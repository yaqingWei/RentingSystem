package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Xiaobo
 * @create 2021-08-02 13:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tbl_Jd {
    private Integer jdid;
    private String jd;
    private Tbl_Qx tbl_qx;
}
