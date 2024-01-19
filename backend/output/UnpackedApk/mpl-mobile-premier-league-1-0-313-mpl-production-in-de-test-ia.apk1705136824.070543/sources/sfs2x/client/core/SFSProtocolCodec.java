package sfs2x.client.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSObject;
import com.smartfoxserver.v2.exceptions.SFSCodecException;
import com.smartfoxserver.v2.exceptions.SFSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.bitswarm.IController;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.bitswarm.IOHandler;
import sfs2x.client.bitswarm.IProtocolCodec;
import sfs2x.client.bitswarm.Message;
import sfs2x.client.util.ByteArray;

public class SFSProtocolCodec implements IProtocolCodec {
    public static final String ACTION_ID = "a";
    public static final String CONTROLLER_ID = "c";
    public static final String PARAM_ID = "p";
    public static final String UDP_PACKET_ID = "i";
    public static final String USER_ID = "u";
    public BitSwarmClient bitSwarm;
    public IOHandler ioHandler = null;
    public Logger log;

    public SFSProtocolCodec(IOHandler iOHandler, BitSwarmClient bitSwarmClient) {
        this.ioHandler = iOHandler;
        this.log = LoggerFactory.getLogger(SFSProtocolCodec.class);
        this.bitSwarm = bitSwarmClient;
    }

    private void dispatchRequest(ISFSObject iSFSObject) throws SFSException {
        Message message = new Message();
        if (iSFSObject.isNull("c")) {
            throw new SFSCodecException((String) "Request rejected: No Controller ID in request!");
        } else if (!iSFSObject.isNull("a")) {
            message.setId(iSFSObject.getShort("a").shortValue());
            message.setContent(iSFSObject.getSFSObject("p"));
            message.setUDP(iSFSObject.containsKey("i"));
            if (message.isUDP()) {
                message.setPacketId(iSFSObject.getLong("i").longValue());
            }
            byte byteValue = iSFSObject.getByte("c").byteValue();
            IController controller = this.bitSwarm.getController(byteValue);
            if (controller != null) {
                controller.handleMessage(message);
                return;
            }
            throw new SFSException(GeneratedOutlineSupport.outline40("Cannot handle server response. Unknown controller, id: ", byteValue));
        } else {
            throw new SFSCodecException((String) "Request rejected: No Action ID in request!");
        }
    }

    private ISFSObject prepareTCPPacket(IMessage iMessage) {
        SFSObject sFSObject = new SFSObject();
        sFSObject.putByte("c", (byte) iMessage.getTargetController());
        sFSObject.putShort("a", (short) iMessage.getId());
        sFSObject.putSFSObject("p", iMessage.getContent());
        return sFSObject;
    }

    private ISFSObject prepareUDPPacket(IMessage iMessage) {
        SFSObject sFSObject = new SFSObject();
        sFSObject.putByte("c", (byte) iMessage.getTargetController());
        sFSObject.putInt("u", this.bitSwarm.getSfs().getMySelf() != null ? this.bitSwarm.getSfs().getMySelf().getId() : -1);
        sFSObject.putLong("i", this.bitSwarm.getNextUdpPacketId());
        sFSObject.putSFSObject("p", iMessage.getContent());
        return sFSObject;
    }

    public IOHandler getIOHandler() {
        return this.ioHandler;
    }

    public void onPacketRead(ByteArray byteArray) throws SFSException {
        dispatchRequest(SFSObject.newFromBinaryData(byteArray.getBytes()));
    }

    public void onPacketWrite(IMessage iMessage) throws SFSException {
        ISFSObject iSFSObject;
        if (iMessage.isUDP()) {
            iSFSObject = prepareUDPPacket(iMessage);
        } else {
            iSFSObject = prepareTCPPacket(iMessage);
        }
        iMessage.setContent(iSFSObject);
        this.ioHandler.onDataWrite(iMessage);
    }

    public void setIOHandler(IOHandler iOHandler) throws SFSException {
        if (this.ioHandler == null) {
            this.ioHandler = iOHandler;
            return;
        }
        throw new SFSException("IOHandler is already defined for thir ProtocolHandler instance: " + this);
    }

    public void onPacketRead(ISFSObject iSFSObject) throws SFSException {
        dispatchRequest(iSFSObject);
    }
}
