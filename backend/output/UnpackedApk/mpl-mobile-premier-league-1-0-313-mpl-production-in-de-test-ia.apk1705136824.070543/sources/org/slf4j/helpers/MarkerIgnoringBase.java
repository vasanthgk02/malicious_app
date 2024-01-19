package org.slf4j.helpers;

import org.slf4j.Logger;

public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    public static final long serialVersionUID = 9044267456635152283L;

    public String toString() {
        return getClass().getName() + "(" + "NOP" + ")";
    }
}
