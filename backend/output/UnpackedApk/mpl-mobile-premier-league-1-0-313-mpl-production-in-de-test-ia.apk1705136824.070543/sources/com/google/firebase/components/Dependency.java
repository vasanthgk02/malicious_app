package com.google.firebase.components;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.paynimo.android.payment.util.Validation;

public final class Dependency {
    public final Class<?> anInterface;
    public final int injection;
    public final int type;

    public Dependency(Class<?> cls, int i, int i2) {
        TextAppearanceConfig.checkNotNull(cls, "Null dependency anInterface.");
        this.anInterface = cls;
        this.type = i;
        this.injection = i2;
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (this.anInterface == dependency.anInterface && this.type == dependency.type && this.injection == dependency.injection) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public boolean isSet() {
        return this.type == 2;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.anInterface);
        sb.append(", type=");
        int i = this.type;
        sb.append(i == 1 ? Validation.REQUIRED_MSG : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i2 = this.injection;
        if (i2 == 0) {
            str = "direct";
        } else if (i2 == 1) {
            str = "provider";
        } else if (i2 == 2) {
            str = "deferred";
        } else {
            throw new AssertionError(GeneratedOutlineSupport.outline41("Unsupported injection: ", i2));
        }
        return GeneratedOutlineSupport.outline62(sb, str, "}");
    }
}
