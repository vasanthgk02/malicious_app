package org.apache.pdfbox.exceptions;

public class CryptographyException extends Exception {
    public Exception embedded;

    public CryptographyException(String str) {
        super(str);
    }

    private void setEmbedded(Exception exc) {
        this.embedded = exc;
    }

    public Exception getEmbedded() {
        return this.embedded;
    }

    public CryptographyException(Exception exc) {
        super(exc.getMessage());
        setEmbedded(exc);
    }
}
