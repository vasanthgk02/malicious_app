package sfs2x.client.controllers;

import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;

public interface IResHandler {
    void handleResponse(ISmartFox iSmartFox, SystemController systemController, IMessage iMessage) throws Exception;
}
