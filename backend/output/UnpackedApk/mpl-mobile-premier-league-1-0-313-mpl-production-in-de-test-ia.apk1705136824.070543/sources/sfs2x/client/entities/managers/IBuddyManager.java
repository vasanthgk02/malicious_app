package sfs2x.client.entities.managers;

import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.List;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.variables.BuddyVariable;

public interface IBuddyManager {
    void addBuddy(Buddy buddy);

    void clearAll();

    boolean containsBuddy(String str);

    Buddy getBuddyById(int i);

    Buddy getBuddyByName(String str);

    Buddy getBuddyByNickName(String str);

    List<Buddy> getBuddyList();

    List<String> getBuddyStates();

    String getMyNickName();

    boolean getMyOnlineState();

    String getMyState();

    BuddyVariable getMyVariable(String str);

    List<BuddyVariable> getMyVariables();

    List<Buddy> getOfflineBuddies();

    List<Buddy> getOnlineBuddies();

    boolean isInited();

    Buddy removeBuddyById(int i);

    Buddy removeBuddyByName(String str);

    void setBuddyStates(List<String> list);

    void setInited(boolean z);

    void setMyNickName(String str) throws SFSException;

    void setMyOnlineState(boolean z) throws SFSException;

    void setMyState(String str) throws SFSException;

    void setMyVariable(BuddyVariable buddyVariable);

    void setMyVariables(List<BuddyVariable> list);
}
