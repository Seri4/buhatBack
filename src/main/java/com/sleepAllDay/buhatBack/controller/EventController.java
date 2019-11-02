package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.service.BarService;
import com.sleepAllDay.buhatBack.service.EventService;
import com.sleepAllDay.buhatBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private BarService barService;

    @Autowired
    private UserService userService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.findById(id).get();
    }

    @PostMapping("/events/add/{address}/{description}/{name}/{bar_id}/{creation_id}")
    public void addEvent(@PathVariable String address, @PathVariable String description,
                         @PathVariable String name, @PathVariable Long bar_id,
                         @PathVariable Long creation_id) {
        Bar bar = barService.findById(bar_id).get();
        User creator = userService.findById(creation_id).get();
        eventService.save(new Event(name, bar, address, description, creator));
    }


    @PutMapping("/events/add/{id}/{participant_id}")
    public void addParticipant(@PathVariable Long id, @PathVariable Long participant_id) {
        eventService.addParticipant(id, participant_id);
    }

    @PutMapping("/events/{id}/delete_participant/{participant_id}")
    public void deleteParticipant(@PathVariable Long id, @PathVariable Long participant_id) {
        eventService.deleteParticipant(id, participant_id);
    }

    @PutMapping("/events/update/{id}/{address}/{bar_id}/{creator_id}/{description}/{name}")
    public void updateEvent(@PathVariable Long id, @PathVariable String address,
                            @PathVariable Long bar_id, @PathVariable Long creator_id,
                            @PathVariable String description, @PathVariable String name) {
        Event event = eventService.findById(id).get();
        Bar bar = barService.findById(bar_id).get();
        User creator = userService.findById(creator_id).get();
        event.setAddress(address);
        event.setBar(bar);
        event.setCreator(creator);
        event.setDescription(description);
        event.setName(name);
        eventService.save(event);
    }

    @DeleteMapping("/events/delete/{id}")
    public void delete(@PathVariable Long id) {
        eventService.deleteById(id);
    }

}
