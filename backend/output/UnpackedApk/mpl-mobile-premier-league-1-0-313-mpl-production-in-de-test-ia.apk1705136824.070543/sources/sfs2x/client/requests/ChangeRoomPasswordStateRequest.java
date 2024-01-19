package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;

public class ChangeRoomPasswordStateRequest extends BaseRequest {
    public static final String KEY_PASS = "p";
    public static final String KEY_ROOM = "r";
    public String newPass;
    public Room room;

    public ChangeRoomPasswordStateRequest(Room room2, String str) {
        super(9);
        this.room = room2;
        this.newPass = str;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putInt("r", this.room.getId());
        this.sfso.putUtfString("p", this.newPass);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.room == null) {
            arrayList.add("Provided room is null");
        }
        if (this.newPass == null) {
            arrayList.add("Invalid new room password. It must be a non-null string.");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("ChangePassState request error", arrayList);
        }
    }
}
