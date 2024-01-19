package sfs2x.client.entities;

import java.util.List;
import java.util.Map;
import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.entities.managers.IUserManager;
import sfs2x.client.entities.variables.UserVariable;

public interface User {
    boolean containsVariable(String str);

    Vec3D getAOIEntryPoint();

    int getId();

    String getName();

    int getPlayerId();

    int getPlayerId(Room room);

    int getPrivilegeId();

    Map<String, Object> getProperties();

    IUserManager getUserManager();

    UserVariable getVariable(String str);

    List<UserVariable> getVariables();

    boolean isAdmin();

    boolean isGuest();

    boolean isItMe();

    boolean isJoinedInRoom(Room room);

    boolean isModerator();

    boolean isPlayer();

    boolean isPlayerInRoom(Room room);

    boolean isSpectator();

    boolean isSpectatorInRoom(Room room);

    boolean isStandardUser();

    void removePlayerId(Room room);

    void setAOIEntryPoint(Vec3D vec3D);

    void setPlayerId(int i, Room room);

    void setPrivilegeId(int i);

    void setProperties(Map<String, Object> map);

    void setUserManager(IUserManager iUserManager);

    void setVariable(UserVariable userVariable);

    void setVariables(List<? extends UserVariable> list);
}
