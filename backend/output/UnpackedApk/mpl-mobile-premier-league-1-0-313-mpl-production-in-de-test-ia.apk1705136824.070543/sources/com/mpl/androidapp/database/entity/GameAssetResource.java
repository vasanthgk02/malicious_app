package com.mpl.androidapp.database.entity;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/mpl/androidapp/database/entity/GameAssetResource;", "", "gameId", "", "name", "downloadId", "", "downloadFileName", "downloadFilePath", "optScreenUserVisit", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Z)V", "getDownloadFileName", "()Ljava/lang/String;", "getDownloadFilePath", "getDownloadId", "()J", "getGameId", "getName", "getOptScreenUserVisit", "()Z", "setOptScreenUserVisit", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameAssetResource.kt */
public final class GameAssetResource {
    public final String downloadFileName;
    public final String downloadFilePath;
    public final long downloadId;
    public final String gameId;
    public final String name;
    public boolean optScreenUserVisit;

    public GameAssetResource(String str, String str2, long j, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "gameId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "downloadFileName");
        Intrinsics.checkNotNullParameter(str4, "downloadFilePath");
        this.gameId = str;
        this.name = str2;
        this.downloadId = j;
        this.downloadFileName = str3;
        this.downloadFilePath = str4;
        this.optScreenUserVisit = z;
    }

    public static /* synthetic */ GameAssetResource copy$default(GameAssetResource gameAssetResource, String str, String str2, long j, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameAssetResource.gameId;
        }
        if ((i & 2) != 0) {
            str2 = gameAssetResource.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            j = gameAssetResource.downloadId;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str3 = gameAssetResource.downloadFileName;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = gameAssetResource.downloadFilePath;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            z = gameAssetResource.optScreenUserVisit;
        }
        return gameAssetResource.copy(str, str5, j2, str6, str7, z);
    }

    public final String component1() {
        return this.gameId;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.downloadId;
    }

    public final String component4() {
        return this.downloadFileName;
    }

    public final String component5() {
        return this.downloadFilePath;
    }

    public final boolean component6() {
        return this.optScreenUserVisit;
    }

    public final GameAssetResource copy(String str, String str2, long j, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "gameId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "downloadFileName");
        Intrinsics.checkNotNullParameter(str4, "downloadFilePath");
        GameAssetResource gameAssetResource = new GameAssetResource(str, str2, j, str3, str4, z);
        return gameAssetResource;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameAssetResource)) {
            return false;
        }
        GameAssetResource gameAssetResource = (GameAssetResource) obj;
        return Intrinsics.areEqual(this.gameId, gameAssetResource.gameId) && Intrinsics.areEqual(this.name, gameAssetResource.name) && this.downloadId == gameAssetResource.downloadId && Intrinsics.areEqual(this.downloadFileName, gameAssetResource.downloadFileName) && Intrinsics.areEqual(this.downloadFilePath, gameAssetResource.downloadFilePath) && this.optScreenUserVisit == gameAssetResource.optScreenUserVisit;
    }

    public final String getDownloadFileName() {
        return this.downloadFileName;
    }

    public final String getDownloadFilePath() {
        return this.downloadFilePath;
    }

    public final long getDownloadId() {
        return this.downloadId;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getOptScreenUserVisit() {
        return this.optScreenUserVisit;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.name, this.gameId.hashCode() * 31, 31);
        int outline112 = GeneratedOutlineSupport.outline11(this.downloadFilePath, GeneratedOutlineSupport.outline11(this.downloadFileName, (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.downloadId) + outline11) * 31, 31), 31);
        boolean z = this.optScreenUserVisit;
        if (z) {
            z = true;
        }
        return outline112 + (z ? 1 : 0);
    }

    public final void setOptScreenUserVisit(boolean z) {
        this.optScreenUserVisit = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameAssetResource(gameId=");
        outline73.append(this.gameId);
        outline73.append(", name=");
        outline73.append(this.name);
        outline73.append(", downloadId=");
        outline73.append(this.downloadId);
        outline73.append(", downloadFileName=");
        outline73.append(this.downloadFileName);
        outline73.append(", downloadFilePath=");
        outline73.append(this.downloadFilePath);
        outline73.append(", optScreenUserVisit=");
        return GeneratedOutlineSupport.outline65(outline73, this.optScreenUserVisit, ')');
    }

    public /* synthetic */ GameAssetResource(String str, String str2, long j, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, (i & 32) != 0 ? false : z);
    }
}
