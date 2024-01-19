package sfs2x.client.requests;

import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import java.util.ArrayList;
import sfs2x.client.ISmartFox;
import sfs2x.client.entities.Room;
import sfs2x.client.exceptions.SFSValidationException;
import sfs2x.client.util.SFSStringUtils;

public class ExtensionRequest extends BaseRequest {
    public static final String KEY_CMD = "c";
    public static final String KEY_PARAMS = "p";
    public static final String KEY_ROOM = "r";
    public String extCmd;
    public ISFSObject params;
    public Room room;
    public Boolean useUDP;

    public ExtensionRequest(String str, ISFSObject iSFSObject, Room room2, boolean z) {
        super(13);
        this.targetController = 1;
        this.extCmd = str;
        this.params = iSFSObject;
        this.room = room2;
        this.useUDP = Boolean.valueOf(z);
        if (this.params == null) {
            this.params = new SFSObject();
        }
    }

    public void execute(ISmartFox iSmartFox) {
        this.sfso.putUtfString("c", this.extCmd);
        ISFSObject iSFSObject = this.sfso;
        Room room2 = this.room;
        iSFSObject.putInt("r", room2 == null ? -1 : room2.getId());
        this.sfso.putSFSObject("p", this.params);
    }

    public boolean getUseUDP() {
        return this.useUDP.booleanValue();
    }

    public void validate(ISmartFox iSmartFox) throws SFSValidationException {
        ArrayList arrayList = new ArrayList();
        if (SFSStringUtils.isEmptyOrNull(this.extCmd)) {
            arrayList.add("Missing extension command");
        }
        if (this.params == null) {
            arrayList.add("Missing extension parameters");
        }
        if (arrayList.size() > 0) {
            throw new SFSValidationException("ExtensionCall request error", arrayList);
        }
    }

    public ExtensionRequest(String str, ISFSObject iSFSObject, Room room2) {
        this(str, iSFSObject, room2, false);
    }

    public ExtensionRequest(String str, ISFSObject iSFSObject) {
        this(str, iSFSObject, null, false);
    }
}
