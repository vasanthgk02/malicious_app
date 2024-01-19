package sfs2x.client.controllers.system;

import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;

public class ResHandshake implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("message", iMessage.getContent());
        SFSEvent sFSEvent = new SFSEvent(SFSEvent.HANDSHAKE, hashMap);
        iSmartFox.handleHandShake(sFSEvent);
        iSmartFox.dispatchEvent(sFSEvent);
    }
}
