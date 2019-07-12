package com.chujianyun.component;

import com.chujianyun.entity.context.UserCheckContext;
import com.chujianyun.entity.dto.UserCheckResultDTO;
import com.chujianyun.entity.param.UserParam;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class UserCheckFuntions {

    // 注入校验所需的各种Bean

    public Function<UserCheckContext, UserCheckContext> checkIsValid(UserParam userParam) {

        return buildCheck(userCheckContext -> {
            UserCheckResultDTO userCheckResultDTO = userCheckContext.getUserCheckResultDTO();
            // 模拟调用服务A，检查有效性
            boolean result = (userParam.getUserId() > 50);
            if (result) {
                userCheckResultDTO.setIsValidUser(true);
            } else {
                userCheckResultDTO.setIsValidUser(false);
                addFailedMessage(userCheckResultDTO, "无效");
            }
        });
    }

    public Function<UserCheckContext, UserCheckContext> checkIsInWhiteList(UserParam userParam) {
        return buildCheck(userCheckContext -> {
            UserCheckResultDTO userCheckResultDTO = userCheckContext.getUserCheckResultDTO();
            // 模拟调用服务B，检查是否在白名单
            boolean result = (userParam.getUserId() > 500);
            if (result) {
                userCheckResultDTO.setIsInWhiteList(true);
            } else {
                userCheckResultDTO.setIsInWhiteList(false);
                addFailedMessage(userCheckResultDTO, "不在白名单");
            }
        });
    }

    public Function<UserCheckContext, UserCheckContext> checkIsHighLevel(UserParam userParam) {
        return buildCheck(userCheckContext -> {
            UserCheckResultDTO userCheckResultDTO = userCheckContext.getUserCheckResultDTO();
            // 模拟调用服务C，检查是否高级用户
            boolean result = (userParam.getUserId() > 30);
            if (result) {
                userCheckResultDTO.setIsHighLevel(true);
            } else {
                userCheckResultDTO.setIsHighLevel(false);
                addFailedMessage(userCheckResultDTO, "等级不够");
            }
        });
    }

    public Function<UserCheckContext, UserCheckContext> buildCheck(Consumer<UserCheckContext> userCheckContextConsumer) {
        return (userCheckContext) -> {
            userCheckContextConsumer.accept(userCheckContext);
            return userCheckContext;
        };
    }

    /**
     * 添加失败的信息
     */
    public void addFailedMessage(UserCheckResultDTO userCheckResultDTO, String message) {

        List<String> failMessages = userCheckResultDTO.getFailedMessages();
        if (failMessages == null) {
            failMessages = new ArrayList<>();
            userCheckResultDTO.setFailedMessages(failMessages);
        }
        failMessages.add(message);

    }
}
