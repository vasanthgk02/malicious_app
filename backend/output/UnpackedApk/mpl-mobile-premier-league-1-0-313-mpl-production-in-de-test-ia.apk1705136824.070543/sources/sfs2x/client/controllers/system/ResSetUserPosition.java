package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.IMMOItem;
import sfs2x.client.entities.MMOItem;
import sfs2x.client.entities.MMORoom;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.requests.mmo.SetUserPositionRequest;

public class ResSetUserPosition implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        int intValue = content.getInt("r").intValue();
        Collection<Integer> intArray = content.getIntArray("m");
        ISFSArray sFSArray = content.getSFSArray("p");
        Collection<Integer> intArray2 = content.getIntArray("n");
        ISFSArray sFSArray2 = content.getSFSArray(SetUserPositionRequest.KEY_PLUS_ITEM_LIST);
        Room roomById = iSmartFox.getRoomManager().getRoomById(intValue);
        if (roomById == null) {
            Logger logger = iSmartFox.getLogger();
            logger.warn(" >>> TARGET ROOM IS NULL: " + intValue);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = new LinkedList();
        if (intArray != null && intArray.size() > 0) {
            for (Integer intValue2 : intArray) {
                User userById = roomById.getUserById(intValue2.intValue());
                if (userById != null) {
                    roomById.removeUser(userById);
                    linkedList2.add(userById);
                }
            }
        }
        if (sFSArray != null) {
            for (int i = 0; i < sFSArray.size(); i++) {
                ISFSArray sFSArray3 = sFSArray.getSFSArray(i);
                User orCreateUser = systemController.getOrCreateUser(sFSArray3, true, roomById);
                linkedList.add(orCreateUser);
                roomById.addUser(orCreateUser);
                if (sFSArray3.size() > 5) {
                    orCreateUser.setAOIEntryPoint(Vec3D.fromArray(sFSArray3.get(5)));
                }
            }
        }
        MMORoom mMORoom = (MMORoom) roomById;
        if (intArray2 != null) {
            for (Integer next : intArray2) {
                IMMOItem mMOItem = mMORoom.getMMOItem(next.intValue());
                if (mMOItem != null) {
                    mMORoom.RemoveItem(next.intValue());
                    linkedList4.add(mMOItem);
                }
            }
        }
        if (sFSArray2 != null) {
            for (int i2 = 0; i2 < sFSArray2.size(); i2++) {
                ISFSArray sFSArray4 = sFSArray2.getSFSArray(i2);
                IMMOItem fromSFSArray = MMOItem.fromSFSArray(sFSArray4);
                linkedList3.add(fromSFSArray);
                mMORoom.addMMOItem(fromSFSArray);
                if (sFSArray4.size() > 2) {
                    ((MMOItem) fromSFSArray).setAOIEntryPoint(Vec3D.fromArray(sFSArray4.get(2)));
                }
            }
        }
        hashMap.put("addedItems", linkedList3);
        hashMap.put("removedItems", linkedList4);
        hashMap.put("removedUsers", linkedList2);
        hashMap.put("addedUsers", linkedList);
        hashMap.put("room", mMORoom);
        GeneratedOutlineSupport.outline98(SFSEvent.PROXIMITY_LIST_UPDATE, hashMap, iSmartFox);
    }
}
