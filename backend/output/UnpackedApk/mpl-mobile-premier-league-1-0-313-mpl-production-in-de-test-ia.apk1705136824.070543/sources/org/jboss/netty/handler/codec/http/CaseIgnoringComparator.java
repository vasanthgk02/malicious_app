package org.jboss.netty.handler.codec.http;

import java.io.Serializable;
import java.util.Comparator;

public final class CaseIgnoringComparator implements Comparator<String>, Serializable {
    public static final CaseIgnoringComparator INSTANCE = new CaseIgnoringComparator();
    public static final long serialVersionUID = 4582133183775373862L;

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(String str, String str2) {
        return str.compareToIgnoreCase(str2);
    }
}
