package com.mapper;

import com.domain.Tbl_User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author Xiaobo
 * @create 2021-08-02 18:50
 */
public interface Tbl_UserMapper {
    @Select("select * from tbl_user where uid=#{uid}")
    Tbl_User findById(int id);

    @Select("select * from tbl_user where uname=#{uname} and upass=MD5(#{upass})")
    Tbl_User findLogin(Tbl_User user);

    @Insert("insert into Tbl_User(uname,upass) values(#{uname},MD5(#{upass}))")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
    boolean registerUser(Tbl_User user);

    @Select("select * from tbl_user where uname=#{uname}")
    Tbl_User findByUname(String uname);
}
