package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.HashMap;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;

public class ResUserLost implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        User userById = iSmartFox.getUserManager().getUserById(iMessage.getContent().getInt("u").intValue());
        if (userById != null) {
            List<Room> userRooms = iSmartFox.getRoomManager().getUserRooms(userById);
            iSmartFox.getRoomManager().removeUser(userById);
            iSmartFox.getUserManager().removeUser(userById);
            for (Room put : userRooms) {
                HashMap hashMap = new HashMap();
                hashMap.put(Action.USER, userById);
                hashMap.put("room", put);
                GeneratedOutlineSupport.outline98(SFSEvent.USER_EXIT_ROOM, hashMap, iSmartFox);
            }
        }
    }
}
