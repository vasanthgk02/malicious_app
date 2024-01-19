package org.spongycastle.asn1.teletrust;

import com.paynimo.android.payment.util.Constant;
import io.sentry.SentryClient;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface TeleTrusTObjectIdentifiers {
    public static final ASN1ObjectIdentifier brainpoolP160r1;
    public static final ASN1ObjectIdentifier brainpoolP160t1;
    public static final ASN1ObjectIdentifier brainpoolP192r1;
    public static final ASN1ObjectIdentifier brainpoolP192t1;
    public static final ASN1ObjectIdentifier brainpoolP224r1;
    public static final ASN1ObjectIdentifier brainpoolP224t1;
    public static final ASN1ObjectIdentifier brainpoolP256r1;
    public static final ASN1ObjectIdentifier brainpoolP256t1;
    public static final ASN1ObjectIdentifier brainpoolP320r1;
    public static final ASN1ObjectIdentifier brainpoolP320t1;
    public static final ASN1ObjectIdentifier brainpoolP384r1;
    public static final ASN1ObjectIdentifier brainpoolP384t1;
    public static final ASN1ObjectIdentifier brainpoolP512r1;
    public static final ASN1ObjectIdentifier brainpoolP512t1;
    public static final ASN1ObjectIdentifier ecSign;
    public static final ASN1ObjectIdentifier ecc_brainpool;
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier teleTrusTAlgorithm;
    public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm;
    public static final ASN1ObjectIdentifier versionOne;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier((String) "1.3.36.3");
        teleTrusTAlgorithm = aSN1ObjectIdentifier;
        if (aSN1ObjectIdentifier != null) {
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "2.1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = teleTrusTAlgorithm;
            if (aSN1ObjectIdentifier2 != null) {
                new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2.2");
                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = teleTrusTAlgorithm;
                if (aSN1ObjectIdentifier3 != null) {
                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "2.3");
                    ASN1ObjectIdentifier aSN1ObjectIdentifier4 = teleTrusTAlgorithm;
                    if (aSN1ObjectIdentifier4 != null) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "3.1");
                        teleTrusTRSAsignatureAlgorithm = aSN1ObjectIdentifier5;
                        if (aSN1ObjectIdentifier5 != null) {
                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "2");
                            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = teleTrusTRSAsignatureAlgorithm;
                            if (aSN1ObjectIdentifier6 != null) {
                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3");
                                ASN1ObjectIdentifier aSN1ObjectIdentifier7 = teleTrusTRSAsignatureAlgorithm;
                                if (aSN1ObjectIdentifier7 != null) {
                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "4");
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier8 = teleTrusTAlgorithm;
                                    if (aSN1ObjectIdentifier8 != null) {
                                        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "3.2");
                                        ecSign = aSN1ObjectIdentifier9;
                                        if (aSN1ObjectIdentifier9 != null) {
                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, "1");
                                            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = ecSign;
                                            if (aSN1ObjectIdentifier10 != null) {
                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, "2");
                                                ASN1ObjectIdentifier aSN1ObjectIdentifier11 = teleTrusTAlgorithm;
                                                if (aSN1ObjectIdentifier11 != null) {
                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "3.2.8");
                                                    ecc_brainpool = aSN1ObjectIdentifier12;
                                                    if (aSN1ObjectIdentifier12 != null) {
                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "1");
                                                        ellipticCurve = aSN1ObjectIdentifier13;
                                                        if (aSN1ObjectIdentifier13 != null) {
                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "1");
                                                            versionOne = aSN1ObjectIdentifier14;
                                                            if (aSN1ObjectIdentifier14 != null) {
                                                                brainpoolP160r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier14, "1");
                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier15 = versionOne;
                                                                if (aSN1ObjectIdentifier15 != null) {
                                                                    brainpoolP160t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier15, "2");
                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier16 = versionOne;
                                                                    if (aSN1ObjectIdentifier16 != null) {
                                                                        brainpoolP192r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier16, "3");
                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = versionOne;
                                                                        if (aSN1ObjectIdentifier17 != null) {
                                                                            brainpoolP192t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier17, "4");
                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = versionOne;
                                                                            if (aSN1ObjectIdentifier18 != null) {
                                                                                brainpoolP224r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier18, "5");
                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier19 = versionOne;
                                                                                if (aSN1ObjectIdentifier19 != null) {
                                                                                    brainpoolP224t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier19, "6");
                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier20 = versionOne;
                                                                                    if (aSN1ObjectIdentifier20 != null) {
                                                                                        brainpoolP256r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier20, SentryClient.SENTRY_PROTOCOL_VERSION);
                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = versionOne;
                                                                                        if (aSN1ObjectIdentifier21 != null) {
                                                                                            brainpoolP256t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier21, "8");
                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = versionOne;
                                                                                            if (aSN1ObjectIdentifier22 != null) {
                                                                                                brainpoolP320r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier22, "9");
                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier23 = versionOne;
                                                                                                if (aSN1ObjectIdentifier23 != null) {
                                                                                                    brainpoolP320t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier23, Constant.BANKCODE_ICICI);
                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier24 = versionOne;
                                                                                                    if (aSN1ObjectIdentifier24 != null) {
                                                                                                        brainpoolP384r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier24, "11");
                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = versionOne;
                                                                                                        if (aSN1ObjectIdentifier25 != null) {
                                                                                                            brainpoolP384t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier25, "12");
                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = versionOne;
                                                                                                            if (aSN1ObjectIdentifier26 != null) {
                                                                                                                brainpoolP512r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier26, "13");
                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier27 = versionOne;
                                                                                                                if (aSN1ObjectIdentifier27 != null) {
                                                                                                                    brainpoolP512t1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier27, "14");
                                                                                                                    return;
                                                                                                                }
                                                                                                                throw null;
                                                                                                            }
                                                                                                            throw null;
                                                                                                        }
                                                                                                        throw null;
                                                                                                    }
                                                                                                    throw null;
                                                                                                }
                                                                                                throw null;
                                                                                            }
                                                                                            throw null;
                                                                                        }
                                                                                        throw null;
                                                                                    }
                                                                                    throw null;
                                                                                }
                                                                                throw null;
                                                                            }
                                                                            throw null;
                                                                        }
                                                                        throw null;
                                                                    }
                                                                    throw null;
                                                                }
                                                                throw null;
                                                            }
                                                            throw null;
                                                        }
                                                        throw null;
                                                    }
                                                    throw null;
                                                }
                                                throw null;
                                            }
                                            throw null;
                                        }
                                        throw null;
                                    }
                                    throw null;
                                }
                                throw null;
                            }
                            throw null;
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }
}
