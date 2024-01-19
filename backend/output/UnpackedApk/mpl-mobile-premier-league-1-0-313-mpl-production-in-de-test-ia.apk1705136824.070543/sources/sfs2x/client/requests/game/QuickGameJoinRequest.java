package sfs2x.client.requests.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.match.MatchExpression;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class QuickGameJoinRequest extends BaseRequest {
    public static final String KEY_GROUP_LIST = "gl";
    public static final String KEY_MATCH_EXPRESSION = "me";
    public static final String KEY_ROOM_LIST = "rl";
    public static final String KEY_ROOM_TO_LEAVE = "tl";
    public static final int MAX_ROOMS = 32;
    public MatchExpression matchExpression;
    public Room roomToLeave;
    public List<?> whereToSearch;

    public QuickGameJoinRequest(MatchExpression matchExpression2, List<?> list, Room room) {
        super(BaseRequest.QuickJoinGame);
        this.matchExpression = matchExpression2;
        this.roomToLeave = room;
        this.whereToSearch = list;
    }

    public void execute(ISmartFox iSmartFox) {
        if (this.whereToSearch.get(0) instanceof Room) {
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = this.whereToSearch.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((Room) it.next()).getId()));
            }
            this.sfso.putIntArray("rl", arrayList);
        } else {
            this.sfso.putUtfStringArray(KEY_GROUP_LIST, this.whereToSearch);
        }
        Room room = this.roomToLeave;
        if (room != null) {
            this.sfso.putInt(KEY_ROOM_TO_LEAVE, room.getId());
        }
        MatchExpression matchExpression2 = this.matchExpression;
        if (matchExpression2 != null) {
            this.sfso.putSFSArray(KEY_MATCH_EXPRESSION, matchExpression2.toSFSArray());
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        List<?> list = this.whereToSearch;
        if (list == null || list.size() < 1) {
            arrayList.add("Missing whereToSearch parameter");
        } else if (this.whereToSearch.size() > 32) {
            arrayList.add("Too many Rooms specified in the whereToSearch parameter. Client limit is: 32");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("QuickJoinGame request error", arrayList);
        }
    }

    public QuickGameJoinRequest(MatchExpression matchExpression2, List<?> list) {
        this(matchExpression2, list, null);
    }
}
