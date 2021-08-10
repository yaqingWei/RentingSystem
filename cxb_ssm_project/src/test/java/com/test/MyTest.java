package com.test;

import com.domain.Tbl_Fwxx;
import com.domain.Tbl_Qx;
import com.mapper.Tbl_FwxxMapper;
import com.service.Tbl_FwxxService;
import com.service.Tbl_QxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 18:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@MapperScan(basePackages = "com.mapper")
public class MyTest {
    @Autowired
    private Tbl_QxService tbl_qxService;
    @Autowired
    private Tbl_FwxxService tbl_fwxxService;
    @Test
    public void test1(){
        List<Tbl_Qx> list = tbl_qxService.findAll();
        System.out.println(list);
    }
    @Test
    public void test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void test3(){
        List<Tbl_Fwxx> all = tbl_fwxxService.findAll();
        System.out.println(all);
    }
    @Test
    public void testDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2020-1-1 20:3:23");
        System.out.println(date);
    }
    @Test
    public void test4(){
        List<Tbl_Fwxx> list = tbl_fwxxService.findByCondition("出租", 0, 0, null, null, 0, 0, null, 0,0);
        System.out.println(list);
    }
    @Test
    public void test5(){
        List<Tbl_Fwxx> byUid = tbl_fwxxService.findByUid(56);
        System.out.println(byUid);
    }
}
