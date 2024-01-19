package org.apache.fontbox.cff;

import java.io.ByteArrayOutputStream;
import java.util.List;
import sfs2x.client.entities.invitation.InvitationReply;

public class Type1CharStringFormatter {
    public ByteArrayOutputStream output = null;

    private void writeCommand(CharStringCommand charStringCommand) {
        int[] value = charStringCommand.getKey().getValue();
        for (int write : value) {
            this.output.write(write);
        }
    }

    private void writeNumber(Integer num) {
        int intValue = num.intValue();
        if (intValue >= -107 && intValue <= 107) {
            this.output.write(intValue + 139);
        } else if (intValue >= 108 && intValue <= 1131) {
            int i = intValue - 108;
            int i2 = i % 256;
            this.output.write(((i - i2) / 256) + 247);
            this.output.write(i2);
        } else if (intValue < -1131 || intValue > -108) {
            int i3 = (intValue >>> 24) & InvitationReply.EXPIRED;
            int i4 = (intValue >>> 16) & InvitationReply.EXPIRED;
            int i5 = (intValue >>> 8) & InvitationReply.EXPIRED;
            int i6 = (intValue >>> 0) & InvitationReply.EXPIRED;
            this.output.write(InvitationReply.EXPIRED);
            this.output.write(i3);
            this.output.write(i4);
            this.output.write(i5);
            this.output.write(i6);
        } else {
            int i7 = intValue + 108;
            int i8 = -(i7 % 256);
            this.output.write(-(((i7 + i8) / 256) - 251));
            this.output.write(i8);
        }
    }

    public byte[] format(List<Object> list) {
        this.output = new ByteArrayOutputStream();
        for (Object next : list) {
            if (next instanceof CharStringCommand) {
                writeCommand((CharStringCommand) next);
            } else if (next instanceof Integer) {
                writeNumber((Integer) next);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return this.output.toByteArray();
    }
}
