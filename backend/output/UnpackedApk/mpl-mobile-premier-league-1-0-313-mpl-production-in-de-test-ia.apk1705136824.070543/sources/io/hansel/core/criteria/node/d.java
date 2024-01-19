package io.hansel.core.criteria.node;

import android.util.Pair;
import io.hansel.core.criteria.b;
import io.hansel.core.criteria.datatype.DataType;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.module.EventData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class d extends HSLCriteriaNode {

    /* renamed from: a  reason: collision with root package name */
    public String f5154a;

    /* renamed from: b  reason: collision with root package name */
    public b f5155b;

    /* renamed from: c  reason: collision with root package name */
    public io.hansel.core.criteria.a f5156c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Object> f5157d;

    /* renamed from: e  reason: collision with root package name */
    public String f5158e;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5159a;

        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|(2:33|34)|35|(2:37|38)|39|41|42|43|(2:45|46)|47|(2:49|50)|51|(2:53|54)|55|57|58|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|41|42|43|(2:45|46)|47|(2:49|50)|51|53|54|55|57|58|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|37|38|39|41|42|43|(2:45|46)|47|49|50|51|53|54|55|57|58|59|(2:61|62)|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Can't wrap try/catch for region: R(66:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|45|46|47|49|50|51|53|54|55|57|58|59|61|62|63|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|82) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x00a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x00bb */
        static {
            /*
                io.hansel.core.criteria.a[] r0 = io.hansel.core.criteria.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5159a = r0
                r1 = 1
                r2 = 19
                io.hansel.core.criteria.a r3 = io.hansel.core.criteria.a.average     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r0 = 2
                r3 = 20
                int[] r4 = f5159a     // Catch:{ NoSuchFieldError -> 0x0019 }
                io.hansel.core.criteria.a r5 = io.hansel.core.criteria.a.min     // Catch:{ NoSuchFieldError -> 0x0019 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r4 = 3
                r5 = 21
                int[] r6 = f5159a     // Catch:{ NoSuchFieldError -> 0x0022 }
                io.hansel.core.criteria.a r7 = io.hansel.core.criteria.a.max     // Catch:{ NoSuchFieldError -> 0x0022 }
                r6[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r6 = 4
                r7 = 22
                int[] r8 = f5159a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.core.criteria.a r9 = io.hansel.core.criteria.a.count     // Catch:{ NoSuchFieldError -> 0x002b }
                r8[r7] = r6     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r8 = 5
                r9 = 23
                int[] r10 = f5159a     // Catch:{ NoSuchFieldError -> 0x0034 }
                io.hansel.core.criteria.a r11 = io.hansel.core.criteria.a.sum     // Catch:{ NoSuchFieldError -> 0x0034 }
                r10[r9] = r8     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r10 = 6
                int[] r11 = f5159a     // Catch:{ NoSuchFieldError -> 0x003c }
                io.hansel.core.criteria.a r12 = io.hansel.core.criteria.a.equal     // Catch:{ NoSuchFieldError -> 0x003c }
                r12 = 0
                r11[r12] = r10     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                r11 = 7
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x0043 }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.not_equal     // Catch:{ NoSuchFieldError -> 0x0043 }
                r12[r1] = r11     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r1 = 8
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x004b }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.in     // Catch:{ NoSuchFieldError -> 0x004b }
                r12[r0] = r1     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                r0 = 9
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x0053 }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.not_in     // Catch:{ NoSuchFieldError -> 0x0053 }
                r12[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                r4 = 10
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x005b }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.contains     // Catch:{ NoSuchFieldError -> 0x005b }
                r12[r6] = r4     // Catch:{ NoSuchFieldError -> 0x005b }
            L_0x005b:
                r6 = 11
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x0063 }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.doesnt_contains     // Catch:{ NoSuchFieldError -> 0x0063 }
                r12[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                r8 = 12
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x006b }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.less     // Catch:{ NoSuchFieldError -> 0x006b }
                r12[r10] = r8     // Catch:{ NoSuchFieldError -> 0x006b }
            L_0x006b:
                r10 = 13
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x0073 }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.greater     // Catch:{ NoSuchFieldError -> 0x0073 }
                r12[r11] = r10     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                r11 = 14
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x007b }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.less_or_equal     // Catch:{ NoSuchFieldError -> 0x007b }
                r12[r1] = r11     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                r1 = 15
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x0083 }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.greater_or_equal     // Catch:{ NoSuchFieldError -> 0x0083 }
                r12[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                r0 = 16
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x008b }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.version_equal     // Catch:{ NoSuchFieldError -> 0x008b }
                r12[r10] = r0     // Catch:{ NoSuchFieldError -> 0x008b }
            L_0x008b:
                r10 = 17
                int[] r12 = f5159a     // Catch:{ NoSuchFieldError -> 0x0093 }
                io.hansel.core.criteria.a r13 = io.hansel.core.criteria.a.version_greater_than     // Catch:{ NoSuchFieldError -> 0x0093 }
                r12[r11] = r10     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                int[] r11 = f5159a     // Catch:{ NoSuchFieldError -> 0x009b }
                io.hansel.core.criteria.a r12 = io.hansel.core.criteria.a.version_greater_or_equal     // Catch:{ NoSuchFieldError -> 0x009b }
                r12 = 18
                r11[r1] = r12     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                int[] r1 = f5159a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                io.hansel.core.criteria.a r11 = io.hansel.core.criteria.a.version_less_than     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f5159a     // Catch:{ NoSuchFieldError -> 0x00a7 }
                io.hansel.core.criteria.a r1 = io.hansel.core.criteria.a.version_less_or_equal     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r10] = r3     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                int[] r0 = f5159a     // Catch:{ NoSuchFieldError -> 0x00af }
                io.hansel.core.criteria.a r1 = io.hansel.core.criteria.a.regex     // Catch:{ NoSuchFieldError -> 0x00af }
                r1 = 18
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r0 = f5159a     // Catch:{ NoSuchFieldError -> 0x00b5 }
                io.hansel.core.criteria.a r1 = io.hansel.core.criteria.a.date_prior     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r0[r4] = r7     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = f5159a     // Catch:{ NoSuchFieldError -> 0x00bb }
                io.hansel.core.criteria.a r1 = io.hansel.core.criteria.a.date_post     // Catch:{ NoSuchFieldError -> 0x00bb }
                r0[r6] = r9     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                int[] r0 = f5159a     // Catch:{ NoSuchFieldError -> 0x00c3 }
                io.hansel.core.criteria.a r1 = io.hansel.core.criteria.a.date_equal     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r1 = 24
                r0[r8] = r1     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.criteria.node.d.a.<clinit>():void");
        }
    }

    public d(String str, DataType dataType, io.hansel.core.criteria.a aVar, Object obj, ArrayList<HSLCriteriaNode> arrayList, String str2) {
        super(arrayList);
        this.f5154a = str;
        this.f5156c = aVar;
        this.f5158e = str2;
        ArrayList<Object> arrayList2 = new ArrayList<>();
        this.f5157d = arrayList2;
        arrayList2.add(obj);
        this.f5155b = dataType.getCriteriaDataType();
    }

    public d(String str, DataType dataType, io.hansel.core.criteria.a aVar, ArrayList<Object> arrayList, ArrayList<HSLCriteriaNode> arrayList2, String str2) {
        super(arrayList2);
        this.f5154a = str;
        this.f5156c = aVar;
        this.f5157d = arrayList;
        this.f5158e = str2;
        this.f5155b = dataType.getCriteriaDataType();
    }

    private boolean a(ArrayList<Object> arrayList, String str) {
        switch (a.f5159a[this.f5156c.ordinal()]) {
            case 6:
                return this.f5155b.equal(arrayList, str);
            case 7:
                return this.f5155b.notEqual(arrayList, str);
            case 8:
                return this.f5155b.in(arrayList, str);
            case 9:
                return this.f5155b.notIn(arrayList, str);
            case 10:
                return this.f5155b.isContainedIn(arrayList, str);
            case 11:
                return this.f5155b.isNotContainedIn(arrayList, str);
            case 12:
                return this.f5155b.lessThan(arrayList, str);
            case 13:
                return this.f5155b.greaterThan(arrayList, str);
            case 14:
                return this.f5155b.lessThanOrEqual(arrayList, str);
            case 15:
                return this.f5155b.greaterThanOrEqual(arrayList, str);
            case 16:
                return this.f5155b.versionEqual(arrayList, str);
            case 17:
                return this.f5155b.versionGreaterThan(arrayList, str);
            case 18:
                return this.f5155b.versionGreaterThanOrEqual(arrayList, str);
            case 19:
                return this.f5155b.versionLessThan(arrayList, str);
            case 20:
                return this.f5155b.versionLessThanOrEqual(arrayList, str);
            case 21:
                return this.f5155b.regex(arrayList, str);
            case 22:
                return this.f5155b.datePriorTo(arrayList, str, this.f5158e);
            case 23:
                return this.f5155b.datePost(arrayList, str, this.f5158e);
            case 24:
                return this.f5155b.dateEqual(arrayList, str, this.f5158e);
            default:
                return false;
        }
    }

    public boolean a(io.hansel.core.criteria.a aVar, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair) {
        if (!(aVar == null || this.f5155b == null)) {
            Object obj = null;
            if ("hsl_event_count".equals(this.f5154a)) {
                obj = pair.second;
            } else {
                HashMap hashMap = (HashMap) ((HashMap) pair.first).get(this.f5154a);
                if (hashMap == null) {
                    obj = Integer.valueOf(0);
                } else {
                    int i = a.f5159a[aVar.ordinal()];
                    if (i == 1) {
                        obj = this.f5155b.average(hashMap);
                    } else if (i == 2) {
                        obj = this.f5155b.min(hashMap);
                    } else if (i == 3) {
                        obj = this.f5155b.max(hashMap);
                    } else if (i == 4) {
                        obj = this.f5155b.count(hashMap);
                    } else if (i == 5) {
                        obj = this.f5155b.sum(hashMap);
                    }
                }
            }
            if (obj != null) {
                HSLLogger.d("Aggregation:   " + obj);
                return a(this.f5157d, obj.toString());
            }
        }
        return false;
    }

    public boolean evaluate(CoreJSONObject coreJSONObject) {
        boolean z = false;
        try {
            Object opt = coreJSONObject.opt(this.f5154a);
            if (opt != null && a(this.f5157d, opt.toString())) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return false;
        }
    }

    public boolean evaluate(HashMap<String, Object> hashMap, Pair<HashMap<String, HashMap<Object, Integer>>, Integer> pair, EventData eventData) {
        if (this.f5155b == null || !hashMap.containsKey(this.f5154a)) {
            return false;
        }
        Object obj = hashMap.get(this.f5154a);
        return a(this.f5157d, obj == null ? null : obj.toString());
    }

    public boolean evaluateFromMap(Map<String, Object> map) {
        boolean z = false;
        try {
            Object obj = map.get(this.f5154a);
            if (obj != null && a(this.f5157d, obj.toString())) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return false;
        }
    }
}
