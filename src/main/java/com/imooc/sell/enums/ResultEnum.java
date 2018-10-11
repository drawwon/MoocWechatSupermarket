package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不足"),
    ORDER_NOT_EXSIT(12, "订单不存在"),
    ORDER_DETAIL_NOT_EXSIT(12, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    PAY_STAUS_ERROR(17, "支付状态不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
