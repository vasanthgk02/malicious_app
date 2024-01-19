package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.SFSRoom;
import sfs2x.client.entities.User;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.JoinRoomRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResJoinRoom implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        IRoomManager roomManager = iSmartFox.getRoomManager();
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        iSmartFox.setJoining(false);
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            ISFSArray sFSArray = content.getSFSArray("r");
            ISFSArray sFSArray2 = content.getSFSArray(JoinRoomRequest.KEY_USER_LIST);
            Room fromSFSArray = SFSRoom.fromSFSArray(sFSArray);
            fromSFSArray.setRoomManager(iSmartFox.getRoomManager());
            Room replaceRoom = roomManager.replaceRoom(fromSFSArray, roomManager.containsGroup(fromSFSArray.getGroupId()));
            for (int i = 0; i < sFSArray2.size(); i++) {
                ISFSArray sFSArray3 = sFSArray2.getSFSArray(i);
                User orCreateUser = systemController.getOrCreateUser(sFSArray3, true, replaceRoom);
                orCreateUser.setPlayerId(sFSArray3.getShort(3).shortValue(), replaceRoom);
                replaceRoom.addUser(orCreateUser);
            }
            replaceRoom.setJoined(true);
            iSmartFox.setLastJoinedRoom(replaceRoom);
            hashMap.put("room", replaceRoom);
            GeneratedOutlineSupport.outline98(SFSEvent.ROOM_JOIN, hashMap, iSmartFox);
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        GeneratedOutlineSupport.outline98(SFSEvent.ROOM_JOIN_ERROR, hashMap, iSmartFox);
    }
}
