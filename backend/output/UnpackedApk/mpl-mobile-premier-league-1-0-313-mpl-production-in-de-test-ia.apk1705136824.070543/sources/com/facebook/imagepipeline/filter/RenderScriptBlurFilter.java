package com.facebook.imagepipeline.filter;

public abstract class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void blurBitmap(android.graphics.Bitmap r2, android.graphics.Bitmap r3, android.content.Context r4, int r5) {
        /*
            r0 = 0
            if (r2 == 0) goto L_0x0043
            if (r3 == 0) goto L_0x0042
            if (r4 == 0) goto L_0x0041
            if (r5 <= 0) goto L_0x000f
            r1 = 25
            if (r5 > r1) goto L_0x000f
            r1 = 1
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            co.hyperverge.hypersnapsdk.c.k.checkArgument(r1)
            android.renderscript.RenderScript r0 = android.renderscript.RenderScript.create(r4)     // Catch:{ all -> 0x003a }
            android.renderscript.Element r4 = android.renderscript.Element.U8_4(r0)     // Catch:{ all -> 0x003a }
            android.renderscript.ScriptIntrinsicBlur r4 = android.renderscript.ScriptIntrinsicBlur.create(r0, r4)     // Catch:{ all -> 0x003a }
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r0, r3)     // Catch:{ all -> 0x003a }
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r0, r2)     // Catch:{ all -> 0x003a }
            float r5 = (float) r5     // Catch:{ all -> 0x003a }
            r4.setRadius(r5)     // Catch:{ all -> 0x003a }
            r4.setInput(r3)     // Catch:{ all -> 0x003a }
            r4.forEach(r1)     // Catch:{ all -> 0x003a }
            r1.copyTo(r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0039
            r0.destroy()
        L_0x0039:
            return
        L_0x003a:
            r2 = move-exception
            if (r0 == 0) goto L_0x0040
            r0.destroy()
        L_0x0040:
            throw r2
        L_0x0041:
            throw r0
        L_0x0042:
            throw r0
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.filter.RenderScriptBlurFilter.blurBitmap(android.graphics.Bitmap, android.graphics.Bitmap, android.content.Context, int):void");
    }

    public static boolean canUseRenderScript() {
        return true;
    }
}
