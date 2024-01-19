package org.spongycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.SignaturePacket;
import org.spongycastle.bcpg.SignatureSubpacket;
import org.spongycastle.bcpg.TrustPacket;
import org.spongycastle.openpgp.operator.PGPContentVerifier;

public class PGPSignature {
    public byte lastb;
    public OutputStream sigOut;
    public SignaturePacket sigPck;
    public int signatureType;
    public PGPContentVerifier verifier;

    public PGPSignature(BCPGInputStream bCPGInputStream) throws IOException, PGPException {
        SignaturePacket signaturePacket = (SignaturePacket) bCPGInputStream.readPacket();
        this.sigPck = signaturePacket;
        this.signatureType = signaturePacket.signatureType;
    }

    public final void byteUpdate(byte b2) {
        try {
            this.sigOut.write(b2);
        } catch (IOException e2) {
            throw new PGPRuntimeOperationException(e2.getMessage(), e2);
        }
    }

    public byte[] getSignatureTrailer() {
        SignaturePacket signaturePacket = this.sigPck;
        int i = signaturePacket.version;
        if (i == 3 || i == 2) {
            long j = signaturePacket.creationTime / 1000;
            return new byte[]{(byte) signaturePacket.signatureType, (byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)};
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write((byte) signaturePacket.version);
            byteArrayOutputStream.write((byte) signaturePacket.signatureType);
            byteArrayOutputStream.write((byte) signaturePacket.keyAlgorithm);
            byteArrayOutputStream.write((byte) signaturePacket.hashAlgorithm);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            SignatureSubpacket[] signatureSubpacketArr = signaturePacket.hashedData;
            for (int i2 = 0; i2 != signatureSubpacketArr.length; i2++) {
                signatureSubpacketArr[i2].encode(byteArrayOutputStream2);
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream.write((byte) (byteArray.length >> 8));
            byteArrayOutputStream.write((byte) byteArray.length);
            byteArrayOutputStream.write(byteArray);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.write((byte) signaturePacket.version);
            byteArrayOutputStream.write(-1);
            byteArrayOutputStream.write((byte) (byteArray2.length >> 24));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 16));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 8));
            byteArrayOutputStream.write((byte) byteArray2.length);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException("exception generating trailer: " + e2);
        }
    }

    public PGPSignature(SignaturePacket signaturePacket, TrustPacket trustPacket) throws PGPException {
        this.sigPck = signaturePacket;
        this.signatureType = signaturePacket.signatureType;
    }
}
