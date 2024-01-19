package androidx.recyclerview.widget;

import com.android.tools.r8.GeneratedOutlineSupport;

public class LayoutState {
    public int mAvailable;
    public int mCurrentPosition;
    public int mEndLine = 0;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public boolean mStopInFocusable;

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LayoutState{mAvailable=");
        outline73.append(this.mAvailable);
        outline73.append(", mCurrentPosition=");
        outline73.append(this.mCurrentPosition);
        outline73.append(", mItemDirection=");
        outline73.append(this.mItemDirection);
        outline73.append(", mLayoutDirection=");
        outline73.append(this.mLayoutDirection);
        outline73.append(", mStartLine=");
        outline73.append(this.mStartLine);
        outline73.append(", mEndLine=");
        return GeneratedOutlineSupport.outline56(outline73, this.mEndLine, '}');
    }
}
