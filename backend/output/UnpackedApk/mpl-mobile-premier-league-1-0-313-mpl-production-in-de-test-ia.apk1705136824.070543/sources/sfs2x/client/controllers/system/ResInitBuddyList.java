package sfs2x.client.controllers.system;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSBuddyEvent;
import sfs2x.client.entities.SFSBuddy;
import sfs2x.client.entities.variables.SFSBuddyVariable;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.buddylist.InitBuddyListRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResInitBuddyList implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            ISFSArray sFSArray = content.getSFSArray(InitBuddyListRequest.KEY_BLIST);
            ISFSArray sFSArray2 = content.getSFSArray("mv");
            Collection<String> utfStringArray = content.getUtfStringArray("bs");
            iSmartFox.getBuddyManager().clearAll();
            for (int i = 0; i < sFSArray.size(); i++) {
                iSmartFox.getBuddyManager().addBuddy(SFSBuddy.fromSFSArray(sFSArray.getSFSArray(i)));
            }
            if (utfStringArray != null) {
                iSmartFox.getBuddyManager().setBuddyStates(new ArrayList(utfStringArray));
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sFSArray2.size(); i2++) {
                arrayList.add(SFSBuddyVariable.fromSFSArray(sFSArray2.getSFSArray(i2)));
            }
            iSmartFox.getBuddyManager().setMyVariables(arrayList);
            iSmartFox.getBuddyManager().setInited(true);
            hashMap.put("buddyList", iSmartFox.getBuddyManager().getBuddyList());
            hashMap.put("myVariables", iSmartFox.getBuddyManager().getMyVariables());
            iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_LIST_INIT, hashMap));
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        iSmartFox.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_ERROR, hashMap));
    }
}
