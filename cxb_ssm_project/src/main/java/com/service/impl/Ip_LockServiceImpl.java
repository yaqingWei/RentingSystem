package com.service.impl;

import com.domain.Ip_Lock;
import com.mapper.Ip_LockMapper;
import com.service.Ip_LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Xiaobo
 * @create 2021-08-10 12:43
 */
@Service
public class Ip_LockServiceImpl implements Ip_LockService {
    @Autowired
    private Ip_LockMapper ip_lockMapper;
    @Override
    public int insert(Ip_Lock ip_lock) {
        return ip_lockMapper.insert(ip_lock);
    }

    @Override
    public Ip_Lock find(Ip_Lock ip_lock) {
        return ip_lockMapper.find(ip_lock);
    }

    @Override
    public int updateCount(Ip_Lock ip_lock) {
        return ip_lockMapper.updateCount(ip_lock);
    }

    @Override
    public int updateDate(Ip_Lock ip_lock) {
        return ip_lockMapper.updateDate(ip_lock);
    }

    @Override
    public int updateDatenow(Ip_Lock ip_lock) {
        return ip_lockMapper.updateDatenow(ip_lock);
    }
}
