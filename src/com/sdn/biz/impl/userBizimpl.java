package com.sdn.biz.impl;

import com.sdn.biz.userBiz;
import com.sdn.dao.userMapper;
import com.sdn.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userBizimpl implements userBiz {
    @Autowired
    userMapper dao;
    @Override
    public int add(user user) {
        return 0;
    }

    @Override
    public List<user> getAll() {
        return dao.getAll();
    }

    @Override
    public List<user> getpaing(int a, int b) {
        return dao.getAll();
    }

    @Override
    public int updates(user user) {
        return 0;
    }

    @Override
    public int deletes(int id) {
        return 0;
    }

    @Override
    public user getByid(int id) {
        return null;
    }
}
