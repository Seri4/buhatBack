package com.sleepAllDay.buhatBack.service;

import com.sleepAllDay.buhatBack.models.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAll();

    Optional<Event> findById(Long id);

    void save(Event event);

    void delete(Event event);

    void deleteById(Long id);
}

