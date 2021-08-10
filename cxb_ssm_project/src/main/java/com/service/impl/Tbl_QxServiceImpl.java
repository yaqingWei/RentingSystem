package com.service.impl;

import com.domain.Tbl_Qx;
import com.mapper.Tbl_QxMapper;
import com.service.Tbl_QxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 16:53
 */
@Service
public class Tbl_QxServiceImpl implements Tbl_QxService {
    @Autowired
    private Tbl_QxMapper tbl_qxMapper;

    @Override
    public List<Tbl_Qx> findAll() {
        return tbl_qxMapper.findAll();
    }

    @Override
    public Tbl_Qx findById(int id) {
        return tbl_qxMapper.findById(id);
    }
}
