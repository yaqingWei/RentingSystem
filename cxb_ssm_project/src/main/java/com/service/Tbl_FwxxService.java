package com.service;

import com.domain.Tbl_Fwxx;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 14:18
 */
public interface Tbl_FwxxService {
    List<Tbl_Fwxx> findAll();

    int selectMaxShi();

    int selectMaxTing();

    List<Tbl_Fwxx> findByCondition(String title, int qxid, int jdid, Double zj1, Double zj2, int shi, int ting, int[] fwlx, int date, int uid);

    List<Tbl_Fwxx> findByUid(int uid);

    Tbl_Fwxx findByFwid(int fwid);

    int loginDel(int fwid);

    int postFwxx(Tbl_Fwxx fwxx);

    Tbl_Fwxx findByfwid(int fwid);

    int putFwxx(Tbl_Fwxx tbl_fwxx);
}
