package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.Collections;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.util.PasswordUtil;

public class LoginRequest extends BaseRequest {
    public static final String KEY_ID = "id";
    public static final String KEY_PARAMS = "p";
    public static final String KEY_PASSWORD = "pw";
    public static final String KEY_PRIVILEGE_ID = "pi";
    public static final String KEY_RECONNECTION_SECONDS = "rs";
    public static final String KEY_ROOMLIST = "rl";
    public static final String KEY_USER_NAME = "un";
    public static final String KEY_ZONE_NAME = "zn";
    public ISFSObject params;
    public String password;
    public String userName;
    public String zoneName;

    public LoginRequest(String str, String str2, String str3, ISFSObject iSFSObject) {
        super(1);
        this.zoneName = str3;
        this.userName = str;
        this.password = str2 == null ? "" : str2;
        this.params = iSFSObject;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putUtfString("zn", this.zoneName);
        this.sfso.putUtfString(KEY_USER_NAME, this.userName);
        if (this.password.length() > 0) {
            this.password = PasswordUtil.MD5Password(String.valueOf(iSmartFox.getSessionToken()) + this.password);
        }
        this.sfso.putUtfString(KEY_PASSWORD, this.password);
        ISFSObject iSFSObject = this.params;
        if (iSFSObject != null) {
            this.sfso.putSFSObject("p", iSFSObject);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        if (iSmartFox.getMySelf() == null) {
            String str = this.zoneName;
            if ((str == null || str.length() == 0) && iSmartFox.getConfig() != null) {
                this.zoneName = iSmartFox.getConfig().getZone();
            }
            String str2 = this.zoneName;
            if (str2 == null || str2.length() == 0) {
                throw new SFSValidationException("LoginRequest Error", Collections.singletonList("Missing Zone name"));
            }
            return;
        }
        throw new SFSValidationException("LoginRequest Error", Collections.singletonList("You are already logged in. Logout first"));
    }

    public LoginRequest(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public LoginRequest(String str, String str2) {
        this(str, str2, null, null);
    }

    public LoginRequest(String str) {
        this(str, null, null, null);
    }
}
