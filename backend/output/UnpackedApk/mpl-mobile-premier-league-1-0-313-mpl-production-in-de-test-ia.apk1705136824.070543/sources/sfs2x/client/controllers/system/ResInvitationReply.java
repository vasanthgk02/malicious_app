package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.SFSUser;
import sfs2x.client.entities.User;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.game.InviteUsersRequest;
import sfs2x.client.util.SFSErrorCodes;

public class ResInvitationReply implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        User user;
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (!content.containsKey(BaseRequest.KEY_ERROR_CODE)) {
            if (content.containsKey("ui")) {
                user = iSmartFox.getUserManager().getUserById(content.getInt("ui").intValue());
            } else {
                user = SFSUser.fromSFSArray(content.getSFSArray("u"));
            }
            byte byteValue = content.getByte(InviteUsersRequest.KEY_REPLY_ID).byteValue();
            ISFSObject sFSObject = content.getSFSObject("p");
            hashMap.put("invitee", user);
            hashMap.put("reply", Integer.valueOf(byteValue));
            hashMap.put("data", sFSObject);
            iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.INVITATION_REPLY, hashMap));
            return;
        }
        short shortValue = content.getShort(BaseRequest.KEY_ERROR_CODE).shortValue();
        hashMap.put("errorMessage", SFSErrorCodes.getErrorMessage(shortValue, content.getUtfStringArray(BaseRequest.KEY_ERROR_PARAMS).toArray()));
        hashMap.put("errorCode", Short.valueOf(shortValue));
        GeneratedOutlineSupport.outline98(SFSEvent.INVITATION_REPLY_ERROR, hashMap, iSmartFox);
    }
}
