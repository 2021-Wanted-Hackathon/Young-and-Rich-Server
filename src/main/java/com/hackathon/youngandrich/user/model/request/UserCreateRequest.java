package com.hackathon.youngandrich.user.model.request;

import com.hackathon.youngandrich.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String userName;

    @NotNull
    private String phoneNumber;

    public User toUser() {
        User user = new User();

        user.setEmail(getEmail());
        user.setPassword(getPassword());
        user.setUserName(getUserName());
        user.setPhoneNumber(getPhoneNumber());

        return user;
    }
}
