package sfs2x.client.entities.managers;

import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.variables.BuddyVariable;
import sfs2x.client.entities.variables.ReservedBuddyVariables;
import sfs2x.client.entities.variables.SFSBuddyVariable;

public class SFSBuddyManager implements IBuddyManager {
    public Map<String, Buddy> buddiesByName = new ConcurrentHashMap();
    public List<String> buddyStates;
    public boolean inited = false;
    public boolean myOnlineState;
    public Map<String, BuddyVariable> myVariables = new ConcurrentHashMap();
    public ISmartFox sfs;

    public SFSBuddyManager(ISmartFox iSmartFox) {
        this.sfs = iSmartFox;
    }

    public void addBuddy(Buddy buddy) {
        this.buddiesByName.put(buddy.getName(), buddy);
    }

    public void clearAll() {
        this.buddiesByName.clear();
    }

    public boolean containsBuddy(String str) {
        return this.buddiesByName.containsKey(str);
    }

    public Buddy getBuddyById(int i) {
        if (i > -1) {
            for (Buddy next : this.buddiesByName.values()) {
                if (next.getId() == i) {
                    return next;
                }
            }
        }
        return null;
    }

    public Buddy getBuddyByName(String str) {
        return this.buddiesByName.get(str);
    }

    public Buddy getBuddyByNickName(String str) {
        for (Buddy next : this.buddiesByName.values()) {
            if (next.getNickName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public List<Buddy> getBuddyList() {
        return new ArrayList(this.buddiesByName.values());
    }

    public List<String> getBuddyStates() {
        return this.buddyStates;
    }

    public String getMyNickName() {
        BuddyVariable myVariable = getMyVariable(ReservedBuddyVariables.BV_NICKNAME);
        if (myVariable != null) {
            return myVariable.getStringValue();
        }
        return null;
    }

    public boolean getMyOnlineState() {
        if (!this.inited) {
            return false;
        }
        boolean z = true;
        BuddyVariable myVariable = getMyVariable(ReservedBuddyVariables.BV_ONLINE);
        if (myVariable != null) {
            z = myVariable.getBoolValue().booleanValue();
        }
        return z;
    }

    public String getMyState() {
        BuddyVariable myVariable = getMyVariable(ReservedBuddyVariables.BV_STATE);
        if (myVariable != null) {
            return myVariable.getStringValue();
        }
        return null;
    }

    public BuddyVariable getMyVariable(String str) {
        return this.myVariables.get(str);
    }

    public List<BuddyVariable> getMyVariables() {
        return new ArrayList(this.myVariables.values());
    }

    public List<Buddy> getOfflineBuddies() {
        ArrayList arrayList = new ArrayList();
        for (Buddy next : this.buddiesByName.values()) {
            if (!next.isOnline()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<Buddy> getOnlineBuddies() {
        ArrayList arrayList = new ArrayList();
        for (Buddy next : this.buddiesByName.values()) {
            if (next.isOnline()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public boolean isInited() {
        return this.inited;
    }

    public Buddy removeBuddyById(int i) {
        Buddy buddyById = getBuddyById(i);
        if (buddyById != null) {
            this.buddiesByName.remove(buddyById.getName());
        }
        return buddyById;
    }

    public Buddy removeBuddyByName(String str) {
        Buddy buddyByName = getBuddyByName(str);
        if (buddyByName != null) {
            this.buddiesByName.remove(buddyByName.getName());
        }
        return buddyByName;
    }

    public void setBuddyStates(List<String> list) {
        this.buddyStates = list;
    }

    public void setInited(boolean z) {
        this.inited = z;
    }

    public void setMyNickName(String str) throws SFSException {
        setMyVariable(new SFSBuddyVariable(ReservedBuddyVariables.BV_NICKNAME, str));
    }

    public void setMyOnlineState(boolean z) throws SFSException {
        setMyVariable(new SFSBuddyVariable(ReservedBuddyVariables.BV_ONLINE, Boolean.valueOf(z)));
    }

    public void setMyState(String str) throws SFSException {
        setMyVariable(new SFSBuddyVariable(ReservedBuddyVariables.BV_STATE, str));
    }

    public void setMyVariable(BuddyVariable buddyVariable) {
        this.myVariables.put(buddyVariable.getName(), buddyVariable);
    }

    public void setMyVariables(List<BuddyVariable> list) {
        for (BuddyVariable myVariable : list) {
            setMyVariable(myVariable);
        }
    }
}
