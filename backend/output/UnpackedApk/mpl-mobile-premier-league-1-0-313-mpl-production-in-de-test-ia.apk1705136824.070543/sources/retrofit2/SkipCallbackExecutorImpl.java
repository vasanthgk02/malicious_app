package retrofit2;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.lang.annotation.Annotation;

public final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    public static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline36(SkipCallbackExecutor.class, GeneratedOutlineSupport.outline73(ColorPropConverter.PREFIX_RESOURCE), "()");
    }
}
