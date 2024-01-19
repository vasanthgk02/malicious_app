package sfs2x.client.requests.buddylist;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import sfs2x.client.entities.Buddy;
import sfs2x.client.requests.GenericMessageRequest;

public class BuddyMessageRequest extends GenericMessageRequest {
    public BuddyMessageRequest(String str, Buddy buddy) {
        this(str, buddy, null);
    }

    public BuddyMessageRequest(String str, Buddy buddy, ISFSObject iSFSObject) {
        this.type = 5;
        this.message = str;
        this.recipient = Integer.valueOf(buddy != null ? buddy.getId() : -1);
        this.params = iSFSObject;
    }
}
