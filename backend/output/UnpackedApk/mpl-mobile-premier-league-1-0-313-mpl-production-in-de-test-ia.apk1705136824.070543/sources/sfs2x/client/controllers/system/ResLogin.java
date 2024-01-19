package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.SFSUser;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.LoginRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResLogin implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            systemController.populateRoomList(content.getSFSArray("rl"));
            iSmartFox.setMySelf(new SFSUser(content.getInt("id").intValue(), content.getUtfString(LoginRequest.KEY_USER_NAME), true));
            iSmartFox.getMySelf().setUserManager(iSmartFox.getUserManager());
            iSmartFox.getMySelf().setPrivilegeId(content.getShort(LoginRequest.KEY_PRIVILEGE_ID).shortValue());
            iSmartFox.getUserManager().addUser(iSmartFox.getMySelf());
            iSmartFox.setReconnectionSeconds(content.getShort(LoginRequest.KEY_RECONNECTION_SECONDS).shortValue());
            iSmartFox.getMySelf().setPrivilegeId(content.getShort(LoginRequest.KEY_PRIVILEGE_ID).shortValue());
            hashMap.put("zone", content.getUtfString("zn"));
            hashMap.put(Action.USER, iSmartFox.getMySelf());
            hashMap.put("data", content.getSFSObject("p"));
            SFSEvent sFSEvent = new SFSEvent(SFSEvent.LOGIN, hashMap);
            iSmartFox.handleLogin(sFSEvent);
            iSmartFox.dispatchEvent(sFSEvent);
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        GeneratedOutlineSupport.outline98(SFSEvent.LOGIN_ERROR, hashMap, iSmartFox);
    }
}
