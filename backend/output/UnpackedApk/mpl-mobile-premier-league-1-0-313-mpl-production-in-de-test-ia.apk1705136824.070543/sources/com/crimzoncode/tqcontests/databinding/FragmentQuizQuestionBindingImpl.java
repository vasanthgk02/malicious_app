package com.crimzoncode.tqcontests.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.CompoundButtonCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.IncludedLayouts;
import com.crimzoncode.tqcontests.BR;
import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;

public class FragmentQuizQuestionBindingImpl extends FragmentQuizQuestionBinding {
    public static final IncludedLayouts sIncludes = null;
    public static final SparseIntArray sViewsWithIds;
    public long mDirtyFlags;
    public final ConstraintLayout mboundView0;
    public final AppCompatTextView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.divider, 2);
        sViewsWithIds.put(R.id.label_question, 3);
        sViewsWithIds.put(R.id.question_count, 4);
        sViewsWithIds.put(R.id.label_question_timer, 5);
        sViewsWithIds.put(R.id.question_timer, 6);
        sViewsWithIds.put(R.id.question_webview, 7);
    }

    public FragmentQuizQuestionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        QuizAttempt quizAttempt = this.mQuizAttempt;
        String str = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || quizAttempt == null)) {
            str = quizAttempt.getChapter();
        }
        if (i != 0) {
            CompoundButtonCompat.setText(this.mboundView1, str);
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
        }
        requestRebind();
    }

    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public void setQuizAttempt(QuizAttempt quizAttempt) {
        this.mQuizAttempt = quizAttempt;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.quizAttempt);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (BR.quizAttempt != i) {
            return false;
        }
        setQuizAttempt((QuizAttempt) obj);
        return true;
    }

    public FragmentQuizQuestionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[2], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[4], (AppCompatTextView) objArr[6], (WebView) objArr[7]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatTextView appCompatTextView = objArr[1];
        this.mboundView1 = appCompatTextView;
        appCompatTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
