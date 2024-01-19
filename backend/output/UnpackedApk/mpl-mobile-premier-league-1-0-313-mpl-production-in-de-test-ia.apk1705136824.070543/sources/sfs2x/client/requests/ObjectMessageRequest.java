package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.List;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;

public class ObjectMessageRequest extends GenericMessageRequest {
    public ObjectMessageRequest(ISFSObject iSFSObject, Room room, List<User> list) {
        this.type = 4;
        this.params = iSFSObject;
        this.room = room;
        this.recipient = list;
    }

    public ObjectMessageRequest(ISFSObject iSFSObject, Room room) {
        this(iSFSObject, room, null);
    }

    public ObjectMessageRequest(ISFSObject iSFSObject) {
        this(iSFSObject, null, null);
    }
}
