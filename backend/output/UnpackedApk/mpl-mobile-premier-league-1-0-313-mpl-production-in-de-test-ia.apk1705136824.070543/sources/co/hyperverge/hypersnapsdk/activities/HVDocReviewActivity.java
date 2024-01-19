package co.hyperverge.hypersnapsdk.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.pdf.PdfRenderer;
import android.graphics.pdf.PdfRenderer.Page;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import co.hyperverge.hypersnapsdk.R$string;
import co.hyperverge.hypersnapsdk.c.g;
import co.hyperverge.hypersnapsdk.c.n;
import co.hyperverge.hypersnapsdk.c.q;
import co.hyperverge.hypersnapsdk.f.h;
import co.hyperverge.hypersnapsdk.f.i;
import co.hyperverge.hypersnapsdk.objects.HVBaseConfig;
import co.hyperverge.hypersnapsdk.objects.HVDocConfig;
import co.hyperverge.hypersnapsdk.objects.HVError;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.inca.security.Proxy.iIiIiIiIii;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

@SuppressLint({"LogNotTimber"})
public class HVDocReviewActivity extends a {

    /* renamed from: d  reason: collision with root package name */
    public final q f2962d = new q();

    /* renamed from: e  reason: collision with root package name */
    public final q f2963e = new q();

    /* renamed from: f  reason: collision with root package name */
    public final String f2964f = HVDocReviewActivity.class.getSimpleName();
    public ImageView g;
    public FloatingActionButton h;
    public FloatingActionButton i;
    public CardView j;
    public ContentLoadingProgressBar k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public String r = "";
    public String s = "";
    public float v;
    public double w;
    public HVDocConfig x;
    public final ExecutorService z = Executors.newSingleThreadExecutor();

    /* access modifiers changed from: 0000 */
    public void a(View view) {
        Intent intent = new Intent();
        intent.putExtra("imageUri", this.r);
        if (this.x.isShouldReadQR()) {
            intent.putExtra("qrCodeCroppedImageUri", this.s);
        }
        intent.putExtra("timeTakenToClickConfirmButton", this.f2963e.c().longValue());
        setResult(7, intent);
        finish();
    }

    /* access modifiers changed from: 0000 */
    public void b(View view) {
        if (n.m().o && n.m().j != null) {
            n.m().j.B();
        }
        Intent intent = new Intent();
        intent.putExtra("timeTakenToClickRetakeButton", this.f2963e.c().longValue());
        setResult(6, intent);
        finish();
    }

    public void d() {
        setResult(5);
        finish();
    }

    public boolean e() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void k() {
        try {
            Bitmap a2 = g.a(this.r);
            if (a2 != null) {
                Bitmap a3 = h.a(this, a2, this.w, this.v, h.a((Context) this, 10.0f), this.x.isShouldSetPadding());
                a2.recycle();
                runOnUiThread(new Runnable(a3) {
                    public final /* synthetic */ Bitmap f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        HVDocReviewActivity.this.a(this.f$1);
                    }
                });
            }
        } catch (Exception e2) {
            i.a((Throwable) e2);
            if (n.m().i != null) {
                n.m().i.a(e2);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1002405177, bundle);
    }

    public void onRemoteConfigFetchDone() {
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, -641869270, new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: 0000 */
    public void a(File file) {
        ArrayList arrayList = new ArrayList();
        try {
            PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(file, ClientDefaults.MAX_MSG_SIZE));
            int pageCount = pdfRenderer.getPageCount();
            for (int i2 = 0; i2 < pageCount; i2++) {
                Page openPage = pdfRenderer.openPage(i2);
                Bitmap createBitmap = Bitmap.createBitmap(openPage.getWidth(), openPage.getHeight(), Config.ARGB_8888);
                openPage.render(createBitmap, null, null, 1);
                arrayList.add(createBitmap);
                openPage.close();
            }
            pdfRenderer.close();
        } catch (Exception | OutOfMemoryError e2) {
            i.a(e2);
        }
        runOnUiThread(new Runnable(arrayList) {
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                HVDocReviewActivity.this.a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public /* synthetic */ void b(AtomicInteger atomicInteger, List list, View view) {
        int i2 = atomicInteger.get();
        boolean z2 = true;
        if (i2 < list.size() - 1) {
            i2 = atomicInteger.incrementAndGet();
            b((Bitmap) list.get(i2));
            this.q.setText(String.format(getString(R$string.hv_pdf_page_count), new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(list.size())}));
        }
        this.h.setEnabled(i2 != 0 && list.size() > 1);
        FloatingActionButton floatingActionButton = this.i;
        if (i2 == list.size() - 1 || list.size() <= 1) {
            z2 = false;
        }
        floatingActionButton.setEnabled(z2);
    }

    public final void b(Bitmap bitmap) {
        if (bitmap != null) {
            this.g.setImageBitmap(bitmap);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(List list) {
        a(false);
        if (list.size() != 0) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            if (list.size() > 1) {
                this.j.setVisibility(0);
            }
            b((Bitmap) list.get(atomicInteger.get()));
            this.q.setText(String.format(getString(R$string.hv_pdf_page_count), new Object[]{Integer.valueOf(atomicInteger.get() + 1), Integer.valueOf(list.size())}));
            this.h.setOnClickListener(new OnClickListener(atomicInteger, list) {
                public final /* synthetic */ AtomicInteger f$1;
                public final /* synthetic */ List f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    HVDocReviewActivity.this.a(this.f$1, this.f$2, view);
                }
            });
            this.i.setOnClickListener(new OnClickListener(atomicInteger, list) {
                public final /* synthetic */ AtomicInteger f$1;
                public final /* synthetic */ List f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    HVDocReviewActivity.this.b(this.f$1, this.f$2, view);
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Bitmap bitmap) {
        a(false);
        if (bitmap == null) {
            HVError hVError = new HVError(2, "Error while processing the document");
            Intent intent = new Intent();
            intent.putExtra("hvError", hVError);
            setResult(8, intent);
            finish();
            return;
        }
        b(bitmap);
    }

    public final void a(boolean z2) {
        int i2 = 0;
        this.k.setVisibility(z2 ? 0 : 8);
        this.p.setVisibility(z2 ? 4 : 0);
        TextView textView = this.o;
        if (z2) {
            i2 = 4;
        }
        textView.setVisibility(i2);
    }

    /* access modifiers changed from: 0000 */
    public /* synthetic */ void a(AtomicInteger atomicInteger, List list, View view) {
        int i2 = atomicInteger.get();
        boolean z2 = false;
        if (i2 > 0) {
            i2 = atomicInteger.decrementAndGet();
            b((Bitmap) list.get(i2));
            this.q.setText(String.format(getString(R$string.hv_pdf_page_count), new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(list.size())}));
        }
        this.h.setEnabled(i2 != 0 && list.size() > 1);
        FloatingActionButton floatingActionButton = this.i;
        if (i2 != list.size() - 1 && list.size() > 1) {
            z2 = true;
        }
        floatingActionButton.setEnabled(z2);
    }

    public HVBaseConfig a() {
        return this.x;
    }
}
