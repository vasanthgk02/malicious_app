package com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.local.entity;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/entity/UnityCrashData;", "", "id", "", "battleId", "", "data", "message", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBattleId", "()Ljava/lang/String;", "getData", "getId", "()I", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityCrashData.kt */
public final class UnityCrashData {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_CRASH_MESSAGE = "Unity Crash";
    public final String battleId;
    public final String data;
    public final int id;
    public final String message;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/local/entity/UnityCrashData$Companion;", "", "()V", "DEFAULT_CRASH_MESSAGE", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnityCrashData.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnityCrashData(int i, String str, String str2, String str3) {
        GeneratedOutlineSupport.outline97(str, WebViewGameVm.KEY_BATTLE_ID, str2, "data", str3, "message");
        this.id = i;
        this.battleId = str;
        this.data = str2;
        this.message = str3;
    }

    public static /* synthetic */ UnityCrashData copy$default(UnityCrashData unityCrashData, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = unityCrashData.id;
        }
        if ((i2 & 2) != 0) {
            str = unityCrashData.battleId;
        }
        if ((i2 & 4) != 0) {
            str2 = unityCrashData.data;
        }
        if ((i2 & 8) != 0) {
            str3 = unityCrashData.message;
        }
        return unityCrashData.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.battleId;
    }

    public final String component3() {
        return this.data;
    }

    public final String component4() {
        return this.message;
    }

    public final UnityCrashData copy(int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str2, "data");
        Intrinsics.checkNotNullParameter(str3, "message");
        return new UnityCrashData(i, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnityCrashData)) {
            return false;
        }
        UnityCrashData unityCrashData = (UnityCrashData) obj;
        return this.id == unityCrashData.id && Intrinsics.areEqual(this.battleId, unityCrashData.battleId) && Intrinsics.areEqual(this.data, unityCrashData.data) && Intrinsics.areEqual(this.message, unityCrashData.message);
    }

    public final String getBattleId() {
        return this.battleId;
    }

    public final String getData() {
        return this.data;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode() + GeneratedOutlineSupport.outline11(this.data, GeneratedOutlineSupport.outline11(this.battleId, this.id * 31, 31), 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UnityCrashData(id=");
        outline73.append(this.id);
        outline73.append(", battleId=");
        outline73.append(this.battleId);
        outline73.append(", data=");
        outline73.append(this.data);
        outline73.append(", message=");
        return GeneratedOutlineSupport.outline59(outline73, this.message, ')');
    }

    public /* synthetic */ UnityCrashData(int i, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? AnalyticsConstants.NOT_AVAILABLE : str, str2, (i2 & 8) != 0 ? "Unity Crash" : str3);
    }
}
