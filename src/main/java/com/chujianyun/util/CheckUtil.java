package com.chujianyun.util;

import java.util.function.Consumer;
import java.util.function.Function;

public class CheckUtil {

    public static <T> Function<T, T> buildCheck(Consumer<T> checkConsumer) {
        return (checkContext) -> {
            checkConsumer.accept(checkContext);
            return checkContext;
        };
    }
}
