package org.apache.pdfbox.exceptions;

public class WrappedException extends Exception {
    public WrappedException(Exception exc) {
        super(exc);
    }
}
