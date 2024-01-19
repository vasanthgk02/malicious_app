package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;

public class ModeratorMessageRequest extends GenericMessageRequest {
    public ModeratorMessageRequest(String str, MessageRecipientMode messageRecipientMode, ISFSObject iSFSObject) {
        if (messageRecipientMode != null) {
            this.type = 2;
            this.message = str;
            this.params = iSFSObject;
            this.recipient = messageRecipientMode.getTarget();
            this.sendMode = messageRecipientMode.getMode();
            return;
        }
        throw new IllegalArgumentException("RecipientMode cannot be null!");
    }

    public ModeratorMessageRequest(String str, MessageRecipientMode messageRecipientMode) {
        this(str, messageRecipientMode, null);
    }
}
