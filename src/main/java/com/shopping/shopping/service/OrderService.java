package com.shopping.shopping.service;

import com.shopping.shopping.domain.Order;

import java.util.List;

public interface OrderService {

    //주문 등록
    public int insertOrder(String userId) throws Exception;

    //orderSeq 불러오기
    public List<Order> checkOrderSeq(String userId) throws Exception;
}
