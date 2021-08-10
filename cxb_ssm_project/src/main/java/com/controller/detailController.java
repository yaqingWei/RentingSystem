package com.controller;

import com.domain.Tbl_Fwxx;
import com.service.Tbl_FwxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Xiaobo
 * @create 2021-08-04 21:36
 */
@Controller
public class detailController {
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    @RequestMapping("/detail")
    public ModelAndView find(ModelAndView modelAndView,int fwid){
        modelAndView.setViewName("detail");
        Tbl_Fwxx fwxx = tbl_fwxxService.findByFwid(fwid);
        modelAndView.addObject("fwxx",fwxx);
        return modelAndView;
    }
}
