package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;

public class AdminMessageRequest extends GenericMessageRequest {
    public AdminMessageRequest(String str, MessageRecipientMode messageRecipientMode, ISFSObject iSFSObject) {
        if (messageRecipientMode != null) {
            this.type = 3;
            this.message = str;
            this.params = iSFSObject;
            this.recipient = messageRecipientMode.getTarget();
            this.sendMode = messageRecipientMode.getMode();
            return;
        }
        throw new IllegalArgumentException("RecipientMode cannot be null!");
    }

    public AdminMessageRequest(String str, MessageRecipientMode messageRecipientMode) {
        this(str, messageRecipientMode, null);
    }
}
