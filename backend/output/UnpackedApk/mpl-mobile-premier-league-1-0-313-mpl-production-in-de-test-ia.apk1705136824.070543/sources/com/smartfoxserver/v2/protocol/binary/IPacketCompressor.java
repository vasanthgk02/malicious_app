package com.smartfoxserver.v2.protocol.binary;

public interface IPacketCompressor {
    byte[] compress(byte[] bArr) throws Exception;

    byte[] uncompress(byte[] bArr) throws Exception;
}
