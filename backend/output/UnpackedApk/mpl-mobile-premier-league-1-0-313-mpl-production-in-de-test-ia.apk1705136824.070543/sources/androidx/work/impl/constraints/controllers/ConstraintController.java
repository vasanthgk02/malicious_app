package androidx.work.impl.constraints.controllers;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class ConstraintController<T> implements ConstraintListener<T> {
    public OnConstraintUpdatedCallback mCallback;
    public T mCurrentValue;
    public final List<String> mMatchingWorkSpecIds = new ArrayList();
    public ConstraintTracker<T> mTracker;

    public interface OnConstraintUpdatedCallback {
    }

    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.mTracker = constraintTracker;
    }

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public abstract boolean isConstrained(T t);

    public void onConstraintChanged(T t) {
        this.mCurrentValue = t;
        updateCallback(this.mCallback, t);
    }

    public void replace(Iterable<WorkSpec> iterable) {
        this.mMatchingWorkSpecIds.clear();
        for (WorkSpec next : iterable) {
            if (hasConstraint(next)) {
                this.mMatchingWorkSpecIds.add(next.id);
            }
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            this.mTracker.removeListener(this);
        } else {
            ConstraintTracker<T> constraintTracker = this.mTracker;
            synchronized (constraintTracker.mLock) {
                if (constraintTracker.mListeners.add(this)) {
                    if (constraintTracker.mListeners.size() == 1) {
                        constraintTracker.mCurrentState = constraintTracker.getInitialState();
                        Logger.get().debug(ConstraintTracker.TAG, String.format("%s: initial state = %s", new Object[]{constraintTracker.getClass().getSimpleName(), constraintTracker.mCurrentState}), new Throwable[0]);
                        constraintTracker.startTracking();
                    }
                    onConstraintChanged(constraintTracker.mCurrentState);
                }
            }
        }
        updateCallback(this.mCallback, this.mCurrentValue);
    }

    public final void updateCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t) {
        if (!this.mMatchingWorkSpecIds.isEmpty() && onConstraintUpdatedCallback != null) {
            if (t == null || isConstrained(t)) {
                List<String> list = this.mMatchingWorkSpecIds;
                WorkConstraintsTracker workConstraintsTracker = (WorkConstraintsTracker) onConstraintUpdatedCallback;
                synchronized (workConstraintsTracker.mLock) {
                    if (workConstraintsTracker.mCallback != null) {
                        workConstraintsTracker.mCallback.onAllConstraintsNotMet(list);
                    }
                }
            } else {
                List<String> list2 = this.mMatchingWorkSpecIds;
                WorkConstraintsTracker workConstraintsTracker2 = (WorkConstraintsTracker) onConstraintUpdatedCallback;
                synchronized (workConstraintsTracker2.mLock) {
                    ArrayList arrayList = new ArrayList();
                    for (String next : list2) {
                        if (workConstraintsTracker2.areAllConstraintsMet(next)) {
                            Logger.get().debug(WorkConstraintsTracker.TAG, String.format("Constraints met for %s", new Object[]{next}), new Throwable[0]);
                            arrayList.add(next);
                        }
                    }
                    if (workConstraintsTracker2.mCallback != null) {
                        workConstraintsTracker2.mCallback.onAllConstraintsMet(arrayList);
                    }
                }
            }
        }
    }
}
