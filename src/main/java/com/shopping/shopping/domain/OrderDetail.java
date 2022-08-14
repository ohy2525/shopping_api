package com.shopping.shopping.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {

    private int orderDetailSeq;                    //PK
    private int orderSeq;                          //FK
    private int productSeq;                        //FK
    private int orderDetailCount;
    private int orderDetailPrice;
    private int orderDetailState;                  //0:구매대기, 1:취소 2:환불, 3:구매완료 //기본값 : 0
    private String orderDetailCreateDate;
    private String orderDetailUpdateDate;

}
