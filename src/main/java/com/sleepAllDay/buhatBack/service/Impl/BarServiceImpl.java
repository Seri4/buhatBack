package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.dto.BarDto;
import com.sleepAllDay.buhatBack.mapper.BarMapper;
import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.repositories.BarRepository;
import com.sleepAllDay.buhatBack.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarServiceImpl implements BarService {

    @Autowired
    private BarRepository barRepository;

    @Override
    public List<BarDto> findAll() {
        return barRepository.findAll().stream()
                .map(BarMapper.INSTANCE::mapBarToBarDto)
                .collect(Collectors.toList());
    }

    @Override
    public BarDto findById(Long id) {
        Bar currentBar = barRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return BarMapper.INSTANCE.mapBarToBarDto(currentBar);
    }

    @Override
    public void save(BarDto barDto) {
        Bar bar = Bar.builder()
                .id(barDto.getId())
                .name(barDto.getName())
                .description(barDto.getDescription())
                .imageUrl(barDto.getImageUrl())
                .averagePrice(barDto.getAveragePrice())
                .address(barDto.getAddress())
                .build();
        barRepository.save(bar);
    }

    @Override
    public void delete(BarDto barDto) {
        Bar bar = Bar.builder()
                .id(barDto.getId())
                .name(barDto.getName())
                .description(barDto.getDescription())
                .imageUrl(barDto.getImageUrl())
                .averagePrice(barDto.getAveragePrice())
                .address(barDto.getAddress())
                .build();
        barRepository.delete(bar);
    }

    @Override
    public void deleteById(Long id) {
        barRepository.deleteById(id);
    }
}
