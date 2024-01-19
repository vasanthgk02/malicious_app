package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

public final class Utils {
    public static final float INV_SQRT_2 = ((float) (Math.sqrt(2.0d) / 2.0d));
    public static float dpScale = -1.0f;
    public static final ThreadLocal<PathMeasure> threadLocalPathMeasure = new ThreadLocal<PathMeasure>() {
        public Object initialValue() {
            return new PathMeasure();
        }
    };
    public static final ThreadLocal<float[]> threadLocalPoints = new ThreadLocal<float[]>() {
        public Object initialValue() {
            return new float[4];
        }
    };
    public static final ThreadLocal<Path> threadLocalTempPath = new ThreadLocal<Path>() {
        public Object initialValue() {
            return new Path();
        }
    };
    public static final ThreadLocal<Path> threadLocalTempPath2 = new ThreadLocal<Path>() {
        public Object initialValue() {
            return new Path();
        }
    };

    public static void applyTrimPathIfNeeded(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent != null && !trimPathContent.hidden) {
            applyTrimPathIfNeeded(path, ((FloatKeyframeAnimation) trimPathContent.startAnimation).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.endAnimation).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.offsetAnimation).getFloatValue() / 360.0f);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f2 = pointF.x;
            float f3 = pointF2.x;
            float f4 = pointF2.y;
            path.cubicTo(pointF3.x + f2, pointF.y + pointF3.y, f3 + pointF4.x, f4 + pointF4.y, f3, f4);
        }
        return path;
    }

    public static float dpScale() {
        if (dpScale == -1.0f) {
            dpScale = Resources.getSystem().getDisplayMetrics().density;
        }
        return dpScale;
    }

    public static float getAnimationScale(Context context) {
        return Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = threadLocalPoints.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = INV_SQRT_2;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        return (float) Math.hypot((double) (fArr[2] - fArr[0]), (double) (fArr[3] - fArr[1]));
    }

    public static int hashFor(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (((float) 527) * f2) : 17;
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (((float) (i * 31)) * f4);
        }
        return f5 != 0.0f ? (int) (((float) (i * 31)) * f5) : i;
    }

    public static boolean isNetworkException(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int i) {
        if (VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.endSection("Utils#saveLayer");
    }

    public static void applyTrimPathIfNeeded(Path path, float f2, float f3, float f4) {
        PathMeasure pathMeasure = threadLocalPathMeasure.get();
        Path path2 = threadLocalTempPath.get();
        Path path3 = threadLocalTempPath2.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            L.endSection("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f3 - f2) - 1.0f)) < 0.01d) {
            L.endSection("applyTrimPathIfNeeded");
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = (float) MiscUtils.floorMod(min, length);
                max = (float) MiscUtils.floorMod(max, length);
            }
            if (min < 0.0f) {
                min = (float) MiscUtils.floorMod(min, length);
            }
            if (max < 0.0f) {
                max = (float) MiscUtils.floorMod(max, length);
            }
            int i = (min > max ? 1 : (min == max ? 0 : -1));
            if (i == 0) {
                path.reset();
                L.endSection("applyTrimPathIfNeeded");
                return;
            }
            if (i >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            L.endSection("applyTrimPathIfNeeded");
        }
    }
}
