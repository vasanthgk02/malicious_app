package androidx.datastore.core;

import java.io.File;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore$file$2 extends Lambda implements Function0<File> {
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SingleProcessDataStore$file$2(SingleProcessDataStore<T> singleProcessDataStore) {
        // this.this$0 = singleProcessDataStore;
        super(0);
    }

    public Object invoke() {
        File file = (File) this.this$0.produceFile.invoke();
        String absolutePath = file.getAbsolutePath();
        SingleProcessDataStore singleProcessDataStore = SingleProcessDataStore.Companion;
        synchronized (SingleProcessDataStore.activeFilesLock) {
            SingleProcessDataStore singleProcessDataStore2 = SingleProcessDataStore.Companion;
            if (!SingleProcessDataStore.activeFiles.contains(absolutePath)) {
                SingleProcessDataStore singleProcessDataStore3 = SingleProcessDataStore.Companion;
                Set<String> set = SingleProcessDataStore.activeFiles;
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it");
                set.add(absolutePath);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return file;
    }
}
