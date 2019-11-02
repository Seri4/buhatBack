package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.repositories.EventRepository;
import com.sleepAllDay.buhatBack.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void save(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public void deleteById(Long id){
        eventRepository.deleteById(id);
    }
}
