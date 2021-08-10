package com.mapper;

import com.domain.Tbl_Qx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 16:55
 */
public interface Tbl_QxMapper {
    @Select("select * from tbl_qx")
    List<Tbl_Qx> findAll();
    @Select("select * from tbl_qx where qxid=#{qxid}")
    Tbl_Qx findById(int id);
}
