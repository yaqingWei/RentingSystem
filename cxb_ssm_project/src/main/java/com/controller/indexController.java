package com.controller;

import com.domain.Tbl_Fwlx;
import com.domain.Tbl_Fwxx;
import com.domain.Tbl_Jd;
import com.domain.Tbl_Qx;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Tbl_FwlxService;
import com.service.Tbl_FwxxService;
import com.service.Tbl_JdService;
import com.service.Tbl_QxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.SchemaOutputResolver;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 14:13
 */
@Controller
public class indexController {

    @Autowired
    private Tbl_QxService tbl_qxService;
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    @Autowired
    private Tbl_JdService tbl_jdService;
    @Autowired
    private Tbl_FwlxService tbl_fwlxService;

    /**
     * 查询页面所需要的所有元素
     */
    @RequestMapping("/selectAll")
    public ModelAndView findAllIndex(ModelAndView modelAndView, @RequestParam(value = "page", defaultValue = "1") int page) {
        modelAndView.setViewName("index");
        PageHelper.startPage(page, 10);
        List<Tbl_Fwxx> fwxxList = tbl_fwxxService.findAll();
        PageInfo pageInfo = new PageInfo(fwxxList);
        int pageCount = pageInfo.getPages();
        int p = pageInfo.getPageNum();
        int shi = tbl_fwxxService.selectMaxShi();
        int ting = tbl_fwxxService.selectMaxTing();
        List<Tbl_Jd> jdList = tbl_jdService.findAll();
        List<Tbl_Fwlx> fwlxList = tbl_fwlxService.findAll();
        List<Tbl_Qx> qxList = tbl_qxService.findAll();
        modelAndView.addObject("fwxxList", fwxxList);
        modelAndView.addObject("shi", shi);
        modelAndView.addObject("ting", ting);
        modelAndView.addObject("jdList", jdList);
        modelAndView.addObject("fwlxList", fwlxList);
        modelAndView.addObject("qxList", qxList);
        modelAndView.addObject("pageCount", pageCount);
        modelAndView.addObject("page", p);
        return modelAndView;
    }
}
