package com.evilduck.french.verbinator.conjugation;

import com.evilduck.french.verbinator.entity.Conjugation;
import com.evilduck.french.verbinator.utils.CsvLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConjugationsLoader {

    private final CsvLoader csvLoader;
    private final String conjugationsDir;

    public ConjugationsLoader(final CsvLoader csvLoader,
                               @Value("${conjugations.dir}") final String conjugationsDir) {
        this.csvLoader = csvLoader;
        this.conjugationsDir = conjugationsDir;
    }

    @Bean
    public List<Conjugation> erConjugations() {
        return csvLoader.beanifyCsv(getFilePathFor("er"), Conjugation.class);
    }

    @Bean
    public List<Conjugation> reConjugations() {
        return csvLoader.beanifyCsv(getFilePathFor("re"), Conjugation.class);
    }

    @Bean
    public List<Conjugation> irConjugations() {
        return csvLoader.beanifyCsv(getFilePathFor("ir"), Conjugation.class);
    }


    private String getFilePathFor(final String suffix) {
        return String.format("%s/conjugations_%s.csv", conjugationsDir, suffix);
    }

}
