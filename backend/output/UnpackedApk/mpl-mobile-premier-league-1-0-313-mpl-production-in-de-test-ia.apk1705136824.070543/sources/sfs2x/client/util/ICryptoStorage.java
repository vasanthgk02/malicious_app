package sfs2x.client.util;

public interface ICryptoStorage {
    String getHttpHost();

    int getHttpPort();

    CryptoKey getKey();

    void setKey(CryptoKey cryptoKey);
}
