package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Xiaobo
 * @create 2021-08-02 13:25
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Tbl_Fwxx {
    private Integer fwid;
    private Tbl_User tbl_user;
    private  Tbl_Jd tbl_jd;
    private Tbl_Qx tbl_qx;
    private Tbl_Fwlx tbl_fwlx;
    private Integer shi;
    private Integer ting;
    private String fwxx;
    private Double zj;
    private String title;
    private Date date;
    private String telephone;
    private String lxr;
    private String img;
    private Boolean logic;
}
