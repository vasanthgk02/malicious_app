package sfs2x.client.controllers.system;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.SFSRoom;
import sfs2x.client.requests.FindRoomsRequest;

public class ResFindRooms implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        ISFSArray sFSArray = content.getSFSArray(FindRoomsRequest.KEY_FILTERED_ROOMS);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sFSArray.size(); i++) {
            Room fromSFSArray = SFSRoom.fromSFSArray(sFSArray.getSFSArray(i));
            Room roomById = iSmartFox.getRoomManager().getRoomById(fromSFSArray.getId());
            if (roomById != null) {
                fromSFSArray.setJoined(roomById.isJoined());
            }
            arrayList.add(fromSFSArray);
        }
        hashMap.put("rooms", arrayList);
        iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.ROOM_FIND_RESULT, hashMap));
    }
}
