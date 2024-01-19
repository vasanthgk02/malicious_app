package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: signatureEnhancement.kt */
public final class SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    public final /* synthetic */ JavaTypeQualifiers[] $computedResult;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(JavaTypeQualifiers[] javaTypeQualifiersArr) {
        // this.$computedResult = javaTypeQualifiersArr;
        super(1);
    }

    public Object invoke(Object obj) {
        int intValue = ((Number) obj).intValue();
        JavaTypeQualifiers[] javaTypeQualifiersArr = this.$computedResult;
        if (intValue >= 0 && intValue <= TweetUtils.getLastIndex((T[]) javaTypeQualifiersArr)) {
            return javaTypeQualifiersArr[intValue];
        }
        JavaTypeQualifiers javaTypeQualifiers = JavaTypeQualifiers.Companion;
        return JavaTypeQualifiers.NONE;
    }
}
