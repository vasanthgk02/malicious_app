package com.mpl.androidapp.other.appusage.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/mpl/androidapp/other/appusage/model/Usage;", "", "userId", "", "date", "packageName", "lastDayUsage", "last7DaysUsage", "last30DaysUsage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getLast30DaysUsage", "getLast7DaysUsage", "getLastDayUsage", "getPackageName", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Usage.kt */
public final class Usage {
    public final String date;
    public final String last30DaysUsage;
    public final String last7DaysUsage;
    public final String lastDayUsage;
    public final String packageName;
    public final String userId;

    public Usage(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, DatePickerDialogModule.ARG_DATE);
        Intrinsics.checkNotNullParameter(str3, "packageName");
        Intrinsics.checkNotNullParameter(str4, "lastDayUsage");
        Intrinsics.checkNotNullParameter(str5, "last7DaysUsage");
        Intrinsics.checkNotNullParameter(str6, "last30DaysUsage");
        this.userId = str;
        this.date = str2;
        this.packageName = str3;
        this.lastDayUsage = str4;
        this.last7DaysUsage = str5;
        this.last30DaysUsage = str6;
    }

    public static /* synthetic */ Usage copy$default(Usage usage, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = usage.userId;
        }
        if ((i & 2) != 0) {
            str2 = usage.date;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = usage.packageName;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = usage.lastDayUsage;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = usage.last7DaysUsage;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = usage.last30DaysUsage;
        }
        return usage.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.date;
    }

    public final String component3() {
        return this.packageName;
    }

    public final String component4() {
        return this.lastDayUsage;
    }

    public final String component5() {
        return this.last7DaysUsage;
    }

    public final String component6() {
        return this.last30DaysUsage;
    }

    public final Usage copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(str2, DatePickerDialogModule.ARG_DATE);
        Intrinsics.checkNotNullParameter(str3, "packageName");
        Intrinsics.checkNotNullParameter(str4, "lastDayUsage");
        Intrinsics.checkNotNullParameter(str5, "last7DaysUsage");
        Intrinsics.checkNotNullParameter(str6, "last30DaysUsage");
        Usage usage = new Usage(str, str2, str3, str4, str5, str6);
        return usage;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Usage)) {
            return false;
        }
        Usage usage = (Usage) obj;
        return Intrinsics.areEqual(this.userId, usage.userId) && Intrinsics.areEqual(this.date, usage.date) && Intrinsics.areEqual(this.packageName, usage.packageName) && Intrinsics.areEqual(this.lastDayUsage, usage.lastDayUsage) && Intrinsics.areEqual(this.last7DaysUsage, usage.last7DaysUsage) && Intrinsics.areEqual(this.last30DaysUsage, usage.last30DaysUsage);
    }

    public final String getDate() {
        return this.date;
    }

    public final String getLast30DaysUsage() {
        return this.last30DaysUsage;
    }

    public final String getLast7DaysUsage() {
        return this.last7DaysUsage;
    }

    public final String getLastDayUsage() {
        return this.lastDayUsage;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.last30DaysUsage.hashCode() + GeneratedOutlineSupport.outline11(this.last7DaysUsage, GeneratedOutlineSupport.outline11(this.lastDayUsage, GeneratedOutlineSupport.outline11(this.packageName, GeneratedOutlineSupport.outline11(this.date, this.userId.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Usage(userId=");
        outline73.append(this.userId);
        outline73.append(", date=");
        outline73.append(this.date);
        outline73.append(", packageName=");
        outline73.append(this.packageName);
        outline73.append(", lastDayUsage=");
        outline73.append(this.lastDayUsage);
        outline73.append(", last7DaysUsage=");
        outline73.append(this.last7DaysUsage);
        outline73.append(", last30DaysUsage=");
        return GeneratedOutlineSupport.outline59(outline73, this.last30DaysUsage, ')');
    }
}
