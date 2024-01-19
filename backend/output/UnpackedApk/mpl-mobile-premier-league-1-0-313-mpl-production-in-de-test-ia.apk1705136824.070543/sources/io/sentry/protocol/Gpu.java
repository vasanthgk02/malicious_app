package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Gpu implements IUnknownPropertiesConsumer {
    public static final String TYPE = "gpu";
    public String apiType;
    public Integer id;
    public Integer memorySize;
    public Boolean multiThreadedRendering;
    public String name;
    public String npotSupport;
    public Map<String, Object> unknown;
    public Integer vendorId;
    public String vendorName;
    public String version;

    public Gpu() {
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public String getApiType() {
        return this.apiType;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getMemorySize() {
        return this.memorySize;
    }

    public String getName() {
        return this.name;
    }

    public String getNpotSupport() {
        return this.npotSupport;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public Integer getVendorId() {
        return this.vendorId;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public String getVersion() {
        return this.version;
    }

    public Boolean isMultiThreadedRendering() {
        return this.multiThreadedRendering;
    }

    public void setApiType(String str) {
        this.apiType = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setMemorySize(Integer num) {
        this.memorySize = num;
    }

    public void setMultiThreadedRendering(Boolean bool) {
        this.multiThreadedRendering = bool;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNpotSupport(String str) {
        this.npotSupport = str;
    }

    public void setVendorId(Integer num) {
        this.vendorId = num;
    }

    public void setVendorName(String str) {
        this.vendorName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public Gpu(Gpu gpu) {
        this.name = gpu.name;
        this.id = gpu.id;
        this.vendorId = gpu.vendorId;
        this.vendorName = gpu.vendorName;
        this.memorySize = gpu.memorySize;
        this.apiType = gpu.apiType;
        this.multiThreadedRendering = gpu.multiThreadedRendering;
        this.version = gpu.version;
        this.npotSupport = gpu.npotSupport;
        this.unknown = CollectionUtils.newConcurrentHashMap(gpu.unknown);
    }
}
