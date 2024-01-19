package sfs2x.client.controllers.system;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.entities.managers.IUserManager;

public class ResRoomLost implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        Room roomById = iSmartFox.getRoomManager().getRoomById(content.getInt("r").intValue());
        IUserManager userManager = iSmartFox.getUserManager();
        if (roomById != null) {
            iSmartFox.getRoomManager().removeRoom(roomById);
            for (User removeUser : roomById.getUserList()) {
                userManager.removeUser(removeUser);
            }
            hashMap.put("room", roomById);
            iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.ROOM_REMOVE, hashMap));
        }
    }
}
