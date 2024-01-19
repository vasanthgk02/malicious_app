package sfs2x.client.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import okio.Utf8;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

public class Base64 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final byte EQUALS_SIGN = 61;
    public static final byte EQUALS_SIGN_ENC = -1;
    public static final int GZIP = 2;
    public static final int MAX_LINE_LENGTH = 76;
    public static final byte NEW_LINE = 10;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final String PREFERRED_ENCODING = "US-ASCII";
    public static final int URL_SAFE = 16;
    public static final byte WHITE_SPACE_ENC = -5;
    public static final byte[] _ORDERED_ALPHABET = {45, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    public static final byte[] _ORDERED_DECODABET;
    public static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 43, 47};
    public static final byte[] _STANDARD_DECODABET;
    public static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, BaseParser.ASCII_ZERO, 49, 50, 51, 52, 53, 54, 55, 56, BaseParser.ASCII_NINE, 45, 95};
    public static final byte[] _URL_SAFE_DECODABET;

    public static class InputStream extends FilterInputStream {
        public boolean breakLines;
        public byte[] buffer;
        public int bufferLength;
        public byte[] decodabet;
        public boolean encode;
        public int lineLength;
        public int numSigBytes;
        public int options;
        public int position;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public int read() throws IOException {
            int read;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        int read2 = this.in.read();
                        if (read2 < 0) {
                            break;
                        }
                        bArr[i2] = (byte) read2;
                        i++;
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64.encode3to4(bArr, 0, i, this.buffer, 0, this.options);
                    this.position = 0;
                    this.numSigBytes = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.decodabet[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 == 4) {
                        this.numSigBytes = Base64.decode4to3(bArr2, 0, this.buffer, 0, this.options);
                        this.position = 0;
                    } else if (i3 == 0) {
                        return -1;
                    } else {
                        throw new IOException("Improperly padded Base64 input.");
                    }
                }
            }
            int i4 = this.position;
            if (i4 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            } else if (i4 >= this.numSigBytes) {
                return -1;
            } else {
                if (!this.encode || !this.breakLines || this.lineLength < 76) {
                    this.lineLength++;
                    byte[] bArr3 = this.buffer;
                    int i5 = this.position;
                    int i6 = i5 + 1;
                    this.position = i6;
                    byte b2 = bArr3[i5];
                    if (i6 >= this.bufferLength) {
                        this.position = -1;
                    }
                    return b2 & 255;
                }
                this.lineLength = 0;
                return 10;
            }
        }

        public InputStream(java.io.InputStream inputStream, int i) {
            super(inputStream);
            this.options = i;
            boolean z = true;
            this.breakLines = (i & 8) > 0;
            z = (i & 1) <= 0 ? false : z;
            this.encode = z;
            int i2 = z ? 4 : 3;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = -1;
            this.lineLength = 0;
            this.decodabet = Base64.getDecodabet(i);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class OutputStream extends FilterOutputStream {
        public byte[] b4;
        public boolean breakLines;
        public byte[] buffer;
        public int bufferLength;
        public byte[] decodabet;
        public boolean encode;
        public int lineLength;
        public int options;
        public int position;
        public boolean suspendEncoding;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }

        public void flushBase64() throws IOException {
            int i = this.position;
            if (i <= 0) {
                return;
            }
            if (this.encode) {
                this.out.write(Base64.encode3to4(this.b4, this.buffer, i, this.options));
                this.position = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        public void write(int i) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(i);
                return;
            }
            if (this.encode) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = this.bufferLength;
                if (i3 >= i4) {
                    this.out.write(Base64.encode3to4(this.b4, bArr, i4, this.options));
                    int i5 = this.lineLength + 4;
                    this.lineLength = i5;
                    if (this.breakLines && i5 >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else {
                byte[] bArr2 = this.decodabet;
                int i6 = i & 127;
                if (bArr2[i6] > -5) {
                    byte[] bArr3 = this.buffer;
                    int i7 = this.position;
                    int i8 = i7 + 1;
                    this.position = i8;
                    bArr3[i7] = (byte) i;
                    if (i8 >= this.bufferLength) {
                        this.out.write(this.b4, 0, Base64.decode4to3(bArr3, 0, this.b4, 0, this.options));
                        this.position = 0;
                    }
                } else if (bArr2[i6] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public OutputStream(java.io.OutputStream outputStream, int i) {
            super(outputStream);
            boolean z = true;
            this.breakLines = (i & 8) != 0;
            z = (i & 1) == 0 ? false : z;
            this.encode = z;
            int i2 = z ? 3 : 4;
            this.bufferLength = i2;
            this.buffer = new byte[i2];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = i;
            this.decodabet = Base64.getDecodabet(i);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.suspendEncoding) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = -9;
        bArr[1] = -9;
        bArr[2] = -9;
        bArr[3] = -9;
        bArr[4] = -9;
        bArr[5] = -9;
        bArr[6] = -9;
        bArr[7] = -9;
        bArr[8] = -9;
        bArr[9] = -5;
        bArr[10] = -5;
        bArr[11] = -9;
        bArr[12] = -9;
        bArr[13] = -5;
        bArr[14] = -9;
        bArr[15] = -9;
        bArr[16] = -9;
        bArr[17] = -9;
        bArr[18] = -9;
        bArr[19] = -9;
        bArr[20] = -9;
        bArr[21] = -9;
        bArr[22] = -9;
        bArr[23] = -9;
        bArr[24] = -9;
        bArr[25] = -9;
        bArr[26] = -9;
        bArr[27] = -9;
        bArr[28] = -9;
        bArr[29] = -9;
        bArr[30] = -9;
        bArr[31] = -9;
        bArr[32] = -5;
        bArr[33] = -9;
        bArr[34] = -9;
        bArr[35] = -9;
        bArr[36] = -9;
        bArr[37] = -9;
        bArr[38] = -9;
        bArr[39] = -9;
        bArr[40] = -9;
        bArr[41] = -9;
        bArr[42] = -9;
        bArr[43] = 62;
        bArr[44] = -9;
        bArr[45] = -9;
        bArr[46] = -9;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        bArr[48] = 52;
        bArr[49] = 53;
        bArr[50] = 54;
        bArr[51] = 55;
        bArr[52] = 56;
        bArr[53] = BaseParser.ASCII_NINE;
        bArr[54] = HttpCodecUtil.COLON;
        bArr[55] = HttpCodecUtil.SEMICOLON;
        bArr[56] = 60;
        bArr[57] = 61;
        bArr[58] = -9;
        bArr[59] = -9;
        bArr[60] = -9;
        bArr[61] = -1;
        bArr[62] = -9;
        bArr[63] = -9;
        bArr[64] = -9;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = MqttWireMessage.MESSAGE_TYPE_UNSUBACK;
        bArr[77] = MqttWireMessage.MESSAGE_TYPE_PINGREQ;
        bArr[78] = 13;
        bArr[79] = MqttWireMessage.MESSAGE_TYPE_DISCONNECT;
        bArr[80] = 15;
        bArr[81] = GlyfDescript.X_DUAL;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        bArr[91] = -9;
        bArr[92] = -9;
        bArr[93] = -9;
        bArr[94] = -9;
        bArr[95] = -9;
        bArr[96] = -9;
        bArr[97] = 26;
        bArr[98] = 27;
        bArr[99] = 28;
        bArr[100] = 29;
        bArr[101] = 30;
        bArr[102] = 31;
        bArr[103] = 32;
        bArr[104] = 33;
        bArr[105] = HttpCodecUtil.DOUBLE_QUOTE;
        bArr[106] = 35;
        bArr[107] = 36;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 43;
        bArr[115] = HttpCodecUtil.COMMA;
        bArr[116] = 45;
        bArr[117] = 46;
        bArr[118] = 47;
        bArr[119] = BaseParser.ASCII_ZERO;
        bArr[120] = 49;
        bArr[121] = 50;
        bArr[122] = 51;
        bArr[123] = -9;
        bArr[124] = -9;
        bArr[125] = -9;
        bArr[126] = -9;
        bArr[127] = -9;
        bArr[128] = -9;
        bArr[129] = -9;
        bArr[130] = -9;
        bArr[131] = -9;
        bArr[132] = -9;
        bArr[133] = -9;
        bArr[134] = -9;
        bArr[135] = -9;
        bArr[136] = -9;
        bArr[137] = -9;
        bArr[138] = -9;
        bArr[139] = -9;
        bArr[140] = -9;
        bArr[141] = -9;
        bArr[142] = -9;
        bArr[143] = -9;
        bArr[144] = -9;
        bArr[145] = -9;
        bArr[146] = -9;
        bArr[147] = -9;
        bArr[148] = -9;
        bArr[149] = -9;
        bArr[150] = -9;
        bArr[151] = -9;
        bArr[152] = -9;
        bArr[153] = -9;
        bArr[154] = -9;
        bArr[155] = -9;
        bArr[156] = -9;
        bArr[157] = -9;
        bArr[158] = -9;
        bArr[159] = -9;
        bArr[160] = -9;
        bArr[161] = -9;
        bArr[162] = -9;
        bArr[163] = -9;
        bArr[164] = -9;
        bArr[165] = -9;
        bArr[166] = -9;
        bArr[167] = -9;
        bArr[168] = -9;
        bArr[169] = -9;
        bArr[170] = -9;
        bArr[171] = -9;
        bArr[172] = -9;
        bArr[173] = -9;
        bArr[174] = -9;
        bArr[175] = -9;
        bArr[176] = -9;
        bArr[177] = -9;
        bArr[178] = -9;
        bArr[179] = -9;
        bArr[180] = -9;
        bArr[181] = -9;
        bArr[182] = -9;
        bArr[183] = -9;
        bArr[184] = -9;
        bArr[185] = -9;
        bArr[186] = -9;
        bArr[187] = -9;
        bArr[188] = -9;
        bArr[189] = -9;
        bArr[190] = -9;
        bArr[191] = -9;
        bArr[192] = -9;
        bArr[193] = -9;
        bArr[194] = -9;
        bArr[195] = -9;
        bArr[196] = -9;
        bArr[197] = -9;
        bArr[198] = -9;
        bArr[199] = -9;
        bArr[200] = -9;
        bArr[201] = -9;
        bArr[202] = -9;
        bArr[203] = -9;
        bArr[204] = -9;
        bArr[205] = -9;
        bArr[206] = -9;
        bArr[207] = -9;
        bArr[208] = -9;
        bArr[209] = -9;
        bArr[210] = -9;
        bArr[211] = -9;
        bArr[212] = -9;
        bArr[213] = -9;
        bArr[214] = -9;
        bArr[215] = -9;
        bArr[216] = -9;
        bArr[217] = -9;
        bArr[218] = -9;
        bArr[219] = -9;
        bArr[220] = -9;
        bArr[221] = -9;
        bArr[222] = -9;
        bArr[223] = -9;
        bArr[224] = -9;
        bArr[225] = -9;
        bArr[226] = -9;
        bArr[227] = -9;
        bArr[228] = -9;
        bArr[229] = -9;
        bArr[230] = -9;
        bArr[231] = -9;
        bArr[232] = -9;
        bArr[233] = -9;
        bArr[234] = -9;
        bArr[235] = -9;
        bArr[236] = -9;
        bArr[237] = -9;
        bArr[238] = -9;
        bArr[239] = -9;
        bArr[240] = -9;
        bArr[241] = -9;
        bArr[242] = -9;
        bArr[243] = -9;
        bArr[244] = -9;
        bArr[245] = -9;
        bArr[246] = -9;
        bArr[247] = -9;
        bArr[248] = -9;
        bArr[249] = -9;
        bArr[250] = -9;
        bArr[251] = -9;
        bArr[252] = -9;
        bArr[253] = -9;
        bArr[254] = -9;
        bArr[255] = -9;
        _STANDARD_DECODABET = bArr;
        byte[] bArr2 = new byte[256];
        bArr2[0] = -9;
        bArr2[1] = -9;
        bArr2[2] = -9;
        bArr2[3] = -9;
        bArr2[4] = -9;
        bArr2[5] = -9;
        bArr2[6] = -9;
        bArr2[7] = -9;
        bArr2[8] = -9;
        bArr2[9] = -5;
        bArr2[10] = -5;
        bArr2[11] = -9;
        bArr2[12] = -9;
        bArr2[13] = -5;
        bArr2[14] = -9;
        bArr2[15] = -9;
        bArr2[16] = -9;
        bArr2[17] = -9;
        bArr2[18] = -9;
        bArr2[19] = -9;
        bArr2[20] = -9;
        bArr2[21] = -9;
        bArr2[22] = -9;
        bArr2[23] = -9;
        bArr2[24] = -9;
        bArr2[25] = -9;
        bArr2[26] = -9;
        bArr2[27] = -9;
        bArr2[28] = -9;
        bArr2[29] = -9;
        bArr2[30] = -9;
        bArr2[31] = -9;
        bArr2[32] = -5;
        bArr2[33] = -9;
        bArr2[34] = -9;
        bArr2[35] = -9;
        bArr2[36] = -9;
        bArr2[37] = -9;
        bArr2[38] = -9;
        bArr2[39] = -9;
        bArr2[40] = -9;
        bArr2[41] = -9;
        bArr2[42] = -9;
        bArr2[43] = -9;
        bArr2[44] = -9;
        bArr2[45] = 62;
        bArr2[46] = -9;
        bArr2[47] = -9;
        bArr2[48] = 52;
        bArr2[49] = 53;
        bArr2[50] = 54;
        bArr2[51] = 55;
        bArr2[52] = 56;
        bArr2[53] = BaseParser.ASCII_NINE;
        bArr2[54] = HttpCodecUtil.COLON;
        bArr2[55] = HttpCodecUtil.SEMICOLON;
        bArr2[56] = 60;
        bArr2[57] = 61;
        bArr2[58] = -9;
        bArr2[59] = -9;
        bArr2[60] = -9;
        bArr2[61] = -1;
        bArr2[62] = -9;
        bArr2[63] = -9;
        bArr2[64] = -9;
        bArr2[66] = 1;
        bArr2[67] = 2;
        bArr2[68] = 3;
        bArr2[69] = 4;
        bArr2[70] = 5;
        bArr2[71] = 6;
        bArr2[72] = 7;
        bArr2[73] = 8;
        bArr2[74] = 9;
        bArr2[75] = 10;
        bArr2[76] = MqttWireMessage.MESSAGE_TYPE_UNSUBACK;
        bArr2[77] = MqttWireMessage.MESSAGE_TYPE_PINGREQ;
        bArr2[78] = 13;
        bArr2[79] = MqttWireMessage.MESSAGE_TYPE_DISCONNECT;
        bArr2[80] = 15;
        bArr2[81] = GlyfDescript.X_DUAL;
        bArr2[82] = 17;
        bArr2[83] = 18;
        bArr2[84] = 19;
        bArr2[85] = 20;
        bArr2[86] = 21;
        bArr2[87] = 22;
        bArr2[88] = 23;
        bArr2[89] = 24;
        bArr2[90] = 25;
        bArr2[91] = -9;
        bArr2[92] = -9;
        bArr2[93] = -9;
        bArr2[94] = -9;
        bArr2[95] = Utf8.REPLACEMENT_BYTE;
        bArr2[96] = -9;
        bArr2[97] = 26;
        bArr2[98] = 27;
        bArr2[99] = 28;
        bArr2[100] = 29;
        bArr2[101] = 30;
        bArr2[102] = 31;
        bArr2[103] = 32;
        bArr2[104] = 33;
        bArr2[105] = HttpCodecUtil.DOUBLE_QUOTE;
        bArr2[106] = 35;
        bArr2[107] = 36;
        bArr2[108] = 37;
        bArr2[109] = 38;
        bArr2[110] = 39;
        bArr2[111] = 40;
        bArr2[112] = 41;
        bArr2[113] = 42;
        bArr2[114] = 43;
        bArr2[115] = HttpCodecUtil.COMMA;
        bArr2[116] = 45;
        bArr2[117] = 46;
        bArr2[118] = 47;
        bArr2[119] = BaseParser.ASCII_ZERO;
        bArr2[120] = 49;
        bArr2[121] = 50;
        bArr2[122] = 51;
        bArr2[123] = -9;
        bArr2[124] = -9;
        bArr2[125] = -9;
        bArr2[126] = -9;
        bArr2[127] = -9;
        bArr2[128] = -9;
        bArr2[129] = -9;
        bArr2[130] = -9;
        bArr2[131] = -9;
        bArr2[132] = -9;
        bArr2[133] = -9;
        bArr2[134] = -9;
        bArr2[135] = -9;
        bArr2[136] = -9;
        bArr2[137] = -9;
        bArr2[138] = -9;
        bArr2[139] = -9;
        bArr2[140] = -9;
        bArr2[141] = -9;
        bArr2[142] = -9;
        bArr2[143] = -9;
        bArr2[144] = -9;
        bArr2[145] = -9;
        bArr2[146] = -9;
        bArr2[147] = -9;
        bArr2[148] = -9;
        bArr2[149] = -9;
        bArr2[150] = -9;
        bArr2[151] = -9;
        bArr2[152] = -9;
        bArr2[153] = -9;
        bArr2[154] = -9;
        bArr2[155] = -9;
        bArr2[156] = -9;
        bArr2[157] = -9;
        bArr2[158] = -9;
        bArr2[159] = -9;
        bArr2[160] = -9;
        bArr2[161] = -9;
        bArr2[162] = -9;
        bArr2[163] = -9;
        bArr2[164] = -9;
        bArr2[165] = -9;
        bArr2[166] = -9;
        bArr2[167] = -9;
        bArr2[168] = -9;
        bArr2[169] = -9;
        bArr2[170] = -9;
        bArr2[171] = -9;
        bArr2[172] = -9;
        bArr2[173] = -9;
        bArr2[174] = -9;
        bArr2[175] = -9;
        bArr2[176] = -9;
        bArr2[177] = -9;
        bArr2[178] = -9;
        bArr2[179] = -9;
        bArr2[180] = -9;
        bArr2[181] = -9;
        bArr2[182] = -9;
        bArr2[183] = -9;
        bArr2[184] = -9;
        bArr2[185] = -9;
        bArr2[186] = -9;
        bArr2[187] = -9;
        bArr2[188] = -9;
        bArr2[189] = -9;
        bArr2[190] = -9;
        bArr2[191] = -9;
        bArr2[192] = -9;
        bArr2[193] = -9;
        bArr2[194] = -9;
        bArr2[195] = -9;
        bArr2[196] = -9;
        bArr2[197] = -9;
        bArr2[198] = -9;
        bArr2[199] = -9;
        bArr2[200] = -9;
        bArr2[201] = -9;
        bArr2[202] = -9;
        bArr2[203] = -9;
        bArr2[204] = -9;
        bArr2[205] = -9;
        bArr2[206] = -9;
        bArr2[207] = -9;
        bArr2[208] = -9;
        bArr2[209] = -9;
        bArr2[210] = -9;
        bArr2[211] = -9;
        bArr2[212] = -9;
        bArr2[213] = -9;
        bArr2[214] = -9;
        bArr2[215] = -9;
        bArr2[216] = -9;
        bArr2[217] = -9;
        bArr2[218] = -9;
        bArr2[219] = -9;
        bArr2[220] = -9;
        bArr2[221] = -9;
        bArr2[222] = -9;
        bArr2[223] = -9;
        bArr2[224] = -9;
        bArr2[225] = -9;
        bArr2[226] = -9;
        bArr2[227] = -9;
        bArr2[228] = -9;
        bArr2[229] = -9;
        bArr2[230] = -9;
        bArr2[231] = -9;
        bArr2[232] = -9;
        bArr2[233] = -9;
        bArr2[234] = -9;
        bArr2[235] = -9;
        bArr2[236] = -9;
        bArr2[237] = -9;
        bArr2[238] = -9;
        bArr2[239] = -9;
        bArr2[240] = -9;
        bArr2[241] = -9;
        bArr2[242] = -9;
        bArr2[243] = -9;
        bArr2[244] = -9;
        bArr2[245] = -9;
        bArr2[246] = -9;
        bArr2[247] = -9;
        bArr2[248] = -9;
        bArr2[249] = -9;
        bArr2[250] = -9;
        bArr2[251] = -9;
        bArr2[252] = -9;
        bArr2[253] = -9;
        bArr2[254] = -9;
        bArr2[255] = -9;
        _URL_SAFE_DECODABET = bArr2;
        byte[] bArr3 = new byte[FTPReply.PATHNAME_CREATED];
        bArr3[0] = -9;
        bArr3[1] = -9;
        bArr3[2] = -9;
        bArr3[3] = -9;
        bArr3[4] = -9;
        bArr3[5] = -9;
        bArr3[6] = -9;
        bArr3[7] = -9;
        bArr3[8] = -9;
        bArr3[9] = -5;
        bArr3[10] = -5;
        bArr3[11] = -9;
        bArr3[12] = -9;
        bArr3[13] = -5;
        bArr3[14] = -9;
        bArr3[15] = -9;
        bArr3[16] = -9;
        bArr3[17] = -9;
        bArr3[18] = -9;
        bArr3[19] = -9;
        bArr3[20] = -9;
        bArr3[21] = -9;
        bArr3[22] = -9;
        bArr3[23] = -9;
        bArr3[24] = -9;
        bArr3[25] = -9;
        bArr3[26] = -9;
        bArr3[27] = -9;
        bArr3[28] = -9;
        bArr3[29] = -9;
        bArr3[30] = -9;
        bArr3[31] = -9;
        bArr3[32] = -5;
        bArr3[33] = -9;
        bArr3[34] = -9;
        bArr3[35] = -9;
        bArr3[36] = -9;
        bArr3[37] = -9;
        bArr3[38] = -9;
        bArr3[39] = -9;
        bArr3[40] = -9;
        bArr3[41] = -9;
        bArr3[42] = -9;
        bArr3[43] = -9;
        bArr3[44] = -9;
        bArr3[46] = -9;
        bArr3[47] = -9;
        bArr3[48] = 1;
        bArr3[49] = 2;
        bArr3[50] = 3;
        bArr3[51] = 4;
        bArr3[52] = 5;
        bArr3[53] = 6;
        bArr3[54] = 7;
        bArr3[55] = 8;
        bArr3[56] = 9;
        bArr3[57] = 10;
        bArr3[58] = -9;
        bArr3[59] = -9;
        bArr3[60] = -9;
        bArr3[61] = -1;
        bArr3[62] = -9;
        bArr3[63] = -9;
        bArr3[64] = -9;
        bArr3[65] = MqttWireMessage.MESSAGE_TYPE_UNSUBACK;
        bArr3[66] = MqttWireMessage.MESSAGE_TYPE_PINGREQ;
        bArr3[67] = 13;
        bArr3[68] = MqttWireMessage.MESSAGE_TYPE_DISCONNECT;
        bArr3[69] = 15;
        bArr3[70] = GlyfDescript.X_DUAL;
        bArr3[71] = 17;
        bArr3[72] = 18;
        bArr3[73] = 19;
        bArr3[74] = 20;
        bArr3[75] = 21;
        bArr3[76] = 22;
        bArr3[77] = 23;
        bArr3[78] = 24;
        bArr3[79] = 25;
        bArr3[80] = 26;
        bArr3[81] = 27;
        bArr3[82] = 28;
        bArr3[83] = 29;
        bArr3[84] = 30;
        bArr3[85] = 31;
        bArr3[86] = 32;
        bArr3[87] = 33;
        bArr3[88] = HttpCodecUtil.DOUBLE_QUOTE;
        bArr3[89] = 35;
        bArr3[90] = 36;
        bArr3[91] = -9;
        bArr3[92] = -9;
        bArr3[93] = -9;
        bArr3[94] = -9;
        bArr3[95] = 37;
        bArr3[96] = -9;
        bArr3[97] = 38;
        bArr3[98] = 39;
        bArr3[99] = 40;
        bArr3[100] = 41;
        bArr3[101] = 42;
        bArr3[102] = 43;
        bArr3[103] = HttpCodecUtil.COMMA;
        bArr3[104] = 45;
        bArr3[105] = 46;
        bArr3[106] = 47;
        bArr3[107] = BaseParser.ASCII_ZERO;
        bArr3[108] = 49;
        bArr3[109] = 50;
        bArr3[110] = 51;
        bArr3[111] = 52;
        bArr3[112] = 53;
        bArr3[113] = 54;
        bArr3[114] = 55;
        bArr3[115] = 56;
        bArr3[116] = BaseParser.ASCII_NINE;
        bArr3[117] = HttpCodecUtil.COLON;
        bArr3[118] = HttpCodecUtil.SEMICOLON;
        bArr3[119] = 60;
        bArr3[120] = 61;
        bArr3[121] = 62;
        bArr3[122] = Utf8.REPLACEMENT_BYTE;
        bArr3[123] = -9;
        bArr3[124] = -9;
        bArr3[125] = -9;
        bArr3[126] = -9;
        bArr3[127] = -9;
        bArr3[128] = -9;
        bArr3[129] = -9;
        bArr3[130] = -9;
        bArr3[131] = -9;
        bArr3[132] = -9;
        bArr3[133] = -9;
        bArr3[134] = -9;
        bArr3[135] = -9;
        bArr3[136] = -9;
        bArr3[137] = -9;
        bArr3[138] = -9;
        bArr3[139] = -9;
        bArr3[140] = -9;
        bArr3[141] = -9;
        bArr3[142] = -9;
        bArr3[143] = -9;
        bArr3[144] = -9;
        bArr3[145] = -9;
        bArr3[146] = -9;
        bArr3[147] = -9;
        bArr3[148] = -9;
        bArr3[149] = -9;
        bArr3[150] = -9;
        bArr3[151] = -9;
        bArr3[152] = -9;
        bArr3[153] = -9;
        bArr3[154] = -9;
        bArr3[155] = -9;
        bArr3[156] = -9;
        bArr3[157] = -9;
        bArr3[158] = -9;
        bArr3[159] = -9;
        bArr3[160] = -9;
        bArr3[161] = -9;
        bArr3[162] = -9;
        bArr3[163] = -9;
        bArr3[164] = -9;
        bArr3[165] = -9;
        bArr3[166] = -9;
        bArr3[167] = -9;
        bArr3[168] = -9;
        bArr3[169] = -9;
        bArr3[170] = -9;
        bArr3[171] = -9;
        bArr3[172] = -9;
        bArr3[173] = -9;
        bArr3[174] = -9;
        bArr3[175] = -9;
        bArr3[176] = -9;
        bArr3[177] = -9;
        bArr3[178] = -9;
        bArr3[179] = -9;
        bArr3[180] = -9;
        bArr3[181] = -9;
        bArr3[182] = -9;
        bArr3[183] = -9;
        bArr3[184] = -9;
        bArr3[185] = -9;
        bArr3[186] = -9;
        bArr3[187] = -9;
        bArr3[188] = -9;
        bArr3[189] = -9;
        bArr3[190] = -9;
        bArr3[191] = -9;
        bArr3[192] = -9;
        bArr3[193] = -9;
        bArr3[194] = -9;
        bArr3[195] = -9;
        bArr3[196] = -9;
        bArr3[197] = -9;
        bArr3[198] = -9;
        bArr3[199] = -9;
        bArr3[200] = -9;
        bArr3[201] = -9;
        bArr3[202] = -9;
        bArr3[203] = -9;
        bArr3[204] = -9;
        bArr3[205] = -9;
        bArr3[206] = -9;
        bArr3[207] = -9;
        bArr3[208] = -9;
        bArr3[209] = -9;
        bArr3[210] = -9;
        bArr3[211] = -9;
        bArr3[212] = -9;
        bArr3[213] = -9;
        bArr3[214] = -9;
        bArr3[215] = -9;
        bArr3[216] = -9;
        bArr3[217] = -9;
        bArr3[218] = -9;
        bArr3[219] = -9;
        bArr3[220] = -9;
        bArr3[221] = -9;
        bArr3[222] = -9;
        bArr3[223] = -9;
        bArr3[224] = -9;
        bArr3[225] = -9;
        bArr3[226] = -9;
        bArr3[227] = -9;
        bArr3[228] = -9;
        bArr3[229] = -9;
        bArr3[230] = -9;
        bArr3[231] = -9;
        bArr3[232] = -9;
        bArr3[233] = -9;
        bArr3[234] = -9;
        bArr3[235] = -9;
        bArr3[236] = -9;
        bArr3[237] = -9;
        bArr3[238] = -9;
        bArr3[239] = -9;
        bArr3[240] = -9;
        bArr3[241] = -9;
        bArr3[242] = -9;
        bArr3[243] = -9;
        bArr3[244] = -9;
        bArr3[245] = -9;
        bArr3[246] = -9;
        bArr3[247] = -9;
        bArr3[248] = -9;
        bArr3[249] = -9;
        bArr3[250] = -9;
        bArr3[251] = -9;
        bArr3[252] = -9;
        bArr3[253] = -9;
        bArr3[254] = -9;
        bArr3[255] = -9;
        bArr3[256] = -9;
        _ORDERED_DECODABET = bArr3;
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
    }

    public static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 != null) {
            if (i >= 0) {
                int i4 = i + 3;
                if (i4 < bArr.length) {
                    if (i2 >= 0) {
                        int i5 = i2 + 2;
                        if (i5 < bArr2.length) {
                            byte[] decodabet = getDecodabet(i3);
                            int i6 = i + 2;
                            if (bArr[i6] == 61) {
                                bArr2[i2] = (byte) ((((decodabet[bArr[i + 1]] & 255) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i4] == 61) {
                                int i7 = (decodabet[bArr[i + 1]] & 255) << MqttWireMessage.MESSAGE_TYPE_PINGREQ;
                                int i8 = ((decodabet[bArr[i6]] & 255) << 6) | i7 | ((decodabet[bArr[i]] & 255) << 18);
                                bArr2[i2] = (byte) (i8 >>> 16);
                                bArr2[i2 + 1] = (byte) (i8 >>> 8);
                                return 2;
                            } else {
                                int i9 = (decodabet[bArr[i + 1]] & 255) << MqttWireMessage.MESSAGE_TYPE_PINGREQ;
                                byte b2 = (decodabet[bArr[i4]] & 255) | i9 | ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i6]] & 255) << 6);
                                bArr2[i2] = (byte) (b2 >> GlyfDescript.X_DUAL);
                                bArr2[i2 + 1] = (byte) (b2 >> 8);
                                bArr2[i5] = (byte) b2;
                                return 3;
                            }
                        }
                    }
                    throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i2)}));
                }
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)}));
        } else {
            throw new NullPointerException("Destination array was null.");
        }
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        byte[] decodeFromFile = decodeFromFile(str);
        java.io.OutputStream outputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream.write(decodeFromFile);
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = bufferedOutputStream;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = bufferedOutputStream;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        InputStream inputStream = null;
        try {
            File file = new File(str);
            if (file.length() <= 2147483647L) {
                byte[] bArr = new byte[((int) file.length())];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i, 4096);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            }
            throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("US-ASCII"));
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        return decodeToObject(str, 0, null);
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            encode3to4(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i, int i2) {
        encode3to4(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    public static String encodeBytes(byte[] bArr) {
        try {
            return encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static void encodeFileToFile(String str, String str2) throws IOException {
        String encodeFromFile = encodeFromFile(str);
        java.io.OutputStream outputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = bufferedOutputStream;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = bufferedOutputStream;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        InputStream inputStream = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((((double) file.length()) * 1.4d) + 1.0d), 40)];
            InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            int i = 0;
            while (true) {
                try {
                    int read = inputStream2.read(bArr, i, 4096);
                    if (read < 0) {
                        break;
                    }
                    i += read;
                } catch (IOException e2) {
                    e = e2;
                    inputStream = inputStream2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i, "US-ASCII");
            try {
                inputStream2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        return encodeObject(serializable, 0);
    }

    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        if (bArr != null) {
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = new OutputStream(new FileOutputStream(str), 1);
                try {
                    outputStream2.write(bArr);
                    try {
                        outputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    e = e2;
                    outputStream = outputStream2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    try {
                        outputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }

    public static final byte[] getAlphabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_ALPHABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_ALPHABET;
        }
        return _STANDARD_ALPHABET;
    }

    public static final byte[] getDecodabet(int i) {
        if ((i & 16) == 16) {
            return _URL_SAFE_DECODABET;
        }
        if ((i & 32) == 32) {
            return _ORDERED_DECODABET;
        }
        return _STANDARD_DECODABET;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) throws IOException {
        if (bArr != null) {
            if (i >= 0) {
                int i4 = i + i2;
                if (i4 <= bArr.length) {
                    if (i2 == 0) {
                        return new byte[0];
                    }
                    if (i2 >= 4) {
                        byte[] decodabet = getDecodabet(i3);
                        byte[] bArr2 = new byte[((i2 * 3) / 4)];
                        byte[] bArr3 = new byte[4];
                        int i5 = 0;
                        int i6 = 0;
                        while (i < i4) {
                            byte b2 = decodabet[bArr[i] & 255];
                            if (b2 >= -5) {
                                if (b2 >= -1) {
                                    int i7 = i5 + 1;
                                    bArr3[i5] = bArr[i];
                                    if (i7 > 3) {
                                        i6 += decode4to3(bArr3, 0, bArr2, i6, i3);
                                        if (bArr[i] == 61) {
                                            break;
                                        }
                                        i5 = 0;
                                    } else {
                                        i5 = i7;
                                    }
                                }
                                i++;
                            } else {
                                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)}));
                            }
                        }
                        byte[] bArr4 = new byte[i6];
                        System.arraycopy(bArr2, 0, bArr4, 0, i6);
                        return bArr4;
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline40("Base64-encoded string must have at least four characters, but length specified was ", i2));
                }
            }
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        throw new NullPointerException("Cannot decode null source array.");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.ClassLoader] */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|30|31|32|33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|(2:4|5)(1:6)|7|8|9|10|11|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x003c */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v2
      assigns: []
      uses: []
      mth insns count: 35
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object decodeToObject(java.lang.String r1, int r2, final java.lang.ClassLoader r3) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            byte[] r1 = decode(r1, r2)
            r2 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0035, ClassNotFoundException -> 0x0032, all -> 0x002f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0035, ClassNotFoundException -> 0x0032, all -> 0x002f }
            if (r3 != 0) goto L_0x0012
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            goto L_0x0017
        L_0x0012:
            sfs2x.client.util.Base64$1 r1 = new sfs2x.client.util.Base64$1     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            r1.<init>(r0, r3)     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
        L_0x0017:
            r2 = r1
            java.lang.Object r1 = r2.readObject()     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            r0.close()     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            r2.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            return r1
        L_0x0023:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0039
        L_0x0027:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0034
        L_0x002b:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0037
        L_0x002f:
            r1 = move-exception
            r3 = r2
            goto L_0x0039
        L_0x0032:
            r1 = move-exception
            r3 = r2
        L_0x0034:
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0035:
            r1 = move-exception
            r3 = r2
        L_0x0037:
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            r2.close()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            r3.close()     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.Base64.decodeToObject(java.lang.String, int, java.lang.ClassLoader):java.lang.Object");
    }

    public static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] alphabet = getAlphabet(i4);
        int i5 = 0;
        int i6 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i5 = (bArr[i + 2] << 24) >>> 24;
        }
        int i7 = i6 | i5;
        if (i2 == 1) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = alphabet[i7 >>> 18];
            bArr2[i3 + 1] = alphabet[(i7 >>> 12) & 63];
            bArr2[i3 + 2] = alphabet[(i7 >>> 6) & 63];
            bArr2[i3 + 3] = alphabet[i7 & 63];
            return bArr2;
        }
    }

    public static String encodeBytes(byte[] bArr, int i) throws IOException {
        return encodeBytes(bArr, 0, bArr.length, i);
    }

    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r3v6, types: [sfs2x.client.util.Base64$OutputStream] */
    /* JADX WARNING: type inference failed for: r2v13, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v24, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r2v19, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11, types: [java.io.OutputStream, sfs2x.client.util.Base64$OutputStream] */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:32|33|46|47|48|49|50|51|52) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0064 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v7
      assigns: []
      uses: []
      mth insns count: 140
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 17 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encodeBytesToBytes(byte[] r19, int r20, int r21, int r22) throws java.io.IOException {
        /*
            r0 = r19
            r7 = r20
            r8 = r21
            if (r0 == 0) goto L_0x0112
            if (r7 < 0) goto L_0x0106
            if (r8 < 0) goto L_0x00fa
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            r10 = 0
            if (r1 > r2) goto L_0x00d7
            r1 = r22 & 2
            if (r1 == 0) goto L_0x0068
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0056, all -> 0x0052 }
            r2.<init>()     // Catch:{ IOException -> 0x0056, all -> 0x0052 }
            sfs2x.client.util.Base64$OutputStream r3 = new sfs2x.client.util.Base64$OutputStream     // Catch:{ IOException -> 0x004a, all -> 0x0047 }
            r4 = r22 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x004a, all -> 0x0047 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0043, all -> 0x0041 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r4.close()     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r4.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            r3.close()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r2.close()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003d:
            r0 = move-exception
            goto L_0x005d
        L_0x003f:
            r0 = move-exception
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            goto L_0x005e
        L_0x0043:
            r0 = move-exception
            r4 = r1
        L_0x0045:
            r1 = r3
            goto L_0x004c
        L_0x0047:
            r0 = move-exception
            r3 = r1
            goto L_0x005e
        L_0x004a:
            r0 = move-exception
            r4 = r1
        L_0x004c:
            r18 = r2
            r2 = r1
            r1 = r18
            goto L_0x0059
        L_0x0052:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x005e
        L_0x0056:
            r0 = move-exception
            r2 = r1
            r4 = r2
        L_0x0059:
            throw r0     // Catch:{ all -> 0x005a }
        L_0x005a:
            r0 = move-exception
            r3 = r2
            r2 = r1
        L_0x005d:
            r1 = r4
        L_0x005e:
            r1.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            r3.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            r2.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            throw r0
        L_0x0068:
            r1 = r22 & 8
            if (r1 == 0) goto L_0x006f
            r1 = 1
            r11 = 1
            goto L_0x0071
        L_0x006f:
            r1 = 0
            r11 = 0
        L_0x0071:
            int r1 = r8 / 3
            int r1 = r1 * 4
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x007b
            r2 = 4
            goto L_0x007c
        L_0x007b:
            r2 = 0
        L_0x007c:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x0082
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x0082:
            r12 = r1
            byte[] r13 = new byte[r12]
            int r14 = r8 + -2
            r1 = 0
            r2 = 0
            r3 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x008f:
            if (r15 < r14) goto L_0x00af
            if (r15 >= r8) goto L_0x00a3
            int r2 = r15 + r7
            int r3 = r8 - r15
            r1 = r19
            r4 = r13
            r5 = r16
            r6 = r22
            encode3to4(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00a3:
            r0 = r16
            int r12 = r12 - r9
            if (r0 > r12) goto L_0x00ae
            byte[] r1 = new byte[r0]
            java.lang.System.arraycopy(r13, r10, r1, r10, r0)
            return r1
        L_0x00ae:
            return r13
        L_0x00af:
            int r2 = r15 + r7
            r3 = 3
            r1 = r19
            r4 = r13
            r5 = r16
            r6 = r22
            encode3to4(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00d0
            r2 = 76
            if (r1 < r2) goto L_0x00d0
            int r1 = r16 + 4
            r2 = 10
            r13[r1] = r2
            int r16 = r16 + 1
            r1 = 0
            r17 = 0
            goto L_0x00d2
        L_0x00d0:
            r17 = r1
        L_0x00d2:
            int r15 = r15 + 3
            int r16 = r16 + 4
            goto L_0x008f
        L_0x00d7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r20)
            r2[r10] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            r2[r9] = r3
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3 = 2
            r2[r3] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x00fa:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot have length offset: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline40(r1, r8)
            r0.<init>(r1)
            throw r0
        L_0x0106:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot have negative offset: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline40(r1, r7)
            r0.<init>(r1)
            throw r0
        L_0x0112:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.Base64.encodeBytesToBytes(byte[], int, int, int):byte[]");
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.ObjectOutputStream] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.ObjectOutputStream] */
    /* JADX WARNING: type inference failed for: r6v14, types: [java.io.ObjectOutputStream] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.ObjectOutputStream] */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:13|51|52|53|54|55|56|57|58|59) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:4|5|6|(5:8|9|10|11|12)(3:16|17|18)|19|20|21|22|23|24|25|26|27|28|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:2|3|4|5|6|(5:8|9|10|11|12)(3:16|17|18)|19|20|21|22|23|24|25|26|27|28|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
        return new java.lang.String(r1.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x007d */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v11
      assigns: []
      uses: []
      mth insns count: 79
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 12 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encodeObject(java.io.Serializable r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0081
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r1.<init>()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            sfs2x.client.util.Base64$OutputStream r2 = new sfs2x.client.util.Base64$OutputStream     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r3 = r6 | 1
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r6 = r6 & 2
            if (r6 == 0) goto L_0x0027
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0 = r3
            goto L_0x002f
        L_0x001f:
            r5 = move-exception
            goto L_0x0074
        L_0x0022:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x006f
        L_0x0027:
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x002f:
            r0.writeObject(r5)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.close()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r6.close()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r2.close()     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            r1.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x004a }
            byte[] r6 = r1.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x004a }
            java.lang.String r0 = "US-ASCII"
            r5.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x004a }
            return r5
        L_0x004a:
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r1.toByteArray()
            r5.<init>(r6)
            return r5
        L_0x0054:
            r5 = move-exception
            r6 = r0
            goto L_0x0074
        L_0x0057:
            r5 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x006f
        L_0x005c:
            r5 = move-exception
            r6 = r0
            r2 = r6
            goto L_0x0074
        L_0x0060:
            r5 = move-exception
            r6 = r0
            r2 = r6
            r0 = r1
            r1 = r2
            goto L_0x006f
        L_0x0066:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
            goto L_0x0074
        L_0x006b:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
        L_0x006f:
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0074:
            r0.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r6.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            r2.close()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            r1.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            throw r5
        L_0x0081:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Cannot serialize a null object."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.Base64.encodeObject(java.io.Serializable, int):java.lang.String");
    }

    public static String encodeBytes(byte[] bArr, int i, int i2) {
        try {
            return encodeBytes(bArr, i, i2, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr, int i, int i2, int i3) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2, i3);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(encodeBytesToBytes);
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            encode3to4(bArr2, bArr, min, 0);
            for (int i = 0; i < 4; i++) {
                charBuffer.put((char) (bArr2[i] & 255));
            }
        }
    }

    public static byte[] decode(String str) throws IOException {
        return decode(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:16|17|18|19|20|(6:21|22|(3:23|24|(1:68)(2:33|34))|26|27|28)|29|30|31|32) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:55|56|57|58|59|60|61|62) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x0089 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decode(java.lang.String r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x008e
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0009 }
            goto L_0x000d
        L_0x0009:
            byte[] r5 = r5.getBytes()
        L_0x000d:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = decode(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L_0x001a
            r6 = 1
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            if (r5 == 0) goto L_0x008d
            int r3 = r5.length
            if (r3 < r0) goto L_0x008d
            if (r6 != 0) goto L_0x008d
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x008d
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            r2.<init>()     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            r3.<init>(r5)     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        L_0x0048:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            if (r0 >= 0) goto L_0x005c
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            r2.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            r4.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            r3.close()     // Catch:{ Exception -> 0x008d }
            goto L_0x008d
        L_0x005c:
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            goto L_0x0048
        L_0x0060:
            r5 = move-exception
            goto L_0x006d
        L_0x0062:
            r6 = move-exception
            goto L_0x0072
        L_0x0064:
            r5 = move-exception
            r4 = r0
            goto L_0x006d
        L_0x0067:
            r6 = move-exception
            r4 = r0
            goto L_0x0072
        L_0x006a:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L_0x006d:
            r0 = r2
            goto L_0x0083
        L_0x006f:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x0072:
            r0 = r2
            goto L_0x007b
        L_0x0074:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0083
        L_0x0078:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x007b:
            r6.printStackTrace()     // Catch:{ all -> 0x0082 }
            r0.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0055
        L_0x0082:
            r5 = move-exception
        L_0x0083:
            r0.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            r4.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            r3.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            throw r5
        L_0x008d:
            return r5
        L_0x008e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sfs2x.client.util.Base64.decode(java.lang.String, int):byte[]");
    }
}
