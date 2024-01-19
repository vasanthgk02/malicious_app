package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    public boolean initialized;
    public final Function1<KotlinType, Void> reportCycleError;
    public final List<KotlinType> upperBounds;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 28) ? 2 : 3)];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 5 || i == 28) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TypeParameterDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r12, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r13, boolean r14, kotlin.reflect.jvm.internal.impl.types.Variance r15, kotlin.reflect.jvm.internal.impl.name.Name r16, int r17, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r18, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.Void> r19, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker r20, kotlin.reflect.jvm.internal.impl.storage.StorageManager r21) {
        /*
            r11 = this;
            r10 = r11
            r0 = 0
            if (r12 == 0) goto L_0x0056
            if (r13 == 0) goto L_0x0050
            if (r15 == 0) goto L_0x004a
            if (r16 == 0) goto L_0x0044
            if (r18 == 0) goto L_0x003e
            if (r20 == 0) goto L_0x0038
            if (r21 == 0) goto L_0x0032
            r0 = r11
            r1 = r21
            r2 = r12
            r3 = r13
            r4 = r16
            r5 = r15
            r6 = r14
            r7 = r17
            r8 = r18
            r9 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 1
            r0.<init>(r1)
            r10.upperBounds = r0
            r0 = 0
            r10.initialized = r0
            r0 = r19
            r10.reportCycleError = r0
            return
        L_0x0032:
            r1 = 25
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0038:
            r1 = 24
            $$$reportNull$$$0(r1)
            throw r0
        L_0x003e:
            r1 = 23
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0044:
            r1 = 22
            $$$reportNull$$$0(r1)
            throw r0
        L_0x004a:
            r1 = 21
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0050:
            r1 = 20
            $$$reportNull$$$0(r1)
            throw r0
        L_0x0056:
            r1 = 19
            $$$reportNull$$$0(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, boolean, kotlin.reflect.jvm.internal.impl.types.Variance, kotlin.reflect.jvm.internal.impl.name.Name, int, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, kotlin.jvm.functions.Function1, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker, kotlin.reflect.jvm.internal.impl.storage.StorageManager):void");
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, SourceElement sourceElement, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(6);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(7);
            throw null;
        } else if (variance == null) {
            $$$reportNull$$$0(8);
            throw null;
        } else if (name == null) {
            $$$reportNull$$$0(9);
            throw null;
        } else if (storageManager != null) {
            TypeParameterDescriptorImpl typeParameterDescriptorImpl = new TypeParameterDescriptorImpl(declarationDescriptor, annotations, z, variance, name, i, sourceElement, null, EMPTY.INSTANCE, storageManager);
            return typeParameterDescriptorImpl;
        } else {
            $$$reportNull$$$0(11);
            throw null;
        }
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor declarationDescriptor, Annotations annotations, boolean z, Variance variance, Name name, int i, StorageManager storageManager) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(0);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(1);
            throw null;
        } else if (variance == null) {
            $$$reportNull$$$0(2);
            throw null;
        } else if (storageManager != null) {
            TypeParameterDescriptorImpl createForFurtherModification = createForFurtherModification(declarationDescriptor, annotations, z, variance, name, i, SourceElement.NO_SOURCE, storageManager);
            createForFurtherModification.addUpperBound(DescriptorUtilsKt.getBuiltIns(declarationDescriptor).getDefaultBound());
            createForFurtherModification.checkUninitialized();
            createForFurtherModification.initialized = true;
            return createForFurtherModification;
        } else {
            $$$reportNull$$$0(4);
            throw null;
        }
    }

    public void addUpperBound(KotlinType kotlinType) {
        if (kotlinType != null) {
            checkUninitialized();
            if (!TweetUtils.isError(kotlinType)) {
                this.upperBounds.add(kotlinType);
                return;
            }
            return;
        }
        $$$reportNull$$$0(26);
        throw null;
    }

    public final void checkUninitialized() {
        if (this.initialized) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Type parameter descriptor is already initialized: ");
            outline73.append(nameForAssertions());
            throw new IllegalStateException(outline73.toString());
        }
    }

    public final String nameForAssertions() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void reportSupertypeLoopError(KotlinType kotlinType) {
        if (kotlinType != null) {
            Function1<KotlinType, Void> function1 = this.reportCycleError;
            if (function1 != null) {
                function1.invoke(kotlinType);
                return;
            }
            return;
        }
        $$$reportNull$$$0(27);
        throw null;
    }

    public List<KotlinType> resolveUpperBounds() {
        if (this.initialized) {
            List<KotlinType> list = this.upperBounds;
            if (list != null) {
                return list;
            }
            $$$reportNull$$$0(28);
            throw null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Type parameter descriptor is not initialized: ");
        outline73.append(nameForAssertions());
        throw new IllegalStateException(outline73.toString());
    }
}
