package org.spongycastle.crypto.digests;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.ttf.GlyfDescript;

public class MD5Digest extends GeneralDigest {
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int[] X = new int[16];
    public int xOff;

    public MD5Digest() {
        reset();
    }

    public final int F(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    public final int G(int i, int i2, int i3) {
        return (i & i3) | (i2 & (~i3));
    }

    public final int K(int i, int i2, int i3) {
        return (i | (~i3)) ^ i2;
    }

    public int doFinal(byte[] bArr, int i) {
        finish();
        unpackWord(this.H1, bArr, i);
        unpackWord(this.H2, bArr, i + 4);
        unpackWord(this.H3, bArr, i + 8);
        unpackWord(this.H4, bArr, i + 12);
        reset();
        return 16;
    }

    public int getDigestSize() {
        return 16;
    }

    public void processBlock() {
        int i = this.H1;
        int i2 = this.H2;
        int i3 = this.H3;
        int i4 = this.H4;
        int outline10 = GeneratedOutlineSupport.outline10(i + F(i2, i3, i4), this.X[0], -680876936, this, 7, i2);
        int outline102 = GeneratedOutlineSupport.outline10(F(outline10, i2, i3) + i4, this.X[1], -389564586, this, 12, outline10);
        int outline103 = GeneratedOutlineSupport.outline10(F(outline102, outline10, i2) + i3, this.X[2], 606105819, this, 17, outline102);
        int outline104 = GeneratedOutlineSupport.outline10(F(outline103, outline102, outline10) + i2, this.X[3], -1044525330, this, 22, outline103);
        int i5 = outline104;
        int outline105 = GeneratedOutlineSupport.outline10(F(outline104, outline103, outline102) + outline10, this.X[4], -176418897, this, 7, outline104);
        int i6 = outline105;
        int outline106 = GeneratedOutlineSupport.outline10(F(outline105, i5, outline103) + outline102, this.X[5], 1200080426, this, 12, outline105);
        int i7 = i6;
        int i8 = i7;
        int i9 = outline106;
        int outline107 = GeneratedOutlineSupport.outline10(F(outline106, i7, i5) + outline103, this.X[6], -1473231341, this, 17, outline106);
        int i10 = i9;
        int i11 = i10;
        int i12 = outline107;
        int outline108 = GeneratedOutlineSupport.outline10(F(outline107, i10, i8) + i5, this.X[7], -45705983, this, 22, outline107);
        int i13 = i12;
        int i14 = i13;
        int i15 = outline108;
        int outline109 = GeneratedOutlineSupport.outline10(F(outline108, i13, i11) + i8, this.X[8], 1770035416, this, 7, outline108);
        int i16 = i15;
        int i17 = i16;
        int i18 = outline109;
        int outline1010 = GeneratedOutlineSupport.outline10(F(outline109, i16, i14) + i11, this.X[9], -1958414417, this, 12, outline109);
        int i19 = i18;
        int i20 = i19;
        int i21 = outline1010;
        int outline1011 = GeneratedOutlineSupport.outline10(F(outline1010, i19, i17) + i14, this.X[10], -42063, this, 17, outline1010);
        int i22 = i21;
        int i23 = i22;
        int i24 = outline1011;
        int outline1012 = GeneratedOutlineSupport.outline10(F(outline1011, i22, i20) + i17, this.X[11], -1990404162, this, 22, outline1011);
        int i25 = i24;
        int i26 = i25;
        int i27 = outline1012;
        int outline1013 = GeneratedOutlineSupport.outline10(F(outline1012, i25, i23) + i20, this.X[12], 1804603682, this, 7, outline1012);
        int i28 = i27;
        int i29 = i28;
        int i30 = outline1013;
        int outline1014 = GeneratedOutlineSupport.outline10(F(outline1013, i28, i26) + i23, this.X[13], -40341101, this, 12, outline1013);
        int i31 = outline1014;
        int outline1015 = GeneratedOutlineSupport.outline10(F(outline1014, i30, i29) + i26, this.X[14], -1502002290, this, 17, outline1014);
        int i32 = outline1015;
        int outline1016 = GeneratedOutlineSupport.outline10(F(outline1015, i31, i30) + i29, this.X[15], 1236535329, this, 22, outline1015);
        int i33 = outline1016;
        int outline1017 = GeneratedOutlineSupport.outline10(G(outline1016, i32, i31) + i30, this.X[1], -165796510, this, 5, outline1016);
        int i34 = outline1017;
        int outline1018 = GeneratedOutlineSupport.outline10(G(outline1017, i33, i32) + i31, this.X[6], -1069501632, this, 9, outline1017);
        int i35 = outline1018;
        int outline1019 = GeneratedOutlineSupport.outline10(G(outline1018, i34, i33) + i32, this.X[11], 643717713, this, 14, outline1018);
        int i36 = outline1019;
        int outline1020 = GeneratedOutlineSupport.outline10(G(outline1019, i35, i34) + i33, this.X[0], -373897302, this, 20, outline1019);
        int i37 = i36;
        int i38 = i37;
        int i39 = outline1020;
        int outline1021 = GeneratedOutlineSupport.outline10(G(outline1020, i37, i35) + i34, this.X[5], -701558691, this, 5, outline1020);
        int i40 = i39;
        int i41 = i40;
        int i42 = outline1021;
        int outline1022 = GeneratedOutlineSupport.outline10(G(outline1021, i40, i38) + i35, this.X[10], 38016083, this, 9, outline1021);
        int i43 = outline1022;
        int outline1023 = GeneratedOutlineSupport.outline10(G(outline1022, i42, i41) + i38, this.X[15], -660478335, this, 14, outline1022);
        int i44 = outline1023;
        int outline1024 = GeneratedOutlineSupport.outline10(G(outline1023, i43, i42) + i41, this.X[4], -405537848, this, 20, outline1023);
        int i45 = outline1024;
        int outline1025 = GeneratedOutlineSupport.outline10(G(outline1024, i44, i43) + i42, this.X[9], 568446438, this, 5, outline1024);
        int i46 = outline1025;
        int outline1026 = GeneratedOutlineSupport.outline10(G(outline1025, i45, i44) + i43, this.X[14], -1019803690, this, 9, outline1025);
        int i47 = outline1026;
        int outline1027 = GeneratedOutlineSupport.outline10(G(outline1026, i46, i45) + i44, this.X[3], -187363961, this, 14, outline1026);
        int i48 = outline1027;
        int outline1028 = GeneratedOutlineSupport.outline10(G(outline1027, i47, i46) + i45, this.X[8], 1163531501, this, 20, outline1027);
        int i49 = outline1028;
        int outline1029 = GeneratedOutlineSupport.outline10(G(outline1028, i48, i47) + i46, this.X[13], -1444681467, this, 5, outline1028);
        int i50 = outline1029;
        int outline1030 = GeneratedOutlineSupport.outline10(G(outline1029, i49, i48) + i47, this.X[2], -51403784, this, 9, outline1029);
        int i51 = outline1030;
        int outline1031 = GeneratedOutlineSupport.outline10(G(outline1030, i50, i49) + i48, this.X[7], 1735328473, this, 14, outline1030);
        int i52 = outline1031;
        int outline1032 = GeneratedOutlineSupport.outline10(G(outline1031, i51, i50) + i49, this.X[12], -1926607734, this, 20, outline1031);
        int outline1033 = GeneratedOutlineSupport.outline10(((outline1032 ^ i52) ^ i51) + i50, this.X[5], -378558, this, 4, outline1032);
        int outline1034 = GeneratedOutlineSupport.outline10(((outline1033 ^ outline1032) ^ i52) + i51, this.X[8], -2022574463, this, 11, outline1033);
        int outline1035 = GeneratedOutlineSupport.outline10(((outline1034 ^ outline1033) ^ outline1032) + i52, this.X[11], 1839030562, this, 16, outline1034);
        int outline1036 = GeneratedOutlineSupport.outline10(((outline1035 ^ outline1034) ^ outline1033) + outline1032, this.X[14], -35309556, this, 23, outline1035);
        int outline1037 = GeneratedOutlineSupport.outline10(((outline1036 ^ outline1035) ^ outline1034) + outline1033, this.X[1], -1530992060, this, 4, outline1036);
        int outline1038 = GeneratedOutlineSupport.outline10(((outline1037 ^ outline1036) ^ outline1035) + outline1034, this.X[4], 1272893353, this, 11, outline1037);
        int outline1039 = GeneratedOutlineSupport.outline10(((outline1038 ^ outline1037) ^ outline1036) + outline1035, this.X[7], -155497632, this, 16, outline1038);
        int outline1040 = GeneratedOutlineSupport.outline10(outline1036 + ((outline1039 ^ outline1038) ^ outline1037), this.X[10], -1094730640, this, 23, outline1039);
        int outline1041 = GeneratedOutlineSupport.outline10(((outline1040 ^ outline1039) ^ outline1038) + outline1037, this.X[13], 681279174, this, 4, outline1040);
        int outline1042 = GeneratedOutlineSupport.outline10(((outline1041 ^ outline1040) ^ outline1039) + outline1038, this.X[0], -358537222, this, 11, outline1041);
        int outline1043 = GeneratedOutlineSupport.outline10(((outline1042 ^ outline1041) ^ outline1040) + outline1039, this.X[3], -722521979, this, 16, outline1042);
        int outline1044 = GeneratedOutlineSupport.outline10(((outline1043 ^ outline1042) ^ outline1041) + outline1040, this.X[6], 76029189, this, 23, outline1043);
        int outline1045 = GeneratedOutlineSupport.outline10(((outline1044 ^ outline1043) ^ outline1042) + outline1041, this.X[9], -640364487, this, 4, outline1044);
        int outline1046 = GeneratedOutlineSupport.outline10(((outline1045 ^ outline1044) ^ outline1043) + outline1042, this.X[12], -421815835, this, 11, outline1045);
        int outline1047 = GeneratedOutlineSupport.outline10(((outline1046 ^ outline1045) ^ outline1044) + outline1043, this.X[15], 530742520, this, 16, outline1046);
        int outline1048 = GeneratedOutlineSupport.outline10(((outline1047 ^ outline1046) ^ outline1045) + outline1044, this.X[2], -995338651, this, 23, outline1047);
        int outline1049 = GeneratedOutlineSupport.outline10(K(outline1048, outline1047, outline1046) + outline1045, this.X[0], -198630844, this, 6, outline1048);
        int outline1050 = GeneratedOutlineSupport.outline10(K(outline1049, outline1048, outline1047) + outline1046, this.X[7], 1126891415, this, 10, outline1049);
        int outline1051 = GeneratedOutlineSupport.outline10(K(outline1050, outline1049, outline1048) + outline1047, this.X[14], -1416354905, this, 15, outline1050);
        int outline1052 = GeneratedOutlineSupport.outline10(K(outline1051, outline1050, outline1049) + outline1048, this.X[5], -57434055, this, 21, outline1051);
        int outline1053 = GeneratedOutlineSupport.outline10(K(outline1052, outline1051, outline1050) + outline1049, this.X[12], 1700485571, this, 6, outline1052);
        int outline1054 = GeneratedOutlineSupport.outline10(K(outline1053, outline1052, outline1051) + outline1050, this.X[3], -1894986606, this, 10, outline1053);
        int outline1055 = GeneratedOutlineSupport.outline10(K(outline1054, outline1053, outline1052) + outline1051, this.X[10], -1051523, this, 15, outline1054);
        int outline1056 = GeneratedOutlineSupport.outline10(K(outline1055, outline1054, outline1053) + outline1052, this.X[1], -2054922799, this, 21, outline1055);
        int outline1057 = GeneratedOutlineSupport.outline10(K(outline1056, outline1055, outline1054) + outline1053, this.X[8], 1873313359, this, 6, outline1056);
        int outline1058 = GeneratedOutlineSupport.outline10(K(outline1057, outline1056, outline1055) + outline1054, this.X[15], -30611744, this, 10, outline1057);
        int outline1059 = GeneratedOutlineSupport.outline10(K(outline1058, outline1057, outline1056) + outline1055, this.X[6], -1560198380, this, 15, outline1058);
        int outline1060 = GeneratedOutlineSupport.outline10(K(outline1059, outline1058, outline1057) + outline1056, this.X[13], 1309151649, this, 21, outline1059);
        int outline1061 = GeneratedOutlineSupport.outline10(K(outline1060, outline1059, outline1058) + outline1057, this.X[4], -145523070, this, 6, outline1060);
        int outline1062 = GeneratedOutlineSupport.outline10(K(outline1061, outline1060, outline1059) + outline1058, this.X[11], -1120210379, this, 10, outline1061);
        int outline1063 = GeneratedOutlineSupport.outline10(K(outline1062, outline1061, outline1060) + outline1059, this.X[2], 718787259, this, 15, outline1062);
        int outline1064 = GeneratedOutlineSupport.outline10(K(outline1063, outline1062, outline1061) + outline1060, this.X[9], -343485551, this, 21, outline1063);
        this.H1 += outline1061;
        this.H2 += outline1064;
        this.H3 += outline1063;
        this.H4 += outline1062;
        this.xOff = 0;
        int i53 = 0;
        while (true) {
            int[] iArr = this.X;
            if (i53 != iArr.length) {
                iArr[i53] = 0;
                i53++;
            } else {
                return;
            }
        }
    }

    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (-1 & j);
        iArr[15] = (int) (j >>> 32);
    }

    public void processWord(byte[] bArr, int i) {
        int[] iArr = this.X;
        int i2 = this.xOff;
        int i3 = i2 + 1;
        this.xOff = i3;
        iArr[i2] = ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << GlyfDescript.X_DUAL);
        if (i3 == 16) {
            processBlock();
        }
    }

    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public final int rotateLeft(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public final void unpackWord(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }
}
