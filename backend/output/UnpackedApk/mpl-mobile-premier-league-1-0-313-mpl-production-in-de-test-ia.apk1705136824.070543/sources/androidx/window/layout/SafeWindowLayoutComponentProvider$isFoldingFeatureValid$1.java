package androidx.window.layout;

import android.graphics.Rect;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeWindowLayoutComponentProvider.kt */
public final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ ClassLoader $classLoader;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        // this.$classLoader = classLoader;
        super(0);
    }

    public Object invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class<?> loadClass = this.$classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
        boolean z = false;
        Method method = loadClass.getMethod("getBounds", new Class[0]);
        Method method2 = loadClass.getMethod("getType", new Class[0]);
        Method method3 = loadClass.getMethod("getState", new Class[0]);
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(method, "getBoundsMethod");
        if (SafeWindowLayoutComponentProvider.access$doesReturn(safeWindowLayoutComponentProvider2, method, Reflection.getOrCreateKotlinClass(Rect.class))) {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.INSTANCE;
            if (Modifier.isPublic(method.getModifiers())) {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider4 = SafeWindowLayoutComponentProvider.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(method2, "getTypeMethod");
                if (SafeWindowLayoutComponentProvider.access$doesReturn(safeWindowLayoutComponentProvider4, method2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider5 = SafeWindowLayoutComponentProvider.INSTANCE;
                    if (Modifier.isPublic(method2.getModifiers())) {
                        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider6 = SafeWindowLayoutComponentProvider.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(method3, "getStateMethod");
                        if (SafeWindowLayoutComponentProvider.access$doesReturn(safeWindowLayoutComponentProvider6, method3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider7 = SafeWindowLayoutComponentProvider.INSTANCE;
                            if (Modifier.isPublic(method3.getModifiers())) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
