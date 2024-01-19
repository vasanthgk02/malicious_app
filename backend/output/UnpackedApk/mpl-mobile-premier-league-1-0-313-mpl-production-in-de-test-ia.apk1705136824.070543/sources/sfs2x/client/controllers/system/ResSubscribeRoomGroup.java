package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResSubscribeRoomGroup implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            String utfString = content.getUtfString("g");
            ISFSArray sFSArray = content.getSFSArray("rl");
            if (iSmartFox.getRoomManager().containsGroup(utfString)) {
                Logger logger = iSmartFox.getLogger();
                logger.warn("SubscribeGroup Error. Group:" + utfString + "already subscribed!");
            }
            iSmartFox.getRoomManager().addGroup(utfString);
            systemController.populateRoomList(sFSArray);
            hashMap.put("groupId", utfString);
            hashMap.put("newRooms", iSmartFox.getRoomManager().getRoomListFromGroup(utfString));
            iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.ROOM_GROUP_SUBSCRIBE, hashMap));
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        GeneratedOutlineSupport.outline98(SFSEvent.ROOM_GROUP_SUBSCRIBE_ERROR, hashMap, iSmartFox);
    }
}