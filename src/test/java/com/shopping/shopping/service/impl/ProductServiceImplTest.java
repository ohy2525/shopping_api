package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServiceImplTest {
    
    @Autowired
    private ProductServiceImpl productServiceImpl;
    
    @Test
    void 상품등록() {
        //given
        Product product = new Product();
        product.setProductName("testproduct");
        product.setProductPrice(500);
        product.setProductCount(999);

        String userId = "관리자";

        //when
        int result = productServiceImpl.insertProduct(product, userId);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 상품정보업데이트() {
        //given
        Product product = new Product();
        product.setProductSeq(7);
        product.setProductName("testupdate");
        product.setProductPrice(804);
        product.setProductCount(804);
        product.setProductDelYn(1);

        String userId = "관리자";

        //when
        int result = productServiceImpl.updateProduct(product, userId);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 남은수량확인() {
        //given
        Product product = new Product();
        product.setProductSeq(1);

        //when
        List result = productServiceImpl.getProductCount(product);

        //then
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

}
