package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf.IntEncoding;
import java.lang.annotation.Annotation;

public final class AtProtobuf$ProtobufImpl implements Protobuf {
    public final IntEncoding intEncoding;
    public final int tag;

    public AtProtobuf$ProtobufImpl(int i, IntEncoding intEncoding2) {
        this.tag = i;
        this.intEncoding = intEncoding2;
    }

    public Class<? extends Annotation> annotationType() {
        return Protobuf.class;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Protobuf)) {
            return false;
        }
        Protobuf protobuf = (Protobuf) obj;
        if (this.tag != protobuf.tag() || !this.intEncoding.equals(protobuf.intEncoding())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.tag ^ 14552422) + (this.intEncoding.hashCode() ^ 2041407134);
    }

    public IntEncoding intEncoding() {
        return this.intEncoding;
    }

    public int tag() {
        return this.tag;
    }

    public String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.tag + "intEncoding=" + this.intEncoding + ')';
    }
}
