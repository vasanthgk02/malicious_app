package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: Handshake.kt */
public final class Handshake$peerCertificates$2 extends Lambda implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ Function0 $peerCertificatesFn;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Handshake$peerCertificates$2(Function0 function0) {
        // this.$peerCertificatesFn = function0;
        super(0);
    }

    public final List<Certificate> invoke() {
        try {
            return (List) this.$peerCertificatesFn.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return EmptyList.INSTANCE;
        }
    }
}
