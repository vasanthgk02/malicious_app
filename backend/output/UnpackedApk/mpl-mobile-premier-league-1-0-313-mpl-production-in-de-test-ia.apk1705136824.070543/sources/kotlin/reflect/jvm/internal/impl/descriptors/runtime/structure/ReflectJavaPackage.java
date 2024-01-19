package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaPackage.kt */
public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {
    public final FqName fqName;

    public ReflectJavaPackage(FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.fqName = fqName2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaPackage) && Intrinsics.areEqual(this.fqName, ((ReflectJavaPackage) obj).fqName);
    }

    public JavaAnnotation findAnnotation(FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        return null;
    }

    public Collection getAnnotations() {
        return EmptyList.INSTANCE;
    }

    public Collection<JavaClass> getClasses(Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return EmptyList.INSTANCE;
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public Collection<JavaPackage> getSubPackages() {
        return EmptyList.INSTANCE;
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(ReflectJavaPackage.class, sb, ": ");
        sb.append(this.fqName);
        return sb.toString();
    }
}
