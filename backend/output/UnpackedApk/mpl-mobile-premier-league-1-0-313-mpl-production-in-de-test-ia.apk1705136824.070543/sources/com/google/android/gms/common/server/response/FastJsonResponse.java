package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.Constant;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class FastJsonResponse {

    @ShowFirstParty
    @Class
    @VisibleForTesting
    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final int zaa;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final boolean zab;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final int zac;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final boolean zad;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final String zae;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final int zaf;
        public final Class zag;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public final String zah;
        @VersionField
        public final int zai;
        public zan zaj;
        @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field
        public FieldConverter zak;

        @Constructor
        public Field(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) boolean z, @Param(id = 4) int i3, @Param(id = 5) boolean z2, @Param(id = 6) String str, @Param(id = 7) int i4, @Param(id = 8) String str2, @Param(id = 9) zaa zaa2) {
            this.zai = i;
            this.zaa = i2;
            this.zab = z;
            this.zac = i3;
            this.zad = z2;
            this.zae = str;
            this.zaf = i4;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaa2 == null) {
                this.zak = null;
                return;
            }
            StringToIntConverter stringToIntConverter = zaa2.zab;
            if (stringToIntConverter != null) {
                this.zak = stringToIntConverter;
                return;
            }
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }

        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String str, int i, Class<T> cls) {
            Field field = new Field(11, false, 11, false, str, i, cls, null);
            return field;
        }

        @KeepForSdk
        public static Field<String, String> forString(String str, int i) {
            Field field = new Field(7, false, 7, false, str, i, null, null);
            return field;
        }

        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(String str, int i) {
            Field field = new Field(7, true, 7, true, str, i, null, null);
            return field;
        }

        public final String toString() {
            ToStringHelper toStringHelper = new ToStringHelper(this);
            toStringHelper.add(Response.VERSION_CODE, Integer.valueOf(this.zai));
            toStringHelper.add("typeIn", Integer.valueOf(this.zaa));
            toStringHelper.add("typeInArray", Boolean.valueOf(this.zab));
            toStringHelper.add("typeOut", Integer.valueOf(this.zac));
            toStringHelper.add("typeOutArray", Boolean.valueOf(this.zad));
            toStringHelper.add("outputFieldName", this.zae);
            toStringHelper.add("safeParcelFieldId", Integer.valueOf(this.zaf));
            String str = this.zah;
            if (str == null) {
                str = null;
            }
            toStringHelper.add("concreteTypeName", str);
            Class cls = this.zag;
            if (cls != null) {
                toStringHelper.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter fieldConverter = this.zak;
            if (fieldConverter != null) {
                toStringHelper.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return toStringHelper.toString();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            int i2 = this.zai;
            parcel.writeInt(262145);
            parcel.writeInt(i2);
            int i3 = this.zaa;
            parcel.writeInt(262146);
            parcel.writeInt(i3);
            boolean z = this.zab;
            parcel.writeInt(262147);
            parcel.writeInt(z ? 1 : 0);
            int i4 = this.zac;
            parcel.writeInt(262148);
            parcel.writeInt(i4);
            boolean z2 = this.zad;
            parcel.writeInt(262149);
            parcel.writeInt(z2 ? 1 : 0);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            int i5 = this.zaf;
            parcel.writeInt(262151);
            parcel.writeInt(i5);
            String str = this.zah;
            zaa zaa2 = null;
            if (str == null) {
                str = null;
            }
            SafeParcelWriter.writeString(parcel, 8, str, false);
            FieldConverter fieldConverter = this.zak;
            if (fieldConverter != null) {
                zaa2 = zaa.zaa(fieldConverter);
            }
            SafeParcelWriter.writeParcelable(parcel, 9, zaa2, i, false);
            SafeParcelWriter.zzb(parcel, beginObjectHeader);
        }

        public final Map zah() {
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.zaj);
            Map zab2 = this.zaj.zab(this.zah);
            Preconditions.checkNotNull(zab2);
            return zab2;
        }

        public Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, FieldConverter fieldConverter) {
            this.zai = 1;
            this.zaa = i;
            this.zab = z;
            this.zac = i2;
            this.zad = z2;
            this.zae = str;
            this.zaf = i3;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.zak = null;
        }
    }

    @ShowFirstParty
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public interface FieldConverter<I, O> {
        Object zac(Object obj);

        Object zad(Object obj);
    }

    public static final Object zaD(Field field, Object obj) {
        FieldConverter fieldConverter = field.zak;
        if (fieldConverter == null) {
            return obj;
        }
        Preconditions.checkNotNull(fieldConverter);
        return field.zak.zad(obj);
    }

    private final void zaE(Field field, Object obj) {
        String str = field.zae;
        Preconditions.checkNotNull(field.zak);
        Object zac = field.zak.zac(obj);
        Preconditions.checkNotNull(zac);
        int i = field.zac;
        switch (i) {
            case 0:
                setIntegerInternal(field, str, ((Integer) zac).intValue());
                return;
            case 1:
                zaf(field, str, (BigInteger) zac);
                return;
            case 2:
                setLongInternal(field, str, ((Long) zac).longValue());
                return;
            case 4:
                zan(field, str, ((Double) zac).doubleValue());
                return;
            case 5:
                zab(field, str, (BigDecimal) zac);
                return;
            case 6:
                setBooleanInternal(field, str, ((Boolean) zac).booleanValue());
                return;
            case 7:
                setStringInternal(field, str, (String) zac);
                return;
            case 8:
            case 9:
                setDecodedBytesInternal(field, str, (byte[]) zac);
                return;
            default:
                throw new IllegalStateException(GeneratedOutlineSupport.outline41("Unsupported type for conversion: ", i));
        }
    }

    public static final void zaF(StringBuilder sb, Field field, Object obj) {
        int i = field.zaa;
        if (i == 11) {
            Class cls = field.zag;
            Preconditions.checkNotNull(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else if (i == 7) {
            sb.append("\"");
            sb.append(JsonUtils.escapeString((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    public static final void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
        }
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String str, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String str, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    @KeepForSdk
    public Object getFieldValue(Field field) {
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        Preconditions.checkState(getValueObject(str) == null, "Concrete field shouldn't be value object: %s", field.zae);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            return getClass().getMethod(Constant.GET + upperCase + substring, new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @KeepForSdk
    public abstract Object getValueObject(String str);

    @KeepForSdk
    public boolean isFieldSet(Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @KeepForSdk
    public abstract boolean isPrimitiveFieldSet(String str);

    @KeepForSdk
    public void setBooleanInternal(Field<?, ?> field, String str, boolean z) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    @KeepForSdk
    public void setDecodedBytesInternal(Field<?, ?> field, String str, byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    @KeepForSdk
    public void setIntegerInternal(Field<?, ?> field, String str, int i) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    @KeepForSdk
    public void setLongInternal(Field<?, ?> field, String str, long j) {
        throw new UnsupportedOperationException("Long not supported");
    }

    @KeepForSdk
    public void setStringInternal(Field<?, ?> field, String str, String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    @KeepForSdk
    public void setStringMapInternal(Field<?, ?> field, String str, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    @KeepForSdk
    public void setStringsInternal(Field<?, ?> field, String str, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb = new StringBuilder(100);
        for (String next : fieldMappings.keySet()) {
            Field field = fieldMappings.get(next);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                GeneratedOutlineSupport.outline102(sb, "\"", next, "\":");
                if (zaD != null) {
                    switch (field.zac) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64Utils.encode((byte[]) zaD));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64Utils.encodeUrlSafe((byte[]) zaD));
                            sb.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb, (HashMap) zaD);
                            break;
                        default:
                            if (!field.zab) {
                                zaF(sb, field, zaD);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    if (i > 0) {
                                        sb.append(",");
                                    }
                                    Object obj = arrayList.get(i);
                                    if (obj != null) {
                                        zaF(sb, field, obj);
                                    }
                                }
                                sb.append(CMapParser.MARK_END_OF_ARRAY);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    public final void zaA(Field field, String str) {
        if (field.zak != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final void zaB(Field field, Map map) {
        if (field.zak != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public final void zaC(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    public final void zaa(Field field, BigDecimal bigDecimal) {
        if (field.zak != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.zae, bigDecimal);
        }
    }

    public void zab(Field field, String str, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final void zac(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    public void zad(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final void zae(Field field, BigInteger bigInteger) {
        if (field.zak != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.zae, bigInteger);
        }
    }

    public void zaf(Field field, String str, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final void zag(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.zae, arrayList);
        }
    }

    public void zah(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final void zai(Field field, boolean z) {
        if (field.zak != null) {
            zaE(field, Boolean.valueOf(z));
        } else {
            setBooleanInternal(field, field.zae, z);
        }
    }

    public final void zaj(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.zae, arrayList);
        }
    }

    public void zak(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final void zal(Field field, byte[] bArr) {
        if (field.zak != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final void zam(Field field, double d2) {
        if (field.zak != null) {
            zaE(field, Double.valueOf(d2));
        } else {
            zan(field, field.zae, d2);
        }
    }

    public void zan(Field field, String str, double d2) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final void zao(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.zae, arrayList);
        }
    }

    public void zap(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final void zaq(Field field, float f2) {
        if (field.zak != null) {
            zaE(field, Float.valueOf(f2));
        } else {
            zar(field, field.zae, f2);
        }
    }

    public void zar(Field field, String str, float f2) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final void zas(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.zae, arrayList);
        }
    }

    public void zat(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final void zau(Field field, int i) {
        if (field.zak != null) {
            zaE(field, Integer.valueOf(i));
        } else {
            setIntegerInternal(field, field.zae, i);
        }
    }

    public final void zav(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.zae, arrayList);
        }
    }

    public void zaw(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final void zax(Field field, long j) {
        if (field.zak != null) {
            zaE(field, Long.valueOf(j));
        } else {
            setLongInternal(field, field.zae, j);
        }
    }

    public final void zay(Field field, ArrayList arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.zae, arrayList);
        }
    }

    public void zaz(Field field, String str, ArrayList arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }
}
