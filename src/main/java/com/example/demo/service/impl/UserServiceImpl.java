package com.example.demo.service.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

}
