package com.evilduck.french.verbinator.conjugation;

public enum Tense {

    PAST("past"),

    IMPERFECT("imperfect"),
    PRESENT("present"),
    FUTURE("future");


    Tense(final String type) {
        this.type = type;
    }

    private final String type;

    @Override
    public String toString() {
        return type;
    }
}
