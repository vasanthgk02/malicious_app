package kotlin.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: PlatformImplementations.kt */
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        int i;
        PlatformImplementations platformImplementations;
        Object newInstance;
        Object newInstance2;
        Object newInstance3;
        Object newInstance4;
        Class<PlatformImplementations> cls = PlatformImplementations.class;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            int indexOf$default = CharsKt__CharKt.indexOf$default((CharSequence) property, '.', 0, false, 6);
            if (indexOf$default < 0) {
                try {
                    i = Integer.parseInt(property) * 65536;
                } catch (NumberFormatException unused) {
                }
                if (i >= 65544 || i < 65536) {
                    newInstance4 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    platformImplementations = (PlatformImplementations) newInstance4;
                    IMPLEMENTATIONS = platformImplementations;
                }
                if (i >= 65543 || i < 65536) {
                    try {
                        newInstance2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                        platformImplementations = (PlatformImplementations) newInstance2;
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader2 = cls.getClassLoader();
                        if (!Intrinsics.areEqual(classLoader, classLoader2)) {
                            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e2);
                        }
                        throw e2;
                    } catch (ClassNotFoundException unused2) {
                        try {
                            newInstance = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                            Intrinsics.checkNotNullExpressionValue(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                            platformImplementations = (PlatformImplementations) newInstance;
                        } catch (ClassCastException e3) {
                            ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                            ClassLoader classLoader4 = cls.getClassLoader();
                            if (!Intrinsics.areEqual(classLoader3, classLoader4)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e3);
                            }
                            throw e3;
                        } catch (ClassNotFoundException unused3) {
                        }
                    }
                    IMPLEMENTATIONS = platformImplementations;
                }
                platformImplementations = new PlatformImplementations();
                IMPLEMENTATIONS = platformImplementations;
            }
            int i2 = indexOf$default + 1;
            int indexOf$default2 = CharsKt__CharKt.indexOf$default((CharSequence) property, '.', i2, false, 4);
            if (indexOf$default2 < 0) {
                indexOf$default2 = property.length();
            }
            String substring = property.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = property.substring(i2, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            i = Integer.parseInt(substring2) + (Integer.parseInt(substring) * 65536);
            newInstance4 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
            platformImplementations = (PlatformImplementations) newInstance4;
            IMPLEMENTATIONS = platformImplementations;
        }
        i = 65542;
        try {
            newInstance4 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
            platformImplementations = (PlatformImplementations) newInstance4;
        } catch (ClassCastException e4) {
            ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
            ClassLoader classLoader6 = cls.getClassLoader();
            if (!Intrinsics.areEqual(classLoader5, classLoader6)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e4);
            }
            throw e4;
        } catch (ClassNotFoundException unused4) {
            try {
                newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                platformImplementations = (PlatformImplementations) newInstance3;
            } catch (ClassCastException e5) {
                ClassLoader classLoader7 = newInstance3.getClass().getClassLoader();
                ClassLoader classLoader8 = cls.getClassLoader();
                if (!Intrinsics.areEqual(classLoader7, classLoader8)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e5);
                }
                throw e5;
            } catch (ClassNotFoundException unused5) {
            }
        }
        IMPLEMENTATIONS = platformImplementations;
    }
}
