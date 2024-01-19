package sfs2x.client.core;

import java.util.Map;

public class SFSBuddyEvent extends BaseEvent {
    public static final String BUDDY_ADD = "buddyAdd";
    public static final String BUDDY_BLOCK = "buddyBlock";
    public static final String BUDDY_ERROR = "buddyError";
    public static final String BUDDY_LIST_INIT = "buddyListInit";
    public static final String BUDDY_MESSAGE = "buddyMessage";
    public static final String BUDDY_ONLINE_STATE_UPDATE = "buddyOnlineStateChange";
    public static final String BUDDY_REMOVE = "buddyRemove";
    public static final String BUDDY_VARIABLES_UPDATE = "buddyVariablesUpdate";

    public SFSBuddyEvent(String str, Map<String, Object> map) {
        super(str, map);
    }

    public SFSBuddyEvent(String str) {
        super(str, null);
    }
}
