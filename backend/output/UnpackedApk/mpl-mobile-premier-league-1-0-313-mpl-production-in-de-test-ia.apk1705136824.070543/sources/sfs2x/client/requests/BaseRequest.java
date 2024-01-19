package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.bitswarm.Message;

public abstract class BaseRequest implements IRequest {
    public static final int AddBuddy = 201;
    public static final int AdminMessage = 23;
    public static final int AutoJoin = 5;
    public static final int BanUser = 25;
    public static final int BlockBuddy = 202;
    public static final int CallExtension = 13;
    public static final int ChangeRoomCapacity = 19;
    public static final int ChangeRoomName = 8;
    public static final int ChangeRoomPassword = 9;
    public static final int CreateRoom = 6;
    public static final int CreateSFSGame = 302;
    public static final int FindRooms = 27;
    public static final int FindUsers = 28;
    public static final int GenericMessage = 7;
    public static final int GetRoomList = 3;
    public static final int GoOnline = 205;
    public static final int Handshake = 0;
    public static final int InitBuddyList = 200;
    public static final int InvitationReply = 301;
    public static final int InviteUser = 300;
    public static final int JoinRoom = 4;
    public static final int JoinRoomInvite = 304;
    public static final String KEY_ERROR_CODE = "ec";
    public static final String KEY_ERROR_PARAMS = "ep";
    public static final int KickUser = 24;
    public static final int LeaveRoom = 14;
    public static final int Login = 1;
    public static final int Logout = 2;
    public static final int ManualDisconnection = 26;
    public static final int ModeratorMessage = 22;
    public static final int ObjectMessage = 10;
    public static final int PingPong = 29;
    public static final int PlayerToSpectator = 18;
    public static final int PrivateMessage = 21;
    public static final int PublicMessage = 20;
    public static final int QuickJoinGame = 303;
    public static final int RemoveBuddy = 203;
    public static final int SetBuddyVariables = 204;
    public static final int SetRoomVariables = 11;
    public static final int SetUserPosition = 30;
    public static final int SetUserVariables = 12;
    public static final int SpectatorToPlayer = 17;
    public static final int SubscribeRoomGroup = 15;
    public static final int UnsubscribeRoomGroup = 16;
    public int id;
    public boolean isEncrypted = false;
    public ISFSObject sfso = SFSObject.newInstance();
    public int targetController = 0;

    public BaseRequest(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public IMessage getMessage() {
        Message message = new Message();
        message.setId(this.id);
        message.setEncrypted(this.isEncrypted);
        message.setTargetController(this.targetController);
        message.setContent(this.sfso);
        if (this instanceof ExtensionRequest) {
            message.setUDP(((ExtensionRequest) this).getUseUDP());
        }
        return message;
    }

    public int getTargetController() {
        return this.targetController;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setTargetController(int i) {
        this.targetController = i;
    }
}
