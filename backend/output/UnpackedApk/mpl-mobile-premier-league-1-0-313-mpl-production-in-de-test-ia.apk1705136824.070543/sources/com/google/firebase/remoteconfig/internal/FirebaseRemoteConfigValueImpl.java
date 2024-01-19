package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {
    public final int source;
    public final String value;

    public FirebaseRemoteConfigValueImpl(String str, int i) {
        this.value = str;
        this.source = i;
    }

    public boolean asBoolean() throws IllegalArgumentException {
        if (this.source == 0) {
            return false;
        }
        String asTrimmedString = asTrimmedString();
        if (ConfigGetParameterHandler.TRUE_REGEX.matcher(asTrimmedString).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.FALSE_REGEX.matcher(asTrimmedString).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{asTrimmedString, "boolean"}));
    }

    public double asDouble() {
        if (this.source == 0) {
            return 0.0d;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Double.valueOf(asTrimmedString).doubleValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{asTrimmedString, "double"}), e2);
        }
    }

    public long asLong() {
        if (this.source == 0) {
            return 0;
        }
        String asTrimmedString = asTrimmedString();
        try {
            return Long.valueOf(asTrimmedString).longValue();
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", new Object[]{asTrimmedString, "long"}), e2);
        }
    }

    public String asString() {
        if (this.source == 0) {
            return "";
        }
        String str = this.value;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    public final String asTrimmedString() {
        return asString().trim();
    }

    public int getSource() {
        return this.source;
    }
}
