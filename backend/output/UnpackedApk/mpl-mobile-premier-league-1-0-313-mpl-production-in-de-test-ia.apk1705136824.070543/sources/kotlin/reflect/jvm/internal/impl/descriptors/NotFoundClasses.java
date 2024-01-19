package kotlin.reflect.jvm.internal.impl.descriptors;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: NotFoundClasses.kt */
public final class NotFoundClasses {
    public final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes = this.storageManager.createMemoizedFunction(new NotFoundClasses$classes$1(this));
    public final ModuleDescriptor module;
    public final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    public final StorageManager storageManager;

    /* compiled from: NotFoundClasses.kt */
    public static final class ClassRequest {
        public final ClassId classId;
        public final List<Integer> typeParametersCount;

        public ClassRequest(ClassId classId2, List<Integer> list) {
            Intrinsics.checkNotNullParameter(classId2, "classId");
            Intrinsics.checkNotNullParameter(list, "typeParametersCount");
            this.classId = classId2;
            this.typeParametersCount = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClassRequest)) {
                return false;
            }
            ClassRequest classRequest = (ClassRequest) obj;
            return Intrinsics.areEqual(this.classId, classRequest.classId) && Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount);
        }

        public int hashCode() {
            return this.typeParametersCount.hashCode() + (this.classId.hashCode() * 31);
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ClassRequest(classId=");
            outline73.append(this.classId);
            outline73.append(", typeParametersCount=");
            outline73.append(this.typeParametersCount);
            outline73.append(')');
            return outline73.toString();
        }
    }

    /* compiled from: NotFoundClasses.kt */
    public static final class MockClassDescriptor extends ClassDescriptorBase {
        public final List<TypeParameterDescriptor> declaredTypeParameters;
        public final boolean isInner;
        public final ClassTypeConstructorImpl typeConstructor;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public MockClassDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z, int i) {
            // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            // Intrinsics.checkNotNullParameter(declarationDescriptor, "container");
            // Intrinsics.checkNotNullParameter(name, "name");
            super(storageManager, declarationDescriptor, name, SourceElement.NO_SOURCE, false);
            this.isInner = z;
            IntRange until = RangesKt___RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(until, 10));
            IntIterator it = until.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int nextInt = it.nextInt();
                if (Annotations.Companion != null) {
                    arrayList.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Companion.EMPTY, false, Variance.INVARIANT, Name.identifier(Intrinsics.stringPlus("T", Integer.valueOf(nextInt))), nextInt, storageManager));
                } else {
                    throw null;
                }
            }
            this.declaredTypeParameters = arrayList;
            this.typeConstructor = new ClassTypeConstructorImpl(this, TweetUtils.computeConstructorTypeParameters(this), TweetUtils.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), storageManager);
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

        public Collection<ClassConstructorDescriptor> getConstructors() {
            return EmptySet.INSTANCE;
        }

        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.declaredTypeParameters;
        }

        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        public Modality getModality() {
            return Modality.FINAL;
        }

        public Collection<ClassDescriptor> getSealedSubclasses() {
            return EmptyList.INSTANCE;
        }

        public MemberScope getStaticScope() {
            return Empty.INSTANCE;
        }

        public TypeConstructor getTypeConstructor() {
            return this.typeConstructor;
        }

        public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return Empty.INSTANCE;
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
            return this.isInner;
        }

        public boolean isValue() {
            return false;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("class ");
            outline73.append(getName());
            outline73.append(" (not found)");
            return outline73.toString();
        }
    }

    public NotFoundClasses(StorageManager storageManager2, ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        this.storageManager = storageManager2;
        this.module = moduleDescriptor;
        this.packageFragments = storageManager2.createMemoizedFunction(new NotFoundClasses$packageFragments$1(this));
    }

    public final ClassDescriptor getClass(ClassId classId, List<Integer> list) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(list, "typeParametersCount");
        return (ClassDescriptor) this.classes.invoke(new ClassRequest(classId, list));
    }
}
