package sfs2x.client.entities;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.fontbox.cmap.CMapParser;
import sfs2x.client.entities.variables.BuddyVariable;
import sfs2x.client.entities.variables.ReservedBuddyVariables;
import sfs2x.client.entities.variables.SFSBuddyVariable;

public class SFSBuddy implements Buddy {
    public int id;
    public boolean isBlocked;
    public boolean isTemp;
    public String name;
    public Map<String, BuddyVariable> variables;

    public SFSBuddy(int i, String str, boolean z, boolean z2) {
        this.variables = new ConcurrentHashMap();
        this.name = str;
        this.id = i;
        this.isBlocked = z;
        this.isTemp = z2;
        this.variables = new HashMap();
    }

    public static Buddy fromSFSArray(ISFSArray iSFSArray) {
        SFSBuddy sFSBuddy = new SFSBuddy(iSFSArray.getInt(0).intValue(), iSFSArray.getUtfString(1), iSFSArray.getBool(2).booleanValue(), iSFSArray.size() > 4 ? iSFSArray.getBool(4).booleanValue() : false);
        ISFSArray sFSArray = iSFSArray.getSFSArray(3);
        for (int i = 0; i < sFSArray.size(); i++) {
            sFSBuddy.setVariable(SFSBuddyVariable.fromSFSArray(sFSArray.getSFSArray(i)));
        }
        return sFSBuddy;
    }

    public void clearVolatileVariables() {
        Iterator<BuddyVariable> it = this.variables.values().iterator();
        while (it.hasNext()) {
            if (!it.next().getName().startsWith(SFSBuddyVariable.OFFLINE_PREFIX)) {
                it.remove();
            }
        }
    }

    public boolean containsVariable(String str) {
        return this.variables.containsKey(str);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        BuddyVariable variable = getVariable(ReservedBuddyVariables.BV_NICKNAME);
        if (variable == null) {
            return null;
        }
        return variable.getStringValue();
    }

    public List<BuddyVariable> getOfflineVariables() {
        ArrayList arrayList = new ArrayList();
        for (BuddyVariable next : this.variables.values()) {
            if (next.getName().startsWith(SFSBuddyVariable.OFFLINE_PREFIX)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<BuddyVariable> getOnlineVariables() {
        ArrayList arrayList = new ArrayList();
        for (BuddyVariable next : this.variables.values()) {
            if (!next.getName().startsWith(SFSBuddyVariable.OFFLINE_PREFIX)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public String getState() {
        BuddyVariable variable = getVariable(ReservedBuddyVariables.BV_STATE);
        if (variable == null) {
            return null;
        }
        return variable.getStringValue();
    }

    public BuddyVariable getVariable(String str) {
        if (this.variables.containsKey(str)) {
            return this.variables.get(str);
        }
        return null;
    }

    public List<BuddyVariable> getVariables() {
        return new ArrayList(this.variables.values());
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isOnline() {
        boolean z;
        BuddyVariable variable = getVariable(ReservedBuddyVariables.BV_ONLINE);
        if (variable == null) {
            z = true;
        } else {
            z = variable.getBoolValue().booleanValue();
        }
        if (!z || this.id <= -1) {
            return false;
        }
        return true;
    }

    public boolean isTemp() {
        return this.isTemp;
    }

    public void removeVariable(String str) {
        this.variables.remove(str);
    }

    public void setBlocked(boolean z) {
        this.isBlocked = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setVariable(BuddyVariable buddyVariable) {
        this.variables.put(buddyVariable.getName(), buddyVariable);
    }

    public void setVariables(List<BuddyVariable> list) {
        for (BuddyVariable variable : list) {
            setVariable(variable);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[Buddy: ");
        sb.append(this.name);
        sb.append(", id: ");
        return GeneratedOutlineSupport.outline57(sb, this.id, CMapParser.MARK_END_OF_ARRAY);
    }

    public SFSBuddy(int i, String str, boolean z) {
        this(i, str, z, false);
    }

    public SFSBuddy(int i, String str) {
        this(i, str, false, false);
    }
}
