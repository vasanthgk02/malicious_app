package sfs2x.client.entities;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.entities.managers.IUserManager;
import sfs2x.client.entities.variables.SFSUserVariable;
import sfs2x.client.entities.variables.UserVariable;

public class SFSUser implements User {
    public Vec3D aoiEntryPoint;
    public int id;
    public boolean isItMe;
    public boolean isModerator;
    public String name;
    public Map<Integer, Integer> playerIdByRoomId;
    public int privilegeId;
    public Map<String, Object> properties;
    public IUserManager userManager;
    public Map<String, UserVariable> variables;

    public SFSUser(int i, String str) {
        this(i, str, false);
    }

    public static User fromSFSArray(ISFSArray iSFSArray, Room room) {
        SFSUser sFSUser = new SFSUser(iSFSArray.getInt(0).intValue(), iSFSArray.getUtfString(1));
        sFSUser.setPrivilegeId(iSFSArray.getShort(2).shortValue());
        if (room != null) {
            sFSUser.setPlayerId(iSFSArray.getShort(3).shortValue(), room);
        }
        ISFSArray sFSArray = iSFSArray.getSFSArray(4);
        for (int i = 0; i < sFSArray.size(); i++) {
            sFSUser.setVariable(SFSUserVariable.fromSFSArray(sFSArray.getSFSArray(i)));
        }
        return sFSUser;
    }

    public boolean containsVariable(String str) {
        boolean containsKey;
        synchronized (this.variables) {
            containsKey = this.variables.containsKey(str);
        }
        return containsKey;
    }

    public Vec3D getAOIEntryPoint() {
        return this.aoiEntryPoint;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPlayerId() {
        return getPlayerId(this.userManager.getSmartFox().getLastJoinedRoom());
    }

    public int getPrivilegeId() {
        return this.privilegeId;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public IUserManager getUserManager() {
        return this.userManager;
    }

    public UserVariable getVariable(String str) {
        synchronized (this.variables) {
            if (!this.variables.containsKey(str)) {
                return null;
            }
            UserVariable userVariable = this.variables.get(str);
            return userVariable;
        }
    }

    public List<UserVariable> getVariables() {
        ArrayList arrayList;
        synchronized (this.variables) {
            arrayList = new ArrayList(this.variables.values());
        }
        return arrayList;
    }

    public boolean isAdmin() {
        return this.privilegeId == 3;
    }

    public boolean isGuest() {
        return this.privilegeId == 0;
    }

    public boolean isItMe() {
        return this.isItMe;
    }

    public boolean isJoinedInRoom(Room room) {
        return room.containsUser(this);
    }

    public boolean isModerator() {
        return this.privilegeId == 2;
    }

    public boolean isPlayer() {
        return getPlayerId() > 0;
    }

    public boolean isPlayerInRoom(Room room) {
        return this.playerIdByRoomId.get(Integer.valueOf(room.getId())).intValue() > 0;
    }

    public boolean isSpectator() {
        return !isPlayer();
    }

    public boolean isSpectatorInRoom(Room room) {
        return this.playerIdByRoomId.get(Integer.valueOf(room.getId())).intValue() < 0;
    }

    public boolean isStandardUser() {
        return this.privilegeId == 1;
    }

    public void removePlayerId(Room room) {
        this.playerIdByRoomId.remove(Integer.valueOf(room.getId()));
    }

    public void setAOIEntryPoint(Vec3D vec3D) {
        this.aoiEntryPoint = vec3D;
    }

    public void setPlayerId(int i, Room room) {
        this.playerIdByRoomId.put(Integer.valueOf(room.getId()), Integer.valueOf(i));
    }

    public void setPrivilegeId(int i) {
        this.privilegeId = i;
    }

    public void setProperties(Map<String, Object> map) {
        this.properties = map;
    }

    public void setUserManager(IUserManager iUserManager) {
        this.userManager = iUserManager;
    }

    public void setVariable(UserVariable userVariable) {
        synchronized (this.variables) {
            if (userVariable != null) {
                if (userVariable.isNull()) {
                    this.variables.remove(userVariable.getName());
                } else {
                    this.variables.put(userVariable.getName(), userVariable);
                }
            }
        }
    }

    public void setVariables(List<? extends UserVariable> list) {
        synchronized (this.variables) {
            for (UserVariable variable : list) {
                setVariable(variable);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[User: ");
        sb.append(this.name);
        sb.append(", Id: ");
        sb.append(this.id);
        sb.append(", isMe: ");
        return GeneratedOutlineSupport.outline66(sb, this.isItMe, CMapParser.MARK_END_OF_ARRAY);
    }

    public SFSUser(int i, String str, boolean z) {
        this.id = -1;
        this.privilegeId = 0;
        this.id = i;
        this.name = str;
        this.isItMe = z;
        this.variables = new HashMap();
        this.properties = new HashMap();
        this.isModerator = false;
        this.playerIdByRoomId = new HashMap();
    }

    public int getPlayerId(Room room) {
        if (this.playerIdByRoomId.containsKey(Integer.valueOf(room.getId()))) {
            return this.playerIdByRoomId.get(Integer.valueOf(room.getId())).intValue();
        }
        return 0;
    }

    public static User fromSFSArray(ISFSArray iSFSArray) {
        return fromSFSArray(iSFSArray, null);
    }
}
