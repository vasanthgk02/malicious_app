package com.como.RNTScratchView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ScratchView extends View implements OnTouchListener {
    public float brushSize = 0.0f;
    public int clearPointsCounter;
    public boolean cleared;
    public ArrayList<ArrayList<Boolean>> grid;
    public float gridSize;
    public Bitmap image;
    public Paint imagePaint = new Paint();
    public Rect imageRect = null;
    public boolean imageTakenFromView = false;
    public String imageUrl = null;
    public boolean inited = false;
    public float minDimension;
    public Path path;
    public Paint pathPaint = new Paint();
    public int placeholderColor = -1;
    public String resizeMode = "stretch";
    public String resourceName = null;
    public float scratchProgress;
    public float threshold = 0.0f;

    public ScratchView(Context context) {
        super(context);
        init();
    }

    public Bitmap createBitmapFromView() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        this.imageTakenFromView = true;
        return createBitmap;
    }

    public final void init() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(this);
        this.imagePaint.setAntiAlias(true);
        this.imagePaint.setFilterBitmap(true);
        this.pathPaint.setAlpha(0);
        this.pathPaint.setStyle(Style.STROKE);
        this.pathPaint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        this.pathPaint.setAntiAlias(true);
        setLayerType(1, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        if (r5 < r6) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r5 > r6) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007b, code lost:
        r0 = (int) (((r4 * r5) - r0) / 2.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0081, code lost:
        r1 = (int) (((r0 / r5) - r4) / 2.0f);
        r0 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            boolean r0 = r10.inited
            r1 = 1
            if (r0 != 0) goto L_0x0010
            int r0 = r10.getWidth()
            if (r0 <= 0) goto L_0x0010
            r10.inited = r1
            r10.reset()
        L_0x0010:
            boolean r0 = r10.imageTakenFromView
            r2 = -1
            if (r0 != 0) goto L_0x0020
            int r0 = r10.placeholderColor
            if (r0 == r2) goto L_0x001a
            goto L_0x001d
        L_0x001a:
            r0 = -7829368(0xffffffffff888888, float:NaN)
        L_0x001d:
            r11.drawColor(r0)
        L_0x0020:
            android.graphics.Bitmap r0 = r10.image
            if (r0 != 0) goto L_0x0025
            return
        L_0x0025:
            android.graphics.Rect r0 = r10.imageRect
            r3 = 0
            if (r0 != 0) goto L_0x009a
            int r0 = r10.getWidth()
            float r0 = (float) r0
            int r4 = r10.getHeight()
            float r4 = (float) r4
            android.graphics.Bitmap r5 = r10.image
            int r5 = r5.getWidth()
            float r5 = (float) r5
            android.graphics.Bitmap r6 = r10.image
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r5 = r5 / r6
            float r6 = r0 / r4
            java.lang.String r7 = r10.resizeMode
            int r8 = r7.hashCode()
            r9 = 94852023(0x5a753b7, float:1.5735357E-35)
            if (r8 == r9) goto L_0x0060
            r9 = 951526612(0x38b724d4, float:8.73298E-5)
            if (r8 == r9) goto L_0x0056
            goto L_0x0069
        L_0x0056:
            java.lang.String r8 = "contain"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0069
            r2 = 1
            goto L_0x0069
        L_0x0060:
            java.lang.String r8 = "cover"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0069
            r2 = 0
        L_0x0069:
            r7 = 1073741824(0x40000000, float:2.0)
            if (r2 == 0) goto L_0x0077
            if (r2 == r1) goto L_0x0072
            r0 = 0
        L_0x0070:
            r1 = 0
            goto L_0x0087
        L_0x0072:
            int r1 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0081
            goto L_0x007b
        L_0x0077:
            int r1 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0081
        L_0x007b:
            float r4 = r4 * r5
            float r4 = r4 - r0
            float r4 = r4 / r7
            int r0 = (int) r4
            goto L_0x0070
        L_0x0081:
            float r0 = r0 / r5
            float r0 = r0 - r4
            float r0 = r0 / r7
            int r0 = (int) r0
            r1 = r0
            r0 = 0
        L_0x0087:
            android.graphics.Rect r2 = new android.graphics.Rect
            int r4 = -r0
            int r5 = -r1
            int r6 = r10.getWidth()
            int r6 = r6 + r0
            int r0 = r10.getHeight()
            int r0 = r0 + r1
            r2.<init>(r4, r5, r6, r0)
            r10.imageRect = r2
        L_0x009a:
            android.graphics.Bitmap r0 = r10.image
            android.graphics.Rect r1 = new android.graphics.Rect
            android.graphics.Bitmap r2 = r10.image
            int r2 = r2.getWidth()
            android.graphics.Bitmap r4 = r10.image
            int r4 = r4.getHeight()
            r1.<init>(r3, r3, r2, r4)
            android.graphics.Rect r2 = r10.imageRect
            android.graphics.Paint r3 = r10.imagePaint
            r11.drawBitmap(r0, r1, r2, r3)
            android.graphics.Path r0 = r10.path
            if (r0 == 0) goto L_0x00bd
            android.graphics.Paint r1 = r10.pathPaint
            r11.drawPath(r0, r1)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.como.RNTScratchView.ScratchView.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r8 != 3) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            float r7 = r8.getX()
            int r7 = (int) r7
            float r0 = r8.getY()
            int r0 = (int) r0
            int r8 = r8.getAction()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L_0x00aa
            if (r8 == r3) goto L_0x009d
            r4 = 2
            if (r8 == r4) goto L_0x001d
            r7 = 3
            if (r8 == r7) goto L_0x009d
            goto L_0x00f1
        L_0x001d:
            android.graphics.Path r8 = r6.path
            if (r8 == 0) goto L_0x00f1
            float r7 = (float) r7
            float r0 = (float) r0
            r8.lineTo(r7, r0)
            int r8 = r6.getWidth()
            float r8 = (float) r8
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r7 = java.lang.Math.min(r7, r8)
            float r7 = java.lang.Math.max(r7, r1)
            float r7 = r7 / r8
            float r8 = r6.gridSize
            r4 = 1065353216(0x3f800000, float:1.0)
            float r8 = r8 - r4
            float r8 = r8 * r7
            int r7 = java.lang.Math.round(r8)
            float r8 = java.lang.Math.min(r0, r2)
            float r8 = java.lang.Math.max(r8, r1)
            float r8 = r8 / r2
            float r0 = r6.gridSize
            float r0 = r0 - r4
            float r0 = r0 * r8
            int r8 = java.lang.Math.round(r0)
            java.util.ArrayList<java.util.ArrayList<java.lang.Boolean>> r0 = r6.grid
            java.lang.Object r0 = r0.get(r7)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r8)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != r3) goto L_0x00f1
            java.util.ArrayList<java.util.ArrayList<java.lang.Boolean>> r0 = r6.grid
            java.lang.Object r7 = r0.get(r7)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r7.set(r8, r0)
            int r7 = r6.clearPointsCounter
            int r7 = r7 + r3
            r6.clearPointsCounter = r7
            float r7 = (float) r7
            float r8 = r6.gridSize
            float r8 = r8 * r8
            float r7 = r7 / r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r8
            r6.scratchProgress = r7
            r6.reportScratchProgress()
            boolean r7 = r6.cleared
            if (r7 != 0) goto L_0x00f1
            float r7 = r6.scratchProgress
            float r8 = r6.threshold
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x00f1
            r6.cleared = r3
            r6.reportScratchState()
            goto L_0x00f1
        L_0x009d:
            r6.reportTouchState(r2)
            android.graphics.Bitmap r7 = r6.createBitmapFromView()
            r6.image = r7
            r7 = 0
            r6.path = r7
            goto L_0x00f1
        L_0x00aa:
            android.graphics.Bitmap r8 = r6.createBitmapFromView()
            r6.image = r8
            r6.reportTouchState(r3)
            float r8 = r6.brushSize
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ba
            goto L_0x00d1
        L_0x00ba:
            int r8 = r6.getHeight()
            int r1 = r6.getWidth()
            if (r8 >= r1) goto L_0x00c9
            int r8 = r6.getHeight()
            goto L_0x00cd
        L_0x00c9:
            int r8 = r6.getWidth()
        L_0x00cd:
            float r8 = (float) r8
            r1 = 1092616192(0x41200000, float:10.0)
            float r8 = r8 / r1
        L_0x00d1:
            android.graphics.Rect r1 = new android.graphics.Rect
            int r4 = r6.getWidth()
            int r5 = r6.getHeight()
            r1.<init>(r2, r2, r4, r5)
            r6.imageRect = r1
            android.graphics.Paint r1 = r6.pathPaint
            r1.setStrokeWidth(r8)
            android.graphics.Path r8 = new android.graphics.Path
            r8.<init>()
            r6.path = r8
            float r7 = (float) r7
            float r0 = (float) r0
            r8.moveTo(r7, r0)
        L_0x00f1:
            r6.invalidate()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.como.RNTScratchView.ScratchView.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void reportImageLoadFinished(boolean z) {
        Context context = getContext();
        if (context instanceof ReactContext) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("success", z);
            ((RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), RNTScratchViewManager.EVENT_IMAGE_LOAD, createMap);
        }
    }

    public void reportScratchProgress() {
        Context context = getContext();
        if (context instanceof ReactContext) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("progressValue", ((double) Math.round(this.scratchProgress * 100.0f)) / 100.0d);
            ((RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), RNTScratchViewManager.EVENT_SCRATCH_PROGRESS_CHANGED, createMap);
        }
    }

    public void reportScratchState() {
        Context context = getContext();
        if (context instanceof ReactContext) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("isScratchDone", this.cleared);
            ((RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), RNTScratchViewManager.EVENT_SCRATCH_DONE, createMap);
        }
    }

    public void reportTouchState(boolean z) {
        Context context = getContext();
        if (context instanceof ReactContext) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("touchState", z);
            ((RCTEventEmitter) ((ReactContext) context).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), RNTScratchViewManager.EVENT_TOUCH_STATE_CHANGED, createMap);
        }
    }

    public void reset() {
        float height = (float) (getWidth() > getHeight() ? getHeight() : getWidth());
        this.minDimension = height;
        float f2 = this.brushSize;
        if (f2 <= 0.0f) {
            f2 = height / 10.0f;
        }
        this.brushSize = f2;
        this.brushSize = Math.max(1.0f, Math.min(100.0f, f2));
        float f3 = this.threshold;
        if (f3 <= 0.0f) {
            f3 = 50.0f;
        }
        this.threshold = f3;
        this.path = null;
        if (this.imageUrl != null) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        ScratchView.this.image = BitmapFactory.decodeStream((InputStream) FirebasePerfUrlConnection.getContent(new URL(ScratchView.this.imageUrl))).copy(Config.ARGB_8888, true);
                        ScratchView.this.reportImageLoadFinished(true);
                        ScratchView.this.invalidate();
                    } catch (Exception e2) {
                        ScratchView.this.reportImageLoadFinished(false);
                        e2.printStackTrace();
                    }
                }
            }).start();
        } else if (this.resourceName != null) {
            this.image = BitmapFactory.decodeResource(getContext().getResources(), getResources().getIdentifier(this.resourceName, "drawable", getContext().getPackageName()));
            reportImageLoadFinished(true);
            invalidate();
        }
        this.gridSize = (float) Math.max(Math.min(Math.ceil((double) (this.minDimension / this.brushSize)), 29.0d), 9.0d);
        this.grid = new ArrayList<>();
        for (int i = 0; ((float) i) < this.gridSize; i++) {
            this.grid.add(new ArrayList());
            for (int i2 = 0; ((float) i2) < this.gridSize; i2++) {
                this.grid.get(i).add(Boolean.TRUE);
            }
        }
        this.clearPointsCounter = 0;
        this.cleared = false;
        this.scratchProgress = 0.0f;
        reportScratchProgress();
        reportScratchState();
    }

    public void setBrushSize(float f2) {
        this.brushSize = f2 * 3.0f;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setPlaceholderColor(String str) {
        if (str != null) {
            try {
                this.placeholderColor = Color.parseColor(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setResizeMode(String str) {
        if (str != null) {
            this.resizeMode = str.toLowerCase();
        }
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public void setThreshold(float f2) {
        this.threshold = f2;
    }

    public ScratchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ScratchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
