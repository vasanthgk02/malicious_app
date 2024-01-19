package org.spongycastle.asn1.nist;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.sec.SECObjectIdentifiers;

public class NISTNamedCurves {
    public static final Hashtable names = new Hashtable();
    public static final Hashtable objIds = new Hashtable();

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = SECObjectIdentifiers.sect163r2;
        objIds.put("B-163".toUpperCase(), aSN1ObjectIdentifier);
        names.put(aSN1ObjectIdentifier, "B-163");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = SECObjectIdentifiers.sect233r1;
        objIds.put("B-233".toUpperCase(), aSN1ObjectIdentifier2);
        names.put(aSN1ObjectIdentifier2, "B-233");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = SECObjectIdentifiers.sect283r1;
        objIds.put("B-283".toUpperCase(), aSN1ObjectIdentifier3);
        names.put(aSN1ObjectIdentifier3, "B-283");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = SECObjectIdentifiers.sect409r1;
        objIds.put("B-409".toUpperCase(), aSN1ObjectIdentifier4);
        names.put(aSN1ObjectIdentifier4, "B-409");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = SECObjectIdentifiers.sect571r1;
        objIds.put("B-571".toUpperCase(), aSN1ObjectIdentifier5);
        names.put(aSN1ObjectIdentifier5, "B-571");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = SECObjectIdentifiers.sect163k1;
        objIds.put("K-163".toUpperCase(), aSN1ObjectIdentifier6);
        names.put(aSN1ObjectIdentifier6, "K-163");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = SECObjectIdentifiers.sect233k1;
        objIds.put("K-233".toUpperCase(), aSN1ObjectIdentifier7);
        names.put(aSN1ObjectIdentifier7, "K-233");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = SECObjectIdentifiers.sect283k1;
        objIds.put("K-283".toUpperCase(), aSN1ObjectIdentifier8);
        names.put(aSN1ObjectIdentifier8, "K-283");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = SECObjectIdentifiers.sect409k1;
        objIds.put("K-409".toUpperCase(), aSN1ObjectIdentifier9);
        names.put(aSN1ObjectIdentifier9, "K-409");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = SECObjectIdentifiers.sect571k1;
        objIds.put("K-571".toUpperCase(), aSN1ObjectIdentifier10);
        names.put(aSN1ObjectIdentifier10, "K-571");
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = SECObjectIdentifiers.secp192r1;
        objIds.put("P-192".toUpperCase(), aSN1ObjectIdentifier11);
        names.put(aSN1ObjectIdentifier11, "P-192");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = SECObjectIdentifiers.secp224r1;
        objIds.put("P-224".toUpperCase(), aSN1ObjectIdentifier12);
        names.put(aSN1ObjectIdentifier12, "P-224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = SECObjectIdentifiers.secp256r1;
        objIds.put("P-256".toUpperCase(), aSN1ObjectIdentifier13);
        names.put(aSN1ObjectIdentifier13, "P-256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = SECObjectIdentifiers.secp384r1;
        objIds.put("P-384".toUpperCase(), aSN1ObjectIdentifier14);
        names.put(aSN1ObjectIdentifier14, "P-384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = SECObjectIdentifiers.secp521r1;
        objIds.put("P-521".toUpperCase(), aSN1ObjectIdentifier15);
        names.put(aSN1ObjectIdentifier15, "P-521");
    }
}
