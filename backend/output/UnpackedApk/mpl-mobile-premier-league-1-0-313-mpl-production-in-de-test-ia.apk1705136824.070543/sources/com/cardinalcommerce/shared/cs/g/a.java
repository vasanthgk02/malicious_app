package com.cardinalcommerce.shared.cs.g;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView;
import com.squareup.picasso.NetworkRequestHandler;
import java.lang.ref.WeakReference;

public class a extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<CCAImageView> f2171a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2172b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2173c;

    /* renamed from: d  reason: collision with root package name */
    public final com.cardinalcommerce.shared.cs.utils.a f2174d = com.cardinalcommerce.shared.cs.utils.a.e();

    public a(CCAImageView cCAImageView, String str) {
        this.f2171a = new WeakReference<>(cCAImageView);
        this.f2172b = str;
        this.f2173c = str.substring(0, 4).toLowerCase().equals(NetworkRequestHandler.SCHEME_HTTP);
    }

    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v11, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v2
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], android.graphics.Bitmap]
      uses: [java.lang.Object, ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.net.HttpURLConnection]
      mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067 A[SYNTHETIC, Splitter:B:29:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e A[SYNTHETIC, Splitter:B:44:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doInBackground(java.lang.Object[] r7) {
        /*
            r6 = this;
            java.lang.String[] r7 = (java.lang.String[]) r7
            r7 = 0
            boolean r0 = r6.f2173c     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = r6.f2172b     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r1 = r6.f2172b     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r2 = ","
            int r1 = r1.indexOf(r2)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r1 = 0
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            int r2 = r0.length     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r0, r1, r2)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            goto L_0x0082
        L_0x0023:
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r1 = r6.f2172b     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            int r1 = r0.getResponseCode()     // Catch:{ Exception -> 0x005e, all -> 0x0058 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 == r2) goto L_0x0042
            r0.disconnect()
            goto L_0x0082
        L_0x0042:
            java.io.InputStream r1 = r0.getInputStream()     // Catch:{ Exception -> 0x005e, all -> 0x0058 }
            if (r1 == 0) goto L_0x0052
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x0050 }
            r0.disconnect()
            goto L_0x007a
        L_0x0050:
            goto L_0x0065
        L_0x0052:
            r0.disconnect()
            if (r1 == 0) goto L_0x0082
            goto L_0x007a
        L_0x0058:
            r1 = move-exception
            r5 = r1
            r1 = r7
            r7 = r0
            r0 = r5
            goto L_0x0087
        L_0x005e:
            r1 = r7
            goto L_0x0065
        L_0x0060:
            r0 = move-exception
            r1 = r7
            goto L_0x0087
        L_0x0063:
            r0 = r7
            r1 = r0
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.disconnect()     // Catch:{ all -> 0x0083 }
        L_0x006a:
            com.cardinalcommerce.shared.cs.utils.a r2 = r6.f2174d     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = "ImageDownloader"
            java.lang.String r4 = "Error downloading image"
            r2.a(r3, r4, r7)     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x0078
            r0.disconnect()
        L_0x0078:
            if (r1 == 0) goto L_0x0082
        L_0x007a:
            r1.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0082:
            return r7
        L_0x0083:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x0087:
            if (r7 == 0) goto L_0x008c
            r7.disconnect()
        L_0x008c:
            if (r1 == 0) goto L_0x0096
            r1.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0096:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.shared.cs.g.a.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (isCancelled()) {
            bitmap = null;
        }
        WeakReference<CCAImageView> weakReference = this.f2171a;
        if (weakReference != null) {
            CCAImageView cCAImageView = (CCAImageView) weakReference.get();
            if (cCAImageView != null && bitmap != null) {
                cCAImageView.setCCAImageBitmap(bitmap);
                cCAImageView.setAdjustViewBounds(true);
            }
        }
    }
}
