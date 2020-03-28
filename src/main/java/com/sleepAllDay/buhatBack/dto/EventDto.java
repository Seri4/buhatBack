package com.sleepAllDay.buhatBack.dto;

import com.sleepAllDay.buhatBack.models.Event;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class EventDto {
    private Long id;
    private String name;//название
    private BarDto bar;//ссылка на бар
    private Long countPeople;// кол-во участников
    private String description;// описание
    private UserDto creator; //создатель эвента
    private String imageUrl;

    public EventDto() {
    }
}
