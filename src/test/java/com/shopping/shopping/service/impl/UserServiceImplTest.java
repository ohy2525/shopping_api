package com.shopping.shopping.service.impl;

import com.shopping.shopping.domain.User;
import com.shopping.shopping.response.UserResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @BeforeEach
    public void BeforeEach(){
        // inset 구현
    }


    @AfterEach
    public void AfterEach(){
        // delete 구현
    }


    @Test
    void 사용자등록() {
        //given
        User user = new User();
        user.setUserId("testcode7");
        user.setUserPassword("pwd");
        user.setUserPhone("010-7894-7894");
        user.setUserAddr("신림");
        user.setUserGubun(1);

        //when
        UserResponse userResponse = userServiceImpl.insertUser(user);

        //then
        //System.out.println("result = "  + (result == 1));
        //Assertions.assertEquals(1, result);
//        Assertions.assertThat(result).isEqualTo(1);

    }

    @Test
    void 사용자목록조회() {
        //given

        //when
        List<User> result = userServiceImpl.getUserList();

        //then
        Assertions.assertThat(result.size()).isEqualTo(7);
    }

    @Test
    void 사용자업데이트() {
        //given
        User user = new User();
        user.setUserId("testcode7");
        user.setUserPassword("pwdupdate");
        user.setUserPhone("010-9999-9999");
        user.setUserAddr("미국");

        //when
        //int result = userServiceImpl.updateUser(user);

        //then
        //System.out.println("result = "  + (result == 1));
        //Assertions.assertEquals(1, result);
        //Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void 사용자제거() {
        //given
        User user = new User();
        user.setUserId("testcode4");

        //when
        int result = userServiceImpl.deleteUser(user);

        //then
        //System.out.println("result = "  + (result == 1));
        //Assertions.assertEquals(1, result);
        Assertions.assertThat(result).isEqualTo(1);
    }

    /*@Test
    void 사용자중복확인() {
        //given
        User user = new User();
        user.setUserId("관리자");

        //when
        int result = userServiceImpl.getUserById(user);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }*/
}
