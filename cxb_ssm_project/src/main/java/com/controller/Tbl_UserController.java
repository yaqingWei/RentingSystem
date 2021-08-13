package com.controller;

import com.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.webservices.internal.api.message.ContentType;
import com.service.*;
import com.util.IpUtil;
import com.util.Md5Util;
import javafx.scene.input.DataFormat;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.omg.PortableInterceptor.ObjectReferenceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author Xiaobo
 * @create 2021-08-03 19:27
 */
@SessionAttributes({"user", "fwxxList", "shi", "ting", "jdList", "qxList", "fwlxList"})
@Controller
public class Tbl_UserController {
    @Autowired
    private Tbl_UserService tbl_userService;
    @Autowired
    private Tbl_QxService tbl_qxService;
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    @Autowired
    private Tbl_JdService tbl_jdService;
    @Autowired
    private Tbl_FwlxService tbl_fwlxService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private Ip_LockService ip_lockService;

    /**
     * 将异常抛给Springmvc进行处理
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(Tbl_User tbl_user, Model model, Ip_Lock ip_lock, IpLockResult ipLockResult,String imgcode) throws ParseException {
        if(!request.getSession().getAttribute("code").equals(imgcode)){
            ipLockResult.setCheck(0);
            return ipLockResult;
        }
        String ip = IpUtil.getIP(request);
        //初始化
        ip_lock.setIp(ip);
        ip_lock.setCount(0);
        Tbl_User user = tbl_userService.findLogin(tbl_user);
        Ip_Lock ipLock = ip_lockService.find(ip_lock);
        System.out.println(ipLock);
        //账号已锁定（可以优化,针对业务的多样可以新建一个result类对结果进行判断返回）
        if (ipLock != null && ipLock.getDate().compareTo(new Date())==1){
            ipLockResult.setIp_lock(ipLock);
            return ipLockResult;
        }
        if (user != null) {
            //情况判断
            if (ipLock != null) {
                ipLock.setCount(0);
                ip_lockService.updateCount(ipLock);
                ip_lockService.updateDatenow(ipLock);
            }
            List<Tbl_Fwxx> fwxxList = tbl_fwxxService.findByUid(user.getUid());
            int shi = tbl_fwxxService.selectMaxShi();
            int ting = tbl_fwxxService.selectMaxTing();
            List<Tbl_Jd> jdList = tbl_jdService.findAll();
            List<Tbl_Fwlx> fwlxList = tbl_fwlxService.findAll();
            List<Tbl_Qx> qxList = tbl_qxService.findAll();
            model.addAttribute("fwxxList", fwxxList);
            model.addAttribute("shi", shi);
            model.addAttribute("ting", ting);
            model.addAttribute("jdList", jdList);
            model.addAttribute("fwlxList", fwlxList);
            model.addAttribute("qxList", qxList);
            model.addAttribute("user", user);
            ipLockResult.setUser(user);
        } else {
            //情况判断
            if (ipLock != null) {
                Integer count = ipLock.getCount();
                if (count + 1 < 5) {
                    ipLock.setCount(ipLock.getCount() + 1);
                    ip_lockService.updateCount(ipLock);
                } else {
                    ipLock.setCount(ipLock.getCount() + 1);
                    ip_lockService.updateCount(ipLock);
                    ip_lockService.updateDate(ipLock);
                    //封装
                    ipLockResult.setIp_lock(ipLock);
                    System.out.println(ipLockResult);
                    return ipLockResult;

                }
            } else {
                ip_lockService.insert(ip_lock);
            }
        }
        return ipLockResult;
    }

    @RequestMapping("/loginGo")
    public ModelAndView loginGo(ModelAndView modelAndView, int uid, int page, Model model) {
        int shi = tbl_fwxxService.selectMaxShi();
        Tbl_User user = tbl_userService.findById(uid);
        int ting = tbl_fwxxService.selectMaxTing();
        List<Tbl_Jd> jdList = tbl_jdService.findAll();
        List<Tbl_Fwlx> fwlxList = tbl_fwlxService.findAll();
        List<Tbl_Qx> qxList = tbl_qxService.findAll();
        PageHelper.startPage(page, 5);
        List<Tbl_Fwxx> fwxxList = tbl_fwxxService.findByUid(uid);
        modelAndView.addObject("shi", shi);
        modelAndView.addObject("ting", ting);
        modelAndView.addObject("jdList", jdList);
        modelAndView.addObject("fwlxList", fwlxList);
        modelAndView.addObject("qxList", qxList);
        modelAndView.addObject("user", user);
        model.addAttribute("fwxxList", fwxxList);
        PageInfo pageInfo = new PageInfo(fwxxList);
        int pageCount = pageInfo.getPages();
        int p = pageInfo.getPageNum();
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("page", p);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("user");
        model.addAttribute("page", 1);
        return "redirect:selectAll";
    }
}
