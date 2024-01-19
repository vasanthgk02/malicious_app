package sfs2x.client.controllers;

import com.mpl.androidapp.react.modules.SocialShareModule;
import com.mpl.androidapp.utils.Constant;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.fontbox.cmap.CMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.BaseController;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.SFSRoom;
import sfs2x.client.entities.SFSUser;
import sfs2x.client.entities.User;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.entities.variables.SFSUserVariable;
import sfs2x.client.requests.BaseRequest;

public class SystemController extends BaseController {
    public static final String RES_HANDLERS_PACKAGE = "sfs2x.client.controllers.system.";
    public BitSwarmClient bitSwarm;
    public Map<String, IResHandler> responseHandlerCache;
    public Map<Integer, String> responseHandlers;
    public ISmartFox sfs;

    public SystemController() {
        initRequestHandlers();
    }

    private String getEvtName(int i) {
        return this.responseHandlers.get(Integer.valueOf(i));
    }

    private void initRequestHandlers() {
        this.responseHandlers = new ConcurrentHashMap();
        this.responseHandlerCache = new ConcurrentHashMap();
        this.responseHandlers.put(Integer.valueOf(0), "ResHandshake");
        this.responseHandlers.put(Integer.valueOf(1), "ResLogin");
        this.responseHandlers.put(Integer.valueOf(2), "ResLogout");
        this.responseHandlers.put(Integer.valueOf(4), "ResJoinRoom");
        this.responseHandlers.put(Integer.valueOf(6), "ResCreateRoom");
        this.responseHandlers.put(Integer.valueOf(7), "ResGenericMessage");
        this.responseHandlers.put(Integer.valueOf(8), "ResChangeRoomName");
        this.responseHandlers.put(Integer.valueOf(9), "ResChangeRoomPassword");
        this.responseHandlers.put(Integer.valueOf(19), "ResChangeRoomCapacity");
        this.responseHandlers.put(Integer.valueOf(11), "ResSetRoomVariables");
        this.responseHandlers.put(Integer.valueOf(12), "ResSetUserVariables");
        this.responseHandlers.put(Integer.valueOf(13), "ResCallExtension");
        this.responseHandlers.put(Integer.valueOf(15), "ResSubscribeRoomGroup");
        this.responseHandlers.put(Integer.valueOf(16), "ResUnsubscribeRoomGroup");
        this.responseHandlers.put(Integer.valueOf(17), "ResSpectatorToPlayer");
        this.responseHandlers.put(Integer.valueOf(18), "ResPlayerToSpectator");
        this.responseHandlers.put(Integer.valueOf(200), "ResInitBuddyList");
        this.responseHandlers.put(Integer.valueOf(BaseRequest.AddBuddy), "ResAddBuddy");
        this.responseHandlers.put(Integer.valueOf(BaseRequest.RemoveBuddy), "ResRemoveBuddy");
        this.responseHandlers.put(Integer.valueOf(202), "ResBlockBuddy");
        this.responseHandlers.put(Integer.valueOf(BaseRequest.GoOnline), "ResGoOnline");
        this.responseHandlers.put(Integer.valueOf(BaseRequest.SetBuddyVariables), "ResSetBuddyVariables");
        this.responseHandlers.put(Integer.valueOf(27), "ResFindRooms");
        this.responseHandlers.put(Integer.valueOf(28), "ResFindUsers");
        this.responseHandlers.put(Integer.valueOf(300), "ResInviteUsers");
        this.responseHandlers.put(Integer.valueOf(BaseRequest.InvitationReply), "ResInvitationReply");
        this.responseHandlers.put(Integer.valueOf(BaseRequest.QuickJoinGame), "ResQuickJoinGame");
        this.responseHandlers.put(Integer.valueOf(29), "ResPingPong");
        this.responseHandlers.put(Integer.valueOf(30), "ResSetUserPosition");
        this.responseHandlers.put(Integer.valueOf(1000), "ResUserEnterRoom");
        this.responseHandlers.put(Integer.valueOf(1001), "ResUserCountChange");
        this.responseHandlers.put(Integer.valueOf(1002), "ResUserLost");
        this.responseHandlers.put(Integer.valueOf(SocialShareModule.SHARE_TO_WHATSAPP), "ResRoomLost");
        this.responseHandlers.put(Integer.valueOf(1004), "ResUserExitRoom");
        this.responseHandlers.put(Integer.valueOf(WebSocketProtocol.CLOSE_NO_STATUS_CODE), "ResClientDisconnect");
        this.responseHandlers.put(Integer.valueOf(1006), "ResReconnectionFailure");
        this.responseHandlers.put(Integer.valueOf(Constant.REQUEST_CODE_FOR_SHORT_CUT), "ResSetMMOItemVariable");
    }

    public User getOrCreateUser(ISFSArray iSFSArray, boolean z, Room room) throws SFSException {
        User userById = this.sfs.getUserManager().getUserById(iSFSArray.getInt(0).intValue());
        if (userById == null) {
            userById = SFSUser.fromSFSArray(iSFSArray, room);
            userById.setUserManager(this.sfs.getUserManager());
        } else if (room != null) {
            userById.setPlayerId(iSFSArray.getShort(3).shortValue(), room);
            ISFSArray sFSArray = iSFSArray.getSFSArray(4);
            for (int i = 0; i < sFSArray.size(); i++) {
                userById.setVariable(SFSUserVariable.fromSFSArray(sFSArray.getSFSArray(i)));
            }
        }
        if (z) {
            this.sfs.getUserManager().addUser(userById);
        }
        return userById;
    }

    public void handleMessage(IMessage iMessage) {
        IResHandler iResHandler;
        if (this.sfs.isDebug()) {
            Logger logger = this.log;
            logger.info("Message: " + getEvtName(iMessage.getId()) + CMap.SPACE + iMessage);
        }
        String str = this.responseHandlers.get(Integer.valueOf(iMessage.getId()));
        if (str != null) {
            try {
                if (this.responseHandlerCache.containsKey(str)) {
                    iResHandler = this.responseHandlerCache.get(str);
                } else {
                    iResHandler = (IResHandler) Class.forName(RES_HANDLERS_PACKAGE + str).newInstance();
                    this.responseHandlerCache.put(str, iResHandler);
                }
                iResHandler.handleResponse(this.sfs, this, iMessage);
            } catch (ClassNotFoundException unused) {
                this.log.warn(String.format("Cannot instantiate handler for eventId: %s, %s, Class: %s.%s", new Object[]{Integer.valueOf(iMessage.getId()), str, RES_HANDLERS_PACKAGE, str}));
            } catch (Exception e2) {
                Logger logger2 = this.log;
                logger2.warn("Error in handling event: " + e2);
                e2.printStackTrace();
            }
        } else {
            Logger logger3 = this.log;
            logger3.warn("Unknown message id: " + iMessage.getId());
        }
    }

    public void populateRoomList(ISFSArray iSFSArray) throws SFSException {
        IRoomManager roomManager = this.sfs.getRoomManager();
        for (int i = 0; i < iSFSArray.size(); i++) {
            roomManager.replaceRoom(SFSRoom.fromSFSArray(iSFSArray.getSFSArray(i)));
        }
    }

    public SystemController(ISmartFox iSmartFox) {
        this();
        this.sfs = iSmartFox;
    }

    public SystemController(BitSwarmClient bitSwarmClient) {
        this();
        this.bitSwarm = bitSwarmClient;
        this.sfs = bitSwarmClient.getSfs();
    }
}
