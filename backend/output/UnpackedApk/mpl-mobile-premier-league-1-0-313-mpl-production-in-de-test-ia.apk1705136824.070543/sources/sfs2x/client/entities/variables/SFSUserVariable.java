package sfs2x.client.entities.variables;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import org.apache.fontbox.cmap.CMapParser;

public class SFSUserVariable extends BaseVariable implements UserVariable {
    public boolean _isPrivate;

    public SFSUserVariable(String str, Object obj) {
        super(str, obj, -1);
    }

    public static UserVariable fromSFSArray(ISFSArray iSFSArray) {
        SFSUserVariable sFSUserVariable = new SFSUserVariable(iSFSArray.getUtfString(0), iSFSArray.getElementAt(2), iSFSArray.getByte(1).byteValue());
        if (iSFSArray.size() > 3) {
            sFSUserVariable.setPrivate(iSFSArray.getBool(3).booleanValue());
        }
        return sFSUserVariable;
    }

    public static SFSUserVariable newPrivateVariable(String str, Object obj) {
        SFSUserVariable sFSUserVariable = new SFSUserVariable(str, obj);
        sFSUserVariable.setPrivate(true);
        return sFSUserVariable;
    }

    public boolean isPrivate() {
        return this._isPrivate;
    }

    public void setPrivate(boolean z) {
        this._isPrivate = z;
    }

    public ISFSArray toSFSArray() {
        ISFSArray sFSArray = super.toSFSArray();
        sFSArray.addBool(this._isPrivate);
        return sFSArray;
    }

    public String toString() {
        return "[UVar: " + this.name + ", type: " + this.type + ", value: " + this.val + CMapParser.MARK_END_OF_ARRAY;
    }

    public SFSUserVariable(String str, Object obj, int i) {
        super(str, obj, i);
    }
}
