package sfs2x.client.controllers.system;

import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.controllers.IResHandler;
import sfs2x.client.controllers.SystemController;
import sfs2x.client.util.ClientDisconnectionReason;

public class ResClientDisconnect implements IResHandler {
    public void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception {
        iSmartFox.handleClientDisconnection(ClientDisconnectionReason.getReason(iMessage.getContent().getByte("dr").byteValue()));
    }
}
