package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.utils.Constants;
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

public class ResSpectatorToPlayer implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            int intValue = content.getInt("r").intValue();
            int intValue2 = content.getInt("u").intValue();
            short shortValue = content.getShort("p").shortValue();
            User userById = iSmartFox.getUserManager().getUserById(intValue2);
            Room roomById = iSmartFox.getRoomManager().getRoomById(intValue);
            if (roomById == null) {
                Logger logger = iSmartFox.getLogger();
                logger.warn("Room not found, ID:" + intValue + ", SpectatorToPlayer failed.");
            } else if (userById == null) {
                Logger logger2 = iSmartFox.getLogger();
                logger2.warn("User not found, ID:" + intValue2 + ", SpectatorToPlayer failed.");
            } else if (userById.isJoinedInRoom(roomById)) {
                userById.setPlayerId(shortValue, roomById);
                hashMap.put("room", roomById);
                hashMap.put(Action.USER, userById);
                hashMap.put(Constants.PLAYER_ID_KEY, Integer.valueOf(shortValue));
                GeneratedOutlineSupport.outline98(SFSEvent.SPECTATOR_TO_PLAYER, hashMap, iSmartFox);
            } else {
                Logger logger3 = iSmartFox.getLogger();
                logger3.warn("User: " + userById + " not joined in Room: " + roomById + ", SpectatorToPlayer failed.");
            }
        } else {
            short shortValue2 = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
            hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue2, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
            hashMap.put("errorCode", Short.valueOf(shortValue2));
            GeneratedOutlineSupport.outline98(SFSEvent.SPECTATOR_TO_PLAYER_ERROR, hashMap, iSmartFox);
        }
    }
}
