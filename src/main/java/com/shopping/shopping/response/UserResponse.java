package com.shopping.shopping.response;

import lombok.Data;

@Data
public class UserResponse {
    private Object message;     // 가입이 완료되었습니다.  // 이미 Id 있습니다. // 업데이트에 실패하엿습니다.
    private int errCode;        // 500
    private String errMsg;      // connection refuse
}
