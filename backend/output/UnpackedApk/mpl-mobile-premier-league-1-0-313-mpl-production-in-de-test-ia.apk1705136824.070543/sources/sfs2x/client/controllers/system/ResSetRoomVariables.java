package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.variables.RoomVariable;
import sfs2x.client.entities.variables.SFSRoomVariable;

public class ResSetRoomVariables implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        int intValue = content.getInt("r").intValue();
        ISFSArray sFSArray = content.getSFSArray("vl");
        Room roomById = iSmartFox.getRoomManager().getRoomById(intValue);
        ArrayList arrayList = new ArrayList();
        if (roomById != null) {
            for (int i = 0; i < sFSArray.size(); i++) {
                RoomVariable fromSFSArray = SFSRoomVariable.fromSFSArray(sFSArray.getSFSArray(i));
                roomById.setVariable(fromSFSArray);
                arrayList.add(fromSFSArray.getName());
            }
            hashMap.put("changedVars", arrayList);
            hashMap.put("room", roomById);
            GeneratedOutlineSupport.outline98(SFSEvent.ROOM_VARIABLES_UPDATE, hashMap, iSmartFox);
            return;
        }
        Logger logger = iSmartFox.getLogger();
        logger.warn("RoomVariablesUpdate, unknown Room id = " + intValue);
    }
}
