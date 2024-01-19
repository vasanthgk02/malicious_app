package com.freshchat.consumer.sdk.j.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.freshchat.consumer.sdk.j.ai;
import java.lang.ref.WeakReference;

public abstract class f {
    public com.freshchat.consumer.sdk.f.a bZ;
    public d kc;
    public com.freshchat.consumer.sdk.j.a.d.a kd;
    public Bitmap ke;
    public boolean kf = true;
    public boolean kg = false;
    public boolean kh = false;
    public final Object ki = new Object();
    public Resources kj;

    public static class a extends BitmapDrawable {
        public final WeakReference<b> kk;

        public a(Resources resources, Bitmap bitmap, b bVar) {
            super(resources, bitmap);
            this.kk = new WeakReference<>(bVar);
        }

        public b fz() {
            return (b) this.kk.get();
        }
    }

    public class b extends a<Object, Void, Bitmap> {
        public Object data;
        public final WeakReference<ImageView> gS;

        public b(ImageView imageView) {
            this.gS = new WeakReference<>(imageView);
        }

        private ImageView fA() {
            ImageView imageView = (ImageView) this.gS.get();
            if (this == f.a(imageView)) {
                return imageView;
            }
            return null;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0010 */
        /* JADX WARNING: Removed duplicated region for block: B:2:0x0010 A[LOOP:0: B:2:0x0010->B:38:0x0010, LOOP_START, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Object... r5) {
            /*
                r4 = this;
                r0 = 0
                r1 = r5[r0]
                r4.data = r1
                java.lang.String r1 = java.lang.String.valueOf(r1)
                com.freshchat.consumer.sdk.j.a.f r2 = com.freshchat.consumer.sdk.j.a.f.this
                java.lang.Object r2 = r2.ki
                monitor-enter(r2)
            L_0x0010:
                com.freshchat.consumer.sdk.j.a.f r3 = com.freshchat.consumer.sdk.j.a.f.this     // Catch:{ all -> 0x0081 }
                boolean r3 = r3.kh     // Catch:{ all -> 0x0081 }
                if (r3 == 0) goto L_0x0026
                boolean r3 = r4.isCancelled()     // Catch:{ all -> 0x0081 }
                if (r3 != 0) goto L_0x0026
                com.freshchat.consumer.sdk.j.a.f r3 = com.freshchat.consumer.sdk.j.a.f.this     // Catch:{ InterruptedException -> 0x0010 }
                java.lang.Object r3 = r3.ki     // Catch:{ InterruptedException -> 0x0010 }
                r3.wait()     // Catch:{ InterruptedException -> 0x0010 }
                goto L_0x0010
            L_0x0026:
                monitor-exit(r2)     // Catch:{ all -> 0x0081 }
                com.freshchat.consumer.sdk.j.a.f r2 = com.freshchat.consumer.sdk.j.a.f.this
                com.freshchat.consumer.sdk.j.a.d r2 = r2.kc
                if (r2 == 0) goto L_0x004e
                boolean r2 = r4.isCancelled()
                if (r2 != 0) goto L_0x004e
                android.widget.ImageView r2 = r4.fA()
                if (r2 == 0) goto L_0x004e
                com.freshchat.consumer.sdk.j.a.f r2 = com.freshchat.consumer.sdk.j.a.f.this
                boolean r2 = r2.kg
                if (r2 != 0) goto L_0x004e
                com.freshchat.consumer.sdk.j.a.f r2 = com.freshchat.consumer.sdk.j.a.f.this
                com.freshchat.consumer.sdk.j.a.d r2 = r2.kc
                android.graphics.Bitmap r2 = r2.bI(r1)
                goto L_0x004f
            L_0x004e:
                r2 = 0
            L_0x004f:
                if (r2 != 0) goto L_0x006d
                boolean r3 = r4.isCancelled()
                if (r3 != 0) goto L_0x006d
                android.widget.ImageView r3 = r4.fA()
                if (r3 == 0) goto L_0x006d
                com.freshchat.consumer.sdk.j.a.f r3 = com.freshchat.consumer.sdk.j.a.f.this
                boolean r3 = r3.kg
                if (r3 != 0) goto L_0x006d
                com.freshchat.consumer.sdk.j.a.f r2 = com.freshchat.consumer.sdk.j.a.f.this
                r5 = r5[r0]
                android.graphics.Bitmap r2 = r2.d(r5)
            L_0x006d:
                if (r2 == 0) goto L_0x0080
                com.freshchat.consumer.sdk.j.a.f r5 = com.freshchat.consumer.sdk.j.a.f.this
                com.freshchat.consumer.sdk.j.a.d r5 = r5.kc
                if (r5 == 0) goto L_0x0080
                com.freshchat.consumer.sdk.j.a.f r5 = com.freshchat.consumer.sdk.j.a.f.this
                com.freshchat.consumer.sdk.j.a.d r5 = r5.kc
                r5.a(r1, r2)
            L_0x0080:
                return r2
            L_0x0081:
                r5 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0081 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.a.f.b.doInBackground(java.lang.Object[]):android.graphics.Bitmap");
        }

        public void onCancelled(Bitmap bitmap) {
            super.onCancelled(bitmap);
            synchronized (f.this.ki) {
                f.this.ki.notifyAll();
            }
        }

        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled() || f.this.kg) {
                bitmap = null;
            }
            ImageView fA = fA();
            if (bitmap == null || fA == null) {
                f.this.fx();
                return;
            }
            ai.d("ImageWorker", "onPostExecute - setting bitmap");
            f.this.a(fA, bitmap);
        }
    }

    public class c extends a<Object, Void, Void> {
        public c() {
        }

        public Void doInBackground(Object... objArr) {
            int intValue = objArr[0].intValue();
            if (intValue == 0) {
                f.this.fr();
            } else if (intValue == 1) {
                f.this.fp();
            } else if (intValue == 2) {
                f.this.fs();
            } else if (intValue == 3) {
                f.this.ft();
            } else if (intValue == 4) {
                f.this.fy();
            }
            return null;
        }
    }

    public f(Context context) {
        this.kj = context.getResources();
    }

    public static b a(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof a) {
                return ((a) drawable).fz();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(ImageView imageView, Bitmap bitmap) {
        if (this.kf) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), new BitmapDrawable(this.kj, bitmap)});
            imageView.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(200);
        } else {
            imageView.setImageBitmap(bitmap);
        }
        fw();
    }

    public static boolean b(Object obj, ImageView imageView) {
        b a2 = a(imageView);
        if (a2 != null) {
            Object a3 = a2.data;
            if (a3 != null && a3.equals(obj)) {
                return false;
            }
            a2.cancel(true);
            ai.d("ImageWorker", "cancelPotentialWork - cancelled work for " + obj);
        }
        return true;
    }

    private void fv() {
        com.freshchat.consumer.sdk.f.a aVar = this.bZ;
        if (aVar != null) {
            aVar.aG();
        }
    }

    private void fw() {
        com.freshchat.consumer.sdk.f.a aVar = this.bZ;
        if (aVar != null) {
            aVar.aH();
        }
    }

    /* access modifiers changed from: private */
    public void fx() {
        com.freshchat.consumer.sdk.f.a aVar = this.bZ;
        if (aVar != null) {
            aVar.aI();
        }
    }

    public void a(d dVar) {
        this.kc = dVar;
    }

    public void a(Object obj, ImageView imageView) {
        if (obj != null) {
            Bitmap bitmap = null;
            d dVar = this.kc;
            if (dVar != null) {
                bitmap = dVar.bH(String.valueOf(obj));
            }
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else if (b(obj, imageView)) {
                fv();
                b bVar = new b(imageView);
                imageView.setImageDrawable(new a(this.kj, this.ke, bVar));
                bVar.a(a.iL, (Params[]) new Object[]{obj});
            }
        }
    }

    public void a(Object obj, ImageView imageView, com.freshchat.consumer.sdk.f.a aVar) {
        this.bZ = aVar;
        a(obj, imageView);
    }

    public void c(com.freshchat.consumer.sdk.j.a.d.a aVar) {
        this.kd = aVar;
        a(d.a(aVar));
        new c().a((Params[]) new Object[]{Integer.valueOf(1)});
    }

    public abstract Bitmap d(Object obj);

    public void fp() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.jX();
        }
    }

    public void fr() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.clearCache();
        }
    }

    public void fs() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.flush();
        }
    }

    public void ft() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.close();
            this.kc = null;
        }
    }

    public void fy() {
        d dVar = this.kc;
        if (dVar != null) {
            dVar.jY();
            this.kc = null;
        }
    }
}
