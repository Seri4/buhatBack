package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.dto.BarDto;
import com.sleepAllDay.buhatBack.models.Bar;
import com.sleepAllDay.buhatBack.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class BarController {

    private final BarService barService;

    public BarController(BarService barService) {
        this.barService = barService;
    }

    @GetMapping("/bars")
    public ResponseEntity<List<BarDto>> getBars() {
        return new ResponseEntity<List<BarDto>>(barService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bar")
    public ResponseEntity<BarDto> getBarById(@RequestParam("id") Long id) {
        if (Objects.nonNull(id)) {
            return new ResponseEntity<BarDto>(barService.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/bars/add")
    public void addBar(@RequestBody BarDto barDto) {
        barService.save(barDto);
    }

    @PutMapping("/bars/update")
    public void updateBar(@RequestBody BarDto barDto) {
        barService.save(barDto);
    }

    @DeleteMapping("/bars/delete")
    public void delete(@RequestBody BarDto barDto) {
        barService.delete(barDto);
    }

}
