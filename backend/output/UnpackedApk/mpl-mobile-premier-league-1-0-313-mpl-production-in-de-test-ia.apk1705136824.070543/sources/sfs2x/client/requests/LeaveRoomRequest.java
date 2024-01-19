package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;

public class LeaveRoomRequest extends BaseRequest {
    public static final String KEY_ROOM_ID = "r";
    public Room room;

    public LeaveRoomRequest(Room room2) {
        super(14);
        this.room = room2;
    }

    public void execute(ISmartFox iSmartFox) {
        Room room2 = this.room;
        if (room2 != null) {
            this.sfso.putInt("r", room2.getId());
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (iSmartFox.getJoinedRooms().size() < 1) {
            arrayList.add("You are not joined in any rooms");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("LeaveRoom request error", arrayList);
        }
    }

    public LeaveRoomRequest() {
        this(null);
    }
}
