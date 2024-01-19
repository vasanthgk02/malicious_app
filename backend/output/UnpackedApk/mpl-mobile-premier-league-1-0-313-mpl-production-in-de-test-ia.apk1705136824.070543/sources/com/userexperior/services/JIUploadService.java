package com.userexperior.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.JobIntentService;
import com.userexperior.UserExperior;
import com.userexperior.c.c.c;
import com.userexperior.c.c.d;
import com.userexperior.c.c.f;
import com.userexperior.utilities.b;
import com.userexperior.utilities.l;
import java.util.logging.Level;
import org.eclipse.paho.android.service.MqttServiceConstants;

public class JIUploadService extends JobIntentService {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4097a = JIUploadService.class.getSimpleName();

    public static void a(Context context, d dVar) {
        Level level;
        String str;
        StringBuilder sb;
        try {
            Intent intent = new Intent();
            intent.setAction(c.UPLOAD_CRASH_DATA.toString());
            dVar.f3884a = UserExperior.getUeSdkAppVersionKey();
            dVar.f3886c = l.f(context);
            Bundle bundle = new Bundle();
            bundle.putParcelable("upload_crash_data", dVar);
            intent.putExtras(bundle);
            JobIntentService.enqueueWork(context, JIUploadService.class, 1000, intent);
        } catch (Exception e2) {
            level = Level.INFO;
            sb = new StringBuilder("issue at jius: uc = ");
            str = e2.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (Error e3) {
            level = Level.INFO;
            sb = new StringBuilder("issue at jius: uc = ");
            str = e3.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        }
    }

    public static void a(Context context, f fVar, boolean z) {
        StringBuilder sb;
        Level level;
        String str;
        try {
            Intent intent = new Intent();
            intent.setAction(c.UPLOAD_DATA.toString());
            if (fVar != null) {
                fVar.f3892a = UserExperior.getUeSdkAppVersionKey();
                Bundle bundle = new Bundle();
                bundle.putParcelable("upload_data", fVar);
                bundle.putBoolean(MqttServiceConstants.TRACE_EXCEPTION, z);
                intent.putExtras(bundle);
                new StringBuilder("number of file size ").append(fVar.f3893b != null ? fVar.f3893b.size() : 0);
                JobIntentService.enqueueWork(context, JIUploadService.class, 1000, intent);
            }
        } catch (Exception e2) {
            level = Level.INFO;
            sb = new StringBuilder("issue at jius: uc = ");
            str = e2.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (Error e3) {
            level = Level.INFO;
            sb = new StringBuilder("issue at jius: uc = ");
            str = e3.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        }
    }

    public static void b(Context context, d dVar) {
        Level level;
        String str;
        StringBuilder sb;
        try {
            Intent intent = new Intent();
            intent.setAction(c.UPLOAD_ANR_DATA.toString());
            dVar.f3884a = UserExperior.getUeSdkAppVersionKey();
            dVar.f3886c = l.f(context);
            Bundle bundle = new Bundle();
            bundle.putParcelable("upload_anr_data", dVar);
            intent.putExtras(bundle);
            JobIntentService.enqueueWork(context, JIUploadService.class, 1000, intent);
        } catch (Exception e2) {
            level = Level.INFO;
            sb = new StringBuilder("issue at jius: uc = ");
            str = e2.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        } catch (Error e3) {
            level = Level.INFO;
            sb = new StringBuilder("issue at jius: uc = ");
            str = e3.getMessage();
            sb.append(str);
            b.a(level, sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e7, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        new java.lang.StringBuilder("Error while uploading: ").append(r12.getMessage());
        r0 = java.util.logging.Level.SEVERE;
        com.userexperior.utilities.b.a(r0, "Error while u z: " + r12.getMessage());
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010d, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010e, code lost:
        new java.lang.StringBuilder("Error while uploading: ").append(r12.getMessage());
        r0 = java.util.logging.Level.SEVERE;
        com.userexperior.utilities.b.a(r0, "Error while u z: " + r12.getMessage());
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015a, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        new java.lang.StringBuilder("Error while c uploading: ").append(r12.getMessage());
        r0 = java.util.logging.Level.SEVERE;
        com.userexperior.utilities.b.a(r0, "Error while u c: " + r12.getMessage());
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0180, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0181, code lost:
        new java.lang.StringBuilder("Error while c uploading: ").append(r12.getMessage());
        r0 = java.util.logging.Level.SEVERE;
        com.userexperior.utilities.b.a(r0, "Error while u c: " + r12.getMessage());
        r12.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0228, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        r0 = java.util.logging.Level.INFO;
        r1 = new java.lang.StringBuilder("ohw: ");
        r12 = r12.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0235, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0236, code lost:
        r0 = java.util.logging.Level.INFO;
        r1 = new java.lang.StringBuilder("ohw: ");
        r12 = r12.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0241, code lost:
        r1.append(r12);
        com.userexperior.utilities.b.a(r0, r1.toString());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0228 A[ExcHandler: Error (r12v5 'e' java.lang.Error A[CUSTOM_DECLARE]), Splitter:B:2:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleWork(android.content.Intent r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Error while u a: "
            java.lang.String r1 = "Error while u c: "
            java.lang.String r2 = "Error while a uploading: "
            java.lang.String r3 = "Error while c uploading: "
            java.lang.String r4 = "ohw: "
            if (r12 == 0) goto L_0x024b
            java.lang.String r5 = r12.getAction()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r5 == 0) goto L_0x024b
            com.userexperior.b.a r5 = com.userexperior.b.a.a()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.services.recording.f r6 = com.userexperior.services.recording.f.g()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r6)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r6 = r12.getAction()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.c.c.c r7 = com.userexperior.c.c.c.UPLOAD_DATA     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r6 == 0) goto L_0x0133
            android.os.Bundle r12 = r12.getExtras()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r12 == 0) goto L_0x024b
            java.lang.String r0 = "upload_data"
            android.os.Parcelable r0 = r12.getParcelable(r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r1 = r0 instanceof com.userexperior.c.c.f     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r1 == 0) goto L_0x0132
            com.userexperior.c.c.f r0 = (com.userexperior.c.c.f) r0     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.List<com.userexperior.c.c.e> r1 = r0.f3893b     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2 = 0
            if (r1 == 0) goto L_0x00a6
            java.util.List<com.userexperior.c.c.e> r1 = r0.f3893b     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
        L_0x004b:
            r3 = 0
        L_0x004c:
            boolean r6 = r1.hasNext()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r6 = r1.next()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.c.c.e r6 = (com.userexperior.c.c.e) r6     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r7 = r6.f3889a     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r7 == 0) goto L_0x004c
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r8 = r3.exists()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r8 == 0) goto L_0x0098
            boolean r8 = r3.isFile()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r8 == 0) goto L_0x0098
            java.lang.String r8 = r3.getName()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r9 = ".zip"
            boolean r8 = r8.endsWith(r9)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r8 == 0) goto L_0x0098
            com.userexperior.models.recording.enums.d r6 = r6.f3890b     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.models.recording.enums.d r7 = com.userexperior.models.recording.enums.d.USER_SCREEN_SHOTS     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r6 != r7) goto L_0x0096
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r7 = "zip size :"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            long r7 = r3.length()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r9 = 1024(0x400, double:5.06E-321)
            long r7 = r7 / r9
            r6.append(r7)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r3 = " KB"
            r6.append(r3)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
        L_0x0096:
            r3 = 1
            goto L_0x004c
        L_0x0098:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r3.<init>()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r3.append(r7)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r6 = " does not exists"
            r3.append(r6)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            goto L_0x004b
        L_0x00a6:
            r3 = 0
        L_0x00a7:
            if (r3 == 0) goto L_0x0132
            java.lang.String r1 = "exception"
            boolean r12 = r12.getBoolean(r1, r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = "Error while u z: "
            java.lang.String r2 = "Error while uploading: "
            if (r12 == 0) goto L_0x00e3
            java.lang.Thread.currentThread()     // Catch:{ InterruptedException -> 0x00c8, Exception -> 0x00c3, Error -> 0x00be }
            r6 = 2000(0x7d0, double:9.88E-321)
            java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x00c8, Exception -> 0x00c3, Error -> 0x00be }
            goto L_0x00e3
        L_0x00be:
            r12 = move-exception
            r12.getMessage()     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            goto L_0x00e3
        L_0x00c3:
            r12 = move-exception
            r12.getMessage()     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            goto L_0x00e3
        L_0x00c8:
            r12 = move-exception
            java.util.logging.Level r3 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            java.lang.String r7 = "Error checkAndWait(): "
            r6.<init>(r7)     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            java.lang.String r7 = r12.getMessage()     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            r6.append(r7)     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r3, r6)     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
        L_0x00e3:
            r5.a(r0)     // Catch:{ Exception -> 0x010d, OutOfMemoryError -> 0x00e7, Error -> 0x0228 }
            return
        L_0x00e7:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r2 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.append(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.append(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r0, r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            goto L_0x0132
        L_0x010d:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r2 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.append(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.append(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r0, r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
        L_0x0132:
            return
        L_0x0133:
            java.lang.String r6 = r12.getAction()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.c.c.c r7 = com.userexperior.c.c.c.UPLOAD_CRASH_DATA     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r6 == 0) goto L_0x01a6
            android.os.Bundle r12 = r12.getExtras()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r12 == 0) goto L_0x024b
            java.lang.String r0 = "upload_crash_data"
            android.os.Parcelable r12 = r12.getParcelable(r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r0 = r12 instanceof com.userexperior.c.c.d     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r0 == 0) goto L_0x01a5
            com.userexperior.c.c.d r12 = (com.userexperior.c.c.d) r12     // Catch:{ Exception -> 0x0180, OutOfMemoryError -> 0x015a, Error -> 0x0228 }
            r5.a(r12)     // Catch:{ Exception -> 0x0180, OutOfMemoryError -> 0x015a, Error -> 0x0228 }
            return
        L_0x015a:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r2 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.append(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.append(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r0, r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            goto L_0x01a5
        L_0x0180:
            r12 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r2 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.append(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.logging.Level r0 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.append(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r0, r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
        L_0x01a5:
            return
        L_0x01a6:
            java.lang.String r1 = r12.getAction()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.c.c.c r3 = com.userexperior.c.c.c.UPLOAD_ANR_DATA     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r1 == 0) goto L_0x0219
            android.os.Bundle r12 = r12.getExtras()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r12 == 0) goto L_0x024b
            java.lang.String r1 = "upload_anr_data"
            android.os.Parcelable r12 = r12.getParcelable(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            boolean r1 = r12 instanceof com.userexperior.c.c.d     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            if (r1 == 0) goto L_0x0218
            com.userexperior.c.c.d r12 = (com.userexperior.c.c.d) r12     // Catch:{ Exception -> 0x01f3, OutOfMemoryError -> 0x01cd, Error -> 0x0228 }
            r5.b(r12)     // Catch:{ Exception -> 0x01f3, OutOfMemoryError -> 0x01cd, Error -> 0x0228 }
            return
        L_0x01cd:
            r12 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r2 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r1.append(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r0 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.append(r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r1, r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            goto L_0x0218
        L_0x01f3:
            r12 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r2 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r1.append(r2)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r0 = r12.getMessage()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r2.append(r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            com.userexperior.utilities.b.a(r1, r0)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r12.printStackTrace()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
        L_0x0218:
            return
        L_0x0219:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r1 = "action not supported: "
            r0.<init>(r1)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            java.lang.String r12 = r12.getAction()     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            r0.append(r12)     // Catch:{ Exception -> 0x0235, Error -> 0x0228 }
            goto L_0x024b
        L_0x0228:
            r12 = move-exception
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r12 = r12.getMessage()
            goto L_0x0241
        L_0x0235:
            r12 = move-exception
            java.util.logging.Level r0 = java.util.logging.Level.INFO
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r12 = r12.getMessage()
        L_0x0241:
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            com.userexperior.utilities.b.a(r0, r12)
        L_0x024b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.JIUploadService.onHandleWork(android.content.Intent):void");
    }
}
