package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;

public class JoinRoomRequest extends BaseRequest {
    public static final String KEY_AS_SPECTATOR = "sp";
    public static final String KEY_PASS = "p";
    public static final String KEY_ROOM = "r";
    public static final String KEY_ROOM_ID = "i";
    public static final String KEY_ROOM_NAME = "n";
    public static final String KEY_ROOM_TO_LEAVE = "rl";
    public static final String KEY_USER_LIST = "ul";
    public boolean asSpectator;
    public int id;
    public String name;
    public String pass;
    public Integer roomIdToLeave;

    public JoinRoomRequest(Object obj, String str, Integer num, boolean z) {
        super(4);
        this.id = -1;
        if (obj instanceof String) {
            this.name = (String) obj;
        } else if (obj instanceof Integer) {
            this.id = ((Integer) obj).intValue();
        } else if (obj instanceof Room) {
            this.id = ((Room) obj).getId();
        }
        this.pass = str;
        this.roomIdToLeave = num;
        this.asSpectator = z;
    }

    public void execute(ISmartFox iSmartFox) {
        int i = this.id;
        if (i > -1) {
            this.sfso.putInt("i", i);
        } else {
            String str = this.name;
            if (str != null) {
                this.sfso.putUtfString("n", str);
            }
        }
        String str2 = this.pass;
        if (str2 != null) {
            this.sfso.putUtfString("p", str2);
        }
        Integer num = this.roomIdToLeave;
        if (num != null) {
            this.sfso.putInt("rl", num.intValue());
        }
        boolean z = this.asSpectator;
        if (z) {
            this.sfso.putBool(KEY_AS_SPECTATOR, z);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        if (this.id < 0 && this.name == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Missing Room id or name, you should provide at least one");
            throw new SFSValidationException("JoinRoomRequest Error", arrayList);
        }
    }

    public JoinRoomRequest(Object obj, String str, Integer num) {
        this(obj, str, num, false);
    }

    public JoinRoomRequest(Object obj, String str) {
        this(obj, str, null, false);
    }

    public JoinRoomRequest(Object obj) {
        this(obj, null, null, false);
    }
}
