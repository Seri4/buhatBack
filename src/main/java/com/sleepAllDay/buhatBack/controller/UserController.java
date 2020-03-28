package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<List<UserDto>>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(@RequestParam() Map<String, String> params) {
        UserDto currentUser = userService.find(params.get("login"), params.get("id"));
        if (Objects.nonNull(currentUser)){
            return new ResponseEntity<UserDto>(currentUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @GetMapping("/users/find/{login}")
//    public User getUserByLogin(@PathVariable String login) {
//        return userService.findByLogin(login);
//    }
//
//    @GetMapping("/users/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.findById(id).get();
//    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody UserDto user) {
        userService.save(user);
    }

//    @PostMapping("/users/add/{login}/{password}/{rate}")
//    public void addUser(@PathVariable String login, @PathVariable String password,
//                        @PathVariable double rate) {
//        userService.save(new User(login, password, rate));
//    }

    @PutMapping("/users/update/")
    public void updateLogin(@RequestBody UserDto user) {
//        User user = userService.findById(id);
//        user.setLogin(login);
        userService.update(user);
    }

    @DeleteMapping("/users/delete/")
    public void deleteUser(@RequestBody UserDto user) {
        userService.delete(user);
    }
}
