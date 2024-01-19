package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpolationAnimatedNode extends ValueAnimatedNode {
    public static final Pattern fpPattern = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
    public final String mExtrapolateLeft;
    public final String mExtrapolateRight;
    public final boolean mHasStringOutput;
    public final double[] mInputRange;
    public int mNumVals;
    public final double[] mOutputRange;
    public double[][] mOutputs;
    public ValueAnimatedNode mParent;
    public String mPattern;
    public final Matcher mSOutputMatcher;
    public boolean mShouldRound;

    public InterpolationAnimatedNode(ReadableMap readableMap) {
        this.mInputRange = fromDoubleArray(readableMap.getArray("inputRange"));
        ReadableArray array = readableMap.getArray("outputRange");
        boolean z = array.getType(0) == ReadableType.String;
        this.mHasStringOutput = z;
        if (z) {
            int size = array.size();
            this.mOutputRange = new double[size];
            String string = array.getString(0);
            this.mPattern = string;
            this.mShouldRound = string.startsWith("rgb");
            this.mSOutputMatcher = fpPattern.matcher(this.mPattern);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                Matcher matcher = fpPattern.matcher(array.getString(i));
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                while (matcher.find()) {
                    arrayList2.add(Double.valueOf(Double.parseDouble(matcher.group())));
                }
                this.mOutputRange[i] = ((Double) arrayList2.get(0)).doubleValue();
            }
            int size2 = ((ArrayList) arrayList.get(0)).size();
            this.mNumVals = size2;
            this.mOutputs = new double[size2][];
            for (int i2 = 0; i2 < this.mNumVals; i2++) {
                double[] dArr = new double[size];
                this.mOutputs[i2] = dArr;
                for (int i3 = 0; i3 < size; i3++) {
                    dArr[i3] = ((Double) ((ArrayList) arrayList.get(i3)).get(i2)).doubleValue();
                }
            }
        } else {
            this.mOutputRange = fromDoubleArray(array);
            this.mSOutputMatcher = null;
        }
        this.mExtrapolateLeft = readableMap.getString("extrapolateLeft");
        this.mExtrapolateRight = readableMap.getString("extrapolateRight");
    }

    public static double[] fromDoubleArray(ReadableArray readableArray) {
        int size = readableArray.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = readableArray.getDouble(i);
        }
        return dArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static double interpolate(double r16, double[] r18, double[] r19, java.lang.String r20, java.lang.String r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = 1
        L_0x0007:
            int r4 = r0.length
            int r4 = r4 + -1
            if (r3 >= r4) goto L_0x0016
            r4 = r0[r3]
            int r6 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r6 < 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0016:
            int r3 = r3 + -1
            r4 = r0[r3]
            int r6 = r3 + 1
            r7 = r0[r6]
            r9 = r19[r3]
            r11 = r19[r6]
            java.lang.String r0 = "Invalid extrapolation type "
            java.lang.String r3 = "clamp"
            java.lang.String r6 = "identity"
            java.lang.String r13 = "extend"
            r14 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
            int r15 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            r18 = r15
            if (r15 >= 0) goto L_0x0078
            int r15 = r20.hashCode()
            if (r15 == r14) goto L_0x0054
            r14 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
            if (r15 == r14) goto L_0x004c
            r14 = 94742715(0x5a5a8bb, float:1.5578507E-35)
            if (r15 == r14) goto L_0x0044
            goto L_0x005c
        L_0x0044:
            boolean r14 = r1.equals(r3)
            if (r14 == 0) goto L_0x005c
            r14 = 1
            goto L_0x005d
        L_0x004c:
            boolean r14 = r1.equals(r6)
            if (r14 == 0) goto L_0x005c
            r14 = 0
            goto L_0x005d
        L_0x0054:
            boolean r14 = r1.equals(r13)
            if (r14 == 0) goto L_0x005c
            r14 = 2
            goto L_0x005d
        L_0x005c:
            r14 = -1
        L_0x005d:
            if (r14 == 0) goto L_0x0074
            r15 = 1
            if (r14 == r15) goto L_0x0072
            r15 = 2
            if (r14 != r15) goto L_0x0066
            goto L_0x0078
        L_0x0066:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "for left extrapolation"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r0, r1, r3)
            r2.<init>(r0)
            throw r2
        L_0x0072:
            r14 = r4
            goto L_0x007a
        L_0x0074:
            r11 = r16
            goto L_0x00de
        L_0x0078:
            r14 = r16
        L_0x007a:
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c4
            int r1 = r21.hashCode()
            r16 = r14
            r14 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
            if (r1 == r14) goto L_0x00a4
            r13 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
            if (r1 == r13) goto L_0x009c
            r6 = 94742715(0x5a5a8bb, float:1.5578507E-35)
            if (r1 == r6) goto L_0x0094
            goto L_0x00ac
        L_0x0094:
            boolean r1 = r2.equals(r3)
            if (r1 == 0) goto L_0x00ac
            r1 = 1
            goto L_0x00ad
        L_0x009c:
            boolean r1 = r2.equals(r6)
            if (r1 == 0) goto L_0x00ac
            r1 = 0
            goto L_0x00ad
        L_0x00a4:
            boolean r1 = r2.equals(r13)
            if (r1 == 0) goto L_0x00ac
            r1 = 2
            goto L_0x00ad
        L_0x00ac:
            r1 = -1
        L_0x00ad:
            if (r1 == 0) goto L_0x0074
            r3 = 1
            if (r1 == r3) goto L_0x00c2
            r3 = 2
            if (r1 != r3) goto L_0x00b6
            goto L_0x00c6
        L_0x00b6:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "for right extrapolation"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r0, r2, r3)
            r1.<init>(r0)
            throw r1
        L_0x00c2:
            r14 = r7
            goto L_0x00c8
        L_0x00c4:
            r16 = r14
        L_0x00c6:
            r14 = r16
        L_0x00c8:
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x00cd
            goto L_0x00d3
        L_0x00cd:
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x00d5
            if (r18 > 0) goto L_0x00de
        L_0x00d3:
            r11 = r9
            goto L_0x00de
        L_0x00d5:
            double r11 = r11 - r9
            double r14 = r14 - r4
            double r14 = r14 * r11
            double r7 = r7 - r4
            double r14 = r14 / r7
            double r0 = r14 + r9
            r11 = r0
        L_0x00de:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.interpolate(double, double[], double[], java.lang.String, java.lang.String):double");
    }

    public void onAttachedToNode(AnimatedNode animatedNode) {
        if (this.mParent != null) {
            throw new IllegalStateException("Parent already attached");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            this.mParent = (ValueAnimatedNode) animatedNode;
        } else {
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
    }

    public void onDetachedFromNode(AnimatedNode animatedNode) {
        if (animatedNode == this.mParent) {
            this.mParent = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    public void update() {
        ValueAnimatedNode valueAnimatedNode = this.mParent;
        if (valueAnimatedNode != null) {
            double value = valueAnimatedNode.getValue();
            double interpolate = interpolate(value, this.mInputRange, this.mOutputRange, this.mExtrapolateLeft, this.mExtrapolateRight);
            this.mValue = interpolate;
            if (this.mHasStringOutput) {
                if (this.mNumVals > 1) {
                    StringBuffer stringBuffer = new StringBuffer(this.mPattern.length());
                    this.mSOutputMatcher.reset();
                    int i = 0;
                    while (this.mSOutputMatcher.find()) {
                        int i2 = i + 1;
                        double interpolate2 = interpolate(value, this.mInputRange, this.mOutputs[i], this.mExtrapolateLeft, this.mExtrapolateRight);
                        if (this.mShouldRound) {
                            boolean z = i2 == 4;
                            if (z) {
                                interpolate2 *= 1000.0d;
                            }
                            int round = (int) Math.round(interpolate2);
                            this.mSOutputMatcher.appendReplacement(stringBuffer, z ? Double.toString(((double) round) / 1000.0d) : Integer.toString(round));
                        } else {
                            int i3 = (int) interpolate2;
                            this.mSOutputMatcher.appendReplacement(stringBuffer, ((double) i3) != interpolate2 ? Double.toString(interpolate2) : Integer.toString(i3));
                        }
                        i = i2;
                    }
                    this.mSOutputMatcher.appendTail(stringBuffer);
                    this.mAnimatedObject = stringBuffer.toString();
                } else {
                    this.mAnimatedObject = this.mSOutputMatcher.replaceFirst(String.valueOf(interpolate));
                }
            }
        }
    }
}
