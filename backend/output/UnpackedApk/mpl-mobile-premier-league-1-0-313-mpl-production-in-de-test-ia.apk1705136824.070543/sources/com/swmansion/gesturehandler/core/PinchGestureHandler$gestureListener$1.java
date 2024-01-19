package com.swmansion.gesturehandler.core;

import com.swmansion.gesturehandler.core.ScaleGestureDetector.OnScaleGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/swmansion/gesturehandler/core/PinchGestureHandler$gestureListener$1", "Lcom/swmansion/gesturehandler/core/ScaleGestureDetector$OnScaleGestureListener;", "onScale", "", "detector", "Lcom/swmansion/gesturehandler/core/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchGestureHandler.kt */
public final class PinchGestureHandler$gestureListener$1 implements OnScaleGestureListener {
    public final /* synthetic */ PinchGestureHandler this$0;

    public PinchGestureHandler$gestureListener$1(PinchGestureHandler pinchGestureHandler) {
        this.this$0 = pinchGestureHandler;
        PinchGestureHandler pinchGestureHandler2 = this.this$0;
        if (pinchGestureHandler2 != null) {
            pinchGestureHandler2.shouldCancelWhenOutside = false;
            return;
        }
        throw null;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
        PinchGestureHandler pinchGestureHandler = this.this$0;
        double d2 = pinchGestureHandler.scale;
        float f2 = 1.0f;
        if (scaleGestureDetector.inAnchoredScaleMode()) {
            boolean z = (scaleGestureDetector.mEventBeforeOrAboveStartingGestureEvent && scaleGestureDetector.mCurrSpan < scaleGestureDetector.mPrevSpan) || (!scaleGestureDetector.mEventBeforeOrAboveStartingGestureEvent && scaleGestureDetector.mCurrSpan > scaleGestureDetector.mPrevSpan);
            float abs = Math.abs(1.0f - (scaleGestureDetector.mCurrSpan / scaleGestureDetector.mPrevSpan)) * 0.5f;
            if (scaleGestureDetector.mPrevSpan > ((float) scaleGestureDetector.mSpanSlop)) {
                f2 = z ? 1.0f + abs : 1.0f - abs;
            }
        } else {
            float f3 = scaleGestureDetector.mPrevSpan;
            if (f3 > 0.0f) {
                f2 = scaleGestureDetector.mCurrSpan / f3;
            }
        }
        pinchGestureHandler.scale = ((double) f2) * d2;
        long j = scaleGestureDetector.mCurrTime - scaleGestureDetector.mPrevTime;
        if (j > 0) {
            PinchGestureHandler pinchGestureHandler2 = this.this$0;
            pinchGestureHandler2.velocity = (pinchGestureHandler2.scale - d2) / ((double) j);
        }
        float abs2 = Math.abs(this.this$0.startingSpan - scaleGestureDetector.mCurrSpan);
        PinchGestureHandler pinchGestureHandler3 = this.this$0;
        if (abs2 >= pinchGestureHandler3.spanSlop && pinchGestureHandler3.state == 2) {
            pinchGestureHandler3.activate(false);
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
        this.this$0.startingSpan = scaleGestureDetector.mCurrSpan;
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        Intrinsics.checkNotNullParameter(scaleGestureDetector, "detector");
    }
}
