package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.dto.EventDto;
import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.service.BarService;
import com.sleepAllDay.buhatBack.service.EventService;
import com.sleepAllDay.buhatBack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return new ResponseEntity<List<EventDto>>(eventService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/event")
    public ResponseEntity<EventDto> getEventById(@RequestParam("id") Long id) {
        return new ResponseEntity<EventDto>(eventService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/events/add")
    public void addEvent(@RequestBody EventDto eventDto){
        eventService.save(eventDto);
    }


    @PutMapping("/events/add/{id}")
    public void addParticipant(@PathVariable Long id, @RequestBody UserDto participant) {
        eventService.addParticipant(id, participant);
    }

    @PutMapping("/events/{id}/delete_participant/")
    public void deleteParticipant(@PathVariable Long id, @RequestBody UserDto participant) {
        eventService.deleteParticipant(id, participant);
    }

    @PutMapping("/events/update")
    public void updateEvent(@RequestBody EventDto eventDto) {
        eventService.save(eventDto);
    }

    @DeleteMapping("/events/delete")
    public void delete(@RequestBody EventDto eventDto) {
        eventService.delete(eventDto);
    }

}
