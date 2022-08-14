package com.shopping.shopping.service;

import com.shopping.shopping.domain.Cart;

import java.util.List;

public interface CartService {

    //장바구니 전체 조회
    public List<Cart> getCartList() throws Exception;

    //사용자별 장바구니 조회
    public List<Cart> getCartListByUser(String userId) throws Exception;

    //장바구니 등록
    public int insertCart(Cart cart) throws Exception;

    //장바구니 수정
    public int updateCart(Cart cart) throws Exception;

    //구매완료
    public int completeCart(Cart cart) throws Exception;

}
