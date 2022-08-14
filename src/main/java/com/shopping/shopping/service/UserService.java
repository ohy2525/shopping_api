package com.shopping.shopping.service;

import com.shopping.shopping.domain.User;
import com.shopping.shopping.response.UserResponse;

import java.util.List;

public interface UserService {

    //사용자 조회
    public List<User> getUserList() throws Exception;

    // 사용자 등록
    public UserResponse insertUser(User user) throws Exception;

    // 사용자 정보 변경
    public UserResponse updateUser(User user) throws Exception;

    //사용자 삭제
    public int deleteUser(User user) throws Exception;

    //사용자가 관리자인지 확인
    public List<User> checkUser(String userId) throws Exception;

    //사용자 확인
    public List<User> getUserById(User user) throws Exception;

}
