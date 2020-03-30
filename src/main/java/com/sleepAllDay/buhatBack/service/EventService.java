package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.dto.EventDto;
import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<EventDto> findAll();

    EventDto findById(Long id);

    void save(EventDto event);

    void delete(EventDto event);

    void addParticipant(Long id, UserDto user);

    void deleteParticipant(Long id, UserDto userDto);
}

