package com.chujianyun.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserCheckResultDTO {

    /**
     * 是否有效
     */
    private Boolean isValidUser;

    /**
     * 是否白名单
     */
    private Boolean isInWhiteList;

    /**
     * 是否等级高
     */
    private Boolean isHighLevel;

    /**
     * 失败原因
     */
    private List<String> failedMessages;
}
