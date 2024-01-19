package sfs2x.client.requests.game;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Buddy;
import sfs2x.client.entities.User;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;
import sfs2x.client.requests.CreateRoomRequest;

public class CreateSFSGameRequest extends BaseRequest {
    public static final String KEY_INVITATION_EXPIRY = "gie";
    public static final String KEY_INVITATION_PARAMS = "ip";
    public static final String KEY_INVITED_PLAYERS = "ginp";
    public static final String KEY_IS_PUBLIC = "gip";
    public static final String KEY_LEAVE_ROOM = "glr";
    public static final String KEY_MIN_PLAYERS = "gmp";
    public static final String KEY_NOTIFY_GAME_STARTED = "gns";
    public static final String KEY_PLAYER_MATCH_EXP = "gpme";
    public static final String KEY_SEARCHABLE_ROOMS = "gsr";
    public static final String KEY_SPECTATOR_MATCH_EXP = "gsme";
    public CreateRoomRequest createRoomRequest;
    public SFSGameSettings settings;

    public CreateSFSGameRequest(SFSGameSettings sFSGameSettings) {
        super(BaseRequest.CreateSFSGame);
        this.settings = sFSGameSettings;
        this.createRoomRequest = new CreateRoomRequest(sFSGameSettings, false, null);
    }

    public void execute(ISmartFox iSmartFox) {
        this.createRoomRequest.execute(iSmartFox);
        ISFSObject content = this.createRoomRequest.getMessage().getContent();
        this.sfso = content;
        content.putBool(KEY_IS_PUBLIC, this.settings.isPublic());
        this.sfso.putShort(KEY_MIN_PLAYERS, (short) this.settings.getMinPlayersToStartGame());
        this.sfso.putShort(KEY_INVITATION_EXPIRY, (short) this.settings.getInvitationExpiryTime());
        this.sfso.putBool(KEY_LEAVE_ROOM, this.settings.getLeaveLastJoinedRoom());
        this.sfso.putBool(KEY_NOTIFY_GAME_STARTED, this.settings.getNotifyGameStarted());
        if (this.settings.getPlayerMatchExpression() != null) {
            this.sfso.putSFSArray(KEY_PLAYER_MATCH_EXP, this.settings.getPlayerMatchExpression().toSFSArray());
        }
        if (this.settings.getSpectatorMatchExpression() != null) {
            this.sfso.putSFSArray(KEY_SPECTATOR_MATCH_EXP, this.settings.getSpectatorMatchExpression().toSFSArray());
        }
        List<?> invitedPlayers = this.settings.getInvitedPlayers();
        if (invitedPlayers != null) {
            ArrayList arrayList = new ArrayList(invitedPlayers.size());
            for (Object next : invitedPlayers) {
                if (next instanceof User) {
                    arrayList.add(Integer.valueOf(((User) next).getId()));
                } else if (next instanceof Buddy) {
                    arrayList.add(Integer.valueOf(((Buddy) next).getId()));
                }
            }
            this.sfso.putIntArray(KEY_INVITED_PLAYERS, arrayList);
        }
        List<String> searchableRooms = this.settings.getSearchableRooms();
        if (searchableRooms != null) {
            this.sfso.putUtfStringArray(KEY_SEARCHABLE_ROOMS, searchableRooms);
        }
        if (this.settings.getInvitationParams() != null) {
            this.sfso.putSFSObject(KEY_INVITATION_PARAMS, this.settings.getInvitationParams());
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        try {
            this.createRoomRequest.validate(iSmartFox);
        } catch (SFSValidationException e2) {
            arrayList.addAll(e2.getErrors());
        }
        if (this.settings.getMinPlayersToStartGame() > this.settings.getMaxUsers()) {
            arrayList.add("minPlayersToStartGame cannot be greater than maxUsers");
        }
        if (this.settings.getInvitationExpiryTime() < 5 || this.settings.getInvitationExpiryTime() > 300) {
            arrayList.add("Expiry time value is out of range (5-300)");
        }
        if (this.settings.getInvitedPlayers() != null && this.settings.getInvitedPlayers().size() > 8) {
            arrayList.add("Cannot invite more than 8 players from client side");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("CreateSFSGameRoom request error", arrayList);
        }
    }
}
