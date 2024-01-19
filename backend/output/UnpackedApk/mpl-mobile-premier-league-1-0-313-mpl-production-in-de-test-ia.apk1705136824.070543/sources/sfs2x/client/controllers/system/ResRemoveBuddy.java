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
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResRemoveBuddy implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            String utfString = content.getUtfString("bn");
            Buddy removeBuddyByName = iSmartFox.getBuddyManager().removeBuddyByName(utfString);
            if (removeBuddyByName != null) {
                hashMap.put("buddy", removeBuddyByName);
                iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_REMOVE, hashMap));
                return;
            }
            Logger logger = iSmartFox.getLogger();
            logger.warn("RemoveBuddy failed, buddy not found: " + utfString);
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_ERROR, hashMap));
    }
}
