package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.mpl.androidapp.utils.Constant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnotationUseSiteTarget.kt */
public enum AnnotationUseSiteTarget {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER(Constant.GET),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    public final String renderName;

    /* access modifiers changed from: public */
    AnnotationUseSiteTarget(String str) {
        if (str == null) {
            String name = name();
            if (name != null) {
                str = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        this.renderName = str;
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
