package sfs2x.client.entities.invitation;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import sfs2x.client.entities.User;

public class SFSInvitation implements Invitation {
    public int id;
    public User invitee;
    public User inviter;
    public ISFSObject parameters;
    public int secondsForAnswer;

    public SFSInvitation(User user, User user2, int i, ISFSObject iSFSObject) {
        this.inviter = user;
        this.invitee = user2;
        this.secondsForAnswer = i;
        this.parameters = iSFSObject;
    }

    public int getId() {
        return this.id;
    }

    public User getInvitee() {
        return this.invitee;
    }

    public User getInviter() {
        return this.inviter;
    }

    public ISFSObject getParams() {
        return this.parameters;
    }

    public int getSecondsForAnswer() {
        return this.secondsForAnswer;
    }

    public void setId(int i) {
        this.id = i;
    }

    public SFSInvitation(User user, User user2, int i) {
        this(user, user2, i, null);
    }

    public SFSInvitation(User user, User user2) {
        this(user, user2, 15, null);
    }
}
