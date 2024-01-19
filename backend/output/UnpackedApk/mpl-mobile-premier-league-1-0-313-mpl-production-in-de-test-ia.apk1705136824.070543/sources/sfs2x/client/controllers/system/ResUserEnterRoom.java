package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;

public class ResUserEnterRoom implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        Room roomById = iSmartFox.getRoomManager().getRoomById(content.getInt("r").intValue());
        if (roomById != null) {
            User orCreateUser = systemController.getOrCreateUser(content.getSFSArray("u"), true, roomById);
            roomById.addUser(orCreateUser);
            hashMap.put(Action.USER, orCreateUser);
            hashMap.put("room", roomById);
            GeneratedOutlineSupport.outline98(SFSEvent.USER_ENTER_ROOM, hashMap, iSmartFox);
        }
    }
}
