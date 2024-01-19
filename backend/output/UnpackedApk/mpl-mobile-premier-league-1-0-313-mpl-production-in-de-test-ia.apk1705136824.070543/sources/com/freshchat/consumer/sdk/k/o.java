package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.service.Status;

public abstract class o extends n {
    public int rs;

    public o(Context context) {
        super(context);
    }

    public Status B(boolean z) {
        return z ? jl() : jd();
    }

    public abstract void aa(int i);

    public boolean b(Status status) {
        if (!jk()) {
            int i = this.rs;
            if (i != 0) {
                return status == Status.SUCCESS && i == 1;
            }
        }
        return true;
    }

    public Status c(Status status) {
        if (this.rr == status) {
            return null;
        }
        this.rr = status;
        return status;
    }

    public Status jd() {
        Status status;
        if (al.aS(getContext())) {
            aa(this.rs + 1);
            status = this.rs == 0 ? Status.INIT_LOADING : Status.LOADING_MORE;
        } else {
            status = Status.NO_INTERNET;
        }
        return c(status);
    }

    public abstract boolean jk();

    public Status jl() {
        Status status = this.rr;
        if (status != Status.SUCCESS) {
            return status;
        }
        ai.i("BasePagingViewModel", " Load more data called in View model ");
        return jd();
    }

    public Status jm() {
        if (!al.aS(getContext()) || this.rr != Status.NO_INTERNET) {
            return null;
        }
        return jd();
    }

    public void jn() {
        this.rs++;
    }

    public void jo() {
        this.rs = 0;
    }
}
