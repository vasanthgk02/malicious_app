package com.swmansion.gesturehandler.core;

import com.swmansion.gesturehandler.core.RotationGestureDetector.OnRotationGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/swmansion/gesturehandler/core/RotationGestureHandler$gestureListener$1", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector$OnRotationGestureListener;", "onRotation", "", "detector", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector;", "onRotationBegin", "onRotationEnd", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RotationGestureHandler.kt */
public final class RotationGestureHandler$gestureListener$1 implements OnRotationGestureListener {
    public final /* synthetic */ RotationGestureHandler this$0;

    public RotationGestureHandler$gestureListener$1(RotationGestureHandler rotationGestureHandler) {
        this.this$0 = rotationGestureHandler;
    }

    public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
        Intrinsics.checkNotNullParameter(rotationGestureDetector, "detector");
        RotationGestureHandler rotationGestureHandler = this.this$0;
        double d2 = rotationGestureHandler.rotation;
        double d3 = rotationGestureDetector.rotation + d2;
        rotationGestureHandler.rotation = d3;
        long j = rotationGestureDetector.currentTime - rotationGestureDetector.previousTime;
        if (j > 0) {
            rotationGestureHandler.velocity = (d3 - d2) / ((double) j);
        }
        if (Math.abs(this.this$0.rotation) >= 0.08726646259971647d) {
            RotationGestureHandler rotationGestureHandler2 = this.this$0;
            if (rotationGestureHandler2.state == 2) {
                rotationGestureHandler2.activate(false);
            }
        }
        return true;
    }

    public boolean onRotationBegin(RotationGestureDetector rotationGestureDetector) {
        Intrinsics.checkNotNullParameter(rotationGestureDetector, "detector");
        return true;
    }

    public void onRotationEnd(RotationGestureDetector rotationGestureDetector) {
        Intrinsics.checkNotNullParameter(rotationGestureDetector, "detector");
        this.this$0.end();
    }
}
