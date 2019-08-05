package com.example.demo.service.impl;

import com.example.demo.dao.ILogtableDao;
import com.example.demo.entity.Logtable;
import com.example.demo.service.ILogtableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class LogtableServiceImpl implements ILogtableService {
    @Autowired
    private ILogtableDao logtableMapper;
    @Override
    public boolean addLog(Logtable log) throws SQLException {
        return logtableMapper.insert(log) > 0 ? true : false;
    }
}
