package io.hansel.userjourney.prompts.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import io.hansel.R;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.network.request.a.e;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.n;
import io.hansel.userjourney.prompts.v;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5512a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5513b;

    /* renamed from: c  reason: collision with root package name */
    public e f5514c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f5515d;

    public class a implements io.hansel.core.network.request.a.e.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f5516a;

        public a(ImageView imageView) {
            this.f5516a = imageView;
        }

        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                if (d.this.f5514c.b() == d.this.f5514c.c() - 1) {
                    if (d.this.f5514c.d() && d.this.f5515d != null) {
                        d.this.a(this.f5516a, bitmap);
                    }
                    d.this.f5515d = null;
                    d.this.f5514c.e();
                }
                d.this.f5515d = bitmap;
                d.this.a(this.f5516a, bitmap);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f5518a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f5519b;

        public b(d dVar, ImageView imageView, Bitmap bitmap) {
            this.f5518a = imageView;
            this.f5519b = bitmap;
        }

        public void run() {
            this.f5518a.setImageBitmap(this.f5519b);
        }
    }

    public d(Context context) {
        this.f5512a = context;
    }

    private void a(View view, String[] strArr, String[] strArr2) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.findViewById(R.id.frame_image_container).getLayoutParams();
        marginLayoutParams.leftMargin = HSLUtils.dpToPx(Integer.parseInt(strArr2[3]) + Integer.parseInt(strArr[3]));
        marginLayoutParams.topMargin = HSLUtils.dpToPx(Integer.parseInt(strArr2[0]) + Integer.parseInt(strArr[0]));
        marginLayoutParams.rightMargin = HSLUtils.dpToPx(Integer.parseInt(strArr2[1]) + Integer.parseInt(strArr[1]));
        marginLayoutParams.bottomMargin = HSLUtils.dpToPx(Integer.parseInt(strArr2[2]) + Integer.parseInt(strArr[2]));
        view.findViewById(R.id.frame_image_container).setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView, Bitmap bitmap) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(new b(this, imageView, bitmap));
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void a(String str, ImageView imageView) {
        byte[] a2 = a(str);
        e eVar = new e();
        this.f5514c = eVar;
        eVar.a((io.hansel.core.network.request.a.e.d) new a(imageView));
        this.f5514c.a(a2);
        this.f5514c.f();
    }

    private boolean a(String str, FrameLayout frameLayout) {
        Bitmap a2 = n.a(str);
        if (a2 == null) {
            return false;
        }
        frameLayout.setBackground(new BitmapDrawable(this.f5512a.getResources(), a2));
        return true;
    }

    private byte[] a(String str) {
        String str2;
        File file = new File(str);
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bArr, 0, length);
            bufferedInputStream.close();
        } catch (FileNotFoundException e2) {
            str2 = e2.getMessage();
        } catch (IOException e3) {
            str2 = e3.getMessage();
        }
        return bArr;
        HSLLogger.e(str2);
        return bArr;
    }

    public boolean a(View view, CoreJSONObject coreJSONObject, int i, v vVar, String str) {
        int i2;
        ProgressBar progressBar;
        ImageView imageView;
        int i3;
        int i4;
        ProgressBar progressBar2;
        View view2 = view;
        CoreJSONObject coreJSONObject2 = coreJSONObject;
        v vVar2 = vVar;
        String[] split = str.replaceAll("px", "").split(CMap.SPACE);
        CoreJSONObject optJSONObject = coreJSONObject2.optJSONObject("props");
        String[] split2 = optJSONObject.has("spacing") ? optJSONObject.optString("spacing").replaceAll("px", "").split(CMap.SPACE) : null;
        v vVar3 = v.imgHcardRight;
        if (vVar2 == vVar3 || vVar2 == v.imgHcardLeft) {
            this.f5513b = true;
            i2 = i;
        } else {
            i2 = i - HSLUtils.dpToPx(Integer.parseInt(split2[1]) + (Integer.parseInt(split2[3]) + (Integer.parseInt(split[1]) + Integer.parseInt(split[3]))));
        }
        String optString = optJSONObject.optString("url", "");
        try {
            CoreJSONObject jSONObject = optJSONObject.getJSONObject("width");
            int a2 = (int) (n.a(optJSONObject, (String) "opacity", 1.0f) * 255.0f);
            String str2 = optString;
            int optInt = jSONObject.optInt(HSLCriteriaBuilder.VALUE, 0);
            if (optInt == 0) {
                return false;
            }
            boolean z = optInt == 100;
            if ("%".equals(jSONObject.optString("unit", ""))) {
                optInt = (optInt * i2) / 100;
            }
            v vVar4 = v.bgImage;
            String optString2 = vVar2 == vVar4 ? coreJSONObject2.optString("url") : str2;
            v vVar5 = vVar4;
            if (vVar2 == v.img1) {
                imageView = (ImageView) view2.findViewById(R.id.img1);
                ProgressBar progressBar3 = (ProgressBar) view2.findViewById(R.id.img1_spinner);
                if (!z) {
                    progressBar2 = progressBar3;
                    int dpToPx = HSLUtils.dpToPx(n.b(optJSONObject.optString("maxTopSpacing", "24px"))) / 2;
                    int i5 = (i2 - optInt) / 2;
                    if (i5 < dpToPx) {
                        dpToPx = i5;
                    }
                    imageView.setPadding(0, dpToPx, 0, 0);
                } else {
                    progressBar2 = progressBar3;
                }
                if (optJSONObject.has("spacing") && !this.f5513b) {
                    a(view2, split2, split);
                }
                progressBar = progressBar2;
            } else {
                if (vVar2 == v.imgHcardLeft) {
                    imageView = (ImageView) view2.findViewById(R.id.img_h_left);
                    i4 = R.id.img_h_spinner_left;
                } else if (vVar2 == vVar3) {
                    imageView = (ImageView) view2.findViewById(R.id.img_h_right);
                    i4 = R.id.img_h_spinner_right;
                } else if (vVar2 != vVar5) {
                    return false;
                } else {
                    String string = this.f5512a.getSharedPreferences("IMAGES", 0).getString(optString2, "");
                    FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.prompt_content_view);
                    if (!HSLUtils.isSet(string) || "__HSL_FAILED".equals(string)) {
                        return false;
                    }
                    return a(string, frameLayout);
                }
                progressBar = (ProgressBar) view2.findViewById(i4);
            }
            String string2 = this.f5512a.getSharedPreferences("IMAGES", 0).getString(optString2, "");
            float optDouble = (float) optJSONObject.optDouble("imgAspectRatio", 1.7000000476837158d);
            if (!HSLUtils.isSet(string2) || "__HSL_FAILED".equals(string2)) {
                return false;
            }
            if (!HSLUtils.isSet(string2)) {
                return false;
            }
            if (string2.endsWith("__HSL_DOWNLOADING")) {
                LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = optInt;
                layoutParams.height = Math.round(optDouble * ((float) optInt));
                progressBar.setVisibility(0);
                imageView.setTag("_hsl_width: " + optInt + "::::__hsl_img: " + string2.split(HSLCriteriaBuilder.DIFF_CHAR)[0]);
            } else {
                if (string2.endsWith(".gif")) {
                    LayoutParams layoutParams2 = imageView.getLayoutParams();
                    layoutParams2.width = optInt;
                    layoutParams2.height = Math.round(optDouble * ((float) optInt));
                    a(string2, imageView);
                    i3 = 0;
                } else {
                    i3 = 0;
                    if (!n.a(string2, optInt, imageView)) {
                        return false;
                    }
                }
                imageView.setBackgroundColor(i3);
            }
            imageView.setImageAlpha(a2);
            return true;
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            return false;
        }
    }
}
