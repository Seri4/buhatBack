package com.sleepAllDay.buhatBack.mapper;

import com.sleepAllDay.buhatBack.dto.EventDto;
import com.sleepAllDay.buhatBack.models.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(source = "participant", target = "countPeople")
    EventDto mapEventToEventDto(Event event);
}
