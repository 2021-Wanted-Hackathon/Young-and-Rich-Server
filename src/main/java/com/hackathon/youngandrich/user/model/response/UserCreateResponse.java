package com.hackathon.youngandrich.user.model.response;

import com.hackathon.youngandrich.user.model.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreateResponse {
    private int userId;

    public static UserCreateResponse from(User user) {
        return builder().userId(user.getUserId()).build();
    }
}
