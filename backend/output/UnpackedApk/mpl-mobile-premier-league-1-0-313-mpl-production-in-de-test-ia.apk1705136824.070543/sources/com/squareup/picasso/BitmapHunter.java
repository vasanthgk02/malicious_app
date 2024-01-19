package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.imagepipeline.common.RotationOptions;
import com.squareup.picasso.NetworkRequestHandler.ResponseException;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public class BitmapHunter implements Runnable {
    public static final Object DECODE_LOCK = new Object();
    public static final RequestHandler ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request request) {
            return true;
        }

        public Result load(Request request, int i) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + request);
        }
    };
    public static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        public StringBuilder initialValue() {
            return new StringBuilder(Utils.THREAD_PREFIX);
        }
    };
    public static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    public Action action;
    public List<Action> actions;
    public final Cache cache;
    public final Request data;
    public final Dispatcher dispatcher;
    public Exception exception;
    public int exifOrientation;
    public Future<?> future;
    public final String key;
    public LoadedFrom loadedFrom;
    public final int memoryPolicy;
    public int networkPolicy;
    public final Picasso picasso;
    public Priority priority;
    public final RequestHandler requestHandler;
    public Bitmap result;
    public int retryCount;
    public final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
    public final Stats stats;

    public BitmapHunter(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2, RequestHandler requestHandler2) {
        this.picasso = picasso2;
        this.dispatcher = dispatcher2;
        this.cache = cache2;
        this.stats = stats2;
        this.action = action2;
        this.key = action2.getKey();
        this.data = action2.getRequest();
        this.priority = action2.getPriority();
        this.memoryPolicy = action2.getMemoryPolicy();
        this.networkPolicy = action2.getNetworkPolicy();
        this.requestHandler = requestHandler2;
        this.retryCount = requestHandler2.getRetryCount();
    }

    public static Bitmap applyCustomTransformations(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final Transformation transformation = list.get(i);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    final StringBuilder outline73 = GeneratedOutlineSupport.outline73("Transformation ");
                    outline73.append(transformation.key());
                    outline73.append(" returned null after ");
                    outline73.append(i);
                    outline73.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation key2 : list) {
                        outline73.append(key2.key());
                        outline73.append(10);
                    }
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(outline73.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Transformation ");
                            outline73.append(transformation.key());
                            outline73.append(" returned input Bitmap but recycled it.");
                            throw new IllegalStateException(outline73.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i++;
                    bitmap = transform;
                } else {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Transformation ");
                            outline73.append(transformation.key());
                            outline73.append(" mutated input Bitmap but failed to recycle the original.");
                            throw new IllegalStateException(outline73.toString());
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e2) {
                Picasso.HANDLER.post(new Runnable() {
                    public void run() {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Transformation ");
                        outline73.append(transformation.key());
                        outline73.append(" crashed with exception.");
                        throw new RuntimeException(outline73.toString(), e2);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    private Priority computeNewPriority() {
        Priority priority2 = Priority.LOW;
        List<Action> list = this.actions;
        boolean z = true;
        boolean z2 = list != null && !list.isEmpty();
        if (this.action == null && !z2) {
            z = false;
        }
        if (!z) {
            return priority2;
        }
        Action action2 = this.action;
        if (action2 != null) {
            priority2 = action2.getPriority();
        }
        if (z2) {
            int size = this.actions.size();
            for (int i = 0; i < size; i++) {
                Priority priority3 = this.actions.get(i).getPriority();
                if (priority3.ordinal() > priority2.ordinal()) {
                    priority2 = priority3;
                }
            }
        }
        return priority2;
    }

    public static Bitmap decodeStream(Source source, Request request) throws IOException {
        BufferedSource buffer = Okio.buffer(source);
        boolean isWebPFile = Utils.isWebPFile(buffer);
        boolean z = request.purgeable;
        Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
        boolean requiresInSampleSize = RequestHandler.requiresInSampleSize(createBitmapOptions);
        if (isWebPFile || 0 != 0) {
            byte[] readByteArray = buffer.readByteArray();
            if (requiresInSampleSize) {
                BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, createBitmapOptions);
                RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
            }
            return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, createBitmapOptions);
        }
        InputStream inputStream = buffer.inputStream();
        if (requiresInSampleSize) {
            MarkableInputStream markableInputStream = new MarkableInputStream(inputStream);
            markableInputStream.allowMarksToExpire(false);
            long savePosition = markableInputStream.savePosition(1024);
            BitmapFactory.decodeStream(markableInputStream, null, createBitmapOptions);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
            markableInputStream.reset(savePosition);
            markableInputStream.allowMarksToExpire(true);
            inputStream = markableInputStream;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, createBitmapOptions);
        if (decodeStream != null) {
            return decodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public static BitmapHunter forRequest(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2) {
        Request request = action2.getRequest();
        List<RequestHandler> requestHandlers = picasso2.getRequestHandlers();
        int size = requestHandlers.size();
        for (int i = 0; i < size; i++) {
            RequestHandler requestHandler2 = requestHandlers.get(i);
            if (requestHandler2.canHandleRequest(request)) {
                BitmapHunter bitmapHunter = new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, requestHandler2);
                return bitmapHunter;
            }
        }
        BitmapHunter bitmapHunter2 = new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, ERRORING_HANDLER);
        return bitmapHunter2;
    }

    public static int getExifRotation(int i) {
        switch (i) {
            case 3:
            case 4:
                return RotationOptions.ROTATE_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int getExifTranslation(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static boolean shouldResize(boolean z, int i, int i2, int i3, int i4) {
        return !z || (i3 != 0 && i > i3) || (i4 != 0 && i2 > i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap transformResult(com.squareup.picasso.Request r26, android.graphics.Bitmap r27, int r28) {
        /*
            r0 = r26
            int r1 = r27.getWidth()
            int r2 = r27.getHeight()
            boolean r3 = r0.onlyScaleDown
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r4 = r26.needsMatrixTransform()
            if (r4 != 0) goto L_0x001f
            if (r28 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r3 = r1
            r5 = r2
            r0 = r9
            goto L_0x024e
        L_0x001f:
            int r4 = r0.targetWidth
            int r6 = r0.targetHeight
            float r7 = r0.rotationDegrees
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0141
            double r10 = (double) r7
            double r12 = java.lang.Math.toRadians(r10)
            double r12 = java.lang.Math.cos(r12)
            double r10 = java.lang.Math.toRadians(r10)
            double r10 = java.lang.Math.sin(r10)
            boolean r4 = r0.hasRotationPivot
            if (r4 == 0) goto L_0x00d3
            float r4 = r0.rotationPivotX
            float r6 = r0.rotationPivotY
            r9.setRotate(r7, r4, r6)
            float r4 = r0.rotationPivotX
            double r6 = (double) r4
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 - r12
            double r6 = r6 * r14
            float r8 = r0.rotationPivotY
            r16 = r2
            r17 = r3
            double r2 = (double) r8
            double r2 = r2 * r10
            double r2 = r2 + r6
            double r6 = (double) r8
            double r6 = r6 * r14
            double r14 = (double) r4
            double r14 = r14 * r10
            double r6 = r6 - r14
            int r4 = r0.targetWidth
            double r14 = (double) r4
            double r14 = r14 * r12
            double r14 = r14 + r2
            r18 = r9
            double r8 = (double) r4
            double r8 = r8 * r10
            double r8 = r8 + r6
            r20 = r6
            double r5 = (double) r4
            double r5 = r5 * r12
            double r5 = r5 + r2
            int r7 = r0.targetHeight
            r22 = r1
            double r0 = (double) r7
            double r0 = r0 * r10
            double r5 = r5 - r0
            double r0 = (double) r4
            double r0 = r0 * r10
            double r0 = r0 + r20
            r23 = r8
            double r8 = (double) r7
            double r8 = r8 * r12
            double r8 = r8 + r0
            double r0 = (double) r7
            double r0 = r0 * r10
            double r0 = r2 - r0
            double r10 = (double) r7
            double r10 = r10 * r12
            double r10 = r10 + r20
            double r12 = java.lang.Math.max(r2, r14)
            double r12 = java.lang.Math.max(r5, r12)
            double r12 = java.lang.Math.max(r0, r12)
            double r2 = java.lang.Math.min(r2, r14)
            double r2 = java.lang.Math.min(r5, r2)
            double r0 = java.lang.Math.min(r0, r2)
            r6 = r20
            r2 = r23
            double r4 = java.lang.Math.max(r6, r2)
            double r4 = java.lang.Math.max(r8, r4)
            double r4 = java.lang.Math.max(r10, r4)
            double r2 = java.lang.Math.min(r6, r2)
            double r2 = java.lang.Math.min(r8, r2)
            double r2 = java.lang.Math.min(r10, r2)
            double r12 = r12 - r0
            double r0 = java.lang.Math.floor(r12)
            int r0 = (int) r0
            double r4 = r4 - r2
            double r1 = java.lang.Math.floor(r4)
            int r6 = (int) r1
            r4 = r0
            r0 = r18
            goto L_0x0148
        L_0x00d3:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
            r0.setRotate(r7)
            r1 = r26
            int r2 = r1.targetWidth
            double r3 = (double) r2
            double r3 = r3 * r12
            double r5 = (double) r2
            double r5 = r5 * r10
            double r7 = (double) r2
            double r7 = r7 * r12
            int r9 = r1.targetHeight
            double r14 = (double) r9
            double r14 = r14 * r10
            double r7 = r7 - r14
            double r14 = (double) r2
            double r14 = r14 * r10
            double r1 = (double) r9
            double r1 = r1 * r12
            double r1 = r1 + r14
            double r14 = (double) r9
            double r14 = r14 * r10
            double r10 = -r14
            double r14 = (double) r9
            double r14 = r14 * r12
            r12 = 0
            r20 = r14
            double r14 = java.lang.Math.max(r12, r3)
            double r14 = java.lang.Math.max(r7, r14)
            double r14 = java.lang.Math.max(r10, r14)
            double r3 = java.lang.Math.min(r12, r3)
            double r3 = java.lang.Math.min(r7, r3)
            double r3 = java.lang.Math.min(r10, r3)
            double r7 = java.lang.Math.max(r12, r5)
            double r7 = java.lang.Math.max(r1, r7)
            r9 = r20
            double r7 = java.lang.Math.max(r9, r7)
            double r5 = java.lang.Math.min(r12, r5)
            double r1 = java.lang.Math.min(r1, r5)
            double r1 = java.lang.Math.min(r9, r1)
            double r14 = r14 - r3
            double r3 = java.lang.Math.floor(r14)
            int r4 = (int) r3
            double r7 = r7 - r1
            double r1 = java.lang.Math.floor(r7)
            int r6 = (int) r1
            goto L_0x0148
        L_0x0141:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
        L_0x0148:
            if (r28 == 0) goto L_0x016e
            int r1 = getExifRotation(r28)
            int r2 = getExifTranslation(r28)
            if (r1 == 0) goto L_0x0165
            float r3 = (float) r1
            r0.preRotate(r3)
            r3 = 90
            if (r1 == r3) goto L_0x0160
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L_0x0165
        L_0x0160:
            r25 = r6
            r6 = r4
            r4 = r25
        L_0x0165:
            r1 = 1
            if (r2 == r1) goto L_0x016e
            float r1 = (float) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r1, r2)
        L_0x016e:
            r1 = r26
            boolean r2 = r1.centerCrop
            if (r2 == 0) goto L_0x0203
            if (r4 == 0) goto L_0x017e
            float r2 = (float) r4
            r3 = r22
            float r5 = (float) r3
            float r2 = r2 / r5
            r5 = r16
            goto L_0x0185
        L_0x017e:
            r3 = r22
            float r2 = (float) r6
            r5 = r16
            float r7 = (float) r5
            float r2 = r2 / r7
        L_0x0185:
            if (r6 == 0) goto L_0x018a
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x018c
        L_0x018a:
            float r7 = (float) r4
            float r8 = (float) r3
        L_0x018c:
            float r7 = r7 / r8
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x01bc
            float r8 = (float) r5
            float r7 = r7 / r2
            float r7 = r7 * r8
            double r7 = (double) r7
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            int r1 = r1.centerCropGravity
            r8 = r1 & 48
            r9 = 48
            if (r8 != r9) goto L_0x01a5
            r1 = 0
            goto L_0x01b1
        L_0x01a5:
            r8 = 80
            r1 = r1 & r8
            if (r1 != r8) goto L_0x01ad
            int r1 = r5 - r7
            goto L_0x01b1
        L_0x01ad:
            int r1 = r5 - r7
            int r1 = r1 / 2
        L_0x01b1:
            float r8 = (float) r6
            float r9 = (float) r7
            float r8 = r8 / r9
            r9 = r7
            r10 = r17
            r19 = 0
            r7 = r1
            r1 = r3
            goto L_0x01f4
        L_0x01bc:
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x01eb
            float r8 = (float) r3
            float r2 = r2 / r7
            float r2 = r2 * r8
            double r8 = (double) r2
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r1 = r1.centerCropGravity
            r8 = r1 & 3
            r9 = 3
            if (r8 != r9) goto L_0x01d3
            r1 = 0
            goto L_0x01de
        L_0x01d3:
            r8 = 5
            r1 = r1 & r8
            if (r1 != r8) goto L_0x01da
            int r1 = r3 - r2
            goto L_0x01de
        L_0x01da:
            int r1 = r3 - r2
            int r1 = r1 / 2
        L_0x01de:
            float r8 = (float) r4
            float r9 = (float) r2
            float r8 = r8 / r9
            r19 = r1
            r1 = r2
            r9 = r5
            r2 = r8
            r10 = r17
            r8 = r7
            r7 = 0
            goto L_0x01f4
        L_0x01eb:
            r1 = r3
            r9 = r5
            r2 = r7
            r8 = r2
            r10 = r17
            r7 = 0
            r19 = 0
        L_0x01f4:
            boolean r3 = shouldResize(r10, r3, r5, r4, r6)
            if (r3 == 0) goto L_0x01fd
            r0.preScale(r2, r8)
        L_0x01fd:
            r6 = r7
            r8 = r9
            r5 = r19
            r7 = r1
            goto L_0x0252
        L_0x0203:
            r5 = r16
            r10 = r17
            r3 = r22
            boolean r1 = r1.centerInside
            if (r1 == 0) goto L_0x022d
            if (r4 == 0) goto L_0x0212
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0214
        L_0x0212:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x0214:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x021a
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x021c
        L_0x021a:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x021c:
            float r2 = r2 / r7
            int r7 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0222
            goto L_0x0223
        L_0x0222:
            r1 = r2
        L_0x0223:
            boolean r2 = shouldResize(r10, r3, r5, r4, r6)
            if (r2 == 0) goto L_0x024e
            r0.preScale(r1, r1)
            goto L_0x024e
        L_0x022d:
            if (r4 != 0) goto L_0x0231
            if (r6 == 0) goto L_0x024e
        L_0x0231:
            if (r4 != r3) goto L_0x0235
            if (r6 == r5) goto L_0x024e
        L_0x0235:
            if (r4 == 0) goto L_0x023a
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x023c
        L_0x023a:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x023c:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x0242
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x0244
        L_0x0242:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x0244:
            float r2 = r2 / r7
            boolean r4 = shouldResize(r10, r3, r5, r4, r6)
            if (r4 == 0) goto L_0x024e
            r0.preScale(r1, r2)
        L_0x024e:
            r7 = r3
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0252:
            r10 = 1
            r4 = r27
            r9 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            r1 = r27
            if (r0 == r1) goto L_0x0262
            r27.recycle()
            goto L_0x0263
        L_0x0262:
            r0 = r1
        L_0x0263:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.transformResult(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void updateThreadName(Request request) {
        String name = request.getName();
        StringBuilder sb = NAME_BUILDER.get();
        sb.ensureCapacity(name.length() + 8);
        sb.replace(8, sb.length(), name);
        Thread.currentThread().setName(sb.toString());
    }

    public void attach(Action action2) {
        boolean z = this.picasso.loggingEnabled;
        Request request = action2.request;
        if (this.action == null) {
            this.action = action2;
            if (z) {
                List<Action> list = this.actions;
                if (list == null || list.isEmpty()) {
                    Utils.log(Utils.OWNER_HUNTER, Utils.VERB_JOINED, request.logId(), "to empty hunter");
                } else {
                    Utils.log(Utils.OWNER_HUNTER, Utils.VERB_JOINED, request.logId(), Utils.getLogIdsForHunter(this, "to "));
                }
            }
            return;
        }
        if (this.actions == null) {
            this.actions = new ArrayList(3);
        }
        this.actions.add(action2);
        if (z) {
            Utils.log(Utils.OWNER_HUNTER, Utils.VERB_JOINED, request.logId(), Utils.getLogIdsForHunter(this, "to "));
        }
        Priority priority2 = action2.getPriority();
        if (priority2.ordinal() > this.priority.ordinal()) {
            this.priority = priority2;
        }
    }

    public boolean cancel() {
        if (this.action != null) {
            return false;
        }
        List<Action> list = this.actions;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        Future<?> future2 = this.future;
        if (future2 == null || !future2.cancel(false)) {
            return false;
        }
        return true;
    }

    public void detach(Action action2) {
        boolean z;
        if (this.action == action2) {
            this.action = null;
            z = true;
        } else {
            List<Action> list = this.actions;
            z = list != null ? list.remove(action2) : false;
        }
        if (z && action2.getPriority() == this.priority) {
            this.priority = computeNewPriority();
        }
        if (this.picasso.loggingEnabled) {
            Utils.log(Utils.OWNER_HUNTER, Utils.VERB_REMOVED, action2.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
    }

    public Action getAction() {
        return this.action;
    }

    public List<Action> getActions() {
        return this.actions;
    }

    public Request getData() {
        return this.data;
    }

    public Exception getException() {
        return this.exception;
    }

    public String getKey() {
        return this.key;
    }

    public LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    public int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    public Picasso getPicasso() {
        return this.picasso;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Bitmap getResult() {
        return this.result;
    }

    public Bitmap hunt() throws IOException {
        Bitmap bitmap;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
            bitmap = this.cache.get(this.key);
            if (bitmap != null) {
                this.stats.dispatchCacheHit();
                this.loadedFrom = LoadedFrom.MEMORY;
                if (this.picasso.loggingEnabled) {
                    Utils.log(Utils.OWNER_HUNTER, Utils.VERB_DECODED, this.data.logId(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        int i = this.retryCount == 0 ? NetworkPolicy.OFFLINE.index : this.networkPolicy;
        this.networkPolicy = i;
        Result load = this.requestHandler.load(this.data, i);
        if (load != null) {
            this.loadedFrom = load.getLoadedFrom();
            this.exifOrientation = load.getExifOrientation();
            bitmap = load.getBitmap();
            if (bitmap == null) {
                Source source = load.getSource();
                try {
                    bitmap = decodeStream(source, this.data);
                } finally {
                    try {
                        source.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.picasso.loggingEnabled) {
                Utils.log(Utils.OWNER_HUNTER, Utils.VERB_DECODED, this.data.logId());
            }
            this.stats.dispatchBitmapDecoded(bitmap);
            if (this.data.needsTransformation() || this.exifOrientation != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.data.needsMatrixTransform() || this.exifOrientation != 0) {
                        bitmap = transformResult(this.data, bitmap, this.exifOrientation);
                        if (this.picasso.loggingEnabled) {
                            Utils.log(Utils.OWNER_HUNTER, Utils.VERB_TRANSFORMED, this.data.logId());
                        }
                    }
                    if (this.data.hasCustomTransformations()) {
                        bitmap = applyCustomTransformations(this.data.transformations, bitmap);
                        if (this.picasso.loggingEnabled) {
                            Utils.log(Utils.OWNER_HUNTER, Utils.VERB_TRANSFORMED, this.data.logId(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.stats.dispatchBitmapTransformed(bitmap);
                }
            }
        }
        return bitmap;
    }

    public boolean isCancelled() {
        Future<?> future2 = this.future;
        return future2 != null && future2.isCancelled();
    }

    public void run() {
        try {
            updateThreadName(this.data);
            if (this.picasso.loggingEnabled) {
                Utils.log(Utils.OWNER_HUNTER, Utils.VERB_EXECUTING, Utils.getLogIdsForHunter(this));
            }
            Bitmap hunt = hunt();
            this.result = hunt;
            if (hunt == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (ResponseException e2) {
            if (!NetworkPolicy.isOfflineOnly(e2.networkPolicy) || e2.code != 504) {
                this.exception = e2;
            }
            this.dispatcher.dispatchFailed(this);
        } catch (IOException e3) {
            this.exception = e3;
            this.dispatcher.dispatchRetry(this);
        } catch (OutOfMemoryError e4) {
            StringWriter stringWriter = new StringWriter();
            this.stats.createSnapshot().dump(new PrintWriter(stringWriter));
            this.exception = new RuntimeException(stringWriter.toString(), e4);
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e5) {
            this.exception = e5;
            this.dispatcher.dispatchFailed(this);
        } catch (Throwable th) {
            Thread.currentThread().setName(Utils.THREAD_IDLE_NAME);
            throw th;
        }
        Thread.currentThread().setName(Utils.THREAD_IDLE_NAME);
    }

    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        if (!(this.retryCount > 0)) {
            return false;
        }
        this.retryCount--;
        return this.requestHandler.shouldRetry(z, networkInfo);
    }

    public boolean supportsReplay() {
        return this.requestHandler.supportsReplay();
    }
}
