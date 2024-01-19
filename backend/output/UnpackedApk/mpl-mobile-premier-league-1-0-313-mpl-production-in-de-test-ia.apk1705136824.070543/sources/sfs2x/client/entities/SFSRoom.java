package sfs2x.client.entities;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cmap.CMapParser;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.entities.managers.IUserManager;
import sfs2x.client.entities.managers.SFSUserManager;
import sfs2x.client.entities.variables.RoomVariable;
import sfs2x.client.entities.variables.SFSRoomVariable;

public class SFSRoom implements Room {
    public String groupId;
    public int id;
    public boolean isGame;
    public boolean isHidden;
    public boolean isJoined;
    public boolean isManaged;
    public boolean isPasswordProtected;
    public int maxSpectators;
    public int maxUsers;
    public String name;
    public Map properties;
    public IRoomManager roomManager;
    public int specCount;
    public int userCount;
    public IUserManager userManager;
    public Map<String, RoomVariable> variables;

    public SFSRoom(int i, String str) {
        this(i, str, "default");
    }

    public static Room fromSFSArray(ISFSArray iSFSArray) {
        Room room;
        boolean z = iSFSArray.size() == 14;
        if (z) {
            room = new MMORoom(iSFSArray.getInt(0).intValue(), iSFSArray.getUtfString(1), iSFSArray.getUtfString(2));
        } else {
            room = new SFSRoom(iSFSArray.getInt(0).intValue(), iSFSArray.getUtfString(1), iSFSArray.getUtfString(2));
        }
        room.setGame(iSFSArray.getBool(3).booleanValue());
        room.setHidden(iSFSArray.getBool(4).booleanValue());
        room.setPasswordProtected(iSFSArray.getBool(5).booleanValue());
        room.setUserCount(iSFSArray.getShort(6).shortValue());
        room.setMaxUsers(iSFSArray.getShort(7).shortValue());
        ISFSArray sFSArray = iSFSArray.getSFSArray(8);
        if (sFSArray.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sFSArray.size(); i++) {
                arrayList.add(SFSRoomVariable.fromSFSArray(sFSArray.getSFSArray(i)));
            }
            room.setVariables(arrayList);
        }
        if (room.isGame()) {
            room.setSpectatorCount(iSFSArray.getShort(9).shortValue());
            room.setMaxSpectators(iSFSArray.getShort(10).shortValue());
        }
        if (z) {
            MMORoom mMORoom = (MMORoom) room;
            mMORoom.setDefaultAOI(Vec3D.fromArray(iSFSArray.get(11)));
            if (!iSFSArray.isNull(13)) {
                mMORoom.setLowerMapLimit(Vec3D.fromArray(iSFSArray.get(12)));
                mMORoom.setHigherMapLimit(Vec3D.fromArray(iSFSArray.get(13)));
            }
        }
        return room;
    }

    public void addUser(User user) {
        this.userManager.addUser(user);
    }

    public boolean containsUser(User user) {
        return this.userManager.containsUser(user);
    }

    public boolean containsVariable(String str) {
        boolean containsKey;
        synchronized (this.variables) {
            containsKey = this.variables.containsKey(str);
        }
        return containsKey;
    }

    public int getCapacity() {
        return this.maxUsers + this.maxSpectators;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int getId() {
        return this.id;
    }

    public int getMaxSpectators() {
        return this.maxSpectators;
    }

    public int getMaxUsers() {
        return this.maxUsers;
    }

    public String getName() {
        return this.name;
    }

    public List<User> getPlayerList() {
        ArrayList arrayList = new ArrayList();
        for (User next : this.userManager.getUserList()) {
            if (next.isPlayerInRoom(this)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Map<?, ?> getProperties() {
        return this.properties;
    }

    public IRoomManager getRoomManager() {
        return this.roomManager;
    }

    public int getSpectatorCount() {
        if (!this.isGame) {
            return 0;
        }
        if (this.isJoined) {
            return getSpectatorList().size();
        }
        return this.specCount;
    }

    public List<User> getSpectatorList() {
        ArrayList arrayList = new ArrayList();
        for (User next : this.userManager.getUserList()) {
            if (next.isSpectatorInRoom(this)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public User getUserById(int i) {
        return this.userManager.getUserById(i);
    }

    public User getUserByName(String str) {
        return this.userManager.getUserByName(str);
    }

    public int getUserCount() {
        if (!this.isJoined) {
            return this.userCount;
        }
        if (this.isGame) {
            return getPlayerList().size();
        }
        return this.userManager.getUserCount();
    }

    public List<User> getUserList() {
        return this.userManager.getUserList();
    }

    public RoomVariable getVariable(String str) {
        synchronized (this.variables) {
            if (!this.variables.containsKey(str)) {
                return null;
            }
            RoomVariable roomVariable = this.variables.get(str);
            return roomVariable;
        }
    }

    public List<RoomVariable> getVariables() {
        ArrayList arrayList;
        synchronized (this.variables) {
            arrayList = new ArrayList(this.variables.values());
        }
        return arrayList;
    }

    public boolean isGame() {
        return this.isGame;
    }

    public boolean isHidden() {
        return this.isHidden;
    }

    public boolean isJoined() {
        return this.isJoined;
    }

    public boolean isManaged() {
        return this.isManaged;
    }

    public boolean isPasswordProtected() {
        return this.isPasswordProtected;
    }

    public void merge(Room room) {
        synchronized (this.variables) {
            if (!this.isJoined) {
                this.variables.clear();
                for (RoomVariable next : room.getVariables()) {
                    this.variables.put(next.getName(), next);
                }
                this.userManager.replaceAll(room.getUserList());
            }
        }
    }

    public void removeUser(User user) {
        this.userManager.removeUser(user);
    }

    public void setGame(boolean z) {
        this.isGame = z;
    }

    public void setHidden(boolean z) {
        this.isHidden = z;
    }

    public void setJoined(boolean z) {
        this.isJoined = z;
    }

    public void setManaged(boolean z) {
        this.isManaged = z;
    }

    public void setMaxSpectators(int i) {
        this.maxSpectators = i;
    }

    public void setMaxUsers(int i) {
        this.maxUsers = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPasswordProtected(boolean z) {
        this.isPasswordProtected = z;
    }

    public void setProperties(Map<?, ?> map) {
        this.properties = map;
    }

    public void setRoomManager(IRoomManager iRoomManager) throws SFSException {
        if (this.roomManager == null) {
            this.roomManager = iRoomManager;
            return;
        }
        throw new SFSException("Room manager already assigned. Room: " + this);
    }

    public void setSpectatorCount(int i) {
        this.specCount = i;
    }

    public void setUserCount(int i) {
        this.userCount = i;
    }

    public void setVariable(RoomVariable roomVariable) {
        synchronized (this.variables) {
            if (roomVariable.isNull()) {
                this.variables.remove(roomVariable.getName());
            } else {
                this.variables.put(roomVariable.getName(), roomVariable);
            }
        }
    }

    public void setVariables(List<? extends RoomVariable> list) {
        synchronized (this.variables) {
            for (RoomVariable variable : list) {
                setVariable(variable);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[Room: ");
        sb.append(this.name);
        sb.append(", Id: ");
        sb.append(this.id);
        sb.append(", GroupId: ");
        return GeneratedOutlineSupport.outline62(sb, this.groupId, CMapParser.MARK_END_OF_ARRAY);
    }

    public SFSRoom(int i, String str, String str2) {
        this.id = i;
        this.name = str;
        this.groupId = str2;
        this.isHidden = false;
        this.isGame = false;
        this.isJoined = false;
        this.isManaged = true;
        this.specCount = 0;
        this.userCount = 0;
        this.variables = new HashMap();
        this.properties = new HashMap();
        this.userManager = new SFSUserManager(null);
    }
}
