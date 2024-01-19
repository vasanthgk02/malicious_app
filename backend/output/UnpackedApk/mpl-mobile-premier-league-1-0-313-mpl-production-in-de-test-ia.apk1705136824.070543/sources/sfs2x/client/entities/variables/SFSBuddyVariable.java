package sfs2x.client.entities.variables;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import org.apache.fontbox.cmap.CMapParser;

public class SFSBuddyVariable extends BaseVariable implements BuddyVariable {
    public static final String OFFLINE_PREFIX = "$";

    public SFSBuddyVariable(String str, Object obj) {
        this(str, obj, -1);
    }

    public static BuddyVariable fromSFSArray(ISFSArray iSFSArray) {
        return new SFSBuddyVariable(iSFSArray.getUtfString(0), iSFSArray.getElementAt(2), iSFSArray.getByte(1).byteValue());
    }

    public boolean isOffline() {
        return this.name.startsWith(OFFLINE_PREFIX);
    }

    public String toString() {
        return "[BuddyVar: " + this.name + ", type: " + this.type + ", value: " + this.val + CMapParser.MARK_END_OF_ARRAY;
    }

    public SFSBuddyVariable(String str, Object obj, int i) {
        super(str, obj, i);
    }
}
