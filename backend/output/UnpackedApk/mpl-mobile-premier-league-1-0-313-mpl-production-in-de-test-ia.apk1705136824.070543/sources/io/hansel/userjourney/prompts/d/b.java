package io.hansel.userjourney.prompts.d;

import android.content.Context;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.n;
import org.apache.fontbox.cmap.CMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f5505a;

    /* renamed from: b  reason: collision with root package name */
    public f f5506b;

    /* renamed from: c  reason: collision with root package name */
    public String f5507c;

    /* renamed from: d  reason: collision with root package name */
    public int f5508d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f5509e = 0;

    public b(Context context, String str, f fVar) {
        this.f5505a = context;
        this.f5507c = str;
        this.f5506b = fVar;
    }

    public void a() {
        this.f5509e++;
    }

    public void a(TextView textView, String str, int i, int i2) {
        int i3;
        int i4;
        if (!str.equals("auto")) {
            String[] split = this.f5507c.split(CMap.SPACE);
            int a2 = this.f5506b.a();
            int i5 = 0;
            if (split.length == 4) {
                i3 = HSLUtils.dpToPx(n.b(split[1]));
                i4 = HSLUtils.dpToPx(n.b(split[3]));
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (str.equals(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
                i5 = (((i2 - i3) - i4) - i) - a2;
            } else if (str.equals(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
                a2 = (((i2 - i3) - i4) - i) - a2;
            } else if (str.equals("center")) {
                a2 = ((((i2 - i) - i3) - i4) - a2) / 2;
                i5 = a2;
            } else {
                a2 = 0;
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.leftMargin = a2;
            marginLayoutParams.rightMargin = i5;
            textView.setLayoutParams(marginLayoutParams);
        }
    }

    public void a(CoreJSONObject coreJSONObject, TextView textView) {
        int i;
        int i2;
        int i3;
        String[] split = coreJSONObject.optString("spacing").split(CMap.SPACE);
        int i4 = 0;
        if (split.length == 4) {
            int dpToPx = HSLUtils.dpToPx(n.b(split[0]));
            i3 = HSLUtils.dpToPx(n.b(split[1]));
            i2 = HSLUtils.dpToPx(n.b(split[2]));
            int i5 = dpToPx;
            i4 = HSLUtils.dpToPx(n.b(split[3]));
            i = i5;
        } else {
            i = 0;
            i3 = 0;
            i2 = 0;
        }
        textView.setPadding(i4, i, i3, i2);
    }

    public void a(boolean z) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.View r33, io.hansel.core.json.CoreJSONObject r34, int r35, io.hansel.segments.c r36, int r37, int r38, int r39, java.util.List<android.widget.TextView> r40, java.util.Set<java.lang.String> r41, java.util.HashMap<java.lang.String, java.lang.Object> r42) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r35
            r3 = r39
            r4 = r42
            java.lang.String r5 = "props"
            r6 = r34
            io.hansel.core.json.CoreJSONObject r5 = r6.optJSONObject(r5)
            int r6 = io.hansel.R.id.container_btnX
            android.view.View r13 = r1.findViewById(r6)
            r6 = 0
            if (r5 == 0) goto L_0x0022
            java.lang.String r7 = "text"
            java.lang.String r6 = r5.optString(r7, r6)
        L_0x0022:
            r14 = -1
            r15 = 3
            r12 = 2
            r11 = 1
            if (r2 != r11) goto L_0x003b
            if (r6 == 0) goto L_0x002f
            java.lang.String r7 = "Button_1_text"
            r4.put(r7, r6)
        L_0x002f:
            int r4 = io.hansel.R.id.btn1
            android.view.View r1 = r1.findViewById(r4)
            java.lang.String r4 = "prompt_btn1,Button_1_clicked"
        L_0x0037:
            r1.setTag(r4)
            goto L_0x006f
        L_0x003b:
            if (r2 != r12) goto L_0x004d
            if (r6 == 0) goto L_0x0044
            java.lang.String r7 = "Button_2_text"
            r4.put(r7, r6)
        L_0x0044:
            int r4 = io.hansel.R.id.btn2
            android.view.View r1 = r1.findViewById(r4)
            java.lang.String r4 = "prompt_btn2,Button_2_clicked"
            goto L_0x0037
        L_0x004d:
            if (r2 != r15) goto L_0x005f
            if (r6 == 0) goto L_0x0056
            java.lang.String r7 = "Button_3_text"
            r4.put(r7, r6)
        L_0x0056:
            int r4 = io.hansel.R.id.btn3
            android.view.View r1 = r1.findViewById(r4)
            java.lang.String r4 = "prompt_btn3,Button_3_clicked"
            goto L_0x0037
        L_0x005f:
            if (r2 != r14) goto L_0x02f2
            int r4 = io.hansel.R.id.btnX
            android.view.View r1 = r1.findViewById(r4)
            java.lang.String r4 = "prompt_btnx,Button_close_clicked"
            r1.setTag(r4)
            r13.setTag(r4)
        L_0x006f:
            java.lang.String r4 = "type"
            java.lang.String r6 = "flat"
            java.lang.String r4 = r5.optString(r4, r6)
            r16 = 20
            r17 = 5
            r18 = 1069547520(0x3fc00000, float:1.5)
            java.lang.String r9 = "box"
            if (r2 <= 0) goto L_0x0129
            java.lang.String r6 = "btnAlign"
            java.lang.String r8 = r5.optString(r6)
            android.widget.TextView r7 = new android.widget.TextView
            android.content.Context r6 = r0.f5505a
            r7.<init>(r6)
            android.view.ViewGroup$MarginLayoutParams r6 = new android.view.ViewGroup$MarginLayoutParams
            r10 = -2
            r6.<init>(r10, r10)
            r7.setLayoutParams(r6)
            android.content.Context r6 = r0.f5505a
            r10 = 0
            boolean r19 = r9.equals(r4)
            if (r19 == 0) goto L_0x00a4
            io.hansel.userjourney.prompts.p0 r19 = io.hansel.userjourney.prompts.p0.BTN_FILLED
            goto L_0x00a6
        L_0x00a4:
            io.hansel.userjourney.prompts.p0 r19 = io.hansel.userjourney.prompts.p0.BTN_FLAT
        L_0x00a6:
            r20 = 0
            r33 = r7
            r14 = r8
            r8 = r5
            r21 = r9
            r9 = r10
            r15 = 0
            r10 = r19
            r11 = r20
            r19 = 2
            r12 = r36
            io.hansel.userjourney.prompts.f0.a(r6, r7, r8, r9, r10, r11, r12)
            r6 = r33
            r6.measure(r15, r15)
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
            r6.setIncludeFontPadding(r15)
            int r8 = r6.getMeasuredWidth()
            int r9 = r7.leftMargin
            int r8 = r8 + r9
            int r9 = r7.rightMargin
            int r8 = r8 + r9
            int r9 = r37 * 2
            int r9 = r9 + r8
            int r6 = r6.getMeasuredHeight()
            int r8 = r7.topMargin
            int r6 = r6 + r8
            int r7 = r7.bottomMargin
            int r6 = r6 + r7
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0.a(r5, r7)
            int r8 = r1.getPaddingLeft()
            int r8 = r8 + r9
            int r10 = r1.getPaddingRight()
            int r10 = r10 + r8
            r8 = r38
            r0.a(r7, r14, r10, r8)
            android.view.ViewGroup$LayoutParams r7 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r7 = (android.view.ViewGroup.MarginLayoutParams) r7
            int r8 = r0.f5508d
            int r10 = r1.getPaddingTop()
            int r10 = r10 + r6
            int r11 = r1.getPaddingBottom()
            int r11 = r11 + r10
            int r8 = java.lang.Math.max(r8, r11)
            r0.f5508d = r8
            int r8 = r1.getPaddingTop()
            int r8 = r8 + r6
            int r6 = r1.getPaddingBottom()
            int r6 = r6 + r8
            r7.height = r6
            int r6 = r1.getPaddingLeft()
            int r6 = r6 + r9
            int r8 = r1.getPaddingRight()
            int r8 = r8 + r6
            r7.width = r8
            r1.setLayoutParams(r7)
            goto L_0x012e
        L_0x0129:
            r21 = r9
            r15 = 0
            r19 = 2
        L_0x012e:
            r14 = 10
            if (r2 >= 0) goto L_0x020d
            java.lang.String r6 = "#808080"
            int r6 = io.hansel.userjourney.n.c(r6)
            java.lang.String r7 = "textColor"
            int r6 = io.hansel.userjourney.n.a(r5, r7, r6)
            java.lang.String r7 = "bgSize"
            java.lang.String r8 = "20px 20px"
            java.lang.String r7 = r5.optString(r7, r8)
            r8 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            java.lang.String r10 = "fontWidth"
            double r8 = r5.optDouble(r10, r8)
            float r8 = (float) r8
            java.lang.String r9 = " "
            java.lang.String[] r7 = r7.split(r9)
            int r10 = r7.length
            if (r10 <= 0) goto L_0x0163
            r7 = r7[r15]
            int r7 = io.hansel.userjourney.n.b(r7)
            int r16 = io.hansel.core.utils.HSLUtils.dpToPx(r7)
        L_0x0163:
            java.lang.String r7 = "iconSize"
            java.lang.String r10 = "10px 10px"
            java.lang.String r7 = r5.optString(r7, r10)
            java.lang.String[] r7 = r7.split(r9)
            int r10 = r7.length
            if (r10 <= 0) goto L_0x017d
            r7 = r7[r15]
            int r7 = io.hansel.userjourney.n.b(r7)
            int r7 = io.hansel.core.utils.HSLUtils.dpToPx(r7)
            goto L_0x017f
        L_0x017d:
            r7 = 10
        L_0x017f:
            int r10 = r16 - r7
            int r17 = r10 / 2
            int r10 = io.hansel.core.utils.HSLUtils.dpToPx(r14)
            java.lang.String r11 = "spacing"
            java.lang.String r11 = r5.optString(r11)
            java.lang.String[] r9 = r11.split(r9)
            int r11 = r9.length
            r12 = 4
            if (r11 != r12) goto L_0x01c8
            r10 = r9[r15]
            int r10 = io.hansel.userjourney.n.b(r10)
            int r10 = io.hansel.core.utils.HSLUtils.dpToPx(r10)
            r12 = 1
            r11 = r9[r12]
            int r11 = io.hansel.userjourney.n.b(r11)
            int r11 = io.hansel.core.utils.HSLUtils.dpToPx(r11)
            r14 = r9[r19]
            int r14 = io.hansel.userjourney.n.b(r14)
            int r14 = io.hansel.core.utils.HSLUtils.dpToPx(r14)
            r18 = 3
            r9 = r9[r18]
            int r9 = io.hansel.userjourney.n.b(r9)
            int r9 = io.hansel.core.utils.HSLUtils.dpToPx(r9)
            r31 = r14
            r14 = r9
            r9 = r10
            r10 = r31
            goto L_0x01cd
        L_0x01c8:
            r12 = 1
            r9 = r10
            r11 = r9
            r10 = 0
            r14 = 0
        L_0x01cd:
            android.view.ViewGroup$LayoutParams r18 = r1.getLayoutParams()
            r12 = r18
            android.view.ViewGroup$MarginLayoutParams r12 = (android.view.ViewGroup.MarginLayoutParams) r12
            r12.leftMargin = r14
            r12.topMargin = r9
            r12.rightMargin = r11
            r12.bottomMargin = r10
            r1.setLayoutParams(r12)
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            r18 = 30
            int r15 = io.hansel.core.utils.HSLUtils.dpToPx(r18)
            int r14 = r14 + r11
            int r14 = r14 + r16
            int r9 = r9 + r10
            int r9 = r9 + r16
            int r10 = java.lang.Math.max(r14, r15)
            r12.width = r10
            int r9 = java.lang.Math.max(r9, r15)
            r12.height = r9
            r13.setLayoutParams(r12)
            r26 = r6
            r28 = r7
            r30 = r8
            r27 = r16
            r29 = r17
            r13 = r21
            r15 = 1
            goto L_0x0243
        L_0x020d:
            java.lang.String r6 = "image"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L_0x0236
            android.content.Context r6 = r0.f5505a
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            r9 = 1
            r13 = r21
            boolean r8 = r13.equals(r4)
            if (r8 == 0) goto L_0x0226
            io.hansel.userjourney.prompts.p0 r8 = io.hansel.userjourney.prompts.p0.BTN_FILLED
            goto L_0x0228
        L_0x0226:
            io.hansel.userjourney.prompts.p0 r8 = io.hansel.userjourney.prompts.p0.BTN_FLAT
        L_0x0228:
            r10 = r8
            r11 = 0
            r8 = r5
            r15 = 1
            r12 = r36
            boolean r6 = io.hansel.userjourney.prompts.f0.a(r6, r7, r8, r9, r10, r11, r12)
            if (r6 != 0) goto L_0x0239
            r6 = 0
            return r6
        L_0x0236:
            r13 = r21
            r15 = 1
        L_0x0239:
            r26 = -1
            r27 = 20
            r28 = 10
            r29 = 5
            r30 = 1069547520(0x3fc00000, float:1.5)
        L_0x0243:
            boolean r4 = r13.equals(r4)
            if (r4 == 0) goto L_0x02b9
            java.lang.String r4 = "bgColor"
            int r4 = io.hansel.userjourney.n.a(r5, r4, r3)
            java.lang.String r6 = "borderColor"
            int r3 = io.hansel.userjourney.n.a(r5, r6, r3)
            java.lang.String r6 = "borderWidth"
            int r6 = r5.optInt(r6, r15)
            java.lang.String r7 = "cornerRadius"
            r8 = 0
            int r7 = r5.optInt(r7, r8)
            int r7 = io.hansel.core.utils.HSLUtils.dpToPx(r7)
            if (r2 >= 0) goto L_0x0277
            android.content.Context r2 = r0.f5505a
            r22 = r1
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            r23 = 1
            r21 = r2
            r24 = r4
            r25 = r7
            goto L_0x02c9
        L_0x0277:
            android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
            r2.<init>()
            android.graphics.drawable.GradientDrawable r8 = new android.graphics.drawable.GradientDrawable
            r8.<init>()
            r9 = 0
            r2.setShape(r9)
            r8.setShape(r9)
            float r7 = (float) r7
            r2.setCornerRadius(r7)
            r8.setCornerRadius(r7)
            r2.setColor(r4)
            r8.setColor(r4)
            r2.setStroke(r6, r3)
            r8.setStroke(r6, r3)
            r3 = 63
            r8.setAlpha(r3)
            android.graphics.drawable.StateListDrawable r3 = new android.graphics.drawable.StateListDrawable
            r3.<init>()
            int[] r4 = new int[r15]
            r6 = 16842910(0x101009e, float:2.3694E-38)
            r7 = 0
            r4[r7] = r6
            r3.addState(r4, r2)
            int[] r2 = new int[r7]
            r3.addState(r2, r8)
            r1.setBackground(r3)
            goto L_0x02cc
        L_0x02b9:
            if (r2 >= 0) goto L_0x02cc
            android.content.Context r2 = r0.f5505a
            r22 = r1
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            r23 = 0
            r24 = 0
            r25 = 0
            r21 = r2
        L_0x02c9:
            io.hansel.userjourney.n.a(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
        L_0x02cc:
            java.lang.String r2 = "actionType"
            java.lang.String r3 = "cancel"
            java.lang.String r2 = r5.optString(r2, r3)
            java.lang.String r3 = "submit"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x02f1
            r2 = r1
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = r40
            r3.add(r2)
            int r2 = r41.size()
            if (r2 != 0) goto L_0x02ed
            r11 = 1
            goto L_0x02ee
        L_0x02ed:
            r11 = 0
        L_0x02ee:
            r1.setEnabled(r11)
        L_0x02f1:
            return r15
        L_0x02f2:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.d.b.a(android.view.View, io.hansel.core.json.CoreJSONObject, int, io.hansel.segments.c, int, int, int, java.util.List, java.util.Set, java.util.HashMap):boolean");
    }

    public int b() {
        return this.f5508d;
    }

    public int c() {
        return this.f5509e;
    }
}
