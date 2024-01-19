package org.apache.pdfbox.filter;

import java.io.IOException;

public class MissingImageReaderException extends IOException {
    public static final long serialVersionUID = 1;

    public MissingImageReaderException(String str) {
        super(str);
    }
}
