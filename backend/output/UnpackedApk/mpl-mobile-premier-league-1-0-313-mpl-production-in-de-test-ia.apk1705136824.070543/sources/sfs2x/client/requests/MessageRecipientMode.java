package sfs2x.client.requests;

import com.android.tools.r8.GeneratedOutlineSupport;

public class MessageRecipientMode {
    public static final int TO_GROUP = 2;
    public static final int TO_ROOM = 1;
    public static final int TO_USER = 0;
    public static final int TO_ZONE = 3;
    public int mode;
    public Object target;

    public MessageRecipientMode(int i, Object obj) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline40("Illegal recipient mode: ", i));
        }
        this.mode = i;
        this.target = obj;
    }

    public int getMode() {
        return this.mode;
    }

    public Object getTarget() {
        return this.target;
    }
}
