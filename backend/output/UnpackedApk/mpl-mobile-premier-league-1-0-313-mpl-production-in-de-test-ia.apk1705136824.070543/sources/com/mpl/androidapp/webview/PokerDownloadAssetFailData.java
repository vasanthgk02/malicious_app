package com.mpl.androidapp.webview;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mpl/androidapp/webview/PokerDownloadAssetFailData;", "", "gameId", "", "newVersion", "(II)V", "getGameId", "()I", "getNewVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PokerWebViewVm.kt */
public final class PokerDownloadAssetFailData {
    public final int gameId;
    public final int newVersion;

    public PokerDownloadAssetFailData(int i, int i2) {
        this.gameId = i;
        this.newVersion = i2;
    }

    public static /* synthetic */ PokerDownloadAssetFailData copy$default(PokerDownloadAssetFailData pokerDownloadAssetFailData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pokerDownloadAssetFailData.gameId;
        }
        if ((i3 & 2) != 0) {
            i2 = pokerDownloadAssetFailData.newVersion;
        }
        return pokerDownloadAssetFailData.copy(i, i2);
    }

    public final int component1() {
        return this.gameId;
    }

    public final int component2() {
        return this.newVersion;
    }

    public final PokerDownloadAssetFailData copy(int i, int i2) {
        return new PokerDownloadAssetFailData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PokerDownloadAssetFailData)) {
            return false;
        }
        PokerDownloadAssetFailData pokerDownloadAssetFailData = (PokerDownloadAssetFailData) obj;
        return this.gameId == pokerDownloadAssetFailData.gameId && this.newVersion == pokerDownloadAssetFailData.newVersion;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final int getNewVersion() {
        return this.newVersion;
    }

    public int hashCode() {
        return (this.gameId * 31) + this.newVersion;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PokerDownloadAssetFailData(gameId=");
        outline73.append(this.gameId);
        outline73.append(", newVersion=");
        return GeneratedOutlineSupport.outline56(outline73, this.newVersion, ')');
    }
}
