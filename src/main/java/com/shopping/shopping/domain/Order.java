package com.shopping.shopping.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private int orderSeq;                 //PK
    private String userId;                //FK
    private String orderCreateDate;
    private String orderUpdateDate;

}
