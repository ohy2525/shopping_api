package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.OrderDetail;
import com.shopping.shopping.domain.Product;
import com.shopping.shopping.mapper.OrderMapper;
import com.shopping.shopping.mapper.OrderDetailMapper;
import com.shopping.shopping.mapper.ProductMapper;
import com.shopping.shopping.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailMapper orderDetailMapper;
    final OrderMapper orderMapper;
    final ProductMapper productMapper;

    public OrderDetailServiceImpl(OrderDetailMapper orderDetailMapper, OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderDetailMapper = orderDetailMapper;
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
    }

    //주문 상세 등록
    @Override
    public int insertOrderDetail(String userId, HashMap<String, Object> params) {

        //userId 주문 등록
        try {
            int i = orderMapper.insertOrder(userId);
            if (i == 1) {
                System.out.println("insertOrder 완료");
                //log.debug("~~~~~");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //userId 최근 주문번호 확인
        List result = null;
        try {
            result = orderMapper.checkOrderSeq(userId);
            if (result.size() == 1) {
                System.out.println("주문번호확인");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //주문번호에 맞춰서 주문상세 input(Json --> list )
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> DetailList = (List<Map<String, Object>>) params.get("Detail");

        //주문 상품 수에 따라 수량을 확인하고 주문
        for (int i = 0; i < DetailList.size(); ++i) {
            List countList = null;
            HashMap DetailMap = (HashMap) DetailList.get(i);
            Integer productSeq = (Integer) DetailMap.get("productSeq");
            Integer productCount = (Integer) DetailMap.get("orderDetailCount");
            Integer orderDetailPrice = (Integer) DetailMap.get("orderDetailPrice");
            Product product = new Product();
            product.setProductSeq(productSeq);
            product.setProductCount(productCount);

            System.out.println("상품번호" + productSeq + "  상품수량" + productCount);

            try {
                productMapper.buyProduct(product);                  //수량이 부족한지 먼저 확인해야하는데
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                countList = productMapper.getProductCount(product);
                if (0 > Integer.parseInt(countList.get(0).toString())) {

                    System.out.println("수량이 부족합니다.");

                } else {
                    Integer Seq = Integer.parseInt((String) result.get(0));
                    System.out.println("구매 가능");
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderSeq(Seq);
                    orderDetail.setProductSeq(productSeq);
                    orderDetail.setOrderDetailCount(productCount);
                    orderDetail.setOrderDetailPrice(orderDetailPrice);

//                    try {
                    orderDetailMapper.insertOrderDetail(orderDetail);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return 0;
    }

    @Override
    public int updateOrderDetailState(OrderDetail orderDetail) {

        try {
            return orderDetailMapper.updateOrderDetailState(orderDetail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
