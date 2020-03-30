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

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/users/add")
    public void addUser(@RequestBody UserDto user) {
        userService.save(user);
    }

    @PutMapping("/users/update/")
    public void update(@RequestBody UserDto user) {
        userService.update(user);
    }

    @DeleteMapping("/users/delete/")
    public void deleteUser(@RequestBody UserDto user) {
        userService.delete(user);
    }
}
