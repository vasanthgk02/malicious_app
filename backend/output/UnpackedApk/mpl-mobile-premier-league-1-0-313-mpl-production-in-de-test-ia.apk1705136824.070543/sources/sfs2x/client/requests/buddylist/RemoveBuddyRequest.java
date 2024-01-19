package sfs2x.client.requests.buddylist;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class RemoveBuddyRequest extends BaseRequest {
    public static final String KEY_BUDDY_NAME = "bn";
    public String name;

    public RemoveBuddyRequest(String str) {
        super(BaseRequest.RemoveBuddy);
        this.name = str;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putUtfString("bn", this.name);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (!iSmartFox.getBuddyManager().isInited()) {
            arrayList.add("BuddyList is not inited. Please send an InitBuddyRequest first.");
        }
        if (!iSmartFox.getBuddyManager().getMyOnlineState()) {
            arrayList.add("Can't remove buddy while off-line");
        }
        if (!iSmartFox.getBuddyManager().containsBuddy(this.name)) {
            arrayList.add("Can't remove buddy, it's not in your list: " + this.name);
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("BuddyList request error", arrayList);
        }
    }
}
