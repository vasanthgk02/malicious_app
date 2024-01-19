package com.mpl.analytics.kafka;

import a.a.a.a.a;
import a.a.a.a.d.b;
import a.a.a.a.g;
import a.a.a.a.h;
import a.a.a.a.j;
import a.a.a.a.l;
import android.content.Context;
import android.database.Cursor;
import androidx.core.widget.CompoundButtonCompat;
import androidx.room.RoomSQLiteQuery;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import org.json.JSONObject;

public class AnalyticsHelper {
    public static AnalyticsHelper analyticsHelperInstance;
    public final j mDatabaseManagement;

    public AnalyticsHelper(Context context, Config config) {
        this.mDatabaseManagement = new j(context, config);
    }

    public static AnalyticsHelper getInstance(Context context, Config config) {
        if (analyticsHelperInstance == null) {
            analyticsHelperInstance = new AnalyticsHelper(context, config);
        }
        return analyticsHelperInstance;
    }

    public void addEvent(String str, String str2, String str3) {
        g a2;
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            try {
                l lVar = new l();
                lVar.f2431b = str;
                lVar.f2432c = str2;
                lVar.f2434e = "pending";
                lVar.f2433d = str3;
                a2 = jVar.f2425b.a();
                a2.f2417a.assertNotSuspendingTransaction();
                a2.f2417a.beginTransaction();
                a2.f2418b.insert(lVar);
                a2.f2417a.setTransactionSuccessful();
                a2.f2417a.endTransaction();
            } catch (Exception unused) {
            } catch (Throwable th) {
                a2.f2417a.endTransaction();
                throw th;
            }
        } else {
            throw null;
        }
    }

    public void addEvent(String str, HashMap<String, Object> hashMap, String str2) {
        addEvent(str, new JSONObject(hashMap).toString(), str2);
    }

    public void addEvent(String str, JSONObject jSONObject, String str2) {
        addEvent(str, jSONObject.toString(), str2);
    }

    public void addHeader(MHeader mHeader) {
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            Config config = jVar.f2424a;
            if (config != null) {
                config.addHeader(mHeader);
                this.mDatabaseManagement.f2424a = config;
                boolean isLogEnabled = config.isLogEnabled();
                b.f6a = isLogEnabled;
                MLog.setIsLogEnabled(isLogEnabled);
            }
        }
    }

    public int deleteAllEvent() {
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            try {
                if (jVar.f2425b != null) {
                    return jVar.f2425b.a().a();
                }
            } catch (Exception unused) {
            }
            return -1;
        }
        throw null;
    }

    public int deleteEvent(String str) {
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            try {
                return jVar.f2425b.a().a(str);
            } catch (Exception unused) {
                return -1;
            }
        } else {
            throw null;
        }
    }

    public int getAllEntryCount() {
        j jVar = this.mDatabaseManagement;
        MPLDatabase mPLDatabase = jVar.f2425b;
        if (mPLDatabase == null || mPLDatabase.a() == null) {
            return -1;
        }
        g a2 = jVar.f2425b.a();
        if (a2 != null) {
            int i = 0;
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM events", 0);
            a2.f2417a.assertNotSuspendingTransaction();
            Cursor query = CompoundButtonCompat.query(a2.f2417a, acquire, false, null);
            try {
                if (query.moveToFirst()) {
                    i = query.getInt(0);
                }
                return i;
            } finally {
                query.close();
                acquire.release();
            }
        } else {
            throw null;
        }
    }

    public void initiateSendingEvent() {
        j jVar = this.mDatabaseManagement;
        Timer timer = jVar.f2426c;
        if (timer != null) {
            timer.purge();
            jVar.f2426c.cancel();
            jVar.f2426c = null;
        }
        jVar.f2426c = new Timer();
        jVar.f2426c.scheduleAtFixedRate(new h(jVar), 100, jVar.f2424a.getSendingIntervalTime());
    }

    public void sendEventToKafka(JSONObject jSONObject) {
        j jVar = this.mDatabaseManagement;
        if (jVar != null && jVar.f2424a != null) {
            jVar.a(jSONObject);
        }
    }

    public void setClockDrift(long j) {
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            a aVar = jVar.f2429f;
            if (aVar != null) {
                aVar.f2389d = j;
            }
        }
    }

    public void setConfig(Config config) {
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            jVar.f2424a = config;
            boolean isLogEnabled = config.isLogEnabled();
            b.f6a = isLogEnabled;
            MLog.setIsLogEnabled(isLogEnabled);
        }
    }

    public void stopSendingEvent() {
        j jVar = this.mDatabaseManagement;
        Timer timer = jVar.f2426c;
        if (timer != null) {
            timer.purge();
            jVar.f2426c.cancel();
            jVar.f2426c = null;
        }
    }

    public void addHeader(List<MHeader> list) {
        j jVar = this.mDatabaseManagement;
        if (jVar != null) {
            Config config = jVar.f2424a;
            if (config != null) {
                config.setHeaders(list);
                this.mDatabaseManagement.f2424a = config;
                boolean isLogEnabled = config.isLogEnabled();
                b.f6a = isLogEnabled;
                MLog.setIsLogEnabled(isLogEnabled);
            }
        }
    }
}
