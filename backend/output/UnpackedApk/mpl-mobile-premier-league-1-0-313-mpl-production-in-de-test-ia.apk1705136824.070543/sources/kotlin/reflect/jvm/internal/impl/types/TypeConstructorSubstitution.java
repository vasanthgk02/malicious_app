package kotlin.reflect.jvm.internal.impl.types;

import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);

    /* compiled from: TypeSubstitution.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean z, int i) {
            if ((i & 2) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(map, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(map, z);
        }

        public final TypeSubstitution create(KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        public final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
            Intrinsics.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) ArraysKt___ArraysJvmKt.lastOrNull(parameters);
            if (Intrinsics.areEqual(typeParameterDescriptor == null ? null : Boolean.valueOf(typeParameterDescriptor.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(parameters2, 10));
                for (TypeParameterDescriptor typeConstructor2 : parameters2) {
                    arrayList.add(typeConstructor2.getTypeConstructor());
                }
                return createByConstructorsMap$default(this, ArraysKt___ArraysJvmKt.toMap((Iterable<? extends Pair<? extends K, ? extends V>>) ArraysKt___ArraysJvmKt.zip(arrayList, list)), false, 2);
            }
            Intrinsics.checkNotNullParameter(parameters, BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY);
            Intrinsics.checkNotNullParameter(list, "argumentsList");
            Object[] array = parameters.toArray(new TypeParameterDescriptor[0]);
            if (array != null) {
                TypeParameterDescriptor[] typeParameterDescriptorArr = (TypeParameterDescriptor[]) array;
                Object[] array2 = list.toArray(new TypeProjection[0]);
                if (array2 != null) {
                    return new IndexedParametersSubstitution(typeParameterDescriptorArr, (TypeProjection[]) array2, false);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        return get(kotlinType.getConstructor());
    }

    public abstract TypeProjection get(TypeConstructor typeConstructor);
}
