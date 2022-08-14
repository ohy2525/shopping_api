package com.shopping.shopping.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int userSeq;                 //PK
    private String userId;               //중복 X
    private String userPassword;
    private String userPhone;
    private String userAddr;
    private int userGubun;               // 0:관리자  1:고객
    private String userCreateDate;
    private String userUpdateDate;

}
