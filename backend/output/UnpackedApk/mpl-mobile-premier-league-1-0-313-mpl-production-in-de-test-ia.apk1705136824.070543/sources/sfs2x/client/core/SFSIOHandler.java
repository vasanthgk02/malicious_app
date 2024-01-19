package sfs2x.client.core;

import com.smartfoxserver.bitswarm.util.ByteUtils;
import com.smartfoxserver.v2.exceptions.SFSCodecException;
import com.smartfoxserver.v2.exceptions.SFSException;
import com.smartfoxserver.v2.protocol.binary.PacketHeader;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import java.nio.ByteBuffer;
import org.apache.fontbox.ttf.GlyfDescript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sfs2x.client.bitswarm.BitSwarmClient;
import sfs2x.client.bitswarm.IMessage;
import sfs2x.client.bitswarm.IOHandler;
import sfs2x.client.bitswarm.IProtocolCodec;
import sfs2x.client.bitswarm.PendingPacket;
import sfs2x.client.util.ByteArray;
import sfs2x.fsm.FiniteStateMachine;

public class SFSIOHandler implements IOHandler {
    public static final int INT_BYTE_SIZE = 4;
    public static final int SHORT_BYTE_SIZE = 2;
    public final ByteArray EMPTY_BUFFER = new ByteArray();
    public BitSwarmClient bitSwarm;
    public FiniteStateMachine fsm;
    public boolean isDebugMode = false;
    public Logger log;
    public IPacketEncrypter packetEncrypter;
    public PendingPacket pendingPacket;
    public IProtocolCodec protocolCodec;
    public int skipBytes = 0;

    public SFSIOHandler(BitSwarmClient bitSwarmClient) {
        this.bitSwarm = bitSwarmClient;
        this.log = LoggerFactory.getLogger(SFSIOHandler.class);
        this.protocolCodec = new SFSProtocolCodec(this, bitSwarmClient);
        this.packetEncrypter = new DefaultPacketEncrypter(bitSwarmClient);
        InitStates();
        this.isDebugMode = bitSwarmClient.getSfs().isDebug();
    }

    private void InitStates() {
        FiniteStateMachine finiteStateMachine = new FiniteStateMachine();
        this.fsm = finiteStateMachine;
        finiteStateMachine.addState(4);
        this.fsm.addState(3);
        this.fsm.addState(1);
        this.fsm.addState(2);
        this.fsm.addState(0);
        this.fsm.addStateTransition(0, 1, 0);
        this.fsm.addStateTransition(1, 3, 1);
        this.fsm.addStateTransition(1, 2, 2);
        this.fsm.addStateTransition(2, 3, 3);
        this.fsm.addStateTransition(3, 0, 4);
        this.fsm.addStateTransition(3, 4, 5);
        this.fsm.addStateTransition(4, 0, 6);
        this.fsm.setCurrentState(0);
    }

    private PacketHeader createPacketHeader(byte b2) {
        PacketHeader packetHeader = new PacketHeader(true, (b2 & 64) > 0, (b2 & 32) > 0, (b2 & GlyfDescript.X_DUAL) > 0, (b2 & 8) > 0);
        return packetHeader;
    }

    private byte encodePacketHeader(PacketHeader packetHeader) {
        byte b2 = packetHeader.isBinary() ? (byte) 128 : 0;
        if (packetHeader.isEncrypted()) {
            b2 = (byte) (b2 | 64);
        }
        if (packetHeader.isCompressed()) {
            b2 = (byte) (b2 | 32);
        }
        if (packetHeader.isBlueBoxed()) {
            b2 = (byte) (b2 | GlyfDescript.X_DUAL);
        }
        return packetHeader.isBigSized() ? (byte) (b2 | 8) : b2;
    }

    private int getReadState() {
        return this.fsm.getCurrentState();
    }

    private ByteArray handleDataSize(ByteArray byteArray) throws SFSException {
        int i;
        if (this.isDebugMode && this.log.isDebugEnabled()) {
            Logger logger = this.log;
            StringBuilder sb = new StringBuilder("Handling Header Size. Length: ");
            sb.append(byteArray.getLength());
            sb.append(" (");
            sb.append(this.pendingPacket.getHeader().isBigSized() ? "big" : "small");
            sb.append(")");
            logger.debug(sb.toString());
        }
        int i2 = 4;
        if (this.pendingPacket.getHeader().isBigSized()) {
            i = byteArray.getLength() >= 4 ? byteArray.readInt() : -1;
        } else {
            i = byteArray.getLength() >= 2 ? byteArray.readUShort() : -1;
            i2 = 2;
        }
        if (this.isDebugMode && this.log.isDebugEnabled()) {
            Logger logger2 = this.log;
            logger2.debug("Data size is " + i);
        }
        if (i != -1) {
            this.pendingPacket.getHeader().setExpectedLen(i);
            ByteArray resizeByteArray = resizeByteArray(byteArray, i2, byteArray.getLength() - i2);
            this.fsm.applyTransition(1);
            return resizeByteArray;
        }
        this.fsm.applyTransition(2);
        writeBytes(this.pendingPacket, byteArray);
        return this.EMPTY_BUFFER;
    }

    private ByteArray handleDataSizeFragment(ByteArray byteArray) throws SFSException {
        if (this.isDebugMode && this.log.isDebugEnabled()) {
            Logger logger = this.log;
            logger.debug("Handling Size fragment. Data: " + byteArray.getLength());
        }
        int i = 4;
        int length = this.pendingPacket.getHeader().isBigSized() ? 4 - this.pendingPacket.getBuffer().getLength() : 2 - this.pendingPacket.getBuffer().getLength();
        if (byteArray.getLength() >= length) {
            writeBytes(this.pendingPacket, byteArray, length);
            if (!this.pendingPacket.getHeader().isBigSized()) {
                i = 2;
            }
            ByteArray byteArray2 = new ByteArray();
            byteArray2.writeBytes(this.pendingPacket.getBuffer().getBytes(), i);
            byteArray2.setPosition(0);
            int readInt = this.pendingPacket.getHeader().isBigSized() ? byteArray2.readInt() : byteArray2.readShort();
            if (this.isDebugMode && this.log.isDebugEnabled()) {
                Logger logger2 = this.log;
                logger2.debug("DataSize is ready: " + readInt + " bytes");
            }
            this.pendingPacket.getHeader().setExpectedLen(readInt);
            this.pendingPacket.setBuffer(new ByteArray());
            this.fsm.applyTransition(3);
            if (byteArray.getLength() > length) {
                return resizeByteArray(byteArray, length, byteArray.getLength() - length);
            }
            return this.EMPTY_BUFFER;
        }
        writeBytes(this.pendingPacket, byteArray);
        return this.EMPTY_BUFFER;
    }

    private ByteArray handleInvalidData(ByteArray byteArray) {
        if (this.skipBytes == 0) {
            this.fsm.applyTransition(6);
            return byteArray;
        }
        int min = Math.min(byteArray.getLength(), this.skipBytes);
        ByteArray resizeByteArray = resizeByteArray(byteArray, min, byteArray.getLength() - min);
        this.skipBytes -= min;
        return resizeByteArray;
    }

    private ByteArray handleNewPacket(ByteArray byteArray) throws SFSException {
        if (this.isDebugMode) {
            Logger logger = this.log;
            logger.info("Handling New Packet of size " + byteArray.getLength());
        }
        byte readByte = byteArray.readByte();
        if ((~(readByte & 128)) <= 0) {
            this.pendingPacket = new PendingPacket(createPacketHeader(readByte));
            this.fsm.applyTransition(0);
            return resizeByteArray(byteArray, 1, byteArray.getLength() - 1);
        }
        throw new SFSException("Unexpected header byte: " + readByte + "\n" + DefaultObjectDumpFormatter.prettyPrintByteArray(byteArray.getBytes()));
    }

    private ByteArray handlePacketData(ByteArray byteArray) throws SFSException {
        ByteArray byteArray2;
        int expectedLen = this.pendingPacket.getHeader().getExpectedLen() - this.pendingPacket.getBuffer().getLength();
        boolean z = byteArray.getLength() > expectedLen;
        ByteArray byteArray3 = new ByteArray(byteArray.getBytes());
        try {
            if (this.isDebugMode) {
                Logger logger = this.log;
                logger.info("Handling Data: " + byteArray.getLength() + ", previous state: " + this.pendingPacket.getBuffer().getLength() + "/" + this.pendingPacket.getHeader().getExpectedLen());
            }
            if (byteArray.getLength() >= expectedLen) {
                writeBytes(this.pendingPacket, byteArray, expectedLen);
                if (this.isDebugMode) {
                    this.log.info("<<< Packet Complete >>>");
                }
                if (this.pendingPacket.getHeader().isEncrypted()) {
                    this.pendingPacket.getBuffer().setBuffer(this.packetEncrypter.decrypt(this.pendingPacket.getBuffer().getBytes()));
                }
                if (this.pendingPacket.getHeader().isCompressed()) {
                    uncompress(this.pendingPacket);
                }
                this.protocolCodec.onPacketRead(this.pendingPacket.getBuffer());
                this.fsm.applyTransition(4);
            } else {
                writeBytes(this.pendingPacket, byteArray);
            }
            if (z) {
                byteArray2 = resizeByteArray(byteArray, expectedLen, byteArray.getLength() - expectedLen);
            } else {
                byteArray2 = this.EMPTY_BUFFER;
            }
            return byteArray2;
        } catch (Exception e2) {
            throw new SFSException((Throwable) e2);
        } catch (RuntimeException e3) {
            Logger logger2 = this.log;
            logger2.error("Error handling data: " + e3.getMessage(), e3);
            this.skipBytes = expectedLen;
            this.fsm.applyTransition(5);
            return byteArray3;
        }
    }

    private ByteArray resizeByteArray(ByteArray byteArray, int i, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.put(byteArray.getBytes(), i, i2);
        return new ByteArray(allocate.array());
    }

    private void uncompress(PendingPacket pendingPacket2) throws SFSException {
        ByteArray buffer = pendingPacket2.getBuffer();
        buffer.uncompress();
        pendingPacket2.setBuffer(buffer);
    }

    private void writeBytes(PendingPacket pendingPacket2, ByteArray byteArray) {
        ByteArray buffer = pendingPacket2.getBuffer();
        buffer.writeBytes(byteArray.getBytes());
        pendingPacket2.setBuffer(buffer);
    }

    private void writeTCP(IMessage iMessage, ByteArray byteArray) {
        this.bitSwarm.getSocket().write(byteArray.getBytes());
        if (this.isDebugMode) {
            Logger logger = this.log;
            logger.info("Data written: " + iMessage.getContent().getHexDump());
        }
    }

    private void writeUDP(IMessage iMessage, ByteArray byteArray) {
        this.bitSwarm.getUdpManager().send(byteArray);
    }

    public final IProtocolCodec getCodec() {
        return this.protocolCodec;
    }

    public void onDataRead(ByteArray byteArray) throws SFSException {
        if (byteArray.getLength() != 0) {
            if (this.bitSwarm != null && this.isDebugMode) {
                if (byteArray.getLength() > 1024) {
                    this.log.info("Data Read: Size > 1024, dump omitted");
                } else {
                    Logger logger = this.log;
                    logger.info("Data Read: " + ByteUtils.fullHexDump(byteArray.getBytes()));
                }
            }
            byteArray.setPosition(0);
            while (byteArray.getLength() > 0) {
                if (getReadState() == 0) {
                    byteArray = handleNewPacket(byteArray);
                } else if (getReadState() == 1) {
                    byteArray = handleDataSize(byteArray);
                } else if (getReadState() == 2) {
                    byteArray = handleDataSizeFragment(byteArray);
                } else if (getReadState() == 3) {
                    byteArray = handlePacketData(byteArray);
                } else if (getReadState() == 4) {
                    byteArray = handleInvalidData(byteArray);
                }
            }
            return;
        }
        throw new SFSException((String) "Unexpected empty packet data: no readable bytes available!");
    }

    public void onDataWrite(IMessage iMessage) throws SFSException {
        boolean z;
        boolean z2;
        ByteArray byteArray = new ByteArray();
        ByteArray byteArray2 = new ByteArray(iMessage.getContent().toBinary());
        if (byteArray2.getLength() > this.bitSwarm.getCompressionThreshold()) {
            byteArray2.compress();
            z = true;
        } else {
            z = false;
        }
        if (byteArray2.getLength() <= this.bitSwarm.getMaxMessageSize()) {
            if (this.bitSwarm.getCryptoKey() == null || this.bitSwarm.isReconnecting()) {
                z2 = false;
            } else {
                try {
                    byteArray2.setBuffer(this.packetEncrypter.encrypt(byteArray2.getBytes()));
                    z2 = true;
                } catch (Exception e2) {
                    throw new SFSException((Throwable) e2);
                }
            }
            char c2 = byteArray2.getLength() > 65535 ? (char) 4 : 2;
            PacketHeader packetHeader = new PacketHeader(true, z2, z, this.bitSwarm.getUseBlueBox(), c2 == 4);
            byteArray.writeByte(encodePacketHeader(packetHeader));
            if (c2 > 2) {
                byteArray.writeInt(byteArray2.getLength());
            } else {
                byteArray.writeUShort(byteArray2.getLength());
            }
            byteArray.writeBytes(byteArray2.getBytes());
            if (this.bitSwarm.getUseBlueBox()) {
                this.bitSwarm.getHttpClient().send(byteArray);
            } else if (!this.bitSwarm.getSocket().isConnected()) {
            } else {
                if (iMessage.isUDP()) {
                    writeUDP(iMessage, byteArray);
                } else {
                    writeTCP(iMessage, byteArray);
                }
            }
        } else {
            throw new SFSCodecException("Message size is too big: " + byteArray2.getLength() + ", the server limit is: " + this.bitSwarm.getMaxMessageSize());
        }
    }

    private void writeBytes(PendingPacket pendingPacket2, ByteArray byteArray, int i) {
        ByteArray buffer = pendingPacket2.getBuffer();
        buffer.writeBytes(byteArray.getBytes(), i);
        pendingPacket2.setBuffer(buffer);
    }
}
