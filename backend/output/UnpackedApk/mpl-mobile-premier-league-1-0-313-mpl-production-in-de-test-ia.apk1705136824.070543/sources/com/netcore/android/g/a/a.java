package com.netcore.android.g.a;

import android.content.Context;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTUserProfile.kt */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f1091a;

    /* renamed from: b  reason: collision with root package name */
    public static SMTPreferenceHelper f1092b;

    /* renamed from: c  reason: collision with root package name */
    public static final C0004a f1093c = new C0004a(null);

    /* renamed from: com.netcore.android.g.a.a$a  reason: collision with other inner class name */
    /* compiled from: SMTUserProfile.kt */
    public static final class C0004a {
        public C0004a() {
        }

        public final void a(SMTPreferenceHelper sMTPreferenceHelper) {
            a.f1092b = sMTPreferenceHelper;
        }

        public final a b(WeakReference<Context> weakReference) {
            a aVar;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            a a2 = a.f1091a;
            if (a2 != null) {
                return a2;
            }
            synchronized (a.class) {
                try {
                    a a3 = a.f1091a;
                    if (a3 != null) {
                        aVar = a3;
                    } else {
                        aVar = a.f1093c.a(weakReference);
                        a.f1091a = aVar;
                    }
                }
            }
            return aVar;
        }

        public /* synthetic */ C0004a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final a a(WeakReference<Context> weakReference) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                C0004a aVar = a.f1093c;
                Companion companion = SMTPreferenceHelper.Companion;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                aVar.a(companion.getAppPreferenceInstance(context, null));
            }
            return new a(weakReference, null);
        }
    }

    public a(WeakReference<Context> weakReference) {
    }

    public /* synthetic */ a(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r0 != null) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.HashMap<java.lang.String, java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "userProfileData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.netcore.android.preference.SMTPreferenceHelper r0 = f1092b
            java.lang.String r1 = "smt_user_profile_sha256_hash"
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0014
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            com.netcore.android.preference.SMTPreferenceHelper r3 = f1092b
            if (r3 == 0) goto L_0x0022
            java.lang.String r4 = "smt_user_identity"
            java.lang.String r3 = r3.getString(r4)
            if (r3 == 0) goto L_0x0022
            r2 = r3
        L_0x0022:
            com.netcore.android.utility.k.c$a r3 = com.netcore.android.utility.k.c.f1323b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r2 = 59
            r4.append(r2)
            r4.append(r6)
            java.lang.String r6 = r4.toString()
            java.lang.String r6 = r3.a(r6)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)
            r2 = 1
            r0 = r0 ^ r2
            if (r0 != r2) goto L_0x004c
            com.netcore.android.preference.SMTPreferenceHelper r0 = f1092b
            if (r0 == 0) goto L_0x004f
            r0.setString(r1, r6)
            goto L_0x004f
        L_0x004c:
            if (r0 != 0) goto L_0x0050
            r2 = 0
        L_0x004f:
            return r2
        L_0x0050:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.g.a.a.a(java.util.HashMap):boolean");
    }
}
