package com.sleepAllDay.buhatBack.mapper;

import com.sleepAllDay.buhatBack.dto.UserDto;
import com.sleepAllDay.buhatBack.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserDto userToUserDto(User user);
}
