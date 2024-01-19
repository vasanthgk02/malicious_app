package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic extends MotionInterpolator {
    public StopEngine mEngine;
    public SpringStopEngine mSpringStopEngine;
    public StopLogicEngine mStopLogicEngine;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.mStopLogicEngine = stopLogicEngine;
        this.mEngine = stopLogicEngine;
    }

    public void config(float f2, float f3, float f4, float f5, float f6, float f7) {
        StopLogicEngine stopLogicEngine = this.mStopLogicEngine;
        this.mEngine = stopLogicEngine;
        stopLogicEngine.mStartPosition = f2;
        boolean z = f2 > f3;
        stopLogicEngine.mBackwards = z;
        if (z) {
            stopLogicEngine.setup(-f4, f2 - f3, f6, f7, f5);
        } else {
            stopLogicEngine.setup(f4, f3 - f2, f6, f7, f5);
        }
    }

    public float getInterpolation(float f2) {
        return this.mEngine.getInterpolation(f2);
    }

    public float getVelocity() {
        return this.mEngine.getVelocity();
    }
}
