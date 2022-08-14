package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Order;
import com.shopping.shopping.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags={"5. Order"})
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //주문등록
    @ApiOperation(value="주문등록", notes="userId")
    @PostMapping("/order/{userId}")
    public int insertOrder(@PathVariable("userId")String userId) {
        try {
            return orderService.insertOrder(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //주문번호불러오기
    @ApiOperation(value="주문번호불러오기", notes="userId")
    @GetMapping("/order/{userId}")
    public List<Order> checkOrderSeq(@PathVariable("userId")String userId) {
        try {
            return orderService.checkOrderSeq(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
