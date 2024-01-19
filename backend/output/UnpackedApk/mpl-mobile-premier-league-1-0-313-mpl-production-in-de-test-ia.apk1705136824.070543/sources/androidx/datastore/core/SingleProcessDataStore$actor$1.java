package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "T", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore$actor$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SingleProcessDataStore$actor$1(SingleProcessDataStore<T> singleProcessDataStore) {
        // this.this$0 = singleProcessDataStore;
        super(1);
    }

    public Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        if (th != null) {
            this.this$0.downstreamFlow.setValue(new Final(th));
        }
        SingleProcessDataStore singleProcessDataStore = SingleProcessDataStore.Companion;
        Object obj2 = SingleProcessDataStore.activeFilesLock;
        SingleProcessDataStore<T> singleProcessDataStore2 = this.this$0;
        synchronized (obj2) {
            SingleProcessDataStore singleProcessDataStore3 = SingleProcessDataStore.Companion;
            SingleProcessDataStore.activeFiles.remove(singleProcessDataStore2.getFile().getAbsolutePath());
        }
        return Unit.INSTANCE;
    }
}
