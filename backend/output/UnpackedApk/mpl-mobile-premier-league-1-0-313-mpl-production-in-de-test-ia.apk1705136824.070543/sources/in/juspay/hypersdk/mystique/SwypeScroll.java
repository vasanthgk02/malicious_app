package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ScrollView;
import androidx.annotation.Keep;

@Keep
public class SwypeScroll extends ScrollView {
    public float lastX;
    public float lastY;
    public float xDistance;
    public float yDistance;

    public SwypeScroll(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.xDistance = Math.abs(x - this.lastX) + this.xDistance;
            float abs = Math.abs(y - this.lastY) + this.yDistance;
            this.yDistance = abs;
            this.lastX = x;
            this.lastY = y;
            if (this.xDistance > abs) {
                return false;
            }
            SwypeLayout swypeLayout = SwypeLayout.partialSwype;
            if (!(swypeLayout == null || swypeLayout == SwypeLayout.activeLayout)) {
                SwypeLayout.partialSwype.reset();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
