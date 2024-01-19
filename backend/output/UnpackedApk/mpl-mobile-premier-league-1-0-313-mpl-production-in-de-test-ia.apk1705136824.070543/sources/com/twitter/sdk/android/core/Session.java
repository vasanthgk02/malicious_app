package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

public class Session<T extends AuthToken> {
    @SerializedName("auth_token")
    public final T authToken;
    @SerializedName("id")
    public final long id;

    public Session(T t, long j) {
        if (t != null) {
            this.authToken = t;
            this.id = j;
            return;
        }
        throw new IllegalArgumentException("AuthToken must not be null.");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Session session = (Session) obj;
        if (this.id != session.id) {
            return false;
        }
        T t = this.authToken;
        T t2 = session.authToken;
        if (t != null) {
            z = t.equals(t2);
        } else if (t2 != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        T t = this.authToken;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.id;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
