package com.clevertap.android.sdk.network;

import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.Logger;
import java.io.BufferedInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

public final class SSLContextBuilder {
    public SSLContext build() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore instance3 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance3.load(null, null);
            instance3.setCertificateEntry("AmazonRootCA1", (X509Certificate) instance.generateCertificate(new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("com/clevertap/android/sdk/certificates/AmazonRootCA1.cer"))));
            instance2.init(instance3);
            SSLContext instance4 = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            instance4.init(null, instance2.getTrustManagers(), null);
            Logger.d("SSL Context built");
            return instance4;
        } catch (Throwable unused) {
            int i = CleverTapAPI.debugLevel;
            LogLevel.INFO.intValue();
            return null;
        }
    }
}
