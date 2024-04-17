package com.thomas.forum.config.contoller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thomas.forum.config.contoller.GovOperation;
import com.thomas.forum.model.User;
import com.thomas.forum.service.UserService;
import com.thomas.forum.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovOperationImpl implements GovOperation {

    @Autowired
    UserService userService;

    public List<User> getUsers() {

        List<User> users = userService.getUsers();
        return users;

    }

    public User getUser(int num) {

        List<User> users = userService.getUsers();

        return users.get(num);

    }


    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping(value = "demo-user")
    public User getDemoUser(@RequestParam(value = "id") int num) {
        List<User> users2 = List.of(
                User.builder().id(1000).name("testing").build(),
                User.builder().id(1331).build(),
                User.builder().id(191)
                        .address(User.Address.builder().city("HK").build())
                        .build());


        User targetUser = null;
        int count = 0;
        for (User user : users2) {
            if (user.getId() == num) {
                targetUser = user;
            } else {
                count++;
            }
        }
        System.out.println("number of user not found: " + count);
        System.out.println("founded user: " + targetUser.getName());
        return targetUser;
    }


    public static void main(String[] args) {

        GovOperationImpl testGov = new GovOperationImpl();


        System.out.println(testGov.getDemoUser(1331));


    }



}
