package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.util.io.Streams;
import sfs2x.client.entities.invitation.InvitationReply;

public class ASN1InputStream extends FilterInputStream {
    public final boolean lazyEvaluate;
    public final int limit;
    public final byte[][] tmpBuffers;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ASN1InputStream(InputStream inputStream) {
        // int findLimit = StreamUtil.findLimit(inputStream);
        super(inputStream);
        this.limit = findLimit;
        this.lazyEvaluate = false;
        this.tmpBuffers = new byte[11][];
    }

    public static ASN1Primitive createPrimitiveDERObject(int i, DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        ASN1Enumerated aSN1Enumerated;
        ASN1Primitive aSN1Primitive;
        if (i == 10) {
            byte[] buffer = getBuffer(definiteLengthInputStream, bArr);
            if (buffer.length > 1) {
                aSN1Enumerated = new ASN1Enumerated(TypeUtilsKt.clone(buffer));
            } else if (buffer.length != 0) {
                byte b2 = buffer[0] & 255;
                ASN1Enumerated[] aSN1EnumeratedArr = ASN1Enumerated.cache;
                if (b2 >= aSN1EnumeratedArr.length) {
                    aSN1Enumerated = new ASN1Enumerated(TypeUtilsKt.clone(buffer));
                } else {
                    ASN1Enumerated aSN1Enumerated2 = aSN1EnumeratedArr[b2];
                    if (aSN1Enumerated2 == null) {
                        aSN1Enumerated2 = new ASN1Enumerated(TypeUtilsKt.clone(buffer));
                        aSN1EnumeratedArr[b2] = aSN1Enumerated2;
                    }
                    aSN1Enumerated = aSN1Enumerated2;
                }
            } else {
                throw new IllegalArgumentException("ENUMERATED has zero length");
            }
            return aSN1Enumerated;
        } else if (i == 12) {
            return new DERUTF8String(definiteLengthInputStream.toByteArray());
        } else {
            if (i != 30) {
                switch (i) {
                    case 1:
                        return ASN1Boolean.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
                    case 2:
                        return new ASN1Integer(definiteLengthInputStream.toByteArray(), false);
                    case 3:
                        int i2 = definiteLengthInputStream._remaining;
                        if (i2 >= 1) {
                            int read = definiteLengthInputStream.read();
                            int i3 = i2 - 1;
                            byte[] bArr2 = new byte[i3];
                            if (i3 != 0) {
                                if (Streams.readFully(definiteLengthInputStream, bArr2, 0, i3) != i3) {
                                    throw new EOFException("EOF encountered in middle of BIT STRING");
                                } else if (read > 0 && read < 8) {
                                    int i4 = i3 - 1;
                                    if (bArr2[i4] != ((byte) (bArr2[i4] & (InvitationReply.EXPIRED << read)))) {
                                        aSN1Primitive = new DLBitString(bArr2, read);
                                        return aSN1Primitive;
                                    }
                                }
                            }
                            aSN1Primitive = new DERBitString(bArr2, read);
                            return aSN1Primitive;
                        }
                        throw new IllegalArgumentException("truncated BIT STRING detected");
                    case 4:
                        return new DEROctetString(definiteLengthInputStream.toByteArray());
                    case 5:
                        return DERNull.INSTANCE;
                    case 6:
                        return ASN1ObjectIdentifier.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
                    default:
                        switch (i) {
                            case 18:
                                return new DERNumericString(definiteLengthInputStream.toByteArray());
                            case 19:
                                return new DERPrintableString(definiteLengthInputStream.toByteArray());
                            case 20:
                                return new DERT61String(definiteLengthInputStream.toByteArray());
                            case 21:
                                return new DERVideotexString(definiteLengthInputStream.toByteArray());
                            case 22:
                                return new DERIA5String(definiteLengthInputStream.toByteArray());
                            case 23:
                                return new ASN1UTCTime(definiteLengthInputStream.toByteArray());
                            case 24:
                                return new ASN1GeneralizedTime(definiteLengthInputStream.toByteArray());
                            case 25:
                                return new DERGraphicString(definiteLengthInputStream.toByteArray());
                            case 26:
                                return new DERVisibleString(definiteLengthInputStream.toByteArray());
                            case 27:
                                return new DERGeneralString(definiteLengthInputStream.toByteArray());
                            case 28:
                                return new DERUniversalString(definiteLengthInputStream.toByteArray());
                            default:
                                throw new IOException(GeneratedOutlineSupport.outline42("unknown tag ", i, " encountered"));
                        }
                }
            } else {
                int i5 = definiteLengthInputStream._remaining / 2;
                char[] cArr = new char[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    int read2 = definiteLengthInputStream.read();
                    if (read2 < 0) {
                        break;
                    }
                    int read3 = definiteLengthInputStream.read();
                    if (read3 < 0) {
                        break;
                    }
                    cArr[i6] = (char) ((read2 << 8) | (read3 & InvitationReply.EXPIRED));
                }
                return new DERBMPString(cArr);
            }
        }
    }

    public static byte[] getBuffer(DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int i = definiteLengthInputStream._remaining;
        if (i >= bArr.length) {
            return definiteLengthInputStream.toByteArray();
        }
        byte[] bArr2 = bArr[i];
        if (bArr2 == null) {
            bArr2 = new byte[i];
            bArr[i] = bArr2;
        }
        Streams.readFully(definiteLengthInputStream, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static int readLength(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read > 127) {
                int i2 = read & 127;
                if (i2 <= 4) {
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < i2) {
                        int read2 = inputStream.read();
                        if (read2 >= 0) {
                            i3 = (i3 << 8) + read2;
                            i4++;
                        } else {
                            throw new EOFException("EOF found reading length");
                        }
                    }
                    if (i3 < 0) {
                        throw new IOException("corrupted stream - negative length found");
                    } else if (i3 < i) {
                        read = i3;
                    } else {
                        throw new IOException("corrupted stream - out of bounds length found");
                    }
                } else {
                    throw new IOException(GeneratedOutlineSupport.outline41("DER length more than 4 bytes: ", i2));
                }
            }
            return read;
        }
    }

    public static int readTagNumber(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i3 = (i3 | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i3 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    public ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream) definiteLengthInputStream);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.v.addElement(readObject);
        }
    }

    public ASN1Primitive buildObject(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i3);
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(z, i2, definiteLengthInputStream.toByteArray());
        }
        if ((i & 128) != 0) {
            return new ASN1StreamParser(definiteLengthInputStream).readTaggedObject(z, i2);
        }
        if (!z) {
            return createPrimitiveDERObject(i2, definiteLengthInputStream, this.tmpBuffers);
        }
        if (i2 == 4) {
            ASN1EncodableVector buildDEREncodableVector = buildDEREncodableVector(definiteLengthInputStream);
            int size = buildDEREncodableVector.size();
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
            for (int i4 = 0; i4 != size; i4++) {
                aSN1OctetStringArr[i4] = (ASN1OctetString) buildDEREncodableVector.get(i4);
            }
            return new BEROctetString(aSN1OctetStringArr);
        } else if (i2 == 8) {
            return new DERExternal(buildDEREncodableVector(definiteLengthInputStream));
        } else {
            if (i2 != 16) {
                if (i2 == 17) {
                    return DERFactory.createSet(buildDEREncodableVector(definiteLengthInputStream));
                }
                throw new IOException(GeneratedOutlineSupport.outline42("unknown tag ", i2, " encountered"));
            } else if (this.lazyEvaluate) {
                return new LazyEncodedSequence(definiteLengthInputStream.toByteArray());
            } else {
                return DERFactory.createSequence(buildDEREncodableVector(definiteLengthInputStream));
            }
        }
    }

    public ASN1Primitive readObject() throws IOException {
        int read = read();
        if (read > 0) {
            int readTagNumber = readTagNumber(this, read);
            boolean z = (read & 32) != 0;
            int readLength = readLength(this, this.limit);
            if (readLength >= 0) {
                try {
                    return buildObject(read, readTagNumber, readLength);
                } catch (IllegalArgumentException e2) {
                    throw new ASN1Exception("corrupted stream detected", e2);
                }
            } else if (z) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecific(readTagNumber, aSN1StreamParser.readVector());
                }
                if ((read & 128) != 0) {
                    return aSN1StreamParser.readTaggedObject(true, readTagNumber);
                }
                if (readTagNumber == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 8) {
                    try {
                        return new DERExternal(aSN1StreamParser.readVector());
                    } catch (IllegalArgumentException e3) {
                        throw new ASN1Exception(e3.getMessage(), e3);
                    }
                } else if (readTagNumber == 16) {
                    return new BERSequence(aSN1StreamParser.readVector());
                } else {
                    if (readTagNumber == 17) {
                        return new BERSet(aSN1StreamParser.readVector());
                    }
                    throw new IOException("unknown BER object encountered");
                }
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ASN1InputStream(byte[] r2) {
        /*
            r1 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r2)
            int r2 = r2.length
            r1.<init>(r0)
            r1.limit = r2
            r2 = 0
            r1.lazyEvaluate = r2
            r2 = 11
            byte[][] r2 = new byte[r2][]
            r1.tmpBuffers = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1InputStream.<init>(byte[]):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ASN1InputStream(byte[] r2, boolean r3) {
        /*
            r1 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r2)
            int r2 = r2.length
            r1.<init>(r0)
            r1.limit = r2
            r1.lazyEvaluate = r3
            r2 = 11
            byte[][] r2 = new byte[r2][]
            r1.tmpBuffers = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1InputStream.<init>(byte[], boolean):void");
    }
}
