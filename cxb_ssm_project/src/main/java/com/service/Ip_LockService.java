package com.service;

import com.domain.Ip_Lock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author Xiaobo
 * @create 2021-08-10 12:43
 */
public interface Ip_LockService {
    int insert(Ip_Lock ip_lock);

    Ip_Lock find(Ip_Lock ip_lock);

    int updateCount(Ip_Lock ip_lock);

    int  updateDate(Ip_Lock ip_lock);
}
