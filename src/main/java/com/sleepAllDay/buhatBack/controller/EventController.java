package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.findById(id).get();
    }

    @PostMapping("/events/add")
    public void addEvent(@RequestBody Event event) {
        eventService.save(event);
    }

    @PutMapping("/events/update/{id}")
    public void updateEvent(@RequestBody Event newEvent, @PathVariable Long id) {
        Event event = eventService.findById(id).get();
        event.setAddress(newEvent.getAddress());
        event.setBar(newEvent.getBar());
        event.setCreator(newEvent.getCreator());
        event.setDescription(newEvent.getDescription());
        event.setName(newEvent.getName());
        event.setParticipant(newEvent.getParticipant());
        eventService.save(event);
    }

    @DeleteMapping("/events/delete/{id}")
    public void delete(@PathVariable Long id){
        eventService.deleteById(id);
    }

}
