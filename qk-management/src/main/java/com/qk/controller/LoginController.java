package com.qk.controller;

import com.qk.common.Result;
import com.qk.dto.LoginDto;
import com.qk.service.UserService;
import com.qk.vo.LoginResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        LoginResultVo loginResult = userService.login(loginDto.getUsername(), loginDto.getPassword());
        return Result.success(loginResult);
    }
}
