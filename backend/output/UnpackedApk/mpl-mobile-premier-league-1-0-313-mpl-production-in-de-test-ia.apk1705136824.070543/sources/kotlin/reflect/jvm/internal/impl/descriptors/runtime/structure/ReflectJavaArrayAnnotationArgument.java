package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    public final Object[] values;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReflectJavaArrayAnnotationArgument(Name name, Object[] objArr) {
        // Intrinsics.checkNotNullParameter(objArr, "values");
        super(name);
        this.values = objArr;
    }

    public List<ReflectJavaAnnotationArgument> getElements() {
        Object obj;
        Object[] objArr = this.values;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            Intrinsics.checkNotNull(obj2);
            Intrinsics.checkNotNullParameter(obj2, HSLCriteriaBuilder.VALUE);
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(obj2.getClass())) {
                obj = new ReflectJavaEnumValueAnnotationArgument(null, (Enum) obj2);
            } else if (obj2 instanceof Annotation) {
                obj = new ReflectJavaAnnotationAsAnnotationArgument(null, (Annotation) obj2);
            } else if (obj2 instanceof Object[]) {
                obj = new ReflectJavaArrayAnnotationArgument(null, (Object[]) obj2);
            } else if (obj2 instanceof Class) {
                obj = new ReflectJavaClassObjectAnnotationArgument(null, (Class) obj2);
            } else {
                obj = new ReflectJavaLiteralAnnotationArgument(null, obj2);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
