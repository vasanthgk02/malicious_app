package com.nozbe.watermelondb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J+\u0010\u0016\u001a\u00020\u000e2\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00182\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00030\u001aj\u0002`\u001b¢\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\u00020\u00152\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00182\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00010\u001aj\u0002`\u001e¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0003J+\u0010\"\u001a\u00020\u00152\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00182\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00010\u001aj\u0002`\u001e¢\u0006\u0002\u0010\u001fJ\u0018\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00030$j\b\u0012\u0004\u0012\u00020\u0003`%H\u0002J\u0010\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u0003J\u0016\u0010'\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J+\u0010(\u001a\u00020)2\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00182\u0012\b\u0002\u0010\u0019\u001a\f\u0012\u0004\u0012\u00020\u00030\u001aj\u0002`\u001b¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\u00020\u00152\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150-J\u0006\u0010.\u001a\u00020\u0015J\u0012\u0010/\u001a\u00020\u00152\n\u00100\u001a\u00060\u0003j\u0002`\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u00061"}, d2 = {"Lcom/nozbe/watermelondb/Database;", "", "name", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "db", "Landroid/database/sqlite/SQLiteDatabase;", "getDb", "()Landroid/database/sqlite/SQLiteDatabase;", "db$delegate", "Lkotlin/Lazy;", "value", "", "userVersion", "getUserVersion", "()I", "setUserVersion", "(I)V", "close", "", "count", "query", "Lcom/nozbe/watermelondb/SQL;", "args", "", "Lcom/nozbe/watermelondb/RawQueryArgs;", "(Ljava/lang/String;[Ljava/lang/String;)I", "delete", "Lcom/nozbe/watermelondb/QueryArgs;", "(Ljava/lang/String;[Ljava/lang/Object;)V", "deleteFromLocalStorage", "key", "execute", "getAllTables", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFromLocalStorage", "insertToLocalStorage", "rawQuery", "Landroid/database/Cursor;", "(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;", "transaction", "function", "Lkotlin/Function0;", "unsafeDestroyEverything", "unsafeExecuteStatements", "statements", "watermelondb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Database.kt */
public final class Database {
    public final Context context;
    public final Lazy db$delegate = TweetUtils.lazy((Function0<? extends T>) new Database$db$2<Object>(this));
    public final String name;

    public Database(String str, Context context2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.name = str;
        this.context = context2;
    }

    public static /* synthetic */ void execute$default(Database database, String str, Object[] objArr, int i) {
        database.execute(str, (i & 2) != 0 ? new Object[0] : null);
    }

    public static /* synthetic */ Cursor rawQuery$default(Database database, String str, String[] strArr, int i) {
        return database.rawQuery(str, (i & 2) != 0 ? new String[0] : null);
    }

    public final void execute(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(objArr, "args");
        getDb().execSQL(str, objArr);
    }

    public final SQLiteDatabase getDb() {
        Object value = this.db$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-db>(...)");
        return (SQLiteDatabase) value;
    }

    public final int getUserVersion() {
        return getDb().getVersion();
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(strArr, "args");
        Cursor rawQuery = getDb().rawQuery(str, strArr);
        Intrinsics.checkNotNullExpressionValue(rawQuery, "db.rawQuery(query, args)");
        return rawQuery;
    }

    public final void transaction(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "function");
        getDb().beginTransaction();
        try {
            function0.invoke();
            getDb().setTransactionSuccessful();
        } finally {
            getDb().endTransaction();
        }
    }
}
