package com.domain;

import lombok.*;

import java.beans.ConstructorProperties;

/**
 * @author Xiaobo
 * @create 2021-08-02 13:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tbl_User {
    private Integer uid;
    private String uname;
    private String upass;
}
