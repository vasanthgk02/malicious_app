package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.SFSArray;
import java.io.PrintStream;
import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.variables.RoomVariable;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.mmo.MMORoomSettings;

public class CreateRoomRequest extends BaseRequest {
    public static final String KEY_ALLOW_JOIN_INVITATION_BY_OWNER = "aji";
    public static final String KEY_AUTOJOIN = "aj";
    public static final String KEY_EVENTS = "ev";
    public static final String KEY_EXTCLASS = "xc";
    public static final String KEY_EXTID = "xn";
    public static final String KEY_EXTPROP = "xp";
    public static final String KEY_GROUP_ID = "g";
    public static final String KEY_ISGAME = "ig";
    public static final String KEY_MAXSPECTATORS = "ms";
    public static final String KEY_MAXUSERS = "mu";
    public static final String KEY_MAXVARS = "mv";
    public static final String KEY_MMO_DEFAULT_AOI = "maoi";
    public static final String KEY_MMO_MAP_HIGH_LIMIT = "mlhm";
    public static final String KEY_MMO_MAP_LOW_LIMIT = "mllm";
    public static final String KEY_MMO_PROXIMITY_UPDATE_MILLIS = "mpum";
    public static final String KEY_MMO_SEND_ENTRY_POINT = "msep";
    public static final String KEY_MMO_USER_MAX_LIMBO_SECONDS = "muls";
    public static final String KEY_NAME = "n";
    public static final String KEY_PASSWORD = "p";
    public static final String KEY_PERMISSIONS = "pm";
    public static final String KEY_ROOM = "r";
    public static final String KEY_ROOMVARS = "rv";
    public static final String KEY_ROOM_TO_LEAVE = "rl";
    public boolean autoJoin;
    public Room roomToLeave;
    public RoomSettings settings;

    public CreateRoomRequest(RoomSettings roomSettings, boolean z, Room room) {
        super(6);
        this.settings = roomSettings;
        this.autoJoin = z;
        this.roomToLeave = room;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putUtfString("n", this.settings.getName());
        this.sfso.putUtfString("g", this.settings.getGroupId());
        this.sfso.putUtfString("p", this.settings.getPassword());
        this.sfso.putBool(KEY_ISGAME, this.settings.isGame());
        this.sfso.putShort(KEY_MAXUSERS, (short) this.settings.getMaxUsers());
        this.sfso.putShort("ms", (short) this.settings.getMaxSpectators());
        this.sfso.putShort("mv", (short) this.settings.getMaxVariables());
        this.sfso.putBool(KEY_ALLOW_JOIN_INVITATION_BY_OWNER, this.settings.allowOwnerOnlyInvitation());
        if (this.settings.getVariables() != null && this.settings.getVariables().size() > 0) {
            SFSArray newInstance = SFSArray.newInstance();
            for (RoomVariable sFSArray : this.settings.getVariables()) {
                newInstance.addSFSArray(sFSArray.toSFSArray());
            }
            this.sfso.putSFSArray(KEY_ROOMVARS, newInstance);
        }
        if (this.settings.getPermissions() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Boolean.valueOf(this.settings.getPermissions().getAllowNameChange()));
            arrayList.add(Boolean.valueOf(this.settings.getPermissions().getAllowPasswordStateChange()));
            arrayList.add(Boolean.valueOf(this.settings.getPermissions().getAllowPublicMessages()));
            arrayList.add(Boolean.valueOf(this.settings.getPermissions().getAllowResizing()));
            this.sfso.putBoolArray(KEY_PERMISSIONS, arrayList);
        }
        if (this.settings.getEvents() != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Boolean.valueOf(this.settings.getEvents().getAllowUserEnter()));
            arrayList2.add(Boolean.valueOf(this.settings.getEvents().getAllowUserExit()));
            arrayList2.add(Boolean.valueOf(this.settings.getEvents().getAllowUserCountChange()));
            arrayList2.add(Boolean.valueOf(this.settings.getEvents().getAllowUserVariablesUpdate()));
            this.sfso.putBoolArray(KEY_EVENTS, arrayList2);
        }
        if (this.settings.getExtension() != null) {
            this.sfso.putUtfString(KEY_EXTID, this.settings.getExtension().getId());
            this.sfso.putUtfString(KEY_EXTCLASS, this.settings.getExtension().getClassName());
            if (this.settings.getExtension().getPropertiesFile() != null && this.settings.getExtension().getPropertiesFile().length() > 0) {
                this.sfso.putUtfString(KEY_EXTPROP, this.settings.getExtension().getPropertiesFile());
            }
        }
        RoomSettings roomSettings = this.settings;
        if (roomSettings instanceof MMORoomSettings) {
            MMORoomSettings mMORoomSettings = (MMORoomSettings) roomSettings;
            if (mMORoomSettings.getDefaultAOI().isFloat()) {
                this.sfso.putFloatArray(KEY_MMO_DEFAULT_AOI, mMORoomSettings.getDefaultAOI().toFloatArray());
                if (mMORoomSettings.getMapLimits() != null) {
                    this.sfso.putFloatArray(KEY_MMO_MAP_LOW_LIMIT, mMORoomSettings.getMapLimits().getLowerLimit().toFloatArray());
                    this.sfso.putFloatArray(KEY_MMO_MAP_HIGH_LIMIT, mMORoomSettings.getMapLimits().getHigherLimit().toFloatArray());
                }
            } else {
                this.sfso.putIntArray(KEY_MMO_DEFAULT_AOI, mMORoomSettings.getDefaultAOI().toIntArray());
                if (mMORoomSettings.getMapLimits() != null) {
                    this.sfso.putIntArray(KEY_MMO_MAP_LOW_LIMIT, mMORoomSettings.getMapLimits().getLowerLimit().toIntArray());
                    this.sfso.putIntArray(KEY_MMO_MAP_HIGH_LIMIT, mMORoomSettings.getMapLimits().getHigherLimit().toIntArray());
                }
            }
            this.sfso.putShort(KEY_MMO_USER_MAX_LIMBO_SECONDS, (short) mMORoomSettings.getUserMaxLimboSeconds());
            this.sfso.putShort(KEY_MMO_PROXIMITY_UPDATE_MILLIS, (short) mMORoomSettings.getProximityListUpdateMillis());
            this.sfso.putBool(KEY_MMO_SEND_ENTRY_POINT, mMORoomSettings.isSendAOIEntryPoint());
        }
        this.sfso.putBool(KEY_AUTOJOIN, this.autoJoin);
        Room room = this.roomToLeave;
        if (room != null) {
            this.sfso.putInt("rl", room.getId());
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.settings.getName() == null || this.settings.getName().length() == 0) {
            arrayList.add("Missing room name");
        }
        if (this.settings.getMaxUsers() <= 0) {
            arrayList.add("maxUsers must be > 0");
        }
        if (this.settings.getExtension() != null) {
            if (this.settings.getExtension().getClassName() == null || this.settings.getExtension().getClassName().length() == 0) {
                arrayList.add("Missing Extension class name");
            }
            if (this.settings.getExtension().getId() == null || this.settings.getExtension().getId().length() == 0) {
                arrayList.add("Missing Extension id");
            }
        }
        RoomSettings roomSettings = this.settings;
        if (roomSettings instanceof MMORoomSettings) {
            MMORoomSettings mMORoomSettings = (MMORoomSettings) roomSettings;
            if (mMORoomSettings.getDefaultAOI() == null) {
                arrayList.add("Missing default AOI (area of interest)");
            }
            if (mMORoomSettings.getMapLimits() != null && (mMORoomSettings.getMapLimits().getLowerLimit() == null || mMORoomSettings.getMapLimits().getHigherLimit() == null)) {
                arrayList.add("Map limits must be both defined");
            }
            PrintStream printStream = System.out;
            Object[] objArr = new Object[3];
            boolean z = true;
            objArr[0] = Boolean.valueOf(mMORoomSettings.getMapLimits() != null);
            objArr[1] = Boolean.valueOf(mMORoomSettings.getMapLimits().getLowerLimit() == null);
            if (mMORoomSettings.getMapLimits().getHigherLimit() != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            printStream.println(String.format("---> %s AND (%s OR %s)", objArr));
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("CreateRoom request error", arrayList);
        }
    }

    public CreateRoomRequest(RoomSettings roomSettings, boolean z) {
        this(roomSettings, z, null);
    }

    public CreateRoomRequest(RoomSettings roomSettings) {
        this(roomSettings, false, null);
    }
}
