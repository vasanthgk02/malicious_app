package io.hansel.segments.s;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f5288a;

    /* renamed from: b  reason: collision with root package name */
    public long f5289b;

    /* renamed from: c  reason: collision with root package name */
    public String f5290c;

    /* renamed from: d  reason: collision with root package name */
    public String f5291d;

    /* renamed from: e  reason: collision with root package name */
    public long f5292e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f5293a;

        /* renamed from: b  reason: collision with root package name */
        public static final f f5294b;

        /* renamed from: c  reason: collision with root package name */
        public static final f f5295c;

        /* renamed from: d  reason: collision with root package name */
        public static final f f5296d;

        /* renamed from: e  reason: collision with root package name */
        public static final f f5297e;

        /* renamed from: f  reason: collision with root package name */
        public static final List<f> f5298f = new ArrayList();

        static {
            Class<Long> cls = Long.class;
            Class<String> cls2 = String.class;
            f5293a = new f(0, cls2, false, "EVN");
            f5294b = new f(1, cls, false, "TS");
            f5295c = new f(2, cls2, false, "UID");
            f5296d = new f(3, cls2, false, "KVJ");
            f5297e = new f(4, cls, true, "ETS");
        }

        public static List<f> a() {
            List<f> list = f5298f;
            if (list.isEmpty()) {
                list.add(f5293a);
                list.add(f5294b);
                list.add(f5295c);
                list.add(f5296d);
                list.add(f5297e);
            }
            return list;
        }
    }

    public c() {
    }

    public c(String str, long j, String str2, String str3, long j2) {
        this.f5288a = str;
        this.f5289b = j;
        this.f5290c = str2;
        this.f5291d = str3;
        this.f5292e = j2;
    }

    public static int a(long j) {
        return b.a().a((String) "EVENT_DB", a.f5294b.a() + " < " + j, (String[]) null);
    }

    public static int a(Set<String> set) {
        String replace = set.toString().replace("[", "(").replace(CMapParser.MARK_END_OF_ARRAY, ")");
        return b.a().a((String) "EVENT_DB", a.f5293a.a() + " IN " + replace, (String[]) null);
    }

    public static Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(boolean z, String str, String str2, long j, long j2, ConditionNode conditionNode) {
        e eVar = new e();
        eVar.a("EVENT_DB");
        eVar.f();
        eVar.a(a.f5293a.a(), str, (String) " = ");
        eVar.a();
        eVar.a(a.f5295c.a(), str2, (String) " = ");
        eVar.a();
        eVar.a(a.f5294b.a(), j, j2);
        eVar.a(z, a.f5297e.a());
        return b.a().a(conditionNode, c.class, eVar.c(), new String[0]);
    }

    public static Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(boolean z, String str, String str2, ArrayList<Pair<Long, Long>> arrayList, ConditionNode conditionNode) {
        e eVar = new e();
        eVar.a("EVENT_DB");
        eVar.f();
        eVar.a(a.f5293a.a(), str, (String) " = ");
        eVar.a();
        eVar.a(a.f5295c.a(), str2, (String) " = ");
        if (arrayList != null && arrayList.size() > 0) {
            eVar.a();
            eVar.d();
            for (int i = 0; i < arrayList.size(); i++) {
                eVar.d();
                eVar.a(a.f5294b.a(), ((Long) arrayList.get(i).first).longValue(), ((Long) arrayList.get(i).second).longValue());
                eVar.b();
                if (i < arrayList.size() - 1) {
                    eVar.e();
                }
            }
            eVar.b();
        }
        eVar.a(z, a.f5297e.a());
        return b.a().a(conditionNode, c.class, eVar.c(), new String[0]);
    }

    private CoreJSONObject a(String str) {
        try {
            return HSLUtils.isSet(str) ? new CoreJSONObject(str) : new CoreJSONObject();
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            return new CoreJSONObject();
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS EVENT_DB ");
        List<f> a2 = a.a();
        sb.append("(");
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            f fVar = a2.get(i);
            sb.append(fVar.a());
            sb.append(CMap.SPACE);
            sb.append(fVar.c());
            if (fVar.d()) {
                sb.append(" PRIMARY KEY");
            }
            if (a2.indexOf(fVar) != a2.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(");");
        return sb.toString();
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE EVENT_DB ADD COLUMN ETS INTEGER; ");
        sQLiteDatabase.execSQL("UPDATE EVENT_DB SET ETS = TS;");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS EVENT_TS_DB (EVN TEXT, TS INTEGER, UID TEXT, KVJ TEXT, ETS INTEGER PRIMARY KEY);");
        sQLiteDatabase.execSQL("INSERT INTO EVENT_TS_DB SELECT * FROM EVENT_DB; ");
        sQLiteDatabase.execSQL("DROP TABLE EVENT_DB; ");
        sQLiteDatabase.execSQL("ALTER TABLE EVENT_TS_DB RENAME TO EVENT_DB; ");
    }

    public static int b() {
        return b.a().a((String) "EVENT_DB");
    }

    public static String c() {
        return "DROP TABLE IF EXISTSEVENT_DB";
    }

    private ContentValues d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.f5293a.a(), this.f5288a);
        contentValues.put(a.f5294b.a(), Long.valueOf(this.f5289b));
        contentValues.put(a.f5295c.a(), this.f5290c);
        contentValues.put(a.f5296d.a(), this.f5291d);
        contentValues.put(a.f5297e.a(), Long.valueOf(this.f5292e));
        return contentValues;
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Long> a(ConditionNode conditionNode, Cursor cursor, HashMap<String, HashMap<Object, Integer>> hashMap) {
        HashMap hashMap2;
        int i;
        Integer num;
        int i2;
        long j = cursor.getLong(a.f5294b.b());
        boolean z = false;
        try {
            f fVar = a.f5296d;
            if (!cursor.isNull(fVar.b()) || conditionNode != null) {
                CoreJSONObject a2 = a(cursor.getString(fVar.b()));
                if (conditionNode == null || conditionNode.evaluate(a2)) {
                    ArrayList arrayList = new ArrayList(a2.keySet());
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str = (String) arrayList.get(i3);
                        if (hashMap.containsKey(str)) {
                            HashMap hashMap3 = hashMap.get(str);
                            if (hashMap3 == null) {
                                num = null;
                                hashMap2 = new HashMap();
                            } else {
                                hashMap2 = hashMap3;
                                num = (Integer) hashMap3.get(a2.get(str));
                            }
                            i = (num == null ? 0 : num.intValue()) + 1;
                        } else {
                            hashMap2 = new HashMap();
                            i = 1;
                        }
                        hashMap2.put(a2.get(str), Integer.valueOf(i));
                        hashMap.put(str, hashMap2);
                    }
                    z = true;
                }
                if (!z) {
                    j = 0;
                }
                return new Pair<>(hashMap, Long.valueOf(j));
            }
            HashMap hashMap4 = hashMap.get("");
            if (hashMap4 == null) {
                hashMap4 = new HashMap();
            } else {
                Integer num2 = (Integer) hashMap4.get("");
                if (num2 != null) {
                    i2 = num2.intValue();
                    hashMap4.put("", Integer.valueOf(i2 + 1));
                    return new Pair<>(hashMap, Long.valueOf(j));
                }
            }
            i2 = 0;
            hashMap4.put("", Integer.valueOf(i2 + 1));
            return new Pair<>(hashMap, Long.valueOf(j));
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public boolean e() {
        return b.a().a((String) "EVENT_DB", d()) != -1;
    }
}
