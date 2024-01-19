package com.amazon.identity.auth.device.api.authorization;

import android.os.Bundle;

public final class AuthorizeResult {

    /* renamed from: a  reason: collision with root package name */
    public User f3280a;

    /* renamed from: a  reason: collision with other field name */
    public String f107a;

    /* renamed from: b  reason: collision with root package name */
    public String f3281b;

    /* renamed from: c  reason: collision with root package name */
    public String f3282c;

    /* renamed from: d  reason: collision with root package name */
    public String f3283d;

    public AuthorizeResult(Bundle bundle) {
        this(bundle, null);
    }

    public AuthorizeResult(Bundle bundle, User user) {
        this.f107a = bundle.getString(ch$b.TOKEN.f89a);
        this.f3281b = bundle.getString(ch$b.AUTHORIZATION_CODE.f89a);
        this.f3282c = bundle.getString(ch$b.CLIENT_ID.f89a);
        this.f3283d = bundle.getString(ch$b.REDIRECT_URI.f89a);
        this.f3280a = user;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthorizeResult.class != obj.getClass()) {
            return false;
        }
        AuthorizeResult authorizeResult = (AuthorizeResult) obj;
        String str = this.f107a;
        if (str == null) {
            if (authorizeResult.f107a != null) {
                return false;
            }
        } else if (!str.equals(authorizeResult.f107a)) {
            return false;
        }
        String str2 = this.f3281b;
        if (str2 == null) {
            if (authorizeResult.f3281b != null) {
                return false;
            }
        } else if (!str2.equals(authorizeResult.f3281b)) {
            return false;
        }
        User user = this.f3280a;
        if (user == null) {
            if (authorizeResult.f3280a != null) {
                return false;
            }
        } else if (!user.equals(authorizeResult.f3280a)) {
            return false;
        }
        String str3 = this.f3282c;
        if (str3 == null) {
            if (authorizeResult.f3282c != null) {
                return false;
            }
        } else if (!str3.equals(authorizeResult.f3282c)) {
            return false;
        }
        String str4 = this.f3283d;
        String str5 = authorizeResult.f3283d;
        if (str4 == null) {
            if (str5 != null) {
                return false;
            }
        } else if (!str4.equals(str5)) {
            return false;
        }
        return true;
    }

    public String getAccessToken() {
        return this.f107a;
    }

    public String getAuthorizationCode() {
        return this.f3281b;
    }

    public String getClientId() {
        return this.f3282c;
    }

    public String getRedirectURI() {
        return this.f3283d;
    }

    public User getUser() {
        return this.f3280a;
    }

    public int hashCode() {
        String str = this.f107a;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f3281b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        User user = this.f3280a;
        int hashCode3 = (hashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        String str3 = this.f3282c;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f3283d;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }
}
