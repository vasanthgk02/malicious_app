package com.mpl.androidapp.miniprofile.kotlin.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.models.CometChatPayload;
import com.mpl.androidapp.miniprofile.models.CtaDetailsPayload;
import com.mpl.androidapp.miniprofile.models.VideoSegments;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bé\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\"¢\u0006\u0002\u0010&J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\t\u0010M\u001a\u00020\u0004HÆ\u0003J\t\u0010N\u001a\u00020\u0004HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0013HÆ\u0003J\t\u0010Q\u001a\u00020\u0004HÆ\u0003J\t\u0010R\u001a\u00020\u0004HÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\t\u0010T\u001a\u00020\u0004HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0004HÆ\u0003J\t\u0010Z\u001a\u00020\u0004HÆ\u0003J\t\u0010[\u001a\u00020\u0004HÆ\u0003J\t\u0010\\\u001a\u00020\u001fHÆ\u0003J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020#0\"HÆ\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020%0\"HÆ\u0003J\t\u0010`\u001a\u00020\u0004HÆ\u0003J\t\u0010a\u001a\u00020\u0004HÆ\u0003J\t\u0010b\u001a\u00020\u0004HÆ\u0003J\t\u0010c\u001a\u00020\u0004HÆ\u0003J\t\u0010d\u001a\u00020\fHÆ\u0003J\t\u0010e\u001a\u00020\u0004HÆ\u0003J\t\u0010f\u001a\u00020\u0004HÆ\u0003J£\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00062\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\"HÆ\u0001J\t\u0010h\u001a\u00020\u0006HÖ\u0001J\u0013\u0010i\u001a\u00020\u00132\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\u0006HÖ\u0001J\u0006\u0010m\u001a\u00020\u0013J\u0006\u0010n\u001a\u00020\u0013J\u0006\u0010o\u001a\u00020\u0013J\t\u0010p\u001a\u00020\u0004HÖ\u0001J\u0019\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0006HÖ\u0001R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010.\"\u0004\b5\u00106R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010.R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010.\"\u0004\bB\u00106R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bE\u0010(R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bF\u0010(R\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bG\u0010(R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\"¢\u0006\b\n\u0000\u001a\u0004\bH\u0010,R\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010.\"\u0004\bJ\u00106R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.¨\u0006w"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/Broadcast;", "Landroid/os/Parcelable;", "()V", "gameBroadcastName", "", "koTournamentId", "", "displayGameName", "displayRoundName", "displayStageName", "displayTournamentName", "durationInMils", "", "gameBroadcastId", "gameIcon", "hostedBy", "liveUrl", "liveViewCount", "reminderOn", "", "sendBirdChannelUrl", "status", "startTime", "thumbnailUrl", "totalHeartCount", "totalShareCount", "totalViewCount", "vodUrl", "watermarkVideoUrl", "tileUrl", "cometChatPayload", "Lcom/mpl/androidapp/miniprofile/models/CometChatPayload;", "cometChatHeartCount", "ctaDetailsPayload", "", "Lcom/mpl/androidapp/miniprofile/models/CtaDetailsPayload;", "videoSegments", "Lcom/mpl/androidapp/miniprofile/models/VideoSegments;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/mpl/androidapp/miniprofile/models/CometChatPayload;ILjava/util/List;Ljava/util/List;)V", "getCometChatHeartCount", "()I", "getCometChatPayload", "()Lcom/mpl/androidapp/miniprofile/models/CometChatPayload;", "getCtaDetailsPayload", "()Ljava/util/List;", "getDisplayGameName", "()Ljava/lang/String;", "getDisplayRoundName", "getDisplayStageName", "getDisplayTournamentName", "getDurationInMils", "()J", "getGameBroadcastId", "setGameBroadcastId", "(Ljava/lang/String;)V", "getGameBroadcastName", "getGameIcon", "getHostedBy", "getKoTournamentId", "getLiveUrl", "getLiveViewCount", "getReminderOn", "()Z", "getSendBirdChannelUrl", "getStartTime", "getStatus", "setStatus", "getThumbnailUrl", "getTileUrl", "getTotalHeartCount", "getTotalShareCount", "getTotalViewCount", "getVideoSegments", "getVodUrl", "setVodUrl", "getWatermarkVideoUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "isLive", "isUpcoming", "isVOD", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Broadcast.kt */
public final class Broadcast implements Parcelable {
    public static final android.os.Parcelable.Creator<Broadcast> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    public static final String STATUS_LIVE = "LIVE";
    public static final String STATUS_UPCOMING = "UPCOMING";
    public static final String STATUS_VOD = "VOD";
    public final int cometChatHeartCount;
    public final CometChatPayload cometChatPayload;
    public final List<CtaDetailsPayload> ctaDetailsPayload;
    public final String displayGameName;
    public final String displayRoundName;
    public final String displayStageName;
    public final String displayTournamentName;
    public final long durationInMils;
    public String gameBroadcastId;
    public final String gameBroadcastName;
    public final String gameIcon;
    public final String hostedBy;
    public final int koTournamentId;
    public final String liveUrl;
    public final int liveViewCount;
    public final boolean reminderOn;
    public final String sendBirdChannelUrl;
    public final long startTime;
    public String status;
    public final String thumbnailUrl;
    public final String tileUrl;
    public final int totalHeartCount;
    public final int totalShareCount;
    public final int totalViewCount;
    public final List<VideoSegments> videoSegments;
    public String vodUrl;
    public final String watermarkVideoUrl;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/Broadcast$Companion;", "", "()V", "STATUS_LIVE", "", "STATUS_UPCOMING", "STATUS_VOD", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Broadcast.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Broadcast.kt */
    public static final class Creator implements android.os.Parcelable.Creator<Broadcast> {
        public final Broadcast createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            long readLong = parcel.readLong();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            int readInt2 = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            long readLong2 = parcel.readLong();
            String readString12 = parcel.readString();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            CometChatPayload createFromParcel = CometChatPayload.CREATOR.createFromParcel(parcel2);
            int readInt6 = parcel.readInt();
            int readInt7 = parcel.readInt();
            int i = readInt2;
            ArrayList arrayList = new ArrayList(readInt7);
            int i2 = 0;
            while (i2 != readInt7) {
                arrayList.add(CtaDetailsPayload.CREATOR.createFromParcel(parcel2));
                i2++;
                readInt7 = readInt7;
            }
            int readInt8 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt8);
            ArrayList arrayList3 = arrayList;
            int i3 = 0;
            while (i3 != readInt8) {
                arrayList2.add(VideoSegments.CREATOR.createFromParcel(parcel2));
                i3++;
                readInt8 = readInt8;
            }
            Broadcast broadcast = new Broadcast(readString, readInt, readString2, readString3, readString4, readString5, readLong, readString6, readString7, readString8, readString9, i, z, readString10, readString11, readLong2, readString12, readInt3, readInt4, readInt5, readString13, readString14, readString15, createFromParcel, readInt6, arrayList3, arrayList2);
            return broadcast;
        }

        public final Broadcast[] newArray(int i) {
            return new Broadcast[i];
        }
    }

    public Broadcast(String str, int i, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, int i2, boolean z, String str10, String str11, long j2, String str12, int i3, int i4, int i5, String str13, String str14, String str15, CometChatPayload cometChatPayload2, int i6, List<CtaDetailsPayload> list, List<VideoSegments> list2) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        CometChatPayload cometChatPayload3 = cometChatPayload2;
        Intrinsics.checkNotNullParameter(str16, "gameBroadcastName");
        Intrinsics.checkNotNullParameter(str17, "displayGameName");
        Intrinsics.checkNotNullParameter(str18, "displayRoundName");
        Intrinsics.checkNotNullParameter(str19, "displayStageName");
        Intrinsics.checkNotNullParameter(str20, "displayTournamentName");
        Intrinsics.checkNotNullParameter(str21, "gameBroadcastId");
        Intrinsics.checkNotNullParameter(str22, WebViewGameVm.KEY_GAME_ICON);
        Intrinsics.checkNotNullParameter(str23, "hostedBy");
        Intrinsics.checkNotNullParameter(str24, "liveUrl");
        Intrinsics.checkNotNullParameter(str25, "sendBirdChannelUrl");
        Intrinsics.checkNotNullParameter(str26, "status");
        Intrinsics.checkNotNullParameter(str27, "thumbnailUrl");
        Intrinsics.checkNotNullParameter(str28, "vodUrl");
        Intrinsics.checkNotNullParameter(str29, "watermarkVideoUrl");
        Intrinsics.checkNotNullParameter(str15, "tileUrl");
        Intrinsics.checkNotNullParameter(cometChatPayload2, "cometChatPayload");
        Intrinsics.checkNotNullParameter(list, "ctaDetailsPayload");
        Intrinsics.checkNotNullParameter(list2, "videoSegments");
        this.gameBroadcastName = str16;
        this.koTournamentId = i;
        this.displayGameName = str17;
        this.displayRoundName = str18;
        this.displayStageName = str19;
        this.displayTournamentName = str20;
        this.durationInMils = j;
        this.gameBroadcastId = str21;
        this.gameIcon = str22;
        this.hostedBy = str23;
        this.liveUrl = str24;
        this.liveViewCount = i2;
        this.reminderOn = z;
        this.sendBirdChannelUrl = str25;
        this.status = str26;
        this.startTime = j2;
        this.thumbnailUrl = str27;
        this.totalHeartCount = i3;
        this.totalShareCount = i4;
        this.totalViewCount = i5;
        this.vodUrl = str28;
        this.watermarkVideoUrl = str29;
        this.tileUrl = str15;
        this.cometChatPayload = cometChatPayload2;
        this.cometChatHeartCount = i6;
        this.ctaDetailsPayload = list;
        this.videoSegments = list2;
    }

    public static /* synthetic */ Broadcast copy$default(Broadcast broadcast, String str, int i, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, int i2, boolean z, String str10, String str11, long j2, String str12, int i3, int i4, int i5, String str13, String str14, String str15, CometChatPayload cometChatPayload2, int i6, List list, List list2, int i7, Object obj) {
        Broadcast broadcast2 = broadcast;
        int i8 = i7;
        return broadcast.copy((i8 & 1) != 0 ? broadcast2.gameBroadcastName : str, (i8 & 2) != 0 ? broadcast2.koTournamentId : i, (i8 & 4) != 0 ? broadcast2.displayGameName : str2, (i8 & 8) != 0 ? broadcast2.displayRoundName : str3, (i8 & 16) != 0 ? broadcast2.displayStageName : str4, (i8 & 32) != 0 ? broadcast2.displayTournamentName : str5, (i8 & 64) != 0 ? broadcast2.durationInMils : j, (i8 & 128) != 0 ? broadcast2.gameBroadcastId : str6, (i8 & 256) != 0 ? broadcast2.gameIcon : str7, (i8 & 512) != 0 ? broadcast2.hostedBy : str8, (i8 & 1024) != 0 ? broadcast2.liveUrl : str9, (i8 & 2048) != 0 ? broadcast2.liveViewCount : i2, (i8 & 4096) != 0 ? broadcast2.reminderOn : z, (i8 & 8192) != 0 ? broadcast2.sendBirdChannelUrl : str10, (i8 & 16384) != 0 ? broadcast2.status : str11, (i8 & 32768) != 0 ? broadcast2.startTime : j2, (i8 & 65536) != 0 ? broadcast2.thumbnailUrl : str12, (131072 & i8) != 0 ? broadcast2.totalHeartCount : i3, (i8 & 262144) != 0 ? broadcast2.totalShareCount : i4, (i8 & 524288) != 0 ? broadcast2.totalViewCount : i5, (i8 & 1048576) != 0 ? broadcast2.vodUrl : str13, (i8 & PDChoice.FLAG_MULTI_SELECT) != 0 ? broadcast2.watermarkVideoUrl : str14, (i8 & 4194304) != 0 ? broadcast2.tileUrl : str15, (i8 & PDTextField.FLAG_DO_NOT_SCROLL) != 0 ? broadcast2.cometChatPayload : cometChatPayload2, (i8 & 16777216) != 0 ? broadcast2.cometChatHeartCount : i6, (i8 & 33554432) != 0 ? broadcast2.ctaDetailsPayload : list, (i8 & PDChoice.FLAG_COMMIT_ON_SEL_CHANGE) != 0 ? broadcast2.videoSegments : list2);
    }

    public final String component1() {
        return this.gameBroadcastName;
    }

    public final String component10() {
        return this.hostedBy;
    }

    public final String component11() {
        return this.liveUrl;
    }

    public final int component12() {
        return this.liveViewCount;
    }

    public final boolean component13() {
        return this.reminderOn;
    }

    public final String component14() {
        return this.sendBirdChannelUrl;
    }

    public final String component15() {
        return this.status;
    }

    public final long component16() {
        return this.startTime;
    }

    public final String component17() {
        return this.thumbnailUrl;
    }

    public final int component18() {
        return this.totalHeartCount;
    }

    public final int component19() {
        return this.totalShareCount;
    }

    public final int component2() {
        return this.koTournamentId;
    }

    public final int component20() {
        return this.totalViewCount;
    }

    public final String component21() {
        return this.vodUrl;
    }

    public final String component22() {
        return this.watermarkVideoUrl;
    }

    public final String component23() {
        return this.tileUrl;
    }

    public final CometChatPayload component24() {
        return this.cometChatPayload;
    }

    public final int component25() {
        return this.cometChatHeartCount;
    }

    public final List<CtaDetailsPayload> component26() {
        return this.ctaDetailsPayload;
    }

    public final List<VideoSegments> component27() {
        return this.videoSegments;
    }

    public final String component3() {
        return this.displayGameName;
    }

    public final String component4() {
        return this.displayRoundName;
    }

    public final String component5() {
        return this.displayStageName;
    }

    public final String component6() {
        return this.displayTournamentName;
    }

    public final long component7() {
        return this.durationInMils;
    }

    public final String component8() {
        return this.gameBroadcastId;
    }

    public final String component9() {
        return this.gameIcon;
    }

    public final Broadcast copy(String str, int i, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, String str9, int i2, boolean z, String str10, String str11, long j2, String str12, int i3, int i4, int i5, String str13, String str14, String str15, CometChatPayload cometChatPayload2, int i6, List<CtaDetailsPayload> list, List<VideoSegments> list2) {
        String str16 = str;
        Intrinsics.checkNotNullParameter(str16, "gameBroadcastName");
        Intrinsics.checkNotNullParameter(str2, "displayGameName");
        Intrinsics.checkNotNullParameter(str3, "displayRoundName");
        Intrinsics.checkNotNullParameter(str4, "displayStageName");
        Intrinsics.checkNotNullParameter(str5, "displayTournamentName");
        Intrinsics.checkNotNullParameter(str6, "gameBroadcastId");
        Intrinsics.checkNotNullParameter(str7, WebViewGameVm.KEY_GAME_ICON);
        Intrinsics.checkNotNullParameter(str8, "hostedBy");
        Intrinsics.checkNotNullParameter(str9, "liveUrl");
        Intrinsics.checkNotNullParameter(str10, "sendBirdChannelUrl");
        Intrinsics.checkNotNullParameter(str11, "status");
        Intrinsics.checkNotNullParameter(str12, "thumbnailUrl");
        Intrinsics.checkNotNullParameter(str13, "vodUrl");
        Intrinsics.checkNotNullParameter(str14, "watermarkVideoUrl");
        Intrinsics.checkNotNullParameter(str15, "tileUrl");
        Intrinsics.checkNotNullParameter(cometChatPayload2, "cometChatPayload");
        Intrinsics.checkNotNullParameter(list, "ctaDetailsPayload");
        Intrinsics.checkNotNullParameter(list2, "videoSegments");
        Broadcast broadcast = new Broadcast(str16, i, str2, str3, str4, str5, j, str6, str7, str8, str9, i2, z, str10, str11, j2, str12, i3, i4, i5, str13, str14, str15, cometChatPayload2, i6, list, list2);
        return broadcast;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Broadcast)) {
            return false;
        }
        Broadcast broadcast = (Broadcast) obj;
        return Intrinsics.areEqual(this.gameBroadcastName, broadcast.gameBroadcastName) && this.koTournamentId == broadcast.koTournamentId && Intrinsics.areEqual(this.displayGameName, broadcast.displayGameName) && Intrinsics.areEqual(this.displayRoundName, broadcast.displayRoundName) && Intrinsics.areEqual(this.displayStageName, broadcast.displayStageName) && Intrinsics.areEqual(this.displayTournamentName, broadcast.displayTournamentName) && this.durationInMils == broadcast.durationInMils && Intrinsics.areEqual(this.gameBroadcastId, broadcast.gameBroadcastId) && Intrinsics.areEqual(this.gameIcon, broadcast.gameIcon) && Intrinsics.areEqual(this.hostedBy, broadcast.hostedBy) && Intrinsics.areEqual(this.liveUrl, broadcast.liveUrl) && this.liveViewCount == broadcast.liveViewCount && this.reminderOn == broadcast.reminderOn && Intrinsics.areEqual(this.sendBirdChannelUrl, broadcast.sendBirdChannelUrl) && Intrinsics.areEqual(this.status, broadcast.status) && this.startTime == broadcast.startTime && Intrinsics.areEqual(this.thumbnailUrl, broadcast.thumbnailUrl) && this.totalHeartCount == broadcast.totalHeartCount && this.totalShareCount == broadcast.totalShareCount && this.totalViewCount == broadcast.totalViewCount && Intrinsics.areEqual(this.vodUrl, broadcast.vodUrl) && Intrinsics.areEqual(this.watermarkVideoUrl, broadcast.watermarkVideoUrl) && Intrinsics.areEqual(this.tileUrl, broadcast.tileUrl) && Intrinsics.areEqual(this.cometChatPayload, broadcast.cometChatPayload) && this.cometChatHeartCount == broadcast.cometChatHeartCount && Intrinsics.areEqual(this.ctaDetailsPayload, broadcast.ctaDetailsPayload) && Intrinsics.areEqual(this.videoSegments, broadcast.videoSegments);
    }

    public final int getCometChatHeartCount() {
        return this.cometChatHeartCount;
    }

    public final CometChatPayload getCometChatPayload() {
        return this.cometChatPayload;
    }

    public final List<CtaDetailsPayload> getCtaDetailsPayload() {
        return this.ctaDetailsPayload;
    }

    public final String getDisplayGameName() {
        return this.displayGameName;
    }

    public final String getDisplayRoundName() {
        return this.displayRoundName;
    }

    public final String getDisplayStageName() {
        return this.displayStageName;
    }

    public final String getDisplayTournamentName() {
        return this.displayTournamentName;
    }

    public final long getDurationInMils() {
        return this.durationInMils;
    }

    public final String getGameBroadcastId() {
        return this.gameBroadcastId;
    }

    public final String getGameBroadcastName() {
        return this.gameBroadcastName;
    }

    public final String getGameIcon() {
        return this.gameIcon;
    }

    public final String getHostedBy() {
        return this.hostedBy;
    }

    public final int getKoTournamentId() {
        return this.koTournamentId;
    }

    public final String getLiveUrl() {
        return this.liveUrl;
    }

    public final int getLiveViewCount() {
        return this.liveViewCount;
    }

    public final boolean getReminderOn() {
        return this.reminderOn;
    }

    public final String getSendBirdChannelUrl() {
        return this.sendBirdChannelUrl;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getTileUrl() {
        return this.tileUrl;
    }

    public final int getTotalHeartCount() {
        return this.totalHeartCount;
    }

    public final int getTotalShareCount() {
        return this.totalShareCount;
    }

    public final int getTotalViewCount() {
        return this.totalViewCount;
    }

    public final List<VideoSegments> getVideoSegments() {
        return this.videoSegments;
    }

    public final String getVodUrl() {
        return this.vodUrl;
    }

    public final String getWatermarkVideoUrl() {
        return this.watermarkVideoUrl;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.displayTournamentName, GeneratedOutlineSupport.outline11(this.displayStageName, GeneratedOutlineSupport.outline11(this.displayRoundName, GeneratedOutlineSupport.outline11(this.displayGameName, ((this.gameBroadcastName.hashCode() * 31) + this.koTournamentId) * 31, 31), 31), 31), 31);
        int outline112 = (GeneratedOutlineSupport.outline11(this.liveUrl, GeneratedOutlineSupport.outline11(this.hostedBy, GeneratedOutlineSupport.outline11(this.gameIcon, GeneratedOutlineSupport.outline11(this.gameBroadcastId, (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.durationInMils) + outline11) * 31, 31), 31), 31), 31) + this.liveViewCount) * 31;
        boolean z = this.reminderOn;
        if (z) {
            z = true;
        }
        int outline113 = GeneratedOutlineSupport.outline11(this.status, GeneratedOutlineSupport.outline11(this.sendBirdChannelUrl, (outline112 + (z ? 1 : 0)) * 31, 31), 31);
        String str = this.thumbnailUrl;
        int outline114 = GeneratedOutlineSupport.outline11(this.tileUrl, GeneratedOutlineSupport.outline11(this.watermarkVideoUrl, GeneratedOutlineSupport.outline11(this.vodUrl, (((((GeneratedOutlineSupport.outline11(str, (C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.startTime) + outline113) * 31, 31) + this.totalHeartCount) * 31) + this.totalShareCount) * 31) + this.totalViewCount) * 31, 31), 31), 31);
        int hashCode = this.ctaDetailsPayload.hashCode();
        return this.videoSegments.hashCode() + ((hashCode + ((((this.cometChatPayload.hashCode() + outline114) * 31) + this.cometChatHeartCount) * 31)) * 31);
    }

    public final boolean isLive() {
        return Intrinsics.areEqual(this.status, "LIVE");
    }

    public final boolean isUpcoming() {
        return Intrinsics.areEqual(this.status, STATUS_UPCOMING);
    }

    public final boolean isVOD() {
        return Intrinsics.areEqual(this.status, STATUS_VOD);
    }

    public final void setGameBroadcastId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gameBroadcastId = str;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final void setVodUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vodUrl = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Broadcast(gameBroadcastName=");
        outline73.append(this.gameBroadcastName);
        outline73.append(", koTournamentId=");
        outline73.append(this.koTournamentId);
        outline73.append(", displayGameName=");
        outline73.append(this.displayGameName);
        outline73.append(", displayRoundName=");
        outline73.append(this.displayRoundName);
        outline73.append(", displayStageName=");
        outline73.append(this.displayStageName);
        outline73.append(", displayTournamentName=");
        outline73.append(this.displayTournamentName);
        outline73.append(", durationInMils=");
        outline73.append(this.durationInMils);
        outline73.append(", gameBroadcastId=");
        outline73.append(this.gameBroadcastId);
        outline73.append(", gameIcon=");
        outline73.append(this.gameIcon);
        outline73.append(", hostedBy=");
        outline73.append(this.hostedBy);
        outline73.append(", liveUrl=");
        outline73.append(this.liveUrl);
        outline73.append(", liveViewCount=");
        outline73.append(this.liveViewCount);
        outline73.append(", reminderOn=");
        outline73.append(this.reminderOn);
        outline73.append(", sendBirdChannelUrl=");
        outline73.append(this.sendBirdChannelUrl);
        outline73.append(", status=");
        outline73.append(this.status);
        outline73.append(", startTime=");
        outline73.append(this.startTime);
        outline73.append(", thumbnailUrl=");
        outline73.append(this.thumbnailUrl);
        outline73.append(", totalHeartCount=");
        outline73.append(this.totalHeartCount);
        outline73.append(", totalShareCount=");
        outline73.append(this.totalShareCount);
        outline73.append(", totalViewCount=");
        outline73.append(this.totalViewCount);
        outline73.append(", vodUrl=");
        outline73.append(this.vodUrl);
        outline73.append(", watermarkVideoUrl=");
        outline73.append(this.watermarkVideoUrl);
        outline73.append(", tileUrl=");
        outline73.append(this.tileUrl);
        outline73.append(", cometChatPayload=");
        outline73.append(this.cometChatPayload);
        outline73.append(", cometChatHeartCount=");
        outline73.append(this.cometChatHeartCount);
        outline73.append(", ctaDetailsPayload=");
        outline73.append(this.ctaDetailsPayload);
        outline73.append(", videoSegments=");
        outline73.append(this.videoSegments);
        outline73.append(')');
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.gameBroadcastName);
        parcel.writeInt(this.koTournamentId);
        parcel.writeString(this.displayGameName);
        parcel.writeString(this.displayRoundName);
        parcel.writeString(this.displayStageName);
        parcel.writeString(this.displayTournamentName);
        parcel.writeLong(this.durationInMils);
        parcel.writeString(this.gameBroadcastId);
        parcel.writeString(this.gameIcon);
        parcel.writeString(this.hostedBy);
        parcel.writeString(this.liveUrl);
        parcel.writeInt(this.liveViewCount);
        parcel.writeInt(this.reminderOn ? 1 : 0);
        parcel.writeString(this.sendBirdChannelUrl);
        parcel.writeString(this.status);
        parcel.writeLong(this.startTime);
        parcel.writeString(this.thumbnailUrl);
        parcel.writeInt(this.totalHeartCount);
        parcel.writeInt(this.totalShareCount);
        parcel.writeInt(this.totalViewCount);
        parcel.writeString(this.vodUrl);
        parcel.writeString(this.watermarkVideoUrl);
        parcel.writeString(this.tileUrl);
        this.cometChatPayload.writeToParcel(parcel, i);
        parcel.writeInt(this.cometChatHeartCount);
        List<CtaDetailsPayload> list = this.ctaDetailsPayload;
        parcel.writeInt(list.size());
        for (CtaDetailsPayload writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
        List<VideoSegments> list2 = this.videoSegments;
        parcel.writeInt(list2.size());
        for (VideoSegments writeToParcel2 : list2) {
            writeToParcel2.writeToParcel(parcel, i);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Broadcast() {
        /*
            r30 = this;
            r0 = r30
            com.mpl.androidapp.miniprofile.models.CometChatPayload r1 = new com.mpl.androidapp.miniprofile.models.CometChatPayload
            r26 = r1
            java.lang.String r2 = ""
            r1.<init>(r2, r2, r2)
            com.mpl.androidapp.miniprofile.models.CtaDetailsPayload r1 = new com.mpl.androidapp.miniprofile.models.CtaDetailsPayload
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r11 = 600(0x258, float:8.41E-43)
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            java.util.List r28 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r29 = r1
            r1.<init>()
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            r7 = -1
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            java.lang.String r12 = ""
            r13 = -1
            r14 = 0
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            r17 = -1
            java.lang.String r19 = ""
            r20 = -1
            r21 = -1
            r22 = -1
            java.lang.String r23 = ""
            java.lang.String r24 = ""
            java.lang.String r25 = ""
            r27 = -1
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.miniprofile.kotlin.model.Broadcast.<init>():void");
    }
}
