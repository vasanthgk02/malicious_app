package org.spongycastle.util.encoders;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;

public class Base64 {
    public static final Encoder encoder = new Base64Encoder();

    public static byte[] decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((bArr.length / 4) * 3);
        try {
            encoder.decode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new DecoderException(GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("unable to decode base64 data: ")), e2);
        }
    }
}
