package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;

public class PrivateMessageRequest extends GenericMessageRequest {
    public PrivateMessageRequest(String str, int i, ISFSObject iSFSObject) {
        this.type = 1;
        this.message = str;
        this.recipient = Integer.valueOf(i);
        this.params = iSFSObject;
    }

    public PrivateMessageRequest(String str, int i) {
        this(str, i, null);
    }
}
