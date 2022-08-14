package com.shopping.shopping.controller;

import com.shopping.shopping.domain.Product;
import com.shopping.shopping.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags={"2. Product"})
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }
    //상품 목록 조회
    @ApiOperation(value="상품 목록 조회", notes = "모든 상품 조회")
    @GetMapping("/product")
    public List<Product> getProductList()  {
        try {
            return productService.getProductList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //상품 등록
    @ApiOperation(value="상품 등록", notes = "{\n" +
            "\"productName\":\"8월4일\",\n" +
            "\"productPrice\":4587451,\n" +
            "\"productCount\":100\n" +
            "}")
    @PostMapping("/product/{userId}/insert")
    public int insertProduct(@RequestBody Product product, @PathVariable("userId")String userId) {
        try {
            return productService.insertProduct(product, userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //상품 정보 업데이트
    @ApiOperation(value="상품 정보 업데이트", notes = "{\n" +
            "\"productSeq\" : 7,\n" +
            "\"productName\" : \"updatetest\",\n" +
            "\"productPrice\" : 100,\n" +
            "\"productCount\" : 7,\n" +
            "\"productDelYn\": 1\n" +
            "}")
    @PutMapping("/product/{userId}/update")
    public int updateProduct(@RequestBody Product product, @PathVariable("userId")String userId) {
        try {
            return productService.updateProduct(product, userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //구매 수량 만큼 상품 수 감소
    @ApiOperation(value="구매 수량 만큼 상품 수 감소", notes = "productSeq, productCount")
    @PutMapping("/product/buy")
    public int buyProduct(@RequestBody Product product) {
        try {
            return productService.buyProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //남은 상품 수 확인
    @ApiOperation(value="남은 상품 수 확인", notes = "productSeq")
    @PostMapping("/product/count")
    public List<Product> getProductCount(@RequestBody Product product) {
        try {
            return productService.getProductCount(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
