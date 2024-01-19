package com.mpl.androidapp.utils;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.facebook.react.bridge.ReactApplicationContext;
import com.mpl.androidapp.MPLApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShareFile {
    public static final String TAG = "ShareFile";
    public final Context reactContext;
    public String type;
    public final Uri uri;
    public final String url;

    public ShareFile(String str, String str2, ReactApplicationContext reactApplicationContext) {
        this(str, reactApplicationContext);
        this.type = str2;
    }

    private String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    private String getRealPathFromURI(Uri uri2) {
        CursorLoader cursorLoader = new CursorLoader(this.reactContext, uri2, new String[]{"_data"}, null, null, null);
        Cursor loadInBackground = cursorLoader.loadInBackground();
        if (loadInBackground == null || !loadInBackground.moveToFirst()) {
            if (loadInBackground != null && !loadInBackground.isClosed()) {
                loadInBackground.close();
            }
            return null;
        }
        String string = loadInBackground.getString(loadInBackground.getColumnIndexOrThrow("_data"));
        loadInBackground.close();
        return string;
    }

    private boolean isBase64File() {
        if (this.uri.getScheme() == null || !this.uri.getScheme().equals("data")) {
            return false;
        }
        this.type = this.uri.getSchemeSpecificPart().substring(0, this.uri.getSchemeSpecificPart().indexOf(";"));
        return true;
    }

    private boolean isLocalFile() {
        if (this.uri.getScheme() == null || (!this.uri.getScheme().equals("content") && !this.uri.getScheme().equals("file"))) {
            return false;
        }
        if (this.type != null) {
            return true;
        }
        String mimeType = getMimeType(this.uri.toString());
        this.type = mimeType;
        if (mimeType == null) {
            String realPathFromURI = getRealPathFromURI(this.uri);
            if (realPathFromURI == null) {
                return false;
            }
            this.type = getMimeType(realPathFromURI);
        }
        if (this.type == null) {
            this.type = "*/*";
        }
        return true;
    }

    public String getType() {
        String str = this.type;
        return str == null ? "*/*" : str;
    }

    public Uri getURI() {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(getType());
        String fileProviderAuthority = ((MPLApplication) this.reactContext.getApplicationContext()).getFileProviderAuthority();
        if (isBase64File()) {
            String substring = this.uri.getSchemeSpecificPart().substring(this.uri.getSchemeSpecificPart().indexOf(";base64,") + 8);
            try {
                File externalCacheDir = this.reactContext.getExternalCacheDir();
                File file = new File(externalCacheDir, System.currentTimeMillis() + "." + extensionFromMimeType);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(Base64.decode(substring, 0));
                fileOutputStream.flush();
                fileOutputStream.close();
                return FileProvider.getUriForFile(this.reactContext, fileProviderAuthority, file);
            } catch (IOException e2) {
                MLogger.e(TAG, "", e2);
            }
        } else {
            if (isLocalFile()) {
                return FileProvider.getUriForFile(this.reactContext, fileProviderAuthority, new File(Uri.parse(this.url).getPath()));
            }
            return null;
        }
    }

    public boolean isFile() {
        return isBase64File() || isLocalFile();
    }

    public ShareFile(String str, ReactApplicationContext reactApplicationContext) {
        this.url = str;
        this.uri = Uri.parse(str);
        this.reactContext = reactApplicationContext.getApplicationContext();
    }

    public ShareFile(String str, Context context) {
        this.url = str;
        this.uri = Uri.parse(str);
        this.reactContext = context;
    }
}
