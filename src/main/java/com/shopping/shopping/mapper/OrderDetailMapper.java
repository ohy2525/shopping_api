package com.shopping.shopping.mapper;

import com.shopping.shopping.domain.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {

    //주문 상세 등록
    public int insertOrderDetail(OrderDetail orderDetail) throws Exception;

    //주문 상태 수정 0: 구매대기 1: 취소 2:환불  3:구매완료
    public int updateOrderDetailState(OrderDetail orderDetail) throws Exception;

}
