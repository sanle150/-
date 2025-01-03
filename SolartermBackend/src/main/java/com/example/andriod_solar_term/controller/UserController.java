package com.example.andriod_solar_term.controller;

import com.example.andriod_solar_term.beans.RequestLogin;
import com.example.andriod_solar_term.beans.RequestRegister;
import com.example.andriod_solar_term.beans.User;
import com.example.andriod_solar_term.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/updateByUsername",method = RequestMethod.POST)
    public void updateByUsername(@RequestBody User user) {
        if(user == null) {
            throw new RuntimeException("user格式错误");
        }
        userService.updateByUsername(user);
    }

    // http://localhost:8080/user/searchByUsername/Povl
    @RequestMapping(value = "/searchByUsername/{username}",method = RequestMethod.GET)
    public User searchByUsername(@PathVariable String username) {
        if(username == null) {
            return null;
        }
        return userService.searchByUsername(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> userLogin(@RequestBody RequestLogin requestLogin, HttpServletRequest request) {
        if (requestLogin == null) {
            log.info("request =>" + requestLogin);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("请求参数错误");
        }
        User loginUser = userService.userLogin(requestLogin);
        if (loginUser != null) {
            request.getSession().setAttribute("loginState", loginUser);
            return ResponseEntity.ok(loginUser);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.POST)
    public Integer userLoginOut(HttpServletRequest request) {
        if (request == null){
            return -1;
        }
        return userService.userLoginOut(request);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Integer userRegister(@RequestBody RequestRegister requestRegister) {
        if(requestRegister == null || requestRegister.getUsername() == null) {
            return -1;
        }
        return userService.userRegister(requestRegister);
    }

}
