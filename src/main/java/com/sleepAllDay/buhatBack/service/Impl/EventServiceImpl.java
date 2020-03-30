package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.dto.EventDto;
import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.models.Event;
import com.sleepAllDay.buhatBack.models.User;
import com.sleepAllDay.buhatBack.repositories.EventRepository;
import com.sleepAllDay.buhatBack.repositories.UserRepository;
import com.sleepAllDay.buhatBack.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream()
                .map(EventDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto findById(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new EventDto(event);
    }

    @Override
    public void save(EventDto eventDto) {
        User creator = User.builder()
                .id(eventDto.getCreator().getId())
                .login(eventDto.getCreator().getLogin())
                .password(eventDto.getCreator().getPassword())
                .rate(eventDto.getCreator().getRate())
                .build();
        Bar bar = Bar.builder()
                .id(eventDto.getBar().getId())
                .name(eventDto.getBar().getName())
                .address(eventDto.getBar().getAddress())
                .averagePrice(eventDto.getBar().getAveragePrice())
                .description(eventDto.getBar().getDescription())
                .imageUrl(eventDto.getBar().getImageUrl())
                .build();
        Event event = Event.builder()
                .id(eventDto.getId())
                .bar(bar)
                .description(eventDto.getDescription())
                .imageUrl(eventDto.getImageUrl())
                .name(eventDto.getName())
                .creator(creator)
                .build();
        eventRepository.save(event);
    }

    @Override
    public void delete(EventDto eventDto) {
        User creator = User.builder()
                .id(eventDto.getCreator().getId())
                .login(eventDto.getCreator().getLogin())
                .password(eventDto.getCreator().getPassword())
                .rate(eventDto.getCreator().getRate())
                .build();
        Bar bar = Bar.builder()
                .id(eventDto.getBar().getId())
                .name(eventDto.getBar().getName())
                .address(eventDto.getBar().getAddress())
                .averagePrice(eventDto.getBar().getAveragePrice())
                .description(eventDto.getBar().getDescription())
                .imageUrl(eventDto.getBar().getImageUrl())
                .build();
        Event event = Event.builder()
                .id(eventDto.getId())
                .bar(bar)
                .description(eventDto.getDescription())
                .imageUrl(eventDto.getImageUrl())
                .name(eventDto.getName())
                .creator(creator)
                .build();
        eventRepository.delete(event);
    }

    @Override
    public void addParticipant(Long id, UserDto userDto) {
        Event event = eventRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        User user = User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .rate(userDto.getRate())
                .build();
        List<User> participants = event.getParticipant();
        participants.add(user);
        event.setParticipant(participants);
        eventRepository.save(event);
    }

    @Override
    public void deleteParticipant(Long id, UserDto userDto) {
        Event event = eventRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        User user = User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .rate(userDto.getRate())
                .build();
        List<User> participants = event.getParticipant();
        participants.remove(user);
        eventRepository.save(event);
    }

}
