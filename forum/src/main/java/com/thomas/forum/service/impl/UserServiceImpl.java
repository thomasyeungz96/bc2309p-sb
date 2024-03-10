package com.thomas.forum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thomas.forum.model.User;
import com.thomas.forum.model.User.Address;
import com.thomas.forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<User> getUsers() {

        String url = "https://jsonplaceholder.typicode.com/users";

        User[] users = restTemplate.getForObject(url, User[].class);

        List<User> listUsers = Arrays.asList(users);

        return listUsers;

        // List<User> result = List.of(
        // User.builder()
        // .name("ABC")
        // .address(Address.builder()
        //  .city("Maxhon")
        // .street("Yau Tong Street")
        // .build())
        // .build(),
        // User.builder().name("ABC2").build());

        // return result;

    }

    public static void main(String[] args) {
        System.out.println(new UserServiceImpl().getUsers());
    }

}
