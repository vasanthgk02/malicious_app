package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;
import org.apache.fontbox.cmap.CMap;

public class a extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f4801a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f772a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f773a = {"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", null, f4801a);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < f773a.length - 1; i += 2) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(f773a[i]);
            sb.append(CMap.SPACE);
            sb.append(f773a[i + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f772a) {
            try {
                a(sQLiteDatabase);
            } catch (SQLException e2) {
                b.a((Throwable) e2);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
