package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto findByLogin(String login);

    UserDto find(String login, String id);

    void save(UserDto user);

    void delete(UserDto user);

    void update(UserDto user);

    void deleteById(Long id);

    void ratingIncrease(Long id, double value);

    void ratingDecrease(Long id, double value);
}
