package com.mpl.androidapp.game.androidgames.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lcom/mpl/androidapp/game/androidgames/data/GameData;", "", "gameId", "", "authToken", "", "battleId", "connectTimeout", "readTimeout", "automaticReconnection", "emojiEnabled", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAuthToken", "()Ljava/lang/String;", "getAutomaticReconnection", "getBattleId", "getConnectTimeout", "getEmojiEnabled", "()Z", "getGameId", "()I", "getReadTimeout", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameData.kt */
public final class GameData {
    public final String authToken;
    public final String automaticReconnection;
    public final String battleId;
    public final String connectTimeout;
    public final boolean emojiEnabled;
    public final int gameId;
    public final String readTimeout;

    public GameData() {
        this(0, null, null, null, null, null, false, 127, null);
    }

    public GameData(int i, String str, String str2, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "authToken");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str3, "connectTimeout");
        Intrinsics.checkNotNullParameter(str4, "readTimeout");
        Intrinsics.checkNotNullParameter(str5, "automaticReconnection");
        this.gameId = i;
        this.authToken = str;
        this.battleId = str2;
        this.connectTimeout = str3;
        this.readTimeout = str4;
        this.automaticReconnection = str5;
        this.emojiEnabled = z;
    }

    public static /* synthetic */ GameData copy$default(GameData gameData, int i, String str, String str2, String str3, String str4, String str5, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gameData.gameId;
        }
        if ((i2 & 2) != 0) {
            str = gameData.authToken;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = gameData.battleId;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = gameData.connectTimeout;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = gameData.readTimeout;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = gameData.automaticReconnection;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            z = gameData.emojiEnabled;
        }
        return gameData.copy(i, str6, str7, str8, str9, str10, z);
    }

    public final int component1() {
        return this.gameId;
    }

    public final String component2() {
        return this.authToken;
    }

    public final String component3() {
        return this.battleId;
    }

    public final String component4() {
        return this.connectTimeout;
    }

    public final String component5() {
        return this.readTimeout;
    }

    public final String component6() {
        return this.automaticReconnection;
    }

    public final boolean component7() {
        return this.emojiEnabled;
    }

    public final GameData copy(int i, String str, String str2, String str3, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(str, "authToken");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str3, "connectTimeout");
        Intrinsics.checkNotNullParameter(str4, "readTimeout");
        Intrinsics.checkNotNullParameter(str5, "automaticReconnection");
        GameData gameData = new GameData(i, str, str2, str3, str4, str5, z);
        return gameData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameData)) {
            return false;
        }
        GameData gameData = (GameData) obj;
        return this.gameId == gameData.gameId && Intrinsics.areEqual(this.authToken, gameData.authToken) && Intrinsics.areEqual(this.battleId, gameData.battleId) && Intrinsics.areEqual(this.connectTimeout, gameData.connectTimeout) && Intrinsics.areEqual(this.readTimeout, gameData.readTimeout) && Intrinsics.areEqual(this.automaticReconnection, gameData.automaticReconnection) && this.emojiEnabled == gameData.emojiEnabled;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final String getAutomaticReconnection() {
        return this.automaticReconnection;
    }

    public final String getBattleId() {
        return this.battleId;
    }

    public final String getConnectTimeout() {
        return this.connectTimeout;
    }

    public final boolean getEmojiEnabled() {
        return this.emojiEnabled;
    }

    public final int getGameId() {
        return this.gameId;
    }

    public final String getReadTimeout() {
        return this.readTimeout;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.automaticReconnection, GeneratedOutlineSupport.outline11(this.readTimeout, GeneratedOutlineSupport.outline11(this.connectTimeout, GeneratedOutlineSupport.outline11(this.battleId, GeneratedOutlineSupport.outline11(this.authToken, this.gameId * 31, 31), 31), 31), 31), 31);
        boolean z = this.emojiEnabled;
        if (z) {
            z = true;
        }
        return outline11 + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GameData(gameId=");
        outline73.append(this.gameId);
        outline73.append(", authToken=");
        outline73.append(this.authToken);
        outline73.append(", battleId=");
        outline73.append(this.battleId);
        outline73.append(", connectTimeout=");
        outline73.append(this.connectTimeout);
        outline73.append(", readTimeout=");
        outline73.append(this.readTimeout);
        outline73.append(", automaticReconnection=");
        outline73.append(this.automaticReconnection);
        outline73.append(", emojiEnabled=");
        return GeneratedOutlineSupport.outline65(outline73, this.emojiEnabled, ')');
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GameData(int r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = 0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            java.lang.String r1 = ""
            if (r7 == 0) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r8
        L_0x0011:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0017
            r3 = r1
            goto L_0x0018
        L_0x0017:
            r3 = r9
        L_0x0018:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001e
            r4 = r1
            goto L_0x001f
        L_0x001e:
            r4 = r10
        L_0x001f:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0025
            r5 = r1
            goto L_0x0026
        L_0x0025:
            r5 = r11
        L_0x0026:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r12
        L_0x002c:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0032
            r14 = 0
            goto L_0x0033
        L_0x0032:
            r14 = r13
        L_0x0033:
            r7 = r6
            r8 = r15
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r5
            r13 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.game.androidgames.data.GameData.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
