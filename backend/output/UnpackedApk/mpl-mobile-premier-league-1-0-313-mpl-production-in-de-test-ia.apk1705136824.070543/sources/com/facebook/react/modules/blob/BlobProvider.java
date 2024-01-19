package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.ReactApplication;
import java.io.FileNotFoundException;

public final class BlobProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        if (str.equals("r")) {
            Context applicationContext = getContext().getApplicationContext();
            if (!(applicationContext instanceof ReactApplication)) {
                throw new RuntimeException("No blob module associated with BlobProvider");
            }
            ((ReactApplication) applicationContext).getReactNativeHost();
            throw null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cannot open ");
        outline73.append(uri.toString());
        outline73.append(" in mode '");
        outline73.append(str);
        outline73.append("'");
        throw new FileNotFoundException(outline73.toString());
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
