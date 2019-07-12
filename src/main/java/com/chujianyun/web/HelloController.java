package com.chujianyun.web;

import com.chujianyun.entity.dto.UserCheckResultDTO;
import com.chujianyun.entity.param.UserParam;
import com.chujianyun.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class HelloController {

    @Resource
    private UserService userService;


    @PostMapping("/check")
    public ResponseEntity<UserCheckResultDTO> checkUser(UserParam userParam) {

        return new ResponseEntity<>(userService.checkUser(userParam), HttpStatus.OK);
    }
}
