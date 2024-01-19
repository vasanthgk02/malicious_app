package lib.android.paypal.com.magnessdk;

import sfs2x.client.requests.buddylist.GoOnlineRequest;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public enum c$i {
    OPEN(GoOnlineRequest.KEY_ONLINE),
    EXCLUDED("e"),
    MIN_VERSION("m"),
    RAMP_THRESHOLD("r"),
    APP_IDS("ai"),
    APP_SOURCES(JoinRoomInvitationRequest.KEY_AS_SPECT),
    CONF_REFRESH_TIME_KEY("cr_ti");
    
    public final String h;

    /* access modifiers changed from: public */
    c$i(String str) {
        this.h = str;
    }

    public String toString() {
        return this.h;
    }
}
