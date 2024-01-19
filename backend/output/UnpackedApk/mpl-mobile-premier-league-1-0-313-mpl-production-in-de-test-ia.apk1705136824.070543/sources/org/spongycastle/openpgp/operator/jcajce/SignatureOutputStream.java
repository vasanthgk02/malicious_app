package org.spongycastle.openpgp.operator.jcajce;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureOutputStream extends OutputStream {
    public Signature sig;

    public SignatureOutputStream(Signature signature) {
        this.sig = signature;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.sig.update(bArr, i, i2);
        } catch (SignatureException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("signature update caused exception: ");
            outline73.append(e2.getMessage());
            throw new IOException(outline73.toString());
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.sig.update(bArr);
        } catch (SignatureException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("signature update caused exception: ");
            outline73.append(e2.getMessage());
            throw new IOException(outline73.toString());
        }
    }

    public void write(int i) throws IOException {
        try {
            this.sig.update((byte) i);
        } catch (SignatureException e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("signature update caused exception: ");
            outline73.append(e2.getMessage());
            throw new IOException(outline73.toString());
        }
    }
}
