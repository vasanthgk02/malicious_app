package com.freshchat.consumer.sdk.i;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.freshchat.consumer.sdk.j.a.d;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class a extends AsyncTask<Uri, Void, Bitmap> {
    public static String TAG = a.class.getName();
    public final Context context;
    public final WeakReference<ImageView> gS;
    public final WeakReference<com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.a> gT;
    public final int gU;
    public final WeakReference<com.freshchat.consumer.sdk.f.a> lm;

    public a(Context context2, ImageView imageView, int i, com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.a aVar, com.freshchat.consumer.sdk.f.a aVar2) {
        this.gS = new WeakReference<>(imageView);
        this.gU = i;
        this.context = context2.getApplicationContext();
        this.gT = new WeakReference<>(aVar);
        this.lm = new WeakReference<>(aVar2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(android.net.Uri r9) {
        /*
            r8 = this;
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Handling URI "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.freshchat.consumer.sdk.j.ai.d(r0, r1)
            java.io.InputStream r9 = r8.b(r9)
            android.content.Context r0 = r8.context
            int r0 = com.freshchat.consumer.sdk.j.p.cq(r0)
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r2 = 1
            r1.inJustDecodeBounds = r2
            r3 = 0
            android.graphics.BitmapFactory.decodeStream(r9, r3, r1)
            int r3 = r1.outWidth
            int r1 = r1.outHeight
            java.lang.String r4 = TAG
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Orig "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r6 = " "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.freshchat.consumer.sdk.j.ai.d(r4, r5)
            long r4 = (long) r0
            r6 = 2073600(0x1fa400, double:1.0244945E-317)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x005c
        L_0x0056:
            int r3 = r3 * r1
            long r0 = (long) r3
            long r0 = r0 / r6
        L_0x005a:
            double r0 = (double) r0
            goto L_0x006c
        L_0x005c:
            r6 = 921600(0xe1000, double:4.55331E-318)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0064
            goto L_0x0056
        L_0x0064:
            int r3 = r3 * r1
            long r0 = (long) r3
            r3 = 409920(0x64140, double:2.025274E-318)
            long r0 = r0 / r3
            goto L_0x005a
        L_0x006c:
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0074
            r0 = 1
            goto L_0x007d
        L_0x0074:
            r3 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x007c
            r0 = 2
            goto L_0x007d
        L_0x007c:
            r0 = 4
        L_0x007d:
            java.lang.String r1 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Calculated scale "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.freshchat.consumer.sdk.j.ai.d(r1, r3)
            java.io.Closeable[] r1 = new java.io.Closeable[r2]
            r2 = 0
            r1[r2] = r9
            com.freshchat.consumer.sdk.j.ad.a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.i.a.a(android.net.Uri):int");
    }

    private com.freshchat.consumer.sdk.f.a fu() {
        WeakReference<com.freshchat.consumer.sdk.f.a> weakReference = this.lm;
        if (weakReference != null) {
            return (com.freshchat.consumer.sdk.f.a) weakReference.get();
        }
        return null;
    }

    public InputStream b(Uri uri) {
        return this.gU == 126 ? ad.aE(uri.getPath()) : ad.d(this.context, uri);
    }

    public Bitmap doInBackground(Uri... uriArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Uri[] uriArr2 = uriArr;
        FileOutputStream fileOutputStream3 = null;
        if (uriArr2 == null || uriArr2.length == 0) {
            return null;
        }
        Uri uri = uriArr2[0];
        InputStream b2 = b(uri);
        try {
            Options options = new Options();
            options.inSampleSize = a(uri);
            int aG = af.aG(uri.getPath());
            Matrix matrix = new Matrix();
            if (aG != 0) {
                matrix.postRotate((float) aG);
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(b2, null, options);
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
            File R = d.R(this.context, "freshchat");
            long nanoTime = System.nanoTime();
            File file = new File(R, nanoTime + ".img");
            File file2 = new File(R, nanoTime + ".img.t");
            fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
                try {
                    q.a(e);
                    ad.a(b2, fileOutputStream2, fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream3 = fileOutputStream2;
                    ad.a(b2, fileOutputStream3, fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileOutputStream3 = fileOutputStream2;
                ad.a(b2, fileOutputStream3, fileOutputStream);
                throw th;
            }
            try {
                createBitmap.compress(CompressFormat.JPEG, 85, fileOutputStream2);
                createBitmap.compress(CompressFormat.JPEG, 70, fileOutputStream);
                ai.d(TAG, "Pic saved to " + file.getAbsolutePath());
                com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.a aVar = (com.freshchat.consumer.sdk.activity.PictureAttachmentActivity.a) this.gT.get();
                if (aVar != null) {
                    aVar.l(file.getAbsolutePath());
                    aVar.k(file2.getAbsolutePath());
                    aVar.setHeight(createBitmap.getHeight());
                    aVar.setWidth(createBitmap.getWidth());
                }
                x.bs(uri.toString());
                ad.a(b2, fileOutputStream2, fileOutputStream);
                return createBitmap;
            } catch (Exception e3) {
                e = e3;
                q.a(e);
                ad.a(b2, fileOutputStream2, fileOutputStream);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = null;
            fileOutputStream = null;
            q.a(e);
            ad.a(b2, fileOutputStream2, fileOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            ad.a(b2, fileOutputStream3, fileOutputStream);
            throw th;
        }
    }

    public void onPostExecute(Bitmap bitmap) {
        WeakReference<ImageView> weakReference = this.gS;
        if (weakReference == null || bitmap == null) {
            ai.e("FRESHCHAT_WARNING", " image view not present or bitmap is null");
            if (fu() != null) {
                fu().aI();
                return;
            }
            return;
        }
        ImageView imageView = (ImageView) weakReference.get();
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        if (fu() != null) {
            fu().aH();
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
        if (fu() != null) {
            fu().aG();
        }
    }
}
