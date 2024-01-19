package androidx.window.core;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/math/BigInteger;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Version.kt */
public final class Version$bigInteger$2 extends Lambda implements Function0<BigInteger> {
    public final /* synthetic */ Version this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Version$bigInteger$2(Version version) {
        // this.this$0 = version;
        super(0);
    }

    public Object invoke() {
        return BigInteger.valueOf((long) this.this$0.major).shiftLeft(32).or(BigInteger.valueOf((long) this.this$0.minor)).shiftLeft(32).or(BigInteger.valueOf((long) this.this$0.patch));
    }
}
