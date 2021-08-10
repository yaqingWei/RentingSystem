package com.service.impl;

import com.domain.Tbl_User;
import com.mapper.Tbl_UserMapper;
import com.service.Tbl_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xiaobo
 * @create 2021-08-02 19:42
 */
@Service
public class Tbl_UserServiceImpl implements Tbl_UserService {
    @Autowired
    private Tbl_UserMapper tbl_userMapper;

    @Override
    public Tbl_User findById(int id) {
        return tbl_userMapper.findById(id);
    }

    @Override
    public Tbl_User findLogin(Tbl_User user) {
        return tbl_userMapper.findLogin(user);
    }

    @Override
    public boolean registerUser(Tbl_User user) {
        return tbl_userMapper.registerUser(user);
    }

    @Override
    public Tbl_User findByUname(String uname) {
        return tbl_userMapper.findByUname(uname);
    }
}
