package sfs2x.client;

import java.util.List;
import org.slf4j.Logger;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.core.BaseEvent;
import sfs2x.client.core.EventDispatcher;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.entities.managers.IBuddyManager;
import sfs2x.client.entities.managers.IRoomManager;
import sfs2x.client.entities.managers.IUserManager;
import sfs2x.client.util.ConfigData;
import sfs2x.client.util.LagMonitor;

public interface ISmartFox {
    void dispatchEvent(BaseEvent baseEvent);

    IBuddyManager getBuddyManager();

    ConfigData getConfig();

    EventDispatcher getDispatcher();

    List<Room> getJoinedRooms();

    LagMonitor getLagMonitor();

    Room getLastJoinedRoom();

    Logger getLogger();

    User getMySelf();

    IRoomManager getRoomManager();

    String getSessionToken();

    BitSwarmClient getSocketEngine();

    IUserManager getUserManager();

    void handleClientDisconnection(String str);

    void handleHandShake(BaseEvent baseEvent);

    void handleLogin(BaseEvent baseEvent);

    void handleLogout();

    void initCrypto();

    boolean isConnected();

    boolean isDebug();

    void setClientDetails(String str, String str2);

    void setJoining(boolean z);

    void setLastJoinedRoom(Room room);

    void setMySelf(User user);

    void setReconnectionSeconds(int i);
}
