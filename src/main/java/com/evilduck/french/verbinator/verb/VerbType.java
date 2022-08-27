package com.evilduck.french.verbinator.verb;

public enum VerbType {

    ER("er"),
    RE("re"),
    IR("ir");


    VerbType(final String suffix) {
        this.suffix = suffix;
    }

    private String suffix;

    @Override
    public String toString() {
        return suffix;
    }
}
