package com.deviceAtlas.TechnicalTest.controller;

import com.deviceAtlas.TechnicalTest.model.UserDTO;
import com.deviceAtlas.TechnicalTest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value="/users")
    public List<UserDTO> users(){
        return userService.getAllUsers();
    }

    @GetMapping(value="/user/{id}")
    public Object user(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @GetMapping(value="/friends/{id}")
    public List<Object> friendsById(@PathVariable Long id){
        return userService.getFriendsByUserId(id);
    }

    @GetMapping(value="/suggestedFriends/{id}")
    public List<Object> suggestedFriendsById(@PathVariable Long id){
        return userService.getSuggestedFriendsByUserId(id);
    }




}
