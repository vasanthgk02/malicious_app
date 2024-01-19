package sfs2x.client.requests.buddylist;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Buddy;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class BlockBuddyRequest extends BaseRequest {
    public static final String KEY_BUDDY = "bd";
    public static final String KEY_BUDDY_BLOCK_STATE = "bs";
    public static final String KEY_BUDDY_NAME = "bn";
    public boolean blocked;
    public String buddyName;

    public BlockBuddyRequest(String str, boolean z) {
        super(202);
        this.buddyName = str;
        this.blocked = z;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putUtfString("bn", this.buddyName);
        this.sfso.putBool("bs", this.blocked);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (!iSmartFox.getBuddyManager().isInited()) {
            arrayList.add("BuddyList is not inited. Please send an InitBuddyRequest first.");
        }
        String str = this.buddyName;
        if (str == null || str.length() < 1) {
            arrayList.add("Invalid buddy name: " + this.buddyName);
        }
        if (!iSmartFox.getBuddyManager().getMyOnlineState()) {
            arrayList.add("Can't block buddy while off-line");
        }
        Buddy buddyByName = iSmartFox.getBuddyManager().getBuddyByName(this.buddyName);
        if (buddyByName == null) {
            arrayList.add("Can't block buddy, it's not in your list: " + this.buddyName);
        } else if (buddyByName.isBlocked() == this.blocked) {
            arrayList.add("BuddyBlock flag is already in the requested state: " + this.blocked + ", for buddy: " + buddyByName);
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("BuddyList request error", arrayList);
        }
    }
}
