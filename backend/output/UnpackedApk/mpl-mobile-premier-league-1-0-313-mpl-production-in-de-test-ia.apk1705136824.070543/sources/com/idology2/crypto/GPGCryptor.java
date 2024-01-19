package com.idology2.crypto;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketHandshake;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.bcpg.BCPGOutputStream;
import org.spongycastle.bcpg.MPInteger;
import org.spongycastle.bcpg.SignaturePacket;
import org.spongycastle.jcajce.util.NamedJcaJceHelper;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.openpgp.PGPException;
import org.spongycastle.openpgp.PGPObjectFactory;
import org.spongycastle.openpgp.PGPPublicKey;
import org.spongycastle.openpgp.PGPPublicKeyRing;
import org.spongycastle.openpgp.PGPRuntimeOperationException;
import org.spongycastle.openpgp.PGPSignature;
import org.spongycastle.openpgp.PGPSignatureList;
import org.spongycastle.openpgp.PGPUtil;
import org.spongycastle.openpgp.operator.PGPContentVerifier;
import org.spongycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider.JcaPGPContentVerifierBuilder;
import org.spongycastle.openpgp.operator.jcajce.JcaPGPContentVerifierBuilderProvider.JcaPGPContentVerifierBuilder.AnonymousClass1;
import org.spongycastle.openpgp.operator.jcajce.OperatorHelper;
import org.spongycastle.openpgp.operator.jcajce.SignatureOutputStream;
import org.spongycastle.util.BigIntegers;

public class GPGCryptor {
    public PGPPublicKey getPublicKey(InputStream inputStream) throws IOException, PGPException {
        InputStream decoderStream = PGPUtil.getDecoderStream(inputStream);
        BcKeyFingerprintCalculator bcKeyFingerprintCalculator = new BcKeyFingerprintCalculator();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        PGPObjectFactory pGPObjectFactory = new PGPObjectFactory(decoderStream, bcKeyFingerprintCalculator);
        while (true) {
            Object nextObject = pGPObjectFactory.nextObject();
            if (nextObject == null) {
                PGPPublicKey pGPPublicKey = null;
                Iterator it = hashMap.values().iterator();
                while (pGPPublicKey == null && it.hasNext()) {
                    Iterator it2 = Collections.unmodifiableList(((PGPPublicKeyRing) it.next()).keys).iterator();
                    while (pGPPublicKey == null && it2.hasNext()) {
                        PGPPublicKey pGPPublicKey2 = (PGPPublicKey) it2.next();
                        int i = pGPPublicKey2.publicPk.algorithm;
                        boolean z = true;
                        if (!(i == 1 || i == 2 || i == 16 || i == 20 || i == 18)) {
                            z = false;
                        }
                        if (z) {
                            pGPPublicKey = pGPPublicKey2;
                        }
                    }
                }
                if (pGPPublicKey != null) {
                    return pGPPublicKey;
                }
                throw new IllegalArgumentException("Can't find encryption key in key ring.");
            } else if (nextObject instanceof PGPPublicKeyRing) {
                PGPPublicKeyRing pGPPublicKeyRing = (PGPPublicKeyRing) nextObject;
                Long l = new Long(((PGPPublicKey) pGPPublicKeyRing.keys.get(0)).keyID);
                hashMap.put(l, pGPPublicKeyRing);
                arrayList.add(l);
            } else {
                throw new PGPException(nextObject.getClass().getName() + " found where PGPPublicKeyRing expected");
            }
        }
    }

    public boolean verify(InputStream inputStream, InputStream inputStream2, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        String str;
        String str2;
        byte[] bArr;
        Security.addProvider(new BouncyCastleProvider());
        PGPSignature pGPSignature = ((PGPSignatureList) new PGPObjectFactory(PGPUtil.getDecoderStream(inputStream2), new BcKeyFingerprintCalculator()).nextObject()).sigs[0];
        JcaPGPContentVerifierBuilderProvider jcaPGPContentVerifierBuilderProvider = new JcaPGPContentVerifierBuilderProvider();
        jcaPGPContentVerifierBuilderProvider.helper = new OperatorHelper(new NamedJcaJceHelper("SC"));
        jcaPGPContentVerifierBuilderProvider.keyConverter.helper = new OperatorHelper(new NamedJcaJceHelper("SC"));
        SignaturePacket signaturePacket = pGPSignature.sigPck;
        JcaPGPContentVerifierBuilder jcaPGPContentVerifierBuilder = new JcaPGPContentVerifierBuilder(signaturePacket.keyAlgorithm, signaturePacket.hashAlgorithm);
        OperatorHelper operatorHelper = JcaPGPContentVerifierBuilderProvider.this.helper;
        int i = jcaPGPContentVerifierBuilder.keyAlgorithm;
        int i2 = jcaPGPContentVerifierBuilder.hashAlgorithm;
        if (operatorHelper != null) {
            if (i == 1 || i == 3) {
                str = "RSA";
            } else {
                if (i != 16) {
                    if (i == 17) {
                        str = "DSA";
                    } else if (i == 19) {
                        str = "ECDSA";
                    } else if (i != 20) {
                        throw new PGPException(GeneratedOutlineSupport.outline41("unknown algorithm tag in signature:", i));
                    }
                }
                str = "ElGamal";
            }
            StringBuilder sb = new StringBuilder();
            switch (i2) {
                case 1:
                    str2 = "MD5";
                    break;
                case 2:
                    str2 = WebSocketHandshake.SHA1_PROTOCOL;
                    break;
                case 3:
                    str2 = "RIPEMD160";
                    break;
                case 5:
                    str2 = "MD2";
                    break;
                case 6:
                    str2 = "TIGER";
                    break;
                case 8:
                    str2 = "SHA256";
                    break;
                case 9:
                    str2 = "SHA384";
                    break;
                case 10:
                    str2 = "SHA512";
                    break;
                case 11:
                    str2 = "SHA224";
                    break;
                default:
                    throw new PGPException(GeneratedOutlineSupport.outline41("unknown hash algorithm tag in getDigestName: ", i2));
            }
            try {
                Signature createSignature = operatorHelper.helper.createSignature(GeneratedOutlineSupport.outline63(sb, str2, "with", str));
                try {
                    createSignature.initVerify(JcaPGPContentVerifierBuilderProvider.this.keyConverter.getPublicKey(pGPPublicKey));
                    AnonymousClass1 r2 = new PGPContentVerifier(jcaPGPContentVerifierBuilder, pGPPublicKey, createSignature) {
                        public final /* synthetic */ Signature val$signature;

                        {
                            this.val$signature = r3;
                        }
                    };
                    pGPSignature.verifier = r2;
                    pGPSignature.lastb = 0;
                    pGPSignature.sigOut = new SignatureOutputStream(r2.val$signature);
                    while (true) {
                        int read = inputStream.read();
                        if (read >= 0) {
                            byte b2 = (byte) read;
                            if (pGPSignature.signatureType == 1) {
                                if (b2 == 13) {
                                    pGPSignature.byteUpdate(13);
                                    pGPSignature.byteUpdate(10);
                                } else if (b2 != 10) {
                                    pGPSignature.byteUpdate(b2);
                                } else if (pGPSignature.lastb != 13) {
                                    pGPSignature.byteUpdate(13);
                                    pGPSignature.byteUpdate(10);
                                }
                                pGPSignature.lastb = b2;
                            } else {
                                pGPSignature.byteUpdate(b2);
                            }
                        } else {
                            try {
                                pGPSignature.sigOut.write(pGPSignature.getSignatureTrailer());
                                pGPSignature.sigOut.close();
                                PGPContentVerifier pGPContentVerifier = pGPSignature.verifier;
                                SignaturePacket signaturePacket2 = pGPSignature.sigPck;
                                MPInteger[] mPIntegerArr = signaturePacket2.signature;
                                if (mPIntegerArr == null) {
                                    byte[] bArr2 = signaturePacket2.signatureEncoding;
                                    if (bArr2 == null) {
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
                                        int i3 = 0;
                                        while (true) {
                                            MPInteger[] mPIntegerArr2 = signaturePacket2.signature;
                                            if (i3 != mPIntegerArr2.length) {
                                                try {
                                                    mPIntegerArr2[i3].encode(bCPGOutputStream);
                                                    i3++;
                                                } catch (IOException e2) {
                                                    throw new RuntimeException("internal error: " + e2);
                                                }
                                            } else {
                                                bArr = byteArrayOutputStream.toByteArray();
                                            }
                                        }
                                    } else {
                                        bArr = TypeUtilsKt.clone(bArr2);
                                    }
                                } else if (mPIntegerArr.length == 1) {
                                    bArr = BigIntegers.asUnsignedByteArray(mPIntegerArr[0].value);
                                } else {
                                    try {
                                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                                        aSN1EncodableVector.v.addElement(new ASN1Integer(mPIntegerArr[0].value));
                                        aSN1EncodableVector.v.addElement(new ASN1Integer(mPIntegerArr[1].value));
                                        bArr = new DERSequence(aSN1EncodableVector).getEncoded();
                                    } catch (IOException e3) {
                                        throw new PGPException("exception encoding DSA sig.", e3);
                                    }
                                }
                                AnonymousClass1 r10 = (AnonymousClass1) pGPContentVerifier;
                                if (r10 != null) {
                                    try {
                                        if (r10.val$signature.verify(bArr)) {
                                            return true;
                                        }
                                        return false;
                                    } catch (SignatureException e4) {
                                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("unable to verify signature: ");
                                        outline73.append(e4.getMessage());
                                        throw new PGPRuntimeOperationException(outline73.toString(), e4);
                                    }
                                } else {
                                    throw null;
                                }
                            } catch (IOException e5) {
                                throw new PGPException(e5.getMessage(), e5);
                            }
                        }
                    }
                } catch (InvalidKeyException e6) {
                    throw new PGPException("invalid key.", e6);
                }
            } catch (GeneralSecurityException e7) {
                throw new PGPException(GeneratedOutlineSupport.outline67(e7, GeneratedOutlineSupport.outline73("cannot create signature: ")), e7);
            }
        } else {
            throw null;
        }
    }
}
