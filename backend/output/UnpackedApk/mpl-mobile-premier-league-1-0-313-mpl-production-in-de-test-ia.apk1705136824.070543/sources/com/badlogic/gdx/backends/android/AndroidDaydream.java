package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Handler;
import android.service.dreams.DreamService;
import android.view.Window;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.badlogic.gdx.utils.SnapshotArray;

@TargetApi(17)
public class AndroidDaydream extends DreamService implements AndroidApplicationBase {
    public final Array<Runnable> executedRunnables = new Array<>();
    public boolean firstResume = true;
    public final SnapshotArray<LifecycleListener> lifecycleListeners = new SnapshotArray<>(LifecycleListener.class);
    public int logLevel = 2;
    public final Array<Runnable> runnables = new Array<>();

    static {
        GdxNativesLoader.load();
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.add(lifecycleListener);
        }
    }

    public void error(String str, String str2) {
        if (this.logLevel >= 1 && getApplicationLogger() == null) {
            throw null;
        }
    }

    public ApplicationAdapter getApplicationListener() {
        return null;
    }

    public AndroidApplicationLogger getApplicationLogger() {
        return null;
    }

    public Window getApplicationWindow() {
        return getWindow();
    }

    public AndroidAudio getAudio() {
        return null;
    }

    public Array<Runnable> getExecutedRunnables() {
        return this.executedRunnables;
    }

    public Graphics getGraphics() {
        return null;
    }

    public Handler getHandler() {
        return null;
    }

    public AndroidInput getInput() {
        return null;
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

    public void log(String str, String str2) {
        if (this.logLevel >= 2 && getApplicationLogger() == null) {
            throw null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.hardKeyboardHidden;
        throw null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onDreamingStarted() {
        k.app = this;
        k.input = null;
        k.audio = getAudio();
        k.files = null;
        k.graphics = null;
        k.f3111net = null;
        throw null;
    }

    public void onDreamingStopped() {
        throw null;
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

    public void useImmersiveMode(boolean z) {
        throw new UnsupportedOperationException();
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
