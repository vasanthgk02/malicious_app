package androidx.versionedparcelable;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class VersionedParcel {
    public final ArrayMap<String, Class> mParcelizerCache;
    public final ArrayMap<String, Method> mReadCache;
    public final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public final Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.mParcelizerCache.getOrDefault(cls.getName(), null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method getReadMethod(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method method = (Method) this.mReadCache.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method getWriteMethod(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.mWriteCache.getOrDefault(cls.getName(), null);
        if (method != null) {
            return method;
        }
        Class findParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = findParcelClass.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public boolean readBoolean(boolean z, int i) {
        if (!readField(i)) {
            return z;
        }
        return ((VersionedParcelParcel) this).mParcel.readInt() != 0;
    }

    public CharSequence readCharSequence(CharSequence charSequence, int i) {
        if (!readField(i)) {
            return charSequence;
        }
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((VersionedParcelParcel) this).mParcel);
    }

    public abstract boolean readField(int i);

    public int readInt(int i, int i2) {
        if (!readField(i2)) {
            return i;
        }
        return ((VersionedParcelParcel) this).mParcel.readInt();
    }

    public <T extends Parcelable> T readParcelable(T t, int i) {
        if (!readField(i)) {
            return t;
        }
        return ((VersionedParcelParcel) this).mParcel.readParcelable(VersionedParcelParcel.class.getClassLoader());
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = ((VersionedParcelParcel) this).mParcel.readString();
        if (readString == null) {
            return null;
        }
        VersionedParcel createSubParcel = createSubParcel();
        try {
            return (VersionedParcelable) getReadMethod(readString).invoke(null, new Object[]{createSubParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    public abstract void setOutputField(int i);

    public void writeInt(int i, int i2) {
        setOutputField(i2);
        ((VersionedParcelParcel) this).mParcel.writeInt(i);
    }

    public void writeParcelable(Parcelable parcelable, int i) {
        setOutputField(i);
        ((VersionedParcelParcel) this).mParcel.writeParcelable(parcelable, 0);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            ((VersionedParcelParcel) this).mParcel.writeString(null);
            return;
        }
        try {
            ((VersionedParcelParcel) this).mParcel.writeString(findParcelClass(versionedParcelable.getClass()).getName());
            VersionedParcel createSubParcel = createSubParcel();
            try {
                getWriteMethod(versionedParcelable.getClass()).invoke(null, new Object[]{versionedParcelable, createSubParcel});
                createSubParcel.closeField();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (InvocationTargetException e3) {
                if (e3.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e3.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
            }
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e6);
        }
    }
}
