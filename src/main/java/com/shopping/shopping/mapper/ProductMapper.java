package com.shopping.shopping.mapper;

import com.shopping.shopping.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //상품 전체 조회
    public List<Product> getProductList() throws Exception;

    //상품 등록
    public int insertProduct(Product product) throws Exception;

    //상품 정보 변경
    public int updateProduct(Product product) throws Exception;

    //구매 수량 만큼 상품 수 감소
    public int buyProduct(Product product) throws Exception;

    //남은 상품 수 확인
    public List<Product> getProductCount(Product product) throws Exception;

    //상품 삭제
//    public int deleteProduct(Product product) throws Exception;
}
