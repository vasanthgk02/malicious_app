package kotlin.reflect.jvm.internal.impl.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Visibilities.kt */
public final class Visibilities {
    public static final Visibilities INSTANCE = new Visibilities();
    public static final Map<Visibility, Integer> ORDERED_VISIBILITIES;

    /* compiled from: Visibilities.kt */
    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = new Inherited();

        public Inherited() {
            super("inherited", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = new Internal();

        public Internal() {
            super("internal", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        public InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Local extends Visibility {
        public static final Local INSTANCE = new Local();

        public Local() {
            super("local", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Private extends Visibility {
        public static final Private INSTANCE = new Private();

        public Private() {
            super("private", false);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        public PrivateToThis() {
            super("private_to_this", false);
        }

        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = new Protected();

        public Protected() {
            super("protected", true);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Public extends Visibility {
        public static final Public INSTANCE = new Public();

        public Public() {
            super("public", true);
        }
    }

    /* compiled from: Visibilities.kt */
    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = new Unknown();

        public Unknown() {
            super("unknown", false);
        }
    }

    static {
        Map createMapBuilder = TweetUtils.createMapBuilder();
        PrivateToThis privateToThis = PrivateToThis.INSTANCE;
        Integer valueOf = Integer.valueOf(0);
        MapBuilder mapBuilder = (MapBuilder) createMapBuilder;
        mapBuilder.put(privateToThis, valueOf);
        mapBuilder.put(Private.INSTANCE, valueOf);
        Internal internal = Internal.INSTANCE;
        Integer valueOf2 = Integer.valueOf(1);
        mapBuilder.put(internal, valueOf2);
        mapBuilder.put(Protected.INSTANCE, valueOf2);
        mapBuilder.put(Public.INSTANCE, Integer.valueOf(2));
        ORDERED_VISIBILITIES = TweetUtils.build(createMapBuilder);
        Public publicR = Public.INSTANCE;
    }

    public final boolean isPrivate(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return visibility == Private.INSTANCE || visibility == PrivateToThis.INSTANCE;
    }
}
