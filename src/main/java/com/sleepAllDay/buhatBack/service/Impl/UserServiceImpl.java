package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.mapper.UserMapper;
import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.repositories.UserRepository;
import com.sleepAllDay.buhatBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        User currentUser = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return UserMapper.INSTANCE.userToUserDto(currentUser);
    }

    @Override
    public UserDto findByLogin(String login) {
        User currentUser = userRepository.findByLogin(login).orElseThrow(EntityNotFoundException::new);
        return UserMapper.INSTANCE.userToUserDto(currentUser);
    }

    @Override
    public UserDto find(String login, String id) {
        if (!login.equals("") && id.equals("")){
            return UserMapper.INSTANCE.userToUserDto(userRepository.findByLogin(login).orElseThrow(EntityNotFoundException::new));
        }
        if (login.equals("") && !id.equals("")) {
            return UserMapper.INSTANCE.userToUserDto(userRepository.findById(Long.parseLong(id)).orElseThrow(EntityNotFoundException::new));
        }
        return null;
    }

    @Override
    public void save(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .rate(userDto.getRate())
                .build();
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .rate(userDto.getRate())
                .build();
        userRepository.delete(user);
    }

    @Override
    public void update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElseThrow(EntityNotFoundException::new);
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setRate(userDto.getRate());
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void ratingIncrease(Long id, double value) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setRate(user.getRate() + value);
        userRepository.save(user);
    }

    @Override
    public void ratingDecrease(Long id, double value) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setRate(user.getRate()-value);
        userRepository.save(user);
    }
}
