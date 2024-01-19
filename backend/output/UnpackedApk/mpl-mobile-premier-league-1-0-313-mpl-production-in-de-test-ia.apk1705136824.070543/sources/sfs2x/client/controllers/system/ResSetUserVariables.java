package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.User;
import sfs2x.client.entities.variables.SFSUserVariable;
import sfs2x.client.entities.variables.UserVariable;

public class ResSetUserVariables implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        int intValue = content.getInt("u").intValue();
        ISFSArray sFSArray = content.getSFSArray("vl");
        User userById = iSmartFox.getUserManager().getUserById(intValue);
        ArrayList arrayList = new ArrayList();
        if (userById != null) {
            for (int i = 0; i < sFSArray.size(); i++) {
                UserVariable fromSFSArray = SFSUserVariable.fromSFSArray(sFSArray.getSFSArray(i));
                userById.setVariable(fromSFSArray);
                arrayList.add(fromSFSArray.getName());
            }
            hashMap.put("changedVars", arrayList);
            hashMap.put(Action.USER, userById);
            GeneratedOutlineSupport.outline98(SFSEvent.USER_VARIABLES_UPDATE, hashMap, iSmartFox);
            return;
        }
        Logger logger = iSmartFox.getLogger();
        logger.warn("UserVariablesUpdate: unknown user id = " + intValue);
    }
}
