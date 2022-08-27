package com.evilduck.french.verbinator.converter;

import com.evilduck.french.verbinator.conjugation.Tense;
import org.springframework.core.convert.converter.Converter;

public class StringToTenseConverter implements Converter<String, Tense> {

    @Override
    public Tense convert(final String source) {
        return Tense.valueOf(source.toUpperCase());
    }

}
