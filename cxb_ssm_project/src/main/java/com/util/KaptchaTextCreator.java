package com.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.text.impl.DefaultTextCreator;
import com.google.code.kaptcha.util.Config;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.code.kaptcha.Constants.*;

/**
 * 验证码文本生成器
 *
 * @author lwchen
 */
@Component
public class KaptchaTextCreator extends DefaultTextCreator {
    private static final String imageJpg = "data:image/jpg;base64,";
    private static final String[] CNUMBERS = "0,1,2,3,4,5,6,7,8,9,10".split(",");
    private static final String[] CNU = "零,壹,贰,叁,肆,伍,陆,柒,捌,玖".split(",");
    @Autowired
    public  DefaultKaptcha defaultKaptcha;


    @Override
    public String getText() {
        Integer result = 0;
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        StringBuilder suChinese = new StringBuilder();
        int randomoperands = (int) Math.round(Math.random() * 2);
        if (randomoperands == 0) {
            result = x * y;
            suChinese.append(CNUMBERS[x]);
            suChinese.append("*");
            suChinese.append(CNUMBERS[y]);
        } else if (randomoperands == 1) {
            if (!(x == 0) && y % x == 0) {
                result = y / x;
                suChinese.append(CNUMBERS[y]);
                suChinese.append("/");
                suChinese.append(CNUMBERS[x]);
            } else {
                result = x + y;
                suChinese.append(CNUMBERS[x]);
                suChinese.append("+");
                suChinese.append(CNUMBERS[y]);
            }
        } else if (randomoperands == 2) {
            if (x >= y) {
                result = x - y;
                suChinese.append(CNUMBERS[x]);
                suChinese.append("-");
                suChinese.append(CNUMBERS[y]);
            } else {
                result = y - x;
                suChinese.append(CNUMBERS[y]);
                suChinese.append("-");
                suChinese.append(CNUMBERS[x]);
            }
        } else {
            result = x + y;
            suChinese.append(CNUMBERS[x]);
            suChinese.append("+");
            suChinese.append(CNUMBERS[y]);
        }
        suChinese.append("=?@" + result);
        return suChinese.toString();
    }

    public String getImage(String text) throws IOException {
        BufferedImage image = defaultKaptcha.createImage(text);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        outputStream.close();
        String encode = Base64.encode(outputStream.toByteArray());
        return imageJpg + encode;
    }

    public static void main(String[] args) throws IOException {
        KaptchaTextCreator k = new KaptchaTextCreator();
        //生成验证码字符串
        k.getText().split("@");
        String text = k.getText().split("@")[0];
        System.out.println(text);

        //根据验证码字符串生成对应的验证码图片
        String encode = k.getImage(text);
        System.out.println(encode);
    }

}