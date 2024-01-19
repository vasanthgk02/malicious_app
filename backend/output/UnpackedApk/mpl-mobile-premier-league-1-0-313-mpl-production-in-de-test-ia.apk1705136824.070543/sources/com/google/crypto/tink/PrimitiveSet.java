package com.google.crypto.tink;

import com.google.android.material.resources.TextAppearanceConfig;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class PrimitiveSet<P> {
    public Entry<P> primary;
    public final Class<P> primitiveClass;
    public final ConcurrentMap<Prefix, List<Entry<P>>> primitives = new ConcurrentHashMap();

    public static final class Entry<P> {
        public final byte[] identifier;
        public final OutputPrefixType outputPrefixType;
        public final P primitive;
        public final KeyStatusType status;

        public Entry(P p, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType2, int i) {
            this.primitive = p;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType2;
        }

        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }
    }

    public static class Prefix implements Comparable<Prefix> {
        public final byte[] prefix;

        public Prefix(byte[] bArr, AnonymousClass1 r2) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        public int compareTo(Object obj) {
            int i;
            int i2;
            Prefix prefix2 = (Prefix) obj;
            byte[] bArr = this.prefix;
            int length = bArr.length;
            byte[] bArr2 = prefix2.prefix;
            if (length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                int i3 = 0;
                while (true) {
                    byte[] bArr3 = this.prefix;
                    if (i3 >= bArr3.length) {
                        return 0;
                    }
                    byte b2 = bArr3[i3];
                    byte[] bArr4 = prefix2.prefix;
                    if (b2 != bArr4[i3]) {
                        i = bArr3[i3];
                        i2 = bArr4[i3];
                        break;
                    }
                    i3++;
                }
            }
            return i - i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Prefix)) {
                return false;
            }
            return Arrays.equals(this.prefix, ((Prefix) obj).prefix);
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public String toString() {
            return TextAppearanceConfig.encode(this.prefix);
        }
    }

    public PrimitiveSet(Class<P> cls) {
        this.primitiveClass = cls;
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = (List) this.primitives.get(new Prefix(bArr, null));
        return list != null ? list : Collections.emptyList();
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }
}
