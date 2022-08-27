package com.evilduck.french.verbinator.exception;

public class VerbNotFoundException extends IllegalArgumentException {
    public VerbNotFoundException(final String s) {
        super(s);
    }
}
