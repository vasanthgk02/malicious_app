package org.spongycastle.jce.provider;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    public static final String[] ASYMMETRIC_CIPHERS = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145"};
    public static final String[] ASYMMETRIC_GENERIC = {"X509", "IES"};
    public static final String[] DIGESTS = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", WebSocketHandshake.SHA1_PROTOCOL, "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b"};
    public static final String[] KEYSTORES = {"BC", "PKCS12"};
    public static final String[] SYMMETRIC_CIPHERS = {EncryptionHelper.algorithm, "ARC4", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF"};
    public static final String[] SYMMETRIC_GENERIC = {"PBEPBKDF2", "PBEPKCS12"};
    public static final String[] SYMMETRIC_MACS = {"SipHash"};

    static {
        new BouncyCastleProviderConfiguration();
        new HashMap();
    }

    public BouncyCastleProvider() {
        super("SC", 1.54d, "BouncyCastle Security Provider v1.54");
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                BouncyCastleProvider bouncyCastleProvider = BouncyCastleProvider.this;
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.digest.", BouncyCastleProvider.DIGESTS);
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.SYMMETRIC_GENERIC);
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.SYMMETRIC_MACS);
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.SYMMETRIC_CIPHERS);
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.ASYMMETRIC_GENERIC);
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.ASYMMETRIC_CIPHERS);
                bouncyCastleProvider.loadAlgorithms("org.spongycastle.jcajce.provider.keystore.", BouncyCastleProvider.KEYSTORES);
                bouncyCastleProvider.put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
                bouncyCastleProvider.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
                bouncyCastleProvider.put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
                bouncyCastleProvider.put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
                bouncyCastleProvider.put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
                bouncyCastleProvider.put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
                bouncyCastleProvider.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
                bouncyCastleProvider.put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
                bouncyCastleProvider.put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
                bouncyCastleProvider.put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
                bouncyCastleProvider.put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
                bouncyCastleProvider.put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
                bouncyCastleProvider.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
                bouncyCastleProvider.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
                bouncyCastleProvider.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
                bouncyCastleProvider.put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
                bouncyCastleProvider.put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
                bouncyCastleProvider.put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
                bouncyCastleProvider.put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
                bouncyCastleProvider.put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
                bouncyCastleProvider.put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
                bouncyCastleProvider.put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
                bouncyCastleProvider.put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
                bouncyCastleProvider.put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
                bouncyCastleProvider.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
                return null;
            }
        });
    }

    public final void loadAlgorithms(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            Class<?> cls = null;
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                if (classLoader != null) {
                    cls = classLoader.loadClass(str + strArr[i] + "$Mappings");
                } else {
                    cls = Class.forName(str + strArr[i] + "$Mappings");
                }
            } catch (ClassNotFoundException unused) {
            }
            if (cls != null) {
                try {
                    ((AlgorithmProvider) cls.newInstance()).configure(this);
                } catch (Exception e2) {
                    StringBuilder outline78 = GeneratedOutlineSupport.outline78("cannot create instance of ", str);
                    outline78.append(strArr[i]);
                    outline78.append("$Mappings : ");
                    outline78.append(e2);
                    throw new InternalError(outline78.toString());
                }
            }
        }
    }
}
