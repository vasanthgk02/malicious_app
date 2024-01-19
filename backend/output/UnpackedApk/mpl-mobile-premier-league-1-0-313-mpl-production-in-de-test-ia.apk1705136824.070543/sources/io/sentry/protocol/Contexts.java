package io.sentry.protocol;

import io.sentry.SpanContext;
import io.sentry.util.Objects;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public final class Contexts extends ConcurrentHashMap<String, Object> {
    public static final long serialVersionUID = 252445813254943011L;

    public Contexts() {
    }

    private <T> T toContextType(String str, Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public App getApp() {
        return (App) toContextType("app", App.class);
    }

    public Browser getBrowser() {
        return (Browser) toContextType(Browser.TYPE, Browser.class);
    }

    public Device getDevice() {
        return (Device) toContextType("device", Device.class);
    }

    public Gpu getGpu() {
        return (Gpu) toContextType(Gpu.TYPE, Gpu.class);
    }

    public OperatingSystem getOperatingSystem() {
        return (OperatingSystem) toContextType("os", OperatingSystem.class);
    }

    public SentryRuntime getRuntime() {
        return (SentryRuntime) toContextType(SentryRuntime.TYPE, SentryRuntime.class);
    }

    public SpanContext getTrace() {
        return (SpanContext) toContextType("trace", SpanContext.class);
    }

    public void setApp(App app) {
        put("app", app);
    }

    public void setBrowser(Browser browser) {
        put(Browser.TYPE, browser);
    }

    public void setDevice(Device device) {
        put("device", device);
    }

    public void setGpu(Gpu gpu) {
        put(Gpu.TYPE, gpu);
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        put("os", operatingSystem);
    }

    public void setRuntime(SentryRuntime sentryRuntime) {
        put(SentryRuntime.TYPE, sentryRuntime);
    }

    public void setTrace(SpanContext spanContext) {
        Objects.requireNonNull(spanContext, "traceContext is required");
        put("trace", spanContext);
    }

    public Contexts(Contexts contexts) {
        for (Entry entry : contexts.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if ("app".equals(entry.getKey()) && (value instanceof App)) {
                    setApp(new App((App) value));
                } else if (Browser.TYPE.equals(entry.getKey()) && (value instanceof Browser)) {
                    setBrowser(new Browser((Browser) value));
                } else if ("device".equals(entry.getKey()) && (value instanceof Device)) {
                    setDevice(new Device((Device) value));
                } else if ("os".equals(entry.getKey()) && (value instanceof OperatingSystem)) {
                    setOperatingSystem(new OperatingSystem((OperatingSystem) value));
                } else if (SentryRuntime.TYPE.equals(entry.getKey()) && (value instanceof SentryRuntime)) {
                    setRuntime(new SentryRuntime((SentryRuntime) value));
                } else if (Gpu.TYPE.equals(entry.getKey()) && (value instanceof Gpu)) {
                    setGpu(new Gpu((Gpu) value));
                } else if (!"trace".equals(entry.getKey()) || !(value instanceof SpanContext)) {
                    put((String) entry.getKey(), value);
                } else {
                    setTrace(new SpanContext((SpanContext) value));
                }
            }
        }
    }
}
