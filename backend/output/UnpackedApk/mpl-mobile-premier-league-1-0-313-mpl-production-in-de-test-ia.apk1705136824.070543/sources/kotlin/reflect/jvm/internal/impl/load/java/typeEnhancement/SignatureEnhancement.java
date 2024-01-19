package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.utils.ReportLevel;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement {
    public final AnnotationTypeQualifierResolver annotationTypeQualifierResolver;
    public final JavaTypeEnhancementState javaTypeEnhancementState;
    public final JavaTypeEnhancement typeEnhancement;

    /* compiled from: signatureEnhancement.kt */
    public static class PartEnhancementResult {
        public final boolean containsFunctionN;
        public final KotlinType type;
        public final boolean wereChanges;

        public PartEnhancementResult(KotlinType kotlinType, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            this.type = kotlinType;
            this.wereChanges = z;
            this.containsFunctionN = z2;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    public final class SignatureParts {
        public final AnnotationQualifierApplicabilityType containerApplicabilityType;
        public final LazyJavaResolverContext containerContext;
        public final Collection<KotlinType> fromOverridden;
        public final KotlinType fromOverride;
        public final boolean isCovariant;
        public final Annotated typeContainer;
        public final boolean typeParameterBounds;

        public SignatureParts(SignatureEnhancement signatureEnhancement, Annotated annotated, KotlinType kotlinType, Collection<? extends KotlinType> collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2) {
            Intrinsics.checkNotNullParameter(signatureEnhancement, "this$0");
            Intrinsics.checkNotNullParameter(kotlinType, "fromOverride");
            Intrinsics.checkNotNullParameter(collection, "fromOverridden");
            Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "containerContext");
            Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "containerApplicabilityType");
            SignatureEnhancement.this = signatureEnhancement;
            this.typeContainer = annotated;
            this.fromOverride = kotlinType;
            this.fromOverridden = collection;
            this.isCovariant = z;
            this.containerContext = lazyJavaResolverContext;
            this.containerApplicabilityType = annotationQualifierApplicabilityType;
            this.typeParameterBounds = z2;
        }

        public static final <T> T extractQualifiersFromAnnotations$ifPresent(List<FqName> list, Annotations annotations, T t) {
            boolean z;
            boolean z2 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (annotations.findAnnotation((FqName) it.next()) != null) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z2) {
                return t;
            }
            return null;
        }

        public static final void toIndexed$add(SignatureParts signatureParts, ArrayList<TypeAndDefaultQualifiers> arrayList, KotlinType kotlinType, LazyJavaResolverContext lazyJavaResolverContext, TypeParameterDescriptor typeParameterDescriptor) {
            JavaDefaultQualifiers javaDefaultQualifiers;
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            LazyJavaResolverContext copyWithNewDefaultTypeQualifiers = TweetUtils.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, kotlinType.getAnnotations());
            JavaTypeQualifiersByElementType defaultTypeQualifiers = copyWithNewDefaultTypeQualifiers.getDefaultTypeQualifiers();
            if (defaultTypeQualifiers == null) {
                javaDefaultQualifiers = null;
            } else {
                if (signatureParts.typeParameterBounds) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                javaDefaultQualifiers = defaultTypeQualifiers.defaultQualifiers.get(annotationQualifierApplicabilityType);
            }
            arrayList.add(new TypeAndDefaultQualifiers(kotlinType, javaDefaultQualifiers, typeParameterDescriptor, false));
            List<TypeProjection> arguments = kotlinType.getArguments();
            List<TypeParameterDescriptor> parameters = kotlinType.getConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
            Iterator it = ((ArrayList) ArraysKt___ArraysJvmKt.zip(arguments, parameters)).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                TypeProjection typeProjection = (TypeProjection) pair.first;
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) pair.second;
                if (typeProjection.isStarProjection()) {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "arg.type");
                    arrayList.add(new TypeAndDefaultQualifiers(type, javaDefaultQualifiers, typeParameterDescriptor2, true));
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "arg.type");
                    toIndexed$add(signatureParts, arrayList, type2, copyWithNewDefaultTypeQualifiers, typeParameterDescriptor2);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x007e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier boundsNullability(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r8) {
            /*
                r7 = this;
                boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor) r8
                java.util.List r0 = r8.getUpperBounds()
                java.lang.String r2 = "upperBounds"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                boolean r3 = r0.isEmpty()
                r4 = 0
                r5 = 1
                if (r3 == 0) goto L_0x001b
                goto L_0x0033
            L_0x001b:
                java.util.Iterator r0 = r0.iterator()
            L_0x001f:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0033
                java.lang.Object r3 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
                boolean r3 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r3)
                if (r3 != 0) goto L_0x001f
                r0 = 0
                goto L_0x0034
            L_0x0033:
                r0 = 1
            L_0x0034:
                if (r0 == 0) goto L_0x0038
                goto L_0x00b5
            L_0x0038:
                java.util.List r0 = r8.getUpperBounds()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                boolean r3 = r0.isEmpty()
                if (r3 == 0) goto L_0x0046
                goto L_0x007a
            L_0x0046:
                java.util.Iterator r0 = r0.iterator()
            L_0x004a:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x007a
                java.lang.Object r3 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = r3.unwrap()
                boolean r6 = r3 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
                if (r6 == 0) goto L_0x0061
                kotlin.reflect.jvm.internal.impl.types.FlexibleType r3 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r3
                goto L_0x0062
            L_0x0061:
                r3 = r1
            L_0x0062:
                if (r3 != 0) goto L_0x0065
                goto L_0x0075
            L_0x0065:
                kotlin.reflect.jvm.internal.impl.types.SimpleType r6 = r3.lowerBound
                boolean r6 = r6.isMarkedNullable()
                kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.upperBound
                boolean r3 = r3.isMarkedNullable()
                if (r6 == r3) goto L_0x0075
                r3 = 1
                goto L_0x0076
            L_0x0075:
                r3 = 0
            L_0x0076:
                if (r3 != 0) goto L_0x004a
                r0 = 0
                goto L_0x007b
            L_0x007a:
                r0 = 1
            L_0x007b:
                if (r0 == 0) goto L_0x007e
                goto L_0x00b5
            L_0x007e:
                java.util.List r8 = r8.getUpperBounds()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
                boolean r0 = r8.isEmpty()
                if (r0 == 0) goto L_0x008c
                goto L_0x00ae
            L_0x008c:
                java.util.Iterator r8 = r8.iterator()
            L_0x0090:
                boolean r0 = r8.hasNext()
                if (r0 == 0) goto L_0x00ae
                java.lang.Object r0 = r8.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                java.lang.String r1 = "it"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r1 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(r0)
                r0 = r0 ^ r5
                if (r0 == 0) goto L_0x0090
                r4 = 1
            L_0x00ae:
                if (r4 == 0) goto L_0x00b3
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L_0x00b5
            L_0x00b3:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L_0x00b5:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.boundsNullability(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:135:0x02ce, code lost:
            if ((r8.affectsTypeParameterBasedTypes || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r15)) != false) goto L_0x02d2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x03cc, code lost:
            if (r9.qualifier == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L_0x03f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x03ee, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r4, java.lang.Boolean.TRUE) != false) goto L_0x03f3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:264:0x047f, code lost:
            if (((r8 != null) && r13 && r7 == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE) == false) goto L_0x0483;
         */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0244  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0257  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x028e  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x02a5  */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x02bb  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x02c0  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x02de  */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x02e1  */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x02e4  */
        /* JADX WARNING: Removed duplicated region for block: B:143:0x02e6  */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x02ed  */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x02f8  */
        /* JADX WARNING: Removed duplicated region for block: B:155:0x032d  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0348  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:195:0x03c5  */
        /* JADX WARNING: Removed duplicated region for block: B:197:0x03c8  */
        /* JADX WARNING: Removed duplicated region for block: B:199:0x03cf  */
        /* JADX WARNING: Removed duplicated region for block: B:215:0x03f8  */
        /* JADX WARNING: Removed duplicated region for block: B:216:0x03fa  */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x040e A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x041c  */
        /* JADX WARNING: Removed duplicated region for block: B:227:0x0421  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:232:0x042c  */
        /* JADX WARNING: Removed duplicated region for block: B:233:0x042e  */
        /* JADX WARNING: Removed duplicated region for block: B:236:0x0443  */
        /* JADX WARNING: Removed duplicated region for block: B:237:0x0445  */
        /* JADX WARNING: Removed duplicated region for block: B:239:0x0448  */
        /* JADX WARNING: Removed duplicated region for block: B:240:0x044a  */
        /* JADX WARNING: Removed duplicated region for block: B:243:0x0452 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:248:0x045e  */
        /* JADX WARNING: Removed duplicated region for block: B:268:0x0491  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:271:0x049c  */
        /* JADX WARNING: Removed duplicated region for block: B:275:0x04a3  */
        /* JADX WARNING: Removed duplicated region for block: B:285:0x04c4  */
        /* JADX WARNING: Removed duplicated region for block: B:288:0x04c9 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:291:0x04d7  */
        /* JADX WARNING: Removed duplicated region for block: B:292:0x04d9  */
        /* JADX WARNING: Removed duplicated region for block: B:297:0x0501  */
        /* JADX WARNING: Removed duplicated region for block: B:298:0x0503  */
        /* JADX WARNING: Removed duplicated region for block: B:301:0x0519  */
        /* JADX WARNING: Removed duplicated region for block: B:303:0x051c  */
        /* JADX WARNING: Removed duplicated region for block: B:312:0x054d  */
        /* JADX WARNING: Removed duplicated region for block: B:338:0x025a A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:342:0x033e A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.PartEnhancementResult enhance(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r28) {
            /*
                r27 = this;
                r0 = r27
                r1 = r28
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r2 = r0.fromOverridden
                java.util.ArrayList r3 = new java.util.ArrayList
                r4 = 10
                int r5 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r2, r4)
                r3.<init>(r5)
                java.util.Iterator r2 = r2.iterator()
            L_0x0015:
                boolean r5 = r2.hasNext()
                r6 = 1
                r7 = 0
                if (r5 == 0) goto L_0x0031
                java.lang.Object r5 = r2.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r5
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>(r6)
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r6 = r0.containerContext
                toIndexed$add(r0, r8, r5, r6, r7)
                r3.add(r8)
                goto L_0x0015
            L_0x0031:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r0.fromOverride
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>(r6)
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r8 = r0.containerContext
                toIndexed$add(r0, r5, r2, r8, r7)
                boolean r2 = r0.isCovariant
                if (r2 == 0) goto L_0x0070
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> r2 = r0.fromOverridden
                boolean r9 = r2 instanceof java.util.Collection
                if (r9 == 0) goto L_0x004e
                boolean r9 = r2.isEmpty()
                if (r9 == 0) goto L_0x004e
                goto L_0x006b
            L_0x004e:
                java.util.Iterator r2 = r2.iterator()
            L_0x0052:
                boolean r9 = r2.hasNext()
                if (r9 == 0) goto L_0x006b
                java.lang.Object r9 = r2.next()
                kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r9
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r10 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
                kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r0.fromOverride
                boolean r9 = r10.equalTypes(r9, r11)
                r9 = r9 ^ r6
                if (r9 == 0) goto L_0x0052
                r2 = 1
                goto L_0x006c
            L_0x006b:
                r2 = 0
            L_0x006c:
                if (r2 == 0) goto L_0x0070
                r2 = 1
                goto L_0x0071
            L_0x0070:
                r2 = 0
            L_0x0071:
                if (r2 == 0) goto L_0x0075
                r9 = 1
                goto L_0x0079
            L_0x0075:
                int r9 = r5.size()
            L_0x0079:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[] r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers[r9]
                r11 = 0
            L_0x007c:
                java.lang.String r12 = "<this>"
                if (r11 >= r9) goto L_0x04f4
                if (r11 != 0) goto L_0x0084
                r13 = 1
                goto L_0x0085
            L_0x0084:
                r13 = 0
            L_0x0085:
                if (r13 != 0) goto L_0x008c
                if (r2 != 0) goto L_0x008a
                goto L_0x008c
            L_0x008a:
                r14 = 0
                goto L_0x008d
            L_0x008c:
                r14 = 1
            L_0x008d:
                boolean r15 = kotlin._Assertions.ENABLED
                if (r15 == 0) goto L_0x009c
                if (r14 == 0) goto L_0x0094
                goto L_0x009c
            L_0x0094:
                java.lang.AssertionError r1 = new java.lang.AssertionError
                java.lang.String r2 = "Only head type constructors should be computed"
                r1.<init>(r2)
                throw r1
            L_0x009c:
                java.lang.Object r14 = r5.get(r11)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers r14 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers) r14
                kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = r14.type
                kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r8 = r14.defaultQualifiers
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7 = r14.typeParameterForArgument
                boolean r14 = r14.isFromStarProjection
                java.util.ArrayList r6 = new java.util.ArrayList
                r6.<init>()
                java.util.Iterator r16 = r3.iterator()
            L_0x00b3:
                boolean r17 = r16.hasNext()
                if (r17 == 0) goto L_0x00d5
                java.lang.Object r17 = r16.next()
                r4 = r17
                java.util.List r4 = (java.util.List) r4
                java.lang.Object r4 = kotlin.collections.ArraysKt___ArraysJvmKt.getOrNull(r4, r11)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers) r4
                if (r4 != 0) goto L_0x00cb
                r4 = 0
                goto L_0x00cd
            L_0x00cb:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.type
            L_0x00cd:
                if (r4 == 0) goto L_0x00d2
                r6.add(r4)
            L_0x00d2:
                r4 = 10
                goto L_0x00b3
            L_0x00d5:
                java.util.ArrayList r4 = new java.util.ArrayList
                r16 = r2
                r17 = r3
                r2 = 10
                int r3 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r6, r2)
                r4.<init>(r3)
                java.util.Iterator r3 = r6.iterator()
            L_0x00e8:
                boolean r18 = r3.hasNext()
                if (r18 == 0) goto L_0x0100
                java.lang.Object r18 = r3.next()
                r2 = r18
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r2 = r0.extractQualifiers(r2)
                r4.add(r2)
                r2 = 10
                goto L_0x00e8
            L_0x0100:
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r3 = r4.iterator()
            L_0x0109:
                boolean r18 = r3.hasNext()
                if (r18 == 0) goto L_0x0123
                java.lang.Object r18 = r3.next()
                r19 = r3
                r3 = r18
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r3
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r3 = r3.mutability
                if (r3 == 0) goto L_0x0120
                r2.add(r3)
            L_0x0120:
                r3 = r19
                goto L_0x0109
            L_0x0123:
                java.util.Set r2 = kotlin.collections.ArraysKt___ArraysJvmKt.toSet(r2)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Iterator r18 = r4.iterator()
            L_0x0130:
                boolean r19 = r18.hasNext()
                if (r19 == 0) goto L_0x014a
                java.lang.Object r19 = r18.next()
                r20 = r5
                r5 = r19
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r5
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = r5.nullability
                if (r5 == 0) goto L_0x0147
                r3.add(r5)
            L_0x0147:
                r5 = r20
                goto L_0x0130
            L_0x014a:
                r20 = r5
                java.util.Set r3 = kotlin.collections.ArraysKt___ArraysJvmKt.toSet(r3)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.Iterator r6 = r6.iterator()
            L_0x0159:
                boolean r18 = r6.hasNext()
                if (r18 == 0) goto L_0x0183
                java.lang.Object r18 = r6.next()
                r19 = r6
                r6 = r18
                kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r12)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r18 = com.twitter.sdk.android.tweetui.TweetUtils.getEnhancement(r6)
                if (r18 != 0) goto L_0x0173
                goto L_0x0175
            L_0x0173:
                r6 = r18
            L_0x0175:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r6 = r0.extractQualifiers(r6)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = r6.nullability
                if (r6 == 0) goto L_0x0180
                r5.add(r6)
            L_0x0180:
                r6 = r19
                goto L_0x0159
            L_0x0183:
                java.util.Set r5 = kotlin.collections.ArraysKt___ArraysJvmKt.toSet(r5)
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r6 = r0.containerContext
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r6 = r6.components
                kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings r6 = r6.settings
                boolean r6 = r6.getTypeEnhancementImprovements()
                if (r13 == 0) goto L_0x0282
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r12 = r0.typeContainer
                if (r12 == 0) goto L_0x0282
                r18 = r8
                boolean r8 = r12 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
                if (r8 != 0) goto L_0x027f
                if (r6 == 0) goto L_0x027f
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r8 = r12.getAnnotations()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.this
                r19 = r9
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.Iterator r8 = r8.iterator()
            L_0x01b0:
                boolean r21 = r8.hasNext()
                if (r21 == 0) goto L_0x026a
                java.lang.Object r1 = r8.next()
                r21 = r8
                r8 = r1
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r8
                r22 = r10
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver r10 = r12.annotationTypeQualifierResolver
                if (r10 == 0) goto L_0x0268
                r23 = r12
                java.lang.String r12 = "annotationDescriptor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r12)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r12 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(r8)
                if (r12 != 0) goto L_0x01d7
                r25 = r4
                r24 = r11
                goto L_0x01ec
            L_0x01d7:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r12 = r12.getAnnotations()
                r24 = r11
                kotlin.reflect.jvm.internal.impl.name.FqName r11 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.TARGET_ANNOTATION
                r25 = r4
                java.lang.String r4 = "TARGET_ANNOTATION"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r4)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r4 = r12.findAnnotation(r11)
                if (r4 != 0) goto L_0x01ee
            L_0x01ec:
                r4 = 0
                goto L_0x0241
            L_0x01ee:
                java.util.Map r4 = r4.getAllValueArguments()
                java.util.ArrayList r11 = new java.util.ArrayList
                r11.<init>()
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x01ff:
                boolean r12 = r4.hasNext()
                if (r12 == 0) goto L_0x0222
                java.lang.Object r12 = r4.next()
                java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                java.lang.Object r12 = r12.getValue()
                kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r12 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r12
                r26 = r4
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1 r4 = new kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1
                r4.<init>(r10)
                java.util.List r4 = r10.mapConstantToQualifierApplicabilityTypes(r12, r4)
                com.twitter.sdk.android.tweetui.TweetUtils.addAll(r11, r4)
                r4 = r26
                goto L_0x01ff
            L_0x0222:
                java.util.Iterator r4 = r11.iterator()
                r10 = 0
            L_0x0227:
                boolean r11 = r4.hasNext()
                if (r11 == 0) goto L_0x023c
                java.lang.Object r11 = r4.next()
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r11 = (kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType) r11
                int r11 = r11.ordinal()
                r12 = 1
                int r11 = r12 << r11
                r10 = r10 | r11
                goto L_0x0227
            L_0x023c:
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$TypeQualifierWithApplicability r4 = new kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$TypeQualifierWithApplicability
                r4.<init>(r8, r10)
            L_0x0241:
                if (r4 != 0) goto L_0x0244
                goto L_0x0254
            L_0x0244:
                java.util.List r4 = r4.component2()
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r8 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.TYPE_USE
                java.util.ArrayList r4 = (java.util.ArrayList) r4
                boolean r4 = r4.contains(r8)
                if (r4 != 0) goto L_0x0254
                r4 = 1
                goto L_0x0255
            L_0x0254:
                r4 = 0
            L_0x0255:
                if (r4 == 0) goto L_0x025a
                r9.add(r1)
            L_0x025a:
                r1 = r28
                r8 = r21
                r10 = r22
                r12 = r23
                r11 = r24
                r4 = r25
                goto L_0x01b0
            L_0x0268:
                r1 = 0
                throw r1
            L_0x026a:
                r25 = r4
                r22 = r10
                r24 = r11
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.create(r9)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r15.getAnnotations()
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = com.twitter.sdk.android.tweetui.TweetUtils.composeAnnotations(r1, r4)
                goto L_0x02a3
            L_0x027f:
                r25 = r4
                goto L_0x0286
            L_0x0282:
                r25 = r4
                r18 = r8
            L_0x0286:
                r19 = r9
                r22 = r10
                r24 = r11
                if (r13 == 0) goto L_0x029f
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r1 = r0.typeContainer
                if (r1 == 0) goto L_0x029f
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.getAnnotations()
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = r15.getAnnotations()
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = com.twitter.sdk.android.tweetui.TweetUtils.composeAnnotations(r1, r4)
                goto L_0x02a3
            L_0x029f:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r15.getAnnotations()
            L_0x02a3:
                if (r13 == 0) goto L_0x02bb
                kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = r0.containerContext
                kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType r4 = r4.getDefaultTypeQualifiers()
                if (r4 != 0) goto L_0x02af
                r8 = 0
                goto L_0x02bd
            L_0x02af:
                kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r8 = r0.containerApplicabilityType
                java.util.EnumMap<kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType, kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers> r4 = r4.defaultQualifiers
                java.lang.Object r4 = r4.get(r8)
                r8 = r4
                kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers r8 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers) r8
                goto L_0x02bd
            L_0x02bb:
                r8 = r18
            L_0x02bd:
                if (r8 != 0) goto L_0x02c0
                goto L_0x02d1
            L_0x02c0:
                boolean r4 = r8.affectsTypeParameterBasedTypes
                if (r4 != 0) goto L_0x02cd
                boolean r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r15)
                if (r4 != 0) goto L_0x02cb
                goto L_0x02cd
            L_0x02cb:
                r4 = 0
                goto L_0x02ce
            L_0x02cd:
                r4 = 1
            L_0x02ce:
                if (r4 == 0) goto L_0x02d1
                goto L_0x02d2
            L_0x02d1:
                r8 = 0
            L_0x02d2:
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r15.getConstructor()
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
                boolean r9 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
                if (r9 == 0) goto L_0x02e1
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r4
                goto L_0x02e2
            L_0x02e1:
                r4 = 0
            L_0x02e2:
                if (r4 != 0) goto L_0x02e6
                r4 = 0
                goto L_0x02ea
            L_0x02e6:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r0.boundsNullability(r4)
            L_0x02ea:
                r9 = 2
                if (r4 != 0) goto L_0x02f8
                kotlin.Pair r4 = new kotlin.Pair
                java.lang.Boolean r10 = java.lang.Boolean.FALSE
                r11 = 0
                r4.<init>(r11, r10)
                r18 = r5
                goto L_0x0313
            L_0x02f8:
                kotlin.Pair r10 = new kotlin.Pair
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r11 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r12 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                r18 = r5
                r5 = 0
                r11.<init>(r12, r5, r9)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                if (r4 != r5) goto L_0x030a
                r4 = 1
                goto L_0x030b
            L_0x030a:
                r4 = 0
            L_0x030b:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                r10.<init>(r11, r4)
                r4 = r10
            L_0x0313:
                A r5 = r4.first
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus) r5
                B r4 = r4.second
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                boolean r10 = r0.typeParameterBounds
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r11 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.this
                java.util.Iterator r12 = r1.iterator()
            L_0x0327:
                boolean r21 = r12.hasNext()
                if (r21 == 0) goto L_0x033e
                java.lang.Object r21 = r12.next()
                r9 = r21
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r9
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r9 = r11.extractNullability(r9, r6, r10)
                if (r9 == 0) goto L_0x033c
                goto L_0x033f
            L_0x033c:
                r9 = 2
                goto L_0x0327
            L_0x033e:
                r9 = 0
            L_0x033f:
                if (r9 != 0) goto L_0x0342
                goto L_0x0345
            L_0x0342:
                if (r14 != 0) goto L_0x0345
                goto L_0x0346
            L_0x0345:
                r9 = 0
            L_0x0346:
                if (r9 != 0) goto L_0x03c5
                if (r5 != 0) goto L_0x035d
                if (r8 != 0) goto L_0x034d
                goto L_0x0351
            L_0x034d:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r5 = r8.nullabilityQualifier
                if (r5 != 0) goto L_0x0353
            L_0x0351:
                r5 = 0
                goto L_0x035d
            L_0x0353:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r10 = r5.qualifier
                boolean r5 = r5.isForWarningOnly
                r6.<init>(r10, r5)
                r5 = r6
            L_0x035d:
                if (r7 != 0) goto L_0x0361
                r6 = 0
                goto L_0x0365
            L_0x0361:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = r0.boundsNullability(r7)
            L_0x0365:
                if (r6 != 0) goto L_0x0369
                goto L_0x03c6
            L_0x0369:
                if (r5 != 0) goto L_0x0372
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r5 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
                r7 = 0
                r5.<init>(r6, r7)
                goto L_0x03c6
            L_0x0372:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r5 = r5.qualifier
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r10 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
                if (r6 != r10) goto L_0x037b
                goto L_0x0382
            L_0x037b:
                if (r5 != r10) goto L_0x037e
                goto L_0x0386
            L_0x037e:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r10 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
                if (r6 != r10) goto L_0x0384
            L_0x0382:
                r6 = r5
                goto L_0x0386
            L_0x0384:
                if (r5 != r10) goto L_0x0389
            L_0x0386:
                r5 = 2
                r10 = 0
                goto L_0x03c0
            L_0x0389:
                if (r6 != r5) goto L_0x0391
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r10 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                if (r6 != r10) goto L_0x0391
                r10 = 1
                goto L_0x0392
            L_0x0391:
                r10 = 0
            L_0x0392:
                boolean r11 = kotlin._Assertions.ENABLED
                if (r11 == 0) goto L_0x03bd
                if (r10 == 0) goto L_0x0399
                goto L_0x03bd
            L_0x0399:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected everything is NOT_NULL, but "
                r1.append(r2)
                r1.append(r6)
                java.lang.String r2 = " and "
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = " are found"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.AssertionError r2 = new java.lang.AssertionError
                r2.<init>(r1)
                throw r2
            L_0x03bd:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L_0x0386
            L_0x03c0:
                r7.<init>(r6, r10, r5)
                r5 = r7
                goto L_0x03c6
            L_0x03c5:
                r5 = r9
            L_0x03c6:
                if (r9 == 0) goto L_0x03cf
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r9.qualifier
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                if (r4 != r6) goto L_0x03f1
                goto L_0x03f3
            L_0x03cf:
                if (r4 != 0) goto L_0x03f3
                if (r8 != 0) goto L_0x03d5
                r4 = 0
                goto L_0x03e8
            L_0x03d5:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r4 = r8.nullabilityQualifier
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r4.qualifier
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                if (r4 != r6) goto L_0x03e3
                boolean r4 = r8.affectsTypeParameterBasedTypes
                if (r4 == 0) goto L_0x03e3
                r4 = 1
                goto L_0x03e4
            L_0x03e3:
                r4 = 0
            L_0x03e4:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            L_0x03e8:
                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
                if (r4 == 0) goto L_0x03f1
                goto L_0x03f3
            L_0x03f1:
                r4 = 0
                goto L_0x03f4
            L_0x03f3:
                r4 = 1
            L_0x03f4:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r6 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
                if (r5 != 0) goto L_0x03fa
                r7 = 0
                goto L_0x03fc
            L_0x03fa:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = r5.qualifier
            L_0x03fc:
                java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.READ_ONLY_ANNOTATIONS
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                java.lang.Object r8 = extractQualifiersFromAnnotations$ifPresent(r8, r1, r9)
                java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> r9 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.MUTABLE_ANNOTATIONS
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r10 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                java.lang.Object r1 = extractQualifiersFromAnnotations$ifPresent(r9, r1, r10)
                if (r8 == 0) goto L_0x0419
                if (r1 == 0) goto L_0x0419
                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
                if (r9 == 0) goto L_0x0417
                goto L_0x0419
            L_0x0417:
                r1 = 0
                goto L_0x041d
            L_0x0419:
                if (r8 != 0) goto L_0x041c
                goto L_0x041d
            L_0x041c:
                r1 = r8
            L_0x041d:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r1 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r1
                if (r4 == 0) goto L_0x0429
                boolean r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isTypeParameter(r15)
                if (r4 == 0) goto L_0x0429
                r4 = 1
                goto L_0x042a
            L_0x0429:
                r4 = 0
            L_0x042a:
                if (r5 != 0) goto L_0x042e
                r5 = 0
                goto L_0x0434
            L_0x042e:
                boolean r5 = r5.isForWarningOnly
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            L_0x0434:
                java.lang.Boolean r8 = java.lang.Boolean.TRUE
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r8)
                r6.<init>(r7, r1, r4, r5)
                boolean r1 = r6.isNullabilityQualifierForWarning
                r4 = 1
                r1 = r1 ^ r4
                if (r1 == 0) goto L_0x0445
                r1 = r6
                goto L_0x0446
            L_0x0445:
                r1 = 0
            L_0x0446:
                if (r1 != 0) goto L_0x044a
                r1 = 0
                goto L_0x044c
            L_0x044a:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = r1.nullability
            L_0x044c:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r4 = r6.nullability
                boolean r5 = r0.isCovariant
                if (r5 == 0) goto L_0x0456
                if (r13 == 0) goto L_0x0456
                r5 = 1
                goto L_0x0457
            L_0x0456:
                r5 = 0
            L_0x0457:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r7 = com.twitter.sdk.android.tweetui.TweetUtils.select(r3, r1, r5)
                if (r7 != 0) goto L_0x045e
                goto L_0x0482
            L_0x045e:
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated r8 = r0.typeContainer
                boolean r9 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
                if (r9 != 0) goto L_0x0465
                r8 = 0
            L_0x0465:
                kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r8
                if (r8 != 0) goto L_0x046b
                r8 = 0
                goto L_0x046f
            L_0x046b:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getVarargElementType()
            L_0x046f:
                if (r8 == 0) goto L_0x0473
                r8 = 1
                goto L_0x0474
            L_0x0473:
                r8 = 0
            L_0x0474:
                if (r8 == 0) goto L_0x047e
                if (r13 == 0) goto L_0x047e
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
                if (r7 != r8) goto L_0x047e
                r8 = 1
                goto L_0x047f
            L_0x047e:
                r8 = 0
            L_0x047f:
                if (r8 != 0) goto L_0x0482
                goto L_0x0483
            L_0x0482:
                r7 = 0
            L_0x0483:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r10 = r6.mutability
                java.lang.Object r2 = com.twitter.sdk.android.tweetui.TweetUtils.select(r2, r8, r9, r10, r5)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r2
                if (r4 != r1) goto L_0x049c
                r1 = r18
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
                if (r3 != 0) goto L_0x049a
                goto L_0x049e
            L_0x049a:
                r3 = 0
                goto L_0x049f
            L_0x049c:
                r1 = r18
            L_0x049e:
                r3 = 1
            L_0x049f:
                boolean r6 = r6.isNotNullTypeParameter
                if (r6 != 0) goto L_0x04c6
                boolean r6 = r25.isEmpty()
                if (r6 == 0) goto L_0x04aa
                goto L_0x04c0
            L_0x04aa:
                java.util.Iterator r6 = r25.iterator()
            L_0x04ae:
                boolean r8 = r6.hasNext()
                if (r8 == 0) goto L_0x04c0
                java.lang.Object r8 = r6.next()
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r8
                boolean r8 = r8.isNotNullTypeParameter
                if (r8 == 0) goto L_0x04ae
                r6 = 1
                goto L_0x04c1
            L_0x04c0:
                r6 = 0
            L_0x04c1:
                if (r6 == 0) goto L_0x04c4
                goto L_0x04c6
            L_0x04c4:
                r6 = 0
                goto L_0x04c7
            L_0x04c6:
                r6 = 1
            L_0x04c7:
                if (r7 != 0) goto L_0x04d5
                if (r3 == 0) goto L_0x04d5
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = com.twitter.sdk.android.tweetui.TweetUtils.select(r1, r4, r5)
                r3 = 1
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r1 = com.twitter.sdk.android.tweetui.TweetUtils.createJavaTypeQualifiers(r1, r2, r3, r6)
                goto L_0x04de
            L_0x04d5:
                if (r7 != 0) goto L_0x04d9
                r1 = 1
                goto L_0x04da
            L_0x04d9:
                r1 = 0
            L_0x04da:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r1 = com.twitter.sdk.android.tweetui.TweetUtils.createJavaTypeQualifiers(r7, r2, r1, r6)
            L_0x04de:
                r22[r24] = r1
                int r11 = r24 + 1
                r1 = r28
                r2 = r16
                r3 = r17
                r9 = r19
                r5 = r20
                r10 = r22
                r4 = 10
                r6 = 1
                r7 = 0
                goto L_0x007c
            L_0x04f4:
                r22 = r10
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                r2 = r22
                r1.<init>(r2)
                r2 = r28
                if (r2 != 0) goto L_0x0503
                r3 = 0
                goto L_0x0508
            L_0x0503:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 r3 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1
                r3.<init>(r2, r1)
            L_0x0508:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r0.fromOverride
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE
                boolean r2 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.contains(r2, r4)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.this
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement r4 = r4.typeEnhancement
                kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r0.fromOverride
                if (r3 != 0) goto L_0x0519
                goto L_0x051a
            L_0x0519:
                r1 = r3
            L_0x051a:
                if (r4 == 0) goto L_0x054d
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r12)
                java.lang.String r3 = "qualifiers"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r3 = r5.unwrap()
                r5 = 0
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r1 = r4.enhancePossiblyFlexible(r3, r1, r5)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r1.getType()
                boolean r1 = r1.wereChanges
                if (r1 == 0) goto L_0x0537
                r1 = r3
                goto L_0x0538
            L_0x0537:
                r1 = 0
            L_0x0538:
                if (r1 != 0) goto L_0x053c
                r7 = 0
                goto L_0x0542
            L_0x053c:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult
                r3 = 1
                r7.<init>(r1, r3, r2)
            L_0x0542:
                if (r7 != 0) goto L_0x054c
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r0.fromOverride
                r3 = 0
                r7.<init>(r1, r3, r2)
            L_0x054c:
                return r7
            L_0x054d:
                r1 = 0
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.enhance(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
            if (r1.containsKey(r0) != false) goto L_0x0091;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers extractQualifiers(kotlin.reflect.jvm.internal.impl.types.KotlinType r11) {
            /*
                r10 = this;
                boolean r0 = com.twitter.sdk.android.tweetui.TweetUtils.isFlexible(r11)
                if (r0 == 0) goto L_0x0014
                kotlin.reflect.jvm.internal.impl.types.FlexibleType r0 = com.twitter.sdk.android.tweetui.TweetUtils.asFlexibleType(r11)
                kotlin.Pair r1 = new kotlin.Pair
                kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = r0.lowerBound
                kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r0.upperBound
                r1.<init>(r2, r0)
                goto L_0x0019
            L_0x0014:
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r11, r11)
            L_0x0019:
                A r0 = r1.first
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
                B r1 = r1.second
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
                boolean r2 = r0.isMarkedNullable()
                r3 = 0
                if (r2 == 0) goto L_0x002e
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L_0x002c:
                r4 = r2
                goto L_0x0038
            L_0x002e:
                boolean r2 = r1.isMarkedNullable()
                if (r2 != 0) goto L_0x0037
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L_0x002c
            L_0x0037:
                r4 = r3
            L_0x0038:
                java.lang.String r2 = "type"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.getClassDescriptor(r0)
                r5 = 1
                java.lang.String r6 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
                r7 = 0
                if (r0 == 0) goto L_0x0065
                java.lang.String r9 = "readOnly"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r9)
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r9 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
                kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(r0)
                java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName> r9 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.readOnlyToMutable
                if (r9 == 0) goto L_0x005f
                boolean r0 = r9.containsKey(r0)
                if (r0 == 0) goto L_0x0065
                r0 = 1
                goto L_0x0066
            L_0x005f:
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                r11.<init>(r6)
                throw r11
            L_0x0065:
                r0 = 0
            L_0x0066:
                if (r0 == 0) goto L_0x006b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L_0x0097
            L_0x006b:
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.getClassDescriptor(r1)
                if (r0 == 0) goto L_0x0090
                java.lang.String r1 = "mutable"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.INSTANCE
                kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(r0)
                java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName> r1 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.mutableToReadOnly
                if (r1 == 0) goto L_0x008a
                boolean r0 = r1.containsKey(r0)
                if (r0 == 0) goto L_0x0090
                goto L_0x0091
            L_0x008a:
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                r11.<init>(r6)
                throw r11
            L_0x0090:
                r5 = 0
            L_0x0091:
                if (r5 == 0) goto L_0x0096
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L_0x0097
            L_0x0096:
                r0 = r3
            L_0x0097:
                kotlin.reflect.jvm.internal.impl.types.UnwrappedType r11 = r11.unwrap()
                boolean r5 = r11 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter
                r6 = 0
                r7 = 8
                r2 = r8
                r3 = r4
                r4 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiers(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
        }

        public /* synthetic */ SignatureParts(Annotated annotated, KotlinType kotlinType, Collection collection, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, int i) {
            this(SignatureEnhancement.this, annotated, kotlinType, collection, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, (i & 64) != 0 ? false : z2);
        }
    }

    /* compiled from: signatureEnhancement.kt */
    public static final class ValueParameterEnhancementResult extends PartEnhancementResult {
        public final boolean hasDefaultValue;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public ValueParameterEnhancementResult(KotlinType kotlinType, boolean z, boolean z2, boolean z3) {
            // Intrinsics.checkNotNullParameter(kotlinType, "type");
            super(kotlinType, z2, z3);
            this.hasDefaultValue = z;
        }
    }

    public SignatureEnhancement(AnnotationTypeQualifierResolver annotationTypeQualifierResolver2, JavaTypeEnhancementState javaTypeEnhancementState2, JavaTypeEnhancement javaTypeEnhancement) {
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver2, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState2, "javaTypeEnhancementState");
        Intrinsics.checkNotNullParameter(javaTypeEnhancement, "typeEnhancement");
        this.annotationTypeQualifierResolver = annotationTypeQualifierResolver2;
        this.javaTypeEnhancementState = javaTypeEnhancementState2;
        this.typeEnhancement = javaTypeEnhancement;
    }

    /* JADX WARNING: type inference failed for: r0v46, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v47 */
    /* JADX WARNING: type inference failed for: r0v48, types: [java.lang.Double] */
    /* JADX WARNING: type inference failed for: r0v50, types: [java.lang.Float] */
    /* JADX WARNING: type inference failed for: r0v51, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r0v52, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r0v56, types: [java.lang.Short] */
    /* JADX WARNING: type inference failed for: r0v60, types: [java.lang.Byte] */
    /* JADX WARNING: type inference failed for: r0v62, types: [java.lang.Character] */
    /* JADX WARNING: type inference failed for: r0v64, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0352, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r7) != false) goto L_0x0357;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0470, code lost:
        if (r5 == false) goto L_0x0473;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0281 A[Catch:{ IllegalArgumentException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x028c A[Catch:{ IllegalArgumentException -> 0x0355 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0362  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0368  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0392  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0459  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04a1 A[LOOP:4: B:259:0x049b->B:261:0x04a1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> java.util.Collection<D> enhanceSignatures(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r20, java.util.Collection<? extends D> r21) {
        /*
            r19 = this;
            r7 = r19
            r8 = r20
            r0 = r21
            java.lang.String r1 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "platformSignatures"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = 10
            int r1 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r0, r10)
            r9.<init>(r1)
            java.util.Iterator r11 = r21.iterator()
        L_0x001f:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x04c7
            java.lang.Object r0 = r11.next()
            r12 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r12 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r12
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
            if (r0 != 0) goto L_0x0031
            goto L_0x004b
        L_0x0031:
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r1 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r2 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            r13 = 1
            if (r1 != r2) goto L_0x004f
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = r0.getOriginal()
            java.util.Collection r0 = r0.getOverriddenDescriptors()
            int r0 = r0.size()
            if (r0 != r13) goto L_0x004f
        L_0x004b:
            r18 = r11
            goto L_0x0473
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r12.getAnnotations()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r4 = com.twitter.sdk.android.tweetui.TweetUtils.copyWithNewDefaultTypeQualifiers(r8, r0)
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor
            r14 = 0
            if (r0 == 0) goto L_0x007a
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r1 = r0.getter
            if (r1 != 0) goto L_0x0065
            r1 = r14
            goto L_0x006b
        L_0x0065:
            boolean r1 = r1.isDefault
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x006b:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x007a
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl r0 = r0.getter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r2 = r0
            goto L_0x007b
        L_0x007a:
            r2 = r12
        L_0x007b:
            r15 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r15 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor) r15
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r15.getExtensionReceiverParameter()
            if (r0 == 0) goto L_0x00a5
            boolean r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 != 0) goto L_0x008a
            r0 = r14
            goto L_0x008b
        L_0x008a:
            r0 = r2
        L_0x008b:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            if (r0 != 0) goto L_0x0091
            r0 = r14
            goto L_0x0099
        L_0x0091:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r1 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER
            java.lang.Object r0 = r0.getUserData(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
        L_0x0099:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1 r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$receiverTypeEnhancement$1.INSTANCE
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r0 = r7.partsForValueParameter(r12, r0, r4, r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r0 = r0.enhance(r14)
            r6 = r0
            goto L_0x00a6
        L_0x00a5:
            r6 = r14
        L_0x00a6:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor
            if (r0 == 0) goto L_0x00ae
            r0 = r12
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor) r0
            goto L_0x00af
        L_0x00ae:
            r0 = r14
        L_0x00af:
            r5 = 0
            if (r0 != 0) goto L_0x00b3
            goto L_0x00c6
        L_0x00b3:
            kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents r1 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r0.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            r14 = 3
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r0, r5, r5, r14)
            java.lang.String r0 = com.twitter.sdk.android.tweetui.TweetUtils.signature(r1, r3, r0)
            if (r0 != 0) goto L_0x00c8
        L_0x00c6:
            r14 = 0
            goto L_0x00d1
        L_0x00c8:
            java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo> r1 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt.PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE
            java.lang.Object r0 = r1.get(r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo) r0
            r14 = r0
        L_0x00d1:
            if (r14 != 0) goto L_0x00d4
            goto L_0x0128
        L_0x00d4:
            java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> r0 = r14.parametersInfo
            int r0 = r0.size()
            java.util.List r1 = r15.getValueParameters()
            int r1 = r1.size()
            if (r0 != r1) goto L_0x00e6
            r0 = 1
            goto L_0x00e7
        L_0x00e6:
            r0 = 0
        L_0x00e7:
            boolean r1 = kotlin._Assertions.ENABLED
            if (r1 == 0) goto L_0x0128
            if (r0 == 0) goto L_0x00ee
            goto L_0x0128
        L_0x00ee:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Predefined enhancement info for "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " has "
            r0.append(r1)
            java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> r1 = r14.parametersInfo
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r1 = ", but "
            r0.append(r1)
            java.util.List r1 = r15.getValueParameters()
            int r1 = r1.size()
            r0.append(r1)
            java.lang.String r1 = " expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L_0x0128:
            java.util.List r0 = r2.getValueParameters()
            java.lang.String r1 = "annotationOwnerForMember.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.ArrayList r3 = new java.util.ArrayList
            int r1 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r0, r10)
            r3.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x013e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03be
            java.lang.Object r1 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r1
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1 r13 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$valueParameterEnhancements$1$enhancementResult$1
            r13.<init>(r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r13 = r7.partsForValueParameter(r12, r1, r4, r13)
            if (r14 != 0) goto L_0x0156
            goto L_0x015a
        L_0x0156:
            java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> r10 = r14.parametersInfo
            if (r10 != 0) goto L_0x015c
        L_0x015a:
            r5 = 0
            goto L_0x0166
        L_0x015c:
            int r5 = r1.getIndex()
            java.lang.Object r5 = kotlin.collections.ArraysKt___ArraysJvmKt.getOrNull(r10, r5)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo) r5
        L_0x0166:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r5 = r13.enhance(r5)
            boolean r10 = r5.wereChanges
            if (r10 == 0) goto L_0x0171
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r5.type
            goto L_0x017a
        L_0x0171:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r10 = r1.getType()
            java.lang.String r13 = "p.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
        L_0x017a:
            java.lang.String r13 = "p"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            java.lang.String r13 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r13)
            r16 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r1.getAnnotations()
            r17 = r6
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_VALUE_FQ_NAME
            java.lang.String r7 = "DEFAULT_VALUE_FQ_NAME"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r0 = r0.findAnnotation(r6)
            if (r0 != 0) goto L_0x019a
            goto L_0x01a0
        L_0x019a:
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r0 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstArgument(r0)
            if (r0 != 0) goto L_0x01a2
        L_0x01a0:
            r0 = 0
            goto L_0x01a9
        L_0x01a2:
            boolean r6 = r0 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue
            if (r6 != 0) goto L_0x01a7
            r0 = 0
        L_0x01a7:
            kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue r0 = (kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue) r0
        L_0x01a9:
            if (r0 != 0) goto L_0x01ac
            goto L_0x01b2
        L_0x01ac:
            T r0 = r0.value
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x01c8
        L_0x01b2:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r0 = r1.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.DEFAULT_NULL_FQ_NAME
            java.lang.String r7 = "DEFAULT_NULL_FQ_NAME"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            boolean r0 = r0.hasAnnotation(r6)
            if (r0 == 0) goto L_0x01c6
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue r0 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue.INSTANCE
            goto L_0x01ce
        L_0x01c6:
            r0 = 0
            goto L_0x01ce
        L_0x01c8:
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue r6 = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue
            r6.<init>(r0)
            r0 = r6
        L_0x01ce:
            boolean r6 = r0 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue
            if (r6 == 0) goto L_0x0368
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue r0 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.StringDefaultValue) r0
            java.lang.String r0 = r0.value
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r13)
            java.lang.String r6 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r7 = r10.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r7 = r7.getDeclarationDescriptor()
            boolean r8 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r8 == 0) goto L_0x0224
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r8 = r7.getKind()
            r18 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r11 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS
            if (r8 != r11) goto L_0x0226
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r6 = r7.getUnsubstitutedInnerClassesScope()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r0)
            java.lang.String r7 = "identifier(value)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r7 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BACKEND
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r6.getContributedClassifier(r0, r7)
            boolean r6 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r6 == 0) goto L_0x0221
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r7 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r6 != r7) goto L_0x0221
            kotlin.reflect.jvm.internal.impl.load.java.EnumEntry r6 = new kotlin.reflect.jvm.internal.impl.load.java.EnumEntry
            r6.<init>(r0)
            r11 = 1
            goto L_0x0360
        L_0x0221:
            r11 = 1
            goto L_0x035f
        L_0x0224:
            r18 = r11
        L_0x0226:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNotNullable(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
            r6 = 2
            java.lang.String r8 = "0x"
            r10 = 0
            boolean r8 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r8, r10, r6)
            java.lang.String r11 = "(this as java.lang.String).substring(startIndex)"
            if (r8 != 0) goto L_0x0268
            java.lang.String r8 = "0X"
            boolean r8 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r8, r10, r6)
            if (r8 == 0) goto L_0x0242
            goto L_0x0268
        L_0x0242:
            java.lang.String r8 = "0b"
            boolean r8 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r8, r10, r6)
            if (r8 != 0) goto L_0x025b
            java.lang.String r8 = "0B"
            boolean r8 = kotlin.text.CharsKt__CharKt.startsWith$default(r0, r8, r10, r6)
            if (r8 == 0) goto L_0x0253
            goto L_0x025b
        L_0x0253:
            kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix r6 = new kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix
            r8 = 10
            r6.<init>(r0, r8)
            goto L_0x0277
        L_0x025b:
            kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix r8 = new kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix
            java.lang.String r10 = r0.substring(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r8.<init>(r10, r6)
            goto L_0x0276
        L_0x0268:
            kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix r8 = new kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix
            java.lang.String r6 = r0.substring(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
            r10 = 16
            r8.<init>(r6, r10)
        L_0x0276:
            r6 = r8
        L_0x0277:
            java.lang.String r8 = r6.number
            int r6 = r6.radix
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBoolean(r7)     // Catch:{ IllegalArgumentException -> 0x0355 }
            if (r10 == 0) goto L_0x028c
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ IllegalArgumentException -> 0x0355 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x0355 }
            r11 = 1
            goto L_0x0357
        L_0x028c:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r10 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._char     // Catch:{ IllegalArgumentException -> 0x0355 }
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r7, r10)     // Catch:{ IllegalArgumentException -> 0x0355 }
            if (r10 == 0) goto L_0x02a9
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r13)     // Catch:{ IllegalArgumentException -> 0x0355 }
            int r6 = r0.length()     // Catch:{ IllegalArgumentException -> 0x0355 }
            r11 = 1
            if (r6 != r11) goto L_0x0356
            r10 = 0
            char r0 = r0.charAt(r10)     // Catch:{  }
            java.lang.Character r0 = java.lang.Character.valueOf(r0)     // Catch:{  }
            goto L_0x0357
        L_0x02a9:
            r11 = 1
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r10 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._byte     // Catch:{  }
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r7, r10)     // Catch:{  }
            if (r10 == 0) goto L_0x02d0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r13)     // Catch:{  }
            java.lang.Integer r0 = kotlin.text.CharsKt__CharKt.toIntOrNull(r8, r6)     // Catch:{  }
            if (r0 == 0) goto L_0x0356
            int r0 = r0.intValue()     // Catch:{  }
            r6 = -128(0xffffffffffffff80, float:NaN)
            if (r0 < r6) goto L_0x0356
            r6 = 127(0x7f, float:1.78E-43)
            if (r0 <= r6) goto L_0x02c9
            goto L_0x0356
        L_0x02c9:
            byte r0 = (byte) r0     // Catch:{  }
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{  }
            goto L_0x0357
        L_0x02d0:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r10 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._short     // Catch:{  }
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r7, r10)     // Catch:{  }
            if (r10 == 0) goto L_0x02f5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r13)     // Catch:{  }
            java.lang.Integer r0 = kotlin.text.CharsKt__CharKt.toIntOrNull(r8, r6)     // Catch:{  }
            if (r0 == 0) goto L_0x0356
            int r0 = r0.intValue()     // Catch:{  }
            r6 = -32768(0xffffffffffff8000, float:NaN)
            if (r0 < r6) goto L_0x0356
            r6 = 32767(0x7fff, float:4.5916E-41)
            if (r0 <= r6) goto L_0x02ef
            goto L_0x0356
        L_0x02ef:
            short r0 = (short) r0     // Catch:{  }
            java.lang.Short r0 = java.lang.Short.valueOf(r0)     // Catch:{  }
            goto L_0x0357
        L_0x02f5:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r10 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._int     // Catch:{  }
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r7, r10)     // Catch:{  }
            if (r10 == 0) goto L_0x0302
            java.lang.Integer r0 = kotlin.text.CharsKt__CharKt.toIntOrNull(r8, r6)     // Catch:{  }
            goto L_0x0357
        L_0x0302:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r10 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._long     // Catch:{  }
            boolean r10 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(r7, r10)     // Catch:{  }
            if (r10 == 0) goto L_0x030f
            java.lang.Long r0 = kotlin.text.CharsKt__CharKt.toLongOrNull(r8, r6)     // Catch:{  }
            goto L_0x0357
        L_0x030f:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r6 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._float     // Catch:{  }
            boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClass(r7, r6)     // Catch:{  }
            if (r6 == 0) goto L_0x031f
            boolean r6 = r7.isMarkedNullable()     // Catch:{  }
            if (r6 != 0) goto L_0x031f
            r10 = 1
            goto L_0x0320
        L_0x031f:
            r10 = 0
        L_0x0320:
            if (r10 == 0) goto L_0x0336
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r13)     // Catch:{  }
            kotlin.text.Regex r6 = kotlin.text.ScreenFloatValueRegEx.value     // Catch:{ IllegalArgumentException -> 0x0356 }
            boolean r6 = r6.matches(r0)     // Catch:{ IllegalArgumentException -> 0x0356 }
            if (r6 == 0) goto L_0x0356
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ IllegalArgumentException -> 0x0356 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x0356 }
            goto L_0x0357
        L_0x0336:
            kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe r6 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._double     // Catch:{  }
            boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isConstructedFromGivenClass(r7, r6)     // Catch:{  }
            if (r6 == 0) goto L_0x0346
            boolean r6 = r7.isMarkedNullable()     // Catch:{  }
            if (r6 != 0) goto L_0x0346
            r10 = 1
            goto L_0x0347
        L_0x0346:
            r10 = 0
        L_0x0347:
            if (r10 == 0) goto L_0x034e
            java.lang.Double r0 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.toDoubleOrNull(r0)     // Catch:{  }
            goto L_0x0357
        L_0x034e:
            boolean r6 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r7)     // Catch:{  }
            if (r6 == 0) goto L_0x0356
            goto L_0x0357
        L_0x0355:
            r11 = 1
        L_0x0356:
            r0 = 0
        L_0x0357:
            if (r0 == 0) goto L_0x035f
            kotlin.reflect.jvm.internal.impl.load.java.Constant r6 = new kotlin.reflect.jvm.internal.impl.load.java.Constant
            r6.<init>(r0)
            goto L_0x0360
        L_0x035f:
            r6 = 0
        L_0x0360:
            if (r6 == 0) goto L_0x0365
            r6 = 0
            r10 = 1
            goto L_0x037f
        L_0x0365:
            r6 = 0
            r10 = 0
            goto L_0x037f
        L_0x0368:
            r18 = r11
            r6 = 0
            r11 = 1
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue r7 = kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue.INSTANCE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
            if (r7 == 0) goto L_0x0379
            boolean r10 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.acceptsNullable(r10)
            goto L_0x037f
        L_0x0379:
            if (r0 != 0) goto L_0x03b8
            boolean r10 = r1.declaresDefaultValue()
        L_0x037f:
            if (r10 == 0) goto L_0x038d
            java.util.Collection r0 = r1.getOverriddenDescriptors()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x038d
            r10 = 1
            goto L_0x038e
        L_0x038d:
            r10 = 0
        L_0x038e:
            boolean r0 = r5.wereChanges
            if (r0 != 0) goto L_0x039b
            boolean r0 = r1.declaresDefaultValue()
            if (r10 == r0) goto L_0x0399
            goto L_0x039b
        L_0x0399:
            r0 = 0
            goto L_0x039c
        L_0x039b:
            r0 = 1
        L_0x039c:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$ValueParameterEnhancementResult r1 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$ValueParameterEnhancementResult
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r5.type
            boolean r5 = r5.containsFunctionN
            r1.<init>(r7, r10, r0, r5)
            r3.add(r1)
            r7 = r19
            r8 = r20
            r0 = r16
            r6 = r17
            r11 = r18
            r5 = 0
            r10 = 10
            r13 = 1
            goto L_0x013e
        L_0x03b8:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x03be:
            r17 = r6
            r18 = r11
            r6 = 0
            r11 = 1
            r5 = 1
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
            if (r0 != 0) goto L_0x03cb
            r0 = 0
            goto L_0x03cc
        L_0x03cb:
            r0 = r12
        L_0x03cc:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r0
            if (r0 != 0) goto L_0x03d2
            r0 = 0
            goto L_0x03da
        L_0x03d2:
            boolean r0 = com.twitter.sdk.android.tweetui.TweetUtils.isJavaField(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x03da:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x03e5
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.FIELD
            goto L_0x03e7
        L_0x03e5:
            kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType r0 = kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE
        L_0x03e7:
            r7 = r0
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1 r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceSignature$returnTypeEnhancement$1.INSTANCE
            r0 = r19
            r1 = r12
            r10 = r3
            r3 = r5
            r13 = 0
            r5 = r7
            r7 = r17
            r6 = r8
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts r0 = r0.parts(r1, r2, r3, r4, r5, r6)
            if (r14 != 0) goto L_0x03fc
            r1 = 0
            goto L_0x03fe
        L_0x03fc:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo r1 = r14.returnTypeInfo
        L_0x03fe:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$PartEnhancementResult r0 = r0.enhance(r1)
            if (r7 != 0) goto L_0x0406
            r1 = 0
            goto L_0x040c
        L_0x0406:
            boolean r1 = r7.containsFunctionN
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x040c:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L_0x043b
            boolean r1 = r0.containsFunctionN
            if (r1 != 0) goto L_0x043b
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x041f
            goto L_0x0435
        L_0x041f:
            java.util.Iterator r1 = r10.iterator()
        L_0x0423:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0435
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$ValueParameterEnhancementResult r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.ValueParameterEnhancementResult) r2
            boolean r2 = r2.containsFunctionN
            if (r2 == 0) goto L_0x0423
            r5 = 1
            goto L_0x0436
        L_0x0435:
            r5 = 0
        L_0x0436:
            if (r5 == 0) goto L_0x0439
            goto L_0x043b
        L_0x0439:
            r5 = 0
            goto L_0x043c
        L_0x043b:
            r5 = 1
        L_0x043c:
            if (r7 != 0) goto L_0x0440
            r1 = 0
            goto L_0x0446
        L_0x0440:
            boolean r1 = r7.wereChanges
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x0446:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 != 0) goto L_0x0476
            boolean r1 = r0.wereChanges
            if (r1 != 0) goto L_0x0476
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto L_0x0459
            goto L_0x046e
        L_0x0459:
            java.util.Iterator r1 = r10.iterator()
        L_0x045d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x046e
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$ValueParameterEnhancementResult r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.ValueParameterEnhancementResult) r2
            boolean r2 = r2.wereChanges
            if (r2 == 0) goto L_0x045d
            r13 = 1
        L_0x046e:
            if (r13 != 0) goto L_0x0476
            if (r5 == 0) goto L_0x0473
            goto L_0x0476
        L_0x0473:
            r2 = 10
            goto L_0x04ba
        L_0x0476:
            if (r5 == 0) goto L_0x0485
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor$UserDataKey<java.lang.Object> r1 = kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt.DEPRECATED_FUNCTION_KEY
            kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN r2 = new kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionN
            r2.<init>(r12)
            kotlin.Pair r3 = new kotlin.Pair
            r3.<init>(r1, r2)
            goto L_0x0486
        L_0x0485:
            r3 = 0
        L_0x0486:
            if (r7 != 0) goto L_0x048a
            r14 = 0
            goto L_0x048c
        L_0x048a:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r14 = r7.type
        L_0x048c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r4 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r10, r2)
            r1.<init>(r4)
            java.util.Iterator r4 = r10.iterator()
        L_0x049b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x04b4
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$ValueParameterEnhancementResult r5 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.ValueParameterEnhancementResult) r5
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData r6 = new kotlin.reflect.jvm.internal.impl.load.java.descriptors.ValueParameterData
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r5.type
            boolean r5 = r5.hasDefaultValue
            r6.<init>(r7, r5)
            r1.add(r6)
            goto L_0x049b
        L_0x04b4:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.type
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor r12 = r15.enhance(r14, r1, r0, r3)
        L_0x04ba:
            r9.add(r12)
            r7 = r19
            r8 = r20
            r11 = r18
            r10 = 10
            goto L_0x001f
        L_0x04c7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.enhanceSignatures(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, java.util.Collection):java.util.Collection");
    }

    public final NullabilityQualifierWithMigrationStatus extractNullability(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotationDescriptor");
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations = extractNullabilityFromKnownAnnotations(annotationDescriptor, z, z2);
        if (extractNullabilityFromKnownAnnotations != null) {
            return extractNullabilityFromKnownAnnotations;
        }
        AnnotationDescriptor resolveTypeQualifierAnnotation = this.annotationTypeQualifierResolver.resolveTypeQualifierAnnotation(annotationDescriptor);
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = null;
        if (resolveTypeQualifierAnnotation == null) {
            return null;
        }
        ReportLevel resolveJsr305AnnotationState = this.annotationTypeQualifierResolver.resolveJsr305AnnotationState(annotationDescriptor);
        if (resolveJsr305AnnotationState.isIgnore()) {
            return null;
        }
        NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations2 = extractNullabilityFromKnownAnnotations(resolveTypeQualifierAnnotation, z, z2);
        if (extractNullabilityFromKnownAnnotations2 != null) {
            nullabilityQualifierWithMigrationStatus = NullabilityQualifierWithMigrationStatus.copy$default(extractNullabilityFromKnownAnnotations2, null, resolveJsr305AnnotationState.isWarning(), 1);
        }
        return nullabilityQualifierWithMigrationStatus;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c9, code lost:
        if (r8.equals("NEVER") == false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        if (r8.equals("MAYBE") == false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d5, code lost:
        r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE, r7);
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus extractNullabilityFromKnownAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r6, boolean r7, boolean r8) {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r6.getFqName()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r2 = r6 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001b
            r2 = r6
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor) r2
            boolean r2 = r2.isFreshlySupportedTypeUseAnnotation
            if (r2 != 0) goto L_0x0017
            if (r8 == 0) goto L_0x001b
        L_0x0017:
            if (r7 != 0) goto L_0x001b
            r7 = 1
            goto L_0x001c
        L_0x001b:
            r7 = 0
        L_0x001c:
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r8 = r5.javaTypeEnhancementState
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r8 = r8.jspecifyReportLevel
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r2 = kotlin.reflect.jvm.internal.impl.utils.ReportLevel.IGNORE
            if (r8 != r2) goto L_0x0025
            goto L_0x004a
        L_0x0025:
            kotlin.reflect.jvm.internal.impl.utils.ReportLevel r2 = kotlin.reflect.jvm.internal.impl.utils.ReportLevel.WARN
            if (r8 != r2) goto L_0x002a
            r3 = 1
        L_0x002a:
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.JSPECIFY_NULLABLE
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r8 == 0) goto L_0x003a
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            r8.<init>(r2, r3)
            goto L_0x004b
        L_0x003a:
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.JSPECIFY_NULLNESS_UNKNOWN
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r8 == 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            r8.<init>(r2, r3)
            goto L_0x004b
        L_0x004a:
            r8 = r1
        L_0x004b:
            if (r8 != 0) goto L_0x012e
            java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.NULLABLE_ANNOTATIONS
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x005e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x005e:
            java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.NOT_NULL_ANNOTATIONS
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x006f
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x006f:
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.JAVAX_NONNULL_ANNOTATION
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r8 == 0) goto L_0x00dd
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r8 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstArgument(r6)
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue
            if (r0 == 0) goto L_0x0082
            kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue r8 = (kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue) r8
            goto L_0x0083
        L_0x0082:
            r8 = r1
        L_0x0083:
            if (r8 != 0) goto L_0x008e
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x008e:
            kotlin.reflect.jvm.internal.impl.name.Name r8 = r8.enumEntryName
            java.lang.String r8 = r8.asString()
            int r0 = r8.hashCode()
            switch(r0) {
                case 73135176: goto L_0x00cc;
                case 74175084: goto L_0x00c3;
                case 433141802: goto L_0x00b0;
                case 1933739535: goto L_0x009d;
                default: goto L_0x009b;
            }
        L_0x009b:
            goto L_0x012a
        L_0x009d:
            java.lang.String r0 = "ALWAYS"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00a7
            goto L_0x012a
        L_0x00a7:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x00b0:
            java.lang.String r0 = "UNKNOWN"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00ba
            goto L_0x012a
        L_0x00ba:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.FORCE_FLEXIBILITY
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x00c3:
            java.lang.String r0 = "NEVER"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00d5
            goto L_0x012a
        L_0x00cc:
            java.lang.String r0 = "MAYBE"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x00d5
            goto L_0x012a
        L_0x00d5:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x00dd:
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.COMPATQUAL_NULLABLE_ANNOTATION
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r8 == 0) goto L_0x00f3
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r8 = r5.javaTypeEnhancementState
            boolean r8 = r8.enableCompatqualCheckerFrameworkAnnotations
            if (r8 == 0) goto L_0x00f3
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x00f3:
            kotlin.reflect.jvm.internal.impl.name.FqName r8 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.COMPATQUAL_NONNULL_ANNOTATION
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r8 == 0) goto L_0x0109
            kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState r8 = r5.javaTypeEnhancementState
            boolean r8 = r8.enableCompatqualCheckerFrameworkAnnotations
            if (r8 == 0) goto L_0x0109
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            r8.<init>(r0, r7)
            goto L_0x012b
        L_0x0109:
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.ANDROIDX_RECENTLY_NON_NULL_ANNOTATION
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
            if (r7 == 0) goto L_0x0119
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            r7.<init>(r8, r4)
            goto L_0x0128
        L_0x0119:
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNamesKt.ANDROIDX_RECENTLY_NULLABLE_ANNOTATION
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
            if (r7 == 0) goto L_0x012a
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            r7.<init>(r8, r4)
        L_0x0128:
            r8 = r7
            goto L_0x012b
        L_0x012a:
            r8 = r1
        L_0x012b:
            if (r8 != 0) goto L_0x012e
            return r1
        L_0x012e:
            boolean r7 = r8.isForWarningOnly
            if (r7 != 0) goto L_0x0142
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
            if (r7 == 0) goto L_0x0142
            kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor r6 = (kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor) r6
            boolean r6 = r6.isIdeExternalAnnotation()
            if (r6 == 0) goto L_0x0142
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r8 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus.copy$default(r8, r1, r4, r4)
        L_0x0142:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.extractNullabilityFromKnownAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus");
    }

    public final SignatureParts parts(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        Function1<? super CallableMemberDescriptor, ? extends KotlinType> function12 = function1;
        KotlinType kotlinType = (KotlinType) function12.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (CallableMemberDescriptor callableMemberDescriptor3 : overriddenDescriptors) {
            Intrinsics.checkNotNullExpressionValue(callableMemberDescriptor3, "it");
            arrayList.add((KotlinType) function12.invoke(callableMemberDescriptor3));
        }
        Annotated annotated2 = annotated;
        boolean z2 = z;
        SignatureParts signatureParts = new SignatureParts(annotated2, kotlinType, arrayList, z2, TweetUtils.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, ((KotlinType) function12.invoke(callableMemberDescriptor)).getAnnotations()), annotationQualifierApplicabilityType, false, 64);
        return signatureParts;
    }

    public final SignatureParts partsForValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        if (valueParameterDescriptor != null) {
            lazyJavaResolverContext = TweetUtils.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations());
        }
        return parts(callableMemberDescriptor, valueParameterDescriptor, false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, function1);
    }
}
