package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;

@KeepForSdk
@Class
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    @KeepForSdk
    public static final Creator<SafeParcelResponse> CREATOR = new zaq();
    @VersionField
    public final int zaa;
    @Field
    public final Parcel zab;
    public final int zac = 2;
    @Field
    public final zan zad;
    public final String zae;
    public int zaf;
    public int zag;

    @Constructor
    public SafeParcelResponse(@Param(id = 1) int i, @Param(id = 2) Parcel parcel, @Param(id = 3) zan zan) {
        String str;
        this.zaa = i;
        Preconditions.checkNotNull(parcel);
        this.zab = parcel;
        this.zad = zan;
        if (zan == null) {
            str = null;
        } else {
            str = zan.zac;
        }
        this.zae = str;
        this.zaf = 2;
    }

    public static final void zaI(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                Preconditions.checkNotNull(obj);
                sb.append(JsonUtils.escapeString(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(Base64Utils.encode((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(Base64Utils.encodeUrlSafe((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                Preconditions.checkNotNull(obj);
                MapUtils.writeStringMapToJson(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("Unknown type = ", i));
        }
    }

    public static final void zaJ(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        if (field.zab) {
            ArrayList arrayList = (ArrayList) obj;
            sb.append("[");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                zaI(sb, field.zaa, arrayList.get(i));
            }
            sb.append(CMapParser.MARK_END_OF_ARRAY);
            return;
        }
        zaI(sb, field.zaa, obj);
    }

    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field field, String str, ArrayList<T> arrayList) {
        zaG(field);
        ArrayList arrayList2 = new ArrayList();
        Preconditions.checkNotNull(arrayList);
        arrayList.size();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((SafeParcelResponse) ((FastJsonResponse) arrayList.get(i))).zaE());
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        int size2 = arrayList2.size();
        parcel.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            Parcel parcel2 = (Parcel) arrayList2.get(i2);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field field, String str, T t) {
        zaG(field);
        SafeParcelWriter.writeParcel(this.zab, field.zaf, ((SafeParcelResponse) t).zaE(), true);
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
        zan zan = this.zad;
        if (zan == null) {
            return null;
        }
        String str = this.zae;
        Preconditions.checkNotNull(str);
        return (Map) zan.zab.get(str);
    }

    public final Object getValueObject(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final boolean isPrimitiveFieldSet(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public final void setBooleanInternal(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        zaG(field);
        SafeParcelWriter.writeBoolean(this.zab, field.zaf, z);
    }

    public final void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        zaG(field);
        SafeParcelWriter.writeByteArray(this.zab, field.zaf, bArr, true);
    }

    public final void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        zaG(field);
        SafeParcelWriter.writeInt(this.zab, field.zaf, i);
    }

    public final void setLongInternal(FastJsonResponse.Field<?, ?> field, String str, long j) {
        zaG(field);
        SafeParcelWriter.writeLong(this.zab, field.zaf, j);
    }

    public final void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        zaG(field);
        SafeParcelWriter.writeString(this.zab, field.zaf, str2, true);
    }

    public final void setStringMapInternal(FastJsonResponse.Field<?, ?> field, String str, Map<String, String> map) {
        zaG(field);
        Bundle bundle = new Bundle();
        Preconditions.checkNotNull(map);
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        SafeParcelWriter.writeBundle(this.zab, field.zaf, bundle, true);
    }

    public final void setStringsInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<String> arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = arrayList.get(i);
        }
        SafeParcelWriter.writeStringArray(this.zab, field.zaf, strArr, true);
    }

    public final String toString() {
        Preconditions.checkNotNull(this.zad, "Cannot convert to JSON on client side.");
        Parcel zaE = zaE();
        zaE.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zan zan = this.zad;
        String str = this.zae;
        Preconditions.checkNotNull(str);
        Map map = (Map) zan.zab.get(str);
        Preconditions.checkNotNull(map);
        zaH(sb, map, zaE);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zan zan;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        int i2 = this.zaa;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        SafeParcelWriter.writeParcel(parcel, 2, zaE(), false);
        int i3 = this.zac;
        if (i3 != 0) {
            zan = i3 != 1 ? this.zad : this.zad;
        } else {
            zan = null;
        }
        SafeParcelWriter.writeParcelable(parcel, 3, zan, i, false);
        SafeParcelWriter.zzb(parcel, beginObjectHeader);
    }

    public final Parcel zaE() {
        int i = this.zaf;
        if (i == 0) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(this.zab);
            this.zag = beginObjectHeader;
            SafeParcelWriter.zzb(this.zab, beginObjectHeader);
            this.zaf = 2;
        } else if (i == 1) {
            SafeParcelWriter.zzb(this.zab, this.zag);
            this.zaf = 2;
        }
        return this.zab;
    }

    public final void zaG(FastJsonResponse.Field field) {
        if (field.zaf != -1) {
            Parcel parcel = this.zab;
            if (parcel != null) {
                int i = this.zaf;
                if (i == 0) {
                    this.zag = SafeParcelWriter.beginObjectHeader(parcel);
                    this.zaf = 1;
                } else if (i != 1) {
                    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
                }
            } else {
                throw new IllegalStateException("Internal Parcel object is null.");
            }
        } else {
            throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
        }
    }

    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v6, types: [java.math.BigInteger[]] */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r7v1, types: [long] */
    /* JADX WARNING: type inference failed for: r6v8, types: [long[]] */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r3v17, types: [float] */
    /* JADX WARNING: type inference failed for: r6v10, types: [float[]] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r7v2, types: [double] */
    /* JADX WARNING: type inference failed for: r6v12, types: [double[]] */
    /* JADX WARNING: type inference failed for: r6v13, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v14, types: [java.math.BigDecimal[]] */
    /* JADX WARNING: type inference failed for: r6v15, types: [boolean[]] */
    /* JADX WARNING: type inference failed for: r3v21, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v16, types: [boolean[]] */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r5v5, types: [android.os.Parcel] */
    /* JADX WARNING: type inference failed for: r7v5, types: [android.os.Parcel] */
    /* JADX WARNING: type inference failed for: r7v6, types: [android.os.Parcel[]] */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r6v26 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v4
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], long[], java.math.BigInteger[], float[], double[], java.math.BigDecimal[], boolean[], ?[OBJECT, ARRAY]]
      uses: [java.lang.Object[], ?[], ?[long, double][], ?[OBJECT, ARRAY][], ?[int, float][], boolean[]]
      mth insns count: 307
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zaH(java.lang.StringBuilder r13, java.util.Map r14, android.os.Parcel r15) {
        /*
            r12 = this;
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x000d:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r1 = r14.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r2 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r2
            int r2 = r2.zaf
            r0.put(r2, r1)
            goto L_0x000d
        L_0x0025:
            r14 = 123(0x7b, float:1.72E-43)
            r13.append(r14)
            int r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r15)
            r1 = 0
        L_0x002f:
            int r2 = r15.dataPosition()
            if (r2 >= r14) goto L_0x03ae
            int r2 = r15.readInt()
            char r3 = (char) r2
            java.lang.Object r3 = r0.get(r3)
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            if (r3 == 0) goto L_0x002f
            java.lang.String r4 = ","
            if (r1 == 0) goto L_0x0049
            r13.append(r4)
        L_0x0049:
            java.lang.Object r1 = r3.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r3.getValue()
            com.google.android.gms.common.server.response.FastJsonResponse$Field r3 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r3
            java.lang.String r5 = "\""
            java.lang.String r6 = "\":"
            com.android.tools.r8.GeneratedOutlineSupport.outline102(r13, r5, r1, r6)
            com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter r1 = r3.zak
            if (r1 == 0) goto L_0x0062
            r1 = 1
            goto L_0x0063
        L_0x0062:
            r1 = 0
        L_0x0063:
            if (r1 == 0) goto L_0x0138
            int r1 = r3.zac
            switch(r1) {
                case 0: goto L_0x0127;
                case 1: goto L_0x011a;
                case 2: goto L_0x0109;
                case 3: goto L_0x00f8;
                case 4: goto L_0x00e7;
                case 5: goto L_0x00da;
                case 6: goto L_0x00c9;
                case 7: goto L_0x00bc;
                case 8: goto L_0x00af;
                case 9: goto L_0x00af;
                case 10: goto L_0x007e;
                case 11: goto L_0x0076;
                default: goto L_0x006a;
            }
        L_0x006a:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Unknown field out type = "
            java.lang.String r14 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r14, r1)
            r13.<init>(r14)
            throw r13
        L_0x0076:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r14 = "Method does not accept concrete type."
            r13.<init>(r14)
            throw r13
        L_0x007e:
            android.os.Bundle r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r15, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Set r4 = r1.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x008f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00a6
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r1.getString(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            r2.put(r5, r6)
            goto L_0x008f
        L_0x00a6:
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r2)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x00af:
            byte[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r15, r2)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x00bc:
            java.lang.String r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r15, r2)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x00c9:
            boolean r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r15, r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x00da:
            java.math.BigDecimal r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimal(r15, r2)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x00e7:
            double r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDouble(r15, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x00f8:
            float r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r15, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x0109:
            long r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r15, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x011a:
            java.math.BigInteger r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigInteger(r15, r2)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x0127:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r15, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = com.google.android.gms.common.server.response.FastJsonResponse.zaD(r3, r1)
            zaJ(r13, r3, r1)
            goto L_0x03ab
        L_0x0138:
            boolean r1 = r3.zad
            if (r1 == 0) goto L_0x02e1
            java.lang.String r1 = "["
            r13.append(r1)
            int r1 = r3.zac
            r6 = 0
            switch(r1) {
                case 0: goto L_0x02c1;
                case 1: goto L_0x0297;
                case 2: goto L_0x026f;
                case 3: goto L_0x0247;
                case 4: goto L_0x021f;
                case 5: goto L_0x01eb;
                case 6: goto L_0x01c3;
                case 7: goto L_0x01a8;
                case 8: goto L_0x01a0;
                case 9: goto L_0x01a0;
                case 10: goto L_0x01a0;
                case 11: goto L_0x014f;
                default: goto L_0x0147;
            }
        L_0x0147:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Unknown field type out."
            r13.<init>(r14)
            throw r13
        L_0x014f:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x015a
            goto L_0x0185
        L_0x015a:
            int r5 = r15.readInt()
            android.os.Parcel[] r7 = new android.os.Parcel[r5]
            r8 = 0
        L_0x0161:
            if (r8 >= r5) goto L_0x0180
            int r9 = r15.readInt()
            if (r9 == 0) goto L_0x017b
            int r10 = r15.dataPosition()
            android.os.Parcel r11 = android.os.Parcel.obtain()
            r11.appendFrom(r15, r10, r9)
            r7[r8] = r11
            int r10 = r10 + r9
            r15.setDataPosition(r10)
            goto L_0x017d
        L_0x017b:
            r7[r8] = r6
        L_0x017d:
            int r8 = r8 + 1
            goto L_0x0161
        L_0x0180:
            int r2 = r2 + r1
            r15.setDataPosition(r2)
            r6 = r7
        L_0x0185:
            int r1 = r6.length
            r2 = 0
        L_0x0187:
            if (r2 >= r1) goto L_0x02da
            if (r2 <= 0) goto L_0x018e
            r13.append(r4)
        L_0x018e:
            r5 = r6[r2]
            r7 = 0
            r5.setDataPosition(r7)
            java.util.Map r5 = r3.zah()
            r7 = r6[r2]
            r12.zaH(r13, r5, r7)
            int r2 = r2 + 1
            goto L_0x0187
        L_0x01a0:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r14 = "List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported"
            r13.<init>(r14)
            throw r13
        L_0x01a8:
            java.lang.String[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r15, r2)
            int r2 = r1.length
            r3 = 0
        L_0x01ae:
            if (r3 >= r2) goto L_0x02da
            if (r3 == 0) goto L_0x01b5
            r13.append(r4)
        L_0x01b5:
            r13.append(r5)
            r6 = r1[r3]
            r13.append(r6)
            r13.append(r5)
            int r3 = r3 + 1
            goto L_0x01ae
        L_0x01c3:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x01ce
            goto L_0x01d6
        L_0x01ce:
            boolean[] r6 = r15.createBooleanArray()
            int r2 = r2 + r1
            r15.setDataPosition(r2)
        L_0x01d6:
            int r1 = r6.length
            r2 = 0
        L_0x01d8:
            if (r2 >= r1) goto L_0x02da
            if (r2 == 0) goto L_0x01df
            r13.append(r4)
        L_0x01df:
            boolean r3 = r6[r2]
            java.lang.String r3 = java.lang.Boolean.toString(r3)
            r13.append(r3)
            int r2 = r2 + 1
            goto L_0x01d8
        L_0x01eb:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x01f6
            goto L_0x021a
        L_0x01f6:
            int r3 = r15.readInt()
            java.math.BigDecimal[] r6 = new java.math.BigDecimal[r3]
            r4 = 0
        L_0x01fd:
            if (r4 >= r3) goto L_0x0216
            byte[] r5 = r15.createByteArray()
            int r7 = r15.readInt()
            java.math.BigDecimal r8 = new java.math.BigDecimal
            java.math.BigInteger r9 = new java.math.BigInteger
            r9.<init>(r5)
            r8.<init>(r9, r7)
            r6[r4] = r8
            int r4 = r4 + 1
            goto L_0x01fd
        L_0x0216:
            int r2 = r2 + r1
            r15.setDataPosition(r2)
        L_0x021a:
            com.google.android.gms.common.util.ArrayUtils.writeArray(r13, r6)
            goto L_0x02da
        L_0x021f:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x022a
            goto L_0x0232
        L_0x022a:
            double[] r6 = r15.createDoubleArray()
            int r2 = r2 + r1
            r15.setDataPosition(r2)
        L_0x0232:
            int r1 = r6.length
            r2 = 0
        L_0x0234:
            if (r2 >= r1) goto L_0x02da
            if (r2 == 0) goto L_0x023b
            r13.append(r4)
        L_0x023b:
            r7 = r6[r2]
            java.lang.String r3 = java.lang.Double.toString(r7)
            r13.append(r3)
            int r2 = r2 + 1
            goto L_0x0234
        L_0x0247:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x0252
            goto L_0x025a
        L_0x0252:
            float[] r6 = r15.createFloatArray()
            int r2 = r2 + r1
            r15.setDataPosition(r2)
        L_0x025a:
            int r1 = r6.length
            r2 = 0
        L_0x025c:
            if (r2 >= r1) goto L_0x02da
            if (r2 == 0) goto L_0x0263
            r13.append(r4)
        L_0x0263:
            r3 = r6[r2]
            java.lang.String r3 = java.lang.Float.toString(r3)
            r13.append(r3)
            int r2 = r2 + 1
            goto L_0x025c
        L_0x026f:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x027a
            goto L_0x0282
        L_0x027a:
            long[] r6 = r15.createLongArray()
            int r2 = r2 + r1
            r15.setDataPosition(r2)
        L_0x0282:
            int r1 = r6.length
            r2 = 0
        L_0x0284:
            if (r2 >= r1) goto L_0x02da
            if (r2 == 0) goto L_0x028b
            r13.append(r4)
        L_0x028b:
            r7 = r6[r2]
            java.lang.String r3 = java.lang.Long.toString(r7)
            r13.append(r3)
            int r2 = r2 + 1
            goto L_0x0284
        L_0x0297:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r15, r2)
            int r2 = r15.dataPosition()
            if (r1 != 0) goto L_0x02a2
            goto L_0x02bd
        L_0x02a2:
            int r3 = r15.readInt()
            java.math.BigInteger[] r6 = new java.math.BigInteger[r3]
            r4 = 0
        L_0x02a9:
            if (r4 >= r3) goto L_0x02b9
            java.math.BigInteger r5 = new java.math.BigInteger
            byte[] r7 = r15.createByteArray()
            r5.<init>(r7)
            r6[r4] = r5
            int r4 = r4 + 1
            goto L_0x02a9
        L_0x02b9:
            int r2 = r2 + r1
            r15.setDataPosition(r2)
        L_0x02bd:
            com.google.android.gms.common.util.ArrayUtils.writeArray(r13, r6)
            goto L_0x02da
        L_0x02c1:
            int[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(r15, r2)
            int r2 = r1.length
            r3 = 0
        L_0x02c7:
            if (r3 >= r2) goto L_0x02da
            if (r3 == 0) goto L_0x02ce
            r13.append(r4)
        L_0x02ce:
            r5 = r1[r3]
            java.lang.String r5 = java.lang.Integer.toString(r5)
            r13.append(r5)
            int r3 = r3 + 1
            goto L_0x02c7
        L_0x02da:
            java.lang.String r1 = "]"
            r13.append(r1)
            goto L_0x03ab
        L_0x02e1:
            int r1 = r3.zac
            switch(r1) {
                case 0: goto L_0x03a4;
                case 1: goto L_0x039c;
                case 2: goto L_0x0394;
                case 3: goto L_0x038c;
                case 4: goto L_0x0384;
                case 5: goto L_0x037c;
                case 6: goto L_0x0374;
                case 7: goto L_0x0362;
                case 8: goto L_0x0350;
                case 9: goto L_0x033e;
                case 10: goto L_0x02ff;
                case 11: goto L_0x02ee;
                default: goto L_0x02e6;
            }
        L_0x02e6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Unknown field type out"
            r13.<init>(r14)
            throw r13
        L_0x02ee:
            android.os.Parcel r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcel(r15, r2)
            r2 = 0
            r1.setDataPosition(r2)
            java.util.Map r2 = r3.zah()
            r12.zaH(r13, r2, r1)
            goto L_0x03ab
        L_0x02ff:
            android.os.Bundle r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r15, r2)
            java.util.Set r2 = r1.keySet()
            java.lang.String r3 = "{"
            r13.append(r3)
            java.util.Iterator r2 = r2.iterator()
            r3 = 1
        L_0x0311:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x0337
            java.lang.Object r6 = r2.next()
            java.lang.String r6 = (java.lang.String) r6
            if (r3 != 0) goto L_0x0322
            r13.append(r4)
        L_0x0322:
            java.lang.String r3 = "\":\""
            com.android.tools.r8.GeneratedOutlineSupport.outline102(r13, r5, r6, r3)
            java.lang.String r3 = r1.getString(r6)
            java.lang.String r3 = com.google.android.gms.common.util.JsonUtils.escapeString(r3)
            r13.append(r3)
            r13.append(r5)
            r3 = 0
            goto L_0x0311
        L_0x0337:
            java.lang.String r1 = "}"
            r13.append(r1)
            goto L_0x03ab
        L_0x033e:
            byte[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r15, r2)
            r13.append(r5)
            java.lang.String r1 = com.google.android.gms.common.util.Base64Utils.encodeUrlSafe(r1)
            r13.append(r1)
            r13.append(r5)
            goto L_0x03ab
        L_0x0350:
            byte[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r15, r2)
            r13.append(r5)
            java.lang.String r1 = com.google.android.gms.common.util.Base64Utils.encode(r1)
            r13.append(r1)
            r13.append(r5)
            goto L_0x03ab
        L_0x0362:
            java.lang.String r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r15, r2)
            r13.append(r5)
            java.lang.String r1 = com.google.android.gms.common.util.JsonUtils.escapeString(r1)
            r13.append(r1)
            r13.append(r5)
            goto L_0x03ab
        L_0x0374:
            boolean r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r15, r2)
            r13.append(r1)
            goto L_0x03ab
        L_0x037c:
            java.math.BigDecimal r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigDecimal(r15, r2)
            r13.append(r1)
            goto L_0x03ab
        L_0x0384:
            double r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readDouble(r15, r2)
            r13.append(r1)
            goto L_0x03ab
        L_0x038c:
            float r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r15, r2)
            r13.append(r1)
            goto L_0x03ab
        L_0x0394:
            long r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r15, r2)
            r13.append(r1)
            goto L_0x03ab
        L_0x039c:
            java.math.BigInteger r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBigInteger(r15, r2)
            r13.append(r1)
            goto L_0x03ab
        L_0x03a4:
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r15, r2)
            r13.append(r1)
        L_0x03ab:
            r1 = 1
            goto L_0x002f
        L_0x03ae:
            int r0 = r15.dataPosition()
            if (r0 != r14) goto L_0x03ba
            r14 = 125(0x7d, float:1.75E-43)
            r13.append(r14)
            return
        L_0x03ba:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException r13 = new com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException
            java.lang.String r0 = "Overread allowed size end="
            java.lang.String r14 = com.android.tools.r8.GeneratedOutlineSupport.outline41(r0, r14)
            r13.<init>(r14, r15)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.SafeParcelResponse.zaH(java.lang.StringBuilder, java.util.Map, android.os.Parcel):void");
    }

    public final void zab(FastJsonResponse.Field field, String str, BigDecimal bigDecimal) {
        zaG(field);
        Parcel parcel = this.zab;
        int i = field.zaf;
        if (bigDecimal == null) {
            parcel.writeInt(i | 0);
            return;
        }
        int zza = SafeParcelWriter.zza(parcel, i);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zad(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        BigDecimal[] bigDecimalArr = new BigDecimal[size];
        for (int i = 0; i < size; i++) {
            bigDecimalArr[i] = (BigDecimal) arrayList.get(i);
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i2].scale());
        }
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zaf(FastJsonResponse.Field field, String str, BigInteger bigInteger) {
        zaG(field);
        Parcel parcel = this.zab;
        int i = field.zaf;
        if (bigInteger == null) {
            parcel.writeInt(i | 0);
            return;
        }
        int zza = SafeParcelWriter.zza(parcel, i);
        parcel.writeByteArray(bigInteger.toByteArray());
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zah(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        BigInteger[] bigIntegerArr = new BigInteger[size];
        for (int i = 0; i < size; i++) {
            bigIntegerArr[i] = (BigInteger) arrayList.get(i);
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(bigIntegerArr[i2].toByteArray());
        }
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zak(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = ((Boolean) arrayList.get(i)).booleanValue();
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        parcel.writeBooleanArray(zArr);
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zan(FastJsonResponse.Field field, String str, double d2) {
        zaG(field);
        SafeParcelWriter.writeDouble(this.zab, field.zaf, d2);
    }

    public final void zap(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((Double) arrayList.get(i)).doubleValue();
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        parcel.writeDoubleArray(dArr);
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zar(FastJsonResponse.Field field, String str, float f2) {
        zaG(field);
        SafeParcelWriter.writeFloat(this.zab, field.zaf, f2);
    }

    public final void zat(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        parcel.writeFloatArray(fArr);
        SafeParcelWriter.zzb(parcel, zza);
    }

    public final void zaw(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        SafeParcelWriter.writeIntArray(this.zab, field.zaf, iArr, true);
    }

    public final void zaz(FastJsonResponse.Field field, String str, ArrayList arrayList) {
        zaG(field);
        Preconditions.checkNotNull(arrayList);
        int size = arrayList.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        Parcel parcel = this.zab;
        int zza = SafeParcelWriter.zza(parcel, field.zaf);
        parcel.writeLongArray(jArr);
        SafeParcelWriter.zzb(parcel, zza);
    }
}
