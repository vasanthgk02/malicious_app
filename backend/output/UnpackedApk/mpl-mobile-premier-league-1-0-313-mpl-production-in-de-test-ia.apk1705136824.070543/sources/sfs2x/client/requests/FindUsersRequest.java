package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.entities.match.MatchExpression;
import sfs2x.client.exceptions.SFSValidationException;

public class FindUsersRequest extends BaseRequest {
    public static final String KEY_EXPRESSION = "e";
    public static final String KEY_FILTERED_USERS = "fu";
    public static final String KEY_GROUP = "g";
    public static final String KEY_LIMIT = "l";
    public static final String KEY_ROOM = "r";
    public short limit;
    public MatchExpression matchExpr;
    public Object target;

    public FindUsersRequest(MatchExpression matchExpression, Object obj, short s) {
        super(28);
        this.limit = s;
        this.target = obj;
        this.matchExpr = matchExpression;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putSFSArray("e", this.matchExpr.toSFSArray());
        Object obj = this.target;
        if (obj != null) {
            if (obj instanceof Room) {
                this.sfso.putInt("r", ((Room) obj).getId());
            } else if (obj instanceof String) {
                this.sfso.putUtfString("g", (String) obj);
            }
        }
        short s = this.limit;
        if (s > 0) {
            this.sfso.putShort("l", s);
        }
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (this.matchExpr == null) {
            arrayList.add("Missing Match Expression");
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("FindUsers request error", arrayList);
        }
    }

    public FindUsersRequest(MatchExpression matchExpression) {
        this(matchExpression, null, 0);
    }

    public FindUsersRequest(MatchExpression matchExpression, Object obj) {
        this(matchExpression, obj, 0);
    }
}
