package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: Handshake.kt */
public final class Handshake$Companion$handshake$1 extends Lambda implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ List $peerCertificatesCopy;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public Handshake$Companion$handshake$1(List list) {
        // this.$peerCertificatesCopy = list;
        super(0);
    }

    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
