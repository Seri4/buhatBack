package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.repositories.EventRepository;
import com.sleepAllDay.buhatBack.repositories.UserRepository;
import com.sleepAllDay.buhatBack.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public void addParticipant(Long id, Long userId) {
        Event event = eventRepository.findById(id).get();
        User user = userRepository.findById(userId).get();
        event.addParticipant(user);
        eventRepository.save(event);
    }

    @Override
    public void deleteParticipant(Long id, Long userId) {
        Event event = eventRepository.findById(id).get();
        User user = userRepository.findById(userId).get();
        event.deleteParticipant(user);
        eventRepository.save(event);
    }

}
