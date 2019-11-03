package com.sleepAllDay.buhatBack.controller;

import com.sleepAllDay.buhatBack.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("events", eventService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
