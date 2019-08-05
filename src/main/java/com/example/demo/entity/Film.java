package com.example.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lqh
 * @since 2019-07-25
 */
@ApiModel
public class Film extends Model<Film> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer status;
    private Integer num;


    public Integer getId() {
        return id;
    }

    public Film setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Film setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Film setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public Film setNum(Integer num) {
        this.num = num;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Film{" +
        "id=" + id +
        ", name=" + name +
        ", status=" + status +
        ", num=" + num +
        "}";
    }
}
