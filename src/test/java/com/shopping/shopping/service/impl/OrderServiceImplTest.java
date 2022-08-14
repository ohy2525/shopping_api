package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Test
    void 주문등록(){

        //given
        String userId = "testcode";

        //when
        int result = orderServiceImpl.insertOrder(userId);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 주문번호불러오기(){
        //given
        String userId = "testcode";

        //when
        List result = orderServiceImpl.checkOrderSeq(userId);

        //then
        Assertions.assertThat(result.size()).isEqualTo(1);

    }

}
