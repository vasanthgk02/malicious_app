package com.badlogic.gdx.backends.android;

import android.content.ContextWrapper;
import android.content.res.AssetManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;

public class DefaultAndroidFiles implements AndroidFiles {
    public final AssetManager assets;
    public ZipResourceFile expansionFile = null;
    public final String externalFilesPath;
    public final String localpath;

    public DefaultAndroidFiles(AssetManager assetManager, ContextWrapper contextWrapper, boolean z) {
        String str = null;
        this.assets = assetManager;
        String absolutePath = contextWrapper.getFilesDir().getAbsolutePath();
        this.localpath = !absolutePath.endsWith("/") ? GeneratedOutlineSupport.outline50(absolutePath, "/") : absolutePath;
        if (z) {
            File externalFilesDir = contextWrapper.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                String absolutePath2 = externalFilesDir.getAbsolutePath();
                str = !absolutePath2.endsWith("/") ? GeneratedOutlineSupport.outline50(absolutePath2, "/") : absolutePath2;
            }
            this.externalFilesPath = str;
            return;
        }
        this.externalFilesPath = null;
    }

    public FileHandle classpath(String str) {
        return new AndroidFileHandle((AssetManager) null, str, FileType.Classpath);
    }

    public FileHandle external(String str) {
        return new AndroidFileHandle((AssetManager) null, str, FileType.External);
    }

    public String getExternalStoragePath() {
        return this.externalFilesPath;
    }

    public FileHandle getFileHandle(String str, FileType fileType) {
        return new AndroidFileHandle(fileType == FileType.Internal ? this.assets : null, str, fileType);
    }

    public String getLocalStoragePath() {
        return this.localpath;
    }

    public FileHandle internal(String str) {
        return new AndroidFileHandle(this.assets, str, FileType.Internal);
    }

    public FileHandle local(String str) {
        return new AndroidFileHandle((AssetManager) null, str, FileType.Local);
    }
}
