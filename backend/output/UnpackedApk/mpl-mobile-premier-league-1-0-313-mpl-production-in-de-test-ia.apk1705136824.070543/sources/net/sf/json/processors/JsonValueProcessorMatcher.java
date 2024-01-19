package net.sf.json.processors;

import java.util.Set;

public abstract class JsonValueProcessorMatcher {
    public static final JsonValueProcessorMatcher DEFAULT = new DefaultJsonValueProcessorMatcher(null);

    public static final class DefaultJsonValueProcessorMatcher extends JsonValueProcessorMatcher {
        public DefaultJsonValueProcessorMatcher(AnonymousClass1 r1) {
        }

        public Object getMatch(Class cls, Set set) {
            if (cls == null || set == null || !set.contains(cls)) {
                return null;
            }
            return cls;
        }
    }

    public abstract Object getMatch(Class cls, Set set);
}
