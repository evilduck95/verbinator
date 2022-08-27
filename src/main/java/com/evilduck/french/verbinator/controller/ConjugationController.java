package com.evilduck.french.verbinator.controller;

import com.evilduck.french.verbinator.conjugation.ConjugationsService;
import com.evilduck.french.verbinator.conjugation.Tense;
import com.evilduck.french.verbinator.domain.ConjugationResponse;
import com.evilduck.french.verbinator.entity.ConjugatedVerb;
import com.evilduck.french.verbinator.entity.Verb;
import com.evilduck.french.verbinator.exception.VerbNotFoundException;
import com.evilduck.french.verbinator.verb.VerbsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ConjugationController {

    private final VerbsService verbsService;
    private final ConjugationsService conjugationsService;

    public ConjugationController(final VerbsService verbsService, final ConjugationsService conjugationsService) {
        this.verbsService = verbsService;
        this.conjugationsService = conjugationsService;
    }

    @GetMapping("/conjugate")
    public ConjugationResponse getConjugations(@RequestParam final String verb,
                                               @RequestParam final Tense tense) throws IllegalArgumentException {
        final Optional<Verb> foundVerb = verbsService.find(verb);
        if (foundVerb.isPresent()) {
            final Verb v = foundVerb.get();
            final List<ConjugatedVerb> conjugations = conjugationsService.conjugationsFor(v, tense);
            return new ConjugationResponse(
                    v,
                    tense,
                    conjugations
            );
        } else throw new VerbNotFoundException("Verb \"" + verb + "\" Not Found!");
    }

}
