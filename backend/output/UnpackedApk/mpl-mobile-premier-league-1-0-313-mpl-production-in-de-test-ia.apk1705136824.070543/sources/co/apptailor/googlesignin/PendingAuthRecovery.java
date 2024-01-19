package co.apptailor.googlesignin;

import com.facebook.react.bridge.WritableMap;

public class PendingAuthRecovery {
    public WritableMap userProperties;

    public PendingAuthRecovery(WritableMap writableMap) {
        this.userProperties = writableMap;
    }
}
