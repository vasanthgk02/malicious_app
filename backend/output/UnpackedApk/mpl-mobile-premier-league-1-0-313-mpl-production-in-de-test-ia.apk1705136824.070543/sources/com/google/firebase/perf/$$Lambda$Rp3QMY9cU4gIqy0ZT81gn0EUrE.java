package com.google.firebase.perf;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: com.google.firebase.perf.-$$Lambda$Rp3QMY9c-U4gIqy0ZT81gn0EUrE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Rp3QMY9cU4gIqy0ZT81gn0EUrE implements ComponentFactory {
    public static final /* synthetic */ $$Lambda$Rp3QMY9cU4gIqy0ZT81gn0EUrE INSTANCE = new $$Lambda$Rp3QMY9cU4gIqy0ZT81gn0EUrE();

    private /* synthetic */ $$Lambda$Rp3QMY9cU4gIqy0ZT81gn0EUrE() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
    }
}
