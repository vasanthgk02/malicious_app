package sfs2x.client.entities;

import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.List;
import java.util.Map;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.entities.variables.RoomVariable;

public interface Room {
    void addUser(User user);

    boolean containsUser(User user);

    boolean containsVariable(String str);

    int getCapacity();

    String getGroupId();

    int getId();

    int getMaxSpectators();

    int getMaxUsers();

    String getName();

    List<User> getPlayerList();

    Map<?, ?> getProperties();

    IRoomManager getRoomManager();

    int getSpectatorCount();

    List<User> getSpectatorList();

    User getUserById(int i);

    User getUserByName(String str);

    int getUserCount();

    List<User> getUserList();

    RoomVariable getVariable(String str);

    List<RoomVariable> getVariables();

    boolean isGame();

    boolean isHidden();

    boolean isJoined();

    boolean isManaged();

    boolean isPasswordProtected();

    void merge(Room room);

    void removeUser(User user);

    void setGame(boolean z);

    void setHidden(boolean z);

    void setJoined(boolean z);

    void setManaged(boolean z);

    void setMaxSpectators(int i);

    void setMaxUsers(int i);

    void setName(String str);

    void setPasswordProtected(boolean z);

    void setProperties(Map<?, ?> map);

    void setRoomManager(IRoomManager iRoomManager) throws SFSException;

    void setSpectatorCount(int i);

    void setUserCount(int i);

    void setVariable(RoomVariable roomVariable);

    void setVariables(List<? extends RoomVariable> list);
}
