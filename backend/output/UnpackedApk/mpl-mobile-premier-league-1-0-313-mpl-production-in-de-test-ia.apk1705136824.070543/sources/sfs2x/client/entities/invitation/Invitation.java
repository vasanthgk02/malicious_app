package sfs2x.client.entities.invitation;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import sfs2x.client.entities.User;

public interface Invitation {
    int getId();

    User getInvitee();

    User getInviter();

    ISFSObject getParams();

    int getSecondsForAnswer();

    void setId(int i);
}
