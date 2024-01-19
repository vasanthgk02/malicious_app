package androidx.dynamicanimation.animation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    public boolean mEndRequested = false;
    public float mPendingPosition = Float.MAX_VALUE;
    public SpringForce mSpring = null;

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
    }
}
