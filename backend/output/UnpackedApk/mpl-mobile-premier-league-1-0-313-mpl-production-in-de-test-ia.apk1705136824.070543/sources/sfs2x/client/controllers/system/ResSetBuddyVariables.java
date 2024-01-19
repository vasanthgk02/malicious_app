package sfs2x.client.controllers.system;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSBuddyEvent;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.variables.BuddyVariable;
import sfs2x.client.entities.variables.SFSBuddyVariable;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.buddylist.SetBuddyVariablesRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResSetBuddyVariables implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        boolean z;
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            String utfString = content.getUtfString("bn");
            ISFSArray sFSArray = content.getSFSArray(SetBuddyVariablesRequest.KEY_BUDDY_VARS);
            Buddy buddyByName = iSmartFox.getBuddyManager().getBuddyByName(utfString);
            boolean equals = utfString.equals(iSmartFox.getMySelf().getName());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < sFSArray.size(); i++) {
                BuddyVariable fromSFSArray = SFSBuddyVariable.fromSFSArray(sFSArray.getSFSArray(i));
                arrayList2.add(fromSFSArray);
                arrayList.add(fromSFSArray.getName());
            }
            if (equals) {
                iSmartFox.getBuddyManager().setMyVariables(arrayList2);
                z = true;
            } else if (buddyByName != null) {
                buddyByName.setVariables(arrayList2);
                z = iSmartFox.getBuddyManager().getMyOnlineState();
            } else {
                return;
            }
            if (z) {
                hashMap.put("isItMe", Boolean.valueOf(equals));
                hashMap.put("changedVars", arrayList);
                hashMap.put("buddy", buddyByName);
                iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_VARIABLES_UPDATE, hashMap));
            }
        } else {
            short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
            hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
            hashMap.put("errorCode", Short.valueOf(shortValue));
            iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_ERROR, hashMap));
        }
    }
}
