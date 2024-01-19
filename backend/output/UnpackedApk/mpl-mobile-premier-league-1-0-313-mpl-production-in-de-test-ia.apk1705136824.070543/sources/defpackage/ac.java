package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.IInterface;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.BaseConstants;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.fontbox.cmap.CMap;

/* renamed from: ac  reason: default package */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public static Object f2697a = new Object();

    /* renamed from: ac$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static long f2699a;

        /* renamed from: a  reason: collision with other field name */
        public static b f24a;

        public static void a(b bVar) {
            f24a = bVar;
            f2699a = bVar == null ? 0 : GeneratedOutlineSupport.outline13();
        }
    }

    /* renamed from: ac$b */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ab f2700a;

        /* renamed from: a  reason: collision with other field name */
        public Intent f25a;

        /* renamed from: a  reason: collision with other field name */
        public final ResolveInfo f26a;

        /* renamed from: a  reason: collision with other field name */
        public IInterface f27a = null;

        /* renamed from: a  reason: collision with other field name */
        public final cr f28a;

        public b(ac acVar, cr crVar, IInterface iInterface, ab abVar, boolean z, ResolveInfo resolveInfo, Intent intent) {
            this.f28a = crVar;
            this.f2700a = abVar;
            this.f26a = resolveInfo;
            this.f25a = intent;
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection, Intent intent) {
        String packageName = intent != null ? intent.getComponent().getPackageName() : null;
        cp.a((String) "ac", "Unbinding pkg=" + packageName);
        if (serviceConnection != null) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException unused) {
                String.format("IllegalArgumentException is received during unbinding from %s. Ignored.", new Object[]{packageName});
            }
        }
    }

    public static boolean a(String str, Signature signature) {
        String str2;
        String str3;
        try {
            String a2 = cl.a(signature, ce.SHA_256);
            cp.a((String) "ac", (String) "Expected fingerprint", "Fingerprint=" + str);
            cp.a((String) "ac", (String) "Extracted fingerprint", "Fingerprint=" + a2);
            return str.equals(a2);
        } catch (CertificateException e2) {
            str3 = e2.getMessage();
            str2 = "CertificateException getting Fingerprint. ";
            cp.a((String) "ac", str2, str3);
            return false;
        } catch (NoSuchAlgorithmException e3) {
            str3 = e3.getMessage();
            str2 = "NoSuchAlgorithmException getting Fingerprint. ";
            cp.a((String) "ac", str2, str3);
            return false;
        } catch (IOException e4) {
            str3 = e4.getMessage();
            str2 = "IOException getting Fingerprint. ";
            cp.a((String) "ac", str2, str3);
            return false;
        }
    }

    public b a(List<b> list) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Number of MAP services to compare = ");
        outline73.append(list.size());
        cp.c("ac", outline73.toString());
        b bVar = null;
        for (b next : list) {
            if (bVar != null) {
                cr crVar = next.f28a;
                cr crVar2 = bVar.f28a;
                if (crVar != null) {
                    try {
                        int[] iArr = crVar2.f126a;
                        int min = Math.min(crVar.f126a.length, crVar2.f126a.length) - 1;
                        int i = 0;
                        int i2 = 0;
                        while (i2 < min && crVar.f126a[i2] == iArr[i2]) {
                            i2++;
                        }
                        Integer valueOf = Integer.valueOf(crVar.f126a[i2]);
                        Integer valueOf2 = Integer.valueOf(iArr[i2]);
                        if (i2 != crVar.f126a.length || crVar.f126a.length != crVar2.f126a.length) {
                            i = (iArr.length == crVar.f126a.length || !valueOf.equals(valueOf2)) ? valueOf.compareTo(valueOf2) : Integer.valueOf(crVar.f126a.length).compareTo(Integer.valueOf(iArr.length));
                        }
                        if (i <= 0) {
                        }
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("1=");
                        outline732.append(crVar.toString());
                        outline732.append(" vs 2=");
                        outline732.append(crVar2.toString());
                        outline732.append(CMap.SPACE);
                        outline732.append(e2.getMessage());
                        throw new ArrayIndexOutOfBoundsException(outline732.toString());
                    }
                } else {
                    throw null;
                }
            }
            bVar = next;
        }
        return bVar;
    }

    public k a(Context context, boolean z) throws AuthError {
        IInterface iInterface;
        String str;
        Signature signature;
        cp.c("ac", "Attempting to retrieve remote Android service. Ignore cached service=" + z);
        if (!ca.a()) {
            cp.a((String) "ac", (String) "getAuthorizationServiceInstance");
            synchronized (f2697a) {
                b bVar = null;
                if (z) {
                    b bVar2 = a.f24a;
                    if (bVar2 != null) {
                        a(context, bVar2.f2700a, bVar2.f25a);
                        a.a(null);
                    }
                    bVar = bVar2;
                } else {
                    b bVar3 = a.f24a;
                    if (bVar3 != null) {
                        a(context, bVar3.f2700a, bVar3.f25a);
                        if (a(context)) {
                            iInterface = bVar3.f27a;
                        } else {
                            a.a(null);
                        }
                    }
                }
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent();
                intent.setAction("com.amazon.identity.auth.device.authorization.MapAuthorizationService");
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                queryIntentServices.size();
                ArrayList arrayList = new ArrayList();
                for (ResolveInfo next : queryIntentServices) {
                    if (bVar == null || !next.serviceInfo.applicationInfo.packageName.equals(bVar.f26a.serviceInfo.applicationInfo.packageName)) {
                        try {
                            cp.c("ac", "Verifying signature for pkg=" + next.serviceInfo.applicationInfo.packageName);
                            Signature[] signatureArr = context.getPackageManager().getPackageInfo(next.serviceInfo.applicationInfo.packageName, 64).signatures;
                            if (signatureArr.length == 1) {
                                if (cj.a(context, context.getPackageName()).equalsIgnoreCase(BaseConstants.DEVELOPMENT)) {
                                    cp.c("ac", "Attempting to check fingerprint in development environment");
                                    signature = signatureArr[0];
                                    str = "7cac391937981b6134bdce1fd9834c253181f5abf91ded6078210d0f91ace360";
                                } else {
                                    cp.c("ac", "Attempting to check fingerprint in production environment");
                                    signature = signatureArr[0];
                                    str = "2f19adeb284eb36f7f07786152b9a1d14b21653203ad0b04ebbf9c73ab6d7625";
                                }
                                if (!a(str, signature)) {
                                    cp.a((String) "ac", (String) "Security check failure", (String) "Signature is incorrect.");
                                } else {
                                    ComponentName componentName = new ComponentName(next.serviceInfo.applicationInfo.packageName, next.serviceInfo.name);
                                    Bundle bundle = context.getPackageManager().getServiceInfo(componentName, 128).metaData;
                                    if (bundle != null) {
                                        boolean z2 = bundle.getBoolean("map.primary");
                                        String string = bundle.getString("map.version");
                                        if (!TextUtils.isEmpty(string) || z2) {
                                            b bVar4 = new b(this, z2 ? cr.f3314a : new cr(string), null, new ab(), z2, next, new Intent().setComponent(componentName));
                                            arrayList.add(bVar4);
                                        }
                                    }
                                }
                            } else {
                                cp.a((String) "ac", (String) "Security count failure", "Signature count (" + signatureArr.length + ") is incorrect.");
                            }
                        } catch (NameNotFoundException e2) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("msg=");
                            outline73.append(e2.getMessage());
                            cp.a((String) "ac", (String) "NameNotFoundException.", outline73.toString());
                        }
                    } else {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Ignoring previous service =");
                        outline732.append(next.serviceInfo.name);
                        cp.c("ac", outline732.toString());
                    }
                }
                synchronized (f2697a) {
                    a.a(a((List<b>) arrayList));
                    if (a.f24a == null) {
                        iInterface = null;
                    } else {
                        a(context);
                        b bVar5 = a.f24a;
                        iInterface = bVar5 != null ? bVar5.f27a : null;
                    }
                }
            }
            return (k) iInterface;
        }
        cp.b("ac", "getAuthorizationServiceInstance started on main thread");
        throw new IllegalStateException("getAuthorizationServiceInstance started on main thread");
    }

    public static void a(Context context) {
        synchronized (f2697a) {
            cp.c("ac", "Unbinding Highest Versioned Service");
            b bVar = a.f24a;
            if (!(bVar == null || bVar.f2700a == null)) {
                a(context, bVar.f2700a, bVar.f25a);
                bVar.f27a = null;
                bVar.f2700a = null;
                bVar.f25a = null;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m230a(Context context) throws AuthError {
        if (a.f24a == null || GeneratedOutlineSupport.outline13() > a.f2699a + 86400000) {
            return false;
        }
        final b bVar = a.f24a;
        ServiceInfo serviceInfo = bVar.f26a.serviceInfo;
        ComponentName componentName = new ComponentName(serviceInfo.applicationInfo.packageName, serviceInfo.name);
        Intent intent = new Intent();
        intent.setComponent(componentName);
        ab abVar = new ab();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final ab abVar2 = abVar;
        final Intent intent2 = intent;
        final CountDownLatch countDownLatch2 = countDownLatch;
        AnonymousClass1 r4 = new l(this) {
        };
        abVar.f164a = r4;
        if (context.bindService(intent, abVar, 5)) {
            try {
                if (!countDownLatch.await(10, TimeUnit.SECONDS)) {
                    a.a(null);
                    throw new AuthError("Binding to authorization service has timed out!", ERROR_TYPE.ERROR_THREAD);
                }
            } catch (InterruptedException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("msg+=");
                outline73.append(e2.getMessage());
                cp.a((String) "ac", (String) "InterruptedException", outline73.toString());
                a.a(null);
                throw new AuthError("Binding to authorization service has timed out!", e2, ERROR_TYPE.ERROR_THREAD);
            }
        } else {
            a.a(null);
            intent.getComponent().flattenToString();
        }
        return true;
    }
}
