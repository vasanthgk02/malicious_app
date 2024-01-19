package com.facebook.login;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.common.R$id;
import com.facebook.common.R$layout;
import com.facebook.common.R$string;
import com.facebook.common.R$style;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DeviceAuthDialog.PermissionsLists;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.login.LoginClient.Result.Code;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.paynimo.android.payment.util.Constant;
import in.juspay.hypersdk.core.Labels.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.game.QuickGameJoinRequest;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J4\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010'\u001a\u00020\u001dH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0015J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u000fH\u0014J\b\u0010,\u001a\u00020\u000fH\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\u0012\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J&\u00102\u001a\u0004\u0018\u00010\u00162\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00107\u001a\u00020\u001fH\u0016J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u000201H\u0016J'\u0010@\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020B2\b\u0010&\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020\u001fH\u0002J<\u0010E\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "confirmationCode", "Landroid/widget/TextView;", "currentGraphRequestPoll", "Lcom/facebook/GraphRequestAsyncTask;", "currentRequestState", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "deviceAuthMethodHandler", "Lcom/facebook/login/DeviceAuthMethodHandler;", "instructions", "isBeingDestroyed", "", "isRetry", "pollRequest", "Lcom/facebook/GraphRequest;", "getPollRequest", "()Lcom/facebook/GraphRequest;", "progressBar", "Landroid/view/View;", "request", "Lcom/facebook/login/LoginClient$Request;", "scheduledPoll", "Ljava/util/concurrent/ScheduledFuture;", "additionalDeviceInfo", "", "", "completeLogin", "", "userId", "permissions", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "accessToken", "expirationTime", "Ljava/util/Date;", "dataAccessExpirationTime", "getApplicationAccessToken", "getLayoutResId", "", "isSmartLogin", "initializeContentView", "onBackButtonPressed", "onCancel", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onError", "ex", "Lcom/facebook/FacebookException;", "onSaveInstanceState", "outState", "onSuccess", "expiresIn", "", "(Ljava/lang/String;JLjava/lang/Long;)V", "poll", "presentConfirmation", "name", "schedulePoll", "setCurrentRequestState", "startLogin", "Companion", "PermissionsLists", "RequestState", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DeviceAuthDialog.kt */
public class DeviceAuthDialog extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    public final AtomicBoolean completed = new AtomicBoolean();
    public TextView confirmationCode;
    public volatile GraphRequestAsyncTask currentGraphRequestPoll;
    public volatile RequestState currentRequestState;
    public DeviceAuthMethodHandler deviceAuthMethodHandler;
    public TextView instructions;
    public boolean isBeingDestroyed;
    public boolean isRetry;
    public View progressBar;
    public Request request;
    public volatile ScheduledFuture<?> scheduledPoll;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00020\f8\u0000XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$Companion;", "", "()V", "DEVICE_LOGIN_ENDPOINT", "", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release", "()Ljava/lang/String;", "DEVICE_LOGIN_STATUS_ENDPOINT", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED", "", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release", "()I", "LOGIN_ERROR_SUBCODE_CODE_EXPIRED", "LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING", "REQUEST_STATE_KEY", "handlePermissionResponse", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "result", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceAuthDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final PermissionsLists access$handlePermissionResponse(Companion companion, JSONObject jSONObject) {
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString(System.PERMISSION);
                    Intrinsics.checkNotNullExpressionValue(optString, System.PERMISSION);
                    if (!(optString.length() == 0) && !Intrinsics.areEqual(optString, "installed")) {
                        String optString2 = optJSONObject.optString("status");
                        if (optString2 != null) {
                            int hashCode = optString2.hashCode();
                            if (hashCode != -1309235419) {
                                if (hashCode != 280295099) {
                                    if (hashCode == 568196142 && optString2.equals("declined")) {
                                        arrayList2.add(optString);
                                    }
                                } else if (optString2.equals("granted")) {
                                    arrayList.add(optString);
                                }
                            } else if (optString2.equals("expired")) {
                                arrayList3.add(optString);
                            }
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return new PermissionsLists(arrayList, arrayList2, arrayList3);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "", "grantedPermissions", "", "", "declinedPermissions", "expiredPermissions", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceAuthDialog.kt */
    public static final class PermissionsLists {
        public List<String> declinedPermissions;
        public List<String> expiredPermissions;
        public List<String> grantedPermissions;

        public PermissionsLists(List<String> list, List<String> list2, List<String> list3) {
            Intrinsics.checkNotNullParameter(list, "grantedPermissions");
            Intrinsics.checkNotNullParameter(list2, "declinedPermissions");
            Intrinsics.checkNotNullParameter(list3, "expiredPermissions");
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018H\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "", "authorizationUri", "getAuthorizationUri", "()Ljava/lang/String;", "interval", "", "getInterval", "()J", "setInterval", "(J)V", "lastPoll", "requestCode", "getRequestCode", "setRequestCode", "(Ljava/lang/String;)V", "userCode", "describeContents", "", "getUserCode", "setLastPoll", "", "setUserCode", "withinLastRefreshWindow", "", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceAuthDialog.kt */
    public static final class RequestState implements Parcelable {
        public static final Creator<RequestState> CREATOR = new DeviceAuthDialog$RequestState$Companion$CREATOR$1();
        public String authorizationUri;
        public long interval;
        public long lastPoll;
        public String requestCode;
        public String userCode;

        public RequestState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }

        public RequestState(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }
    }

    /* renamed from: _get_pollRequest_$lambda-5  reason: not valid java name */
    public static final void m61_get_pollRequest_$lambda5(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        FacebookException facebookException;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError facebookRequestError = graphResponse.error;
            if (facebookRequestError != null) {
                int i = facebookRequestError.subErrorCode;
                boolean z = true;
                if (!(i == 1349174 || i == 1349172)) {
                    z = false;
                }
                if (z) {
                    deviceAuthDialog.schedulePoll();
                } else if (i == 1349152) {
                    RequestState requestState = deviceAuthDialog.currentRequestState;
                    if (requestState != null) {
                        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                        DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
                    }
                    Request request2 = deviceAuthDialog.request;
                    if (request2 != null) {
                        deviceAuthDialog.startLogin(request2);
                    } else {
                        deviceAuthDialog.onCancel();
                    }
                } else if (i == 1349173) {
                    deviceAuthDialog.onCancel();
                } else {
                    FacebookRequestError facebookRequestError2 = graphResponse.error;
                    if (facebookRequestError2 == null) {
                        facebookException = null;
                    } else {
                        facebookException = facebookRequestError2.exception;
                    }
                    if (facebookException == null) {
                        facebookException = new FacebookException();
                    }
                    deviceAuthDialog.onError(facebookException);
                }
                return;
            }
            try {
                JSONObject jSONObject = graphResponse.graphObject;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String string = jSONObject.getString("access_token");
                Intrinsics.checkNotNullExpressionValue(string, "resultObject.getString(\"access_token\")");
                deviceAuthDialog.onSuccess(string, jSONObject.getLong("expires_in"), Long.valueOf(jSONObject.optLong("data_access_expiration_time")));
            } catch (JSONException e2) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e2));
            }
        }
    }

    /* renamed from: initializeContentView$lambda-2  reason: not valid java name */
    public static final void m62initializeContentView$lambda2(DeviceAuthDialog deviceAuthDialog, View view) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        deviceAuthDialog.onCancel();
    }

    /* renamed from: onSuccess$lambda-10  reason: not valid java name */
    public static final void m63onSuccess$lambda10(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2, GraphResponse graphResponse) {
        DeviceAuthDialog deviceAuthDialog2 = deviceAuthDialog;
        GraphResponse graphResponse2 = graphResponse;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        String str2 = str;
        Intrinsics.checkNotNullParameter(str, "$accessToken");
        Intrinsics.checkNotNullParameter(graphResponse2, Constant.TAG_RESPONSE);
        if (!deviceAuthDialog2.completed.get()) {
            FacebookRequestError facebookRequestError = graphResponse2.error;
            if (facebookRequestError != null) {
                FacebookException facebookException = facebookRequestError.exception;
                if (facebookException == null) {
                    facebookException = new FacebookException();
                }
                deviceAuthDialog.onError(facebookException);
                return;
            }
            try {
                JSONObject jSONObject = graphResponse2.graphObject;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                String string = jSONObject.getString("id");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"id\")");
                PermissionsLists access$handlePermissionResponse = Companion.access$handlePermissionResponse(Companion, jSONObject);
                String string2 = jSONObject.getString("name");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"name\")");
                RequestState requestState = deviceAuthDialog2.currentRequestState;
                if (requestState != null) {
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
                }
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                Boolean bool = null;
                if (appSettingsWithoutQuery != null) {
                    EnumSet<SmartLoginOption> enumSet = appSettingsWithoutQuery.smartLoginOptions;
                    if (enumSet != null) {
                        bool = Boolean.valueOf(enumSet.contains(SmartLoginOption.RequireConfirm));
                    }
                }
                if (!Intrinsics.areEqual(bool, Boolean.TRUE) || deviceAuthDialog2.isRetry) {
                    deviceAuthDialog.completeLogin(string, access$handlePermissionResponse, str, date, date2);
                    return;
                }
                deviceAuthDialog2.isRetry = true;
                String string3 = deviceAuthDialog.getResources().getString(R$string.com_facebook_smart_login_confirmation_title);
                Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
                String string4 = deviceAuthDialog.getResources().getString(R$string.com_facebook_smart_login_confirmation_continue_as);
                Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
                String string5 = deviceAuthDialog.getResources().getString(R$string.com_facebook_smart_login_confirmation_cancel);
                Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
                String outline70 = GeneratedOutlineSupport.outline70(new Object[]{string2}, 1, string4, "java.lang.String.format(format, *args)");
                Builder builder = new Builder(deviceAuthDialog.getContext());
                Builder cancelable = builder.setMessage(string3).setCancelable(true);
                $$Lambda$Qkt4SBKxD9_3N_PQkRXHHIetkw r1 = new OnClickListener(string, access$handlePermissionResponse, str, date, date2) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ PermissionsLists f$2;
                    public final /* synthetic */ String f$3;
                    public final /* synthetic */ Date f$4;
                    public final /* synthetic */ Date f$5;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r6;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DeviceAuthDialog.m64presentConfirmation$lambda6(DeviceAuthDialog.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, dialogInterface, i);
                    }
                };
                cancelable.setNegativeButton(outline70, r1).setPositiveButton(string5, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DeviceAuthDialog.m65presentConfirmation$lambda8(DeviceAuthDialog.this, dialogInterface, i);
                    }
                });
                builder.create().show();
            } catch (JSONException e2) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e2));
            }
        }
    }

    /* renamed from: presentConfirmation$lambda-6  reason: not valid java name */
    public static final void m64presentConfirmation$lambda6(DeviceAuthDialog deviceAuthDialog, String str, PermissionsLists permissionsLists, String str2, Date date, Date date2, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(str, "$userId");
        Intrinsics.checkNotNullParameter(permissionsLists, "$permissions");
        Intrinsics.checkNotNullParameter(str2, "$accessToken");
        deviceAuthDialog.completeLogin(str, permissionsLists, str2, date, date2);
    }

    /* renamed from: presentConfirmation$lambda-8  reason: not valid java name */
    public static final void m65presentConfirmation$lambda8(DeviceAuthDialog deviceAuthDialog, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        View initializeContentView = deviceAuthDialog.initializeContentView(false);
        Dialog dialog = deviceAuthDialog.getDialog();
        if (dialog != null) {
            dialog.setContentView(initializeContentView);
        }
        Request request2 = deviceAuthDialog.request;
        if (request2 != null) {
            deviceAuthDialog.startLogin(request2);
        }
    }

    /* renamed from: schedulePoll$lambda-3  reason: not valid java name */
    public static final void m66schedulePoll$lambda3(DeviceAuthDialog deviceAuthDialog) {
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        deviceAuthDialog.poll();
    }

    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final void m67startLogin$lambda1(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        FacebookException facebookException;
        Intrinsics.checkNotNullParameter(deviceAuthDialog, "this$0");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        if (!deviceAuthDialog.isBeingDestroyed) {
            FacebookRequestError facebookRequestError = graphResponse.error;
            if (facebookRequestError != null) {
                if (facebookRequestError == null) {
                    facebookException = null;
                } else {
                    facebookException = facebookRequestError.exception;
                }
                if (facebookException == null) {
                    facebookException = new FacebookException();
                }
                deviceAuthDialog.onError(facebookException);
                return;
            }
            JSONObject jSONObject = graphResponse.graphObject;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            RequestState requestState = new RequestState();
            try {
                String string = jSONObject.getString("user_code");
                requestState.userCode = string;
                String format = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{string}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                requestState.authorizationUri = format;
                requestState.requestCode = jSONObject.getString("code");
                requestState.interval = jSONObject.getLong("interval");
                deviceAuthDialog.setCurrentRequestState(requestState);
            } catch (JSONException e2) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e2));
            }
        }
    }

    public final void completeLogin(String str, PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        PermissionsLists permissionsLists2 = permissionsLists;
        DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler2 != null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String applicationId = FacebookSdk.getApplicationId();
            List<String> list = permissionsLists2.grantedPermissions;
            List<String> list2 = permissionsLists2.declinedPermissions;
            List<String> list3 = permissionsLists2.expiredPermissions;
            AccessTokenSource accessTokenSource = AccessTokenSource.DEVICE_AUTH;
            Intrinsics.checkNotNullParameter(str2, "accessToken");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "userId");
            AccessToken accessToken = new AccessToken(str2, applicationId, str3, list, list2, list3, accessTokenSource, date, null, date2, null, 1024);
            Request request2 = deviceAuthMethodHandler2.getLoginClient().pendingRequest;
            Intrinsics.checkNotNullParameter(accessToken, "token");
            Result result = new Result(request2, Code.SUCCESS, accessToken, null, null);
            deviceAuthMethodHandler2.getLoginClient().completeAndValidate(result);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public String getApplicationAccessToken() {
        StringBuilder sb = new StringBuilder();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        sb.append(FacebookSdk.getApplicationId());
        sb.append('|');
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        sb.append(FacebookSdk.getClientToken());
        return sb.toString();
    }

    public View initializeContentView(boolean z) {
        int i;
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "requireActivity().layoutInflater");
        if (z) {
            i = R$layout.com_facebook_smart_device_dialog_fragment;
        } else {
            i = R$layout.com_facebook_device_auth_dialog_fragment;
        }
        View inflate = layoutInflater.inflate(i, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View findViewById = inflate.findViewById(R$id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = findViewById;
        View findViewById2 = inflate.findViewById(R$id.confirmation_code);
        if (findViewById2 != null) {
            this.confirmationCode = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R$id.cancel_button);
            if (findViewById3 != null) {
                ((Button) findViewById3).setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        DeviceAuthDialog.m62initializeContentView$lambda2(DeviceAuthDialog.this, view);
                    }
                });
                View findViewById4 = inflate.findViewById(R$id.com_facebook_device_auth_instructions);
                if (findViewById4 != null) {
                    TextView textView = (TextView) findViewById4;
                    this.instructions = textView;
                    if (textView != null) {
                        textView.setText(Html.fromHtml(getString(R$string.com_facebook_device_auth_instructions)));
                        return inflate;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("instructions");
                    throw null;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                Result result = new Result(deviceAuthMethodHandler2.getLoginClient().pendingRequest, Code.CANCEL, null, "User canceled log in.", null);
                deviceAuthMethodHandler2.getLoginClient().completeAndValidate(result);
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        DeviceAuthDialog$onCreateDialog$dialog$1 deviceAuthDialog$onCreateDialog$dialog$1 = new DeviceAuthDialog$onCreateDialog$dialog$1(this, requireActivity(), R$style.com_facebook_auth_dialog);
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        deviceAuthDialog$onCreateDialog$dialog$1.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return deviceAuthDialog$onCreateDialog$dialog$1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LoginMethodHandler loginMethodHandler;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) requireActivity()).currentFragment;
        if (loginFragment == null) {
            loginMethodHandler = null;
        } else {
            loginMethodHandler = loginFragment.getLoginClient().getCurrentHandler();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) loginMethodHandler;
        if (bundle != null) {
            RequestState requestState = (RequestState) bundle.getParcelable("request_state");
            if (requestState != null) {
                setCurrentRequestState(requestState);
            }
        }
        return onCreateView;
    }

    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onError(FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(facebookException, "ex");
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                Intrinsics.checkNotNullParameter(facebookException, "ex");
                Request request2 = deviceAuthMethodHandler2.getLoginClient().pendingRequest;
                String message = facebookException.getMessage();
                ArrayList arrayList = new ArrayList();
                if (message != null) {
                    arrayList.add(message);
                }
                Result result = new Result(request2, Code.ERROR, null, TextUtils.join(": ", arrayList), null);
                deviceAuthMethodHandler2.getLoginClient().completeAndValidate(result);
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable("request_state", this.currentRequestState);
        }
    }

    public final void onSuccess(String str, long j, Long l) {
        Date date;
        Bundle outline14 = GeneratedOutlineSupport.outline14("fields", "id,permissions,name");
        Date date2 = null;
        if (j != 0) {
            date = new Date((j * 1000) + GeneratedOutlineSupport.outline13());
        } else {
            date = null;
        }
        if ((l == null || l.longValue() != 0) && l != null) {
            date2 = new Date(l.longValue() * 1000);
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        AccessToken accessToken = new AccessToken(str, FacebookSdk.getApplicationId(), "0", null, null, null, null, date, null, date2, null, 1024);
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, QuickGameJoinRequest.KEY_MATCH_EXPRESSION, new Callback(str, date, date2) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Date f$2;
            public final /* synthetic */ Date f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m63onSuccess$lambda10(DeviceAuthDialog.this, this.f$1, this.f$2, this.f$3, graphResponse);
            }
        });
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(outline14);
        newGraphPathRequest.executeAsync();
    }

    public final void poll() {
        String str;
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.lastPoll = GeneratedOutlineSupport.outline13();
        }
        Bundle bundle = new Bundle();
        RequestState requestState2 = this.currentRequestState;
        if (requestState2 == null) {
            str = null;
        } else {
            str = requestState2.requestCode;
        }
        bundle.putString("code", str);
        bundle.putString("access_token", getApplicationAccessToken());
        this.currentGraphRequestPoll = GraphRequest.Companion.newPostRequestWithBundle(null, "device/login_status", bundle, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m61_get_pollRequest_$lambda5(DeviceAuthDialog.this, graphResponse);
            }
        }).executeAsync();
    }

    public final void schedulePoll() {
        Long l;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            l = null;
        } else {
            l = Long.valueOf(requestState.interval);
        }
        if (l != null) {
            synchronized (DeviceAuthMethodHandler.Companion) {
                if (DeviceAuthMethodHandler.backgroundExecutor == null) {
                    DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = DeviceAuthMethodHandler.backgroundExecutor;
                if (scheduledThreadPoolExecutor == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundExecutor");
                    throw null;
                }
            }
            this.scheduledPoll = scheduledThreadPoolExecutor.schedule(new Runnable() {
                public final void run() {
                    DeviceAuthDialog.m66schedulePoll$lambda3(DeviceAuthDialog.this);
                }
            }, l.longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setCurrentRequestState(com.facebook.login.DeviceAuthDialog.RequestState r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.Class<com.facebook.devicerequests.internal.DeviceRequestsHelper> r3 = com.facebook.devicerequests.internal.DeviceRequestsHelper.class
            r1.currentRequestState = r2
            android.widget.TextView r0 = r1.confirmationCode
            r4 = 0
            java.lang.String r5 = "confirmationCode"
            if (r0 == 0) goto L_0x011e
            java.lang.String r6 = r2.userCode
            r0.setText(r6)
            com.facebook.devicerequests.internal.DeviceRequestsHelper r0 = com.facebook.devicerequests.internal.DeviceRequestsHelper.INSTANCE
            java.lang.String r7 = r2.authorizationUri
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            r12 = 0
            if (r0 == 0) goto L_0x0021
            goto L_0x0089
        L_0x0021:
            java.util.EnumMap r11 = new java.util.EnumMap     // Catch:{ all -> 0x0085 }
            java.lang.Class<com.google.zxing.EncodeHintType> r0 = com.google.zxing.EncodeHintType.class
            r11.<init>(r0)     // Catch:{ all -> 0x0085 }
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.MARGIN     // Catch:{ all -> 0x0085 }
            r6 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0085 }
            r11.put(r0, r6)     // Catch:{ all -> 0x0085 }
            com.google.zxing.MultiFormatWriter r6 = new com.google.zxing.MultiFormatWriter     // Catch:{ WriterException -> 0x0089 }
            r6.<init>()     // Catch:{ WriterException -> 0x0089 }
            com.google.zxing.BarcodeFormat r8 = com.google.zxing.BarcodeFormat.QR_CODE     // Catch:{ WriterException -> 0x0089 }
            r9 = 200(0xc8, float:2.8E-43)
            r10 = 200(0xc8, float:2.8E-43)
            com.google.zxing.common.BitMatrix r0 = r6.encode(r7, r8, r9, r10, r11)     // Catch:{ WriterException -> 0x0089 }
            int r6 = r0.height     // Catch:{ WriterException -> 0x0089 }
            int r7 = r0.width     // Catch:{ WriterException -> 0x0089 }
            int r8 = r6 * r7
            int[] r14 = new int[r8]     // Catch:{ WriterException -> 0x0089 }
            if (r6 <= 0) goto L_0x006d
            r8 = 0
        L_0x004c:
            int r9 = r8 + 1
            int r10 = r8 * r7
            if (r7 <= 0) goto L_0x0068
            r11 = 0
        L_0x0053:
            int r13 = r11 + 1
            int r15 = r10 + r11
            boolean r11 = r0.get(r11, r8)     // Catch:{ WriterException -> 0x0089 }
            if (r11 == 0) goto L_0x0060
            r11 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x0061
        L_0x0060:
            r11 = -1
        L_0x0061:
            r14[r15] = r11     // Catch:{ WriterException -> 0x0089 }
            if (r13 < r7) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r11 = r13
            goto L_0x0053
        L_0x0068:
            if (r9 < r6) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r8 = r9
            goto L_0x004c
        L_0x006d:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ WriterException -> 0x0089 }
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r7, r6, r0)     // Catch:{ WriterException -> 0x0089 }
            r15 = 0
            r17 = 0
            r18 = 0
            r13 = r0
            r16 = r7
            r19 = r7
            r20 = r6
            r13.setPixels(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ WriterException -> 0x0083 }
            goto L_0x008a
        L_0x0083:
            goto L_0x008a
        L_0x0085:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3)
        L_0x0089:
            r0 = r4
        L_0x008a:
            android.graphics.drawable.BitmapDrawable r6 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r7 = r21.getResources()
            r6.<init>(r7, r0)
            android.widget.TextView r0 = r1.instructions
            if (r0 == 0) goto L_0x0118
            r0.setCompoundDrawablesWithIntrinsicBounds(r4, r6, r4, r4)
            android.widget.TextView r0 = r1.confirmationCode
            if (r0 == 0) goto L_0x0114
            r0.setVisibility(r12)
            android.view.View r0 = r1.progressBar
            if (r0 == 0) goto L_0x010e
            r5 = 8
            r0.setVisibility(r5)
            boolean r0 = r1.isRetry
            if (r0 != 0) goto L_0x00e8
            com.facebook.devicerequests.internal.DeviceRequestsHelper r0 = com.facebook.devicerequests.internal.DeviceRequestsHelper.INSTANCE
            java.lang.String r0 = r2.userCode
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            if (r5 == 0) goto L_0x00b9
            goto L_0x00ca
        L_0x00b9:
            boolean r5 = com.facebook.devicerequests.internal.DeviceRequestsHelper.isAvailable()     // Catch:{ all -> 0x00c6 }
            if (r5 == 0) goto L_0x00ca
            com.facebook.devicerequests.internal.DeviceRequestsHelper r5 = com.facebook.devicerequests.internal.DeviceRequestsHelper.INSTANCE     // Catch:{ all -> 0x00c6 }
            boolean r0 = r5.startAdvertisementServiceImpl(r0)     // Catch:{ all -> 0x00c6 }
            goto L_0x00cb
        L_0x00c6:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3)
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            if (r0 == 0) goto L_0x00e8
            android.content.Context r0 = r21.getContext()
            com.facebook.appevents.AppEventsLoggerImpl r3 = new com.facebook.appevents.AppEventsLoggerImpl
            r3.<init>(r0, r4, r4)
            java.lang.String r0 = "loggerImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            boolean r0 = com.facebook.FacebookSdk.getAutoLogAppEventsEnabled()
            if (r0 == 0) goto L_0x00e8
            java.lang.String r0 = "fb_smart_login_service"
            r3.logEventImplicitly(r0, r4, r4)
        L_0x00e8:
            long r3 = r2.lastPoll
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00f1
            goto L_0x0104
        L_0x00f1:
            long r3 = com.android.tools.r8.GeneratedOutlineSupport.outline13()
            long r7 = r2.lastPoll
            long r3 = r3 - r7
            long r7 = r2.interval
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            long r3 = r3 - r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0104
            r12 = 1
        L_0x0104:
            if (r12 == 0) goto L_0x010a
            r21.schedulePoll()
            goto L_0x010d
        L_0x010a:
            r21.poll()
        L_0x010d:
            return
        L_0x010e:
            java.lang.String r0 = "progressBar"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r4
        L_0x0114:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            throw r4
        L_0x0118:
            java.lang.String r0 = "instructions"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            throw r4
        L_0x011e:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.DeviceAuthDialog.setCurrentRequestState(com.facebook.login.DeviceAuthDialog$RequestState):void");
    }

    public void startLogin(Request request2) {
        String str;
        Intrinsics.checkNotNullParameter(request2, "request");
        this.request = request2;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request2.permissions));
        Utility.putNonEmptyString(bundle, "redirect_uri", request2.deviceRedirectUriString);
        Utility.putNonEmptyString(bundle, "target_user_id", request2.deviceAuthTargetUserId);
        bundle.putString("access_token", getApplicationAccessToken());
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                HashMap hashMap = new HashMap();
                String str2 = Build.DEVICE;
                Intrinsics.checkNotNullExpressionValue(str2, "DEVICE");
                hashMap.put("device", str2);
                String str3 = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(str3, "MODEL");
                hashMap.put("model", str3);
                str = new JSONObject(hashMap).toString();
                Intrinsics.checkNotNullExpressionValue(str, "JSONObject(deviceInfo as Map<*, *>).toString()");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
            bundle.putString(OneSingnalConstant.TAG_DEVICE_INFO, str);
            GraphRequest.Companion.newPostRequestWithBundle(null, "device/login", bundle, new Callback() {
                public final void onCompleted(GraphResponse graphResponse) {
                    DeviceAuthDialog.m67startLogin$lambda1(DeviceAuthDialog.this, graphResponse);
                }
            }).executeAsync();
        }
        str = null;
        bundle.putString(OneSingnalConstant.TAG_DEVICE_INFO, str);
        GraphRequest.Companion.newPostRequestWithBundle(null, "device/login", bundle, new Callback() {
            public final void onCompleted(GraphResponse graphResponse) {
                DeviceAuthDialog.m67startLogin$lambda1(DeviceAuthDialog.this, graphResponse);
            }
        }).executeAsync();
    }
}
