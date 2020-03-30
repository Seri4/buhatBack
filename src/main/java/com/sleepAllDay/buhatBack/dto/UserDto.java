package com.sleepAllDay.buhatBack.dto;

import com.sleepAllDay.buhatBack.models.User;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String login;
    private String password;
    private Double rate;

    public UserDto(User item) {
        this.id = item.getId();
        this.login = item.getLogin();
        this.password = item.getPassword();
        this.rate = item.getRate();
    }
}
