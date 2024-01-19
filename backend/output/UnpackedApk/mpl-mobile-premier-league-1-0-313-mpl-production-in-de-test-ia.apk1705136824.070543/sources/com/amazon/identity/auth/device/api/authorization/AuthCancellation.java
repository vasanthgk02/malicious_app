package com.amazon.identity.auth.device.api.authorization;

import android.os.Bundle;

public final class AuthCancellation {

    /* renamed from: a  reason: collision with root package name */
    public final Cause f3266a;

    /* renamed from: a  reason: collision with other field name */
    public final String f98a;

    public enum Cause {
        FAILED_AUTHENTICATION;

        public static Cause a(int i) {
            return FAILED_AUTHENTICATION;
        }
    }

    public AuthCancellation(Bundle bundle) {
        this(Cause.a(bundle.getInt(ch$b.CAUSE_ID.f89a)), bundle.getString(ch$b.ON_CANCEL_DESCRIPTION.f89a));
    }

    public AuthCancellation(Cause cause, String str) {
        this.f3266a = cause;
        this.f98a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthCancellation.class != obj.getClass()) {
            return false;
        }
        AuthCancellation authCancellation = (AuthCancellation) obj;
        if (this.f3266a != authCancellation.f3266a) {
            return false;
        }
        String str = this.f98a;
        String str2 = authCancellation.f98a;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public Cause getCause() {
        return this.f3266a;
    }

    public String getDescription() {
        return this.f98a;
    }

    public int hashCode() {
        Cause cause = this.f3266a;
        int i = 0;
        int hashCode = ((cause == null ? 0 : cause.hashCode()) + 31) * 31;
        String str = this.f98a;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return String.format("%s {cause='%s', description='%s'}", new Object[]{super.toString(), this.f3266a.toString(), this.f98a});
    }
}
