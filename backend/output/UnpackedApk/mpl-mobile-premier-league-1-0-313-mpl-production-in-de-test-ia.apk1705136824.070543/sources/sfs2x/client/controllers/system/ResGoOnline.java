package sfs2x.client.controllers.system;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSBuddyEvent;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.variables.ReservedBuddyVariables;
import sfs2x.client.entities.variables.SFSBuddyVariable;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.buddylist.GoOnlineRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResGoOnline implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            String utfString = content.getUtfString("bn");
            Buddy buddyByName = iSmartFox.getBuddyManager().getBuddyByName(utfString);
            boolean equals = utfString.equals(iSmartFox.getMySelf().getName());
            byte byteValue = content.getByte(GoOnlineRequest.KEY_ONLINE).byteValue();
            boolean z = true;
            boolean z2 = byteValue == 0;
            if (equals) {
                if (iSmartFox.getBuddyManager().getMyOnlineState() != z2) {
                    Logger logger = iSmartFox.getLogger();
                    logger.warn("Unexpected: MyOnlineState is not in synch with the server. Resynching: " + z2);
                    iSmartFox.getBuddyManager().setMyOnlineState(z2);
                }
            } else if (buddyByName != null) {
                buddyByName.setId(content.getInt(GoOnlineRequest.KEY_BUDDY_ID).intValue());
                buddyByName.setVariable(new SFSBuddyVariable(ReservedBuddyVariables.BV_ONLINE, Boolean.valueOf(z2)));
                if (byteValue == 2) {
                    buddyByName.clearVolatileVariables();
                }
                z = iSmartFox.getBuddyManager().getMyOnlineState();
            } else {
                Logger logger2 = iSmartFox.getLogger();
                logger2.warn("GoOnline error, buddy not found: " + utfString + ", in local BuddyList.");
                return;
            }
            if (z) {
                hashMap.put("buddy", buddyByName);
                hashMap.put("isItMe", Boolean.valueOf(equals));
                iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_ONLINE_STATE_UPDATE, hashMap));
            }
        } else {
            short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
            hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
            hashMap.put("errorCode", Short.valueOf(shortValue));
            iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_ERROR, hashMap));
        }
    }
}
