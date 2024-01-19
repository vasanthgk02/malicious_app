package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
public final class SimpleTypeImpl extends SimpleType {
    public final List<TypeProjection> arguments;
    public final TypeConstructor constructor;
    public final boolean isMarkedNullable;
    public final MemberScope memberScope;
    public final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;

    public SimpleTypeImpl(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope2, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope2, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        this.constructor = typeConstructor;
        this.arguments = list;
        this.isMarkedNullable = z;
        this.memberScope = memberScope2;
        this.refinedTypeFactory = function1;
        if (memberScope2 instanceof ErrorScope) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SimpleTypeImpl should not be created for error type: ");
            outline73.append(this.memberScope);
            outline73.append(10);
            outline73.append(this.constructor);
            throw new IllegalStateException(outline73.toString());
        }
    }

    public Annotations getAnnotations() {
        if (Annotations.Companion != null) {
            return Companion.EMPTY;
        }
        throw null;
    }

    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = (SimpleType) this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        return simpleType == null ? this : simpleType;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == this.isMarkedNullable) {
            return this;
        }
        if (z) {
            return new NullableSimpleType(this);
        }
        return new NotNullSimpleType(this);
    }

    public SimpleType replaceAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (annotations.isEmpty()) {
            return this;
        }
        return new AnnotatedSimpleType(this, annotations);
    }

    /* renamed from: refine  reason: collision with other method in class */
    public UnwrappedType m981refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType simpleType = (SimpleType) this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        return simpleType == null ? this : simpleType;
    }
}
