package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Cart;
import com.shopping.shopping.mapper.CartMapper;
import com.shopping.shopping.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartMapper cartMapper;

    public CartServiceImpl(CartMapper cartMapper) {

        this.cartMapper = cartMapper;
    }

    //장바구니 전체 조회
    @Override
    public List<Cart> getCartList() {
        try {
            return cartMapper.getCartList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자별 장바구니 조회
    @Override
    public List<Cart> getCartListByUser(String userId) {
        try {
            return cartMapper.getCartListByUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //장바구니 등록
    @Override
    public int insertCart(Cart cart) {
        try {
            return cartMapper.insertCart(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //장바구니 수정
    @Override
    public int updateCart(Cart cart) {
        try {
            return cartMapper.updateCart(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //구매완료
    @Override
    public int completeCart(Cart cart) {
        try {
            return cartMapper.completeCart(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
