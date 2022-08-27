package com.evilduck.french.verbinator.entity;

import com.evilduck.french.verbinator.verb.VerbType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Verb {

    private String english;
    private String french;
    private VerbType type;

}
