package androidx.work;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Data {
    public static final Data EMPTY = new Builder().build();
    public static final String TAG = Logger.tagWithPrefix("Data");
    public Map<String, Object> mValues;

    public static final class Builder {
        public Map<String, Object> mValues = new HashMap();

        public Data build() {
            Data data = new Data(this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }

        public Builder putAll(Map<String, Object> map) {
            for (Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value == null) {
                    this.mValues.put(str, null);
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                        this.mValues.put(str, value);
                    } else if (cls == boolean[].class) {
                        this.mValues.put(str, Data.convertPrimitiveBooleanArray((boolean[]) value));
                    } else if (cls == byte[].class) {
                        this.mValues.put(str, Data.convertPrimitiveByteArray((byte[]) value));
                    } else if (cls == int[].class) {
                        this.mValues.put(str, Data.convertPrimitiveIntArray((int[]) value));
                    } else if (cls == long[].class) {
                        this.mValues.put(str, Data.convertPrimitiveLongArray((long[]) value));
                    } else if (cls == float[].class) {
                        this.mValues.put(str, Data.convertPrimitiveFloatArray((float[]) value));
                    } else if (cls == double[].class) {
                        this.mValues.put(str, Data.convertPrimitiveDoubleArray((double[]) value));
                    } else {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                    }
                }
            }
            return this;
        }
    }

    public Data() {
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Integer[] convertPrimitiveIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:12|13|(2:18|19)|20|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|(7:3|4|5|6|(2:8|9)|10|11)|28|29|30|32) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0043 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[SYNTHETIC, Splitter:B:26:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.Data fromByteArray(byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x004c
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException | ClassNotFoundException -> 0x003d, all -> 0x0033 }
            r2.<init>(r1)     // Catch:{ IOException | ClassNotFoundException -> 0x003d, all -> 0x0033 }
            int r5 = r2.readInt()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
        L_0x0019:
            if (r5 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            r0.put(r3, r4)     // Catch:{ IOException | ClassNotFoundException -> 0x0031, all -> 0x002d }
            int r5 = r5 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0043
        L_0x002d:
            r5 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x0034
        L_0x0031:
            r5 = r2
            goto L_0x003e
        L_0x0033:
            r0 = move-exception
        L_0x0034:
            if (r5 == 0) goto L_0x0039
            r5.close()     // Catch:{ IOException -> 0x0039 }
        L_0x0039:
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            throw r0
        L_0x003d:
        L_0x003e:
            if (r5 == 0) goto L_0x0043
            r5.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            r1.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            androidx.work.Data r5 = new androidx.work.Data
            r5.<init>(r0)
            return r5
        L_0x004c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|(2:34|35)|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:22|21|24|25|(0)|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|(2:7|5)|8|9|10|11|13|(2:15|16)(2:17|18)) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[SYNTHETIC, Splitter:B:27:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC, Splitter:B:34:0x006e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArrayInternal(androidx.work.Data r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x005f }
            r2.<init>(r0)     // Catch:{ IOException -> 0x005f }
            java.util.Map<java.lang.String, java.lang.Object> r1 = r4.mValues     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            int r1 = r1.size()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.mValues     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        L_0x001e:
            boolean r1 = r4.hasNext()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r4.next()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            r2.writeObject(r1)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            goto L_0x001e
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            r0.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0043
        L_0x0042:
        L_0x0043:
            int r4 = r0.size()
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r4 > r1) goto L_0x0050
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x0050:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r4.<init>(r0)
            throw r4
        L_0x0058:
            r4 = move-exception
            r1 = r2
            goto L_0x006c
        L_0x005b:
            r1 = r2
            goto L_0x005f
        L_0x005d:
            r4 = move-exception
            goto L_0x006c
        L_0x005f:
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            r0.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            return r4
        L_0x006c:
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ IOException -> 0x0071 }
        L_0x0071:
            r0.close()     // Catch:{ IOException -> 0x0074 }
        L_0x0074:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.toByteArrayInternal(androidx.work.Data):byte[]");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.mValues.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.mValues.get(next);
            Object obj3 = data.mValues.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public String getString(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String next : this.mValues.keySet()) {
                sb.append(next);
                sb.append(" : ");
                Object obj = this.mValues.get(next);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    public Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }
}
