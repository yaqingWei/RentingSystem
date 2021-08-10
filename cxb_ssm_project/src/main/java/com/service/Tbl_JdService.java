package com.service;

import com.domain.Tbl_Jd;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:40
 */
public interface Tbl_JdService {
    Tbl_Jd findById(int id);

    List<Tbl_Jd> findAll();
}
