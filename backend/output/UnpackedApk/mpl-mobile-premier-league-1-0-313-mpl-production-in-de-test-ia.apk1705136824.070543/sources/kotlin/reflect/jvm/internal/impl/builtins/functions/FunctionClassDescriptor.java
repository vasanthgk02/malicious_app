package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: FunctionClassDescriptor.kt */
public final class FunctionClassDescriptor extends AbstractClassDescriptor {
    public static final ClassId functionClassId = new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, Name.identifier("Function"));
    public static final ClassId kFunctionClassId = new ClassId(StandardNames.KOTLIN_REFLECT_FQ_NAME, Name.identifier("KFunction"));
    public final int arity;
    public final PackageFragmentDescriptor containingDeclaration;
    public final FunctionClassKind functionKind;
    public final FunctionClassScope memberScope = new FunctionClassScope(this.storageManager, this);
    public final List<TypeParameterDescriptor> parameters;
    public final StorageManager storageManager;
    public final FunctionTypeConstructor typeConstructor = new FunctionTypeConstructor(this);

    /* compiled from: FunctionClassDescriptor.kt */
    public final class FunctionTypeConstructor extends AbstractClassTypeConstructor {
        public final /* synthetic */ FunctionClassDescriptor this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public FunctionTypeConstructor(FunctionClassDescriptor functionClassDescriptor) {
            // Intrinsics.checkNotNullParameter(functionClassDescriptor, "this$0");
            // this.this$0 = functionClassDescriptor;
            super(functionClassDescriptor.storageManager);
        }

        public Collection<KotlinType> computeSupertypes() {
            List<ClassId> list;
            Iterable<TypeParameterDescriptor> iterable;
            int ordinal = this.this$0.functionKind.ordinal();
            if (ordinal == 0) {
                list = TweetUtils.listOf(FunctionClassDescriptor.functionClassId);
            } else if (ordinal == 1) {
                list = TweetUtils.listOf(FunctionClassDescriptor.functionClassId);
            } else if (ordinal == 2) {
                list = TweetUtils.listOf((T[]) new ClassId[]{FunctionClassDescriptor.kFunctionClassId, new ClassId(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, FunctionClassKind.Function.numberedClassName(this.this$0.arity))});
            } else if (ordinal == 3) {
                list = TweetUtils.listOf((T[]) new ClassId[]{FunctionClassDescriptor.kFunctionClassId, new ClassId(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE, FunctionClassKind.SuspendFunction.numberedClassName(this.this$0.arity))});
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ModuleDescriptor containingDeclaration = this.this$0.containingDeclaration.getContainingDeclaration();
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (ClassId classId : list) {
                ClassDescriptor findClassAcrossModuleDependencies = TweetUtils.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (findClassAcrossModuleDependencies != null) {
                    List list2 = this.this$0.parameters;
                    int size = findClassAcrossModuleDependencies.getTypeConstructor().getParameters().size();
                    Intrinsics.checkNotNullParameter(list2, "<this>");
                    if (size >= 0) {
                        if (size == 0) {
                            iterable = EmptyList.INSTANCE;
                        } else {
                            int size2 = list2.size();
                            if (size >= size2) {
                                iterable = ArraysKt___ArraysJvmKt.toList(list2);
                            } else if (size == 1) {
                                iterable = TweetUtils.listOf(ArraysKt___ArraysJvmKt.last(list2));
                            } else {
                                ArrayList arrayList2 = new ArrayList(size);
                                if (list2 instanceof RandomAccess) {
                                    for (int i = size2 - size; i < size2; i++) {
                                        arrayList2.add(list2.get(i));
                                    }
                                } else {
                                    ListIterator listIterator = list2.listIterator(size2 - size);
                                    while (listIterator.hasNext()) {
                                        arrayList2.add(listIterator.next());
                                    }
                                }
                                iterable = arrayList2;
                            }
                        }
                        ArrayList arrayList3 = new ArrayList(TweetUtils.collectionSizeOrDefault(iterable, 10));
                        for (TypeParameterDescriptor defaultType : iterable) {
                            arrayList3.add(new TypeProjectionImpl(defaultType.getDefaultType()));
                        }
                        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
                        if (Annotations.Companion != null) {
                            arrayList.add(KotlinTypeFactory.simpleNotNullType(Companion.EMPTY, findClassAcrossModuleDependencies, arrayList3));
                        } else {
                            throw null;
                        }
                    } else {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Requested element count ", size, " is less than zero.").toString());
                    }
                } else {
                    throw new IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
            }
            return ArraysKt___ArraysJvmKt.toList(arrayList);
        }

        public ClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public List<TypeParameterDescriptor> getParameters() {
            return this.this$0.parameters;
        }

        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return EMPTY.INSTANCE;
        }

        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            return this.this$0.toString();
        }

        /* renamed from: getDeclarationDescriptor  reason: collision with other method in class */
        public ClassifierDescriptor m894getDeclarationDescriptor() {
            return this.this$0;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FunctionClassDescriptor(StorageManager storageManager2, PackageFragmentDescriptor packageFragmentDescriptor, FunctionClassKind functionClassKind, int i) {
        // Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        // Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "containingDeclaration");
        // Intrinsics.checkNotNullParameter(functionClassKind, "functionKind");
        super(storageManager2, functionClassKind.numberedClassName(i));
        this.storageManager = storageManager2;
        this.containingDeclaration = packageFragmentDescriptor;
        this.functionKind = functionClassKind;
        this.arity = i;
        ArrayList arrayList = new ArrayList();
        IntRange intRange = new IntRange(1, this.arity);
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(intRange, 10));
        IntIterator it = intRange.iterator();
        while (((IntProgressionIterator) it).hasNext) {
            _init_$typeParameter(arrayList, this, Variance.IN_VARIANCE, Intrinsics.stringPlus("P", Integer.valueOf(it.nextInt())));
            arrayList2.add(Unit.INSTANCE);
        }
        _init_$typeParameter(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.parameters = ArraysKt___ArraysJvmKt.toList(arrayList);
    }

    public static final void _init_$typeParameter(ArrayList<TypeParameterDescriptor> arrayList, FunctionClassDescriptor functionClassDescriptor, Variance variance, String str) {
        if (Annotations.Companion != null) {
            arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, Companion.EMPTY, false, variance, Name.identifier(str), arrayList.size(), functionClassDescriptor.storageManager));
            return;
        }
        throw null;
    }

    public Annotations getAnnotations() {
        if (Annotations.Companion != null) {
            return Companion.EMPTY;
        }
        throw null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public Collection getConstructors() {
        return EmptyList.INSTANCE;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    public Collection getSealedSubclasses() {
        return EmptyList.INSTANCE;
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    public MemberScope getStaticScope() {
        return Empty.INSTANCE;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScope;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "PUBLIC");
        return descriptorVisibility;
    }

    public boolean isActual() {
        return false;
    }

    public boolean isCompanionObject() {
        return false;
    }

    public boolean isData() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isFun() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isInner() {
        return false;
    }

    public boolean isValue() {
        return false;
    }

    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return asString;
    }
}
