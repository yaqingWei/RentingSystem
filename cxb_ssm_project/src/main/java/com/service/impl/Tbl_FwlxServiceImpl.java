package com.service.impl;

import com.domain.Tbl_Fwlx;
import com.mapper.Tbl_FwlxMapper;
import com.service.Tbl_FwlxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:36
 */
@Service
public class Tbl_FwlxServiceImpl implements Tbl_FwlxService {
    @Autowired
    private Tbl_FwlxMapper tbl_fwlxMapper;

    @Override
    public Tbl_Fwlx findById(int id) {
        return tbl_fwlxMapper.findById(id);
    }

    @Override
    public List<Tbl_Fwlx> findAll() {
        return tbl_fwlxMapper.findAll();
    }
}
