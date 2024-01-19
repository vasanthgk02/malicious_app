package sfs2x.client.requests.buddylist;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class InitBuddyListRequest extends BaseRequest {
    public static final String KEY_BLIST = "bl";
    public static final String KEY_BUDDY_STATES = "bs";
    public static final String KEY_MY_VARS = "mv";

    public InitBuddyListRequest() {
        super(200);
    }

    public void execute(ISmartFox iSmartFox) {
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (iSmartFox.getBuddyManager().isInited()) {
            arrayList.add("Buddy List is already initialized.");
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("InitBuddyRequest error", arrayList);
        }
    }
}
