package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zze;
import com.google.android.gms.internal.auth.zzhj;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class zzl {
    @ShowFirstParty
    public static final String[] zza = {"com.google", "com.google.work", "cn.google"};
    @ShowFirstParty
    @SuppressLint({"InlinedApi"})
    public static final String zzb = "androidPackageName";
    public static final ComponentName zzc = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    public static final Logger zzd = new Logger("Auth", "GoogleAuthUtil");

    public static /* synthetic */ TokenData zzb(Account account, String str, Bundle bundle, IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zze = zze.zzb(iBinder).zze(account, str, bundle);
        if (zze != null) {
            return zzf(zze);
        }
        throw new IOException("Service call returned null");
    }

    public static TokenData zzf(Bundle bundle) throws GoogleAuthException, IOException {
        TokenData tokenData;
        Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (zzby.zzb(zza2)) {
            Logger logger = zzd;
            String valueOf = String.valueOf(zza2);
            logger.format("GoogleAuthUtil", GeneratedOutlineSupport.outline62(new StringBuilder(valueOf.length() + 31), "isUserRecoverableError status: ", valueOf));
            throw new UserRecoverableAuthException(string, intent);
        } else if (zzby.NETWORK_ERROR.equals(zza2) || zzby.SERVICE_UNAVAILABLE.equals(zza2) || zzby.INTNERNAL_ERROR.equals(zza2) || zzby.AUTH_SECURITY_ERROR.equals(zza2)) {
            throw new IOException(string);
        } else {
            throw new GoogleAuthException(string);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        throw new java.io.IOException("Error on service connection.", r7);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e A[ExcHandler: RemoteException | InterruptedException (r7v4 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:5:0x001b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T zzg(android.content.Context r5, android.content.ComponentName r6, com.google.android.gms.auth.zzk<T> r7) throws java.io.IOException, com.google.android.gms.auth.GoogleAuthException {
        /*
            java.lang.String r0 = "GoogleAuthUtil"
            com.google.android.gms.common.BlockingServiceConnection r1 = new com.google.android.gms.common.BlockingServiceConnection
            r1.<init>()
            com.google.android.gms.common.internal.GmsClientSupervisor r5 = com.google.android.gms.common.internal.GmsClientSupervisor.getInstance(r5)
            r2 = 0
            if (r5 == 0) goto L_0x004a
            com.google.android.gms.common.internal.zzn r3 = new com.google.android.gms.common.internal.zzn     // Catch:{ SecurityException -> 0x004b }
            r4 = 4225(0x1081, float:5.92E-42)
            r3.<init>(r6, r4)     // Catch:{ SecurityException -> 0x004b }
            boolean r2 = r5.zzc(r3, r1, r0, r2)     // Catch:{ SecurityException -> 0x004b }
            if (r2 == 0) goto L_0x0042
            android.os.IBinder r2 = r1.getService()     // Catch:{ RemoteException -> 0x0030, InterruptedException -> 0x002e }
            java.lang.Object r7 = r7.zza(r2)     // Catch:{ RemoteException -> 0x0030, InterruptedException -> 0x002e }
            com.google.android.gms.common.internal.zzn r2 = new com.google.android.gms.common.internal.zzn
            r2.<init>(r6, r4)
            r5.zza(r2, r1, r0)
            return r7
        L_0x002c:
            r7 = move-exception
            goto L_0x0039
        L_0x002e:
            r7 = move-exception
            goto L_0x0031
        L_0x0030:
            r7 = move-exception
        L_0x0031:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x002c }
            java.lang.String r3 = "Error on service connection."
            r2.<init>(r3, r7)     // Catch:{ all -> 0x002c }
            throw r2     // Catch:{ all -> 0x002c }
        L_0x0039:
            com.google.android.gms.common.internal.zzn r2 = new com.google.android.gms.common.internal.zzn
            r2.<init>(r6, r4)
            r5.zza(r2, r1, r0)
            throw r7
        L_0x0042:
            java.io.IOException r5 = new java.io.IOException
            java.lang.String r6 = "Could not bind to service."
            r5.<init>(r6)
            throw r5
        L_0x004a:
            throw r2     // Catch:{ SecurityException -> 0x004b }
        L_0x004b:
            r5 = move-exception
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r7 = 0
            java.lang.String r0 = r5.getMessage()
            r6[r7] = r0
            java.lang.String r7 = "SecurityException while bind to auth service: %s"
            java.lang.String.format(r7, r6)
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "SecurityException while binding to Auth service."
            r6.<init>(r7, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzl.zzg(android.content.Context, android.content.ComponentName, com.google.android.gms.auth.zzk):java.lang.Object");
    }

    public static <ResultT> ResultT zzh(Task<ResultT> task, String str) throws IOException, ApiException {
        try {
            return Tasks.await(task);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof ApiException) {
                throw ((ApiException) cause);
            }
            String format = String.format("Unable to get a result for %s due to ExecutionException.", new Object[]{str});
            zzd.format(format, new Object[0]);
            throw new IOException(format, e2);
        } catch (InterruptedException e3) {
            String format2 = String.format("Interrupted while waiting for the task of %s to finish.", new Object[]{str});
            zzd.format(format2, new Object[0]);
            throw new IOException(format2, e3);
        } catch (CancellationException e4) {
            String format3 = String.format("Canceled while waiting for the task of %s to finish.", new Object[]{str});
            zzd.format(format3, new Object[0]);
            throw new IOException(format3, e4);
        }
    }

    public static <T> T zzi(T t) throws IOException {
        if (t != null) {
            return t;
        }
        zzd.format("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    public static void zzj(Context context, int i) throws GoogleAuthException {
        try {
            GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.zza, e2.getMessage(), new Intent(e2.zza));
        } catch (GooglePlayServicesIncorrectManifestValueException | GooglePlayServicesNotAvailableException e3) {
            throw new GoogleAuthException(e3.getMessage(), e3);
        }
    }

    public static void zzk(ApiException apiException, String str) {
        zzd.format("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(apiException));
    }

    public static void zzl(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        } else if (!TextUtils.isEmpty(account.name)) {
            String[] strArr = zza;
            int i = 0;
            while (i < 3) {
                if (!strArr[i].equals(account.type)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        } else {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
    }

    public static boolean zzm(Context context) {
        if (GoogleApiAvailability.zab.isGooglePlayServicesAvailable(context, 17895000) != 0) {
            return false;
        }
        String str = context.getApplicationInfo().packageName;
        for (String equals : zzhj.zzb().zzm()) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }
}
