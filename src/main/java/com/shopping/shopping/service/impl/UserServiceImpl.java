package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.User;
import com.shopping.shopping.mapper.UserMapper;
import com.shopping.shopping.response.UserResponse;
import com.shopping.shopping.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {

        this.userMapper = userMapper;
    }

    //사용자 목록 조회
    @Override
    public List<User> getUserList() {
        try {
            return userMapper.getUserList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자 등록
    @Override
    public UserResponse insertUser(User user) {
        UserResponse userResponse = new UserResponse();
        try {
            List i = userMapper.getUserById(user);
            if (i.size() == 1) {
                userResponse.setMessage("이미 존재하는 아이디입니다.");
                userResponse.setErrCode(500);
                userResponse.setErrMsg("에러");
            } else {
                String str = user.getUserPhone();
                String pattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
                if (Pattern.matches(pattern, str)) {
                    int j = userMapper.insertUser(user);
                    if (j == 1) {
                        userResponse.setMessage("사용자 등록 완료");
                    }
                } else {
                    userResponse.setMessage("핸드폰 번호 양식 확인");
                    userResponse.setErrCode(444);
                    userResponse.setErrMsg("에러");
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userResponse;
    }

    //사용자 정보 업데이트
    @Override
    public UserResponse updateUser(User user) {
        UserResponse userResponse = new UserResponse();

        try {
            List i = userMapper.getUserById(user);
            if (i.size() == 1) {
                int j = userMapper.updateUser(user);
                if (j == 1) {
                    userResponse.setMessage("정보가 변경되었습니다.");
                } else {
                    userResponse.setMessage("업데이트과정에서 문제 발생.");
                }
            }

        } catch (Exception e) {
            userResponse.setMessage("회원 정보가 없습니다.");
            userResponse.setErrCode(500);
            userResponse.setErrMsg("에러");
        }

        return userResponse;
    }

    //사용자 삭제
    @Override
    public int deleteUser(User user) {
        try {
            return userMapper.deleteUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //관리자 확인
    @Override
    public List<User> checkUser(String userId) {
        try {
            return userMapper.checkUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //사용자 확인
    @Override
    public List<User> getUserById(User user) {
        try {
            return userMapper.getUserById(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
