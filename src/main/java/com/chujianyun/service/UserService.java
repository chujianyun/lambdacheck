package com.chujianyun.service;

import com.chujianyun.entity.dto.UserCheckResultDTO;
import com.chujianyun.entity.param.UserParam;

public interface UserService {

    UserCheckResultDTO checkUser(UserParam userParam);
}
