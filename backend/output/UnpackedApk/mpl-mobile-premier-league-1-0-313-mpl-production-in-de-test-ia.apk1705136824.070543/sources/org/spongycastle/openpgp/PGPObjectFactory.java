package org.spongycastle.openpgp;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.spongycastle.bcpg.BCPGInputStream;
import org.spongycastle.bcpg.PublicKeyPacket;
import org.spongycastle.openpgp.operator.KeyFingerPrintCalculator;

public class PGPObjectFactory implements Iterable {
    public KeyFingerPrintCalculator fingerPrintCalculator;

    /* renamed from: in  reason: collision with root package name */
    public BCPGInputStream f6256in;

    public PGPObjectFactory(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator) {
        this.f6256in = new BCPGInputStream(inputStream);
        this.fingerPrintCalculator = keyFingerPrintCalculator;
    }

    public Iterator iterator() {
        return new Iterator() {
            public Object obj = getObject();

            public final Object getObject() {
                try {
                    return PGPObjectFactory.this.nextObject();
                } catch (IOException e2) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Iterator failed to get next object: ");
                    outline73.append(e2.getMessage());
                    throw new PGPRuntimeOperationException(outline73.toString(), e2);
                }
            }

            public boolean hasNext() {
                return this.obj != null;
            }

            public Object next() {
                Object obj2 = this.obj;
                this.obj = getObject();
                return obj2;
            }

            public void remove() {
                throw new UnsupportedOperationException("Cannot remove element from factory.");
            }
        };
    }

    public Object nextObject() throws IOException {
        int nextPacketTag = this.f6256in.nextPacketTag();
        if (nextPacketTag == -1) {
            return null;
        }
        if (nextPacketTag == 8) {
            return new PGPCompressedData(this.f6256in);
        }
        if (nextPacketTag == 14) {
            try {
                BCPGInputStream bCPGInputStream = this.f6256in;
                return new PGPPublicKey((PublicKeyPacket) bCPGInputStream.readPacket(), PGPKeyRing.readOptionalTrustPacket(bCPGInputStream), PGPKeyRing.readSignaturesAndTrust(bCPGInputStream), this.fingerPrintCalculator);
            } catch (PGPException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("processing error: ");
                outline73.append(e2.getMessage());
                throw new IOException(outline73.toString());
            }
        } else if (nextPacketTag == 10) {
            return new PGPMarker(this.f6256in);
        } else {
            if (nextPacketTag == 11) {
                return new PGPLiteralData(this.f6256in);
            }
            switch (nextPacketTag) {
                case 1:
                case 3:
                    return new PGPEncryptedDataList(this.f6256in);
                case 2:
                    ArrayList arrayList = new ArrayList();
                    while (this.f6256in.nextPacketTag() == 2) {
                        try {
                            arrayList.add(new PGPSignature(this.f6256in));
                        } catch (PGPException e3) {
                            throw new IOException("can't create signature object: " + e3);
                        }
                    }
                    return new PGPSignatureList((PGPSignature[]) arrayList.toArray(new PGPSignature[arrayList.size()]));
                case 4:
                    ArrayList arrayList2 = new ArrayList();
                    while (this.f6256in.nextPacketTag() == 4) {
                        try {
                            arrayList2.add(new PGPOnePassSignature(this.f6256in));
                        } catch (PGPException e4) {
                            throw new IOException("can't create one pass signature object: " + e4);
                        }
                    }
                    return new PGPOnePassSignatureList((PGPOnePassSignature[]) arrayList2.toArray(new PGPOnePassSignature[arrayList2.size()]));
                case 5:
                    try {
                        return new PGPSecretKeyRing(this.f6256in, this.fingerPrintCalculator);
                    } catch (PGPException e5) {
                        throw new IOException("can't create secret key object: " + e5);
                    }
                case 6:
                    return new PGPPublicKeyRing(this.f6256in, this.fingerPrintCalculator);
                default:
                    switch (nextPacketTag) {
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                            return this.f6256in.readPacket();
                        default:
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("unknown object in stream: ");
                            outline732.append(this.f6256in.nextPacketTag());
                            throw new IOException(outline732.toString());
                    }
            }
        }
    }
}
