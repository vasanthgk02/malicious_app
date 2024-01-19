package io.hansel.core.utils;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import io.hansel.core.b;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.logger.HSLLogger;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class HSLUtils {
    public static DisplayMetrics displaymetrics = b.e().d().getResources().getDisplayMetrics();

    public static <T> void cleanList(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
    }

    public static void clearClipboard(Context context) {
        if (context != null && isAndroidOSLessThanVersion(31)) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText("", "");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
        }
    }

    public static String clipboardData(Context context) {
        CharSequence charSequence;
        if (context != null && isAndroidOSLessThanVersion(31)) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (!(clipboardManager == null || clipboardManager.getPrimaryClip() == null || clipboardManager.getPrimaryClip().getItemCount() <= 0)) {
                Item itemAt = clipboardManager.getPrimaryClip().getItemAt(0);
                if (itemAt != null) {
                    charSequence = itemAt.getText();
                    return charSequence.toString();
                }
            }
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static String colorIntToHex(int i) {
        return String.format("#%08X", new Object[]{Integer.valueOf(i & -1)});
    }

    public static Set<Integer> createSetFromIntegerArray(CoreJSONArray coreJSONArray) {
        HashSet hashSet = new HashSet();
        if (coreJSONArray == null) {
            return hashSet;
        }
        for (int i = 0; i < coreJSONArray.length(); i++) {
            hashSet.add(Integer.valueOf(coreJSONArray.optInt(i)));
        }
        return hashSet;
    }

    public static int dpToPx(float f2) {
        return (int) (f2 * displaymetrics.density);
    }

    public static int dpToPx(int i) {
        return (int) (((float) i) * displaymetrics.density);
    }

    public static int getIdFromResourceId(Context context, String str) {
        return getIdFromResourceId(context, str, null);
    }

    public static int getIdFromResourceId(Context context, String str, String str2) {
        if (str2 == null || str2.isEmpty() || "id".equals(str2)) {
            str2 = context.getPackageName();
        }
        return context.getResources().getIdentifier(str, "id", str2);
    }

    public static <K, V> Integer getIntegerValueFromMap(HashMap<K, V> hashMap, K k, Integer num) {
        V v = hashMap.get(k);
        return v instanceof Integer ? (Integer) v : num;
    }

    public static long getMillis(String str) {
        if (str == null || str.length() != 4) {
            return 0;
        }
        return (long) ((Integer.parseInt(str.substring(2, 4)) + (Integer.parseInt(str.substring(0, 2)) * 60 * 1)) * 60000);
    }

    public static long getMillisInADay() {
        return 86400000;
    }

    public static String getNumericValue(String str) {
        return str.replaceAll("[^\\d.]", "");
    }

    public static String getReadableTimeFromMillis(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    public static <K, V> String getStringValueFromMap(HashMap<K, V> hashMap, K k, String str) {
        V v = hashMap.get(k);
        return v instanceof String ? String.valueOf(v) : str;
    }

    public static long getTimeOffset(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals(Action.USER)) {
            return (long) TimeZone.getDefault().getRawOffset();
        }
        return getMillis(str.substring(1, 5)) * (str.charAt(0) == '-' ? -1 : 1);
    }

    public static boolean isAndroidOSLessThanVersion(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean isSet(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isValueSet(String str) {
        if (str != null && !str.isEmpty()) {
            return !str.trim().isEmpty();
        }
        return false;
    }

    public static Boolean parseBooleanTagValue(Object obj, String str) {
        StringBuilder sb;
        String str2;
        boolean z = obj instanceof String;
        if (z || (obj instanceof Boolean)) {
            if (z) {
                try {
                    obj = Boolean.valueOf(Boolean.parseBoolean((String) obj));
                } catch (Exception unused) {
                    sb = new StringBuilder();
                    str2 = "Error parsing tag ";
                }
            }
            return Boolean.valueOf(((Boolean) obj).booleanValue());
        }
        sb = new StringBuilder();
        str2 = "Invalid value assigned to tag ";
        sb.append(str2);
        sb.append(str);
        HSLLogger.d(sb.toString());
        return null;
    }

    public static String parseStringTagValue(Object obj, String str) {
        if (obj instanceof String) {
            return (String) obj;
        }
        HSLLogger.d("Invalid value assigned to tag " + str);
        return null;
    }

    public static int pxToDp(float f2) {
        return (int) (f2 / displaymetrics.density);
    }

    public static int pxToSp(float f2) {
        return (int) (f2 / displaymetrics.scaledDensity);
    }

    public static int spToPx(int i) {
        return (int) (((float) i) * displaymetrics.scaledDensity);
    }
}
