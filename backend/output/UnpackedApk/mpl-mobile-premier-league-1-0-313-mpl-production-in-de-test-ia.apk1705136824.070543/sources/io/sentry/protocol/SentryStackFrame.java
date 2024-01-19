package io.sentry.protocol;

import com.google.gson.annotations.SerializedName;
import io.sentry.IUnknownPropertiesConsumer;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class SentryStackFrame implements IUnknownPropertiesConsumer {
    @SerializedName("native")
    public Boolean _native;
    @SerializedName("package")
    public String _package;
    public String absPath;
    public Integer colno;
    public String contextLine;
    public String filename;
    public List<Integer> framesOmitted;
    public String function;
    public String imageAddr;
    public Boolean inApp;
    public String instructionAddr;
    public Integer lineno;
    public String module;
    public String platform;
    public List<String> postContext;
    public List<String> preContext;
    public String rawFunction;
    public String symbolAddr;
    public Map<String, Object> unknown;
    public Map<String, String> vars;

    @Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public String getAbsPath() {
        return this.absPath;
    }

    public Integer getColno() {
        return this.colno;
    }

    public String getContextLine() {
        return this.contextLine;
    }

    public String getFilename() {
        return this.filename;
    }

    public List<Integer> getFramesOmitted() {
        return this.framesOmitted;
    }

    public String getFunction() {
        return this.function;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public String getInstructionAddr() {
        return this.instructionAddr;
    }

    public Integer getLineno() {
        return this.lineno;
    }

    public String getModule() {
        return this.module;
    }

    public String getPackage() {
        return this._package;
    }

    public String getPlatform() {
        return this.platform;
    }

    public List<String> getPostContext() {
        return this.postContext;
    }

    public List<String> getPreContext() {
        return this.preContext;
    }

    public String getRawFunction() {
        return this.rawFunction;
    }

    public String getSymbolAddr() {
        return this.symbolAddr;
    }

    public Map<String, String> getVars() {
        return this.vars;
    }

    public Boolean isInApp() {
        return this.inApp;
    }

    public Boolean isNative() {
        return this._native;
    }

    public void setAbsPath(String str) {
        this.absPath = str;
    }

    public void setColno(Integer num) {
        this.colno = num;
    }

    public void setContextLine(String str) {
        this.contextLine = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setFramesOmitted(List<Integer> list) {
        this.framesOmitted = list;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public void setInApp(Boolean bool) {
        this.inApp = bool;
    }

    public void setInstructionAddr(String str) {
        this.instructionAddr = str;
    }

    public void setLineno(Integer num) {
        this.lineno = num;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setNative(Boolean bool) {
        this._native = bool;
    }

    public void setPackage(String str) {
        this._package = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setPostContext(List<String> list) {
        this.postContext = list;
    }

    public void setPreContext(List<String> list) {
        this.preContext = list;
    }

    public void setRawFunction(String str) {
        this.rawFunction = str;
    }

    public void setSymbolAddr(String str) {
        this.symbolAddr = str;
    }

    public void setVars(Map<String, String> map) {
        this.vars = map;
    }
}
