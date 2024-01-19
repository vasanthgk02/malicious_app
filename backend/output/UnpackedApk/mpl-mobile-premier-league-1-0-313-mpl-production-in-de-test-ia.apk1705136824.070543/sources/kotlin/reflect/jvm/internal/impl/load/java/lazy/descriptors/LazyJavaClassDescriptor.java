package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache.AnonymousClass1;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    public final ClassDescriptor additionalSupertypeClassDescriptor;
    public final Annotations annotations;

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5941c;
    public final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    public final InnerClassesScopeWrapper innerClassesScope;
    public final boolean isInner;
    public final JavaClass jClass;
    public final ClassKind kind;
    public final Modality modality;
    public final LazyJavaResolverContext outerContext;
    public final ScopesHolderForClass<LazyJavaClassMemberScope> scopeHolder;
    public final LazyJavaStaticClassScope staticScope;
    public final LazyJavaClassTypeConstructor typeConstructor;
    public final LazyJavaClassMemberScope unsubstitutedMemberScope;
    public final Visibility visibility;

    /* compiled from: LazyJavaClassDescriptor.kt */
    public final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        public final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;
        public final /* synthetic */ LazyJavaClassDescriptor this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public LazyJavaClassTypeConstructor(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            // Intrinsics.checkNotNullParameter(lazyJavaClassDescriptor, "this$0");
            // this.this$0 = lazyJavaClassDescriptor;
            super(lazyJavaClassDescriptor.f5941c.components.storageManager);
            LazyJavaClassDescriptor lazyJavaClassDescriptor2 = this.this$0;
            this.parameters = lazyJavaClassDescriptor2.f5941c.components.storageManager.createLazyValue(new LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(lazyJavaClassDescriptor2));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a4, code lost:
            if ((!r8.isRoot() && r8.startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME)) != false) goto L_0x00a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c1, code lost:
            if (r9 == null) goto L_0x0165;
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x024d  */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0252  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0170  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01f9  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0218  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            /*
                r22 = this;
                r0 = r22
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r1 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass r1 = r1.jClass
                java.util.Collection r1 = r1.getSupertypes()
                java.util.ArrayList r2 = new java.util.ArrayList
                int r3 = r1.size()
                r2.<init>(r3)
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 0
                r3.<init>(r4)
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r5 = r0.this$0
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = r5.annotations
                kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION
                java.lang.String r7 = "PURELY_IMPLEMENTS_ANNOTATION"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r5 = r5.findAnnotation(r6)
                r6 = 1
                r7 = 0
                if (r5 != 0) goto L_0x002e
                goto L_0x0089
            L_0x002e:
                java.util.Map r5 = r5.getAllValueArguments()
                java.util.Collection r5 = r5.values()
                java.lang.Object r5 = kotlin.collections.ArraysKt___ArraysJvmKt.singleOrNull(r5)
                boolean r8 = r5 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue
                if (r8 == 0) goto L_0x0041
                kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue r5 = (kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue) r5
                goto L_0x0042
            L_0x0041:
                r5 = r7
            L_0x0042:
                if (r5 != 0) goto L_0x0046
                r5 = r7
                goto L_0x004a
            L_0x0046:
                T r5 = r5.value
                java.lang.String r5 = (java.lang.String) r5
            L_0x004a:
                if (r5 != 0) goto L_0x004d
                goto L_0x0089
            L_0x004d:
                kotlin.reflect.jvm.internal.impl.name.State r8 = kotlin.reflect.jvm.internal.impl.name.State.BEGINNING
                r9 = 0
            L_0x0050:
                int r10 = r5.length()
                if (r9 >= r10) goto L_0x0080
                char r10 = r5.charAt(r9)
                int r9 = r9 + 1
                int r11 = r8.ordinal()
                if (r11 == 0) goto L_0x0076
                if (r11 == r6) goto L_0x0068
                r12 = 2
                if (r11 == r12) goto L_0x0076
                goto L_0x0050
            L_0x0068:
                r11 = 46
                if (r10 != r11) goto L_0x006f
                kotlin.reflect.jvm.internal.impl.name.State r8 = kotlin.reflect.jvm.internal.impl.name.State.AFTER_DOT
                goto L_0x0050
            L_0x006f:
                boolean r10 = java.lang.Character.isJavaIdentifierPart(r10)
                if (r10 != 0) goto L_0x0050
                goto L_0x0086
            L_0x0076:
                boolean r8 = java.lang.Character.isJavaIdentifierPart(r10)
                if (r8 != 0) goto L_0x007d
                goto L_0x0086
            L_0x007d:
                kotlin.reflect.jvm.internal.impl.name.State r8 = kotlin.reflect.jvm.internal.impl.name.State.MIDDLE
                goto L_0x0050
            L_0x0080:
                kotlin.reflect.jvm.internal.impl.name.State r9 = kotlin.reflect.jvm.internal.impl.name.State.AFTER_DOT
                if (r8 == r9) goto L_0x0086
                r8 = 1
                goto L_0x0087
            L_0x0086:
                r8 = 0
            L_0x0087:
                if (r8 != 0) goto L_0x008b
            L_0x0089:
                r8 = r7
                goto L_0x0090
            L_0x008b:
                kotlin.reflect.jvm.internal.impl.name.FqName r8 = new kotlin.reflect.jvm.internal.impl.name.FqName
                r8.<init>(r5)
            L_0x0090:
                if (r8 != 0) goto L_0x0093
                goto L_0x00a7
            L_0x0093:
                boolean r5 = r8.isRoot()
                if (r5 != 0) goto L_0x00a3
                kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME
                boolean r5 = r8.startsWith(r5)
                if (r5 == 0) goto L_0x00a3
                r5 = 1
                goto L_0x00a4
            L_0x00a3:
                r5 = 0
            L_0x00a4:
                if (r5 == 0) goto L_0x00a7
                goto L_0x00a8
            L_0x00a7:
                r8 = r7
            L_0x00a8:
                r5 = 10
                if (r8 != 0) goto L_0x00c5
                kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider r9 = kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider.INSTANCE
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r9 = r0.this$0
                kotlin.reflect.jvm.internal.impl.name.FqName r9 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r9)
                java.lang.String r10 = "classFqName"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r10)
                java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.name.FqName> r10 = kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider.pureImplementations
                java.lang.Object r9 = r10.get(r9)
                kotlin.reflect.jvm.internal.impl.name.FqName r9 = (kotlin.reflect.jvm.internal.impl.name.FqName) r9
                if (r9 != 0) goto L_0x00c6
                goto L_0x0165
            L_0x00c5:
                r9 = r8
            L_0x00c6:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r10 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r10 = r10.f5941c
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r10 = r10.components
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10 = r10.module
                kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r11 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_JAVA_LOADER
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.resolveTopLevelClass(r10, r9, r11)
                if (r9 != 0) goto L_0x00d8
                goto L_0x0165
            L_0x00d8:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r9.getTypeConstructor()
                java.util.List r10 = r10.getParameters()
                int r10 = r10.size()
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r11 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor$LazyJavaClassTypeConstructor r11 = r11.typeConstructor
                java.util.List r11 = r11.getParameters()
                java.lang.String r12 = "getTypeConstructor().parameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
                int r12 = r11.size()
                if (r12 != r10) goto L_0x011f
                java.util.ArrayList r8 = new java.util.ArrayList
                int r10 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r11, r5)
                r8.<init>(r10)
                java.util.Iterator r10 = r11.iterator()
            L_0x0104:
                boolean r11 = r10.hasNext()
                if (r11 == 0) goto L_0x0157
                java.lang.Object r11 = r10.next()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r11 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r11
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r12 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
                kotlin.reflect.jvm.internal.impl.types.Variance r13 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r11.getDefaultType()
                r12.<init>(r13, r11)
                r8.add(r12)
                goto L_0x0104
            L_0x011f:
                if (r12 != r6) goto L_0x0165
                if (r10 <= r6) goto L_0x0165
                if (r8 != 0) goto L_0x0165
                kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r8 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
                kotlin.reflect.jvm.internal.impl.types.Variance r12 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                java.lang.Object r11 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r11)
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r11 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r11
                kotlin.reflect.jvm.internal.impl.types.SimpleType r11 = r11.getDefaultType()
                r8.<init>(r12, r11)
                kotlin.ranges.IntRange r11 = new kotlin.ranges.IntRange
                r11.<init>(r6, r10)
                java.util.ArrayList r10 = new java.util.ArrayList
                int r12 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r11, r5)
                r10.<init>(r12)
                kotlin.collections.IntIterator r11 = r11.iterator()
            L_0x0148:
                r12 = r11
                kotlin.ranges.IntProgressionIterator r12 = (kotlin.ranges.IntProgressionIterator) r12
                boolean r12 = r12.hasNext
                if (r12 == 0) goto L_0x0156
                r11.nextInt()
                r10.add(r8)
                goto L_0x0148
            L_0x0156:
                r8 = r10
            L_0x0157:
                kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory r10 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.INSTANCE
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                if (r10 == 0) goto L_0x0164
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
                kotlin.reflect.jvm.internal.impl.types.SimpleType r8 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(r10, r9, r8)
                goto L_0x0166
            L_0x0164:
                throw r7
            L_0x0165:
                r8 = r7
            L_0x0166:
                java.util.Iterator r1 = r1.iterator()
            L_0x016a:
                boolean r9 = r1.hasNext()
                if (r9 == 0) goto L_0x01f2
                java.lang.Object r9 = r1.next()
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) r9
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r10 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r10 = r10.f5941c
                kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver r10 = r10.typeResolver
                kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r11 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.SUPERTYPE
                r12 = 3
                kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r11 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r11, r4, r7, r12)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r10.transformJavaType(r9, r11)
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r10 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r10 = r10.f5941c
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r10 = r10.components
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r10 = r10.settings
                boolean r10 = r10.getTypeEnhancementImprovements()
                if (r10 == 0) goto L_0x01c5
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r10 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r10 = r10.f5941c
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r11 = r10.components
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r13 = r11.signatureEnhancement
                if (r13 == 0) goto L_0x01c4
                java.lang.String r11 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r11)
                java.lang.String r11 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts
                kotlin.collections.EmptyList r16 = kotlin.collections.EmptyList.INSTANCE
                r17 = 0
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r19 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE
                r20 = 0
                r21 = 64
                r14 = 0
                r12 = r11
                r18 = r10
                r12.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r10 = r11.enhance(r7)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r10.type
                goto L_0x01c5
            L_0x01c4:
                throw r7
            L_0x01c5:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r15.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getDeclarationDescriptor()
                boolean r10 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor
                if (r10 == 0) goto L_0x01d4
                r3.add(r9)
            L_0x01d4:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9 = r15.getConstructor()
                if (r8 != 0) goto L_0x01dc
                r10 = r7
                goto L_0x01e0
            L_0x01dc:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r10 = r8.getConstructor()
            L_0x01e0:
                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)
                if (r9 == 0) goto L_0x01e7
                goto L_0x016a
            L_0x01e7:
                boolean r9 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAnyOrNullableAny(r15)
                if (r9 != 0) goto L_0x016a
                r2.add(r15)
                goto L_0x016a
            L_0x01f2:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r1 = r0.this$0
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = r1.additionalSupertypeClassDescriptor
                if (r4 != 0) goto L_0x01f9
                goto L_0x020b
            L_0x01f9:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution r1 = com.twitter.sdk.android.tweetui.TweetUtils.createMappedTypeParametersSubstitution(r4, r1)
                kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r1 = r1.buildSubstitutor()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getDefaultType()
                kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
                kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r1.substitute(r4, r7)
            L_0x020b:
                kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.addIfNotNull(r2, r7)
                kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.addIfNotNull(r2, r8)
                boolean r1 = r3.isEmpty()
                r1 = r1 ^ r6
                if (r1 == 0) goto L_0x0246
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r1 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r1.f5941c
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r4 = r4.components
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r4 = r4.errorReporter
                java.util.ArrayList r7 = new java.util.ArrayList
                int r5 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r3, r5)
                r7.<init>(r5)
                java.util.Iterator r3 = r3.iterator()
            L_0x022d:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L_0x0243
                java.lang.Object r5 = r3.next()
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r5
                kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) r5
                java.lang.String r5 = r5.getPresentableText()
                r7.add(r5)
                goto L_0x022d
            L_0x0243:
                r4.reportIncompleteHierarchy(r1, r7)
            L_0x0246:
                boolean r1 = r2.isEmpty()
                r1 = r1 ^ r6
                if (r1 == 0) goto L_0x0252
                java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r2)
                goto L_0x0266
            L_0x0252:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r1 = r0.this$0
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r1 = r1.f5941c
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r1 = r1.components
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r1 = r1.module
                kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r1 = r1.getBuiltIns()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getAnyType()
                java.util.List r1 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r1)
            L_0x0266:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.computeSupertypes():java.util.Collection");
        }

        public ClassDescriptor getDeclarationDescriptor() {
            return this.this$0;
        }

        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return this.this$0.f5941c.components.supertypeLoopChecker;
        }

        public boolean isDenotable() {
            return true;
        }

        public String toString() {
            String asString = this.this$0.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
            return asString;
        }

        /* renamed from: getDeclarationDescriptor  reason: collision with other method in class */
        public ClassifierDescriptor m905getDeclarationDescriptor() {
            return this.this$0;
        }
    }

    static {
        TweetUtils.setOf((T[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor) {
        ClassKind classKind;
        Modality modality2;
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "outerContext");
        // Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        // Intrinsics.checkNotNullParameter(javaClass, "jClass");
        super(lazyJavaResolverContext.components.storageManager, declarationDescriptor, javaClass.getName(), lazyJavaResolverContext.components.sourceElementFactory.source(javaClass), false);
        this.outerContext = lazyJavaResolverContext;
        this.jClass = javaClass;
        this.additionalSupertypeClassDescriptor = classDescriptor;
        LazyJavaResolverContext childForClassOrPackage$default = TweetUtils.childForClassOrPackage$default(lazyJavaResolverContext, this, javaClass, 0, 4);
        this.f5941c = childForClassOrPackage$default;
        JavaResolverCache javaResolverCache = childForClassOrPackage$default.components.javaResolverCache;
        JavaClass javaClass2 = this.jClass;
        if (((AnonymousClass1) javaResolverCache) == null) {
            throw null;
        } else if (javaClass2 != null) {
            boolean z = javaClass2.getLightClassOriginKind() == null;
            if (!_Assertions.ENABLED || z) {
                if (this.jClass.isAnnotationType()) {
                    classKind = ClassKind.ANNOTATION_CLASS;
                } else if (this.jClass.isInterface()) {
                    classKind = ClassKind.INTERFACE;
                } else if (this.jClass.isEnum()) {
                    classKind = ClassKind.ENUM_CLASS;
                } else {
                    classKind = ClassKind.CLASS;
                }
                this.kind = classKind;
                if (this.jClass.isAnnotationType() || this.jClass.isEnum()) {
                    modality2 = Modality.FINAL;
                } else {
                    modality2 = Modality.Companion.convertFromFlags(false, this.jClass.isSealed() || this.jClass.isAbstract() || this.jClass.isInterface(), !this.jClass.isFinal());
                }
                this.modality = modality2;
                this.visibility = this.jClass.getVisibility();
                this.isInner = this.jClass.getOuterClass() != null && !this.jClass.isStatic();
                this.typeConstructor = new LazyJavaClassTypeConstructor(this);
                LazyJavaClassMemberScope lazyJavaClassMemberScope = new LazyJavaClassMemberScope(this.f5941c, this, this.jClass, this.additionalSupertypeClassDescriptor != null, null);
                this.unsubstitutedMemberScope = lazyJavaClassMemberScope;
                ScopesHolderForClass scopesHolderForClass = ScopesHolderForClass.Companion;
                JavaResolverComponents javaResolverComponents = this.f5941c.components;
                this.scopeHolder = ScopesHolderForClass.create(this, javaResolverComponents.storageManager, javaResolverComponents.kotlinTypeChecker.getKotlinTypeRefiner(), new LazyJavaClassDescriptor$scopeHolder$1(this));
                this.innerClassesScope = new InnerClassesScopeWrapper(this.unsubstitutedMemberScope);
                this.staticScope = new LazyJavaStaticClassScope(this.f5941c, this.jClass, this);
                this.annotations = TweetUtils.resolveAnnotations(this.f5941c, this.jClass);
                this.declaredParameters = this.f5941c.components.storageManager.createLazyValue(new LazyJavaClassDescriptor$declaredParameters$1(this));
                return;
            }
            throw new AssertionError(Intrinsics.stringPlus("Creating LazyJavaClassDescriptor for light class ", this.jClass));
        } else {
            AnonymousClass1.$$$reportNull$$$0(7);
            throw null;
        }
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    public Collection getConstructors() {
        return (List) this.unsubstitutedMemberScope.constructors.invoke();
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List) this.declaredParameters.invoke();
    }

    public ClassKind getKind() {
        return this.kind;
    }

    public Modality getModality() {
        return this.modality;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        if (this.modality != Modality.SEALED) {
            return EmptyList.INSTANCE;
        }
        JavaTypeAttributes attributes$default = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3);
        Collection<JavaClassifierType> permittedTypes = this.jClass.getPermittedTypes();
        ArrayList arrayList = new ArrayList();
        for (JavaClassifierType transformJavaType : permittedTypes) {
            ClassifierDescriptor declarationDescriptor = this.f5941c.typeResolver.transformJavaType(transformJavaType, attributes$default).getConstructor().getDeclarationDescriptor();
            Object obj = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public MemberScope getStaticScope() {
        return this.staticScope;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (LazyJavaClassMemberScope) this.scopeHolder.getScope(kotlinTypeRefiner);
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public DescriptorVisibility getVisibility() {
        if (!Intrinsics.areEqual(this.visibility, DescriptorVisibilities.PRIVATE) || this.jClass.getOuterClass() != null) {
            return TweetUtils.toDescriptorVisibility(this.visibility);
        }
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.PACKAGE_VISIBILITY;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "{\n            JavaDescriptorVisibilities.PACKAGE_VISIBILITY\n        }");
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
        return Intrinsics.stringPlus("Lazy Java class ", DescriptorUtilsKt.getFqNameUnsafe(this));
    }

    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        return (LazyJavaClassMemberScope) super.getUnsubstitutedMemberScope();
    }
}
