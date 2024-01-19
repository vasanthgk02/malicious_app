package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory {
    public static final ArrayValue createArrayValue(List<?> list, PrimitiveType primitiveType) {
        List<T> list2 = ArraysKt___ArraysJvmKt.toList(list);
        ArrayList arrayList = new ArrayList();
        for (T createConstantValue : list2) {
            ConstantValue<?> createConstantValue2 = createConstantValue(createConstantValue);
            if (createConstantValue2 != null) {
                arrayList.add(createConstantValue2);
            }
        }
        return new ArrayValue(arrayList, new ConstantValueFactory$createArrayValue$3(primitiveType));
    }

    /* JADX WARNING: type inference failed for: r0v20, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v22, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v23, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v26, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v28, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v30, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v33, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v35, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v36, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v39, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v41, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v42, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v45, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v47, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v49, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v52, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v54, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v55, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v58, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v60, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v61, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v64, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v66, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v67, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v78 */
    /* JADX WARNING: type inference failed for: r0v79 */
    /* JADX WARNING: type inference failed for: r0v80 */
    /* JADX WARNING: type inference failed for: r0v81 */
    /* JADX WARNING: type inference failed for: r0v82 */
    /* JADX WARNING: type inference failed for: r0v83 */
    /* JADX WARNING: type inference failed for: r0v84 */
    /* JADX WARNING: type inference failed for: r0v85 */
    /* JADX WARNING: type inference failed for: r0v86 */
    /* JADX WARNING: type inference failed for: r0v87 */
    /* JADX WARNING: type inference failed for: r0v88 */
    /* JADX WARNING: type inference failed for: r0v89 */
    /* JADX WARNING: type inference failed for: r0v90 */
    /* JADX WARNING: type inference failed for: r0v91 */
    /* JADX WARNING: type inference failed for: r0v92 */
    /* JADX WARNING: type inference failed for: r0v93 */
    /* JADX WARNING: type inference failed for: r0v94 */
    /* JADX WARNING: type inference failed for: r0v95 */
    /* JADX WARNING: type inference failed for: r0v96 */
    /* JADX WARNING: type inference failed for: r0v97 */
    /* JADX WARNING: type inference failed for: r0v98 */
    /* JADX WARNING: type inference failed for: r0v99 */
    /* JADX WARNING: type inference failed for: r0v100 */
    /* JADX WARNING: type inference failed for: r0v101 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> createConstantValue(java.lang.Object r5) {
        /*
            boolean r0 = r5 instanceof java.lang.Byte
            if (r0 == 0) goto L_0x0011
            kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue
            java.lang.Number r5 = (java.lang.Number) r5
            byte r5 = r5.byteValue()
            r0.<init>(r5)
            goto L_0x0278
        L_0x0011:
            boolean r0 = r5 instanceof java.lang.Short
            if (r0 == 0) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue
            java.lang.Number r5 = (java.lang.Number) r5
            short r5 = r5.shortValue()
            r0.<init>(r5)
            goto L_0x0278
        L_0x0022:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x0033
            kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            r0.<init>(r5)
            goto L_0x0278
        L_0x0033:
            boolean r0 = r5 instanceof java.lang.Long
            if (r0 == 0) goto L_0x0044
            kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue
            java.lang.Number r5 = (java.lang.Number) r5
            long r1 = r5.longValue()
            r0.<init>(r1)
            goto L_0x0278
        L_0x0044:
            boolean r0 = r5 instanceof java.lang.Character
            if (r0 == 0) goto L_0x0055
            kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue
            java.lang.Character r5 = (java.lang.Character) r5
            char r5 = r5.charValue()
            r0.<init>(r5)
            goto L_0x0278
        L_0x0055:
            boolean r0 = r5 instanceof java.lang.Float
            if (r0 == 0) goto L_0x0066
            kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r0.<init>(r5)
            goto L_0x0278
        L_0x0066:
            boolean r0 = r5 instanceof java.lang.Double
            if (r0 == 0) goto L_0x0077
            kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue
            java.lang.Number r5 = (java.lang.Number) r5
            double r1 = r5.doubleValue()
            r0.<init>(r1)
            goto L_0x0278
        L_0x0077:
            boolean r0 = r5 instanceof java.lang.Boolean
            if (r0 == 0) goto L_0x0088
            kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r0.<init>(r5)
            goto L_0x0278
        L_0x0088:
            boolean r0 = r5 instanceof java.lang.String
            if (r0 == 0) goto L_0x0095
            kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue
            java.lang.String r5 = (java.lang.String) r5
            r0.<init>(r5)
            goto L_0x0278
        L_0x0095:
            boolean r0 = r5 instanceof byte[]
            r1 = 0
            java.lang.String r2 = "<this>"
            r3 = 1
            if (r0 == 0) goto L_0x00d4
            byte[] r5 = (byte[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x00ca
            if (r0 == r3) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x00b1:
            if (r1 >= r2) goto L_0x00cc
            byte r3 = r5[r1]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x00b1
        L_0x00bf:
            byte r5 = r5[r1]
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x00cc
        L_0x00ca:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BYTE
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x00d4:
            boolean r0 = r5 instanceof short[]
            if (r0 == 0) goto L_0x010f
            short[] r5 = (short[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x0105
            if (r0 == r3) goto L_0x00fa
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x00ec:
            if (r1 >= r2) goto L_0x0107
            short r3 = r5[r1]
            java.lang.Short r3 = java.lang.Short.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x00ec
        L_0x00fa:
            short r5 = r5[r1]
            java.lang.Short r5 = java.lang.Short.valueOf(r5)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x0107
        L_0x0105:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x0107:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.SHORT
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x010f:
            boolean r0 = r5 instanceof int[]
            if (r0 == 0) goto L_0x014a
            int[] r5 = (int[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x0140
            if (r0 == r3) goto L_0x0135
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x0127:
            if (r1 >= r2) goto L_0x0142
            r3 = r5[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x0127
        L_0x0135:
            r5 = r5[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x0142
        L_0x0140:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x0142:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.INT
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x014a:
            boolean r0 = r5 instanceof long[]
            if (r0 == 0) goto L_0x0185
            long[] r5 = (long[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x017b
            if (r0 == r3) goto L_0x0170
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x0162:
            if (r1 >= r2) goto L_0x017d
            r3 = r5[r1]
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x0162
        L_0x0170:
            r0 = r5[r1]
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x017d
        L_0x017b:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x017d:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.LONG
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x0185:
            boolean r0 = r5 instanceof char[]
            if (r0 == 0) goto L_0x01c0
            char[] r5 = (char[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x01b6
            if (r0 == r3) goto L_0x01ab
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x019d:
            if (r1 >= r2) goto L_0x01b8
            char r3 = r5[r1]
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x019d
        L_0x01ab:
            char r5 = r5[r1]
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x01b8
        L_0x01b6:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x01b8:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.CHAR
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x01c0:
            boolean r0 = r5 instanceof float[]
            if (r0 == 0) goto L_0x01fb
            float[] r5 = (float[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x01f1
            if (r0 == r3) goto L_0x01e6
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x01d8:
            if (r1 >= r2) goto L_0x01f3
            r3 = r5[r1]
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x01d8
        L_0x01e6:
            r5 = r5[r1]
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x01f3
        L_0x01f1:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x01f3:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.FLOAT
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x01fb:
            boolean r0 = r5 instanceof double[]
            if (r0 == 0) goto L_0x0235
            double[] r5 = (double[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x022c
            if (r0 == r3) goto L_0x0221
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x0213:
            if (r1 >= r2) goto L_0x022e
            r3 = r5[r1]
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x0213
        L_0x0221:
            r0 = r5[r1]
            java.lang.Double r5 = java.lang.Double.valueOf(r0)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x022e
        L_0x022c:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x022e:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.DOUBLE
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x0235:
            boolean r0 = r5 instanceof boolean[]
            if (r0 == 0) goto L_0x026f
            boolean[] r5 = (boolean[]) r5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            int r0 = r5.length
            if (r0 == 0) goto L_0x0266
            if (r0 == r3) goto L_0x025b
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r2 = r5.length
            r0.<init>(r2)
            int r2 = r5.length
        L_0x024d:
            if (r1 >= r2) goto L_0x0268
            boolean r3 = r5[r1]
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0.add(r3)
            int r1 = r1 + 1
            goto L_0x024d
        L_0x025b:
            boolean r5 = r5[r1]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r5)
            goto L_0x0268
        L_0x0266:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x0268:
            kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType r5 = kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BOOLEAN
            kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue r0 = createArrayValue(r0, r5)
            goto L_0x0278
        L_0x026f:
            if (r5 != 0) goto L_0x0277
            kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue r0 = new kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue
            r0.<init>()
            goto L_0x0278
        L_0x0277:
            r0 = 0
        L_0x0278:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.createConstantValue(java.lang.Object):kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue");
    }
}
