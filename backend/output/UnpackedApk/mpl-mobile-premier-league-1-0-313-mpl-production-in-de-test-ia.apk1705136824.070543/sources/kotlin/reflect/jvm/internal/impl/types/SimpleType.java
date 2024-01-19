package kotlin.reflect.jvm.internal.impl.types;

import com.facebook.react.bridge.ColorPropConverter;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;

/* compiled from: KotlinType.kt */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    public SimpleType() {
        super(null);
    }

    public abstract SimpleType makeNullableAsSpecified(boolean z);

    public abstract SimpleType replaceAnnotations(Annotations annotations);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (AnnotationDescriptor renderAnnotation$default : getAnnotations()) {
            String[] strArr = {"[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, renderAnnotation$default, null, 2, null), "] "};
            Intrinsics.checkNotNullParameter(sb, "<this>");
            Intrinsics.checkNotNullParameter(strArr, HSLCriteriaBuilder.VALUE);
            for (int i = 0; i < 3; i++) {
                sb.append(strArr[i]);
            }
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            ArraysKt___ArraysJvmKt.joinTo$default(getArguments(), sb, ", ", "<", ">", 0, null, null, 112);
        }
        if (isMarkedNullable()) {
            sb.append(ColorPropConverter.PREFIX_ATTR);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
