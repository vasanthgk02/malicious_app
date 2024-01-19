package io.hansel.core.criteria;

import io.hansel.core.criteria.node.b;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.segments.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HSLCriteriaBuilder {
    public static final String AGG = "agg";
    public static final String CONDITION = "condition";
    public static final String CRITERIA = "criteria";
    public static final String DIFF_CHAR = "__";
    public static final String FIELD = "field";
    public static final String NID = "id";
    public static final String NOT = "not";
    public static final String OPERATOR = "operator";
    public static final String PAGG = "pagg";
    public static final String PRULES = "prules";
    public static final String RULES = "rules";
    public static final String SDK_EVENT = "sdk_event";
    public static final String SDK_PROFILE = "sdk_profile";
    public static final String SDK_TZ_EVENT = "sdk_tz_event";
    public static final String TYPE = "type";
    public static final String TYPE_NODE = "t";
    public static final String VALUE = "value";

    public static void addSubsegmentId(Set<String> set, String str) {
        if (set != null) {
            set.add(str);
        }
    }

    public static HSLCriteriaAttributes build(String str, CoreJSONObject coreJSONObject, HashMap<String, Object> hashMap, HSLCriteriaAttributes hSLCriteriaAttributes, boolean z, Set<String> set) {
        return build(str, coreJSONObject, hashMap, hSLCriteriaAttributes, z, false, set, null);
    }

    /* JADX WARNING: type inference failed for: r36v0, types: [java.util.HashMap<java.lang.String, java.lang.Object>] */
    /* JADX WARNING: type inference failed for: r37v0, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r40v0, types: [java.util.Set<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r41v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r11v0, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r12v0, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r15v0, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v0, types: [io.hansel.core.criteria.node.HSLCriteriaNode] */
    /* JADX WARNING: type inference failed for: r7v1, types: [io.hansel.core.criteria.node.e] */
    /* JADX WARNING: type inference failed for: r31v0, types: [io.hansel.core.json.CoreJSONArray] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r17v1, types: [io.hansel.core.criteria.node.b] */
    /* JADX WARNING: type inference failed for: r17v2, types: [io.hansel.core.criteria.node.b] */
    /* JADX WARNING: type inference failed for: r30v1 */
    /* JADX WARNING: type inference failed for: r28v0 */
    /* JADX WARNING: type inference failed for: r31v1 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r30v3 */
    /* JADX WARNING: type inference failed for: r28v1 */
    /* JADX WARNING: type inference failed for: r28v2 */
    /* JADX WARNING: type inference failed for: r30v4 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r30v5 */
    /* JADX WARNING: type inference failed for: r28v3 */
    /* JADX WARNING: type inference failed for: r28v4 */
    /* JADX WARNING: type inference failed for: r30v6 */
    /* JADX WARNING: type inference failed for: r28v5 */
    /* JADX WARNING: type inference failed for: r30v7 */
    /* JADX WARNING: type inference failed for: r30v8 */
    /* JADX WARNING: type inference failed for: r28v6 */
    /* JADX WARNING: type inference failed for: r28v7 */
    /* JADX WARNING: type inference failed for: r30v9 */
    /* JADX WARNING: type inference failed for: r28v8 */
    /* JADX WARNING: type inference failed for: r30v10 */
    /* JADX WARNING: type inference failed for: r28v9 */
    /* JADX WARNING: type inference failed for: r30v11 */
    /* JADX WARNING: type inference failed for: r30v12 */
    /* JADX WARNING: type inference failed for: r28v10 */
    /* JADX WARNING: type inference failed for: r28v11 */
    /* JADX WARNING: type inference failed for: r30v13 */
    /* JADX WARNING: type inference failed for: r28v12 */
    /* JADX WARNING: type inference failed for: r28v13 */
    /* JADX WARNING: type inference failed for: r28v14, types: [io.hansel.core.json.CoreJSONArray] */
    /* JADX WARNING: type inference failed for: r30v14 */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r4v7, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r7v18, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r30v15 */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r4v8, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r7v19, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r0v38, types: [io.hansel.core.criteria.node.HSLCriteriaNode] */
    /* JADX WARNING: type inference failed for: r30v17 */
    /* JADX WARNING: type inference failed for: r30v18 */
    /* JADX WARNING: type inference failed for: r28v15 */
    /* JADX WARNING: type inference failed for: r30v19 */
    /* JADX WARNING: type inference failed for: r28v16 */
    /* JADX WARNING: type inference failed for: r30v20 */
    /* JADX WARNING: type inference failed for: r30v21 */
    /* JADX WARNING: type inference failed for: r28v17 */
    /* JADX WARNING: type inference failed for: r30v22 */
    /* JADX WARNING: type inference failed for: r28v18 */
    /* JADX WARNING: type inference failed for: r28v19 */
    /* JADX WARNING: type inference failed for: r30v23 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r15v3, types: [io.hansel.core.criteria.node.d] */
    /* JADX WARNING: type inference failed for: r21v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v10, types: [io.hansel.core.criteria.node.a] */
    /* JADX WARNING: type inference failed for: r7v32 */
    /* JADX WARNING: type inference failed for: r7v33 */
    /* JADX WARNING: type inference failed for: r15v4, types: [io.hansel.core.criteria.node.d] */
    /* JADX WARNING: type inference failed for: r21v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v15, types: [io.hansel.core.criteria.node.a] */
    /* JADX WARNING: type inference failed for: r7v38 */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r1v28, types: [io.hansel.core.criteria.node.ConditionNode] */
    /* JADX WARNING: type inference failed for: r7v42 */
    /* JADX WARNING: type inference failed for: r3v18, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r4v20, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r7v43, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r14v3, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r8v12, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r7v44, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r15v7 */
    /* JADX WARNING: type inference failed for: r7v46 */
    /* JADX WARNING: type inference failed for: r7v47, types: [io.hansel.core.criteria.node.HSLCriteriaNode] */
    /* JADX WARNING: type inference failed for: r3v19, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r4v22, types: [io.hansel.core.criteria.HSLCriteriaAttributes] */
    /* JADX WARNING: type inference failed for: r7v48, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r7v50, types: [io.hansel.core.criteria.node.c] */
    /* JADX WARNING: type inference failed for: r7v53 */
    /* JADX WARNING: type inference failed for: r4v24 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r5v25 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r7v54 */
    /* JADX WARNING: type inference failed for: r17v16, types: [io.hansel.core.criteria.node.b] */
    /* JADX WARNING: type inference failed for: r17v17, types: [io.hansel.core.criteria.node.b] */
    /* JADX WARNING: type inference failed for: r30v24 */
    /* JADX WARNING: type inference failed for: r28v20 */
    /* JADX WARNING: type inference failed for: r30v25 */
    /* JADX WARNING: type inference failed for: r28v21 */
    /* JADX WARNING: type inference failed for: r30v26 */
    /* JADX WARNING: type inference failed for: r28v22 */
    /* JADX WARNING: type inference failed for: r30v27 */
    /* JADX WARNING: type inference failed for: r28v23 */
    /* JADX WARNING: type inference failed for: r28v24 */
    /* JADX WARNING: type inference failed for: r28v25 */
    /* JADX WARNING: type inference failed for: r28v26 */
    /* JADX WARNING: type inference failed for: r30v28 */
    /* JADX WARNING: type inference failed for: r30v29 */
    /* JADX WARNING: type inference failed for: r28v27 */
    /* JADX WARNING: type inference failed for: r30v30 */
    /* JADX WARNING: type inference failed for: r28v28 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r7v55 */
    /* JADX WARNING: type inference failed for: r7v56 */
    /* JADX WARNING: type inference failed for: r7v57 */
    /* JADX WARNING: type inference failed for: r7v58 */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0245, code lost:
        if (r4 == false) goto L_0x0247;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r30v3
      assigns: []
      uses: []
      mth insns count: 524
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04c9 A[Catch:{ CoreJSONException -> 0x0085, all -> 0x0515 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04e9 A[Catch:{ CoreJSONException -> 0x0085, all -> 0x0515 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0511 A[Catch:{ CoreJSONException -> 0x0085, all -> 0x0515 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010d A[SYNTHETIC, Splitter:B:62:0x010d] */
    /* JADX WARNING: Unknown variable types count: 41 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.hansel.core.criteria.HSLCriteriaAttributes build(java.lang.String r34, io.hansel.core.json.CoreJSONObject r35, java.util.HashMap<java.lang.String, java.lang.Object> r36, io.hansel.core.criteria.HSLCriteriaAttributes r37, boolean r38, boolean r39, java.util.Set<java.lang.String> r40, java.lang.String r41) {
        /*
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r39
            r15 = r40
            java.lang.String r1 = "st"
            java.lang.String r2 = "sw"
            java.lang.String r3 = "value"
            java.lang.String r8 = "condition"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r0.<init>()     // Catch:{ all -> 0x0515 }
            java.lang.String r4 = "Invoking build method in HSLCriteriaAttributes with value segId "
            r0.append(r4)     // Catch:{ all -> 0x0515 }
            r0.append(r9)     // Catch:{ all -> 0x0515 }
            java.lang.String r4 = " criteriaJSON "
            r0.append(r4)     // Catch:{ all -> 0x0515 }
            r0.append(r10)     // Catch:{ all -> 0x0515 }
            java.lang.String r4 = " filteredMap "
            r0.append(r4)     // Catch:{ all -> 0x0515 }
            java.lang.String r4 = "null"
            if (r11 != 0) goto L_0x0039
            r5 = r4
            goto L_0x003a
        L_0x0039:
            r5 = r11
        L_0x003a:
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            java.lang.String r5 = " criteriaAttributes "
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            if (r12 != 0) goto L_0x0046
            r5 = r4
            goto L_0x0047
        L_0x0046:
            r5 = r12
        L_0x0047:
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            java.lang.String r5 = " isUJM "
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            r0.append(r13)     // Catch:{ all -> 0x0515 }
            java.lang.String r5 = "isFilter"
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            r0.append(r14)     // Catch:{ all -> 0x0515 }
            java.lang.String r5 = " subSegIds "
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            if (r15 != 0) goto L_0x0063
            r5 = r4
            goto L_0x0064
        L_0x0063:
            r5 = r15
        L_0x0064:
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            java.lang.String r5 = " tzOffset "
            r0.append(r5)     // Catch:{ all -> 0x0515 }
            if (r41 != 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r4 = r41
        L_0x0071:
            r0.append(r4)     // Catch:{ all -> 0x0515 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0515 }
            io.hansel.core.logger.HSLLogger.d(r0)     // Catch:{ all -> 0x0515 }
            if (r10 == 0) goto L_0x0509
            java.lang.String r0 = "t"
            java.lang.String r0 = r10.getString(r0)     // Catch:{ CoreJSONException -> 0x0085 }
            goto L_0x009f
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r4.<init>()     // Catch:{ all -> 0x0515 }
            java.lang.String r5 = "HSLCriteriaTYPE_NODE:  "
            r4.append(r5)     // Catch:{ all -> 0x0515 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0515 }
            r4.append(r0)     // Catch:{ all -> 0x0515 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0515 }
            io.hansel.core.logger.HSLLogger.d(r0)     // Catch:{ all -> 0x0515 }
            r0 = 0
        L_0x009f:
            java.lang.String r4 = "sdk_profile"
            java.lang.String r5 = "sdk_event"
            java.lang.String r6 = "sdk_tz_event"
            if (r0 == 0) goto L_0x00bd
            boolean r16 = r4.equals(r0)     // Catch:{ all -> 0x0515 }
            if (r16 != 0) goto L_0x00bd
            boolean r16 = r5.equals(r0)     // Catch:{ all -> 0x0515 }
            if (r16 != 0) goto L_0x00bd
            boolean r16 = r6.equals(r0)     // Catch:{ all -> 0x0515 }
            if (r16 == 0) goto L_0x00ba
            goto L_0x00bd
        L_0x00ba:
            r7 = 0
            goto L_0x050f
        L_0x00bd:
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x0515 }
            java.lang.String r7 = "prules"
            r17 = r1
            java.lang.String r1 = "id"
            r18 = r8
            java.lang.String r8 = "__"
            r19 = 0
            java.lang.String r20 = ""
            if (r5 != 0) goto L_0x02a7
            boolean r5 = r6.equals(r0)     // Catch:{ all -> 0x0515 }
            if (r5 == 0) goto L_0x00d9
            goto L_0x02a7
        L_0x00d9:
            boolean r0 = r4.equals(r0)     // Catch:{ all -> 0x0515 }
            if (r0 == 0) goto L_0x0139
            java.lang.String r1 = r10.getString(r1)     // Catch:{ Exception -> 0x00ec }
            addSubsegmentId(r15, r1)     // Catch:{ Exception -> 0x00e8 }
            r14 = r1
            goto L_0x00f2
        L_0x00e8:
            r0 = move-exception
            r20 = r1
            goto L_0x00ed
        L_0x00ec:
            r0 = move-exception
        L_0x00ed:
            io.hansel.core.logger.HSLLogger.printStackTrace(r0)     // Catch:{ all -> 0x0515 }
            r14 = r20
        L_0x00f2:
            io.hansel.core.json.CoreJSONObject r2 = r10.optJSONObject(r7)     // Catch:{ all -> 0x0515 }
            r6 = 0
            r0 = 0
            r1 = r34
            r3 = r36
            r4 = r37
            r5 = r38
            r10 = 0
            r7 = r40
            r11 = r8
            r8 = r0
            io.hansel.core.criteria.HSLCriteriaAttributes r0 = build(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0515 }
            if (r0 != 0) goto L_0x010d
        L_0x010b:
            r7 = r10
            goto L_0x0118
        L_0x010d:
            io.hansel.core.criteria.node.HSLCriteriaNode r7 = r0.getHslCriteriaNode()     // Catch:{ Exception -> 0x0112 }
            goto L_0x0118
        L_0x0112:
            r0 = move-exception
            r1 = r0
            io.hansel.core.logger.HSLLogger.printStackTrace(r1)     // Catch:{ all -> 0x0515 }
            goto L_0x010b
        L_0x0118:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0515 }
            r0.<init>()     // Catch:{ all -> 0x0515 }
            r0.add(r7)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.node.c r7 = new io.hansel.core.criteria.node.c     // Catch:{ all -> 0x0515 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r1.<init>()     // Catch:{ all -> 0x0515 }
            r1.append(r9)     // Catch:{ all -> 0x0515 }
            r1.append(r11)     // Catch:{ all -> 0x0515 }
            r1.append(r14)     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0515 }
            r7.<init>(r0, r1)     // Catch:{ all -> 0x0515 }
            goto L_0x050f
        L_0x0139:
            r8 = 0
            r7 = r18
            boolean r0 = r10.has(r7)     // Catch:{ all -> 0x0515 }
            if (r0 == 0) goto L_0x01bd
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0515 }
            r0.<init>()     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = "rules"
            io.hansel.core.json.CoreJSONArray r6 = r10.optJSONArray(r1)     // Catch:{ all -> 0x0515 }
            int r5 = r6.length()     // Catch:{ all -> 0x0515 }
            r4 = 0
        L_0x0152:
            if (r4 >= r5) goto L_0x0190
            io.hansel.core.json.CoreJSONObject r2 = r6.optJSONObject(r4)     // Catch:{ all -> 0x0515 }
            r1 = r34
            r3 = r36
            r19 = r4
            r4 = r37
            r16 = r5
            r5 = r38
            r17 = r6
            r6 = r39
            r18 = r7
            r7 = r40
            r14 = r8
            r15 = r18
            r8 = r41
            io.hansel.core.criteria.HSLCriteriaAttributes r1 = build(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0515 }
            if (r1 == 0) goto L_0x017c
            io.hansel.core.criteria.node.HSLCriteriaNode r7 = r1.getHslCriteriaNode()     // Catch:{ all -> 0x0515 }
            goto L_0x017d
        L_0x017c:
            r7 = r14
        L_0x017d:
            if (r7 == 0) goto L_0x018f
            r0.add(r7)     // Catch:{ all -> 0x0515 }
            int r4 = r19 + 1
            r8 = r14
            r7 = r15
            r5 = r16
            r6 = r17
            r14 = r39
            r15 = r40
            goto L_0x0152
        L_0x018f:
            return r14
        L_0x0190:
            r15 = r7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r1.<init>()     // Catch:{ all -> 0x0515 }
            java.lang.String r2 = "Getting the rootCriteriaNode for segment with id "
            r1.append(r2)     // Catch:{ all -> 0x0515 }
            r1.append(r9)     // Catch:{ all -> 0x0515 }
            java.lang.String r2 = " and criteriaJSON "
            r1.append(r2)     // Catch:{ all -> 0x0515 }
            r1.append(r10)     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0515 }
            io.hansel.core.logger.HSLLogger.d(r1)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.node.ConditionNode r1 = new io.hansel.core.criteria.node.ConditionNode     // Catch:{ all -> 0x0515 }
            java.lang.String r2 = r10.optString(r15)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.c r2 = io.hansel.core.criteria.c.a(r2)     // Catch:{ all -> 0x0515 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0515 }
            r7 = r1
            goto L_0x050f
        L_0x01bd:
            r14 = r8
            java.lang.String r0 = r10.optString(r3)     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = "type"
            java.lang.String r1 = r10.optString(r1)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.datatype.DataType r6 = io.hansel.core.criteria.datatype.DataType.getDataType(r1)     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = "field"
            java.lang.String r5 = r10.optString(r1)     // Catch:{ all -> 0x0515 }
            if (r11 == 0) goto L_0x01dc
            boolean r1 = r11.containsKey(r5)     // Catch:{ all -> 0x0515 }
            if (r1 != 0) goto L_0x01dc
            return r14
        L_0x01dc:
            java.lang.String r1 = "agg"
            java.lang.String r2 = "operator"
            if (r13 == 0) goto L_0x024c
            java.lang.String r4 = r10.optString(r2)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r4 = io.hansel.core.criteria.a.valueOf(r4)     // Catch:{ all -> 0x0515 }
            java.lang.String r7 = "in"
            io.hansel.core.criteria.a r7 = io.hansel.core.criteria.a.valueOf(r7)     // Catch:{ all -> 0x0515 }
            if (r4 == r7) goto L_0x0202
            java.lang.String r4 = r10.optString(r2)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r4 = io.hansel.core.criteria.a.valueOf(r4)     // Catch:{ all -> 0x0515 }
            java.lang.String r7 = "not_in"
            io.hansel.core.criteria.a r7 = io.hansel.core.criteria.a.valueOf(r7)     // Catch:{ all -> 0x0515 }
            if (r4 != r7) goto L_0x024c
        L_0x0202:
            boolean r3 = r10.has(r1)     // Catch:{ all -> 0x0515 }
            if (r3 == 0) goto L_0x0226
            io.hansel.core.criteria.node.a r3 = new io.hansel.core.criteria.node.a     // Catch:{ all -> 0x0515 }
            java.lang.String r2 = r10.optString(r2)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r7 = io.hansel.core.criteria.a.valueOf(r2)     // Catch:{ all -> 0x0515 }
            java.util.ArrayList r8 = r6.getArrayValueObject(r0)     // Catch:{ all -> 0x0515 }
            r9 = 0
            java.lang.String r0 = r10.optString(r1)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r10 = io.hansel.core.criteria.a.valueOf(r0)     // Catch:{ all -> 0x0515 }
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0515 }
            r7 = r3
            goto L_0x050f
        L_0x0226:
            io.hansel.core.criteria.node.d r7 = new io.hansel.core.criteria.node.d     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = r10.optString(r2)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r18 = io.hansel.core.criteria.a.valueOf(r1)     // Catch:{ all -> 0x0515 }
            java.util.ArrayList r19 = r6.getArrayValueObject(r0)     // Catch:{ all -> 0x0515 }
            r20 = 0
            r15 = r7
            r16 = r5
            r17 = r6
            r21 = r41
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0515 }
            r12.addRuleField(r5)     // Catch:{ all -> 0x0515 }
            r4 = r39
            if (r4 != 0) goto L_0x050f
        L_0x0247:
            r12.addSubSegmentField(r9, r5, r4)     // Catch:{ all -> 0x0515 }
            goto L_0x050f
        L_0x024c:
            r4 = r39
            io.hansel.core.json.CoreJSONArray r3 = r10.optJSONArray(r3)     // Catch:{ all -> 0x0515 }
            boolean r7 = r10.has(r1)     // Catch:{ all -> 0x0515 }
            if (r7 == 0) goto L_0x027e
            io.hansel.core.criteria.node.a r11 = new io.hansel.core.criteria.node.a     // Catch:{ all -> 0x0515 }
            java.lang.String r2 = r10.optString(r2)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r7 = io.hansel.core.criteria.a.valueOf(r2)     // Catch:{ all -> 0x0515 }
            if (r3 != 0) goto L_0x0269
            java.lang.Object r0 = r6.getValueObject(r0)     // Catch:{ all -> 0x0515 }
            goto L_0x026d
        L_0x0269:
            java.util.ArrayList r0 = r6.getValueObject(r3)     // Catch:{ all -> 0x0515 }
        L_0x026d:
            r8 = r0
            r9 = 0
            java.lang.String r0 = r10.optString(r1)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r10 = io.hansel.core.criteria.a.valueOf(r0)     // Catch:{ all -> 0x0515 }
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0515 }
            r7 = r11
            goto L_0x050f
        L_0x027e:
            io.hansel.core.criteria.node.d r7 = new io.hansel.core.criteria.node.d     // Catch:{ all -> 0x0515 }
            java.lang.String r1 = r10.optString(r2)     // Catch:{ all -> 0x0515 }
            io.hansel.core.criteria.a r18 = io.hansel.core.criteria.a.valueOf(r1)     // Catch:{ all -> 0x0515 }
            if (r3 != 0) goto L_0x028f
            java.lang.Object r0 = r6.getValueObject(r0)     // Catch:{ all -> 0x0515 }
            goto L_0x0293
        L_0x028f:
            java.util.ArrayList r0 = r6.getValueObject(r3)     // Catch:{ all -> 0x0515 }
        L_0x0293:
            r19 = r0
            r20 = 0
            r15 = r7
            r16 = r5
            r17 = r6
            r21 = r41
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0515 }
            r12.addRuleField(r5)     // Catch:{ all -> 0x0515 }
            if (r4 != 0) goto L_0x050f
            goto L_0x0247
        L_0x02a7:
            r14 = r8
            r15 = 0
            boolean r16 = r6.equals(r0)     // Catch:{ all -> 0x0515 }
            r3 = -1
            java.lang.String r8 = r10.getString(r1)     // Catch:{ Exception -> 0x047d }
            r6 = r40
            addSubsegmentId(r6, r8)     // Catch:{ Exception -> 0x046c }
            java.lang.String r0 = "not"
            boolean r18 = r10.getBoolean(r0)     // Catch:{ Exception -> 0x046c }
            java.lang.String r0 = "pi"
            java.lang.String r21 = r10.getString(r0)     // Catch:{ Exception -> 0x045d }
            java.lang.String r0 = "n"
            java.lang.String r22 = r10.getString(r0)     // Catch:{ Exception -> 0x0448 }
            boolean r0 = r10.has(r2)     // Catch:{ Exception -> 0x0437 }
            if (r0 == 0) goto L_0x0302
            int r19 = r10.getInt(r2)     // Catch:{ Exception -> 0x02fb }
            java.lang.String r0 = "swu"
            java.lang.String r0 = r10.getString(r0)     // Catch:{ Exception -> 0x02e5 }
            r25 = r0
            r23 = r3
            r17 = r19
            r19 = r23
            goto L_0x037d
        L_0x02e5:
            r0 = move-exception
            r23 = r3
            r29 = r8
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r17 = r19
            r25 = r20
        L_0x02f5:
            r20 = r21
        L_0x02f7:
            r19 = r18
            goto L_0x048f
        L_0x02fb:
            r0 = move-exception
            r23 = r3
            r29 = r8
            goto L_0x043c
        L_0x0302:
            r1 = r17
            boolean r0 = r10.has(r1)     // Catch:{ Exception -> 0x0437 }
            if (r0 == 0) goto L_0x032c
            long r1 = r10.getLong(r1)     // Catch:{ Exception -> 0x02fb }
            java.lang.String r0 = "et"
            long r3 = r10.getLong(r0)     // Catch:{ Exception -> 0x0315 }
            goto L_0x0375
        L_0x0315:
            r0 = move-exception
            r23 = r3
            r29 = r8
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r19 = r18
            r25 = r20
            r20 = r21
            r17 = 0
            r3 = r1
            goto L_0x048f
        L_0x032c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0437 }
            r0.<init>()     // Catch:{ Exception -> 0x0437 }
            java.lang.String r1 = "sd"
            java.lang.String r1 = r10.getString(r1)     // Catch:{ Exception -> 0x0437 }
            r0.append(r1)     // Catch:{ Exception -> 0x0437 }
            java.lang.String r1 = " 00:00:00 GMT"
            r0.append(r1)     // Catch:{ Exception -> 0x0437 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0437 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0437 }
            r1.<init>()     // Catch:{ Exception -> 0x0437 }
            java.lang.String r2 = "ed"
            java.lang.String r2 = r10.getString(r2)     // Catch:{ Exception -> 0x0437 }
            r1.append(r2)     // Catch:{ Exception -> 0x0437 }
            java.lang.String r2 = " 23:59:59 GMT"
            r1.append(r2)     // Catch:{ Exception -> 0x0437 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0437 }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0437 }
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss z"
            r2.<init>(r5)     // Catch:{ Exception -> 0x0437 }
            java.util.Date r0 = r2.parse(r0)     // Catch:{ Exception -> 0x0437 }
            long r23 = r0.getTime()     // Catch:{ Exception -> 0x0437 }
            java.util.Date r0 = r2.parse(r1)     // Catch:{ Exception -> 0x041d }
            long r0 = r0.getTime()     // Catch:{ Exception -> 0x041d }
            r3 = r0
            r1 = r23
        L_0x0375:
            r23 = r3
            r25 = r20
            r17 = 0
            r19 = r1
        L_0x037d:
            java.lang.String r0 = "tz"
            java.lang.String r1 = "+0000"
            java.lang.String r26 = r10.optString(r0, r1)     // Catch:{ Exception -> 0x040f }
            java.lang.String r0 = "dlst"
            io.hansel.core.json.CoreJSONArray r27 = r10.optJSONArray(r0)     // Catch:{ Exception -> 0x03fe }
            java.lang.String r0 = "tlst"
            io.hansel.core.json.CoreJSONArray r28 = r10.optJSONArray(r0)     // Catch:{ Exception -> 0x03f8 }
            io.hansel.core.json.CoreJSONObject r2 = r10.optJSONObject(r7)     // Catch:{ Exception -> 0x03f2 }
            r0 = 1
            r1 = r34
            r3 = r36
            r4 = r37
            r5 = r38
            r6 = r0
            r7 = r40
            r29 = r8
            r8 = r26
            io.hansel.core.criteria.HSLCriteriaAttributes r0 = build(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x03f0 }
            if (r0 != 0) goto L_0x03b0
            r30 = r15
            goto L_0x03b6
        L_0x03b0:
            io.hansel.core.criteria.node.HSLCriteriaNode r0 = r0.getHslCriteriaNode()     // Catch:{ Exception -> 0x03f0 }
            r30 = r0
        L_0x03b6:
            java.lang.String r0 = "pagg"
            io.hansel.core.json.CoreJSONObject r2 = r10.optJSONObject(r0)     // Catch:{ Exception -> 0x03ee }
            r6 = 0
            r8 = 0
            r1 = r34
            r3 = r36
            r4 = r37
            r5 = r38
            r7 = r40
            io.hansel.core.criteria.HSLCriteriaAttributes r0 = build(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x03ee }
            if (r0 != 0) goto L_0x03e9
            r7 = r15
        L_0x03cf:
            r0 = r21
            r1 = r22
            r31 = r28
            r8 = r29
            r2 = r30
            r29 = r26
            r30 = r27
            r27 = r23
            r24 = r25
            r23 = r17
            r25 = r19
            r19 = r18
            goto L_0x04a9
        L_0x03e9:
            io.hansel.core.criteria.node.HSLCriteriaNode r7 = r0.getHslCriteriaNode()     // Catch:{ Exception -> 0x03ee }
            goto L_0x03cf
        L_0x03ee:
            r0 = move-exception
            goto L_0x0407
        L_0x03f0:
            r0 = move-exception
            goto L_0x03f5
        L_0x03f2:
            r0 = move-exception
            r29 = r8
        L_0x03f5:
            r30 = r15
            goto L_0x0407
        L_0x03f8:
            r0 = move-exception
            r29 = r8
            r28 = r15
            goto L_0x0405
        L_0x03fe:
            r0 = move-exception
            r29 = r8
            r27 = r15
            r28 = r27
        L_0x0405:
            r30 = r28
        L_0x0407:
            r3 = r19
            r20 = r21
            r7 = r26
            goto L_0x02f7
        L_0x040f:
            r0 = move-exception
            r29 = r8
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r3 = r19
            goto L_0x02f5
        L_0x041d:
            r0 = move-exception
            r29 = r8
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r19 = r18
            r25 = r20
            r20 = r21
            r17 = 0
            r32 = r3
            r3 = r23
            r23 = r32
            goto L_0x048f
        L_0x0437:
            r0 = move-exception
            r29 = r8
            r23 = r3
        L_0x043c:
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r19 = r18
            r25 = r20
            goto L_0x045a
        L_0x0448:
            r0 = move-exception
            r29 = r8
            r23 = r3
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r19 = r18
            r22 = r20
            r25 = r22
        L_0x045a:
            r20 = r21
            goto L_0x048d
        L_0x045d:
            r0 = move-exception
            r29 = r8
            r23 = r3
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r19 = r18
            goto L_0x0478
        L_0x046c:
            r0 = move-exception
            r29 = r8
            r23 = r3
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
        L_0x0478:
            r22 = r20
            r25 = r22
            goto L_0x048d
        L_0x047d:
            r0 = move-exception
            r23 = r3
            r7 = r15
            r27 = r7
            r28 = r27
            r30 = r28
            r22 = r20
            r25 = r22
            r29 = r25
        L_0x048d:
            r17 = 0
        L_0x048f:
            io.hansel.core.logger.HSLLogger.printStackTrace(r0)     // Catch:{ all -> 0x0515 }
            r0 = r20
            r1 = r22
            r31 = r28
            r8 = r29
            r2 = r30
            r29 = r7
            r7 = r15
            r30 = r27
            r27 = r23
            r24 = r25
            r25 = r3
            r23 = r17
        L_0x04a9:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0515 }
            r3.<init>()     // Catch:{ all -> 0x0515 }
            r3.add(r2)     // Catch:{ all -> 0x0515 }
            r3.add(r7)     // Catch:{ all -> 0x0515 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r2.<init>()     // Catch:{ all -> 0x0515 }
            r2.append(r1)     // Catch:{ all -> 0x0515 }
            r2.append(r0)     // Catch:{ all -> 0x0515 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0515 }
            r4 = 1
            r12.addSubSegmentField(r9, r2, r4)     // Catch:{ all -> 0x0515 }
            if (r16 == 0) goto L_0x04e9
            io.hansel.core.criteria.node.b r7 = new io.hansel.core.criteria.node.b     // Catch:{ all -> 0x0515 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r2.<init>()     // Catch:{ all -> 0x0515 }
            r2.append(r9)     // Catch:{ all -> 0x0515 }
            r2.append(r14)     // Catch:{ all -> 0x0515 }
            r2.append(r8)     // Catch:{ all -> 0x0515 }
            java.lang.String r20 = r2.toString()     // Catch:{ all -> 0x0515 }
            r17 = r7
            r18 = r3
            r21 = r0
            r22 = r1
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r27, r29, r30, r31)     // Catch:{ all -> 0x0515 }
            goto L_0x050f
        L_0x04e9:
            io.hansel.core.criteria.node.b r7 = new io.hansel.core.criteria.node.b     // Catch:{ all -> 0x0515 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0515 }
            r2.<init>()     // Catch:{ all -> 0x0515 }
            r2.append(r9)     // Catch:{ all -> 0x0515 }
            r2.append(r14)     // Catch:{ all -> 0x0515 }
            r2.append(r8)     // Catch:{ all -> 0x0515 }
            java.lang.String r20 = r2.toString()     // Catch:{ all -> 0x0515 }
            r17 = r7
            r18 = r3
            r21 = r0
            r22 = r1
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r27)     // Catch:{ all -> 0x0515 }
            goto L_0x050f
        L_0x0509:
            r15 = 0
            io.hansel.core.criteria.node.e r7 = new io.hansel.core.criteria.node.e     // Catch:{ all -> 0x0515 }
            r7.<init>(r15)     // Catch:{ all -> 0x0515 }
        L_0x050f:
            if (r7 == 0) goto L_0x051e
            r12.setHslCriteriaNode(r7)     // Catch:{ all -> 0x0515 }
            goto L_0x051e
        L_0x0515:
            r0 = move-exception
            java.lang.String r1 = "Exception caught in build method of HSLCriteria builder."
            io.hansel.core.logger.HSLLogger.d(r1)
            io.hansel.core.logger.HSLLogger.printStackTrace(r0)
        L_0x051e:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.core.criteria.HSLCriteriaBuilder.build(java.lang.String, io.hansel.core.json.CoreJSONObject, java.util.HashMap, io.hansel.core.criteria.HSLCriteriaAttributes, boolean, boolean, java.util.Set, java.lang.String):io.hansel.core.criteria.HSLCriteriaAttributes");
    }

    public static HSLCriteriaAttributes buildStopConditionCriteria(String str, CoreJSONObject coreJSONObject, Set<String> set) {
        String str2 = str;
        CoreJSONObject coreJSONObject2 = coreJSONObject;
        try {
            HSLCriteriaAttributes hSLCriteriaAttributes = new HSLCriteriaAttributes();
            String a2 = q.a(str);
            addSubsegmentId(set, a2);
            String string = coreJSONObject2.getString("vendor");
            String string2 = coreJSONObject2.getString("event_name");
            HSLCriteriaAttributes build = build(str, coreJSONObject2.optJSONObject(CRITERIA), null, new HSLCriteriaAttributes(), true, false, set, null);
            Object hslCriteriaNode = build == null ? null : build.getHslCriteriaNode();
            ArrayList arrayList = new ArrayList();
            arrayList.add(hslCriteriaNode);
            arrayList.add(null);
            hSLCriteriaAttributes.addSubSegmentField(str2, string2 + string, true);
            b bVar = new b(arrayList, false, str2 + DIFF_CHAR + a2, string, string2, 14, "day", -1, -1, null, null, null);
            hSLCriteriaAttributes.setHslCriteriaNode(bVar);
            return hSLCriteriaAttributes;
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }
}
