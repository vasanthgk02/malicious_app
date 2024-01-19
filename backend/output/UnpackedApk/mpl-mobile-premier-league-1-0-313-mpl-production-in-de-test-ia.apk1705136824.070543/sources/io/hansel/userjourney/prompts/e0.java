package io.hansel.userjourney.prompts;

import android.content.Context;
import com.brentvatne.react.ReactVideoViewManager;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.EventContentProvider;
import io.hansel.core.base.utils.HSLInternalUtils;
import io.hansel.core.criteria.HSLCriteriaAttributes;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.utils.HSLUtils;
import io.hansel.segments.f;
import io.hansel.segments.n;
import io.hansel.segments.q;

public class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f5533a;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5534a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0024 */
        static {
            /*
                io.hansel.userjourney.prompts.f[] r0 = io.hansel.userjourney.prompts.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5534a = r0
                r1 = 1
                io.hansel.userjourney.prompts.f r2 = io.hansel.userjourney.prompts.f.HOUR     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f5534a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.userjourney.prompts.f r3 = io.hansel.userjourney.prompts.f.DAY     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = f5534a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.hansel.userjourney.prompts.f r3 = io.hansel.userjourney.prompts.f.WEEK     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = f5534a     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.hansel.userjourney.prompts.f r3 = io.hansel.userjourney.prompts.f.MONTH     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = f5534a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.userjourney.prompts.f r2 = io.hansel.userjourney.prompts.f.SESSION     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.e0.a.<clinit>():void");
        }
    }

    public e0(Context context) {
        f5533a = context;
    }

    private int a(CoreJSONArray coreJSONArray, long j) {
        int binarySearch = coreJSONArray.binarySearch(Long.valueOf(j));
        return binarySearch > 0 ? binarySearch : binarySearch * -1;
    }

    private boolean a(CoreJSONObject coreJSONObject, CoreJSONArray coreJSONArray) {
        if (!(coreJSONObject == null || coreJSONArray == null)) {
            if (coreJSONObject.has(ReactVideoViewManager.PROP_REPEAT) && coreJSONObject.optJSONObject(ReactVideoViewManager.PROP_REPEAT) != null && HSLInternalUtils.getIntFromSharedPreferences(f5533a, "SESSION_LIMIT_FREQ", 0) != 0) {
                return false;
            }
            if (coreJSONObject.has(EventContentProvider.QUERY_PARAMETER_LIMIT) && coreJSONObject.optJSONObject(EventContentProvider.QUERY_PARAMETER_LIMIT) != null) {
                long currentTimeMillis = System.currentTimeMillis();
                CoreJSONObject optJSONObject = coreJSONObject.optJSONObject(EventContentProvider.QUERY_PARAMETER_LIMIT);
                if (optJSONObject.has("day")) {
                    if ((coreJSONArray.length() - a(coreJSONArray, currentTimeMillis - 86400000)) + 1 >= optJSONObject.optInt("day", Integer.MAX_VALUE)) {
                        return false;
                    }
                }
                if (optJSONObject.has(TimePickerDialogModule.ARG_HOUR)) {
                    if ((coreJSONArray.length() - a(coreJSONArray, currentTimeMillis - 3600000)) + 1 >= optJSONObject.optInt(TimePickerDialogModule.ARG_HOUR, Integer.MAX_VALUE)) {
                        return false;
                    }
                }
                if (optJSONObject.has("week")) {
                    if ((coreJSONArray.length() - a(coreJSONArray, currentTimeMillis - 604800000)) + 1 >= optJSONObject.optInt("week", Integer.MAX_VALUE)) {
                        return false;
                    }
                }
                if (optJSONObject.has("session")) {
                    if ((coreJSONArray.length() - a(coreJSONArray, HSLInternalUtils.getLongFromSharedPreferences(f5533a, "SESSION_ENTRY_TIME"))) + 1 >= optJSONObject.optInt("session", Integer.MAX_VALUE)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void a(r rVar, long j, boolean z) {
        CoreJSONArray coreJSONArray;
        String b2 = rVar.b();
        String uniqueId = HSLFiltersInternal.getInstance().getUniqueId();
        String b3 = f.b(f5533a, uniqueId);
        try {
            CoreJSONArray coreJSONArray2 = !HSLUtils.isSet(b3) ? new CoreJSONArray() : new CoreJSONArray(b3);
            if (!rVar.i().I()) {
                coreJSONArray2.put(j);
            }
            f.b(f5533a, uniqueId, coreJSONArray2.toString());
        } catch (CoreJSONException e2) {
            e2.printStackTrace();
        }
        try {
            String a2 = f.a(f5533a, b2);
            CoreJSONObject coreJSONObject = null;
            if (HSLUtils.isSet(a2)) {
                coreJSONObject = new CoreJSONObject(a2);
                coreJSONArray = coreJSONObject.optJSONArray(uniqueId);
            } else {
                coreJSONArray = null;
            }
            if (coreJSONObject == null) {
                coreJSONObject = new CoreJSONObject();
            }
            if (coreJSONArray == null) {
                coreJSONArray = new CoreJSONArray();
            }
            int length = coreJSONArray.length();
            if ((z && length > 19) || (!z && length > 499)) {
                coreJSONArray.remove(0);
            }
            coreJSONArray.put(j);
            coreJSONObject.put(uniqueId, (Object) coreJSONArray);
            f.a(f5533a, b2, coreJSONObject.toString());
        } catch (CoreJSONException e3) {
            HSLLogger.printStackTrace(e3);
        }
    }

    public boolean a(int i, CoreJSONObject coreJSONObject, String str) {
        boolean z;
        StringBuilder sb;
        try {
            CoreJSONArray optJSONArray = coreJSONObject.optJSONArray("stop");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                if (length > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = false;
                            break;
                        }
                        CoreJSONObject jSONObject = optJSONArray.getJSONObject(i2);
                        String optString = jSONObject.optString("type");
                        if ("event".equals(optString)) {
                            if (!n.a(f5533a).c(q.a(str, jSONObject.optString("event_name"), jSONObject.optString("vendor")))) {
                                break;
                            }
                            i2++;
                        } else {
                            if ("maxCount".equals(optString)) {
                                int optInt = jSONObject.optInt(HSLCriteriaBuilder.VALUE, -1);
                                if (optInt > -1 && i < optInt) {
                                    break;
                                }
                                sb = new StringBuilder();
                                sb.append("Stop condition failed for nudge at index: ");
                                sb.append(i2);
                                sb.append("    for prompt id: ");
                                sb.append(str);
                            } else {
                                sb = new StringBuilder();
                                sb.append("Stop condition failed for nudge at index: ");
                                sb.append(i2);
                                sb.append("    for prompt id: ");
                                sb.append(str);
                            }
                            HSLLogger.e(sb.toString());
                            i2++;
                        }
                    }
                    z = true;
                    if (!z) {
                        HSLLogger.w("onPromptCondition->stop condition failed", LogGroup.PT);
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught while evaluating stop condition", LogGroup.PT);
            return false;
        }
    }

    public boolean a(CoreJSONObject coreJSONObject) {
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("prompt_criteria");
        if (optJSONObject != null) {
            HSLCriteriaAttributes build = HSLCriteriaBuilder.build("", optJSONObject, null, new HSLCriteriaAttributes(), true, null);
            if (build != null) {
                return build.getHslCriteriaNode().evaluate(HSLFiltersInternal.getInstance().getFiltersForPromptCriteriaEval());
            }
        }
        return true;
    }

    public boolean a(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        HSLCriteriaAttributes build = HSLCriteriaBuilder.build("", coreJSONObject.optJSONObject("trigger").optJSONObject(HSLCriteriaBuilder.CRITERIA), null, new HSLCriteriaAttributes(), true, null);
        if (build != null) {
            return build.getHslCriteriaNode().evaluate(coreJSONObject2);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r5 > r11) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0099, code lost:
        if (((((long) r1) * 2592000000L) + r5) > r9) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a2, code lost:
        if (((((long) r1) * 604800000) + r5) > r9) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ab, code lost:
        if (((((long) r1) * 86400000) + r5) > r9) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
        if (((((long) r1) * 3600000) + r5) > r9) goto L_0x00b6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c1 A[Catch:{ all -> 0x00cb }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(io.hansel.core.json.CoreJSONObject r20, io.hansel.userjourney.prompts.f r21, io.hansel.core.json.CoreJSONArray r22) {
        /*
            r19 = this;
            r0 = r22
            java.lang.String r1 = "in"
            java.lang.String r2 = "onPromptCondition->isFrequencyValid method and duration in isEligibleForDisplay."
            r3 = 0
            io.hansel.core.logger.LogGroup r4 = io.hansel.core.logger.LogGroup.PT     // Catch:{ all -> 0x00cb }
            io.hansel.core.logger.HSLLogger.d(r2, r4)     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "frequency"
            r5 = r20
            io.hansel.core.json.CoreJSONObject r2 = r5.optJSONObject(r2)     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "method"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x0021
            int r6 = r22.length()     // Catch:{ all -> 0x00cb }
            goto L_0x0022
        L_0x0021:
            r6 = 0
        L_0x0022:
            java.lang.String r7 = "once"
            boolean r7 = r7.equals(r5)     // Catch:{ all -> 0x00cb }
            r8 = 1
            if (r7 == 0) goto L_0x00c2
            boolean r5 = r2.has(r1)     // Catch:{ all -> 0x00cb }
            r7 = -1
            if (r5 == 0) goto L_0x0037
            int r1 = r2.optInt(r1)     // Catch:{ all -> 0x00cb }
            goto L_0x0038
        L_0x0037:
            r1 = -1
        L_0x0038:
            if (r0 == 0) goto L_0x00b8
            if (r1 != r7) goto L_0x0040
            if (r6 <= 0) goto L_0x0040
            goto L_0x00b6
        L_0x0040:
            if (r6 != 0) goto L_0x0044
            goto L_0x00b8
        L_0x0044:
            if (r21 != 0) goto L_0x0048
            goto L_0x00b6
        L_0x0048:
            int r6 = r6 - r8
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x00cb }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x00cb }
            long r5 = r0.longValue()     // Catch:{ all -> 0x00cb }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00cb }
            r11 = 3600000(0x36ee80, double:1.7786363E-317)
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            r15 = 604800000(0x240c8400, double:2.988109026E-315)
            r17 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            int[] r0 = io.hansel.userjourney.prompts.e0.a.f5534a     // Catch:{ all -> 0x00cb }
            int r2 = r21.ordinal()     // Catch:{ all -> 0x00cb }
            r0 = r0[r2]     // Catch:{ all -> 0x00cb }
            if (r0 == r8) goto L_0x00ae
            r2 = 2
            if (r0 == r2) goto L_0x00a5
            r2 = 3
            if (r0 == r2) goto L_0x009c
            r2 = 4
            if (r0 == r2) goto L_0x0093
            r2 = 5
            if (r0 == r2) goto L_0x007c
            goto L_0x00b8
        L_0x007c:
            android.content.Context r0 = f5533a     // Catch:{ all -> 0x00cb }
            long r11 = io.hansel.core.base.utils.HSLInternalUtils.getLastBackgroundTs(r0)     // Catch:{ all -> 0x00cb }
            long r0 = (long) r1
            r13 = 1800000(0x1b7740, double:8.89318E-318)
            long r0 = r0 * r13
            long r0 = r0 + r11
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x008e
            goto L_0x00b6
        L_0x008e:
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b8
            goto L_0x00b6
        L_0x0093:
            long r0 = (long) r1
            long r0 = r0 * r17
            long r0 = r0 + r5
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b8
            goto L_0x00b6
        L_0x009c:
            long r0 = (long) r1
            long r0 = r0 * r15
            long r0 = r0 + r5
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b8
            goto L_0x00b6
        L_0x00a5:
            long r0 = (long) r1
            long r0 = r0 * r13
            long r0 = r0 + r5
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b8
            goto L_0x00b6
        L_0x00ae:
            long r0 = (long) r1
            long r0 = r0 * r11
            long r0 = r0 + r5
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b8
        L_0x00b6:
            r0 = 0
            goto L_0x00b9
        L_0x00b8:
            r0 = 1
        L_0x00b9:
            if (r0 != 0) goto L_0x00c1
            java.lang.String r0 = "onPromptCondition->shown once already"
            io.hansel.core.logger.HSLLogger.w(r0, r4)     // Catch:{ all -> 0x00cb }
            return r3
        L_0x00c1:
            return r8
        L_0x00c2:
            java.lang.String r0 = "everytime"
            boolean r0 = r0.equals(r5)     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00d3
            return r8
        L_0x00cb:
            r0 = move-exception
            io.hansel.core.logger.LogGroup r1 = io.hansel.core.logger.LogGroup.PT
            java.lang.String r2 = "Exception caught while evaluating frequency condition"
            io.hansel.core.logger.HSLLogger.printStackTrace(r0, r2, r1)
        L_0x00d3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.e0.a(io.hansel.core.json.CoreJSONObject, io.hansel.userjourney.prompts.f, io.hansel.core.json.CoreJSONArray):boolean");
    }

    public boolean a(CoreJSONObject coreJSONObject, String str, CoreJSONObject coreJSONObject2) {
        try {
            if (!a(coreJSONObject, coreJSONObject2)) {
                HSLLogger.d("Trigger condition failed for prompt with id " + str);
                return false;
            } else if (!a(coreJSONObject)) {
                HSLLogger.d("Prompt criteria failed for prompt with id " + str);
                return false;
            } else if (b(coreJSONObject)) {
                return true;
            } else {
                HSLLogger.d("Prompt with id " + str + " is not with in specified schedule");
                return false;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            HSLLogger.w("onPromptCondition->some other issue", LogGroup.PT);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a A[Catch:{ all -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r9, io.hansel.userjourney.prompts.k r10) {
        /*
            r8 = this;
            r0 = 0
            android.content.Context r1 = f5533a     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = io.hansel.userjourney.p.r(r1, r9)     // Catch:{ all -> 0x0081 }
            io.hansel.core.json.CoreJSONObject r2 = new io.hansel.core.json.CoreJSONObject     // Catch:{ all -> 0x0081 }
            r2.<init>(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "frequency"
            io.hansel.core.json.CoreJSONObject r1 = r2.optJSONObject(r1)     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "duration"
            java.lang.String r1 = r1.optString(r3)     // Catch:{ all -> 0x0081 }
            io.hansel.userjourney.prompts.f r1 = io.hansel.userjourney.prompts.f.a(r1)     // Catch:{ all -> 0x0081 }
            android.content.Context r3 = f5533a     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = io.hansel.segments.f.a(r3, r9)     // Catch:{ all -> 0x0081 }
            io.hansel.core.filters.HSLFiltersInternal r4 = io.hansel.core.filters.HSLFiltersInternal.getInstance()     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = r4.getUniqueId()     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = "onPromptCondition->Read frequency method and duration in isEligibleForDisplay."
            io.hansel.core.logger.LogGroup r6 = io.hansel.core.logger.LogGroup.PT     // Catch:{ all -> 0x0081 }
            io.hansel.core.logger.HSLLogger.d(r5, r6)     // Catch:{ all -> 0x0081 }
            boolean r5 = io.hansel.core.utils.HSLUtils.isSet(r3)     // Catch:{ all -> 0x0081 }
            r6 = 0
            if (r5 == 0) goto L_0x0048
            io.hansel.core.json.CoreJSONObject r5 = new io.hansel.core.json.CoreJSONObject     // Catch:{ all -> 0x0081 }
            r5.<init>(r3)     // Catch:{ all -> 0x0081 }
            io.hansel.core.json.CoreJSONArray r3 = r5.optJSONArray(r4)     // Catch:{ all -> 0x0081 }
            if (r3 == 0) goto L_0x0049
            int r5 = r3.length()     // Catch:{ all -> 0x0081 }
            goto L_0x004a
        L_0x0048:
            r3 = r6
        L_0x0049:
            r5 = 0
        L_0x004a:
            boolean r10 = r10.I()     // Catch:{ all -> 0x0081 }
            android.content.Context r7 = f5533a     // Catch:{ all -> 0x0081 }
            java.lang.String r7 = io.hansel.segments.f.b(r7, r4)     // Catch:{ all -> 0x0081 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0081 }
            if (r7 != 0) goto L_0x0065
            io.hansel.core.json.CoreJSONArray r6 = new io.hansel.core.json.CoreJSONArray     // Catch:{ all -> 0x0081 }
            android.content.Context r7 = f5533a     // Catch:{ all -> 0x0081 }
            java.lang.String r7 = io.hansel.segments.f.b(r7, r4)     // Catch:{ all -> 0x0081 }
            r6.<init>(r7)     // Catch:{ all -> 0x0081 }
        L_0x0065:
            android.content.Context r7 = f5533a     // Catch:{ all -> 0x0081 }
            io.hansel.core.json.CoreJSONObject r4 = io.hansel.userjourney.p.y(r7, r4)     // Catch:{ all -> 0x0081 }
            boolean r4 = r8.a(r4, r6)     // Catch:{ all -> 0x0081 }
            boolean r1 = r8.a(r2, r1, r3)     // Catch:{ all -> 0x0081 }
            boolean r9 = r8.a(r5, r2, r9)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0080
            if (r9 == 0) goto L_0x0080
            if (r4 != 0) goto L_0x007f
            if (r10 == 0) goto L_0x0080
        L_0x007f:
            r0 = 1
        L_0x0080:
            return r0
        L_0x0081:
            r10 = move-exception
            java.lang.String r1 = "Exception caught in method isFrequencyAndStopConditionMet for prompt "
            java.lang.String r9 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r9)
            io.hansel.core.logger.LogGroup r1 = io.hansel.core.logger.LogGroup.PT
            io.hansel.core.logger.HSLLogger.printStackTrace(r10, r9, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.e0.a(java.lang.String, io.hansel.userjourney.prompts.k):boolean");
    }

    public boolean b(CoreJSONObject coreJSONObject) {
        LogGroup logGroup;
        String str;
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("schedule");
        String optString = optJSONObject.optString(AnalyticsConstants.START);
        String optString2 = optJSONObject.optString(AnalyticsConstants.END);
        if (!"now".equals(optString) && optString != null && !optString.isEmpty()) {
            if (System.currentTimeMillis() < Long.parseLong(optString)) {
                logGroup = LogGroup.PT;
                str = "onPromptCondition->startTime for prompt schedule did not start.";
                HSLLogger.w(str, logGroup);
                return false;
            }
        }
        if (!"never".equals(optString2) && optString2 != null && !optString2.isEmpty()) {
            if (System.currentTimeMillis() > Long.parseLong(optString2)) {
                logGroup = LogGroup.PT;
                str = "onPromptCondition->endTime for prompt schedule expired";
                HSLLogger.w(str, logGroup);
                return false;
            }
        }
        return true;
    }
}
