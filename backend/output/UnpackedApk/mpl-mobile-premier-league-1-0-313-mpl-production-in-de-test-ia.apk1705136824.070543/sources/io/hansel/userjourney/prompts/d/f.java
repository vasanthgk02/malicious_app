package io.hansel.userjourney.prompts.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import io.hansel.R;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.userjourney.prompts.IndicatorView;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f5522a;

    public f(Context context) {
    }

    private int a(CoreJSONObject coreJSONObject, int i) {
        CoreJSONObject coreJSONObject2;
        try {
            coreJSONObject2 = coreJSONObject.getJSONObject("width");
        } catch (CoreJSONException e2) {
            e2.printStackTrace();
            coreJSONObject2 = null;
        }
        int optInt = coreJSONObject2.optInt(HSLCriteriaBuilder.VALUE, 0);
        if (optInt == 0) {
            return 0;
        }
        if ("%".equals(coreJSONObject2.optString("unit", ""))) {
            optInt = (i * optInt) / 100;
        }
        return optInt;
    }

    public int a() {
        return this.f5522a;
    }

    public boolean a(View view, CoreJSONObject coreJSONObject, int i) {
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("props");
        this.f5522a = (optJSONObject == null || !optJSONObject.has("width")) ? 0 : a(optJSONObject, i);
        IndicatorView indicatorView = (IndicatorView) view.findViewById(R.id.stepper);
        LayoutParams layoutParams = indicatorView.getLayoutParams();
        layoutParams.width = this.f5522a;
        indicatorView.setLayoutParams(layoutParams);
        indicatorView.a(optJSONObject, this.f5522a);
        String optString = optJSONObject.optString("align");
        indicatorView.setGravity(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(optString) ? 3 : RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(optString) ? 5 : 17);
        return true;
    }
}
