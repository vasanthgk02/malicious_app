package kotlin.reflect.jvm.internal.impl.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class BoundedByteString extends LiteralByteString {
    public final int bytesLength;
    public final int bytesOffset;

    public class BoundedByteIterator implements ByteIterator {
        public final int limit;
        public int position;

        public BoundedByteIterator(AnonymousClass1 r2) {
            int i = BoundedByteString.this.bytesOffset;
            this.position = i;
            this.limit = i + BoundedByteString.this.bytesLength;
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Object next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            int i = this.position;
            if (i < this.limit) {
                byte[] bArr = BoundedByteString.this.bytes;
                this.position = i + 1;
                return bArr[i];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline31(29, "Offset too small: ", i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline31(29, "Length too small: ", i));
        } else if (((long) i) + ((long) i2) <= ((long) bArr.length)) {
            this.bytesOffset = i;
            this.bytesLength = i2;
        } else {
            StringBuilder sb = new StringBuilder(48);
            sb.append("Offset+Length too large: ");
            sb.append(i);
            sb.append(MqttTopic.SINGLE_LEVEL_WILDCARD);
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, this.bytesOffset + i, bArr, i2, i3);
    }

    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    public int size() {
        return this.bytesLength;
    }

    public ByteIterator iterator() {
        return new BoundedByteIterator(null);
    }
}
