package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* renamed from: $$ServiceLoaderMethods  reason: invalid class name and default package */
/* compiled from: ServiceLoader */
public final /* synthetic */ class C$$ServiceLoaderMethods {
    /* renamed from: $load$kotlinx$coroutines$CoroutineExceptionHandlerImplKt$$clinit$-163931$$0  reason: not valid java name */
    public static Iterator m228xadba410b() {
        try {
            return Arrays.asList(new CoroutineExceptionHandler[]{new AndroidExceptionPreHandler()}).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    /* renamed from: $load$kotlinx$coroutines$internal$MainDispatcherLoader$loadMainDispatcher$-159772$$0  reason: not valid java name */
    public static Iterator m229x990b35f8() {
        try {
            return Arrays.asList(new MainDispatcherFactory[]{new AndroidDispatcherFactory()}).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
