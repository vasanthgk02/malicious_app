package com.mpl.androidapp.unity.deepLink;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/unity/deepLink/UnityUserProfileParam;", "", "id", "", "entryPoint", "", "from", "gameView", "Lcom/mpl/androidapp/unity/deepLink/GameIdParam;", "(ILjava/lang/String;Ljava/lang/String;Lcom/mpl/androidapp/unity/deepLink/GameIdParam;)V", "getEntryPoint", "()Ljava/lang/String;", "getFrom", "getGameView", "()Lcom/mpl/androidapp/unity/deepLink/GameIdParam;", "getId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityUserProfileParam.kt */
public final class UnityUserProfileParam {
    public final String entryPoint;
    public final String from;
    public final GameIdParam gameView;
    public final int id;

    public UnityUserProfileParam(int i, String str, String str2, GameIdParam gameIdParam) {
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        Intrinsics.checkNotNullParameter(str2, "from");
        Intrinsics.checkNotNullParameter(gameIdParam, "gameView");
        this.id = i;
        this.entryPoint = str;
        this.from = str2;
        this.gameView = gameIdParam;
    }

    public static /* synthetic */ UnityUserProfileParam copy$default(UnityUserProfileParam unityUserProfileParam, int i, String str, String str2, GameIdParam gameIdParam, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = unityUserProfileParam.id;
        }
        if ((i2 & 2) != 0) {
            str = unityUserProfileParam.entryPoint;
        }
        if ((i2 & 4) != 0) {
            str2 = unityUserProfileParam.from;
        }
        if ((i2 & 8) != 0) {
            gameIdParam = unityUserProfileParam.gameView;
        }
        return unityUserProfileParam.copy(i, str, str2, gameIdParam);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.entryPoint;
    }

    public final String component3() {
        return this.from;
    }

    public final GameIdParam component4() {
        return this.gameView;
    }

    public final UnityUserProfileParam copy(int i, String str, String str2, GameIdParam gameIdParam) {
        Intrinsics.checkNotNullParameter(str, "entryPoint");
        Intrinsics.checkNotNullParameter(str2, "from");
        Intrinsics.checkNotNullParameter(gameIdParam, "gameView");
        return new UnityUserProfileParam(i, str, str2, gameIdParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnityUserProfileParam)) {
            return false;
        }
        UnityUserProfileParam unityUserProfileParam = (UnityUserProfileParam) obj;
        return this.id == unityUserProfileParam.id && Intrinsics.areEqual(this.entryPoint, unityUserProfileParam.entryPoint) && Intrinsics.areEqual(this.from, unityUserProfileParam.from) && Intrinsics.areEqual(this.gameView, unityUserProfileParam.gameView);
    }

    public final String getEntryPoint() {
        return this.entryPoint;
    }

    public final String getFrom() {
        return this.from;
    }

    public final GameIdParam getGameView() {
        return this.gameView;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return this.gameView.hashCode() + GeneratedOutlineSupport.outline11(this.from, GeneratedOutlineSupport.outline11(this.entryPoint, this.id * 31, 31), 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UnityUserProfileParam(id=");
        outline73.append(this.id);
        outline73.append(", entryPoint=");
        outline73.append(this.entryPoint);
        outline73.append(", from=");
        outline73.append(this.from);
        outline73.append(", gameView=");
        outline73.append(this.gameView);
        outline73.append(')');
        return outline73.toString();
    }
}
