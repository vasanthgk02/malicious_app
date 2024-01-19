package androidx.work.impl;

import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.Operation.State;
import androidx.work.Operation.State.FAILURE;
import androidx.work.Operation.State.SUCCESS;
import androidx.work.impl.utils.futures.SettableFuture;

public class OperationImpl implements Operation {
    public final SettableFuture<SUCCESS> mOperationFuture = new SettableFuture<>();
    public final MutableLiveData<State> mOperationState = new MutableLiveData<>();

    public OperationImpl() {
        setState(Operation.IN_PROGRESS);
    }

    public void setState(State state) {
        this.mOperationState.postValue(state);
        if (state instanceof SUCCESS) {
            this.mOperationFuture.set((SUCCESS) state);
        } else if (state instanceof FAILURE) {
            this.mOperationFuture.setException(((FAILURE) state).mThrowable);
        }
    }
}
