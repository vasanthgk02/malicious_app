package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.facebook.react.bridge.ColorPropConverter;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.cmap.CMapParser;

public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    public final Name name;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 2 || i == 3 || i == 5 || i == 6) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 5 || i == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (!(i == 2 || i == 3)) {
            if (i == 4) {
                objArr[2] = "toString";
            } else if (!(i == 5 || i == 6)) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 2 || i == 3 || i == 5 || i == 6) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeclarationDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2, kotlin.reflect.jvm.internal.impl.name.Name r3) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0010
            if (r3 == 0) goto L_0x000b
            r1.<init>(r2)
            r1.name = r3
            return
        L_0x000b:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0010:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name):void");
    }

    public Name getName() {
        Name name2 = this.name;
        if (name2 != null) {
            return name2;
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public String toString() {
        return toString(this);
    }

    public static String toString(DeclarationDescriptor declarationDescriptor) {
        try {
            String str = DescriptorRenderer.DEBUG_TEXT.render(declarationDescriptor) + "[" + declarationDescriptor.getClass().getSimpleName() + ColorPropConverter.PREFIX_RESOURCE + Integer.toHexString(System.identityHashCode(declarationDescriptor)) + CMapParser.MARK_END_OF_ARRAY;
            if (str != null) {
                return str;
            }
            $$$reportNull$$$0(5);
            throw null;
        } catch (Throwable unused) {
            String str2 = declarationDescriptor.getClass().getSimpleName() + CMap.SPACE + declarationDescriptor.getName();
            if (str2 != null) {
                return str2;
            }
            $$$reportNull$$$0(6);
            throw null;
        }
    }
}
