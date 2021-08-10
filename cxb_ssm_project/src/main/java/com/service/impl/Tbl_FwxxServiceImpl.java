package com.service.impl;

import com.domain.Tbl_Fwxx;
import com.mapper.Tbl_FwxxMapper;
import com.service.Tbl_FwxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 14:19
 */
@Service
public class Tbl_FwxxServiceImpl implements Tbl_FwxxService {
    @Autowired
    private Tbl_FwxxMapper tbl_fwxxMapper;
    @Override
    public List<Tbl_Fwxx> findAll() {
        return tbl_fwxxMapper.selectAll();
    }

    @Override
    public int selectMaxShi() {
        return tbl_fwxxMapper.selectMaxShi();
    }

    @Override
    public int selectMaxTing() {
        return tbl_fwxxMapper.selectMaxTing();
    }

    @Override
    public List<Tbl_Fwxx> findByCondition(String title, int qxid, int jdid, Double zj1, Double zj2, int shi, int ting, int[] fwlx, int date,int uid) {
        return tbl_fwxxMapper.findByCondition(title,qxid,jdid,zj1,zj2,shi,ting,fwlx,date,uid);
    }

    @Override
    public List<Tbl_Fwxx> findByUid(int uid) {
        return tbl_fwxxMapper.findByUid(uid);
    }

    @Override
    public Tbl_Fwxx findByFwid(int fwid) {
        return tbl_fwxxMapper.findByFwid(fwid);
    }

    @Override
    public int loginDel(int fwid) {
        return tbl_fwxxMapper.loginDel(fwid);
    }

    @Override
    public int postFwxx(Tbl_Fwxx fwxx) {
        return tbl_fwxxMapper.postFwxx(fwxx);
    }

    @Override
    public Tbl_Fwxx findByfwid(int fwid) {
        return tbl_fwxxMapper.findByfwid(fwid);
    }

    @Override
    public int putFwxx(Tbl_Fwxx tbl_fwxx) {
        return tbl_fwxxMapper.putFwxx(tbl_fwxx);
    }


}
