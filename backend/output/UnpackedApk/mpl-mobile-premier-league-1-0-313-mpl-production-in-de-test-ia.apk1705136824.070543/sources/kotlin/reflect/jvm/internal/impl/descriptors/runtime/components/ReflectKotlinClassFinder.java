package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.KotlinClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ReflectKotlinClassFinder.kt */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    public final BuiltInsResourceLoader builtInsResourceLoader = new BuiltInsResourceLoader();
    public final ClassLoader classLoader;

    public ReflectKotlinClassFinder(ClassLoader classLoader2) {
        Intrinsics.checkNotNullParameter(classLoader2, "classLoader");
        this.classLoader = classLoader2;
    }

    public InputStream findBuiltInsData(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "packageFqName");
        if (!fqName.startsWith(StandardNames.BUILT_INS_PACKAGE_NAME)) {
            return null;
        }
        return this.builtInsResourceLoader.loadResource(BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath(fqName));
    }

    public final Result findKotlinClass(String str) {
        Class<?> tryLoadClass = TweetUtils.tryLoadClass(this.classLoader, str);
        if (tryLoadClass == null) {
            return null;
        }
        ReflectKotlinClass create = ReflectKotlinClass.create(tryLoadClass);
        if (create == null) {
            return null;
        }
        return new KotlinClass(create, null, 2);
    }

    public Result findKotlinClassOrContent(JavaClass javaClass) {
        Intrinsics.checkNotNullParameter(javaClass, "javaClass");
        FqName fqName = javaClass.getFqName();
        String asString = fqName == null ? null : fqName.asString();
        if (asString == null) {
            return null;
        }
        return findKotlinClass(asString);
    }

    public Result findKotlinClassOrContent(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "relativeClassName.asString()");
        String replace$default = CharsKt__CharKt.replace$default(asString, '.', '$', false, 4);
        if (!classId.getPackageFqName().isRoot()) {
            replace$default = classId.getPackageFqName() + '.' + replace$default;
        }
        return findKotlinClass(replace$default);
    }
}
