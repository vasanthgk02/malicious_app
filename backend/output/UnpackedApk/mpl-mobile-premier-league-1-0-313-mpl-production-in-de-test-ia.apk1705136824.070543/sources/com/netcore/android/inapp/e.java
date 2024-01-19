package com.netcore.android.inapp;

import com.netcore.android.inapp.h.b;

/* compiled from: SMTInAppRuleActionListener.kt */
public interface e {

    /* compiled from: SMTInAppRuleActionListener.kt */
    public static final class a {
        public static /* synthetic */ void a(e eVar, int i, b bVar, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str = null;
                }
                eVar.a(i, bVar, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordInAppEvent");
        }
    }

    void a(int i, b bVar, String str);

    void a(boolean z);
}
