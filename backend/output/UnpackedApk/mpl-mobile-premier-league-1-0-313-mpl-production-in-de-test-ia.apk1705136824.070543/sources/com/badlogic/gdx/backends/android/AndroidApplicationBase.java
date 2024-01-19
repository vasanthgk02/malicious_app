package com.badlogic.gdx.backends.android;

import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.LifecycleListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.SnapshotArray;

public interface AndroidApplicationBase extends Application {
    Window getApplicationWindow();

    Array<Runnable> getExecutedRunnables();

    Handler getHandler();

    AndroidInput getInput();

    SnapshotArray<LifecycleListener> getLifecycleListeners();

    Array<Runnable> getRunnables();

    WindowManager getWindowManager();

    void useImmersiveMode(boolean z);
}
