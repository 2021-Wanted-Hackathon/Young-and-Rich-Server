package com.hackathon.youngandrich.user.service;

import com.hackathon.youngandrich.common.exception.BadRequestException;
import com.hackathon.youngandrich.common.exception.ExceptionCode;
import com.hackathon.youngandrich.user.repository.UserRepository;
import com.hackathon.youngandrich.user.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public int signUp(User user) {

        if (userRepository.checkEmail(user) == 1) {
            throw new BadRequestException(ExceptionCode.ALREADY_EXIST_EMAIL);
        }

        if (userRepository.checkPhoneNumber(user) == 1) {
            throw new BadRequestException(ExceptionCode.ALREADY_EXIST_PHONENUMBER);
        }

        return userRepository.signUp(user);
    }

}
