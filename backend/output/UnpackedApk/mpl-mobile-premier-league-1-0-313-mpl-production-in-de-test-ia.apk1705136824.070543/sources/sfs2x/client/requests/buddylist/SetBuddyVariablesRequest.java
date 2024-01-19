package sfs2x.client.requests.buddylist;

import com.smartfoxserver.v2.entities.data.SFSArray;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.variables.BuddyVariable;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.requests.BaseRequest;

public class SetBuddyVariablesRequest extends BaseRequest {
    public static final String KEY_BUDDY_NAME = "bn";
    public static final String KEY_BUDDY_VARS = "bv";
    public List<BuddyVariable> buddyVariables;

    public SetBuddyVariablesRequest(List<BuddyVariable> list) {
        super(BaseRequest.SetBuddyVariables);
        this.buddyVariables = list;
    }

    public void execute(ISmartFox iSmartFox) {
        SFSArray newInstance = SFSArray.newInstance();
        for (BuddyVariable sFSArray : this.buddyVariables) {
            newInstance.addSFSArray(sFSArray.toSFSArray());
        }
        this.sfso.putSFSArray(KEY_BUDDY_VARS, newInstance);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (!iSmartFox.getBuddyManager().isInited()) {
            arrayList.add("BuddyList is not inited. Please send an InitBuddyRequest first.");
        }
        if (!iSmartFox.getBuddyManager().getMyOnlineState()) {
            arrayList.add("Can't set buddy variables while off-line");
        }
        List<BuddyVariable> list = this.buddyVariables;
        if (list == null || list.size() == 0) {
            arrayList.add("No variables were specified");
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("SetBuddyVariables request error", arrayList);
        }
    }
}
