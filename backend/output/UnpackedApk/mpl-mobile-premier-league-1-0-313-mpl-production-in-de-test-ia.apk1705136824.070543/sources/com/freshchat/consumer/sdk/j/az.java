package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

public class az {

    public interface a {
        void a(c cVar);

        void fQ();
    }

    public enum b {
        TYPE_IMAGE("image/*");
        
        public String type;

        /* access modifiers changed from: public */
        b(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }
    }

    public enum c {
        INVALID_PARAMS,
        UNKNOWN_TYPE,
        INVALID_TYPE
    }

    public static String V(String str) {
        if (as.isEmpty(str)) {
            return null;
        }
        return str.split("/")[0];
    }

    public static void a(Context context, Uri uri, b bVar, a aVar) {
        if (context == null || uri == null || aVar == null || bVar == null) {
            if (aVar != null) {
                aVar.a(c.INVALID_PARAMS);
            } else {
                ai.e("FRESHCHAT_WARNING", "Invalid parameters. Can not validate Uri.");
            }
            return;
        }
        String e2 = e(context, uri);
        if (as.isEmpty(e2)) {
            aVar.a(c.UNKNOWN_TYPE);
            return;
        }
        if (as.m(V(bVar.getType()), V(e2))) {
            aVar.fQ();
        } else {
            aVar.a(c.INVALID_TYPE);
        }
    }

    public static String e(Context context, Uri uri) {
        String mimeTypeFromExtension;
        if (context == null || uri == null) {
            return null;
        }
        try {
            if (as.m(uri.getScheme(), "content")) {
                mimeTypeFromExtension = context.getContentResolver().getType(uri);
            } else {
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
            }
            return mimeTypeFromExtension;
        } catch (Exception e2) {
            ai.e("FRESHCHAT", e2.toString());
            return null;
        }
    }
}
