package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.util.SFSStringUtils;

public class SubscribeRoomGroupRequest extends BaseRequest {
    public static final String KEY_GROUP_ID = "g";
    public static final String KEY_ROOM_LIST = "rl";
    public String groupId;

    public SubscribeRoomGroupRequest(String str) {
        super(15);
        this.groupId = str;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putUtfString("g", this.groupId);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (SFSStringUtils.isEmptyOrNull(this.groupId)) {
            arrayList.add("Invalid groupId. Must be a string with at least 1 character.");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("SubscribeGroup request error", arrayList);
        }
    }
}
