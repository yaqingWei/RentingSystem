package com.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Xiaobo
 * @create 2021-08-06 21:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ip_Lock {
    private Integer id;
    private String uname;
    private String ip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date date;
    private Integer count;
}
