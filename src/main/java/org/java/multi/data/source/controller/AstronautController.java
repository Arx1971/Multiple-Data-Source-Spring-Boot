package org.java.multi.data.source.controller;

import org.java.multi.data.source.nasa.service.AstronautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/astronaut")
@Controller
public class AstronautController {

    private final AstronautService astronautService;

    @Autowired
    public AstronautController(AstronautService astronautService) {
        this.astronautService = astronautService;
    }

    @RequestMapping(value = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String getActorList(Model model) {
        model.addAttribute("astronauts", astronautService.findAll());
        return "astronaut/index";
    }

}
