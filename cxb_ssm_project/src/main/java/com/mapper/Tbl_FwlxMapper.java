package com.mapper;

import com.domain.Tbl_Fwlx;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:02
 */
public interface Tbl_FwlxMapper {

    @Select("select * from tbl_fwlx where lxid=#{lxid}")
    Tbl_Fwlx findById(int id);

    @Select("select * from tbl_fwlx")
    List<Tbl_Fwlx> findAll();

}
