package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: constantValues.kt */
public final class KClassValue extends ConstantValue<Value> {

    /* compiled from: constantValues.kt */
    public static abstract class Value {

        /* compiled from: constantValues.kt */
        public static final class LocalClass extends Value {
            public final KotlinType type;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public LocalClass(KotlinType kotlinType) {
                // Intrinsics.checkNotNullParameter(kotlinType, "type");
                super(null);
                this.type = kotlinType;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LocalClass) && Intrinsics.areEqual(this.type, ((LocalClass) obj).type);
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("LocalClass(type=");
                outline73.append(this.type);
                outline73.append(')');
                return outline73.toString();
            }
        }

        /* compiled from: constantValues.kt */
        public static final class NormalClass extends Value {
            public final ClassLiteralValue value;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public NormalClass(ClassLiteralValue classLiteralValue) {
                // Intrinsics.checkNotNullParameter(classLiteralValue, HSLCriteriaBuilder.VALUE);
                super(null);
                this.value = classLiteralValue;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NormalClass) && Intrinsics.areEqual(this.value, ((NormalClass) obj).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("NormalClass(value=");
                outline73.append(this.value);
                outline73.append(')');
                return outline73.toString();
            }
        }

        public Value() {
        }

        public Value(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KClassValue(Value value) {
        // Intrinsics.checkNotNullParameter(value, HSLCriteriaBuilder.VALUE);
        super(value);
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        KotlinType kotlinType;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
            if (builtIns != null) {
                ClassDescriptor builtInClassByFqName = builtIns.getBuiltInClassByFqName(FqNames.kClass.toSafe());
                if (builtInClassByFqName != null) {
                    Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "module.builtIns.kClass");
                    Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
                    T t = this.value;
                    Value value = (Value) t;
                    if (value instanceof LocalClass) {
                        kotlinType = ((LocalClass) t).type;
                    } else if (value instanceof NormalClass) {
                        ClassLiteralValue classLiteralValue = ((NormalClass) t).value;
                        ClassId classId = classLiteralValue.classId;
                        int i = classLiteralValue.arrayNestedness;
                        ClassDescriptor findClassAcrossModuleDependencies = TweetUtils.findClassAcrossModuleDependencies(moduleDescriptor, classId);
                        if (findClassAcrossModuleDependencies == null) {
                            kotlinType = ErrorUtils.createErrorType("Unresolved type: " + classId + " (arrayDimensions=" + i + ')');
                            Intrinsics.checkNotNullExpressionValue(kotlinType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
                        } else {
                            SimpleType defaultType = findClassAcrossModuleDependencies.getDefaultType();
                            Intrinsics.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
                            KotlinType replaceArgumentsWithStarProjections = TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
                            for (int i2 = 0; i2 < i; i2++) {
                                replaceArgumentsWithStarProjections = moduleDescriptor.getBuiltIns().getArrayType(Variance.INVARIANT, replaceArgumentsWithStarProjections);
                                Intrinsics.checkNotNullExpressionValue(replaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
                            }
                            kotlinType = replaceArgumentsWithStarProjections;
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    return KotlinTypeFactory.simpleNotNullType(annotations, builtInClassByFqName, TweetUtils.listOf(new TypeProjectionImpl(kotlinType)));
                }
                KotlinBuiltIns.$$$reportNull$$$0(20);
                throw null;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KClassValue(kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue r3) {
        /*
            r2 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue$Value$NormalClass r1 = new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue$Value$NormalClass
            r1.<init>(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.<init>(kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue):void");
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KClassValue(ClassId classId, int i) {
        // Intrinsics.checkNotNullParameter(classId, "classId");
        this(new ClassLiteralValue(classId, i));
    }
}
