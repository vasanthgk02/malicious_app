package sfs2x.client.controllers.system;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.HashMap;
import org.slf4j.Logger;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSBuddyEvent;
import sfs2x.client.core.SFSEvent;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.SFSUser;
import sfs2x.client.entities.User;
import sfs2x.client.requests.GenericMessageRequest;

public class ResGenericMessage implements IResHandler {
    public ISmartFox sfs;

    private void handleAdminMessage(ISFSObject iSFSObject) throws SFSException {
        handleModMessage(iSFSObject, SFSEvent.ADMIN_MESSAGE);
    }

    private void handleBuddyMessage(ISFSObject iSFSObject) {
        HashMap hashMap = new HashMap();
        int intValue = iSFSObject.getInt("u").intValue();
        Buddy buddyById = this.sfs.getBuddyManager().getBuddyById(intValue);
        hashMap.put("isItMe", Boolean.valueOf(this.sfs.getMySelf().getId() == intValue));
        hashMap.put("buddy", buddyById);
        hashMap.put("message", iSFSObject.getUtfString("m"));
        hashMap.put("data", iSFSObject.getSFSObject("p"));
        this.sfs.dispatchEvent(new SFSBuddyEvent(SFSBuddyEvent.BUDDY_MESSAGE, hashMap));
    }

    private void handleModMessage(ISFSObject iSFSObject) throws SFSException {
        handleModMessage(iSFSObject, SFSEvent.MODERATOR_MESSAGE);
    }

    private void handleObjectMessage(ISFSObject iSFSObject) {
        HashMap hashMap = new HashMap();
        hashMap.put("sender", this.sfs.getUserManager().getUserById(iSFSObject.getInt("u").intValue()));
        hashMap.put("message", iSFSObject.getSFSObject("p"));
        GeneratedOutlineSupport.outline98(SFSEvent.OBJECT_MESSAGE, hashMap, this.sfs);
    }

    private void handlePrivateMessage(ISFSObject iSFSObject) throws SFSException {
        HashMap hashMap = new HashMap();
        User userById = this.sfs.getUserManager().getUserById(iSFSObject.getInt("u").intValue());
        if (userById == null) {
            if (!iSFSObject.containsKey(GenericMessageRequest.KEY_SENDER_DATA)) {
                this.sfs.getLogger().warn("Unexpected. Private message has no Sender details!");
                return;
            }
            userById = SFSUser.fromSFSArray(iSFSObject.getSFSArray(GenericMessageRequest.KEY_SENDER_DATA));
        }
        hashMap.put("sender", userById);
        hashMap.put("message", iSFSObject.getUtfString("m"));
        hashMap.put("data", iSFSObject.getSFSObject("p"));
        GeneratedOutlineSupport.outline98(SFSEvent.PRIVATE_MESSAGE, hashMap, this.sfs);
    }

    private void handlePublicMessage(ISFSObject iSFSObject) {
        HashMap hashMap = new HashMap();
        int intValue = iSFSObject.getInt("r").intValue();
        Room roomById = this.sfs.getRoomManager().getRoomById(intValue);
        if (roomById != null) {
            hashMap.put("room", roomById);
            hashMap.put("sender", this.sfs.getUserManager().getUserById(iSFSObject.getInt("u").intValue()));
            hashMap.put("message", iSFSObject.getUtfString("m"));
            hashMap.put("data", iSFSObject.getSFSObject("p"));
            GeneratedOutlineSupport.outline98(SFSEvent.PUBLIC_MESSAGE, hashMap, this.sfs);
            return;
        }
        Logger logger = this.sfs.getLogger();
        logger.warn("Unexpected, PublicMessage target room doesn't exist. RoomId: " + intValue);
    }

    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        this.sfs = iSmartFox;
        ISFSObject content = iMessage.getContent();
        byte byteValue = content.getByte("t").byteValue();
        if (byteValue == 0) {
            handlePublicMessage(content);
        } else if (byteValue == 1) {
            handlePrivateMessage(content);
        } else if (byteValue == 5) {
            handleBuddyMessage(content);
        } else if (byteValue == 2) {
            handleModMessage(content);
        } else if (byteValue == 3) {
            handleAdminMessage(content);
        } else if (byteValue == 4) {
            handleObjectMessage(content);
        }
    }

    private void handleModMessage(ISFSObject iSFSObject, String str) throws SFSException {
        HashMap hashMap = new HashMap();
        hashMap.put("sender", SFSUser.fromSFSArray(iSFSObject.getSFSArray(GenericMessageRequest.KEY_SENDER_DATA)));
        hashMap.put("message", iSFSObject.getUtfString("m"));
        hashMap.put("data", iSFSObject.getSFSObject("p"));
        GeneratedOutlineSupport.outline98(str, hashMap, this.sfs);
    }
}
