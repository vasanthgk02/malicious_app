package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {
    public final NotNullLazyValue<SimpleType> defaultType;
    public final int index;
    public final boolean reified;
    public final StorageManager storageManager;
    public final NotNullLazyValue<TypeConstructor> typeConstructor;
    public final Variance variance;

    public class TypeParameterTypeConstructor extends AbstractTypeConstructor {
        public final SupertypeLoopChecker supertypeLoopChecker;
        public final /* synthetic */ AbstractTypeParameterDescriptor this$0;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TypeParameterTypeConstructor(kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor r1, kotlin.reflect.jvm.internal.impl.storage.StorageManager r2, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker r3) {
            /*
                r0 = this;
                if (r2 == 0) goto L_0x000a
                r0.this$0 = r1
                r0.<init>(r2)
                r0.supertypeLoopChecker = r3
                return
            L_0x000a:
                r1 = 0
                $$$reportNull$$$0(r1)
                r1 = 0
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor.TypeParameterTypeConstructor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker):void");
        }

        public Collection<KotlinType> computeSupertypes() {
            List<KotlinType> resolveUpperBounds = this.this$0.resolveUpperBounds();
            if (resolveUpperBounds != null) {
                return resolveUpperBounds;
            }
            $$$reportNull$$$0(1);
            throw null;
        }

        public KotlinType defaultSupertypeIfEmpty() {
            return ErrorUtils.createErrorType("Cyclic upper bounds");
        }

        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(this.this$0);
            if (builtIns != null) {
                return builtIns;
            }
            $$$reportNull$$$0(4);
            throw null;
        }

        public ClassifierDescriptor getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor abstractTypeParameterDescriptor = this.this$0;
            if (abstractTypeParameterDescriptor != null) {
                return abstractTypeParameterDescriptor;
            }
            $$$reportNull$$$0(3);
            throw null;
        }

        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> emptyList = Collections.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            $$$reportNull$$$0(2);
            throw null;
        }

        public SupertypeLoopChecker getSupertypeLoopChecker() {
            SupertypeLoopChecker supertypeLoopChecker2 = this.supertypeLoopChecker;
            if (supertypeLoopChecker2 != null) {
                return supertypeLoopChecker2;
            }
            $$$reportNull$$$0(5);
            throw null;
        }

        public boolean isDenotable() {
            return true;
        }

        public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> list) {
            if (list != null) {
                List<KotlinType> processBoundsWithoutCycles = this.this$0.processBoundsWithoutCycles(list);
                if (processBoundsWithoutCycles != null) {
                    return processBoundsWithoutCycles;
                }
                $$$reportNull$$$0(8);
                throw null;
            }
            $$$reportNull$$$0(7);
            throw null;
        }

        public void reportSupertypeLoopError(KotlinType kotlinType) {
            this.this$0.reportSupertypeLoopError(kotlinType);
        }

        public String toString() {
            return this.this$0.getName().name;
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbstractTypeParameterDescriptor(final kotlin.reflect.jvm.internal.impl.storage.StorageManager r2, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4, final kotlin.reflect.jvm.internal.impl.name.Name r5, kotlin.reflect.jvm.internal.impl.types.Variance r6, boolean r7, int r8, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9, final kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker r10) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x004f
            if (r3 == 0) goto L_0x004a
            if (r4 == 0) goto L_0x0045
            if (r5 == 0) goto L_0x0040
            if (r6 == 0) goto L_0x003b
            if (r9 == 0) goto L_0x0036
            if (r10 == 0) goto L_0x0031
            r1.<init>(r3, r4, r5, r9)
            r1.variance = r6
            r1.reified = r7
            r1.index = r8
            kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor$1 r3 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor$1
            r3.<init>(r2, r10)
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r3 = r2.createLazyValue(r3)
            r1.typeConstructor = r3
            kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor$2 r3 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor$2
            r3.<init>(r5)
            kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r3 = r2.createLazyValue(r3)
            r1.defaultType = r3
            r1.storageManager = r2
            return
        L_0x0031:
            r2 = 6
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0036:
            r2 = 5
            $$$reportNull$$$0(r2)
            throw r0
        L_0x003b:
            r2 = 4
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0040:
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0045:
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x004a:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x004f:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.types.Variance, boolean, int, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker):void");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitTypeParameterDescriptor(this, d2);
    }

    public SimpleType getDefaultType() {
        SimpleType simpleType = (SimpleType) this.defaultType.invoke();
        if (simpleType != null) {
            return simpleType;
        }
        $$$reportNull$$$0(10);
        throw null;
    }

    public int getIndex() {
        return this.index;
    }

    public ClassifierDescriptor getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public DeclarationDescriptor m900getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public DeclarationDescriptorWithSource m901getOriginal() {
        return this;
    }

    /* renamed from: getOriginal  reason: collision with other method in class */
    public TypeParameterDescriptor m902getOriginal() {
        return this;
    }

    public StorageManager getStorageManager() {
        StorageManager storageManager2 = this.storageManager;
        if (storageManager2 != null) {
            return storageManager2;
        }
        $$$reportNull$$$0(14);
        throw null;
    }

    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = (TypeConstructor) this.typeConstructor.invoke();
        if (typeConstructor2 != null) {
            return typeConstructor2;
        }
        $$$reportNull$$$0(9);
        throw null;
    }

    public List<KotlinType> getUpperBounds() {
        List<KotlinType> supertypes = ((TypeParameterTypeConstructor) getTypeConstructor()).getSupertypes();
        if (supertypes != null) {
            return supertypes;
        }
        $$$reportNull$$$0(8);
        throw null;
    }

    public Variance getVariance() {
        Variance variance2 = this.variance;
        if (variance2 != null) {
            return variance2;
        }
        $$$reportNull$$$0(7);
        throw null;
    }

    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    public boolean isReified() {
        return this.reified;
    }

    public List<KotlinType> processBoundsWithoutCycles(List<KotlinType> list) {
        if (list == null) {
            $$$reportNull$$$0(12);
            throw null;
        } else if (list != null) {
            return list;
        } else {
            $$$reportNull$$$0(13);
            throw null;
        }
    }

    public abstract void reportSupertypeLoopError(KotlinType kotlinType);

    public abstract List<KotlinType> resolveUpperBounds();
}
