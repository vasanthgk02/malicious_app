package sfs2x.client.requests;

public class RoomPermissions {
    public boolean allowNameChange;
    public boolean allowPasswordStateChange;
    public boolean allowPublicMessages;
    public boolean allowResizing;

    public boolean getAllowNameChange() {
        return this.allowNameChange;
    }

    public boolean getAllowPasswordStateChange() {
        return this.allowPasswordStateChange;
    }

    public boolean getAllowPublicMessages() {
        return this.allowPublicMessages;
    }

    public boolean getAllowResizing() {
        return this.allowResizing;
    }

    public void setAllowNameChange(boolean z) {
        this.allowNameChange = z;
    }

    public void setAllowPasswordStateChange(boolean z) {
        this.allowPasswordStateChange = z;
    }

    public void setAllowPublicMessages(boolean z) {
        this.allowPublicMessages = z;
    }

    public void setAllowResizing(boolean z) {
        this.allowResizing = z;
    }
}
