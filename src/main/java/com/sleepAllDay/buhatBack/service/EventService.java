package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAll();

    Optional<Event> findById(Long id);

    void save(Event event);

    void delete(Event event);

    void deleteById(Long id);

    void addParticipant(Long id, Long userId);

    void deleteParticipant(Long id, Long userId);
}

