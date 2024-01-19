package in.juspay.vies;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import androidx.annotation.Keep;
import in.juspay.hypersdk.core.PaymentUtils;
import in.juspay.hypersdk.utils.network.JuspaySSLSocketFactory;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class VIESSocketFactory extends JuspaySSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    public final SSLSocketFactory f5041a;

    public class CustomX509TrustManager implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f5043b;

        /* renamed from: c  reason: collision with root package name */
        public X509TrustManagerExtensions f5044c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f5045d;

        public CustomX509TrustManager(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions, Set<String> set) {
            this.f5043b = x509TrustManager;
            this.f5045d = set;
            this.f5044c = x509TrustManagerExtensions;
        }

        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f5043b.checkClientTrusted(x509CertificateArr, str);
        }

        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f5043b.checkServerTrusted(x509CertificateArr, str);
            if (!PaymentUtils.validatePinning(x509CertificateArr, this.f5045d)) {
                throw new CertificateException("SSL Pinning failed");
            }
        }

        @Keep
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            this.f5044c.checkServerTrusted(x509CertificateArr, str, str2);
            if (!PaymentUtils.validatePinning(x509CertificateArr, this.f5045d)) {
                throw new CertificateException("SSL Pinning failed");
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.f5043b.getAcceptedIssuers();
        }
    }

    public VIESSocketFactory(Set<String> set) {
        SSLContext instance = SSLContext.getInstance("SSL");
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance2.init(null);
        X509TrustManager x509TrustManager = (X509TrustManager) instance2.getTrustManagers()[0];
        instance.init(null, new TrustManager[]{new CustomX509TrustManager(x509TrustManager, new X509TrustManagerExtensions(x509TrustManager), set)}, new SecureRandom());
        this.f5041a = instance.getSocketFactory();
    }

    public SSLSocketFactory a() {
        return this.f5041a;
    }
}
