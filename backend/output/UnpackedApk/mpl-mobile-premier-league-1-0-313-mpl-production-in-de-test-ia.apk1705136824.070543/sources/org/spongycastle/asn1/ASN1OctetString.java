package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.spongycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    public byte[] string;

    public ASN1OctetString(byte[] bArr) {
        if (bArr != null) {
            this.string = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.string, ((ASN1OctetString) aSN1Primitive).string);
    }

    public ASN1Primitive getLoadedObject() {
        return this;
    }

    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(getOctets());
    }

    public ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    public ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(MqttTopic.MULTI_LEVEL_WILDCARD);
        outline73.append(new String(Hex.encode(this.string)));
        return outline73.toString();
    }
}
