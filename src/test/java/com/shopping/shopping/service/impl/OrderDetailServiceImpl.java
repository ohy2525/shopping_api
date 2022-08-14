package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.OrderDetail;
import com.shopping.shopping.mapper.OrderDetailMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderDetailServiceImplTest {

    @Autowired
    private OrderDetailServiceImpl orderDetailServiceImpl;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    void 주문상태수정() {
        //given
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailSeq(20);
        orderDetail.setOrderDetailState(3);

        //when
        int result = orderDetailServiceImpl.updateOrderDetailState(orderDetail);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 주문상세등록() throws Exception {
        //given
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderSeq(44);
        orderDetail.setProductSeq(5);
        orderDetail.setOrderDetailCount(999);
        orderDetail.setOrderDetailPrice(999999999);

        //when
        int result = orderDetailMapper.insertOrderDetail(orderDetail);

        //then
        Assertions.assertThat(result).isEqualTo(1);

    }
}

