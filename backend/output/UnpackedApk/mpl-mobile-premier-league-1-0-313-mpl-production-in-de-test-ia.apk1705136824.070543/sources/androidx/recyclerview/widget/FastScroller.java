package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.State;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class FastScroller extends ItemDecoration implements OnItemTouchListener {
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] PRESSED_STATE_SET = {16842919};
    public int mAnimationState = 0;
    public int mDragState = 0;
    public final Runnable mHideRunnable = new Runnable() {
        public void run() {
            FastScroller fastScroller = FastScroller.this;
            int i = fastScroller.mAnimationState;
            if (i == 1) {
                fastScroller.mShowHideAnimator.cancel();
            } else if (i != 2) {
                return;
            }
            fastScroller.mAnimationState = 3;
            ValueAnimator valueAnimator = fastScroller.mShowHideAnimator;
            valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
            fastScroller.mShowHideAnimator.setDuration((long) 500);
            fastScroller.mShowHideAnimator.start();
        }
    };
    public float mHorizontalDragX;
    public final int[] mHorizontalRange = new int[2];
    public int mHorizontalThumbCenterX;
    public final StateListDrawable mHorizontalThumbDrawable;
    public final int mHorizontalThumbHeight;
    public int mHorizontalThumbWidth;
    public final Drawable mHorizontalTrackDrawable;
    public final int mHorizontalTrackHeight;
    public final int mMargin;
    public boolean mNeedHorizontalScrollbar = false;
    public boolean mNeedVerticalScrollbar = false;
    public final OnScrollListener mOnScrollListener = new OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FastScroller fastScroller = FastScroller.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = fastScroller.mRecyclerView.computeVerticalScrollRange();
            int i3 = fastScroller.mRecyclerViewHeight;
            fastScroller.mNeedVerticalScrollbar = computeVerticalScrollRange - i3 > 0 && i3 >= fastScroller.mScrollbarMinimumRange;
            int computeHorizontalScrollRange = fastScroller.mRecyclerView.computeHorizontalScrollRange();
            int i4 = fastScroller.mRecyclerViewWidth;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= fastScroller.mScrollbarMinimumRange;
            fastScroller.mNeedHorizontalScrollbar = z;
            if (fastScroller.mNeedVerticalScrollbar || z) {
                if (fastScroller.mNeedVerticalScrollbar) {
                    float f2 = (float) i3;
                    fastScroller.mVerticalThumbCenterY = (int) ((((f2 / 2.0f) + ((float) computeVerticalScrollOffset)) * f2) / ((float) computeVerticalScrollRange));
                    fastScroller.mVerticalThumbHeight = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (fastScroller.mNeedHorizontalScrollbar) {
                    float f3 = (float) computeHorizontalScrollOffset;
                    float f4 = (float) i4;
                    fastScroller.mHorizontalThumbCenterX = (int) ((((f4 / 2.0f) + f3) * f4) / ((float) computeHorizontalScrollRange));
                    fastScroller.mHorizontalThumbWidth = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                int i5 = fastScroller.mState;
                if (i5 == 0 || i5 == 1) {
                    fastScroller.setState(1);
                }
            } else if (fastScroller.mState != 0) {
                fastScroller.setState(0);
            }
        }
    };
    public RecyclerView mRecyclerView;
    public int mRecyclerViewHeight = 0;
    public int mRecyclerViewWidth = 0;
    public final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    public int mState = 0;
    public float mVerticalDragY;
    public final int[] mVerticalRange = new int[2];
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    public int mVerticalThumbHeight;
    public final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    public final int mVerticalTrackWidth;

    public class AnimatorListener extends AnimatorListenerAdapter {
        public boolean mCanceled = false;

        public AnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
                return;
            }
            if (((Float) FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.mAnimationState = 2;
                fastScroller2.mRecyclerView.invalidate();
            }
        }
    }

    public class AnimatorUpdater implements AnimatorUpdateListener {
        public AnimatorUpdater() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.mVerticalThumbDrawable.setAlpha(floatValue);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(floatValue);
            FastScroller.this.mRecyclerView.invalidate();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        boolean z = false;
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i2;
        this.mMargin = i3;
        this.mVerticalThumbDrawable.setAlpha(InvitationReply.EXPIRED);
        this.mVerticalTrackDrawable.setAlpha(InvitationReply.EXPIRED);
        this.mShowHideAnimator.addListener(new AnimatorListener());
        this.mShowHideAnimator.addUpdateListener(new AnimatorUpdater());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                LayoutManager layoutManager = recyclerView2.mLayout;
                if (layoutManager != null) {
                    layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
                }
                recyclerView2.mItemDecorations.remove(this);
                if (recyclerView2.mItemDecorations.isEmpty()) {
                    recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2 ? true : z);
                }
                recyclerView2.markItemDecorInsetsDirty();
                recyclerView2.requestLayout();
                RecyclerView recyclerView3 = this.mRecyclerView;
                recyclerView3.mOnItemTouchListeners.remove(this);
                if (recyclerView3.mInterceptingOnItemTouchListener == this) {
                    recyclerView3.mInterceptingOnItemTouchListener = null;
                }
                RecyclerView recyclerView4 = this.mRecyclerView;
                OnScrollListener onScrollListener = this.mOnScrollListener;
                List<OnScrollListener> list = recyclerView4.mScrollListeners;
                if (list != null) {
                    list.remove(onScrollListener);
                }
                cancelHide();
            }
            this.mRecyclerView = recyclerView;
            recyclerView.addItemDecoration(this);
            this.mRecyclerView.mOnItemTouchListeners.add(this);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        }
    }

    public final void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    public boolean isPointInsideHorizontalThumb(float f2, float f3) {
        if (f3 >= ((float) (this.mRecyclerViewHeight - this.mHorizontalThumbHeight))) {
            int i = this.mHorizontalThumbCenterX;
            int i2 = this.mHorizontalThumbWidth;
            if (f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) ((i2 / 2) + i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointInsideVerticalThumb(float f2, float f3) {
        if (ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) {
            if (f2 > ((float) this.mVerticalThumbWidth)) {
                return false;
            }
        } else if (f2 < ((float) (this.mRecyclerViewWidth - this.mVerticalThumbWidth))) {
            return false;
        }
        int i = this.mVerticalThumbCenterY;
        int i2 = this.mVerticalThumbHeight / 2;
        if (f3 < ((float) (i - i2)) || f3 > ((float) (i2 + i))) {
            return false;
        }
        return true;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        if (this.mRecyclerViewWidth == this.mRecyclerView.getWidth() && this.mRecyclerViewHeight == this.mRecyclerView.getHeight()) {
            if (this.mAnimationState != 0) {
                if (this.mNeedVerticalScrollbar) {
                    int i = this.mRecyclerViewWidth;
                    int i2 = this.mVerticalThumbWidth;
                    int i3 = i - i2;
                    int i4 = this.mVerticalThumbCenterY;
                    int i5 = this.mVerticalThumbHeight;
                    int i6 = i4 - (i5 / 2);
                    this.mVerticalThumbDrawable.setBounds(0, 0, i2, i5);
                    this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
                    boolean z = true;
                    if (ViewCompat.getLayoutDirection(this.mRecyclerView) != 1) {
                        z = false;
                    }
                    if (z) {
                        this.mVerticalTrackDrawable.draw(canvas);
                        canvas.translate((float) this.mVerticalThumbWidth, (float) i6);
                        canvas.scale(-1.0f, 1.0f);
                        this.mVerticalThumbDrawable.draw(canvas);
                        canvas.scale(-1.0f, 1.0f);
                        canvas.translate((float) (-this.mVerticalThumbWidth), (float) (-i6));
                    } else {
                        canvas.translate((float) i3, 0.0f);
                        this.mVerticalTrackDrawable.draw(canvas);
                        canvas.translate(0.0f, (float) i6);
                        this.mVerticalThumbDrawable.draw(canvas);
                        canvas.translate((float) (-i3), (float) (-i6));
                    }
                }
                if (this.mNeedHorizontalScrollbar) {
                    int i7 = this.mRecyclerViewHeight;
                    int i8 = this.mHorizontalThumbHeight;
                    int i9 = i7 - i8;
                    int i10 = this.mHorizontalThumbCenterX;
                    int i11 = this.mHorizontalThumbWidth;
                    int i12 = i10 - (i11 / 2);
                    this.mHorizontalThumbDrawable.setBounds(0, 0, i11, i8);
                    this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
                    canvas.translate(0.0f, (float) i9);
                    this.mHorizontalTrackDrawable.draw(canvas);
                    canvas.translate((float) i12, 0.0f);
                    this.mHorizontalThumbDrawable.draw(canvas);
                    canvas.translate((float) (-i12), (float) (-i9));
                }
            }
            return;
        }
        this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
        setState(0);
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.mState;
        if (i == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (isPointInsideVerticalThumb || isPointInsideHorizontalThumb)) {
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (float) ((int) motionEvent.getX());
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (float) ((int) motionEvent.getY());
                }
                setState(2);
                return true;
            }
        } else if (i == 2) {
            return true;
        }
        return false;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                    if (isPointInsideHorizontalThumb) {
                        this.mDragState = 1;
                        this.mHorizontalDragX = (float) ((int) motionEvent.getX());
                    } else if (isPointInsideVerticalThumb) {
                        this.mDragState = 2;
                        this.mVerticalDragY = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.mVerticalDragY = 0.0f;
                this.mHorizontalDragX = 0.0f;
                setState(1);
                this.mDragState = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                show();
                if (this.mDragState == 1) {
                    float x = motionEvent.getX();
                    int[] iArr = this.mHorizontalRange;
                    int i = this.mMargin;
                    iArr[0] = i;
                    iArr[1] = this.mRecyclerViewWidth - i;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.mHorizontalThumbCenterX) - max) >= 2.0f) {
                        int scrollTo = scrollTo(this.mHorizontalDragX, max, iArr, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
                        if (scrollTo != 0) {
                            this.mRecyclerView.scrollBy(scrollTo, 0);
                        }
                        this.mHorizontalDragX = max;
                    }
                }
                if (this.mDragState == 2) {
                    float y = motionEvent.getY();
                    int[] iArr2 = this.mVerticalRange;
                    int i2 = this.mMargin;
                    iArr2[0] = i2;
                    iArr2[1] = this.mRecyclerViewHeight - i2;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y));
                    if (Math.abs(((float) this.mVerticalThumbCenterY) - max2) >= 2.0f) {
                        int scrollTo2 = scrollTo(this.mVerticalDragY, max2, iArr2, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
                        if (scrollTo2 != 0) {
                            this.mRecyclerView.scrollBy(0, scrollTo2);
                        }
                        this.mVerticalDragY = max2;
                    }
                }
            }
        }
    }

    public final int scrollTo(float f2, float f3, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f3 - f2) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    public void setState(int i) {
        if (i == 2 && this.mState != 2) {
            this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
            cancelHide();
        }
        if (i == 0) {
            this.mRecyclerView.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
            cancelHide();
            this.mRecyclerView.postDelayed(this.mHideRunnable, (long) 1200);
        } else if (i == 1) {
            cancelHide();
            this.mRecyclerView.postDelayed(this.mHideRunnable, (long) 1500);
        }
        this.mState = i;
    }

    public void show() {
        int i = this.mAnimationState;
        if (i != 0) {
            if (i == 3) {
                this.mShowHideAnimator.cancel();
            } else {
                return;
            }
        }
        this.mAnimationState = 1;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.mShowHideAnimator.setDuration(500);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
    }
}
