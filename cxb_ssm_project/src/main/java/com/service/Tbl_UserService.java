package com.service;

import com.domain.Tbl_User;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:42
 */
public interface Tbl_UserService {
    Tbl_User findById(int id);

    Tbl_User findLogin(Tbl_User user);

    boolean registerUser(Tbl_User user);

    Tbl_User findByUname(String uname);
}
