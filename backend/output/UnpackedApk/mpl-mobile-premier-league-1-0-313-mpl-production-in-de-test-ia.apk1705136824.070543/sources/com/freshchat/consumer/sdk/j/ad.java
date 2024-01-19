package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ad {
    /* JADX INFO: finally extract failed */
    public static String a(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[8192];
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (-1 == read) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            }
            a(inputStream);
            return sb.toString();
        } catch (Throwable th) {
            a(inputStream);
            throw th;
        }
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Exception e2) {
                        ai.e("FRESHCHAT_WARNING", "Failed to close closeable", e2);
                    }
                }
            }
        }
    }

    public static InputStream aE(String str) {
        try {
            return new BufferedInputStream(new FileInputStream(str));
        } catch (Exception e2) {
            ai.e("FRESHCHAT_WARNING", "Exception while reading input stream from File", e2);
            return null;
        }
    }

    public static String aF(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("content://") || !str.startsWith("/")) ? str : GeneratedOutlineSupport.outline50("file:///", str.substring(1, str.length()));
    }

    public static InputStream d(Context context, Uri uri) {
        if (uri != null) {
            try {
                return context.getContentResolver().openInputStream(uri);
            } catch (Exception e2) {
                ai.e("FRESHCHAT_WARNING", "Exception while reading input stream from URI", e2);
            }
        }
        return null;
    }
}
