package sfs2x.client.requests;

public class RoomEvents {
    public boolean allowUserCountChange = false;
    public boolean allowUserEnter = false;
    public boolean allowUserExit = false;
    public boolean allowUserVariablesUpdate = false;

    public boolean getAllowUserCountChange() {
        return this.allowUserCountChange;
    }

    public boolean getAllowUserEnter() {
        return this.allowUserEnter;
    }

    public boolean getAllowUserExit() {
        return this.allowUserExit;
    }

    public boolean getAllowUserVariablesUpdate() {
        return this.allowUserVariablesUpdate;
    }

    public void setAllowUserCountChange(boolean z) {
        this.allowUserCountChange = z;
    }

    public void setAllowUserEnter(boolean z) {
        this.allowUserEnter = z;
    }

    public void setAllowUserExit(boolean z) {
        this.allowUserExit = z;
    }

    public void setAllowUserVariablesUpdate(boolean z) {
        this.allowUserVariablesUpdate = z;
    }
}
