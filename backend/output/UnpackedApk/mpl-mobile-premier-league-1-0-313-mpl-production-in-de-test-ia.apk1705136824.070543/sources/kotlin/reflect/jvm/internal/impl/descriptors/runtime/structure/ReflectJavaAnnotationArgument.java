package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public final Name name;

    public ReflectJavaAnnotationArgument(Name name2) {
        this.name = name2;
    }

    public Name getName() {
        return this.name;
    }
}
