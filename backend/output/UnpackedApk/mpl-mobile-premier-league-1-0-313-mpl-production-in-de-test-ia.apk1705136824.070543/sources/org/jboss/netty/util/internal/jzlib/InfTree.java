package org.jboss.netty.util.internal.jzlib;

import androidx.fragment.app.FragmentTransaction;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.facebook.imagepipeline.common.RotationOptions;
import com.mpl.androidapp.utils.Constant;
import org.apache.commons.net.ftp.FTPReply;
import sfs2x.client.entities.invitation.InvitationReply;
import sfs2x.client.requests.BaseRequest;

public final class InfTree {
    public static final int BMAX = 15;
    public static final int[] cpdext = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
    public static final int[] cpdist = {1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, FTPReply.PATHNAME_CREATED, 385, GL20.GL_LESS, GL20.GL_ONE_MINUS_SRC_COLOR, Constant.GPS_REQUEST_ID_V2, 1537, 2049, 3073, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, GL30.GL_DEPTH, 8193, 12289, 16385, 24577};
    public static final int[] cplens = {3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, FTPReply.ENTERING_PASSIVE_MODE, 258, 0, 0};
    public static final int[] cplext = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 112, 112};
    public static final int fixed_bd = 5;
    public static final int fixed_bl = 9;
    public static final int[] fixed_td = {80, 5, 1, 87, 5, FTPReply.PATHNAME_CREATED, 83, 5, 17, 91, 5, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 81, 5, 5, 89, 5, Constant.GPS_REQUEST_ID_V2, 85, 5, 65, 93, 5, 16385, 80, 5, 3, 88, 5, GL20.GL_LESS, 84, 5, 33, 92, 5, 8193, 82, 5, 9, 90, 5, 2049, 86, 5, 129, 192, 5, 24577, 80, 5, 2, 87, 5, 385, 83, 5, 25, 91, 5, GL30.GL_DEPTH, 81, 5, 7, 89, 5, 1537, 85, 5, 97, 93, 5, 24577, 80, 5, 4, 88, 5, GL20.GL_ONE_MINUS_SRC_COLOR, 84, 5, 49, 92, 5, 12289, 82, 5, 13, 90, 5, 3073, 86, 5, 193, 192, 5, 24577};
    public static final int[] fixed_tl = {96, 7, 256, 0, 8, 80, 0, 8, 16, 84, 8, 115, 82, 7, 31, 0, 8, 112, 0, 8, 48, 0, 9, 192, 80, 7, 10, 0, 8, 96, 0, 8, 32, 0, 9, 160, 0, 8, 0, 0, 8, 128, 0, 8, 64, 0, 9, 224, 80, 7, 6, 0, 8, 88, 0, 8, 24, 0, 9, 144, 83, 7, 59, 0, 8, 120, 0, 8, 56, 0, 9, 208, 81, 7, 17, 0, 8, 104, 0, 8, 40, 0, 9, 176, 0, 8, 8, 0, 8, 136, 0, 8, 72, 0, 9, 240, 80, 7, 4, 0, 8, 84, 0, 8, 20, 85, 8, FTPReply.ENTERING_PASSIVE_MODE, 83, 7, 43, 0, 8, 116, 0, 8, 52, 0, 9, 200, 81, 7, 13, 0, 8, 100, 0, 8, 36, 0, 9, 168, 0, 8, 4, 0, 8, 132, 0, 8, 68, 0, 9, 232, 80, 7, 8, 0, 8, 92, 0, 8, 28, 0, 9, 152, 84, 7, 83, 0, 8, 124, 0, 8, 60, 0, 9, 216, 82, 7, 23, 0, 8, 108, 0, 8, 44, 0, 9, 184, 0, 8, 12, 0, 8, 140, 0, 8, 76, 0, 9, 248, 80, 7, 3, 0, 8, 82, 0, 8, 18, 85, 8, 163, 83, 7, 35, 0, 8, 114, 0, 8, 50, 0, 9, 196, 81, 7, 11, 0, 8, 98, 0, 8, 34, 0, 9, 164, 0, 8, 2, 0, 8, 130, 0, 8, 66, 0, 9, 228, 80, 7, 7, 0, 8, 90, 0, 8, 26, 0, 9, 148, 84, 7, 67, 0, 8, 122, 0, 8, 58, 0, 9, FTPReply.DIRECTORY_STATUS, 82, 7, 19, 0, 8, 106, 0, 8, 42, 0, 9, RotationOptions.ROTATE_180, 0, 8, 10, 0, 8, 138, 0, 8, 74, 0, 9, 244, 80, 7, 5, 0, 8, 86, 0, 8, 22, 192, 8, 0, 83, 7, 51, 0, 8, 118, 0, 8, 54, 0, 9, BaseRequest.SetBuddyVariables, 81, 7, 15, 0, 8, 102, 0, 8, 38, 0, 9, 172, 0, 8, 6, 0, 8, 134, 0, 8, 70, 0, 9, 236, 80, 7, 9, 0, 8, 94, 0, 8, 30, 0, 9, 156, 84, 7, 99, 0, 8, 126, 0, 8, 62, 0, 9, FTPReply.SERVICE_READY, 82, 7, 27, 0, 8, 110, 0, 8, 46, 0, 9, 188, 0, 8, 14, 0, 8, 142, 0, 8, 78, 0, 9, 252, 96, 7, 256, 0, 8, 81, 0, 8, 17, 85, 8, 131, 82, 7, 31, 0, 8, 113, 0, 8, 49, 0, 9, 194, 80, 7, 10, 0, 8, 97, 0, 8, 33, 0, 9, 162, 0, 8, 1, 0, 8, 129, 0, 8, 65, 0, 9, FTPReply.CLOSING_DATA_CONNECTION, 80, 7, 6, 0, 8, 89, 0, 8, 25, 0, 9, 146, 83, 7, 59, 0, 8, 121, 0, 8, 57, 0, 9, 210, 81, 7, 17, 0, 8, 105, 0, 8, 41, 0, 9, 178, 0, 8, 9, 0, 8, 137, 0, 8, 73, 0, 9, 242, 80, 7, 4, 0, 8, 85, 0, 8, 21, 80, 8, 258, 83, 7, 43, 0, 8, 117, 0, 8, 53, 0, 9, 202, 81, 7, 13, 0, 8, 101, 0, 8, 37, 0, 9, 170, 0, 8, 5, 0, 8, 133, 0, 8, 69, 0, 9, FTPReply.SECURITY_DATA_EXCHANGE_COMPLETE, 80, 7, 8, 0, 8, 93, 0, 8, 29, 0, 9, 154, 84, 7, 83, 0, 8, 125, 0, 8, 61, 0, 9, 218, 82, 7, 23, 0, 8, 109, 0, 8, 45, 0, 9, 186, 0, 8, 13, 0, 8, 141, 0, 8, 77, 0, 9, 250, 80, 7, 3, 0, 8, 83, 0, 8, 19, 85, 8, 195, 83, 7, 35, 0, 8, 115, 0, 8, 51, 0, 9, 198, 81, 7, 11, 0, 8, 99, 0, 8, 35, 0, 9, 166, 0, 8, 3, 0, 8, 131, 0, 8, 67, 0, 9, FTPReply.USER_LOGGED_IN, 80, 7, 7, 0, 8, 91, 0, 8, 27, 0, 9, FTPReply.FILE_STATUS_OK, 84, 7, 67, 0, 8, 123, 0, 8, 59, 0, 9, FTPReply.HELP_MESSAGE, 82, 7, 19, 0, 8, 107, 0, 8, 43, 0, 9, 182, 0, 8, 11, 0, 8, 139, 0, 8, 75, 0, 9, 246, 80, 7, 5, 0, 8, 87, 0, 8, 23, 192, 8, 0, 83, 7, 51, 0, 8, 119, 0, 8, 55, 0, 9, 206, 81, 7, 15, 0, 8, 103, 0, 8, 39, 0, 9, 174, 0, 8, 7, 0, 8, 135, 0, 8, 71, 0, 9, 238, 80, 7, 9, 0, 8, 95, 0, 8, 31, 0, 9, 158, 84, 7, 99, 0, 8, 127, 0, 8, 63, 0, 9, 222, 82, 7, 27, 0, 8, 111, 0, 8, 47, 0, 9, 190, 0, 8, 15, 0, 8, 143, 0, 8, 79, 0, 9, 254, 96, 7, 256, 0, 8, 80, 0, 8, 16, 84, 8, 115, 82, 7, 31, 0, 8, 112, 0, 8, 48, 0, 9, 193, 80, 7, 10, 0, 8, 96, 0, 8, 32, 0, 9, 161, 0, 8, 0, 0, 8, 128, 0, 8, 64, 0, 9, FTPReply.DATA_CONNECTION_OPEN, 80, 7, 6, 0, 8, 88, 0, 8, 24, 0, 9, 145, 83, 7, 59, 0, 8, 120, 0, 8, 56, 0, 9, 209, 81, 7, 17, 0, 8, 104, 0, 8, 40, 0, 9, 177, 0, 8, 8, 0, 8, 136, 0, 8, 72, 0, 9, 241, 80, 7, 4, 0, 8, 84, 0, 8, 20, 85, 8, FTPReply.ENTERING_PASSIVE_MODE, 83, 7, 43, 0, 8, 116, 0, 8, 52, 0, 9, BaseRequest.AddBuddy, 81, 7, 13, 0, 8, 100, 0, 8, 36, 0, 9, 169, 0, 8, 4, 0, 8, 132, 0, 8, 68, 0, 9, 233, 80, 7, 8, 0, 8, 92, 0, 8, 28, 0, 9, 153, 84, 7, 83, 0, 8, 124, 0, 8, 60, 0, 9, 217, 82, 7, 23, 0, 8, 108, 0, 8, 44, 0, 9, 185, 0, 8, 12, 0, 8, 140, 0, 8, 76, 0, 9, 249, 80, 7, 3, 0, 8, 82, 0, 8, 18, 85, 8, 163, 83, 7, 35, 0, 8, 114, 0, 8, 50, 0, 9, 197, 81, 7, 11, 0, 8, 98, 0, 8, 34, 0, 9, 165, 0, 8, 2, 0, 8, 130, 0, 8, 66, 0, 9, FTPReply.ENTERING_EPSV_MODE, 80, 7, 7, 0, 8, 90, 0, 8, 26, 0, 9, 149, 84, 7, 67, 0, 8, 122, 0, 8, 58, 0, 9, FTPReply.FILE_STATUS, 82, 7, 19, 0, 8, 106, 0, 8, 42, 0, 9, 181, 0, 8, 10, 0, 8, 138, 0, 8, 74, 0, 9, 245, 80, 7, 5, 0, 8, 86, 0, 8, 22, 192, 8, 0, 83, 7, 51, 0, 8, 118, 0, 8, 54, 0, 9, BaseRequest.GoOnline, 81, 7, 15, 0, 8, 102, 0, 8, 38, 0, 9, 173, 0, 8, 6, 0, 8, 134, 0, 8, 70, 0, 9, 237, 80, 7, 9, 0, 8, 94, 0, 8, 30, 0, 9, 157, 84, 7, 99, 0, 8, 126, 0, 8, 62, 0, 9, FTPReply.SERVICE_CLOSING_CONTROL_CONNECTION, 82, 7, 27, 0, 8, 110, 0, 8, 46, 0, 9, 189, 0, 8, 14, 0, 8, 142, 0, 8, 78, 0, 9, 253, 96, 7, 256, 0, 8, 81, 0, 8, 17, 85, 8, 131, 82, 7, 31, 0, 8, 113, 0, 8, 49, 0, 9, 195, 80, 7, 10, 0, 8, 97, 0, 8, 33, 0, 9, 163, 0, 8, 1, 0, 8, 129, 0, 8, 65, 0, 9, FTPReply.ENTERING_PASSIVE_MODE, 80, 7, 6, 0, 8, 89, 0, 8, 25, 0, 9, 147, 83, 7, 59, 0, 8, 121, 0, 8, 57, 0, 9, FTPReply.SYSTEM_STATUS, 81, 7, 17, 0, 8, 105, 0, 8, 41, 0, 9, 179, 0, 8, 9, 0, 8, 137, 0, 8, 73, 0, 9, 243, 80, 7, 4, 0, 8, 85, 0, 8, 21, 80, 8, 258, 83, 7, 43, 0, 8, 117, 0, 8, 53, 0, 9, BaseRequest.RemoveBuddy, 81, 7, 13, 0, 8, 101, 0, 8, 37, 0, 9, 171, 0, 8, 5, 0, 8, 133, 0, 8, 69, 0, 9, FTPReply.SECURITY_DATA_EXCHANGE_SUCCESSFULLY, 80, 7, 8, 0, 8, 93, 0, 8, 29, 0, 9, 155, 84, 7, 83, 0, 8, 125, 0, 8, 61, 0, 9, 219, 82, 7, 23, 0, 8, 109, 0, 8, 45, 0, 9, 187, 0, 8, 13, 0, 8, 141, 0, 8, 77, 0, 9, 251, 80, 7, 3, 0, 8, 83, 0, 8, 19, 85, 8, 195, 83, 7, 35, 0, 8, 115, 0, 8, 51, 0, 9, 199, 81, 7, 11, 0, 8, 99, 0, 8, 35, 0, 9, 167, 0, 8, 3, 0, 8, 131, 0, 8, 67, 0, 9, 231, 80, 7, 7, 0, 8, 91, 0, 8, 27, 0, 9, 151, 84, 7, 67, 0, 8, 123, 0, 8, 59, 0, 9, FTPReply.NAME_SYSTEM_TYPE, 82, 7, 19, 0, 8, 107, 0, 8, 43, 0, 9, 183, 0, 8, 11, 0, 8, 139, 0, 8, 75, 0, 9, 247, 80, 7, 5, 0, 8, 87, 0, 8, 23, 192, 8, 0, 83, 7, 51, 0, 8, 119, 0, 8, 55, 0, 9, 207, 81, 7, 15, 0, 8, 103, 0, 8, 39, 0, 9, 175, 0, 8, 7, 0, 8, 135, 0, 8, 71, 0, 9, 239, 80, 7, 9, 0, 8, 95, 0, 8, 31, 0, 9, 159, 84, 7, 99, 0, 8, 127, 0, 8, 63, 0, 9, 223, 82, 7, 27, 0, 8, 111, 0, 8, 47, 0, 9, 191, 0, 8, 15, 0, 8, 143, 0, 8, 79, 0, 9, InvitationReply.EXPIRED};

    /* renamed from: c  reason: collision with root package name */
    public int[] f6175c;
    public int[] hn;
    public int[] r;
    public int[] u;
    public int[] v;
    public int[] x;

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0150, code lost:
        r10 = r0.r;
        r4 = r7 - r1;
        r26 = r8;
        r10[1] = (byte) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015e, code lost:
        if (r6 < r5) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0160, code lost:
        r10[0] = 192;
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0168, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0170, code lost:
        if (r35[r6] >= r2) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0172, code lost:
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0178, code lost:
        if (r35[r6] >= 256) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x017a, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017c, code lost:
        r5 = 96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0180, code lost:
        r10[0] = (byte) r5;
        r0.r[2] = r35[r6];
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x018e, code lost:
        r27 = r5;
        r10[0] = (byte) ((r30[r35[r6] - r2] + 16) + 64);
        r10[2] = r29[r35[r6] - r2];
        r6 = r6 + 1;
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01aa, code lost:
        r4 = r5 << r4;
        r5 = r14 >>> r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ae, code lost:
        if (r5 >= r12) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01b0, code lost:
        java.lang.System.arraycopy(r0.r, 0, r3, (r15 + r5) * 3, 3);
        r5 = r5 + r4;
        r6 = r6;
        r2 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c3, code lost:
        r25 = r6;
        r2 = 1 << (r7 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cd, code lost:
        if ((r14 & r2) == 0) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cf, code lost:
        r14 = r14 ^ r2;
        r2 = r2 >>> 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d3, code lost:
        r14 = r14 ^ r2;
        r2 = (1 << r1) - 1;
        r8 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01de, code lost:
        if ((r2 & r14) == r0.x[r8]) goto L_0x01e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e0, code lost:
        r8 = r8 - 1;
        r1 = r1 - r11;
        r2 = (1 << r1) - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f5, code lost:
        r27 = r5;
        r7 = r7 + 1;
        r6 = r6;
        r2 = r28;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int huft_build(int[] r25, int r26, int r27, int r28, int[] r29, int[] r30, int[] r31, int[] r32, int[] r33, int[] r34, int[] r35) {
        /*
            r24 = this;
            r0 = r24
            r1 = r27
            r2 = r28
            r3 = r33
            r4 = 0
            r6 = r1
            r5 = 0
        L_0x000b:
            int[] r7 = r0.f6175c
            int r8 = r26 + r5
            r8 = r25[r8]
            r9 = r7[r8]
            r10 = 1
            int r9 = r9 + r10
            r7[r8] = r9
            int r5 = r5 + r10
            r8 = -1
            int r6 = r6 + r8
            if (r6 != 0) goto L_0x021c
            r5 = r7[r4]
            if (r5 != r1) goto L_0x0025
            r31[r4] = r8
            r32[r4] = r4
            return r4
        L_0x0025:
            r5 = r32[r4]
            r7 = 1
        L_0x0028:
            r6 = 15
            if (r7 > r6) goto L_0x0036
            int[] r9 = r0.f6175c
            r9 = r9[r7]
            if (r9 == 0) goto L_0x0033
            goto L_0x0036
        L_0x0033:
            int r7 = r7 + 1
            goto L_0x0028
        L_0x0036:
            if (r5 >= r7) goto L_0x0039
            r5 = r7
        L_0x0039:
            r9 = 15
        L_0x003b:
            if (r9 == 0) goto L_0x0047
            int[] r6 = r0.f6175c
            r6 = r6[r9]
            if (r6 == 0) goto L_0x0044
            goto L_0x0047
        L_0x0044:
            int r9 = r9 + -1
            goto L_0x003b
        L_0x0047:
            if (r5 <= r9) goto L_0x004b
            r11 = r9
            goto L_0x004c
        L_0x004b:
            r11 = r5
        L_0x004c:
            r32[r4] = r11
            int r5 = r10 << r7
            r6 = r7
        L_0x0051:
            r12 = -3
            if (r6 >= r9) goto L_0x0061
            int[] r13 = r0.f6175c
            r13 = r13[r6]
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x005c
            return r12
        L_0x005c:
            int r6 = r6 + 1
            int r5 = r5 << 1
            goto L_0x0051
        L_0x0061:
            int[] r6 = r0.f6175c
            r13 = r6[r9]
            int r13 = r5 - r13
            if (r13 >= 0) goto L_0x006a
            return r12
        L_0x006a:
            r5 = r6[r9]
            int r5 = r5 + r13
            r6[r9] = r5
            int[] r5 = r0.x
            r5[r10] = r4
            r5 = r9
            r6 = 2
            r15 = 0
            r16 = 1
        L_0x0078:
            int r5 = r5 + r8
            if (r5 == 0) goto L_0x0089
            int[] r8 = r0.x
            int[] r14 = r0.f6175c
            r14 = r14[r16]
            int r15 = r15 + r14
            r8[r6] = r15
            int r6 = r6 + r10
            int r16 = r16 + 1
            r8 = -1
            goto L_0x0078
        L_0x0089:
            r5 = 0
            r6 = 0
        L_0x008b:
            int r8 = r26 + r5
            r8 = r25[r8]
            if (r8 == 0) goto L_0x009b
            int[] r14 = r0.x
            r15 = r14[r8]
            int r16 = r15 + 1
            r14[r8] = r16
            r35[r15] = r6
        L_0x009b:
            int r5 = r5 + 1
            int r6 = r6 + 1
            if (r6 < r1) goto L_0x0212
            int[] r1 = r0.x
            r5 = r1[r9]
            r1[r4] = r4
            int r1 = -r11
            int[] r6 = r0.u
            r6[r4] = r4
            r6 = 0
            r8 = -1
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x00b2:
            if (r7 > r9) goto L_0x0208
            int[] r12 = r0.f6175c
            r12 = r12[r7]
        L_0x00b8:
            int r17 = r12 + -1
            if (r12 == 0) goto L_0x01f5
            r12 = r16
        L_0x00be:
            int r4 = r1 + r11
            if (r7 <= r4) goto L_0x0150
            int r8 = r8 + 1
            int r1 = r9 - r4
            if (r1 <= r11) goto L_0x00c9
            r1 = r11
        L_0x00c9:
            int r12 = r7 - r4
            r15 = 1
            int r10 = r15 << r12
            int r15 = r17 + 1
            if (r10 <= r15) goto L_0x00f7
            int r10 = r10 - r15
            if (r12 >= r1) goto L_0x00f7
            r15 = r7
        L_0x00d6:
            r16 = 1
            int r12 = r12 + 1
            if (r12 >= r1) goto L_0x00f3
            int r10 = r10 << 1
            r26 = r1
            int[] r1 = r0.f6175c
            int r15 = r15 + 1
            r27 = r12
            r12 = r1[r15]
            if (r10 > r12) goto L_0x00eb
            goto L_0x00f5
        L_0x00eb:
            r1 = r1[r15]
            int r10 = r10 - r1
            r1 = r26
            r12 = r27
            goto L_0x00d6
        L_0x00f3:
            r27 = r12
        L_0x00f5:
            r12 = r27
        L_0x00f7:
            r1 = 1
            int r10 = r1 << r12
            r1 = 0
            r15 = r34[r1]
            int r15 = r15 + r10
            r1 = 1440(0x5a0, float:2.018E-42)
            if (r15 <= r1) goto L_0x0105
            r19 = -3
            return r19
        L_0x0105:
            r19 = -3
            int[] r1 = r0.u
            r15 = 0
            r16 = r34[r15]
            r1[r8] = r16
            r20 = r34[r15]
            int r20 = r20 + r10
            r34[r15] = r20
            if (r8 == 0) goto L_0x0143
            int[] r15 = r0.x
            r15[r8] = r14
            int[] r15 = r0.r
            byte r12 = (byte) r12
            r20 = 0
            r15[r20] = r12
            byte r12 = (byte) r11
            r21 = 1
            r15[r21] = r12
            int r12 = r4 - r11
            int r12 = r14 >>> r12
            int r22 = r8 + -1
            r23 = r1[r22]
            int r23 = r16 - r23
            int r23 = r23 - r12
            r18 = 2
            r15[r18] = r23
            r1 = r1[r22]
            int r1 = r1 + r12
            r12 = 3
            int r1 = r1 * 3
            r25 = r4
            r4 = 0
            java.lang.System.arraycopy(r15, r4, r3, r1, r12)
            goto L_0x0148
        L_0x0143:
            r25 = r4
            r4 = 0
            r31[r4] = r16
        L_0x0148:
            r1 = r25
            r12 = r10
            r15 = r16
            r10 = 1
            goto L_0x00be
        L_0x0150:
            r4 = 0
            r19 = -3
            int[] r10 = r0.r
            int r4 = r7 - r1
            r26 = r8
            byte r8 = (byte) r4
            r16 = 1
            r10[r16] = r8
            if (r6 < r5) goto L_0x016c
            r8 = 192(0xc0, float:2.69E-43)
            r16 = 0
            r10[r16] = r8
            r27 = r5
        L_0x0168:
            r5 = 1
            r18 = 2
            goto L_0x01aa
        L_0x016c:
            r16 = 0
            r8 = r35[r6]
            if (r8 >= r2) goto L_0x018e
            r8 = r35[r6]
            r27 = r5
            r5 = 256(0x100, float:3.59E-43)
            if (r8 >= r5) goto L_0x017c
            r5 = 0
            goto L_0x0180
        L_0x017c:
            r20 = 96
            r5 = 96
        L_0x0180:
            byte r5 = (byte) r5
            r10[r16] = r5
            int[] r5 = r0.r
            int r8 = r6 + 1
            r6 = r35[r6]
            r10 = 2
            r5[r10] = r6
            r6 = r8
            goto L_0x0168
        L_0x018e:
            r27 = r5
            r5 = r35[r6]
            int r5 = r5 - r2
            r5 = r30[r5]
            int r5 = r5 + 16
            int r5 = r5 + 64
            byte r5 = (byte) r5
            r8 = 0
            r10[r8] = r5
            int r5 = r6 + 1
            r6 = r35[r6]
            int r6 = r6 - r2
            r6 = r29[r6]
            r18 = 2
            r10[r18] = r6
            r6 = r5
            r5 = 1
        L_0x01aa:
            int r4 = r5 << r4
            int r5 = r14 >>> r1
        L_0x01ae:
            if (r5 >= r12) goto L_0x01c3
            int[] r8 = r0.r
            int r10 = r15 + r5
            r2 = 3
            int r10 = r10 * 3
            r25 = r6
            r6 = 0
            java.lang.System.arraycopy(r8, r6, r3, r10, r2)
            int r5 = r5 + r4
            r6 = r25
            r2 = r28
            goto L_0x01ae
        L_0x01c3:
            r25 = r6
            r6 = 0
            int r2 = r7 + -1
            r4 = 1
            int r2 = r4 << r2
        L_0x01cb:
            r5 = r14 & r2
            if (r5 == 0) goto L_0x01d3
            r14 = r14 ^ r2
            int r2 = r2 >>> 1
            goto L_0x01cb
        L_0x01d3:
            r14 = r14 ^ r2
            int r2 = r4 << r1
            int r2 = r2 - r4
            r8 = r26
        L_0x01d9:
            r2 = r2 & r14
            int[] r5 = r0.x
            r5 = r5[r8]
            if (r2 == r5) goto L_0x01e7
            int r8 = r8 + -1
            int r1 = r1 - r11
            int r2 = r4 << r1
            int r2 = r2 - r4
            goto L_0x01d9
        L_0x01e7:
            r6 = r25
            r5 = r27
            r2 = r28
            r16 = r12
            r12 = r17
            r4 = 0
            r10 = 1
            goto L_0x00b8
        L_0x01f5:
            r27 = r5
            r2 = r6
            r4 = 1
            r6 = 0
            r18 = 2
            r19 = -3
            int r7 = r7 + 1
            r6 = r2
            r4 = 0
            r10 = 1
            r12 = -3
            r2 = r28
            goto L_0x00b2
        L_0x0208:
            r4 = 1
            r6 = 0
            if (r13 == 0) goto L_0x0210
            if (r9 == r4) goto L_0x0210
            r4 = -5
            goto L_0x0211
        L_0x0210:
            r4 = 0
        L_0x0211:
            return r4
        L_0x0212:
            r2 = r6
            r6 = 0
            r18 = 2
            r6 = r2
            r4 = 0
            r2 = r28
            goto L_0x008b
        L_0x021c:
            r2 = r6
            r2 = r28
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfTree.huft_build(int[], int, int, int, int[], int[], int[], int[], int[], int[], int[]):int");
    }

    public static int inflate_trees_fixed(int[] iArr, int[] iArr2, int[][] iArr3, int[][] iArr4) {
        iArr[0] = 9;
        iArr2[0] = 5;
        iArr3[0] = fixed_tl;
        iArr4[0] = fixed_td;
        return 0;
    }

    private void initWorkArea(int i) {
        if (this.hn == null) {
            this.hn = new int[1];
            this.v = new int[i];
            this.f6175c = new int[16];
            this.r = new int[3];
            this.u = new int[15];
            this.x = new int[16];
            return;
        }
        if (this.v.length < i) {
            this.v = new int[i];
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                this.v[i2] = 0;
            }
        }
        for (int i3 = 0; i3 < 16; i3++) {
            this.f6175c[i3] = 0;
        }
        for (int i4 = 0; i4 < 3; i4++) {
            this.r[i4] = 0;
        }
        System.arraycopy(this.f6175c, 0, this.u, 0, 15);
        System.arraycopy(this.f6175c, 0, this.x, 0, 16);
    }

    public int inflate_trees_bits(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, ZStream zStream) {
        ZStream zStream2 = zStream;
        initWorkArea(19);
        int[] iArr5 = this.hn;
        iArr5[0] = 0;
        int huft_build = huft_build(iArr, 0, 19, 19, null, null, iArr3, iArr2, iArr4, iArr5, this.v);
        if (huft_build == -3) {
            zStream2.msg = "oversubscribed dynamic bit lengths tree";
            return huft_build;
        } else if (huft_build != -5 && iArr2[0] != 0) {
            return huft_build;
        } else {
            zStream2.msg = "incomplete dynamic bit lengths tree";
            return -3;
        }
    }

    public int inflate_trees_dynamic(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, ZStream zStream) {
        ZStream zStream2 = zStream;
        initWorkArea(288);
        int[] iArr7 = this.hn;
        iArr7[0] = 0;
        int huft_build = huft_build(iArr, 0, i, FTPReply.PATHNAME_CREATED, cplens, cplext, iArr4, iArr2, iArr6, iArr7, this.v);
        if (huft_build != 0 || iArr2[0] == 0) {
            if (huft_build == -3) {
                zStream2.msg = "oversubscribed literal/length tree";
            } else if (huft_build != -4) {
                zStream2.msg = "incomplete literal/length tree";
                huft_build = -3;
            }
            return huft_build;
        }
        initWorkArea(288);
        int huft_build2 = huft_build(iArr, i, i2, 0, cpdist, cpdext, iArr5, iArr3, iArr6, this.hn, this.v);
        if (huft_build2 == 0 && (iArr3[0] != 0 || i <= 257)) {
            return 0;
        }
        if (huft_build2 == -3) {
            zStream2.msg = "oversubscribed distance tree";
        } else {
            if (huft_build2 == -5) {
                zStream2.msg = "incomplete distance tree";
            } else if (huft_build2 != -4) {
                zStream2.msg = "empty distance tree with lengths";
            }
            huft_build2 = -3;
        }
        return huft_build2;
    }
}
