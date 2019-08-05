package com.example.demo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author fenglang
 * @since 2019-07-25
 */
@TableName("film_order")
public class FilmOrder extends Model<FilmOrder> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("film_id")
    private Integer filmId;
    @TableField("user_id")
    private Integer userId;
    private Integer num;


    public Integer getId() {
        return id;
    }

    public FilmOrder setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public FilmOrder setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public FilmOrder setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public FilmOrder setNum(Integer num) {
        this.num = num;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "FilmOrder{" +
        "id=" + id +
        ", filmId=" + filmId +
        ", userId=" + userId +
        ", num=" + num +
        "}";
    }
}
