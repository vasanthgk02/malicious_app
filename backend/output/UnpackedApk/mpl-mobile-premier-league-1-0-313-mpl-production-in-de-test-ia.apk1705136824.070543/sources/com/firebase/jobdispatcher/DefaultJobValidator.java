package com.firebase.jobdispatcher;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultJobValidator implements JobValidator {
    public final Context context;

    public DefaultJobValidator(Context context2) {
        this.context = context2;
    }

    public static List<String> addError(List<String> list, String str) {
        if (str == null) {
            return list;
        }
        if (list == null) {
            return getMutableSingletonList(str);
        }
        Collections.addAll(list, new String[]{str});
        return list;
    }

    public static List<String> addErrorsIf(boolean z, List<String> list, String str) {
        return z ? addError(list, str) : list;
    }

    public static List<String> getMutableSingletonList(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return arrayList;
    }

    public static List<String> mergeErrorLists(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        list.addAll(list2);
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> validate(com.firebase.jobdispatcher.JobParameters r13) {
        /*
            r12 = this;
            com.firebase.jobdispatcher.JobTrigger r0 = r13.getTrigger()
            com.firebase.jobdispatcher.JobTrigger$ImmediateTrigger r1 = com.firebase.jobdispatcher.Trigger.NOW
            r2 = 0
            if (r0 == r1) goto L_0x0018
            boolean r1 = r0 instanceof com.firebase.jobdispatcher.JobTrigger.ExecutionWindowTrigger
            if (r1 != 0) goto L_0x0018
            boolean r0 = r0 instanceof com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "Unknown trigger provided"
            java.util.List r0 = getMutableSingletonList(r0)
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            java.util.List r0 = mergeErrorLists(r2, r0)
            com.firebase.jobdispatcher.RetryStrategy r1 = r13.getRetryStrategy()
            int r3 = r1.policy
            int r4 = r1.initialBackoff
            int r1 = r1.maximumBackoff
            r5 = 2
            r6 = 0
            r7 = 1
            if (r3 == r7) goto L_0x0030
            if (r3 == r5) goto L_0x0030
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            java.lang.String r8 = "Unknown retry policy provided"
            java.util.List r3 = addErrorsIf(r3, r2, r8)
            if (r1 >= r4) goto L_0x003b
            r8 = 1
            goto L_0x003c
        L_0x003b:
            r8 = 0
        L_0x003c:
            java.lang.String r9 = "Maximum backoff must be greater than or equal to initial backoff"
            java.util.List r3 = addErrorsIf(r8, r3, r9)
            r8 = 300(0x12c, float:4.2E-43)
            if (r8 <= r1) goto L_0x0048
            r1 = 1
            goto L_0x0049
        L_0x0048:
            r1 = 0
        L_0x0049:
            java.lang.String r8 = "Maximum backoff must be greater than 300s (5 minutes)"
            java.util.List r1 = addErrorsIf(r1, r3, r8)
            r3 = 30
            if (r4 >= r3) goto L_0x0055
            r3 = 1
            goto L_0x0056
        L_0x0055:
            r3 = 0
        L_0x0056:
            java.lang.String r4 = "Initial backoff must be at least 30s"
            java.util.List r1 = addErrorsIf(r3, r1, r4)
            java.util.List r0 = mergeErrorLists(r0, r1)
            boolean r1 = r13.isRecurring()
            if (r1 == 0) goto L_0x0074
            com.firebase.jobdispatcher.JobTrigger r1 = r13.getTrigger()
            com.firebase.jobdispatcher.JobTrigger$ImmediateTrigger r3 = com.firebase.jobdispatcher.Trigger.NOW
            if (r1 != r3) goto L_0x0074
            java.lang.String r1 = "ImmediateTriggers can't be used with recurring jobs"
            java.util.List r0 = addError(r0, r1)
        L_0x0074:
            android.os.Bundle r1 = r13.getExtras()
            if (r1 != 0) goto L_0x007c
        L_0x007a:
            r1 = r2
            goto L_0x00a8
        L_0x007c:
            android.os.Parcel r3 = android.os.Parcel.obtain()
            r1.writeToParcel(r3, r6)
            int r1 = r3.dataSize()
            r3.recycle()
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r1 <= r3) goto L_0x007a
            java.util.Locale r4 = java.util.Locale.US
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8[r6] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r8[r7] = r1
            java.lang.String r1 = "Extras too large: %d bytes is > the max (%d bytes)"
            java.lang.String r1 = java.lang.String.format(r4, r1, r8)
            java.util.List r1 = getMutableSingletonList(r1)
        L_0x00a8:
            java.util.List r0 = mergeErrorLists(r0, r1)
            int r1 = r13.getLifetime()
            if (r1 <= r7) goto L_0x0106
            android.os.Bundle r1 = r13.getExtras()
            if (r1 == 0) goto L_0x0101
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = r2
        L_0x00c1:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0102
            java.lang.Object r8 = r3.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.get(r8)
            if (r9 == 0) goto L_0x00fb
            boolean r10 = r9 instanceof java.lang.Integer
            if (r10 != 0) goto L_0x00fb
            boolean r10 = r9 instanceof java.lang.Long
            if (r10 != 0) goto L_0x00fb
            boolean r10 = r9 instanceof java.lang.Double
            if (r10 != 0) goto L_0x00fb
            boolean r10 = r9 instanceof java.lang.String
            if (r10 != 0) goto L_0x00fb
            boolean r10 = r9 instanceof java.lang.Boolean
            if (r10 == 0) goto L_0x00e8
            goto L_0x00fb
        L_0x00e8:
            java.util.Locale r10 = java.util.Locale.US
            java.lang.Object[] r11 = new java.lang.Object[r5]
            java.lang.Class r9 = r9.getClass()
            r11[r6] = r9
            r11[r7] = r8
            java.lang.String r8 = "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean"
            java.lang.String r8 = java.lang.String.format(r10, r8, r11)
            goto L_0x00fc
        L_0x00fb:
            r8 = r2
        L_0x00fc:
            java.util.List r4 = addError(r4, r8)
            goto L_0x00c1
        L_0x0101:
            r4 = r2
        L_0x0102:
            java.util.List r0 = mergeErrorLists(r0, r4)
        L_0x0106:
            java.lang.String r1 = r13.getTag()
            if (r1 != 0) goto L_0x0113
            java.lang.String r1 = "Tag can't be null"
            java.util.List r1 = getMutableSingletonList(r1)
            goto L_0x0123
        L_0x0113:
            int r1 = r1.length()
            r3 = 100
            if (r1 <= r3) goto L_0x0122
            java.lang.String r1 = "Tag must be shorter than 100"
            java.util.List r1 = getMutableSingletonList(r1)
            goto L_0x0123
        L_0x0122:
            r1 = r2
        L_0x0123:
            java.util.List r0 = mergeErrorLists(r0, r1)
            java.lang.String r13 = r13.getService()
            if (r13 == 0) goto L_0x0194
            boolean r1 = r13.isEmpty()
            if (r1 == 0) goto L_0x0134
            goto L_0x0194
        L_0x0134:
            android.content.Context r1 = r12.context
            if (r1 != 0) goto L_0x013f
            java.lang.String r13 = "Context is null, can't query PackageManager"
            java.util.List r2 = getMutableSingletonList(r13)
            goto L_0x019a
        L_0x013f:
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            if (r1 != 0) goto L_0x014c
            java.lang.String r13 = "PackageManager is null, can't validate service"
            java.util.List r2 = getMutableSingletonList(r13)
            goto L_0x019a
        L_0x014c:
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "com.firebase.jobdispatcher.ACTION_EXECUTE"
            r3.<init>(r4)
            android.content.Context r4 = r12.context
            r3.setClassName(r4, r13)
            java.util.List r1 = r1.queryIntentServices(r3, r6)
            if (r1 == 0) goto L_0x019a
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x0165
            goto L_0x019a
        L_0x0165:
            java.util.Iterator r1 = r1.iterator()
        L_0x0169:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x017e
            java.lang.Object r3 = r1.next()
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3
            android.content.pm.ServiceInfo r3 = r3.serviceInfo
            if (r3 == 0) goto L_0x0169
            boolean r3 = r3.enabled
            if (r3 == 0) goto L_0x0169
            goto L_0x019a
        L_0x017e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            java.lang.String r13 = " is disabled."
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            java.util.List r2 = getMutableSingletonList(r13)
            goto L_0x019a
        L_0x0194:
            java.lang.String r13 = "Service can't be empty"
            java.util.List r2 = getMutableSingletonList(r13)
        L_0x019a:
            java.util.List r13 = mergeErrorLists(r0, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.DefaultJobValidator.validate(com.firebase.jobdispatcher.JobParameters):java.util.List");
    }
}
