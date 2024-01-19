package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import io.sentry.util.CollectionUtils;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Device implements IUnknownPropertiesConsumer {
    public static final String TYPE = "device";
    public String[] archs;
    public Float batteryLevel;
    public Float batteryTemperature;
    public Date bootTime;
    public String brand;
    public Boolean charging;
    public String connectionType;
    public Long externalFreeStorage;
    public Long externalStorageSize;
    public String family;
    public Long freeMemory;
    public Long freeStorage;
    public String id;
    public String language;
    public Boolean lowMemory;
    public String manufacturer;
    public Long memorySize;
    public String model;
    public String modelId;
    public String name;
    public Boolean online;
    public DeviceOrientation orientation;
    public Float screenDensity;
    public Integer screenDpi;
    public Integer screenHeightPixels;
    public Integer screenWidthPixels;
    public Boolean simulator;
    public Long storageSize;
    public TimeZone timezone;
    public Map<String, Object> unknown;
    public Long usableMemory;

    public enum DeviceOrientation {
        PORTRAIT,
        LANDSCAPE
    }

    public Device() {
    }

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = new ConcurrentHashMap(map);
    }

    public String[] getArchs() {
        return this.archs;
    }

    public Float getBatteryLevel() {
        return this.batteryLevel;
    }

    public Float getBatteryTemperature() {
        return this.batteryTemperature;
    }

    public Date getBootTime() {
        Date date = this.bootTime;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public Long getExternalFreeStorage() {
        return this.externalFreeStorage;
    }

    public Long getExternalStorageSize() {
        return this.externalStorageSize;
    }

    public String getFamily() {
        return this.family;
    }

    public Long getFreeMemory() {
        return this.freeMemory;
    }

    public Long getFreeStorage() {
        return this.freeStorage;
    }

    public String getId() {
        return this.id;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public Long getMemorySize() {
        return this.memorySize;
    }

    public String getModel() {
        return this.model;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getName() {
        return this.name;
    }

    public DeviceOrientation getOrientation() {
        return this.orientation;
    }

    public Float getScreenDensity() {
        return this.screenDensity;
    }

    public Integer getScreenDpi() {
        return this.screenDpi;
    }

    public Integer getScreenHeightPixels() {
        return this.screenHeightPixels;
    }

    public Integer getScreenWidthPixels() {
        return this.screenWidthPixels;
    }

    public Long getStorageSize() {
        return this.storageSize;
    }

    public TimeZone getTimezone() {
        return this.timezone;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public Long getUsableMemory() {
        return this.usableMemory;
    }

    public Boolean isCharging() {
        return this.charging;
    }

    public Boolean isLowMemory() {
        return this.lowMemory;
    }

    public Boolean isOnline() {
        return this.online;
    }

    public Boolean isSimulator() {
        return this.simulator;
    }

    public void setArchs(String[] strArr) {
        this.archs = strArr;
    }

    public void setBatteryLevel(Float f2) {
        this.batteryLevel = f2;
    }

    public void setBatteryTemperature(Float f2) {
        this.batteryTemperature = f2;
    }

    public void setBootTime(Date date) {
        this.bootTime = date;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCharging(Boolean bool) {
        this.charging = bool;
    }

    public void setConnectionType(String str) {
        this.connectionType = str;
    }

    public void setExternalFreeStorage(Long l) {
        this.externalFreeStorage = l;
    }

    public void setExternalStorageSize(Long l) {
        this.externalStorageSize = l;
    }

    public void setFamily(String str) {
        this.family = str;
    }

    public void setFreeMemory(Long l) {
        this.freeMemory = l;
    }

    public void setFreeStorage(Long l) {
        this.freeStorage = l;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLowMemory(Boolean bool) {
        this.lowMemory = bool;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMemorySize(Long l) {
        this.memorySize = l;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnline(Boolean bool) {
        this.online = bool;
    }

    public void setOrientation(DeviceOrientation deviceOrientation) {
        this.orientation = deviceOrientation;
    }

    public void setScreenDensity(Float f2) {
        this.screenDensity = f2;
    }

    public void setScreenDpi(Integer num) {
        this.screenDpi = num;
    }

    public void setScreenHeightPixels(Integer num) {
        this.screenHeightPixels = num;
    }

    public void setScreenWidthPixels(Integer num) {
        this.screenWidthPixels = num;
    }

    public void setSimulator(Boolean bool) {
        this.simulator = bool;
    }

    public void setStorageSize(Long l) {
        this.storageSize = l;
    }

    public void setTimezone(TimeZone timeZone) {
        this.timezone = timeZone;
    }

    public void setUsableMemory(Long l) {
        this.usableMemory = l;
    }

    public Device(Device device) {
        this.name = device.name;
        this.manufacturer = device.manufacturer;
        this.brand = device.brand;
        this.family = device.family;
        this.model = device.model;
        this.modelId = device.modelId;
        this.charging = device.charging;
        this.online = device.online;
        this.orientation = device.orientation;
        this.simulator = device.simulator;
        this.memorySize = device.memorySize;
        this.freeMemory = device.freeMemory;
        this.usableMemory = device.usableMemory;
        this.lowMemory = device.lowMemory;
        this.storageSize = device.storageSize;
        this.freeStorage = device.freeStorage;
        this.externalStorageSize = device.externalStorageSize;
        this.externalFreeStorage = device.externalFreeStorage;
        this.screenWidthPixels = device.screenWidthPixels;
        this.screenHeightPixels = device.screenHeightPixels;
        this.screenDensity = device.screenDensity;
        this.screenDpi = device.screenDpi;
        this.bootTime = device.bootTime;
        this.id = device.id;
        this.language = device.language;
        this.connectionType = device.connectionType;
        this.batteryTemperature = device.batteryTemperature;
        this.batteryLevel = device.batteryLevel;
        String[] strArr = device.archs;
        TimeZone timeZone = null;
        this.archs = strArr != null ? (String[]) strArr.clone() : null;
        TimeZone timeZone2 = device.timezone;
        this.timezone = timeZone2 != null ? (TimeZone) timeZone2.clone() : timeZone;
        this.unknown = CollectionUtils.newConcurrentHashMap(device.unknown);
    }
}
