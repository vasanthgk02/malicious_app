package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.Executor;

public final class by {
    public final Object AFInAppEventParameterName = new Object();
    public final ca AFInAppEventType;
    public final bw AFKeystoreWrapper;
    public final bd AFVersionDeclaration;
    public final cb AppsFlyer2dXConversionCallback;
    public final bx getLevel;
    public final Executor init;
    public final aa valueOf;
    public ap values;

    public by(bw bwVar, aa aaVar, ca caVar, bx bxVar, bd bdVar, cb cbVar, Executor executor, ai aiVar) {
        this.AFKeystoreWrapper = bwVar;
        this.valueOf = aaVar;
        this.AFInAppEventType = caVar;
        this.getLevel = bxVar;
        this.AFVersionDeclaration = bdVar;
        this.AppsFlyer2dXConversionCallback = cbVar;
        this.init = executor;
        aiVar.AFKeystoreWrapper.add(this);
    }

    public final ap AFKeystoreWrapper() {
        ap apVar;
        synchronized (this.AFInAppEventParameterName) {
            try {
                apVar = this.values;
                this.values = null;
            }
        }
        return apVar;
    }

    public final void values(final bv bvVar) {
        final bs bsVar = new bs(this.AFKeystoreWrapper, this.valueOf, this.AFInAppEventType, this.getLevel, this.AFVersionDeclaration, this.AppsFlyer2dXConversionCallback, "v1");
        this.init.execute(new Runnable() {
            public final void run() {
                try {
                    bsVar.call();
                    bs bsVar = bsVar;
                    bu buVar = bsVar.AFKeystoreWrapper;
                    if (buVar != bu.USE_CACHED) {
                        by byVar = by.this;
                        ap apVar = bsVar.valueOf;
                        synchronized (byVar.AFInAppEventParameterName) {
                            byVar.values = apVar;
                        }
                    }
                    if (buVar == null) {
                        AFLogger.AppsFlyer2dXConversionCallback("CFG: update RC returned null result, something went wrong!");
                        bu buVar2 = bu.FAILURE;
                    }
                    synchronized (by.this.AFInAppEventParameterName) {
                    }
                } catch (Exception unused) {
                    bu buVar3 = bu.FAILURE;
                    by byVar2 = by.this;
                    ap apVar2 = bsVar.valueOf;
                    synchronized (byVar2.AFInAppEventParameterName) {
                        byVar2.values = apVar2;
                        synchronized (by.this.AFInAppEventParameterName) {
                        }
                    }
                }
            }
        });
    }
}
