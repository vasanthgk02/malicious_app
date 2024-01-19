package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import sfs2x.client.entities.Room;

public class PublicMessageRequest extends GenericMessageRequest {
    public PublicMessageRequest(String str, ISFSObject iSFSObject, Room room) {
        this.type = 0;
        this.message = str;
        this.room = room;
        this.params = iSFSObject;
    }

    public PublicMessageRequest(String str, ISFSObject iSFSObject) {
        this(str, iSFSObject, null);
    }

    public PublicMessageRequest(String str) {
        this(str, null, null);
    }
}
