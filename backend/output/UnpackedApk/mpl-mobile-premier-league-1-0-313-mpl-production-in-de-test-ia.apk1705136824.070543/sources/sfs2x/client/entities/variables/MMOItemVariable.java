package sfs2x.client.entities.variables;

import com.smartfoxserver.v2.entities.data.ISFSArray;

public class MMOItemVariable extends BaseVariable implements IMMOItemVariable {
    public MMOItemVariable(String str, Object obj) {
        super(str, obj);
    }

    public static IMMOItemVariable fromSFSArray(ISFSArray iSFSArray) {
        return new MMOItemVariable(iSFSArray.getUtfString(0), iSFSArray.getElementAt(2), iSFSArray.getByte(1).byteValue());
    }

    public MMOItemVariable(String str, Object obj, int i) {
        super(str, obj, i);
    }
}
