package com.sleepAllDay.buhatBack.dto;

import com.sleepAllDay.buhatBack.models.Event;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private Long id;
    private String name;//название
    private BarDto bar;//ссылка на бар
    private Long countPeople;// кол-во участников
    private String description;// описание
    private UserDto creator; //создатель эвента
    private String imageUrl;

    public EventDto(Event item) {
        this.id = item.getId();
        this.name = item.getName();
        this.bar = new BarDto(item.getBar());
        this.countPeople = (long) item.getParticipant().size();
        this.description = item.getDescription();
        this.creator = new UserDto(item.getCreator());
        this.imageUrl = item.getImageUrl();
    }
}
