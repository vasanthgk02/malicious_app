package sfs2x.client.entities;

import java.util.List;
import sfs2x.client.entities.variables.BuddyVariable;

public interface Buddy {
    void clearVolatileVariables();

    boolean containsVariable(String str);

    int getId();

    String getName();

    String getNickName();

    List<BuddyVariable> getOfflineVariables();

    List<BuddyVariable> getOnlineVariables();

    String getState();

    BuddyVariable getVariable(String str);

    List<BuddyVariable> getVariables();

    boolean isBlocked();

    boolean isOnline();

    boolean isTemp();

    void removeVariable(String str);

    void setBlocked(boolean z);

    void setId(int i);

    void setVariable(BuddyVariable buddyVariable);

    void setVariables(List<BuddyVariable> list);
}
