package androidx.dynamicanimation.animation;

public abstract class FloatPropertyCompat<T> {
    public FloatPropertyCompat(String str) {
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f2);
}
