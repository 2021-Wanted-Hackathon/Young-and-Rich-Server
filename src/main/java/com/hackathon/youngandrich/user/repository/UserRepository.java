package com.hackathon.youngandrich.user.repository;

import com.hackathon.youngandrich.user.mapper.UserMapper;
import com.hackathon.youngandrich.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final UserMapper userMapper;

    public int signUp(User user) {
        return userMapper.signUp(user);
    }

    public int checkEmail(User user) {
        return userMapper.checkEmail(user);
    }

    public int checkPhoneNumber(User user) {
        return userMapper.checkPhoneNumber(user);
    }
}
