package sfs2x.client.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;

public class SFSErrorCodes {
    public static HashMap<Short, String> errorMap;

    static {
        HashMap<Short, String> hashMap = new HashMap<>();
        errorMap = hashMap;
        hashMap.put(Short.valueOf(0), "Client API version is obsolete: %s; required version: %s");
        errorMap.put(Short.valueOf(1), "Requested Zone %s does not exist");
        errorMap.put(Short.valueOf(2), "User name %s is not recognized");
        errorMap.put(Short.valueOf(3), "Wrong password for user %s");
        errorMap.put(Short.valueOf(4), "User %s is banned");
        errorMap.put(Short.valueOf(5), "Zone %s is full");
        errorMap.put(Short.valueOf(6), "User %s is already logged in Zone %s");
        errorMap.put(Short.valueOf(7), "The server is full");
        errorMap.put(Short.valueOf(8), "Zone %s is currently inactive");
        errorMap.put(Short.valueOf(9), "User name %s contains bad words; filtered: %s");
        errorMap.put(Short.valueOf(10), "Guest users not allowed in Zone %s");
        errorMap.put(Short.valueOf(11), "IP address %s is banned");
        errorMap.put(Short.valueOf(12), "A Room with the same name already exists: %s");
        errorMap.put(Short.valueOf(13), "Requested Group is not available - Room: %s; Group: %s");
        errorMap.put(Short.valueOf(14), "Bad Room name length -  Min: %s; max: %s; passed name length: %s");
        errorMap.put(Short.valueOf(15), "Room name contains bad words: %s");
        errorMap.put(Short.valueOf(16), "Zone is full; can't add Rooms anymore");
        errorMap.put(Short.valueOf(17), "You have exceeded the number of Rooms that you can create per session: %s");
        errorMap.put(Short.valueOf(18), "Room creation failed, wrong parameter: %s");
        errorMap.put(Short.valueOf(19), "User %s already joined in Room");
        errorMap.put(Short.valueOf(20), "Room %s is full");
        errorMap.put(Short.valueOf(21), "Wrong password for Room %s");
        errorMap.put(Short.valueOf(22), "Requested Room does not exist");
        errorMap.put(Short.valueOf(23), "Room %s is locked");
        errorMap.put(Short.valueOf(24), "Group %s is already subscribed");
        errorMap.put(Short.valueOf(25), "Group %s does not exist");
        errorMap.put(Short.valueOf(26), "Group %s is not subscribed");
        errorMap.put(Short.valueOf(27), "Group %s does not exist");
        errorMap.put(Short.valueOf(28), "%s");
        errorMap.put(Short.valueOf(29), "Room permission error; Room %s cannot be renamed");
        errorMap.put(Short.valueOf(30), "Room permission error; Room %s cannot change password statee");
        errorMap.put(Short.valueOf(31), "Room permission error; Room %s cannot change capacity");
        errorMap.put(Short.valueOf(32), "Switch user error; no player slots available in Room %s");
        errorMap.put(Short.valueOf(33), "Switch user error; no spectator slots available in Room %s");
        errorMap.put(Short.valueOf(34), "Switch user error; Room %s is not a Game Room");
        errorMap.put(Short.valueOf(35), "Switch user error; you are not joined in Room %s");
        errorMap.put(Short.valueOf(36), "Buddy Manager initialization error, could not load buddy list: %s");
        errorMap.put(Short.valueOf(37), "Buddy Manager error, your buddy list is full; size is %s");
        errorMap.put(Short.valueOf(38), "Buddy Manager error, was not able to block buddy %s because offline");
        errorMap.put(Short.valueOf(39), "Buddy Manager error, you are attempting to set too many Buddy Variables; limit is %s");
        errorMap.put(Short.valueOf(40), "Game %s access denied, user does not match access criteria");
        errorMap.put(Short.valueOf(41), "QuickJoinGame action failed: no matching Rooms were found");
        errorMap.put(Short.valueOf(42), "Your previous invitation reply was invalid or arrived too late");
    }

    public static String getErrorMessage(short s, Object[] objArr) {
        try {
            return String.format(errorMap.get(Short.valueOf(s)), objArr);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error in converting error code to text for code: ");
            sb.append(s);
            sb.append(". Cause: ");
            return GeneratedOutlineSupport.outline39(e2, sb);
        }
    }

    public static void setErrorMessage(short s, String str) {
        errorMap.put(Short.valueOf(s), str);
    }
}
