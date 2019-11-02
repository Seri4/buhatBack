package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/bars/add/{address}/{description}/{image_url}/{name}")
    public Bar addBar(@PathVariable String address, @PathVariable String description,
                      @PathVariable String image_url, @PathVariable String name) {
        return barService.save(new Bar(name, description, address, image_url));
    }

    @PutMapping("/bars/update/{id}/{address}/{description}/{image_url}/{name}")
    public void updateBar(@PathVariable Long id, @PathVariable String address,
                          @PathVariable String description, @PathVariable String image_url,
                          @PathVariable String name) {
        Bar bar = barService.findById(id).get();

        bar.setName(name);
        bar.setImageUrl(image_url);
        bar.setDescription(description);
        bar.setAddress(address);

        barService.save(bar);
    }
}
