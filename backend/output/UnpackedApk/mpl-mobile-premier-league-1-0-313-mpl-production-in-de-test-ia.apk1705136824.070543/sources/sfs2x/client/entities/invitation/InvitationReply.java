package sfs2x.client.entities.invitation;

public class InvitationReply {
    public static final int ACCEPT = 0;
    public static final int EXPIRED = 255;
    public static final int REFUSE = 1;

    public InvitationReply() {
        throw new UnsupportedOperationException("This class can't be instantiated");
    }

    public static String fromCode(int i) {
        return i != 0 ? i != 1 ? i != 255 ? "UNKNOWN" : "EXPIRED" : "REFUSED" : "ACCEPTED";
    }
}
