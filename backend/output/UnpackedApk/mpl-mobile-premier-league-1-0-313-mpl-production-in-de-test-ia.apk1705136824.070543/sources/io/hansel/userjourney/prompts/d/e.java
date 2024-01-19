package io.hansel.userjourney.prompts.d;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import io.hansel.R;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.utils.HSLUtils;
import io.hansel.segments.c;
import io.hansel.userjourney.prompts.b0;
import io.hansel.userjourney.prompts.f0;
import io.hansel.userjourney.prompts.p0;
import io.hansel.userjourney.prompts.w;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5520a;

    /* renamed from: b  reason: collision with root package name */
    public c f5521b;

    public e(Context context, c cVar) {
        this.f5520a = context;
        this.f5521b = cVar;
    }

    public boolean a(View view, CoreJSONObject coreJSONObject, w wVar) {
        int i;
        if (wVar == w.label0) {
            i = R.id.label0;
        } else if (wVar == w.label1) {
            i = R.id.label1;
        } else if (wVar == w.label2) {
            i = R.id.label2;
        } else if (wVar == w.label3) {
            i = R.id.label3;
        } else if (wVar == w.npsInputLabel) {
            i = R.id.npsInputLabel;
        } else if (wVar == w.label4) {
            i = R.id.label4;
        } else if (wVar == w.label5) {
            i = R.id.label5;
        } else if (wVar != w.label6) {
            return false;
        } else {
            i = R.id.label6;
        }
        return a((TextView) view.findViewById(i), coreJSONObject, wVar);
    }

    public boolean a(TextView textView, CoreJSONObject coreJSONObject, w wVar) {
        int i;
        int i2;
        int i3;
        int dpToPx;
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("props");
        if (wVar == w.label0) {
            i2 = HSLUtils.dpToPx(24);
            i = HSLUtils.dpToPx(24);
        } else {
            if (wVar == w.label1) {
                dpToPx = HSLUtils.dpToPx(24);
            } else {
                if (wVar == w.label2) {
                    i3 = 8;
                } else if (wVar == w.label3) {
                    i3 = 6;
                } else if (wVar == w.npsInputLabel) {
                    i3 = 32;
                } else if (wVar != w.label4 && wVar != w.label5 && wVar != w.label6) {
                    return false;
                } else {
                    b0.a().a(textView, optJSONObject);
                    i2 = 0;
                    i = 0;
                }
                dpToPx = HSLUtils.dpToPx(i3);
            }
            i2 = dpToPx;
            i = 0;
        }
        String optString = optJSONObject.optString("align");
        textView.setGravity(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(optString) ? 3 : RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(optString) ? 5 : 17);
        b0.a().a(optJSONObject, textView, 0, i2, 0, i);
        return f0.a(this.f5520a, textView, optJSONObject, true, p0.TEXT, null, this.f5521b);
    }
}
