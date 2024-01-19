package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty0.Getter;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public KCallable computeReflected() {
        return Reflection.factory.property0(this);
    }

    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    public Object invoke() {
        return get();
    }

    public Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }
}
