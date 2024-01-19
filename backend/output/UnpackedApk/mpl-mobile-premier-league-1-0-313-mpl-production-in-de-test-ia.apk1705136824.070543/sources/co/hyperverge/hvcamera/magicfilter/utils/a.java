package co.hyperverge.hvcamera.magicfilter.utils;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;

public class a {
    static {
        new MeteringRectangle(0, 0, 0, 0, 0);
    }

    public static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static MeteringRectangle[] a(float f2, float f3, float f4, Rect rect, int i) {
        PointF pointF;
        PointF pointF2;
        int min = (int) (f4 * 0.5f * ((float) Math.min(rect.width(), rect.height())));
        if (i == 0) {
            pointF2 = new PointF(f2, f3);
        } else if (i == 90) {
            pointF2 = new PointF(f3, 1.0f - f2);
        } else if (i == 180) {
            pointF2 = new PointF(1.0f - f2, 1.0f - f3);
        } else if (i != 270) {
            pointF = null;
            int width = (int) ((pointF.x * ((float) rect.width())) + ((float) rect.left));
            int height = (int) ((pointF.y * ((float) rect.height())) + ((float) rect.top));
            Rect rect2 = new Rect(width - min, height - min, width + min, height + min);
            rect2.left = a(rect2.left, rect.left, rect.right);
            rect2.top = a(rect2.top, rect.top, rect.bottom);
            rect2.right = a(rect2.right, rect.left, rect.right);
            rect2.bottom = a(rect2.bottom, rect.top, rect.bottom);
            return new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)};
        } else {
            pointF2 = new PointF(1.0f - f3, f2);
        }
        pointF = pointF2;
        int width2 = (int) ((pointF.x * ((float) rect.width())) + ((float) rect.left));
        int height2 = (int) ((pointF.y * ((float) rect.height())) + ((float) rect.top));
        Rect rect22 = new Rect(width2 - min, height2 - min, width2 + min, height2 + min);
        rect22.left = a(rect22.left, rect.left, rect.right);
        rect22.top = a(rect22.top, rect.top, rect.bottom);
        rect22.right = a(rect22.right, rect.left, rect.right);
        rect22.bottom = a(rect22.bottom, rect.top, rect.bottom);
        return new MeteringRectangle[]{new MeteringRectangle(rect22, 1000)};
    }

    public static Rect a(CameraCharacteristics cameraCharacteristics, float f2, float f3) {
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        int width = rect.width() / 2;
        int height = rect.height() / 2;
        int width2 = (int) ((((float) rect.width()) * 0.5f) / f2);
        int height2 = (int) ((((float) rect.height()) * 0.5f) / f2);
        return new Rect(width - width2, height - height2, width + width2, height + height2);
    }
}
