package com.firebase.jobdispatcher;

import java.util.List;

public class JobTrigger {

    public static final class ContentUriTrigger extends JobTrigger {
        public final List<ObservedUri> uris;

        public ContentUriTrigger(List<ObservedUri> list) {
            this.uris = list;
        }
    }

    public static final class ExecutionWindowTrigger extends JobTrigger {
        public final int windowEnd;
        public final int windowStart;

        public ExecutionWindowTrigger(int i, int i2) {
            this.windowStart = i;
            this.windowEnd = i2;
        }
    }

    public static final class ImmediateTrigger extends JobTrigger {
    }
}
