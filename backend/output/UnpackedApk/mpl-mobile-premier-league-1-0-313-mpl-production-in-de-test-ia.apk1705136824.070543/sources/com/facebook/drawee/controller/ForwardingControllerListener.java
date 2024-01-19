package com.facebook.drawee.controller;

import java.util.ArrayList;
import java.util.List;

public class ForwardingControllerListener<INFO> implements ControllerListener<INFO> {
    public final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

    public synchronized void addListener(ControllerListener<? super INFO> controllerListener) {
        this.mListeners.add(controllerListener);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onFailure(java.lang.String r4, java.lang.Throwable r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r0 = r3.mListeners     // Catch:{ all -> 0x001f }
            int r0 = r0.size()     // Catch:{ all -> 0x001f }
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x001d
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r2 = r3.mListeners     // Catch:{ Exception -> 0x0018 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0018 }
            com.facebook.drawee.controller.ControllerListener r2 = (com.facebook.drawee.controller.ControllerListener) r2     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x001a
            r2.onFailure(r4, r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            monitor-enter(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
        L_0x001a:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x001d:
            monitor-exit(r3)
            return
        L_0x001f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.ForwardingControllerListener.onFailure(java.lang.String, java.lang.Throwable):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onFinalImageSet(java.lang.String r4, INFO r5, android.graphics.drawable.Animatable r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r0 = r3.mListeners     // Catch:{ all -> 0x001f }
            int r0 = r0.size()     // Catch:{ all -> 0x001f }
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x001d
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r2 = r3.mListeners     // Catch:{ Exception -> 0x0018 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0018 }
            com.facebook.drawee.controller.ControllerListener r2 = (com.facebook.drawee.controller.ControllerListener) r2     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x001a
            r2.onFinalImageSet(r4, r5, r6)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            monitor-enter(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
        L_0x001a:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x001d:
            monitor-exit(r3)
            return
        L_0x001f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.ForwardingControllerListener.onFinalImageSet(java.lang.String, java.lang.Object, android.graphics.drawable.Animatable):void");
    }

    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (Exception unused) {
                synchronized (this) {
                }
            }
        }
    }

    public void onIntermediateImageSet(String str, INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (Exception unused) {
                synchronized (this) {
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onRelease(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r0 = r3.mListeners     // Catch:{ all -> 0x001f }
            int r0 = r0.size()     // Catch:{ all -> 0x001f }
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x001d
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r2 = r3.mListeners     // Catch:{ Exception -> 0x0018 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0018 }
            com.facebook.drawee.controller.ControllerListener r2 = (com.facebook.drawee.controller.ControllerListener) r2     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x001a
            r2.onRelease(r4)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            monitor-enter(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
        L_0x001a:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x001d:
            monitor-exit(r3)
            return
        L_0x001f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.ForwardingControllerListener.onRelease(java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onSubmit(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r0 = r3.mListeners     // Catch:{ all -> 0x001f }
            int r0 = r0.size()     // Catch:{ all -> 0x001f }
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x001d
            java.util.List<com.facebook.drawee.controller.ControllerListener<? super INFO>> r2 = r3.mListeners     // Catch:{ Exception -> 0x0018 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x0018 }
            com.facebook.drawee.controller.ControllerListener r2 = (com.facebook.drawee.controller.ControllerListener) r2     // Catch:{ Exception -> 0x0018 }
            if (r2 == 0) goto L_0x001a
            r2.onSubmit(r4, r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            monitor-enter(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
        L_0x001a:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x001d:
            monitor-exit(r3)
            return
        L_0x001f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.ForwardingControllerListener.onSubmit(java.lang.String, java.lang.Object):void");
    }
}
