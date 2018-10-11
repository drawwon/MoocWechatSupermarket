package com.imooc.sell.service.impl;

import com.imooc.sell.dataObject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    private final String buyerOpenid = "110110";
    private final String Order_Id = "12345678";
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerName("拜考神");
        orderDTO.setBuyerPhone("18888888888");
        orderDTO.setBuyerOpenid(buyerOpenid);
        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO orderDTO1 = orderService.create(orderDTO);
        assertNotNull(orderDTO1);
    }

    @Test
    public void getOne() {
        OrderDTO result = orderService.getOne(Order_Id);
        log.info("[查询单个订单] result={}", result);
        assertNotNull(result);

    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(buyerOpenid, request);
        log.info("查询订单List的结果：result={}", orderDTOPage.getContent());
        assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO result = orderService.getOne("123456");
        OrderDTO orderDTO = orderService.cancel(result);
        assertEquals(OrderStatusEnum.CANCEL.getCode(), orderDTO.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO result = orderService.getOne("123456");
        OrderDTO orderDTO = orderService.finish(result);
        assertEquals(OrderStatusEnum.FINISHED.getCode(), orderDTO.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO result = orderService.getOne("123456");
        OrderDTO orderDTO = orderService.paid(result);
        assertEquals(PayStatusEnum.SUCCESS.getCode(), orderDTO.getPayStatus());
    }
}