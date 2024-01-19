package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpecialTypes.kt */
public final class SpecialTypesKt {
    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType unwrappedType, boolean z) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.makeDefinitelyNotNull$descriptors(unwrappedType, z);
        if (makeDefinitelyNotNull$descriptors != null) {
            return makeDefinitelyNotNull$descriptors;
        }
        SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType);
        return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? unwrappedType.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType unwrappedType, boolean z, int i) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeDefinitelyNotNullOrNotNull(unwrappedType, z);
    }

    public static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType kotlinType) {
        IntersectionTypeConstructor intersectionTypeConstructor;
        TypeConstructor constructor = kotlinType.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor2 = constructor instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) constructor : null;
        if (intersectionTypeConstructor2 == null) {
            return null;
        }
        LinkedHashSet<KotlinType> linkedHashSet = intersectionTypeConstructor2.intersectedTypes;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(linkedHashSet, 10));
        boolean z = false;
        for (KotlinType next : linkedHashSet) {
            if (TypeUtils.isNullableType(next)) {
                next = makeDefinitelyNotNullOrNotNull$default(next.unwrap(), false, 1);
                z = true;
            }
            arrayList.add(next);
        }
        if (!z) {
            intersectionTypeConstructor = null;
        } else {
            KotlinType kotlinType2 = intersectionTypeConstructor2.alternative;
            if (kotlinType2 == null) {
                kotlinType2 = null;
            } else if (TypeUtils.isNullableType(kotlinType2)) {
                kotlinType2 = makeDefinitelyNotNullOrNotNull$default(kotlinType2.unwrap(), false, 1);
            }
            Intrinsics.checkNotNullParameter(arrayList, "typesToIntersect");
            boolean z2 = !arrayList.isEmpty();
            if (!_Assertions.ENABLED || z2) {
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(arrayList);
                linkedHashSet2.hashCode();
                intersectionTypeConstructor = new IntersectionTypeConstructor(linkedHashSet2);
                intersectionTypeConstructor.alternative = kotlinType2;
            } else {
                throw new AssertionError("Attempt to create an empty intersection");
            }
        }
        if (intersectionTypeConstructor == null) {
            return null;
        }
        return intersectionTypeConstructor.createType();
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType simpleType, boolean z) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull$descriptors = DefinitelyNotNullType.makeDefinitelyNotNull$descriptors(simpleType, z);
        if (makeDefinitelyNotNull$descriptors != null) {
            return makeDefinitelyNotNull$descriptors;
        }
        SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? simpleType.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
    }

    public static final SimpleType withAbbreviation(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviatedType");
        if (TweetUtils.isError(simpleType)) {
            return simpleType;
        }
        return new AbbreviatedType(simpleType, simpleType2);
    }
}
