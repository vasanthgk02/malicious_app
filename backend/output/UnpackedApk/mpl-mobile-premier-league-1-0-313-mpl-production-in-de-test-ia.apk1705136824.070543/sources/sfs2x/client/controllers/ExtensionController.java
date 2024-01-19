package sfs2x.client.controllers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import java.util.HashMap;
import sfs2x.client.ISmartFox;
import sfs2x.client.bitswarm.BaseController;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.core.SFSEvent;

public class ExtensionController extends BaseController {
    public static final String KEY_CMD = "c";
    public static final String KEY_PARAMS = "p";
    public static final String KEY_ROOM = "r";
    public BitSwarmClient bitSwarm;
    public ISmartFox sfs;

    public ExtensionController(ISmartFox iSmartFox) {
        this.sfs = iSmartFox;
    }

    public void handleMessage(IMessage iMessage) {
        if (this.sfs.isDebug()) {
            this.log.info(iMessage.toString());
        }
        ISFSObject content = iMessage.getContent();
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", content.getUtfString("c"));
        hashMap.put(CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, content.getSFSObject("p"));
        if (content.containsKey("r")) {
            int intValue = content.getInt("r").intValue();
            hashMap.put("sourceRoom", Integer.valueOf(intValue));
            hashMap.put("room", this.sfs.getRoomManager().getRoomById(intValue));
        }
        if (iMessage.isUDP()) {
            hashMap.put("packetId", Long.valueOf(iMessage.getPacketId()));
        }
        GeneratedOutlineSupport.outline98(SFSEvent.EXTENSION_RESPONSE, hashMap, this.sfs);
    }

    public ExtensionController(BitSwarmClient bitSwarmClient) {
        this.bitSwarm = bitSwarmClient;
        this.sfs = bitSwarmClient.getSfs();
    }
}
