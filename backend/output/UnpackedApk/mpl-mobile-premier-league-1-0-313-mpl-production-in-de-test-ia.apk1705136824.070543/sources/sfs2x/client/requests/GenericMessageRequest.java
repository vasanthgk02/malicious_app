package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.exceptions.SFSException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.User;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.util.SFSStringUtils;

public class GenericMessageRequest extends BaseRequest {
    public static final String KEY_MESSAGE = "m";
    public static final String KEY_MESSAGE_TYPE = "t";
    public static final String KEY_RECIPIENT = "rc";
    public static final String KEY_RECIPIENT_MODE = "rm";
    public static final String KEY_ROOM_ID = "r";
    public static final String KEY_SENDER_DATA = "sd";
    public static final String KEY_USER_ID = "u";
    public static final String KEY_XTRA_PARAMS = "p";
    public Logger log = LoggerFactory.getLogger(getClass());
    public String message;
    public ISFSObject params;
    public Object recipient;
    public Room room;
    public int sendMode = -1;
    public int type = -1;
    public User user;

    public GenericMessageRequest() {
        super(7);
    }

    private void executeBuddyMessage(ISmartFox iSmartFox) {
        this.sfso.putInt(KEY_RECIPIENT, ((Integer) this.recipient).intValue());
        this.sfso.putUtfString("m", this.message);
        ISFSObject iSFSObject = this.params;
        if (iSFSObject != null) {
            this.sfso.putSFSObject("p", iSFSObject);
        }
    }

    private void executeObjectMessage(ISmartFox iSmartFox) {
        if (this.room == null) {
            this.room = iSmartFox.getLastJoinedRoom();
        }
        HashSet hashSet = new HashSet();
        Object obj = this.recipient;
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            if (collection.size() <= this.room.getCapacity()) {
                for (Object next : collection) {
                    if (next instanceof User) {
                        hashSet.add(Integer.valueOf(((User) next).getId()));
                    } else {
                        Logger logger = this.log;
                        logger.warn("Bad recipient in ObjectMessage recipient list: " + next.getClass().getName() + ", expected type: User");
                    }
                }
            } else {
                throw new IllegalArgumentException("The number of recipients is bigger than the target Room capacity: " + collection.size());
            }
        }
        this.sfso.putInt("r", this.room.getId());
        this.sfso.putSFSObject("p", this.params);
        if (!hashSet.isEmpty()) {
            this.sfso.putIntArray(KEY_RECIPIENT, hashSet);
        }
    }

    private void executePrivateMessage(ISmartFox iSmartFox) {
        this.sfso.putInt(KEY_RECIPIENT, ((Integer) this.recipient).intValue());
        this.sfso.putUtfString("m", this.message);
        ISFSObject iSFSObject = this.params;
        if (iSFSObject != null) {
            this.sfso.putSFSObject("p", iSFSObject);
        }
    }

    private void executePublicMessage(ISmartFox iSmartFox) throws SFSException {
        if (this.room == null) {
            this.room = iSmartFox.getLastJoinedRoom();
        }
        Room room2 = this.room;
        if (room2 != null) {
            this.sfso.putInt("r", room2.getId());
            this.sfso.putInt("u", iSmartFox.getMySelf().getId());
            this.sfso.putUtfString("m", this.message);
            ISFSObject iSFSObject = this.params;
            if (iSFSObject != null) {
                this.sfso.putSFSObject("p", iSFSObject);
                return;
            }
            return;
        }
        throw new SFSException((String) "User should be joined in a room in order to send a public message");
    }

    private void executeSuperUserMessage(ISmartFox iSmartFox) {
        this.sfso.putUtfString("m", this.message);
        ISFSObject iSFSObject = this.params;
        if (iSFSObject != null) {
            this.sfso.putSFSObject("p", iSFSObject);
        }
        this.sfso.putInt(KEY_RECIPIENT_MODE, this.sendMode);
        int i = this.sendMode;
        if (i == 0) {
            this.sfso.putInt(KEY_RECIPIENT, ((User) this.recipient).getId());
        } else if (i == 1) {
            this.sfso.putInt(KEY_RECIPIENT, ((Room) this.recipient).getId());
        } else if (i == 2) {
            this.sfso.putUtfString(KEY_RECIPIENT, (String) this.recipient);
        }
    }

    private void validateBuddyMessage(ISmartFox iSmartFox, List<String> list) {
        if (!iSmartFox.getBuddyManager().isInited()) {
            list.add("BuddyList is not inited. Please send an InitBuddyRequest first.");
        }
        if (!iSmartFox.getBuddyManager().getMyOnlineState()) {
            list.add("Can't send messages while off-line");
        }
        if (SFSStringUtils.isEmptyOrNull(this.message)) {
            list.add("Buddy message is empty!");
        }
        if (((Integer) this.recipient).intValue() < 0) {
            list.add("Recipient is not online or not in your buddy list");
        }
    }

    private void validateObjectMessage(ISmartFox iSmartFox, List<String> list) {
        if (this.params == null) {
            list.add("Object message is null!");
        }
    }

    private void validatePrivateMessage(ISmartFox iSmartFox, List<String> list) {
        if (SFSStringUtils.isEmptyOrNull(this.message)) {
            list.add("Private message is empty!");
        }
        if (((Integer) this.recipient).intValue() < 0) {
            list.add("Invalid recipient id: " + this.recipient);
        }
    }

    private void validatePublicMessage(ISmartFox iSmartFox, List<String> list) {
        if (SFSStringUtils.isEmptyOrNull(this.message)) {
            list.add("Public message is empty!");
        }
        if (this.room != null && !iSmartFox.getJoinedRooms().contains(this.room)) {
            list.add("You are not joined in the target Room: " + this.room);
        }
    }

    private void validateSuperUserMessage(ISmartFox iSmartFox, List<String> list) {
        if (SFSStringUtils.isEmptyOrNull(this.message)) {
            list.add("Moderator message is empty!");
        }
        int i = this.sendMode;
        if (i != 0) {
            if (i != 1) {
                if (i == 2 && !(this.recipient instanceof String)) {
                    list.add("TO_GROUP expects a String object (the groupId) as recipient");
                }
            } else if (!(this.recipient instanceof Room)) {
                list.add("TO_ROOM expects a Room object as recipient");
            }
        } else if (!(this.recipient instanceof User)) {
            list.add("TO_USER expects a User object as recipient");
        }
    }

    public void execute(ISmartFox iSmartFox) throws SFSException {
        this.sfso.putByte("t", (byte) this.type);
        int i = this.type;
        if (i == 0) {
            executePublicMessage(iSmartFox);
        } else if (i == 1) {
            executePrivateMessage(iSmartFox);
        } else if (i == 4) {
            executeObjectMessage(iSmartFox);
        } else if (i != 5) {
            executeSuperUserMessage(iSmartFox);
        } else {
            executeBuddyMessage(iSmartFox);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        if (this.type >= 0) {
            ArrayList arrayList = new ArrayList();
            int i = this.type;
            if (i == 0) {
                validatePublicMessage(iSmartFox, arrayList);
            } else if (i == 1) {
                validatePrivateMessage(iSmartFox, arrayList);
            } else if (i == 4) {
                validateObjectMessage(iSmartFox, arrayList);
            } else if (i != 5) {
                validateSuperUserMessage(iSmartFox, arrayList);
            } else {
                validateBuddyMessage(iSmartFox, arrayList);
            }
            if (!arrayList.isEmpty()) {
                throw new SFSValidationException("Request error - ", arrayList);
            }
            return;
        }
        throw new SFSValidationException("PublicMessage request error", Collections.singletonList("Unsupported message type: " + this.type));
    }
}
