package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Cart;
import com.shopping.shopping.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags={"3. Cart"})
@RestController
public class CartController {
    
    private final CartService cartService;
    
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //장바구니 전체 조회
    @ApiOperation(value="장바구니 목록 조회", notes= "모든 장바구니 목록 조회")
    @GetMapping("/cart")
    public List<Cart> getCartList() {
        try {
            return cartService.getCartList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자별 장바구니 조회
    @ApiOperation(value="사용자별 장바구니 조회", notes= "사용자별 구매하지 않은 장바구니 목록 조회")
    @GetMapping("/cart/{userId}")
    public List<Cart> getCartListByUser(@PathVariable("userId")String userId) {
        try {
            return cartService.getCartListByUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //장바구니 등록
    @ApiOperation(value="장바구니 등록", notes= "userId, productSeq, cartProductCount")
    @PostMapping("/cart/insert")
    public int insertCart(@RequestBody Cart cart) {
        try {
            return cartService.insertCart(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //장바구니 수정
    @ApiOperation(value="장바구니 수정", notes= "cartSeq, cartProductCount, cartProductDel")
    @PutMapping("/cart/update")
    public int updateCart(@RequestBody Cart cart) {
        try {
            return cartService.updateCart(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //구매완료
    @ApiOperation(value="구매 완료 처리", notes= "cartSeq")
    @PutMapping("/cart/complete")
    public int completeCart(@RequestBody Cart cart) {
        try {
            return cartService.completeCart(cart);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
