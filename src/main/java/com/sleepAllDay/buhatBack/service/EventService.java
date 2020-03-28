package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.dto.EventDto;
import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<EventDto> findAll();

    EventDto findById(Long id);

    void save(EventDto event);

    void delete(EventDto event);

    void deleteById(Long id);

    void addParticipant(Long id, Long userId);

    void deleteParticipant(Long id, Long userId);
}

