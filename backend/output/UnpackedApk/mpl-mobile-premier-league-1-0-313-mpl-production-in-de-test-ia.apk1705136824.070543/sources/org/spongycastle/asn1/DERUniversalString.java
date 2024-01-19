package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class DERUniversalString extends ASN1Primitive {
    public static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] string;

    public DERUniversalString(byte[] bArr) {
        this.string = bArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUniversalString)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.string, ((DERUniversalString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(28, this.string);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.string);
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(MqttTopic.MULTI_LEVEL_WILDCARD);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i = 0; i != byteArray.length; i++) {
                stringBuffer.append(table[(byteArray[i] >>> 4) & 15]);
                stringBuffer.append(table[byteArray[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new RuntimeException("internal error encoding BitString");
        }
    }
}
