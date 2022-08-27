package com.evilduck.french.verbinator.controller;

import com.evilduck.french.verbinator.entity.Verb;
import com.evilduck.french.verbinator.verb.VerbsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/verbs")
public class VerbController {

    private final VerbsService verbsService;

    public VerbController(final VerbsService verbsService) {
        this.verbsService = verbsService;
    }

    @GetMapping("/all")
    public List<Verb> getAllVerbs() {
        return verbsService.getAllVerbs();
    }

    @GetMapping("/english")
    public List<String> getEnglishVerbs() {
        return verbsService.getEnglishVerbs();
    }

    @GetMapping("/french")
    public List<String> getFrenchVerbs() {
        return verbsService.getFrenchVerbs();
    }

}
