package sfs2x.client.entities.managers;

import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;

public interface IRoomManager {
    void addGroup(String str);

    void addRoom(Room room);

    void addRoom(Room room, boolean z);

    void changeRoomCapacity(Room room, int i, int i2);

    void changeRoomName(Room room, String str);

    void changeRoomPasswordState(Room room, boolean z);

    boolean containsGroup(String str);

    boolean containsRoom(int i);

    boolean containsRoom(String str);

    boolean containsRoomInGroup(int i, String str);

    boolean containsRoomInGroup(String str, String str2);

    List<Room> getJoinedRooms();

    String getOwnerZone();

    Room getRoomById(int i);

    Room getRoomByName(String str);

    int getRoomCount();

    List<String> getRoomGroups();

    List<Room> getRoomList();

    List<Room> getRoomListFromGroup(String str);

    ISmartFox getSmartFox();

    List<Room> getUserRooms(User user);

    void removeGroup(String str);

    void removeRoom(Room room);

    void removeRoomById(int i);

    void removeRoomByName(String str);

    void removeUser(User user);

    Room replaceRoom(Room room);

    Room replaceRoom(Room room, boolean z);
}
