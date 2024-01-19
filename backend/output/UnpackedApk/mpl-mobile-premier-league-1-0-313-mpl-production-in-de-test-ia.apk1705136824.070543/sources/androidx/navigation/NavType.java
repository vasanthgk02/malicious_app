package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import java.io.Serializable;
import org.apache.pdfbox.pdfparser.BaseParser;

public abstract class NavType<T> {
    public static final NavType<boolean[]> BoolArrayType = new NavType<boolean[]>(true) {
        public Object get(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        public String getName() {
            return "boolean[]";
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putBooleanArray(str, (boolean[]) obj);
        }
    };
    public static final NavType<Boolean> BoolType = new NavType<Boolean>(false) {
        public Object get(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        public String getName() {
            return "boolean";
        }

        public Object parseValue(String str) {
            if (BaseParser.TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if (BaseParser.FALSE.equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    };
    public static final NavType<float[]> FloatArrayType = new NavType<float[]>(true) {
        public Object get(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        public String getName() {
            return "float[]";
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putFloatArray(str, (float[]) obj);
        }
    };
    public static final NavType<Float> FloatType = new NavType<Float>(false) {
        public Object get(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        public String getName() {
            return "float";
        }

        public Object parseValue(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        }
    };
    public static final NavType<int[]> IntArrayType = new NavType<int[]>(true) {
        public Object get(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        public String getName() {
            return "integer[]";
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putIntArray(str, (int[]) obj);
        }
    };
    public static final NavType<Integer> IntType = new NavType<Integer>(false) {
        public Object get(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        public String getName() {
            return "integer";
        }

        public Object parseValue(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    };
    public static final NavType<long[]> LongArrayType = new NavType<long[]>(true) {
        public Object get(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        public String getName() {
            return "long[]";
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putLongArray(str, (long[]) obj);
        }
    };
    public static final NavType<Long> LongType = new NavType<Long>(false) {
        public Object get(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        public String getName() {
            return "long";
        }

        public Object parseValue(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putLong(str, ((Long) obj).longValue());
        }
    };
    public static final NavType<Integer> ReferenceType = new NavType<Integer>(false) {
        public Object get(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        public String getName() {
            return "reference";
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putInt(str, ((Integer) obj).intValue());
        }
    };
    public static final NavType<String[]> StringArrayType = new NavType<String[]>(true) {
        public Object get(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        public String getName() {
            return "string[]";
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putStringArray(str, (String[]) obj);
        }
    };
    public static final NavType<String> StringType = new NavType<String>(true) {
        public Object get(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        public String getName() {
            return NetworkingModule.REQUEST_BODY_KEY_STRING;
        }

        public Object parseValue(String str) {
            return str;
        }

        public void put(Bundle bundle, String str, Object obj) {
            bundle.putString(str, (String) obj);
        }
    };
    public final boolean mNullableAllowed;

    public static final class EnumType<D extends Enum> extends SerializableType<D> {
        public final Class<D> mType;

        public EnumType(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        public String getName() {
            return this.mType.getName();
        }

        public D parseValue(String str) {
            for (D d2 : (Enum[]) this.mType.getEnumConstants()) {
                if (d2.name().equals(str)) {
                    return d2;
                }
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline36(this.mType, GeneratedOutlineSupport.outline80("Enum value ", str, " not found for type "), "."));
        }
    }

    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        public final Class<D[]> mArrayType;

        public ParcelableArrayType(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.mArrayType = Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ParcelableArrayType.class != obj.getClass()) {
                return false;
            }
            return this.mArrayType.equals(((ParcelableArrayType) obj).mArrayType);
        }

        public Object get(Bundle bundle, String str) {
            return (Parcelable[]) bundle.get(str);
        }

        public String getName() {
            return this.mArrayType.getName();
        }

        public int hashCode() {
            return this.mArrayType.hashCode();
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            this.mArrayType.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }
    }

    public static final class ParcelableType<D> extends NavType<D> {
        public final Class<D> mType;

        public ParcelableType(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ParcelableType.class != obj.getClass()) {
                return false;
            }
            return this.mType.equals(((ParcelableType) obj).mType);
        }

        public D get(Bundle bundle, String str) {
            return bundle.get(str);
        }

        public String getName() {
            return this.mType.getName();
        }

        public int hashCode() {
            return this.mType.hashCode();
        }

        public D parseValue(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public void put(Bundle bundle, String str, D d2) {
            this.mType.cast(d2);
            if (d2 == null || (d2 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d2);
            } else if (d2 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d2);
            }
        }
    }

    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        public final Class<D[]> mArrayType;

        public SerializableArrayType(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.mArrayType = Class.forName("[L" + cls.getName() + ";");
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SerializableArrayType.class != obj.getClass()) {
                return false;
            }
            return this.mArrayType.equals(((SerializableArrayType) obj).mArrayType);
        }

        public Object get(Bundle bundle, String str) {
            return (Serializable[]) bundle.get(str);
        }

        public String getName() {
            return this.mArrayType.getName();
        }

        public int hashCode() {
            return this.mArrayType.hashCode();
        }

        public Object parseValue(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARNING: type inference failed for: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable] */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v1, types: [java.lang.Object, java.io.Serializable[], java.io.Serializable]
          assigns: [java.io.Serializable[]]
          uses: [java.lang.Object, java.io.Serializable]
          mth insns count: 5
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void put(android.os.Bundle r2, java.lang.String r3, java.lang.Object r4) {
            /*
                r1 = this;
                java.io.Serializable[] r4 = (java.io.Serializable[]) r4
                java.lang.Class<D[]> r0 = r1.mArrayType
                r0.cast(r4)
                r2.putSerializable(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.SerializableArrayType.put(android.os.Bundle, java.lang.String, java.lang.Object):void");
        }
    }

    public static class SerializableType<D extends Serializable> extends NavType<D> {
        public final Class<D> mType;

        public SerializableType(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.mType = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return this.mType.equals(((SerializableType) obj).mType);
        }

        public Object get(Bundle bundle, String str) {
            return (Serializable) bundle.get(str);
        }

        public String getName() {
            return this.mType.getName();
        }

        public int hashCode() {
            return this.mType.hashCode();
        }

        public void put(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            this.mType.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        public D parseValue(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public SerializableType(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.mType = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }

    public NavType(boolean z) {
        this.mNullableAllowed = z;
    }

    public abstract T get(Bundle bundle, String str);

    public abstract String getName();

    public abstract T parseValue(String str);

    public abstract void put(Bundle bundle, String str, T t);

    public String toString() {
        return getName();
    }
}
