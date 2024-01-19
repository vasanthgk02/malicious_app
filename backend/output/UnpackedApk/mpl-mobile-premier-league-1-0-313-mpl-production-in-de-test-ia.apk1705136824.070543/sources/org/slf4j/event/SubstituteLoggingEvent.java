package org.slf4j.event;

import org.slf4j.helpers.SubstituteLogger;

public class SubstituteLoggingEvent implements LoggingEvent {
    public Object[] argArray;
    public SubstituteLogger logger;
}
