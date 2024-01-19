package io.sentry.react;

import io.sentry.Scope;
import io.sentry.ScopeCallback;

/* renamed from: io.sentry.react.-$$Lambda$RNSentryModule$UXBbDDjVrpP0efteWI-s6CIxXek  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$RNSentryModule$UXBbDDjVrpP0efteWIs6CIxXek implements ScopeCallback {
    public static final /* synthetic */ $$Lambda$RNSentryModule$UXBbDDjVrpP0efteWIs6CIxXek INSTANCE = new $$Lambda$RNSentryModule$UXBbDDjVrpP0efteWIs6CIxXek();

    private /* synthetic */ $$Lambda$RNSentryModule$UXBbDDjVrpP0efteWIs6CIxXek() {
    }

    public final void run(Scope scope) {
        scope.clearBreadcrumbs();
    }
}
