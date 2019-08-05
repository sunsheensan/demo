package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
@Api(description = "用户相关接口")
@RestController
@RequestMapping(value = "/user",produces = "application/json; charset=utf-8")
public class UserController {

    @Autowired
    IUserService userService;

    @ApiOperation(value = "登录",notes = "登录")
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestBody User user, HttpSession session){
        //noinspection AlibabaUndefineMagicConstant
        if("zhangsan".equalsIgnoreCase(user.getUserName()) && "123456".equalsIgnoreCase(user.getPassword())){
            session.setAttribute("userInfo",user);
        }
        return "登录成功";
    }

    @ApiOperation(value = "查询所有用户，只返回了最后一个",notes = "这是查询用户的说明")
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        List<User> list = userService.selectAll();
        User user = list.get(list.size()-1);
        return "Hello SpringBoot----" + user.getUserName() + user.getAge() + user.getPassword();
    }

    @ApiOperation(value = "插入用户")
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public int insertUser(@RequestBody UserController user){
        return 1;
    }

}
