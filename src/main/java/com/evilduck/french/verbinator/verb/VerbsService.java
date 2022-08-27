package com.evilduck.french.verbinator.verb;

import com.evilduck.french.verbinator.entity.Verb;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class VerbsService {

    private final List<Verb> verbs;

    public VerbsService(final List<Verb> verbs) {
        this.verbs = verbs;
    }

    public Optional<Verb> find(final String givenVerb) {
        return verbs.stream().filter(
                        v -> v.getEnglish().toLowerCase().endsWith(givenVerb.toLowerCase()) || v.getFrench().equalsIgnoreCase(givenVerb))
                .findFirst();
    }

    public List<Verb> getAllVerbs() {
        return verbs;
    }

    public List<String> getEnglishVerbs() {
        return getVerbsComponent(Verb::getEnglish);
    }

    public List<String> getFrenchVerbs() {
        return getVerbsComponent(Verb::getFrench);
    }

    private List<String> getVerbsComponent(final Function<Verb, String> callback) {
        return verbs.stream().map(callback).collect(toList());
    }

}
