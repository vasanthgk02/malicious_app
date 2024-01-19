package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;

public class ResUserExitRoom implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        int intValue = content.getInt("r").intValue();
        int intValue2 = content.getInt("u").intValue();
        Room roomById = iSmartFox.getRoomManager().getRoomById(intValue);
        User userById = iSmartFox.getUserManager().getUserById(intValue2);
        if (roomById == null || userById == null) {
            Logger logger = iSmartFox.getLogger();
            logger.warn("Failed to handle UserExit event. Room: " + roomById + ", User: " + userById);
            return;
        }
        roomById.removeUser(userById);
        iSmartFox.getUserManager().removeUser(userById);
        if (userById.isItMe() && roomById.isJoined()) {
            roomById.setJoined(false);
            if (iSmartFox.getJoinedRooms().size() == 0) {
                iSmartFox.setLastJoinedRoom(null);
            }
            if (!roomById.isManaged()) {
                iSmartFox.getRoomManager().removeRoom(roomById);
            }
        }
        hashMap.put(Action.USER, userById);
        hashMap.put("room", roomById);
        GeneratedOutlineSupport.outline98(SFSEvent.USER_EXIT_ROOM, hashMap, iSmartFox);
    }
}
