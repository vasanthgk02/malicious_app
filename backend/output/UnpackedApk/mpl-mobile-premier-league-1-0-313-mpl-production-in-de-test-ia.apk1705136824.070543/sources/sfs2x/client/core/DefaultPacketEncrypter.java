package sfs2x.client.core;

import in.juspay.hypersdk.security.EncryptionHelper;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.util.CryptoKey;

public class DefaultPacketEncrypter implements IPacketEncrypter {
    public final String ALGORITHM = EncryptionHelper.algorithm;
    public final String ALGORITHM_MODE = "AES/CBC/PKCS5PADDING";
    public final BitSwarmClient bitSwarm;

    public DefaultPacketEncrypter(BitSwarmClient bitSwarmClient) {
        this.bitSwarm = bitSwarmClient;
    }

    private byte[] execute(int i, byte[] bArr) throws Exception {
        CryptoKey cryptoKey = this.bitSwarm.getCryptoKey();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(cryptoKey.getInitVector());
        SecretKeySpec secretKeySpec = new SecretKeySpec(cryptoKey.getSecretKey(), EncryptionHelper.algorithm);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public byte[] decrypt(byte[] bArr) throws Exception {
        return execute(2, bArr);
    }

    public byte[] encrypt(byte[] bArr) throws Exception {
        return execute(1, bArr);
    }
}
