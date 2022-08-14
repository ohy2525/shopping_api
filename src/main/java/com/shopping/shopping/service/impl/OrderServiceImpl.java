package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Order;
import com.shopping.shopping.mapper.OrderMapper;
import com.shopping.shopping.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    //주문 등록
    @Override
    public int insertOrder(String userId) {
        try {
            return orderMapper.insertOrder(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //orderSeq 불러오기
    @Override
    public List<Order> checkOrderSeq(String userId) {
        try {
            return orderMapper.checkOrderSeq(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
