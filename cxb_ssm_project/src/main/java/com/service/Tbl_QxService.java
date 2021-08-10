package com.service;

import com.domain.Tbl_Qx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 16:53
 */
public interface Tbl_QxService {
    List<Tbl_Qx> findAll();

    Tbl_Qx findById(int id);
}
