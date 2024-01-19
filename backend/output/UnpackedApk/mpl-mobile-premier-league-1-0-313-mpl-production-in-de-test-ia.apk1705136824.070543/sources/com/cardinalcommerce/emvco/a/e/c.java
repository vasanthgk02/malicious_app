package com.cardinalcommerce.emvco.a.e;

import android.os.AsyncTask;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEObject;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.Payload;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.DirectDecrypter;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.util.Base64URL;
import com.cardinalcommerce.emvco.events.ProtocolErrorEvent;
import com.cardinalcommerce.emvco.events.RuntimeErrorEvent;
import com.cardinalcommerce.shared.cs.d.a;
import com.cardinalcommerce.shared.cs.e.b;
import com.cardinalcommerce.shared.cs.e.e;
import com.cardinalcommerce.shared.cs.e.i;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.h;
import com.cardinalcommerce.shared.models.ErrorMessage;
import java.text.ParseException;
import java.util.Arrays;
import javax.crypto.SecretKey;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.cardinalcommerce.emvco.a.d.a f2060a;

    /* renamed from: b  reason: collision with root package name */
    public char[] f2061b;

    /* renamed from: c  reason: collision with root package name */
    public SecretKey f2062c;

    /* renamed from: e  reason: collision with root package name */
    public b f2063e = b.a();

    /* renamed from: f  reason: collision with root package name */
    public final char[] f2064f;
    public final char[] g;
    public final char[] h;
    public com.cardinalcommerce.shared.cs.e.a i;
    public char[] j;
    public com.cardinalcommerce.emvco.a.g.a k = com.cardinalcommerce.emvco.a.g.a.a();

    /* renamed from: com.cardinalcommerce.emvco.a.e.c$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2065a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001e */
        static {
            /*
                com.cardinalcommerce.shared.cs.b.a[] r0 = com.cardinalcommerce.shared.cs.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2065a = r0
                r1 = 1
                r2 = 4
                com.cardinalcommerce.shared.cs.b.a r3 = com.cardinalcommerce.shared.cs.b.a.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 3
                int[] r4 = f2065a     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.cardinalcommerce.shared.cs.b.a r5 = com.cardinalcommerce.shared.cs.b.a.IO_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r4 = f2065a     // Catch:{ NoSuchFieldError -> 0x001e }
                com.cardinalcommerce.shared.cs.b.a r5 = com.cardinalcommerce.shared.cs.b.a.PROTOCOL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x001e }
                r5 = 0
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                int[] r3 = f2065a     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.cardinalcommerce.shared.cs.b.a r4 = com.cardinalcommerce.shared.cs.b.a.MALFORMED_URL_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x0024 }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                int[] r1 = f2065a     // Catch:{ NoSuchFieldError -> 0x002b }
                com.cardinalcommerce.shared.cs.b.a r2 = com.cardinalcommerce.shared.cs.b.a.SOCKET_TIMEOUT_EXCEPTION     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 5
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.emvco.a.e.c.AnonymousClass2.<clinit>():void");
        }
    }

    public c(com.cardinalcommerce.emvco.a.d.a aVar, com.cardinalcommerce.shared.cs.e.a aVar2) {
        this.i = aVar2;
        if (this.f2063e != null) {
            this.f2060a = aVar;
            throw null;
        }
        throw null;
    }

    public final ErrorMessage a(e eVar) {
        return new ErrorMessage(eVar.i, eVar.f2097a, eVar.f2099c, eVar.f2100d);
    }

    public void a(String str, int i2) {
        this.k.b(String.valueOf(i2), str);
        e("ACS not reachable");
        this.k.a("EMVCoTransaction", "Challenge Task finished");
        b();
    }

    public final void b() {
        com.cardinalcommerce.shared.cs.e.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        if (aVar != null) {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    h.c(a.this.g);
                    h.c(a.this.k);
                    h.c(a.this.m);
                    h.c(a.this.o);
                    h.c(a.this.s);
                    h.c(a.this.t);
                    h.c(a.this.u);
                }
            });
            return;
        }
        throw null;
    }

    public final void b(e eVar) {
        char[] cArr = this.f2061b;
        if (cArr != null && cArr.length > 0) {
            new e(eVar, new String(this.f2061b)).execute(new Void[0]);
        }
    }

    public final void b(ErrorMessage errorMessage) {
        this.f2060a.a("ProtocolError", new ProtocolErrorEvent(new String(this.f2064f), errorMessage));
    }

    public final void d(String str) {
        if (this.f2063e != null) {
            e eVar = new e(null);
            eVar.f2097a = "101";
            eVar.f2099c = str;
            eVar.f2100d = "CRes";
            eVar.i = new String(this.g);
            eVar.j = new String(this.h);
            eVar.h = new String(this.f2064f);
            b(eVar);
            b(a(eVar));
            return;
        }
        throw null;
    }

    public final void e(String str) {
        if (this.f2063e != null) {
            new String(null);
            new String(this.g);
            new String(this.h);
            new String(this.f2064f);
            this.f2060a.a("RunTimeError", new RuntimeErrorEvent("101", str));
            return;
        }
        throw null;
    }

    public void onPreExecute() {
        super.onPreExecute();
        if (h.a(this.j)) {
            return;
        }
        if (Arrays.equals(this.j, ThreeDSStrings.CHALLENGE_CANCEL_CHAR) || Arrays.equals(this.j, ThreeDSStrings.CHALLENGE_CANCEL_ERROR)) {
            this.f2060a.a("CancelTimeout", null);
        }
    }

    public final void b(b bVar, String str) {
        if (this.f2063e != null) {
            e eVar = new e(null);
            eVar.f2097a = "301";
            eVar.f2099c = "Transaction ID received is not valid for the receiving component.";
            eVar.f2100d = str;
            eVar.a(bVar);
            b(eVar);
            b(a(eVar));
            return;
        }
        throw null;
    }

    public void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar) {
        int i2 = AnonymousClass2.f2065a[aVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.k.b(String.valueOf(12101), GeneratedOutlineSupport.outline38(exc, GeneratedOutlineSupport.outline73("Error 101 Created: Message is not CRes \n")));
            e("Invalid Formatted Message");
        } else if (i2 == 3 || i2 == 4 || i2 == 5) {
            if (this.f2063e != null) {
                e eVar = new e(null);
                eVar.f2097a = "402";
                eVar.f2099c = "Transaction Timed Out";
                eVar.f2100d = "For example, a slowly processing back-end system.";
                eVar.i = new String(this.g);
                eVar.j = new String(this.h);
                eVar.h = new String(this.f2064f);
                b(eVar);
                ErrorMessage a2 = a(eVar);
                this.f2060a.a("RunTimeError", new RuntimeErrorEvent(a2.f2229b, a2.f2230c));
            } else {
                throw null;
            }
        }
        this.k.a("EMVCoTransaction", "Challenge Task finished");
        b();
    }

    public final void b(String str) {
        Base64URL[] base64URLArr;
        char c2;
        Payload payload;
        String str2;
        String str3 = str;
        if (!str3.replaceAll("[\\s|\\u00A0]+", "").contains("\"messageType\":\"Erro\"")) {
            SecretKey secretKey = this.f2062c;
            String trim = str.trim();
            int indexOf = trim.indexOf(".");
            if (indexOf != -1) {
                int i2 = indexOf + 1;
                int indexOf2 = trim.indexOf(".", i2);
                if (indexOf2 != -1) {
                    int i3 = indexOf2 + 1;
                    int indexOf3 = trim.indexOf(".", i3);
                    if (indexOf3 == -1) {
                        base64URLArr = new Base64URL[]{new Base64URL(trim.substring(0, indexOf)), new Base64URL(trim.substring(i2, indexOf2)), new Base64URL(trim.substring(i3))};
                        c2 = 4;
                    } else {
                        int i4 = indexOf3 + 1;
                        int indexOf4 = trim.indexOf(".", i4);
                        if (indexOf4 == -1) {
                            throw new ParseException("Invalid serialized JWE object: Missing fourth delimiter", 0);
                        } else if (indexOf4 == -1 || trim.indexOf(".", indexOf4 + 1) == -1) {
                            Base64URL base64URL = new Base64URL(trim.substring(indexOf4 + 1));
                            c2 = 4;
                            base64URLArr = new Base64URL[]{new Base64URL(trim.substring(0, indexOf)), new Base64URL(trim.substring(i2, indexOf2)), new Base64URL(trim.substring(i3, indexOf3)), new Base64URL(trim.substring(i4, indexOf4)), base64URL};
                        } else {
                            throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Too many part delimiters", 0);
                        }
                    }
                    if (base64URLArr.length == 5) {
                        JWEObject jWEObject = new JWEObject(base64URLArr[0], base64URLArr[1], base64URLArr[2], base64URLArr[3], base64URLArr[c2]);
                        DirectDecrypter directDecrypter = new DirectDecrypter(Arrays.copyOfRange(secretKey.getEncoded(), 16, 32));
                        synchronized (jWEObject) {
                            if (jWEObject.f1965f == JWEObject.a.ENCRYPTED) {
                                try {
                                    payload = new Payload(directDecrypter.a(jWEObject.f1960a, jWEObject.f1961b, jWEObject.f1962c, jWEObject.f1963d, jWEObject.f1964e));
                                    jWEObject.f2003a = payload;
                                    jWEObject.f1965f = JWEObject.a.DECRYPTED;
                                } catch (JOSEException e2) {
                                    throw e2;
                                } catch (Exception e3) {
                                    throw new JOSEException(e3.getMessage(), e3);
                                }
                            } else {
                                throw new IllegalStateException("The JWE object must be in an encrypted state");
                            }
                        }
                        b bVar = new b(payload.toString());
                        if (!bVar.s.equals("CRes")) {
                            this.k.b(String.valueOf(12101), "Error 101 Created: Message Description Invalid");
                            d("Message is not CRes");
                        } else if (!k.a(bVar).f2109a) {
                            this.k.b(String.valueOf(12201), "Error 201 Created: Required data element missing");
                            i a2 = k.a(bVar);
                            if (this.f2063e != null) {
                                e eVar = new e(null);
                                eVar.f2097a = "201";
                                eVar.f2099c = "A message element required as defined in Table A.1 is missing from the message.";
                                eVar.f2100d = a2.f2110b;
                                eVar.a(bVar);
                                b(eVar);
                                b(a(eVar));
                                return;
                            }
                            throw null;
                        } else if (!ThreeDSStrings.supportedMessageVersions.contains(bVar.t)) {
                            this.k.b(String.valueOf(12102), "Error 102 Created: Invalid Message Version");
                            if (this.f2063e != null) {
                                e eVar2 = new e(null);
                                eVar2.f2097a = "102";
                                eVar2.f2099c = "Message Version Number received is not valid for the receiving component.";
                                if (this.f2063e != null) {
                                    eVar2.f2100d = new String(null);
                                    eVar2.a(bVar);
                                    b(eVar2);
                                    b(a(eVar2));
                                    return;
                                }
                                throw null;
                            }
                            throw null;
                        } else if (bVar.f2086b) {
                            this.k.b(String.valueOf(12202), "Error 202 Created: SDK is Critical");
                            if (this.f2063e != null) {
                                e eVar3 = new e(null);
                                eVar3.f2097a = "202";
                                eVar3.f2099c = "Critical message extension not recognised.";
                                eVar3.f2100d = bVar.f2087c;
                                eVar3.a(bVar);
                                b(eVar3);
                                b(a(eVar3));
                                return;
                            }
                            throw null;
                        } else {
                            i iVar = bVar.f2085a;
                            if (iVar.f2109a) {
                                if (!bVar.f2088d.equals(new String(this.g))) {
                                    this.k.b(String.valueOf(12301), "Error 301 Created: Invalid ThreeDSServerTransID");
                                    str2 = "ThreeDSServerTransID";
                                } else if (!bVar.f2089e.equals(new String(this.h))) {
                                    this.k.b(String.valueOf(12301), "Error 301 Created: Invalid AcsTransId");
                                    str2 = "AcsTransId";
                                } else if (!bVar.z.equalsIgnoreCase(new String(this.f2064f))) {
                                    this.k.b(String.valueOf(12301), "Error 301 Created: Invalid SdkTransactionID");
                                    str2 = "sdkTransactionID";
                                } else if (Integer.parseInt(bVar.E) != this.f2063e.f2059a - 1) {
                                    this.k.b(String.valueOf(12302), "Error 302 Created: Data could not be decrypted");
                                    if (this.f2063e != null) {
                                        e eVar4 = new e(null);
                                        eVar4.f2097a = "302";
                                        eVar4.f2099c = "Data could not be decrypted by the receiving system due to technical or other reason.";
                                        eVar4.f2100d = "AcsCounterAtoS";
                                        eVar4.a(bVar);
                                        b(eVar4);
                                        b(a(eVar4));
                                        return;
                                    }
                                    throw null;
                                } else {
                                    this.f2060a.a(bVar);
                                    return;
                                }
                                b(bVar, str2);
                            } else if (this.f2063e != null) {
                                e eVar5 = new e(null);
                                eVar5.f2097a = "203";
                                eVar5.f2099c = "Data element not in the required format or value is invalid as defined in Table A.1,";
                                eVar5.f2100d = iVar.f2110b;
                                eVar5.a(bVar);
                                b(eVar5);
                                b(a(eVar5));
                                com.cardinalcommerce.emvco.a.g.a aVar = this.k;
                                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error 203 Created: \n");
                                outline73.append(eVar5.f2099c);
                                outline73.append(" - ");
                                outline73.append(eVar5.f2100d);
                                aVar.b(String.valueOf(12203), outline73.toString());
                            } else {
                                throw null;
                            }
                        }
                    } else {
                        throw new ParseException("Unexpected number of Base64URL parts, must be five", 0);
                    }
                } else {
                    throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing second delimiter", 0);
                }
            } else {
                throw new ParseException("Invalid serialized unsecured/JWS/JWE object: Missing part delimiters", 0);
            }
        } else {
            JSONObject jSONObject = new JSONObject(str3);
            String optString = jSONObject.optString("errorCode", "");
            if (!optString.isEmpty()) {
                String optString2 = jSONObject.optString("errorDescription", "");
                String optString3 = jSONObject.optString("errorDetail", "");
                if (this.f2063e != null) {
                    new String(null);
                    b(new ErrorMessage("", optString, optString2, optString3));
                    return;
                }
                throw null;
            }
            this.k.b(String.valueOf(12101), "Error 101 Created: Message is not CRes - Challenge Decrypted CardinalError");
            String optString4 = jSONObject.optString("errorDescription", "Challenge Decrypted CardinalError");
            e("Message is not CRes " + optString4);
        }
    }

    public void a(String str) {
        String str2;
        if (!h.a(this.j)) {
            return;
        }
        if (!Arrays.equals(this.j, ThreeDSStrings.CHALLENGE_CANCEL_CHAR) || !Arrays.equals(this.j, ThreeDSStrings.CHALLENGE_CANCEL_ERROR)) {
            try {
                if (str.isEmpty()) {
                    d("Message is not CRes");
                } else {
                    b(str);
                }
            } catch (JOSEException e2) {
                e = e2;
                com.cardinalcommerce.emvco.a.g.a aVar = this.k;
                aVar.b(String.valueOf(12101), "Error 101 Created: Error Decrypting response" + e.getLocalizedMessage());
                str2 = "Invalid Message from the ACS";
            } catch (ParseException e3) {
                e = e3;
                com.cardinalcommerce.emvco.a.g.a aVar2 = this.k;
                aVar2.b(String.valueOf(12101), "Error 101 Created: Error Decrypting response" + e.getLocalizedMessage());
                str2 = "Invalid Message from the ACS";
            } catch (JSONException e4) {
                com.cardinalcommerce.emvco.a.g.a aVar3 = this.k;
                aVar3.b(String.valueOf(12101), "Error 101 Created: Response is in invalid format" + e4.getLocalizedMessage());
                str2 = "Invalid Formatted Message";
            } catch (Throwable th) {
                this.k.a("EMVCoTransaction", "Challenge Task finished");
                b();
                throw th;
            }
            this.k.a("EMVCoTransaction", "Challenge Task finished");
            b();
        }
        return;
        d(str2);
        this.k.a("EMVCoTransaction", "Challenge Task finished");
        b();
    }
}
