package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Cart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Test
    void 장바구니등록() {
        //given
        Cart cart = new Cart();
        cart.setUserId("testcode");
        cart.setProductSeq(1);
        cart.setCartProductCount(10);

        //when
        int result = cartServiceImpl.insertCart(cart);

        //then
        Assertions.assertThat(result).isEqualTo(1);

    }

    @Test
    void 장바구니수정() {
        //given
        Cart cart = new Cart();
        cart.setCartSeq(8);
        cart.setCartProductCount(100000);
        cart.setCartProductDel(2);

        //when
        int result = cartServiceImpl.updateCart(cart);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 구매완료() {
        //given
        Cart cart = new Cart();
        cart.setCartSeq(9);

        //when
        int result = cartServiceImpl.completeCart(cart);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }
}
