package org.spongycastle.asn1.anssi;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.math.ec.ECCurve.Fp;
import org.spongycastle.util.encoders.Hex;

public class ANSSINamedCurves {
    public static X9ECParametersHolder FRP256v1 = new X9ECParametersHolder() {
        public X9ECParameters createParameters() {
            BigInteger access$000 = ANSSINamedCurves.access$000("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger access$0002 = ANSSINamedCurves.access$000("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger access$0003 = ANSSINamedCurves.access$000("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger access$0004 = ANSSINamedCurves.access$000("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger valueOf = BigInteger.valueOf(1);
            Fp fp = new Fp(access$000, access$0002, access$0003, access$0004, valueOf);
            X9ECParameters x9ECParameters = new X9ECParameters(fp, new X9ECPoint(fp, Hex.decode("04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB")), access$0004, valueOf, null);
            return x9ECParameters;
        }
    };
    public static final Hashtable curves = new Hashtable();
    public static final Hashtable names = new Hashtable();
    public static final Hashtable objIds = new Hashtable();

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = ANSSIObjectIdentifiers.FRP256v1;
        X9ECParametersHolder x9ECParametersHolder = FRP256v1;
        objIds.put("FRP256v1".toLowerCase(), aSN1ObjectIdentifier);
        names.put(aSN1ObjectIdentifier, "FRP256v1");
        curves.put(aSN1ObjectIdentifier, x9ECParametersHolder);
    }

    public static BigInteger access$000(String str) {
        return new BigInteger(1, Hex.decode(str));
    }
}
