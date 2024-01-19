package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.common.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class NavInflater {
    public static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    public Context mContext;
    public NavigatorProvider mNavigatorProvider;

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    public static NavType checkNavType(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType == null || navType == navType2) {
            return navType != null ? navType : navType2;
        }
        StringBuilder outline82 = GeneratedOutlineSupport.outline82("Type is ", str, " but found ", str2, ": ");
        outline82.append(typedValue.data);
        throw new XmlPullParserException(outline82.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    @android.annotation.SuppressLint({"ResourceType"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.NavGraph inflate(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.mContext
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x000e:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0053 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0049
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0053 }
            androidx.navigation.NavDestination r2 = r6.inflate(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0053 }
            boolean r4 = r2 instanceof androidx.navigation.NavGraph     // Catch:{ Exception -> 0x0053 }
            if (r4 == 0) goto L_0x002d
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2     // Catch:{ Exception -> 0x0053 }
            r1.close()
            return r2
        L_0x002d:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0053 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r4.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = "Root element <"
            r4.append(r5)     // Catch:{ Exception -> 0x0053 }
            r4.append(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r4.append(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0053 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            throw r2     // Catch:{ Exception -> 0x0053 }
        L_0x0049:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            throw r2     // Catch:{ Exception -> 0x0053 }
        L_0x0051:
            r7 = move-exception
            goto L_0x007b
        L_0x0053:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0051 }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x0051 }
            throw r3     // Catch:{ all -> 0x0051 }
        L_0x007b:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflate(int):androidx.navigation.NavGraph");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:120|121|122|123|124|125) */
    /* JADX WARNING: Code restructure failed: missing block: B:121:?, code lost:
        androidx.navigation.NavType.LongType.parseValue(r0);
        r2 = androidx.navigation.NavType.LongType;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        androidx.navigation.NavType.FloatType.parseValue(r0);
        r2 = androidx.navigation.NavType.FloatType;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        androidx.navigation.NavType.BoolType.parseValue(r0);
        r2 = androidx.navigation.NavType.BoolType;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0272, code lost:
        r2 = androidx.navigation.NavType.StringType;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:120:0x025a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x0262 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:124:0x026a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavArgument inflateArgument(android.content.res.TypedArray r16, android.content.res.Resources r17, int r18) throws org.xmlpull.v1.XmlPullParserException {
        /*
            r15 = this;
            r0 = r16
            int r1 = androidx.navigation.common.R$styleable.NavArgument_nullable
            r2 = 0
            boolean r1 = r0.getBoolean(r1, r2)
            java.lang.ThreadLocal<android.util.TypedValue> r3 = sTmpValue
            java.lang.Object r3 = r3.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L_0x001d
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            java.lang.ThreadLocal<android.util.TypedValue> r4 = sTmpValue
            r4.set(r3)
        L_0x001d:
            int r4 = androidx.navigation.common.R$styleable.NavArgument_argType
            java.lang.String r4 = r0.getString(r4)
            java.lang.String r5 = "reference"
            java.lang.String r6 = "float"
            java.lang.String r7 = "boolean"
            java.lang.String r8 = "integer"
            r9 = 0
            if (r4 == 0) goto L_0x0150
            java.lang.String r10 = r17.getResourcePackageName(r18)
            boolean r11 = r8.equals(r4)
            if (r11 == 0) goto L_0x003c
            androidx.navigation.NavType<java.lang.Integer> r10 = androidx.navigation.NavType.IntType
            goto L_0x0151
        L_0x003c:
            java.lang.String r11 = "integer[]"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x0048
            androidx.navigation.NavType<int[]> r10 = androidx.navigation.NavType.IntArrayType
            goto L_0x0151
        L_0x0048:
            java.lang.String r11 = "long"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x0054
            androidx.navigation.NavType<java.lang.Long> r10 = androidx.navigation.NavType.LongType
            goto L_0x0151
        L_0x0054:
            java.lang.String r11 = "long[]"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x0060
            androidx.navigation.NavType<long[]> r10 = androidx.navigation.NavType.LongArrayType
            goto L_0x0151
        L_0x0060:
            boolean r11 = r7.equals(r4)
            if (r11 == 0) goto L_0x006a
            androidx.navigation.NavType<java.lang.Boolean> r10 = androidx.navigation.NavType.BoolType
            goto L_0x0151
        L_0x006a:
            java.lang.String r11 = "boolean[]"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x0076
            androidx.navigation.NavType<boolean[]> r10 = androidx.navigation.NavType.BoolArrayType
            goto L_0x0151
        L_0x0076:
            java.lang.String r11 = "string"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x0082
            androidx.navigation.NavType<java.lang.String> r10 = androidx.navigation.NavType.StringType
            goto L_0x0151
        L_0x0082:
            java.lang.String r11 = "string[]"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x008e
            androidx.navigation.NavType<java.lang.String[]> r10 = androidx.navigation.NavType.StringArrayType
            goto L_0x0151
        L_0x008e:
            boolean r11 = r6.equals(r4)
            if (r11 == 0) goto L_0x0098
            androidx.navigation.NavType<java.lang.Float> r10 = androidx.navigation.NavType.FloatType
            goto L_0x0151
        L_0x0098:
            java.lang.String r11 = "float[]"
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x00a4
            androidx.navigation.NavType<float[]> r10 = androidx.navigation.NavType.FloatArrayType
            goto L_0x0151
        L_0x00a4:
            boolean r11 = r5.equals(r4)
            if (r11 == 0) goto L_0x00ae
            androidx.navigation.NavType<java.lang.Integer> r10 = androidx.navigation.NavType.ReferenceType
            goto L_0x0151
        L_0x00ae:
            boolean r11 = r4.isEmpty()
            if (r11 != 0) goto L_0x014d
            java.lang.String r11 = "."
            boolean r11 = r4.startsWith(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r11 == 0) goto L_0x00ce
            if (r10 == 0) goto L_0x00ce
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0146 }
            r11.<init>()     // Catch:{ ClassNotFoundException -> 0x0146 }
            r11.append(r10)     // Catch:{ ClassNotFoundException -> 0x0146 }
            r11.append(r4)     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.String r10 = r11.toString()     // Catch:{ ClassNotFoundException -> 0x0146 }
            goto L_0x00cf
        L_0x00ce:
            r10 = r4
        L_0x00cf:
            java.lang.String r11 = "[]"
            boolean r11 = r4.endsWith(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r11 == 0) goto L_0x0101
            int r11 = r10.length()     // Catch:{ ClassNotFoundException -> 0x0146 }
            int r11 = r11 + -2
            java.lang.String r10 = r10.substring(r2, r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.Class r11 = java.lang.Class.forName(r10)     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.Class<android.os.Parcelable> r12 = android.os.Parcelable.class
            boolean r12 = r12.isAssignableFrom(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r12 == 0) goto L_0x00f3
            androidx.navigation.NavType$ParcelableArrayType r10 = new androidx.navigation.NavType$ParcelableArrayType     // Catch:{ ClassNotFoundException -> 0x0146 }
            r10.<init>(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            goto L_0x0151
        L_0x00f3:
            java.lang.Class<java.io.Serializable> r12 = java.io.Serializable.class
            boolean r12 = r12.isAssignableFrom(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r12 == 0) goto L_0x012f
            androidx.navigation.NavType$SerializableArrayType r10 = new androidx.navigation.NavType$SerializableArrayType     // Catch:{ ClassNotFoundException -> 0x0146 }
            r10.<init>(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            goto L_0x0151
        L_0x0101:
            java.lang.Class r11 = java.lang.Class.forName(r10)     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.Class<android.os.Parcelable> r12 = android.os.Parcelable.class
            boolean r12 = r12.isAssignableFrom(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r12 == 0) goto L_0x0113
            androidx.navigation.NavType$ParcelableType r10 = new androidx.navigation.NavType$ParcelableType     // Catch:{ ClassNotFoundException -> 0x0146 }
            r10.<init>(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            goto L_0x0151
        L_0x0113:
            java.lang.Class<java.lang.Enum> r12 = java.lang.Enum.class
            boolean r12 = r12.isAssignableFrom(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r12 == 0) goto L_0x0121
            androidx.navigation.NavType$EnumType r10 = new androidx.navigation.NavType$EnumType     // Catch:{ ClassNotFoundException -> 0x0146 }
            r10.<init>(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            goto L_0x0151
        L_0x0121:
            java.lang.Class<java.io.Serializable> r12 = java.io.Serializable.class
            boolean r12 = r12.isAssignableFrom(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            if (r12 == 0) goto L_0x012f
            androidx.navigation.NavType$SerializableType r10 = new androidx.navigation.NavType$SerializableType     // Catch:{ ClassNotFoundException -> 0x0146 }
            r10.<init>(r11)     // Catch:{ ClassNotFoundException -> 0x0146 }
            goto L_0x0151
        L_0x012f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0146 }
            r1.<init>()     // Catch:{ ClassNotFoundException -> 0x0146 }
            r1.append(r10)     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.String r2 = " is not Serializable or Parcelable."
            r1.append(r2)     // Catch:{ ClassNotFoundException -> 0x0146 }
            java.lang.String r1 = r1.toString()     // Catch:{ ClassNotFoundException -> 0x0146 }
            r0.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x0146 }
            throw r0     // Catch:{ ClassNotFoundException -> 0x0146 }
        L_0x0146:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x014d:
            androidx.navigation.NavType<java.lang.String> r10 = androidx.navigation.NavType.StringType
            goto L_0x0151
        L_0x0150:
            r10 = r9
        L_0x0151:
            int r11 = androidx.navigation.common.R$styleable.NavArgument_android_defaultValue
            boolean r11 = r0.getValue(r11, r3)
            if (r11 == 0) goto L_0x027a
            androidx.navigation.NavType<java.lang.Integer> r11 = androidx.navigation.NavType.ReferenceType
            java.lang.String r12 = "' for "
            java.lang.String r13 = "unsupported value '"
            r14 = 16
            if (r10 != r11) goto L_0x019d
            int r0 = r3.resourceId
            if (r0 == 0) goto L_0x016d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x027b
        L_0x016d:
            int r0 = r3.type
            if (r0 != r14) goto L_0x017b
            int r0 = r3.data
            if (r0 != 0) goto L_0x017b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            goto L_0x027b
        L_0x017b:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r13)
            java.lang.CharSequence r2 = r3.string
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = r10.getName()
            r1.append(r2)
            java.lang.String r2 = ". Must be a reference to a resource."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x019d:
            int r2 = r3.resourceId
            if (r2 == 0) goto L_0x01ce
            if (r10 != 0) goto L_0x01aa
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r10 = r11
            goto L_0x027b
        L_0x01aa:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r13)
            java.lang.CharSequence r2 = r3.string
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = r10.getName()
            r1.append(r2)
            java.lang.String r2 = ". You must use a \""
            r1.append(r2)
            java.lang.String r2 = "\" type to reference other resources."
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r1, r5, r2)
            r0.<init>(r1)
            throw r0
        L_0x01ce:
            androidx.navigation.NavType<java.lang.String> r2 = androidx.navigation.NavType.StringType
            if (r10 != r2) goto L_0x01da
            int r2 = androidx.navigation.common.R$styleable.NavArgument_android_defaultValue
            java.lang.String r0 = r0.getString(r2)
            goto L_0x027b
        L_0x01da:
            int r0 = r3.type
            r2 = 3
            if (r0 == r2) goto L_0x0249
            r2 = 4
            if (r0 == r2) goto L_0x023a
            r2 = 5
            if (r0 == r2) goto L_0x0224
            r2 = 18
            if (r0 == r2) goto L_0x0212
            if (r0 < r14) goto L_0x01fd
            r2 = 31
            if (r0 > r2) goto L_0x01fd
            androidx.navigation.NavType<java.lang.Integer> r0 = androidx.navigation.NavType.IntType
            androidx.navigation.NavType r10 = checkNavType(r3, r10, r0, r4, r8)
            int r0 = r3.data
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x027b
        L_0x01fd:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "unsupported argument type "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            int r2 = r3.type
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0212:
            androidx.navigation.NavType<java.lang.Boolean> r0 = androidx.navigation.NavType.BoolType
            androidx.navigation.NavType r10 = checkNavType(r3, r10, r0, r4, r7)
            int r0 = r3.data
            if (r0 == 0) goto L_0x021e
            r0 = 1
            goto L_0x021f
        L_0x021e:
            r0 = 0
        L_0x021f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x027b
        L_0x0224:
            androidx.navigation.NavType<java.lang.Integer> r0 = androidx.navigation.NavType.IntType
            java.lang.String r2 = "dimension"
            androidx.navigation.NavType r10 = checkNavType(r3, r10, r0, r4, r2)
            android.util.DisplayMetrics r0 = r17.getDisplayMetrics()
            float r0 = r3.getDimension(r0)
            int r0 = (int) r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x027b
        L_0x023a:
            androidx.navigation.NavType<java.lang.Float> r0 = androidx.navigation.NavType.FloatType
            androidx.navigation.NavType r10 = checkNavType(r3, r10, r0, r4, r6)
            float r0 = r3.getFloat()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x027b
        L_0x0249:
            java.lang.CharSequence r0 = r3.string
            java.lang.String r0 = r0.toString()
            if (r10 != 0) goto L_0x0275
            androidx.navigation.NavType<java.lang.Integer> r2 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x025a }
            r2.parseValue(r0)     // Catch:{ IllegalArgumentException -> 0x025a }
            androidx.navigation.NavType<java.lang.Integer> r2 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x025a }
        L_0x0258:
            r10 = r2
            goto L_0x0275
        L_0x025a:
            androidx.navigation.NavType<java.lang.Long> r2 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x0262 }
            r2.parseValue(r0)     // Catch:{ IllegalArgumentException -> 0x0262 }
            androidx.navigation.NavType<java.lang.Long> r2 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x0262 }
            goto L_0x0258
        L_0x0262:
            androidx.navigation.NavType<java.lang.Float> r2 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x026a }
            r2.parseValue(r0)     // Catch:{ IllegalArgumentException -> 0x026a }
            androidx.navigation.NavType<java.lang.Float> r2 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x026a }
            goto L_0x0258
        L_0x026a:
            androidx.navigation.NavType<java.lang.Boolean> r2 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x0272 }
            r2.parseValue(r0)     // Catch:{ IllegalArgumentException -> 0x0272 }
            androidx.navigation.NavType<java.lang.Boolean> r2 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x0272 }
            goto L_0x0258
        L_0x0272:
            androidx.navigation.NavType<java.lang.String> r2 = androidx.navigation.NavType.StringType
            goto L_0x0258
        L_0x0275:
            java.lang.Object r0 = r10.parseValue(r0)
            goto L_0x027b
        L_0x027a:
            r0 = r9
        L_0x027b:
            if (r0 == 0) goto L_0x027f
            r2 = 1
            goto L_0x0281
        L_0x027f:
            r2 = 0
            r0 = r9
        L_0x0281:
            if (r10 == 0) goto L_0x0284
            r9 = r10
        L_0x0284:
            if (r9 != 0) goto L_0x0371
            boolean r3 = r0 instanceof java.lang.Integer
            if (r3 == 0) goto L_0x028f
            androidx.navigation.NavType<java.lang.Integer> r3 = androidx.navigation.NavType.IntType
        L_0x028c:
            r9 = r3
            goto L_0x0371
        L_0x028f:
            boolean r3 = r0 instanceof int[]
            if (r3 == 0) goto L_0x0296
            androidx.navigation.NavType<int[]> r3 = androidx.navigation.NavType.IntArrayType
            goto L_0x028c
        L_0x0296:
            boolean r3 = r0 instanceof java.lang.Long
            if (r3 == 0) goto L_0x029d
            androidx.navigation.NavType<java.lang.Long> r3 = androidx.navigation.NavType.LongType
            goto L_0x028c
        L_0x029d:
            boolean r3 = r0 instanceof long[]
            if (r3 == 0) goto L_0x02a4
            androidx.navigation.NavType<long[]> r3 = androidx.navigation.NavType.LongArrayType
            goto L_0x028c
        L_0x02a4:
            boolean r3 = r0 instanceof java.lang.Float
            if (r3 == 0) goto L_0x02ab
            androidx.navigation.NavType<java.lang.Float> r3 = androidx.navigation.NavType.FloatType
            goto L_0x028c
        L_0x02ab:
            boolean r3 = r0 instanceof float[]
            if (r3 == 0) goto L_0x02b2
            androidx.navigation.NavType<float[]> r3 = androidx.navigation.NavType.FloatArrayType
            goto L_0x028c
        L_0x02b2:
            boolean r3 = r0 instanceof java.lang.Boolean
            if (r3 == 0) goto L_0x02b9
            androidx.navigation.NavType<java.lang.Boolean> r3 = androidx.navigation.NavType.BoolType
            goto L_0x028c
        L_0x02b9:
            boolean r3 = r0 instanceof boolean[]
            if (r3 == 0) goto L_0x02c0
            androidx.navigation.NavType<boolean[]> r3 = androidx.navigation.NavType.BoolArrayType
            goto L_0x028c
        L_0x02c0:
            boolean r3 = r0 instanceof java.lang.String
            if (r3 != 0) goto L_0x036d
            if (r0 != 0) goto L_0x02c8
            goto L_0x036d
        L_0x02c8:
            boolean r3 = r0 instanceof java.lang.String[]
            if (r3 == 0) goto L_0x02cf
            androidx.navigation.NavType<java.lang.String[]> r3 = androidx.navigation.NavType.StringArrayType
            goto L_0x028c
        L_0x02cf:
            java.lang.Class r3 = r0.getClass()
            boolean r3 = r3.isArray()
            if (r3 == 0) goto L_0x02f7
            java.lang.Class<android.os.Parcelable> r3 = android.os.Parcelable.class
            java.lang.Class r4 = r0.getClass()
            java.lang.Class r4 = r4.getComponentType()
            boolean r3 = r3.isAssignableFrom(r4)
            if (r3 == 0) goto L_0x02f7
            androidx.navigation.NavType$ParcelableArrayType r3 = new androidx.navigation.NavType$ParcelableArrayType
            java.lang.Class r4 = r0.getClass()
            java.lang.Class r4 = r4.getComponentType()
            r3.<init>(r4)
            goto L_0x028c
        L_0x02f7:
            java.lang.Class r3 = r0.getClass()
            boolean r3 = r3.isArray()
            if (r3 == 0) goto L_0x0320
            java.lang.Class<java.io.Serializable> r3 = java.io.Serializable.class
            java.lang.Class r4 = r0.getClass()
            java.lang.Class r4 = r4.getComponentType()
            boolean r3 = r3.isAssignableFrom(r4)
            if (r3 == 0) goto L_0x0320
            androidx.navigation.NavType$SerializableArrayType r3 = new androidx.navigation.NavType$SerializableArrayType
            java.lang.Class r4 = r0.getClass()
            java.lang.Class r4 = r4.getComponentType()
            r3.<init>(r4)
            goto L_0x028c
        L_0x0320:
            boolean r3 = r0 instanceof android.os.Parcelable
            if (r3 == 0) goto L_0x032f
            androidx.navigation.NavType$ParcelableType r3 = new androidx.navigation.NavType$ParcelableType
            java.lang.Class r4 = r0.getClass()
            r3.<init>(r4)
            goto L_0x028c
        L_0x032f:
            boolean r3 = r0 instanceof java.lang.Enum
            if (r3 == 0) goto L_0x033e
            androidx.navigation.NavType$EnumType r3 = new androidx.navigation.NavType$EnumType
            java.lang.Class r4 = r0.getClass()
            r3.<init>(r4)
            goto L_0x028c
        L_0x033e:
            boolean r3 = r0 instanceof java.io.Serializable
            if (r3 == 0) goto L_0x034d
            androidx.navigation.NavType$SerializableType r3 = new androidx.navigation.NavType$SerializableType
            java.lang.Class r4 = r0.getClass()
            r3.<init>(r4)
            goto L_0x028c
        L_0x034d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Object of type "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r2.append(r0)
            java.lang.String r0 = " is not supported for navigation arguments."
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x036d:
            androidx.navigation.NavType<java.lang.String> r3 = androidx.navigation.NavType.StringType
            goto L_0x028c
        L_0x0371:
            androidx.navigation.NavArgument r3 = new androidx.navigation.NavArgument
            r3.<init>(r9, r1, r0, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflateArgument(android.content.res.TypedArray, android.content.res.Resources, int):androidx.navigation.NavArgument");
    }

    public final NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int i2;
        String str;
        Resources resources2 = resources;
        AttributeSet attributeSet2 = attributeSet;
        NavDestination createDestination = this.mNavigatorProvider.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.mContext, attributeSet2);
        int i3 = 1;
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i3) {
                break;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                break;
            } else if (next == 2 && depth2 <= depth) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    TypedArray obtainAttributes = resources2.obtainAttributes(attributeSet2, R$styleable.NavArgument);
                    String string = obtainAttributes.getString(R$styleable.NavArgument_android_name);
                    if (string != null) {
                        NavArgument inflateArgument = inflateArgument(obtainAttributes, resources2, i);
                        if (createDestination.mArguments == null) {
                            createDestination.mArguments = new HashMap<>();
                        }
                        createDestination.mArguments.put(string, inflateArgument);
                        obtainAttributes.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                } else {
                    int i4 = i;
                    if ("deepLink".equals(name)) {
                        TypedArray obtainAttributes2 = resources2.obtainAttributes(attributeSet2, R$styleable.NavDeepLink);
                        String string2 = obtainAttributes2.getString(R$styleable.NavDeepLink_uri);
                        String string3 = obtainAttributes2.getString(R$styleable.NavDeepLink_action);
                        String string4 = obtainAttributes2.getString(R$styleable.NavDeepLink_mimeType);
                        if (!TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3) || !TextUtils.isEmpty(string4)) {
                            String str2 = null;
                            String replace = string2 != null ? string2.replace("${applicationId}", this.mContext.getPackageName()) : null;
                            if (!TextUtils.isEmpty(string3)) {
                                str = string3.replace("${applicationId}", this.mContext.getPackageName());
                                if (str.isEmpty()) {
                                    throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                                }
                            } else {
                                str = null;
                            }
                            if (string4 != null) {
                                str2 = string4.replace("${applicationId}", this.mContext.getPackageName());
                            }
                            NavDeepLink navDeepLink = new NavDeepLink(replace, str, str2);
                            if (createDestination.mDeepLinks == null) {
                                createDestination.mDeepLinks = new ArrayList<>();
                            }
                            createDestination.mDeepLinks.add(navDeepLink);
                            obtainAttributes2.recycle();
                        } else {
                            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                        }
                    } else {
                        if ("action".equals(name)) {
                            TypedArray obtainAttributes3 = resources2.obtainAttributes(attributeSet2, R$styleable.NavAction);
                            int resourceId = obtainAttributes3.getResourceId(R$styleable.NavAction_android_id, 0);
                            NavAction navAction = new NavAction(obtainAttributes3.getResourceId(R$styleable.NavAction_destination, 0));
                            obtainAttributes3.getBoolean(R$styleable.NavAction_launchSingleTop, false);
                            obtainAttributes3.getResourceId(R$styleable.NavAction_popUpTo, -1);
                            obtainAttributes3.getBoolean(R$styleable.NavAction_popUpToInclusive, false);
                            obtainAttributes3.getResourceId(R$styleable.NavAction_enterAnim, -1);
                            obtainAttributes3.getResourceId(R$styleable.NavAction_exitAnim, -1);
                            obtainAttributes3.getResourceId(R$styleable.NavAction_popEnterAnim, -1);
                            obtainAttributes3.getResourceId(R$styleable.NavAction_popExitAnim, -1);
                            Bundle bundle = new Bundle();
                            int depth3 = xmlResourceParser.getDepth() + i3;
                            int i5 = i4;
                            while (true) {
                                int next2 = xmlResourceParser.next();
                                if (next2 == i3) {
                                    i2 = depth;
                                    break;
                                }
                                int depth4 = xmlResourceParser.getDepth();
                                i2 = depth;
                                if (depth4 < depth3 && next2 == 3) {
                                    break;
                                }
                                if (next2 == 2 && depth4 <= depth3) {
                                    if ("argument".equals(xmlResourceParser.getName())) {
                                        TypedArray obtainAttributes4 = resources2.obtainAttributes(attributeSet2, R$styleable.NavArgument);
                                        String string5 = obtainAttributes4.getString(R$styleable.NavArgument_android_name);
                                        if (string5 != null) {
                                            NavArgument inflateArgument2 = inflateArgument(obtainAttributes4, resources2, i5);
                                            boolean z = inflateArgument2.mDefaultValuePresent;
                                            if (z && z) {
                                                inflateArgument2.mType.put(bundle, string5, inflateArgument2.mDefaultValue);
                                            }
                                            obtainAttributes4.recycle();
                                        } else {
                                            throw new XmlPullParserException("Arguments must have a name");
                                        }
                                    }
                                    i5 = i4;
                                }
                                depth = i2;
                                i3 = 1;
                            }
                            bundle.isEmpty();
                            if (!createDestination.supportsActions()) {
                                throw new UnsupportedOperationException("Cannot add action " + resourceId + " to " + createDestination + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
                            } else if (resourceId != 0) {
                                if (createDestination.mActions == null) {
                                    createDestination.mActions = new SparseArrayCompat<>();
                                }
                                createDestination.mActions.put(resourceId, navAction);
                                obtainAttributes3.recycle();
                            } else {
                                throw new IllegalArgumentException("Cannot have an action with actionId 0");
                            }
                        } else {
                            i2 = depth;
                            if ("include".equals(name) && (createDestination instanceof NavGraph)) {
                                TypedArray obtainAttributes5 = resources2.obtainAttributes(attributeSet2, R$styleable.NavInclude);
                                ((NavGraph) createDestination).addDestination(inflate(obtainAttributes5.getResourceId(R$styleable.NavInclude_graph, 0)));
                                obtainAttributes5.recycle();
                            } else if (createDestination instanceof NavGraph) {
                                ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                            }
                        }
                        depth = i2;
                        i3 = 1;
                    }
                }
                i2 = depth;
                depth = i2;
                i3 = 1;
            }
        }
        return createDestination;
    }
}
