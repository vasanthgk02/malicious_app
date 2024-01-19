package io.hansel.userjourney.prompts;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.n;
import org.apache.fontbox.cmap.CMap;

public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static b0 f5491a;

    public static b0 a() {
        if (f5491a == null) {
            synchronized (b0.class) {
                if (f5491a == null) {
                    f5491a = new b0();
                }
            }
        }
        return f5491a;
    }

    public void a(View view, CoreJSONObject coreJSONObject) {
        if (coreJSONObject.has("spacing")) {
            String[] split = coreJSONObject.optString("spacing").replaceAll("px", "").split(CMap.SPACE);
            if (split.length == 4) {
                view.setPadding(HSLUtils.dpToPx(Integer.parseInt(split[3])), HSLUtils.dpToPx(Integer.parseInt(split[0])), HSLUtils.dpToPx(Integer.parseInt(split[1])), HSLUtils.dpToPx(Integer.parseInt(split[2])));
            }
        }
    }

    public void a(CoreJSONObject coreJSONObject, View view, int i, int i2, int i3, int i4) {
        String[] split = coreJSONObject.optString("spacing").split(CMap.SPACE);
        if (split.length == 4) {
            i2 = HSLUtils.dpToPx(n.b(split[0]));
            i3 = HSLUtils.dpToPx(n.b(split[1]));
            i4 = HSLUtils.dpToPx(n.b(split[2]));
            i = HSLUtils.dpToPx(n.b(split[3]));
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.rightMargin = i3;
        marginLayoutParams.bottomMargin = i4;
        view.setLayoutParams(marginLayoutParams);
    }
}
