package com.smartfoxserver.v2.protocol.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public final class DefaultPacketCompressor implements IPacketCompressor {
    public final int MAX_SIZE_FOR_COMPRESSION;
    public final int compressionBufferSize;
    public final int maxPacketSize;

    public DefaultPacketCompressor() {
        this.MAX_SIZE_FOR_COMPRESSION = 1000000;
        this.compressionBufferSize = 512;
        this.maxPacketSize = Integer.MAX_VALUE;
    }

    public byte[] compress(byte[] bArr) throws Exception {
        if (bArr.length > 1000000) {
            return bArr;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2 = new byte[512];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] uncompress(byte[] bArr) throws Exception {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2 = new byte[512];
        int i = 0;
        while (!inflater.finished()) {
            try {
                int inflate = inflater.inflate(bArr2);
                if (inflate < 1) {
                    if (inflater.needsInput()) {
                        throw new IOException("Bad Packet compression format! Packet dropped.");
                    }
                }
                i += inflate;
                if (i <= this.maxPacketSize) {
                    byteArrayOutputStream.write(bArr2, 0, inflate);
                } else {
                    throw new IOException("Uncompressed size exceeds current packet size limit. Packet dropped.");
                }
            } finally {
                byteArrayOutputStream.close();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public DefaultPacketCompressor(int i) {
        this.MAX_SIZE_FOR_COMPRESSION = 1000000;
        this.compressionBufferSize = 512;
        this.maxPacketSize = i;
    }
}
