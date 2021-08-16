package com.util;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.text.impl.DefaultTextCreator;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author Xiaobo
 * @create 2021-08-13 19:20
 */
public class KaptchaTest extends DefaultTextCreator {
    private String[] num="0,1,2,3,4,5,6,7,8,9".split(",");
    private String prefixx="data:image/jpg;base64,";
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @Override
    public String getText() {
        StringBuffer str=new StringBuffer();
        Integer result=0;
        Random ran=new Random();
        int x=ran.nextInt(10);
        int y=ran.nextInt(10);
        int ranNum=(int)Math.round(Math.random()*2);
        if(ranNum==0){
            result=x*y;
            str.append(num[x]);
            str.append("*");
            str.append(num[y]);

        }else if(ranNum==1){
            if(x!=0 && x%y==0){
                result=x/y;
                str.append(num[x]);
                str.append("/");
                str.append(num[y]);
            }else{
                result=x+y;
                str.append(num[x]);
                str.append("+");
                str.append(num[y]);
            }
        }else{
            if(x>=y){
                result=x-y;
                str.append(num[x]);
                str.append("-");
                str.append(num[y]);
            }else{
                result=y-x;
                str.append(num[y]);
                str.append("-");
                str.append(num[x]);
            }
        }
        str.append("=?");
        str.insert(str.length(),"@"+result);
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        KaptchaTest k = new KaptchaTest();
        String text = k.getText();
        String[] split = text.split("@");
        ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
        DefaultKaptcha bean = application.getBean(DefaultKaptcha.class);
        BufferedImage image = bean.createImage(split[0]);
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",out);
        out.close();
        String encode = Base64.encode(out.toByteArray());
        System.out.println(encode);
    }

}
