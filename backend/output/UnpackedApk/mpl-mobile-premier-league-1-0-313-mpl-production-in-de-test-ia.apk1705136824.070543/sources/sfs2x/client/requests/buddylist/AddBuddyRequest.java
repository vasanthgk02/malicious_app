package sfs2x.client.requests.buddylist;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Buddy;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class AddBuddyRequest extends BaseRequest {
    public static final String KEY_BUDDY_NAME = "bn";
    public String name;

    public AddBuddyRequest(String str) {
        super(BaseRequest.AddBuddy);
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
        String str = this.name;
        if (str == null || str.length() < 1) {
            arrayList.add("Invalid buddy name: " + this.name);
        }
        if (!iSmartFox.getBuddyManager().getMyOnlineState()) {
            arrayList.add("Can't add buddy while off-line");
        }
        Buddy buddyByName = iSmartFox.getBuddyManager().getBuddyByName(this.name);
        if (buddyByName != null && !buddyByName.isTemp()) {
            arrayList.add("Can't add buddy, it is already in your list: " + this.name);
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("BuddyList request error", arrayList);
        }
    }
}
