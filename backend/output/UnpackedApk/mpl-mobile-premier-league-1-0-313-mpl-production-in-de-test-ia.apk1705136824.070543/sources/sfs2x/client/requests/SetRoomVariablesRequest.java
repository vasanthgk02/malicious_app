package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.SFSArray;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.variables.RoomVariable;
import sfs2x.client.exceptions.SFSValidationException;

public class SetRoomVariablesRequest extends BaseRequest {
    public static final String KEY_VAR_LIST = "vl";
    public static final String KEY_VAR_ROOM = "r";
    public Room room;
    public List<RoomVariable> roomVariables;

    public SetRoomVariablesRequest(List<RoomVariable> list, Room room2) {
        super(11);
        this.roomVariables = list;
        this.room = room2;
    }

    public void execute(ISmartFox iSmartFox) {
        SFSArray newInstance = SFSArray.newInstance();
        for (RoomVariable sFSArray : this.roomVariables) {
            newInstance.addSFSArray(sFSArray.toSFSArray());
        }
        if (this.room == null) {
            this.room = iSmartFox.getLastJoinedRoom();
        }
        this.sfso.putSFSArray("vl", newInstance);
        this.sfso.putInt("r", this.room.getId());
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        Room room2 = this.room;
        if (room2 != null) {
            if (!room2.containsUser(iSmartFox.getMySelf())) {
                arrayList.add("You are not joined in the target room");
            }
        } else if (iSmartFox.getLastJoinedRoom() == null) {
            arrayList.add("You are not joined in any rooms");
        }
        List<RoomVariable> list = this.roomVariables;
        if (list == null || list.isEmpty()) {
            arrayList.add("No variables were specified");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("SetRoomVariables request error", arrayList);
        }
    }

    public SetRoomVariablesRequest(List<RoomVariable> list) {
        this(list, null);
    }
}
