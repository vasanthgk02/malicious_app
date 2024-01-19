package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.MotionScene.Transition;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintSet.Constraint;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    public int backwardTransition = -1;
    public float dampening = 0.9f;
    public int emptyViewBehavior = 4;
    public int firstViewReference = -1;
    public int forwardTransition = -1;
    public boolean infiniteCarousel = false;
    public Adapter mAdapter = null;
    public int mAnimateTargetDelay = 200;
    public int mIndex = 0;
    public final ArrayList<View> mList = new ArrayList<>();
    public MotionLayout mMotionLayout;
    public int mPreviousIndex = 0;
    public int mTargetIndex = -1;
    public Runnable mUpdateRunnable = new Runnable() {
        public void run() {
            Carousel.this.mMotionLayout.setProgress(0.0f);
            Carousel.this.updateItems();
            Carousel carousel = Carousel.this;
            carousel.mAdapter.onNewItem(carousel.mIndex);
            float velocity = Carousel.this.mMotionLayout.getVelocity();
            Carousel carousel2 = Carousel.this;
            if (carousel2.touchUpMode == 2 && velocity > carousel2.velocityThreshold && carousel2.mIndex < carousel2.mAdapter.count() - 1) {
                Carousel carousel3 = Carousel.this;
                final float f2 = velocity * carousel3.dampening;
                int i = carousel3.mIndex;
                if (i != 0 || carousel3.mPreviousIndex <= i) {
                    Carousel carousel4 = Carousel.this;
                    if (carousel4.mIndex == carousel4.mAdapter.count() - 1) {
                        Carousel carousel5 = Carousel.this;
                        if (carousel5.mPreviousIndex < carousel5.mIndex) {
                            return;
                        }
                    }
                    Carousel.this.mMotionLayout.post(new Runnable() {
                        public void run() {
                            Carousel.this.mMotionLayout.touchAnimateTo(5, 1.0f, f2);
                        }
                    });
                }
            }
        }
    };
    public int nextState = -1;
    public int previousState = -1;
    public int startIndex = 0;
    public int touchUpMode = 1;
    public float velocityThreshold = 2.0f;

    public interface Adapter {
        int count();

        void onNewItem(int i);

        void populate(View view, int i);
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public final boolean enableTransition(int i, boolean z) {
        if (i == -1) {
            return false;
        }
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout == null) {
            return false;
        }
        Transition transition = motionLayout.getTransition(i);
        if (transition == null || z == (!transition.mDisable)) {
            return false;
        }
        transition.mDisable = !z;
        return true;
    }

    public int getCount() {
        Adapter adapter = this.mAdapter;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.mIndex;
    }

    public final void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.firstViewReference = obtainStyledAttributes.getResourceId(index, this.firstViewReference);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.backwardTransition = obtainStyledAttributes.getResourceId(index, this.backwardTransition);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.forwardTransition = obtainStyledAttributes.getResourceId(index, this.forwardTransition);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.emptyViewBehavior = obtainStyledAttributes.getInt(index, this.emptyViewBehavior);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.previousState = obtainStyledAttributes.getResourceId(index, this.previousState);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.nextState = obtainStyledAttributes.getResourceId(index, this.nextState);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.dampening = obtainStyledAttributes.getFloat(index, this.dampening);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.touchUpMode = obtainStyledAttributes.getInt(index, this.touchUpMode);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.velocityThreshold = obtainStyledAttributes.getFloat(index, this.velocityThreshold);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.infiniteCarousel = obtainStyledAttributes.getBoolean(index, this.infiniteCarousel);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ void lambda$updateItems$0$Carousel() {
        this.mMotionLayout.setTransitionDuration(this.mAnimateTargetDelay);
        if (this.mTargetIndex < this.mIndex) {
            this.mMotionLayout.transitionToState(this.previousState, this.mAnimateTargetDelay);
        } else {
            this.mMotionLayout.transitionToState(this.nextState, this.mAnimateTargetDelay);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i = 0; i < this.mCount; i++) {
                int i2 = this.mIds[i];
                View viewById = motionLayout.getViewById(i2);
                if (this.firstViewReference == i2) {
                    this.startIndex = i;
                }
                this.mList.add(viewById);
            }
            this.mMotionLayout = motionLayout;
            if (this.touchUpMode == 2) {
                Transition transition = motionLayout.getTransition(this.forwardTransition);
                if (transition != null) {
                    TouchResponse touchResponse = transition.mTouchResponse;
                    if (touchResponse != null) {
                        touchResponse.mOnTouchUp = 5;
                    }
                }
                Transition transition2 = this.mMotionLayout.getTransition(this.backwardTransition);
                if (transition2 != null) {
                    TouchResponse touchResponse2 = transition2.mTouchResponse;
                    if (touchResponse2 != null) {
                        touchResponse2.mOnTouchUp = 5;
                    }
                }
            }
            updateItems();
        }
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f2) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        int i2 = this.mIndex;
        this.mPreviousIndex = i2;
        if (i == this.nextState) {
            this.mIndex = i2 + 1;
        } else if (i == this.previousState) {
            this.mIndex = i2 - 1;
        }
        if (this.infiniteCarousel) {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = 0;
            }
            if (this.mIndex < 0) {
                this.mIndex = this.mAdapter.count() - 1;
            }
        } else {
            if (this.mIndex >= this.mAdapter.count()) {
                this.mIndex = this.mAdapter.count() - 1;
            }
            if (this.mIndex < 0) {
                this.mIndex = 0;
            }
        }
        if (this.mPreviousIndex != this.mIndex) {
            this.mMotionLayout.post(this.mUpdateRunnable);
        }
    }

    public void setAdapter(Adapter adapter) {
        this.mAdapter = adapter;
    }

    public final void updateItems() {
        Adapter adapter = this.mAdapter;
        if (adapter != null && this.mMotionLayout != null && adapter.count() != 0) {
            int size = this.mList.size();
            for (int i = 0; i < size; i++) {
                View view = this.mList.get(i);
                int i2 = (this.mIndex + i) - this.startIndex;
                if (this.infiniteCarousel) {
                    if (i2 < 0) {
                        int i3 = this.emptyViewBehavior;
                        if (i3 != 4) {
                            updateViewVisibility(view, i3);
                        } else {
                            updateViewVisibility(view, 0);
                        }
                        if (i2 % this.mAdapter.count() == 0) {
                            this.mAdapter.populate(view, 0);
                        } else {
                            Adapter adapter2 = this.mAdapter;
                            adapter2.populate(view, (i2 % this.mAdapter.count()) + adapter2.count());
                        }
                    } else if (i2 >= this.mAdapter.count()) {
                        if (i2 == this.mAdapter.count()) {
                            i2 = 0;
                        } else if (i2 > this.mAdapter.count()) {
                            i2 %= this.mAdapter.count();
                        }
                        int i4 = this.emptyViewBehavior;
                        if (i4 != 4) {
                            updateViewVisibility(view, i4);
                        } else {
                            updateViewVisibility(view, 0);
                        }
                        this.mAdapter.populate(view, i2);
                    } else {
                        updateViewVisibility(view, 0);
                        this.mAdapter.populate(view, i2);
                    }
                } else if (i2 < 0) {
                    updateViewVisibility(view, this.emptyViewBehavior);
                } else if (i2 >= this.mAdapter.count()) {
                    updateViewVisibility(view, this.emptyViewBehavior);
                } else {
                    updateViewVisibility(view, 0);
                    this.mAdapter.populate(view, i2);
                }
            }
            int i5 = this.mTargetIndex;
            if (i5 != -1 && i5 != this.mIndex) {
                this.mMotionLayout.post(new Runnable() {
                    public final void run() {
                        Carousel.this.lambda$updateItems$0$Carousel();
                    }
                });
            } else if (this.mTargetIndex == this.mIndex) {
                this.mTargetIndex = -1;
            }
            if (this.backwardTransition != -1 && this.forwardTransition != -1 && !this.infiniteCarousel) {
                int count = this.mAdapter.count();
                if (this.mIndex == 0) {
                    enableTransition(this.backwardTransition, false);
                } else {
                    enableTransition(this.backwardTransition, true);
                    this.mMotionLayout.setTransition(this.backwardTransition);
                }
                if (this.mIndex == count - 1) {
                    enableTransition(this.forwardTransition, false);
                } else {
                    enableTransition(this.forwardTransition, true);
                    this.mMotionLayout.setTransition(this.forwardTransition);
                }
            }
        }
    }

    public final boolean updateViewVisibility(View view, int i) {
        ConstraintSet constraintSet;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout == null) {
            return false;
        }
        int[] constraintSetIds = motionLayout.getConstraintSetIds();
        boolean z = false;
        for (int i2 : constraintSetIds) {
            MotionScene motionScene = this.mMotionLayout.mScene;
            if (motionScene == null) {
                constraintSet = null;
            } else {
                constraintSet = motionScene.getConstraintSet(i2);
            }
            boolean z2 = true;
            if (constraintSet != null) {
                Constraint constraint = constraintSet.getConstraint(view.getId());
                if (constraint != null) {
                    constraint.propertySet.mVisibilityMode = 1;
                    view.setVisibility(i);
                    z |= z2;
                }
            }
            z2 = false;
            z |= z2;
        }
        return z;
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
