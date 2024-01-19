package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatDelegateImpl.ActionBarDrawableToggleImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.LongSparseArray;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.app.TaskStackBuilder.SupportParentable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.runtime.R$id;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;

public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, SupportParentable {
    public static final String DELEGATE_TAG = "androidx:appcompat";
    public AppCompatDelegate mDelegate;
    public Resources mResources;

    public AppCompatActivity() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new SavedStateProvider() {
            public Bundle saveState() {
                Bundle bundle = new Bundle();
                if (((AppCompatDelegateImpl) AppCompatActivity.this.getDelegate()) != null) {
                    return bundle;
                }
                throw null;
            }
        });
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void onContextAvailable(Context context) {
                AppCompatDelegate delegate = AppCompatActivity.this.getDelegate();
                delegate.installViewFactory();
                delegate.onCreate(AppCompatActivity.this.getSavedStateRegistry().consumeRestoredStateForKey(AppCompatActivity.DELEGATE_TAG));
            }
        });
    }

    private void initViewTreeOwners() {
        getWindow().getDecorView().setTag(R$id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        if (VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey(keyEvent.getKeyCode())) {
            Window window = getWindow();
            if (!(window == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent))) {
                return true;
            }
        }
        return false;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().addContentView(view, layoutParams);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x01d1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:124:0x01df */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachBaseContext(android.content.Context r10) {
        /*
            r9 = this;
            androidx.appcompat.app.AppCompatDelegate r0 = r9.getDelegate()
            androidx.appcompat.app.AppCompatDelegateImpl r0 = (androidx.appcompat.app.AppCompatDelegateImpl) r0
            r1 = 1
            r0.mBaseContextAttached = r1
            int r2 = r0.mLocalNightMode
            r3 = -100
            if (r2 == r3) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r2 = -100
        L_0x0012:
            int r2 = r0.mapNightMode(r10, r2)
            boolean r3 = androidx.appcompat.app.AppCompatDelegateImpl.sCanApplyOverrideConfiguration
            r4 = 0
            if (r3 == 0) goto L_0x002c
            boolean r3 = r10 instanceof android.view.ContextThemeWrapper
            if (r3 == 0) goto L_0x002c
            android.content.res.Configuration r3 = r0.createOverrideConfigurationForDayNight(r10, r2, r4)
            r5 = r10
            android.view.ContextThemeWrapper r5 = (android.view.ContextThemeWrapper) r5     // Catch:{ IllegalStateException -> 0x002b }
            r5.applyOverrideConfiguration(r3)     // Catch:{ IllegalStateException -> 0x002b }
            goto L_0x01e7
        L_0x002b:
        L_0x002c:
            boolean r3 = r10 instanceof androidx.appcompat.view.ContextThemeWrapper
            if (r3 == 0) goto L_0x003d
            android.content.res.Configuration r3 = r0.createOverrideConfigurationForDayNight(r10, r2, r4)
            r5 = r10
            androidx.appcompat.view.ContextThemeWrapper r5 = (androidx.appcompat.view.ContextThemeWrapper) r5     // Catch:{ IllegalStateException -> 0x003c }
            r5.applyOverrideConfiguration(r3)     // Catch:{ IllegalStateException -> 0x003c }
            goto L_0x01e7
        L_0x003c:
        L_0x003d:
            boolean r3 = androidx.appcompat.app.AppCompatDelegateImpl.sCanReturnDifferentContext
            if (r3 != 0) goto L_0x0043
            goto L_0x01e7
        L_0x0043:
            android.content.res.Configuration r3 = new android.content.res.Configuration
            r3.<init>()
            r5 = -1
            r3.uiMode = r5
            r5 = 0
            r3.fontScale = r5
            android.content.Context r3 = r10.createConfigurationContext(r3)
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            android.content.res.Resources r6 = r10.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r7 = r6.uiMode
            r3.uiMode = r7
            boolean r7 = r3.equals(r6)
            if (r7 != 0) goto L_0x018e
            android.content.res.Configuration r7 = new android.content.res.Configuration
            r7.<init>()
            r7.fontScale = r5
            int r5 = r3.diff(r6)
            if (r5 != 0) goto L_0x007b
            goto L_0x018f
        L_0x007b:
            float r5 = r3.fontScale
            float r8 = r6.fontScale
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0085
            r7.fontScale = r8
        L_0x0085:
            int r5 = r3.mcc
            int r8 = r6.mcc
            if (r5 == r8) goto L_0x008d
            r7.mcc = r8
        L_0x008d:
            int r5 = r3.mnc
            int r8 = r6.mnc
            if (r5 == r8) goto L_0x0095
            r7.mnc = r8
        L_0x0095:
            int r5 = android.os.Build.VERSION.SDK_INT
            r8 = 24
            if (r5 < r8) goto L_0x00b1
            android.os.LocaleList r5 = r3.getLocales()
            android.os.LocaleList r8 = r6.getLocales()
            boolean r5 = r5.equals(r8)
            if (r5 != 0) goto L_0x00bf
            r7.setLocales(r8)
            java.util.Locale r5 = r6.locale
            r7.locale = r5
            goto L_0x00bf
        L_0x00b1:
            java.util.Locale r5 = r3.locale
            java.util.Locale r8 = r6.locale
            boolean r5 = java.util.Objects.equals(r5, r8)
            if (r5 != 0) goto L_0x00bf
            java.util.Locale r5 = r6.locale
            r7.locale = r5
        L_0x00bf:
            int r5 = r3.touchscreen
            int r8 = r6.touchscreen
            if (r5 == r8) goto L_0x00c7
            r7.touchscreen = r8
        L_0x00c7:
            int r5 = r3.keyboard
            int r8 = r6.keyboard
            if (r5 == r8) goto L_0x00cf
            r7.keyboard = r8
        L_0x00cf:
            int r5 = r3.keyboardHidden
            int r8 = r6.keyboardHidden
            if (r5 == r8) goto L_0x00d7
            r7.keyboardHidden = r8
        L_0x00d7:
            int r5 = r3.navigation
            int r8 = r6.navigation
            if (r5 == r8) goto L_0x00df
            r7.navigation = r8
        L_0x00df:
            int r5 = r3.navigationHidden
            int r8 = r6.navigationHidden
            if (r5 == r8) goto L_0x00e7
            r7.navigationHidden = r8
        L_0x00e7:
            int r5 = r3.orientation
            int r8 = r6.orientation
            if (r5 == r8) goto L_0x00ef
            r7.orientation = r8
        L_0x00ef:
            int r5 = r3.screenLayout
            r5 = r5 & 15
            int r8 = r6.screenLayout
            r8 = r8 & 15
            if (r5 == r8) goto L_0x00fe
            int r5 = r7.screenLayout
            r5 = r5 | r8
            r7.screenLayout = r5
        L_0x00fe:
            int r5 = r3.screenLayout
            r5 = r5 & 192(0xc0, float:2.69E-43)
            int r8 = r6.screenLayout
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r5 == r8) goto L_0x010d
            int r5 = r7.screenLayout
            r5 = r5 | r8
            r7.screenLayout = r5
        L_0x010d:
            int r5 = r3.screenLayout
            r5 = r5 & 48
            int r8 = r6.screenLayout
            r8 = r8 & 48
            if (r5 == r8) goto L_0x011c
            int r5 = r7.screenLayout
            r5 = r5 | r8
            r7.screenLayout = r5
        L_0x011c:
            int r5 = r3.screenLayout
            r5 = r5 & 768(0x300, float:1.076E-42)
            int r8 = r6.screenLayout
            r8 = r8 & 768(0x300, float:1.076E-42)
            if (r5 == r8) goto L_0x012b
            int r5 = r7.screenLayout
            r5 = r5 | r8
            r7.screenLayout = r5
        L_0x012b:
            int r5 = android.os.Build.VERSION.SDK_INT
            r8 = 26
            if (r5 < r8) goto L_0x014f
            int r5 = r3.colorMode
            r5 = r5 & 3
            int r8 = r6.colorMode
            r8 = r8 & 3
            if (r5 == r8) goto L_0x0140
            int r5 = r7.colorMode
            r5 = r5 | r8
            r7.colorMode = r5
        L_0x0140:
            int r5 = r3.colorMode
            r5 = r5 & 12
            int r8 = r6.colorMode
            r8 = r8 & 12
            if (r5 == r8) goto L_0x014f
            int r5 = r7.colorMode
            r5 = r5 | r8
            r7.colorMode = r5
        L_0x014f:
            int r5 = r3.uiMode
            r5 = r5 & 15
            int r8 = r6.uiMode
            r8 = r8 & 15
            if (r5 == r8) goto L_0x015e
            int r5 = r7.uiMode
            r5 = r5 | r8
            r7.uiMode = r5
        L_0x015e:
            int r5 = r3.uiMode
            r5 = r5 & 48
            int r8 = r6.uiMode
            r8 = r8 & 48
            if (r5 == r8) goto L_0x016d
            int r5 = r7.uiMode
            r5 = r5 | r8
            r7.uiMode = r5
        L_0x016d:
            int r5 = r3.screenWidthDp
            int r8 = r6.screenWidthDp
            if (r5 == r8) goto L_0x0175
            r7.screenWidthDp = r8
        L_0x0175:
            int r5 = r3.screenHeightDp
            int r8 = r6.screenHeightDp
            if (r5 == r8) goto L_0x017d
            r7.screenHeightDp = r8
        L_0x017d:
            int r5 = r3.smallestScreenWidthDp
            int r8 = r6.smallestScreenWidthDp
            if (r5 == r8) goto L_0x0185
            r7.smallestScreenWidthDp = r8
        L_0x0185:
            int r3 = r3.densityDpi
            int r5 = r6.densityDpi
            if (r3 == r5) goto L_0x018f
            r7.densityDpi = r5
            goto L_0x018f
        L_0x018e:
            r7 = r4
        L_0x018f:
            android.content.res.Configuration r0 = r0.createOverrideConfigurationForDayNight(r10, r2, r7)
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            int r3 = androidx.appcompat.R$style.Theme_AppCompat_Empty
            r2.<init>(r10, r3)
            r2.applyOverrideConfiguration(r0)
            r0 = 0
            android.content.res.Resources$Theme r10 = r10.getTheme()     // Catch:{ NullPointerException -> 0x01a6 }
            if (r10 == 0) goto L_0x01a6
            r10 = 1
            goto L_0x01a7
        L_0x01a6:
            r10 = 0
        L_0x01a7:
            if (r10 == 0) goto L_0x01e6
            android.content.res.Resources$Theme r10 = r2.getTheme()
            int r3 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r3 < r5) goto L_0x01b7
            r10.rebase()
            goto L_0x01e6
        L_0x01b7:
            r5 = 23
            if (r3 < r5) goto L_0x01e6
            java.lang.Object r3 = androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethodLock
            monitor-enter(r3)
            boolean r5 = androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethodFetched     // Catch:{ all -> 0x01e3 }
            if (r5 != 0) goto L_0x01d3
            java.lang.Class<android.content.res.Resources$Theme> r5 = android.content.res.Resources.Theme.class
            java.lang.String r6 = "rebase"
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x01d1 }
            java.lang.reflect.Method r5 = r5.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x01d1 }
            androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod = r5     // Catch:{ NoSuchMethodException -> 0x01d1 }
            r5.setAccessible(r1)     // Catch:{ NoSuchMethodException -> 0x01d1 }
        L_0x01d1:
            androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethodFetched = r1     // Catch:{ all -> 0x01e3 }
        L_0x01d3:
            java.lang.reflect.Method r1 = androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod     // Catch:{ all -> 0x01e3 }
            if (r1 == 0) goto L_0x01e1
            java.lang.reflect.Method r1 = androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x01df }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x01df }
            r1.invoke(r10, r0)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x01df }
            goto L_0x01e1
        L_0x01df:
            androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23.sRebaseMethod = r4     // Catch:{ all -> 0x01e3 }
        L_0x01e1:
            monitor-exit(r3)     // Catch:{ all -> 0x01e3 }
            goto L_0x01e6
        L_0x01e3:
            r10 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01e3 }
            throw r10
        L_0x01e6:
            r10 = r2
        L_0x01e7:
            super.attachBaseContext(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatActivity.attachBaseContext(android.content.Context):void");
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.onMenuKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        return appCompatDelegateImpl.mWindow.findViewById(i);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create((Activity) this, (AppCompatCallback) this);
        }
        return this.mDelegate;
    }

    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl != null) {
            return new ActionBarDrawableToggleImpl(appCompatDelegateImpl);
        }
        throw null;
    }

    public MenuInflater getMenuInflater() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mMenuInflater == null) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            appCompatDelegateImpl.mMenuInflater = new SupportMenuInflater(actionBar != null ? actionBar.getThemedContext() : appCompatDelegateImpl.mContext);
        }
        return appCompatDelegateImpl.mMenuInflater;
    }

    public Resources getResources() {
        if (this.mResources == null) {
            VectorEnabledTintResources.shouldBeUsed();
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        return appCompatDelegateImpl.mActionBar;
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHasActionBar && appCompatDelegateImpl.mSubDecorInstalled) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.onConfigurationChanged(configuration);
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = appCompatDelegateImpl.mContext;
        synchronized (appCompatDrawableManager) {
            ResourceManagerInternal resourceManagerInternal = appCompatDrawableManager.mResourceManager;
            synchronized (resourceManagerInternal) {
                LongSparseArray longSparseArray = resourceManagerInternal.mDrawableCaches.get(context);
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
        appCompatDelegateImpl.applyDayNight(false);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack((Activity) this);
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImpl) getDelegate()).ensureSubDecor();
    }

    public void onPostResume() {
        super.onPostResume();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    public void onStart() {
        super.onStart();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mStarted = true;
        appCompatDelegateImpl.applyDayNight();
    }

    public void onStop() {
        super.onStop();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mStarted = false;
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            TaskStackBuilder create = TaskStackBuilder.create(this);
            onCreateSupportNavigateUpTaskStack(create);
            onPrepareSupportNavigateUpTaskStack(create);
            create.startActivities();
            try {
                ActivityCompat.finishAffinity(this);
            } catch (IllegalStateException unused) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    public ActionMode onWindowStartingSupportActionMode(Callback callback) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i) {
        initViewTreeOwners();
        getDelegate().setContentView(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHost instanceof Activity) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (!(actionBar instanceof WindowDecorActionBar)) {
                appCompatDelegateImpl.mMenuInflater = null;
                if (actionBar != null) {
                    actionBar.onDestroy();
                }
                if (toolbar != null) {
                    Object obj = appCompatDelegateImpl.mHost;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = appCompatDelegateImpl.mTitle;
                    }
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, charSequence, appCompatDelegateImpl.mAppCompatWindowCallback);
                    appCompatDelegateImpl.mActionBar = toolbarActionBar;
                    appCompatDelegateImpl.mWindow.setCallback(toolbarActionBar.mWindowCallback);
                } else {
                    appCompatDelegateImpl.mActionBar = null;
                    appCompatDelegateImpl.mWindow.setCallback(appCompatDelegateImpl.mAppCompatWindowCallback);
                }
                appCompatDelegateImpl.invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public void setTheme(int i) {
        super.setTheme(i);
        ((AppCompatDelegateImpl) getDelegate()).mThemeResId = i;
    }

    public ActionMode startSupportActionMode(Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    public AppCompatActivity(int i) {
        super(i);
        initDelegate();
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().setContentView(view, layoutParams);
    }
}
