package com.mapper;

import com.domain.Tbl_Jd;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 18:57
 */
public interface Tbl_JdMapper {
    @Select("select * from Tbl_Jd where jdid=#{jdid}")
    Tbl_Jd findById(int id);

    @Select("select * from Tbl_Jd")
    List<Tbl_Jd> findAll();
}
