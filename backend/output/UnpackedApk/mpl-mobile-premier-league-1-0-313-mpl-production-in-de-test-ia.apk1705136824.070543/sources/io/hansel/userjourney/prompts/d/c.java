package io.hansel.userjourney.prompts.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import io.hansel.R;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.n;
import io.hansel.userjourney.prompts.b0;
import io.hansel.userjourney.prompts.v;
import io.hansel.userjourney.prompts.w;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final e f5510a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5511b;

    public c(Context context, e eVar, d dVar) {
        this.f5510a = eVar;
        this.f5511b = dVar;
    }

    public boolean a(View view, CoreJSONObject coreJSONObject, int i) {
        int i2;
        MarginLayoutParams marginLayoutParams;
        FrameLayout frameLayout;
        View view2 = view;
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("props");
        try {
            CoreJSONObject jSONObject = optJSONObject.getJSONObject("col1Width");
            int optInt = jSONObject.optInt(HSLCriteriaBuilder.VALUE, 0);
            if (optInt == 0) {
                return false;
            }
            int i3 = "%".equals(jSONObject.optString("unit", "")) ? (i * optInt) / 100 : 0;
            if (i3 == 0) {
                return false;
            }
            try {
                String optString = optJSONObject.optString("image_position", RNGestureHandlerModule.KEY_HIT_SLOP_LEFT);
                int dpToPx = HSLUtils.dpToPx(n.b(optJSONObject.optString("gap", "16px")));
                if (!optJSONObject.has("img2") || !optString.equalsIgnoreCase(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
                    i2 = 8;
                } else {
                    i2 = 8;
                    int i4 = dpToPx;
                    if (this.f5511b.a(view, optJSONObject.getJSONObject("img2"), i3, v.imgHcardRight, "")) {
                        view2.findViewById(R.id.frame_img_card_left).setVisibility(8);
                        frameLayout = (FrameLayout) view2.findViewById(R.id.frame_img_card_right);
                        LayoutParams layoutParams = frameLayout.getLayoutParams();
                        layoutParams.width = i3;
                        marginLayoutParams = (MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMarginStart(i4);
                        frameLayout.setLayoutParams(marginLayoutParams);
                        if (!optJSONObject.has("label4") || !this.f5510a.a(view2, optJSONObject.getJSONObject("label4"), w.label4)) {
                            view2.findViewById(R.id.label4).setVisibility(i2);
                        }
                        if (!optJSONObject.has("label6") || !this.f5510a.a(view2, optJSONObject.getJSONObject("label6"), w.label6)) {
                            view2.findViewById(R.id.label6).setVisibility(i2);
                        }
                        b0.a().a(optJSONObject, view2.findViewById(R.id.card_ha), 0, HSLUtils.dpToPx(24), 0, 0);
                        return true;
                    }
                    dpToPx = i4;
                }
                if (optJSONObject.has("img2") && optString.equalsIgnoreCase(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
                    int i5 = dpToPx;
                    if (this.f5511b.a(view, optJSONObject.getJSONObject("img2"), i3, v.imgHcardLeft, "")) {
                        view2.findViewById(R.id.frame_img_card_right).setVisibility(i2);
                        frameLayout = (FrameLayout) view2.findViewById(R.id.frame_img_card_left);
                        LayoutParams layoutParams2 = frameLayout.getLayoutParams();
                        layoutParams2.width = i3;
                        marginLayoutParams = (MarginLayoutParams) layoutParams2;
                        marginLayoutParams.setMarginEnd(i5);
                        frameLayout.setLayoutParams(marginLayoutParams);
                    }
                }
                view2.findViewById(R.id.label4).setVisibility(i2);
                view2.findViewById(R.id.label6).setVisibility(i2);
                b0.a().a(optJSONObject, view2.findViewById(R.id.card_ha), 0, HSLUtils.dpToPx(24), 0, 0);
                return true;
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
                return false;
            }
        } catch (CoreJSONException e2) {
            HSLLogger.printStackTrace(e2);
            return false;
        }
    }
}
