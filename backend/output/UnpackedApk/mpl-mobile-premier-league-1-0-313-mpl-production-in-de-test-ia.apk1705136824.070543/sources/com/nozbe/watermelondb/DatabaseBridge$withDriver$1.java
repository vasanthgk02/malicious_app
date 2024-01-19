package com.nozbe.watermelondb;

import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DatabaseBridge.kt */
public final class DatabaseBridge$withDriver$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function1<DatabaseDriver, Object> $function;
    public final /* synthetic */ Promise $promise;
    public final /* synthetic */ int $tag;
    public final /* synthetic */ DatabaseBridge this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DatabaseBridge$withDriver$1(DatabaseBridge databaseBridge, int i, Promise promise, Function1<? super DatabaseDriver, ? extends Object> function1) {
        // this.this$0 = databaseBridge;
        // this.$tag = i;
        // this.$promise = promise;
        // this.$function = function1;
        super(0);
    }

    public Object invoke() {
        this.this$0.withDriver(this.$tag, this.$promise, this.$function);
        return Unit.INSTANCE;
    }
}
