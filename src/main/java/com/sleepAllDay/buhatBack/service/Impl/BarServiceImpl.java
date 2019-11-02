package com.sleepAllDay.buhatBack.service.Impl;

import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.repositories.BarRepository;
import com.sleepAllDay.buhatBack.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarServiceImpl implements BarService {

    @Autowired
    private BarRepository barRepository;

    @Override
    public List<Bar> findAll() {
        return barRepository.findAll();
    }

    @Override
    public Optional<Bar> findById(Long id) {
        return barRepository.findById(id);
    }

    @Override
    public void save(Bar bar) {
        barRepository.save(bar);
    }

    @Override
    public void save(Long id){
        barRepository.save(barRepository.getOne(id));
    }

    @Override
    public void delete(Bar bar) {
        barRepository.delete(bar);
    }

    @Override
    public void delete(Long id) {
        barRepository.deleteById(id);
    }
}
