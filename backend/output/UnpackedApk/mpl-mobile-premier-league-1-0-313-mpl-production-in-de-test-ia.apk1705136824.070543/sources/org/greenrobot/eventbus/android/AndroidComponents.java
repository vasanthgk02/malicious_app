package org.greenrobot.eventbus.android;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.greenrobot.eventbus.Logger;

public abstract class AndroidComponents {
    public static final AndroidComponents implementation;
    public final DefaultAndroidMainThreadSupport defaultMainThreadSupport;
    public final Logger logger;

    static {
        AndroidComponents androidComponents = null;
        if (TypeUtilsKt.isAndroidSDKAvailable()) {
            try {
                androidComponents = (AndroidComponents) Class.forName("org.greenrobot.eventbus.android.AndroidComponentsImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
            }
        }
        implementation = androidComponents;
    }

    public AndroidComponents(Logger logger2, DefaultAndroidMainThreadSupport defaultAndroidMainThreadSupport) {
        this.logger = logger2;
        this.defaultMainThreadSupport = defaultAndroidMainThreadSupport;
    }
}
