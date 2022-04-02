package com.controller;

import com.domain.Tbl_Qx;
import com.service.Tbl_QxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-10-13 11:26
 */
@RestController
public class VueWorkController {
    @Autowired
    private Tbl_QxService tbl_qxService;
    @RequestMapping("/selectVue")
    public List<Tbl_Qx> selectVue(HttpServletRequest request){
        System.out.println("请求过来了"+request.getRequestURL());
        List<Tbl_Qx> all = tbl_qxService.findAll();
        return all;
    }
    @RequestMapping("/inserVue")
    public int inserVue(Tbl_Qx tbl_qx){
        return tbl_qxService.addQx(tbl_qx);
    }
}
