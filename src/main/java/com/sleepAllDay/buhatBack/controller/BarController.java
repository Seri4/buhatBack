package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BarController {

    @Autowired
    private BarService barService;

    @GetMapping("/bars")
    public List<Bar> getBars() {
        return barService.findAll();
    }

    @GetMapping("/bars/{id}")
    public Optional<Bar> getBarById(@PathVariable Long id) {
        return barService.findById(id);
    }

    @GetMapping("/bars/delete/{id}")
    public List<Bar> deleteBar(@PathVariable Long id) {
        barService.deleteById(id);
        return barService.findAll();
    }

    @PostMapping("/bars/add")
    public void addBar(@RequestBody Bar bar) {
        barService.save(bar);
    }

    @PutMapping("/bars/update/{id}")
    public void updateBar(@RequestBody Bar newBar, @PathVariable Long id) {
        Bar bar =  barService.findById(id).get();

        bar.setName(newBar.getName());
        bar.setImageUrl(newBar.getImageUrl());
        bar.setDescription(newBar.getDescription());
        bar.setAddress(newBar.getAddress());

        barService.save(bar);
    }
}
