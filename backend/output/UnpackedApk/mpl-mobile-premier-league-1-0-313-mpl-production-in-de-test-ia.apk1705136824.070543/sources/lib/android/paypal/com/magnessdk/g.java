package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lib.android.paypal.com.magnessdk.b.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class g {
    public static boolean bj;
    public static String bk;

    public long a(int i) {
        String str;
        long blockSize;
        int blockCount;
        File file = new File("/storage");
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = listFiles[i2];
                    if (file2.exists()) {
                        try {
                            if (Environment.isExternalStorageRemovable(file2)) {
                                str = file2.getAbsolutePath();
                                break;
                            }
                        } catch (Exception e2) {
                            a.a(getClass(), 3, (Throwable) e2);
                        }
                    }
                    i2++;
                }
            }
            str = "";
            if (!str.isEmpty()) {
                File file3 = new File(str);
                if (file3.exists()) {
                    StatFs statFs = new StatFs(file3.getPath());
                    if (i == 600) {
                        blockSize = (long) statFs.getBlockSize();
                        blockCount = statFs.getAvailableBlocks();
                    } else if (i == 601) {
                        blockSize = (long) statFs.getBlockSize();
                        blockCount = statFs.getBlockCount();
                    }
                    return blockSize * ((long) blockCount);
                }
            }
        }
        return 12345;
    }

    public Object a(Object obj) {
        boolean z = obj instanceof Integer;
        Object valueOf = Integer.valueOf(-400);
        if (z) {
            if (((Integer) obj).intValue() == 12345) {
                obj = valueOf;
            }
            return obj;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 12345.0d) {
                obj = valueOf;
            }
            return obj;
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == 12345) {
                obj = valueOf;
            }
            return obj;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 12345.0f) {
                obj = valueOf;
            }
            return obj;
        } else if (!(obj instanceof String)) {
            return valueOf;
        } else {
            if (obj.equals("default")) {
                obj = "-400";
            }
            return obj;
        }
    }

    public abstract JSONObject a();

    public final boolean a(int i, String str, String str2) {
        boolean z = false;
        if (!str.equalsIgnoreCase("")) {
            String lowerCase = str.toLowerCase();
            int abs = Math.abs(i);
            int abs2 = Math.abs(lowerCase.hashCode());
            if (abs2 > 0) {
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 115) {
                    if (hashCode != 3343) {
                        if (hashCode != 3696) {
                            if (hashCode == 3711 && str2.equals("ts")) {
                                c2 = 2;
                            }
                        } else if (str2.equals("td")) {
                            c2 = 3;
                        }
                    } else if (str2.equals("hw")) {
                        c2 = 1;
                    }
                } else if (str2.equals("s")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        abs2 /= 100;
                    } else if (c2 == 2) {
                        abs2 /= 10000;
                    } else if (c2 != 3) {
                        return false;
                    } else {
                        abs2 /= 1000000;
                    }
                }
                int i2 = abs2 % 100;
                if (i2 < abs) {
                    bj = true;
                }
                if (i2 < abs) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean a(Context context, String str) {
        boolean z = false;
        try {
            if (context.checkCallingOrSelfPermission(str) == 0) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            a.a(getClass(), 3, (Throwable) e2);
            return false;
        }
    }

    public boolean a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (true) {
            if (i >= split.length && i >= split2.length) {
                return false;
            }
            if (i >= split.length || i >= split2.length) {
                if (i < split.length) {
                    if (Integer.parseInt(split[i]) != 0) {
                        return true;
                    }
                } else if (i < split2.length && Integer.parseInt(split2[i]) != 0) {
                    return false;
                }
            } else if (Integer.parseInt(split[i]) < Integer.parseInt(split2[i])) {
                return false;
            } else {
                if (Integer.parseInt(split[i]) > Integer.parseInt(split2[i])) {
                    return true;
                }
            }
            i++;
        }
    }

    public boolean a(d dVar, int i, String str, String str2, Context context) {
        try {
            JSONObject optJSONObject = dVar.h.optJSONObject(str2);
            if (optJSONObject != null) {
                if (!str.equalsIgnoreCase("")) {
                    String string = optJSONObject.getString(c$i.MIN_VERSION.toString());
                    String replaceAll = "5.1.1.release".replaceAll(".debug", "").replaceAll(".release", "");
                    if (!string.equalsIgnoreCase("")) {
                        if (a(replaceAll, string)) {
                            if (optJSONObject.getBoolean(c$i.OPEN.toString())) {
                                return a(optJSONObject, i, context);
                            }
                            if (i != MagnesSource.PAYPAL.getVersion()) {
                                if (i != MagnesSource.VENMO.getVersion()) {
                                    return false;
                                }
                            }
                            return a(optJSONObject.optInt(c$i.RAMP_THRESHOLD.toString(), 0), str, str2);
                        }
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            a.a(getClass(), 3, (Throwable) e2);
            return false;
        }
    }

    public JSONObject b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RiskManagerMG", 0);
        bk = sharedPreferences.getString("RiskManagerMG", "");
        long j = sharedPreferences.getLong("RiskManagerMGTIMESTAMP", 0);
        if (bk.equals("") && j == 0) {
            bk = f.a(true);
            j = System.currentTimeMillis();
            Editor edit = sharedPreferences.edit();
            edit.putString("RiskManagerMG", bk);
            edit.putLong("RiskManagerMGTIMESTAMP", j);
            edit.apply();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", bk);
        hashMap.put("created_at", j + "");
        try {
            return new JSONObject("{\"id\":" + ((String) hashMap.get("id")) + ",\"created_at\":" + ((String) hashMap.get("created_at")) + "}");
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject b(String str, JSONArray jSONArray, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(c$a.FEATURE.toString(), str2);
        jSONObject.put(c$a.PAYLOAD.toString(), jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pairing_id", str);
        String c_a = c$a.AUDIT_KEY.toString();
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(jSONObject);
        jSONObject2.put(c_a, jSONArray2);
        return jSONObject2;
    }

    public boolean a(JSONObject jSONObject, int i, Context context) {
        try {
            String packageName = context.getPackageName();
            if (f.a(f.a(jSONObject.getJSONArray(c$i.EXCLUDED.toString())), "5.1.1.release".replaceAll(".debug", "").replaceAll(".release", ""))) {
                List<String> a2 = f.a(jSONObject.getJSONArray(c$i.APP_IDS.toString()));
                JSONArray jSONArray = jSONObject.getJSONArray(c$i.APP_SOURCES.toString());
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    if (jSONArray.length() > 0) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add((Integer) jSONArray.get(i2));
                        }
                    }
                }
                if (arrayList.contains(Integer.valueOf(i)) || f.a(a2, packageName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            a.a(getClass(), 3, (Throwable) e2);
            return false;
        }
    }
}
