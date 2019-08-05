package com.example.demo.dao;
import com.example.demo.entity.User;

import java.util.List;
public interface IUserDao {
    List<User> selectAll();
}
