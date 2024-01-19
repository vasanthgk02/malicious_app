package com.facebook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.common.R$color;
import com.facebook.common.R$style;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u00002\u00020\u0001B9\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0014J*\u00104\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u00105\u001a\u00020\u0007H\u0016J\b\u00106\u001a\u00020\u0007H\u0016J\u0012\u00107\u001a\u0002012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u00108\u001a\u0002012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0014J\u0012\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010;\u001a\u000201H\u0014J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>H\u0014J*\u0010?\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010@\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0003J*\u0010A\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010B\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010C\u001a\u0002012\u0006\u0010\u001f\u001a\u00020%J\u000e\u0010C\u001a\u0002012\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010D\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010F\u001a\u0002012\b\u0010E\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010G\u001a\u000201H\u0002R\u0014\u0010\r\u001a\u00020\u000e8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0007X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010$\u001a\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001a¨\u0006H"}, d2 = {"Lcom/facebook/FacebookButtonBase;", "Landroid/widget/Button;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "analyticsButtonCreatedEventName", "", "analyticsButtonTappedEventName", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "getAnalyticsButtonCreatedEventName", "()Ljava/lang/String;", "getAnalyticsButtonTappedEventName", "androidxActivityResultRegistryOwner", "Landroidx/activity/result/ActivityResultRegistryOwner;", "getAndroidxActivityResultRegistryOwner", "()Landroidx/activity/result/ActivityResultRegistryOwner;", "defaultRequestCode", "getDefaultRequestCode", "()I", "defaultStyleResource", "getDefaultStyleResource", "externalOnClickListener", "Landroid/view/View$OnClickListener;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "internalOnClickListener", "nativeFragment", "Landroid/app/Fragment;", "getNativeFragment", "()Landroid/app/Fragment;", "overrideCompoundPadding", "", "overrideCompoundPaddingLeft", "overrideCompoundPaddingRight", "parentFragment", "Lcom/facebook/internal/FragmentWrapper;", "requestCode", "getRequestCode", "callExternalOnClickListener", "", "v", "Landroid/view/View;", "configureButton", "getCompoundPaddingLeft", "getCompoundPaddingRight", "logButtonCreated", "logButtonTapped", "measureTextWidth", "text", "onAttachedToWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "parseBackgroundAttributes", "parseCompoundDrawableAttributes", "parseContentAttributes", "parseTextAttributes", "setFragment", "setInternalOnClickListener", "l", "setOnClickListener", "setupOnClickListener", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@SuppressLint({"ResourceType"})
/* compiled from: FacebookButtonBase.kt */
public abstract class FacebookButtonBase extends Button {
    public final String analyticsButtonCreatedEventName;
    public final String analyticsButtonTappedEventName;
    public OnClickListener externalOnClickListener;
    public OnClickListener internalOnClickListener;
    public boolean overrideCompoundPadding;
    public int overrideCompoundPaddingLeft;
    public int overrideCompoundPaddingRight;
    public FragmentWrapper parentFragment;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FacebookButtonBase(Context context, AttributeSet attributeSet, int i, int i2, String str, String str2) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(str, "analyticsButtonCreatedEventName");
        // Intrinsics.checkNotNullParameter(str2, "analyticsButtonTappedEventName");
        super(context, attributeSet, 0);
        configureButton(context, attributeSet, i, (i2 == 0 ? getDefaultStyleResource() : i2) == 0 ? R$style.com_facebook_button : i2 == 0 ? getDefaultStyleResource() : i2);
        this.analyticsButtonCreatedEventName = str;
        this.analyticsButtonTappedEventName = str2;
        setClickable(true);
        setFocusable(true);
    }

    /* renamed from: setupOnClickListener$lambda-0  reason: not valid java name */
    public static final void m120setupOnClickListener$lambda0(FacebookButtonBase facebookButtonBase, View view) {
        if (!CrashShieldHandler.isObjectCrashing(FacebookButtonBase.class)) {
            try {
                Intrinsics.checkNotNullParameter(facebookButtonBase, "this$0");
                Context context = facebookButtonBase.getContext();
                if (!CrashShieldHandler.isObjectCrashing(facebookButtonBase)) {
                    AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, (String) null, (AccessToken) null);
                    Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
                    String str = facebookButtonBase.analyticsButtonTappedEventName;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                        appEventsLoggerImpl.logEventImplicitly(str, null, null);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FacebookButtonBase.class);
                return;
            }
            OnClickListener onClickListener = facebookButtonBase.internalOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            } else {
                OnClickListener onClickListener2 = facebookButtonBase.externalOnClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        }
    }

    public void callExternalOnClickListener(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                OnClickListener onClickListener = this.externalOnClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
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
                parseBackgroundAttributes(context, attributeSet, i, i2);
                parseCompoundDrawableAttributes(context, attributeSet, i, i2);
                parseContentAttributes(context, attributeSet, i, i2);
                parseTextAttributes(context, attributeSet, i, i2);
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    super.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            FacebookButtonBase.m120setupOnClickListener$lambda0(FacebookButtonBase.this, view);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public Activity getActivity() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Context context = getContext();
            while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            throw new FacebookException((String) "Unable to get Activity.");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getAnalyticsButtonCreatedEventName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.analyticsButtonCreatedEventName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getAnalyticsButtonTappedEventName() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.analyticsButtonTappedEventName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final ActivityResultRegistryOwner getAndroidxActivityResultRegistryOwner() {
        ActivityResultRegistryOwner activityResultRegistryOwner = null;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Activity activity = getActivity();
            if (activity instanceof ActivityResultRegistryOwner) {
                activityResultRegistryOwner = (ActivityResultRegistryOwner) activity;
            }
            return activityResultRegistryOwner;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public int getCompoundPaddingLeft() {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            if (this.overrideCompoundPadding) {
                i = this.overrideCompoundPaddingLeft;
            } else {
                i = super.getCompoundPaddingLeft();
            }
            return i;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public int getCompoundPaddingRight() {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            if (this.overrideCompoundPadding) {
                i = this.overrideCompoundPaddingRight;
            } else {
                i = super.getCompoundPaddingRight();
            }
            return i;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public abstract int getDefaultRequestCode();

    public int getDefaultStyleResource() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
        }
        return 0;
    }

    public final Fragment getFragment() {
        Fragment fragment = null;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            FragmentWrapper fragmentWrapper = this.parentFragment;
            if (fragmentWrapper != null) {
                fragment = fragmentWrapper.supportFragment;
            }
            return fragment;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final android.app.Fragment getNativeFragment() {
        android.app.Fragment fragment = null;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            FragmentWrapper fragmentWrapper = this.parentFragment;
            if (fragmentWrapper != null) {
                fragment = fragmentWrapper.nativeFragment;
            }
            return fragment;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public int getRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getDefaultRequestCode();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public int measureTextWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return (int) Math.ceil((double) getPaint().measureText(str));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public void onAttachedToWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onAttachedToWindow();
                if (!isInEditMode()) {
                    Context context = getContext();
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, (String) null, (AccessToken) null);
                        Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
                        String str = this.analyticsButtonCreatedEventName;
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                            appEventsLoggerImpl.logEventImplicitly(str, null, null);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onDraw(Canvas canvas) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                if ((getGravity() & 1) != 0) {
                    int compoundPaddingLeft = getCompoundPaddingLeft();
                    int compoundPaddingRight = getCompoundPaddingRight();
                    int min = Math.min((((getWidth() - (getCompoundDrawablePadding() + compoundPaddingLeft)) - compoundPaddingRight) - measureTextWidth(getText().toString())) / 2, (compoundPaddingLeft - getPaddingLeft()) / 2);
                    this.overrideCompoundPaddingLeft = compoundPaddingLeft - min;
                    this.overrideCompoundPaddingRight = compoundPaddingRight + min;
                    this.overrideCompoundPadding = true;
                }
                super.onDraw(canvas);
                this.overrideCompoundPadding = false;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void parseBackgroundAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (!isInEditMode()) {
                    obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842964}, i, i2);
                    Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                    if (obtainStyledAttributes.hasValue(0)) {
                        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                        if (resourceId != 0) {
                            setBackgroundResource(resourceId);
                        } else {
                            setBackgroundColor(obtainStyledAttributes.getColor(0, 0));
                        }
                    } else {
                        setBackgroundColor(ContextCompat.getColor(context, R$color.com_facebook_blue));
                    }
                    obtainStyledAttributes.recycle();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @SuppressLint({"ResourceType"})
    public final void parseCompoundDrawableAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16843119, 16843117, 16843120, 16843118, 16843121}, i, i2);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                setCompoundDrawablesWithIntrinsicBounds(obtainStyledAttributes.getResourceId(0, 0), obtainStyledAttributes.getResourceId(1, 0), obtainStyledAttributes.getResourceId(2, 0), obtainStyledAttributes.getResourceId(3, 0));
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
                obtainStyledAttributes.recycle();
                setCompoundDrawablePadding(dimensionPixelSize);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void parseContentAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842966, 16842967, 16842968, 16842969}, i, i2);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                setPadding(obtainStyledAttributes.getDimensionPixelSize(0, 0), obtainStyledAttributes.getDimensionPixelSize(1, 0), obtainStyledAttributes.getDimensionPixelSize(2, 0), obtainStyledAttributes.getDimensionPixelSize(3, 0));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void parseTextAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        TypedArray obtainStyledAttributes2;
        TypedArray obtainStyledAttributes3;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842904}, i, i2);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyledAttributes(attrs, colorResources, defStyleAttr, defStyleRes)");
                setTextColor(obtainStyledAttributes.getColorStateList(0));
                obtainStyledAttributes.recycle();
                obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842927}, i, i2);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "context.theme.obtainStyledAttributes(attrs, gravityResources, defStyleAttr, defStyleRes)");
                int i3 = obtainStyledAttributes2.getInt(0, 17);
                obtainStyledAttributes2.recycle();
                setGravity(i3);
                obtainStyledAttributes3 = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{16842901, 16842903, 16843087}, i, i2);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes3, "context.theme.obtainStyledAttributes(attrs, attrsResources, defStyleAttr, defStyleRes)");
                setTextSize(0, (float) obtainStyledAttributes3.getDimensionPixelSize(0, 0));
                setTypeface(Typeface.create(getTypeface(), 1));
                String string = obtainStyledAttributes3.getString(2);
                obtainStyledAttributes3.recycle();
                setText(string);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setFragment(android.app.Fragment fragment) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                this.parentFragment = new FragmentWrapper(fragment);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setInternalOnClickListener(OnClickListener onClickListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.internalOnClickListener = onClickListener;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.externalOnClickListener = onClickListener;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setFragment(Fragment fragment) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                this.parentFragment = new FragmentWrapper(fragment);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
