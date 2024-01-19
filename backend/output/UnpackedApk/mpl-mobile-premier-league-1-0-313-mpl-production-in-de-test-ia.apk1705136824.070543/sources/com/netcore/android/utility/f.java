package com.netcore.android.utility;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.R;
import com.netcore.android.inapp.g;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.mediadownloader.SMTImageDownloader;
import com.netcore.android.network.SMTNetworkUtil;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.userexperior.models.recording.enums.UeCustomType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Regex;

/* compiled from: SMTInAppNativeImageUtility.kt */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1288a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static final f f1289b = new f();

    /* compiled from: SMTInAppNativeImageUtility.kt */
    public interface a {
        void a(com.netcore.android.inapp.h.b bVar, Bitmap bitmap);
    }

    /* compiled from: SMTInAppNativeImageUtility.kt */
    public static final class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f1290a;

        public b(ArrayList arrayList) {
            this.f1290a = arrayList;
        }

        public void run() {
            if (this.f1290a == null) {
                Activity a2 = g.f1213b.a();
                if (a2 != null) {
                    File dir = a2.getDir("smt_in_app_images", 0);
                    if (dir != null) {
                        FilesKt__FileReadWriteKt.deleteRecursively(dir);
                    }
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.netcore.android.inapp.h.b bVar : this.f1290a) {
                arrayList.add(f.f1289b.a(bVar.n().b(), bVar.j(), bVar.i()));
            }
            Activity a3 = g.f1213b.a();
            if (a3 != null) {
                File dir2 = a3.getDir("smt_in_app_images", 0);
                if (dir2 != null) {
                    File[] listFiles = dir2.listFiles();
                    if (listFiles != null) {
                        Iterator it = TweetUtils.iterator(listFiles);
                        while (true) {
                            ArrayIterator arrayIterator = (ArrayIterator) it;
                            if (!arrayIterator.hasNext()) {
                                break;
                            }
                            File file = (File) arrayIterator.next();
                            Intrinsics.checkNotNullExpressionValue(file, "it");
                            if (!arrayList.contains(file.getName())) {
                                arrayList.remove(file.getName());
                                file.delete();
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: SMTInAppNativeImageUtility.kt */
    public static final class c implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.netcore.android.inapp.h.b f1291a;

        public c(com.netcore.android.inapp.h.b bVar) {
            this.f1291a = bVar;
        }

        public final void onClick(View view) {
            if (!CharsKt__CharKt.isBlank(this.f1291a.n().a())) {
                String a2 = this.f1291a.n().a();
                if (!(a2.length() == 0)) {
                    if (new Regex((String) "sms:[0-9]*.&body=(?s:.)*").matches(a2)) {
                        a2 = new Regex((String) "&body").replace(a2, "\\?body");
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a2));
                    Activity a3 = g.f1213b.a();
                    if (a3 != null) {
                        a3.startActivity(intent);
                    }
                }
            }
        }
    }

    /* compiled from: SMTInAppNativeImageUtility.kt */
    public static final class d implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Function0 f1292a;

        public d(Function0 function0) {
            this.f1292a = function0;
        }

        public final void onClick(View view) {
            this.f1292a.invoke();
        }
    }

    /* compiled from: SMTInAppNativeImageUtility.kt */
    public static final class e extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f1293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f1295c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f1296d;

        public e(Bitmap bitmap, String str, String str2, String str3) {
            this.f1293a = bitmap;
            this.f1294b = str;
            this.f1295c = str2;
            this.f1296d = str3;
        }

        public void run() {
            f.f1289b.a(this.f1294b, this.f1295c, this.f1296d, this.f1293a);
        }
    }

    /* renamed from: com.netcore.android.utility.f$f  reason: collision with other inner class name */
    /* compiled from: SMTInAppNativeImageUtility.kt */
    public static final class C0013f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.netcore.android.inapp.h.b f1297a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f1298b;

        /* renamed from: com.netcore.android.utility.f$f$a */
        /* compiled from: SMTInAppNativeImageUtility.kt */
        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Bitmap f1299a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C0013f f1300b;

            public a(Bitmap bitmap, C0013f fVar) {
                this.f1299a = bitmap;
                this.f1300b = fVar;
            }

            public final void run() {
                C0013f fVar = this.f1300b;
                a aVar = fVar.f1298b;
                if (aVar != null) {
                    aVar.a(fVar.f1297a, this.f1299a);
                }
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String a2 = f.f1288a;
                Intrinsics.checkNotNullExpressionValue(a2, UeCustomType.TAG);
                sMTLogger.i(a2, "bitmap loaded");
            }
        }

        public C0013f(com.netcore.android.inapp.h.b bVar, a aVar) {
            this.f1297a = bVar;
            this.f1298b = aVar;
        }

        public void run() {
            Bitmap b2 = f.f1289b.b(this.f1297a.n().b(), this.f1297a.j(), this.f1297a.i());
            if (b2 != null) {
                Activity a2 = g.f1213b.a();
                if (a2 != null) {
                    a2.runOnUiThread(new a(b2, this));
                }
            }
        }
    }

    public final Bitmap b(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        Intrinsics.checkNotNullParameter(str3, "id");
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            File dir = a2.getDir("smt_in_app_images", 0);
            if (dir != null) {
                File file = new File(dir, f1289b.a(str, str2, str3));
                if (dir.exists() && file.isFile()) {
                    return BitmapFactory.decodeStream(new FileInputStream(file));
                }
            }
            Bitmap a3 = f1289b.a(str);
            if (a3 != null) {
                new e(a3, str, str2, str3).start();
                return a3;
            }
        }
        return null;
    }

    public final String a(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str3, "id");
        boolean z = true;
        if (str.length() == 0) {
            return str;
        }
        if (!(str2 == null || str2.length() == 0)) {
            z = false;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append('-');
            String substring = str.substring(0, CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) ".", 0, false, 6));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(new Regex((String) "[^a-zA-Z0-9]").replace(substring, ""));
            String substring2 = str.substring(CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) ".", 0, false, 6));
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append('-');
        sb2.append(str3);
        sb2.append('-');
        String substring3 = str.substring(0, CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) ".", 0, false, 6));
        Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb2.append(new Regex((String) "[^a-zA-Z0-9]").replace(substring3, ""));
        String substring4 = str.substring(CharsKt__CharKt.lastIndexOf$default((CharSequence) str, (String) ".", 0, false, 6));
        Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.String).substring(startIndex)");
        sb2.append(substring4);
        return sb2.toString();
    }

    public final void a(com.netcore.android.inapp.h.b bVar, PopupWindow popupWindow, a aVar) {
        Intrinsics.checkNotNullParameter(bVar, "identifiedRule");
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = f1288a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.d(str, "popupWindowRef: " + popupWindow);
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        if (g.f1213b.a() != null) {
            try {
                new C0013f(bVar, aVar).start();
            } catch (Exception e2) {
                SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                String str2 = f1288a;
                GeneratedOutlineSupport.outline96(str2, UeCustomType.TAG, e2, sMTLogger2, str2);
            }
        }
    }

    private final Bitmap a(String str) {
        Activity a2 = g.f1213b.a();
        if (a2 != null) {
            SMTNetworkUtil sMTNetworkUtil = SMTNetworkUtil.INSTANCE;
            if (!sMTNetworkUtil.hasInternetConnection(a2) || !sMTNetworkUtil.hasInternetConnectionAvailable(a2)) {
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str2 = f1288a;
                Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                sMTLogger.i(str2, "Network connection is not available.");
            } else {
                try {
                    SMTImageDownloader sMTImageDownloader = new SMTImageDownloader(a2, str, "", false, 8, null);
                    return sMTImageDownloader.downloadBitmap();
                } catch (IOException e2) {
                    SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                    String str3 = f1288a;
                    Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                    sMTLogger2.e(str3, String.valueOf(e2.getMessage()));
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, java.lang.String r6, java.lang.String r7, android.graphics.Bitmap r8) {
        /*
            r4 = this;
            java.lang.String r0 = "imageUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.netcore.android.inapp.g$a r0 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x0051 }
            android.app.Activity r0 = r0.a()     // Catch:{ Exception -> 0x0051 }
            r1 = 0
            if (r0 == 0) goto L_0x0020
            java.lang.String r2 = "smt_in_app_images"
            r3 = 0
            java.io.File r0 = r0.getDir(r2, r3)     // Catch:{ Exception -> 0x0051 }
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            if (r0 == 0) goto L_0x005b
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x0051 }
            if (r2 != 0) goto L_0x002c
            r0.mkdir()     // Catch:{ Exception -> 0x0051 }
        L_0x002c:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0051 }
            com.netcore.android.utility.f r3 = f1289b     // Catch:{ Exception -> 0x0051 }
            java.lang.String r5 = r3.a(r5, r6, r7)     // Catch:{ Exception -> 0x0051 }
            r2.<init>(r0, r5)     // Catch:{ Exception -> 0x0051 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0051 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0051 }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x004a }
            r7 = 100
            r8.compress(r6, r7, r5)     // Catch:{ all -> 0x004a }
            r5.close()     // Catch:{ all -> 0x004a }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r1)     // Catch:{ Exception -> 0x0051 }
            goto L_0x005b
        L_0x004a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x004c }
        L_0x004c:
            r7 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r6)     // Catch:{ Exception -> 0x0051 }
            throw r7     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            r5 = move-exception
            com.netcore.android.logger.SMTLogger r6 = com.netcore.android.logger.SMTLogger.INSTANCE
            java.lang.String r7 = f1288a
            java.lang.String r8 = "TAG"
            com.android.tools.r8.GeneratedOutlineSupport.outline96(r7, r8, r5, r6, r7)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.utility.f.a(java.lang.String, java.lang.String, java.lang.String, android.graphics.Bitmap):void");
    }

    public final View a(Activity activity, com.netcore.android.inapp.h.b bVar, Bitmap bitmap, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bVar, "identifiedRule");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(function0, "dismissPopup");
        Object systemService = activity.getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.inapp_image_popup, null);
            Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R….inapp_image_popup, null)");
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ivBackground);
            imageView.setImageBitmap(bitmap);
            imageView.setOnClickListener(new c(bVar));
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.ivClose);
            Intrinsics.checkNotNullExpressionValue(imageView2, "ivClose");
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new d(function0));
            return inflate;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public final void a(ArrayList<com.netcore.android.inapp.h.b> arrayList) {
        try {
            new b(arrayList).start();
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = f1288a;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
    }
}
