package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.repositories.UserRepository;
import com.sleepAllDay.buhatBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void ratingIncrease(Long id, double value) {
        User user = userRepository.findById(id).get();
        user.setRate(user.getRate() + value);
        userRepository.save(user);
    }

    @Override
    public void ratingDecrease(Long id, double value) {
        User user = userRepository.findById(id).get();
        user.setRate(user.getRate()-value);
        userRepository.save(user);
    }
}
