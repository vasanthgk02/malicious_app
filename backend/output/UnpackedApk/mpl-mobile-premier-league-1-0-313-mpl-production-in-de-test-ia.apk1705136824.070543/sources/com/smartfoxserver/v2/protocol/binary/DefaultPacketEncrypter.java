package com.smartfoxserver.v2.protocol.binary;

import com.smartfoxserver.bitswarm.io.IPacketEncrypter;
import com.smartfoxserver.bitswarm.sessions.ISession;
import in.juspay.hypersdk.security.EncryptionHelper;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class DefaultPacketEncrypter implements IPacketEncrypter {
    public final String ALGORITHM = EncryptionHelper.algorithm;
    public final String ALGORITHM_MODE = "AES/CBC/PKCS5PADDING";

    private byte[] execute(int i, ISession iSession, byte[] bArr) throws Exception {
        CryptoKey cryptoKey = (CryptoKey) iSession.getCryptoKey();
        if (cryptoKey != null) {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(cryptoKey.getInitVector());
            SecretKeySpec secretKeySpec = new SecretKeySpec(cryptoKey.getSecretKey(), EncryptionHelper.algorithm);
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(i, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        }
        throw new IllegalStateException("Session does not support encryption: " + iSession);
    }

    public byte[] decrypt(ISession iSession, byte[] bArr) throws Exception {
        return execute(2, iSession, bArr);
    }

    public byte[] encrypt(ISession iSession, byte[] bArr) throws Exception {
        return execute(1, iSession, bArr);
    }
}
