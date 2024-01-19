package org.spongycastle.bcpg;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import org.apache.fontbox.ttf.GlyfDescript;
import org.spongycastle.bcpg.sig.IssuerKeyID;
import org.spongycastle.bcpg.sig.SignatureCreationTime;

public class SignaturePacket extends ContainedPacket {
    public long creationTime;
    public byte[] fingerPrint;
    public int hashAlgorithm;
    public SignatureSubpacket[] hashedData;
    public int keyAlgorithm;
    public long keyID;
    public MPInteger[] signature;
    public byte[] signatureEncoding;
    public int signatureType;
    public SignatureSubpacket[] unhashedData;
    public int version;

    public SignaturePacket(BCPGInputStream bCPGInputStream) throws IOException {
        int read = bCPGInputStream.read();
        this.version = read;
        char c2 = 0;
        char c3 = 1;
        if (read == 3 || read == 2) {
            bCPGInputStream.read();
            this.signatureType = bCPGInputStream.read();
            this.creationTime = ((((long) bCPGInputStream.read()) << 24) | ((long) (bCPGInputStream.read() << 16)) | ((long) (bCPGInputStream.read() << 8)) | ((long) bCPGInputStream.read())) * 1000;
            long read2 = this.keyID | (((long) bCPGInputStream.read()) << 56);
            this.keyID = read2;
            long read3 = read2 | (((long) bCPGInputStream.read()) << 48);
            this.keyID = read3;
            long read4 = read3 | (((long) bCPGInputStream.read()) << 40);
            this.keyID = read4;
            long read5 = read4 | (((long) bCPGInputStream.read()) << 32);
            this.keyID = read5;
            long read6 = read5 | (((long) bCPGInputStream.read()) << 24);
            this.keyID = read6;
            long read7 = read6 | (((long) bCPGInputStream.read()) << 16);
            this.keyID = read7;
            long read8 = read7 | (((long) bCPGInputStream.read()) << 8);
            this.keyID = read8;
            this.keyID = read8 | ((long) bCPGInputStream.read());
            this.keyAlgorithm = bCPGInputStream.read();
            this.hashAlgorithm = bCPGInputStream.read();
        } else if (read == 4) {
            this.signatureType = bCPGInputStream.read();
            this.keyAlgorithm = bCPGInputStream.read();
            this.hashAlgorithm = bCPGInputStream.read();
            byte[] bArr = new byte[((bCPGInputStream.read() << 8) | bCPGInputStream.read())];
            bCPGInputStream.readFully(bArr);
            SignatureSubpacketInputStream signatureSubpacketInputStream = new SignatureSubpacketInputStream(new ByteArrayInputStream(bArr));
            Vector vector = new Vector();
            while (true) {
                SignatureSubpacket readPacket = signatureSubpacketInputStream.readPacket();
                if (readPacket == null) {
                    break;
                }
                vector.addElement(readPacket);
            }
            this.hashedData = new SignatureSubpacket[vector.size()];
            int i = 0;
            while (i != this.hashedData.length) {
                SignatureSubpacket signatureSubpacket = (SignatureSubpacket) vector.elementAt(i);
                if (signatureSubpacket instanceof IssuerKeyID) {
                    this.keyID = ((IssuerKeyID) signatureSubpacket).getKeyID();
                } else if (signatureSubpacket instanceof SignatureCreationTime) {
                    byte[] bArr2 = ((SignatureCreationTime) signatureSubpacket).data;
                    this.creationTime = new Date((((long) ((bArr2[c3] & 255) << GlyfDescript.X_DUAL)) | (((long) (bArr2[c2] & 255)) << 24) | ((long) ((bArr2[2] & 255) << 8)) | ((long) (bArr2[3] & 255))) * 1000).getTime();
                }
                this.hashedData[i] = signatureSubpacket;
                i++;
                c2 = 0;
                c3 = 1;
            }
            byte[] bArr3 = new byte[((bCPGInputStream.read() << 8) | bCPGInputStream.read())];
            bCPGInputStream.readFully(bArr3);
            SignatureSubpacketInputStream signatureSubpacketInputStream2 = new SignatureSubpacketInputStream(new ByteArrayInputStream(bArr3));
            vector.removeAllElements();
            while (true) {
                SignatureSubpacket readPacket2 = signatureSubpacketInputStream2.readPacket();
                if (readPacket2 == null) {
                    break;
                }
                vector.addElement(readPacket2);
            }
            this.unhashedData = new SignatureSubpacket[vector.size()];
            for (int i2 = 0; i2 != this.unhashedData.length; i2++) {
                SignatureSubpacket signatureSubpacket2 = (SignatureSubpacket) vector.elementAt(i2);
                if (signatureSubpacket2 instanceof IssuerKeyID) {
                    this.keyID = ((IssuerKeyID) signatureSubpacket2).getKeyID();
                }
                this.unhashedData[i2] = signatureSubpacket2;
            }
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("unsupported version: ");
            outline73.append(this.version);
            throw new RuntimeException(outline73.toString());
        }
        byte[] bArr4 = new byte[2];
        this.fingerPrint = bArr4;
        bCPGInputStream.readFully(bArr4);
        int i3 = this.keyAlgorithm;
        if (i3 == 1 || i3 == 3) {
            MPInteger mPInteger = new MPInteger(bCPGInputStream);
            MPInteger[] mPIntegerArr = new MPInteger[1];
            this.signature = mPIntegerArr;
            mPIntegerArr[0] = mPInteger;
            return;
        }
        if (i3 != 16) {
            if (i3 == 17) {
                MPInteger mPInteger2 = new MPInteger(bCPGInputStream);
                MPInteger mPInteger3 = new MPInteger(bCPGInputStream);
                MPInteger[] mPIntegerArr2 = new MPInteger[2];
                this.signature = mPIntegerArr2;
                mPIntegerArr2[0] = mPInteger2;
                mPIntegerArr2[1] = mPInteger3;
                return;
            } else if (i3 == 19) {
                MPInteger mPInteger4 = new MPInteger(bCPGInputStream);
                MPInteger mPInteger5 = new MPInteger(bCPGInputStream);
                MPInteger[] mPIntegerArr3 = new MPInteger[2];
                this.signature = mPIntegerArr3;
                mPIntegerArr3[0] = mPInteger4;
                mPIntegerArr3[1] = mPInteger5;
                return;
            } else if (i3 != 20) {
                if (i3 < 100 || i3 > 110) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("unknown signature key algorithm: ");
                    outline732.append(this.keyAlgorithm);
                    throw new IOException(outline732.toString());
                }
                this.signature = null;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read9 = bCPGInputStream.read();
                    if (read9 >= 0) {
                        byteArrayOutputStream.write(read9);
                    } else {
                        this.signatureEncoding = byteArrayOutputStream.toByteArray();
                        return;
                    }
                }
            }
        }
        MPInteger mPInteger6 = new MPInteger(bCPGInputStream);
        MPInteger mPInteger7 = new MPInteger(bCPGInputStream);
        MPInteger mPInteger8 = new MPInteger(bCPGInputStream);
        MPInteger[] mPIntegerArr4 = new MPInteger[3];
        this.signature = mPIntegerArr4;
        mPIntegerArr4[0] = mPInteger6;
        mPIntegerArr4[1] = mPInteger7;
        mPIntegerArr4[2] = mPInteger8;
    }
}
