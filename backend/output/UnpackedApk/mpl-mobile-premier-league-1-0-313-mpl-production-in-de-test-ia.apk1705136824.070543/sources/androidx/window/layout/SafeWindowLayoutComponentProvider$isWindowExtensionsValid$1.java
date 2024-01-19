package androidx.window.layout;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeWindowLayoutComponentProvider.kt */
public final class SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ ClassLoader $classLoader;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(ClassLoader classLoader) {
        // this.$classLoader = classLoader;
        super(0);
    }

    public Object invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        boolean z = false;
        Method method = this.$classLoader.loadClass("androidx.window.extensions.WindowExtensions").getMethod("getWindowLayoutComponent", new Class[0]);
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.INSTANCE;
        Class<?> loadClass = this.$classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(method, "getWindowLayoutComponentMethod");
        if (Modifier.isPublic(method.getModifiers())) {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider4 = SafeWindowLayoutComponentProvider.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(loadClass, "windowLayoutComponentClass");
            if (method.getReturnType().equals(loadClass)) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}
