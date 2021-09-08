package com.controller;

import com.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.service.Tbl_FwlxService;
import com.service.Tbl_FwxxService;
import com.service.Tbl_JdService;
import com.service.Tbl_QxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-05 20:35
 */
@Controller
public class Tbl_FwxxController {
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    @Autowired
    private ServletContext application;
    @Autowired
    private Tbl_FwlxService tbl_fwlxService;
    @Autowired
    private Tbl_QxService tbl_qxService;
    @Autowired
    private Tbl_JdService tbl_jdService;

    @RequestMapping(value = "/logicDel", produces = "text/json;charset=utf-8")
    @ResponseBody
    public String logicDel(int fwid) throws IOException {
        int i = tbl_fwxxService.loginDel(fwid);
        if (i > 0) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    @RequestMapping("/postFwxx")
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public String postFwxx(@RequestParam("fileupload") MultipartFile fileupload, Tbl_Fwxx fwxx, Tbl_Jd tbl_jd, Tbl_Qx tbl_qx, Tbl_User tbl_user, Tbl_Fwlx tbl_fwlx, Model model) throws IOException {
        System.out.println(fileupload);
        String filename = fileupload.getOriginalFilename();
        fwxx.setImg(filename);
        fwxx.setTbl_fwlx(tbl_fwlx);
        fwxx.setTbl_qx(tbl_qx);
        fwxx.setTbl_jd(tbl_jd);
        fwxx.setTbl_user(tbl_user);
        fwxx.setDate(new Date());
        Tbl_Fwlx fwlx = tbl_fwlxService.findById(tbl_fwlx.getLxid());
        Tbl_Qx qx = tbl_qxService.findById(tbl_qx.getQxid());
        Tbl_Jd jd = tbl_jdService.findById(tbl_jd.getJdid());
        fileupload.transferTo(new File(application.getRealPath("images") + "/" + filename));
        int i = tbl_fwxxService.postFwxx(fwxx);
        model.addAttribute("fwxx",fwxx);
        model.addAttribute("qx",qx);
        model.addAttribute("jd",jd);
        model.addAttribute("fwlx",fwlx);
        return "post_confirm";
    }

    @RequestMapping("/post")
    public ModelAndView post(ModelAndView modelAndView) {
        modelAndView.setViewName("post");
        int shi = tbl_fwxxService.selectMaxShi();
        int ting = tbl_fwxxService.selectMaxTing();
        List<Tbl_Jd> jdList = tbl_jdService.findAll();
        List<Tbl_Qx> qxList = tbl_qxService.findAll();
        modelAndView.addObject("jdList", jdList);
        modelAndView.addObject("qxList", qxList);
        modelAndView.addObject("shi", shi);
        modelAndView.addObject("ting", ting);
        return modelAndView;
    }
    @RequestMapping("/updateFwxx")
    public ModelAndView updateFwxx(int fwid,ModelAndView modelAndView){
        List<Tbl_Jd> jdList = tbl_jdService.findAll();
        List<Tbl_Qx> qxList = tbl_qxService.findAll();
        List<Tbl_Fwlx> fwlxList = tbl_fwlxService.findAll();
        int shi = tbl_fwxxService.selectMaxShi();
        int ting = tbl_fwxxService.selectMaxTing();
        Tbl_Fwxx byFwid = tbl_fwxxService.findByFwid(fwid);
        modelAndView.addObject("fwxx",byFwid);
        modelAndView.addObject("jdList", jdList);
        modelAndView.addObject("qxList", qxList);
        modelAndView.addObject("fwlxList",fwlxList);
        modelAndView.addObject("shi", shi);
        modelAndView.addObject("ting", ting);
        modelAndView.setViewName("updateFwxx");
        return modelAndView;
    }
    @RequestMapping("/putFwxx")
    public ModelAndView putFwxx(Tbl_Fwxx fwxx, Tbl_Jd tbl_jd, Tbl_Qx tbl_qx, Tbl_User tbl_user, Tbl_Fwlx tbl_fwlx, ModelAndView modelAndView){
        fwxx.setTbl_jd(tbl_jd);
        fwxx.setTbl_qx(tbl_qx);
        fwxx.setTbl_fwlx(tbl_fwlx);
        System.out.println(fwxx);
        modelAndView.addObject("page",1);
        modelAndView.addObject("uid",tbl_user.getUid());
        int i = tbl_fwxxService.putFwxx(fwxx);
        modelAndView.setViewName("redirect:loginGo");
        return modelAndView;
    }
}
