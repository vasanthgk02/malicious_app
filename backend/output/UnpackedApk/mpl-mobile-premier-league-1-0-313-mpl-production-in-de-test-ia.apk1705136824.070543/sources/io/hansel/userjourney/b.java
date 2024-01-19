package io.hansel.userjourney;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.network.request.HSLServerRequest;
import io.hansel.core.network.request.HSLServerResponseHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class b implements HSLServerResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5409a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5410b;

    /* renamed from: c  reason: collision with root package name */
    public final IMessageBroker f5411c;

    /* renamed from: d  reason: collision with root package name */
    public final c f5412d;

    public b(Context context, String str, IMessageBroker iMessageBroker, c cVar) {
        this.f5409a = context;
        this.f5410b = str;
        this.f5411c = iMessageBroker;
        this.f5412d = cVar;
    }

    private void a(InputStream inputStream, String str, File file) {
        FileOutputStream fileOutputStream;
        HSLLogger.d("Saving Media file");
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        HSLLogger.d("Is file saved $fileSaved");
                        try {
                            fileOutputStream.close();
                            HSLLogger.d(GeneratedOutlineSupport.outline50("Successfully downloaded image:  ", str), LogGroup.OT);
                            return;
                        } catch (Exception e2) {
                            HSLLogger.e(e2.getMessage());
                            throw e2;
                        }
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
            } catch (Throwable th) {
                th = th;
                try {
                    fileOutputStream.close();
                    throw th;
                } catch (Exception e4) {
                    HSLLogger.e(e4.getMessage());
                    throw e4;
                }
            }
        } catch (Exception e5) {
            e = e5;
            try {
                HSLLogger.d("Saving media file save failed ${e.localizedMessage}");
                throw e;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                fileOutputStream.close();
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0090 A[Catch:{ Exception -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096 A[Catch:{ Exception -> 0x012e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseResponse(io.hansel.core.network.request.HSLServerRequest r7, java.io.InputStream r8, int r9) {
        /*
            r6 = this;
            android.content.Context r7 = r6.f5409a     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "IMAGES"
            r1 = 0
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r0, r1)     // Catch:{ Exception -> 0x012e }
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 != r0) goto L_0x0108
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r0.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r2 = "ImageResponseHandler:  "
            r0.append(r2)     // Catch:{ Exception -> 0x012e }
            r0.append(r9)     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = r0.toString()     // Catch:{ Exception -> 0x012e }
            io.hansel.core.logger.HSLLogger.d(r9)     // Catch:{ Exception -> 0x012e }
            android.content.ContextWrapper r9 = new android.content.ContextWrapper     // Catch:{ Exception -> 0x012e }
            android.content.Context r0 = r6.f5409a     // Catch:{ Exception -> 0x012e }
            r9.<init>(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "HSLImages"
            java.io.File r9 = r9.getDir(r0, r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = r6.f5410b     // Catch:{ Exception -> 0x012e }
            java.lang.String r2 = ""
            java.lang.String r0 = r7.getString(r0, r2)     // Catch:{ Exception -> 0x012e }
            if (r0 != 0) goto L_0x0041
            java.util.Map r0 = r7.getAll()     // Catch:{ Exception -> 0x012e }
            int r0 = r0.size()     // Catch:{ Exception -> 0x012e }
            goto L_0x004d
        L_0x0041:
            java.lang.String r2 = "__"
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x012e }
            r0 = r0[r1]     // Catch:{ Exception -> 0x012e }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x012e }
        L_0x004d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r2.<init>()     // Catch:{ Exception -> 0x012e }
            r2.append(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = ".jpg"
            r2.append(r3)     // Catch:{ Exception -> 0x012e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x012e }
            io.hansel.userjourney.c r3 = r6.f5412d     // Catch:{ Exception -> 0x012e }
            io.hansel.userjourney.c r4 = io.hansel.userjourney.c.PNG     // Catch:{ Exception -> 0x012e }
            if (r3 != r4) goto L_0x0072
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r2.<init>()     // Catch:{ Exception -> 0x012e }
            r2.append(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = ".png"
        L_0x006e:
            r2.append(r0)     // Catch:{ Exception -> 0x012e }
            goto L_0x0081
        L_0x0072:
            io.hansel.userjourney.c r5 = io.hansel.userjourney.c.GIF     // Catch:{ Exception -> 0x012e }
            if (r3 != r5) goto L_0x0085
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r2.<init>()     // Catch:{ Exception -> 0x012e }
            r2.append(r0)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = ".gif"
            goto L_0x006e
        L_0x0081:
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x012e }
        L_0x0085:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x012e }
            r0.<init>(r9, r2)     // Catch:{ Exception -> 0x012e }
            io.hansel.userjourney.c r9 = r6.f5412d     // Catch:{ Exception -> 0x012e }
            io.hansel.userjourney.c r3 = io.hansel.userjourney.c.GIF     // Catch:{ Exception -> 0x012e }
            if (r9 != r3) goto L_0x0096
            java.lang.String r9 = r6.f5410b     // Catch:{ Exception -> 0x012e }
            r6.a(r8, r9, r0)     // Catch:{ Exception -> 0x012e }
            goto L_0x00c4
        L_0x0096:
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r8)     // Catch:{ Exception -> 0x012e }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x012e }
            r3.<init>()     // Catch:{ Exception -> 0x012e }
            io.hansel.userjourney.c r5 = r6.f5412d     // Catch:{ Exception -> 0x012e }
            if (r5 != r4) goto L_0x00ab
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x012e }
            r5 = 100
            r9.compress(r4, r5, r3)     // Catch:{ Exception -> 0x012e }
            goto L_0x00b2
        L_0x00ab:
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x012e }
            r5 = 10
            r9.compress(r4, r5, r3)     // Catch:{ Exception -> 0x012e }
        L_0x00b2:
            byte[] r9 = r3.toByteArray()     // Catch:{ Exception -> 0x012e }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x012e }
            r3.<init>(r0)     // Catch:{ Exception -> 0x012e }
            r3.write(r9)     // Catch:{ Exception -> 0x012e }
            r3.flush()     // Catch:{ Exception -> 0x012e }
            r3.close()     // Catch:{ Exception -> 0x012e }
        L_0x00c4:
            r8.close()     // Catch:{ Exception -> 0x012e }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ Exception -> 0x012e }
            java.lang.String r8 = r6.f5410b     // Catch:{ Exception -> 0x012e }
            java.lang.String r9 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x012e }
            android.content.SharedPreferences$Editor r7 = r7.putString(r8, r9)     // Catch:{ Exception -> 0x012e }
            r7.apply()     // Catch:{ Exception -> 0x012e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r7.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r8 = "Successfully downloaded image:  "
            r7.append(r8)     // Catch:{ Exception -> 0x012e }
            java.lang.String r8 = r6.f5410b     // Catch:{ Exception -> 0x012e }
            r7.append(r8)     // Catch:{ Exception -> 0x012e }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x012e }
            io.hansel.core.logger.LogGroup r8 = io.hansel.core.logger.LogGroup.OT     // Catch:{ Exception -> 0x012e }
            io.hansel.core.logger.HSLLogger.d(r7, r8)     // Catch:{ Exception -> 0x012e }
            io.hansel.core.module.IMessageBroker r7 = r6.f5411c     // Catch:{ Exception -> 0x012e }
            io.hansel.core.module.EventsConstants r8 = io.hansel.core.module.EventsConstants.IMAGE_DOWNLOADED     // Catch:{ Exception -> 0x012e }
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x012e }
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ Exception -> 0x012e }
            r9[r1] = r2     // Catch:{ Exception -> 0x012e }
            r1 = 1
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x012e }
            r9[r1] = r0     // Catch:{ Exception -> 0x012e }
            r7.publishEvent(r8, r9)     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x0108:
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ Exception -> 0x012e }
            java.lang.String r8 = r6.f5410b     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = "__HSL_FAILED"
            android.content.SharedPreferences$Editor r7 = r7.putString(r8, r0)     // Catch:{ Exception -> 0x012e }
            r7.apply()     // Catch:{ Exception -> 0x012e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r7.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r8 = "Image Download issue with response code:  "
            r7.append(r8)     // Catch:{ Exception -> 0x012e }
            r7.append(r9)     // Catch:{ Exception -> 0x012e }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x012e }
            io.hansel.core.logger.LogGroup r8 = io.hansel.core.logger.LogGroup.OT     // Catch:{ Exception -> 0x012e }
            io.hansel.core.logger.HSLLogger.w(r7, r8)     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x012e:
            r7 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r7)
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.b.parseResponse(io.hansel.core.network.request.HSLServerRequest, java.io.InputStream, int):void");
    }

    public void parseResponse(HSLServerRequest hSLServerRequest, String str, int i) {
    }
}
