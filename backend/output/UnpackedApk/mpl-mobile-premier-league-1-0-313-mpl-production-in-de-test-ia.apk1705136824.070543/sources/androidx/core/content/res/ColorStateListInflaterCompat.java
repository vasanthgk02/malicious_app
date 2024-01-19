package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    public static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    public static ColorStateList createFromXml(Resources resources, XmlPullParser xmlPullParser, Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARNING: type inference failed for: r9v16, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011a  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList createFromXmlInner(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            java.lang.String r3 = r18.getName()
            java.lang.String r4 = "selector"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0149
            int r3 = r18.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r6 = new int[r5][]
            int[] r5 = new int[r5]
            r7 = 0
            r8 = 0
        L_0x0020:
            int r9 = r18.next()
            if (r9 == r4) goto L_0x0139
            int r10 = r18.getDepth()
            if (r10 >= r3) goto L_0x002f
            r11 = 3
            if (r9 == r11) goto L_0x0139
        L_0x002f:
            r11 = 2
            if (r9 != r11) goto L_0x0136
            if (r10 > r3) goto L_0x0136
            java.lang.String r9 = r18.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0042
            goto L_0x0136
        L_0x0042:
            int[] r9 = androidx.core.R$styleable.ColorStateListItem
            if (r2 != 0) goto L_0x004b
            android.content.res.TypedArray r9 = r0.obtainAttributes(r1, r9)
            goto L_0x004f
        L_0x004b:
            android.content.res.TypedArray r9 = r2.obtainStyledAttributes(r1, r9, r7, r7)
        L_0x004f:
            int r10 = androidx.core.R$styleable.ColorStateListItem_android_color
            r11 = -1
            int r10 = r9.getResourceId(r10, r11)
            r12 = -65281(0xffffffffffff00ff, float:NaN)
            if (r10 == r11) goto L_0x0095
            java.lang.ThreadLocal<android.util.TypedValue> r11 = sTempTypedValue
            java.lang.Object r11 = r11.get()
            android.util.TypedValue r11 = (android.util.TypedValue) r11
            if (r11 != 0) goto L_0x006f
            android.util.TypedValue r11 = new android.util.TypedValue
            r11.<init>()
            java.lang.ThreadLocal<android.util.TypedValue> r13 = sTempTypedValue
            r13.set(r11)
        L_0x006f:
            r0.getValue(r10, r11, r4)
            int r11 = r11.type
            r13 = 28
            if (r11 < r13) goto L_0x007e
            r13 = 31
            if (r11 > r13) goto L_0x007e
            r11 = 1
            goto L_0x007f
        L_0x007e:
            r11 = 0
        L_0x007f:
            if (r11 != 0) goto L_0x0095
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)     // Catch:{ Exception -> 0x008e }
            android.content.res.ColorStateList r10 = createFromXml(r0, r10, r2)     // Catch:{ Exception -> 0x008e }
            int r10 = r10.getDefaultColor()     // Catch:{ Exception -> 0x008e }
            goto L_0x009b
        L_0x008e:
            int r10 = androidx.core.R$styleable.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r12)
            goto L_0x009b
        L_0x0095:
            int r10 = androidx.core.R$styleable.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r12)
        L_0x009b:
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = androidx.core.R$styleable.ColorStateListItem_android_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L_0x00ac
            int r12 = androidx.core.R$styleable.ColorStateListItem_android_alpha
            float r11 = r9.getFloat(r12, r11)
            goto L_0x00ba
        L_0x00ac:
            int r12 = androidx.core.R$styleable.ColorStateListItem_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L_0x00ba
            int r12 = androidx.core.R$styleable.ColorStateListItem_alpha
            float r11 = r9.getFloat(r12, r11)
        L_0x00ba:
            r9.recycle()
            int r9 = r19.getAttributeCount()
            int[] r12 = new int[r9]
            r13 = 0
            r14 = 0
        L_0x00c5:
            if (r13 >= r9) goto L_0x00ea
            int r15 = r1.getAttributeNameResource(r13)
            r4 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r4) goto L_0x00e6
            r4 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r4) goto L_0x00e6
            int r4 = androidx.core.R$attr.alpha
            if (r15 == r4) goto L_0x00e6
            int r4 = r14 + 1
            boolean r16 = r1.getAttributeBooleanValue(r13, r7)
            if (r16 == 0) goto L_0x00e2
            goto L_0x00e3
        L_0x00e2:
            int r15 = -r15
        L_0x00e3:
            r12[r14] = r15
            r14 = r4
        L_0x00e6:
            int r13 = r13 + 1
            r4 = 1
            goto L_0x00c5
        L_0x00ea:
            int[] r4 = android.util.StateSet.trimStateSet(r12, r14)
            int r9 = android.graphics.Color.alpha(r10)
            float r9 = (float) r9
            float r9 = r9 * r11
            int r9 = java.lang.Math.round(r9)
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r10 = r10 & r11
            int r9 = r9 << 24
            r9 = r9 | r10
            int r10 = r8 + 1
            int r11 = r5.length
            r12 = 4
            r13 = 8
            if (r10 <= r11) goto L_0x0115
            if (r8 > r12) goto L_0x010d
            r11 = 8
            goto L_0x010f
        L_0x010d:
            int r11 = r8 * 2
        L_0x010f:
            int[] r11 = new int[r11]
            java.lang.System.arraycopy(r5, r7, r11, r7, r8)
            r5 = r11
        L_0x0115:
            r5[r8] = r9
            int r9 = r6.length
            if (r10 <= r9) goto L_0x0131
            java.lang.Class r9 = r6.getClass()
            java.lang.Class r9 = r9.getComponentType()
            if (r8 > r12) goto L_0x0125
            goto L_0x0127
        L_0x0125:
            int r13 = r8 * 2
        L_0x0127:
            java.lang.Object r9 = java.lang.reflect.Array.newInstance(r9, r13)
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            java.lang.System.arraycopy(r6, r7, r9, r7, r8)
            r6 = r9
        L_0x0131:
            r6[r8] = r4
            int[][] r6 = (int[][]) r6
            r8 = r10
        L_0x0136:
            r4 = 1
            goto L_0x0020
        L_0x0139:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8][]
            java.lang.System.arraycopy(r5, r7, r0, r7, r8)
            java.lang.System.arraycopy(r6, r7, r1, r7, r8)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        L_0x0149:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r18.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": invalid color state list tag "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.createFromXmlInner(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList inflate(Resources resources, int i, Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception unused) {
            return null;
        }
    }
}
