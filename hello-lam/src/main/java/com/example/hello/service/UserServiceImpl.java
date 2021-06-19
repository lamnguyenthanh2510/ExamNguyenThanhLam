package com.example.hello.service;

import com.example.hello.entity.UserEntity;
import com.example.hello.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    @Override
    public void delete(UserEntity emp) {
        userRepo.delete(emp);
    }

    @Override
    public UserEntity findOne(int id) {
        return null;
    }

    @Override
    public void save(UserEntity contact) {
        userRepo.save(contact);
    }


}
