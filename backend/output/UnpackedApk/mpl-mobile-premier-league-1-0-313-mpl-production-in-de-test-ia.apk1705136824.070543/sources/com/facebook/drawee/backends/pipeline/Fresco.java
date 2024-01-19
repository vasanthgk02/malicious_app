package com.facebook.drawee.backends.pipeline;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

public class Fresco {
    public static final Class<?> TAG = Fresco.class;
    public static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;
    public static volatile boolean sIsInitialized;

    public static ImagePipeline getImagePipeline() {
        return ImagePipelineFactory.getInstance().getImagePipeline();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        com.facebook.soloader.nativeloader.NativeLoader.init(new com.facebook.soloader.nativeloader.SystemDelegate());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.facebook.soloader.nativeloader.NativeLoader.init(new com.facebook.soloader.nativeloader.SystemDelegate());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        com.facebook.soloader.nativeloader.NativeLoader.init(new com.facebook.soloader.nativeloader.SystemDelegate());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.facebook.soloader.nativeloader.NativeLoader.init(new com.facebook.soloader.nativeloader.SystemDelegate());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008b, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008d, code lost:
        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing() != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        throw r5;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x0052, B:22:0x0061, B:26:0x0070, B:30:0x007f] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0070 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x007f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0070=Splitter:B:26:0x0070, B:22:0x0061=Splitter:B:22:0x0061, B:18:0x0052=Splitter:B:18:0x0052, B:30:0x007f=Splitter:B:30:0x007f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initialize(android.content.Context r5, com.facebook.imagepipeline.core.ImagePipelineConfig r6, com.facebook.drawee.backends.pipeline.DraweeConfig r7) {
        /*
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x000b
            java.lang.String r7 = "Fresco#initialize"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r7)
        L_0x000b:
            boolean r7 = sIsInitialized
            r0 = 1
            if (r7 == 0) goto L_0x0018
            java.lang.Class<?> r7 = TAG
            java.lang.String r1 = "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!"
            com.facebook.common.logging.FLog.w(r7, r1)
            goto L_0x001a
        L_0x0018:
            sIsInitialized = r0
        L_0x001a:
            com.facebook.imagepipeline.core.NativeCodeSetup.setUseNativeCode(r0)
            boolean r7 = com.facebook.soloader.nativeloader.NativeLoader.isInitialized()
            if (r7 != 0) goto L_0x009b
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x002e
            java.lang.String r7 = "Fresco.initialize->SoLoader.init"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r7)
        L_0x002e:
            java.lang.String r7 = "com.facebook.imagepipeline.nativecode.NativeCodeInitializer"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            java.lang.String r1 = "init"
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r4 = 0
            r2[r4] = r3     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            java.lang.reflect.Method r7 = r7.getMethod(r1, r2)     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            r1 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            r0[r4] = r5     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            r7.invoke(r1, r0)     // Catch:{ ClassNotFoundException -> 0x007f, IllegalAccessException -> 0x0070, InvocationTargetException -> 0x0061, NoSuchMethodException -> 0x0052 }
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x009b
            goto L_0x008d
        L_0x0050:
            r5 = move-exception
            goto L_0x0091
        L_0x0052:
            com.facebook.soloader.nativeloader.SystemDelegate r7 = new com.facebook.soloader.nativeloader.SystemDelegate     // Catch:{ all -> 0x0050 }
            r7.<init>()     // Catch:{ all -> 0x0050 }
            com.facebook.soloader.nativeloader.NativeLoader.init(r7)     // Catch:{ all -> 0x0050 }
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x009b
            goto L_0x008d
        L_0x0061:
            com.facebook.soloader.nativeloader.SystemDelegate r7 = new com.facebook.soloader.nativeloader.SystemDelegate     // Catch:{ all -> 0x0050 }
            r7.<init>()     // Catch:{ all -> 0x0050 }
            com.facebook.soloader.nativeloader.NativeLoader.init(r7)     // Catch:{ all -> 0x0050 }
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x009b
            goto L_0x008d
        L_0x0070:
            com.facebook.soloader.nativeloader.SystemDelegate r7 = new com.facebook.soloader.nativeloader.SystemDelegate     // Catch:{ all -> 0x0050 }
            r7.<init>()     // Catch:{ all -> 0x0050 }
            com.facebook.soloader.nativeloader.NativeLoader.init(r7)     // Catch:{ all -> 0x0050 }
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x009b
            goto L_0x008d
        L_0x007f:
            com.facebook.soloader.nativeloader.SystemDelegate r7 = new com.facebook.soloader.nativeloader.SystemDelegate     // Catch:{ all -> 0x0050 }
            r7.<init>()     // Catch:{ all -> 0x0050 }
            com.facebook.soloader.nativeloader.NativeLoader.init(r7)     // Catch:{ all -> 0x0050 }
            boolean r7 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r7 == 0) goto L_0x009b
        L_0x008d:
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
            goto L_0x009b
        L_0x0091:
            boolean r6 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r6 == 0) goto L_0x009a
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x009a:
            throw r5
        L_0x009b:
            android.content.Context r5 = r5.getApplicationContext()
            if (r6 != 0) goto L_0x00a5
            com.facebook.imagepipeline.core.ImagePipelineFactory.initialize(r5)
            goto L_0x00a8
        L_0x00a5:
            com.facebook.imagepipeline.core.ImagePipelineFactory.initialize(r6)
        L_0x00a8:
            boolean r6 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r6 == 0) goto L_0x00b3
            java.lang.String r6 = "Fresco.initializeDrawee"
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection(r6)
        L_0x00b3:
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier r6 = new com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilderSupplier
            r6.<init>(r5)
            sDraweeControllerBuilderSupplier = r6
            com.facebook.drawee.view.SimpleDraweeView.sDraweecontrollerbuildersupplier = r6
            boolean r5 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r5 == 0) goto L_0x00c5
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00c5:
            boolean r5 = com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()
            if (r5 == 0) goto L_0x00ce
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection()
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.Fresco.initialize(android.content.Context, com.facebook.imagepipeline.core.ImagePipelineConfig, com.facebook.drawee.backends.pipeline.DraweeConfig):void");
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder() {
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = sDraweeControllerBuilderSupplier;
        if (pipelineDraweeControllerBuilderSupplier != null) {
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = new PipelineDraweeControllerBuilder(pipelineDraweeControllerBuilderSupplier.mContext, pipelineDraweeControllerBuilderSupplier.mPipelineDraweeControllerFactory, pipelineDraweeControllerBuilderSupplier.mImagePipeline, pipelineDraweeControllerBuilderSupplier.mBoundControllerListeners);
            pipelineDraweeControllerBuilder.mImagePerfDataListener = pipelineDraweeControllerBuilderSupplier.mDefaultImagePerfDataListener;
            return pipelineDraweeControllerBuilder;
        }
        throw null;
    }
}
