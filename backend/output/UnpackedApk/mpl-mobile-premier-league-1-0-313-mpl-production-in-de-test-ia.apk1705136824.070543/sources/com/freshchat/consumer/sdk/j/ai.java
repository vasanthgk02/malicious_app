package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.os.Process;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class ai {
    public static File aR(Context context) {
        CharSequence charSequence;
        if (Process.myPid() > 0) {
            charSequence = Integer.toString(r0) + "):";
        } else {
            charSequence = null;
        }
        ar arVar = new ar();
        arVar.v(1000);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(u(10000)).getInputStream()), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!cl() || readLine.contains(charSequence)) {
                    arVar.add(readLine);
                }
            }
        } catch (IOException e2) {
            e("FRESHCHAT", "Mobihelp could not retrieve data from LogCat", e2);
        }
        File q = q(context, "debuglog");
        try {
            q.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(q, true));
            Iterator it = arVar.iterator();
            while (it.hasNext()) {
                bufferedWriter.append((String) it.next());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            return q;
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean ck() {
        return false;
    }

    public static boolean cl() {
        return aw.eV() && Process.myPid() > 0;
    }

    public static void d(Context context, String str, String str2) {
        Toast.makeText(context, str2, 0).show();
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th) {
    }

    public static void i(String str, String str2) {
    }

    public static File q(Context context, String str) {
        if (context != null) {
            try {
                return File.createTempFile(str, ".txt", context.getCacheDir());
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static String u(int i) {
        return "logcat -d -v time" + " -t " + i + " dalvikvm:I AndroidRuntime:E HOTLINE:S HOTLINE_WARNING:S HOTLINE_SERVICE:S *:D";
    }

    public static void w(String str, String str2) {
    }

    public static void w(String str, String str2, Throwable th) {
    }
}
