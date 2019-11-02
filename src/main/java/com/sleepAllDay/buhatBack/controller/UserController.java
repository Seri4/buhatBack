package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id).get();
    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/users/update/{id}")
    public void updateUser(@RequestBody User newUser, @PathVariable Long id){
        User user = userService.findById(id).get();
        user.setLogin(newUser.getLogin());
        user.setPassword(newUser.getPassword());
        user.setRate(newUser.getRate());
        userService.save(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
