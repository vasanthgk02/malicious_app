package com.facebook.react.common;

import java.nio.charset.Charset;
import org.apache.commons.lang.CharEncoding;

public class StandardCharsets {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    static {
        Charset.forName("UTF-16");
        Charset.forName(CharEncoding.UTF_16BE);
        Charset.forName(CharEncoding.UTF_16LE);
    }
}
