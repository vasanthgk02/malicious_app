package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0003R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "handlesException", "", "getHandlesException$kotlinx_coroutines_core", "()Z", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "complete", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JobSupport.kt */
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean handlesException;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JobImpl(Job job) {
        // boolean z = true;
        super(true);
        initParentJob(job);
        ChildHandle childHandle = (ChildHandle) this._parentHandle;
        JobNode jobNode = childHandle instanceof ChildHandleNode ? (ChildHandleNode) childHandle : null;
        if (jobNode != null) {
            JobSupport job2 = jobNode.getJob();
            while (true) {
                if (!job2.getHandlesException$kotlinx_coroutines_core()) {
                    ChildHandle childHandle2 = (ChildHandle) job2._parentHandle;
                    JobNode jobNode2 = childHandle2 instanceof ChildHandleNode ? (ChildHandleNode) childHandle2 : null;
                    if (jobNode2 == null) {
                        break;
                    }
                    job2 = jobNode2.getJob();
                } else {
                    break;
                }
            }
            this.handlesException = z;
        }
        z = false;
        this.handlesException = z;
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.handlesException;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
