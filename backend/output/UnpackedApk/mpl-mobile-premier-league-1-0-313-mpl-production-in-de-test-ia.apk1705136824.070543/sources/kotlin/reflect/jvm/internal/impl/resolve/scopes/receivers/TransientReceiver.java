package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import com.android.tools.r8.GeneratedOutlineSupport;

public class TransientReceiver extends AbstractReceiverValue {
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransientReceiver(kotlin.reflect.jvm.internal.impl.types.KotlinType r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0009
            r1.<init>(r2, r0)
            return
        L_0x0009:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x000e:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.TransientReceiver.<init>(kotlin.reflect.jvm.internal.impl.types.KotlinType):void");
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{Transient} : ");
        outline73.append(getType());
        return outline73.toString();
    }
}
