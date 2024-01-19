package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnShowListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.R$style;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;

public class ReactModalHostView extends ViewGroup implements LifecycleEventListener {
    public String mAnimationType;
    public Dialog mDialog;
    public boolean mHardwareAccelerated;
    public DialogRootViewGroup mHostView;
    public OnRequestCloseListener mOnRequestCloseListener;
    public OnShowListener mOnShowListener;
    public boolean mPropertyRequiresNewDialog;
    public boolean mStatusBarTranslucent;
    public boolean mTransparent;

    public static class DialogRootViewGroup extends ReactViewGroup implements RootView {
        public boolean hasAdjustedSize = false;
        public final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);
        public StateWrapper mStateWrapper;
        public int viewHeight;
        public int viewWidth;

        public DialogRootViewGroup(Context context) {
            super(context);
        }

        public void addView(View view, int i, LayoutParams layoutParams) {
            super.addView(view, i, layoutParams);
            if (this.hasAdjustedSize) {
                updateFirstChildView();
            }
        }

        public final EventDispatcher getEventDispatcher() {
            return ((UIManagerModule) getReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
        }

        public final ReactContext getReactContext() {
            return (ReactContext) getContext();
        }

        public void handleException(Throwable th) {
            getReactContext().handleException(new RuntimeException(th));
        }

        public void onChildStartedNativeGesture(MotionEvent motionEvent) {
            JSTouchDispatcher jSTouchDispatcher = this.mJSTouchDispatcher;
            EventDispatcher eventDispatcher = getEventDispatcher();
            if (!jSTouchDispatcher.mChildIsHandlingNativeGesture) {
                jSTouchDispatcher.dispatchCancelEvent(motionEvent, eventDispatcher);
                jSTouchDispatcher.mChildIsHandlingNativeGesture = true;
                jSTouchDispatcher.mTargetTag = -1;
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.viewWidth = i;
            this.viewHeight = i2;
            updateFirstChildView();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, getEventDispatcher());
            super.onTouchEvent(motionEvent);
            return true;
        }

        public void requestDisallowInterceptTouchEvent(boolean z) {
        }

        public final void updateFirstChildView() {
            if (getChildCount() > 0) {
                this.hasAdjustedSize = false;
                final int id = getChildAt(0).getId();
                StateWrapper stateWrapper = this.mStateWrapper;
                if (stateWrapper != null) {
                    updateState(stateWrapper, this.viewWidth, this.viewHeight);
                    return;
                }
                ReactContext reactContext = getReactContext();
                reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                    public void runGuarded() {
                        int i = id;
                        DialogRootViewGroup dialogRootViewGroup = DialogRootViewGroup.this;
                        ((UIManagerModule) DialogRootViewGroup.this.getReactContext().getNativeModule(UIManagerModule.class)).updateNodeSize(i, dialogRootViewGroup.viewWidth, dialogRootViewGroup.viewHeight);
                    }
                });
                return;
            }
            this.hasAdjustedSize = true;
        }

        public void updateState(StateWrapper stateWrapper, int i, int i2) {
            this.mStateWrapper = stateWrapper;
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("screenWidth", (double) ImageOriginUtils.toDIPFromPixel((float) i));
            writableNativeMap.putDouble("screenHeight", (double) ImageOriginUtils.toDIPFromPixel((float) i2));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    public interface OnRequestCloseListener {
    }

    public ReactModalHostView(Context context) {
        super(context);
        ((ReactContext) context).addLifecycleEventListener(this);
        this.mHostView = new DialogRootViewGroup(context);
    }

    private View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mHostView);
        if (this.mStatusBarTranslucent) {
            frameLayout.setSystemUiVisibility(1024);
        } else {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private Activity getCurrentActivity() {
        return ((ReactContext) getContext()).getCurrentActivity();
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public void addView(View view, int i) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.addView(view, i);
    }

    public final void dismiss() {
        UiThreadUtil.assertOnUiThread();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                Context context = this.mDialog.getContext();
                Class<Activity> cls = Activity.class;
                while (true) {
                    if (!cls.isInstance(context)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        Context baseContext = ((ContextWrapper) context).getBaseContext();
                        if (context == baseContext) {
                            break;
                        }
                        context = baseContext;
                    } else {
                        break;
                    }
                }
                context = null;
                Activity activity = (Activity) context;
                if (activity == null || !activity.isFinishing()) {
                    this.mDialog.dismiss();
                }
            }
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        this.mHostView.dispatchProvideStructure(viewStructure);
    }

    public View getChildAt(int i) {
        return this.mHostView.getChildAt(i);
    }

    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismiss();
    }

    public void onHostDestroy() {
        ((ReactContext) getContext()).removeLifecycleEventListener(this);
        dismiss();
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        showOrUpdate();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(view);
    }

    public void removeViewAt(int i) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(getChildAt(i));
    }

    public void setAnimationType(String str) {
        this.mAnimationType = str;
        this.mPropertyRequiresNewDialog = true;
    }

    public void setHardwareAccelerated(boolean z) {
        this.mHardwareAccelerated = z;
        this.mPropertyRequiresNewDialog = true;
    }

    public void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.mOnRequestCloseListener = onRequestCloseListener;
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    public void setStatusBarTranslucent(boolean z) {
        this.mStatusBarTranslucent = z;
        this.mPropertyRequiresNewDialog = true;
    }

    public void setTransparent(boolean z) {
        this.mTransparent = z;
    }

    public void showOrUpdate() {
        UiThreadUtil.assertOnUiThread();
        if (this.mDialog != null) {
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        this.mPropertyRequiresNewDialog = false;
        int i = R$style.Theme_FullScreenDialog;
        if (this.mAnimationType.equals("fade")) {
            i = R$style.Theme_FullScreenDialogAnimatedFade;
        } else if (this.mAnimationType.equals("slide")) {
            i = R$style.Theme_FullScreenDialogAnimatedSlide;
        }
        Activity currentActivity = getCurrentActivity();
        Context context = currentActivity == 0 ? getContext() : currentActivity;
        Dialog dialog = new Dialog(context, i);
        this.mDialog = dialog;
        dialog.getWindow().setFlags(8, 8);
        this.mDialog.setContentView(getContentView());
        updateProperties();
        this.mDialog.setOnShowListener(this.mOnShowListener);
        this.mDialog.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    if (i == 4) {
                        ImageOriginUtils.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
                        com.facebook.react.views.modal.ReactModalHostManager.AnonymousClass1 r2 = (com.facebook.react.views.modal.ReactModalHostManager.AnonymousClass1) ReactModalHostView.this.mOnRequestCloseListener;
                        eventDispatcher.dispatchEvent(new RequestCloseEvent(reactModalHostView.getId()));
                        return true;
                    }
                    Activity currentActivity = ((ReactContext) ReactModalHostView.this.getContext()).getCurrentActivity();
                    if (currentActivity != null) {
                        return currentActivity.onKeyUp(i, keyEvent);
                    }
                }
                return false;
            }
        });
        this.mDialog.getWindow().setSoftInputMode(16);
        if (this.mHardwareAccelerated) {
            this.mDialog.getWindow().addFlags(16777216);
        }
        if (currentActivity != 0 && !currentActivity.isFinishing()) {
            this.mDialog.show();
            if (context instanceof Activity) {
                this.mDialog.getWindow().getDecorView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.mDialog.getWindow().clearFlags(8);
        }
    }

    public final void updateProperties() {
        ImageOriginUtils.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if ((currentActivity.getWindow().getAttributes().flags & 1024) != 0) {
                this.mDialog.getWindow().addFlags(1024);
            } else {
                this.mDialog.getWindow().clearFlags(1024);
            }
        }
        if (this.mTransparent) {
            this.mDialog.getWindow().clearFlags(2);
            return;
        }
        this.mDialog.getWindow().setDimAmount(0.5f);
        this.mDialog.getWindow().setFlags(2, 2);
    }
}
