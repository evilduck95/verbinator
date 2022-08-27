package com.evilduck.french.verbinator.utils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CsvLoader {

    public <T> List<T> beanifyCsv(final String path, final Class<T> beanType) {
        if (path.endsWith(".csv")) {
            final BufferedReader reader;
            try {
                reader = new BufferedReader(
                        new FileReader(
                                new ClassPathResource(path).getFile()
                        )
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            final CsvToBean<T> csvToBeanReader = new CsvToBeanBuilder<T>(reader)
                    .withType(beanType)
                    .build();
            return csvToBeanReader.parse();
        } else throw new IllegalArgumentException("Non-CSV file passed and cannot be beanified by this method!");
    }

}
