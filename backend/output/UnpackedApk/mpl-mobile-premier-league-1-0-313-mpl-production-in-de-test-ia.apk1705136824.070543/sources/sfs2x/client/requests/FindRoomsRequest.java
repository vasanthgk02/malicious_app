package sfs2x.client.requests;

import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.match.MatchExpression;
import sfs2x.client.exceptions.SFSValidationException;

public class FindRoomsRequest extends BaseRequest {
    public static final String KEY_EXPRESSION = "e";
    public static final String KEY_FILTERED_ROOMS = "fr";
    public static final String KEY_GROUP = "g";
    public static final String KEY_LIMIT = "l";
    public String groupId;
    public short limit;
    public MatchExpression matchExpr;

    public FindRoomsRequest(MatchExpression matchExpression, String str, short s) {
        super(27);
        this.matchExpr = matchExpression;
        this.groupId = str;
        this.limit = s;
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putSFSArray("e", this.matchExpr.toSFSArray());
        String str = this.groupId;
        if (str != null) {
            this.sfso.putUtfString("g", str);
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
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("FindRooms request error", arrayList);
        }
    }

    public FindRoomsRequest(MatchExpression matchExpression, String str) {
        this(matchExpression, str, 0);
    }

    public FindRoomsRequest(MatchExpression matchExpression) {
        this(matchExpression, null, 0);
    }
}
