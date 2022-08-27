package com.evilduck.french.verbinator;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Conjugation {

    @CsvBindByName
    private String imperfect;

    @CsvBindByName
    private String present;

    @CsvBindByName
    private String future;

}
