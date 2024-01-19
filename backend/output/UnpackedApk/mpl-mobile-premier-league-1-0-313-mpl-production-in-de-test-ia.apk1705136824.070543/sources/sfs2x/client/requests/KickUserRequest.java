package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;

public class KickUserRequest extends BaseRequest {
    public static final String KEY_DELAY = "d";
    public static final String KEY_MESSAGE = "m";
    public static final String KEY_USER_ID = "u";
    public int delay;
    public String message;
    public int userId;

    public KickUserRequest(int i, String str, int i2) {
        super(24);
        this.userId = i;
        this.message = str;
        this.delay = i2;
        if (i2 < 0) {
            this.delay = 0;
        }
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putInt("u", this.userId);
        this.sfso.putInt("d", this.delay);
        String str = this.message;
        if (str != null && str.length() > 0) {
            this.sfso.putUtfString("m", this.message);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("KickUser request error", arrayList);
        }
    }

    public KickUserRequest(int i, String str) {
        this(i, str, 5);
    }

    public KickUserRequest(int i) {
        this(i, null, 5);
    }
}
