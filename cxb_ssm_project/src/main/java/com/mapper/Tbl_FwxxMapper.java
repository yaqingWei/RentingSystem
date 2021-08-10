package com.mapper;

import com.domain.*;
import com.provider.Tbl_FwxxSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Xiaobo
 * @create 2021-08-02 14:21
 */
@Repository
public interface Tbl_FwxxMapper {
    @Select("select * from tbl_fwxx where logic=1 order by date desc")
    @Results(value = {
            @Result(id = true, column = "fwid", property = "fwid"),
            @Result(column = "shi", property = "shi"),
            @Result(column = "ting", property = "ting"),
            @Result(column = "fwxx", property = "fwxx"),
            @Result(column = "zj", property = "zj"),
            @Result(column = "title", property = "title"),
            @Result(column = "date", property = "date"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "lxr", property = "lxr"),
            @Result(column = "img", property = "img"),
            @Result(column = "logic", property = "logic"),
            @Result(
                    property = "tbl_user",
                    javaType = Tbl_User.class,
                    column = "uid",
                    one = @One(select = "com.mapper.Tbl_UserMapper.findById")
            ),
            @Result(
                    property = "tbl_jd",
                    column = "jdid",
                    javaType = Tbl_Jd.class,
                    one = @One(select = "com.mapper.Tbl_JdMapper.findById")
            ),
            @Result(
                    property = "tbl_qx",
                    column = "qxid",
                    javaType = Tbl_Qx.class,
                    one = @One(select = "com.mapper.Tbl_QxMapper.findById")
            ),
            @Result(
                    property = "tbl_fwlx",
                    column = "lxid",
                    javaType = Tbl_Fwlx.class,
                    one = @One(select = "com.mapper.Tbl_FwlxMapper.findById")
            )
    })
    List<Tbl_Fwxx> selectAll();

    @Select("select max(shi) from tbl_fwxx where logic=1")
    int selectMaxShi();

    @Select("select max(ting) from tbl_fwxx where logic=1")
    int selectMaxTing();


    @Results(value = {
            @Result(id = true, column = "fwid", property = "fwid"),
            @Result(column = "shi", property = "shi"),
            @Result(column = "ting", property = "ting"),
            @Result(column = "fwxx", property = "fwxx"),
            @Result(column = "zj", property = "zj"),
            @Result(column = "title", property = "title"),
            @Result(column = "date", property = "date"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "lxr", property = "lxr"),
            @Result(column = "img", property = "img"),
            @Result(column = "logic", property = "logic"),
            @Result(
                    property = "tbl_user",
                    javaType = Tbl_User.class,
                    column = "uid",
                    one = @One(select = "com.mapper.Tbl_UserMapper.findById")
            ),
            @Result(
                    property = "tbl_jd",
                    column = "jdid",
                    javaType = Tbl_Jd.class,
                    one = @One(select = "com.mapper.Tbl_JdMapper.findById")
            ),
            @Result(
                    property = "tbl_qx",
                    column = "qxid",
                    javaType = Tbl_Qx.class,
                    one = @One(select = "com.mapper.Tbl_QxMapper.findById")
            ),
            @Result(
                    property = "tbl_fwlx",
                    column = "lxid",
                    javaType = Tbl_Fwlx.class,
                    one = @One(select = "com.mapper.Tbl_FwlxMapper.findById")
            )
    })
    @SelectProvider(type = Tbl_FwxxSqlProvider.class, method = "selectByCondition")
    List<Tbl_Fwxx> findByCondition(@Param("title") String title, @Param("qxid") int qxid, @Param("jdid") int jdid, @Param("zj1") Double zj1, @Param("zj2") Double zj2, @Param("shi") int shi, @Param("ting") int ting, @Param("fwlx") int[] fwlx, @Param("date") int date, @Param("uid") int uid);

    @Select("select * from tbl_fwxx where uid=#{uid} and logic=1 order by date desc")
    @Results(value = {
            @Result(id = true, column = "fwid", property = "fwid"),
            @Result(column = "shi", property = "shi"),
            @Result(column = "ting", property = "ting"),
            @Result(column = "fwxx", property = "fwxx"),
            @Result(column = "zj", property = "zj"),
            @Result(column = "title", property = "title"),
            @Result(column = "date", property = "date"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "lxr", property = "lxr"),
            @Result(column = "img", property = "img"),
            @Result(column = "logic", property = "logic"),
            @Result(
                    property = "tbl_user",
                    javaType = Tbl_User.class,
                    column = "uid",
                    one = @One(select = "com.mapper.Tbl_UserMapper.findById")
            ),
            @Result(
                    property = "tbl_jd",
                    column = "jdid",
                    javaType = Tbl_Jd.class,
                    one = @One(select = "com.mapper.Tbl_JdMapper.findById")
            ),
            @Result(
                    property = "tbl_qx",
                    column = "qxid",
                    javaType = Tbl_Qx.class,
                    one = @One(select = "com.mapper.Tbl_QxMapper.findById")
            ),
            @Result(
                    property = "tbl_fwlx",
                    column = "lxid",
                    javaType = Tbl_Fwlx.class,
                    one = @One(select = "com.mapper.Tbl_FwlxMapper.findById")
            )
    })
    List<Tbl_Fwxx> findByUid(int uid);

    @Results(value = {
            @Result(id = true, column = "fwid", property = "fwid"),
            @Result(column = "shi", property = "shi"),
            @Result(column = "ting", property = "ting"),
            @Result(column = "fwxx", property = "fwxx"),
            @Result(column = "zj", property = "zj"),
            @Result(column = "title", property = "title"),
            @Result(column = "date", property = "date"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "lxr", property = "lxr"),
            @Result(column = "img", property = "img"),
            @Result(column = "logic", property = "logic"),
            @Result(
                    property = "tbl_user",
                    javaType = Tbl_User.class,
                    column = "uid",
                    one = @One(select = "com.mapper.Tbl_UserMapper.findById")
            ),
            @Result(
                    property = "tbl_jd",
                    column = "jdid",
                    javaType = Tbl_Jd.class,
                    one = @One(select = "com.mapper.Tbl_JdMapper.findById")
            ),
            @Result(
                    property = "tbl_qx",
                    column = "qxid",
                    javaType = Tbl_Qx.class,
                    one = @One(select = "com.mapper.Tbl_QxMapper.findById")
            ),
            @Result(
                    property = "tbl_fwlx",
                    column = "lxid",
                    javaType = Tbl_Fwlx.class,
                    one = @One(select = "com.mapper.Tbl_FwlxMapper.findById")
            )
    })
    @Select("select  * from Tbl_Fwxx where fwid=#{fwid} and logic=1 order by date desc")
    Tbl_Fwxx findByFwid(int fwid);

    @Update("update Tbl_Fwxx set logic=0 where fwid=#{fwid} ")
    int loginDel(int fwid);

    @Insert("insert into Tbl_Fwxx values(null,#{tbl_user.uid},#{tbl_jd.jdid},#{tbl_qx.qxid},#{tbl_fwlx.lxid},#{shi},#{ting},#{fwxx},#{zj},#{title},default,#{telephone},#{lxr},#{img},1)")
    int postFwxx(Tbl_Fwxx fwxx);
    @Select("select * from Tbl_Fwxx where fwid=#{fwid}")
    Tbl_Fwxx findByfwid(int fwid);
    @Update("update Tbl_Fwxx set jdid=#{tbl_jd.jdid},qxid=#{tbl_qx.qxid},lxid=#{tbl_fwlx.lxid},shi=#{shi},ting=#{ting},fwxx=#{fwxx},zj=#{zj},title=#{title},date=CURRENT_TIMESTAMP,telephone=#{telephone},lxr=#{lxr} where fwid=#{fwid}")
    int putFwxx(Tbl_Fwxx tbl_fwxx);
}
