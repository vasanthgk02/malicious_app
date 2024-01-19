package com.cardinalcommerce.cardinalmobilesdk.a.d;

import com.cardinalcommerce.cardinalmobilesdk.a.a.c;
import com.cardinalcommerce.shared.cs.utils.CCInitProvider;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.a;
import com.cardinalcommerce.shared.cs.utils.a.C0032a;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class b extends a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f1890d;

    public b() {
        if (f1890d == null) {
            a.f2213a = true;
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance.");
    }

    public static b a() {
        if (f1890d == null) {
            synchronized (b.class) {
                try {
                    if (f1890d == null) {
                        f1890d = new b();
                    }
                }
            }
        }
        return f1890d;
    }

    public void a(c cVar, String str) {
        b(String.valueOf(cVar.f1853a), cVar.f1854b, str);
    }

    public void a(String str, String str2, String str3) {
        if (a.f2213a) {
            a.f2214b = com.cardinalcommerce.cardinalmobilesdk.a.a.a.a().e();
            a.f2215c = "CardinalLoggerV1";
            super.a(str, str2, str3);
        }
    }

    public com.cardinalcommerce.shared.cs.utils.b b() {
        return super.b();
    }

    public void b(String str, String str2, String str3) {
        if (a.f2213a) {
            a.f2214b = com.cardinalcommerce.cardinalmobilesdk.a.a.a.a().e();
            a.f2215c = "CardinalLoggerV1";
            super.b(str, str2, str3);
        }
    }

    public void c() {
        super.c();
    }

    public void a(String str) {
        String str2;
        String str3;
        BufferedReader bufferedReader;
        if (a.f2213a) {
            if (a.f2213a) {
                String str4 = "";
                try {
                    FileInputStream openFileInput = CCInitProvider.f2212a.openFileInput("cca_logs.txt");
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(openFileInput);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            if (openFileInput != null) {
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                    sb.append("\n");
                                }
                                str4 = sb.toString();
                            }
                            bufferedReader.close();
                            inputStreamReader.close();
                            if (openFileInput != null) {
                                openFileInput.close();
                            }
                        } catch (Throwable th) {
                            inputStreamReader.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        if (openFileInput != null) {
                            openFileInput.close();
                        }
                        throw th2;
                    }
                } catch (IOException e2) {
                    e2.getLocalizedMessage();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                str2 = str4.trim();
            } else {
                str2 = null;
            }
            if (str != null) {
                boolean z = ThreeDSStrings.IS_EXTERNAL_BUILD;
                if (str.equals("STAGING")) {
                    str3 = "https://cmsdk.cardinalcommerce.com/stag_logs";
                    new C0032a(str2, str3).execute(new Void[0]);
                    return;
                }
            }
            str3 = "https://cmsdk.cardinalcommerce.com/prod_logs";
            new C0032a(str2, str3).execute(new Void[0]);
            return;
        }
        return;
        throw th;
    }
}
