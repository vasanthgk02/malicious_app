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
import sfs2x.client.entities.SFSBuddy;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.buddylist.BlockBuddyRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResBlockBuddy implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            String utfString = content.getUtfString("bn");
            Buddy buddyByName = iSmartFox.getBuddyManager().getBuddyByName(utfString);
            if (content.containsKey(BlockBuddyRequest.KEY_BUDDY)) {
                buddyByName = SFSBuddy.fromSFSArray(content.getSFSArray(BlockBuddyRequest.KEY_BUDDY));
                iSmartFox.getBuddyManager().addBuddy(buddyByName);
            } else if (buddyByName != null) {
                buddyByName.setBlocked(content.getBool("bs").booleanValue());
            } else {
                Logger logger = iSmartFox.getLogger();
                logger.warn("BlockBuddy failed, buddy not found: " + utfString + ", in local BuddyList");
                return;
            }
            hashMap.put("buddy", buddyByName);
            iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_BLOCK, hashMap));
        } else {
            short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
            hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
            hashMap.put("errorCode", Short.valueOf(shortValue));
            iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_ERROR, hashMap));
        }
    }
}
