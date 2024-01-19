package kotlin.reflect.jvm.internal.impl.types;

import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {
    public final ClassDescriptor classDescriptor;
    public final List<TypeParameterDescriptor> parameters;
    public final Collection<KotlinType> supertypes;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY;
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (!(i == 4 || i == 5 || i == 6 || i == 7)) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 5 || i == 6 || i == 7) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ClassTypeConstructorImpl(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r3, java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r4, kotlin.reflect.jvm.internal.impl.storage.StorageManager r5) {
        /*
            r1 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0028
            if (r4 == 0) goto L_0x0023
            if (r5 == 0) goto L_0x001e
            r1.<init>(r5)
            r1.classDescriptor = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r3)
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)
            r1.parameters = r2
            java.util.Collection r2 = java.util.Collections.unmodifiableCollection(r4)
            r1.supertypes = r2
            return
        L_0x001e:
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0023:
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0028:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, java.util.List, java.util.Collection, kotlin.reflect.jvm.internal.impl.storage.StorageManager):void");
    }

    public Collection<KotlinType> computeSupertypes() {
        Collection<KotlinType> collection = this.supertypes;
        if (collection != null) {
            return collection;
        }
        $$$reportNull$$$0(6);
        throw null;
    }

    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.parameters;
        if (list != null) {
            return list;
        }
        $$$reportNull$$$0(4);
        throw null;
    }

    public SupertypeLoopChecker getSupertypeLoopChecker() {
        return EMPTY.INSTANCE;
    }

    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.classDescriptor).asString();
    }

    public ClassDescriptor getDeclarationDescriptor() {
        ClassDescriptor classDescriptor2 = this.classDescriptor;
        if (classDescriptor2 != null) {
            return classDescriptor2;
        }
        $$$reportNull$$$0(5);
        throw null;
    }
}
