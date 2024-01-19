package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SentryStackTrace implements IUnknownPropertiesConsumer {
    public List<SentryStackFrame> frames;
    public Map<String, String> registers;
    public Boolean snapshot;
    public Map<String, Object> unknown;

    public SentryStackTrace() {
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public List<SentryStackFrame> getFrames() {
        return this.frames;
    }

    public Map<String, String> getRegisters() {
        return this.registers;
    }

    public Boolean getSnapshot() {
        return this.snapshot;
    }

    public void setFrames(List<SentryStackFrame> list) {
        this.frames = list;
    }

    public void setRegisters(Map<String, String> map) {
        this.registers = map;
    }

    public void setSnapshot(Boolean bool) {
        this.snapshot = bool;
    }

    public SentryStackTrace(List<SentryStackFrame> list) {
        this.frames = list;
    }
}
