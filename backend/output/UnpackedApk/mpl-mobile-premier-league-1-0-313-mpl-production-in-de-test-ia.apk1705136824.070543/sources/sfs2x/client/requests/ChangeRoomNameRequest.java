package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.util.SFSStringUtils;

public class ChangeRoomNameRequest extends BaseRequest {
    public static String KEY_NAME = "n";
    public static final String KEY_ROOM = "r";
    public String newName;
    public Room room;

    public ChangeRoomNameRequest(Room room2, String str) {
        super(8);
        this.room = room2;
        this.newName = str;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putInt("r", this.room.getId());
        this.sfso.putUtfString(KEY_NAME, this.newName);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.room == null) {
            arrayList.add("Provided room is null");
        }
        if (SFSStringUtils.isEmptyOrNull(this.newName)) {
            arrayList.add("Invalid new room name. It must be a non-null and non-empty string.");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("ChangeRoomName request error", arrayList);
        }
    }
}
