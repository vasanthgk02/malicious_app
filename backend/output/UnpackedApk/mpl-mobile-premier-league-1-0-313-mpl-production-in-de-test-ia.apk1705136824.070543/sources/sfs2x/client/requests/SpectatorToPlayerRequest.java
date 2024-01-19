package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;

public class SpectatorToPlayerRequest extends BaseRequest {
    public static final String KEY_PLAYER_ID = "p";
    public static final String KEY_ROOM_ID = "r";
    public static final String KEY_USER_ID = "u";
    public Room room;

    public SpectatorToPlayerRequest(Room room2) {
        super(17);
        this.room = room2;
    }

    public void execute(ISmartFox iSmartFox) {
        if (this.room == null) {
            this.room = iSmartFox.getLastJoinedRoom();
        }
        this.sfso.putInt("r", this.room.getId());
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

    public SpectatorToPlayerRequest() {
        this(null);
    }
}
