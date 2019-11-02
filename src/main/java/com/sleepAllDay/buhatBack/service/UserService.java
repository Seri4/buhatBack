package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void delete(User user);

    void deleteById(Long id);

    void ratingIncrease(Long id, double value);

    void ratingDecrease(Long id, double value);
}
