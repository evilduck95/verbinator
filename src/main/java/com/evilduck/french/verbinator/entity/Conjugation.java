package com.evilduck.french.verbinator.entity;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Conjugation {

    @CsvBindByName
    private String subject;

    @CsvBindByName
    private String past;

    @CsvBindByName
    private String imperfect;

    @CsvBindByName
    private String present;

    @CsvBindByName
    private String future;

}
