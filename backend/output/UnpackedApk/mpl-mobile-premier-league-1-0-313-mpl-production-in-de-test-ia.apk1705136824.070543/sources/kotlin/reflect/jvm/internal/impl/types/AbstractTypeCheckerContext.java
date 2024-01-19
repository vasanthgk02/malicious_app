package kotlin.reflect.jvm.internal.impl.types;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;

/* compiled from: AbstractTypeChecker.kt */
public abstract class AbstractTypeCheckerContext implements TypeSystemContext {
    public int argumentsDepth;
    public ArrayDeque<SimpleTypeMarker> supertypesDeque;
    public boolean supertypesLocked;
    public Set<SimpleTypeMarker> supertypesSet;

    /* compiled from: AbstractTypeChecker.kt */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    /* compiled from: AbstractTypeChecker.kt */
    public static abstract class SupertypesPolicy {

        /* compiled from: AbstractTypeChecker.kt */
        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();

            public LowerIfFlexible() {
                super(null);
            }

            public SimpleTypeMarker transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                return TweetUtils.lowerBoundIfFlexible(abstractTypeCheckerContext, kotlinTypeMarker);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = new None();

            public None() {
                super(null);
            }

            public SimpleTypeMarker transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();

            public UpperIfFlexible() {
                super(null);
            }

            public SimpleTypeMarker transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(abstractTypeCheckerContext, "context");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                return TweetUtils.upperBoundIfFlexible(abstractTypeCheckerContext, kotlinTypeMarker);
            }
        }

        public SupertypesPolicy(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public abstract SimpleTypeMarker transformType(AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker);
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> arrayDeque = this.supertypesDeque;
        Intrinsics.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<SimpleTypeMarker> set = this.supertypesSet;
        Intrinsics.checkNotNull(set);
        set.clear();
        this.supertypesLocked = false;
    }

    public TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        return TweetUtils.get(this, typeArgumentListMarker, i);
    }

    public boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        return isMarkedNullable(lowerBoundIfFlexible(kotlinTypeMarker)) != isMarkedNullable(upperBoundIfFlexible(kotlinTypeMarker));
    }

    public final void initialize() {
        boolean z = !this.supertypesLocked;
        if (!_Assertions.ENABLED || z) {
            this.supertypesLocked = true;
            if (this.supertypesDeque == null) {
                this.supertypesDeque = new ArrayDeque<>(4);
            }
            if (this.supertypesSet == null) {
                this.supertypesSet = Companion.create();
                return;
            }
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public boolean isClassType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        return isClassTypeConstructor(typeConstructor(simpleTypeMarker));
    }

    public boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "receiver");
        SimpleTypeMarker asSimpleType = asSimpleType(kotlinTypeMarker);
        return (asSimpleType == null ? null : asDefinitelyNotNullType(asSimpleType)) != null;
    }

    public boolean isIntegerLiteralType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "receiver");
        return isIntegerLiteralTypeConstructor(typeConstructor(simpleTypeMarker));
    }

    public boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.isMarkedNullable((TypeSystemContext) this, kotlinTypeMarker);
    }

    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.lowerBoundIfFlexible(this, kotlinTypeMarker);
    }

    public abstract KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker);

    public abstract KotlinTypeMarker refineType(KotlinTypeMarker kotlinTypeMarker);

    public int size(TypeArgumentListMarker typeArgumentListMarker) {
        return TweetUtils.size(this, typeArgumentListMarker);
    }

    public TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.typeConstructor((TypeSystemContext) this, kotlinTypeMarker);
    }

    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        return TweetUtils.upperBoundIfFlexible(this, kotlinTypeMarker);
    }
}
