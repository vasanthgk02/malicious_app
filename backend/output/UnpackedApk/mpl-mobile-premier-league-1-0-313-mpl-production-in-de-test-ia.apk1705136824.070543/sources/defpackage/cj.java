package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

/* renamed from: cj  reason: default package */
public final class cj {

    /* renamed from: a  reason: collision with root package name */
    public static SQLiteDatabase f2829a;

    public cj() throws Exception {
        throw new Exception("This class is not instantiable!");
    }

    public static synchronized SQLiteDatabase a(Context context) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (cj.class) {
            if (f2829a == null) {
                try {
                    f2829a = new ao(context).getWritableDatabase();
                } catch (SQLiteException unused) {
                    try {
                        cp.a((String) "cj", (String) "deleteDatabase so we can create it from scratch");
                        context.deleteDatabase("MAPDataStore.db");
                    } catch (SQLiteException e2) {
                        cp.a((String) "cj", "deleteDatabase exception: " + e2.getMessage());
                    }
                    f2829a = new ao(context).getWritableDatabase();
                }
            }
            sQLiteDatabase = f2829a;
        }
        return sQLiteDatabase;
    }

    public static String a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("host.type")) {
                return "www";
            }
            String string = applicationInfo.metaData.getString("host.type");
            cp.a((String) "cj", (String) "Host Type", "hostType=" + string + " package=" + str);
            return string;
        } catch (NameNotFoundException unused) {
            cp.a((String) "cj", "No host type found in package " + str);
            return "www";
        }
    }

    public static String a(String[] strArr, String str) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        int i = 0;
        String str2 = "";
        while (i < strArr.length) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str2);
            outline73.append(strArr[i].trim());
            outline73.append(i == strArr.length + -1 ? "" : str);
            str2 = outline73.toString();
            i++;
        }
        return str2;
    }

    public static String[] a(String str, String str2) {
        if (str == null || str.trim().length() <= 0) {
            return null;
        }
        String trim = str.trim();
        return trim.split("[" + str2 + CMapParser.MARK_END_OF_ARRAY);
    }
}
