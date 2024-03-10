package com.thomas.forum.contoller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thomas.forum.contoller.GovOperation;
import com.thomas.forum.model.User;
import com.thomas.forum.service.UserService;
import com.thomas.forum.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovOperationImpl implements GovOperation {

    @Autowired
    UserService userService;

    public List<User> getUsers() {

        List<User> users = userService.getUsers();
        return users;

    }

}
