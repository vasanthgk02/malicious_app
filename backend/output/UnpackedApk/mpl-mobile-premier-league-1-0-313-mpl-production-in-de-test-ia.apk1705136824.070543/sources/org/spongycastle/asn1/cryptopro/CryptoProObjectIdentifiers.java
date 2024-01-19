package org.spongycastle.asn1.cryptopro;

import com.paynimo.android.payment.util.Constant;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface CryptoProObjectIdentifiers {
    public static final ASN1ObjectIdentifier GOST_id;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_A;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_B;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_C;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_XchA;
    public static final ASN1ObjectIdentifier gostR3410_2001_CryptoPro_XchB;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier((String) "1.2.643.2.2");
        GOST_id = aSN1ObjectIdentifier;
        if (aSN1ObjectIdentifier != null) {
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier, "9");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = GOST_id;
            if (aSN1ObjectIdentifier2 != null) {
                new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, Constant.BANKCODE_ICICI);
                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = GOST_id;
                if (aSN1ObjectIdentifier3 != null) {
                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, "21");
                    ASN1ObjectIdentifier aSN1ObjectIdentifier4 = GOST_id;
                    if (aSN1ObjectIdentifier4 != null) {
                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "31.1");
                        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = GOST_id;
                        if (aSN1ObjectIdentifier5 != null) {
                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "31.2");
                            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = GOST_id;
                            if (aSN1ObjectIdentifier6 != null) {
                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "31.3");
                                ASN1ObjectIdentifier aSN1ObjectIdentifier7 = GOST_id;
                                if (aSN1ObjectIdentifier7 != null) {
                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "31.4");
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier8 = GOST_id;
                                    if (aSN1ObjectIdentifier8 != null) {
                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, "20");
                                        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = GOST_id;
                                        if (aSN1ObjectIdentifier9 != null) {
                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, "19");
                                            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = GOST_id;
                                            if (aSN1ObjectIdentifier10 != null) {
                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, "4");
                                                ASN1ObjectIdentifier aSN1ObjectIdentifier11 = GOST_id;
                                                if (aSN1ObjectIdentifier11 != null) {
                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, "3");
                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier12 = GOST_id;
                                                    if (aSN1ObjectIdentifier12 != null) {
                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "30.1");
                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = GOST_id;
                                                        if (aSN1ObjectIdentifier13 != null) {
                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, "32.2");
                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = GOST_id;
                                                            if (aSN1ObjectIdentifier14 != null) {
                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier14, "32.3");
                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier15 = GOST_id;
                                                                if (aSN1ObjectIdentifier15 != null) {
                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier15, "32.4");
                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier16 = GOST_id;
                                                                    if (aSN1ObjectIdentifier16 != null) {
                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier16, "32.5");
                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = GOST_id;
                                                                        if (aSN1ObjectIdentifier17 != null) {
                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier17, "33.1");
                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = GOST_id;
                                                                            if (aSN1ObjectIdentifier18 != null) {
                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier18, "33.2");
                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier19 = GOST_id;
                                                                                if (aSN1ObjectIdentifier19 != null) {
                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier19, "33.3");
                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier20 = GOST_id;
                                                                                    if (aSN1ObjectIdentifier20 != null) {
                                                                                        gostR3410_2001_CryptoPro_A = new ASN1ObjectIdentifier(aSN1ObjectIdentifier20, "35.1");
                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = GOST_id;
                                                                                        if (aSN1ObjectIdentifier21 != null) {
                                                                                            gostR3410_2001_CryptoPro_B = new ASN1ObjectIdentifier(aSN1ObjectIdentifier21, "35.2");
                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = GOST_id;
                                                                                            if (aSN1ObjectIdentifier22 != null) {
                                                                                                gostR3410_2001_CryptoPro_C = new ASN1ObjectIdentifier(aSN1ObjectIdentifier22, "35.3");
                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier23 = GOST_id;
                                                                                                if (aSN1ObjectIdentifier23 != null) {
                                                                                                    gostR3410_2001_CryptoPro_XchA = new ASN1ObjectIdentifier(aSN1ObjectIdentifier23, "36.0");
                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier24 = GOST_id;
                                                                                                    if (aSN1ObjectIdentifier24 != null) {
                                                                                                        gostR3410_2001_CryptoPro_XchB = new ASN1ObjectIdentifier(aSN1ObjectIdentifier24, "36.1");
                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = GOST_id;
                                                                                                        if (aSN1ObjectIdentifier25 != null) {
                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier25, "36.0");
                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = GOST_id;
                                                                                                            if (aSN1ObjectIdentifier26 != null) {
                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier26, "36.1");
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
}
