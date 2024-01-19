package sfs2x.client.bitswarm;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;

public class Message implements IMessage {
    public ISFSObject content;
    public int id;
    public boolean isEncrypted = false;
    public boolean isUDP;
    public long packetId;
    public int targetController;

    public ISFSObject getContent() {
        return this.content;
    }

    public int getId() {
        return this.id;
    }

    public long getPacketId() {
        return this.packetId;
    }

    public int getTargetController() {
        return this.targetController;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public boolean isUDP() {
        return this.isUDP;
    }

    public void setContent(ISFSObject iSFSObject) {
        this.content = iSFSObject;
    }

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setPacketId(long j) {
        this.packetId = j;
    }

    public void setTargetController(int i) {
        this.targetController = i;
    }

    public void setUDP(boolean z) {
        this.isUDP = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ Message id: ");
        outline73.append(this.id);
        outline73.append(" }\n");
        outline73.append("{ Dump: }\n");
        outline73.append(this.content.getDump());
        return outline73.toString();
    }
}
