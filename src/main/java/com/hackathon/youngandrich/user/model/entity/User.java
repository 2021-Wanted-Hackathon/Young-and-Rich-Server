package com.hackathon.youngandrich.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String email;
    private String password;
    private String userName;
    private String phoneNumber;
    private int status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
