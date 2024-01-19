package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import java.util.LinkedList;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.IMMOItem;
import sfs2x.client.entities.MMORoom;
import sfs2x.client.entities.variables.IMMOItemVariable;
import sfs2x.client.entities.variables.MMOItemVariable;

public class ResSetMMOItemVariable implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        int intValue = content.getInt("r").intValue();
        int intValue2 = content.getInt("i").intValue();
        ISFSArray sFSArray = content.getSFSArray("v");
        MMORoom mMORoom = (MMORoom) iSmartFox.getRoomManager().getRoomById(intValue);
        LinkedList linkedList = new LinkedList();
        if (mMORoom != null) {
            IMMOItem mMOItem = mMORoom.getMMOItem(intValue2);
            if (mMOItem != null) {
                for (int i = 0; i < sFSArray.size(); i++) {
                    IMMOItemVariable fromSFSArray = MMOItemVariable.fromSFSArray(sFSArray.getSFSArray(i));
                    mMOItem.setVariable(fromSFSArray);
                    linkedList.add(fromSFSArray.getName());
                }
                hashMap.put("changedVars", linkedList);
                hashMap.put("mmoItem", mMOItem);
                hashMap.put("room", mMORoom);
                GeneratedOutlineSupport.outline98(SFSEvent.MMOITEM_VARIABLES_UPDATE, hashMap, iSmartFox);
            }
        }
    }
}
