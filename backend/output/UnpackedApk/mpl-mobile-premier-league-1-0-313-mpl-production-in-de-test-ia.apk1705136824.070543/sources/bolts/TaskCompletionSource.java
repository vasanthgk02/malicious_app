package bolts;

public class TaskCompletionSource<TResult> {
    public final Task<TResult> task = new Task<>();

    public void setCancelled() {
        if (!this.task.trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void setError(Exception exc) {
        boolean z;
        Task<TResult> task2 = this.task;
        synchronized (task2.lock) {
            z = false;
            if (!task2.complete) {
                task2.complete = true;
                task2.error = exc;
                task2.errorHasBeenObserved = false;
                task2.lock.notifyAll();
                task2.runContinuations();
                z = true;
            }
        }
        if (!z) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void setResult(TResult tresult) {
        if (!this.task.trySetResult(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}
