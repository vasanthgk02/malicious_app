package io.hansel.userjourney;

import a.a.a.a.d.b;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Base64OutputStream;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.R;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.prompts.o;
import io.hansel.userjourney.prompts.p;
import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class n {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5471a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f5472b;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0031 */
        static {
            /*
                io.hansel.userjourney.prompts.p[] r0 = io.hansel.userjourney.prompts.p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5472b = r0
                r1 = 4
                r2 = 1
                io.hansel.userjourney.prompts.p r3 = io.hansel.userjourney.prompts.p.SPOTLIGHT_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 3
                int[] r4 = f5472b     // Catch:{ NoSuchFieldError -> 0x0017 }
                io.hansel.userjourney.prompts.p r5 = io.hansel.userjourney.prompts.p.SPOTLIGHT_CIRCLE     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                io.hansel.userjourney.prompts.o[] r4 = io.hansel.userjourney.prompts.o.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f5471a = r4
                io.hansel.userjourney.prompts.o r5 = io.hansel.userjourney.prompts.o.FULLSCREEN     // Catch:{ NoSuchFieldError -> 0x0024 }
                r4[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r2 = f5471a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.userjourney.prompts.o r4 = io.hansel.userjourney.prompts.o.ROUND     // Catch:{ NoSuchFieldError -> 0x002b }
                r4 = 0
                r2[r4] = r0     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r2 = f5471a     // Catch:{ NoSuchFieldError -> 0x0031 }
                io.hansel.userjourney.prompts.o r4 = io.hansel.userjourney.prompts.o.PILLBOTTOM     // Catch:{ NoSuchFieldError -> 0x0031 }
                r2[r0] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r0 = f5471a     // Catch:{ NoSuchFieldError -> 0x0037 }
                io.hansel.userjourney.prompts.o r2 = io.hansel.userjourney.prompts.o.PILLTOP     // Catch:{ NoSuchFieldError -> 0x0037 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.n.a.<clinit>():void");
        }
    }

    public static float a(CoreJSONObject coreJSONObject, String str, float f2) {
        float optDouble = (float) coreJSONObject.optDouble(str, (double) f2);
        if (optDouble < 0.0f || optDouble > 1.0f) {
            return 1.0f;
        }
        return optDouble;
    }

    public static int a(float f2, String str) {
        String hexString = Integer.toHexString((int) (f2 * 255.0f));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(MqttTopic.MULTI_LEVEL_WILDCARD);
        outline73.append(hexString.length() == 1 ? "0" : "");
        outline73.append(hexString);
        outline73.append(str.substring(1));
        return Color.parseColor(outline73.toString());
    }

    public static int a(int i, int i2) {
        return (i2 * 2) + i;
    }

    public static int a(int i, int i2, int i3, boolean z) {
        if (!z) {
            return (i3 * 2) + i2;
        }
        return (i3 * 2) + Math.max(i, i2);
    }

    public static int a(CoreJSONObject coreJSONObject, String str, float f2, int i) {
        String optString = coreJSONObject.optString(str, "");
        try {
            Color.parseColor(optString);
            return a(f2, optString);
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
            return i;
        }
    }

    public static int a(CoreJSONObject coreJSONObject, String str, int i) {
        String optString = coreJSONObject.optString(str, "");
        try {
            return Color.parseColor(optString);
        } catch (Exception e2) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Color parsing ", optString, "      ");
            outline80.append(e2.getMessage());
            HSLLogger.d(outline80.toString());
            return i;
        }
    }

    public static Bitmap a(Context context, Bitmap bitmap) {
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.4f), Math.round(((float) bitmap.getHeight()) * 0.4f), false);
        Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
        RenderScript create = RenderScript.create(context);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
        create2.setRadius(10.0f);
        create2.setInput(createFromBitmap);
        create2.forEach(createFromBitmap2);
        createFromBitmap2.copyTo(createBitmap);
        return createBitmap;
    }

    public static Bitmap a(String str) {
        return Bitmap.createBitmap(BitmapFactory.decodeFile(str));
    }

    public static Bitmap a(String str, int i) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        return Bitmap.createScaledBitmap(decodeFile, i, (decodeFile.getHeight() * i) / decodeFile.getWidth(), true);
    }

    public static Drawable a(Resources resources, int i, int i2) {
        Drawable drawable = resources.getDrawable(i);
        drawable.mutate().setColorFilter(i2, Mode.SRC_IN);
        return drawable;
    }

    public static ViewGroup a(Activity activity) {
        return (ViewGroup) activity.getWindow().getDecorView().getRootView();
    }

    public static String a(View view, int i, int i2, int i3, int i4) {
        String str = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            view.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
            view.setDrawingCacheEnabled(false);
            byteArrayOutputStream.reset();
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, i, i2, i3, i4);
            createBitmap2.compress(CompressFormat.JPEG, 5, new Base64OutputStream(byteArrayOutputStream, 0));
            str = byteArrayOutputStream.toString();
            createBitmap2.recycle();
            byteArrayOutputStream.reset();
            return str;
        } catch (OutOfMemoryError e2) {
            HSLLogger.printStackTrace(e2);
            return str;
        }
    }

    public static String a(CoreJSONObject coreJSONObject, String str, String str2) {
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject(str);
        return optJSONObject != null ? optJSONObject.optString(str2) : "";
    }

    public static void a(Context context, ImageView imageView, boolean z, int i, int i2, int i3, int i4, int i5, int i6, float f2) {
        int dpToPx = HSLUtils.dpToPx(f2);
        Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i7 = i5 + i6;
        if (z) {
            Paint paint = new Paint();
            paint.setColor(i);
            paint.setStyle(Style.FILL);
            paint.setColor(i);
            paint.setAntiAlias(true);
            float f3 = (float) i4;
            float f4 = (float) i2;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, f3, f3), f4, f4, paint);
        }
        Paint paint2 = new Paint();
        paint2.setColor(i3);
        paint2.setStyle(Style.STROKE);
        float f5 = (float) dpToPx;
        paint2.setStrokeWidth(f5);
        paint2.setAntiAlias(true);
        Path path = new Path();
        float f6 = (float) i6;
        path.moveTo(f6, f6);
        float f7 = (float) i7;
        path.lineTo(f7, f7);
        path.close();
        canvas.drawPath(path, paint2);
        Paint paint3 = new Paint();
        paint3.setColor(i3);
        paint3.setStyle(Style.STROKE);
        paint3.setStrokeWidth(f5);
        paint3.setAntiAlias(true);
        Path path2 = new Path();
        path2.moveTo(f7, f6);
        path2.lineTo(f6, f7);
        path2.close();
        canvas.drawPath(path2, paint3);
        imageView.setImageDrawable(new BitmapDrawable(context.getResources(), createBitmap));
    }

    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            HSLLogger.printStackTrace(e2);
        }
    }

    public static void a(Resources resources, ImageView imageView, p pVar, o oVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Bitmap bitmap;
        boolean z;
        int i10;
        float width;
        float f2;
        float f3;
        float f4;
        Canvas canvas;
        float f5;
        int i11;
        float height;
        float width2;
        float f6;
        float f7;
        Canvas canvas2;
        float f8;
        p pVar2 = pVar;
        int i12 = i2;
        int i13 = i3;
        int i14 = i4;
        int i15 = i6;
        int i16 = i7;
        Bitmap createBitmap = Bitmap.createBitmap(i16, i8, Config.ARGB_8888);
        Canvas canvas3 = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(i9);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_ATOP));
        Paint paint2 = new Paint();
        paint2.setColor(0);
        paint2.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
        paint2.setAntiAlias(true);
        int i17 = a.f5471a[oVar.ordinal()];
        if (i17 == 1) {
            bitmap = createBitmap;
            z = true;
            canvas3.drawRect(0.0f, 0.0f, (float) canvas3.getWidth(), (float) canvas3.getHeight(), paint);
        } else if (i17 != 2) {
            if (i17 == 3) {
                bitmap = createBitmap;
                if (pVar2 == p.SPOTLIGHT_RECTANGLE) {
                    i10 = i16 / 2;
                    width = (float) canvas3.getWidth();
                    float f9 = (float) (i15 + i13 + i14);
                    f3 = 0.0f;
                    f4 = 0.0f;
                    canvas = canvas3;
                    f5 = f9;
                    f2 = f9;
                } else if (pVar2 == p.SPOTLIGHT_CIRCLE) {
                    i10 = i16 / 2;
                    width = (float) canvas3.getWidth();
                    f2 = (float) ((i13 / 2) + i15);
                    f3 = 0.0f;
                    f4 = 0.0f;
                    canvas = canvas3;
                    f5 = f2;
                }
                canvas.drawRect(f3, f4, width, f5, paint);
                float f10 = (float) i10;
                canvas3.drawCircle(f10, f2, f10, paint);
            } else if (i17 != 4) {
                bitmap = createBitmap;
            } else {
                if (pVar2 == p.SPOTLIGHT_RECTANGLE) {
                    i11 = i16 / 2;
                    height = (float) canvas3.getHeight();
                    f8 = (float) i15;
                    canvas2 = canvas3;
                    f7 = 0.0f;
                    width2 = (float) canvas3.getWidth();
                    f6 = f8;
                    bitmap = createBitmap;
                } else {
                    bitmap = createBitmap;
                    if (pVar2 == p.SPOTLIGHT_CIRCLE) {
                        i11 = i16 / 2;
                        height = (float) canvas3.getHeight();
                        width2 = (float) canvas3.getWidth();
                        f6 = (float) (i15 - (i13 / 2));
                        f7 = 0.0f;
                        canvas2 = canvas3;
                        f8 = f6;
                    }
                }
                canvas2.drawRect(f7, height, width2, f6, paint);
                float f11 = (float) i11;
                canvas3.drawCircle(f11, f8, f11, paint);
            }
            z = true;
        } else {
            bitmap = createBitmap;
            z = true;
            canvas3.drawCircle((float) ((i12 / 2) + i5), (float) ((i13 / 2) + i15), (float) ((a(i12, i13, i14, true) / 2) * i), paint);
        }
        int i18 = a.f5472b[pVar.ordinal()];
        if (i18 == z) {
            int i19 = i5 - i14;
            int i20 = i15 - i14;
            canvas3.drawRect((float) i19, (float) i20, (float) (i19 + a(i12, i14)), (float) (i20 + a(i12, i13, i14, false)), paint2);
        } else if (i18 == 2) {
            canvas3.drawCircle((float) ((i12 / 2) + i5), (float) ((i13 / 2) + i15), (float) (a(i12, i13, i14, z) / 2), paint2);
        }
        Bitmap bitmap2 = bitmap;
        canvas3.drawBitmap(bitmap2, 0.0f, 0.0f, new Paint());
        imageView.setBackground(new BitmapDrawable(resources, bitmap2));
    }

    public static void a(EditText editText, int i) {
        Drawable wrap = b.wrap(editText.getBackground());
        wrap.setTint(i);
        editText.setBackground(wrap);
    }

    public static void a(ImageView imageView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{0.0f});
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration((long) 625);
        ofFloat.start();
    }

    public static boolean a(String str, int i, ImageView imageView) {
        Bitmap a2 = a(str, i);
        if (a2 == null) {
            return false;
        }
        imageView.setImageBitmap(a2);
        return true;
    }

    public static int b(CoreJSONObject coreJSONObject, String str, int i) {
        String optString = coreJSONObject.optString(str, "");
        try {
            return Color.parseColor(optString.substring(0, 1) + optString.substring(7, 9) + optString.substring(1, 7));
        } catch (Exception e2) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Color parsing ", optString, "      ");
            outline80.append(e2.getMessage());
            HSLLogger.d(outline80.toString());
            return i;
        }
    }

    public static int b(String str) {
        return Integer.parseInt(HSLUtils.getNumericValue(str));
    }

    public static int c(String str) {
        return Color.parseColor(str);
    }

    public static boolean d(String str) {
        if (!HSLUtils.isSet(str)) {
            return false;
        }
        return Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,4})$").matcher(str).matches();
    }

    public static void a(CompoundButton compoundButton, boolean z, int i, int i2) {
        int i3 = z ? R.drawable.hansel_radio : R.drawable.hansel_check;
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{i, i2});
        Drawable drawable = ContextCompat.getDrawable(compoundButton.getContext(), i3);
        if (drawable != null) {
            Drawable wrap = b.wrap(drawable);
            wrap.setTintList(colorStateList);
            compoundButton.setButtonDrawable(wrap);
        }
    }
}
