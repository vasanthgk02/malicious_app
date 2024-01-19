package sfs2x.client.bitswarm.bbox;

import java.util.Map;
import sfs2x.client.core.SFSEvent;

public class BBEvent extends SFSEvent {
    public static final String CONNECT = "bb-connect";
    public static final String DATA = "bb-data";
    public static final String DISCONNECT = "bb-disconnect";
    public static final String IO_ERROR = "bb-ioError";
    public static final String SECURITY_ERROR = "bb-securityError";

    public BBEvent(String str) {
        super(str);
    }

    public BBEvent(String str, Map<String, Object> map) {
        super(str, map);
    }
}
