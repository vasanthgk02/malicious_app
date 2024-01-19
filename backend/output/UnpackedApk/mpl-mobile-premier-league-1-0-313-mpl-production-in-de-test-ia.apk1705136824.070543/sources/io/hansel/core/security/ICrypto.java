package io.hansel.core.security;

public interface ICrypto {
    String aesDecrypt(String str);

    String aesEncrypt(String str);
}
