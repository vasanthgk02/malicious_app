package co.apptailor.googlesignin;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Promise;

public class PromiseWrapper {
    public String nameOfCallInProgress;
    public Promise promise;

    public void reject(String str, Throwable th) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            resetMembers();
            promise2.reject(str, th.getLocalizedMessage(), th);
        }
    }

    public final void resetMembers() {
        this.promise = null;
        this.nameOfCallInProgress = null;
    }

    public void resolve(Object obj) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            resetMembers();
            promise2.resolve(null);
        }
    }

    public void setPromiseWithInProgressCheck(Promise promise2, String str) {
        Promise promise3 = this.promise;
        if (promise3 != null) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Warning: previous promise did not settle and was overwritten. You've called \"", str, "\" while \"");
            outline80.append(this.nameOfCallInProgress);
            outline80.append("\" was already in progress and has not completed yet.");
            promise3.reject((String) "ASYNC_OP_IN_PROGRESS", outline80.toString());
        }
        this.promise = promise2;
        this.nameOfCallInProgress = str;
    }

    public void reject(String str, String str2) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            resetMembers();
            promise2.reject(str, str2);
        }
    }
}
