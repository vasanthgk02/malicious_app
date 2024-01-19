package org.apache.pdfbox.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

public class PDFBoxResourceLoader {
    public static AssetManager ASSET_MANAGER;
    public static Context CONTEXT;
    public static boolean hasWarned;

    public static InputStream getStream(String str) throws IOException {
        return ASSET_MANAGER.open(str);
    }

    public static void init(Context context) {
        if (CONTEXT == null) {
            Context applicationContext = context.getApplicationContext();
            CONTEXT = applicationContext;
            ASSET_MANAGER = applicationContext.getAssets();
        }
    }

    public static boolean isReady() {
        if (ASSET_MANAGER == null && !hasWarned) {
            hasWarned = true;
        }
        if (ASSET_MANAGER != null) {
            return true;
        }
        return false;
    }
}
