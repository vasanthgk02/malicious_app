package org.apache.pdfbox.filter.ccitt;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;

public final class CCITTFaxG31DDecodeInputStream extends InputStream {
    public static final int[] BIT_POS_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    public static final NonLeafLookupTreeNode BLACK_LOOKUP_TREE_ROOT = new NonLeafLookupTreeNode();
    public static final int CODE_WORD = 0;
    public static final short EOL_STARTER = 2816;
    public static final int SIGNAL_EOD = -1;
    public static final int SIGNAL_EOL = -2;
    public static final NonLeafLookupTreeNode WHITE_LOOKUP_TREE_ROOT = new NonLeafLookupTreeNode();
    public int accumulatedRunLength;
    public int bitPos;
    public int bits;
    public int columns;
    public PackedBitArray decodedLine;
    public int decodedReadPos;
    public int decodedWritePos;
    public boolean encodedByteAlign;
    public int rows;
    public InputStream source;
    public int y;

    public interface CodeWord {
        int execute(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException;

        int getType();
    }

    public static class EndOfLineTreeNode extends LookupTreeNode implements CodeWord {
        public EndOfLineTreeNode() {
            super();
        }

        public int execute(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException {
            return 0;
        }

        public CodeWord getNextCodeWord(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException {
            int access$300;
            do {
                access$300 = cCITTFaxG31DDecodeInputStream.readBit();
            } while (access$300 == 0);
            if (access$300 < 0) {
                return null;
            }
            return this;
        }

        public int getType() {
            return -2;
        }

        public String toString() {
            return "EOL";
        }
    }

    public static abstract class LookupTreeNode {
        public LookupTreeNode() {
        }

        public abstract CodeWord getNextCodeWord(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException;
    }

    public static class MakeUpTreeNode extends LookupTreeNode implements CodeWord {
        public final int length;

        public MakeUpTreeNode(int i) {
            super();
            this.length = i;
        }

        public int execute(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException {
            cCITTFaxG31DDecodeInputStream.writeNonTerminating(this.length);
            return this.length;
        }

        public CodeWord getNextCodeWord(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException {
            return this;
        }

        public int getType() {
            return 0;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Make up code for length ");
            outline73.append(this.length);
            return outline73.toString();
        }
    }

    public static class NonLeafLookupTreeNode extends LookupTreeNode {
        public LookupTreeNode one;
        public LookupTreeNode zero;

        public NonLeafLookupTreeNode() {
            super();
        }

        public LookupTreeNode get(int i) {
            return i == 0 ? this.zero : this.one;
        }

        public CodeWord getNextCodeWord(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException {
            int access$300 = cCITTFaxG31DDecodeInputStream.readBit();
            if (access$300 < 0) {
                return null;
            }
            LookupTreeNode lookupTreeNode = get(access$300);
            if (lookupTreeNode != null) {
                return lookupTreeNode.getNextCodeWord(cCITTFaxG31DDecodeInputStream);
            }
            throw new IOException("Invalid code word encountered");
        }

        public void set(int i, LookupTreeNode lookupTreeNode) {
            if (i == 0) {
                this.zero = lookupTreeNode;
            } else {
                this.one = lookupTreeNode;
            }
        }
    }

    public static class RunLengthTreeNode extends LookupTreeNode implements CodeWord {
        public final int bit;
        public final int length;

        public RunLengthTreeNode(int i, int i2) {
            super();
            this.bit = i;
            this.length = i2;
        }

        public int execute(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) {
            cCITTFaxG31DDecodeInputStream.writeRun(this.bit, this.length);
            return this.length;
        }

        public CodeWord getNextCodeWord(CCITTFaxG31DDecodeInputStream cCITTFaxG31DDecodeInputStream) throws IOException {
            return this;
        }

        public int getType() {
            return 0;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Run Length for ");
            outline73.append(this.length);
            outline73.append(" bits of ");
            outline73.append(this.bit == 0 ? "white" : "black");
            return outline73.toString();
        }
    }

    static {
        buildLookupTree();
    }

    public CCITTFaxG31DDecodeInputStream(InputStream inputStream, int i, int i2, boolean z) {
        this.bitPos = 8;
        this.y = -1;
        this.source = inputStream;
        this.columns = i;
        this.rows = i2;
        PackedBitArray packedBitArray = new PackedBitArray(i);
        this.decodedLine = packedBitArray;
        this.decodedReadPos = packedBitArray.getByteCount();
        this.encodedByteAlign = z;
    }

    public static void addLookupTreeNode(short s, NonLeafLookupTreeNode nonLeafLookupTreeNode, LookupTreeNode lookupTreeNode) {
        int i = s >> 8;
        short s2 = s & 255;
        while (true) {
            i--;
            if (i > 0) {
                int i2 = (s2 >> i) & 1;
                LookupTreeNode lookupTreeNode2 = nonLeafLookupTreeNode.get(i2);
                if (lookupTreeNode2 == null) {
                    lookupTreeNode2 = new NonLeafLookupTreeNode();
                    nonLeafLookupTreeNode.set(i2, lookupTreeNode2);
                }
                if (lookupTreeNode2 instanceof NonLeafLookupTreeNode) {
                    nonLeafLookupTreeNode = (NonLeafLookupTreeNode) lookupTreeNode2;
                } else {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("NonLeafLookupTreeNode expected, was ");
                    outline73.append(lookupTreeNode2.getClass().getName());
                    throw new IllegalStateException(outline73.toString());
                }
            } else {
                short s3 = s2 & 1;
                if (nonLeafLookupTreeNode.get(s3) == null) {
                    nonLeafLookupTreeNode.set(s3, lookupTreeNode);
                    return;
                }
                throw new IllegalStateException("Two codes conflicting in lookup tree");
            }
        }
    }

    public static void buildLookupTree() {
        buildUpTerminating(CCITTFaxConstants.WHITE_TERMINATING, WHITE_LOOKUP_TREE_ROOT, true);
        buildUpTerminating(CCITTFaxConstants.BLACK_TERMINATING, BLACK_LOOKUP_TREE_ROOT, false);
        buildUpMakeUp(CCITTFaxConstants.WHITE_MAKE_UP, WHITE_LOOKUP_TREE_ROOT);
        buildUpMakeUp(CCITTFaxConstants.BLACK_MAKE_UP, BLACK_LOOKUP_TREE_ROOT);
        buildUpMakeUpLong(CCITTFaxConstants.LONG_MAKE_UP, WHITE_LOOKUP_TREE_ROOT);
        buildUpMakeUpLong(CCITTFaxConstants.LONG_MAKE_UP, BLACK_LOOKUP_TREE_ROOT);
        EndOfLineTreeNode endOfLineTreeNode = new EndOfLineTreeNode();
        addLookupTreeNode(EOL_STARTER, WHITE_LOOKUP_TREE_ROOT, endOfLineTreeNode);
        addLookupTreeNode(EOL_STARTER, BLACK_LOOKUP_TREE_ROOT, endOfLineTreeNode);
    }

    public static void buildUpMakeUp(short[] sArr, NonLeafLookupTreeNode nonLeafLookupTreeNode) {
        int length = sArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            addLookupTreeNode(sArr[i], nonLeafLookupTreeNode, new MakeUpTreeNode(i2 * 64));
            i = i2;
        }
    }

    public static void buildUpMakeUpLong(short[] sArr, NonLeafLookupTreeNode nonLeafLookupTreeNode) {
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            addLookupTreeNode(sArr[i], nonLeafLookupTreeNode, new MakeUpTreeNode((i + 28) * 64));
        }
    }

    public static void buildUpTerminating(short[] sArr, NonLeafLookupTreeNode nonLeafLookupTreeNode, boolean z) {
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            addLookupTreeNode(sArr[i], nonLeafLookupTreeNode, new RunLengthTreeNode(z ^ true ? 1 : 0, i));
        }
    }

    private boolean decodeLine() throws IOException {
        if (this.encodedByteAlign && this.bitPos != 0) {
            readByte();
        }
        if (this.bits < 0) {
            return false;
        }
        int i = this.y + 1;
        this.y = i;
        int i2 = this.rows;
        if (i2 > 0 && i >= i2) {
            return false;
        }
        this.decodedLine.clear();
        this.decodedWritePos = 0;
        int i3 = 6;
        int i4 = 0;
        boolean z = true;
        while (true) {
            if (i4 < this.columns || this.accumulatedRunLength > 0) {
                CodeWord nextCodeWord = (z ? WHITE_LOOKUP_TREE_ROOT : BLACK_LOOKUP_TREE_ROOT).getNextCodeWord(this);
                if (nextCodeWord == null) {
                    if (i4 <= 0) {
                        return false;
                    }
                    this.decodedReadPos = 0;
                    return true;
                } else if (nextCodeWord.getType() == -2) {
                    i3--;
                    if (i3 == 0) {
                        return false;
                    }
                } else {
                    int execute = nextCodeWord.execute(this) + i4;
                    if (this.accumulatedRunLength == 0) {
                        z = !z;
                    }
                    i4 = execute;
                    i3 = -1;
                }
            } else {
                this.decodedReadPos = 0;
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public int readBit() throws IOException {
        if (this.bitPos >= 8) {
            readByte();
            if (this.bits < 0) {
                return -1;
            }
        }
        int i = this.bits;
        int[] iArr = BIT_POS_MASKS;
        int i2 = this.bitPos;
        this.bitPos = i2 + 1;
        return (i & iArr[i2]) == 0 ? 0 : 1;
    }

    private void readByte() throws IOException {
        this.bits = this.source.read();
        this.bitPos = 0;
    }

    /* access modifiers changed from: private */
    public void writeNonTerminating(int i) {
        this.accumulatedRunLength += i;
    }

    /* access modifiers changed from: private */
    public void writeRun(int i, int i2) {
        int i3 = this.accumulatedRunLength + i2;
        this.accumulatedRunLength = i3;
        if (i != 0) {
            this.decodedLine.setBits(this.decodedWritePos, i3);
        }
        this.decodedWritePos += this.accumulatedRunLength;
        this.accumulatedRunLength = 0;
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if (this.decodedReadPos >= this.decodedLine.getByteCount() && !decodeLine()) {
            return -1;
        }
        byte[] data = this.decodedLine.getData();
        int i = this.decodedReadPos;
        this.decodedReadPos = i + 1;
        return data[i] & 255;
    }

    public CCITTFaxG31DDecodeInputStream(InputStream inputStream, int i, boolean z) {
        this(inputStream, i, 0, z);
    }
}
