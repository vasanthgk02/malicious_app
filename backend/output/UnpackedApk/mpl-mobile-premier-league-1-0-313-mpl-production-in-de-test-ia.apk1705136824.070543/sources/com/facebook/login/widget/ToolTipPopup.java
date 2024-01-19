package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R$drawable;
import com.facebook.login.R$id;
import com.facebook.login.R$layout;
import com.mpl.androidapp.miniprofile.models.ExoPlayerConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup;", "", "text", "", "anchor", "Landroid/view/View;", "(Ljava/lang/String;Landroid/view/View;)V", "anchorViewRef", "Ljava/lang/ref/WeakReference;", "context", "Landroid/content/Context;", "nuxDisplayTime", "", "popupContent", "Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "popupWindow", "Landroid/widget/PopupWindow;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "style", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "dismiss", "", "registerObserver", "setNuxDisplayTime", "displayTime", "setStyle", "show", "unregisterObserver", "updateArrows", "Companion", "PopupContentView", "Style", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ToolTipPopup.kt */
public final class ToolTipPopup {
    public final WeakReference<View> anchorViewRef;
    public final Context context;
    public long nuxDisplayTime = ExoPlayerConfig.DEFAULT_LIVE_SEGMENT_SIZE_IN_MS;
    public PopupContentView popupContent;
    public PopupWindow popupWindow;
    public final OnScrollChangedListener scrollListener = new OnScrollChangedListener() {
        public final void onScrollChanged() {
            ToolTipPopup.m80scrollListener$lambda1(ToolTipPopup.this);
        }
    };
    public Style style = Style.BLUE;
    public final String text;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$PopupContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/facebook/login/widget/ToolTipPopup;Landroid/content/Context;)V", "bodyFrame", "Landroid/view/View;", "getBodyFrame", "()Landroid/view/View;", "bottomArrow", "Landroid/widget/ImageView;", "getBottomArrow", "()Landroid/widget/ImageView;", "topArrow", "getTopArrow", "xOut", "getXOut", "showBottomArrow", "", "showTopArrow", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ToolTipPopup.kt */
    public final class PopupContentView extends FrameLayout {
        public final View bodyFrame;
        public final ImageView bottomArrow;
        public final ImageView topArrow;
        public final ImageView xOut;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public PopupContentView(ToolTipPopup toolTipPopup, Context context) {
            // Intrinsics.checkNotNullParameter(toolTipPopup, "this$0");
            // Intrinsics.checkNotNullParameter(context, "context");
            super(context);
            LayoutInflater.from(context).inflate(R$layout.com_facebook_tooltip_bubble, this);
            View findViewById = findViewById(R$id.com_facebook_tooltip_bubble_view_top_pointer);
            if (findViewById != null) {
                this.topArrow = (ImageView) findViewById;
                View findViewById2 = findViewById(R$id.com_facebook_tooltip_bubble_view_bottom_pointer);
                if (findViewById2 != null) {
                    this.bottomArrow = (ImageView) findViewById2;
                    View findViewById3 = findViewById(R$id.com_facebook_body_frame);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.com_facebook_body_frame)");
                    this.bodyFrame = findViewById3;
                    View findViewById4 = findViewById(R$id.com_facebook_button_xout);
                    if (findViewById4 != null) {
                        this.xOut = (ImageView) findViewById4;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/widget/ToolTipPopup$Style;", "", "(Ljava/lang/String;I)V", "BLUE", "BLACK", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ToolTipPopup.kt */
    public enum Style {
        BLUE,
        BLACK
    }

    public ToolTipPopup(String str, View view) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(view, "anchor");
        this.text = str;
        this.anchorViewRef = new WeakReference<>(view);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "anchor.context");
        this.context = context2;
    }

    /* renamed from: scrollListener$lambda-1  reason: not valid java name */
    public static final void m80scrollListener$lambda1(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(toolTipPopup, "this$0");
                if (toolTipPopup.anchorViewRef.get() != null) {
                    PopupWindow popupWindow2 = toolTipPopup.popupWindow;
                    if (popupWindow2 != null) {
                        if (popupWindow2.isShowing()) {
                            if (popupWindow2.isAboveAnchor()) {
                                PopupContentView popupContentView = toolTipPopup.popupContent;
                                if (popupContentView != null) {
                                    popupContentView.topArrow.setVisibility(4);
                                    popupContentView.bottomArrow.setVisibility(0);
                                }
                            } else {
                                PopupContentView popupContentView2 = toolTipPopup.popupContent;
                                if (popupContentView2 != null) {
                                    popupContentView2.topArrow.setVisibility(0);
                                    popupContentView2.bottomArrow.setVisibility(4);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: show$lambda-2  reason: not valid java name */
    public static final void m81show$lambda2(ToolTipPopup toolTipPopup) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(toolTipPopup, "this$0");
                toolTipPopup.dismiss();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: show$lambda-3  reason: not valid java name */
    public static final void m82show$lambda3(ToolTipPopup toolTipPopup, View view) {
        Class<ToolTipPopup> cls = ToolTipPopup.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(toolTipPopup, "this$0");
                toolTipPopup.dismiss();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void dismiss() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                unregisterObserver();
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void show() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.anchorViewRef.get() != null) {
                    PopupContentView popupContentView = new PopupContentView(this, this.context);
                    this.popupContent = popupContentView;
                    View findViewById = popupContentView.findViewById(R$id.com_facebook_tooltip_bubble_view_text_body);
                    if (findViewById != null) {
                        ((TextView) findViewById).setText(this.text);
                        if (this.style == Style.BLUE) {
                            popupContentView.bodyFrame.setBackgroundResource(R$drawable.com_facebook_tooltip_blue_background);
                            popupContentView.bottomArrow.setImageResource(R$drawable.com_facebook_tooltip_blue_bottomnub);
                            popupContentView.topArrow.setImageResource(R$drawable.com_facebook_tooltip_blue_topnub);
                            popupContentView.xOut.setImageResource(R$drawable.com_facebook_tooltip_blue_xout);
                        } else {
                            popupContentView.bodyFrame.setBackgroundResource(R$drawable.com_facebook_tooltip_black_background);
                            popupContentView.bottomArrow.setImageResource(R$drawable.com_facebook_tooltip_black_bottomnub);
                            popupContentView.topArrow.setImageResource(R$drawable.com_facebook_tooltip_black_topnub);
                            popupContentView.xOut.setImageResource(R$drawable.com_facebook_tooltip_black_xout);
                        }
                        View decorView = ((Activity) this.context).getWindow().getDecorView();
                        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
                        int width = decorView.getWidth();
                        int height = decorView.getHeight();
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            unregisterObserver();
                            View view = (View) this.anchorViewRef.get();
                            if (view != null) {
                                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                                if (viewTreeObserver != null) {
                                    viewTreeObserver.addOnScrollChangedListener(this.scrollListener);
                                }
                            }
                        }
                        popupContentView.measure(MeasureSpec.makeMeasureSpec(width, LinearLayoutManager.INVALID_OFFSET), MeasureSpec.makeMeasureSpec(height, LinearLayoutManager.INVALID_OFFSET));
                        PopupWindow popupWindow2 = new PopupWindow(popupContentView, popupContentView.getMeasuredWidth(), popupContentView.getMeasuredHeight());
                        this.popupWindow = popupWindow2;
                        popupWindow2.showAsDropDown((View) this.anchorViewRef.get());
                        updateArrows();
                        if (this.nuxDisplayTime > 0) {
                            popupContentView.postDelayed(new Runnable() {
                                public final void run() {
                                    ToolTipPopup.m81show$lambda2(ToolTipPopup.this);
                                }
                            }, this.nuxDisplayTime);
                        }
                        popupWindow2.setTouchable(true);
                        popupContentView.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                ToolTipPopup.m82show$lambda3(ToolTipPopup.this, view);
                            }
                        });
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void unregisterObserver() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View view = (View) this.anchorViewRef.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnScrollChangedListener(this.scrollListener);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void updateArrows() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 != null) {
                    if (popupWindow2.isShowing()) {
                        if (popupWindow2.isAboveAnchor()) {
                            PopupContentView popupContentView = this.popupContent;
                            if (popupContentView != null) {
                                popupContentView.topArrow.setVisibility(4);
                                popupContentView.bottomArrow.setVisibility(0);
                            }
                        } else {
                            PopupContentView popupContentView2 = this.popupContent;
                            if (popupContentView2 != null) {
                                popupContentView2.topArrow.setVisibility(0);
                                popupContentView2.bottomArrow.setVisibility(4);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
