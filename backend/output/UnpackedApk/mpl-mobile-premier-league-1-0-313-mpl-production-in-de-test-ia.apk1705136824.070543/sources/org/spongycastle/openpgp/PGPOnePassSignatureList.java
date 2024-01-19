package org.spongycastle.openpgp;

import java.util.Iterator;
import org.spongycastle.util.Arrays$Iterator;

public class PGPOnePassSignatureList implements Object<PGPOnePassSignature> {
    public PGPOnePassSignature[] sigs;

    public PGPOnePassSignatureList(PGPOnePassSignature[] pGPOnePassSignatureArr) {
        PGPOnePassSignature[] pGPOnePassSignatureArr2 = new PGPOnePassSignature[pGPOnePassSignatureArr.length];
        this.sigs = pGPOnePassSignatureArr2;
        System.arraycopy(pGPOnePassSignatureArr, 0, pGPOnePassSignatureArr2, 0, pGPOnePassSignatureArr.length);
    }

    public Iterator<PGPOnePassSignature> iterator() {
        return new Arrays$Iterator(this.sigs);
    }
}
