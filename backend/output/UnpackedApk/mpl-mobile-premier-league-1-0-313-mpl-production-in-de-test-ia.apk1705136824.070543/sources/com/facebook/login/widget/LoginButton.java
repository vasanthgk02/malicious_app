package com.facebook.login.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.AccessToken.Companion;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.ActivityResultParameters;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.common.R$color;
import com.facebook.common.R$drawable;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginConfiguration;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginManager.ActivityStartActivityDelegate;
import com.facebook.login.LoginManager.FacebookLoginActivityResultContract;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.R$string;
import com.facebook.login.R$style;
import com.facebook.login.R$styleable;
import com.facebook.login.widget.LoginButton.LoginClickListener;
import com.facebook.login.widget.ToolTipPopup.Style;
import com.mpl.androidapp.miniprofile.models.ExoPlayerConfig;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ©\u00012\u00020\u0001:\b©\u0001ª\u0001«\u0001¬\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\b\u0010|\u001a\u00020}H\u0003J\u0006\u0010~\u001a\u00020}J*\u0010\u001a\u00020}2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0015J\u0007\u0010\u0001\u001a\u00020}J\u0012\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\u000eH\u0003J\u0012\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0005J\u0012\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u000eH\u0003J\t\u0010\u0001\u001a\u00020}H\u0015J\t\u0010\u0001\u001a\u00020}H\u0015J\u0013\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u0001H\u0015J6\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0015J\u001b\u0010\u0001\u001a\u00020}2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0015J\u001c\u0010\u0001\u001a\u00020}2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\tH\u0015J+\u0010\u0001\u001a\u00020}2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0005J \u0010\u0001\u001a\u00020}2\u0006\u0010\u001e\u001a\u00020\u001d2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001J\t\u0010\u0001\u001a\u00020}H\u0005J\t\u0010\u0001\u001a\u00020}H\u0005J\t\u0010\u0001\u001a\u00020}H\u0005J\t\u0010 \u0001\u001a\u00020}H\u0005J%\u0010Z\u001a\u00020}2\u0017\u0010W\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0¡\u0001\"\u0004\u0018\u00010\u000e¢\u0006\u0003\u0010¢\u0001J(\u0010£\u0001\u001a\u00020}2\u0017\u0010W\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0¡\u0001\"\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0003\u0010¢\u0001J\u0017\u0010£\u0001\u001a\u00020}2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0VH\u0007J(\u0010¤\u0001\u001a\u00020}2\u0017\u0010W\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0¡\u0001\"\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0003\u0010¢\u0001J\u0017\u0010¤\u0001\u001a\u00020}2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0VH\u0007J\u0015\u0010¥\u0001\u001a\u00020}2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0003J\u000f\u0010¨\u0001\u001a\u00020}2\u0006\u0010\u001e\u001a\u00020\u001dR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\t8UX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\t8TX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u0011\u00102\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0019R$\u00105\u001a\u0002042\u0006\u0010\u0016\u001a\u0002048F@FX\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\t8EX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010/R \u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020C8F@FX\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR(\u0010I\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0019\"\u0004\bK\u0010\u001bR(\u0010L\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR(\u0010O\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e8F@FX\u000e¢\u0006\f\u001a\u0004\bP\u0010\u0019\"\u0004\bQ\u0010\u001bR\u0018\u0010R\u001a\u00060SR\u00020\u00008TX\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR0\u0010W\u001a\b\u0012\u0004\u0012\u00020\u000e0V2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0V8F@FX\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020]X\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R$\u0010`\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\"8F@FX\u000e¢\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bf\u0010bR\u000e\u0010g\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010h\u001a\u00020iX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001a\u0010n\u001a\u00020oX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0010\u0010t\u001a\u0004\u0018\u00010uX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010v\u001a\u00020wX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006­\u0001"}, d2 = {"Lcom/facebook/login/widget/LoginButton;", "Lcom/facebook/FacebookButtonBase;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "analyticsButtonCreatedEventName", "", "analyticsButtonTappedEventName", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "accessTokenTracker", "Lcom/facebook/AccessTokenTracker;", "androidXLoginCaller", "Landroidx/activity/result/ActivityResultLauncher;", "", "value", "authType", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "<set-?>", "Lcom/facebook/CallbackManager;", "callbackManager", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "confirmLogout", "", "customButtonRadius", "", "Ljava/lang/Float;", "customButtonTransparency", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "defaultRequestCode", "getDefaultRequestCode", "()I", "defaultStyleResource", "getDefaultStyleResource", "loggerID", "getLoggerID", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginButtonContinueLabel", "getLoginButtonContinueLabel", "loginManagerLazy", "Lkotlin/Lazy;", "Lcom/facebook/login/LoginManager;", "getLoginManagerLazy", "()Lkotlin/Lazy;", "setLoginManagerLazy", "(Lkotlin/Lazy;)V", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "loginText", "getLoginText", "setLoginText", "logoutText", "getLogoutText", "setLogoutText", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "newLoginClickListener", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "getNewLoginClickListener", "()Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "", "permissions", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "properties", "Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "getProperties", "()Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "resetMessengerState", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "toolTipChecked", "toolTipDisplayTime", "", "getToolTipDisplayTime", "()J", "setToolTipDisplayTime", "(J)V", "toolTipMode", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getToolTipMode", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "setToolTipMode", "(Lcom/facebook/login/widget/LoginButton$ToolTipMode;)V", "toolTipPopup", "Lcom/facebook/login/widget/ToolTipPopup;", "toolTipStyle", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "getToolTipStyle", "()Lcom/facebook/login/widget/ToolTipPopup$Style;", "setToolTipStyle", "(Lcom/facebook/login/widget/ToolTipPopup$Style;)V", "checkToolTipSettings", "", "clearPermissions", "configureButton", "dismissToolTip", "displayToolTip", "toolTipString", "getLoginButtonWidth", "widthMeasureSpec", "measureButtonWidth", "text", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "heightMeasureSpec", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "parseLoginButtonAttributes", "registerCallback", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "setButtonIcon", "setButtonRadius", "setButtonText", "setButtonTransparency", "", "([Ljava/lang/String;)V", "setPublishPermissions", "setReadPermissions", "showToolTipPerSettings", "settings", "Lcom/facebook/internal/FetchedAppSettings;", "unregisterCallback", "Companion", "LoginButtonProperties", "LoginClickListener", "ToolTipMode", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginButton.kt */
public class LoginButton extends FacebookButtonBase {
    public static final String TAG = LoginButton.class.getName();
    public AccessTokenTracker accessTokenTracker;
    public ActivityResultLauncher<Collection<String>> androidXLoginCaller;
    public CallbackManager callbackManager;
    public boolean confirmLogout;
    public Float customButtonRadius;
    public int customButtonTransparency;
    public final String loggerID;
    public Lazy<? extends LoginManager> loginManagerLazy;
    public String loginText;
    public String logoutText;
    public final LoginButtonProperties properties;
    public boolean toolTipChecked;
    public long toolTipDisplayTime;
    public ToolTipMode toolTipMode;
    public ToolTipPopup toolTipPopup;
    public Style toolTipStyle;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020%@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)¨\u00060"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "", "()V", "authType", "", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "permissions", "", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "resetMessengerState", "", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "<set-?>", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "setShouldSkipAccountDeduplication", "clearPermissions", "", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginButton.kt */
    public static class LoginButtonProperties {
        public String authType = "rerequest";
        public DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        public LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        public LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
        public String messengerPageId;
        public List<String> permissions = EmptyList.INSTANCE;
        public boolean resetMessengerState;

        public final void setPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.permissions = list;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0004J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0004R\u0014\u0010\u0003\u001a\u00020\u00048DX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "Landroid/view/View$OnClickListener;", "(Lcom/facebook/login/widget/LoginButton;)V", "isFamilyLogin", "", "()Z", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "getLoginManager", "Lcom/facebook/login/LoginManager;", "onClick", "", "v", "Landroid/view/View;", "performLogin", "performLogout", "context", "Landroid/content/Context;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginButton.kt */
    public class LoginClickListener implements OnClickListener {
        public final /* synthetic */ LoginButton this$0;

        public LoginClickListener(LoginButton loginButton) {
            Intrinsics.checkNotNullParameter(loginButton, "this$0");
            this.this$0 = loginButton;
        }

        /* renamed from: performLogout$lambda-2  reason: not valid java name */
        public static final void m78performLogout$lambda2(LoginManager loginManager, DialogInterface dialogInterface, int i) {
            if (!CrashShieldHandler.isObjectCrashing(LoginClickListener.class)) {
                try {
                    Intrinsics.checkNotNullParameter(loginManager, "$loginManager");
                    loginManager.logOut();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, LoginClickListener.class);
                }
            }
        }

        public LoginManager getLoginManager() {
            LoginManager instance;
            LoginTargetApp loginTargetApp;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                instance = LoginManager.Companion.getInstance();
                instance.setDefaultAudience(this.this$0.getDefaultAudience());
                instance.setLoginBehavior(this.this$0.getLoginBehavior());
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    loginTargetApp = LoginTargetApp.FACEBOOK;
                    Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
                    instance.loginTargetApp = loginTargetApp;
                    String authType = this.this$0.getAuthType();
                    Intrinsics.checkNotNullParameter(authType, "authType");
                    instance.authType = authType;
                    CrashShieldHandler.isObjectCrashing(this);
                    instance.isFamilyLogin = false;
                    instance.shouldSkipAccountDeduplication = this.this$0.getShouldSkipAccountDeduplication();
                    instance.messengerPageId = this.this$0.getMessengerPageId();
                    instance.resetMessengerState = this.this$0.getResetMessengerState();
                    return instance;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
            loginTargetApp = null;
            Intrinsics.checkNotNullParameter(loginTargetApp, "targetApp");
            instance.loginTargetApp = loginTargetApp;
            String authType2 = this.this$0.getAuthType();
            Intrinsics.checkNotNullParameter(authType2, "authType");
            instance.authType = authType2;
            CrashShieldHandler.isObjectCrashing(this);
            instance.isFamilyLogin = false;
            instance.shouldSkipAccountDeduplication = this.this$0.getShouldSkipAccountDeduplication();
            instance.messengerPageId = this.this$0.getMessengerPageId();
            instance.resetMessengerState = this.this$0.getResetMessengerState();
            return instance;
        }

        public void onClick(View view) {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    Intrinsics.checkNotNullParameter(view, "v");
                    this.this$0.callExternalOnClickListener(view);
                    Companion companion = AccessToken.Companion;
                    AccessToken currentAccessToken = Companion.getCurrentAccessToken();
                    Companion companion2 = AccessToken.Companion;
                    boolean isCurrentAccessTokenActive = Companion.isCurrentAccessTokenActive();
                    if (isCurrentAccessTokenActive) {
                        Context context = this.this$0.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        performLogout(context);
                    } else {
                        performLogin();
                    }
                    AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(this.this$0.getContext(), (String) null, (AccessToken) null);
                    Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
                    Bundle bundle = new Bundle();
                    int i = 0;
                    bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
                    if (isCurrentAccessTokenActive) {
                        i = 1;
                    }
                    bundle.putInt("access_token_expired", i);
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                        appEventsLoggerImpl.logEventImplicitly("fb_login_view_usage", null, bundle);
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public final void performLogin() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginManager loginManager = getLoginManager();
                    ActivityResultLauncher<Collection<String>> activityResultLauncher = this.this$0.androidXLoginCaller;
                    if (activityResultLauncher != null) {
                        FacebookLoginActivityResultContract facebookLoginActivityResultContract = (FacebookLoginActivityResultContract) activityResultLauncher.getContract();
                        CallbackManager callbackManager = this.this$0.getCallbackManager();
                        if (callbackManager == null) {
                            callbackManager = new CallbackManagerImpl();
                        }
                        facebookLoginActivityResultContract.callbackManager = callbackManager;
                        activityResultLauncher.launch(this.this$0.getProperties().permissions);
                    } else if (this.this$0.getFragment() != null) {
                        Fragment fragment = this.this$0.getFragment();
                        if (fragment != null) {
                            LoginButton loginButton = this.this$0;
                            List<String> list = loginButton.getProperties().permissions;
                            String loggerID = loginButton.getLoggerID();
                            if (loginManager != null) {
                                Intrinsics.checkNotNullParameter(fragment, "fragment");
                                loginManager.logIn(new FragmentWrapper(fragment), list, loggerID);
                            } else {
                                throw null;
                            }
                        }
                    } else if (this.this$0.getNativeFragment() != null) {
                        android.app.Fragment nativeFragment = this.this$0.getNativeFragment();
                        if (nativeFragment != null) {
                            LoginButton loginButton2 = this.this$0;
                            List<String> list2 = loginButton2.getProperties().permissions;
                            String loggerID2 = loginButton2.getLoggerID();
                            if (loginManager != null) {
                                Intrinsics.checkNotNullParameter(nativeFragment, "fragment");
                                loginManager.logIn(new FragmentWrapper(nativeFragment), list2, loggerID2);
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        Activity activity = this.this$0.getActivity();
                        List<String> list3 = this.this$0.getProperties().permissions;
                        String loggerID3 = this.this$0.getLoggerID();
                        if (loginManager != null) {
                            Intrinsics.checkNotNullParameter(activity, "activity");
                            Request createLoginRequestWithConfig = loginManager.createLoginRequestWithConfig(new LoginConfiguration(list3, null, 2));
                            if (loggerID3 != null) {
                                createLoginRequestWithConfig.setAuthId(loggerID3);
                            }
                            loginManager.startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig);
                        } else {
                            throw null;
                        }
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }

        public final void performLogout(Context context) {
            String str;
            String str2;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    Intrinsics.checkNotNullParameter(context, "context");
                    LoginManager loginManager = getLoginManager();
                    if (this.this$0.confirmLogout) {
                        String string = this.this$0.getResources().getString(R$string.com_facebook_loginview_log_out_action);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_loginview_log_out_action)");
                        String string2 = this.this$0.getResources().getString(R$string.com_facebook_loginview_cancel_action);
                        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.com_facebook_loginview_cancel_action)");
                        Profile profile = Profile.Companion;
                        Profile currentProfile = Profile.getCurrentProfile();
                        if (currentProfile == null) {
                            str = null;
                        } else {
                            str = currentProfile.name;
                        }
                        if (str != null) {
                            String string3 = this.this$0.getResources().getString(R$string.com_facebook_loginview_logged_in_as);
                            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.string.com_facebook_loginview_logged_in_as)");
                            str2 = String.format(string3, Arrays.copyOf(new Object[]{currentProfile.name}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                        } else {
                            str2 = this.this$0.getResources().getString(R$string.com_facebook_loginview_logged_in_using_facebook);
                            Intrinsics.checkNotNullExpressionValue(str2, "{\n          resources.getString(R.string.com_facebook_loginview_logged_in_using_facebook)\n        }");
                        }
                        Builder builder = new Builder(context);
                        builder.setMessage(str2).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                LoginClickListener.m78performLogout$lambda2(LoginManager.this, dialogInterface, i);
                            }
                        }).setNegativeButton(string2, null);
                        builder.create().show();
                    } else {
                        loginManager.logOut();
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "", "stringValue", "", "intValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIntValue", "()I", "toString", "AUTOMATIC", "DISPLAY_ALWAYS", "NEVER_DISPLAY", "Companion", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginButton.kt */
    public enum ToolTipMode {
        AUTOMATIC("automatic", 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static final Companion Companion = null;
        public static final ToolTipMode DEFAULT = null;
        public final int intValue;
        public final String stringValue;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode$Companion;", "", "()V", "DEFAULT", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getDEFAULT", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "fromInt", "enumValue", "", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: LoginButton.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new Companion(null);
            DEFAULT = AUTOMATIC;
        }

        /* access modifiers changed from: public */
        ToolTipMode(String str, int i) {
            this.stringValue = str;
            this.intValue = i;
        }

        public final int getIntValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LoginButton(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(str, "analyticsButtonCreatedEventName");
        // Intrinsics.checkNotNullParameter(str2, "analyticsButtonTappedEventName");
        super(context, attributeSet, i, i2, str, str2);
        this.properties = new LoginButtonProperties();
        this.toolTipStyle = Style.BLUE;
        if (ToolTipMode.Companion != null) {
            this.toolTipMode = ToolTipMode.DEFAULT;
            this.toolTipDisplayTime = ExoPlayerConfig.DEFAULT_LIVE_SEGMENT_SIZE_IN_MS;
            this.loginManagerLazy = TweetUtils.lazy((Function0<? extends T>) LoginButton$loginManagerLazy$1.INSTANCE);
            this.customButtonTransparency = InvitationReply.EXPIRED;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.loggerID = uuid;
            return;
        }
        throw null;
    }

    /* renamed from: checkToolTipSettings$lambda-3  reason: not valid java name */
    public static final void m75checkToolTipSettings$lambda3(String str, LoginButton loginButton) {
        Intrinsics.checkNotNullParameter(str, "$appId");
        Intrinsics.checkNotNullParameter(loginButton, "this$0");
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        loginButton.getActivity().runOnUiThread(new Runnable(FetchedAppSettingsManager.queryAppSettings(str, false)) {
            public final /* synthetic */ FetchedAppSettings f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                LoginButton.m76checkToolTipSettings$lambda3$lambda2(LoginButton.this, this.f$1);
            }
        });
    }

    /* renamed from: checkToolTipSettings$lambda-3$lambda-2  reason: not valid java name */
    public static final void m76checkToolTipSettings$lambda3$lambda2(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        Intrinsics.checkNotNullParameter(loginButton, "this$0");
        if (!CrashShieldHandler.isObjectCrashing(loginButton) && fetchedAppSettings != null) {
            try {
                if (fetchedAppSettings.nuxEnabled && loginButton.getVisibility() == 0) {
                    loginButton.displayToolTip(fetchedAppSettings.nuxContent);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, loginButton);
            }
        }
    }

    /* renamed from: onAttachedToWindow$lambda-0  reason: not valid java name */
    public static final void m77onAttachedToWindow$lambda0(ActivityResultParameters activityResultParameters) {
    }

    public final void checkToolTipSettings() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                int ordinal = this.toolTipMode.ordinal();
                if (ordinal == 0) {
                    String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable(metadataApplicationId, this) {
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ LoginButton f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final void run() {
                            LoginButton.m75checkToolTipSettings$lambda3(this.f$0, this.f$1);
                        }
                    });
                } else if (ordinal == 1) {
                    String string = getResources().getString(R$string.com_facebook_tooltip_default);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_tooltip_default)");
                    displayToolTip(string);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                super.configureButton(context, attributeSet, i, i2);
                setInternalOnClickListener(getNewLoginClickListener());
                parseLoginButtonAttributes(context, attributeSet, i, i2);
                if (isInEditMode()) {
                    setBackgroundColor(getResources().getColor(R$color.com_facebook_blue));
                    setLoginText("Continue with Facebook");
                } else {
                    this.accessTokenTracker = new LoginButton$configureButton$1(this);
                }
                setButtonText();
                setButtonRadius();
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    getBackground().setAlpha(this.customButtonTransparency);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
            setButtonIcon();
        }
    }

    public final void displayToolTip(String str) {
        ToolTipPopup toolTipPopup2;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                toolTipPopup2 = new ToolTipPopup(str, this);
                Style style = this.toolTipStyle;
                if (!CrashShieldHandler.isObjectCrashing(toolTipPopup2)) {
                    Intrinsics.checkNotNullParameter(style, "style");
                    toolTipPopup2.style = style;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
            long j = this.toolTipDisplayTime;
            if (!CrashShieldHandler.isObjectCrashing(toolTipPopup2)) {
                try {
                    toolTipPopup2.nuxDisplayTime = j;
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, toolTipPopup2);
                }
            }
            toolTipPopup2.show();
            this.toolTipPopup = toolTipPopup2;
        }
    }

    public final String getAuthType() {
        return this.properties.authType;
    }

    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.properties.defaultAudience;
    }

    public int getDefaultRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return RequestCodeOffset.Login.toRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public int getDefaultStyleResource() {
        return R$style.com_facebook_loginview_default_style;
    }

    public final String getLoggerID() {
        return this.loggerID;
    }

    public final LoginBehavior getLoginBehavior() {
        return this.properties.loginBehavior;
    }

    public final int getLoginButtonContinueLabel() {
        return R$string.com_facebook_loginview_log_in_button_continue;
    }

    public final Lazy<LoginManager> getLoginManagerLazy() {
        return this.loginManagerLazy;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.properties.loginTargetApp;
    }

    public final String getLoginText() {
        return this.loginText;
    }

    public final String getLogoutText() {
        return this.logoutText;
    }

    public final String getMessengerPageId() {
        return this.properties.messengerPageId;
    }

    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener(this);
    }

    public final List<String> getPermissions() {
        return this.properties.permissions;
    }

    public final LoginButtonProperties getProperties() {
        return this.properties;
    }

    public final boolean getResetMessengerState() {
        return this.properties.resetMessengerState;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        if (this.properties != null) {
            return false;
        }
        throw null;
    }

    public final long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public final ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public final Style getToolTipStyle() {
        return this.toolTipStyle;
    }

    public final int measureButtonWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public void onAttachedToWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onAttachedToWindow();
                if (getContext() instanceof ActivityResultRegistryOwner) {
                    Context context = getContext();
                    if (context != null) {
                        ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) context).getActivityResultRegistry();
                        LoginManager loginManager = (LoginManager) this.loginManagerLazy.getValue();
                        CallbackManager callbackManager2 = this.callbackManager;
                        String str = this.loggerID;
                        if (loginManager != null) {
                            this.androidXLoginCaller = activityResultRegistry.register("facebook-login", new FacebookLoginActivityResultContract(loginManager, callbackManager2, str), $$Lambda$l4VkT_EA0_Oq5neiJFo219TWLtY.INSTANCE);
                        } else {
                            throw null;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
                    }
                }
                AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
                if (accessTokenTracker2 != null) {
                    if (accessTokenTracker2.isTracking) {
                        accessTokenTracker2.startTracking();
                        setButtonText();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onDetachedFromWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onDetachedFromWindow();
                ActivityResultLauncher<Collection<String>> activityResultLauncher = this.androidXLoginCaller;
                if (activityResultLauncher != null) {
                    activityResultLauncher.unregister();
                }
                AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
                if (accessTokenTracker2 != null) {
                    if (accessTokenTracker2.isTracking) {
                        accessTokenTracker2.broadcastManager.unregisterReceiver(accessTokenTracker2.receiver);
                        accessTokenTracker2.isTracking = false;
                    }
                }
                ToolTipPopup toolTipPopup2 = this.toolTipPopup;
                if (toolTipPopup2 != null) {
                    toolTipPopup2.dismiss();
                }
                this.toolTipPopup = null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                super.onDraw(canvas);
                if (!this.toolTipChecked && !isInEditMode()) {
                    this.toolTipChecked = true;
                    checkToolTipSettings();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onLayout(z, i, i2, i3, i4);
                setButtonText();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int compoundPaddingTop;
        Resources resources;
        int i3;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FontMetrics fontMetrics = getPaint().getFontMetrics();
                compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
                resources = getResources();
                i3 = 0;
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    Resources resources2 = getResources();
                    String str = this.loginText;
                    if (str == null) {
                        str = resources2.getString(R$string.com_facebook_loginview_log_in_button_continue);
                        int measureButtonWidth = measureButtonWidth(str);
                        if (Button.resolveSize(measureButtonWidth, i) < measureButtonWidth) {
                            str = resources2.getString(R$string.com_facebook_loginview_log_in_button);
                        }
                    }
                    i3 = measureButtonWidth(str);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
            String str2 = this.logoutText;
            if (str2 == null) {
                str2 = resources.getString(R$string.com_facebook_loginview_log_out_button);
                Intrinsics.checkNotNullExpressionValue(str2, "resources.getString(R.string.com_facebook_loginview_log_out_button)");
            }
            setMeasuredDimension(Button.resolveSize(Math.max(i3, measureButtonWidth(str2)), i), compoundPaddingTop);
        }
    }

    public void onVisibilityChanged(View view, int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(view, "changedView");
                super.onVisibilityChanged(view, i);
                if (i != 0) {
                    ToolTipPopup toolTipPopup2 = this.toolTipPopup;
                    if (toolTipPopup2 != null) {
                        toolTipPopup2.dismiss();
                    }
                    this.toolTipPopup = null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        ToolTipMode toolTipMode2;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                if (ToolTipMode.Companion != null) {
                    this.toolTipMode = ToolTipMode.DEFAULT;
                    obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.com_facebook_login_view, i, i2);
                    Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context\n            .theme\n            .obtainStyledAttributes(\n                attrs, R.styleable.com_facebook_login_view, defStyleAttr, defStyleRes)");
                    this.confirmLogout = obtainStyledAttributes.getBoolean(R$styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
                    setLoginText(obtainStyledAttributes.getString(R$styleable.com_facebook_login_view_com_facebook_login_text));
                    setLogoutText(obtainStyledAttributes.getString(R$styleable.com_facebook_login_view_com_facebook_logout_text));
                    Companion companion = ToolTipMode.Companion;
                    int i3 = R$styleable.com_facebook_login_view_com_facebook_tooltip_mode;
                    if (ToolTipMode.Companion != null) {
                        int i4 = obtainStyledAttributes.getInt(i3, ToolTipMode.DEFAULT.getIntValue());
                        if (companion != null) {
                            ToolTipMode[] values = ToolTipMode.values();
                            int length = values.length;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length) {
                                    toolTipMode2 = null;
                                    break;
                                }
                                toolTipMode2 = values[i5];
                                if (toolTipMode2.getIntValue() == i4) {
                                    break;
                                }
                                i5++;
                            }
                            if (toolTipMode2 == null) {
                                if (ToolTipMode.Companion != null) {
                                    toolTipMode2 = ToolTipMode.DEFAULT;
                                } else {
                                    throw null;
                                }
                            }
                            this.toolTipMode = toolTipMode2;
                            if (obtainStyledAttributes.hasValue(R$styleable.com_facebook_login_view_com_facebook_login_button_radius)) {
                                this.customButtonRadius = Float.valueOf(obtainStyledAttributes.getDimension(R$styleable.com_facebook_login_view_com_facebook_login_button_radius, 0.0f));
                            }
                            int integer = obtainStyledAttributes.getInteger(R$styleable.com_facebook_login_view_com_facebook_login_button_transparency, InvitationReply.EXPIRED);
                            this.customButtonTransparency = integer;
                            int max = Math.max(0, integer);
                            this.customButtonTransparency = max;
                            this.customButtonTransparency = Math.min(InvitationReply.EXPIRED, max);
                            obtainStyledAttributes.recycle();
                            return;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setAuthType(String str) {
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        LoginButtonProperties loginButtonProperties = this.properties;
        if (loginButtonProperties != null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            loginButtonProperties.authType = str;
            return;
        }
        throw null;
    }

    public final void setButtonIcon() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), R$drawable.com_facebook_button_icon), null, null, null);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @TargetApi(29)
    public final void setButtonRadius() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Float f2 = this.customButtonRadius;
                if (f2 != null) {
                    float floatValue = f2.floatValue();
                    Drawable background = getBackground();
                    if (VERSION.SDK_INT >= 29 && (background instanceof StateListDrawable)) {
                        int i = 0;
                        int stateCount = ((StateListDrawable) background).getStateCount();
                        if (stateCount > 0) {
                            while (true) {
                                int i2 = i + 1;
                                Drawable stateDrawable = ((StateListDrawable) background).getStateDrawable(i);
                                GradientDrawable gradientDrawable = stateDrawable instanceof GradientDrawable ? (GradientDrawable) stateDrawable : null;
                                if (gradientDrawable != null) {
                                    gradientDrawable.setCornerRadius(floatValue);
                                }
                                if (i2 >= stateCount) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                    }
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setCornerRadius(floatValue);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setButtonText() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Resources resources = getResources();
                if (!isInEditMode()) {
                    Companion companion = AccessToken.Companion;
                    if (Companion.isCurrentAccessTokenActive()) {
                        String str = this.logoutText;
                        if (str == null) {
                            str = resources.getString(R$string.com_facebook_loginview_log_out_button);
                        }
                        setText(str);
                    }
                }
                if (this.loginText != null) {
                    setText(this.loginText);
                } else {
                    String string = resources.getString(getLoginButtonContinueLabel());
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(loginButtonContinueLabel)");
                    int width = getWidth();
                    if (width != 0 && measureButtonWidth(string) > width) {
                        string = resources.getString(R$string.com_facebook_loginview_log_in_button);
                        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.com_facebook_loginview_log_in_button)");
                    }
                    setText(string);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setDefaultAudience(DefaultAudience defaultAudience) {
        Intrinsics.checkNotNullParameter(defaultAudience, HSLCriteriaBuilder.VALUE);
        LoginButtonProperties loginButtonProperties = this.properties;
        if (loginButtonProperties != null) {
            Intrinsics.checkNotNullParameter(defaultAudience, "<set-?>");
            loginButtonProperties.defaultAudience = defaultAudience;
            return;
        }
        throw null;
    }

    public final void setLoginBehavior(LoginBehavior loginBehavior) {
        Intrinsics.checkNotNullParameter(loginBehavior, HSLCriteriaBuilder.VALUE);
        LoginButtonProperties loginButtonProperties = this.properties;
        if (loginButtonProperties != null) {
            Intrinsics.checkNotNullParameter(loginBehavior, "<set-?>");
            loginButtonProperties.loginBehavior = loginBehavior;
            return;
        }
        throw null;
    }

    public final void setLoginManagerLazy(Lazy<? extends LoginManager> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.loginManagerLazy = lazy;
    }

    public final void setLoginTargetApp(LoginTargetApp loginTargetApp) {
        Intrinsics.checkNotNullParameter(loginTargetApp, HSLCriteriaBuilder.VALUE);
        LoginButtonProperties loginButtonProperties = this.properties;
        if (loginButtonProperties != null) {
            Intrinsics.checkNotNullParameter(loginTargetApp, "<set-?>");
            loginButtonProperties.loginTargetApp = loginTargetApp;
            return;
        }
        throw null;
    }

    public final void setLoginText(String str) {
        this.loginText = str;
        setButtonText();
    }

    public final void setLogoutText(String str) {
        this.logoutText = str;
        setButtonText();
    }

    public final void setMessengerPageId(String str) {
        this.properties.messengerPageId = str;
    }

    public final void setPermissions(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.properties.setPermissions(TweetUtils.listOfNotNull((T[]) Arrays.copyOf(strArr, strArr.length)));
    }

    public final void setPublishPermissions(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        this.properties.setPermissions(list);
    }

    public final void setReadPermissions(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "permissions");
        this.properties.setPermissions(list);
    }

    public final void setResetMessengerState(boolean z) {
        this.properties.resetMessengerState = z;
    }

    public final void setToolTipDisplayTime(long j) {
        this.toolTipDisplayTime = j;
    }

    public final void setToolTipMode(ToolTipMode toolTipMode2) {
        Intrinsics.checkNotNullParameter(toolTipMode2, "<set-?>");
        this.toolTipMode = toolTipMode2;
    }

    public final void setToolTipStyle(Style style) {
        Intrinsics.checkNotNullParameter(style, "<set-?>");
        this.toolTipStyle = style;
    }

    public final void setPermissions(List<String> list) {
        Intrinsics.checkNotNullParameter(list, HSLCriteriaBuilder.VALUE);
        this.properties.setPermissions(list);
    }

    public final void setPublishPermissions(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.properties.setPermissions(TweetUtils.listOfNotNull((T[]) Arrays.copyOf(strArr, strArr.length)));
    }

    public final void setReadPermissions(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.properties.setPermissions(TweetUtils.listOfNotNull((T[]) Arrays.copyOf(strArr, strArr.length)));
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LoginButton(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, i, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }
}
