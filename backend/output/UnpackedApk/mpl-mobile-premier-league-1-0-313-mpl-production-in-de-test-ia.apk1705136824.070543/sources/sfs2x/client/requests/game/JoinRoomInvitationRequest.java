package sfs2x.client.requests.game;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class JoinRoomInvitationRequest extends BaseRequest {
    public static final String KEY_AS_SPECT = "as";
    public static final String KEY_EXPIRY_SECONDS = "es";
    public static final String KEY_INVITED_NAMES = "in";
    public static final String KEY_OPTIONAL_PARAMS = "op";
    public static final String KEY_ROOM_ID = "r";
    public boolean asSpectator;
    public int expirySeconds;
    public List<String> invitedUserNames;
    public ISFSObject params;
    public Room targetRoom;

    public JoinRoomInvitationRequest(Room room, List<String> list) {
        this(room, list, null, 30, false);
    }

    public void execute(ISmartFox iSmartFox) throws SFSException {
        this.sfso.putInt("r", this.targetRoom.getId());
        this.sfso.putUtfStringArray("in", this.invitedUserNames);
        this.sfso.putSFSObject(KEY_OPTIONAL_PARAMS, this.params);
        this.sfso.putInt(KEY_EXPIRY_SECONDS, this.expirySeconds);
        this.sfso.putBool(KEY_AS_SPECT, this.asSpectator);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.targetRoom == null) {
            arrayList.add("Missing target room");
        } else {
            List<String> list = this.invitedUserNames;
            if (list == null || list.size() < 1) {
                arrayList.add("No invitees list provided");
            }
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("JoinRoomInvitationRequest request error", arrayList);
        }
    }

    public JoinRoomInvitationRequest(Room room, List<String> list, ISFSObject iSFSObject, int i) {
        this(room, list, iSFSObject, i, false);
    }

    public JoinRoomInvitationRequest(Room room, List<String> list, ISFSObject iSFSObject, int i, boolean z) {
        super(BaseRequest.JoinRoomInvite);
        this.targetRoom = room;
        this.invitedUserNames = list;
        this.params = iSFSObject;
        this.expirySeconds = i;
        this.asSpectator = z;
    }
}
