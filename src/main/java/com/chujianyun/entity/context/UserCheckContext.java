package com.chujianyun.entity.context;

import com.chujianyun.entity.dto.UserCheckResultDTO;
import lombok.Data;

@Data
public class UserCheckContext {

    private UserCheckResultDTO userCheckResultDTO = new UserCheckResultDTO();

    // 可以携带其他结果
}
