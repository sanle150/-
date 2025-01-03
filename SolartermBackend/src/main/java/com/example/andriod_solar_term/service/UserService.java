package com.example.andriod_solar_term.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.andriod_solar_term.beans.RequestLogin;
import com.example.andriod_solar_term.beans.RequestRegister;
import com.example.andriod_solar_term.beans.User;
import org.springframework.data.relational.core.sql.In;

import javax.servlet.http.HttpServletRequest;


public interface UserService extends IService<User> {
    User searchByUsername(String username);

    void updateByUsername(User user);

    User userLogin(RequestLogin requestLogin);

    Integer userRegister(RequestRegister requestRegister);

    Integer userLoginOut(HttpServletRequest request);
}
