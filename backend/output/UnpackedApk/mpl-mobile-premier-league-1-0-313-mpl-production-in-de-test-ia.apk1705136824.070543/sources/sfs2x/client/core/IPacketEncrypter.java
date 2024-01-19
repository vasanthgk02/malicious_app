package sfs2x.client.core;

public interface IPacketEncrypter {
    byte[] decrypt(byte[] bArr) throws Exception;

    byte[] encrypt(byte[] bArr) throws Exception;
}
