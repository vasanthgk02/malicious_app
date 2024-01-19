package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelperFactory;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "()V", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameworkSQLiteOpenHelperFactory.kt */
public final class FrameworkSQLiteOpenHelperFactory implements Factory {
    public SupportSQLiteOpenHelper create(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory, configuration.allowDataLossOnRecovery);
        return frameworkSQLiteOpenHelper;
    }
}
