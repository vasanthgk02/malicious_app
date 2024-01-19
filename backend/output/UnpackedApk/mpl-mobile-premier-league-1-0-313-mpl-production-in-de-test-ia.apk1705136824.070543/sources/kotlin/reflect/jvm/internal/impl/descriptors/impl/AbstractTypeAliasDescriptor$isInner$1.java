package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        // this.this$0 = abstractTypeAliasDescriptor;
        super(1);
    }

    public Object invoke(Object obj) {
        UnwrappedType unwrappedType = (UnwrappedType) obj;
        Intrinsics.checkNotNullExpressionValue(unwrappedType, "type");
        boolean z = false;
        if (!TweetUtils.isError(unwrappedType)) {
            AbstractTypeAliasDescriptor abstractTypeAliasDescriptor = this.this$0;
            ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
            if ((declarationDescriptor instanceof TypeParameterDescriptor) && !Intrinsics.areEqual(((TypeParameterDescriptor) declarationDescriptor).getContainingDeclaration(), abstractTypeAliasDescriptor)) {
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }
}
