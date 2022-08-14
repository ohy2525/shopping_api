package com.shopping.shopping.mapper;

import com.shopping.shopping.domain.Order;
import com.shopping.shopping.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    //주문 등록
    public int insertOrder(String userId) throws Exception;

    //orderSeq 불러오기
    public List<Order> checkOrderSeq(String userId) throws Exception;

    //주문 조회
    //테이블 2개 join조회???? List<Order, Delivery>

}
