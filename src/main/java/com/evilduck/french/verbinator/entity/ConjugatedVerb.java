package com.evilduck.french.verbinator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConjugatedVerb {

    private String subject;
    private String verb;

}
