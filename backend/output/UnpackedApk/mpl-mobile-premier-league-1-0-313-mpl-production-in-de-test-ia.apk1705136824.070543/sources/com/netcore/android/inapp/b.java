package com.netcore.android.inapp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SMTInAppConstants.kt */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1178a = "smtSrc";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1179b = "platform";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1180c = "pEnabled";

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f1181d = true;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1182e = "pVersion";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1183f = "1";
    public static final a g = new a(null);

    /* compiled from: SMTInAppConstants.kt */
    public static final class a {
        public a() {
        }

        public final String a() {
            return b.f1180c;
        }

        public final boolean b() {
            return b.f1181d;
        }

        public final String c() {
            return b.f1182e;
        }

        public final String d() {
            return b.f1183f;
        }

        public final String e() {
            return b.f1179b;
        }

        public final String f() {
            return b.f1178a;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/netcore/android/inapp/b$b", "", "Lcom/netcore/android/inapp/b$b;", "", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "APP_LAUNCH", "FIRST_APP_LAUNCH", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.netcore.android.inapp.b$b  reason: collision with other inner class name */
    /* compiled from: SMTInAppConstants.kt */
    public enum C0009b {
        APP_LAUNCH("app launch"),
        FIRST_APP_LAUNCH("first app launch");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f1185a;

        /* access modifiers changed from: public */
        C0009b(String str) {
            this.f1185a = str;
        }

        public final String getValue() {
            return this.f1185a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"com/netcore/android/inapp/b$c", "", "Lcom/netcore/android/inapp/b$c;", "", "a", "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "STICKY_HEADER", "STICKY_FOOTER", "INTERSTITIAL", "HALF_INTERSTIAL", "FULL_SCREEN", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTInAppConstants.kt */
    public enum c {
        STICKY_HEADER(1),
        STICKY_FOOTER(2),
        INTERSTITIAL(3),
        HALF_INTERSTIAL(4),
        FULL_SCREEN(5);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f1187a;

        /* access modifiers changed from: public */
        c(int i) {
            this.f1187a = i;
        }

        public final int getValue() {
            return this.f1187a;
        }
    }
}
