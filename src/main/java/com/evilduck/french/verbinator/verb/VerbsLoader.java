package com.evilduck.french.verbinator.verb;

import com.evilduck.french.verbinator.entity.Verb;
import com.evilduck.french.verbinator.utils.CsvLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class VerbsLoader {

    private final String verbsDir;
    private final CsvLoader csvLoader;

    public VerbsLoader(@Value("${verbs.dir}") final String verbsDir,
                       final CsvLoader csvLoader) {
        this.verbsDir = verbsDir;
        this.csvLoader = csvLoader;
    }

    @Bean
    public List<Verb> verbs() throws IOException {
        return csvLoader.beanifyCsv(verbsDir + "/verbs.csv", Verb.class).stream()
                .map(v -> v.toBuilder()
                        .english(String.format("to %s", v.getEnglish()))
                        .build())
                .collect(toList());
    }

}
