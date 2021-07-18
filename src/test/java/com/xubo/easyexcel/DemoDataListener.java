package com.xubo.easyexcel;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;

/**
 * @Author Druid_Xu
 * @Date 2020/11/30 上午 09:25
 * @Description
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);

    /**
     * 每隔5条存储数据库，实际可用3000条，然后清理list，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<DemoData> list = new ArrayList<DemoData>();

    /**
     *  这个没一条数据解析都会来调用，数据临时以对象的形式存入list集合
     *  我这里数据量小，所以就全部放入list里面
     * @param demoData
     * @param analysisContext
     */
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据：{}", JSON.toJSONString(demoData));
        list.add(demoData);
        // 如果达到 BATCH_COUNT ，就去存一次数据库，防止几万条数据在内存中，导致 oom(out of memory)
        /*if(list.size()>BATCH_COUNT) {
            saveDate(); // 调用Dao 层
            list.clear();
        }*/
    }

    /**
     * 所有数据解析完成了，都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        LOGGER.info("数据解析完成！");
    }
}
