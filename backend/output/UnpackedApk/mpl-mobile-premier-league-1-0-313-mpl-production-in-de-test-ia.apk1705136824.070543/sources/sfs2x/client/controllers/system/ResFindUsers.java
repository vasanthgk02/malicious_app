package sfs2x.client.controllers.system;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.SFSUser;
import sfs2x.client.entities.User;
import sfs2x.client.requests.FindUsersRequest;

public class ResFindUsers implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        ISFSArray sFSArray = content.getSFSArray(FindUsersRequest.KEY_FILTERED_USERS);
        ArrayList arrayList = new ArrayList();
        User mySelf = iSmartFox.getMySelf();
        for (int i = 0; i < sFSArray.size(); i++) {
            User fromSFSArray = SFSUser.fromSFSArray(sFSArray.getSFSArray(i));
            if (fromSFSArray.getId() == mySelf.getId()) {
                fromSFSArray = mySelf;
            }
            arrayList.add(fromSFSArray);
        }
        hashMap.put("users", arrayList);
        iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.USER_FIND_RESULT, hashMap));
    }
}
