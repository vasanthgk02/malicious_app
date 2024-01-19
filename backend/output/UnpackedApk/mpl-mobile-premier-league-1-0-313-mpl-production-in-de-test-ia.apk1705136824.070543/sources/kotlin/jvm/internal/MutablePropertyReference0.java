package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty0.Setter;
import kotlin.reflect.KProperty0.Getter;

public abstract class MutablePropertyReference0 extends MutablePropertyReference implements KMutableProperty0 {
    public MutablePropertyReference0() {
    }

    public KCallable computeReflected() {
        return Reflection.factory.mutableProperty0(this);
    }

    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    public Object invoke() {
        return get();
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    public Getter getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    public Setter getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}