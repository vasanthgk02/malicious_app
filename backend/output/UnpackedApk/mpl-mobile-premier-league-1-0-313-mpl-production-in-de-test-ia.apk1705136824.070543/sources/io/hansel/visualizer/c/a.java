package io.hansel.visualizer.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.ui.ScreenshotShareReferral;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.userexperior.e.h;
import io.hansel.R;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogLevel;
import io.hansel.core.logger.HSLLogModel;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.EventsConstants;
import io.hansel.core.sdkmodels.HSLSDKIdentifiers;
import io.hansel.core.utils.HSLUtils;
import io.hansel.hanselsdk.Hansel;
import io.hansel.userjourney.q;
import io.hansel.visualizer.DOM;
import io.hansel.visualizer.HSLVisualizer;
import io.hansel.visualizer.c.d.g;
import io.hansel.visualizer.c.d.i;
import io.hansel.visualizer.f.f;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;

public class a implements io.hansel.visualizer.f.e {
    public static a l;

    /* renamed from: a  reason: collision with root package name */
    public HSLVisualizer f5767a;

    /* renamed from: b  reason: collision with root package name */
    public DOM f5768b;

    /* renamed from: c  reason: collision with root package name */
    public io.hansel.visualizer.f.b f5769c;

    /* renamed from: d  reason: collision with root package name */
    public ByteArrayOutputStream f5770d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f5771e;

    /* renamed from: f  reason: collision with root package name */
    public Context f5772f;
    public HSLSDKIdentifiers g;
    public boolean h;
    public Bitmap i;
    public CountDownLatch j;
    public c k = new C0088a();

    /* renamed from: io.hansel.visualizer.c.a$a  reason: collision with other inner class name */
    public class C0088a implements c {
        public C0088a() {
        }

        public void a(Bitmap bitmap) {
            a.this.i = bitmap;
            if (a.this.j != null) {
                a.this.j.countDown();
            }
        }

        public void a(String str, Window window) {
            try {
                View decorView = window.getDecorView();
                decorView.setDrawingCacheEnabled(true);
                a.this.i = Bitmap.createBitmap(decorView.getDrawingCache());
                decorView.setDrawingCacheEnabled(false);
                if (a.this.j == null) {
                    return;
                }
            } catch (Throwable th) {
                if (a.this.j != null) {
                    a.this.j.countDown();
                }
                throw th;
            }
            a.this.j.countDown();
        }
    }

    public class b implements Runnable {
        public b(a aVar) {
        }

        public void run() {
            Hansel.showToast("Please restart the app.", false);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5774a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0016 */
        static {
            /*
                io.hansel.visualizer.f.f[] r0 = io.hansel.visualizer.f.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5774a = r0
                r1 = 2
                io.hansel.visualizer.f.f r2 = io.hansel.visualizer.f.f.ws_active     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f5774a     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.hansel.visualizer.f.f r2 = io.hansel.visualizer.f.f.ws_fetch_device_state     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 6
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r0 = f5774a     // Catch:{ NoSuchFieldError -> 0x001e }
                io.hansel.visualizer.f.f r1 = io.hansel.visualizer.f.f.ws_need_restart     // Catch:{ NoSuchFieldError -> 0x001e }
                r1 = 7
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.c.a.c.<clinit>():void");
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public /* synthetic */ d(a aVar, C0088a aVar2) {
            this();
        }

        public void run() {
            try {
                a.this.f5767a.getLinkedMessageBroker().publishBlockingEvent(EventsConstants.DISMISS_PROMPT.name(), null);
                Object returnEventData = a.this.f5767a.getLinkedMessageBroker().returnEventData(EventsConstants.GET_TOP_ACTIVITY.name(), null);
                if (returnEventData instanceof Activity) {
                    Activity activity = (Activity) returnEventData;
                    View decorView = activity.getWindow().getDecorView();
                    CoreJSONObject coreJSONObject = new CoreJSONObject();
                    io.hansel.core.base.utils.a.a(decorView, coreJSONObject);
                    CoreJSONObject c2 = a.this.g();
                    Handler d2 = a.this.f5771e;
                    e eVar = new e(activity, c2, coreJSONObject.getInt("w"), coreJSONObject.getInt(h.f3998a));
                    d2.post(eVar);
                }
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final Activity f5776a;

        /* renamed from: b  reason: collision with root package name */
        public final CoreJSONObject f5777b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5778c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5779d;

        public e(Activity activity, CoreJSONObject coreJSONObject, int i, int i2) {
            this.f5776a = activity;
            this.f5777b = coreJSONObject;
            this.f5778c = HSLUtils.dpToPx(i);
            this.f5779d = HSLUtils.dpToPx(i2);
        }

        public void run() {
            CoreJSONObject coreJSONObject;
            try {
                String a2 = a.this.a(this.f5776a);
                coreJSONObject = new CoreJSONObject();
                coreJSONObject.put((String) "st", (Object) this.f5777b);
                CoreJSONObject coreJSONObject2 = new CoreJSONObject();
                coreJSONObject2.put((String) ScreenshotShareReferral.IMAGE_ADDRESS, (Object) a2);
                coreJSONObject2.put((String) "w", HSLUtils.pxToDp((float) this.f5778c));
                coreJSONObject2.put((String) h.f3998a, HSLUtils.pxToDp((float) this.f5779d));
                coreJSONObject.put((String) "scr", (Object) coreJSONObject2);
                coreJSONObject.put((String) "av", (Object) a.this.g.appVersion);
                String currentScreenName = a.this.f5767a.getCurrentScreenName();
                if (HSLUtils.isSet(currentScreenName)) {
                    coreJSONObject.put((String) "screen", (Object) currentScreenName);
                }
            } catch (CoreJSONException e2) {
                HSLLogger.printStackTrace(e2);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
                return;
            }
            a.this.f5769c.b(new io.hansel.visualizer.f.d(f.ws_device_state, coreJSONObject));
            HSLLogger.d("SocketEvent:   ws_device_state", LogGroup.WS);
        }
    }

    public a(HSLVisualizer hSLVisualizer) {
        this.f5767a = hSLVisualizer;
    }

    private int a(int i2, int i3, int i4) {
        if (i2 == i3 || ((i3 < i4 && i2 < i4) || (i3 > i4 && i2 > i4))) {
            return 0;
        }
        return i2 < i3 ? -1 : 1;
    }

    private int a(View view) {
        if (view instanceof ListView) {
            return ((ListView) view).getFirstVisiblePosition();
        }
        if (view instanceof AdapterView) {
            return ((AdapterView) view).getFirstVisiblePosition();
        }
        if (view instanceof RecyclerView) {
            LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
            int i2 = -1;
            if (layoutManager instanceof LinearLayoutManager) {
                i2 = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
                if (findFirstVisibleItemPositions.length > 0) {
                    i2 = findFirstVisibleItemPositions[0];
                }
            }
            return i2;
        } else if (view instanceof ViewPager) {
            return ((ViewPager) view).getCurrentItem();
        } else {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009a A[Catch:{ all -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[Catch:{ all -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A[SYNTHETIC, Splitter:B:29:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d0 A[SYNTHETIC, Splitter:B:43:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117 A[Catch:{ all -> 0x0249 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0229 A[Catch:{ all -> 0x0249 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.util.Pair<android.view.View, io.hansel.core.json.CoreJSONObject> a(android.view.ViewGroup r17, android.view.View r18, java.lang.String r19, boolean r20, int r21, double r22, double r24) {
        /*
            r16 = this;
            r11 = r16
            r0 = r17
            r6 = r18
            r1 = r19
            java.lang.String r2 = "rix:"
            java.lang.String r3 = ","
            java.lang.String r4 = "##"
            r12 = 0
            int r5 = r1.indexOf(r4)     // Catch:{ all -> 0x0249 }
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L_0x0019
            r5 = r1
            goto L_0x001d
        L_0x0019:
            java.lang.String r5 = r1.substring(r7, r5)     // Catch:{ all -> 0x0249 }
        L_0x001d:
            java.lang.String[] r9 = r5.split(r3)     // Catch:{ all -> 0x0249 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
            r10.<init>()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = "The class of the currentView is "
            r10.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.Class r13 = r18.getClass()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0249 }
            r10.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = " class of the currentView in currentViewPropsInEid is "
            r10.append(r13)     // Catch:{ all -> 0x0249 }
            r13 = r9[r7]     // Catch:{ all -> 0x0249 }
            r10.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0249 }
            io.hansel.core.logger.HSLLogger.d(r10)     // Catch:{ all -> 0x0249 }
            java.lang.Class r10 = r18.getClass()     // Catch:{ all -> 0x0249 }
            java.lang.String r10 = r10.getName()     // Catch:{ all -> 0x0249 }
            r13 = r9[r7]     // Catch:{ all -> 0x0249 }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x0249 }
            if (r10 == 0) goto L_0x024d
            io.hansel.core.json.CoreJSONObject r10 = new io.hansel.core.json.CoreJSONObject     // Catch:{ all -> 0x0249 }
            r10.<init>()     // Catch:{ all -> 0x0249 }
            int r13 = r19.length()     // Catch:{ all -> 0x0249 }
            int r14 = r5.length()     // Catch:{ all -> 0x0249 }
            r15 = 2
            if (r13 <= r14) goto L_0x006d
            int r5 = r5.length()     // Catch:{ all -> 0x0249 }
            int r5 = r5 + r15
            goto L_0x0071
        L_0x006d:
            int r5 = r5.length()     // Catch:{ all -> 0x0249 }
        L_0x0071:
            java.lang.String r5 = r1.substring(r5)     // Catch:{ all -> 0x0249 }
            boolean r1 = io.hansel.core.utils.HSLUtils.isSet(r5)     // Catch:{ all -> 0x0249 }
            if (r1 == 0) goto L_0x0239
            int r1 = r9.length     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = ""
            if (r1 <= r15) goto L_0x0093
            r1 = r9[r15]     // Catch:{ all -> 0x0249 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0249 }
            if (r1 == 0) goto L_0x0093
            r1 = r9[r15]     // Catch:{ all -> 0x0249 }
            java.lang.String r1 = r1.replace(r2, r13)     // Catch:{ all -> 0x0249 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0249 }
            goto L_0x0094
        L_0x0093:
            r1 = -1
        L_0x0094:
            int r2 = r5.indexOf(r4)     // Catch:{ all -> 0x0249 }
            if (r2 != r8) goto L_0x009c
            r2 = r5
            goto L_0x00a0
        L_0x009c:
            java.lang.String r2 = r5.substring(r7, r2)     // Catch:{ all -> 0x0249 }
        L_0x00a0:
            java.lang.String[] r2 = r2.split(r3)     // Catch:{ all -> 0x0249 }
            int r3 = r2.length     // Catch:{ all -> 0x0249 }
            java.lang.String r4 = "cix:"
            if (r3 <= r15) goto L_0x00b4
            r3 = r2[r15]     // Catch:{ all -> 0x0249 }
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0249 }
            if (r3 == 0) goto L_0x00b4
            r3 = r2[r15]     // Catch:{ all -> 0x0249 }
            goto L_0x00c2
        L_0x00b4:
            int r3 = r2.length     // Catch:{ all -> 0x0249 }
            r9 = 3
            if (r3 <= r9) goto L_0x00c7
            r3 = r2[r9]     // Catch:{ all -> 0x0249 }
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0249 }
            if (r3 == 0) goto L_0x00c7
            r3 = r2[r9]     // Catch:{ all -> 0x0249 }
        L_0x00c2:
            java.lang.String r3 = r3.replace(r4, r13)     // Catch:{ all -> 0x0249 }
            goto L_0x00c8
        L_0x00c7:
            r3 = r12
        L_0x00c8:
            java.util.HashMap r2 = r11.a(r2)     // Catch:{ all -> 0x0249 }
            java.lang.String r4 = "ix"
            if (r1 == r8) goto L_0x00e9
            int r9 = r11.a(r6)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r13 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r4, r13)     // Catch:{ all -> 0x0249 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0249 }
            int r13 = r13 + r1
            int r13 = r13 - r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0249 }
            r2.put(r4, r9)     // Catch:{ all -> 0x0249 }
        L_0x00e9:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
            r9.<init>()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = "HierarchyDown:      "
            r9.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.Class r13 = r18.getClass()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0249 }
            r9.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = "  :   "
            r9.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.Object r13 = r2.get(r4)     // Catch:{ all -> 0x0249 }
            r9.append(r13)     // Catch:{ all -> 0x0249 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0249 }
            io.hansel.core.logger.LogGroup r13 = io.hansel.core.logger.LogGroup.HC     // Catch:{ all -> 0x0249 }
            io.hansel.core.logger.HSLLogger.d(r9, r13)     // Catch:{ all -> 0x0249 }
            boolean r9 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0249 }
            if (r9 == 0) goto L_0x0229
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x0249 }
            boolean r9 = r6 instanceof android.widget.ExpandableListView     // Catch:{ all -> 0x0249 }
            r10 = 1
            if (r9 == 0) goto L_0x0141
            if (r3 == 0) goto L_0x0141
            java.lang.String r9 = ":"
            java.lang.String[] r3 = r3.split(r9)     // Catch:{ all -> 0x0249 }
            int r9 = r3.length     // Catch:{ all -> 0x0249 }
            if (r9 != r15) goto L_0x013e
            r9 = r3[r7]     // Catch:{ all -> 0x0249 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ all -> 0x0249 }
            r3 = r3[r10]     // Catch:{ all -> 0x0249 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x0249 }
            r13 = r6
            android.widget.ExpandableListView r13 = (android.widget.ExpandableListView) r13     // Catch:{ all -> 0x0249 }
            android.view.View r3 = io.hansel.visualizer.a.a(r13, r9, r3)     // Catch:{ all -> 0x0249 }
            goto L_0x01c2
        L_0x013e:
            r3 = r12
            goto L_0x01c2
        L_0x0141:
            boolean r3 = r6 instanceof androidx.viewpager.widget.ViewPager     // Catch:{ all -> 0x0249 }
            if (r3 != 0) goto L_0x01ac
            boolean r3 = r6 instanceof androidx.recyclerview.widget.RecyclerView     // Catch:{ all -> 0x0249 }
            if (r3 == 0) goto L_0x014a
            goto L_0x01ac
        L_0x014a:
            boolean r3 = r6 instanceof androidx.swiperefreshlayout.widget.SwipeRefreshLayout     // Catch:{ all -> 0x0249 }
            if (r3 == 0) goto L_0x019b
            r3 = 0
            r9 = -1
        L_0x0150:
            int r13 = r6.getChildCount()     // Catch:{ all -> 0x0249 }
            if (r3 >= r13) goto L_0x016e
            android.view.View r13 = r6.getChildAt(r3)     // Catch:{ all -> 0x0249 }
            java.lang.Class r13 = r13.getClass()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0249 }
            java.lang.String r14 = "androidx.swiperefreshlayout.widget.CircleImageView"
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0249 }
            if (r13 == 0) goto L_0x016b
            r9 = r3
        L_0x016b:
            int r3 = r3 + 1
            goto L_0x0150
        L_0x016e:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r3 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r4, r3)     // Catch:{ all -> 0x0249 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = "spix"
            java.lang.Integer r14 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r13 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r13, r14)     // Catch:{ all -> 0x0249 }
            int r13 = r13.intValue()     // Catch:{ all -> 0x0249 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r14 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r4, r14)     // Catch:{ all -> 0x0249 }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0249 }
            int r9 = r11.a(r13, r9, r14)     // Catch:{ all -> 0x0249 }
            int r3 = r3 + r9
            goto L_0x01a7
        L_0x019b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r3 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r4, r3)     // Catch:{ all -> 0x0249 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0249 }
        L_0x01a7:
            android.view.View r3 = r6.getChildAt(r3)     // Catch:{ all -> 0x0249 }
            goto L_0x01c2
        L_0x01ac:
            java.lang.String r3 = "hix"
            java.lang.String r3 = io.hansel.core.utils.HSLUtils.getStringValueFromMap(r2, r3, r12)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r9 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r4, r9)     // Catch:{ all -> 0x0249 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x0249 }
            android.view.View r3 = r11.a(r6, r3, r9)     // Catch:{ all -> 0x0249 }
        L_0x01c2:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
            r9.<init>()     // Catch:{ all -> 0x0249 }
            java.lang.String r13 = "HierarchyDown: childView is "
            r9.append(r13)     // Catch:{ all -> 0x0249 }
            r9.append(r3)     // Catch:{ all -> 0x0249 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0249 }
            io.hansel.core.logger.HSLLogger.d(r9)     // Catch:{ all -> 0x0249 }
            if (r3 == 0) goto L_0x0228
            int r9 = r3.getVisibility()     // Catch:{ all -> 0x0249 }
            if (r9 == 0) goto L_0x01df
            goto L_0x0228
        L_0x01df:
            if (r1 == r8) goto L_0x01e2
            r7 = 1
        L_0x01e2:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0249 }
            java.lang.Integer r1 = io.hansel.core.utils.HSLUtils.getIntegerValueFromMap(r2, r4, r1)     // Catch:{ all -> 0x0249 }
            int r8 = r1.intValue()     // Catch:{ all -> 0x0249 }
            r1 = r16
            r2 = r6
            r4 = r5
            r5 = r7
            r6 = r8
            r7 = r22
            r9 = r24
            android.util.Pair r1 = r1.a(r2, r3, r4, r5, r6, r7, r9)     // Catch:{ all -> 0x0249 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0249 }
            r2.<init>()     // Catch:{ all -> 0x0249 }
            java.lang.String r3 = "HierarchyDown: Pair is "
            r2.append(r3)     // Catch:{ all -> 0x0249 }
            r2.append(r1)     // Catch:{ all -> 0x0249 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0249 }
            io.hansel.core.logger.HSLLogger.d(r2)     // Catch:{ all -> 0x0249 }
            if (r1 == 0) goto L_0x0227
            java.lang.Object r2 = r1.second     // Catch:{ all -> 0x0249 }
            if (r2 == 0) goto L_0x0227
            if (r20 == 0) goto L_0x0219
            return r1
        L_0x0219:
            if (r0 == 0) goto L_0x0227
            io.hansel.core.json.CoreJSONObject r2 = (io.hansel.core.json.CoreJSONObject) r2     // Catch:{ all -> 0x0249 }
            r3 = r21
            boolean r0 = r11.a(r2, r0, r3)     // Catch:{ all -> 0x0249 }
            if (r0 == 0) goto L_0x0226
            goto L_0x0227
        L_0x0226:
            return r12
        L_0x0227:
            return r1
        L_0x0228:
            return r12
        L_0x0229:
            r0 = r18
            r1 = r10
            r2 = r22
            r4 = r24
            io.hansel.userjourney.q.a(r0, r1, r2, r4)     // Catch:{ all -> 0x0249 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0249 }
            r0.<init>(r6, r10)     // Catch:{ all -> 0x0249 }
            return r0
        L_0x0239:
            r0 = r18
            r1 = r10
            r2 = r22
            r4 = r24
            io.hansel.userjourney.q.a(r0, r1, r2, r4)     // Catch:{ all -> 0x0249 }
            android.util.Pair r0 = new android.util.Pair     // Catch:{ all -> 0x0249 }
            r0.<init>(r6, r10)     // Catch:{ all -> 0x0249 }
            return r0
        L_0x0249:
            r0 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r0)
        L_0x024d:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.c.a.a(android.view.ViewGroup, android.view.View, java.lang.String, boolean, int, double, double):android.util.Pair");
    }

    private View a(ViewGroup viewGroup, String str, int i2) {
        String str2;
        if (str != null) {
            Boolean parseBooleanTagValue = HSLUtils.parseBooleanTagValue(viewGroup.getTag(R.id.enable_hansel_indices), "enable_hansel_indices");
            if (parseBooleanTagValue != null && parseBooleanTagValue.booleanValue()) {
                View view = null;
                CoreJSONObject coreJSONObject = new CoreJSONObject();
                q.a((View) viewGroup, coreJSONObject);
                boolean z = false;
                int i3 = 0;
                boolean z2 = false;
                while (true) {
                    if (i3 >= viewGroup.getChildCount()) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i3);
                    if (str.equals(HSLUtils.parseStringTagValue(childAt.getTag(R.id.hansel_index), "hansel_index"))) {
                        CoreJSONObject coreJSONObject2 = new CoreJSONObject();
                        q.a(childAt, coreJSONObject2);
                        if (!z2) {
                            view = childAt;
                        }
                        if (!z2 && b(coreJSONObject, coreJSONObject2)) {
                            z2 = true;
                        }
                        if (a(coreJSONObject, coreJSONObject2)) {
                            view = childAt;
                            z = true;
                            break;
                        }
                    }
                    i3++;
                }
                if (view != null) {
                    String str3 = z ? "Completely visible" : z2 ? "Partly visible" : PDLayoutAttributeObject.BORDER_STYLE_HIDDEN;
                    str2 = str3 + " View found with hansel index " + str;
                } else {
                    str2 = "No view found with hansel index " + str;
                }
                HSLLogger.d(str2);
                return view;
            }
        }
        HSLLogger.d("Hansel indices were disabled during screen capture");
        return viewGroup.getChildAt(i2);
    }

    public static a a(HSLVisualizer hSLVisualizer) {
        if (l == null) {
            l = new a(hSLVisualizer);
        }
        return l;
    }

    private i a(Context context) {
        return new io.hansel.visualizer.c.d.n.c((Application) context.getApplicationContext(), this.f5767a.getLinkedMessageBroker(), Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public String a(Activity activity) {
        b bVar = new b();
        try {
            this.j = new CountDownLatch(1);
            bVar.a(activity, this.k);
            this.f5770d.reset();
            try {
                this.j.await();
            } catch (InterruptedException e2) {
                HSLLogger.printStackTrace(e2, "Something went wrong while waiting to receive Bitmap during screen capture.", LogGroup.PT);
            }
            this.j = null;
            if (this.i == null) {
                return "";
            }
            this.i.compress(CompressFormat.JPEG, 5, new Base64OutputStream(this.f5770d, 0));
            String str = "data:image/jpeg;base64," + this.f5770d.toString();
            this.i = null;
            this.f5770d.reset();
            return str;
        } catch (OutOfMemoryError e3) {
            HSLLogger.printStackTrace(e3);
            return "";
        }
    }

    private HashMap<String, Object> a(String[] strArr) {
        String str;
        String str2;
        String str3;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ix", Integer.valueOf(Integer.parseInt(strArr[1].replace("ix:", ""))));
        if (strArr.length > 2 && strArr[2].contains("hix:")) {
            str3 = strArr[2];
        } else if (strArr.length <= 3 || !strArr[3].contains("hix:")) {
            str = null;
            hashMap.put("hix", str);
            int i2 = -1;
            if (strArr.length > 2 || !strArr[2].contains("spix:")) {
                if (strArr.length > 3 && strArr[3].contains("spix:")) {
                    str2 = strArr[3];
                }
                hashMap.put("spix", Integer.valueOf(i2));
                return hashMap;
            }
            str2 = strArr[2];
            i2 = Integer.parseInt(str2.replace("spix:", ""));
            hashMap.put("spix", Integer.valueOf(i2));
            return hashMap;
        } else {
            str3 = strArr[3];
        }
        str = str3.replace("hix:", "");
        hashMap.put("hix", str);
        int i22 = -1;
        if (strArr.length > 2) {
        }
        str2 = strArr[3];
        i22 = Integer.parseInt(str2.replace("spix:", ""));
        hashMap.put("spix", Integer.valueOf(i22));
        return hashMap;
    }

    private void a() {
        this.f5768b.a();
        this.f5770d = new ByteArrayOutputStream();
        this.f5771e = new Handler(Looper.getMainLooper());
    }

    private boolean a(CoreJSONObject coreJSONObject, ViewGroup viewGroup, int i2) {
        return true;
    }

    private boolean a(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        int optInt = coreJSONObject.optInt("x", -1);
        int optInt2 = coreJSONObject.optInt("y", -1);
        int optInt3 = coreJSONObject.optInt("w", -1);
        int optInt4 = coreJSONObject.optInt(h.f3998a, -1);
        int optInt5 = coreJSONObject2.optInt("x", -1);
        int optInt6 = coreJSONObject2.optInt("y", -1);
        int optInt7 = coreJSONObject2.optInt("w", -1);
        int optInt8 = coreJSONObject2.optInt(h.f3998a, -1);
        return optInt7 > 0 && optInt8 > 0 && optInt5 >= optInt && optInt5 + optInt7 <= optInt + optInt3 && optInt6 >= optInt2 && optInt6 + optInt8 <= optInt2 + optInt4;
    }

    private void b() {
        if (this.h) {
            this.f5769c.b(f.ws_active, (io.hansel.visualizer.f.e) this);
            this.f5769c.b(f.ws_fetch_device_state, (io.hansel.visualizer.f.e) this);
            this.f5769c.b(f.ws_need_restart, (io.hansel.visualizer.f.e) this);
            this.f5769c.d();
            this.f5769c.a(true);
        }
    }

    private boolean b(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if (view.getVisibility() != 0) {
            str = "In isAnchorPointVisible returning false, because anchorView is visibility is not View.VISIBLE.";
        } else if (view.getWidth() != 0 && view.getHeight() != 0) {
            return true;
        } else {
            str = "In isAnchorPointVisible returning false, because anchorView is width or height is 0.";
        }
        HSLLogger.d(str);
        return false;
    }

    private boolean b(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        int optInt = coreJSONObject.optInt("x", -1);
        int optInt2 = coreJSONObject.optInt("y", -1);
        int optInt3 = coreJSONObject.optInt("w", -1);
        int optInt4 = coreJSONObject.optInt(h.f3998a, -1) + optInt2;
        int i2 = optInt3 + optInt;
        int optInt5 = coreJSONObject2.optInt("x", -1);
        int optInt6 = coreJSONObject2.optInt("y", -1);
        int optInt7 = coreJSONObject2.optInt("w", -1);
        int optInt8 = coreJSONObject2.optInt(h.f3998a, -1);
        int i3 = optInt6 + optInt8;
        int i4 = optInt5 + optInt7;
        return optInt7 > 0 && optInt8 > 0 && ((optInt5 >= optInt && optInt5 < i2) || (i4 > optInt && i4 <= i2)) && ((optInt6 >= optInt2 && optInt6 < optInt4) || (i3 > optInt2 && i3 <= optInt4));
    }

    private void c() {
        if (!this.h) {
            this.h = true;
            this.f5769c = new io.hansel.visualizer.f.b(this.f5772f, this.g);
            b();
        }
    }

    /* access modifiers changed from: private */
    public CoreJSONObject g() {
        try {
            return this.f5768b.a(this.f5772f);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007b A[Catch:{ all -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c A[Catch:{ all -> 0x0082 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(java.util.Map r13, android.view.View r14, boolean r15) {
        /*
            r12 = this;
            r15 = 0
            java.lang.String r0 = "eid"
            java.lang.Object r0 = r13.get(r0)     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x000d
            r0 = r1
            goto L_0x0011
        L_0x000d:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0082 }
        L_0x0011:
            if (r0 != r1) goto L_0x0014
            return r15
        L_0x0014:
            java.lang.String r1 = "##"
            int r1 = r0.indexOf(r1)     // Catch:{ all -> 0x0082 }
            int r1 = r1 + 2
            java.lang.String r5 = r0.substring(r1)     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "posx"
            java.lang.Object r0 = r13.get(r0)     // Catch:{ all -> 0x0082 }
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0082 }
            double r3 = java.lang.Double.parseDouble(r0)     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "posy"
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0082 }
            if (r13 != 0) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0082 }
            double r0 = java.lang.Double.parseDouble(r13)     // Catch:{ all -> 0x0082 }
            r10 = r0
            r8 = r3
            goto L_0x0048
        L_0x0046:
            r8 = r1
            r10 = r8
        L_0x0048:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r13.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "@@@    eid"
            r13.append(r0)     // Catch:{ all -> 0x0082 }
            r13.append(r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0082 }
            io.hansel.core.logger.HSLLogger.d(r13)     // Catch:{ all -> 0x0082 }
            r3 = 0
            r6 = 0
            r7 = -1
            r2 = r12
            r4 = r14
            android.util.Pair r13 = r2.a(r3, r4, r5, r6, r7, r8, r10)     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r14.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r0 = "HierarchyDown: Pair is "
            r14.append(r0)     // Catch:{ all -> 0x0082 }
            r14.append(r13)     // Catch:{ all -> 0x0082 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0082 }
            io.hansel.core.logger.HSLLogger.d(r14)     // Catch:{ all -> 0x0082 }
            if (r13 != 0) goto L_0x007c
            goto L_0x0081
        L_0x007c:
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x0082 }
            android.view.View r13 = (android.view.View) r13     // Catch:{ all -> 0x0082 }
            r15 = r13
        L_0x0081:
            return r15
        L_0x0082:
            r13 = move-exception
            io.hansel.core.logger.HSLLogger.printStackTrace(r13)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.c.a.a(java.util.Map, android.view.View, boolean):android.view.View");
    }

    public a a(Context context, HSLSDKIdentifiers hSLSDKIdentifiers) {
        if (this.f5768b == null) {
            this.f5772f = context.getApplicationContext();
            this.g = hSLSDKIdentifiers;
            i a2 = a(context);
            if (a2 != null) {
                this.f5768b = new DOM(new g(a2));
            }
        }
        a();
        return this;
    }

    public void a(io.hansel.visualizer.f.d dVar) {
        Handler handler;
        Runnable dVar2;
        try {
            int i2 = c.f5774a[dVar.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    handler = this.f5771e;
                    dVar2 = new d(this, null);
                } else if (i2 == 3) {
                    handler = this.f5771e;
                    dVar2 = new b(this);
                } else {
                    return;
                }
                handler.postDelayed(dVar2, 0);
                return;
            }
            new CoreJSONObject().put((String) RNGestureHandlerModule.KEY_HIT_SLOP_TOP, -1);
            Hansel.showToast("Connected to hansel dashboard.", false);
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public boolean a(View view, View view2, int i2, int i3, int i4) {
        StringBuilder sb;
        String str;
        View view3 = view;
        View view4 = view2;
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        boolean z = false;
        if (!(view3 == null || view4 == null)) {
            int i8 = 1;
            if (!(i5 < 0) && !(i6 < 0)) {
                if (!b(view4)) {
                    sb = GeneratedOutlineSupport.outline73("In isAnchorPointVisible returning false, isViewVisible is returning false for anchorView ");
                    sb.append(view2.getClass().getName());
                } else {
                    Rect rect = new Rect();
                    ((View) view2.getParent()).getGlobalVisibleRect(rect);
                    int i9 = rect.left;
                    int i10 = rect.top;
                    int width = rect.width();
                    int height = rect.height();
                    if (i5 < i9 || i5 > i9 + width || i6 < i10 || i6 > i10 + height) {
                        return false;
                    }
                    boolean z2 = false;
                    boolean z3 = false;
                    boolean z4 = true;
                    View view5 = view4;
                    while (true) {
                        if (!z2) {
                            if (view5 == view3) {
                                z3 = true;
                            }
                            ViewParent parent = view5.getParent();
                            if (parent != null || z3) {
                                if (!(parent instanceof ViewGroup)) {
                                    break;
                                }
                                ViewGroup viewGroup = (ViewGroup) parent;
                                int indexOfChild = viewGroup.indexOfChild(view5);
                                HSLLogModel.getLogger().buildLogMessage(HSLLogLevel.debug).append("childIndex in isAnchorPointVisible is ").append(Integer.valueOf(indexOfChild)).print();
                                int i11 = indexOfChild + i8;
                                while (true) {
                                    if (i11 >= viewGroup.getChildCount()) {
                                        break;
                                    }
                                    View childAt = viewGroup.getChildAt(i11);
                                    if (childAt.getId() == R.id.frag_hsl_container_main || childAt.getId() == R.id.frag_all_tags_container_main) {
                                        str = "rightView in isAnchorPointVisible is hsl container main or tags container.";
                                    } else {
                                        Boolean parseBooleanTagValue = HSLUtils.parseBooleanTagValue(childAt.getTag(i7), "hansel_ignore_view");
                                        boolean booleanValue = childAt.getTag(R.id.hansel_nudge_view) != null ? ((Boolean) childAt.getTag(R.id.hansel_nudge_view)).booleanValue() : false;
                                        if (childAt.getVisibility() != 0 || ((parseBooleanTagValue != null && parseBooleanTagValue.booleanValue()) || booleanValue)) {
                                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("rightView in isAnchorPointVisible is not considered because of visibility ");
                                            outline73.append(childAt.getVisibility());
                                            outline73.append(" with skip Tag ");
                                            outline73.append(childAt.getTag(i7));
                                            str = outline73.toString();
                                        } else {
                                            HSLLogModel logger = HSLLogModel.getLogger();
                                            HSLLogLevel hSLLogLevel = HSLLogLevel.debug;
                                            logger.buildLogMessage(hSLLogLevel).append("In isAnchorPointVisible, checking with view ").append(childAt.getClass().getName()).print();
                                            Rect rect2 = new Rect();
                                            childAt.getGlobalVisibleRect(rect2);
                                            HSLLogModel.getLogger().buildLogMessage(hSLLogLevel).append("In isAnchorPointVisible, visible rect is left ").append(Integer.valueOf(rect2.left)).append(", top ").append(Integer.valueOf(rect2.top)).append(", width ").append(Integer.valueOf(rect2.width())).append(", height ").append(Integer.valueOf(rect2.height())).append(", anchorPointOnScreenX ").append(Integer.valueOf(i2)).append(", anchorPointOnScreenY ").append(Integer.valueOf(i3)).print();
                                            int i12 = rect2.left;
                                            int i13 = rect2.top;
                                            int width2 = rect2.width();
                                            int height2 = rect2.height();
                                            if (i12 <= i5 && i12 + width2 >= i5 && i13 <= i6 && i13 + height2 >= i6) {
                                                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Anchor point is covered by view ");
                                                outline732.append(childAt.getClass().getName());
                                                outline732.append(" with values viewOriginX ");
                                                outline732.append(i12);
                                                outline732.append(",viewOriginY ");
                                                outline732.append(i13);
                                                outline732.append(",viewWidth ");
                                                outline732.append(width2);
                                                outline732.append(",viewHeight ");
                                                outline732.append(height2);
                                                outline732.append(",anchorPointOnScreenX ");
                                                outline732.append(i5);
                                                outline732.append(",anchorPointOnScreenY ");
                                                outline732.append(i6);
                                                HSLLogger.d(outline732.toString());
                                                z2 = true;
                                                z4 = false;
                                                break;
                                            }
                                            i11++;
                                            View view6 = view;
                                            View view7 = view2;
                                        }
                                    }
                                    HSLLogger.d(str);
                                    i11++;
                                    View view62 = view;
                                    View view72 = view2;
                                }
                                view5 = (View) parent;
                                z = false;
                                i8 = 1;
                                view3 = view;
                                View view8 = view2;
                            } else {
                                HSLLogger.d("Invalid view encountered.");
                                break;
                            }
                        } else {
                            StringBuilder outline733 = GeneratedOutlineSupport.outline73("stopLoop reached in isAnchorPointVisible for anchorView  ");
                            outline733.append(view2.getClass().getName());
                            HSLLogger.d(outline733.toString());
                            break;
                        }
                    }
                    z = z4;
                    sb = new StringBuilder();
                    sb.append("In isAnchorPointVisible method, the final return value is ");
                    sb.append(z);
                }
                HSLLogger.d(sb.toString());
                return z;
            }
        }
        StringBuilder outline734 = GeneratedOutlineSupport.outline73("In isAnchorPointVisible returning false, because decorView is null or anchorView is null or anchor point x or y is less than 0 for anchorView ");
        outline734.append(view2.getClass().getName());
        HSLLogger.d(outline734.toString());
        return false;
    }

    public void d() {
        if (this.h) {
            io.hansel.visualizer.f.b bVar = this.f5769c;
            if (bVar != null) {
                bVar.b(new io.hansel.visualizer.f.d(f.ws_inactive));
                HSLLogger.d("SocketEvent:   ws_inactive", LogGroup.WS);
            }
        }
    }

    public void e() {
        if (this.h) {
            b();
        }
    }

    public void f() {
        c();
    }
}
