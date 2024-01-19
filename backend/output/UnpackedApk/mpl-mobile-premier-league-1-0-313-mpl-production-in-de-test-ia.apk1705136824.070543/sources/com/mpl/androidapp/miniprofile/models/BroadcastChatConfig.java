package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u0001:\u0001&BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/BroadcastChatConfig;", "", "shareEnabled", "", "externalShareEnabled", "internalShareEnabled", "chatEnabled", "heartThrottle", "", "heartsEnabled", "shareText", "", "isDefaultFlowEnabled", "(ZZZZJZLjava/lang/String;Z)V", "getChatEnabled", "()Z", "getExternalShareEnabled", "getHeartThrottle", "()J", "getHeartsEnabled", "getInternalShareEnabled", "getShareEnabled", "getShareText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BroadcastChatConfig.kt */
public final class BroadcastChatConfig {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_SHARE_TEXT = "Now watch game streams on MPL!\n\nBig prizes, Pro Players competing and Live streamed on MPL app.";
    public final boolean chatEnabled;
    public final boolean externalShareEnabled;
    public final long heartThrottle;
    public final boolean heartsEnabled;
    public final boolean internalShareEnabled;
    public final boolean isDefaultFlowEnabled;
    public final boolean shareEnabled;
    public final String shareText;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/BroadcastChatConfig$Companion;", "", "()V", "DEFAULT_SHARE_TEXT", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BroadcastChatConfig.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BroadcastChatConfig() {
        this(false, false, false, false, 0, false, null, false, InvitationReply.EXPIRED, null);
    }

    public BroadcastChatConfig(boolean z, boolean z2, boolean z3, boolean z4, long j, boolean z5, String str, boolean z6) {
        Intrinsics.checkNotNullParameter(str, "shareText");
        this.shareEnabled = z;
        this.externalShareEnabled = z2;
        this.internalShareEnabled = z3;
        this.chatEnabled = z4;
        this.heartThrottle = j;
        this.heartsEnabled = z5;
        this.shareText = str;
        this.isDefaultFlowEnabled = z6;
    }

    public static /* synthetic */ BroadcastChatConfig copy$default(BroadcastChatConfig broadcastChatConfig, boolean z, boolean z2, boolean z3, boolean z4, long j, boolean z5, String str, boolean z6, int i, Object obj) {
        BroadcastChatConfig broadcastChatConfig2 = broadcastChatConfig;
        int i2 = i;
        return broadcastChatConfig.copy((i2 & 1) != 0 ? broadcastChatConfig2.shareEnabled : z, (i2 & 2) != 0 ? broadcastChatConfig2.externalShareEnabled : z2, (i2 & 4) != 0 ? broadcastChatConfig2.internalShareEnabled : z3, (i2 & 8) != 0 ? broadcastChatConfig2.chatEnabled : z4, (i2 & 16) != 0 ? broadcastChatConfig2.heartThrottle : j, (i2 & 32) != 0 ? broadcastChatConfig2.heartsEnabled : z5, (i2 & 64) != 0 ? broadcastChatConfig2.shareText : str, (i2 & 128) != 0 ? broadcastChatConfig2.isDefaultFlowEnabled : z6);
    }

    public final boolean component1() {
        return this.shareEnabled;
    }

    public final boolean component2() {
        return this.externalShareEnabled;
    }

    public final boolean component3() {
        return this.internalShareEnabled;
    }

    public final boolean component4() {
        return this.chatEnabled;
    }

    public final long component5() {
        return this.heartThrottle;
    }

    public final boolean component6() {
        return this.heartsEnabled;
    }

    public final String component7() {
        return this.shareText;
    }

    public final boolean component8() {
        return this.isDefaultFlowEnabled;
    }

    public final BroadcastChatConfig copy(boolean z, boolean z2, boolean z3, boolean z4, long j, boolean z5, String str, boolean z6) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "shareText");
        BroadcastChatConfig broadcastChatConfig = new BroadcastChatConfig(z, z2, z3, z4, j, z5, str2, z6);
        return broadcastChatConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BroadcastChatConfig)) {
            return false;
        }
        BroadcastChatConfig broadcastChatConfig = (BroadcastChatConfig) obj;
        return this.shareEnabled == broadcastChatConfig.shareEnabled && this.externalShareEnabled == broadcastChatConfig.externalShareEnabled && this.internalShareEnabled == broadcastChatConfig.internalShareEnabled && this.chatEnabled == broadcastChatConfig.chatEnabled && this.heartThrottle == broadcastChatConfig.heartThrottle && this.heartsEnabled == broadcastChatConfig.heartsEnabled && Intrinsics.areEqual(this.shareText, broadcastChatConfig.shareText) && this.isDefaultFlowEnabled == broadcastChatConfig.isDefaultFlowEnabled;
    }

    public final boolean getChatEnabled() {
        return this.chatEnabled;
    }

    public final boolean getExternalShareEnabled() {
        return this.externalShareEnabled;
    }

    public final long getHeartThrottle() {
        return this.heartThrottle;
    }

    public final boolean getHeartsEnabled() {
        return this.heartsEnabled;
    }

    public final boolean getInternalShareEnabled() {
        return this.internalShareEnabled;
    }

    public final boolean getShareEnabled() {
        return this.shareEnabled;
    }

    public final String getShareText() {
        return this.shareText;
    }

    public int hashCode() {
        boolean z = this.shareEnabled;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        boolean z2 = this.externalShareEnabled;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.internalShareEnabled;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.chatEnabled;
        if (z4) {
            z4 = true;
        }
        int hashCode = (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.heartThrottle) + ((i4 + (z4 ? 1 : 0)) * 31)) * 31;
        boolean z5 = this.heartsEnabled;
        if (z5) {
            z5 = true;
        }
        int outline11 = GeneratedOutlineSupport.outline11(this.shareText, (hashCode + (z5 ? 1 : 0)) * 31, 31);
        boolean z6 = this.isDefaultFlowEnabled;
        if (!z6) {
            i = z6;
        }
        return outline11 + i;
    }

    public final boolean isDefaultFlowEnabled() {
        return this.isDefaultFlowEnabled;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BroadcastChatConfig(shareEnabled=");
        outline73.append(this.shareEnabled);
        outline73.append(", externalShareEnabled=");
        outline73.append(this.externalShareEnabled);
        outline73.append(", internalShareEnabled=");
        outline73.append(this.internalShareEnabled);
        outline73.append(", chatEnabled=");
        outline73.append(this.chatEnabled);
        outline73.append(", heartThrottle=");
        outline73.append(this.heartThrottle);
        outline73.append(", heartsEnabled=");
        outline73.append(this.heartsEnabled);
        outline73.append(", shareText=");
        outline73.append(this.shareText);
        outline73.append(", isDefaultFlowEnabled=");
        return GeneratedOutlineSupport.outline65(outline73, this.isDefaultFlowEnabled, ')');
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BroadcastChatConfig(boolean r11, boolean r12, boolean r13, boolean r14, long r15, boolean r17, java.lang.String r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r1 = 1
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = 1
            goto L_0x0018
        L_0x0017:
            r4 = r13
        L_0x0018:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x001f
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = r14
        L_0x0020:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0027
            r7 = 2000(0x7d0, double:9.88E-321)
            goto L_0x0028
        L_0x0027:
            r7 = r15
        L_0x0028:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r2 = r17
        L_0x002f:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0036
            java.lang.String r9 = "Now watch game streams on MPL!\n\nBig prizes, Pro Players competing and Live streamed on MPL app."
            goto L_0x0038
        L_0x0036:
            r9 = r18
        L_0x0038:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r6 = r19
        L_0x003f:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r7
            r18 = r2
            r19 = r9
            r20 = r6
            r11.<init>(r12, r13, r14, r15, r16, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.miniprofile.models.BroadcastChatConfig.<init>(boolean, boolean, boolean, boolean, long, boolean, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
