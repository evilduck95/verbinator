package com.evilduck.french.verbinator.verb;

import com.evilduck.french.verbinator.entity.Verb;
import com.evilduck.french.verbinator.utils.CsvLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class VerbsService {

    private final String verbsDir;
    private final CsvLoader csvLoader;

    public VerbsService(@Value("${verbs.dir}") final String verbsDir,
                        final CsvLoader csvLoader) {
        this.verbsDir = verbsDir;
        this.csvLoader = csvLoader;
    }

    @PostConstruct
    public List<Verb> getVerbs() throws IOException {
        return csvLoader.beanifyCsv(verbsDir + "/verbs.csv", Verb.class);
    }

}
