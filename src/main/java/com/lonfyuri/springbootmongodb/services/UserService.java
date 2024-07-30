package com.lonfyuri.springbootmongodb.services;

import com.lonfyuri.springbootmongodb.domain.User;
import com.lonfyuri.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
