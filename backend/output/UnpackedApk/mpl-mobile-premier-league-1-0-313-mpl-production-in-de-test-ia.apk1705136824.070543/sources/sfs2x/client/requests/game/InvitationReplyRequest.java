package sfs2x.client.requests.game;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.invitation.Invitation;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class InvitationReplyRequest extends BaseRequest {
    public static final String KEY_INVITATION_ID = "i";
    public static final String KEY_INVITATION_PARAMS = "p";
    public static final String KEY_INVITATION_REPLY = "r";
    public Invitation invitation;
    public ISFSObject params;
    public int reply;

    public InvitationReplyRequest(Invitation invitation2, int i, ISFSObject iSFSObject) {
        super(BaseRequest.InvitationReply);
        this.invitation = invitation2;
        this.reply = i;
        this.params = iSFSObject;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putInt("i", this.invitation.getId());
        this.sfso.putByte("r", (byte) this.reply);
        ISFSObject iSFSObject = this.params;
        if (iSFSObject != null) {
            this.sfso.putSFSObject("p", iSFSObject);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.invitation == null) {
            arrayList.add("Missing invitation object");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("InvitationReply request error", arrayList);
        }
    }

    public InvitationReplyRequest(Invitation invitation2, int i) {
        this(invitation2, i, null);
    }
}
