package com.smartfoxserver.v2.protocol.binary;

import com.android.tools.r8.GeneratedOutlineSupport;

public class PacketHeader {
    public final boolean bigSized;
    public final boolean binary;
    public final boolean blueBoxed;
    public final boolean compressed;
    public boolean encrypted;
    public int expectedLen = -1;

    public PacketHeader(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.binary = z;
        this.compressed = z3;
        this.encrypted = z2;
        this.blueBoxed = z4;
        this.bigSized = z5;
    }

    public int getExpectedLen() {
        return this.expectedLen;
    }

    public boolean isBigSized() {
        return this.bigSized;
    }

    public boolean isBinary() {
        return this.binary;
    }

    public boolean isBlueBoxed() {
        return this.blueBoxed;
    }

    public boolean isCompressed() {
        return this.compressed;
    }

    public boolean isEncrypted() {
        return this.encrypted;
    }

    public void setEncrypted(boolean z) {
        this.encrypted = z;
    }

    public void setExpectedLen(int i) {
        this.expectedLen = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("\n---------------------------------------------\n");
        outline73.append("Binary:  \t" + isBinary() + "\n");
        outline73.append("Compressed:\t" + isCompressed() + "\n");
        outline73.append("Encrypted:\t" + isEncrypted() + "\n");
        outline73.append("BlueBoxed:\t" + isBlueBoxed() + "\n");
        outline73.append("BigSized:\t" + isBigSized() + "\n");
        outline73.append("---------------------------------------------\n");
        return outline73.toString();
    }
}
