package defpackage;

/* renamed from: ch$b  reason: default package */
public enum ch$b {
    TOKEN("com.amazon.identity.auth.device.authorization.token"),
    AUTHORIZATION_CODE("com.amazon.identity.auth.device.authorization.authorizationCode"),
    DIRECTED_ID("com.amazon.identity.auth.device.authorization.directedId"),
    DEVICE_ID("com.amazon.identity.auth.device.authorization.deviceId"),
    APP_ID("com.amazon.identity.auth.device.authorization.appId"),
    CAUSE_ID("com.amazon.identity.auth.device.authorization.causeId"),
    REJECTED_SCOPE_LIST("com.amazon.identity.auth.device.authorization.ungrantedScopes"),
    AUTHORIZE("com.amazon.identity.auth.device.authorization.authorize"),
    CLIENT_ID("com.amazon.identity.auth.device.authorization.clietId"),
    REDIRECT_URI("com.amazon.identity.auth.device.authorization.redirectURI"),
    ON_CANCEL_TYPE("com.amazon.identity.auth.device.authorization.onCancelType"),
    ON_CANCEL_DESCRIPTION("com.amazon.identity.auth.device.authorization.onCancelDescription"),
    BROWSER_AUTHORIZATION("com.amazon.identity.auth.device.authorization.useBrowserForAuthorization"),
    PROFILE("com.amazon.identity.auth.device.authorization.profile"),
    FUTURE("com.amazon.identity.auth.device.authorization.future.type"),
    NO_SERVICE("com.amazon.identity.auth.device.authorization.noService"),
    SCOPE_DATA("com.amazon.identity.auth.device.authorization.scope_data"),
    CODE_CHALLENGE("com.amazon.identity.auth.device.authorization.code_challenge"),
    CODE_CHALLENGE_METHOD("com.amazon.identity.auth.device.authorization.code_challenge_method"),
    GET_AUTH_CODE("com.amazon.identity.auth.device.authorization.return_auth_code"),
    SANDBOX("com.amazon.identity.auth.device.authorization.sandbox"),
    CHECK_API_KEY("com.amazon.identity.auth.device.authorization.checkAPIKey"),
    EXTRA_URL_PARAMS("com.amazon.identity.auth.device.authorization.extraUrlParameters"),
    RETURN_CODE("com.amazon.identity.auth.device.authorization.returnCode"),
    MINIMUM_TOKEN_LIFETIME("com.amazon.identity.auth.device.authorization.minTokenLifetime"),
    SDK_VERSION("com.amazon.identity.auth.device.authorization.sdkVersion"),
    SSO_VERSION("com.amazon.identity.auth.device.authorization.ssoVersion");
    

    /* renamed from: a  reason: collision with other field name */
    public final String f89a;

    /* access modifiers changed from: public */
    ch$b(String str) {
        this.f89a = str;
    }
}
