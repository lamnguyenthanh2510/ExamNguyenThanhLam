package com.example.hello.service;

import com.example.hello.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> getAll();
    void delete(UserEntity emp);

    UserEntity findOne (int id);

    void save(UserEntity emp);
}
