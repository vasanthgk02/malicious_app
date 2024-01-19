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
import sfs2x.client.entities.invitation.SFSInvitation;
import sfs2x.client.requests.game.InviteUsersRequest;

public class ResInviteUsers implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        User user;
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        if (content.containsKey("ui")) {
            user = iSmartFox.getUserManager().getUserById(content.getInt("ui").intValue());
        } else {
            user = SFSUser.fromSFSArray(content.getSFSArray("u"));
        }
        short shortValue = content.getShort("t").shortValue();
        int intValue = content.getInt(InviteUsersRequest.KEY_INVITATION_ID).intValue();
        SFSInvitation sFSInvitation = new SFSInvitation(user, iSmartFox.getMySelf(), shortValue, content.getSFSObject("p"));
        sFSInvitation.setId(intValue);
        hashMap.put(SFSEvent.INVITATION, sFSInvitation);
        GeneratedOutlineSupport.outline98(SFSEvent.INVITATION, hashMap, iSmartFox);
    }
}
