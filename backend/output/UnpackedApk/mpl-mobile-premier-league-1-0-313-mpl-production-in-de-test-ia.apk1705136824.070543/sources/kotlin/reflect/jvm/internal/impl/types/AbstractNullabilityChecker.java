package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractNullabilityChecker {
    public static final boolean hasNotNullSupertype(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SupertypesPolicy supertypesPolicy) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "<this>");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
        Intrinsics.checkNotNullParameter(supertypesPolicy, "supertypesPolicy");
        if (!((abstractTypeCheckerContext.isClassType(simpleTypeMarker) && !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) || abstractTypeCheckerContext.isDefinitelyNotNullType(simpleTypeMarker))) {
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> arrayDeque = abstractTypeCheckerContext.supertypesDeque;
            Intrinsics.checkNotNull(arrayDeque);
            Set<SimpleTypeMarker> set = abstractTypeCheckerContext.supertypesSet;
            Intrinsics.checkNotNull(set);
            arrayDeque.push(simpleTypeMarker);
            while (!arrayDeque.isEmpty()) {
                if (set.size() <= 1000) {
                    SimpleTypeMarker pop = arrayDeque.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, "current");
                    if (set.add(pop)) {
                        SupertypesPolicy supertypesPolicy2 = abstractTypeCheckerContext.isMarkedNullable(pop) ? None.INSTANCE : supertypesPolicy;
                        if (!(!Intrinsics.areEqual(supertypesPolicy2, None.INSTANCE))) {
                            supertypesPolicy2 = null;
                        }
                        if (supertypesPolicy2 == null) {
                            continue;
                        } else {
                            for (KotlinTypeMarker transformType : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                SimpleTypeMarker transformType2 = supertypesPolicy2.transformType(abstractTypeCheckerContext, transformType);
                                if ((abstractTypeCheckerContext.isClassType(transformType2) && !abstractTypeCheckerContext.isMarkedNullable(transformType2)) || abstractTypeCheckerContext.isDefinitelyNotNullType(transformType2)) {
                                    abstractTypeCheckerContext.clear();
                                } else {
                                    arrayDeque.add(transformType2);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    StringBuilder outline83 = GeneratedOutlineSupport.outline83("Too many supertypes for type: ", simpleTypeMarker, ". Supertypes = ");
                    outline83.append(ArraysKt___ArraysJvmKt.joinToString$default(set, null, null, null, 0, null, null, 63));
                    throw new IllegalStateException(outline83.toString().toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return false;
        }
        return true;
    }

    public static final boolean isApplicableAsEndNode(AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor((KotlinTypeMarker) simpleTypeMarker)) && !abstractTypeCheckerContext.isNullableType(simpleTypeMarker)) {
            return true;
        }
        if (abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (!((ClassicTypeCheckerContext) abstractTypeCheckerContext).stubTypeEqualsToAnything || !abstractTypeCheckerContext.isStubType(simpleTypeMarker)) {
            return abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
        }
        return true;
    }
}
