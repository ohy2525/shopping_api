package com.shopping.shopping.controller;

import com.shopping.shopping.domain.User;
import com.shopping.shopping.response.UserResponse;
import com.shopping.shopping.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags={"1. User"})
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //사용자 목록 조회
    @ApiOperation(value="사용자 목록 조회", notes="모든 사용자 조회")
    @GetMapping("/user")
    public List<User> getUserList() {
        try {
            return userService.getUserList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자 등록
    @ApiOperation(value="사용자 등록", notes="userId, userPassword, userPhone, userAddr, userGubun(0:관리자, 1:회원) 입력")
    @PostMapping("/user/insert")
    public UserResponse insertUser(@RequestBody User user) {
        try {
            return userService.insertUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자 정보 업데이트
    @ApiOperation(value="사용자 정보 업데이트", notes="userId, userPassword, userPhone, userAddr 입력")
    @PutMapping("/user/update")
    public UserResponse updateUser(@RequestBody User user) {
        try {
            return userService.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자 제거
    @ApiOperation(value="사용자 정보 제거", notes="userId")
    @DeleteMapping("/user/delete")
    public int deleteUser(@RequestBody User user) {
        try {
            return userService.deleteUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자가 관리자인지 확인
    @ApiOperation(value="관리자 조회", notes="userId")
    @GetMapping("/user/{userId}")
    public List<User> checkUser(@PathVariable("userId")String userId) {
        try {
            return userService.checkUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
