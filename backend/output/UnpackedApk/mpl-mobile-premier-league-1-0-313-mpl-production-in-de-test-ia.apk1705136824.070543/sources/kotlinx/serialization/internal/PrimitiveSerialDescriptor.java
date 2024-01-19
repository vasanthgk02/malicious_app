package kotlinx.serialization.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Primitives.kt */
public final class PrimitiveSerialDescriptor implements SerialDescriptor {
    public final PrimitiveKind kind;
    public final String serialName;

    public PrimitiveSerialDescriptor(String str, PrimitiveKind primitiveKind) {
        Intrinsics.checkNotNullParameter(str, "serialName");
        Intrinsics.checkNotNullParameter(primitiveKind, "kind");
        this.serialName = str;
        this.kind = primitiveKind;
    }

    public final Void error() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public List<Annotation> getAnnotations() {
        return TypeUtilsKt.getAnnotations(this);
    }

    public List<Annotation> getElementAnnotations(int i) {
        error();
        throw null;
    }

    public SerialDescriptor getElementDescriptor(int i) {
        error();
        throw null;
    }

    public int getElementIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        error();
        throw null;
    }

    public String getElementName(int i) {
        error();
        throw null;
    }

    public int getElementsCount() {
        return 0;
    }

    public SerialKind getKind() {
        return this.kind;
    }

    public String getSerialName() {
        return this.serialName;
    }

    public boolean isElementOptional(int i) {
        error();
        throw null;
    }

    public boolean isInline() {
        TypeUtilsKt.isInline(this);
        return false;
    }

    public boolean isNullable() {
        TypeUtilsKt.isNullable(this);
        return false;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("PrimitiveDescriptor("), this.serialName, ')');
    }
}
