package sfs2x.client.entities.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;

public class SFSRoomManager implements IRoomManager {
    public final Lock globalLock = new ReentrantLock();
    public final Set<String> groups = new HashSet();
    public String ownerZone;
    public final Map<Integer, Room> roomsById = new HashMap();
    public final Map<String, Room> roomsByName = new HashMap();
    public final ISmartFox smartFox;

    public SFSRoomManager(ISmartFox iSmartFox) {
        this.smartFox = iSmartFox;
    }

    public void addGroup(String str) {
        synchronized (this.groups) {
            this.groups.add(str);
        }
    }

    public void addRoom(Room room) {
        addRoom(room, true);
    }

    public void changeRoomCapacity(Room room, int i, int i2) {
        room.setMaxUsers(i);
        room.setMaxSpectators(i2);
    }

    public void changeRoomName(Room room, String str) {
        this.globalLock.lock();
        try {
            String name = room.getName();
            room.setName(str);
            this.roomsByName.put(str, room);
            this.roomsByName.remove(name);
        } finally {
            this.globalLock.unlock();
        }
    }

    public void changeRoomPasswordState(Room room, boolean z) {
        room.setPasswordProtected(z);
    }

    public boolean containsGroup(String str) {
        boolean contains;
        synchronized (this.groups) {
            contains = this.groups.contains(str);
        }
        return contains;
    }

    public boolean containsRoom(int i) {
        this.globalLock.lock();
        try {
            return this.roomsById.containsKey(Integer.valueOf(i));
        } finally {
            this.globalLock.unlock();
        }
    }

    public boolean containsRoomInGroup(int i, String str) {
        for (Room id : getRoomListFromGroup(str)) {
            if (id.getId() == i) {
                return true;
            }
        }
        return false;
    }

    public List<Room> getJoinedRooms() {
        this.globalLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            for (Room next : this.roomsById.values()) {
                if (next.isJoined()) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } finally {
            this.globalLock.unlock();
        }
    }

    public String getOwnerZone() {
        return this.ownerZone;
    }

    /* JADX INFO: finally extract failed */
    public Room getRoomById(int i) {
        this.globalLock.lock();
        try {
            if (!this.roomsById.containsKey(Integer.valueOf(i))) {
                this.globalLock.unlock();
                return null;
            }
            Room room = this.roomsById.get(Integer.valueOf(i));
            this.globalLock.unlock();
            return room;
        } catch (Throwable th) {
            this.globalLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public Room getRoomByName(String str) {
        this.globalLock.lock();
        try {
            if (!this.roomsByName.containsKey(str)) {
                this.globalLock.unlock();
                return null;
            }
            Room room = this.roomsByName.get(str);
            this.globalLock.unlock();
            return room;
        } catch (Throwable th) {
            this.globalLock.unlock();
            throw th;
        }
    }

    public int getRoomCount() {
        this.globalLock.lock();
        try {
            return this.roomsById.size();
        } finally {
            this.globalLock.unlock();
        }
    }

    public List<String> getRoomGroups() {
        ArrayList arrayList;
        synchronized (this.groups) {
            arrayList = new ArrayList(this.groups);
        }
        return arrayList;
    }

    public List<Room> getRoomList() {
        this.globalLock.lock();
        try {
            return new ArrayList(this.roomsById.values());
        } finally {
            this.globalLock.unlock();
        }
    }

    public List<Room> getRoomListFromGroup(String str) {
        this.globalLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            for (Room next : this.roomsById.values()) {
                if (next.getGroupId().equals(str)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } finally {
            this.globalLock.unlock();
        }
    }

    public ISmartFox getSmartFox() {
        return this.smartFox;
    }

    public List<Room> getUserRooms(User user) {
        this.globalLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            for (Room next : this.roomsById.values()) {
                if (next.containsUser(user)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } finally {
            this.globalLock.unlock();
        }
    }

    public void removeGroup(String str) {
        synchronized (this.groups) {
            this.groups.remove(str);
            for (Room next : getRoomListFromGroup(str)) {
                if (!next.isJoined()) {
                    removeRoom(next);
                } else {
                    next.setManaged(false);
                }
            }
        }
    }

    public void removeRoom(Room room) {
        removeRoom(room.getId(), room.getName());
    }

    public void removeRoomById(int i) {
        this.globalLock.lock();
        try {
            if (this.roomsById.containsKey(Integer.valueOf(i))) {
                removeRoom(i, this.roomsById.get(Integer.valueOf(i)).getName());
            }
        } finally {
            this.globalLock.unlock();
        }
    }

    public void removeRoomByName(String str) {
        this.globalLock.lock();
        try {
            if (this.roomsByName.containsKey(str)) {
                removeRoom(this.roomsByName.get(str).getId(), str);
            }
        } finally {
            this.globalLock.unlock();
        }
    }

    public void removeUser(User user) {
        this.globalLock.lock();
        try {
            for (Room next : this.roomsById.values()) {
                if (next.containsUser(user)) {
                    next.removeUser(user);
                }
            }
        } finally {
            this.globalLock.unlock();
        }
    }

    public Room replaceRoom(Room room) {
        return replaceRoom(room, true);
    }

    private void removeRoom(int i, String str) {
        this.globalLock.lock();
        try {
            this.roomsById.remove(Integer.valueOf(i));
            this.roomsByName.remove(str);
        } finally {
            this.globalLock.unlock();
        }
    }

    public void addRoom(Room room, boolean z) {
        this.globalLock.lock();
        try {
            this.roomsById.put(Integer.valueOf(room.getId()), room);
            this.roomsByName.put(room.getName(), room);
            if (z) {
                addGroup(room.getGroupId());
            } else {
                room.setManaged(false);
            }
        } finally {
            this.globalLock.unlock();
        }
    }

    public Room replaceRoom(Room room, boolean z) {
        Room roomById = getRoomById(room.getId());
        if (roomById != null) {
            roomById.merge(room);
            return roomById;
        }
        addRoom(room, z);
        return room;
    }

    public boolean containsRoom(String str) {
        this.globalLock.lock();
        try {
            return this.roomsByName.containsKey(str);
        } finally {
            this.globalLock.unlock();
        }
    }

    public boolean containsRoomInGroup(String str, String str2) {
        for (Room name : getRoomListFromGroup(str2)) {
            if (name.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
