package com.service.impl;

import com.domain.Tbl_Jd;
import com.mapper.Tbl_JdMapper;
import com.service.Tbl_JdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:40
 */
@Service
public class Tbl_JdServiceImpl implements Tbl_JdService {
    @Autowired
    private Tbl_JdMapper tbl_jdMapper;

    @Override
    public Tbl_Jd findById(int id) {
        return tbl_jdMapper.findById(id);
    }

    @Override
    public List<Tbl_Jd> findAll() {
        return tbl_jdMapper.findAll();
    }
}
