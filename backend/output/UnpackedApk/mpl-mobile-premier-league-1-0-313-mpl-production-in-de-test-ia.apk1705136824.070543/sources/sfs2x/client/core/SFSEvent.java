package sfs2x.client.core;

import java.util.Map;

public class SFSEvent extends BaseEvent {
    public static final String ADMIN_MESSAGE = "adminMessage";
    public static final String CONFIG_LOAD_FAILURE = "configLoadFailure";
    public static final String CONFIG_LOAD_SUCCESS = "configLoadSuccess";
    public static final String CONNECTION = "connection";
    public static final String CONNECTION_ATTEMPT_HTTP = "connectionAttemptHttp";
    public static final String CONNECTION_LOST = "connectionLost";
    public static final String CONNECTION_RESUME = "connectionResume";
    public static final String CONNECTION_RETRY = "connectionRetry";
    public static final String CRYPTO_INIT = "cryptoInit";
    public static final String EXTENSION_RESPONSE = "extensionResponse";
    public static final String HANDSHAKE = "handshake";
    public static final String INVITATION = "invitation";
    public static final String INVITATION_REPLY = "invitationReply";
    public static final String INVITATION_REPLY_ERROR = "invitationReplyError";
    public static final String LOGIN = "login";
    public static final String LOGIN_ERROR = "loginError";
    public static final String LOGOUT = "logout";
    public static final String MMOITEM_VARIABLES_UPDATE = "mmoItemVariablesUpdate";
    public static final String MODERATOR_MESSAGE = "moderatorMessage";
    public static final String OBJECT_MESSAGE = "objectMessage";
    public static final String PING_PONG = "pingPong";
    public static final String PLAYER_TO_SPECTATOR = "playerToSpectator";
    public static final String PLAYER_TO_SPECTATOR_ERROR = "playerToSpectatorError";
    public static final String PRIVATE_MESSAGE = "privateMessage";
    public static final String PROXIMITY_LIST_UPDATE = "proximityListUpdate";
    public static final String PUBLIC_MESSAGE = "publicMessage";
    public static final String ROOM_ADD = "roomAdd";
    public static final String ROOM_CAPACITY_CHANGE = "roomCapacityChange";
    public static final String ROOM_CAPACITY_CHANGE_ERROR = "roomCapacityChangeError";
    public static final String ROOM_CREATION_ERROR = "roomCreationError";
    public static final String ROOM_FIND_RESULT = "roomFindResult";
    public static final String ROOM_GROUP_SUBSCRIBE = "roomGroupSubscribe";
    public static final String ROOM_GROUP_SUBSCRIBE_ERROR = "roomGroupSubscribeError";
    public static final String ROOM_GROUP_UNSUBSCRIBE = "roomGroupUnsubscribe";
    public static final String ROOM_GROUP_UNSUBSCRIBE_ERROR = "roomGroupUnsubscribeError";
    public static final String ROOM_JOIN = "roomJoin";
    public static final String ROOM_JOIN_ERROR = "roomJoinError";
    public static final String ROOM_NAME_CHANGE = "roomNameChange";
    public static final String ROOM_NAME_CHANGE_ERROR = "roomNameChangeError";
    public static final String ROOM_PASSWORD_STATE_CHANGE = "roomPasswordStateChange";
    public static final String ROOM_PASSWORD_STATE_CHANGE_ERROR = "roomPasswordStateChangeError";
    public static final String ROOM_REMOVE = "roomRemove";
    public static final String ROOM_VARIABLES_UPDATE = "roomVariablesUpdate";
    public static final String SOCKET_ERROR = "socketError";
    public static final String SPECTATOR_TO_PLAYER = "spectatorToPlayer";
    public static final String SPECTATOR_TO_PLAYER_ERROR = "spectatorToPlayerError";
    public static final String UDP_INIT = "udpInit";
    public static final String USER_COUNT_CHANGE = "userCountChange";
    public static final String USER_ENTER_ROOM = "userEnterRoom";
    public static final String USER_EXIT_ROOM = "userExitRoom";
    public static final String USER_FIND_RESULT = "userFindResult";
    public static final String USER_VARIABLES_UPDATE = "userVariablesUpdate";

    public SFSEvent(String str, Map<String, Object> map) {
        super(str, map);
    }

    public SFSEvent(String str) {
        super(str, null);
    }
}
