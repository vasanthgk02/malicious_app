package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.SFSArray;
import java.util.ArrayList;
import java.util.List;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.variables.UserVariable;
import sfs2x.client.exceptions.SFSValidationException;

public class SetUserVariablesRequest extends BaseRequest {
    public static final String KEY_USER = "u";
    public static final String KEY_VAR_LIST = "vl";
    public List<UserVariable> userVariables;

    public SetUserVariablesRequest(List<UserVariable> list) {
        super(12);
        this.userVariables = list;
    }

    public void execute(ISmartFox iSmartFox) {
        SFSArray newInstance = SFSArray.newInstance();
        for (UserVariable sFSArray : this.userVariables) {
            newInstance.addSFSArray(sFSArray.toSFSArray());
        }
        this.sfso.putSFSArray("vl", newInstance);
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        List<UserVariable> list = this.userVariables;
        if (list == null || list.isEmpty()) {
            arrayList.add("No variables were specified");
        }
        if (!arrayList.isEmpty()) {
            throw new SFSValidationException("SetUserVariables request error", arrayList);
        }
    }
}
