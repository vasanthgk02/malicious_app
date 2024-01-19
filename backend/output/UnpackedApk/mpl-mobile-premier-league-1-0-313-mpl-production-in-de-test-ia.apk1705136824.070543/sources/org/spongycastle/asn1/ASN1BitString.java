package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import sfs2x.client.entities.invitation.InvitationReply;

public abstract class ASN1BitString extends ASN1Primitive {
    public static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final byte[] data;
    public final int padBits;

    public ASN1BitString(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data cannot be null");
        } else if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        } else if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        } else {
            this.data = TypeUtilsKt.clone(bArr);
            this.padBits = i;
        }
    }

    public static byte[] derForm(byte[] bArr, int i) {
        byte[] clone = TypeUtilsKt.clone(bArr);
        if (i > 0) {
            int length = bArr.length - 1;
            clone[length] = (byte) ((InvitationReply.EXPIRED << i) & clone[length]);
        }
        return clone;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        boolean z = false;
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        ASN1BitString aSN1BitString = (ASN1BitString) aSN1Primitive;
        if (this.padBits == aSN1BitString.padBits && TypeUtilsKt.areEqual(getBytes(), aSN1BitString.getBytes())) {
            z = true;
        }
        return z;
    }

    public byte[] getBytes() {
        return derForm(this.data, this.padBits);
    }

    public int hashCode() {
        return this.padBits ^ TypeUtilsKt.hashCode(getBytes());
    }

    public ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    public ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
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
        } catch (IOException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Internal error encoding BitString: ");
            outline73.append(e2.getMessage());
            throw new ASN1ParsingException(outline73.toString(), e2);
        }
    }
}
