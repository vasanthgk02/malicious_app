package com.badlogic.gdx.graphics.g3d.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Pool;

public class AnimationController extends BaseAnimationController {
    public boolean allowSameAnimation;
    public final Pool<AnimationDesc> animationPool = new Pool<AnimationDesc>() {
        public AnimationDesc newObject() {
            return new AnimationDesc();
        }
    };
    public AnimationDesc current;
    public boolean inAction;
    public boolean justChangedAnimation = false;
    public boolean paused;
    public AnimationDesc previous;
    public AnimationDesc queued;
    public float queuedTransitionTime;
    public float transitionCurrentTime;
    public float transitionTargetTime;

    public static class AnimationDesc {
        public Animation animation;
        public float duration;
        public AnimationListener listener;
        public int loopCount;
        public float offset;
        public float speed;
        public float time;

        public float update(float f2) {
            int i;
            if (!(this.loopCount == 0 || this.animation == null)) {
                float f3 = this.speed * f2;
                float f4 = 0.0f;
                if (!MathUtils.isZero(this.duration)) {
                    float f5 = this.time + f3;
                    this.time = f5;
                    if (this.speed < 0.0f) {
                        float f6 = this.duration;
                        float f7 = f6 - f5;
                        i = (int) Math.abs(f7 / f6);
                        this.time = this.duration - Math.abs(f7 % this.duration);
                    } else {
                        i = (int) Math.abs(f5 / this.duration);
                        this.time = Math.abs(this.time % this.duration);
                    }
                } else {
                    i = 1;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = this.loopCount;
                    if (i3 > 0) {
                        this.loopCount = i3 - 1;
                    }
                    if (this.loopCount != 0) {
                        AnimationListener animationListener = this.listener;
                        if (animationListener != null) {
                            animationListener.onLoop(this);
                        }
                    }
                    if (this.loopCount == 0) {
                        float f8 = this.duration;
                        int i4 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                        float f9 = (((float) ((i - 1) - i2)) * f8) + (i4 < 0 ? f8 - this.time : this.time);
                        if (i4 >= 0) {
                            f4 = this.duration;
                        }
                        this.time = f4;
                        AnimationListener animationListener2 = this.listener;
                        if (animationListener2 != null) {
                            animationListener2.onEnd(this);
                        }
                        return f9;
                    }
                }
                f2 = -1.0f;
            }
            return f2;
        }
    }

    public interface AnimationListener {
        void onEnd(AnimationDesc animationDesc);

        void onLoop(AnimationDesc animationDesc);
    }

    public AnimationController(ModelInstance modelInstance) {
        super(modelInstance);
    }

    private AnimationDesc obtain(Animation animation, float f2, float f3, int i, float f4, AnimationListener animationListener) {
        if (animation == null) {
            return null;
        }
        AnimationDesc animationDesc = (AnimationDesc) this.animationPool.obtain();
        animationDesc.animation = animation;
        animationDesc.listener = animationListener;
        animationDesc.loopCount = i;
        animationDesc.speed = f4;
        animationDesc.offset = f2;
        float f5 = 0.0f;
        if (f3 < 0.0f) {
            f3 = animation.duration - f2;
        }
        animationDesc.duration = f3;
        if (f4 < 0.0f) {
            f5 = f3;
        }
        animationDesc.time = f5;
        return animationDesc;
    }

    public AnimationDesc action(String str, int i, float f2, AnimationListener animationListener, float f3) {
        return action(str, 0.0f, -1.0f, i, f2, animationListener, f3);
    }

    public AnimationDesc animate(String str, float f2) {
        return animate(str, 1, 1.0f, null, f2);
    }

    public AnimationDesc queue(String str, int i, float f2, AnimationListener animationListener, float f3) {
        return queue(str, 0.0f, -1.0f, i, f2, animationListener, f3);
    }

    public AnimationDesc setAnimation(String str) {
        return setAnimation(str, 1, 1.0f, null);
    }

    public void update(float f2) {
        if (!this.paused) {
            AnimationDesc animationDesc = this.previous;
            if (animationDesc != null) {
                float f3 = this.transitionCurrentTime + f2;
                this.transitionCurrentTime = f3;
                if (f3 >= this.transitionTargetTime) {
                    removeAnimation(animationDesc.animation);
                    this.justChangedAnimation = true;
                    this.animationPool.free(this.previous);
                    this.previous = null;
                }
            }
            if (this.justChangedAnimation) {
                this.target.calculateTransforms();
                this.justChangedAnimation = false;
            }
            AnimationDesc animationDesc2 = this.current;
            if (!(animationDesc2 == null || animationDesc2.loopCount == 0 || animationDesc2.animation == null)) {
                float update = animationDesc2.update(f2);
                int i = (update > 0.0f ? 1 : (update == 0.0f ? 0 : -1));
                if (i >= 0) {
                    AnimationDesc animationDesc3 = this.queued;
                    if (animationDesc3 != null) {
                        this.inAction = false;
                        animate(animationDesc3, this.queuedTransitionTime);
                        this.queued = null;
                        if (i > 0) {
                            update(update);
                        }
                        return;
                    }
                }
                AnimationDesc animationDesc4 = this.previous;
                if (animationDesc4 != null) {
                    Animation animation = animationDesc4.animation;
                    float f4 = animationDesc4.offset + animationDesc4.time;
                    AnimationDesc animationDesc5 = this.current;
                    applyAnimations(animation, f4, animationDesc5.animation, animationDesc5.offset + animationDesc5.time, this.transitionCurrentTime / this.transitionTargetTime);
                } else {
                    AnimationDesc animationDesc6 = this.current;
                    applyAnimation(animationDesc6.animation, animationDesc6.offset + animationDesc6.time);
                }
            }
        }
    }

    public AnimationDesc action(String str, float f2, float f3, int i, float f4, AnimationListener animationListener, float f5) {
        return action(obtain(str, f2, f3, i, f4, animationListener), f5);
    }

    public AnimationDesc animate(String str, AnimationListener animationListener, float f2) {
        return animate(str, 1, 1.0f, animationListener, f2);
    }

    public AnimationDesc queue(String str, float f2, float f3, int i, float f4, AnimationListener animationListener, float f5) {
        return queue(obtain(str, f2, f3, i, f4, animationListener), f5);
    }

    public AnimationDesc setAnimation(String str, int i) {
        return setAnimation(str, i, 1.0f, null);
    }

    public AnimationDesc action(Animation animation, float f2, float f3, int i, float f4, AnimationListener animationListener, float f5) {
        return action(obtain(animation, f2, f3, i, f4, animationListener), f5);
    }

    public AnimationDesc animate(String str, int i, AnimationListener animationListener, float f2) {
        return animate(str, i, 1.0f, animationListener, f2);
    }

    public AnimationDesc queue(Animation animation, float f2, float f3, int i, float f4, AnimationListener animationListener, float f5) {
        return queue(obtain(animation, f2, f3, i, f4, animationListener), f5);
    }

    public AnimationDesc setAnimation(String str, AnimationListener animationListener) {
        return setAnimation(str, 1, 1.0f, animationListener);
    }

    public AnimationDesc action(AnimationDesc animationDesc, float f2) {
        if (animationDesc.loopCount >= 0) {
            AnimationDesc animationDesc2 = this.current;
            if (animationDesc2 == null || animationDesc2.loopCount == 0) {
                animate(animationDesc, f2);
            } else {
                AnimationDesc obtain = this.inAction ? null : obtain(animationDesc2);
                this.inAction = false;
                animate(animationDesc, f2);
                this.inAction = true;
                if (obtain != null) {
                    queue(obtain, f2);
                }
            }
            return animationDesc;
        }
        throw new GdxRuntimeException((String) "An action cannot be continuous");
    }

    public AnimationDesc animate(String str, int i, float f2, AnimationListener animationListener, float f3) {
        return animate(str, 0.0f, -1.0f, i, f2, animationListener, f3);
    }

    public AnimationDesc queue(AnimationDesc animationDesc, float f2) {
        AnimationDesc animationDesc2 = this.current;
        if (animationDesc2 == null || animationDesc2.loopCount == 0) {
            animate(animationDesc, f2);
        } else {
            AnimationDesc animationDesc3 = this.queued;
            if (animationDesc3 != null) {
                this.animationPool.free(animationDesc3);
            }
            this.queued = animationDesc;
            this.queuedTransitionTime = f2;
            AnimationDesc animationDesc4 = this.current;
            if (animationDesc4.loopCount < 0) {
                animationDesc4.loopCount = 1;
            }
        }
        return animationDesc;
    }

    public AnimationDesc setAnimation(String str, int i, AnimationListener animationListener) {
        return setAnimation(str, i, 1.0f, animationListener);
    }

    public AnimationDesc animate(String str, float f2, float f3, int i, float f4, AnimationListener animationListener, float f5) {
        return animate(obtain(str, f2, f3, i, f4, animationListener), f5);
    }

    public AnimationDesc setAnimation(String str, int i, float f2, AnimationListener animationListener) {
        return setAnimation(str, 0.0f, -1.0f, i, f2, animationListener);
    }

    public AnimationDesc animate(Animation animation, float f2, float f3, int i, float f4, AnimationListener animationListener, float f5) {
        return animate(obtain(animation, f2, f3, i, f4, animationListener), f5);
    }

    public AnimationDesc setAnimation(String str, float f2, float f3, int i, float f4, AnimationListener animationListener) {
        return setAnimation(obtain(str, f2, f3, i, f4, animationListener));
    }

    public AnimationDesc animate(AnimationDesc animationDesc, float f2) {
        AnimationDesc animationDesc2 = this.current;
        if (animationDesc2 == null || animationDesc2.loopCount == 0) {
            this.current = animationDesc;
        } else if (this.inAction) {
            queue(animationDesc, f2);
        } else if (this.allowSameAnimation || animationDesc == null || animationDesc2.animation != animationDesc.animation) {
            AnimationDesc animationDesc3 = this.previous;
            if (animationDesc3 != null) {
                removeAnimation(animationDesc3.animation);
                this.animationPool.free(this.previous);
            }
            this.previous = this.current;
            this.current = animationDesc;
            this.transitionCurrentTime = 0.0f;
            this.transitionTargetTime = f2;
        } else {
            animationDesc.time = animationDesc2.time;
            this.animationPool.free(animationDesc2);
            this.current = animationDesc;
        }
        return animationDesc;
    }

    public AnimationDesc setAnimation(Animation animation, float f2, float f3, int i, float f4, AnimationListener animationListener) {
        return setAnimation(obtain(animation, f2, f3, i, f4, animationListener));
    }

    public AnimationDesc setAnimation(AnimationDesc animationDesc) {
        AnimationDesc animationDesc2 = this.current;
        if (animationDesc2 == null) {
            this.current = animationDesc;
        } else {
            if (this.allowSameAnimation || animationDesc == null || animationDesc2.animation != animationDesc.animation) {
                removeAnimation(this.current.animation);
            } else {
                animationDesc.time = animationDesc2.time;
            }
            this.animationPool.free(this.current);
            this.current = animationDesc;
        }
        this.justChangedAnimation = true;
        return animationDesc;
    }

    private AnimationDesc obtain(String str, float f2, float f3, int i, float f4, AnimationListener animationListener) {
        if (str == null) {
            return null;
        }
        Animation animation = this.target.getAnimation(str);
        if (animation != null) {
            return obtain(animation, f2, f3, i, f4, animationListener);
        }
        throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("Unknown animation: ", str));
    }

    private AnimationDesc obtain(AnimationDesc animationDesc) {
        return obtain(animationDesc.animation, animationDesc.offset, animationDesc.duration, animationDesc.loopCount, animationDesc.speed, animationDesc.listener);
    }
}
