package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.mapper.ProductMapper;
import com.shopping.shopping.mapper.UserMapper;
import com.shopping.shopping.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    final UserMapper userMapper;

    public ProductServiceImpl(ProductMapper productMapper, UserMapper userMapper) {

        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    //상품 목록 조회
    @Override
    public List<Product> getProductList() {
        try {
            return productMapper.getProductList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //상품 등록
    @Override
    public int insertProduct(Product product, String userId) {
        List result = null;
        try {
            result = userMapper.checkUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String str = result.toString();
        char ans = str.charAt(1);

        if (ans == '0') {
            try {
                int i = productMapper.insertProduct(product);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("관리자가 아닙니다. userGubun = " + ans);
        }

        return 1;
    }

    //상품 정보 업데이트
    @Override
    public int updateProduct(Product product, String userId) {

        List result = null;
        try {
            result = userMapper.checkUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String str = result.toString();
        char ans = str.charAt(1);

//        str.equals("0"){
//
//        }

        if (ans == '0') {
            try {
                return productMapper.updateProduct(product);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("관리자가 아닙니다. userGubun = " + ans);
        }

        return 0;
    }

    //구매 수량 만큼 상품 수 감소
    @Override
    public int buyProduct(Product product) {
        try {
            return productMapper.buyProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //남은 상품 수 확인
    @Override
    public List<Product> getProductCount(Product product) {
        try {
            return productMapper.getProductCount(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

