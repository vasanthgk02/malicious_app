package com.mpl.androidapp.updater.gameengine;

import android.content.Context;
import java.io.File;

public interface Interactor {
    boolean canGameLaunch(Context context, int i);

    void copyAssets(Context context);

    boolean deleteAssets(Context context, int i);

    void downloadGameAssets(Context context, int i, int i2);

    void extractAssets(Context context);

    boolean isAssetsAvailable(Context context, int i);

    boolean isGameCodeAvailable(Context context, int i);

    boolean isSpaceAvailable(Context context);

    boolean isValidMD5(Context context, int i, String str, File file);

    String loadAssets(Context context, int i);

    void saveHashForPreBundleAssets(Context context);
}
