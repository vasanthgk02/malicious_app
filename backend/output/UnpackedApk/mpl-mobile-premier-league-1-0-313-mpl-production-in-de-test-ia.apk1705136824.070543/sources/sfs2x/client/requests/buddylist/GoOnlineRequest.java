package sfs2x.client.requests.buddylist;

import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class GoOnlineRequest extends BaseRequest {
    public static final String KEY_BUDDY_ID = "bi";
    public static final String KEY_BUDDY_NAME = "bn";
    public static final String KEY_ONLINE = "o";
    public boolean online;

    public GoOnlineRequest(boolean z) {
        super(BaseRequest.GoOnline);
        this.online = z;
    }

    public void execute(ISmartFox iSmartFox) throws SFSException {
        iSmartFox.getBuddyManager().setMyOnlineState(this.online);
        this.sfso.putBool(KEY_ONLINE, this.online);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (!iSmartFox.getBuddyManager().isInited()) {
            arrayList.add("BuddyList is not inited. Please send an InitBuddyRequest first.");
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("GoOnline request error", arrayList);
        }
    }
}
