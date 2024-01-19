package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabase.Builder;
import androidx.room.RoomDatabase.Callback;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Factory;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.work.impl.WorkDatabaseMigrations.RescheduleMigration;
import androidx.work.impl.WorkDatabaseMigrations.WorkMigration9To10;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

public abstract class WorkDatabase extends RoomDatabase {
    public static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1);

    public static WorkDatabase create(final Context context, Executor executor, boolean z) {
        Builder<WorkDatabase> builder;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cls, "klass");
            builder = new Builder<>(context, cls, null);
            builder.allowMainThreadQueries = true;
        } else {
            WorkDatabasePathHelper.getWorkDatabaseName();
            builder = Room.databaseBuilder(context, cls, "androidx.work.workdb");
            builder.factory = new Factory() {
                public SupportSQLiteOpenHelper create(Configuration configuration) {
                    Configuration.Builder builder = Configuration.builder(context);
                    builder.name = configuration.name;
                    builder.callback(configuration.callback);
                    builder.useNoBackupDirectory = true;
                    Configuration build = builder.build();
                    Intrinsics.checkNotNullParameter(build, "configuration");
                    FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = new FrameworkSQLiteOpenHelper(build.context, build.name, build.callback, build.useNoBackupDirectory, build.allowDataLossOnRecovery);
                    return frameworkSQLiteOpenHelper;
                }
            };
        }
        Intrinsics.checkNotNullParameter(executor, "executor");
        builder.queryExecutor = executor;
        builder.addCallback(new Callback() {
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onOpen(supportSQLiteDatabase);
                supportSQLiteDatabase.beginTransaction();
                try {
                    supportSQLiteDatabase.execSQL(WorkDatabase.getPruneSQL());
                    supportSQLiteDatabase.setTransactionSuccessful();
                } finally {
                    supportSQLiteDatabase.endTransaction();
                }
            }
        });
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_1_2);
        builder.addMigrations(new RescheduleMigration(context, 2, 3));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_3_4);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_4_5);
        builder.addMigrations(new RescheduleMigration(context, 5, 6));
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_6_7);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_7_8);
        builder.addMigrations(WorkDatabaseMigrations.MIGRATION_8_9);
        builder.addMigrations(new WorkMigration9To10(context));
        builder.addMigrations(new RescheduleMigration(context, 10, 11));
        builder.fallbackToDestructiveMigration();
        return (WorkDatabase) builder.build();
    }

    public static String getPruneSQL() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        outline73.append(System.currentTimeMillis() - PRUNE_THRESHOLD_MILLIS);
        outline73.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return outline73.toString();
    }

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();
}
