package io.sentry;

import java.util.ArrayList;
import java.util.List;

public final class SentryValues<T> {
    public final List<T> values;

    public SentryValues(List<T> list) {
        this.values = new ArrayList(list == null ? new ArrayList<>(0) : list);
    }

    public List<T> getValues() {
        return this.values;
    }
}
