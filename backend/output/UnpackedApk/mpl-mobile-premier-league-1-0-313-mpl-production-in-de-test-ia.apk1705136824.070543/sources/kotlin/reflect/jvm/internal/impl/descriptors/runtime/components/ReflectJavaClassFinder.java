package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ReflectJavaClassFinder.kt */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    public final ClassLoader classLoader;

    public ReflectJavaClassFinder(ClassLoader classLoader2) {
        Intrinsics.checkNotNullParameter(classLoader2, "classLoader");
        this.classLoader = classLoader2;
    }

    public JavaClass findClass(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ClassId classId = request.classId;
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "classId.relativeClassName.asString()");
        String replace$default = CharsKt__CharKt.replace$default(asString, '.', '$', false, 4);
        if (!packageFqName.isRoot()) {
            replace$default = packageFqName.asString() + '.' + replace$default;
        }
        Class<?> tryLoadClass = TweetUtils.tryLoadClass(this.classLoader, replace$default);
        if (tryLoadClass != null) {
            return new ReflectJavaClass(tryLoadClass);
        }
        return null;
    }

    public JavaPackage findPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return new ReflectJavaPackage(fqName);
    }

    public Set<String> knownClassNamesInPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        return null;
    }
}
