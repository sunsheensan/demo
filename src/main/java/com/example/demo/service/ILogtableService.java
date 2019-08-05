package com.example.demo.service;
import com.example.demo.entity.Logtable;
import java.sql.SQLException;

public interface ILogtableService {
    /**
     * 增加日志
     * @param log
     * @return
     * @throws SQLException
     */
    public boolean addLog(Logtable log) throws SQLException;
}
