package org.spongycastle.math.ec.endo;

import org.spongycastle.math.ec.ECCurve;

public class GLVTypeBEndomorphism {
    public GLVTypeBEndomorphism(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        eCCurve.fromBigInteger(gLVTypeBParameters.beta);
    }
}
