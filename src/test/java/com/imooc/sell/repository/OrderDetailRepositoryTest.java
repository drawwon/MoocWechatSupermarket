package com.imooc.sell.repository;

import com.imooc.sell.dataObject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("11111100");
        orderDetail.setOrderId("12345678");
        orderDetail.setProductIcon("abc.jpg");
        orderDetail.setProductId("a111");
        orderDetail.setProductName("南瓜");
        orderDetail.setProductPrice(new BigDecimal(10.5));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("12345678");
        assertNotEquals(0, orderDetailList.size());

    }
}