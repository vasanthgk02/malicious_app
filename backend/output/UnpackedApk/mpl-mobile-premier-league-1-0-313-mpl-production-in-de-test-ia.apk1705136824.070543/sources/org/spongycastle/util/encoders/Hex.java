package org.spongycastle.util.encoders;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;

public class Hex {
    public static final Encoder encoder = new HexEncoder();

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new DecoderException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("exception decoding Hex string: ")), e2);
        }
    }

    public static byte[] encode(byte[] bArr) {
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.encode(bArr, 0, length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new EncoderException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("exception encoding Hex string: ")), e2);
        }
    }
}
