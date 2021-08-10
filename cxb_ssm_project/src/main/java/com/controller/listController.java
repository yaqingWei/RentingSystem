package com.controller;

import com.domain.Tbl_Fwxx;
import com.domain.Tbl_User;
import com.service.Tbl_FwxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 23:07
 */
@Controller
public class listController {
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    @Autowired
    private HttpSession session;

    @RequestMapping("/listByCondition")
    public ModelAndView findByCondition(ModelAndView modelAndView,String title,int qxid,int jdid,Double zj1,Double zj2,int[] fwlx,Integer date,int shi,int ting) {
        modelAndView.setViewName("list");
        Tbl_User user = (Tbl_User) session.getAttribute("user");
        List<Tbl_Fwxx> fwxxList=null;
        if(user!=null){
         fwxxList = tbl_fwxxService.findByCondition(title, qxid, jdid, zj1, zj2, shi, ting, fwlx, date,user.getUid());
        }else{
            System.out.println("title="+title);
            System.out.println("qxid="+qxid);
            System.out.println("jdid="+jdid);
            System.out.println("zj1="+zj1);
            System.out.println("zj2="+zj2);
            System.out.println("shi="+shi);
            System.out.println("ting="+ting);
            System.out.println("fwlx="+fwlx);
            System.out.println("date="+date);
            fwxxList = tbl_fwxxService.findByCondition(title, qxid, jdid, zj1, zj2, shi, ting, fwlx, date,0);
        }
        modelAndView.addObject("fwxxList",fwxxList);
        return modelAndView;
    }
}
