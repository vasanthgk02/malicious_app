package defpackage;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: cp  reason: default package */
public final class cp {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3313a = "cp";

    /* renamed from: a  reason: collision with other field name */
    public static boolean f124a;

    static {
        boolean z = false;
        try {
            String str = VERSION.INCREMENTAL;
            if (!TextUtils.isEmpty(str)) {
                Pattern compile = Pattern.compile("^(?:(.*?)_)??(?:([^_]*)_)?([0-9]+)$");
                String str2 = f3313a;
                a(str2, (String) "Extracting verison incremental", "Build.VERSION.INCREMENTAL: " + str);
                Matcher matcher = compile.matcher(str);
                if (!matcher.find()) {
                    String str3 = f3313a;
                    a(str3, (String) "Incremental version '%s' was in invalid format.", "ver=" + str);
                } else if (matcher.groupCount() >= 3) {
                    String group = matcher.group(2);
                    String str4 = f3313a;
                    a(str4, (String) "Extracting flavor", "Build flavor: " + group);
                    if (!TextUtils.isEmpty(group) && (group.equals("userdebug") || group.equals("eng"))) {
                        z = true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        f124a = z;
    }

    public static int a(String str, String str2) {
        return Log.d(str, str2);
    }

    public static int a(String str, String str2, String str3) {
        return a(str, str2, str3, null);
    }

    public static int a(String str, String str2, String str3, Throwable th) {
        if (str == null) {
            str = "NULL_TAG";
        }
        String outline50 = GeneratedOutlineSupport.outline50(str, ".PII");
        char c2 = 3;
        if (f124a) {
            c2 = 4;
        } else {
            cd.a();
            if (Log.isLoggable("com.amazon.identity.pii", 3)) {
                return a(outline50, str2, str3, th, 3);
            }
            str3 = "<obscured>";
        }
        String a2 = a(str2, str3);
        return th != null ? c2 == 4 ? Log.i(outline50, a2, th) : Log.d(outline50, a2, th) : c2 == 4 ? Log.i(outline50, a2) : Log.d(outline50, a2);
    }

    public static int a(String str, String str2, String str3, Throwable th, int i) {
        String a2 = a(str2, str3);
        return th != null ? i == 4 ? Log.i(str, a2, th) : Log.d(str, a2, th) : i == 4 ? Log.i(str, a2) : Log.d(str, a2);
    }

    public static int a(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m304a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (!TextUtils.isEmpty(str2)) {
            stringBuffer.append(":");
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public static int b(String str, String str2) {
        return Log.e(str, str2);
    }

    public static int c(String str, String str2) {
        return Log.i(str, str2);
    }

    public static int d(String str, String str2) {
        return Log.w(str, str2);
    }
}
