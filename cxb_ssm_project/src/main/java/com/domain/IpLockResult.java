package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Xiaobo
 * @create 2021-08-11 11:40
 * 对ip锁定result多样化进行的一个封装
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IpLockResult {
    private Ip_Lock ip_lock;
    private Tbl_User user;
}
