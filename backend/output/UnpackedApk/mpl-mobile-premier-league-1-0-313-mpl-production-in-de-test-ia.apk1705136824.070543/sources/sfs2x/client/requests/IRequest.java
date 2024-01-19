package sfs2x.client.requests;

import com.smartfoxserver.v2.exceptions.SFSException;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.exceptions.SFSValidationException;

public interface IRequest {
    void execute(ISmartFox iSmartFox) throws SFSException;

    IMessage getMessage();

    int getTargetController();

    boolean isEncrypted();

    void setEncrypted(boolean z);

    void setTargetController(int i);

    void validate(ISmartFox iSmartFox) throws SFSValidationException;
}
