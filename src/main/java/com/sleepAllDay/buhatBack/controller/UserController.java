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
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id).get();
    }

    @PostMapping("/users/add/{login}/{password}/{rate}")
    public void addUser(@PathVariable String login, @PathVariable String password,
                        @PathVariable double rate) {
        userService.save(new User(login, password, rate));
    }

    @PutMapping("/users/update/{id}/{login}")
    public void updateLogin(@PathVariable Long id, @PathVariable String login) {
        User user = userService.findById(id).get();
        user.setLogin(login);
        userService.save(user);
    }

    @PutMapping("/user/update/{id}/{password}")
    public void updatePassword(@PathVariable Long id, @PathVariable String password) {
        User user = userService.findById(id).get();
        user.setPassword(password);
        userService.save(user);
    }

    @PutMapping("/user/{id}/rating/increase/{value}")
    public void ratingIncrease(@PathVariable Long id, @PathVariable double value) {
        userService.ratingIncrease(id, value);
    }

    @PutMapping("/user/{id}/rating/decrease/{value}")
    public void ratingDecrease(@PathVariable Long id, @PathVariable double value) {
        userService.ratingDecrease(id, value);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
