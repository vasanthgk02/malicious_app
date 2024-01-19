package co.hyperverge.hypersnapsdk.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import co.hyperverge.facedetection.HVFace;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FileHelper */
public class g {
    public static Bitmap a(Bitmap bitmap, HVFace hVFace, HVFaceConfig hVFaceConfig) {
        if (bitmap == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(hVFace.faceLocation);
            int i = (jSONObject.getInt("ltx") * bitmap.getWidth()) / 100;
            int i2 = (jSONObject.getInt("lty") * bitmap.getHeight()) / 100;
            int i3 = (jSONObject.getInt("rbx") * bitmap.getWidth()) / 100;
            int i4 = (jSONObject.getInt("rby") * bitmap.getHeight()) / 100;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i5 = i3 - i;
            int i6 = i4 - i2;
            float f2 = 0.0f;
            float topPadding = hVFaceConfig.getTopPadding() > 0.0f ? ((float) i6) * hVFaceConfig.getTopPadding() : 0.0f;
            float bottomPadding = hVFaceConfig.getBottomPadding() > 0.0f ? ((float) i6) * hVFaceConfig.getBottomPadding() : 0.0f;
            float leftPadding = hVFaceConfig.getLeftPadding() > 0.0f ? ((float) i5) * hVFaceConfig.getLeftPadding() : 0.0f;
            if (hVFaceConfig.getRightPadding() > 0.0f) {
                f2 = ((float) i5) * hVFaceConfig.getRightPadding();
            }
            int i7 = (int) (((float) i) - leftPadding);
            int i8 = (int) (((float) i3) + f2);
            int i9 = (int) (((float) i2) - topPadding);
            int i10 = (int) (((float) i4) + bottomPadding);
            int i11 = 0;
            if (i7 < 0) {
                i7 = 0;
            }
            if (i9 < 0) {
                i9 = 0;
            }
            if (i8 > width) {
                i8 = width;
            }
            if (i10 > height) {
                i10 = height;
            }
            int i12 = i8 - i7;
            int i13 = i10 - i9;
            if (i7 + i12 > width) {
                i7 = 0;
            } else {
                width = i12;
            }
            if (i9 < 0) {
                i9 = 0;
            }
            if (i9 + i13 <= height) {
                height = i13;
                i11 = i9;
            }
            return Bitmap.createBitmap(bitmap, i7, i11, width, height);
        } catch (Exception | OutOfMemoryError e2) {
            i.a(e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            return null;
        }
    }

    public static List<Integer> a(HVFace hVFace, Bitmap bitmap) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(hVFace.faceLocation);
            arrayList.add(Integer.valueOf((jSONObject.getInt("ltx") * bitmap.getWidth()) / 100));
            arrayList.add(Integer.valueOf((jSONObject.getInt("lty") * bitmap.getHeight()) / 100));
            arrayList.add(Integer.valueOf((jSONObject.getInt("rbx") * bitmap.getWidth()) / 100));
            arrayList.add(Integer.valueOf((jSONObject.getInt("rby") * bitmap.getHeight()) / 100));
        } catch (JSONException e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
        return arrayList;
    }

    public static Bitmap a(String str) {
        try {
            new Options().inPreferredConfig = Config.ARGB_8888;
            return BitmapFactory.decodeFile(str);
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            return null;
        } catch (OutOfMemoryError e3) {
            i.a((Throwable) e3);
            if (n.m().i != null) {
                n.m().i.a(e3);
            }
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 1) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
            return null;
        }
    }
}
