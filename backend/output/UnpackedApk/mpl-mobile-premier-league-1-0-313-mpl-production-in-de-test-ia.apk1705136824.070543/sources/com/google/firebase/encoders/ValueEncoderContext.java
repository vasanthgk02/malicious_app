package com.google.firebase.encoders;

import java.io.IOException;

public interface ValueEncoderContext {
    ValueEncoderContext add(String str) throws IOException;

    ValueEncoderContext add(boolean z) throws IOException;
}
