package com.controller;

import com.domain.Tbl_User;
import com.service.Tbl_UserService;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.util.KaptchaTextCreator;
import com.util.Md5Util;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author Xiaobo
 * @create 2021-08-04 22:03
 */
@Controller
public class regController {
    @Autowired
    private Tbl_UserService tbl_userService;
    @Autowired
    private HttpSession session;
    @Autowired
    private KaptchaTextCreator kaptcha;
    @RequestMapping("/yanzhengMa")
    @ResponseBody
    public void yanzhengMa(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        String[] split = kaptcha.getText().split("@");
        String image = kaptcha.getImage(split[0]);
        session.setAttribute("code",split[1]);
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        System.out.println(image);
        out.print(image);
        out.close();
    }

    @RequestMapping("/register")
    public String checkUname(Tbl_User user, Model model) {
        boolean b = tbl_userService.registerUser(user);
        Integer uid = user.getUid();
        System.out.println(uid);
        model.addAttribute("uid",uid);
        model.addAttribute("page",1);
        if(b){
            return "redirect:/loginGo";
        }else{
           return "reg";
        }
    }
    @RequestMapping("/existsUname")
    @ResponseBody
    public int  existsUname(String uname){
        System.out.println("我进来了");
        Tbl_User user = tbl_userService.findByUname(uname);
        if(user!=null){
            return 1;
        }else{
            return 0;
        }
    }
}
