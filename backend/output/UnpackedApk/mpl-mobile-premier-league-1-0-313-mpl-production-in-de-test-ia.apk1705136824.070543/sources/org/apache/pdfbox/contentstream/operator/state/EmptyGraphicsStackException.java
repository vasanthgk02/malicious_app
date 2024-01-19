package org.apache.pdfbox.contentstream.operator.state;

import java.io.IOException;

public final class EmptyGraphicsStackException extends IOException {
    public static final long serialVersionUID = 1;

    public EmptyGraphicsStackException() {
        super("Cannot execute restore, the graphics stack is empty");
    }
}
