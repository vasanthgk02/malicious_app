package org.eclipse.paho.client.mqttv3.internal.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import sfs2x.client.entities.invitation.InvitationReply;

public class SSLSocketFactoryFactory {
    public static final String CIPHERSUITES = "com.ibm.ssl.enabledCipherSuites";
    public static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory";
    public static final String CLIENTAUTH = "com.ibm.ssl.clientAuthentication";
    public static final String DEFAULT_PROTOCOL = "TLS";
    public static final String JSSEPROVIDER = "com.ibm.ssl.contextProvider";
    public static final String KEYSTORE = "com.ibm.ssl.keyStore";
    public static final String KEYSTOREMGR = "com.ibm.ssl.keyManager";
    public static final String KEYSTOREPROVIDER = "com.ibm.ssl.keyStoreProvider";
    public static final String KEYSTOREPWD = "com.ibm.ssl.keyStorePassword";
    public static final String KEYSTORETYPE = "com.ibm.ssl.keyStoreType";
    public static final String SSLPROTOCOL = "com.ibm.ssl.protocol";
    public static final String SYSKEYMGRALGO = "ssl.KeyManagerFactory.algorithm";
    public static final String SYSKEYSTORE = "javax.net.ssl.keyStore";
    public static final String SYSKEYSTOREPWD = "javax.net.ssl.keyStorePassword";
    public static final String SYSKEYSTORETYPE = "javax.net.ssl.keyStoreType";
    public static final String SYSTRUSTMGRALGO = "ssl.TrustManagerFactory.algorithm";
    public static final String SYSTRUSTSTORE = "javax.net.ssl.trustStore";
    public static final String SYSTRUSTSTOREPWD = "javax.net.ssl.trustStorePassword";
    public static final String SYSTRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
    public static final String TRUSTSTORE = "com.ibm.ssl.trustStore";
    public static final String TRUSTSTOREMGR = "com.ibm.ssl.trustManager";
    public static final String TRUSTSTOREPROVIDER = "com.ibm.ssl.trustStoreProvider";
    public static final String TRUSTSTOREPWD = "com.ibm.ssl.trustStorePassword";
    public static final String TRUSTSTORETYPE = "com.ibm.ssl.trustStoreType";
    public static final byte[] key = {-99, -89, -39, Byte.MIN_VALUE, 5, -72, -119, -100};
    public static final String[] propertyKeys = {SSLPROTOCOL, JSSEPROVIDER, KEYSTORE, KEYSTOREPWD, KEYSTORETYPE, KEYSTOREPROVIDER, KEYSTOREMGR, TRUSTSTORE, TRUSTSTOREPWD, TRUSTSTORETYPE, TRUSTSTOREPROVIDER, TRUSTSTOREMGR, CIPHERSUITES, CLIENTAUTH};
    public static final String xorTag = "{xor}";
    public Hashtable configs;
    public Properties defaultProperties;
    public Logger logger;

    public SSLSocketFactoryFactory() {
        this.logger = null;
        this.configs = new Hashtable();
    }

    private void checkPropertyKeys(Properties properties) throws IllegalArgumentException {
        for (String str : properties.keySet()) {
            if (!keyValid(str)) {
                throw new IllegalArgumentException(String.valueOf(str) + " is not a valid IBM SSL property key.");
            }
        }
    }

    private void convertPassword(Properties properties) {
        String property = properties.getProperty(KEYSTOREPWD);
        if (property != null && !property.startsWith(xorTag)) {
            properties.put(KEYSTOREPWD, obfuscate(property.toCharArray()));
        }
        String property2 = properties.getProperty(TRUSTSTOREPWD);
        if (property2 != null && !property2.startsWith(xorTag)) {
            properties.put(TRUSTSTOREPWD, obfuscate(property2.toCharArray()));
        }
    }

    public static char[] deObfuscate(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = SimpleBase64Encoder.decode(str.substring(5));
            for (int i = 0; i < decode.length; i++) {
                byte b2 = decode[i];
                byte[] bArr = key;
                decode[i] = (byte) ((b2 ^ bArr[i % bArr.length]) & 255);
            }
            return toChar(decode);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getProperty(String str, String str2, String str3) {
        String propertyFromConfig = getPropertyFromConfig(str, str2);
        if (propertyFromConfig != null) {
            return propertyFromConfig;
        }
        if (str3 != null) {
            propertyFromConfig = System.getProperty(str3);
        }
        return propertyFromConfig;
    }

    private String getPropertyFromConfig(String str, String str2) {
        String str3 = null;
        Properties properties = str != null ? (Properties) this.configs.get(str) : null;
        if (properties != null) {
            str3 = properties.getProperty(str2);
            if (str3 != null) {
                return str3;
            }
        }
        Properties properties2 = this.defaultProperties;
        if (properties2 != null) {
            str3 = properties2.getProperty(str2);
            if (str3 != null) {
            }
        }
        return str3;
    }

    private SSLContext getSSLContext(String str) throws MqttSecurityException {
        SSLContext sSLContext;
        KeyManager[] keyManagerArr;
        TrustManager[] trustManagerArr;
        TrustManagerFactory trustManagerFactory;
        String str2;
        String str3;
        String str4;
        String str5;
        KeyManagerFactory keyManagerFactory;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12 = str;
        String sSLProtocol = getSSLProtocol(str);
        if (sSLProtocol == null) {
            sSLProtocol = DEFAULT_PROTOCOL;
        }
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str12 != null ? str12 : "null (broker defaults)";
            objArr[1] = sSLProtocol;
            logger2.fine(CLASS_NAME, "getSSLContext", "12000", objArr);
        }
        String jSSEProvider = getJSSEProvider(str);
        if (jSSEProvider == null) {
            try {
                sSLContext = SSLContext.getInstance(sSLProtocol);
            } catch (KeyStoreException e2) {
                throw new MqttSecurityException((Throwable) e2);
            } catch (CertificateException e3) {
                throw new MqttSecurityException((Throwable) e3);
            } catch (FileNotFoundException e4) {
                throw new MqttSecurityException((Throwable) e4);
            } catch (IOException e5) {
                throw new MqttSecurityException((Throwable) e5);
            } catch (KeyStoreException e6) {
                throw new MqttSecurityException((Throwable) e6);
            } catch (CertificateException e7) {
                throw new MqttSecurityException((Throwable) e7);
            } catch (FileNotFoundException e8) {
                throw new MqttSecurityException((Throwable) e8);
            } catch (IOException e9) {
                throw new MqttSecurityException((Throwable) e9);
            } catch (UnrecoverableKeyException e10) {
                throw new MqttSecurityException((Throwable) e10);
            } catch (NoSuchAlgorithmException e11) {
                throw new MqttSecurityException((Throwable) e11);
            } catch (NoSuchProviderException e12) {
                throw new MqttSecurityException((Throwable) e12);
            } catch (KeyManagementException e13) {
                throw new MqttSecurityException((Throwable) e13);
            }
        } else {
            sSLContext = SSLContext.getInstance(sSLProtocol, jSSEProvider);
        }
        if (this.logger != null) {
            Logger logger3 = this.logger;
            Object[] objArr2 = new Object[2];
            if (str12 != null) {
                str11 = str12;
            } else {
                str11 = "null (broker defaults)";
            }
            objArr2[0] = str11;
            objArr2[1] = sSLContext.getProvider().getName();
            logger3.fine(CLASS_NAME, "getSSLContext", "12001", objArr2);
        }
        String property = getProperty(str12, KEYSTORE, null);
        if (property == null) {
            property = getProperty(str12, KEYSTORE, SYSKEYSTORE);
        }
        String str13 = "null";
        if (this.logger != null) {
            Logger logger4 = this.logger;
            Object[] objArr3 = new Object[2];
            if (str12 != null) {
                str10 = str12;
            } else {
                str10 = "null (broker defaults)";
            }
            objArr3[0] = str10;
            objArr3[1] = property != null ? property : str13;
            logger4.fine(CLASS_NAME, "getSSLContext", "12004", objArr3);
        }
        char[] keyStorePassword = getKeyStorePassword(str);
        if (this.logger != null) {
            Logger logger5 = this.logger;
            Object[] objArr4 = new Object[2];
            if (str12 != null) {
                str9 = str12;
            } else {
                str9 = "null (broker defaults)";
            }
            objArr4[0] = str9;
            objArr4[1] = keyStorePassword != null ? obfuscate(keyStorePassword) : str13;
            logger5.fine(CLASS_NAME, "getSSLContext", "12005", objArr4);
        }
        String keyStoreType = getKeyStoreType(str);
        if (keyStoreType == null) {
            keyStoreType = KeyStore.getDefaultType();
        }
        if (this.logger != null) {
            Logger logger6 = this.logger;
            Object[] objArr5 = new Object[2];
            if (str12 != null) {
                str8 = str12;
            } else {
                str8 = "null (broker defaults)";
            }
            objArr5[0] = str8;
            objArr5[1] = keyStoreType != null ? keyStoreType : str13;
            logger6.fine(CLASS_NAME, "getSSLContext", "12006", objArr5);
        }
        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        String keyStoreProvider = getKeyStoreProvider(str);
        String keyManager = getKeyManager(str);
        if (keyManager != null) {
            defaultAlgorithm = keyManager;
        }
        if (property == null || keyStoreType == null || defaultAlgorithm == null) {
            keyManagerArr = null;
        } else {
            KeyStore instance = KeyStore.getInstance(keyStoreType);
            instance.load(new FileInputStream(property), keyStorePassword);
            if (keyStoreProvider != null) {
                keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm, keyStoreProvider);
            } else {
                keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm);
            }
            if (this.logger != null) {
                Logger logger7 = this.logger;
                Object[] objArr6 = new Object[2];
                if (str12 != null) {
                    str6 = str12;
                } else {
                    str6 = "null (broker defaults)";
                }
                objArr6[0] = str6;
                objArr6[1] = defaultAlgorithm;
                logger7.fine(CLASS_NAME, "getSSLContext", "12010", objArr6);
                Logger logger8 = this.logger;
                Object[] objArr7 = new Object[2];
                if (str12 != null) {
                    str7 = str12;
                } else {
                    str7 = "null (broker defaults)";
                }
                objArr7[0] = str7;
                objArr7[1] = keyManagerFactory.getProvider().getName();
                logger8.fine(CLASS_NAME, "getSSLContext", "12009", objArr7);
            }
            keyManagerFactory.init(instance, keyStorePassword);
            keyManagerArr = keyManagerFactory.getKeyManagers();
        }
        String trustStore = getTrustStore(str);
        if (this.logger != null) {
            Logger logger9 = this.logger;
            Object[] objArr8 = new Object[2];
            if (str12 != null) {
                str5 = str12;
            } else {
                str5 = "null (broker defaults)";
            }
            objArr8[0] = str5;
            objArr8[1] = trustStore != null ? trustStore : str13;
            logger9.fine(CLASS_NAME, "getSSLContext", "12011", objArr8);
        }
        char[] trustStorePassword = getTrustStorePassword(str);
        if (this.logger != null) {
            Logger logger10 = this.logger;
            Object[] objArr9 = new Object[2];
            if (str12 != null) {
                str4 = str12;
            } else {
                str4 = "null (broker defaults)";
            }
            objArr9[0] = str4;
            objArr9[1] = trustStorePassword != null ? obfuscate(trustStorePassword) : str13;
            logger10.fine(CLASS_NAME, "getSSLContext", "12012", objArr9);
        }
        String trustStoreType = getTrustStoreType(str);
        if (trustStoreType == null) {
            trustStoreType = KeyStore.getDefaultType();
        }
        if (this.logger != null) {
            Logger logger11 = this.logger;
            Object[] objArr10 = new Object[2];
            if (str12 != null) {
                str3 = str12;
            } else {
                str3 = "null (broker defaults)";
            }
            objArr10[0] = str3;
            if (trustStoreType != null) {
                str13 = trustStoreType;
            }
            objArr10[1] = str13;
            logger11.fine(CLASS_NAME, "getSSLContext", "12013", objArr10);
        }
        String defaultAlgorithm2 = TrustManagerFactory.getDefaultAlgorithm();
        String trustStoreProvider = getTrustStoreProvider(str);
        String trustManager = getTrustManager(str);
        if (trustManager != null) {
            defaultAlgorithm2 = trustManager;
        }
        if (trustStore == null || trustStoreType == null || defaultAlgorithm2 == null) {
            trustManagerArr = null;
        } else {
            KeyStore instance2 = KeyStore.getInstance(trustStoreType);
            instance2.load(new FileInputStream(trustStore), trustStorePassword);
            if (trustStoreProvider != null) {
                trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm2, trustStoreProvider);
            } else {
                trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm2);
            }
            if (this.logger != null) {
                Logger logger12 = this.logger;
                Object[] objArr11 = new Object[2];
                if (str12 != null) {
                    str2 = str12;
                } else {
                    str2 = "null (broker defaults)";
                }
                objArr11[0] = str2;
                objArr11[1] = defaultAlgorithm2;
                logger12.fine(CLASS_NAME, "getSSLContext", "12017", objArr11);
                Logger logger13 = this.logger;
                Object[] objArr12 = new Object[2];
                if (str12 == null) {
                    str12 = "null (broker defaults)";
                }
                objArr12[0] = str12;
                objArr12[1] = trustManagerFactory.getProvider().getName();
                logger13.fine(CLASS_NAME, "getSSLContext", "12016", objArr12);
            }
            trustManagerFactory.init(instance2);
            trustManagerArr = trustManagerFactory.getTrustManagers();
        }
        sSLContext.init(keyManagerArr, trustManagerArr, null);
        return sSLContext;
    }

    public static boolean isSupportedOnJVM() throws LinkageError, ExceptionInInitializerError {
        try {
            Class.forName("javax.net.ssl.SSLServerSocketFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean keyValid(String str) {
        int i = 0;
        while (true) {
            String[] strArr = propertyKeys;
            if (i < strArr.length && !strArr[i].equals(str)) {
                i++;
            }
        }
        if (i < propertyKeys.length) {
            return true;
        }
        return false;
    }

    public static String obfuscate(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = toByte(cArr);
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            byte[] bArr2 = key;
            bArr[i] = (byte) ((b2 ^ bArr2[i % bArr2.length]) & 255);
        }
        return xorTag + new String(SimpleBase64Encoder.encode(bArr));
    }

    public static String packCipherSuites(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            stringBuffer.append(strArr[i]);
            if (i < strArr.length - 1) {
                stringBuffer.append(',');
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] toByte(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[(cArr.length * 2)];
        int i = 0;
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i + 1;
            bArr[i] = (byte) (cArr[i2] & 255);
            i = i3 + 1;
            bArr[i3] = (byte) ((cArr[i2] >> 8) & InvitationReply.EXPIRED);
        }
        return bArr;
    }

    public static char[] toChar(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[(bArr.length / 2)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            cArr[i2] = (char) ((bArr[i] & 255) + ((bArr[i3] & 255) << 8));
            i2++;
            i = i3 + 1;
        }
        return cArr;
    }

    public static String[] unpackCipherSuites(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = str.indexOf(44);
        int i = 0;
        while (indexOf > -1) {
            vector.add(str.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = str.indexOf(44, i);
        }
        vector.add(str.substring(i));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public SSLSocketFactory createSocketFactory(String str) throws MqttSecurityException {
        SSLContext sSLContext = getSSLContext(str);
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = getEnabledCipherSuites(str) != null ? getProperty(str, CIPHERSUITES, null) : "null (using platform-enabled cipher suites)";
            logger2.fine(CLASS_NAME, "createSocketFactory", "12020", objArr);
        }
        return sSLContext.getSocketFactory();
    }

    public boolean getClientAuthentication(String str) {
        String property = getProperty(str, CLIENTAUTH, null);
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        return false;
    }

    public Properties getConfiguration(String str) {
        Object obj;
        if (str == null) {
            obj = this.defaultProperties;
        } else {
            obj = this.configs.get(str);
        }
        return (Properties) obj;
    }

    public String[] getEnabledCipherSuites(String str) {
        return unpackCipherSuites(getProperty(str, CIPHERSUITES, null));
    }

    public String getJSSEProvider(String str) {
        return getProperty(str, JSSEPROVIDER, null);
    }

    public String getKeyManager(String str) {
        return getProperty(str, KEYSTOREMGR, SYSKEYMGRALGO);
    }

    public String getKeyStore(String str) {
        String propertyFromConfig = getPropertyFromConfig(str, KEYSTORE);
        if (propertyFromConfig != null) {
            return propertyFromConfig;
        }
        return System.getProperty(SYSKEYSTORE);
    }

    public char[] getKeyStorePassword(String str) {
        String property = getProperty(str, KEYSTOREPWD, SYSKEYSTOREPWD);
        if (property == null) {
            return null;
        }
        if (property.startsWith(xorTag)) {
            return deObfuscate(property);
        }
        return property.toCharArray();
    }

    public String getKeyStoreProvider(String str) {
        return getProperty(str, KEYSTOREPROVIDER, null);
    }

    public String getKeyStoreType(String str) {
        return getProperty(str, KEYSTORETYPE, SYSKEYSTORETYPE);
    }

    public String getSSLProtocol(String str) {
        return getProperty(str, SSLPROTOCOL, null);
    }

    public String getTrustManager(String str) {
        return getProperty(str, TRUSTSTOREMGR, SYSTRUSTMGRALGO);
    }

    public String getTrustStore(String str) {
        return getProperty(str, TRUSTSTORE, SYSTRUSTSTORE);
    }

    public char[] getTrustStorePassword(String str) {
        String property = getProperty(str, TRUSTSTOREPWD, SYSTRUSTSTOREPWD);
        if (property == null) {
            return null;
        }
        if (property.startsWith(xorTag)) {
            return deObfuscate(property);
        }
        return property.toCharArray();
    }

    public String getTrustStoreProvider(String str) {
        return getProperty(str, TRUSTSTOREPROVIDER, null);
    }

    public String getTrustStoreType(String str) {
        return getProperty(str, TRUSTSTORETYPE, null);
    }

    public void initialize(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        convertPassword(properties2);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public void merge(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = this.defaultProperties;
        if (str != null) {
            properties2 = (Properties) this.configs.get(str);
        }
        if (properties2 == null) {
            properties2 = new Properties();
        }
        convertPassword(properties);
        properties2.putAll(properties);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public boolean remove(String str) {
        if (str != null) {
            if (this.configs.remove(str) != null) {
                return true;
            }
        } else if (this.defaultProperties != null) {
            this.defaultProperties = null;
            return true;
        }
        return false;
    }

    public SSLSocketFactoryFactory(Logger logger2) {
        this();
        this.logger = logger2;
    }
}
