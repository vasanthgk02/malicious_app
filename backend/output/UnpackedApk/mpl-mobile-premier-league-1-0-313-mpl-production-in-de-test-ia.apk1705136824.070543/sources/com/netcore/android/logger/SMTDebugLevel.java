package com.netcore.android.logger;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SMTDebugLevel {

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
        public static final int DEBUG = 2;
        public static final int ERROR = 5;
        public static final int FATAL = 6;
        public static final int INFO = 3;
        public static final int NONE = 7;
        public static final int VERBOSE = 1;
        public static final int WARN = 4;
    }
}
