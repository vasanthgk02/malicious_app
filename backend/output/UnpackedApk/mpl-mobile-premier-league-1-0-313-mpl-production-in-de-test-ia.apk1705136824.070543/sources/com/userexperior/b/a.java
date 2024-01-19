package com.userexperior.b;

import android.content.Context;
import com.mpl.androidapp.utils.Constant;
import com.squareup.picasso.NetworkRequestHandler;
import com.userexperior.c.c.d;
import com.userexperior.c.c.e;
import com.userexperior.c.c.f;
import com.userexperior.e.b.c;
import com.userexperior.e.b.h;
import com.userexperior.e.b.m;
import com.userexperior.e.o;
import com.userexperior.e.q;
import com.userexperior.e.s;
import com.userexperior.e.t;
import com.userexperior.e.y;
import com.userexperior.utilities.b;
import com.userexperior.utilities.j;
import com.userexperior.utilities.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.eclipse.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;
import sfs2x.client.requests.CreateRoomRequest;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3763a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static a f3764b;

    /* renamed from: c  reason: collision with root package name */
    public q f3765c;

    public static a a() {
        if (f3764b == null) {
            synchronized (a.class) {
                try {
                    if (f3764b == null) {
                        f3764b = new a();
                    }
                }
            }
        }
        return f3764b;
    }

    public static /* synthetic */ HostnameVerifier a(a aVar) {
        return new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                HttpsURLConnection.getDefaultHostnameVerifier();
                return true;
            }
        };
    }

    public static /* synthetic */ void a(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                Level level = Level.INFO;
                b.a(level, "d = " + file.delete());
                StringBuilder sb = new StringBuilder();
                sb.append(file.getName());
                sb.append("deleted = ");
                sb.append(file.delete());
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" does not exists");
        }
    }

    public static SSLSocketFactory c() {
        TrustManager[] trustManagerArr = {new X509TrustManager() {
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        try {
            SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            instance.init(null, trustManagerArr, new SecureRandom());
            return instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e2) {
            e2.getMessage();
            return null;
        } catch (KeyManagementException e3) {
            e3.getMessage();
            return null;
        } catch (Exception e4) {
            e4.getMessage();
            return null;
        }
    }

    public final void a(d dVar) {
        Context a2 = com.userexperior.utilities.a.a();
        com.userexperior.c.b.a e2 = l.e(a2);
        if (e2 != null) {
            for (e next : dVar.f3887d) {
                new StringBuilder("uploading ").append(next.f3889a);
                if (new File(next.f3889a).exists()) {
                    final String str = next.f3889a;
                    String str2 = "https://userexperior.online/upload/api/video/upload/version/crashlog/" + dVar.f3884a;
                    final String substring = str.substring(str.lastIndexOf(File.separator) + 1);
                    dVar.f3885b = substring;
                    byte[] bArr = new byte[0];
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                        bArr = new byte[((int) randomAccessFile.length())];
                        randomAccessFile.readFully(bArr);
                    } catch (Exception e3) {
                        e3.getMessage();
                    }
                    final byte[] a3 = com.userexperior.utilities.e.a(com.userexperior.utilities.e.a(e2.f3823d), com.userexperior.utilities.e.b(e2.j), bArr);
                    final d dVar2 = dVar;
                    final Context context = a2;
                    AnonymousClass13 r0 = new com.userexperior.e.b.l(str2, new t<String>() {
                        public final /* bridge */ /* synthetic */ void a(Object obj) {
                            b.a(Level.INFO, "<<< CUS >>>");
                            a.a(str);
                        }
                    }, new s() {
                        public final void a(y yVar) {
                            b.a(Level.SEVERE, "<<< CUF >>>");
                            Level level = Level.SEVERE;
                            b.a(level, "REASON  : error " + yVar.getMessage());
                        }
                    }) {
                        public final Map<String, m> a() {
                            HashMap hashMap = new HashMap();
                            hashMap.put("crashLogMultipartFile", new m(this, substring, a3, "text/plain"));
                            return hashMap;
                        }

                        public final Map<String, String> b() throws com.userexperior.e.a {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Constant.HEADER_ANDROID_DEVICE_ID, dVar2.f3886c);
                            hashMap.put("appSessionId", l.n(context));
                            hashMap.put("appPackage", context.getPackageName());
                            hashMap.put("platform", "1");
                            hashMap.put(CreateRoomRequest.KEY_ROOMVARS, "1.5.2");
                            return hashMap;
                        }
                    };
                    a((o<T>) r0);
                }
            }
            return;
        }
        b.a(Level.INFO, "UE down, things are saved and will be uploaded later....c");
    }

    public final void a(f fVar) {
        Context a2 = com.userexperior.utilities.a.a();
        com.userexperior.c.b.a e2 = l.e(a2);
        if (e2 != null) {
            for (e next : fVar.f3893b) {
                if (new File(next.f3889a).exists()) {
                    try {
                        fVar.f3894c = String.valueOf(j.j(a2).longValue());
                        fVar.f3895d = "screenshots";
                        fVar.f3896e = l.f(a2);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    if (next.f3890b == com.userexperior.models.recording.enums.d.USER_SCREEN_SHOTS) {
                        final String str = next.f3889a;
                        String str2 = "https://userexperior.online/upload/api/video/upload/version/zip_new/" + fVar.f3892a;
                        final String substring = str.substring(str.lastIndexOf(File.separator) + 1);
                        byte[] bArr = new byte[0];
                        try {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                            bArr = new byte[((int) randomAccessFile.length())];
                            randomAccessFile.readFully(bArr);
                            randomAccessFile.close();
                        } catch (Exception e4) {
                            e4.getMessage();
                        }
                        final byte[] a3 = com.userexperior.utilities.e.a(com.userexperior.utilities.e.a(e2.f3823d), com.userexperior.utilities.e.b(e2.j), bArr);
                        final f fVar2 = fVar;
                        final Context context = a2;
                        AnonymousClass10 r0 = new com.userexperior.e.b.l(str2, new t<String>() {
                            public final /* bridge */ /* synthetic */ void a(Object obj) {
                                b.a(Level.INFO, "<<< SUS >>>");
                                a.a(str);
                            }
                        }, new s() {
                            public final void a(y yVar) {
                                b.a(Level.SEVERE, "<<< SUF >>>");
                                Level level = Level.SEVERE;
                                b.a(level, "REASON  : error " + yVar.getMessage());
                                yVar.printStackTrace();
                            }
                        }) {
                            public final Map<String, m> a() {
                                HashMap hashMap = new HashMap();
                                hashMap.put("zipMultipartFile", new m(this, substring, a3, "application/zip"));
                                return hashMap;
                            }

                            public final Map<String, String> b() throws com.userexperior.e.a {
                                HashMap hashMap = new HashMap();
                                hashMap.put("screenDescription", fVar2.f3895d);
                                hashMap.put("screenLengthSeconds", fVar2.f3894c);
                                hashMap.put(Constant.HEADER_ANDROID_DEVICE_ID, fVar2.f3896e);
                                hashMap.put("appSessionId", l.n(context));
                                hashMap.put("platform", "1");
                                hashMap.put("zipFileName", substring);
                                hashMap.put("appPackage", context.getPackageName());
                                hashMap.put(CreateRoomRequest.KEY_ROOMVARS, "1.5.2");
                                return hashMap;
                            }
                        };
                        a((o<T>) r0);
                    }
                } else {
                    b.a(Level.INFO, "z file doesn't exist");
                }
            }
            return;
        }
        b.a(Level.INFO, "UE down, things are saved and will be uploaded later....s");
    }

    public final <T> void a(o<T> oVar) {
        if (this.f3765c == null) {
            AnonymousClass5 r0 = new h() {
                public final HttpURLConnection a(URL url) throws IOException {
                    boolean equals = NetworkRequestHandler.SCHEME_HTTPS.equals(url.getProtocol());
                    HttpURLConnection a2 = super.a(url);
                    if (!equals) {
                        return a2;
                    }
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) a2;
                    try {
                        httpsURLConnection.setSSLSocketFactory(a.c());
                        httpsURLConnection.setHostnameVerifier(a.a(a.this));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    httpsURLConnection.setConnectTimeout(8000);
                    return httpsURLConnection;
                }
            };
            File file = new File(com.userexperior.utilities.a.a().getCacheDir(), "volley");
            q qVar = new q((com.userexperior.e.b) new c(file, 0), (com.userexperior.e.j) new com.userexperior.e.b.a(r0), 0);
            qVar.a();
            this.f3765c = qVar;
        }
        this.f3765c.a(oVar);
    }

    public final void b(d dVar) {
        Context a2 = com.userexperior.utilities.a.a();
        com.userexperior.c.b.a e2 = l.e(a2);
        if (e2 != null) {
            for (e next : dVar.f3887d) {
                if (new File(next.f3889a).exists()) {
                    final String str = next.f3889a;
                    String str2 = "https://userexperior.online/upload/api/video/upload/version/crashlog/" + dVar.f3884a;
                    final String substring = str.substring(str.lastIndexOf(File.separator) + 1);
                    dVar.f3885b = substring;
                    byte[] bArr = new byte[0];
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
                        bArr = new byte[((int) randomAccessFile.length())];
                        randomAccessFile.readFully(bArr);
                    } catch (Exception e3) {
                        e3.getMessage();
                    }
                    final byte[] a3 = com.userexperior.utilities.e.a(com.userexperior.utilities.e.a(e2.f3823d), com.userexperior.utilities.e.b(e2.j), bArr);
                    final d dVar2 = dVar;
                    final Context context = a2;
                    AnonymousClass4 r0 = new com.userexperior.e.b.l(str2, new t<String>() {
                        public final /* bridge */ /* synthetic */ void a(Object obj) {
                            b.a(Level.INFO, "<<< AUS >>>");
                            a.a(str);
                        }
                    }, new s() {
                        public final void a(y yVar) {
                            b.a(Level.SEVERE, "<<< AUF >>>");
                            Level level = Level.SEVERE;
                            b.a(level, "REASON  : error " + yVar.getMessage());
                        }
                    }) {
                        public final Map<String, m> a() {
                            HashMap hashMap = new HashMap();
                            hashMap.put("crashLogMultipartFile", new m(this, substring, a3, "text/plain"));
                            return hashMap;
                        }

                        public final Map<String, String> b() throws com.userexperior.e.a {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Constant.HEADER_ANDROID_DEVICE_ID, dVar2.f3886c);
                            hashMap.put("appSessionId", l.n(context));
                            hashMap.put("appPackage", context.getPackageName());
                            hashMap.put("platform", "1");
                            hashMap.put(CreateRoomRequest.KEY_ROOMVARS, "1.5.2");
                            return hashMap;
                        }
                    };
                    a((o<T>) r0);
                } else {
                    b.a(Level.INFO, "a file doesn't exist");
                }
            }
            return;
        }
        b.a(Level.INFO, "UE down, things are saved and will be uploaded later....a");
    }
}
