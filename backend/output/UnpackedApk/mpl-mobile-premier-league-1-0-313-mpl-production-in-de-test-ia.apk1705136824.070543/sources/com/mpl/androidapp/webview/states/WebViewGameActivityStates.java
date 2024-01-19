package com.mpl.androidapp.webview.states;

import android.content.Intent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000f\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u000f\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "", "()V", "ChangeOrientation", "CloseScreen", "CloseScreenWithDialog", "DisplayLoader", "ErrorState", "GetDataFromPreviousScreen", "HandleBackNavigation", "HelpDeskRedirect", "InitSessionRequestParams", "InitialState", "NoConnectivity", "PaymentRedirect", "ReInitState", "ReloadState", "StartLoadingWebView", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ChangeOrientation;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$GetDataFromPreviousScreen;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$CloseScreen;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$CloseScreenWithDialog;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$HelpDeskRedirect;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$PaymentRedirect;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$InitSessionRequestParams;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$InitialState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ReloadState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ReInitState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$HandleBackNavigation;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$NoConnectivity;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ErrorState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$DisplayLoader;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$StartLoadingWebView;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGameActivityStates.kt */
public abstract class WebViewGameActivityStates {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ChangeOrientation;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "mode", "", "(Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class ChangeOrientation extends WebViewGameActivityStates {
        public final String mode;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ChangeOrientation(String str) {
            // Intrinsics.checkNotNullParameter(str, "mode");
            super(null);
            this.mode = str;
        }

        public static /* synthetic */ ChangeOrientation copy$default(ChangeOrientation changeOrientation, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = changeOrientation.mode;
            }
            return changeOrientation.copy(str);
        }

        public final String component1() {
            return this.mode;
        }

        public final ChangeOrientation copy(String str) {
            Intrinsics.checkNotNullParameter(str, "mode");
            return new ChangeOrientation(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ChangeOrientation) && Intrinsics.areEqual(this.mode, ((ChangeOrientation) obj).mode);
        }

        public final String getMode() {
            return this.mode;
        }

        public int hashCode() {
            return this.mode.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ChangeOrientation(mode="), this.mode, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$CloseScreen;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class CloseScreen extends WebViewGameActivityStates {
        public static final CloseScreen INSTANCE = new CloseScreen();

        public CloseScreen() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$CloseScreenWithDialog;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class CloseScreenWithDialog extends WebViewGameActivityStates {
        public final String message;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public CloseScreenWithDialog(String str) {
            // Intrinsics.checkNotNullParameter(str, "message");
            super(null);
            this.message = str;
        }

        public static /* synthetic */ CloseScreenWithDialog copy$default(CloseScreenWithDialog closeScreenWithDialog, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = closeScreenWithDialog.message;
            }
            return closeScreenWithDialog.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final CloseScreenWithDialog copy(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new CloseScreenWithDialog(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CloseScreenWithDialog) && Intrinsics.areEqual(this.message, ((CloseScreenWithDialog) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("CloseScreenWithDialog(message="), this.message, ')');
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$DisplayLoader;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "isVisible", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class DisplayLoader extends WebViewGameActivityStates {
        public final boolean isVisible;

        public DisplayLoader(boolean z) {
            super(null);
            this.isVisible = z;
        }

        public static /* synthetic */ DisplayLoader copy$default(DisplayLoader displayLoader, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = displayLoader.isVisible;
            }
            return displayLoader.copy(z);
        }

        public final boolean component1() {
            return this.isVisible;
        }

        public final DisplayLoader copy(boolean z) {
            return new DisplayLoader(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayLoader) && this.isVisible == ((DisplayLoader) obj).isVisible;
        }

        public int hashCode() {
            boolean z = this.isVisible;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline65(GeneratedOutlineSupport.outline73("DisplayLoader(isVisible="), this.isVisible, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ErrorState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "errorMessage", "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class ErrorState extends WebViewGameActivityStates {
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$GetDataFromPreviousScreen;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class GetDataFromPreviousScreen extends WebViewGameActivityStates {
        public final String value;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public GetDataFromPreviousScreen(String str) {
            // Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
            super(null);
            this.value = str;
        }

        public static /* synthetic */ GetDataFromPreviousScreen copy$default(GetDataFromPreviousScreen getDataFromPreviousScreen, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = getDataFromPreviousScreen.value;
            }
            return getDataFromPreviousScreen.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final GetDataFromPreviousScreen copy(String str) {
            Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
            return new GetDataFromPreviousScreen(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetDataFromPreviousScreen) && Intrinsics.areEqual(this.value, ((GetDataFromPreviousScreen) obj).value);
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("GetDataFromPreviousScreen(value="), this.value, ')');
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$HandleBackNavigation;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class HandleBackNavigation extends WebViewGameActivityStates {
        public static final HandleBackNavigation INSTANCE = new HandleBackNavigation();

        public HandleBackNavigation() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$HelpDeskRedirect;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class HelpDeskRedirect extends WebViewGameActivityStates {
        public final Intent intent;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public HelpDeskRedirect(Intent intent2) {
            // Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            super(null);
            this.intent = intent2;
        }

        public static /* synthetic */ HelpDeskRedirect copy$default(HelpDeskRedirect helpDeskRedirect, Intent intent2, int i, Object obj) {
            if ((i & 1) != 0) {
                intent2 = helpDeskRedirect.intent;
            }
            return helpDeskRedirect.copy(intent2);
        }

        public final Intent component1() {
            return this.intent;
        }

        public final HelpDeskRedirect copy(Intent intent2) {
            Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            return new HelpDeskRedirect(intent2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HelpDeskRedirect) && Intrinsics.areEqual(this.intent, ((HelpDeskRedirect) obj).intent);
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public int hashCode() {
            return this.intent.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("HelpDeskRedirect(intent=");
            outline73.append(this.intent);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$InitSessionRequestParams;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "reactDataForWebGame", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getReactDataForWebGame", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class InitSessionRequestParams extends WebViewGameActivityStates {
        public final JSONObject reactDataForWebGame;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public InitSessionRequestParams(JSONObject jSONObject) {
            // Intrinsics.checkNotNullParameter(jSONObject, "reactDataForWebGame");
            super(null);
            this.reactDataForWebGame = jSONObject;
        }

        public static /* synthetic */ InitSessionRequestParams copy$default(InitSessionRequestParams initSessionRequestParams, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = initSessionRequestParams.reactDataForWebGame;
            }
            return initSessionRequestParams.copy(jSONObject);
        }

        public final JSONObject component1() {
            return this.reactDataForWebGame;
        }

        public final InitSessionRequestParams copy(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "reactDataForWebGame");
            return new InitSessionRequestParams(jSONObject);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InitSessionRequestParams) && Intrinsics.areEqual(this.reactDataForWebGame, ((InitSessionRequestParams) obj).reactDataForWebGame);
        }

        public final JSONObject getReactDataForWebGame() {
            return this.reactDataForWebGame;
        }

        public int hashCode() {
            return this.reactDataForWebGame.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("InitSessionRequestParams(reactDataForWebGame=");
            outline73.append(this.reactDataForWebGame);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$InitialState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class InitialState extends WebViewGameActivityStates {
        public static final InitialState INSTANCE = new InitialState();

        public InitialState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$NoConnectivity;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class NoConnectivity extends WebViewGameActivityStates {
        public static final NoConnectivity INSTANCE = new NoConnectivity();

        public NoConnectivity() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$PaymentRedirect;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class PaymentRedirect extends WebViewGameActivityStates {
        public final Intent intent;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public PaymentRedirect(Intent intent2) {
            // Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            super(null);
            this.intent = intent2;
        }

        public static /* synthetic */ PaymentRedirect copy$default(PaymentRedirect paymentRedirect, Intent intent2, int i, Object obj) {
            if ((i & 1) != 0) {
                intent2 = paymentRedirect.intent;
            }
            return paymentRedirect.copy(intent2);
        }

        public final Intent component1() {
            return this.intent;
        }

        public final PaymentRedirect copy(Intent intent2) {
            Intrinsics.checkNotNullParameter(intent2, AnalyticsConstants.INTENT);
            return new PaymentRedirect(intent2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaymentRedirect) && Intrinsics.areEqual(this.intent, ((PaymentRedirect) obj).intent);
        }

        public final Intent getIntent() {
            return this.intent;
        }

        public int hashCode() {
            return this.intent.hashCode();
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("PaymentRedirect(intent=");
            outline73.append(this.intent);
            outline73.append(')');
            return outline73.toString();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ReInitState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class ReInitState extends WebViewGameActivityStates {
        public static final ReInitState INSTANCE = new ReInitState();

        public ReInitState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$ReloadState;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class ReloadState extends WebViewGameActivityStates {
        public static final ReloadState INSTANCE = new ReloadState();

        public ReloadState() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates$StartLoadingWebView;", "Lcom/mpl/androidapp/webview/states/WebViewGameActivityStates;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewGameActivityStates.kt */
    public static final class StartLoadingWebView extends WebViewGameActivityStates {
        public final String url;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public StartLoadingWebView(String str) {
            // Intrinsics.checkNotNullParameter(str, "url");
            super(null);
            this.url = str;
        }

        public static /* synthetic */ StartLoadingWebView copy$default(StartLoadingWebView startLoadingWebView, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = startLoadingWebView.url;
            }
            return startLoadingWebView.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final StartLoadingWebView copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new StartLoadingWebView(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartLoadingWebView) && Intrinsics.areEqual(this.url, ((StartLoadingWebView) obj).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("StartLoadingWebView(url="), this.url, ')');
        }
    }

    public WebViewGameActivityStates() {
    }

    public /* synthetic */ WebViewGameActivityStates(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
