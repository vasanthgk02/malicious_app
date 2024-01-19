package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* compiled from: IntersectionTypeConstructor.kt */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    public KotlinType alternative;
    public final int hashCode;
    public final LinkedHashSet<KotlinType> intersectedTypes;

    public IntersectionTypeConstructor(Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "typesToIntersect");
        boolean z = !collection.isEmpty();
        if (!_Assertions.ENABLED || z) {
            LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
            this.intersectedTypes = linkedHashSet;
            this.hashCode = linkedHashSet.hashCode();
            return;
        }
        throw new AssertionError("Attempt to create an empty intersection");
    }

    public final SimpleType createType() {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
        if (Annotations.Companion != null) {
            return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Companion.EMPTY, this, EmptyList.INSTANCE, false, TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes), new IntersectionTypeConstructor$createType$1(this));
        }
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) obj).intersectedTypes);
    }

    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = ((KotlinType) this.intersectedTypes.iterator().next()).getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return EmptyList.INSTANCE;
    }

    public Collection<KotlinType> getSupertypes() {
        return this.intersectedTypes;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean isDenotable() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: type inference failed for: r0v6, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor] */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v9, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v3
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], kotlin.reflect.jvm.internal.impl.types.KotlinType]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor, kotlin.reflect.jvm.internal.impl.types.KotlinType]
      mth insns count: 36
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r6) {
        /*
            r5 = this;
            java.lang.String r0 = "kotlinTypeRefiner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.LinkedHashSet<kotlin.reflect.jvm.internal.impl.types.KotlinType> r0 = r5.intersectedTypes
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = 1
            r3 = 0
        L_0x0018:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x002d
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.refine(r6)
            r1.add(r3)
            r3 = 1
            goto L_0x0018
        L_0x002d:
            r0 = 0
            if (r3 != 0) goto L_0x0031
            goto L_0x0064
        L_0x0031:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r5.alternative
            if (r3 != 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r3.refine(r6)
        L_0x003a:
            java.lang.String r6 = "typesToIntersect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
            boolean r6 = r1.isEmpty()
            r6 = r6 ^ r2
            boolean r2 = kotlin._Assertions.ENABLED
            if (r2 == 0) goto L_0x0054
            if (r6 == 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            java.lang.String r0 = "Attempt to create an empty intersection"
            r6.<init>(r0)
            throw r6
        L_0x0054:
            java.util.LinkedHashSet r6 = new java.util.LinkedHashSet
            r6.<init>(r1)
            r6.hashCode()
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r1 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            r1.<init>(r6)
            r1.alternative = r0
            r0 = r1
        L_0x0064:
            if (r0 != 0) goto L_0x0067
            r0 = r5
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor");
    }

    public String toString() {
        return ArraysKt___ArraysJvmKt.joinToString$default(ArraysKt___ArraysJvmKt.sortedWith(this.intersectedTypes, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1()), " & ", "{", "}", 0, null, null, 56);
    }
}
