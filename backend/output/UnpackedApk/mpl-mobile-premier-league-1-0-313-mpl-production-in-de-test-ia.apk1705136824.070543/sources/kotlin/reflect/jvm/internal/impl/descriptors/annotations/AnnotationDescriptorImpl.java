package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class AnnotationDescriptorImpl implements AnnotationDescriptor {
    public final KotlinType annotationType;
    public final SourceElement source;
    public final Map<Name, ConstantValue<?>> valueArguments;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 4 || i == 5) ? 2 : 3)];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (!(i == 3 || i == 4 || i == 5)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        throw ((i == 3 || i == 4 || i == 5) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public AnnotationDescriptorImpl(KotlinType kotlinType, Map<Name, ConstantValue<?>> map, SourceElement sourceElement) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
            throw null;
        } else if (map == null) {
            $$$reportNull$$$0(1);
            throw null;
        } else if (sourceElement != null) {
            this.annotationType = kotlinType;
            this.valueArguments = map;
            this.source = sourceElement;
        } else {
            $$$reportNull$$$0(2);
            throw null;
        }
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        Map<Name, ConstantValue<?>> map = this.valueArguments;
        if (map != null) {
            return map;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public FqName getFqName() {
        return TweetUtils.getFqName(this);
    }

    public SourceElement getSource() {
        SourceElement sourceElement = this.source;
        if (sourceElement != null) {
            return sourceElement;
        }
        $$$reportNull$$$0(5);
        throw null;
    }

    public KotlinType getType() {
        KotlinType kotlinType = this.annotationType;
        if (kotlinType != null) {
            return kotlinType;
        }
        $$$reportNull$$$0(3);
        throw null;
    }

    public String toString() {
        return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, null);
    }
}
