package org.apache.pdfbox.filter.ccitt;

import java.io.IOException;
import okio.Utf8;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;
import sfs2x.client.entities.invitation.InvitationReply;

public final class TIFFFaxDecoder {
    public static final short[] ADDITIONAL_MAKEUP = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    public static final short[] BLACK = {62, 62, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 3225, 588, 588, 588, 588, 588, 588, 588, 588, 1680, 1680, 20499, 22547, 24595, 26643, 1776, 1776, 1808, 1808, -24557, -22509, -20461, -18413, 1904, 1904, 1936, 1936, -16365, -14317, 782, 782, 782, 782, 814, 814, 814, 814, -12269, -10221, 10257, 10257, 12305, 12305, 14353, 14353, 16403, 18451, 1712, 1712, 1744, 1744, 28691, 30739, -32749, -30701, -28653, -26605, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 2061, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 424, 750, 750, 750, 750, 1616, 1616, 1648, 1648, 1424, 1424, 1456, 1456, 1488, 1488, 1520, 1520, 1840, 1840, 1872, 1872, 1968, 1968, 8209, 8209, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 1552, 1552, 1584, 1584, 2000, 2000, 2032, 2032, 976, 976, 1008, 1008, 1040, 1040, 1072, 1072, 1296, 1296, 1328, 1328, 718, 718, 718, 718, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 456, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 326, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 358, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 490, 4113, 4113, 6161, 6161, 848, 848, 880, 880, 912, 912, 944, 944, 622, 622, 622, 622, 654, 654, 654, 654, 1104, 1104, 1136, 1136, 1168, 1168, 1200, 1200, 1232, 1232, 1264, 1264, 686, 686, 686, 686, 1360, 1360, 1392, 1392, 12, 12, 12, 12, 12, 12, 12, 12, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390, 390};
    public static final byte[] FLIP_TABLE = {0, Byte.MIN_VALUE, 64, -64, 32, -96, 96, -32, GlyfDescript.X_DUAL, -112, 80, -48, BaseParser.ASCII_ZERO, -80, 112, -16, 8, -120, 72, -56, 40, -88, 104, -24, 24, -104, 88, -40, 56, -72, 120, -8, 4, -124, 68, -60, 36, -92, 100, -28, 20, -108, 84, -44, 52, -76, 116, -12, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -116, 76, -52, HttpCodecUtil.COMMA, -84, 108, -20, 28, -100, 92, -36, 60, -68, 124, -4, 2, -126, 66, -62, HttpCodecUtil.DOUBLE_QUOTE, -94, 98, -30, 18, -110, 82, -46, 50, -78, 114, -14, 10, -118, 74, -54, 42, -86, 106, -22, 26, -102, 90, -38, HttpCodecUtil.COLON, -70, 122, -6, 6, -122, 70, -58, 38, -90, 102, -26, 22, -106, 86, -42, 54, -74, 118, -10, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -114, 78, -50, 46, -82, 110, -18, 30, -98, 94, -34, 62, -66, 126, -2, 1, -127, 65, -63, 33, -95, 97, -31, 17, -111, 81, -47, 49, -79, 113, -15, 9, -119, 73, -55, 41, -87, 105, -23, 25, -103, 89, -39, BaseParser.ASCII_NINE, -71, 121, -7, 5, -123, 69, -59, 37, -91, 101, -27, 21, -107, 85, -43, 53, -75, 117, -11, 13, -115, 77, -51, 45, -83, 109, -19, 29, -99, 93, -35, 61, -67, 125, -3, 3, -125, 67, -61, 35, -93, 99, -29, 19, -109, 83, -45, 51, -77, 115, -13, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -117, 75, -53, 43, -85, 107, -21, 27, -101, 91, -37, HttpCodecUtil.SEMICOLON, -69, 123, -5, 7, -121, 71, -57, 39, -89, 103, -25, 23, -105, 87, -41, 55, -73, 119, -9, 15, -113, 79, -49, 47, -81, 111, -17, 31, -97, 95, -33, Utf8.REPLACEMENT_BYTE, -65, Byte.MAX_VALUE, -1};
    public static final short[] INIT_BLACK = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    public static final int[] TABLE1 = {0, 1, 3, 7, 15, 31, 63, 127, InvitationReply.EXPIRED};
    public static final int[] TABLE2 = {0, 128, 192, 224, 240, 248, 252, 254, InvitationReply.EXPIRED};
    public static final short[] TWO_BIT_BLACK = {292, 260, 226, 226};
    public static final byte[] TWO_DCODES = {80, 88, 23, 71, 30, 30, 62, 62, 4, 4, 4, 4, 4, 4, 4, 4, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};
    public static final short[] WHITE = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    public int bitPointer;
    public int bytePointer;
    public int changingElemSize = 0;
    public int compression = 2;
    public int[] currChangingElems;
    public byte[] data;
    public int fillBits = 0;
    public int fillOrder;
    public int h;
    public int lastChangingElement = 0;
    public int oneD;
    public int[] prevChangingElems;
    public int uncompressedMode = 0;
    public int w;

    public TIFFFaxDecoder(int i, int i2, int i3) {
        this.fillOrder = i;
        this.w = i2;
        this.h = i3;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = i2 + 1;
        this.prevChangingElems = new int[i4];
        this.currChangingElems = new int[i4];
    }

    private boolean advancePointer() {
        if (this.bitPointer != 0) {
            this.bytePointer++;
            this.bitPointer = 0;
        }
        return true;
    }

    private int decodeBlackCodeWord() throws IOException {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s = INIT_BLACK[nextLesserThan8Bits(4)];
            int i2 = (s >>> 1) & 15;
            int i3 = (s >>> 5) & 2047;
            if (i3 == 100) {
                short s2 = BLACK[nextNBits(9)];
                short s3 = s2 & 1;
                int i4 = (s2 >>> 1) & 15;
                int i5 = (s2 >>> 5) & 2047;
                if (i4 == 12) {
                    updatePointer(5);
                    short s4 = ADDITIONAL_MAKEUP[nextLesserThan8Bits(4)];
                    i += (s4 >>> 4) & 4095;
                    updatePointer(4 - ((s4 >>> 1) & 7));
                } else if (i4 != 15) {
                    i += i5;
                    updatePointer(9 - i4);
                    if (s3 != 0) {
                    }
                } else {
                    throw new IOException("TIFFFaxDecoder: EOL encountered in black run.");
                }
            } else if (i3 == 200) {
                short s5 = TWO_BIT_BLACK[nextLesserThan8Bits(2)];
                i += (s5 >>> 5) & 2047;
                updatePointer(2 - ((s5 >>> 1) & 15));
            } else {
                i += i3;
                updatePointer(4 - i2);
            }
            z = true;
        }
        return i;
    }

    private int decodeWhiteCodeWord() throws IOException {
        boolean z = true;
        int i = 0;
        while (z) {
            int nextNBits = nextNBits(10);
            short s = WHITE[nextNBits];
            short s2 = s & 1;
            int i2 = (s >>> 1) & 15;
            if (i2 == 12) {
                short s3 = ADDITIONAL_MAKEUP[((nextNBits << 2) & 12) | nextLesserThan8Bits(2)];
                i += (s3 >>> 4) & 4095;
                updatePointer(4 - ((s3 >>> 1) & 7));
            } else if (i2 == 0) {
                throw new IOException("TIFFFaxDecoder: Invalid code encountered.");
            } else if (i2 != 15) {
                i += (s >>> 5) & 2047;
                updatePointer(10 - i2);
                if (s2 == 0) {
                    z = false;
                }
            } else {
                throw new IOException("TIFFFaxDecoder: EOL encountered in white run.");
            }
        }
        return i;
    }

    private void getNextChangingElement(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.prevChangingElems;
        int i2 = this.changingElemSize;
        int i3 = this.lastChangingElement;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & -2 : i4 | 1;
        while (true) {
            if (i5 >= i2) {
                break;
            }
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.lastChangingElement = i5;
                iArr[0] = i6;
                break;
            }
            i5 += 2;
        }
        int i7 = i5 + 1;
        if (i7 < i2) {
            iArr[1] = iArr2[i7];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextLesserThan8Bits(int r9) throws java.io.IOException {
        /*
            r8 = this;
            byte[] r0 = r8.data
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r8.bytePointer
            int r4 = r8.fillOrder
            r5 = 0
            if (r4 != r2) goto L_0x0016
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x002d
        L_0x0012:
            int r3 = r3 + r2
            byte r0 = r0[r3]
            goto L_0x002d
        L_0x0016:
            r6 = 2
            if (r4 != r6) goto L_0x0064
            byte[] r4 = FLIP_TABLE
            byte r6 = r0[r3]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r4[r6]
            if (r3 != r1) goto L_0x0025
            r4 = r6
            goto L_0x0010
        L_0x0025:
            int r3 = r3 + r2
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r6
        L_0x002d:
            int r1 = r8.bitPointer
            int r3 = 8 - r1
            int r6 = r9 - r3
            int r7 = r3 - r9
            if (r7 < 0) goto L_0x004c
            int[] r0 = TABLE1
            r0 = r0[r3]
            r0 = r0 & r4
            int r0 = r0 >>> r7
            int r1 = r1 + r9
            r8.bitPointer = r1
            r9 = 8
            if (r1 != r9) goto L_0x0063
            r8.bitPointer = r5
            int r9 = r8.bytePointer
            int r9 = r9 + r2
            r8.bytePointer = r9
            goto L_0x0063
        L_0x004c:
            int[] r9 = TABLE1
            r9 = r9[r3]
            r9 = r9 & r4
            int r1 = -r7
            int r9 = r9 << r1
            int[] r1 = TABLE2
            r1 = r1[r6]
            r0 = r0 & r1
            int r1 = 8 - r6
            int r0 = r0 >>> r1
            r0 = r0 | r9
            int r9 = r8.bytePointer
            int r9 = r9 + r2
            r8.bytePointer = r9
            r8.bitPointer = r6
        L_0x0063:
            return r0
        L_0x0064:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r0 = "TIFFFaxDecoder: TIFF_FILL_ORDER tag must be either 1 or 2."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.filter.ccitt.TIFFFaxDecoder.nextLesserThan8Bits(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNBits(int r13) throws java.io.IOException {
        /*
            r12 = this;
            byte[] r0 = r12.data
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r12.bytePointer
            int r4 = r12.fillOrder
            r5 = 2
            r6 = 0
            if (r4 != r2) goto L_0x0024
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0014
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            goto L_0x004d
        L_0x0014:
            int r7 = r3 + 1
            if (r7 != r1) goto L_0x001b
            byte r0 = r0[r7]
            goto L_0x0012
        L_0x001b:
            byte r1 = r0[r7]
            int r3 = r3 + r5
            byte r0 = r0[r3]
        L_0x0020:
            r11 = r1
            r1 = r0
            r0 = r11
            goto L_0x004d
        L_0x0024:
            if (r4 != r5) goto L_0x008d
            byte[] r4 = FLIP_TABLE
            byte r7 = r0[r3]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r4[r7]
            if (r3 != r1) goto L_0x0032
            r4 = r7
            goto L_0x0011
        L_0x0032:
            int r8 = r3 + 1
            if (r8 != r1) goto L_0x003e
            byte r0 = r0[r8]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r7
            goto L_0x0012
        L_0x003e:
            byte r1 = r0[r8]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r4[r1]
            int r3 = r3 + r5
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r7
            goto L_0x0020
        L_0x004d:
            int r3 = r12.bitPointer
            r5 = 8
            int r3 = 8 - r3
            int r13 = r13 - r3
            if (r13 <= r5) goto L_0x005b
            int r7 = r13 + -8
            r8 = 8
            goto L_0x005d
        L_0x005b:
            r8 = r13
            r7 = 0
        L_0x005d:
            int r9 = r12.bytePointer
            int r9 = r9 + r2
            r12.bytePointer = r9
            int[] r10 = TABLE1
            r3 = r10[r3]
            r3 = r3 & r4
            int r13 = r3 << r13
            int[] r3 = TABLE2
            r4 = r3[r8]
            r0 = r0 & r4
            int r4 = 8 - r8
            int r0 = r0 >>> r4
            if (r7 == 0) goto L_0x0081
            int r0 = r0 << r7
            r3 = r3[r7]
            r1 = r1 & r3
            int r3 = 8 - r7
            int r1 = r1 >>> r3
            r0 = r0 | r1
            int r9 = r9 + r2
            r12.bytePointer = r9
            r12.bitPointer = r7
            goto L_0x008b
        L_0x0081:
            if (r8 != r5) goto L_0x0089
            r12.bitPointer = r6
            int r9 = r9 + r2
            r12.bytePointer = r9
            goto L_0x008b
        L_0x0089:
            r12.bitPointer = r8
        L_0x008b:
            r13 = r13 | r0
            return r13
        L_0x008d:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "TIFFFaxDecoder: TIFF_FILL_ORDER tag must be either 1 or 2."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.filter.ccitt.TIFFFaxDecoder.nextNBits(int):int");
    }

    private int readEOL() throws IOException {
        int nextNBits;
        int i = this.fillBits;
        if (i == 0) {
            if (nextNBits(12) != 1) {
                throw new IOException("TIFFFaxDecoder: Scanline must begin with EOL.");
            }
        } else if (i == 1) {
            int i2 = 8 - this.bitPointer;
            if (nextNBits(i2) != 0) {
                throw new IOException("TIFFFaxDecoder: All fill bits preceding EOL code must be 0.");
            } else if (i2 >= 4 || nextNBits(8) == 0) {
                do {
                    nextNBits = nextNBits(8);
                    if (nextNBits != 1) {
                    }
                } while (nextNBits == 0);
                throw new IOException("TIFFFaxDecoder: All fill bits preceding EOL code must be 0.");
            } else {
                throw new IOException("TIFFFaxDecoder: All fill bits preceding EOL code must be 0.");
            }
        }
        if (this.oneD == 0) {
            return 1;
        }
        return nextLesserThan8Bits(1);
    }

    private void setToBlack(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i * 8) + i2;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b2 = bArr[i6];
            while (i8 > 0 && i4 < i5) {
                b2 = (byte) (b2 | i8);
                i8 >>= 1;
                i4++;
            }
            bArr[i6] = b2;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            bArr[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            i4++;
        }
    }

    private void updatePointer(int i) {
        int i2 = this.bitPointer - i;
        if (i2 < 0) {
            this.bytePointer--;
            this.bitPointer = i2 + 8;
            return;
        }
        this.bitPointer = i2;
    }

    public void decode1D(byte[] bArr, byte[] bArr2, int i, int i2) throws IOException {
        this.data = bArr2;
        int i3 = (this.w + 7) / 8;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            decodeNextScanline(bArr, i4, i);
            i4 += i3;
        }
    }

    public void decode2D(byte[] bArr, byte[] bArr2, int i, int i2, long j) throws IOException {
        int i3;
        int i4;
        byte[] bArr3 = bArr;
        int i5 = i;
        this.data = bArr2;
        this.compression = 3;
        int i6 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        byte b2 = 7;
        int i7 = (this.w + 7) / 8;
        int[] iArr = new int[2];
        this.oneD = (int) (j & 1);
        char c2 = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        this.fillBits = (int) ((j & 4) >> 2);
        if (readEOL() == 1) {
            decodeNextScanline(bArr3, 0, i5);
            int i8 = i7 + 0;
            int i9 = i2;
            int i10 = 1;
            while (i10 < i9) {
                if (readEOL() == 0) {
                    int[] iArr2 = this.prevChangingElems;
                    this.prevChangingElems = this.currChangingElems;
                    this.currChangingElems = iArr2;
                    int i11 = -1;
                    this.lastChangingElement = i3;
                    int i12 = i5;
                    boolean z = true;
                    int i13 = 0;
                    while (i12 < this.w) {
                        getNextChangingElement(i11, z, iArr);
                        int i14 = iArr[i3];
                        i11 = iArr[c2];
                        byte b3 = TWO_DCODES[nextLesserThan8Bits(b2)] & 255;
                        int i15 = (b3 & 120) >>> 3;
                        byte b4 = b3 & b2;
                        if (i15 == 0) {
                            if (!z) {
                                setToBlack(bArr3, i8, i12, i11 - i12);
                            }
                            updatePointer(7 - b4);
                            i12 = i11;
                        } else if (i15 == 1) {
                            updatePointer(7 - b4);
                            if (z) {
                                int decodeWhiteCodeWord = i12 + decodeWhiteCodeWord();
                                int i16 = i13 + 1;
                                this.currChangingElems[i13] = decodeWhiteCodeWord;
                                int decodeBlackCodeWord = decodeBlackCodeWord();
                                setToBlack(bArr3, i8, decodeWhiteCodeWord, decodeBlackCodeWord);
                                i12 = decodeWhiteCodeWord + decodeBlackCodeWord;
                                i4 = i16 + 1;
                                this.currChangingElems[i16] = i12;
                            } else {
                                int decodeBlackCodeWord2 = decodeBlackCodeWord();
                                setToBlack(bArr3, i8, i12, decodeBlackCodeWord2);
                                int i17 = i12 + decodeBlackCodeWord2;
                                int i18 = i13 + 1;
                                this.currChangingElems[i13] = i17;
                                i12 = i17 + decodeWhiteCodeWord();
                                i4 = i18 + 1;
                                this.currChangingElems[i18] = i12;
                            }
                            i13 = i4;
                            i11 = i12;
                        } else if (i15 <= 8) {
                            int i19 = i14 + (i15 - 5);
                            int i20 = i13 + 1;
                            this.currChangingElems[i13] = i19;
                            if (!z) {
                                setToBlack(bArr3, i8, i12, i19 - i12);
                            }
                            z = !z;
                            updatePointer(7 - b4);
                            i11 = i19;
                            i12 = i11;
                            i13 = i20;
                            i3 = 0;
                            b2 = 7;
                            c2 = 1;
                        } else {
                            throw new IOException("TIFFFaxDecoder: Invalid code encountered while decoding 2D group 3 compressed data.");
                        }
                        i3 = 0;
                        c2 = 1;
                    }
                    this.currChangingElems[i13] = i12;
                    this.changingElemSize = i13 + 1;
                } else {
                    decodeNextScanline(bArr3, i8, i5);
                }
                i8 += i7;
                i10++;
                i6 = 0;
                b2 = 7;
                c2 = 1;
            }
            return;
        }
        throw new IOException("TIFFFaxDecoder: First scanline must be 1D encoded.");
    }

    public void decodeNextScanline(byte[] bArr, int i, int i2) throws IOException {
        this.changingElemSize = 0;
        boolean z = true;
        while (true) {
            if (i2 >= this.w) {
                break;
            }
            while (z) {
                int nextNBits = nextNBits(10);
                short s = WHITE[nextNBits];
                short s2 = s & 1;
                int i3 = (s >>> 1) & 15;
                if (i3 == 12) {
                    short s3 = ADDITIONAL_MAKEUP[(12 & (nextNBits << 2)) | nextLesserThan8Bits(2)];
                    i2 += (s3 >>> 4) & 4095;
                    updatePointer(4 - ((s3 >>> 1) & 7));
                } else if (i3 == 0) {
                    throw new IOException("TIFFFaxDecoder: Invalid code encountered.");
                } else if (i3 != 15) {
                    i2 += (s >>> 5) & 2047;
                    updatePointer(10 - i3);
                    if (s2 == 0) {
                        int[] iArr = this.currChangingElems;
                        int i4 = this.changingElemSize;
                        this.changingElemSize = i4 + 1;
                        iArr[i4] = i2;
                        z = false;
                    }
                } else {
                    throw new IOException("TIFFFaxDecoder: EOL encountered in white run.");
                }
            }
            if (i2 != this.w) {
                while (!z) {
                    short s4 = INIT_BLACK[nextLesserThan8Bits(4)];
                    int i5 = (s4 >>> 1) & 15;
                    int i6 = (s4 >>> 5) & 2047;
                    if (i6 == 100) {
                        short s5 = BLACK[nextNBits(9)];
                        short s6 = s5 & 1;
                        int i7 = (s5 >>> 1) & 15;
                        int i8 = (s5 >>> 5) & 2047;
                        if (i7 == 12) {
                            updatePointer(5);
                            short s7 = ADDITIONAL_MAKEUP[nextLesserThan8Bits(4)];
                            int i9 = (s7 >>> 4) & 4095;
                            setToBlack(bArr, i, i2, i9);
                            r14 = i2 + i9;
                            updatePointer(4 - ((s7 >>> 1) & 7));
                        } else if (i7 != 15) {
                            setToBlack(bArr, i, i2, i8);
                            r14 = i2 + i8;
                            updatePointer(9 - i7);
                            if (s6 == 0) {
                                int[] iArr2 = this.currChangingElems;
                                int i10 = this.changingElemSize;
                                this.changingElemSize = i10 + 1;
                                iArr2[i10] = r14;
                            }
                        } else {
                            throw new IOException("TIFFFaxDecoder: EOL encountered in black run.");
                        }
                    } else if (i6 == 200) {
                        short s8 = TWO_BIT_BLACK[nextLesserThan8Bits(2)];
                        int i11 = (s8 >>> 5) & 2047;
                        setToBlack(bArr, i, i2, i11);
                        r14 = i2 + i11;
                        updatePointer(2 - ((s8 >>> 1) & 15));
                        int[] iArr3 = this.currChangingElems;
                        int i12 = this.changingElemSize;
                        this.changingElemSize = i12 + 1;
                        iArr3[i12] = r14;
                    } else {
                        setToBlack(bArr, i, i2, i6);
                        r14 = i2 + i6;
                        updatePointer(4 - i5);
                        int[] iArr4 = this.currChangingElems;
                        int i13 = this.changingElemSize;
                        this.changingElemSize = i13 + 1;
                        iArr4[i13] = r14;
                    }
                    z = true;
                }
                if (i2 == this.w) {
                    if (this.compression == 2) {
                        advancePointer();
                    }
                }
            } else if (this.compression == 2) {
                advancePointer();
            }
        }
        int[] iArr5 = this.currChangingElems;
        int i14 = this.changingElemSize;
        this.changingElemSize = i14 + 1;
        iArr5[i14] = i2;
    }

    public synchronized void decodeT6(byte[] bArr, byte[] bArr2, int i, int i2, long j, boolean z) throws IOException {
        int[] iArr;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        byte[] bArr3 = bArr;
        synchronized (this) {
            this.data = bArr2;
            this.compression = 4;
            int i6 = 0;
            this.bitPointer = 0;
            this.bytePointer = 0;
            byte b2 = 7;
            int i7 = (this.w + 7) / 8;
            int[] iArr2 = new int[2];
            int i8 = 1;
            this.uncompressedMode = (int) ((j & 2) >> 1);
            int[] iArr3 = this.currChangingElems;
            this.changingElemSize = 0;
            int i9 = 0 + 1;
            this.changingElemSize = i9;
            iArr3[0] = this.w;
            this.changingElemSize = i9 + 1;
            iArr3[i9] = this.w;
            int i10 = i2;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= i10) {
                    break;
                }
                if (z && this.bitPointer != 0) {
                    this.bitPointer = i3;
                    this.bytePointer += i8;
                }
                int i13 = -1;
                int[] iArr4 = this.prevChangingElems;
                this.prevChangingElems = this.currChangingElems;
                this.currChangingElems = iArr4;
                this.lastChangingElement = i3;
                int i14 = i;
                boolean z4 = true;
                int i15 = 0;
                while (i14 < this.w) {
                    getNextChangingElement(i13, z4, iArr);
                    int i16 = iArr[i3];
                    int i17 = iArr[i8];
                    byte b3 = TWO_DCODES[nextLesserThan8Bits(b2)] & 255;
                    int[] iArr5 = iArr;
                    int i18 = (b3 & 120) >>> 3;
                    byte b4 = b3 & b2;
                    if (i18 == 0) {
                        if (!z4) {
                            setToBlack(bArr3, i12, i14, i17 - i14);
                        }
                        updatePointer(7 - b4);
                        i13 = i17;
                        i14 = i13;
                        iArr = iArr5;
                        i3 = 0;
                    } else {
                        if (i18 == 1) {
                            updatePointer(7 - b4);
                            if (z4) {
                                int decodeWhiteCodeWord = i14 + decodeWhiteCodeWord();
                                int i19 = i15 + 1;
                                iArr4[i15] = decodeWhiteCodeWord;
                                int decodeBlackCodeWord = decodeBlackCodeWord();
                                setToBlack(bArr3, i12, decodeWhiteCodeWord, decodeBlackCodeWord);
                                i14 = decodeWhiteCodeWord + decodeBlackCodeWord;
                                i5 = i19 + 1;
                                iArr4[i19] = i14;
                            } else {
                                int decodeBlackCodeWord2 = decodeBlackCodeWord();
                                setToBlack(bArr3, i12, i14, decodeBlackCodeWord2);
                                int i20 = i14 + decodeBlackCodeWord2;
                                int i21 = i15 + 1;
                                iArr4[i15] = i20;
                                i14 = i20 + decodeWhiteCodeWord();
                                i5 = i21 + 1;
                                iArr4[i21] = i14;
                            }
                            i15 = i5;
                            i13 = i14;
                        } else if (i18 <= 8) {
                            i13 = (i18 - 5) + i16;
                            int i22 = i15 + 1;
                            iArr4[i15] = i13;
                            if (!z4) {
                                setToBlack(bArr3, i12, i14, i13 - i14);
                            }
                            z4 = !z4;
                            updatePointer(7 - b4);
                            i15 = i22;
                            i14 = i13;
                        } else if (i18 != 11) {
                            throw new IOException("TIFFFaxDecoder: Invalid code encountered while decoding 2D group 4 compressed data.");
                        } else if (nextLesserThan8Bits(3) == 7) {
                            boolean z5 = false;
                            int i23 = 0;
                            while (!z5) {
                                while (nextLesserThan8Bits(1) != 1) {
                                    i23++;
                                }
                                if (i23 > 5) {
                                    i23 -= 6;
                                    if (!z4 && i23 > 0) {
                                        iArr4[i15] = i14;
                                        i15++;
                                    }
                                    i14 += i23;
                                    if (i23 > 0) {
                                        z4 = true;
                                    }
                                    if (nextLesserThan8Bits(1) == 0) {
                                        if (!z4) {
                                            iArr4[i15] = i14;
                                            i15++;
                                        }
                                        z3 = true;
                                    } else {
                                        if (z4) {
                                            iArr4[i15] = i14;
                                            i15++;
                                        }
                                        z3 = false;
                                    }
                                    z4 = z3;
                                    z5 = true;
                                }
                                if (i23 == 5) {
                                    if (!z4) {
                                        iArr4[i15] = i14;
                                        i15++;
                                    }
                                    i4 = i14 + i23;
                                    z2 = true;
                                } else {
                                    int i24 = i14 + i23;
                                    iArr4[i15] = i24;
                                    setToBlack(bArr3, i12, i24, 1);
                                    i4 = i24 + 1;
                                    i15++;
                                    z2 = false;
                                }
                            }
                        } else {
                            throw new IOException("TIFFFaxDecoder: Invalid code encountered while decoding 2D group 4 compressed data.");
                        }
                        iArr = iArr5;
                        i3 = 0;
                        b2 = 7;
                    }
                    i8 = 1;
                }
                int[] iArr6 = iArr;
                if (iArr4.length == i15) {
                    break;
                }
                iArr4[i15] = i14;
                this.changingElemSize = i15 + 1;
                i12 += i7;
                i11++;
                iArr2 = iArr6;
                i6 = 0;
                b2 = 7;
            }
        }
    }
}
