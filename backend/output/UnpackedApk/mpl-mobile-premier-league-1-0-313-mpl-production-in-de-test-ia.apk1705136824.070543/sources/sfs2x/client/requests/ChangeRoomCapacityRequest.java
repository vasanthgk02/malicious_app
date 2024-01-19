package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;

public class ChangeRoomCapacityRequest extends BaseRequest {
    public static final String KEY_ROOM = "r";
    public static final String KEY_SPEC_SIZE = "s";
    public static final String KEY_USER_SIZE = "u";
    public int newMaxSpect;
    public int newMaxUsers;
    public Room room;

    public ChangeRoomCapacityRequest(Room room2, int i, int i2) {
        super(19);
        this.room = room2;
        this.newMaxUsers = i;
        this.newMaxSpect = i2;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putInt("r", this.room.getId());
        this.sfso.putInt("u", this.newMaxUsers);
        this.sfso.putInt("s", this.newMaxSpect);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.room == null) {
            arrayList.add("Provided room is null");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("ChangeRoomCapacity request error", arrayList);
        }
    }
}
