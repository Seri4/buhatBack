package com.sleepAllDay.buhatBack.mapper;

import com.sleepAllDay.buhatBack.dto.BarDto;
import com.sleepAllDay.buhatBack.models.Bar;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BarMapper {

    BarMapper INSTANCE = Mappers.getMapper(BarMapper.class);

    BarDto mapBarToBarDto(Bar bar);
}
