package com.imooc.sell.dataObject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    //订单id
    private String orderId;
    //商品id
    private String productId;
    //商品价格
    private BigDecimal productPrice;
    //商品名称
    private String productName;
    //商品数量
    private Integer productQuantity;
    //商品图标
    private String productIcon;

}
