package com.google.android.gms.internal.auth;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public enum zzby {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR("NetworkError"),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    ILLEGAL_ARGUMENT("IllegalArgument"),
    BAD_AUTHENTICATION("BadAuthentication"),
    BAD_TOKEN_REQUEST("BAD_REQUEST"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN(Constants.DOWNLOAD_STATUS_UNKNOWN),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED("ServiceDisabled"),
    CHALLENGE_REQUIRED("ChallengeRequired"),
    NEED_PERMISSION("NeedPermission"),
    NEED_REMOTE_CONSENT("NeedRemoteConsent"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED("PermissionDenied"),
    INVALID_AUDIENCE("INVALID_AUDIENCE"),
    UNREGISTERED_ON_API_CONSOLE("UNREGISTERED_ON_API_CONSOLE"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_SCREENLOCK_REQUIRED("DeviceManagementScreenlockRequired"),
    DM_REQUIRED("DeviceManagementRequired"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError"),
    AUTH_SECURITY_ERROR("AuthSecurityError");
    
    public final String zzag;

    /* access modifiers changed from: public */
    zzby(String str) {
        this.zzag = str;
    }

    public static final zzby zza(String str) {
        zzby zzby = UNKNOWN;
        for (zzby zzby2 : values()) {
            if (true == zzby2.zzag.equals(str)) {
                zzby = zzby2;
            }
        }
        return zzby;
    }

    @ShowFirstParty
    public static boolean zzb(zzby zzby) {
        return BAD_AUTHENTICATION.equals(zzby) || CAPTCHA.equals(zzby) || NEED_PERMISSION.equals(zzby) || NEED_REMOTE_CONSENT.equals(zzby) || NEEDS_BROWSER.equals(zzby) || USER_CANCEL.equals(zzby) || DEVICE_MANAGEMENT_REQUIRED.equals(zzby) || DM_INTERNAL_ERROR.equals(zzby) || DM_SYNC_DISABLED.equals(zzby) || DM_ADMIN_BLOCKED.equals(zzby) || DM_ADMIN_PENDING_APPROVAL.equals(zzby) || DM_STALE_SYNC_REQUIRED.equals(zzby) || DM_DEACTIVATED.equals(zzby) || DM_REQUIRED.equals(zzby) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(zzby) || DM_SCREENLOCK_REQUIRED.equals(zzby);
    }
}
