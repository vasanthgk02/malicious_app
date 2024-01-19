package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import in.juspay.hypersdk.core.DuiCallback;

@Keep
public class BottomSheetLayout extends FrameLayout {
    public final BottomSheetBehavior bottomSheetBehavior = new BottomSheetBehavior();
    public final BottomSheetCallback bottomSheetCallback;

    public class BottomSheetCallback extends com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback {
        public float bottomShift;
        public boolean bottomShiftOverridden = false;
        public DuiCallback duiCallback;
        public float lastReceivedScroll;
        public String stateChangeCallback;
        public String stateSlideCallback;
        public float topShift;
        public boolean topShiftOverridden = false;

        public BottomSheetCallback() {
        }

        public void onSlide(View view, float f2) {
            this.lastReceivedScroll = f2;
            DuiCallback duiCallback2 = this.duiCallback;
            if (duiCallback2 != null && this.stateSlideCallback != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                outline73.append(this.stateSlideCallback);
                outline73.append("','");
                outline73.append(f2);
                outline73.append("');");
                duiCallback2.addJsToWebView(outline73.toString());
            }
        }

        public void onStateChanged(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior;
            int i2;
            if (i == 2) {
                if (!this.topShiftOverridden || !this.bottomShiftOverridden) {
                    float f2 = BottomSheetLayout.this.bottomSheetBehavior.halfExpandedRatio;
                    BottomSheetBehavior access$000 = BottomSheetLayout.this.bottomSheetBehavior;
                    float height = ((float) (access$000.peekHeightAuto ? -1 : access$000.peekHeight)) / ((float) view.getHeight());
                    if (!this.topShiftOverridden) {
                        this.topShift = (f2 / 2.0f) + 0.5f;
                    }
                    if (!this.bottomShiftOverridden) {
                        this.bottomShift = (f2 / 2.0f) - (height / 2.0f);
                    }
                }
                float f3 = this.bottomShift;
                float f4 = this.lastReceivedScroll;
                if (f3 > f4) {
                    bottomSheetBehavior = BottomSheetLayout.this.bottomSheetBehavior;
                    i2 = 4;
                } else if (f4 <= f3 || f4 >= this.topShift) {
                    bottomSheetBehavior = BottomSheetLayout.this.bottomSheetBehavior;
                    i2 = 3;
                } else {
                    bottomSheetBehavior = BottomSheetLayout.this.bottomSheetBehavior;
                    i2 = 6;
                }
                bottomSheetBehavior.setState(i2);
            }
            DuiCallback duiCallback2 = this.duiCallback;
            if (duiCallback2 != null && this.stateChangeCallback != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("window.callUICallback('");
                outline73.append(this.stateChangeCallback);
                outline73.append("','");
                outline73.append(i);
                outline73.append("');");
                duiCallback2.addJsToWebView(outline73.toString());
            }
        }

        public void setBottomShift(float f2) {
            this.bottomShiftOverridden = true;
            this.bottomShift = f2;
        }

        public void setDuiCallback(DuiCallback duiCallback2) {
            this.duiCallback = duiCallback2;
        }

        public void setSlideCallback(String str) {
            this.stateSlideCallback = str;
        }

        public void setStateChangeCallback(String str) {
            this.stateChangeCallback = str;
        }

        public void setTopShift(float f2) {
            this.topShiftOverridden = true;
            this.topShift = f2;
        }
    }

    public BottomSheetLayout(Context context) {
        super(context);
        BottomSheetCallback bottomSheetCallback2 = new BottomSheetCallback();
        this.bottomSheetCallback = bottomSheetCallback2;
        this.bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback2);
    }

    @Keep
    public void setBottomShift(float f2) {
        this.bottomSheetCallback.setBottomShift(f2);
    }

    @Keep
    public void setHalfExpandedRatio(float f2) {
        this.bottomSheetBehavior.setHalfExpandedRatio(f2);
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(this.bottomSheetBehavior);
        }
        super.setLayoutParams(layoutParams);
    }

    @Keep
    public void setPeakHeight(int i) {
        this.bottomSheetBehavior.setPeekHeight(i);
    }

    public void setSlideCallback(DuiCallback duiCallback, String str) {
        this.bottomSheetCallback.setDuiCallback(duiCallback);
        this.bottomSheetCallback.setSlideCallback(str);
    }

    @Keep
    public void setState(int i) {
        this.bottomSheetBehavior.setState(i);
    }

    public void setStateChangeCallback(DuiCallback duiCallback, String str) {
        this.bottomSheetCallback.setDuiCallback(duiCallback);
        this.bottomSheetCallback.setStateChangeCallback(str);
    }

    @Keep
    public void setTopShift(float f2) {
        this.bottomSheetCallback.setTopShift(f2);
    }
}
