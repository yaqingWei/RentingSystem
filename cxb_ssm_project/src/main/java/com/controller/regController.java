package com.controller;

import com.domain.Tbl_User;
import com.service.Tbl_UserService;
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
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Xiaobo
 * @create 2021-08-04 22:03
 */
@Controller
public class regController {
    @Autowired
    private Tbl_UserService tbl_userService;

    @RequestMapping("/yanzhengMa")
    @ResponseBody
    public void yanzhengMa(HttpServletResponse resp, HttpServletRequest req) throws IOException {
        BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 50, 50);
        Random ran = new Random();
        char[] chars = "1234567890qwertyuiopasdfghjklzxcvbnm".toCharArray();
        //保存验证码
        String code = "";
        g.setColor(Color.red);
        g.setFont(new Font("宋体", Font.BOLD, 10));
        for (int i = 0; i < 4; i++) {
            String val = chars[ran.nextInt(chars.length)] + "";
            g.drawString(val, i * 10, ran.nextInt(50));
            code += val;
        }
        g.setColor(Color.gray);
        //画线
        for (int i = 0; i < 5; i++) {
            g.drawLine(ran.nextInt(50), ran.nextInt(50), ran.nextInt(50), ran.nextInt(50));
        }
        System.out.println(code);
        req.getSession(true).setAttribute("code", code);
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(img, "jpg", out);
        out.flush();
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
