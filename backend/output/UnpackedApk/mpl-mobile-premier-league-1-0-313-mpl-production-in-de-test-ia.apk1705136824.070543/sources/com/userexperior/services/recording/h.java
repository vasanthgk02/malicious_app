package com.userexperior.services.recording;

import android.content.Context;
import android.graphics.BitmapFactory.Options;
import com.userexperior.models.recording.c;
import com.userexperior.utilities.a;
import com.userexperior.utilities.j;
import java.lang.ref.WeakReference;

public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4236a = h.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final String f4237b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<c> f4238c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f4239d;

    /* renamed from: e  reason: collision with root package name */
    public final Options f4240e = new Options();

    public h(c cVar, Context context) {
        this.f4238c = new WeakReference<>(cVar);
        context = context == null ? a.a() : context;
        this.f4239d = context;
        this.f4237b = j.i(context);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0162 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            java.lang.ref.WeakReference<com.userexperior.models.recording.c> r0 = r10.f4238c     // Catch:{ Exception -> 0x016a }
            if (r0 == 0) goto L_0x0169
            java.lang.ref.WeakReference<com.userexperior.models.recording.c> r0 = r10.f4238c     // Catch:{ Exception -> 0x016a }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x016a }
            if (r0 == 0) goto L_0x0169
            java.lang.ref.WeakReference<com.userexperior.models.recording.c> r0 = r10.f4238c     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.Object r0 = r0.get()     // Catch:{ OutOfMemoryError -> 0x0162 }
            com.userexperior.models.recording.c r0 = (com.userexperior.models.recording.c) r0     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r0 = r0.f4074a     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.ref.WeakReference<com.userexperior.models.recording.c> r1 = r10.f4238c     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.Object r1 = r1.get()     // Catch:{ OutOfMemoryError -> 0x0162 }
            com.userexperior.models.recording.c r1 = (com.userexperior.models.recording.c) r1     // Catch:{ OutOfMemoryError -> 0x0162 }
            int r1 = r1.f4075b     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 != 0) goto L_0x0032
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r2 = "bitmap "
            r0.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x0162 }
            r0.append(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r1 = " is null"
            r0.append(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            return
        L_0x0032:
            android.graphics.BitmapFactory$Options r2 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            r2.inBitmap = r0     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.io.File r0 = new java.io.File     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0162 }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r3 = r10.f4237b     // Catch:{ OutOfMemoryError -> 0x0162 }
            r2.append(r3)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ OutOfMemoryError -> 0x0162 }
            r2.append(r3)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r3 = "screenshots"
            r2.append(r3)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r2 = r2.toString()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r0.<init>(r2)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.io.File r2 = new java.io.File     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0162 }
            r4.<init>()     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r6 = "img%04d"
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ OutOfMemoryError -> 0x0162 }
            r9 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            r8[r9] = r1     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r1 = java.lang.String.format(r5, r6, r8)     // Catch:{ OutOfMemoryError -> 0x0162 }
            r4.append(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r1 = ".webp"
            r4.append(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r1 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r2.<init>(r3, r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            boolean r1 = r0.exists()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r1 != 0) goto L_0x0093
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r3 = "folder created : "
            r1.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x0162 }
            boolean r0 = r0.mkdirs()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r1.append(r0)     // Catch:{ OutOfMemoryError -> 0x0162 }
        L_0x0093:
            boolean r0 = r2.exists()     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r1 = "Error saveBmP(): "
            if (r0 != 0) goto L_0x00c3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00aa }
            java.lang.String r3 = "file created : "
            r0.<init>(r3)     // Catch:{ IOException -> 0x00aa }
            boolean r3 = r2.createNewFile()     // Catch:{ IOException -> 0x00aa }
            r0.append(r3)     // Catch:{ IOException -> 0x00aa }
            goto L_0x00c3
        L_0x00aa:
            r0 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x0162 }
            r4.<init>(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r5 = r0.getMessage()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r4.append(r5)     // Catch:{ OutOfMemoryError -> 0x0162 }
            java.lang.String r4 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x0162 }
            com.userexperior.utilities.b.a(r3, r4)     // Catch:{ OutOfMemoryError -> 0x0162 }
            r0.printStackTrace()     // Catch:{ OutOfMemoryError -> 0x0162 }
        L_0x00c3:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010b }
            r0.<init>(r2)     // Catch:{ IOException -> 0x010b }
            android.graphics.BitmapFactory$Options r2 = r10.f4240e     // Catch:{ IOException -> 0x010b }
            android.graphics.Bitmap r2 = r2.inBitmap     // Catch:{ IOException -> 0x010b }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ IOException -> 0x010b }
            android.content.Context r4 = r10.f4239d     // Catch:{ IOException -> 0x010b }
            int r4 = com.userexperior.utilities.l.w(r4)     // Catch:{ IOException -> 0x010b }
            if (r4 != r7) goto L_0x00d9
            r4 = 10
            goto L_0x00e1
        L_0x00d9:
            r5 = 2
            if (r4 != r5) goto L_0x00df
            r4 = 50
            goto L_0x00e1
        L_0x00df:
            r4 = 90
        L_0x00e1:
            r2.compress(r3, r4, r0)     // Catch:{ IOException -> 0x010b }
            r0.flush()     // Catch:{ IOException -> 0x010b }
            r0.close()     // Catch:{ IOException -> 0x010b }
            android.graphics.BitmapFactory$Options r0 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 == 0) goto L_0x0142
            android.graphics.BitmapFactory$Options r0 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ OutOfMemoryError -> 0x0162 }
            boolean r0 = r0.isRecycled()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 != 0) goto L_0x0142
            android.app.Activity r0 = com.userexperior.services.recording.i.a()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 == 0) goto L_0x0108
            com.userexperior.services.recording.h$1 r1 = new com.userexperior.services.recording.h$1     // Catch:{ OutOfMemoryError -> 0x0162 }
            r1.<init>()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r0.runOnUiThread(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
        L_0x0108:
            return
        L_0x0109:
            r0 = move-exception
            goto L_0x0143
        L_0x010b:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            r3.<init>(r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0109 }
            r3.append(r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0109 }
            com.userexperior.utilities.b.a(r2, r1)     // Catch:{ all -> 0x0109 }
            r0.getMessage()     // Catch:{ all -> 0x0109 }
            android.graphics.BitmapFactory$Options r0 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 == 0) goto L_0x0142
            android.graphics.BitmapFactory$Options r0 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ OutOfMemoryError -> 0x0162 }
            boolean r0 = r0.isRecycled()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 != 0) goto L_0x0142
            android.app.Activity r0 = com.userexperior.services.recording.i.a()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r0 == 0) goto L_0x0142
            com.userexperior.services.recording.h$1 r1 = new com.userexperior.services.recording.h$1     // Catch:{ OutOfMemoryError -> 0x0162 }
            r1.<init>()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r0.runOnUiThread(r1)     // Catch:{ OutOfMemoryError -> 0x0162 }
        L_0x0142:
            return
        L_0x0143:
            android.graphics.BitmapFactory$Options r1 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r1 = r1.inBitmap     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r1 == 0) goto L_0x0161
            android.graphics.BitmapFactory$Options r1 = r10.f4240e     // Catch:{ OutOfMemoryError -> 0x0162 }
            android.graphics.Bitmap r1 = r1.inBitmap     // Catch:{ OutOfMemoryError -> 0x0162 }
            boolean r1 = r1.isRecycled()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r1 != 0) goto L_0x0161
            android.app.Activity r1 = com.userexperior.services.recording.i.a()     // Catch:{ OutOfMemoryError -> 0x0162 }
            if (r1 == 0) goto L_0x0161
            com.userexperior.services.recording.h$1 r2 = new com.userexperior.services.recording.h$1     // Catch:{ OutOfMemoryError -> 0x0162 }
            r2.<init>()     // Catch:{ OutOfMemoryError -> 0x0162 }
            r1.runOnUiThread(r2)     // Catch:{ OutOfMemoryError -> 0x0162 }
        L_0x0161:
            throw r0     // Catch:{ OutOfMemoryError -> 0x0162 }
        L_0x0162:
            java.util.logging.Level r0 = java.util.logging.Level.INFO     // Catch:{ Exception -> 0x016a }
            java.lang.String r1 = "Out of memory, can't save bitmap....."
            com.userexperior.utilities.b.a(r0, r1)     // Catch:{ Exception -> 0x016a }
        L_0x0169:
            return
        L_0x016a:
            r0 = move-exception
            r0.getMessage()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.h.run():void");
    }
}
