package io.hansel.userjourney.prompts;

import android.content.Context;
import android.util.Pair;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.prompts.d.e;

public class h0 {
    public static Pair<Integer, Boolean> a(Context context, k kVar, e eVar, CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2, w wVar) {
        boolean z = true;
        int i = 0;
        if (!kVar.L()) {
            CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("width");
            double optDouble = optJSONObject.optDouble(HSLCriteriaBuilder.VALUE, 0.0d);
            if (optDouble == 0.0d) {
                HSLLogger.w("Calculating Prompt Width: 0 width", LogGroup.PT);
            }
            if (optDouble != 100.0d) {
                z = false;
            }
            if (optJSONObject.optString("unit", "").equals("%")) {
                i = (int) Math.ceil((((double) (kVar.A().e() ? kVar.A().b() : kVar.A().a())) * optDouble) / 100.0d);
            }
        } else if (coreJSONObject2 != null) {
            int dpToPx = HSLUtils.dpToPx(coreJSONObject.optInt("borderThickness", 0));
            TextView textView = new TextView(context);
            textView.setLayoutParams(new MarginLayoutParams(-2, -2));
            eVar.a(textView, coreJSONObject2, wVar);
            textView.measure(0, 0);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) textView.getLayoutParams();
            int measuredWidth = (dpToPx * 2) + textView.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int b2 = kVar.A().e() ? kVar.A().b() : kVar.A().a();
            int min = Math.min(measuredWidth, b2);
            HSLLogger.d("Calculating Prompt Width: Measured width of FOMO tag is: " + min);
            if (min != b2) {
                z = false;
            }
            i = min;
        } else {
            HSLLogger.d("Calculating Prompt Width: labelJson is null");
            z = false;
        }
        return Pair.create(Integer.valueOf(i), Boolean.valueOf(z));
    }

    public static b a(int i, int i2, int i3, int i4) {
        int i5 = i3 / 2;
        return i2 <= i4 / 2 ? i <= i5 ? b.TOP_LEFT : b.TOP_RIGHT : i <= i5 ? b.BOTTOM_LEFT : b.BOTTOM_RIGHT;
    }

    public static Boolean a(CoreJSONObject coreJSONObject) {
        return Boolean.valueOf(coreJSONObject.optBoolean("send_nudge_events", true));
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof Double) {
                double floor = Math.floor(((Double) obj).doubleValue());
                if (((Double) obj).doubleValue() == floor) {
                    return Integer.toString((int) floor);
                }
                return String.format("%.2f", new Object[]{Double.valueOf(((Double) obj).doubleValue())});
            } else if (obj instanceof Integer) {
                return Integer.toString(((Integer) obj).intValue());
            } else {
                if (obj instanceof Long) {
                    return Long.toString(((Long) obj).longValue());
                }
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue() ? "True" : "False";
                }
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught while trying to convert value " + obj + " for variable support.", LogGroup.PT);
        }
    }

    public static String a(String str) {
        return str.split("___")[0];
    }

    public static String a(String str, k kVar) {
        return kVar.C() == p.HOTSPOT_STAR ? "hotspot_star" : str;
    }

    public static String b(String str) {
        String[] split = str.split("___");
        return GeneratedOutlineSupport.outline50(split[0], split.length > 1 ? split[1] : "");
    }

    public static boolean b(CoreJSONObject coreJSONObject) {
        return coreJSONObject.optString("prompt_type").equals(g0.INVISIBLE.name());
    }
}
