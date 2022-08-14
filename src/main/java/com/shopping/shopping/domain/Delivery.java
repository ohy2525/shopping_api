package com.shopping.shopping.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Delivery {

    private int deliverySeq;                   //PK
    private int orderSeq;                      //FK
    private String userId;                     //FK
    private int deliveryState;                 //0:배송준비, 1:배송중, 2:배송완료
    private String deliveryCreateDate;
    private String deliveryUpdateDate;

}
