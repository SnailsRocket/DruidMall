package com.xubo.mall.controller;

import com.xubo.mall.entity.Cos;
import com.xubo.mall.service.CosService;
import com.xubo.mall.vo.CosViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Druid_Xu
 * @Description TODO
 * @Date 2020/9/2 上午 08:51
 */
@RestController
@RequestMapping("/cos")
@CrossOrigin(origins = {"http://localhost:4200",""})
public class CosController {

    @Autowired
    public CosService cosService;

    @GetMapping("/findAll")
    public List<CosViewObject> findAllCos(HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        System.out.println("HeaderNames");
        while(headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s);
        }
        List<Cos> cosList = cosService.findAll();
        List<CosViewObject> voList = new ArrayList<CosViewObject>();
        for (int i = 0; i < cosList.size(); i++) {
            Cos cos = cosList.get(i);
            if(cos.getIsValid() == 1) {
                voList.add(new CosViewObject(cos.getCosprocessid(),cos.getCosprocess(),
                        cos.getIsValid(),cos.getUpdEmp(),cos.getUpdtime()));
            }
        }
        return voList;
    }

    @GetMapping("/add")
    public int addCosProcess(@RequestParam("cosProcess") String cosProcess) {
        List<Cos> cosList = cosService.findAll();
        Date date = new Date();
        Cos cos = new Cos(cosList.size()+1,cosProcess,1,"druid",new Date());
        int i = cosService.insertCos(cos);

        return i;
    }

    @GetMapping("/edit")
    public int editCosProcess(@RequestParam("cosprocessid") int cosprocessid,@RequestParam("cosprocess") String cosprocess) {
        Cos cos = new Cos(cosprocessid, cosprocess, 1, "Druid", new Date());
        int update = cosService.update(cos);
        return update;
    }

    @GetMapping("/del")
    public void deleteCosProcess(@RequestParam("cosprocessid") String cosprocessid) {
//        删除，传过来的可能是多个数字，所以使用;拼接成字符串
        String[] ids = cosprocessid.split(";");
        if(ids.length == 1) {
            Cos cos = cosService.selectByPre(Integer.parseInt(cosprocessid));
            cos.setIsValid(0);
            int update = cosService.update(cos);
        } else {
            for (String id : ids) {
                Cos cos = cosService.selectByPre(Integer.parseInt(id));
                cos.setIsValid(0);
                int update = cosService.update(cos);
            }
        }
    }

}
