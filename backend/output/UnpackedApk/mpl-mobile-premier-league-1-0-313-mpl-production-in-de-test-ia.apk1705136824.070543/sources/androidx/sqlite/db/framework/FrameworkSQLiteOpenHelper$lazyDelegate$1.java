package androidx.sqlite.db.framework;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.DBRefHolder;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameworkSQLiteOpenHelper.kt */
public final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends Lambda implements Function0<OpenHelper> {
    public final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        // this.this$0 = frameworkSQLiteOpenHelper;
        super(0);
    }

    public Object invoke() {
        OpenHelper openHelper;
        if (VERSION.SDK_INT >= 23) {
            FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = this.this$0;
            if (frameworkSQLiteOpenHelper.name != null && frameworkSQLiteOpenHelper.useNoBackupDirectory) {
                Context context = this.this$0.context;
                Intrinsics.checkNotNullParameter(context, "context");
                File noBackupFilesDir = context.getNoBackupFilesDir();
                Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
                File file = new File(noBackupFilesDir, this.this$0.name);
                Context context2 = this.this$0.context;
                String absolutePath = file.getAbsolutePath();
                DBRefHolder dBRefHolder = new DBRefHolder(null);
                FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper2 = this.this$0;
                openHelper = new OpenHelper(context2, absolutePath, dBRefHolder, frameworkSQLiteOpenHelper2.callback, frameworkSQLiteOpenHelper2.allowDataLossOnRecovery);
                boolean z = this.this$0.writeAheadLoggingEnabled;
                Intrinsics.checkNotNullParameter(openHelper, "sQLiteOpenHelper");
                openHelper.setWriteAheadLoggingEnabled(z);
                return openHelper;
            }
        }
        FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper3 = this.this$0;
        Context context3 = frameworkSQLiteOpenHelper3.context;
        String str = frameworkSQLiteOpenHelper3.name;
        DBRefHolder dBRefHolder2 = new DBRefHolder(null);
        FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper4 = this.this$0;
        openHelper = new OpenHelper(context3, str, dBRefHolder2, frameworkSQLiteOpenHelper4.callback, frameworkSQLiteOpenHelper4.allowDataLossOnRecovery);
        boolean z2 = this.this$0.writeAheadLoggingEnabled;
        Intrinsics.checkNotNullParameter(openHelper, "sQLiteOpenHelper");
        openHelper.setWriteAheadLoggingEnabled(z2);
        return openHelper;
    }
}
