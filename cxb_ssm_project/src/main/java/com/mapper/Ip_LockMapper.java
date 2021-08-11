package com.mapper;

import com.domain.Ip_Lock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.lang.Nullable;

/**
 * @author Xiaobo
 * @create 2021-08-10 11:41
 */
public interface Ip_LockMapper {
    @Select("insert into Ip_Lock values(null,#{ip},#{uname},#{count},default)")
    int insert(Ip_Lock ip_lock);

    @Select("select * from Ip_Lock where ip=#{ip} and uname=#{uname}")
    Ip_Lock find(Ip_Lock ip_lock);

    @Update("update Ip_Lock set count=#{count} where ip=#{ip} and uname=#{uname}")
    int updateCount(Ip_Lock ip_lock);

    @Update("update Ip_Lock set date=ADDDATE(#{date},interval 5 MINUTE) where ip=#{ip} and uname=#{uname}")
    int  updateDate(Ip_Lock ip_lock);

    @Update("update Ip_Lock set date=now() where ip=#{ip} and uname=#{uname}")
    int  updateDatenow(Ip_Lock ip_lock);
}
