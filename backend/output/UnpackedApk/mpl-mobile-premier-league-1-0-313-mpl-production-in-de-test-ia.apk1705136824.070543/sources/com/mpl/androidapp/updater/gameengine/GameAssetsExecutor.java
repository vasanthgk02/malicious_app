package com.mpl.androidapp.updater.gameengine;

import com.mpl.androidapp.utils.MLogger;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GameAssetsExecutor {
    public static final String TAG = "com.mpl.androidapp.updater.gameengine.GameAssetsExecutor";

    public static void execute(List<Callable<Boolean>> list) {
        try {
            for (Future<T> isDone : Executors.newSingleThreadExecutor().invokeAll(list)) {
                MLogger.d(TAG, "Downloading assets", Boolean.valueOf(isDone.isDone()));
            }
        } catch (InterruptedException e2) {
            MLogger.e(TAG, "", e2);
        }
    }
}
