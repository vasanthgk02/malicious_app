package io.hansel.segments.s;

import android.content.Context;
import android.util.Pair;
import io.hansel.core.criteria.datatype.DataType;
import io.hansel.core.criteria.node.ConditionNode;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.lang.StringEscapeUtils;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f5299a;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f5300a;

        /* renamed from: b  reason: collision with root package name */
        public String f5301b;

        /* renamed from: c  reason: collision with root package name */
        public DataType f5302c;

        public a(d dVar, String str, String str2, DataType dataType) {
            this.f5300a = str;
            this.f5301b = str2;
            this.f5302c = dataType;
        }

        public DataType a() {
            return this.f5302c;
        }

        public String b() {
            return this.f5300a;
        }

        public String c() {
            return this.f5301b;
        }

        public boolean equals(Object obj) {
            a aVar = (a) obj;
            if (this.f5300a.equals(aVar.f5300a)) {
                String str = this.f5301b;
                if (((str == null && aVar.f5301b == null) || (str != null && str.equals(aVar.f5301b))) && this.f5302c.equals(aVar.f5302c)) {
                    return true;
                }
            }
            return false;
        }
    }

    public d(Context context) {
        b.a(context);
    }

    private int a(String str, long j, String str2, String str3) {
        c cVar = new c(str, j, str2, str3, System.nanoTime() + System.currentTimeMillis());
        if (cVar.e()) {
            HSLLogger.d("1 row inserted");
            return 1;
        }
        HSLLogger.d("Something went wrong while inserting to db");
        return 0;
    }

    private Pair<Long, Long> a(long j, long j2, Pair<Long, Long> pair) {
        if (pair == null) {
            return null;
        }
        long longValue = ((Long) pair.first).longValue();
        long longValue2 = ((Long) pair.second).longValue();
        if (longValue > j2 || longValue2 < j) {
            return null;
        }
        return longValue > j ? longValue2 < j2 ? new Pair<>(Long.valueOf(longValue), Long.valueOf(longValue2)) : new Pair<>(Long.valueOf(longValue), Long.valueOf(j2)) : longValue2 > j2 ? new Pair<>(Long.valueOf(j), Long.valueOf(j2)) : new Pair<>(Long.valueOf(j), Long.valueOf(longValue2));
    }

    public static d a(Context context) {
        if (f5299a == null) {
            f5299a = new d(context);
        }
        return f5299a;
    }

    private ArrayList<Pair<Long, Long>> a(long j, long j2, long j3, Set<Integer> set, ArrayList<Pair<Long, Long>> arrayList) {
        int i;
        Set<Integer> set2 = set;
        ArrayList<Pair<Long, Long>> arrayList2 = arrayList;
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        ArrayList arrayList3 = new ArrayList();
        long j4 = j + j3;
        long j5 = j2 + j3;
        long millisInADay = HSLUtils.getMillisInADay();
        while (true) {
            if (j4 >= j5) {
                break;
            }
            long j6 = j4 % millisInADay;
            long j7 = ((j4 + millisInADay) - j6) - 1;
            long j8 = j7 > j5 ? j5 : j7;
            long j9 = (j8 - j4) + j6;
            instance.setTimeInMillis(j4);
            if (set2 == null || set.size() == 0 || set2.contains(Integer.valueOf(instance.get(7) - 1))) {
                if (arrayList2 == null || arrayList.size() == 0) {
                    arrayList3.add(new Pair(Long.valueOf(j4), Long.valueOf(j8)));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        try {
                            Pair<Long, Long> a2 = a(j6, j9, arrayList2.get(i2));
                            if (a2 != null) {
                                long j10 = j4 - j6;
                                arrayList3.add(new Pair(Long.valueOf(((Long) a2.first).longValue() + j10), Long.valueOf(j10 + ((Long) a2.second).longValue())));
                            }
                        } catch (Throwable th) {
                            HSLLogger.printStackTrace(th);
                        }
                    }
                }
            }
            j4 = j8 + 1;
        }
        ArrayList<Pair<Long, Long>> arrayList4 = new ArrayList<>();
        for (i = 0; i < arrayList3.size(); i++) {
            arrayList4.add(new Pair(Long.valueOf(((Long) ((Pair) arrayList3.get(i)).first).longValue() - j3), Long.valueOf(((Long) ((Pair) arrayList3.get(i)).second).longValue() - j3)));
        }
        return arrayList4;
    }

    private ArrayList<Pair<Long, Long>> a(CoreJSONArray coreJSONArray) {
        ArrayList<Pair<Long, Long>> arrayList = new ArrayList<>();
        if (!(coreJSONArray == null || coreJSONArray.length() == 0)) {
            for (int i = 0; i < coreJSONArray.length(); i++) {
                CoreJSONObject optJSONObject = coreJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new Pair(Long.valueOf(HSLUtils.getMillis(optJSONObject.optString("st"))), Long.valueOf(HSLUtils.getMillis(optJSONObject.optString("et")))));
                }
            }
        }
        return arrayList;
    }

    private boolean a(String str, char c2) {
        boolean z = false;
        if (str.length() < 2) {
            return false;
        }
        int length = str.length() - 1;
        if (str.charAt(0) == c2 && str.charAt(length) == c2) {
            z = true;
        }
        return z;
    }

    private Set<String> b(Set<String> set) {
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (HSLUtils.isSet(next) && !a(next, (char) StringEscapeUtils.CSV_QUOTE)) {
                hashSet.add(StringEscapeUtils.CSV_QUOTE + next + StringEscapeUtils.CSV_QUOTE);
            }
        }
        return hashSet;
    }

    public int a(long j, String str, String str2, String str3) {
        if (HSLUtils.isSet(str)) {
            return a(str, j, str2, str3);
        }
        return 0;
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(String str, String str2, long j, long j2, ConditionNode conditionNode) {
        Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a2 = c.a(true, str, str2, j, j2, conditionNode);
        return a2 == null ? new Pair<>(new HashMap(), new Pair(Integer.valueOf(0), Long.valueOf(0))) : a2;
    }

    public Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> a(String str, String str2, long j, long j2, ConditionNode conditionNode, long j3, Set<Integer> set, CoreJSONArray coreJSONArray) {
        CoreJSONArray coreJSONArray2 = coreJSONArray;
        if ((coreJSONArray2 == null || coreJSONArray.length() == 0) && (set == null || set.size() == 0)) {
            String str3 = str;
            String str4 = str2;
            ConditionNode conditionNode2 = conditionNode;
            return a(str, str2, j, j2, conditionNode);
        }
        ArrayList<Pair<Long, Long>> a2 = a(j, j2, j3, set, a(coreJSONArray2));
        Pair<HashMap<String, HashMap<Object, Integer>>, Pair<Integer, Long>> pair = null;
        if (a2 == null || a2.size() > 0) {
            String str5 = str;
            String str6 = str2;
            pair = c.a(true, str, str2, a2, conditionNode);
        }
        return pair == null ? new Pair<>(new HashMap(), new Pair(Integer.valueOf(0), Long.valueOf(0))) : pair;
    }

    public a a(String str, Object obj) {
        String str2;
        DataType dataType = DataType.other;
        if (obj == null) {
            dataType = DataType.string;
            str2 = null;
        } else {
            if (obj instanceof Boolean) {
                dataType = DataType.bool;
            } else if (obj instanceof Number) {
                dataType = DataType.number;
            } else if ((obj instanceof Character) || (obj instanceof String)) {
                dataType = DataType.string;
            } else if (obj instanceof byte[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((byte[]) obj);
            } else if (obj instanceof short[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((short[]) obj);
            } else if (obj instanceof int[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((int[]) obj);
            } else if (obj instanceof long[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((long[]) obj);
            } else if (obj instanceof float[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((float[]) obj);
            } else if (obj instanceof double[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((double[]) obj);
            } else if (obj instanceof boolean[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((boolean[]) obj);
            } else if (obj instanceof char[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((char[]) obj);
            } else if (obj instanceof Number[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((Number[]) obj);
            } else if (obj instanceof Character[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((Character[]) obj);
            } else if (obj instanceof String[]) {
                dataType = DataType.array;
                str2 = Arrays.toString((String[]) obj);
            } else if (obj instanceof List) {
                dataType = DataType.array;
            } else {
                str2 = "";
            }
            str2 = String.valueOf(obj);
        }
        return new a(this, str, str2, dataType);
    }

    public String a() {
        String str = c.b() + " rows deleted";
        HSLLogger.d(str);
        return str;
    }

    public String a(int i) {
        String str = c.a(System.currentTimeMillis() - (((long) i) * 86400000)) + " rows deleted";
        HSLLogger.d(str);
        return str;
    }

    public String a(Set<String> set) {
        String str = c.a(b(set)) + " rows deleted";
        HSLLogger.d(str);
        return str;
    }
}
