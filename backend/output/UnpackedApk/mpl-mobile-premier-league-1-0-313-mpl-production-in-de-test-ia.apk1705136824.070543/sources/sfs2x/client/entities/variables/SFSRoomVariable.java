package sfs2x.client.entities.variables;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSArray;
import org.apache.fontbox.cmap.CMapParser;

public class SFSRoomVariable extends BaseVariable implements RoomVariable {
    public boolean isPersistent;
    public boolean isPrivate;

    public SFSRoomVariable(String str, Object obj) {
        super(str, obj, -1);
    }

    public static RoomVariable fromSFSArray(ISFSArray iSFSArray) {
        SFSRoomVariable sFSRoomVariable = new SFSRoomVariable(iSFSArray.getUtfString(0), iSFSArray.getElementAt(2), iSFSArray.getByte(1).byteValue());
        sFSRoomVariable.setPrivate(iSFSArray.getBool(3).booleanValue());
        sFSRoomVariable.setPersistent(iSFSArray.getBool(4).booleanValue());
        return sFSRoomVariable;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public void setPersistent(boolean z) {
        this.isPersistent = z;
    }

    public void setPrivate(boolean z) {
        this.isPrivate = z;
    }

    public ISFSArray toSFSArray() {
        ISFSArray sFSArray = super.toSFSArray();
        sFSArray.addBool(this.isPrivate);
        sFSArray.addBool(this.isPersistent);
        return sFSArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[RVar: ");
        sb.append(this.name);
        sb.append(", type: ");
        sb.append(this.type);
        sb.append(", value: ");
        sb.append(this.val);
        sb.append(", isPriv: ");
        return GeneratedOutlineSupport.outline66(sb, this.isPrivate, CMapParser.MARK_END_OF_ARRAY);
    }

    public SFSRoomVariable(String str, Object obj, int i) {
        super(str, obj, i);
    }
}
