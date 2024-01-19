package androidx.datastore.preferences;

import android.content.Context;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ljava/io/File;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PreferenceDataStoreDelegate.kt */
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends Lambda implements Function0<File> {
    public final /* synthetic */ Context $applicationContext;
    public final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        // this.$applicationContext = context;
        // this.this$0 = preferenceDataStoreSingletonDelegate;
        super(0);
    }

    public Object invoke() {
        Context context = this.$applicationContext;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        String str = this.this$0.name;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        String stringPlus = Intrinsics.stringPlus(str, ".preferences_pb");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(stringPlus, Constants.DOWNLOADER_FILE_NAME);
        return new File(context.getApplicationContext().getFilesDir(), Intrinsics.stringPlus("datastore/", stringPlus));
    }
}
