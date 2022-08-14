package com.shopping.shopping.controller;

import com.shopping.shopping.domain.OrderDetail;
import com.shopping.shopping.service.OrderDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Api(tags={"4. OrderDetail"})
@RestController
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @ApiOperation(value="주문 상세 등록", notes="ex) {\"Detail\" : [ {\"productSeq\" : 1, \"orderDetailCount\" : 2, \"orderDetailPrice\" : 5000000}, {\"productSeq\" : 2, \"orderDetailCount\" : 1, \"orderDetailPrice\" : 2000000}] }")
    @PostMapping("/orderDetail/{userId}/insert")
    public int insertOrderDetail(@PathVariable("userId")String userId, @RequestBody HashMap<String, Object> params) {

        try {
            return orderDetailService.insertOrderDetail(userId, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ApiOperation(value="주문 상태 수정", notes = "orderDetailSeq, orderDetailState (0: 구매대기 1: 취소 2:환불  3:구매완료)")
    @PutMapping("/orderDetail/state")
    public int updateOrderDetailState(@RequestBody OrderDetail orderDetail) {

        try {
            return orderDetailService.updateOrderDetailState(orderDetail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

