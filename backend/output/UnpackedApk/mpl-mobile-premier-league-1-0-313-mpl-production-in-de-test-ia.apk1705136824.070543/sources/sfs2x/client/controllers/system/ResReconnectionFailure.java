package sfs2x.client.controllers.system;

import sfs2x.client.ISmartFox;
import sfs2x.client.SmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;

public class ResReconnectionFailure implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        if (iSmartFox instanceof SmartFox) {
            iSmartFox.setReconnectionSeconds(0);
            ((SmartFox) iSmartFox).getSocketEngine().stopReconnection();
        }
    }
}
