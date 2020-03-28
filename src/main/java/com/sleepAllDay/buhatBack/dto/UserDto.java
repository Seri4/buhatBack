package com.sleepAllDay.buhatBack.dto;

import com.sleepAllDay.buhatBack.models.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private Double rate;

    public UserDto() {
    }
}
