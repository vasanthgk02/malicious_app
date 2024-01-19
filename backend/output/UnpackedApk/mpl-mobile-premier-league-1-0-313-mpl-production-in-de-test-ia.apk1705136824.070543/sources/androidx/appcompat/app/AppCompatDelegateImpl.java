package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper.CallbackWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder.Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.OnAttachListener;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;

public class AppCompatDelegateImpl extends AppCompatDelegate implements Callback, Factory2 {
    public static final boolean IS_PRE_LOLLIPOP = false;
    public static final boolean sCanApplyOverrideConfiguration = true;
    public static final boolean sCanReturnDifferentContext = (!"robolectric".equals(Build.FINGERPRINT));
    public static boolean sInstalledExceptionHandler = true;
    public static final SimpleArrayMap<String, Integer> sLocalNightModes = new SimpleArrayMap<>();
    public static final int[] sWindowBackgroundStyleable = {16842836};
    public ActionBar mActionBar;
    public ActionMenuPresenterCallback mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public boolean mActivityHandlesUiMode;
    public boolean mActivityHandlesUiModeChecked;
    public final AppCompatCallback mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoNightModeManager mAutoBatteryNightModeManager;
    public AutoNightModeManager mAutoTimeNightModeManager;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mEnableDefaultActionBarUp;
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHandleNativeActionModes = true;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public final Runnable mInvalidatePanelMenuRunnable = new Runnable() {
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                appCompatDelegateImpl.doInvalidatePanelMenu(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.mInvalidatePanelMenuFeatures & 4096) != 0) {
                appCompatDelegateImpl2.doInvalidatePanelMenu(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.mInvalidatePanelMenuPosted = false;
            appCompatDelegateImpl3.mInvalidatePanelMenuFeatures = 0;
        }
    };
    public boolean mIsDestroyed;
    public boolean mIsFloating;
    public int mLocalNightMode = -100;
    public boolean mLongPressBackDown;
    public MenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public Runnable mShowActionModePopup;
    public boolean mStarted;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4  reason: invalid class name */
    public class AnonymousClass4 implements FitWindowsViewGroup$OnFitSystemWindowsListener {
        public final /* synthetic */ AppCompatDelegateImpl this$0;
    }

    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle$Delegate {
        public ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
        }
    }

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.checkCloseActionMenu(menuBuilder);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback windowCallback = AppCompatDelegateImpl.this.getWindowCallback();
            if (windowCallback != null) {
                windowCallback.onMenuOpened(108, menuBuilder);
            }
            return true;
        }
    }

    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        public ActionMode.Callback mWrapped;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.mWrapped = callback;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.mActionModePopup != null) {
                appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.mShowActionModePopup);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.mActionModeView != null) {
                appCompatDelegateImpl2.endOnGoingFadeAnimation();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl3.mActionModeView);
                animate.alpha(0.0f);
                appCompatDelegateImpl3.mFadeAnim = animate;
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = AppCompatDelegateImpl.this.mFadeAnim;
                AnonymousClass1 r0 = new ViewPropertyAnimatorListenerAdapter() {
                    public void onAnimationEnd(View view) {
                        AppCompatDelegateImpl.this.mActionModeView.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl.mActionModePopup;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl.this.mActionModeView.getParent());
                        }
                        AppCompatDelegateImpl.this.mActionModeView.killMode();
                        AppCompatDelegateImpl.this.mFadeAnim.setListener(null);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        appCompatDelegateImpl2.mFadeAnim = null;
                        ViewCompat.requestApplyInsets(appCompatDelegateImpl2.mSubDecor);
                    }
                };
                View view = (View) viewPropertyAnimatorCompat.mView.get();
                if (view != null) {
                    viewPropertyAnimatorCompat.setListenerInternal(view, r0);
                }
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            AppCompatCallback appCompatCallback = appCompatDelegateImpl4.mAppCompatCallback;
            if (appCompatCallback != null) {
                appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.mActionMode);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.mActionMode = null;
            ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets(AppCompatDelegateImpl.this.mSubDecor);
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {
        public AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || this.mWrapped.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            if (r6 != false) goto L_0x001d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.mWrapped
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x004f
                androidx.appcompat.app.AppCompatDelegateImpl r0 = androidx.appcompat.app.AppCompatDelegateImpl.this
                int r3 = r6.getKeyCode()
                r0.initWindowDecorActionBar()
                androidx.appcompat.app.ActionBar r4 = r0.mActionBar
                if (r4 == 0) goto L_0x001f
                boolean r3 = r4.onKeyShortcut(r3, r6)
                if (r3 == 0) goto L_0x001f
            L_0x001d:
                r6 = 1
                goto L_0x004d
            L_0x001f:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r3 = r0.mPreparedPanel
                if (r3 == 0) goto L_0x0034
                int r4 = r6.getKeyCode()
                boolean r3 = r0.performPanelShortcut(r3, r4, r6, r2)
                if (r3 == 0) goto L_0x0034
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r6 = r0.mPreparedPanel
                if (r6 == 0) goto L_0x001d
                r6.isHandled = r2
                goto L_0x001d
            L_0x0034:
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r3 = r0.mPreparedPanel
                if (r3 != 0) goto L_0x004c
                androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r3 = r0.getPanelState(r1)
                r0.preparePanel(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.performPanelShortcut(r3, r4, r6, r2)
                r3.isPrepared = r1
                if (r6 == 0) goto L_0x004c
                goto L_0x001d
            L_0x004c:
                r6 = 0
            L_0x004d:
                if (r6 == 0) goto L_0x0050
            L_0x004f:
                r1 = 1
            L_0x0050:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return this.mWrapped.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            this.mWrapped.onMenuOpened(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl != null) {
                if (i == 108) {
                    appCompatDelegateImpl.initWindowDecorActionBar();
                    ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                    if (actionBar != null) {
                        actionBar.dispatchMenuVisibilityChanged(true);
                    }
                }
                return true;
            }
            throw null;
        }

        public void onPanelClosed(int i, Menu menu) {
            this.mWrapped.onPanelClosed(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl == null) {
                throw null;
            } else if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                }
            } else if (i == 0) {
                PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(i);
                if (panelState.isOpen) {
                    appCompatDelegateImpl.closePanel(panelState, false);
                }
            }
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            boolean onPreparePanel = this.mWrapped.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                this.mWrapped.onProvideKeyboardShortcuts(list, menuBuilder, i);
            } else {
                this.mWrapped.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            if (VERSION.SDK_INT >= 23) {
                return null;
            }
            if (AppCompatDelegateImpl.this.mHandleNativeActionModes) {
                return startAsSupportActionMode(callback);
            }
            return this.mWrapped.onWindowStartingActionMode(callback);
        }

        public final android.view.ActionMode startAsSupportActionMode(android.view.ActionMode.Callback callback) {
            CallbackWrapper callbackWrapper = new CallbackWrapper(AppCompatDelegateImpl.this.mContext, callback);
            ActionMode startSupportActionMode = AppCompatDelegateImpl.this.startSupportActionMode(callbackWrapper);
            if (startSupportActionMode != null) {
                return callbackWrapper.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
            if (!AppCompatDelegateImpl.this.mHandleNativeActionModes || i != 0) {
                return this.mWrapped.onWindowStartingActionMode(callback, i);
            }
            return startAsSupportActionMode(callback);
        }
    }

    public class AutoBatteryNightModeManager extends AutoNightModeManager {
        public final PowerManager mPowerManager;

        public AutoBatteryNightModeManager(Context context) {
            super();
            this.mPowerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int getApplyableNightMode() {
            return this.mPowerManager.isPowerSaveMode() ? 2 : 1;
        }

        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    public abstract class AutoNightModeManager {
        public BroadcastReceiver mReceiver;

        public AutoNightModeManager() {
        }

        public void cleanup() {
            BroadcastReceiver broadcastReceiver = this.mReceiver;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.mContext.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.mReceiver = null;
            }
        }

        public abstract IntentFilter createIntentFilterForBroadcastReceiver();

        public abstract int getApplyableNightMode();

        public abstract void onChange();

        public void setup() {
            cleanup();
            IntentFilter createIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
            if (createIntentFilterForBroadcastReceiver != null && createIntentFilterForBroadcastReceiver.countActions() != 0) {
                if (this.mReceiver == null) {
                    this.mReceiver = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            AutoNightModeManager.this.onChange();
                        }
                    };
                }
                AppCompatDelegateImpl.this.mContext.registerReceiver(this.mReceiver, createIntentFilterForBroadcastReceiver);
            }
        }
    }

    public class AutoTimeNightModeManager extends AutoNightModeManager {
        public final TwilightManager mTwilightManager;

        public AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.mTwilightManager = twilightManager;
        }

        public IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getApplyableNightMode() {
            /*
                r22 = this;
                r0 = r22
                androidx.appcompat.app.TwilightManager r1 = r0.mTwilightManager
                androidx.appcompat.app.TwilightManager$TwilightState r2 = r1.mTwilightState
                long r3 = r2.nextUpdate
                long r5 = java.lang.System.currentTimeMillis()
                r7 = 0
                r8 = 1
                int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r9 <= 0) goto L_0x0014
                r3 = 1
                goto L_0x0015
            L_0x0014:
                r3 = 0
            L_0x0015:
                if (r3 == 0) goto L_0x001b
                boolean r1 = r2.isNight
                goto L_0x00fa
            L_0x001b:
                android.content.Context r3 = r1.mContext
                java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
                int r3 = a.a.a.a.d.b.checkSelfPermission(r3, r4)
                r4 = 0
                if (r3 != 0) goto L_0x0037
                java.lang.String r3 = "network"
                android.location.LocationManager r5 = r1.mLocationManager     // Catch:{ Exception -> 0x0037 }
                boolean r5 = r5.isProviderEnabled(r3)     // Catch:{ Exception -> 0x0037 }
                if (r5 == 0) goto L_0x0037
                android.location.LocationManager r5 = r1.mLocationManager     // Catch:{ Exception -> 0x0037 }
                android.location.Location r3 = r5.getLastKnownLocation(r3)     // Catch:{ Exception -> 0x0037 }
                goto L_0x0038
            L_0x0037:
                r3 = r4
            L_0x0038:
                android.content.Context r5 = r1.mContext
                java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
                int r5 = a.a.a.a.d.b.checkSelfPermission(r5, r6)
                if (r5 != 0) goto L_0x0054
                java.lang.String r5 = "gps"
                android.location.LocationManager r6 = r1.mLocationManager     // Catch:{ Exception -> 0x0053 }
                boolean r6 = r6.isProviderEnabled(r5)     // Catch:{ Exception -> 0x0053 }
                if (r6 == 0) goto L_0x0054
                android.location.LocationManager r6 = r1.mLocationManager     // Catch:{ Exception -> 0x0053 }
                android.location.Location r4 = r6.getLastKnownLocation(r5)     // Catch:{ Exception -> 0x0053 }
                goto L_0x0054
            L_0x0053:
            L_0x0054:
                if (r4 == 0) goto L_0x0065
                if (r3 == 0) goto L_0x0065
                long r5 = r4.getTime()
                long r9 = r3.getTime()
                int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r11 <= 0) goto L_0x0068
                goto L_0x0067
            L_0x0065:
                if (r4 == 0) goto L_0x0068
            L_0x0067:
                r3 = r4
            L_0x0068:
                if (r3 == 0) goto L_0x00e7
                androidx.appcompat.app.TwilightManager$TwilightState r1 = r1.mTwilightState
                long r4 = java.lang.System.currentTimeMillis()
                androidx.appcompat.app.TwilightCalculator r6 = androidx.appcompat.app.TwilightCalculator.sInstance
                if (r6 != 0) goto L_0x007b
                androidx.appcompat.app.TwilightCalculator r6 = new androidx.appcompat.app.TwilightCalculator
                r6.<init>()
                androidx.appcompat.app.TwilightCalculator.sInstance = r6
            L_0x007b:
                androidx.appcompat.app.TwilightCalculator r6 = androidx.appcompat.app.TwilightCalculator.sInstance
                r16 = 86400000(0x5265c00, double:4.2687272E-316)
                long r10 = r4 - r16
                double r12 = r3.getLatitude()
                double r14 = r3.getLongitude()
                r9 = r6
                r9.calculateTwilight(r10, r12, r14)
                double r12 = r3.getLatitude()
                double r14 = r3.getLongitude()
                r10 = r4
                r9.calculateTwilight(r10, r12, r14)
                int r9 = r6.state
                if (r9 != r8) goto L_0x009f
                r7 = 1
            L_0x009f:
                long r14 = r6.sunrise
                long r12 = r6.sunset
                long r10 = r4 + r16
                double r16 = r3.getLatitude()
                double r18 = r3.getLongitude()
                r9 = r6
                r20 = r12
                r12 = r16
                r16 = r14
                r14 = r18
                r9.calculateTwilight(r10, r12, r14)
                long r9 = r6.sunrise
                r11 = 0
                r13 = -1
                int r3 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
                if (r3 == 0) goto L_0x00dc
                int r3 = (r20 > r13 ? 1 : (r20 == r13 ? 0 : -1))
                if (r3 != 0) goto L_0x00c8
                goto L_0x00dc
            L_0x00c8:
                int r3 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
                if (r3 <= 0) goto L_0x00ce
                long r9 = r9 + r11
                goto L_0x00d7
            L_0x00ce:
                int r3 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
                if (r3 <= 0) goto L_0x00d5
                long r9 = r20 + r11
                goto L_0x00d7
            L_0x00d5:
                long r9 = r16 + r11
            L_0x00d7:
                r3 = 60000(0xea60, double:2.9644E-319)
                long r9 = r9 + r3
                goto L_0x00e0
            L_0x00dc:
                r9 = 43200000(0x2932e00, double:2.1343636E-316)
                long r9 = r9 + r4
            L_0x00e0:
                r1.isNight = r7
                r1.nextUpdate = r9
                boolean r1 = r2.isNight
                goto L_0x00fa
            L_0x00e7:
                java.util.Calendar r1 = java.util.Calendar.getInstance()
                r2 = 11
                int r1 = r1.get(r2)
                r2 = 6
                if (r1 < r2) goto L_0x00f8
                r2 = 22
                if (r1 < r2) goto L_0x00f9
            L_0x00f8:
                r7 = 1
            L_0x00f9:
                r1 = r7
            L_0x00fa:
                if (r1 == 0) goto L_0x00fd
                r8 = 2
            L_0x00fd:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.AutoTimeNightModeManager.getApplyableNightMode():int");
        }

        public void onChange() {
            AppCompatDelegateImpl.this.applyDayNight();
        }
    }

    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(Context context) {
            super(context, null);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public static final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ViewGroup decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public Context listPresenterContext;
        public MenuBuilder menu;
        public boolean qwertyMode;
        public boolean refreshDecorView = false;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;

        public PanelFeatureState(int i) {
            this.featureId = i;
        }

        public void setMenu(MenuBuilder menuBuilder) {
            MenuBuilder menuBuilder2 = this.menu;
            if (menuBuilder != menuBuilder2) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menuBuilder;
                if (menuBuilder != null) {
                    ListMenuPresenter listMenuPresenter2 = this.listMenuPresenter;
                    if (listMenuPresenter2 != null) {
                        menuBuilder.addMenuPresenter(listMenuPresenter2, menuBuilder.mContext);
                    }
                }
            }
        }
    }

    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z2) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState findMenuPanel = appCompatDelegateImpl.findMenuPanel(menuBuilder);
            if (findMenuPanel == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImpl.this.callOnPanelClosed(findMenuPanel.featureId, findMenuPanel, rootMenu);
                AppCompatDelegateImpl.this.closePanel(findMenuPanel, true);
                return;
            }
            AppCompatDelegateImpl.this.closePanel(findMenuPanel, z);
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == menuBuilder.getRootMenu()) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (appCompatDelegateImpl.mHasActionBar) {
                    Window.Callback windowCallback = appCompatDelegateImpl.getWindowCallback();
                    if (windowCallback != null && !AppCompatDelegateImpl.this.mIsDestroyed) {
                        windowCallback.onMenuOpened(108, menuBuilder);
                    }
                }
            }
            return true;
        }
    }

    static {
        if (IS_PRE_LOLLIPOP && !sInstalledExceptionHandler) {
            final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                public void uncaughtException(Thread thread, Throwable th) {
                    boolean z = false;
                    if (th instanceof NotFoundException) {
                        String message = th.getMessage();
                        if (message != null && (message.contains("drawable") || message.contains("Drawable"))) {
                            z = true;
                        }
                    }
                    if (z) {
                        NotFoundException notFoundException = new NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (this.mLocalNightMode == -100 && (obj instanceof Dialog)) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof AppCompatActivity)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            appCompatActivity = null;
            if (appCompatActivity != null) {
                this.mLocalNightMode = ((AppCompatDelegateImpl) appCompatActivity.getDelegate()).mLocalNightMode;
            }
        }
        if (this.mLocalNightMode == -100) {
            Integer num = (Integer) sLocalNightModes.getOrDefault(this.mHost.getClass().getName(), null);
            if (num != null) {
                this.mLocalNightMode = num.intValue();
                sLocalNightModes.remove(this.mHost.getClass().getName());
            }
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        ensureSubDecor();
        ((ViewGroup) this.mSubDecor.findViewById(16908290)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    public boolean applyDayNight() {
        return applyDayNight(true);
    }

    public final void attachToWindow(Window window) {
        if (this.mWindow == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.mAppCompatWindowCallback = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.mWrapped.recycle();
                this.mWindow = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null && panelFeatureState != null) {
            menu = panelFeatureState.menu;
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mIsDestroyed) {
            this.mAppCompatWindowCallback.mWrapped.onPanelClosed(i, menu);
        }
    }

    public void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            this.mDecorContentParent.dismissPopups();
            Window.Callback windowCallback = getWindowCallback();
            if (windowCallback != null && !this.mIsDestroyed) {
                windowCallback.onPanelClosed(108, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    public void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.featureId == 0) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null && decorContentParent.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen) {
            ViewGroup viewGroup = panelFeatureState.decorView;
            if (viewGroup != null) {
                windowManager.removeView(viewGroup);
                if (z) {
                    callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
                }
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
    }

    public final Configuration createOverrideConfigurationForDayNight(Context context, int i, Configuration configuration) {
        int i2 = i != 1 ? i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & -49);
        return configuration2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0111, code lost:
        if (r7 == false) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mHost
            boolean r1 = r0 instanceof androidx.core.view.KeyEventDispatcher.Component
            r2 = 1
            if (r1 != 0) goto L_0x000b
            boolean r0 = r0 instanceof androidx.appcompat.app.AppCompatDialog
            if (r0 == 0) goto L_0x001a
        L_0x000b:
            android.view.Window r0 = r6.mWindow
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x001a
            boolean r0 = androidx.core.view.ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(r0, r7)
            if (r0 == 0) goto L_0x001a
            return r2
        L_0x001a:
            int r0 = r7.getKeyCode()
            r1 = 82
            if (r0 != r1) goto L_0x002d
            androidx.appcompat.app.AppCompatDelegateImpl$AppCompatWindowCallback r0 = r6.mAppCompatWindowCallback
            android.view.Window$Callback r0 = r0.mWrapped
            boolean r0 = r0.dispatchKeyEvent(r7)
            if (r0 == 0) goto L_0x002d
            return r2
        L_0x002d:
            int r0 = r7.getKeyCode()
            int r3 = r7.getAction()
            r4 = 0
            if (r3 != 0) goto L_0x003a
            r3 = 1
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            r5 = 4
            if (r3 == 0) goto L_0x0065
            if (r0 == r5) goto L_0x0056
            if (r0 == r1) goto L_0x0043
            goto L_0x0062
        L_0x0043:
            int r0 = r7.getRepeatCount()
            if (r0 != 0) goto L_0x0113
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.getPanelState(r4)
            boolean r1 = r0.isOpen
            if (r1 != 0) goto L_0x0113
            r6.preparePanel(r0, r7)
            goto L_0x0113
        L_0x0056:
            int r7 = r7.getFlags()
            r7 = r7 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            r6.mLongPressBackDown = r2
        L_0x0062:
            r2 = 0
            goto L_0x0113
        L_0x0065:
            if (r0 == r5) goto L_0x00e7
            if (r0 == r1) goto L_0x006a
            goto L_0x0062
        L_0x006a:
            androidx.appcompat.view.ActionMode r0 = r6.mActionMode
            if (r0 == 0) goto L_0x0070
            goto L_0x0113
        L_0x0070:
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.getPanelState(r4)
            androidx.appcompat.widget.DecorContentParent r1 = r6.mDecorContentParent
            if (r1 == 0) goto L_0x00aa
            boolean r1 = r1.canShowOverflowMenu()
            if (r1 == 0) goto L_0x00aa
            android.content.Context r1 = r6.mContext
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r1)
            boolean r1 = r1.hasPermanentMenuKey()
            if (r1 != 0) goto L_0x00aa
            androidx.appcompat.widget.DecorContentParent r1 = r6.mDecorContentParent
            boolean r1 = r1.isOverflowMenuShowing()
            if (r1 != 0) goto L_0x00a3
            boolean r1 = r6.mIsDestroyed
            if (r1 != 0) goto L_0x00ca
            boolean r7 = r6.preparePanel(r0, r7)
            if (r7 == 0) goto L_0x00ca
            androidx.appcompat.widget.DecorContentParent r7 = r6.mDecorContentParent
            boolean r7 = r7.showOverflowMenu()
            goto L_0x00d1
        L_0x00a3:
            androidx.appcompat.widget.DecorContentParent r7 = r6.mDecorContentParent
            boolean r7 = r7.hideOverflowMenu()
            goto L_0x00d1
        L_0x00aa:
            boolean r1 = r0.isOpen
            if (r1 != 0) goto L_0x00cc
            boolean r1 = r0.isHandled
            if (r1 == 0) goto L_0x00b3
            goto L_0x00cc
        L_0x00b3:
            boolean r1 = r0.isPrepared
            if (r1 == 0) goto L_0x00ca
            boolean r1 = r0.refreshMenuContent
            if (r1 == 0) goto L_0x00c2
            r0.isPrepared = r4
            boolean r1 = r6.preparePanel(r0, r7)
            goto L_0x00c3
        L_0x00c2:
            r1 = 1
        L_0x00c3:
            if (r1 == 0) goto L_0x00ca
            r6.openPanel(r0, r7)
            r7 = 1
            goto L_0x00d1
        L_0x00ca:
            r7 = 0
            goto L_0x00d1
        L_0x00cc:
            boolean r7 = r0.isOpen
            r6.closePanel(r0, r2)
        L_0x00d1:
            if (r7 == 0) goto L_0x0113
            android.content.Context r7 = r6.mContext
            android.content.Context r7 = r7.getApplicationContext()
            java.lang.String r0 = "audio"
            java.lang.Object r7 = r7.getSystemService(r0)
            android.media.AudioManager r7 = (android.media.AudioManager) r7
            if (r7 == 0) goto L_0x0113
            r7.playSoundEffect(r4)
            goto L_0x0113
        L_0x00e7:
            boolean r7 = r6.mLongPressBackDown
            r6.mLongPressBackDown = r4
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r0 = r6.getPanelState(r4)
            boolean r1 = r0.isOpen
            if (r1 == 0) goto L_0x00f9
            if (r7 != 0) goto L_0x0113
            r6.closePanel(r0, r2)
            goto L_0x0113
        L_0x00f9:
            androidx.appcompat.view.ActionMode r7 = r6.mActionMode
            if (r7 == 0) goto L_0x0101
            r7.finish()
            goto L_0x010e
        L_0x0101:
            r6.initWindowDecorActionBar()
            androidx.appcompat.app.ActionBar r7 = r6.mActionBar
            if (r7 == 0) goto L_0x0110
            boolean r7 = r7.collapseActionView()
            if (r7 == 0) goto L_0x0110
        L_0x010e:
            r7 = 1
            goto L_0x0111
        L_0x0110:
            r7 = 0
        L_0x0111:
            if (r7 == 0) goto L_0x0062
        L_0x0113:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.mSubDecorInstalled) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBar, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.mIsFloating = obtainStyledAttributes.getBoolean(R$styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                ensureWindow();
                this.mWindow.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                if (this.mWindowNoTitle) {
                    viewGroup = this.mOverlayActionMode ? (ViewGroup) from.inflate(R$layout.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(R$layout.abc_screen_simple, null);
                } else if (this.mIsFloating) {
                    viewGroup = (ViewGroup) from.inflate(R$layout.abc_dialog_title_material, null);
                    this.mOverlayActionBar = false;
                    this.mHasActionBar = false;
                } else if (this.mHasActionBar) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new ContextThemeWrapper(this.mContext, typedValue.resourceId);
                    } else {
                        context = this.mContext;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.abc_screen_toolbar, null);
                    DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(R$id.decor_content_parent);
                    this.mDecorContentParent = decorContentParent;
                    decorContentParent.setWindowCallback(getWindowCallback());
                    if (this.mOverlayActionBar) {
                        this.mDecorContentParent.initFeature(109);
                    }
                    if (this.mFeatureProgress) {
                        this.mDecorContentParent.initFeature(2);
                    }
                    if (this.mFeatureIndeterminateProgress) {
                        this.mDecorContentParent.initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
                            int updateStatusGuard = AppCompatDelegateImpl.this.updateStatusGuard(windowInsetsCompat, null);
                            if (systemWindowInsetTop != updateStatusGuard) {
                                windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), updateStatusGuard, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                            }
                            return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                        }
                    });
                    if (this.mDecorContentParent == null) {
                        this.mTitleView = (TextView) viewGroup.findViewById(R$id.title);
                    }
                    ViewUtils.makeOptionalFitsSystemWindows(viewGroup);
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R$id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.mWindow.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new OnAttachListener() {
                    });
                    this.mSubDecor = viewGroup;
                    Object obj = this.mHost;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.mTitle;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.mDecorContentParent;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            ActionBar actionBar = this.mActionBar;
                            if (actionBar != null) {
                                actionBar.setWindowTitle(charSequence);
                            } else {
                                TextView textView = this.mTitleView;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(16908290);
                    View decorView = this.mWindow.getDecorView();
                    contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(R$styleable.AppCompatTheme);
                    obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMajor)) {
                        obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedWidthMinor)) {
                        obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMajor)) {
                        obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(R$styleable.AppCompatTheme_windowFixedHeightMinor)) {
                        obtainStyledAttributes2.getValue(R$styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.mSubDecorInstalled = true;
                    PanelFeatureState panelState = getPanelState(0);
                    if (!this.mIsDestroyed && panelState.menu == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("AppCompat does not support the current theme features: { windowActionBar: ");
                outline73.append(this.mHasActionBar);
                outline73.append(", windowActionBarOverlay: ");
                outline73.append(this.mOverlayActionBar);
                outline73.append(", android:windowIsFloating: ");
                outline73.append(this.mIsFloating);
                outline73.append(", windowActionModeOverlay: ");
                outline73.append(this.mOverlayActionMode);
                outline73.append(", windowNoTitle: ");
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline66(outline73, this.mWindowNoTitle, " }"));
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public final AutoNightModeManager getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            if (TwilightManager.sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                TwilightManager.sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(TwilightManager.sInstance);
        }
        return this.mAutoTimeNightModeManager;
    }

    public PanelFeatureState getPanelState(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i);
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public final void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity) this.mHost, this.mOverlayActionBar);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) this.mHost);
            }
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    public void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            boolean z = from.getFactory2() instanceof AppCompatDelegateImpl;
        }
    }

    public void invalidateOptionsMenu() {
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar == null || !actionBar.invalidateOptionsMenu()) {
            invalidatePanelMenu(0);
        }
    }

    public final void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (!this.mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    public int mapNightMode(Context context, int i) {
        if (i == -100) {
            return -1;
        }
        if (i != -1) {
            if (i != 0) {
                if (!(i == 1 || i == 2)) {
                    if (i == 3) {
                        if (this.mAutoBatteryNightModeManager == null) {
                            this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(context);
                        }
                        return this.mAutoBatteryNightModeManager.getApplyableNightMode();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else if (VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                return getAutoTimeNightModeManager(context).getApplyableNightMode();
            } else {
                return -1;
            }
        }
        return i;
    }

    public void onCreate(Bundle bundle) {
        this.mBaseContextAttached = true;
        applyDayNight(false);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = NavUtils.getParentActivityName((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference(this));
            }
        }
        this.mCreated = true;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Throwable, java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r7v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r7v6, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r8v7, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r7v7, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r7v8, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v10, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r7v9, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v11, types: [androidx.appcompat.widget.AppCompatTextView, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v12, types: [androidx.appcompat.widget.AppCompatImageView, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v13, types: [android.view.View, androidx.appcompat.widget.AppCompatButton] */
    /* JADX WARNING: type inference failed for: r3v14, types: [androidx.appcompat.widget.AppCompatEditText, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v15, types: [androidx.appcompat.widget.AppCompatSpinner, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v16, types: [androidx.appcompat.widget.AppCompatImageButton, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v17, types: [android.view.View, androidx.appcompat.widget.AppCompatCheckBox] */
    /* JADX WARNING: type inference failed for: r3v18, types: [androidx.appcompat.widget.AppCompatRadioButton, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v19, types: [android.view.View, androidx.appcompat.widget.AppCompatCheckedTextView] */
    /* JADX WARNING: type inference failed for: r3v20, types: [androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v21, types: [androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v22, types: [android.view.View, androidx.appcompat.widget.AppCompatRatingBar] */
    /* JADX WARNING: type inference failed for: r3v23, types: [androidx.appcompat.widget.AppCompatSeekBar, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v24, types: [androidx.appcompat.widget.AppCompatToggleButton, android.view.View] */
    /* JADX WARNING: type inference failed for: r3v25, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r3v69 */
    /* JADX WARNING: type inference failed for: r3v70 */
    /* JADX WARNING: type inference failed for: r3v71 */
    /* JADX WARNING: type inference failed for: r3v72 */
    /* JADX WARNING: type inference failed for: r3v73 */
    /* JADX WARNING: type inference failed for: r3v74 */
    /* JADX WARNING: type inference failed for: r3v75 */
    /* JADX WARNING: type inference failed for: r3v76 */
    /* JADX WARNING: type inference failed for: r3v77 */
    /* JADX WARNING: type inference failed for: r3v78 */
    /* JADX WARNING: type inference failed for: r3v79 */
    /* JADX WARNING: type inference failed for: r3v80 */
    /* JADX WARNING: type inference failed for: r3v81 */
    /* JADX WARNING: type inference failed for: r3v82 */
    /* JADX WARNING: type inference failed for: r3v83 */
    /* JADX WARNING: type inference failed for: r3v84 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0, types: [java.lang.Throwable, java.lang.String]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [java.lang.Throwable, ?[OBJECT, ARRAY], java.lang.String]
      mth insns count: 187
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARNING: Unknown variable types count: 21 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r7, java.lang.String r8, android.content.Context r9, android.util.AttributeSet r10) {
        /*
            r6 = this;
            androidx.appcompat.app.AppCompatViewInflater r7 = r6.mAppCompatViewInflater
            r0 = 0
            if (r7 != 0) goto L_0x0039
            android.content.Context r7 = r6.mContext
            int[] r1 = androidx.appcompat.R$styleable.AppCompatTheme
            android.content.res.TypedArray r7 = r7.obtainStyledAttributes(r1)
            int r1 = androidx.appcompat.R$styleable.AppCompatTheme_viewInflaterClass
            java.lang.String r7 = r7.getString(r1)
            if (r7 != 0) goto L_0x001d
            androidx.appcompat.app.AppCompatViewInflater r7 = new androidx.appcompat.app.AppCompatViewInflater
            r7.<init>()
            r6.mAppCompatViewInflater = r7
            goto L_0x0039
        L_0x001d:
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0032 }
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ all -> 0x0032 }
            java.lang.reflect.Constructor r7 = r7.getDeclaredConstructor(r1)     // Catch:{ all -> 0x0032 }
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ all -> 0x0032 }
            java.lang.Object r7 = r7.newInstance(r1)     // Catch:{ all -> 0x0032 }
            androidx.appcompat.app.AppCompatViewInflater r7 = (androidx.appcompat.app.AppCompatViewInflater) r7     // Catch:{ all -> 0x0032 }
            r6.mAppCompatViewInflater = r7     // Catch:{ all -> 0x0032 }
            goto L_0x0039
        L_0x0032:
            androidx.appcompat.app.AppCompatViewInflater r7 = new androidx.appcompat.app.AppCompatViewInflater
            r7.<init>()
            r6.mAppCompatViewInflater = r7
        L_0x0039:
            androidx.appcompat.app.AppCompatViewInflater r7 = r6.mAppCompatViewInflater
            androidx.appcompat.widget.VectorEnabledTintResources.shouldBeUsed()
            r1 = 0
            if (r7 == 0) goto L_0x0210
            int[] r2 = androidx.appcompat.R$styleable.View
            android.content.res.TypedArray r2 = r9.obtainStyledAttributes(r10, r2, r0, r0)
            int r3 = androidx.appcompat.R$styleable.View_theme
            int r3 = r2.getResourceId(r3, r0)
            r2.recycle()
            if (r3 == 0) goto L_0x0063
            boolean r2 = r9 instanceof androidx.appcompat.view.ContextThemeWrapper
            if (r2 == 0) goto L_0x005d
            r2 = r9
            androidx.appcompat.view.ContextThemeWrapper r2 = (androidx.appcompat.view.ContextThemeWrapper) r2
            int r2 = r2.mThemeResource
            if (r2 == r3) goto L_0x0063
        L_0x005d:
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>(r9, r3)
            goto L_0x0064
        L_0x0063:
            r2 = r9
        L_0x0064:
            int r3 = r8.hashCode()
            r4 = -1
            r5 = 1
            switch(r3) {
                case -1946472170: goto L_0x00fa;
                case -1455429095: goto L_0x00ef;
                case -1346021293: goto L_0x00e4;
                case -938935918: goto L_0x00da;
                case -937446323: goto L_0x00d0;
                case -658531749: goto L_0x00c5;
                case -339785223: goto L_0x00bb;
                case 776382189: goto L_0x00b1;
                case 799298502: goto L_0x00a6;
                case 1125864064: goto L_0x009c;
                case 1413872058: goto L_0x0090;
                case 1601505219: goto L_0x0085;
                case 1666676343: goto L_0x007a;
                case 2001146706: goto L_0x006f;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x0105
        L_0x006f:
            java.lang.String r3 = "Button"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 2
            goto L_0x0106
        L_0x007a:
            java.lang.String r3 = "EditText"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 3
            goto L_0x0106
        L_0x0085:
            java.lang.String r3 = "CheckBox"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 6
            goto L_0x0106
        L_0x0090:
            java.lang.String r3 = "AutoCompleteTextView"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 9
            goto L_0x0106
        L_0x009c:
            java.lang.String r3 = "ImageView"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 1
            goto L_0x0106
        L_0x00a6:
            java.lang.String r3 = "ToggleButton"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 13
            goto L_0x0106
        L_0x00b1:
            java.lang.String r3 = "RadioButton"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 7
            goto L_0x0106
        L_0x00bb:
            java.lang.String r3 = "Spinner"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 4
            goto L_0x0106
        L_0x00c5:
            java.lang.String r3 = "SeekBar"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 12
            goto L_0x0106
        L_0x00d0:
            java.lang.String r3 = "ImageButton"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 5
            goto L_0x0106
        L_0x00da:
            java.lang.String r3 = "TextView"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 0
            goto L_0x0106
        L_0x00e4:
            java.lang.String r3 = "MultiAutoCompleteTextView"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 10
            goto L_0x0106
        L_0x00ef:
            java.lang.String r3 = "CheckedTextView"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 8
            goto L_0x0106
        L_0x00fa:
            java.lang.String r3 = "RatingBar"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0105
            r3 = 11
            goto L_0x0106
        L_0x0105:
            r3 = -1
        L_0x0106:
            switch(r3) {
                case 0: goto L_0x0181;
                case 1: goto L_0x0178;
                case 2: goto L_0x0170;
                case 3: goto L_0x0167;
                case 4: goto L_0x015e;
                case 5: goto L_0x0155;
                case 6: goto L_0x014d;
                case 7: goto L_0x0145;
                case 8: goto L_0x013c;
                case 9: goto L_0x0134;
                case 10: goto L_0x012b;
                case 11: goto L_0x0122;
                case 12: goto L_0x0119;
                case 13: goto L_0x010f;
                default: goto L_0x0109;
            }
        L_0x0109:
            android.view.View r3 = r7.createView()
            goto L_0x0188
        L_0x010f:
            androidx.appcompat.widget.AppCompatToggleButton r3 = new androidx.appcompat.widget.AppCompatToggleButton
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0119:
            androidx.appcompat.widget.AppCompatSeekBar r3 = new androidx.appcompat.widget.AppCompatSeekBar
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0122:
            androidx.appcompat.widget.AppCompatRatingBar r3 = new androidx.appcompat.widget.AppCompatRatingBar
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x012b:
            androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView r3 = new androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0134:
            androidx.appcompat.widget.AppCompatAutoCompleteTextView r3 = r7.createAutoCompleteTextView(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x013c:
            androidx.appcompat.widget.AppCompatCheckedTextView r3 = new androidx.appcompat.widget.AppCompatCheckedTextView
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0145:
            androidx.appcompat.widget.AppCompatRadioButton r3 = r7.createRadioButton(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x014d:
            androidx.appcompat.widget.AppCompatCheckBox r3 = r7.createCheckBox(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0155:
            androidx.appcompat.widget.AppCompatImageButton r3 = new androidx.appcompat.widget.AppCompatImageButton
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x015e:
            androidx.appcompat.widget.AppCompatSpinner r3 = new androidx.appcompat.widget.AppCompatSpinner
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0167:
            androidx.appcompat.widget.AppCompatEditText r3 = new androidx.appcompat.widget.AppCompatEditText
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0170:
            androidx.appcompat.widget.AppCompatButton r3 = r7.createButton(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0178:
            androidx.appcompat.widget.AppCompatImageView r3 = new androidx.appcompat.widget.AppCompatImageView
            r3.<init>(r2, r10)
            r7.verifyNotNull(r3, r8)
            goto L_0x0188
        L_0x0181:
            androidx.appcompat.widget.AppCompatTextView r3 = r7.createTextView(r2, r10)
            r7.verifyNotNull(r3, r8)
        L_0x0188:
            if (r3 != 0) goto L_0x01e6
            if (r9 == r2) goto L_0x01e6
            java.lang.String r9 = "view"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x019a
            java.lang.String r8 = "class"
            java.lang.String r8 = r10.getAttributeValue(r1, r8)
        L_0x019a:
            java.lang.Object[] r9 = r7.mConstructorArgs     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            r9[r0] = r2     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            java.lang.Object[] r9 = r7.mConstructorArgs     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            r9[r5] = r10     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            r9 = 46
            int r9 = r8.indexOf(r9)     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            if (r4 != r9) goto L_0x01cb
            r9 = 0
        L_0x01ab:
            java.lang.String[] r3 = androidx.appcompat.app.AppCompatViewInflater.sClassPrefixList     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            int r3 = r3.length     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            if (r9 >= r3) goto L_0x01c4
            java.lang.String[] r3 = androidx.appcompat.app.AppCompatViewInflater.sClassPrefixList     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            r3 = r3[r9]     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            android.view.View r3 = r7.createViewByPrefix(r2, r8, r3)     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            if (r3 == 0) goto L_0x01c1
            java.lang.Object[] r7 = r7.mConstructorArgs
            r7[r0] = r1
            r7[r5] = r1
            goto L_0x01e6
        L_0x01c1:
            int r9 = r9 + 1
            goto L_0x01ab
        L_0x01c4:
            java.lang.Object[] r7 = r7.mConstructorArgs
            r7[r0] = r1
            r7[r5] = r1
            goto L_0x01e7
        L_0x01cb:
            android.view.View r8 = r7.createViewByPrefix(r2, r8, r1)     // Catch:{ Exception -> 0x01df, all -> 0x01d7 }
            java.lang.Object[] r7 = r7.mConstructorArgs
            r7[r0] = r1
            r7[r5] = r1
            r1 = r8
            goto L_0x01e7
        L_0x01d7:
            r8 = move-exception
            java.lang.Object[] r7 = r7.mConstructorArgs
            r7[r0] = r1
            r7[r5] = r1
            throw r8
        L_0x01df:
            java.lang.Object[] r7 = r7.mConstructorArgs
            r7[r0] = r1
            r7[r5] = r1
            goto L_0x01e7
        L_0x01e6:
            r1 = r3
        L_0x01e7:
            if (r1 == 0) goto L_0x020f
            android.content.Context r7 = r1.getContext()
            boolean r8 = r7 instanceof android.content.ContextWrapper
            if (r8 == 0) goto L_0x020f
            boolean r8 = androidx.core.view.ViewCompat.hasOnClickListeners(r1)
            if (r8 != 0) goto L_0x01f8
            goto L_0x020f
        L_0x01f8:
            int[] r8 = androidx.appcompat.app.AppCompatViewInflater.sOnClickAttrs
            android.content.res.TypedArray r7 = r7.obtainStyledAttributes(r10, r8)
            java.lang.String r8 = r7.getString(r0)
            if (r8 == 0) goto L_0x020c
            androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener r9 = new androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener
            r9.<init>(r1, r8)
            r1.setOnClickListener(r9)
        L_0x020c:
            r7.recycle()
        L_0x020f:
            return r1
        L_0x0210:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mHost
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = androidx.appcompat.app.AppCompatDelegate.sActivityDelegatesLock
            monitor-enter(r0)
            androidx.appcompat.app.AppCompatDelegate.removeDelegateFromActives(r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            goto L_0x0011
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        L_0x0011:
            boolean r0 = r3.mInvalidatePanelMenuPosted
            if (r0 == 0) goto L_0x0020
            android.view.Window r0 = r3.mWindow
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.mInvalidatePanelMenuRunnable
            r0.removeCallbacks(r1)
        L_0x0020:
            r0 = 0
            r3.mStarted = r0
            r0 = 1
            r3.mIsDestroyed = r0
            int r0 = r3.mLocalNightMode
            r1 = -100
            if (r0 == r1) goto L_0x0050
            java.lang.Object r0 = r3.mHost
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0050
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0050
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = sLocalNightModes
            java.lang.Object r1 = r3.mHost
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.mLocalNightMode
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x005f
        L_0x0050:
            androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> r0 = sLocalNightModes
            java.lang.Object r1 = r3.mHost
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x005f:
            androidx.appcompat.app.ActionBar r0 = r3.mActionBar
            if (r0 == 0) goto L_0x0066
            r0.onDestroy()
        L_0x0066:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r0 = r3.mAutoTimeNightModeManager
            if (r0 == 0) goto L_0x006d
            r0.cleanup()
        L_0x006d:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r0 = r3.mAutoBatteryNightModeManager
            if (r0 == 0) goto L_0x0074
            r0.cleanup()
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onDestroy():void");
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null && !this.mIsDestroyed) {
            PanelFeatureState findMenuPanel = findMenuPanel(menuBuilder.getRootMenu());
            if (findMenuPanel != null) {
                return windowCallback.onMenuItemSelected(findMenuPanel.featureId, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent == null || !decorContentParent.canShowOverflowMenu() || (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() && !this.mDecorContentParent.isOverflowMenuShowPending())) {
            PanelFeatureState panelState = getPanelState(0);
            panelState.refreshDecorView = true;
            closePanel(panelState, false);
            openPanel(panelState, null);
            return;
        }
        Window.Callback windowCallback = getWindowCallback();
        if (this.mDecorContentParent.isOverflowMenuShowing()) {
            this.mDecorContentParent.hideOverflowMenu();
            if (!this.mIsDestroyed) {
                windowCallback.onPanelClosed(108, getPanelState(0).menu);
            }
        } else if (windowCallback != null && !this.mIsDestroyed) {
            if (this.mInvalidatePanelMenuPosted && (1 & this.mInvalidatePanelMenuFeatures) != 0) {
                this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                this.mInvalidatePanelMenuRunnable.run();
            }
            PanelFeatureState panelState2 = getPanelState(0);
            MenuBuilder menuBuilder2 = panelState2.menu;
            if (menuBuilder2 != null && !panelState2.refreshMenuContent && windowCallback.onPreparePanel(0, panelState2.createdPanelView, menuBuilder2)) {
                windowCallback.onMenuOpened(108, panelState2.menu);
                this.mDecorContentParent.showOverflowMenu();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015c, code lost:
        if (r4 != null) goto L_0x015e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void openPanel(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r13, android.view.KeyEvent r14) {
        /*
            r12 = this;
            boolean r0 = r13.isOpen
            if (r0 != 0) goto L_0x01dd
            boolean r0 = r12.mIsDestroyed
            if (r0 == 0) goto L_0x000a
            goto L_0x01dd
        L_0x000a:
            int r0 = r13.featureId
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0027
            android.content.Context r0 = r12.mContext
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            r3 = 4
            if (r0 != r3) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            if (r0 == 0) goto L_0x0027
            return
        L_0x0027:
            android.view.Window$Callback r0 = r12.getWindowCallback()
            if (r0 == 0) goto L_0x003b
            int r3 = r13.featureId
            androidx.appcompat.view.menu.MenuBuilder r4 = r13.menu
            boolean r0 = r0.onMenuOpened(r3, r4)
            if (r0 != 0) goto L_0x003b
            r12.closePanel(r13, r1)
            return
        L_0x003b:
            android.content.Context r0 = r12.mContext
            java.lang.String r3 = "window"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            if (r0 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r14 = r12.preparePanel(r13, r14)
            if (r14 != 0) goto L_0x004f
            return
        L_0x004f:
            android.view.ViewGroup r14 = r13.decorView
            r3 = -2
            r4 = -1
            if (r14 == 0) goto L_0x006b
            boolean r14 = r13.refreshDecorView
            if (r14 == 0) goto L_0x005a
            goto L_0x006b
        L_0x005a:
            android.view.View r14 = r13.createdPanelView
            if (r14 == 0) goto L_0x01ba
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            if (r14 == 0) goto L_0x01ba
            int r14 = r14.width
            if (r14 != r4) goto L_0x01ba
            r5 = -1
            goto L_0x01bb
        L_0x006b:
            android.view.ViewGroup r14 = r13.decorView
            r4 = 0
            if (r14 != 0) goto L_0x00e8
            r12.initWindowDecorActionBar()
            androidx.appcompat.app.ActionBar r14 = r12.mActionBar
            if (r14 == 0) goto L_0x007c
            android.content.Context r14 = r14.getThemedContext()
            goto L_0x007d
        L_0x007c:
            r14 = r4
        L_0x007d:
            if (r14 != 0) goto L_0x0081
            android.content.Context r14 = r12.mContext
        L_0x0081:
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources r6 = r14.getResources()
            android.content.res.Resources$Theme r6 = r6.newTheme()
            android.content.res.Resources$Theme r7 = r14.getTheme()
            r6.setTo(r7)
            int r7 = androidx.appcompat.R$attr.actionBarPopupTheme
            r6.resolveAttribute(r7, r5, r1)
            int r7 = r5.resourceId
            if (r7 == 0) goto L_0x00a1
            r6.applyStyle(r7, r1)
        L_0x00a1:
            int r7 = androidx.appcompat.R$attr.panelMenuListTheme
            r6.resolveAttribute(r7, r5, r1)
            int r5 = r5.resourceId
            if (r5 == 0) goto L_0x00ae
            r6.applyStyle(r5, r1)
            goto L_0x00b3
        L_0x00ae:
            int r5 = androidx.appcompat.R$style.Theme_AppCompat_CompactMenu
            r6.applyStyle(r5, r1)
        L_0x00b3:
            androidx.appcompat.view.ContextThemeWrapper r5 = new androidx.appcompat.view.ContextThemeWrapper
            r5.<init>(r14, r2)
            android.content.res.Resources$Theme r14 = r5.getTheme()
            r14.setTo(r6)
            r13.listPresenterContext = r5
            int[] r14 = androidx.appcompat.R$styleable.AppCompatTheme
            android.content.res.TypedArray r14 = r5.obtainStyledAttributes(r14)
            int r5 = androidx.appcompat.R$styleable.AppCompatTheme_panelBackground
            int r5 = r14.getResourceId(r5, r2)
            r13.background = r5
            int r5 = androidx.appcompat.R$styleable.AppCompatTheme_android_windowAnimationStyle
            int r5 = r14.getResourceId(r5, r2)
            r13.windowAnimations = r5
            r14.recycle()
            androidx.appcompat.app.AppCompatDelegateImpl$ListMenuDecorView r14 = new androidx.appcompat.app.AppCompatDelegateImpl$ListMenuDecorView
            android.content.Context r5 = r13.listPresenterContext
            r14.<init>(r5)
            r13.decorView = r14
            r14 = 81
            r13.gravity = r14
            goto L_0x00f7
        L_0x00e8:
            boolean r5 = r13.refreshDecorView
            if (r5 == 0) goto L_0x00f7
            int r14 = r14.getChildCount()
            if (r14 <= 0) goto L_0x00f7
            android.view.ViewGroup r14 = r13.decorView
            r14.removeAllViews()
        L_0x00f7:
            android.view.View r14 = r13.createdPanelView
            if (r14 == 0) goto L_0x00fe
            r13.shownPanelView = r14
            goto L_0x015e
        L_0x00fe:
            androidx.appcompat.view.menu.MenuBuilder r14 = r13.menu
            if (r14 != 0) goto L_0x0103
            goto L_0x0160
        L_0x0103:
            androidx.appcompat.app.AppCompatDelegateImpl$PanelMenuPresenterCallback r14 = r12.mPanelMenuPresenterCallback
            if (r14 != 0) goto L_0x010e
            androidx.appcompat.app.AppCompatDelegateImpl$PanelMenuPresenterCallback r14 = new androidx.appcompat.app.AppCompatDelegateImpl$PanelMenuPresenterCallback
            r14.<init>()
            r12.mPanelMenuPresenterCallback = r14
        L_0x010e:
            androidx.appcompat.app.AppCompatDelegateImpl$PanelMenuPresenterCallback r14 = r12.mPanelMenuPresenterCallback
            androidx.appcompat.view.menu.MenuBuilder r5 = r13.menu
            if (r5 != 0) goto L_0x0115
            goto L_0x015a
        L_0x0115:
            androidx.appcompat.view.menu.ListMenuPresenter r4 = r13.listMenuPresenter
            if (r4 != 0) goto L_0x012d
            androidx.appcompat.view.menu.ListMenuPresenter r4 = new androidx.appcompat.view.menu.ListMenuPresenter
            android.content.Context r5 = r13.listPresenterContext
            int r6 = androidx.appcompat.R$layout.abc_list_menu_item_layout
            r4.<init>(r5, r6)
            r13.listMenuPresenter = r4
            r4.mCallback = r14
            androidx.appcompat.view.menu.MenuBuilder r14 = r13.menu
            android.content.Context r5 = r14.mContext
            r14.addMenuPresenter(r4, r5)
        L_0x012d:
            androidx.appcompat.view.menu.ListMenuPresenter r14 = r13.listMenuPresenter
            android.view.ViewGroup r4 = r13.decorView
            androidx.appcompat.view.menu.ExpandedMenuView r5 = r14.mMenuView
            if (r5 != 0) goto L_0x0158
            android.view.LayoutInflater r5 = r14.mInflater
            int r6 = androidx.appcompat.R$layout.abc_expanded_menu_layout
            android.view.View r4 = r5.inflate(r6, r4, r2)
            androidx.appcompat.view.menu.ExpandedMenuView r4 = (androidx.appcompat.view.menu.ExpandedMenuView) r4
            r14.mMenuView = r4
            androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter r4 = r14.mAdapter
            if (r4 != 0) goto L_0x014c
            androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter r4 = new androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter
            r4.<init>()
            r14.mAdapter = r4
        L_0x014c:
            androidx.appcompat.view.menu.ExpandedMenuView r4 = r14.mMenuView
            androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter r5 = r14.mAdapter
            r4.setAdapter(r5)
            androidx.appcompat.view.menu.ExpandedMenuView r4 = r14.mMenuView
            r4.setOnItemClickListener(r14)
        L_0x0158:
            androidx.appcompat.view.menu.ExpandedMenuView r4 = r14.mMenuView
        L_0x015a:
            r13.shownPanelView = r4
            if (r4 == 0) goto L_0x0160
        L_0x015e:
            r14 = 1
            goto L_0x0161
        L_0x0160:
            r14 = 0
        L_0x0161:
            if (r14 == 0) goto L_0x01db
            android.view.View r14 = r13.shownPanelView
            if (r14 != 0) goto L_0x0168
            goto L_0x017d
        L_0x0168:
            android.view.View r14 = r13.createdPanelView
            if (r14 == 0) goto L_0x016d
            goto L_0x017b
        L_0x016d:
            androidx.appcompat.view.menu.ListMenuPresenter r14 = r13.listMenuPresenter
            android.widget.ListAdapter r14 = r14.getAdapter()
            androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter r14 = (androidx.appcompat.view.menu.ListMenuPresenter.MenuAdapter) r14
            int r14 = r14.getCount()
            if (r14 <= 0) goto L_0x017d
        L_0x017b:
            r14 = 1
            goto L_0x017e
        L_0x017d:
            r14 = 0
        L_0x017e:
            if (r14 != 0) goto L_0x0181
            goto L_0x01db
        L_0x0181:
            android.view.View r14 = r13.shownPanelView
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            if (r14 != 0) goto L_0x018e
            android.view.ViewGroup$LayoutParams r14 = new android.view.ViewGroup$LayoutParams
            r14.<init>(r3, r3)
        L_0x018e:
            int r4 = r13.background
            android.view.ViewGroup r5 = r13.decorView
            r5.setBackgroundResource(r4)
            android.view.View r4 = r13.shownPanelView
            android.view.ViewParent r4 = r4.getParent()
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x01a6
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r5 = r13.shownPanelView
            r4.removeView(r5)
        L_0x01a6:
            android.view.ViewGroup r4 = r13.decorView
            android.view.View r5 = r13.shownPanelView
            r4.addView(r5, r14)
            android.view.View r14 = r13.shownPanelView
            boolean r14 = r14.hasFocus()
            if (r14 != 0) goto L_0x01ba
            android.view.View r14 = r13.shownPanelView
            r14.requestFocus()
        L_0x01ba:
            r5 = -2
        L_0x01bb:
            r13.isHandled = r2
            android.view.WindowManager$LayoutParams r14 = new android.view.WindowManager$LayoutParams
            r6 = -2
            r7 = 0
            r8 = 0
            r9 = 1002(0x3ea, float:1.404E-42)
            r10 = 8519680(0x820000, float:1.1938615E-38)
            r11 = -3
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            int r2 = r13.gravity
            r14.gravity = r2
            int r2 = r13.windowAnimations
            r14.windowAnimations = r2
            android.view.ViewGroup r2 = r13.decorView
            r0.addView(r2, r14)
            r13.isOpen = r1
            return
        L_0x01db:
            r13.refreshDecorView = r1
        L_0x01dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.openPanel(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if (panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) {
            MenuBuilder menuBuilder = panelFeatureState.menu;
            if (menuBuilder != null) {
                z = menuBuilder.performShortcut(i, keyEvent, i2);
            }
        }
        if (z && (i2 & 1) == 0 && this.mDecorContentParent == null) {
            closePanel(panelFeatureState, true);
        }
        return z;
    }

    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        Theme theme;
        if (this.mIsDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            closePanel(panelFeatureState2, false);
        }
        Window.Callback windowCallback = getWindowCallback();
        if (windowCallback != null) {
            panelFeatureState.createdPanelView = windowCallback.onCreatePanelView(panelFeatureState.featureId);
        }
        int i = panelFeatureState.featureId;
        boolean z = i == 0 || i == 108;
        if (z) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.setMenuPrepared();
            }
        }
        if (panelFeatureState.createdPanelView == null && (!z || !(this.mActionBar instanceof ToolbarActionBar))) {
            if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                if (panelFeatureState.menu == null) {
                    Context context = this.mContext;
                    int i2 = panelFeatureState.featureId;
                    if ((i2 == 0 || i2 == 108) && this.mDecorContentParent != null) {
                        TypedValue typedValue = new TypedValue();
                        Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R$attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(theme);
                            context = contextThemeWrapper;
                        }
                    }
                    MenuBuilder menuBuilder = new MenuBuilder(context);
                    menuBuilder.mCallback = this;
                    panelFeatureState.setMenu(menuBuilder);
                    if (panelFeatureState.menu == null) {
                        return false;
                    }
                }
                if (z && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback();
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!windowCallback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                    panelFeatureState.setMenu(null);
                    if (z) {
                        DecorContentParent decorContentParent2 = this.mDecorContentParent;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setMenu(null, this.mActionMenuPresenterCallback);
                        }
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.frozenActionViewState;
            if (bundle != null) {
                panelFeatureState.menu.restoreActionViewStates(bundle);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!windowCallback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (z) {
                    DecorContentParent decorContentParent3 = this.mDecorContentParent;
                    if (decorContentParent3 != null) {
                        decorContentParent3.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = z2;
            panelFeatureState.menu.setQwertyMode(z2);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    public boolean requestWindowFeature(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        } else if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        } else if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        } else if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        } else if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        } else if (i != 109) {
            return this.mWindow.requestFeature(i);
        } else {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionBar = true;
            return true;
        }
    }

    public void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final boolean shouldAnimateActionModeView() {
        if (this.mSubDecorInstalled) {
            ViewGroup viewGroup = this.mSubDecor;
            if (viewGroup != null && ViewCompat.isLaidOut(viewGroup)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.appcompat.view.ActionMode startSupportActionMode(androidx.appcompat.view.ActionMode.Callback r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x01a8
            androidx.appcompat.view.ActionMode r0 = r7.mActionMode
            if (r0 == 0) goto L_0x0009
            r0.finish()
        L_0x0009:
            androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
            r0.<init>(r8)
            r7.initWindowDecorActionBar()
            androidx.appcompat.app.ActionBar r8 = r7.mActionBar
            if (r8 == 0) goto L_0x0024
            androidx.appcompat.view.ActionMode r8 = r8.startActionMode(r0)
            r7.mActionMode = r8
            if (r8 == 0) goto L_0x0024
            androidx.appcompat.app.AppCompatCallback r1 = r7.mAppCompatCallback
            if (r1 == 0) goto L_0x0024
            r1.onSupportActionModeStarted(r8)
        L_0x0024:
            androidx.appcompat.view.ActionMode r8 = r7.mActionMode
            if (r8 != 0) goto L_0x01a5
            r7.endOnGoingFadeAnimation()
            androidx.appcompat.view.ActionMode r8 = r7.mActionMode
            if (r8 == 0) goto L_0x0032
            r8.finish()
        L_0x0032:
            androidx.appcompat.app.AppCompatCallback r8 = r7.mAppCompatCallback
            r1 = 0
            if (r8 == 0) goto L_0x0040
            boolean r2 = r7.mIsDestroyed
            if (r2 != 0) goto L_0x0040
            androidx.appcompat.view.ActionMode r8 = r8.onWindowStartingSupportActionMode(r0)     // Catch:{ AbstractMethodError -> 0x0040 }
            goto L_0x0041
        L_0x0040:
            r8 = r1
        L_0x0041:
            if (r8 == 0) goto L_0x0047
            r7.mActionMode = r8
            goto L_0x0196
        L_0x0047:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            r2 = 1
            r3 = 0
            if (r8 != 0) goto L_0x00ff
            boolean r8 = r7.mIsFloating
            if (r8 == 0) goto L_0x00d3
            android.util.TypedValue r8 = new android.util.TypedValue
            r8.<init>()
            android.content.Context r4 = r7.mContext
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R$attr.actionBarTheme
            r4.resolveAttribute(r5, r8, r2)
            int r5 = r8.resourceId
            if (r5 == 0) goto L_0x0086
            android.content.Context r5 = r7.mContext
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r8.resourceId
            r5.applyStyle(r4, r2)
            androidx.appcompat.view.ContextThemeWrapper r4 = new androidx.appcompat.view.ContextThemeWrapper
            android.content.Context r6 = r7.mContext
            r4.<init>(r6, r3)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x0088
        L_0x0086:
            android.content.Context r4 = r7.mContext
        L_0x0088:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4, r1)
            r7.mActionModeView = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R$attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.mActionModePopup = r5
            r6 = 2
            androidx.core.widget.CompoundButtonCompat.setWindowLayoutType(r5, r6)
            android.widget.PopupWindow r5 = r7.mActionModePopup
            androidx.appcompat.widget.ActionBarContextView r6 = r7.mActionModeView
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.mActionModePopup
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R$attr.actionBarSize
            r5.resolveAttribute(r6, r8, r2)
            int r8 = r8.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r8 = android.util.TypedValue.complexToDimensionPixelSize(r8, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.mActionModeView
            r4.setContentHeight(r8)
            android.widget.PopupWindow r8 = r7.mActionModePopup
            r4 = -2
            r8.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r8 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r8.<init>()
            r7.mShowActionModePopup = r8
            goto L_0x00ff
        L_0x00d3:
            android.view.ViewGroup r8 = r7.mSubDecor
            int r4 = androidx.appcompat.R$id.action_mode_bar_stub
            android.view.View r8 = r8.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r8 = (androidx.appcompat.widget.ViewStubCompat) r8
            if (r8 == 0) goto L_0x00ff
            r7.initWindowDecorActionBar()
            androidx.appcompat.app.ActionBar r4 = r7.mActionBar
            if (r4 == 0) goto L_0x00eb
            android.content.Context r4 = r4.getThemedContext()
            goto L_0x00ec
        L_0x00eb:
            r4 = r1
        L_0x00ec:
            if (r4 != 0) goto L_0x00f0
            android.content.Context r4 = r7.mContext
        L_0x00f0:
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r8.setLayoutInflater(r4)
            android.view.View r8 = r8.inflate()
            androidx.appcompat.widget.ActionBarContextView r8 = (androidx.appcompat.widget.ActionBarContextView) r8
            r7.mActionModeView = r8
        L_0x00ff:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            if (r8 == 0) goto L_0x0196
            r7.endOnGoingFadeAnimation()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            r8.killMode()
            androidx.appcompat.view.StandaloneActionMode r8 = new androidx.appcompat.view.StandaloneActionMode
            androidx.appcompat.widget.ActionBarContextView r4 = r7.mActionModeView
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.mActionModeView
            android.widget.PopupWindow r6 = r7.mActionModePopup
            if (r6 != 0) goto L_0x011a
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            r8.<init>(r4, r5, r0, r2)
            androidx.appcompat.view.menu.MenuBuilder r2 = r8.mMenu
            androidx.appcompat.view.ActionMode$Callback r0 = r0.mWrapped
            boolean r0 = r0.onCreateActionMode(r8, r2)
            if (r0 == 0) goto L_0x0194
            r8.invalidate()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.mActionModeView
            r0.initForMode(r8)
            r7.mActionMode = r8
            boolean r8 = r7.shouldAnimateActionModeView()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x015e
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            androidx.core.view.ViewPropertyAnimatorCompat r8 = androidx.core.view.ViewCompat.animate(r8)
            r8.alpha(r0)
            r7.mFadeAnim = r8
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            java.lang.ref.WeakReference<android.view.View> r1 = r8.mView
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x0184
            r8.setListenerInternal(r1, r0)
            goto L_0x0184
        L_0x015e:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            r8.setVisibility(r3)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0184
            androidx.appcompat.widget.ActionBarContextView r8 = r7.mActionModeView
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            r8.requestApplyInsets()
        L_0x0184:
            android.widget.PopupWindow r8 = r7.mActionModePopup
            if (r8 == 0) goto L_0x0196
            android.view.Window r8 = r7.mWindow
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.mShowActionModePopup
            r8.post(r0)
            goto L_0x0196
        L_0x0194:
            r7.mActionMode = r1
        L_0x0196:
            androidx.appcompat.view.ActionMode r8 = r7.mActionMode
            if (r8 == 0) goto L_0x01a1
            androidx.appcompat.app.AppCompatCallback r0 = r7.mAppCompatCallback
            if (r0 == 0) goto L_0x01a1
            r0.onSupportActionModeStarted(r8)
        L_0x01a1:
            androidx.appcompat.view.ActionMode r8 = r7.mActionMode
            r7.mActionMode = r8
        L_0x01a5:
            androidx.appcompat.view.ActionMode r8 = r7.mActionMode
            return r8
        L_0x01a8:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "ActionMode callback can not be null."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.startSupportActionMode(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final int updateStatusGuard(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5 = 0;
        if (windowInsetsCompat != null) {
            i = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            i = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.mActionModeView;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof MarginLayoutParams)) {
            z = false;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mActionModeView.getLayoutParams();
            boolean z3 = true;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect2 = this.mTempRect1;
                Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewGroup viewGroup = this.mSubDecor;
                Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, new Object[]{rect2, rect3});
                    } catch (Exception unused) {
                    }
                }
                int i6 = rect2.top;
                int i7 = rect2.left;
                int i8 = rect2.right;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.mSubDecor);
                if (rootWindowInsets == null) {
                    i2 = 0;
                } else {
                    i2 = rootWindowInsets.getSystemWindowInsetLeft();
                }
                if (rootWindowInsets == null) {
                    i3 = 0;
                } else {
                    i3 = rootWindowInsets.getSystemWindowInsetRight();
                }
                if (marginLayoutParams.topMargin == i6 && marginLayoutParams.leftMargin == i7 && marginLayoutParams.rightMargin == i8) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i6;
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = i8;
                    z2 = true;
                }
                if (i6 <= 0 || this.mStatusGuard != null) {
                    View view = this.mStatusGuard;
                    if (view != null) {
                        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == i2 && marginLayoutParams2.rightMargin == i3)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = i2;
                            marginLayoutParams2.rightMargin = i3;
                            this.mStatusGuard.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.mContext);
                    this.mStatusGuard = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i2;
                    layoutParams.rightMargin = i3;
                    this.mSubDecor.addView(this.mStatusGuard, -1, layoutParams);
                }
                z = this.mStatusGuard != null;
                if (z && this.mStatusGuard.getVisibility() != 0) {
                    View view3 = this.mStatusGuard;
                    if ((view3.getWindowSystemUiVisibility() & 8192) == 0) {
                        z3 = false;
                    }
                    if (z3) {
                        i4 = ContextCompat.getColor(this.mContext, R$color.abc_decor_view_status_guard_light);
                    } else {
                        i4 = ContextCompat.getColor(this.mContext, R$color.abc_decor_view_status_guard);
                    }
                    view3.setBackgroundColor(i4);
                }
                if (!this.mOverlayActionMode && z) {
                    i = 0;
                }
                z3 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z3 = false;
            }
            if (z3) {
                this.mActionModeView.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.mStatusGuard;
        if (view4 != null) {
            if (!z) {
                i5 = 8;
            }
            view4.setVisibility(i5);
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r13v19, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], java.lang.Object, ?[OBJECT, ARRAY]]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.Object, java.util.Map]
      mth insns count: 201
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01df  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean applyDayNight(boolean r13) {
        /*
            r12 = this;
            boolean r0 = r12.mIsDestroyed
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r12.mLocalNightMode
            r2 = -100
            if (r0 == r2) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r0 = -100
        L_0x000f:
            android.content.Context r2 = r12.mContext
            int r2 = r12.mapNightMode(r2, r0)
            android.content.Context r3 = r12.mContext
            r4 = 0
            android.content.res.Configuration r3 = r12.createOverrideConfigurationForDayNight(r3, r2, r4)
            boolean r5 = r12.mActivityHandlesUiModeChecked
            r6 = 24
            r7 = 1
            if (r5 != 0) goto L_0x0065
            java.lang.Object r5 = r12.mHost
            boolean r5 = r5 instanceof android.app.Activity
            if (r5 == 0) goto L_0x0065
            android.content.Context r5 = r12.mContext
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            if (r5 != 0) goto L_0x0033
            r5 = 0
            goto L_0x0069
        L_0x0033:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0063 }
            r9 = 29
            if (r8 < r9) goto L_0x003c
            r8 = 269221888(0x100c0000, float:2.7610132E-29)
            goto L_0x0044
        L_0x003c:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0063 }
            if (r8 < r6) goto L_0x0043
            r8 = 786432(0xc0000, float:1.102026E-39)
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            android.content.ComponentName r9 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x0063 }
            android.content.Context r10 = r12.mContext     // Catch:{ NameNotFoundException -> 0x0063 }
            java.lang.Object r11 = r12.mHost     // Catch:{ NameNotFoundException -> 0x0063 }
            java.lang.Class r11 = r11.getClass()     // Catch:{ NameNotFoundException -> 0x0063 }
            r9.<init>(r10, r11)     // Catch:{ NameNotFoundException -> 0x0063 }
            android.content.pm.ActivityInfo r5 = r5.getActivityInfo(r9, r8)     // Catch:{ NameNotFoundException -> 0x0063 }
            if (r5 == 0) goto L_0x005f
            int r5 = r5.configChanges     // Catch:{ NameNotFoundException -> 0x0063 }
            r5 = r5 & 512(0x200, float:7.17E-43)
            if (r5 == 0) goto L_0x005f
            r5 = 1
            goto L_0x0060
        L_0x005f:
            r5 = 0
        L_0x0060:
            r12.mActivityHandlesUiMode = r5     // Catch:{ NameNotFoundException -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            r12.mActivityHandlesUiMode = r1
        L_0x0065:
            r12.mActivityHandlesUiModeChecked = r7
            boolean r5 = r12.mActivityHandlesUiMode
        L_0x0069:
            android.content.Context r8 = r12.mContext
            android.content.res.Resources r8 = r8.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            int r8 = r8.uiMode
            r8 = r8 & 48
            int r3 = r3.uiMode
            r3 = r3 & 48
            if (r8 == r3) goto L_0x00a3
            if (r13 == 0) goto L_0x00a3
            if (r5 != 0) goto L_0x00a3
            boolean r13 = r12.mBaseContextAttached
            if (r13 == 0) goto L_0x00a3
            boolean r13 = sCanReturnDifferentContext
            if (r13 != 0) goto L_0x008d
            boolean r13 = r12.mCreated
            if (r13 == 0) goto L_0x00a3
        L_0x008d:
            java.lang.Object r13 = r12.mHost
            boolean r9 = r13 instanceof android.app.Activity
            if (r9 == 0) goto L_0x00a3
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r13 = r13.isChild()
            if (r13 != 0) goto L_0x00a3
            java.lang.Object r13 = r12.mHost
            android.app.Activity r13 = (android.app.Activity) r13
            androidx.core.app.ActivityCompat.recreate(r13)
            r1 = 1
        L_0x00a3:
            if (r1 != 0) goto L_0x01a8
            if (r8 == r3) goto L_0x01a8
            android.content.Context r13 = r12.mContext
            android.content.res.Resources r13 = r13.getResources()
            android.content.res.Configuration r1 = new android.content.res.Configuration
            android.content.res.Configuration r8 = r13.getConfiguration()
            r1.<init>(r8)
            android.content.res.Configuration r8 = r13.getConfiguration()
            int r8 = r8.uiMode
            r8 = r8 & -49
            r3 = r3 | r8
            r1.uiMode = r3
            r13.updateConfiguration(r1, r4)
            int r3 = android.os.Build.VERSION.SDK_INT
            r8 = 26
            r9 = 23
            if (r3 >= r8) goto L_0x0163
            r8 = 28
            if (r3 < r8) goto L_0x00d2
            goto L_0x0163
        L_0x00d2:
            java.lang.String r8 = "mDrawableCache"
            if (r3 < r6) goto L_0x011c
            boolean r3 = a.a.a.a.d.b.sResourcesImplFieldFetched
            if (r3 != 0) goto L_0x00e9
            java.lang.Class<android.content.res.Resources> r3 = android.content.res.Resources.class
            java.lang.String r6 = "mResourcesImpl"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r6)     // Catch:{ NoSuchFieldException -> 0x00e7 }
            a.a.a.a.d.b.sResourcesImplField = r3     // Catch:{ NoSuchFieldException -> 0x00e7 }
            r3.setAccessible(r7)     // Catch:{ NoSuchFieldException -> 0x00e7 }
        L_0x00e7:
            a.a.a.a.d.b.sResourcesImplFieldFetched = r7
        L_0x00e9:
            java.lang.reflect.Field r3 = a.a.a.a.d.b.sResourcesImplField
            if (r3 != 0) goto L_0x00ef
            goto L_0x0163
        L_0x00ef:
            java.lang.Object r13 = r3.get(r13)     // Catch:{ IllegalAccessException -> 0x00f4 }
            goto L_0x00f5
        L_0x00f4:
            r13 = r4
        L_0x00f5:
            if (r13 != 0) goto L_0x00f9
            goto L_0x0163
        L_0x00f9:
            boolean r3 = a.a.a.a.d.b.sDrawableCacheFieldFetched
            if (r3 != 0) goto L_0x010c
            java.lang.Class r3 = r13.getClass()     // Catch:{ NoSuchFieldException -> 0x010a }
            java.lang.reflect.Field r3 = r3.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x010a }
            a.a.a.a.d.b.sDrawableCacheField = r3     // Catch:{ NoSuchFieldException -> 0x010a }
            r3.setAccessible(r7)     // Catch:{ NoSuchFieldException -> 0x010a }
        L_0x010a:
            a.a.a.a.d.b.sDrawableCacheFieldFetched = r7
        L_0x010c:
            java.lang.reflect.Field r3 = a.a.a.a.d.b.sDrawableCacheField
            if (r3 == 0) goto L_0x0116
            java.lang.Object r4 = r3.get(r13)     // Catch:{ IllegalAccessException -> 0x0115 }
            goto L_0x0116
        L_0x0115:
        L_0x0116:
            if (r4 == 0) goto L_0x0163
            a.a.a.a.d.b.flushThemedResourcesCache(r4)
            goto L_0x0163
        L_0x011c:
            if (r3 < r9) goto L_0x0140
            boolean r3 = a.a.a.a.d.b.sDrawableCacheFieldFetched
            if (r3 != 0) goto L_0x012f
            java.lang.Class<android.content.res.Resources> r3 = android.content.res.Resources.class
            java.lang.reflect.Field r3 = r3.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x012d }
            a.a.a.a.d.b.sDrawableCacheField = r3     // Catch:{ NoSuchFieldException -> 0x012d }
            r3.setAccessible(r7)     // Catch:{ NoSuchFieldException -> 0x012d }
        L_0x012d:
            a.a.a.a.d.b.sDrawableCacheFieldFetched = r7
        L_0x012f:
            java.lang.reflect.Field r3 = a.a.a.a.d.b.sDrawableCacheField
            if (r3 == 0) goto L_0x0139
            java.lang.Object r4 = r3.get(r13)     // Catch:{ IllegalAccessException -> 0x0138 }
            goto L_0x0139
        L_0x0138:
        L_0x0139:
            if (r4 != 0) goto L_0x013c
            goto L_0x0163
        L_0x013c:
            a.a.a.a.d.b.flushThemedResourcesCache(r4)
            goto L_0x0163
        L_0x0140:
            boolean r3 = a.a.a.a.d.b.sDrawableCacheFieldFetched
            if (r3 != 0) goto L_0x0151
            java.lang.Class<android.content.res.Resources> r3 = android.content.res.Resources.class
            java.lang.reflect.Field r3 = r3.getDeclaredField(r8)     // Catch:{ NoSuchFieldException -> 0x014f }
            a.a.a.a.d.b.sDrawableCacheField = r3     // Catch:{ NoSuchFieldException -> 0x014f }
            r3.setAccessible(r7)     // Catch:{ NoSuchFieldException -> 0x014f }
        L_0x014f:
            a.a.a.a.d.b.sDrawableCacheFieldFetched = r7
        L_0x0151:
            java.lang.reflect.Field r3 = a.a.a.a.d.b.sDrawableCacheField
            if (r3 == 0) goto L_0x0163
            java.lang.Object r13 = r3.get(r13)     // Catch:{ IllegalAccessException -> 0x015d }
            java.util.Map r13 = (java.util.Map) r13     // Catch:{ IllegalAccessException -> 0x015d }
            r4 = r13
            goto L_0x015e
        L_0x015d:
        L_0x015e:
            if (r4 == 0) goto L_0x0163
            r4.clear()
        L_0x0163:
            int r13 = r12.mThemeResId
            if (r13 == 0) goto L_0x017b
            android.content.Context r3 = r12.mContext
            r3.setTheme(r13)
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r9) goto L_0x017b
            android.content.Context r13 = r12.mContext
            android.content.res.Resources$Theme r13 = r13.getTheme()
            int r3 = r12.mThemeResId
            r13.applyStyle(r3, r7)
        L_0x017b:
            if (r5 == 0) goto L_0x01a9
            java.lang.Object r13 = r12.mHost
            boolean r3 = r13 instanceof android.app.Activity
            if (r3 == 0) goto L_0x01a9
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r3 = r13 instanceof androidx.lifecycle.LifecycleOwner
            if (r3 == 0) goto L_0x01a0
            r3 = r13
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            androidx.lifecycle.LifecycleRegistry r3 = (androidx.lifecycle.LifecycleRegistry) r3
            androidx.lifecycle.Lifecycle$State r3 = r3.mState
            androidx.lifecycle.Lifecycle$State r4 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r3 = r3.isAtLeast(r4)
            if (r3 == 0) goto L_0x01a9
            r13.onConfigurationChanged(r1)
            goto L_0x01a9
        L_0x01a0:
            boolean r3 = r12.mStarted
            if (r3 == 0) goto L_0x01a9
            r13.onConfigurationChanged(r1)
            goto L_0x01a9
        L_0x01a8:
            r7 = r1
        L_0x01a9:
            if (r7 == 0) goto L_0x01b6
            java.lang.Object r13 = r12.mHost
            boolean r1 = r13 instanceof androidx.appcompat.app.AppCompatActivity
            if (r1 == 0) goto L_0x01b6
            androidx.appcompat.app.AppCompatActivity r13 = (androidx.appcompat.app.AppCompatActivity) r13
            r13.onNightModeChanged(r2)
        L_0x01b6:
            if (r0 != 0) goto L_0x01c2
            android.content.Context r13 = r12.mContext
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r13 = r12.getAutoTimeNightModeManager(r13)
            r13.setup()
            goto L_0x01c9
        L_0x01c2:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r13 = r12.mAutoTimeNightModeManager
            if (r13 == 0) goto L_0x01c9
            r13.cleanup()
        L_0x01c9:
            r13 = 3
            if (r0 != r13) goto L_0x01df
            android.content.Context r13 = r12.mContext
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r0 = r12.mAutoBatteryNightModeManager
            if (r0 != 0) goto L_0x01d9
            androidx.appcompat.app.AppCompatDelegateImpl$AutoBatteryNightModeManager r0 = new androidx.appcompat.app.AppCompatDelegateImpl$AutoBatteryNightModeManager
            r0.<init>(r13)
            r12.mAutoBatteryNightModeManager = r0
        L_0x01d9:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r13 = r12.mAutoBatteryNightModeManager
            r13.setup()
            goto L_0x01e6
        L_0x01df:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager r13 = r12.mAutoBatteryNightModeManager
            if (r13 == 0) goto L_0x01e6
            r13.cleanup()
        L_0x01e6:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.applyDayNight(boolean):boolean");
    }

    public void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.mWrapped.onContentChanged();
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
