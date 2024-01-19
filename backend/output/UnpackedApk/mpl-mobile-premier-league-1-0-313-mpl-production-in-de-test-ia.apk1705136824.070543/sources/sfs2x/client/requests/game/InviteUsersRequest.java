package sfs2x.client.requests.game;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.User;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class InviteUsersRequest extends BaseRequest {
    public static final String KEY_INVITATION_ID = "ii";
    public static final String KEY_INVITED_USERS = "iu";
    public static final String KEY_INVITEE_ID = "ee";
    public static final String KEY_PARAMS = "p";
    public static final String KEY_REPLY_ID = "ri";
    public static final String KEY_TIME = "t";
    public static final String KEY_USER = "u";
    public static final String KEY_USER_ID = "ui";
    public static final int MAX_EXPIRY_TIME = 300;
    public static final int MAX_INVITATIONS_FROM_CLIENT_SIDE = 8;
    public static final int MIN_EXPIRY_TIME = 5;
    public List<Object> invitedUsers;
    public ISFSObject params;
    public int secondsForAnswer;

    public InviteUsersRequest(List<Object> list, int i, ISFSObject iSFSObject) {
        super(300);
        this.invitedUsers = list;
        this.secondsForAnswer = i;
        this.params = iSFSObject;
    }

    public void execute(ISmartFox iSmartFox) {
        int i;
        ArrayList arrayList = new ArrayList();
        for (Object next : this.invitedUsers) {
            boolean z = next instanceof User;
            if (z || (next instanceof Buddy)) {
                if (z) {
                    i = ((User) next).getId();
                } else {
                    i = ((Buddy) next).getId();
                }
                if (i != iSmartFox.getMySelf().getId()) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        this.sfso.putIntArray(KEY_INVITED_USERS, arrayList);
        this.sfso.putShort("t", (short) this.secondsForAnswer);
        ISFSObject iSFSObject = this.params;
        if (iSFSObject != null) {
            this.sfso.putSFSObject("p", iSFSObject);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        List<Object> list = this.invitedUsers;
        if (list == null || list.isEmpty()) {
            arrayList.add("No invitation(s) to send");
        }
        if (this.invitedUsers.size() > 8) {
            arrayList.add("Too many invitations. Max allowed from client side is: 8");
        }
        int i = this.secondsForAnswer;
        if (i < 5 || i > 300) {
            arrayList.add("SecondsForAnswer value is out of range (5-300)");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("InvitationReply request error", arrayList);
        }
    }
}
