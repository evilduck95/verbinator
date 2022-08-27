package com.evilduck.french.verbinator;

import com.evilduck.french.verbinator.verb.VerbType;
import lombok.Data;

@Data
public class Verb {

    private String english;
    private String french;
    private VerbType type;

}
