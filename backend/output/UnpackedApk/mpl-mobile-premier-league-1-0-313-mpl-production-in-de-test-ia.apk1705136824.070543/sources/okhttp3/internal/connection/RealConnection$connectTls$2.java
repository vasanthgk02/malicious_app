package okhttp3.internal.connection;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Handshake;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: RealConnection.kt */
public final class RealConnection$connectTls$2 extends Lambda implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ RealConnection this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RealConnection$connectTls$2(RealConnection realConnection) {
        // this.this$0 = realConnection;
        super(0);
    }

    public final List<X509Certificate> invoke() {
        Handshake access$getHandshake$p = this.this$0.handshake;
        Intrinsics.checkNotNull(access$getHandshake$p);
        List<Certificate> peerCertificates = access$getHandshake$p.peerCertificates();
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            if (certificate != null) {
                arrayList.add((X509Certificate) certificate);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        return arrayList;
    }
}
