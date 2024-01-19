package com.userexperior.services.recording;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InputEvent;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.R;
import com.userexperior.UserExperior;
import com.userexperior.interfaces.recording.f;
import com.userexperior.models.recording.a;
import com.userexperior.models.recording.e;
import com.userexperior.models.recording.enums.h;
import com.userexperior.models.recording.g;
import com.userexperior.utilities.SecureViewBucket;
import com.userexperior.utilities.b;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

public class c extends TimerTask {

    /* renamed from: d  reason: collision with root package name */
    public static final String f4122d = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Activity f4123a;

    /* renamed from: b  reason: collision with root package name */
    public int f4124b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4125c;

    /* renamed from: e  reason: collision with root package name */
    public final Messenger f4126e;

    /* renamed from: f  reason: collision with root package name */
    public final Messenger f4127f;
    public List<View> g;
    public Bitmap h;
    public List<com.userexperior.models.recording.enums.c> i = new ArrayList();
    public double j = 4.5d;
    public int k = 1;
    public final boolean l;
    public final Semaphore m;
    public final boolean n;
    public final Options o = new Options();
    public final Options p = new Options();
    public final Options q = new Options();
    public final Options r = new Options();
    public final Options s = new Options();
    public String t = "";
    public final Options u = new Options();

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0078, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.app.Activity r4, android.os.Messenger r5, android.os.Messenger r6) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.f4124b = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3.i = r1
            r1 = 4616752568008179712(0x4012000000000000, double:4.5)
            r3.j = r1
            r1 = 1
            r3.k = r1
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3.o = r2
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3.p = r2
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3.q = r2
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3.r = r2
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3.s = r2
            java.lang.String r2 = ""
            r3.t = r2
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3.u = r2
            r3.f4126e = r5
            r3.f4127f = r6
            r3.a(r4)
            android.graphics.Bitmap r4 = b()
            r3.h = r4
            android.content.Context r4 = com.userexperior.utilities.a.a()
            java.lang.String r5 = "UserExperior"
            android.content.SharedPreferences r5 = r4.getSharedPreferences(r5, r0)
            java.lang.String r6 = "autoMasking"
            boolean r5 = r5.getBoolean(r6, r1)
            r3.l = r5
            int r5 = com.userexperior.utilities.l.p(r4)
            r3.k = r5
            java.util.concurrent.Semaphore r5 = new java.util.concurrent.Semaphore
            r5.<init>(r1)
            r3.m = r5
            com.userexperior.c.b.a r4 = com.userexperior.utilities.l.e(r4)
            if (r4 == 0) goto L_0x0079
            boolean r4 = r4.l
            if (r4 == 0) goto L_0x0079
            r0 = 1
        L_0x0079:
            r3.n = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.c.<init>(android.app.Activity, android.os.Messenger, android.os.Messenger):void");
    }

    public static Activity a(Context context) {
        while (context != null) {
            if (!(context instanceof Activity)) {
                if (!(context instanceof ContextWrapper) || (context instanceof Application)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Object a(String str, Object obj) {
        try {
            Class cls = obj.getClass();
            for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
                for (Field field : cls2.getDeclaredFields()) {
                    if (str.equals(field.getName())) {
                        field.setAccessible(true);
                        return field.get(obj);
                    }
                }
            }
            throw new NoSuchFieldException("Field " + str + " not found for class " + cls);
        } catch (Exception e2) {
            b.a(Level.SEVERE, "Error getFieldValue(): " + e2.getMessage());
            throw new d(e2, 0);
        }
    }

    public static /* synthetic */ void a(int i2) {
    }

    private void a(ViewGroup viewGroup) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt);
                if (d(childAt)) {
                    if (this.g.contains(childAt)) {
                    }
                }
            } else {
                if (childAt != null) {
                    if (d(childAt)) {
                        if (this.g.contains(childAt)) {
                        }
                    }
                }
            }
            this.g.add(childAt);
        }
    }

    private void a(e eVar, Bitmap bitmap) {
        List<g> list = eVar.f4080a;
        if (list != null) {
            this.s.inBitmap = bitmap;
            for (final g next : list) {
                if (next != null) {
                    if ((next.f4093d & 2) == 2) {
                        new Canvas(this.s.inBitmap).drawARGB((int) (next.f4094e * 255.0f), 0, 0, 0);
                    }
                    if (next.f4095f.inBitmap != null) {
                        Canvas canvas = new Canvas(this.s.inBitmap);
                        if (!next.f4095f.inBitmap.isRecycled()) {
                            canvas.drawBitmap(next.f4095f.inBitmap, (float) next.f4091b, (float) next.f4092c, null);
                            List<Rect> a2 = eVar.a(next.f4090a);
                            if (a2 != null) {
                                a(a2, this.s.inBitmap);
                            }
                            Activity a3 = i.a();
                            if (a3 != null) {
                                a3.runOnUiThread(new Runnable() {
                                    public final void run() {
                                        next.f4095f.inBitmap.recycle();
                                    }
                                });
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(e eVar) {
        Iterator<View> it = eVar.f4135a.getTouchables().iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next instanceof EditText) {
                c(next);
                if ((next.getTag() == null || !next.getTag().equals("com.userexperior.dontmask")) && ((next.getTag(R.string.ue_dont_mask) == null || !next.getTag(R.string.ue_dont_mask).equals("com.userexperior.dontmask")) && this.l)) {
                    next.setTag(R.string.ue_mask, "com.userexperior.ueSecureView");
                }
            }
        }
    }

    public static void a(List<e> list) {
        if (list.size() > 1) {
            for (int i2 = 0; i2 < list.size() - 1; i2++) {
                e eVar = list.get(i2);
                if (eVar.a()) {
                    Activity a2 = a(eVar.f4135a.getContext());
                    if (a2 != null) {
                        int i3 = i2 + 1;
                        while (true) {
                            if (i3 >= list.size()) {
                                break;
                            }
                            e eVar2 = list.get(i3);
                            if ((eVar2.f4137c.type == 1) && a(eVar2.f4135a.getContext()) == a2) {
                                list.remove(eVar2);
                                list.add(i2, eVar2);
                                break;
                            }
                            i3++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void a(List<Rect> list, Bitmap bitmap) {
        if (!(bitmap == null || list == null || list.size() == 0)) {
            this.r.inBitmap = bitmap;
            Canvas canvas = new Canvas(this.r.inBitmap);
            for (Rect drawBitmap : list) {
                canvas.drawBitmap(this.h, null, drawBitmap, null);
            }
        }
    }

    public static Bitmap b() {
        Bitmap createBitmap = Bitmap.createBitmap(294, 208, Config.RGB_565);
        createBitmap.eraseColor(-16777216);
        return createBitmap;
    }

    private g b(e eVar) {
        boolean z;
        boolean z2;
        final e eVar2 = eVar;
        if (eVar2 == null) {
            return null;
        }
        View view = eVar2.f4135a;
        if (view == null) {
            return null;
        }
        if (view.getMeasuredHeight() <= 0 || eVar2.f4135a.getMeasuredWidth() <= 0) {
            return null;
        }
        this.u.inBitmap = Bitmap.createBitmap(eVar2.f4135a.getWidth() / 4, eVar2.f4135a.getHeight() / 4, Config.ARGB_8888);
        final Canvas canvas = new Canvas(this.u.inBitmap);
        try {
            a(eVar);
            String simpleName = this.f4123a != null ? this.f4123a.getClass().getSimpleName() : "";
            if (eVar.a()) {
                if (eVar2.f4135a instanceof ViewGroup) {
                    String h2 = a.h();
                    if (h2 == null || !h2.equals(this.t)) {
                        ArrayList<View> touchables = eVar2.f4135a.getTouchables();
                        this.t = "Dialog: " + simpleName + ": ";
                        String str = "";
                        int i2 = 0;
                        while (i2 < touchables.size() && i2 != 3) {
                            str = str.concat(b(touchables.get(i2)) + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            i2++;
                        }
                        if (!str.trim().equals("")) {
                            String concat = this.t.concat(str);
                            this.t = concat;
                            UserExperior.startScreen(concat);
                        }
                    }
                }
                Iterator<View> it = eVar2.f4135a.getTouchables().iterator();
                while (it.hasNext()) {
                    View next = it.next();
                    if (next instanceof EditText) {
                        c(next);
                        if (next.getTag() != null) {
                            if (next.getTag().equals("com.userexperior.dontmask")) {
                                z2 = true;
                                if (next.getTag(R.string.ue_dont_mask) != null && next.getTag(R.string.ue_dont_mask).equals("com.userexperior.dontmask")) {
                                    z2 = true;
                                }
                                if (this.l && !z2) {
                                    next.setTag(R.string.ue_mask, "com.userexperior.ueSecureView");
                                }
                            }
                        }
                        z2 = false;
                        z2 = true;
                        next.setTag(R.string.ue_mask, "com.userexperior.ueSecureView");
                    }
                    next.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            String str;
                            CharSequence charSequence;
                            if (motionEvent.getAction() == 1) {
                                if (c.this.n) {
                                    if (view instanceof TextView) {
                                        if (view instanceof EditText) {
                                            EditText editText = (EditText) view;
                                            if (editText.getHint() != null) {
                                                charSequence = editText.getHint();
                                            } else {
                                                str = c.b((View) editText) != null ? c.b((View) editText) : "Edit Box";
                                                f.g().a(h.TAP, c.this.t, (InputEvent) MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 1, motionEvent.getRawX(), motionEvent.getRawY(), 0), (com.userexperior.interfaces.recording.g) new f(str, false));
                                            }
                                        } else {
                                            TextView textView = (TextView) view;
                                            if (textView.getText() != null) {
                                                charSequence = textView.getText();
                                            }
                                        }
                                    } else if ((view instanceof ImageView) && view.getContentDescription() != null) {
                                        charSequence = view.getContentDescription();
                                    }
                                    str = charSequence.toString();
                                    f.g().a(h.TAP, c.this.t, (InputEvent) MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 1, motionEvent.getRawX(), motionEvent.getRawY(), 0), (com.userexperior.interfaces.recording.g) new f(str, false));
                                }
                                str = "";
                                f.g().a(h.TAP, c.this.t, (InputEvent) MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 1, motionEvent.getRawX(), motionEvent.getRawY(), 0), (com.userexperior.interfaces.recording.g) new f(str, false));
                            }
                            return false;
                        }
                    });
                }
            }
            String h3 = a.h();
            if (this.f4123a != null && this.f4123a.hasWindowFocus() && !simpleName.equals("UeConsentActivity") && h3 != null && h3.contains("Dialog: ")) {
                UserExperior.startScreen(simpleName);
            }
            Iterator<View> it2 = eVar2.f4135a.getTouchables().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next() instanceof WebView) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (VERSION.SDK_INT >= 26) {
                if (z) {
                    int[] iArr = new int[2];
                    eVar2.f4135a.getLocationInWindow(iArr);
                    PixelCopy.request(this.f4123a.getWindow(), new Rect(iArr[0], iArr[1], iArr[0] + eVar2.f4135a.getWidth(), iArr[1] + eVar2.f4135a.getHeight()), this.u.inBitmap, $$Lambda$FRdcsUt94u6SzONuWCaq9YbxNQ.INSTANCE, new Handler(Looper.getMainLooper()));
                } else if (this.f4123a == null) {
                    return null;
                } else {
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    this.f4123a.runOnUiThread(new Runnable() {
                        public final void run() {
                            try {
                                canvas.scale(0.25f, 0.25f);
                                eVar2.f4135a.draw(canvas);
                            } catch (Exception e2) {
                                c.f4122d;
                                new StringBuilder("exception ").append(e2.getMessage());
                            } catch (Throwable th) {
                                countDownLatch.countDown();
                                throw th;
                            }
                            countDownLatch.countDown();
                        }
                    });
                    countDownLatch.await();
                }
            }
            this.i = e();
            Rect rect = eVar2.f4136b;
            int i3 = rect.top / 4;
            LayoutParams layoutParams = eVar2.f4137c;
            g gVar = new g(eVar2.f4135a, this.u.inBitmap, rect.left / 4, i3, layoutParams.flags, layoutParams.dimAmount);
            return gVar;
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex: CST - gVB " + e2.getMessage());
            StringBuilder sb = new StringBuilder("frame number ");
            sb.append(this.f4124b);
            sb.append(" skipped");
            return null;
        } catch (OutOfMemoryError e3) {
            Level level2 = Level.SEVERE;
            b.a(level2, "Ex: CST - gVB " + e3.getMessage());
            StringBuilder sb2 = new StringBuilder("frame number ");
            sb2.append(this.f4124b);
            sb2.append(" skipped");
            return null;
        }
    }

    @SuppressLint({"ResourceType"})
    public static String b(View view) {
        String str;
        Exception e2;
        if (view == null) {
            return null;
        }
        try {
            if (view.getId() == -1) {
                return null;
            }
            str = view.getResources().getResourceName(view.getId());
            try {
                str = str.substring(str.indexOf(":id/") + 4);
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
                return str;
            }
            return str;
        } catch (Exception e4) {
            e2 = e4;
            str = null;
            e2.printStackTrace();
            return str;
        }
    }

    public static void b(List<e> list) {
        try {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            for (e next : list) {
                if (next.f4136b.top < i2) {
                    i2 = next.f4136b.top;
                }
                if (next.f4136b.left < i3) {
                    i3 = next.f4136b.left;
                }
            }
            for (e eVar : list) {
                eVar.f4136b.offset(-i3, -i2);
            }
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex: CST - oRTL " + e2.getMessage());
            e2.printStackTrace();
        }
    }

    private Bitmap c(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            this.p.inBitmap = e(activity);
        } catch (Exception unused) {
            b.a(Level.INFO, "CST - cB : frame skipped.");
        } catch (OutOfMemoryError e2) {
            Level level = Level.INFO;
            b.a(level, "CST - cB : frame skipped: " + e2.getMessage());
        }
        return this.p.inBitmap;
    }

    private void c() {
        Activity activity = this.f4123a;
        if (activity != null) {
            try {
                for (View next : activity.getWindow().getDecorView().getRootView().getTouchables()) {
                    if (next != null && (next instanceof EditText)) {
                        if (next.getTag() != null) {
                            if (next.getTag().equals("com.userexperior.dontmask")) {
                            }
                        }
                        if ((next.getTag(R.string.ue_dont_mask) == null || !next.getTag(R.string.ue_dont_mask).equals("com.userexperior.dontmask")) && this.l) {
                            next.setTag(R.string.ue_mask, "com.userexperior.ueSecureView");
                        }
                    }
                }
            } catch (Exception e2) {
                GeneratedOutlineSupport.outline95(e2, new StringBuilder("sampeb : "), Level.INFO);
            }
        }
    }

    public static void c(View view) {
        EditText editText = (EditText) view;
        if (editText.getInputType() == 129 || editText.getInputType() == 145 || editText.getInputType() == 225 || editText.getInputType() == 18) {
            view.setTag(R.string.ue_mask, "com.userexperior.ueSecureView");
        }
    }

    private double d() {
        double d2;
        Activity activity = this.f4123a;
        if (activity == null) {
            return this.j;
        }
        double d3 = 0.0d;
        try {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            Point point = new Point();
            Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
            int i2 = point.x;
            int i3 = point.y;
            d2 = Math.pow((double) (((float) i2) / displayMetrics.xdpi), 2.0d);
            try {
                d3 = Math.pow((double) (((float) i3) / displayMetrics.ydpi), 2.0d);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return Double.valueOf(String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(Math.sqrt(d2 + d3))})).doubleValue();
            }
        } catch (Exception e3) {
            e = e3;
            d2 = 0.0d;
            e.printStackTrace();
            return Double.valueOf(String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(Math.sqrt(d2 + d3))})).doubleValue();
        }
        return Double.valueOf(String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(Math.sqrt(d2 + d3))})).doubleValue();
    }

    private List<e> d(Activity activity) {
        ArrayList arrayList = new ArrayList();
        Object a2 = a((String) "mGlobal", (Object) activity.getWindowManager());
        Object a3 = a((String) "mRoots", a2);
        Object a4 = a((String) "mParams", a2);
        LayoutParams[] layoutParamsArr = new LayoutParams[0];
        Object[] array = ((List) a3).toArray();
        try {
            List list = (List) a4;
            if (list != null) {
                layoutParamsArr = (LayoutParams[]) list.toArray(new LayoutParams[list.size()]);
            }
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex: CST - gRV " + e2.getMessage());
            e2.getMessage();
        }
        for (int i2 = 0; i2 < array.length; i2++) {
            View view = (View) a((String) "mView", array[i2]);
            if (view != null && view.isShown()) {
                try {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    arrayList.add(new e(view, new Rect(i3, i4, view.getWidth() + i3, view.getHeight() + i4), layoutParamsArr[i2]));
                } catch (Exception e3) {
                    GeneratedOutlineSupport.outline95(e3, new StringBuilder("Ex: CST - gRV roots "), Level.SEVERE);
                }
                if (view instanceof ViewGroup) {
                    a((ViewGroup) view);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        b((List<e>) arrayList);
        a((List<e>) arrayList);
        return arrayList;
    }

    public static boolean d(View view) {
        try {
            if (view.getTag() != null) {
                if (view.getTag().equals("com.userexperior.ueSecureView")) {
                    return true;
                }
            }
            if (view.getTag(R.string.ue_mask) != null && view.getTag(R.string.ue_mask).equals("com.userexperior.ueSecureView")) {
                return true;
            }
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "Ex: CST - iSVBT " + e2.getMessage());
            e2.getMessage();
        }
        return false;
    }

    private Bitmap e(Activity activity) throws InterruptedException {
        String str;
        StringBuilder sb;
        List<e> d2 = d(activity);
        if (d2.isEmpty()) {
            return null;
        }
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        int i3 = LinearLayoutManager.INVALID_OFFSET;
        for (e next : d2) {
            int i4 = next.f4136b.right;
            if (i4 > i2) {
                i2 = i4;
            }
            int i5 = next.f4136b.bottom;
            if (i5 > i3) {
                i3 = i5;
            }
        }
        if (i2 > 0 && i3 > 0) {
            this.q.inBitmap = Bitmap.createBitmap(i2 / 4, i3 / 4, Config.ARGB_8888);
            e eVar = new e();
            try {
                ArrayList arrayList = new ArrayList();
                for (e b2 : d2) {
                    g b3 = b(b2);
                    if (b3 != null) {
                        arrayList.add(b3);
                    }
                }
                eVar.f4080a = arrayList;
                eVar.f4081b = this.i;
            } catch (Exception e2) {
                Level level = Level.SEVERE;
                b.a(level, "Ex: CST - tBFAB " + e2.getMessage());
                sb = new StringBuilder("Error : ");
                str = e2.getMessage();
                sb.append(str);
                List<g> list = eVar.f4080a;
                a(eVar, this.q.inBitmap);
                return this.q.inBitmap;
            } catch (OutOfMemoryError e3) {
                Level level2 = Level.SEVERE;
                b.a(level2, "Ex: CST - tBFAB " + e3.getMessage());
                sb = new StringBuilder("Error : ");
                str = e3.getMessage();
                sb.append(str);
                List<g> list2 = eVar.f4080a;
                a(eVar, this.q.inBitmap);
                return this.q.inBitmap;
            }
            List<g> list22 = eVar.f4080a;
            if (!(list22 == null || list22.size() == 0)) {
                a(eVar, this.q.inBitmap);
                return this.q.inBitmap;
            }
        }
        return null;
    }

    private List<com.userexperior.models.recording.enums.c> e() {
        ArrayList arrayList = new ArrayList();
        List<View> list = this.g;
        if (list != null && !list.isEmpty()) {
            for (View next : this.g) {
                if (next != null) {
                    Rect rect = new Rect();
                    if (next.getGlobalVisibleRect(rect)) {
                        rect.bottom /= 4;
                        rect.right /= 4;
                        rect.top /= 4;
                        rect.left /= 4;
                        arrayList.add(new com.userexperior.models.recording.enums.c(rect, next.getRootView()));
                        try {
                            int[] iArr = new int[2];
                            next.getLocationOnScreen(iArr);
                            arrayList.add(new com.userexperior.models.recording.enums.c(new Rect(iArr[0] / 4, iArr[1] / 4, (iArr[0] / 4) + (next.getWidth() / 4), (iArr[1] / 4) + (next.getHeight() / 4)), next.getRootView()));
                        } catch (Exception e2) {
                            GeneratedOutlineSupport.outline95(e2, new StringBuilder("Ex: CST - fRM "), Level.SEVERE);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final void a(Activity activity) {
        this.f4123a = activity;
        if (activity != null) {
            new StringBuilder("UE : CP TASK -> setLatestActivity : ").append(activity.toString());
            this.j = d();
            try {
                b(activity);
            } catch (Exception e2) {
                Level level = Level.SEVERE;
                b.a(level, "Ex: CST - SLA " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public final void b(Activity activity) {
        if (activity != null) {
            if (this.g == null) {
                this.g = new ArrayList();
            }
            List<View> a2 = SecureViewBucket.a(activity);
            if (a2 != null && !a2.isEmpty()) {
                this.g.addAll(a2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.userexperior.utilities.b.a(java.util.logging.Level.INFO, "Error: CST - Out of Memory, Can't create bitmap.....");
        r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0104, code lost:
        com.userexperior.utilities.b.a(java.util.logging.Level.SEVERE, "ex - CST - dsc : " + r0.getMessage());
        r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7 A[ExcHandler: OutOfMemoryError (r0v9 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:17:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: Error | Exception | OutOfMemoryError (unused java.lang.Throwable), SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            java.util.concurrent.Semaphore r0 = r6.m     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.acquire()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r1 = 1
            r0.setPriority(r1)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            android.os.Messenger r0 = r6.f4127f     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            if (r0 == 0) goto L_0x003f
            android.os.Messenger r0 = r6.f4127f     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            android.os.Message r2 = android.os.Message.obtain()     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            r3 = 234119(0x39287, float:3.2807E-40)
            r2.what = r3     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            int r3 = r6.f4124b     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            r2.arg1 = r3     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.send(r2)     // Catch:{ RemoteException -> 0x0024, Error | Exception | OutOfMemoryError -> 0x0138, Error | Exception | OutOfMemoryError -> 0x0138 }
            goto L_0x003f
        L_0x0024:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r4 = "Error CST - updateTime(): "
            r3.<init>(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r3.append(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r3 = r3.toString()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.printStackTrace()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
        L_0x003f:
            android.graphics.Bitmap r0 = r6.h     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            if (r0 != 0) goto L_0x0049
            android.graphics.Bitmap r0 = b()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r6.h = r0     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
        L_0x0049:
            android.app.Activity r0 = r6.f4123a     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r2 = "screenshot_num = "
            if (r0 == 0) goto L_0x011f
            r6.c()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            android.graphics.BitmapFactory$Options r0 = r6.o     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.app.Activity r3 = r6.f4123a     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.Bitmap r3 = r6.c(r3)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r0.inBitmap = r3     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.BitmapFactory$Options r0 = r6.o     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            if (r0 == 0) goto L_0x00e7
            int r0 = r6.k     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r2 = 2
            if (r0 != r2) goto L_0x0073
            android.graphics.BitmapFactory$Options r0 = r6.o     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.BitmapFactory$Options r2 = r6.o     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.Bitmap r2 = r2.inBitmap     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.Bitmap r2 = com.userexperior.e.h.a(r2)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r0.inBitmap = r2     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
        L_0x0073:
            boolean r0 = r6.f4125c     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            if (r0 != 0) goto L_0x012e
            android.graphics.BitmapFactory$Options r0 = r6.o     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.graphics.Bitmap r0 = r0.inBitmap     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            int r2 = r6.f4124b     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            android.os.Messenger r3 = r6.f4126e     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            if (r3 == 0) goto L_0x012e
            android.os.Messenger r3 = r6.f4126e     // Catch:{ DeadObjectException -> 0x0095 }
            android.os.Message r4 = android.os.Message.obtain()     // Catch:{ DeadObjectException -> 0x0095 }
            r5 = 234567(0x39447, float:3.28698E-40)
            r4.what = r5     // Catch:{ DeadObjectException -> 0x0095 }
            r4.obj = r0     // Catch:{ DeadObjectException -> 0x0095 }
            r4.arg1 = r2     // Catch:{ DeadObjectException -> 0x0095 }
            r3.send(r4)     // Catch:{ DeadObjectException -> 0x0095 }
            goto L_0x012e
        L_0x0095:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            java.lang.String r4 = "Error CST - saveBMP() -DeadObject- : "
            r3.<init>(r4)     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            r3.append(r0)     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            java.lang.String r0 = r3.toString()     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            com.userexperior.utilities.b.a(r2, r0)     // Catch:{ RemoteException -> 0x00cb, Exception -> 0x00af, OutOfMemoryError -> 0x00f7 }
            goto L_0x012e
        L_0x00af:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r4 = "Ex: CST - sBMP "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r3.append(r4)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r0.printStackTrace()     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            goto L_0x012e
        L_0x00cb:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r4 = "Error CST - saveBMP() -RemoteException- : "
            r3.<init>(r4)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r3.append(r4)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r0.printStackTrace()     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            goto L_0x012e
        L_0x00e7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            int r2 = r6.f4124b     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            r0.append(r2)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            java.lang.String r2 = " failed during save"
            r0.append(r2)     // Catch:{ Exception -> 0x0103, OutOfMemoryError -> 0x00f7 }
            goto L_0x012e
        L_0x00f7:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.INFO     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r3 = "Error: CST - Out of Memory, Can't create bitmap....."
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.getMessage()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            goto L_0x012e
        L_0x0103:
            r0 = move-exception
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r4 = "ex - CST - dsc : "
            r3.<init>(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r3.append(r4)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r3 = r3.toString()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            com.userexperior.utilities.b.a(r2, r3)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.getMessage()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            goto L_0x012e
        L_0x011f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.<init>(r2)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            int r2 = r6.f4124b     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.append(r2)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.lang.String r2 = " failed as latest activity is null"
            r0.append(r2)     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
        L_0x012e:
            int r0 = r6.f4124b     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            int r0 = r0 + r1
            r6.f4124b = r0     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            java.util.concurrent.Semaphore r0 = r6.m     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
            r0.release()     // Catch:{ Error | Exception | OutOfMemoryError -> 0x0138 }
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.services.recording.c.run():void");
    }
}
