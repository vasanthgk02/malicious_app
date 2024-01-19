package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/security/cert/Certificate;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: RealConnection.kt */
public final class RealConnection$connectTls$1 extends Lambda implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ Address $address;
    public final /* synthetic */ CertificatePinner $certificatePinner;
    public final /* synthetic */ Handshake $unverifiedHandshake;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        // this.$certificatePinner = certificatePinner;
        // this.$unverifiedHandshake = handshake;
        // this.$address = address;
        super(0);
    }

    public final List<Certificate> invoke() {
        CertificateChainCleaner certificateChainCleaner$okhttp = this.$certificatePinner.getCertificateChainCleaner$okhttp();
        Intrinsics.checkNotNull(certificateChainCleaner$okhttp);
        return certificateChainCleaner$okhttp.clean(this.$unverifiedHandshake.peerCertificates(), this.$address.url().host());
    }
}
