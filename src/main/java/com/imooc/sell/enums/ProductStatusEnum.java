package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "在架上"),
    DOWN(1, "已下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
