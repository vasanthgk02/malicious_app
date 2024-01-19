package org.spongycastle.openpgp;

import java.util.Iterator;
import org.spongycastle.util.Arrays$Iterator;

public class PGPSignatureList implements Object<PGPSignature> {
    public PGPSignature[] sigs;

    public PGPSignatureList(PGPSignature[] pGPSignatureArr) {
        PGPSignature[] pGPSignatureArr2 = new PGPSignature[pGPSignatureArr.length];
        this.sigs = pGPSignatureArr2;
        System.arraycopy(pGPSignatureArr, 0, pGPSignatureArr2, 0, pGPSignatureArr.length);
    }

    public Iterator<PGPSignature> iterator() {
        return new Arrays$Iterator(this.sigs);
    }
}
