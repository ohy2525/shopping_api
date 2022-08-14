package com.shopping.shopping.mapper;

import com.shopping.shopping.domain.User;
import com.shopping.shopping.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //사용자 전체 조회
    public List<User> getUserList() throws Exception;

    //사용자 등록
    public int insertUser(User user) throws Exception;

    //사용자 정보 변경
    public int updateUser(User user) throws Exception;

    //사용자 삭제
    public int deleteUser(User user) throws Exception;

    //사용자가 관리자인지 확인
    public List<User> checkUser(String userId) throws Exception;

    //사용자 확인
    public List<User> getUserById(User user) throws Exception;
}
