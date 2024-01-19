package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public final class dc {
    public final FutureTask<List<String>> AFInAppEventParameterName;

    public dc(final Context context) {
        this.AFInAppEventParameterName = new FutureTask<>(new Callable<List<String>>() {
            /* access modifiers changed from: private */
            /* renamed from: AFInAppEventType */
            public List<String> call() {
                ArrayList arrayList = new ArrayList();
                try {
                    List<ResolveInfo> queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent("com.appsflyer.oem.PRELOAD_PROVIDER"), 0);
                    if (queryIntentContentProviders != null) {
                        if (!queryIntentContentProviders.isEmpty()) {
                            for (ResolveInfo resolveInfo : queryIntentContentProviders) {
                                String str = resolveInfo.providerInfo.authority;
                                StringBuilder sb = new StringBuilder("content://");
                                sb.append(str);
                                sb.append("/preload_id");
                                Cursor query = context.getContentResolver().query(Uri.parse(sb.toString()), null, null, null, null);
                                if (query != null) {
                                    query.moveToFirst();
                                    arrayList.add(query.getString(query.getColumnIndex("preload_id")));
                                    query.close();
                                }
                            }
                            return arrayList;
                        }
                    }
                    return null;
                } catch (Exception e2) {
                    AFLogger.valueOf(e2.getMessage(), e2);
                }
            }
        });
    }

    public final boolean AFKeystoreWrapper() {
        return this.AFInAppEventParameterName.isDone();
    }

    public final List<String> values() {
        try {
            if (AFKeystoreWrapper()) {
                return this.AFInAppEventParameterName.get();
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        return null;
    }
}
