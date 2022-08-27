package com.evilduck.french.verbinator.domain;

import com.evilduck.french.verbinator.conjugation.Tense;
import com.evilduck.french.verbinator.entity.ConjugatedVerb;
import com.evilduck.french.verbinator.entity.Verb;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ConjugationResponse {

    private Verb verb;
    private Tense tense;
    private List<ConjugatedVerb> conjugations;

}
