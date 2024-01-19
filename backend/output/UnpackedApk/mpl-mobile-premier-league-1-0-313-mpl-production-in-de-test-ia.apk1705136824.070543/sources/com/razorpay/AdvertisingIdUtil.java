package com.razorpay;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.LinkedBlockingQueue;

public class AdvertisingIdUtil {
    public static String R$$r_ = "permission disabled";

    /* renamed from: com.razorpay.AdvertisingIdUtil$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 implements Serializable {
        public static File a_$P$;
        public String G__G_;
        public long R$$r_;

        public AnonymousClass1(String str, long j) {
            this.G__G_ = str;
            this.R$$r_ = j;
        }

        public static void R$$r_(String str, String str2, long j) {
            File file = new File(a_$P$.getPath(), str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e2) {
                    AnalyticsUtil.reportError(e2, "error", e2.getMessage());
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                AnonymousClass1 r3 = new AnonymousClass1(str2, j + System.currentTimeMillis());
                objectOutputStream.writeObject(r3);
                objectOutputStream.close();
                fileOutputStream.close();
                String.format("%s stored successfully in cache with expiry time of %d", new Object[]{str, Long.valueOf(r3.R$$r_)});
                "Cache value: ".concat(String.valueOf(str2));
            } catch (Exception e3) {
                AnalyticsUtil.reportError(e3, "error", e3.getMessage());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0040 A[Catch:{ Exception -> 0x0054 }] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A[Catch:{ Exception -> 0x0054 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean d__1_(java.lang.String r7) {
            /*
                java.io.File r0 = new java.io.File
                java.io.File r1 = a_$P$
                java.lang.String r1 = r1.getPath()
                r0.<init>(r1, r7)
                boolean r1 = r0.exists()
                r2 = 1
                if (r1 != 0) goto L_0x0013
                return r2
            L_0x0013:
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0054 }
                r1.<init>(r0)     // Catch:{ Exception -> 0x0054 }
                java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0054 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x0054 }
                java.lang.Object r3 = r0.readObject()     // Catch:{ Exception -> 0x0054 }
                com.razorpay.AdvertisingIdUtil$1 r3 = (com.razorpay.AdvertisingIdUtil.AnonymousClass1) r3     // Catch:{ Exception -> 0x0054 }
                r1.close()     // Catch:{ Exception -> 0x0054 }
                r0.close()     // Catch:{ Exception -> 0x0054 }
                long r0 = r3.R$$r_     // Catch:{ Exception -> 0x0054 }
                r3 = 0
                r5 = 0
                int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r6 <= 0) goto L_0x003d
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0054 }
                int r6 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x003b
                goto L_0x003d
            L_0x003b:
                r0 = 0
                goto L_0x003e
            L_0x003d:
                r0 = 1
            L_0x003e:
                if (r0 != 0) goto L_0x004a
                java.lang.String r0 = "Cache has NOT expired for key "
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0054 }
                r0.concat(r7)     // Catch:{ Exception -> 0x0054 }
                return r5
            L_0x004a:
                java.lang.String r0 = "Cache has expired for key "
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0054 }
                r0.concat(r7)     // Catch:{ Exception -> 0x0054 }
                return r2
            L_0x0054:
                r7 = move-exception
                java.lang.String r0 = r7.getMessage()
                java.lang.String r1 = "warning"
                com.razorpay.AnalyticsUtil.reportError(r7, r1, r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.razorpay.AdvertisingIdUtil.AnonymousClass1.d__1_(java.lang.String):boolean");
        }

        public AnonymousClass1() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[Catch:{ Exception -> 0x005c }] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0050 A[Catch:{ Exception -> 0x005c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String R$$r_(java.lang.String r9) {
            /*
                java.io.File r0 = new java.io.File
                java.io.File r1 = a_$P$
                java.lang.String r1 = r1.getPath()
                r0.<init>(r1, r9)
                boolean r1 = r0.exists()
                r2 = 0
                if (r1 != 0) goto L_0x0013
                return r2
            L_0x0013:
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005c }
                r1.<init>(r0)     // Catch:{ Exception -> 0x005c }
                java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x005c }
                r0.<init>(r1)     // Catch:{ Exception -> 0x005c }
                java.lang.Object r3 = r0.readObject()     // Catch:{ Exception -> 0x005c }
                com.razorpay.AdvertisingIdUtil$1 r3 = (com.razorpay.AdvertisingIdUtil.AnonymousClass1) r3     // Catch:{ Exception -> 0x005c }
                r1.close()     // Catch:{ Exception -> 0x005c }
                r0.close()     // Catch:{ Exception -> 0x005c }
                long r0 = r3.R$$r_     // Catch:{ Exception -> 0x005c }
                r4 = 0
                r6 = 0
                r7 = 1
                int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r8 <= 0) goto L_0x003e
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005c }
                int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r8 <= 0) goto L_0x003c
                goto L_0x003e
            L_0x003c:
                r0 = 0
                goto L_0x003f
            L_0x003e:
                r0 = 1
            L_0x003f:
                if (r0 != r7) goto L_0x0050
                java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005c }
                java.io.File r1 = a_$P$     // Catch:{ Exception -> 0x005c }
                java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x005c }
                r0.<init>(r1, r9)     // Catch:{ Exception -> 0x005c }
                r0.delete()     // Catch:{ Exception -> 0x005c }
                return r2
            L_0x0050:
                java.lang.String r0 = "%s fetched successfully from cache"
                java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x005c }
                r1[r6] = r9     // Catch:{ Exception -> 0x005c }
                java.lang.String.format(r0, r1)     // Catch:{ Exception -> 0x005c }
                java.lang.String r9 = r3.G__G_     // Catch:{ Exception -> 0x005c }
                return r9
            L_0x005c:
                r9 = move-exception
                java.lang.String r0 = r9.getMessage()
                java.lang.String r1 = "warning"
                com.razorpay.AnalyticsUtil.reportError(r9, r1, r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.razorpay.AdvertisingIdUtil.AnonymousClass1.R$$r_(java.lang.String):java.lang.String");
        }
    }

    public static final class G__G_ implements ServiceConnection {
        public final LinkedBlockingQueue<IBinder> G__G_;
        public boolean R$$r_;

        public G__G_() {
            this.R$$r_ = false;
            this.G__G_ = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a_$P$() throws InterruptedException {
            if (!this.R$$r_) {
                this.R$$r_ = true;
                return this.G__G_.take();
            }
            throw new IllegalStateException();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.G__G_.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ G__G_(byte b2) {
            this();
        }
    }

    public interface d__1_ {
        void Q_$2$(String str);
    }

    public static void Q_$2$(Context context, d__1_ d__1_2) {
        new AdvertisingIdUtil$R$$r_(context, d__1_2).execute(new Void[0]);
    }
}
