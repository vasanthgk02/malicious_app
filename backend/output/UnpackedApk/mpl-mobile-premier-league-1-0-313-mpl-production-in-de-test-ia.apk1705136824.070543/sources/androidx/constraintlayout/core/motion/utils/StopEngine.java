package androidx.constraintlayout.core.motion.utils;

public interface StopEngine {
    float getInterpolation(float f2);

    float getVelocity();

    boolean isStopped();
}
