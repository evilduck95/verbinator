package com.evilduck.french.verbinator.conjugation;

import com.evilduck.french.verbinator.entity.ConjugatedVerb;
import com.evilduck.french.verbinator.entity.Conjugation;
import com.evilduck.french.verbinator.entity.Verb;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ConjugationsService {

    private final List<Conjugation> erConjugations;
    private final List<Conjugation> reConjugations;
    private final List<Conjugation> irConjugations;

    public ConjugationsService(final List<Conjugation> erConjugations,
                               final List<Conjugation> reConjugations,
                               final List<Conjugation> irConjugations) {
        this.erConjugations = erConjugations;
        this.reConjugations = reConjugations;
        this.irConjugations = irConjugations;
    }

    public List<ConjugatedVerb> conjugationsFor(final Verb verb, final Tense tense) {
        switch (verb.getType()) {
            case ER:
                return conjugateByRule(erConjugations, verb, tense);
            case RE:
                return conjugateByRule(reConjugations, verb, tense);
            case IR:
                return conjugateByRule(irConjugations, verb, tense);
            default:
                return Collections.emptyList();
        }
    }

    private List<ConjugatedVerb> conjugateByRule(final List<Conjugation> erConjugations, final Verb verb, final Tense tense) {
        return erConjugations.stream()
                .map(c -> new ConjugatedVerb(c.getSubject(), conjugateVerbForTense(verb, tense, c)))
                .collect(toList());
    }

    private String conjugateVerbForTense(final Verb verb, final Tense tense, final Conjugation c) {
        return verb.getFrench().replaceFirst(verb.getType() + "$", replacementFor(c, tense));
    }

    private String replacementFor(final Conjugation conjugation, final Tense tense) {
        switch(tense) {
            case PAST:
                return conjugation.getPast();
            case PRESENT:
                return conjugation.getPresent();
            case FUTURE:
                return conjugation.getFuture();
            default:
                return conjugation.getImperfect();
        }
    }


}
