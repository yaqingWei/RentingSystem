package com.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiaobo
 * @create 2021-08-03 19:23
 * 拦截器中令牌校验
 */
public class Tbl_UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //释放静态以及不再校验范围内的资源
        String path = request.getServletPath();
        if (path.equals("/detail") || path.equals("/inserVue") || path.equals("/yanzhengMa") || path.equals("/selectAll") || path.endsWith(".jsp") || path.endsWith(".html") || path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jpg") || path.contains("login")) {
            return true;
        }
        Cookie[] cookies = request.getCookies();
        String token = "";
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals("token")) {
                    token = c.getValue();
                    break;
                }
            }
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("msg", "请先登录!");
        if (!"".equals(token)) {
            try {
                JWTUtils.checkJWT(token);
                return true;
            } catch (AlgorithmMismatchException e) {
                e.printStackTrace();
                map.put("msg", "算法不匹配");
            } catch (TokenExpiredException e) {
                e.printStackTrace();
                map.put("msg", "身份验证已失效");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("msg", "身份验证失败!");
            }
        }
        String msg = map.get("msg");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<script>");
        out.print("alert('" + msg + "');");
        out.print("location.href='selectAll';");
        out.print("</script>");
        return false;


    }
}
