package sfs2x.client.requests.game;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sfs2x.client.entities.match.MatchExpression;
import sfs2x.client.requests.RoomSettings;

public class SFSGameSettings extends RoomSettings {
    public int invitationExpiryTime = 15;
    public ISFSObject invitationParams;
    public List<?> invitedPlayers = new ArrayList();
    public boolean isPublic = true;
    public boolean leaveJoinedLastRoom = true;
    public int minPlayersToStartGame = 2;
    public boolean notifyGameStarted;
    public MatchExpression playerMatchExpression;
    public List<String> searchableRooms = new ArrayList();
    public MatchExpression spectatorMatchExpression;

    public SFSGameSettings(String str) {
        super(str);
    }

    public int getInvitationExpiryTime() {
        return this.invitationExpiryTime;
    }

    public ISFSObject getInvitationParams() {
        return this.invitationParams;
    }

    public List<?> getInvitedPlayers() {
        return Collections.unmodifiableList(this.invitedPlayers);
    }

    public boolean getLeaveLastJoinedRoom() {
        return this.leaveJoinedLastRoom;
    }

    public int getMinPlayersToStartGame() {
        return this.minPlayersToStartGame;
    }

    public boolean getNotifyGameStarted() {
        return this.notifyGameStarted;
    }

    public MatchExpression getPlayerMatchExpression() {
        return this.playerMatchExpression;
    }

    public List<String> getSearchableRooms() {
        return Collections.unmodifiableList(this.searchableRooms);
    }

    public MatchExpression getSpectatorMatchExpression() {
        return this.spectatorMatchExpression;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public void setInvitationExpiryTime(int i) {
        this.invitationExpiryTime = i;
    }

    public void setInvitationParams(ISFSObject iSFSObject) {
        this.invitationParams = iSFSObject;
    }

    public void setInvitedPlayers(List<?> list) {
        this.invitedPlayers = new ArrayList(list);
    }

    public void setLeaveLastJoinedRoom(boolean z) {
        this.leaveJoinedLastRoom = z;
    }

    public void setMinPlayersToStartGame(int i) {
        this.minPlayersToStartGame = i;
    }

    public void setNotifyGameStarted(boolean z) {
        this.notifyGameStarted = z;
    }

    public void setPlayerMatchExpression(MatchExpression matchExpression) {
        this.playerMatchExpression = matchExpression;
    }

    public void setPublic(boolean z) {
        this.isPublic = z;
    }

    public void setSearchableRooms(List<String> list) {
        this.searchableRooms = new ArrayList(list);
    }

    public void setSpectatorMatchExpression(MatchExpression matchExpression) {
        this.spectatorMatchExpression = matchExpression;
    }
}
