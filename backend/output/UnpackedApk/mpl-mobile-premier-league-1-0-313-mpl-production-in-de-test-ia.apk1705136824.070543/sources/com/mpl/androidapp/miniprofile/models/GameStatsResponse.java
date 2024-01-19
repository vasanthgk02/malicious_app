package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/GameStatsResponse;", "", "status", "Lcom/mpl/androidapp/miniprofile/models/Status;", "payload", "Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "(Lcom/mpl/androidapp/miniprofile/models/Status;Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;)V", "getPayload", "()Lcom/mpl/androidapp/miniprofile/models/GameStatsPayload;", "getStatus", "()Lcom/mpl/androidapp/miniprofile/models/Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStatsResponse.kt */
public final class GameStatsResponse {
    @SerializedName("payload")
    public final GameStatsPayload payload;
    public final Status status;

    public GameStatsResponse(Status status2, GameStatsPayload gameStatsPayload) {
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(gameStatsPayload, "payload");
        this.status = status2;
        this.payload = gameStatsPayload;
    }

    public static /* synthetic */ GameStatsResponse copy$default(GameStatsResponse gameStatsResponse, Status status2, GameStatsPayload gameStatsPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            status2 = gameStatsResponse.status;
        }
        if ((i & 2) != 0) {
            gameStatsPayload = gameStatsResponse.payload;
        }
        return gameStatsResponse.copy(status2, gameStatsPayload);
    }

    public final Status component1() {
        return this.status;
    }

    public final GameStatsPayload component2() {
        return this.payload;
    }

    public final GameStatsResponse copy(Status status2, GameStatsPayload gameStatsPayload) {
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(gameStatsPayload, "payload");
        return new GameStatsResponse(status2, gameStatsPayload);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameStatsResponse)) {
            return false;
        }
        GameStatsResponse gameStatsResponse = (GameStatsResponse) obj;
        return Intrinsics.areEqual(this.status, gameStatsResponse.status) && Intrinsics.areEqual(this.payload, gameStatsResponse.payload);
    }

    public final GameStatsPayload getPayload() {
        return this.payload;
    }

    public final Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.payload.hashCode() + (this.status.hashCode() * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameStatsResponse(status=");
        outline73.append(this.status);
        outline73.append(", payload=");
        outline73.append(this.payload);
        outline73.append(')');
        return outline73.toString();
    }
}
