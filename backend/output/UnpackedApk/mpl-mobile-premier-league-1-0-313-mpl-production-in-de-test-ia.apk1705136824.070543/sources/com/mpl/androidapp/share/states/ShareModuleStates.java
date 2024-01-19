package com.mpl.androidapp.share.states;

import android.content.Intent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.share.models.ShareData;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/share/states/ShareModuleStates;", "", "()V", "ErrorState", "InitialState", "ShareIntent", "SharePlatformValidation", "Lcom/mpl/androidapp/share/states/ShareModuleStates$InitialState;", "Lcom/mpl/androidapp/share/states/ShareModuleStates$SharePlatformValidation;", "Lcom/mpl/androidapp/share/states/ShareModuleStates$ShareIntent;", "Lcom/mpl/androidapp/share/states/ShareModuleStates$ErrorState;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShareModuleStates.kt */
public abstract class ShareModuleStates {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/share/states/ShareModuleStates$ErrorState;", "Lcom/mpl/androidapp/share/states/ShareModuleStates;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShareModuleStates.kt */
    public static final class ErrorState extends ShareModuleStates {
        public final String errorMessage;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ErrorState(String str) {
            // Intrinsics.checkNotNullParameter(str, "errorMessage");
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ ErrorState copy$default(ErrorState errorState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = errorState.errorMessage;
            }
            return errorState.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final ErrorState copy(String str) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new ErrorState(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ErrorState) && Intrinsics.areEqual(this.errorMessage, ((ErrorState) obj).errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ErrorState(errorMessage="), this.errorMessage, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/share/states/ShareModuleStates$InitialState;", "Lcom/mpl/androidapp/share/states/ShareModuleStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShareModuleStates.kt */
    public static final class InitialState extends ShareModuleStates {
        public static final InitialState INSTANCE = new InitialState();

        public InitialState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/share/states/ShareModuleStates$ShareIntent;", "Lcom/mpl/androidapp/share/states/ShareModuleStates;", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShareModuleStates.kt */
    public static final class ShareIntent extends ShareModuleStates {
        public final Intent intent;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ShareIntent(Intent intent2) {
            // Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            super(null);
            this.intent = intent2;
        }

        public static /* synthetic */ ShareIntent copy$default(ShareIntent shareIntent, Intent intent2, int i, Object obj) {
            if ((i & 1) != 0) {
                intent2 = shareIntent.intent;
            }
            return shareIntent.copy(intent2);
        }

        public final Intent component1() {
            return this.intent;
        }

        public final ShareIntent copy(Intent intent2) {
            Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            return new ShareIntent(intent2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShareIntent) && Intrinsics.areEqual(this.intent, ((ShareIntent) obj).intent);
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public int hashCode() {
            return this.intent.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ShareIntent(intent=");
            outline73.append(this.intent);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/share/states/ShareModuleStates$SharePlatformValidation;", "Lcom/mpl/androidapp/share/states/ShareModuleStates;", "shareData", "Lcom/mpl/androidapp/share/models/ShareData;", "(Lcom/mpl/androidapp/share/models/ShareData;)V", "getShareData", "()Lcom/mpl/androidapp/share/models/ShareData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShareModuleStates.kt */
    public static final class SharePlatformValidation extends ShareModuleStates {
        public final ShareData shareData;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public SharePlatformValidation(ShareData shareData2) {
            // Intrinsics.checkNotNullParameter(shareData2, "shareData");
            super(null);
            this.shareData = shareData2;
        }

        public static /* synthetic */ SharePlatformValidation copy$default(SharePlatformValidation sharePlatformValidation, ShareData shareData2, int i, Object obj) {
            if ((i & 1) != 0) {
                shareData2 = sharePlatformValidation.shareData;
            }
            return sharePlatformValidation.copy(shareData2);
        }

        public final ShareData component1() {
            return this.shareData;
        }

        public final SharePlatformValidation copy(ShareData shareData2) {
            Intrinsics.checkNotNullParameter(shareData2, "shareData");
            return new SharePlatformValidation(shareData2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SharePlatformValidation) && Intrinsics.areEqual(this.shareData, ((SharePlatformValidation) obj).shareData);
        }

        public final ShareData getShareData() {
            return this.shareData;
        }

        public int hashCode() {
            return this.shareData.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SharePlatformValidation(shareData=");
            outline73.append(this.shareData);
            outline73.append(')');
            return outline73.toString();
        }
    }

    public ShareModuleStates() {
    }

    public /* synthetic */ ShareModuleStates(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
