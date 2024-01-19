package org.jdom.input;

import org.jdom.Document;
import org.jdom.JDOMException;

public class JDOMParseException extends JDOMException {
    public JDOMParseException(String str, Throwable th, Document document) {
        super(str, th);
    }
}
