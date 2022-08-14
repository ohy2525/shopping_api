package com.shopping.shopping.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    
    private int productSeq;                //PK
    private String productName;
    private int productPrice;
    private int productCount;
    private int productDelYn;             //0:있는상품 1:삭제상품
    private String productCreateDate;
    private String productUpdateDate;

}

