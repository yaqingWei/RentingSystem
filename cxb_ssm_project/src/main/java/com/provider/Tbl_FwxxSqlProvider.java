package com.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLOutput;

/**
 * @author Xiaobo
 * @create 2021-08-03 14:40
 */

public class Tbl_FwxxSqlProvider {
    public  String selectByCondition(@Param("title") String title, @Param("qxid") int qxid, @Param("jdid") int jdid, @Param("zj1") Double zj1, @Param("zj2") Double zj2, @Param("shi") int shi, @Param("ting") int ting, @Param("fwlx") int[] fwlx, @Param("date") int date,@Param("uid") int uid){
        SQL sql=new SQL();
        sql.SELECT("*");
        sql.FROM("Tbl_Fwxx");
        if(title!=null && !"".equals(title)){
            //防止索引失效
            sql.WHERE("title in (select title from Tbl_Fwxx where title like '%' #{title,jdbcType=VARCHAR} '%')");
        }
        if(qxid>0){
            sql.WHERE("qxid=#{qxid}");
        }
        if(jdid>0){
            sql.WHERE("jdid=#{jdid}");
        }
        if(zj1!=null && zj1>0 && zj2!=null && zj2>0){
            sql.WHERE("zj between #{zj1} and #{zj2}");
        }
        if(shi>0){
            sql.WHERE("shi=#{shi}");
        }
        if(ting>0){
            sql.WHERE("ting=#{ting}");
        }
        if(fwlx!=null && fwlx.length>0){
            StringBuffer str=new StringBuffer("lxid in(");
            for (int i = 0; i < fwlx.length; i++) {
                str.append(fwlx[i]);
                if(i<fwlx.length-1){
                    str.append(",");
                }
            }
            str.append(")");
            sql.WHERE(str.toString());
        }
        if(date==1){
            sql.WHERE(" STR_TO_DATE(date,'%Y-%m-%d')=STR_TO_DATE(now(),'%Y-%m-%d')");
        }else if(date>1){
            sql.WHERE("STR_TO_DATE(date,'%Y-%m-%d')=STR_TO_DATE(DATE_ADD(now(),interval -#{date} DAY),'%Y-%m-%d')");
        }
        if(uid>0){
            sql.WHERE("uid=#{uid}");
        }
        sql.WHERE("logic=1");
        sql.ORDER_BY("date desc");
        System.out.println(sql);
        return sql.toString();
    }
}
