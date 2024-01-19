package androidx.datastore.preferences.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PreferenceDataStoreFactory.kt */
public final class PreferenceDataStoreFactory$create$delegate$1 extends Lambda implements Function0<File> {
    public final /* synthetic */ Function0<File> $produceFile;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(Function0<? extends File> function0) {
        // this.$produceFile = function0;
        super(0);
    }

    public Object invoke() {
        File file = (File) this.$produceFile.invoke();
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        if (Intrinsics.areEqual(CharsKt__CharKt.substringAfterLast(name, '.', ""), "preferences_pb")) {
            return file;
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: " + "preferences_pb").toString());
    }
}
