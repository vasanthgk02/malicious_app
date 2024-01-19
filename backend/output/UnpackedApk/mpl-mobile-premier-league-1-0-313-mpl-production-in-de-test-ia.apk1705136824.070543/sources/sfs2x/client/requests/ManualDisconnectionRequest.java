package sfs2x.client.requests;

import sfs2x.client.ISmartFox;
import sfs2x.client.exceptions.SFSValidationException;

public class ManualDisconnectionRequest extends BaseRequest {
    public ManualDisconnectionRequest() {
        super(26);
    }

    public void execute(ISmartFox iSmartFox) {
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
    }
}
