package com.xubo.mall.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Author xubo
 * @Date 2021/7/8 11:11
 * @Description 多线程读取文件 或者文件之间进行对比
 * 注意：
 *  使用这个方法有前提条件：源文件已经被被分割成多个小文件，并且行数和列数都一样
 *                        机器内存足够大，最后会将并发读取的结果合并到一个大的结果集，全部数据放入内存中
 *  使用场景：多份文件需要紧急数据分析或者交叉校对，为了加快文件的读取速度，可以采用这种方式批量读取格式一致的Excel文件
 *  rm-uf6gg73d3u0017u8nzo.mysql.rds.aliyuncs.com
 */
@Slf4j
public class EasyExcelConcurrentRead {
    //
    static final int N_CPU = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws Exception {
        // 假设D盘的temp目录下有一堆同格式的Excel文件
        String dir = "D:\\temp";
        List<Map<Integer, String>> mergeResult = Lists.newLinkedList();
        // 使用线程池创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(N_CPU, N_CPU * 2, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new ThreadFactory() {

            private final AtomicInteger counter = new AtomicInteger();

            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                thread.setName("ExcelReadWorker-" + counter.getAndIncrement());
                return thread;
            }
        });
        Path dirPath = Paths.get(dir);
        if (Files.isDirectory(dirPath)) {
            List<Future<List<Map<Integer, String>>>> futures = Files.list(dirPath)
                    .map(path -> path.toAbsolutePath().toString())
                    .filter(absolutePath -> absolutePath.endsWith(".xls") || absolutePath.endsWith(".xlsx"))
                    .map(absolutePath -> executor.submit(new ReadTask(absolutePath)))
                    .collect(Collectors.toList());
            for (Future<List<Map<Integer, String>>> future : futures) {
                mergeResult.addAll(future.get());
            }
        }
        log.info("读取[{}]目录下的文件成功,一共加载:{}行数据", dir, mergeResult.size());
        // 其他业务逻辑.....
        // TODO
        //  1、创建 多个相同的文件对这段代码进行测试
        //  2、将金额与百分比转换成数字类型
        //  3、使用poi实现类似功能


    }

    @RequiredArgsConstructor
    private static class ReadTask implements Callable<List<Map<Integer, String>>> {

        private final String location;

        @Override
        public List<Map<Integer, String>> call() throws Exception {
            List<Map<Integer, String>> data = Lists.newLinkedList();
            EasyExcel.read(location).sheet()
                    .registerReadListener(new AnalysisEventListener<Map<Integer, String>>() {

                        @Override
                        public void invoke(Map<Integer, String> row, AnalysisContext analysisContext) {
                            data.add(row);
                        }

                        @Override
                        public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                            log.info("读取路径[{}]文件成功,一共[{}]行", location, data.size());
                        }
                    }).doRead();
            return data;
        }
    }


}
