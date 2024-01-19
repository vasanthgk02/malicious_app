package com.netcore.android.smartechbase.communication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/netcore/android/smartechbase/communication/SmartechPushInterface;", "", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "Landroid/database/sqlite/SQLiteDatabase;", "db", "createTable", "(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;)V", "", "oldVersion", "newVersion", "upgradeTable", "(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;II)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SmartechPushInterface.kt */
public interface SmartechPushInterface {
    void createTable(Context context, SQLiteDatabase sQLiteDatabase);

    void init(Context context);

    void upgradeTable(Context context, SQLiteDatabase sQLiteDatabase, int i, int i2);
}
