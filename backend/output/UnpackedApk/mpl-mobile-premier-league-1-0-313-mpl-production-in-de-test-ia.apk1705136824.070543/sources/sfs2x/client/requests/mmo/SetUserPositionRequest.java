package sfs2x.client.requests.mmo;

import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.LinkedList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.MMORoom;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class SetUserPositionRequest extends BaseRequest {
    public static final String KEY_MINUS_ITEM_LIST = "n";
    public static final String KEY_MINUS_USER_LIST = "m";
    public static final String KEY_PLUS_ITEM_LIST = "q";
    public static final String KEY_PLUS_USER_LIST = "p";
    public static final String KEY_ROOM = "r";
    public static final String KEY_VEC3D = "v";
    public Vec3D pos;
    public Room room;

    public SetUserPositionRequest(Vec3D vec3D, Room room2) {
        super(30);
        this.pos = vec3D;
        this.room = room2;
    }

    public void execute(ISmartFox iSmartFox) throws SFSException {
        this.sfso.putInt("r", this.room.getId());
        if (this.pos.isFloat()) {
            this.sfso.putFloatArray("v", this.pos.toFloatArray());
        } else {
            this.sfso.putIntArray("v", this.pos.toIntArray());
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        LinkedList linkedList = new LinkedList();
        if (this.pos == null) {
            linkedList.add("Position must be a valid Vec3D ");
        }
        if (this.room == null) {
            this.room = iSmartFox.getLastJoinedRoom();
        }
        if (this.room == null) {
            linkedList.add("You are not joined in any room");
        }
        if (!(this.room instanceof MMORoom)) {
            linkedList.add("Selected Room is not an MMORoom");
        }
        if (linkedList.size() > 0) {
            throw new SFSValidationException("SetUserVariables request error", linkedList);
        }
    }
}
