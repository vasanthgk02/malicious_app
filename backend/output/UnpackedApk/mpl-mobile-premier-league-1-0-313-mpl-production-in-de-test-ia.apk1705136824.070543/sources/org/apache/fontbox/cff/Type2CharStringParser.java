package org.apache.fontbox.cff;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Type2CharStringParser {
    public final String fontName;
    public final String glyphName;
    public int hstemCount = 0;
    public List<Object> sequence = null;
    public int vstemCount = 0;

    public Type2CharStringParser(String str, String str2) {
        this.fontName = str;
        this.glyphName = str2;
    }

    private int getMaskLength() {
        int i = this.hstemCount + this.vstemCount;
        int i2 = 1;
        while (true) {
            i -= 8;
            if (i <= 0) {
                return i2;
            }
            i2++;
        }
    }

    private List<Number> peekNumbers() {
        ArrayList arrayList = new ArrayList();
        int size = this.sequence.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Object obj = this.sequence.get(size);
            if (!(obj instanceof Number)) {
                break;
            }
            arrayList.add(0, (Number) obj);
        }
        return arrayList;
    }

    private CharStringCommand readCommand(int i, DataInput dataInput) throws IOException {
        if (i == 1 || i == 18) {
            this.hstemCount = (peekNumbers().size() / 2) + this.hstemCount;
        } else if (i == 3 || i == 19 || i == 20 || i == 23) {
            this.vstemCount = (peekNumbers().size() / 2) + this.vstemCount;
        }
        if (i == 12) {
            return new CharStringCommand(i, dataInput.readUnsignedByte());
        }
        if (i != 19 && i != 20) {
            return new CharStringCommand(i);
        }
        int maskLength = getMaskLength() + 1;
        int[] iArr = new int[maskLength];
        iArr[0] = i;
        for (int i2 = 1; i2 < maskLength; i2++) {
            iArr[i2] = dataInput.readUnsignedByte();
        }
        return new CharStringCommand(iArr);
    }

    public static Integer readNumber(int i, DataInput dataInput) throws IOException {
        if (i == 28) {
            return Integer.valueOf((short) ((dataInput.readUnsignedByte() << 8) | dataInput.readUnsignedByte()));
        } else if (i >= 32 && i <= 246) {
            return Integer.valueOf(i - 139);
        } else {
            if (i >= 247 && i <= 250) {
                return Integer.valueOf(((i - 247) * 256) + dataInput.readUnsignedByte() + 108);
            } else if (i >= 251 && i <= 254) {
                return Integer.valueOf((((-(i - 251)) * 256) - dataInput.readUnsignedByte()) - 108);
            } else if (i == 255) {
                int readUnsignedByte = dataInput.readUnsignedByte();
                int readUnsignedByte2 = dataInput.readUnsignedByte();
                dataInput.readUnsignedByte();
                dataInput.readUnsignedByte();
                return Integer.valueOf((short) ((readUnsignedByte << 8) | readUnsignedByte2));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Object> parse(byte[] bArr, IndexData indexData, IndexData indexData2) throws IOException {
        return parse(bArr, indexData, indexData2, true);
    }

    private List<Object> parse(byte[] bArr, IndexData indexData, IndexData indexData2, boolean z) throws IOException {
        if (z) {
            this.hstemCount = 0;
            this.vstemCount = 0;
            this.sequence = new ArrayList();
        }
        DataInput dataInput = new DataInput(bArr);
        boolean z2 = indexData2 != null && indexData2.getCount() > 0;
        boolean z3 = indexData != null && indexData.getCount() > 0;
        while (dataInput.hasRemaining()) {
            int readUnsignedByte = dataInput.readUnsignedByte();
            int i = 1131;
            if (readUnsignedByte == 10 && z2) {
                List<Object> list = this.sequence;
                Integer num = (Integer) list.remove(list.size() - 1);
                int count = indexData2.getCount();
                if (count < 1240) {
                    i = 107;
                } else if (count >= 33900) {
                    i = 32768;
                }
                int intValue = num.intValue() + i;
                if (intValue < indexData2.getCount()) {
                    parse(indexData2.getBytes(intValue), indexData, indexData2, false);
                    Object outline30 = GeneratedOutlineSupport.outline30(this.sequence, 1);
                    if ((outline30 instanceof CharStringCommand) && ((CharStringCommand) outline30).getKey().getValue()[0] == 11) {
                        List<Object> list2 = this.sequence;
                        list2.remove(list2.size() - 1);
                    }
                }
            } else if (readUnsignedByte == 29 && z3) {
                List<Object> list3 = this.sequence;
                Integer num2 = (Integer) list3.remove(list3.size() - 1);
                int count2 = indexData.getCount();
                if (count2 < 1240) {
                    i = 107;
                } else if (count2 >= 33900) {
                    i = 32768;
                }
                int intValue2 = num2.intValue() + i;
                if (intValue2 < indexData.getCount()) {
                    parse(indexData.getBytes(intValue2), indexData, indexData2, false);
                    Object outline302 = GeneratedOutlineSupport.outline30(this.sequence, 1);
                    if ((outline302 instanceof CharStringCommand) && ((CharStringCommand) outline302).getKey().getValue()[0] == 11) {
                        List<Object> list4 = this.sequence;
                        list4.remove(list4.size() - 1);
                    }
                }
            } else if (readUnsignedByte >= 0 && readUnsignedByte <= 27) {
                this.sequence.add(readCommand(readUnsignedByte, dataInput));
            } else if (readUnsignedByte == 28) {
                this.sequence.add(readNumber(readUnsignedByte, dataInput));
            } else if (readUnsignedByte >= 29 && readUnsignedByte <= 31) {
                this.sequence.add(readCommand(readUnsignedByte, dataInput));
            } else if (readUnsignedByte < 32 || readUnsignedByte > 255) {
                throw new IllegalArgumentException();
            } else {
                this.sequence.add(readNumber(readUnsignedByte, dataInput));
            }
        }
        return this.sequence;
    }

    public Type2CharStringParser(String str, int i) {
        this.fontName = str;
        this.glyphName = String.format("%04x", new Object[]{Integer.valueOf(i)});
    }
}
