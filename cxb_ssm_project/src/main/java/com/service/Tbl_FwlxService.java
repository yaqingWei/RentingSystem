package com.service;

import com.domain.Tbl_Fwlx;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:36
 */
public interface Tbl_FwlxService {
    Tbl_Fwlx findById(int id);

    List<Tbl_Fwlx> findAll();
}
