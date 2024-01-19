package com.amazon.identity.auth.device.api.authorization;

import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class AuthorizeRequest extends InteractiveRequest<AuthorizeListener, AuthorizeResult, AuthCancellation, AuthError> {

    /* renamed from: a  reason: collision with root package name */
    public GrantType f3276a = GrantType.ACCESS_TOKEN;

    /* renamed from: a  reason: collision with other field name */
    public String f104a;

    /* renamed from: a  reason: collision with other field name */
    public List<Scope> f105a = new LinkedList();

    /* renamed from: a  reason: collision with other field name */
    public boolean f106a = true;

    /* renamed from: b  reason: collision with root package name */
    public String f3277b;

    public static final class Builder extends com.amazon.identity.auth.device.interactive.InteractiveRequest.Builder<AuthorizeRequest> {

        /* renamed from: a  reason: collision with root package name */
        public final AuthorizeRequest f3278a = new AuthorizeRequest(this.requestContext);

        public Builder(RequestContext requestContext) {
            super(requestContext);
        }

        public Builder addScope(Scope scope) {
            this.f3278a.addScope(scope);
            return this;
        }

        public Builder addScopes(Scope... scopeArr) {
            this.f3278a.addScopes(scopeArr);
            return this;
        }

        public AuthorizeRequest build() {
            return this.f3278a;
        }

        public Builder forGrantType(GrantType grantType) {
            this.f3278a.setGrantType(grantType);
            return this;
        }

        public Builder shouldReturnUserData(boolean z) {
            this.f3278a.setShouldReturnUserData(z);
            return this;
        }

        public Builder withProofKeyParameters(String str, String str2) {
            this.f3278a.setProofKeyParameters(str, str2);
            return this;
        }
    }

    public enum GrantType {
        ACCESS_TOKEN,
        AUTHORIZATION_CODE
    }

    public AuthorizeRequest(RequestContext requestContext) {
        super(requestContext);
    }

    public void addScope(Scope scope) {
        this.f105a.add(scope);
    }

    public void addScopes(Scope... scopeArr) {
        Collections.addAll(this.f105a, scopeArr);
    }

    public String getCodeChallenge() {
        return this.f104a;
    }

    public String getCodeChallengeMethod() {
        return this.f3277b;
    }

    public GrantType getGrantType() {
        return this.f3276a;
    }

    public final Class<AuthorizeListener> getListenerClass() {
        return AuthorizeListener.class;
    }

    public final Bundle getRequestExtras() {
        Bundle bundle = new Bundle();
        String[] strArr = new String[this.f105a.size()];
        for (int i = 0; i < this.f105a.size(); i++) {
            strArr[i] = this.f105a.get(i).getName();
        }
        bundle.putStringArray("requestedScopes", strArr);
        bundle.putBoolean("shouldReturnUserData", shouldReturnUserData());
        return bundle;
    }

    public final String getRequestType() {
        return "com.amazon.identity.auth.device.authorization.request.authorize";
    }

    public List<Scope> getScopes() {
        return this.f105a;
    }

    public void setCodeChallenge(String str) {
        this.f104a = str;
    }

    public void setCodeChallengeMethod(String str) {
        this.f3277b = str;
    }

    public void setGrantType(GrantType grantType) {
        this.f3276a = grantType;
    }

    public void setProofKeyParameters(String str, String str2) {
        setCodeChallenge(str);
        setCodeChallengeMethod(str2);
    }

    public void setScopes(List<Scope> list) {
        this.f105a = list;
    }

    public void setShouldReturnUserData(boolean z) {
        this.f106a = z;
    }

    public boolean shouldReturnUserData() {
        return this.f106a;
    }
}
