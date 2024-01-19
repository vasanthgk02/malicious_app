package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer.Companion;
import androidx.recyclerview.widget.LinearLayoutManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
/* compiled from: DataMigrationInitializer.kt */
public final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Companion this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(Companion companion, Continuation<? super DataMigrationInitializer$Companion$runMigrations$1> continuation) {
        // this.this$0 = companion;
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= LinearLayoutManager.INVALID_OFFSET;
        return Companion.access$runMigrations(this.this$0, null, null, this);
    }
}
