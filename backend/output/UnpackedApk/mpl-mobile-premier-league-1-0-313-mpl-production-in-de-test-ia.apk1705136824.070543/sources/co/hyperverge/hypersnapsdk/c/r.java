package co.hyperverge.hypersnapsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.HVFaceConfig;
import co.hyperverge.hypersnapsdk.service.a.a;
import com.crimzoncode.tqcontests.util.TQConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: WaterMarkHelper */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static r f3141a;

    /* renamed from: b  reason: collision with root package name */
    public HVFaceConfig f3142b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3143c = r.class.getSimpleName();

    public String a(Context context, HVFaceConfig hVFaceConfig, String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        Exception e2;
        String format = new SimpleDateFormat(TQConstants.SERVER_DATE_FORMAT).format(Calendar.getInstance().getTime());
        this.f3142b = hVFaceConfig;
        new Options().inPreferredConfig = Config.ARGB_8888;
        Bitmap decodeFile = BitmapFactory.decodeFile(str2);
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(decodeFile, 0.0f, 0.0f, null);
        Rect rect = new Rect();
        a(z).getTextBounds(format, 0, format.length(), rect);
        canvas.drawText(format, 0.0f, ((float) (decodeFile.getHeight() - rect.height())) - 20.0f, a(z));
        canvas.drawText(str, 0.0f, (float) (decodeFile.getHeight() - 10), a(z));
        File file = new File(context.getFilesDir(), "hv");
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = z ? "FD_watermark_crop_image_" : "FD_watermark_full_image_";
        try {
            File file2 = new File(file.getAbsolutePath(), str3 + System.currentTimeMillis() + ".jpg");
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    int i = i.f3183b;
                    createBitmap.compress(compressFormat, 95, fileOutputStream);
                } catch (Exception e3) {
                    e2 = e3;
                }
            } catch (Exception e4) {
                e2 = e4;
                fileOutputStream = null;
                i.a((Throwable) e2);
                fileOutputStream.close();
                return file2.getAbsolutePath();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                i.a((Throwable) e5);
            }
            return file2.getAbsolutePath();
        } catch (OutOfMemoryError e6) {
            i.a((Throwable) e6);
            n m = n.m();
            if (m.i == null) {
                m.i = new a(context);
            }
            m.i.a(e6);
            return null;
        }
    }

    public final Paint a(boolean z) {
        Paint paint = new Paint();
        if (z) {
            paint.setTextSize((float) this.f3142b.getCropImageWaterMarkTextSizePx());
        } else {
            paint.setTextSize((float) this.f3142b.getFullImageWaterMarkTextSizePx());
        }
        paint.setColor(this.f3142b.getWaterMarkColor());
        paint.setFakeBoldText(true);
        paint.setStyle(Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
        return paint;
    }
}
