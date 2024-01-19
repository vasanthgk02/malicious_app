package org.spongycastle.asn1.x9;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECCurve;

public class X9ECPoint extends ASN1Object {
    public final ASN1OctetString encoding;

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.encoding = new DEROctetString(TypeUtilsKt.clone(bArr));
    }

    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
