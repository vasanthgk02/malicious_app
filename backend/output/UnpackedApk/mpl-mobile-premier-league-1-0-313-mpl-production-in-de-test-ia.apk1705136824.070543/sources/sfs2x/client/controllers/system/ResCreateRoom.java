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
import sfs2x.client.entities.SFSRoom;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResCreateRoom implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            IRoomManager roomManager = iSmartFox.getRoomManager();
            Room fromSFSArray = SFSRoom.fromSFSArray(content.getSFSArray("r"));
            fromSFSArray.setRoomManager(iSmartFox.getRoomManager());
            roomManager.addRoom(fromSFSArray);
            hashMap.put("room", fromSFSArray);
            iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.ROOM_ADD, hashMap));
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        GeneratedOutlineSupport.outline98(SFSEvent.ROOM_CREATION_ERROR, hashMap, iSmartFox);
    }
}
