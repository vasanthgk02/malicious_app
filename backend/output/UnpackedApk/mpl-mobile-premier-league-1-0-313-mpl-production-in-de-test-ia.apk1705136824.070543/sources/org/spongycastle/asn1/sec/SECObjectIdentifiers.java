package org.spongycastle.asn1.sec;

import com.paynimo.android.payment.util.Constant;
import io.sentry.SentryClient;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

public interface SECObjectIdentifiers {
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier secg_scheme;
    public static final ASN1ObjectIdentifier secp112r1;
    public static final ASN1ObjectIdentifier secp112r2;
    public static final ASN1ObjectIdentifier secp128r1;
    public static final ASN1ObjectIdentifier secp128r2;
    public static final ASN1ObjectIdentifier secp160k1;
    public static final ASN1ObjectIdentifier secp160r1;
    public static final ASN1ObjectIdentifier secp160r2;
    public static final ASN1ObjectIdentifier secp192k1;
    public static final ASN1ObjectIdentifier secp192r1 = X9ObjectIdentifiers.prime192v1;
    public static final ASN1ObjectIdentifier secp224k1;
    public static final ASN1ObjectIdentifier secp224r1;
    public static final ASN1ObjectIdentifier secp256k1;
    public static final ASN1ObjectIdentifier secp256r1 = X9ObjectIdentifiers.prime256v1;
    public static final ASN1ObjectIdentifier secp384r1;
    public static final ASN1ObjectIdentifier secp521r1;
    public static final ASN1ObjectIdentifier sect113r1;
    public static final ASN1ObjectIdentifier sect113r2;
    public static final ASN1ObjectIdentifier sect131r1;
    public static final ASN1ObjectIdentifier sect131r2;
    public static final ASN1ObjectIdentifier sect163k1;
    public static final ASN1ObjectIdentifier sect163r1;
    public static final ASN1ObjectIdentifier sect163r2;
    public static final ASN1ObjectIdentifier sect193r1;
    public static final ASN1ObjectIdentifier sect193r2;
    public static final ASN1ObjectIdentifier sect233k1;
    public static final ASN1ObjectIdentifier sect233r1;
    public static final ASN1ObjectIdentifier sect239k1;
    public static final ASN1ObjectIdentifier sect283k1;
    public static final ASN1ObjectIdentifier sect283r1;
    public static final ASN1ObjectIdentifier sect409k1;
    public static final ASN1ObjectIdentifier sect409r1;
    public static final ASN1ObjectIdentifier sect571k1;
    public static final ASN1ObjectIdentifier sect571r1;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier((String) "1.3.132.0");
        ellipticCurve = aSN1ObjectIdentifier;
        if (aSN1ObjectIdentifier != null) {
            sect163k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "1");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = ellipticCurve;
            if (aSN1ObjectIdentifier2 != null) {
                sect163r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "2");
                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = ellipticCurve;
                if (aSN1ObjectIdentifier3 != null) {
                    sect239k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "3");
                    ASN1ObjectIdentifier aSN1ObjectIdentifier4 = ellipticCurve;
                    if (aSN1ObjectIdentifier4 != null) {
                        sect113r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "4");
                        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = ellipticCurve;
                        if (aSN1ObjectIdentifier5 != null) {
                            sect113r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "5");
                            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = ellipticCurve;
                            if (aSN1ObjectIdentifier6 != null) {
                                secp112r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "6");
                                ASN1ObjectIdentifier aSN1ObjectIdentifier7 = ellipticCurve;
                                if (aSN1ObjectIdentifier7 != null) {
                                    secp112r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, SentryClient.SENTRY_PROTOCOL_VERSION);
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier8 = ellipticCurve;
                                    if (aSN1ObjectIdentifier8 != null) {
                                        secp160r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "8");
                                        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = ellipticCurve;
                                        if (aSN1ObjectIdentifier9 != null) {
                                            secp160k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, "9");
                                            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = ellipticCurve;
                                            if (aSN1ObjectIdentifier10 != null) {
                                                secp256k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, Constant.BANKCODE_ICICI);
                                                ASN1ObjectIdentifier aSN1ObjectIdentifier11 = ellipticCurve;
                                                if (aSN1ObjectIdentifier11 != null) {
                                                    sect163r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "15");
                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier12 = ellipticCurve;
                                                    if (aSN1ObjectIdentifier12 != null) {
                                                        sect283k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "16");
                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = ellipticCurve;
                                                        if (aSN1ObjectIdentifier13 != null) {
                                                            sect283r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "17");
                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = ellipticCurve;
                                                            if (aSN1ObjectIdentifier14 != null) {
                                                                sect131r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier14, "22");
                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier15 = ellipticCurve;
                                                                if (aSN1ObjectIdentifier15 != null) {
                                                                    sect131r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier15, "23");
                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier16 = ellipticCurve;
                                                                    if (aSN1ObjectIdentifier16 != null) {
                                                                        sect193r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier16, "24");
                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = ellipticCurve;
                                                                        if (aSN1ObjectIdentifier17 != null) {
                                                                            sect193r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier17, "25");
                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = ellipticCurve;
                                                                            if (aSN1ObjectIdentifier18 != null) {
                                                                                sect233k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier18, "26");
                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier19 = ellipticCurve;
                                                                                if (aSN1ObjectIdentifier19 != null) {
                                                                                    sect233r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier19, "27");
                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier20 = ellipticCurve;
                                                                                    if (aSN1ObjectIdentifier20 != null) {
                                                                                        secp128r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier20, "28");
                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = ellipticCurve;
                                                                                        if (aSN1ObjectIdentifier21 != null) {
                                                                                            secp128r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier21, "29");
                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = ellipticCurve;
                                                                                            if (aSN1ObjectIdentifier22 != null) {
                                                                                                secp160r2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier22, "30");
                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier23 = ellipticCurve;
                                                                                                if (aSN1ObjectIdentifier23 != null) {
                                                                                                    secp192k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier23, "31");
                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier24 = ellipticCurve;
                                                                                                    if (aSN1ObjectIdentifier24 != null) {
                                                                                                        secp224k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier24, "32");
                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = ellipticCurve;
                                                                                                        if (aSN1ObjectIdentifier25 != null) {
                                                                                                            secp224r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier25, "33");
                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = ellipticCurve;
                                                                                                            if (aSN1ObjectIdentifier26 != null) {
                                                                                                                secp384r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier26, "34");
                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier27 = ellipticCurve;
                                                                                                                if (aSN1ObjectIdentifier27 != null) {
                                                                                                                    secp521r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier27, "35");
                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier28 = ellipticCurve;
                                                                                                                    if (aSN1ObjectIdentifier28 != null) {
                                                                                                                        sect409k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier28, "36");
                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = ellipticCurve;
                                                                                                                        if (aSN1ObjectIdentifier29 != null) {
                                                                                                                            sect409r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier29, "37");
                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = ellipticCurve;
                                                                                                                            if (aSN1ObjectIdentifier30 != null) {
                                                                                                                                sect571k1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier30, "38");
                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier31 = ellipticCurve;
                                                                                                                                if (aSN1ObjectIdentifier31 != null) {
                                                                                                                                    sect571r1 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier31, "39");
                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier32 = new ASN1ObjectIdentifier((String) "1.3.132.1");
                                                                                                                                    secg_scheme = aSN1ObjectIdentifier32;
                                                                                                                                    if (aSN1ObjectIdentifier32 != null) {
                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier32, "11.0");
                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = secg_scheme;
                                                                                                                                        if (aSN1ObjectIdentifier33 != null) {
                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier33, "11.1");
                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier34 = secg_scheme;
                                                                                                                                            if (aSN1ObjectIdentifier34 != null) {
                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier34, "11.2");
                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier35 = secg_scheme;
                                                                                                                                                if (aSN1ObjectIdentifier35 != null) {
                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier35, "11.3");
                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier36 = secg_scheme;
                                                                                                                                                    if (aSN1ObjectIdentifier36 != null) {
                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier36, "14.0");
                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = secg_scheme;
                                                                                                                                                        if (aSN1ObjectIdentifier37 != null) {
                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier37, "14.1");
                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier38 = secg_scheme;
                                                                                                                                                            if (aSN1ObjectIdentifier38 != null) {
                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier38, "14.2");
                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier39 = secg_scheme;
                                                                                                                                                                if (aSN1ObjectIdentifier39 != null) {
                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier39, "14.3");
                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier40 = secg_scheme;
                                                                                                                                                                    if (aSN1ObjectIdentifier40 != null) {
                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier40, "15.0");
                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = secg_scheme;
                                                                                                                                                                        if (aSN1ObjectIdentifier41 != null) {
                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier41, "15.1");
                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier42 = secg_scheme;
                                                                                                                                                                            if (aSN1ObjectIdentifier42 != null) {
                                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier42, "15.2");
                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier43 = secg_scheme;
                                                                                                                                                                                if (aSN1ObjectIdentifier43 != null) {
                                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier43, "15.3");
                                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier44 = secg_scheme;
                                                                                                                                                                                    if (aSN1ObjectIdentifier44 != null) {
                                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier44, "16.0");
                                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = secg_scheme;
                                                                                                                                                                                        if (aSN1ObjectIdentifier45 != null) {
                                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier45, "16.1");
                                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier46 = secg_scheme;
                                                                                                                                                                                            if (aSN1ObjectIdentifier46 != null) {
                                                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier46, "16.2");
                                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier47 = secg_scheme;
                                                                                                                                                                                                if (aSN1ObjectIdentifier47 != null) {
                                                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier47, "16.3");
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
