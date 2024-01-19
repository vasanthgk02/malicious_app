package com.shield.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.shield.android.d.d;
import com.shield.android.internal.NativeUtils;
import com.shield.android.internal.f;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import sfs2x.client.entities.invitation.InvitationReply;

public class ArpDataCollector {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1445a;

    public ArpDataCollector(Context context) {
        this.f1445a = context;
    }

    public static void a(String str, d dVar) {
        boolean z = false;
        try {
            ArrayList arrayList = new ArrayList(InvitationReply.EXPIRED);
            for (int i = 0; i < 255; i++) {
                String str2 = str + i;
                arrayList.add(Runtime.getRuntime().exec("ping -c 3 " + str2));
            }
            for (int i2 = 0; i2 < 255; i2++) {
                ((Process) arrayList.get(i2)).waitFor();
            }
            z = true;
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
        if (z) {
            dVar.a();
        }
    }

    public String getARP() {
        StringBuilder sb = new StringBuilder();
        if (VERSION.SDK_INT >= 29) {
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
                ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
                AutoCloseInputStream autoCloseInputStream = new AutoCloseInputStream(parcelFileDescriptor);
                if (new NativeUtils(this.f1445a).getArpCache(parcelFileDescriptor2.detachFd()) != 0) {
                    return "Arp failed";
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(" +");
                    if (split.length >= 4) {
                        sb.append(split[4]);
                        sb.append(",");
                    }
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } catch (IOException e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
        } else {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/net/arp"));
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    String[] split2 = readLine2.split(" +");
                    if (split2.length >= 4 && !split2[3].equals("00:00:00:00:00:00") && split2[3].matches("..:..:..:..:..:..")) {
                        sb.append(split2[3]);
                        sb.append(",");
                    }
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } catch (FileNotFoundException e3) {
                if (f.a().f1677b && e3.getMessage() != null) {
                    e3.getLocalizedMessage();
                }
            } catch (IOException e4) {
                if (f.a().f1677b && e4.getMessage() != null) {
                    e4.getLocalizedMessage();
                }
            }
        }
        return sb.toString();
    }
}
