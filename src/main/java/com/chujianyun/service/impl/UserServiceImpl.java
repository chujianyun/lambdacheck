package com.chujianyun.service.impl;

import com.chujianyun.component.UserCheckFuntions;
import com.chujianyun.entity.context.UserCheckContext;
import com.chujianyun.entity.dto.UserCheckResultDTO;
import com.chujianyun.entity.param.UserParam;
import com.chujianyun.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserCheckFuntions userCheckFuntions;

    @Override
    public UserCheckResultDTO checkUser(UserParam userParam) {
        UserCheckContext userCheckContext = new UserCheckContext();
        return userCheckFuntions.checkIsValid(userParam)
                .andThen(userCheckFuntions.checkIsInWhiteList(userParam))
                .andThen(userCheckFuntions.checkIsHighLevel(userParam))
                .apply(userCheckContext)
                .getUserCheckResultDTO();
    }
}
