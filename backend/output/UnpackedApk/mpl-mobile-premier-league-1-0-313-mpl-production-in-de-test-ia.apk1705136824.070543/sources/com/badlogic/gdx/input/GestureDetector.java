package com.badlogic.gdx.input;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.backends.android.DefaultAndroidInput;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GestureDetector extends InputAdapter {
    public boolean inTapRectangle;
    public final Vector2 initialPointer1;
    public final Vector2 initialPointer2;
    public int lastTapButton;
    public int lastTapPointer;
    public long lastTapTime;
    public float lastTapX;
    public float lastTapY;
    public final GestureListener listener;
    public boolean longPressFired;
    public float longPressSeconds;
    public final Task longPressTask;
    public long maxFlingDelay;
    public boolean panning;
    public boolean pinching;
    public Vector2 pointer1;
    public final Vector2 pointer2;
    public int tapCount;
    public long tapCountInterval;
    public float tapRectangleCenterX;
    public float tapRectangleCenterY;
    public float tapRectangleHeight;
    public float tapRectangleWidth;
    public long touchDownTime;
    public final VelocityTracker tracker;

    public static class GestureAdapter implements GestureListener {
        public abstract boolean fling(float f2, float f3, int i);

        public abstract boolean longPress(float f2, float f3);

        public abstract boolean pan(float f2, float f3, float f4, float f5);

        public boolean panStop(float f2, float f3, int i, int i2) {
            return false;
        }

        public abstract boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24);

        public void pinchStop() {
        }

        public abstract boolean tap(float f2, float f3, int i, int i2);

        public boolean touchDown(float f2, float f3, int i, int i2) {
            return false;
        }

        public abstract boolean zoom(float f2, float f3);
    }

    public interface GestureListener {
        boolean fling(float f2, float f3, int i);

        boolean longPress(float f2, float f3);

        boolean pan(float f2, float f3, float f4, float f5);

        boolean panStop(float f2, float f3, int i, int i2);

        boolean pinch(Vector2 vector2, Vector2 vector22, Vector2 vector23, Vector2 vector24);

        void pinchStop();

        boolean tap(float f2, float f3, int i, int i2);

        boolean touchDown(float f2, float f3, int i, int i2);

        boolean zoom(float f2, float f3);
    }

    public static class VelocityTracker {
        public float deltaX;
        public float deltaY;
        public long lastTime;
        public float lastX;
        public float lastY;
        public long[] meanTime = new long[10];
        public float[] meanX = new float[10];
        public float[] meanY = new float[10];
        public int numSamples;
        public int sampleSize = 10;

        public final float getAverage(float[] fArr, int i) {
            int min = Math.min(this.sampleSize, i);
            float f2 = 0.0f;
            for (int i2 = 0; i2 < min; i2++) {
                f2 += fArr[i2];
            }
            return f2 / ((float) min);
        }

        public void start(float f2, float f3, long j) {
            this.lastX = f2;
            this.lastY = f3;
            this.deltaX = 0.0f;
            this.deltaY = 0.0f;
            this.numSamples = 0;
            for (int i = 0; i < this.sampleSize; i++) {
                this.meanX[i] = 0.0f;
                this.meanY[i] = 0.0f;
                this.meanTime[i] = 0;
            }
            this.lastTime = j;
        }

        public void update(float f2, float f3, long j) {
            float f4 = f2 - this.lastX;
            this.deltaX = f4;
            float f5 = f3 - this.lastY;
            this.deltaY = f5;
            this.lastX = f2;
            this.lastY = f3;
            long j2 = j - this.lastTime;
            this.lastTime = j;
            int i = this.numSamples;
            int i2 = i % this.sampleSize;
            this.meanX[i2] = f4;
            this.meanY[i2] = f5;
            this.meanTime[i2] = j2;
            this.numSamples = i + 1;
        }

        public final long getAverage(long[] jArr, int i) {
            int min = Math.min(this.sampleSize, i);
            long j = 0;
            for (int i2 = 0; i2 < min; i2++) {
                j += jArr[i2];
            }
            if (min == 0) {
                return 0;
            }
            return j / ((long) min);
        }
    }

    public GestureDetector(GestureListener gestureListener) {
        this(20.0f, 0.4f, 1.1f, 2.1474836E9f, gestureListener);
    }

    private boolean isWithinTapRectangle(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f4) < this.tapRectangleWidth && Math.abs(f3 - f5) < this.tapRectangleHeight;
    }

    public void cancel() {
        this.longPressTask.cancel();
        this.longPressFired = true;
    }

    public void invalidateTapSquare() {
        this.inTapRectangle = false;
    }

    public boolean isLongPressed() {
        return isLongPressed(this.longPressSeconds);
    }

    public boolean isPanning() {
        return this.panning;
    }

    public void reset() {
        this.touchDownTime = 0;
        this.panning = false;
        this.inTapRectangle = false;
        this.tracker.lastTime = 0;
    }

    public void setLongPressSeconds(float f2) {
        this.longPressSeconds = f2;
    }

    public void setMaxFlingDelay(long j) {
        this.maxFlingDelay = j;
    }

    public void setTapCountInterval(float f2) {
        this.tapCountInterval = (long) (f2 * 1.0E9f);
    }

    public void setTapRectangleSize(float f2, float f3) {
        this.tapRectangleWidth = f2;
        this.tapRectangleHeight = f3;
    }

    public void setTapSquareSize(float f2) {
        setTapRectangleSize(f2, f2);
    }

    public boolean touchDown(int i, int i2, int i3, int i4) {
        return touchDown((float) i, (float) i2, i3, i4);
    }

    public boolean touchDragged(int i, int i2, int i3) {
        return touchDragged((float) i, (float) i2, i3);
    }

    public boolean touchUp(int i, int i2, int i3, int i4) {
        return touchUp((float) i, (float) i2, i3, i4);
    }

    public GestureDetector(float f2, float f3, float f4, float f5, GestureListener gestureListener) {
        this(f2, f2, f3, f4, f5, gestureListener);
    }

    public boolean isLongPressed(float f2) {
        boolean z = false;
        if (this.touchDownTime == 0) {
            return false;
        }
        if (System.nanoTime() - this.touchDownTime > ((long) (f2 * 1.0E9f))) {
            z = true;
        }
        return z;
    }

    public boolean touchDown(float f2, float f3, int i, int i2) {
        boolean z;
        boolean z2 = false;
        if (i > 1) {
            return false;
        }
        if (i == 0) {
            Vector2 vector2 = this.pointer1;
            vector2.x = f2;
            vector2.y = f3;
            long j = ((DefaultAndroidInput) k.input).currentEventTimeStamp;
            this.touchDownTime = j;
            this.tracker.start(f2, f3, j);
            DefaultAndroidInput defaultAndroidInput = (DefaultAndroidInput) k.input;
            synchronized (defaultAndroidInput) {
                z = defaultAndroidInput.touched[1];
            }
            if (z) {
                this.inTapRectangle = false;
                this.pinching = true;
                this.initialPointer1.set(this.pointer1);
                this.initialPointer2.set(this.pointer2);
                this.longPressTask.cancel();
            } else {
                this.inTapRectangle = true;
                this.pinching = false;
                this.longPressFired = false;
                this.tapRectangleCenterX = f2;
                this.tapRectangleCenterY = f3;
                if (this.longPressTask.timer != null) {
                    z2 = true;
                }
                if (!z2) {
                    Timer.schedule(this.longPressTask, this.longPressSeconds);
                }
            }
        } else {
            Vector2 vector22 = this.pointer2;
            vector22.x = f2;
            vector22.y = f3;
            this.inTapRectangle = false;
            this.pinching = true;
            this.initialPointer1.set(this.pointer1);
            this.initialPointer2.set(this.pointer2);
            this.longPressTask.cancel();
        }
        return this.listener.touchDown(f2, f3, i, i2);
    }

    public boolean touchDragged(float f2, float f3, int i) {
        boolean z = true;
        if (i > 1 || this.longPressFired) {
            return false;
        }
        if (i == 0) {
            Vector2 vector2 = this.pointer1;
            vector2.x = f2;
            vector2.y = f3;
        } else {
            Vector2 vector22 = this.pointer2;
            vector22.x = f2;
            vector22.y = f3;
        }
        if (this.pinching) {
            GestureListener gestureListener = this.listener;
            if (gestureListener == null) {
                return false;
            }
            boolean pinch = gestureListener.pinch(this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
            if (!this.listener.zoom(this.initialPointer1.dst(this.initialPointer2), this.pointer1.dst(this.pointer2)) && !pinch) {
                z = false;
            }
            return z;
        }
        this.tracker.update(f2, f3, ((DefaultAndroidInput) k.input).currentEventTimeStamp);
        if (this.inTapRectangle && !isWithinTapRectangle(f2, f3, this.tapRectangleCenterX, this.tapRectangleCenterY)) {
            this.longPressTask.cancel();
            this.inTapRectangle = false;
        }
        if (this.inTapRectangle) {
            return false;
        }
        this.panning = true;
        GestureListener gestureListener2 = this.listener;
        VelocityTracker velocityTracker = this.tracker;
        return gestureListener2.pan(f2, f3, velocityTracker.deltaX, velocityTracker.deltaY);
    }

    public boolean touchUp(float f2, float f3, int i, int i2) {
        boolean z = true;
        if (i > 1) {
            return false;
        }
        if (this.inTapRectangle && !isWithinTapRectangle(f2, f3, this.tapRectangleCenterX, this.tapRectangleCenterY)) {
            this.inTapRectangle = false;
        }
        boolean z2 = this.panning;
        this.panning = false;
        this.longPressTask.cancel();
        if (this.longPressFired) {
            return false;
        }
        if (this.inTapRectangle) {
            if (this.lastTapButton != i2 || this.lastTapPointer != i || System.nanoTime() - this.lastTapTime > this.tapCountInterval || !isWithinTapRectangle(f2, f3, this.lastTapX, this.lastTapY)) {
                this.tapCount = 0;
            }
            this.tapCount++;
            this.lastTapTime = System.nanoTime();
            this.lastTapX = f2;
            this.lastTapY = f3;
            this.lastTapButton = i2;
            this.lastTapPointer = i;
            this.touchDownTime = 0;
            return this.listener.tap(f2, f3, this.tapCount, i2);
        } else if (this.pinching) {
            this.pinching = false;
            this.listener.pinchStop();
            this.panning = true;
            if (i == 0) {
                VelocityTracker velocityTracker = this.tracker;
                Vector2 vector2 = this.pointer2;
                velocityTracker.start(vector2.x, vector2.y, ((DefaultAndroidInput) k.input).currentEventTimeStamp);
            } else {
                VelocityTracker velocityTracker2 = this.tracker;
                Vector2 vector22 = this.pointer1;
                velocityTracker2.start(vector22.x, vector22.y, ((DefaultAndroidInput) k.input).currentEventTimeStamp);
            }
            return false;
        } else {
            boolean panStop = (!z2 || this.panning) ? false : this.listener.panStop(f2, f3, i, i2);
            long j = ((DefaultAndroidInput) k.input).currentEventTimeStamp;
            if (j - this.touchDownTime <= this.maxFlingDelay) {
                this.tracker.update(f2, f3, j);
                GestureListener gestureListener = this.listener;
                VelocityTracker velocityTracker3 = this.tracker;
                float average = velocityTracker3.getAverage(velocityTracker3.meanX, velocityTracker3.numSamples);
                float average2 = ((float) velocityTracker3.getAverage(velocityTracker3.meanTime, velocityTracker3.numSamples)) / 1.0E9f;
                float f4 = 0.0f;
                float f5 = average2 == 0.0f ? 0.0f : average / average2;
                VelocityTracker velocityTracker4 = this.tracker;
                float average3 = velocityTracker4.getAverage(velocityTracker4.meanY, velocityTracker4.numSamples);
                float average4 = ((float) velocityTracker4.getAverage(velocityTracker4.meanTime, velocityTracker4.numSamples)) / 1.0E9f;
                if (average4 != 0.0f) {
                    f4 = average3 / average4;
                }
                if (!gestureListener.fling(f5, f4, i2) && !panStop) {
                    z = false;
                }
                panStop = z;
            }
            this.touchDownTime = 0;
            return panStop;
        }
    }

    public GestureDetector(float f2, float f3, float f4, float f5, float f6, GestureListener gestureListener) {
        this.tracker = new VelocityTracker();
        this.pointer1 = new Vector2();
        this.pointer2 = new Vector2();
        this.initialPointer1 = new Vector2();
        this.initialPointer2 = new Vector2();
        this.longPressTask = new Task() {
            public void run() {
                GestureDetector gestureDetector = GestureDetector.this;
                if (!gestureDetector.longPressFired) {
                    GestureListener gestureListener = gestureDetector.listener;
                    Vector2 vector2 = gestureDetector.pointer1;
                    gestureDetector.longPressFired = gestureListener.longPress(vector2.x, vector2.y);
                }
            }
        };
        if (gestureListener != null) {
            this.tapRectangleWidth = f2;
            this.tapRectangleHeight = f3;
            this.tapCountInterval = (long) (f4 * 1.0E9f);
            this.longPressSeconds = f5;
            this.maxFlingDelay = (long) (f6 * 1.0E9f);
            this.listener = gestureListener;
            return;
        }
        throw new IllegalArgumentException("listener cannot be null.");
    }
}
