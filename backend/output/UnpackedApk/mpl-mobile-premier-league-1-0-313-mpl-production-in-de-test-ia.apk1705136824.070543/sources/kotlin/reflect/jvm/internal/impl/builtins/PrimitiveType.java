package kotlin.reflect.jvm.internal.impl.builtins;

import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: PrimitiveType.kt */
public enum PrimitiveType {
    BOOLEAN(HanselEventConstant.DATA_TYPE_BOOLEAN),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Companion Companion = null;
    public static final Set<PrimitiveType> NUMBER_TYPES = null;
    public final Lazy arrayTypeFqName$delegate;
    public final Name arrayTypeName;
    public final Lazy typeFqName$delegate;
    public final Name typeName;

    /* compiled from: PrimitiveType.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion(null);
        NUMBER_TYPES = TweetUtils.setOf((T[]) new PrimitiveType[]{CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE});
    }

    /* access modifiers changed from: public */
    PrimitiveType(String str) {
        Name identifier = Name.identifier(str);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(typeName)");
        this.typeName = identifier;
        Name identifier2 = Name.identifier(Intrinsics.stringPlus(str, "Array"));
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = identifier2;
        this.typeFqName$delegate = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new PrimitiveType$typeFqName$2(this));
        this.arrayTypeFqName$delegate = TweetUtils.lazy(LazyThreadSafetyMode.PUBLICATION, new PrimitiveType$arrayTypeFqName$2(this));
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
