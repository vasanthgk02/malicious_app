package sfs2x.client.requests;

import sfs2x.client.ISmartFox;

public class HandshakeRequest extends BaseRequest {
    public static final String KEY_API = "api";
    public static final String KEY_CLIENT_TYPE = "cl";
    public static final String KEY_COMPRESSION_THRESHOLD = "ct";
    public static final String KEY_MAX_MESSAGE_SIZE = "ms";
    public static final String KEY_RECONNECTION_TOKEN = "rt";
    public static final String KEY_SESSION_TOKEN = "tk";

    public HandshakeRequest(String str, String str2, String str3) {
        super(0);
        this.sfso.putUtfString(KEY_API, str);
        this.sfso.putUtfString(KEY_CLIENT_TYPE, str3);
        this.sfso.putBool("bin", true);
        if (str2 != null) {
            this.sfso.putUtfString(KEY_RECONNECTION_TOKEN, str2);
        }
    }

    public void execute(ISmartFox iSmartFox) {
    }

    public void validate(ISmartFox iSmartFox) {
    }

    public HandshakeRequest(String str, String str2) {
        this(str, null, str2);
    }
}
