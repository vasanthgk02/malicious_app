package sfs2x.client.util;

public class ClientDisconnectionReason {
    public static final String BAN = "ban";
    public static final String IDLE = "idle";
    public static final String KICK = "kick";
    public static final String MANUAL = "manual";
    public static final String UNKNOWN = "unknown";
    public static String[] reasons = {IDLE, KICK, BAN};

    public static String getReason(int i) {
        return reasons[i];
    }
}
