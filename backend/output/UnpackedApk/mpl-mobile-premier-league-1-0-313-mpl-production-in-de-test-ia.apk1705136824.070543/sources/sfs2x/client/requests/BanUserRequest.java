package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;

public class BanUserRequest extends BaseRequest {
    public static final String KEY_BAN_DURATION_HOURS = "dh";
    public static final String KEY_BAN_MODE = "b";
    public static final String KEY_DELAY = "d";
    public static final String KEY_MESSAGE = "m";
    public static final String KEY_USER_ID = "u";
    public int banMode;
    public int delay;
    public int durationHours;
    public String message;
    public int userId;

    public BanUserRequest(int i, String str, int i2, int i3, int i4) {
        super(25);
        this.userId = i;
        this.message = str;
        this.banMode = i2;
        this.delay = i3;
        this.durationHours = i4;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putInt("u", this.userId);
        this.sfso.putInt("d", this.delay);
        this.sfso.putInt("b", this.banMode);
        this.sfso.putInt(KEY_BAN_DURATION_HOURS, this.durationHours);
        String str = this.message;
        if (str != null && str.length() > 0) {
            this.sfso.putUtfString("m", this.message);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("BanUser request error", arrayList);
        }
    }

    public BanUserRequest(int i, String str, int i2, int i3) {
        this(i, str, i2, i3, 0);
    }

    public BanUserRequest(int i, String str, int i2) {
        this(i, str, i2, 5);
    }

    public BanUserRequest(int i, String str) {
        this(i, str, 1, 5);
    }

    public BanUserRequest(int i) {
        this(i, null, 1, 5);
    }
}
