package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator.ChangeInfo;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;

public abstract class SimpleItemAnimator extends ItemAnimator {
    public boolean mSupportsChangeAnimations = true;

    public boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        int i3 = itemHolderInfo.left;
        int i4 = itemHolderInfo.top;
        if (viewHolder2.shouldIgnore()) {
            int i5 = itemHolderInfo.left;
            i = itemHolderInfo.top;
            i2 = i5;
        } else {
            i2 = itemHolderInfo2.left;
            i = itemHolderInfo2.top;
        }
        DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) this;
        if (viewHolder == viewHolder2) {
            return defaultItemAnimator.animateMove(viewHolder, i3, i4, i2, i);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        defaultItemAnimator.resetAnimation(viewHolder);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        defaultItemAnimator.resetAnimation(viewHolder2);
        viewHolder2.itemView.setTranslationX((float) (-((int) (((float) (i2 - i3)) - translationX))));
        viewHolder2.itemView.setTranslationY((float) (-((int) (((float) (i - i4)) - translationY))));
        viewHolder2.itemView.setAlpha(0.0f);
        ArrayList<ChangeInfo> arrayList = defaultItemAnimator.mPendingChanges;
        ChangeInfo changeInfo = new ChangeInfo(viewHolder, viewHolder2, i3, i4, i2, i);
        arrayList.add(changeInfo);
        return true;
    }

    public abstract boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4);

    public final void dispatchRemoveFinished(ViewHolder viewHolder) {
        dispatchAnimationFinished(viewHolder);
    }
}
