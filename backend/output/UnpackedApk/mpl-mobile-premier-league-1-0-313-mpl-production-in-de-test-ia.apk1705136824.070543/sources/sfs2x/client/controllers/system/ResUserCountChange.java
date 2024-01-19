package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;

public class ResUserCountChange implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        Room roomById = iSmartFox.getRoomManager().getRoomById(content.getInt("r").intValue());
        if (roomById != null) {
            short shortValue = content.getShort("uc").shortValue();
            short s = 0;
            if (content.containsKey("sc")) {
                s = content.getShort("sc").shortValue();
            }
            roomById.setUserCount(shortValue);
            roomById.setSpectatorCount(s);
            hashMap.put("room", roomById);
            hashMap.put("uCount", Integer.valueOf(shortValue));
            hashMap.put("sCount", Integer.valueOf(s));
            GeneratedOutlineSupport.outline98(SFSEvent.USER_COUNT_CHANGE, hashMap, iSmartFox);
        }
    }
}
