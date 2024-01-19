package com.google.firebase.encoders;

import java.io.IOException;

public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException;

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException;
}
