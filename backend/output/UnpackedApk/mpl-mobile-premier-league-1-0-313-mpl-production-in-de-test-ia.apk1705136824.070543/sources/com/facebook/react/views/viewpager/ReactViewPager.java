package com.facebook.react.views.viewpager;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.util.ClientDisconnectionReason;

public class ReactViewPager extends ViewPager {
    public final EventDispatcher mEventDispatcher;
    public boolean mIsCurrentItemFromJs;
    public boolean mScrollEnabled = true;
    public final Runnable measureAndLayout = new Runnable() {
        public void run() {
            ReactViewPager reactViewPager = ReactViewPager.this;
            reactViewPager.measure(MeasureSpec.makeMeasureSpec(reactViewPager.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(ReactViewPager.this.getHeight(), 1073741824));
            ReactViewPager reactViewPager2 = ReactViewPager.this;
            reactViewPager2.layout(reactViewPager2.getLeft(), ReactViewPager.this.getTop(), ReactViewPager.this.getRight(), ReactViewPager.this.getBottom());
        }
    };

    public class Adapter extends PagerAdapter {
        public boolean mIsViewPagerInIntentionallyInconsistentState = false;
        public final List<View> mViews = new ArrayList();

        public Adapter(AnonymousClass1 r2) {
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.mViews.size();
        }

        public int getItemPosition(Object obj) {
            if (this.mIsViewPagerInIntentionallyInconsistentState || !this.mViews.contains(obj)) {
                return -2;
            }
            return this.mViews.indexOf(obj);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.mViews.get(i);
            viewGroup.addView(view, 0, ReactViewPager.this.generateDefaultLayoutParams());
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public class PageChangeListener implements OnPageChangeListener {
        public PageChangeListener(AnonymousClass1 r2) {
        }

        public void onPageScrollStateChanged(int i) {
            String str;
            if (i == 0) {
                str = ClientDisconnectionReason.IDLE;
            } else if (i == 1) {
                str = "dragging";
            } else if (i == 2) {
                str = "settling";
            } else {
                throw new IllegalStateException("Unsupported pageScrollState");
            }
            ReactViewPager reactViewPager = ReactViewPager.this;
            reactViewPager.mEventDispatcher.dispatchEvent(new PageScrollStateChangedEvent(reactViewPager.getId(), str));
        }

        public void onPageScrolled(int i, float f2, int i2) {
            ReactViewPager reactViewPager = ReactViewPager.this;
            reactViewPager.mEventDispatcher.dispatchEvent(new PageScrollEvent(reactViewPager.getId(), i, f2));
        }

        public void onPageSelected(int i) {
            ReactViewPager reactViewPager = ReactViewPager.this;
            if (!reactViewPager.mIsCurrentItemFromJs) {
                reactViewPager.mEventDispatcher.dispatchEvent(new PageSelectedEvent(reactViewPager.getId(), i));
            }
        }
    }

    public ReactViewPager(ReactContext reactContext) {
        super(reactContext);
        this.mEventDispatcher = ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        this.mIsCurrentItemFromJs = false;
        setOnPageChangeListener(new PageChangeListener(null));
        setAdapter(new Adapter(null));
    }

    public int getViewCountInAdapter() {
        return getAdapter().getCount();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestLayout();
        post(this.measureAndLayout);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                ImageOriginUtils.notifyNativeGestureStarted(this, motionEvent);
                return true;
            }
        } catch (IllegalArgumentException e2) {
            FLog.w((String) "ReactNative", (String) "Error intercepting touch event.", (Throwable) e2);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollEnabled) {
            return false;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            FLog.w((String) "ReactNative", (String) "Error handling touch event.", (Throwable) e2);
            return false;
        }
    }

    public void setCurrentItemFromJs(int i, boolean z) {
        this.mIsCurrentItemFromJs = true;
        setCurrentItem(i, z);
        this.mIsCurrentItemFromJs = false;
    }

    public void setScrollEnabled(boolean z) {
        this.mScrollEnabled = z;
    }

    public void setViews(List<View> list) {
        Adapter adapter = getAdapter();
        adapter.mViews.clear();
        adapter.mViews.addAll(list);
        adapter.notifyDataSetChanged();
        adapter.mIsViewPagerInIntentionallyInconsistentState = false;
    }

    public Adapter getAdapter() {
        return (Adapter) super.getAdapter();
    }
}
