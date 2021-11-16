package com.hackathon.youngandrich.user.controller;

import com.hackathon.youngandrich.common.model.ResultContainer;
import com.hackathon.youngandrich.user.service.UserService;
import com.hackathon.youngandrich.user.model.entity.User;
import com.hackathon.youngandrich.user.model.request.UserCreateRequest;
import com.hackathon.youngandrich.user.model.response.UserCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/users/sign-up")
    public ResultContainer<UserCreateResponse> signUp(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        User user = userCreateRequest.toUser();
        userService.signUp(user);

        return new ResultContainer<>(UserCreateResponse.from(user));
    }
}
