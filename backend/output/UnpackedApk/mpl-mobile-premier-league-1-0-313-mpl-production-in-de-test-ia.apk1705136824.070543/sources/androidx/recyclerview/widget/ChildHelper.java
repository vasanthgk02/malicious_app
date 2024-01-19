package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AnonymousClass5;
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public class ChildHelper {
    public final Bucket mBucket = new Bucket();
    public final Callback mCallback;
    public final List<View> mHiddenViews = new ArrayList();

    public static class Bucket {
        public long mData = 0;
        public Bucket mNext;

        public void clear(int i) {
            if (i >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(i - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << i);
        }

        public int countOnesBefore(int i) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.mData & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.mData) + bucket.countOnesBefore(i - 64);
            }
        }

        public final void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public boolean get(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.get(i - 64);
            }
            return (this.mData & (1 << i)) != 0;
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                ensureNext();
                this.mNext.insert(i - 64, z);
                return;
            }
            boolean z2 = (this.mData & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.mData;
            this.mData = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                set(i);
            } else {
                clear(i);
            }
            if (z2 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        public boolean remove(int i) {
            if (i >= 64) {
                ensureNext();
                return this.mNext.remove(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.mData & j) != 0;
            long j2 = this.mData & (~j);
            this.mData = j2;
            long j3 = j - 1;
            this.mData = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }

        public void reset() {
            this.mData = 0;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i) {
            if (i >= 64) {
                ensureNext();
                this.mNext.set(i - 64);
                return;
            }
            this.mData |= 1 << i;
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    public interface Callback {
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    public void addView(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = ((AnonymousClass5) this.mCallback).getChildCount();
        } else {
            i2 = getOffset(i);
        }
        this.mBucket.insert(i2, z);
        if (z) {
            hideViewInternal(view);
        }
        AnonymousClass5 r4 = (AnonymousClass5) this.mCallback;
        RecyclerView.this.addView(view, i2);
        RecyclerView recyclerView = RecyclerView.this;
        if (recyclerView != null) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            recyclerView.onChildAttachedToWindow();
            Adapter adapter = recyclerView.mAdapter;
            if (!(adapter == null || childViewHolderInt == null)) {
                adapter.onViewAttachedToWindow(childViewHolderInt);
            }
            List<OnChildAttachStateChangeListener> list = recyclerView.mOnChildAttachStateListeners;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        recyclerView.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw null;
        }
    }

    public void attachViewToParent(View view, int i, LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = ((AnonymousClass5) this.mCallback).getChildCount();
        } else {
            i2 = getOffset(i);
        }
        this.mBucket.insert(i2, z);
        if (z) {
            hideViewInternal(view);
        }
        AnonymousClass5 r6 = (AnonymousClass5) this.mCallback;
        if (r6 != null) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.clearTmpDetachFlag();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Called attach on a child which is not detached: ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(RecyclerView.this, sb));
                }
            }
            RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            return;
        }
        throw null;
    }

    public void detachViewFromParent(int i) {
        int offset = getOffset(i);
        this.mBucket.remove(offset);
        AnonymousClass5 r0 = (AnonymousClass5) this.mCallback;
        View childAt = RecyclerView.this.getChildAt(offset);
        if (childAt != null) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.addFlags(256);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("called detach on an already detached child ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline33(RecyclerView.this, sb));
                }
            }
        }
        RecyclerView.this.detachViewFromParent(offset);
    }

    public View getChildAt(int i) {
        return ((AnonymousClass5) this.mCallback).getChildAt(getOffset(i));
    }

    public int getChildCount() {
        return ((AnonymousClass5) this.mCallback).getChildCount() - this.mHiddenViews.size();
    }

    public final int getOffset(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = ((AnonymousClass5) this.mCallback).getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int countOnesBefore = i - (i2 - this.mBucket.countOnesBefore(i2));
            if (countOnesBefore == 0) {
                while (this.mBucket.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += countOnesBefore;
        }
        return -1;
    }

    public View getUnfilteredChildAt(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public int getUnfilteredChildCount() {
        return ((AnonymousClass5) this.mCallback).getChildCount();
    }

    public final void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        AnonymousClass5 r0 = (AnonymousClass5) this.mCallback;
        if (r0 != null) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                return;
            }
            return;
        }
        throw null;
    }

    public int indexOfChild(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild != -1 && !this.mBucket.get(indexOfChild)) {
            return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
        }
        return -1;
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeViewAt(int i) {
        int offset = getOffset(i);
        View childAt = ((AnonymousClass5) this.mCallback).getChildAt(offset);
        if (childAt != null) {
            if (this.mBucket.remove(offset)) {
                unhideViewInternal(childAt);
            }
            ((AnonymousClass5) this.mCallback).removeViewAt(offset);
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public final boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        AnonymousClass5 r0 = (AnonymousClass5) this.mCallback;
        if (r0 != null) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
            return true;
        }
        throw null;
    }
}
