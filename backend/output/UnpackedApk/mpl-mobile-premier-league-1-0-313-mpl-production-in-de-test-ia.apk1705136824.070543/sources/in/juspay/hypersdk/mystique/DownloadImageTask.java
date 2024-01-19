package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import in.juspay.hypersdk.core.DuiCallback;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    public static int downloadCount;
    public final BaseAdapter adapter;
    public final BitmapCache bitmapCache;
    public final Context context;
    public final DuiCallback duiCallback;
    public String imageUrl;
    public boolean isTriggerNotify;
    public final Integer palceHolder;

    public DownloadImageTask(BaseAdapter baseAdapter, Integer num, Context context2, BitmapCache bitmapCache2, DuiCallback duiCallback2, ImageView imageView) {
        this.adapter = baseAdapter;
        this.palceHolder = num;
        this.context = context2;
        this.bitmapCache = bitmapCache2;
        this.duiCallback = duiCallback2;
        if (downloadCount == 0) {
            this.isTriggerNotify = true;
        } else {
            this.isTriggerNotify = false;
        }
        int i = downloadCount + 1;
        downloadCount = i;
        downloadCount = i % 5;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(1:22)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|(1:15)|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0 = android.graphics.BitmapFactory.decodeResource(r4.context.getResources(), r4.palceHolder.intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (r5 != null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.duiCallback.getLogger().e("IMG_ERR", "Not able to apply placeholder");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r5 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap getImage(java.lang.String r5) {
        /*
            r4 = this;
            in.juspay.hypersdk.mystique.BitmapCache r0 = r4.bitmapCache
            android.graphics.Bitmap r0 = r0.get(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0062
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r0.<init>(r5)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.net.URLConnection r5 = r0.openConnection()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r0 = 1
            r5.setDoInput(r0)     // Catch:{ Exception -> 0x0030 }
            r5.connect()     // Catch:{ Exception -> 0x0030 }
            java.io.InputStream r0 = r5.getInputStream()     // Catch:{ Exception -> 0x0030 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x0030 }
            r5.disconnect()
            return r0
        L_0x002d:
            r0 = move-exception
            goto L_0x005c
        L_0x002f:
            r5 = r1
        L_0x0030:
            android.content.Context r0 = r4.context     // Catch:{ Exception -> 0x0049 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0049 }
            java.lang.Integer r2 = r4.palceHolder     // Catch:{ Exception -> 0x0049 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0049 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r2)     // Catch:{ Exception -> 0x0049 }
            if (r5 == 0) goto L_0x0045
            r5.disconnect()
        L_0x0045:
            return r0
        L_0x0046:
            r0 = move-exception
            r1 = r5
            goto L_0x005c
        L_0x0049:
            in.juspay.hypersdk.core.DuiCallback r0 = r4.duiCallback     // Catch:{ all -> 0x0046 }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = "IMG_ERR"
            java.lang.String r3 = "Not able to apply placeholder"
            r0.e(r2, r3)     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0062
            r5.disconnect()
            goto L_0x0062
        L_0x005c:
            if (r1 == 0) goto L_0x0061
            r1.disconnect()
        L_0x0061:
            throw r0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.DownloadImageTask.getImage(java.lang.String):android.graphics.Bitmap");
    }

    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        this.imageUrl = str;
        return getImage(str);
    }

    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.bitmapCache.put(this.imageUrl, bitmap);
            BaseAdapter baseAdapter = this.adapter;
            if (baseAdapter == null) {
                this.duiCallback.getLogger().e("IMG_ERR", "Fetching image from url failed. Null adapter passed");
            } else if (this.isTriggerNotify) {
                baseAdapter.notifyDataSetChanged();
            }
        }
    }
}
