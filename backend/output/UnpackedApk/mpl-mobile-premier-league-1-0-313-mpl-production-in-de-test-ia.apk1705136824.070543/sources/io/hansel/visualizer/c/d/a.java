package io.hansel.visualizer.c.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import io.hansel.R;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;

public abstract class a<E> extends c<E> {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.View r19) {
        /*
            r18 = this;
            r0 = r19
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r3 = r0.findViewById(r2)
            java.lang.String r4 = "##"
            r5 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r6 = ",ix:"
            java.lang.String r7 = "is_root"
            java.lang.String r8 = "xpath"
            java.lang.String r9 = "ix"
            java.lang.String r10 = "class"
            r11 = 1
            r12 = 0
            if (r3 == 0) goto L_0x00b6
            int r3 = r19.getId()
            if (r3 == r2) goto L_0x00b6
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            android.app.Activity r3 = r18.b(r19)
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getName()
            r2.put(r10, r3)
            java.lang.String r3 = java.lang.String.valueOf(r11)
            r2.put(r7, r3)
            java.lang.String r3 = java.lang.String.valueOf(r12)
            r2.put(r9, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Object r11 = r2.get(r10)
            java.lang.String r11 = (java.lang.String) r11
            r3.append(r11)
            r3.append(r6)
            java.lang.Object r11 = r2.get(r9)
            java.lang.String r11 = (java.lang.String) r11
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            r2.put(r8, r3)
            java.lang.String r3 = java.lang.String.valueOf(r12)
            r1.put(r9, r3)
            java.lang.Class r3 = r19.getClass()
            java.lang.String r3 = r3.getName()
            r1.put(r10, r3)
            java.lang.String r3 = java.lang.String.valueOf(r12)
            r1.put(r7, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.Object r2 = r2.get(r8)
            java.lang.String r2 = (java.lang.String) r2
            r3.append(r2)
            r3.append(r4)
            java.lang.Object r2 = r1.get(r10)
            java.lang.String r2 = (java.lang.String) r2
            r3.append(r2)
            r3.append(r6)
            java.lang.Object r2 = r1.get(r9)
            java.lang.String r2 = (java.lang.String) r2
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.put(r8, r2)
            r0.setTag(r5, r1)
            goto L_0x025e
        L_0x00b6:
            android.view.ViewParent r2 = r19.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r3 = r2.indexOfChild(r0)
            boolean r5 = r2 instanceof androidx.swiperefreshlayout.widget.SwipeRefreshLayout
            java.lang.String r11 = "spix"
            if (r5 == 0) goto L_0x00f0
            r5 = 0
        L_0x00c8:
            int r12 = r2.getChildCount()
            if (r5 >= r12) goto L_0x00e6
            android.view.View r12 = r2.getChildAt(r5)
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            java.lang.String r13 = "androidx.swiperefreshlayout.widget.CircleImageView"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x00e3
            goto L_0x00e7
        L_0x00e3:
            int r5 = r5 + 1
            goto L_0x00c8
        L_0x00e6:
            r5 = -1
        L_0x00e7:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r1.put(r11, r5)
            r5 = 1
            goto L_0x00f1
        L_0x00f0:
            r5 = 0
        L_0x00f1:
            boolean r12 = r2 instanceof android.widget.ExpandableListView
            java.lang.String r13 = "hix"
            java.lang.String r14 = "cix"
            if (r12 == 0) goto L_0x0106
            android.widget.ExpandableListView r2 = (android.widget.ExpandableListView) r2
            java.lang.String r2 = io.hansel.visualizer.a.a(r2, r0)
            if (r2 == 0) goto L_0x011a
            r1.put(r14, r2)
            r2 = 1
            goto L_0x011b
        L_0x0106:
            boolean r12 = r2 instanceof androidx.viewpager.widget.ViewPager
            if (r12 != 0) goto L_0x010e
            boolean r2 = r2 instanceof androidx.recyclerview.widget.RecyclerView
            if (r2 == 0) goto L_0x011a
        L_0x010e:
            java.lang.String r2 = c(r19)
            if (r2 == 0) goto L_0x011a
            r1.put(r13, r2)
            r2 = 0
            r12 = 1
            goto L_0x011c
        L_0x011a:
            r2 = 0
        L_0x011b:
            r12 = 0
        L_0x011c:
            boolean r15 = r0 instanceof android.widget.ListView
            r16 = r11
            java.lang.String r11 = "rix"
            if (r15 == 0) goto L_0x012c
            r15 = r0
            android.widget.ListView r15 = (android.widget.ListView) r15
            int r15 = r15.getFirstVisiblePosition()
            goto L_0x0137
        L_0x012c:
            boolean r15 = r0 instanceof android.widget.AdapterView
            if (r15 == 0) goto L_0x0141
            r15 = r0
            android.widget.AdapterView r15 = (android.widget.AdapterView) r15
            int r15 = r15.getFirstVisiblePosition()
        L_0x0137:
            java.lang.String r15 = java.lang.String.valueOf(r15)
            r1.put(r11, r15)
            r17 = r5
            goto L_0x0195
        L_0x0141:
            boolean r15 = r0 instanceof androidx.recyclerview.widget.RecyclerView
            if (r15 == 0) goto L_0x0174
            r15 = r0
            androidx.recyclerview.widget.RecyclerView r15 = (androidx.recyclerview.widget.RecyclerView) r15
            androidx.recyclerview.widget.RecyclerView$LayoutManager r15 = r15.getLayoutManager()
            r17 = r5
            boolean r5 = r15 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r5 == 0) goto L_0x0159
            androidx.recyclerview.widget.LinearLayoutManager r15 = (androidx.recyclerview.widget.LinearLayoutManager) r15
            int r5 = r15.findFirstVisibleItemPosition()
            goto L_0x016c
        L_0x0159:
            boolean r5 = r15 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r5 == 0) goto L_0x016b
            androidx.recyclerview.widget.StaggeredGridLayoutManager r15 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r15
            r5 = 0
            int[] r5 = r15.findFirstVisibleItemPositions(r5)
            int r15 = r5.length
            if (r15 <= 0) goto L_0x016b
            r15 = 0
            r5 = r5[r15]
            goto L_0x016c
        L_0x016b:
            r5 = -1
        L_0x016c:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r1.put(r11, r5)
            goto L_0x0195
        L_0x0174:
            r17 = r5
            boolean r5 = r0 instanceof androidx.viewpager.widget.ViewPager
            if (r5 == 0) goto L_0x0197
            r5 = r0
            androidx.viewpager.widget.ViewPager r5 = (androidx.viewpager.widget.ViewPager) r5
            int r15 = r5.getCurrentItem()
            java.lang.String r15 = java.lang.String.valueOf(r15)
            r1.put(r11, r15)
            int r5 = r5.getOffscreenPageLimit()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r15 = "maxRix"
            r1.put(r15, r5)
        L_0x0195:
            r5 = 1
            goto L_0x0198
        L_0x0197:
            r5 = 0
        L_0x0198:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.put(r9, r3)
            java.lang.Class r3 = r19.getClass()
            java.lang.String r3 = r3.getName()
            r1.put(r10, r3)
            r3 = 0
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.put(r7, r3)
            android.view.ViewParent r3 = r19.getParent()
            android.view.View r3 = (android.view.View) r3
            r7 = 2147483647(0x7fffffff, float:NaN)
            java.lang.Object r3 = r3.getTag(r7)
            java.util.HashMap r3 = (java.util.HashMap) r3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            r7.append(r3)
            r7.append(r4)
            java.lang.Object r3 = r1.get(r10)
            java.lang.String r3 = (java.lang.String) r3
            r7.append(r3)
            r7.append(r6)
            java.lang.Object r3 = r1.get(r9)
            java.lang.String r3 = (java.lang.String) r3
            r7.append(r3)
            java.lang.String r3 = ""
            if (r5 == 0) goto L_0x01ff
            java.lang.String r4 = ",rix:"
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.Object r5 = r1.get(r11)
            java.lang.String r5 = (java.lang.String) r5
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x0200
        L_0x01ff:
            r4 = r3
        L_0x0200:
            r7.append(r4)
            if (r2 == 0) goto L_0x0219
            java.lang.String r2 = ",cix:"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.Object r4 = r1.get(r14)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x021a
        L_0x0219:
            r2 = r3
        L_0x021a:
            r7.append(r2)
            if (r12 == 0) goto L_0x0233
            java.lang.String r2 = ",hix:"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.Object r4 = r1.get(r13)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x0234
        L_0x0233:
            r2 = r3
        L_0x0234:
            r7.append(r2)
            if (r17 == 0) goto L_0x024e
            java.lang.String r2 = ",spix:"
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            r3 = r16
            java.lang.Object r3 = r1.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r2.append(r3)
            java.lang.String r3 = r2.toString()
        L_0x024e:
            r7.append(r3)
            java.lang.String r2 = r7.toString()
            r1.put(r8, r2)
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.setTag(r2, r1)
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.visualizer.c.d.a.a(android.view.View):void");
    }

    private void a(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2, E e2) {
        try {
            String name = e2 instanceof Activity ? "android.app.Activity" : e2 instanceof Application ? "android.app.Application" : e2 instanceof View ? ((View) e2).getClass().getName() : null;
            if (name != null) {
                HSLLogger.d("The class of the element " + e2.getClass().getName() + " with hansel type " + name);
                coreJSONObject2.put((String) "type", (Object) name);
                if (coreJSONObject != null && coreJSONObject.length() > 0) {
                    coreJSONObject2.put((String) ColorPropConverter.ATTR, (Object) coreJSONObject);
                }
            }
        } catch (CoreJSONException e3) {
            HSLLogger.printStackTrace(e3);
        }
    }

    private Activity b(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static String c(View view) {
        return HSLUtils.parseStringTagValue(view.getTag(R.id.hansel_index), "hansel_index");
    }

    public final void a(E e2) {
        a();
        d(e2);
    }

    public final void a(E e2, CoreJSONObject coreJSONObject) {
        CoreJSONObject coreJSONObject2 = new CoreJSONObject();
        b(e2, coreJSONObject2);
        a(coreJSONObject2, coreJSONObject, e2);
    }

    public final void a(E e2, io.hansel.visualizer.b.a<Object> aVar) {
        b(e2, aVar);
    }

    public void b(E e2, CoreJSONObject coreJSONObject) {
        if (!(e2 instanceof View)) {
            if (e2 instanceof Activity) {
                e2 = ((Activity) e2).findViewById(16908290).getParent();
            } else {
                return;
            }
        }
        View view = (View) e2;
        io.hansel.core.base.utils.a.a(view, coreJSONObject);
        a(view);
    }

    public void b(E e2, io.hansel.visualizer.b.a<Object> aVar) {
    }

    public final void c(E e2) {
        a();
        e(e2);
    }

    public void d(E e2) {
    }

    public void e(E e2) {
    }
}
