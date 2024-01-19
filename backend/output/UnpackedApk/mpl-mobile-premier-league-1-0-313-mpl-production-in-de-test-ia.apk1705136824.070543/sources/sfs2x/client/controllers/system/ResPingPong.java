package sfs2x.client.controllers.system;

import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.core.SFSEvent;

public class ResPingPong implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.put("lagValue", Integer.valueOf(iSmartFox.getLagMonitor().onPingPong()));
        iSmartFox.dispatchEvent(new SFSEvent(SFSEvent.PING_PONG, hashMap));
    }
}
