package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.backends.android.surfaceview.FillResolutionStrategy;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.badlogic.gdx.utils.SnapshotArray;
import java.util.Arrays;

public class AndroidApplication extends Activity implements AndroidApplicationBase {
    public final Array<AndroidEventListener> androidEventListeners = new Array<>();
    public AndroidApplicationLogger applicationLogger;
    public AndroidAudio audio;
    public final Array<Runnable> executedRunnables = new Array<>();
    public AndroidFiles files;
    public boolean firstResume = true;
    public AndroidGraphics graphics;
    public Handler handler;
    public boolean hideStatusBar = false;
    public AndroidInput input;
    public boolean isWaitingForAudio = false;
    public final SnapshotArray<LifecycleListener> lifecycleListeners = new SnapshotArray<>(LifecycleListener.class);
    public ApplicationAdapter listener;
    public int logLevel = 2;

    /* renamed from: net  reason: collision with root package name */
    public AndroidNet f3303net;
    public final Array<Runnable> runnables = new Array<>();
    public boolean useImmersiveMode = false;
    public int wasFocusChanged = -1;

    static {
        GdxNativesLoader.load();
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.add(lifecycleListener);
        }
    }

    public AndroidInput createInput(AndroidApplicationConfiguration androidApplicationConfiguration) {
        return new DefaultAndroidInput(this, this, this.graphics.view, androidApplicationConfiguration);
    }

    public void error(String str, String str2) {
        if (this.logLevel >= 1 && getApplicationLogger() == null) {
            throw null;
        }
    }

    public ApplicationAdapter getApplicationListener() {
        return this.listener;
    }

    public AndroidApplicationLogger getApplicationLogger() {
        return this.applicationLogger;
    }

    public Window getApplicationWindow() {
        return getWindow();
    }

    public AndroidAudio getAudio() {
        return this.audio;
    }

    public Array<Runnable> getExecutedRunnables() {
        return this.executedRunnables;
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public AndroidInput getInput() {
        return this.input;
    }

    public SnapshotArray<LifecycleListener> getLifecycleListeners() {
        return this.lifecycleListeners;
    }

    public Array<Runnable> getRunnables() {
        return this.runnables;
    }

    public ApplicationType getType() {
        return ApplicationType.Android;
    }

    public final void init(ApplicationAdapter applicationAdapter, AndroidApplicationConfiguration androidApplicationConfiguration, boolean z) {
        setApplicationLogger(new AndroidApplicationLogger());
        ResolutionStrategy resolutionStrategy = androidApplicationConfiguration.resolutionStrategy;
        if (resolutionStrategy == null) {
            resolutionStrategy = new FillResolutionStrategy();
        }
        this.graphics = new AndroidGraphics(this, androidApplicationConfiguration, resolutionStrategy);
        this.input = createInput(androidApplicationConfiguration);
        this.audio = new DefaultAndroidAudio(this, androidApplicationConfiguration);
        getFilesDir();
        this.files = new DefaultAndroidFiles(getAssets(), this, true);
        this.f3303net = new AndroidNet(this, androidApplicationConfiguration);
        this.listener = applicationAdapter;
        this.handler = new Handler();
        this.useImmersiveMode = androidApplicationConfiguration.useImmersiveMode;
        this.hideStatusBar = androidApplicationConfiguration.hideStatusBar;
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        AnonymousClass1 r4 = new LifecycleListener() {
            public void dispose() {
                AndroidApplication.this.audio.dispose();
            }

            public void pause() {
                ((DefaultAndroidAudio) AndroidApplication.this.audio).pause();
            }

            public void resume() {
            }
        };
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.add(r4);
        }
        k.app = this;
        k.input = this.input;
        k.audio = getAudio();
        k.files = this.files;
        k.graphics = this.graphics;
        k.f3111net = this.f3303net;
        if (!z) {
            try {
                requestWindowFeature(1);
            } catch (Exception unused) {
                if (this.logLevel >= 2 && getApplicationLogger() == null) {
                    throw null;
                }
            }
            getWindow().setFlags(1024, 1024);
            getWindow().clearFlags(2048);
            GLSurfaceView20 gLSurfaceView20 = this.graphics.view;
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            setContentView(gLSurfaceView20, layoutParams);
        }
        if (androidApplicationConfiguration.useWakelock) {
            getWindow().addFlags(128);
        }
        if (this.hideStatusBar) {
            getWindow().getDecorView().setSystemUiVisibility(1);
        }
        useImmersiveMode(this.useImmersiveMode);
        if (this.useImmersiveMode) {
            try {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(new AndroidVisibilityListener(), this) {
                    public final /* synthetic */ AndroidApplicationBase val$application;

                    {
                        this.val$application = r2;
                    }

                    public void onSystemUiVisibilityChange(int i) {
                        this.val$application.getHandler().post(new Runnable() {
                            public void run() {
                                AnonymousClass1.this.val$application.useImmersiveMode(true);
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                log("AndroidApplication", "Can't create OnSystemUiVisibilityChangeListener, unable to use immersive mode.", th);
            }
        }
        if (getResources().getConfiguration().keyboard != 1 && ((DefaultAndroidInput) this.input) == null) {
            throw null;
        }
    }

    public void initialize(ApplicationAdapter applicationAdapter, AndroidApplicationConfiguration androidApplicationConfiguration) {
        init(applicationAdapter, androidApplicationConfiguration, false);
    }

    public void log(String str, String str2) {
        if (this.logLevel >= 2 && getApplicationLogger() == null) {
            throw null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        synchronized (this.androidEventListeners) {
            for (int i3 = 0; i3 < this.androidEventListeners.size; i3++) {
                ((AndroidEventListener) this.androidEventListeners.get(i3)).onActivityResult(i, i2, intent);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.hardKeyboardHidden;
        if (((DefaultAndroidInput) this.input) == null) {
            throw null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        boolean z = this.graphics.isContinuous;
        boolean z2 = AndroidGraphics.enforceContinuousRendering;
        AndroidGraphics.enforceContinuousRendering = true;
        this.graphics.setContinuousRendering(true);
        this.graphics.pause();
        DefaultAndroidInput defaultAndroidInput = (DefaultAndroidInput) this.input;
        defaultAndroidInput.unregisterSensorListeners();
        Arrays.fill(defaultAndroidInput.realId, -1);
        Arrays.fill(defaultAndroidInput.touched, false);
        if (isFinishing()) {
            this.graphics.clearManagedCaches();
            this.graphics.destroy();
        }
        AndroidGraphics.enforceContinuousRendering = z2;
        this.graphics.setContinuousRendering(z);
        this.graphics.onPauseGLSurfaceView();
        super.onPause();
    }

    public void onResume() {
        k.app = this;
        k.input = this.input;
        k.audio = getAudio();
        k.files = this.files;
        k.graphics = this.graphics;
        k.f3111net = this.f3303net;
        ((DefaultAndroidInput) this.input).registerSensorListeners();
        AndroidGraphics androidGraphics = this.graphics;
        if (androidGraphics != null) {
            androidGraphics.onResumeGLSurfaceView();
        }
        if (!this.firstResume) {
            this.graphics.resume();
        } else {
            this.firstResume = false;
        }
        this.isWaitingForAudio = true;
        int i = this.wasFocusChanged;
        if (i == 1 || i == -1) {
            ((DefaultAndroidAudio) this.audio).resume();
            this.isWaitingForAudio = false;
        }
        super.onResume();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        useImmersiveMode(this.useImmersiveMode);
        if (this.hideStatusBar) {
            getWindow().getDecorView().setSystemUiVisibility(1);
        }
        if (z) {
            this.wasFocusChanged = 1;
            if (this.isWaitingForAudio) {
                ((DefaultAndroidAudio) this.audio).resume();
                this.isWaitingForAudio = false;
                return;
            }
            return;
        }
        this.wasFocusChanged = 0;
    }

    public void postRunnable(Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.add(runnable);
            ((AndroidGraphics) k.graphics).requestRendering();
        }
    }

    public void removeLifecycleListener(LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.removeValue(lifecycleListener, true);
        }
    }

    public void setApplicationLogger(AndroidApplicationLogger androidApplicationLogger) {
        this.applicationLogger = androidApplicationLogger;
    }

    @TargetApi(19)
    public void useImmersiveMode(boolean z) {
        if (z && VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void error(String str, String str2, Throwable th) {
        if (this.logLevel >= 1 && getApplicationLogger() == null) {
            throw null;
        }
    }

    public void log(String str, String str2, Throwable th) {
        if (this.logLevel >= 2 && getApplicationLogger() == null) {
            throw null;
        }
    }
}
