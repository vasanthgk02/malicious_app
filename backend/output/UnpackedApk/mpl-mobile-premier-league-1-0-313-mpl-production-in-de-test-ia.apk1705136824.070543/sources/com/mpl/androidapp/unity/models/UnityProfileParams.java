package com.mpl.androidapp.unity.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.unity.utils.UnityProfileConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/unity/models/UnityProfileParams;", "", "profileId", "", "gameId", "", "(Ljava/lang/String;I)V", "getGameId", "()I", "getProfileId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityProfileParams.kt */
public final class UnityProfileParams {
    public final int gameId;
    public final String profileId;

    public UnityProfileParams(String str, int i) {
        Intrinsics.checkNotNullParameter(str, UnityProfileConstants.PROFILE_ID);
        this.profileId = str;
        this.gameId = i;
    }

    public static /* synthetic */ UnityProfileParams copy$default(UnityProfileParams unityProfileParams, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = unityProfileParams.profileId;
        }
        if ((i2 & 2) != 0) {
            i = unityProfileParams.gameId;
        }
        return unityProfileParams.copy(str, i);
    }

    public final String component1() {
        return this.profileId;
    }

    public final int component2() {
        return this.gameId;
    }

    public final UnityProfileParams copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, UnityProfileConstants.PROFILE_ID);
        return new UnityProfileParams(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnityProfileParams)) {
            return false;
        }
        UnityProfileParams unityProfileParams = (UnityProfileParams) obj;
        return Intrinsics.areEqual(this.profileId, unityProfileParams.profileId) && this.gameId == unityProfileParams.gameId;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public int hashCode() {
        return (this.profileId.hashCode() * 31) + this.gameId;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UnityProfileParams(profileId=");
        outline73.append(this.profileId);
        outline73.append(", gameId=");
        return GeneratedOutlineSupport.outline56(outline73, this.gameId, ')');
    }
}
