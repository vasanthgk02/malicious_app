package com.midtrans.sdk.gopaycheckout.core;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/GoPayCheckoutState;", "", "()V", "isExecutable", "", "checkExecutable", "setExecutable", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutState {
    public static final GoPayCheckoutState INSTANCE = new GoPayCheckoutState();
    public static boolean isExecutable = true;

    public final boolean checkExecutable() {
        boolean z;
        synchronized (this) {
            try {
                z = isExecutable;
            }
        }
        return z;
    }

    public final void setExecutable(boolean z) {
        synchronized (this) {
            isExecutable = z;
        }
    }
}
