package kotlinx.serialization.descriptors;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001f\u001a\u00020\fH\u0001J\u0011\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\fH\u0001J\u0011\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0018H\u0001J\u0011\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\fH\u0001J\b\u0010$\u001a\u00020\fH\u0016J\u0011\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\fH\u0001J\b\u0010&\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ContextAware.kt */
public final class ContextDescriptor implements SerialDescriptor {
    public final KClass<?> kClass;
    public final SerialDescriptor original;
    public final String serialName = (this.original.getSerialName() + '<' + this.kClass.getSimpleName() + '>');

    public ContextDescriptor(SerialDescriptor serialDescriptor, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "original");
        Intrinsics.checkNotNullParameter(kClass2, "kClass");
        this.original = serialDescriptor;
        this.kClass = kClass2;
    }

    public boolean equals(Object obj) {
        ContextDescriptor contextDescriptor = obj instanceof ContextDescriptor ? (ContextDescriptor) obj : null;
        boolean z = false;
        if (contextDescriptor == null) {
            return false;
        }
        if (Intrinsics.areEqual(this.original, contextDescriptor.original) && Intrinsics.areEqual(contextDescriptor.kClass, this.kClass)) {
            z = true;
        }
        return z;
    }

    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    public List<Annotation> getElementAnnotations(int i) {
        return this.original.getElementAnnotations(i);
    }

    public SerialDescriptor getElementDescriptor(int i) {
        return this.original.getElementDescriptor(i);
    }

    public int getElementIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.original.getElementIndex(str);
    }

    public String getElementName(int i) {
        return this.original.getElementName(i);
    }

    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    public SerialKind getKind() {
        return this.original.getKind();
    }

    public String getSerialName() {
        return this.serialName;
    }

    public int hashCode() {
        return this.serialName.hashCode() + (this.kClass.hashCode() * 31);
    }

    public boolean isElementOptional(int i) {
        return this.original.isElementOptional(i);
    }

    public boolean isInline() {
        return this.original.isInline();
    }

    public boolean isNullable() {
        return this.original.isNullable();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ContextDescriptor(kClass: ");
        outline73.append(this.kClass);
        outline73.append(", original: ");
        outline73.append(this.original);
        outline73.append(')');
        return outline73.toString();
    }
}
