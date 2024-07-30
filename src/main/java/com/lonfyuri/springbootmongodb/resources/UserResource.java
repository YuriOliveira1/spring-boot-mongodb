package com.lonfyuri.springbootmongodb.resources;

import com.lonfyuri.springbootmongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User("1", "John", "john@gmail.com");
        User user2 = new User("2", "Jane", "jane@gmail.com");

        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(user, user2));
        return ResponseEntity.ok().body(list);
    }
}
