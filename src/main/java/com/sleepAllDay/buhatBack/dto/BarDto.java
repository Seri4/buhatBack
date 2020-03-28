package com.sleepAllDay.buhatBack.dto;

import com.sleepAllDay.buhatBack.models.Bar;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class BarDto {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String imageUrl;
    private Double averagePrice;

    public BarDto() {
    }
}
