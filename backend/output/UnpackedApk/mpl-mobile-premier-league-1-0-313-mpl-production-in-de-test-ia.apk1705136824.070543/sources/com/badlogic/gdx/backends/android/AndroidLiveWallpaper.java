package com.badlogic.gdx.backends.android;

import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxNativesLoader;
import com.badlogic.gdx.utils.SnapshotArray;

public class AndroidLiveWallpaper implements AndroidApplicationBase {
    public final Array<Runnable> executedRunnables = new Array<>();
    public boolean firstResume = true;
    public AndroidInput input;
    public final SnapshotArray<LifecycleListener> lifecycleListeners = new SnapshotArray<>(LifecycleListener.class);
    public ApplicationAdapter listener;
    public int logLevel = 2;
    public final Array<Runnable> runnables = new Array<>();
    public AndroidLiveWallpaperService service;
    public volatile Color[] wallpaperColors = null;

    static {
        GdxNativesLoader.load();
    }

    public AndroidLiveWallpaper(AndroidLiveWallpaperService androidLiveWallpaperService) {
        this.service = androidLiveWallpaperService;
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        synchronized (this.lifecycleListeners) {
            this.lifecycleListeners.add(lifecycleListener);
        }
    }

    public void error(String str, String str2) {
        if (this.logLevel >= 1) {
            throw null;
        }
    }

    public ApplicationAdapter getApplicationListener() {
        return null;
    }

    public Window getApplicationWindow() {
        throw new UnsupportedOperationException();
    }

    public Array<Runnable> getExecutedRunnables() {
        return this.executedRunnables;
    }

    public Graphics getGraphics() {
        return null;
    }

    public Handler getHandler() {
        throw new UnsupportedOperationException();
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

    public WindowManager getWindowManager() {
        return this.service.getWindowManager();
    }

    public void log(String str, String str2) {
        if (this.logLevel >= 2) {
            throw null;
        }
    }

    public void postRunnable(Runnable runnable) {
        synchronized (this.runnables) {
            this.runnables.add(runnable);
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
        if (this.logLevel >= 1) {
            throw null;
        }
    }

    public void log(String str, String str2, Throwable th) {
        if (this.logLevel >= 2) {
            throw null;
        }
    }
}
