package com.evilduck.french.verbinator.conjugation;

public enum ConjugationType {

    IMPERFECT("imperfect"),
    PRESENT("present"),
    FUTURE("future");


    ConjugationType(final String type) {
        this.type = type;
    }

    private String type;

    @Override
    public String toString() {
        return type;
    }
}
