package com.sleepAllDay.buhatBack.dto;

import com.sleepAllDay.buhatBack.models.Bar;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String imageUrl;
    private Double averagePrice;

    public BarDto(Bar item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.address = item.getAddress();
        this.imageUrl = item.getImageUrl();
        this.averagePrice = item.getAveragePrice();
    }
}
