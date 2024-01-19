package com.google.zxing.datamatrix.encoder;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.imagepipeline.common.RotationOptions;
import org.apache.commons.net.ftp.FTPReply;
import sfs2x.client.entities.invitation.InvitationReply;
import sfs2x.client.requests.BaseRequest;

public final class ErrorCorrection {
    public static final int[] ALOG = new int[InvitationReply.EXPIRED];
    public static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, InvitationReply.EXPIRED, 110, 61}, new int[]{175, 138, BaseRequest.GoOnline, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, FTPReply.FILE_STATUS, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, FTPReply.FILE_STATUS, 109, 129, 94, 254, FTPReply.DATA_CONNECTION_OPEN, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, BaseRequest.GoOnline, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{FTPReply.SYSTEM_STATUS, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, FTPReply.FILE_STATUS, 141, 136, 120, 151, 233, 168, 93, InvitationReply.EXPIRED}, new int[]{245, 127, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, FTPReply.SERVICE_READY, 251, 80, 182, FTPReply.ENTERING_EPSV_MODE, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, FTPReply.DATA_CONNECTION_OPEN, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, FTPReply.HELP_MESSAGE, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, FTPReply.FILE_STATUS_OK, 177, FTPReply.CLOSING_DATA_CONNECTION, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, BaseRequest.GoOnline, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, BaseRequest.GoOnline, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, FTPReply.FILE_STATUS, 92, 253, FTPReply.DATA_CONNECTION_OPEN, 19}, new int[]{175, 9, 223, 238, 12, 17, FTPReply.SERVICE_READY, 208, 100, 29, 175, 170, FTPReply.USER_LOGGED_IN, 192, FTPReply.NAME_SYSTEM_TYPE, FTPReply.SECURITY_DATA_EXCHANGE_SUCCESSFULLY, FTPReply.FILE_STATUS_OK, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, 117, BaseRequest.RemoveBuddy, 29, 232, 144, 238, 22, FTPReply.FILE_STATUS_OK, BaseRequest.AddBuddy, 117, 62, 207, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, BaseRequest.RemoveBuddy, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, BaseRequest.AddBuddy, 189, 143, 108, 196, 37, 185, 112, 134, FTPReply.USER_LOGGED_IN, 245, 63, 197, 190, 250, 106, 185, FTPReply.SERVICE_CLOSING_CONTROL_CONNECTION, 175, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, BaseRequest.SetBuddyVariables}, new int[]{FTPReply.SERVICE_READY, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, FTPReply.FILE_STATUS, 136, 248, RotationOptions.ROTATE_180, FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, 197, 158, 177, 68, 122, 93, FTPReply.FILE_STATUS, 15, 160, FTPReply.ENTERING_PASSIVE_MODE, 236, 66, 139, 153, 185, 202, 167, 179, 25, FTPReply.SERVICE_READY, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, FTPReply.SYSTEM_STATUS, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    public static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    public static final int[] LOG = new int[256];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= BaseRequest.InvitationReply;
            }
        }
    }

    public static String createECCBlock(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i2 >= iArr.length) {
                i2 = -1;
                break;
            } else if (iArr[i2] == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int[] iArr2 = FACTORS[i2];
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = 0;
            }
            for (int i4 = 0; i4 < 0 + length; i4++) {
                int i5 = i - 1;
                char charAt = cArr[i5] ^ charSequence.charAt(i4);
                while (i5 > 0) {
                    if (charAt == 0 || iArr2[i5] == 0) {
                        cArr[i5] = cArr[i5 - 1];
                    } else {
                        char c2 = cArr[i5 - 1];
                        int[] iArr3 = ALOG;
                        int[] iArr4 = LOG;
                        cArr[i5] = (char) (c2 ^ iArr3[(iArr4[charAt] + iArr4[iArr2[i5]]) % InvitationReply.EXPIRED]);
                    }
                    i5--;
                }
                if (charAt == 0 || iArr2[0] == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = ALOG;
                    int[] iArr6 = LOG;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[iArr2[0]]) % InvitationReply.EXPIRED];
                }
            }
            char[] cArr2 = new char[i];
            for (int i6 = 0; i6 < i; i6++) {
                cArr2[i6] = cArr[(i - i6) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline40("Illegal number of error correction codewords specified: ", i));
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        int length = str.length();
        int i = symbolInfo.dataCapacity;
        if (length == i) {
            StringBuilder sb = new StringBuilder(i + symbolInfo.errorCodewords);
            sb.append(str);
            int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
            if (interleavedBlockCount == 1) {
                sb.append(createECCBlock(str, symbolInfo.errorCodewords));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[interleavedBlockCount];
                int[] iArr2 = new int[interleavedBlockCount];
                int[] iArr3 = new int[interleavedBlockCount];
                int i2 = 0;
                while (i2 < interleavedBlockCount) {
                    int i3 = i2 + 1;
                    iArr[i2] = symbolInfo.getDataLengthForInterleavedBlock(i3);
                    iArr2[i2] = symbolInfo.rsBlockError;
                    iArr3[i2] = 0;
                    if (i2 > 0) {
                        iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                    }
                    i2 = i3;
                }
                for (int i4 = 0; i4 < interleavedBlockCount; i4++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i4]);
                    for (int i5 = i4; i5 < symbolInfo.dataCapacity; i5 += interleavedBlockCount) {
                        sb2.append(str.charAt(i5));
                    }
                    String createECCBlock = createECCBlock(sb2.toString(), iArr2[i4]);
                    int i6 = i4;
                    int i7 = 0;
                    while (i6 < iArr2[i4] * interleavedBlockCount) {
                        sb.setCharAt(symbolInfo.dataCapacity + i6, createECCBlock.charAt(i7));
                        i6 += interleavedBlockCount;
                        i7++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }
}
