package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final /* synthetic */ class zzcs implements zzdg {
    public final /* synthetic */ Context zza;

    public /* synthetic */ zzcs(Context context) {
        this.zza = context;
    }

    public final Object zza() {
        zzde zzde;
        zzde zzde2;
        BufferedReader bufferedReader;
        Context context = this.zza;
        int i = zzcz.zzd;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
            return zzde.zzc();
        }
        if (zzcc.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            if (file.exists()) {
                zzde = zzde.zzd(file);
            } else {
                zzde = zzde.zzc();
            }
        } catch (RuntimeException unused) {
            zzde = zzde.zzc();
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        if (zzde.zzb()) {
            File file2 = (File) zzde.zza();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(CMap.SPACE, 3);
                    if (split.length == 3) {
                        String str3 = new String(split[0]);
                        String decode = Uri.decode(new String(split[1]));
                        String str4 = (String) hashMap2.get(split[2]);
                        if (str4 == null) {
                            String str5 = new String(split[2]);
                            str4 = Uri.decode(str5);
                            if (str4.length() < 1024 || str4 == str5) {
                                hashMap2.put(str5, str4);
                            }
                        }
                        if (!hashMap.containsKey(str3)) {
                            hashMap.put(str3, new HashMap());
                        }
                        ((Map) hashMap.get(str3)).put(decode, str4);
                    } else if (readLine.length() != 0) {
                        "Invalid: ".concat(readLine);
                    } else {
                        new String("Invalid: ");
                    }
                }
                String.valueOf(file2).length();
                zzco zzco = new zzco(hashMap);
                bufferedReader.close();
                zzde2 = zzde.zzd(zzco);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            zzde2 = zzde.zzc();
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzde2;
        throw th;
    }
}
