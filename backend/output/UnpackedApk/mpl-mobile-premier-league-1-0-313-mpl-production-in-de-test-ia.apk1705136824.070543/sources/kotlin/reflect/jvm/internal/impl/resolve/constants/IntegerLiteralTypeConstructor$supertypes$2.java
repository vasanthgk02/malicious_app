package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: IntegerLiteralTypeConstructor.kt */
public final class IntegerLiteralTypeConstructor$supertypes$2 extends Lambda implements Function0<List<SimpleType>> {
    public final /* synthetic */ IntegerLiteralTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        // this.this$0 = integerLiteralTypeConstructor;
        super(0);
    }

    public Object invoke() {
        boolean z = true;
        SimpleType defaultType = this.this$0.getBuiltIns().getBuiltInClassByName("Comparable").getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
        List mutableListOf = TweetUtils.mutableListOf(TweetUtils.replace$default(defaultType, TweetUtils.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, this.this$0.type)), null, 2));
        IntegerLiteralTypeConstructor integerLiteralTypeConstructor = this.this$0;
        ModuleDescriptor moduleDescriptor = integerLiteralTypeConstructor.module;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        SimpleType[] simpleTypeArr = new SimpleType[4];
        simpleTypeArr[0] = moduleDescriptor.getBuiltIns().getIntType();
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        if (builtIns != null) {
            SimpleType primitiveKotlinType = builtIns.getPrimitiveKotlinType(PrimitiveType.LONG);
            if (primitiveKotlinType != null) {
                simpleTypeArr[1] = primitiveKotlinType;
                KotlinBuiltIns builtIns2 = moduleDescriptor.getBuiltIns();
                if (builtIns2 != null) {
                    SimpleType primitiveKotlinType2 = builtIns2.getPrimitiveKotlinType(PrimitiveType.BYTE);
                    if (primitiveKotlinType2 != null) {
                        simpleTypeArr[2] = primitiveKotlinType2;
                        KotlinBuiltIns builtIns3 = moduleDescriptor.getBuiltIns();
                        if (builtIns3 != null) {
                            SimpleType primitiveKotlinType3 = builtIns3.getPrimitiveKotlinType(PrimitiveType.SHORT);
                            if (primitiveKotlinType3 != null) {
                                simpleTypeArr[3] = primitiveKotlinType3;
                                List listOf = TweetUtils.listOf((T[]) simpleTypeArr);
                                if (!listOf.isEmpty()) {
                                    Iterator it = listOf.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        if (!(!integerLiteralTypeConstructor.possibleTypes.contains((KotlinType) it.next()))) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                                if (!z) {
                                    SimpleType defaultType2 = this.this$0.getBuiltIns().getBuiltInClassByName("Number").getDefaultType();
                                    if (defaultType2 != null) {
                                        mutableListOf.add(defaultType2);
                                    } else {
                                        KotlinBuiltIns.$$$reportNull$$$0(54);
                                        throw null;
                                    }
                                }
                                return mutableListOf;
                            }
                            KotlinBuiltIns.$$$reportNull$$$0(56);
                            throw null;
                        }
                        throw null;
                    }
                    KotlinBuiltIns.$$$reportNull$$$0(55);
                    throw null;
                }
                throw null;
            }
            KotlinBuiltIns.$$$reportNull$$$0(58);
            throw null;
        }
        throw null;
    }
}
