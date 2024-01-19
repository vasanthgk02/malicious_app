package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaValueParameter.kt */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements JavaValueParameter {
    public final boolean isVararg;
    public final Annotation[] reflectAnnotations;
    public final String reflectName;
    public final ReflectJavaType type;

    public ReflectJavaValueParameter(ReflectJavaType reflectJavaType, Annotation[] annotationArr, String str, boolean z) {
        Intrinsics.checkNotNullParameter(reflectJavaType, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "reflectAnnotations");
        this.type = reflectJavaType;
        this.reflectAnnotations = annotationArr;
        this.reflectName = str;
        this.isVararg = z;
    }

    public JavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return TweetUtils.findAnnotation(this.reflectAnnotations, fqName);
    }

    public Collection getAnnotations() {
        return TweetUtils.getAnnotations(this.reflectAnnotations);
    }

    public Name getName() {
        String str = this.reflectName;
        if (str == null) {
            return null;
        }
        return Name.guessByFirstCharacter(str);
    }

    public JavaType getType() {
        return this.type;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public boolean isVararg() {
        return this.isVararg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline94(ReflectJavaValueParameter.class, sb, ": ");
        sb.append(this.isVararg ? "vararg " : "");
        String str = this.reflectName;
        sb.append(str == null ? null : Name.guessByFirstCharacter(str));
        sb.append(": ");
        sb.append(this.type);
        return sb.toString();
    }
}
