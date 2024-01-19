package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: ImplicitClassReceiver.kt */
public class ImplicitClassReceiver implements ReceiverValue, ThisClassReceiver {
    public final ClassDescriptor classDescriptor;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor2, ImplicitClassReceiver implicitClassReceiver) {
        Intrinsics.checkNotNullParameter(classDescriptor2, "classDescriptor");
        this.classDescriptor = classDescriptor2;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor2 = this.classDescriptor;
        ClassDescriptor classDescriptor3 = null;
        ImplicitClassReceiver implicitClassReceiver = obj instanceof ImplicitClassReceiver ? (ImplicitClassReceiver) obj : null;
        if (implicitClassReceiver != null) {
            classDescriptor3 = implicitClassReceiver.classDescriptor;
        }
        return Intrinsics.areEqual(classDescriptor2, classDescriptor3);
    }

    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    public KotlinType getType() {
        SimpleType defaultType = this.classDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Class{");
        SimpleType defaultType = this.classDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        outline73.append(defaultType);
        outline73.append('}');
        return outline73.toString();
    }
}
