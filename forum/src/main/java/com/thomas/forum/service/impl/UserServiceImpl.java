package com.thomas.forum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.thomas.forum.infra.Schema;
import com.thomas.forum.model.User;
import com.thomas.forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.jph.domain}")
    private String domin;

    @Value("${api.jph.endpoints.users}")
    private String endpoint;

    // @SuppressWarnings("null")
    // public String url = UriComponentsBuilder.newInstance()
    //         .scheme(Schema.HTTPS.name().toLowerCase()).host(domin).path(endpoint)
    //         .toUriString();

    @Override
    public List<User> getUsers() {

        String url = "https://jsonplaceholder.typicode.com/users";


        // @SuppressWarnings("null")
        User[] users = restTemplate.getForObject(url, User[].class);

        List<User> listUsers = Arrays.asList(users);

        return listUsers;

        // List<User> result = List.of(
        // User.builder()
        // .name("ABC")
        // .address(Address.builder()
        // .city("Maxhon")
        // .street("Yau Tong Street")
        // .build())
        // .build(),
        // User.builder().name("ABC2").build());

        // return result;

    }

    public static void main(String[] args) {
        UserServiceImpl testingUserService = new UserServiceImpl();

        System.out.println(testingUserService.getUsers());
    }

}
