package com.shopping.shopping.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {

    private int cartSeq;                //PK
    private String userId;              //FK
    private int productSeq;             //FK
    private int cartProductCount;
    private int cartProductDel;         //0:등록되어있음, 1:구매완료, 2: 사용자가 삭제//기본값 : 0
    private String cartCreateDate;
    private String cartUpdateDate;

}
