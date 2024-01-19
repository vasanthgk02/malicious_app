package com.cardinalcommerce.cardinalmobilesdk.a.c;

import android.os.Build;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.cardinalmobilesdk.a.a.c;
import com.cardinalcommerce.cardinalmobilesdk.a.a.e;
import com.cardinalcommerce.cardinalmobilesdk.a.a.f;
import com.cardinalcommerce.shared.cs.d.a;
import com.cardinalcommerce.shared.cs.f.g;
import com.cardinalcommerce.shared.cs.f.n;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.h;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final com.cardinalcommerce.cardinalmobilesdk.a.d.b f1872b = com.cardinalcommerce.cardinalmobilesdk.a.d.b.a();

    /* renamed from: a  reason: collision with root package name */
    public com.cardinalcommerce.cardinalmobilesdk.a.b.b f1873a;

    public b(com.cardinalcommerce.cardinalmobilesdk.a.b.b bVar, f fVar, int i) {
        if (fVar != null) {
            this.f1873a = bVar;
            e eVar = fVar.f1860a.deviceFingerprint;
            com.cardinalcommerce.cardinalmobilesdk.a.d.b bVar2 = f1872b;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Creating device fingerprint JSON with referenceId : ");
            outline73.append(eVar.f1856b);
            bVar2.a("CardinalInit", outline73.toString(), null);
            String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), eVar.f1859f, "/V2/Browser/SaveBrowserData");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReferenceId", eVar.f1856b);
            jSONObject.put("OrgUnitId", eVar.f1855a);
            jSONObject.put(Names.ORIGIN, "CardinalMobileSdk_Android");
            jSONObject.put("DeviceChannel", "SDK");
            jSONObject.put("Fingerprint", Build.FINGERPRINT);
            jSONObject.put("UserAgent", Build.BRAND);
            jSONObject.put("ThreatMetrixEnabled", eVar.f1857c);
            jSONObject.put("ThreatMetrixEventType", eVar.f1858d);
            if (com.cardinalcommerce.shared.cs.a.b.a() != null) {
                g gVar = com.cardinalcommerce.shared.cs.a.b.f2069a;
                if (gVar != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        if (gVar.j != null) {
                            jSONObject2.putOpt("ConnectionData", gVar.j.c());
                        }
                        if (gVar.f2134e != null) {
                            jSONObject2.putOpt("Language", h.b(gVar.f2134e));
                        }
                        if (gVar.i != null) {
                            jSONObject2.putOpt("LocationData", gVar.i.a());
                        }
                        if (gVar.h != null) {
                            jSONObject2.putOpt("DeviceData", gVar.h.a());
                        }
                        if (gVar.f2133d != null) {
                            jSONObject2.putOpt("OS", gVar.f2133d.a());
                        }
                        if (gVar.g != null) {
                            jSONObject2.putOpt("TelephonyData", gVar.g.a());
                        }
                        if (gVar.k != null) {
                            jSONObject2.putOpt("ConfigurationData", gVar.k);
                        }
                        if (gVar.f2135f != null) {
                            n nVar = gVar.f2135f;
                            if (nVar != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                try {
                                    jSONObject3.putOpt("SettingsData", nVar.f2170a.a());
                                } catch (JSONException e2) {
                                    com.cardinalcommerce.shared.cs.utils.a.e().b(String.valueOf(13101), e2.getLocalizedMessage(), null);
                                }
                                jSONObject2.putOpt("UserData", jSONObject3);
                            } else {
                                throw null;
                            }
                        }
                        if (gVar.f2130a != null) {
                            jSONObject2.putOpt("ApplicationData", gVar.f2130a.e());
                        }
                        if (gVar.l != null) {
                            jSONObject2.putOpt("SecurityWarnings", gVar.l.d());
                        }
                        if (gVar.f2131b != null) {
                            jSONObject2.putOpt("SdkVersion", h.b(gVar.f2131b));
                        }
                        if (gVar.f2132c != null) {
                            jSONObject2.putOpt("SDKAppId", h.b(gVar.f2132c));
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (String put : ThreeDSStrings.supportedMessageVersions) {
                            jSONArray.put(put);
                        }
                        jSONObject2.putOpt("SDK3DSSupport", jSONArray);
                    } catch (JSONException e3) {
                        com.cardinalcommerce.shared.cs.utils.a.e().b(String.valueOf(13101), e3.getLocalizedMessage(), null);
                    }
                    jSONObject.put("NativeData", jSONObject2);
                    super.a(outline62, jSONObject.toString(), i);
                    f1872b.a("CardinalInit", "DF task initialized", null);
                    return;
                }
                throw null;
            }
            throw null;
        }
        f1872b.a(new c(10204), null);
        throw new InvalidInputException("API Call", new Throwable("Invalid Input Exception"));
    }

    public void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar) {
        f1872b.b(String.valueOf(10218), exc.getLocalizedMessage(), null);
        ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1873a).b(new c(10218));
    }

    public void a(String str, int i) {
        c cVar = new c(i, str);
        f1872b.a(cVar, null);
        ((com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1873a).b(cVar);
    }

    public void a(String str) {
        f1872b.a("CardinalInit", "LASSO Save Successful", null);
        com.cardinalcommerce.cardinalmobilesdk.a.a.a aVar = (com.cardinalcommerce.cardinalmobilesdk.a.a.a) this.f1873a;
        if (aVar.m.j) {
            aVar.b(aVar.j);
        }
        aVar.o = false;
    }
}
