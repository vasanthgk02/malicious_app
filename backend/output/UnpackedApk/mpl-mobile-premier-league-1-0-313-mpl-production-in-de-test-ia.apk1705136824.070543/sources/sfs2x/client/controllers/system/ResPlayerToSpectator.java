package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResPlayerToSpectator implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            int intValue = content.getInt("r").intValue();
            int intValue2 = content.getInt("u").intValue();
            User userById = iSmartFox.getUserManager().getUserById(intValue2);
            Room roomById = iSmartFox.getRoomManager().getRoomById(intValue);
            if (roomById == null) {
                Logger logger = iSmartFox.getLogger();
                logger.warn("Room not found, ID:" + intValue + ", PlayerToSpectator failed.");
            } else if (userById == null) {
                Logger logger2 = iSmartFox.getLogger();
                logger2.warn("User not found, ID:" + intValue2 + ", PlayerToSpectator failed.");
            } else if (userById.isJoinedInRoom(roomById)) {
                userById.setPlayerId(-1, roomById);
                hashMap.put("room", roomById);
                hashMap.put(Action.USER, userById);
                GeneratedOutlineSupport.outline98(SFSEvent.PLAYER_TO_SPECTATOR, hashMap, iSmartFox);
            } else {
                Logger logger3 = iSmartFox.getLogger();
                logger3.warn("User: " + userById + " not joined in Room: " + roomById + ", PlayerToSpectator failed.");
            }
        } else {
            short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
            hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
            hashMap.put("errorCode", Short.valueOf(shortValue));
            GeneratedOutlineSupport.outline98(SFSEvent.PLAYER_TO_SPECTATOR_ERROR, hashMap, iSmartFox);
        }
    }
}
